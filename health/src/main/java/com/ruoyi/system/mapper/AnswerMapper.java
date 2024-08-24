package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Answer;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-08-22
 */
@Mapper
public interface AnswerMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param answerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Answer selectAnswerByAnswerId(Long answerId);


    /**
     * 查询【请填写功能名称】列表
     *
     * @param answer 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Answer> selectAnswerList(Answer answer);

    /**
     * 新增【请填写功能名称】
     *
     * @param answer 【请填写功能名称】
     * @return 结果
     */
    public int insertAnswer(Answer answer);

    /**
     * 修改【请填写功能名称】
     *
     * @param answer 【请填写功能名称】
     * @return 结果
     */
    public int updateAnswer(Answer answer);

    /**
     * 删除【请填写功能名称】
     *
     * @param answerId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAnswerByAnswerId(Long answerId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param answerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAnswerByAnswerIds(Long[] answerIds);
}
