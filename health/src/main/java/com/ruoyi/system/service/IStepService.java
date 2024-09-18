package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Step;

/**
 * 步数Service接口
 * 
 * @author ruoyi
 * @date 2024-09-18
 */
public interface IStepService 
{
    /**
     * 查询步数
     * 
     * @param stepId 步数主键
     * @return 步数
     */
    public Step selectStepByStepId(Long stepId);

    /**
     * 查询步数列表
     * 
     * @param step 步数
     * @return 步数集合
     */
    public List<Step> selectStepList(Step step);

    /**
     * 新增步数
     * 
     * @param step 步数
     * @return 结果
     */
    public int insertStep(Step step);

    /**
     * 修改步数
     * 
     * @param step 步数
     * @return 结果
     */
    public int updateStep(Step step);

    /**
     * 批量删除步数
     * 
     * @param stepIds 需要删除的步数主键集合
     * @return 结果
     */
    public int deleteStepByStepIds(Long[] stepIds);

    /**
     * 删除步数信息
     * 
     * @param stepId 步数主键
     * @return 结果
     */
    public int deleteStepByStepId(Long stepId);
}
