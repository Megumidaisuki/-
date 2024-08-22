package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 question
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public class Question extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 问题 */
    private Long questionId;

    /** 问卷 */
    @Excel(name = "问卷")
    private Long questionnaireId;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isDeleted;

    /** 顺序 */
    @Excel(name = "顺序")
    private Long order;

    public void setQuestionId(Long questionId) 
    {
        this.questionId = questionId;
    }

    public Long getQuestionId() 
    {
        return questionId;
    }
    public void setQuestionnaireId(Long questionnaireId) 
    {
        this.questionnaireId = questionnaireId;
    }

    public Long getQuestionnaireId() 
    {
        return questionnaireId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }
    public void setOrder(Long order) 
    {
        this.order = order;
    }

    public Long getOrder() 
    {
        return order;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("questionId", getQuestionId())
            .append("questionnaireId", getQuestionnaireId())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("isDeleted", getIsDeleted())
            .append("order", getOrder())
            .toString();
    }
}
