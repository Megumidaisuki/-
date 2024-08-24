package com.ruoyi.system.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.service.IQuestionnaireService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-22
 */
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService
{
    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private AnswerDetailMapper answerDetailMapper;
    /**
     * 查询【请填写功能名称】
     *
     * @param questionnaireId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Questionnaire selectQuestionnaireByQuestionnaireId(Long questionnaireId)
    {
        return questionnaireMapper.selectQuestionnaireByQuestionnaireId(questionnaireId);
    }
    /**
     * 查询【请填写功能名称】列表
     *
     * @param questionnaire 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Questionnaire> selectQuestionnaireList(Questionnaire questionnaire)
    {
        return questionnaireMapper.selectQuestionnaireList(questionnaire);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param questionnaire 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertQuestionnaire(Questionnaire questionnaire)
    {
        questionnaire.setCreateTime(DateUtils.getNowDate());
        return questionnaireMapper.insertQuestionnaire(questionnaire);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param questionnaire 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateQuestionnaire(Questionnaire questionnaire)
    {
        return questionnaireMapper.updateQuestionnaire(questionnaire);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param questionnaireIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteQuestionnaireByQuestionnaireIds(Long[] questionnaireIds)
    {
        return questionnaireMapper.deleteQuestionnaireByQuestionnaireIds(questionnaireIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param questionnaireId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteQuestionnaireByQuestionnaireId(Long questionnaireId)
    {
        return questionnaireMapper.deleteQuestionnaireByQuestionnaireId(questionnaireId);
    }

    @Override
    public List<Questionnaire> selectQuestionnaireMessage(Questionnaire questionnaire) {
        List<Questionnaire> questionnaires = questionnaireMapper.selectFrontQuestionnaireList(questionnaire);
        //一级一级往下查
        for (Questionnaire questionnaire1 : questionnaires) {
            Question question = new Question();
            question.setQuestionnaireId(questionnaire1.getQuestionnaireId());
            List<Question> questions = questionMapper.selectQuestionList(question);
            questions.sort(Comparator.comparing(Question::getOrder));
            questionnaire1.setQuestionList(questions);

            for (Question question1 : questions) {
                Answer answer = new Answer();
                answer.setQuestionId(question1.getQuestionId());
                List<Answer> answers = answerMapper.selectAnswerList(answer);
                question1.setAnswerList(answers);
            }
        }
        return questionnaires;

    }

    @Override
    public List<Questionnaire> selectUserQuestionnaire() {
        Long userId = SecurityUtils.getUserId();
        Record record = new Record();
        record.setUserId(userId);
        List<Record> records = recordMapper.selectRecordList(record);
        List<Long> collect = records.stream().map(Record::getRecordId).collect(Collectors.toList());
        List<List<Long>> collect1 = collect.stream().map(answerDetailMapper::selectQuestionIdByRecordId).collect(Collectors.toList());
        Set<Long> set = new HashSet<>();
        for (List<Long> list : collect1) {
            set.addAll(list);
        }
        //此时set代表所有questionId
        //通过questionId去question表里面把questionnaire_id查出来
        Set<Object> collect2 = set.stream().map(a -> {
            return questionMapper.selectQuestionByQuestionId(a).getQuestionnaireId();
        }).collect(Collectors.toSet());
        //拿着questionnaireId去questionnaire表里面查
        List<Questionnaire> questionnaires = questionnaireMapper.selectFrontQuestionnaireList(new Questionnaire());
        for (Questionnaire questionnaire1 : questionnaires) {
            if (collect2.contains(questionnaire1.getQuestionnaireId())) {
                questionnaires.remove(questionnaire1);
            }
        }
        //至此，筛完毕
        //一级一级往下查
        for (Questionnaire questionnaire1 : questionnaires) {
            Question question = new Question();
            question.setQuestionnaireId(questionnaire1.getQuestionnaireId());
            List<Question> questions = questionMapper.selectQuestionList(question);
            questions.sort(Comparator.comparing(Question::getOrder));
            questionnaire1.setQuestionList(questions);

            for (Question question1 : questions) {
                Answer answer = new Answer();
                answer.setQuestionId(question1.getQuestionId());
                List<Answer> answers = answerMapper.selectAnswerList(answer);
                question1.setAnswerList(answers);
            }
        }
        return questionnaires;

    }

    /**
     * 提交问卷
     * @param questionnaire
     */
    @Transactional
    @Override
    public void submitQuestionnaire(Questionnaire questionnaire, String text) {
        Record record = new Record();
        record.setUserId(SecurityUtils.getUserId());

        recordMapper.insertRecordReturnId(record);
        //新增得主键id
        Long recordId = record.getRecordId();
        List<Question> questions = questionnaire.getQuestionList();
        for (Question question1 : questions) {
            List<Answer> answers = question1.getAnswerList();
            //存在简答题
            if( text != null && question1.getStatus() == 2){
                AnswerDetail answerDetail = new AnswerDetail();
                answerDetail.setRecordId(recordId);
                answerDetail.setQuestionId(question1.getQuestionId());
                answerDetail.setAnswerContent(text);
                answerDetailMapper.insertAnswerDetail(answerDetail);
            }else {
                //有选项的选择题
                for (Answer answer1 : answers) {
                    AnswerDetail answerDetail = new AnswerDetail();
                    answerDetail.setAnswerId(answer1.getAnswerId());
                    answerDetail.setQuestionId(question1.getQuestionId());
                    answerDetail.setRecordId(recordId);
                    answerDetailMapper.insertAnswerDetail(answerDetail);
                }
            }
        }
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addQuestionnaire(Questionnaire questionnaire) {
        //要把所有的问题和答案插入表中
        //先把问卷插入问卷表
        questionnaireMapper.insertQuestionnaireBack(questionnaire);
        Long questionnaireId = questionnaire.getQuestionnaireId();
        List<Question> questionList = questionnaire.getQuestionList();
        List<Answer> answerList = new ArrayList<>();
        for (Question question : questionList) {
            question.setQuestionnaireId(questionnaireId);
            for (Answer answer : question.getAnswerList()) {
                answer.setQuestionId(question.getQuestionId());
                answerList.add(answer);
            }
        }
        //把question和answer分别入库
        for (Question question : questionList) {
            questionMapper.insertQuestion(question);
        }
        for (Answer answer : answerList) {
            answerMapper.insertAnswer(answer);
        }
        return 1;
    }
    @Transactional
    @Override
    public int deleteQuestionnaire(Long questionnaireId) {
        //删除这个需要删除好多东西
        //首先删除questionnaire
        questionnaireMapper.deleteQuestionnaireByQuestionnaireId(questionnaireId);
        //其次删除question
        Question question = new Question();
        question.setQuestionnaireId(questionnaireId);
        List<Question> questionList = questionMapper.selectQuestionList(question);
        for (Question question1 : questionList) {
            //删除answer_detail
            answerDetailMapper.deleteAnswerDetailByQuestionId(question1.getQuestionId());
            AnswerDetail answerDetail = answerDetailMapper.selectAnswerDetailByQuestionId(question1.getQuestionId());
            if(answerDetail != null){
                Long recordId = answerDetail.getRecordId();
                //删除record
                recordMapper.deleteRecordByRecordId(recordId);
            }
            questionMapper.deleteQuestionByQuestionId(question1.getQuestionId());
            //最后删除answer
            Answer answer = new Answer();
            answer.setQuestionId(question1.getQuestionId());
            List<Answer> answerList = answerMapper.selectAnswerList(answer);
            for (Answer answer1 : answerList) {
                answerMapper.deleteAnswerByAnswerId(answer1.getAnswerId());
            }
        }
        return 1;
    }


}
