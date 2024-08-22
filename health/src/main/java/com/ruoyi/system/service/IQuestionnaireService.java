package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Questionnaire;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public interface IQuestionnaireService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param questionnaireId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Questionnaire selectQuestionnaireByQuestionnaireId(Long questionnaireId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param questionnaire 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Questionnaire> selectQuestionnaireList(Questionnaire questionnaire);

    /**
     * 新增【请填写功能名称】
     * 
     * @param questionnaire 【请填写功能名称】
     * @return 结果
     */
    public int insertQuestionnaire(Questionnaire questionnaire);

    /**
     * 修改【请填写功能名称】
     * 
     * @param questionnaire 【请填写功能名称】
     * @return 结果
     */
    public int updateQuestionnaire(Questionnaire questionnaire);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param questionnaireIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteQuestionnaireByQuestionnaireIds(Long[] questionnaireIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param questionnaireId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteQuestionnaireByQuestionnaireId(Long questionnaireId);
}
