package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 健康检查对象 check
 * 
 * @author ruoyi
 * @date 2024-09-18
 */
public class Check extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long userId;

    /** 体检结果 */
    @Excel(name = "体检结果")
    private String checkPdf;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCheckPdf(String checkPdf) 
    {
        this.checkPdf = checkPdf;
    }

    public String getCheckPdf() 
    {
        return checkPdf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("checkPdf", getCheckPdf())
            .toString();
    }
}
