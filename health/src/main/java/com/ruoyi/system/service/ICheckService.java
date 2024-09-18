package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Check;

/**
 * 健康检查Service接口
 * 
 * @author ruoyi
 * @date 2024-09-18
 */
public interface ICheckService 
{
    /**
     * 查询健康检查
     * 
     * @param userId 健康检查主键
     * @return 健康检查
     */
    public Check selectCheckByUserId(Long userId);

    /**
     * 查询健康检查列表
     * 
     * @param check 健康检查
     * @return 健康检查集合
     */
    public List<Check> selectCheckList(Check check);

    /**
     * 新增健康检查
     * 
     * @param check 健康检查
     * @return 结果
     */
    public int insertCheck(Check check);

    /**
     * 修改健康检查
     * 
     * @param check 健康检查
     * @return 结果
     */
    public int updateCheck(Check check);

    /**
     * 批量删除健康检查
     * 
     * @param userIds 需要删除的健康检查主键集合
     * @return 结果
     */
    public int deleteCheckByUserIds(Long[] userIds);

    /**
     * 删除健康检查信息
     * 
     * @param userId 健康检查主键
     * @return 结果
     */
    public int deleteCheckByUserId(Long userId);
}
