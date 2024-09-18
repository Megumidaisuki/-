package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StepMapper;
import com.ruoyi.system.domain.Step;
import com.ruoyi.system.service.IStepService;

/**
 * 步数Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-18
 */
@Service
public class StepServiceImpl implements IStepService 
{
    @Autowired
    private StepMapper stepMapper;

    /**
     * 查询步数
     * 
     * @param stepId 步数主键
     * @return 步数
     */
    @Override
    public Step selectStepByStepId(Long stepId)
    {
        return stepMapper.selectStepByStepId(stepId);
    }

    /**
     * 查询步数列表
     * 
     * @param step 步数
     * @return 步数
     */
    @Override
    public List<Step> selectStepList(Step step)
    {
        return stepMapper.selectStepList(step);
    }

    /**
     * 新增步数
     * 
     * @param step 步数
     * @return 结果
     */
    @Override
    public int insertStep(Step step)
    {
        return stepMapper.insertStep(step);
    }

    /**
     * 修改步数
     * 
     * @param step 步数
     * @return 结果
     */
    @Override
    public int updateStep(Step step)
    {
        return stepMapper.updateStep(step);
    }

    /**
     * 批量删除步数
     * 
     * @param stepIds 需要删除的步数主键
     * @return 结果
     */
    @Override
    public int deleteStepByStepIds(Long[] stepIds)
    {
        return stepMapper.deleteStepByStepIds(stepIds);
    }

    /**
     * 删除步数信息
     * 
     * @param stepId 步数主键
     * @return 结果
     */
    @Override
    public int deleteStepByStepId(Long stepId)
    {
        return stepMapper.deleteStepByStepId(stepId);
    }
}
