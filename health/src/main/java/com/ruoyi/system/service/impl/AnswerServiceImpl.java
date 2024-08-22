package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AnswerMapper;
import com.ruoyi.system.domain.Answer;
import com.ruoyi.system.service.IAnswerService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
@Service
public class AnswerServiceImpl implements IAnswerService 
{
    @Autowired
    private AnswerMapper answerMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param answerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Answer selectAnswerByAnswerId(Long answerId)
    {
        return answerMapper.selectAnswerByAnswerId(answerId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param answer 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Answer> selectAnswerList(Answer answer)
    {
        return answerMapper.selectAnswerList(answer);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param answer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAnswer(Answer answer)
    {
        answer.setCreateTime(DateUtils.getNowDate());
        return answerMapper.insertAnswer(answer);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param answer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAnswer(Answer answer)
    {
        return answerMapper.updateAnswer(answer);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param answerIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAnswerByAnswerIds(Long[] answerIds)
    {
        return answerMapper.deleteAnswerByAnswerIds(answerIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param answerId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAnswerByAnswerId(Long answerId)
    {
        return answerMapper.deleteAnswerByAnswerId(answerId);
    }
}
