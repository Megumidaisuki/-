package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 answer_detail
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public class AnswerDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 问题id */
    private Long questionId;

    /** 选择题id */
    @Excel(name = "选择题id")
    private Long answerId;

    /** 简答题内容 */
    @Excel(name = "简答题内容")
    private String answerContent;

    /** 记录 */
    @Excel(name = "记录")
    private Long recordId;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isDeleted;

    public void setQuestionId(Long questionId) 
    {
        this.questionId = questionId;
    }

    public Long getQuestionId() 
    {
        return questionId;
    }
    public void setAnswerId(Long answerId) 
    {
        this.answerId = answerId;
    }

    public Long getAnswerId() 
    {
        return answerId;
    }
    public void setAnswerContent(String answerContent) 
    {
        this.answerContent = answerContent;
    }

    public String getAnswerContent() 
    {
        return answerContent;
    }
    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("questionId", getQuestionId())
            .append("answerId", getAnswerId())
            .append("answerContent", getAnswerContent())
            .append("recordId", getRecordId())
            .append("createTime", getCreateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
