package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.service.IRecordService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-22
 */
@Service
public class RecordServiceImpl implements IRecordService
{
    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerDetailMapper answerDetailMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param recordId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Record selectRecordByRecordId(Long recordId)
    {
        return recordMapper.selectRecordByRecordId(recordId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param record 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Record> selectRecordList(Record record)
    {
        return recordMapper.selectRecordList(record);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param record 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRecord(Record record)
    {
        record.setCreateTime(DateUtils.getNowDate());
        return recordMapper.insertRecord(record);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param record 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRecord(Record record)
    {
        return recordMapper.updateRecord(record);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param recordIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRecordByRecordIds(Long[] recordIds)
    {
        return recordMapper.deleteRecordByRecordIds(recordIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param recordId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRecordByRecordId(Long recordId)
    {
        return recordMapper.deleteRecordByRecordId(recordId);
    }

    @Transactional
    @Override
    public List<Questionnaire> selectQuestionMessage(Record record) {
        List<Record> records = recordMapper.selectRecordList(record);
        List<Questionnaire> questionnaires = new ArrayList<>();
        //对于每一个记录，即每一个问卷
        for(Record r:records){
            AnswerDetail answerDetail = new AnswerDetail();
            answerDetail.setRecordId(r.getRecordId());
            List<AnswerDetail> answerDetails = answerDetailMapper.selectAnswerDetailList(answerDetail);
            //封装成问卷信息返回
            Map<Long,List<Long>> map = new HashMap<>();
            for(AnswerDetail ad:answerDetails){
                List<Long> orDefault = map.getOrDefault(ad.getQuestionId(), new ArrayList<>());
                orDefault.add(ad.getAnswerId());
                map.put(ad.getQuestionId(),orDefault);
            }
            Questionnaire questionnaire = new Questionnaire();
            List<Answer> answerList = null;
            List<Question> questionList = null;
            //对于每一个question
            questionList = new ArrayList<>();
            for(Map.Entry<Long,List<Long>> entry:map.entrySet()){
                Question question1 = questionMapper.selectQuestionByQuestionId(entry.getKey());
                answerList = new ArrayList<>();
                for (Long aLong : entry.getValue()) {
                    //把answer加入到question中
                    answerList.add(answerMapper.selectAnswerByAnswerId(aLong));
                }
                question1.setAnswerList(answerList);
                //如果是简答题处理的逻辑
                if(question1.getStatus() == 2){
                    ArrayList<Answer> objects = new ArrayList<>();
                    Answer answer = new Answer();
                    AnswerDetail answerDetail1 = answerDetailMapper.selectAnswerDetailByQuestionId(question1.getQuestionId());
                    answer.setContent(answerDetail1.getAnswerContent());
                    objects.add(answer);
                    question1.setAnswerList(objects);
                }
                //把问题存进questionnaire
                questionList.add(question1);
                questionnaire = questionnaireMapper.selectQuestionnaireByQuestionnaireId(question1.getQuestionnaireId());
            }

            questionnaire.setQuestionList(questionList);
            questionnaires.add(questionnaire);
        }
        return questionnaires;
    }
}
