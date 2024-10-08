package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Comment;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-08-22
 */
public interface ICommentService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param commentId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Comment selectCommentByCommentId(Long commentId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param comment 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Comment> selectCommentList(Comment comment);

    /**
     * 新增【请填写功能名称】
     *
     * @param comment 【请填写功能名称】
     * @return 结果
     */
    public int insertComment(Comment comment);

    /**
     * 修改【请填写功能名称】
     *
     * @param comment 【请填写功能名称】
     * @return 结果
     */
    public int updateComment(Comment comment);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param commentIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteCommentByCommentIds(Long[] commentIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param commentId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteCommentByCommentId(Long commentId);


}
