package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Questionnaire;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public interface QuestionnaireMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param questionnaireId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteQuestionnaireByQuestionnaireId(Long questionnaireId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param questionnaireIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQuestionnaireByQuestionnaireIds(Long[] questionnaireIds);
}
