package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AnswerDetailMapper;
import com.ruoyi.system.domain.AnswerDetail;
import com.ruoyi.system.service.IAnswerDetailService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
@Service
public class AnswerDetailServiceImpl implements IAnswerDetailService 
{
    @Autowired
    private AnswerDetailMapper answerDetailMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param questionId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public AnswerDetail selectAnswerDetailByQuestionId(Long questionId)
    {
        return answerDetailMapper.selectAnswerDetailByQuestionId(questionId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param answerDetail 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AnswerDetail> selectAnswerDetailList(AnswerDetail answerDetail)
    {
        return answerDetailMapper.selectAnswerDetailList(answerDetail);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param answerDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAnswerDetail(AnswerDetail answerDetail)
    {
        answerDetail.setCreateTime(DateUtils.getNowDate());
        return answerDetailMapper.insertAnswerDetail(answerDetail);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param answerDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAnswerDetail(AnswerDetail answerDetail)
    {
        return answerDetailMapper.updateAnswerDetail(answerDetail);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param questionIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAnswerDetailByQuestionIds(Long[] questionIds)
    {
        return answerDetailMapper.deleteAnswerDetailByQuestionIds(questionIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param questionId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAnswerDetailByQuestionId(Long questionId)
    {
        return answerDetailMapper.deleteAnswerDetailByQuestionId(questionId);
    }
}
