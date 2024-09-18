package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CheckMapper;
import com.ruoyi.system.domain.Check;
import com.ruoyi.system.service.ICheckService;

/**
 * 健康检查Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-18
 */
@Service
public class CheckServiceImpl implements ICheckService 
{
    @Autowired
    private CheckMapper checkMapper;

    /**
     * 查询健康检查
     * 
     * @param userId 健康检查主键
     * @return 健康检查
     */
    @Override
    public Check selectCheckByUserId(Long userId)
    {
        return checkMapper.selectCheckByUserId(userId);
    }

    /**
     * 查询健康检查列表
     * 
     * @param check 健康检查
     * @return 健康检查
     */
    @Override
    public List<Check> selectCheckList(Check check)
    {
        return checkMapper.selectCheckList(check);
    }

    /**
     * 新增健康检查
     * 
     * @param check 健康检查
     * @return 结果
     */
    @Override
    public int insertCheck(Check check)
    {
        return checkMapper.insertCheck(check);
    }

    /**
     * 修改健康检查
     * 
     * @param check 健康检查
     * @return 结果
     */
    @Override
    public int updateCheck(Check check)
    {
        return checkMapper.updateCheck(check);
    }

    /**
     * 批量删除健康检查
     * 
     * @param userIds 需要删除的健康检查主键
     * @return 结果
     */
    @Override
    public int deleteCheckByUserIds(Long[] userIds)
    {
        return checkMapper.deleteCheckByUserIds(userIds);
    }

    /**
     * 删除健康检查信息
     * 
     * @param userId 健康检查主键
     * @return 结果
     */
    @Override
    public int deleteCheckByUserId(Long userId)
    {
        return checkMapper.deleteCheckByUserId(userId);
    }
}
