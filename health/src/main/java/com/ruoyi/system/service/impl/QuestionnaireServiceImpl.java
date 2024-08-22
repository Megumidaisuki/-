package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.QuestionnaireMapper;
import com.ruoyi.system.domain.Questionnaire;
import com.ruoyi.system.service.IQuestionnaireService;

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
}
