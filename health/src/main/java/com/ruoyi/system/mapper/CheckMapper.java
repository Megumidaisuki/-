package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Check;

/**
 * 健康检查Mapper接口
 * 
 * @author ruoyi
 * @date 2024-09-18
 */
public interface CheckMapper 
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
     * 删除健康检查
     * 
     * @param userId 健康检查主键
     * @return 结果
     */
    public int deleteCheckByUserId(Long userId);

    /**
     * 批量删除健康检查
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCheckByUserIds(Long[] userIds);
}
