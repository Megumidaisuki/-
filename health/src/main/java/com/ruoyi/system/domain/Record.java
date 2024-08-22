package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 record
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public class Record extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录id */
    private Long recordId;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isDeleted;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

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
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("createTime", getCreateTime())
            .append("isDeleted", getIsDeleted())
            .append("userId", getUserId())
            .toString();
    }
}
