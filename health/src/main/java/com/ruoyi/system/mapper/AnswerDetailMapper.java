package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AnswerDetail;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public interface AnswerDetailMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param questionId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public AnswerDetail selectAnswerDetailByQuestionId(Long questionId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param answerDetail 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AnswerDetail> selectAnswerDetailList(AnswerDetail answerDetail);

    /**
     * 新增【请填写功能名称】
     * 
     * @param answerDetail 【请填写功能名称】
     * @return 结果
     */
    public int insertAnswerDetail(AnswerDetail answerDetail);

    /**
     * 修改【请填写功能名称】
     * 
     * @param answerDetail 【请填写功能名称】
     * @return 结果
     */
    public int updateAnswerDetail(AnswerDetail answerDetail);

    /**
     * 删除【请填写功能名称】
     * 
     * @param questionId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAnswerDetailByQuestionId(Long questionId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param questionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAnswerDetailByQuestionIds(Long[] questionIds);
}
