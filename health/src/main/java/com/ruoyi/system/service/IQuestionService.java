package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Question;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public interface IQuestionService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param questionId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Question selectQuestionByQuestionId(Long questionId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param question 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Question> selectQuestionList(Question question);

    /**
     * 新增【请填写功能名称】
     * 
     * @param question 【请填写功能名称】
     * @return 结果
     */
    public int insertQuestion(Question question);

    /**
     * 修改【请填写功能名称】
     * 
     * @param question 【请填写功能名称】
     * @return 结果
     */
    public int updateQuestion(Question question);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param questionIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteQuestionByQuestionIds(Long[] questionIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param questionId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteQuestionByQuestionId(Long questionId);
}
