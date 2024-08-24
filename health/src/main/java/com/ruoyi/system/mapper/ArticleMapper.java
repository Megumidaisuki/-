package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-08-22
 */
@Mapper
public interface ArticleMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param articleId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Article selectArticleByArticleId(Long articleId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param article 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Article> selectArticleList(Article article);

    /**
     * 新增【请填写功能名称】
     *
     * @param article 【请填写功能名称】
     * @return 结果
     */
    public int insertArticle(Article article);

    /**
     * 修改【请填写功能名称】
     *
     * @param article 【请填写功能名称】
     * @return 结果
     */
    public int updateArticle(Article article);

    /**
     * 删除【请填写功能名称】
     *
     * @param articleId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteArticleByArticleId(Long articleId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param articleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArticleByArticleIds(Long[] articleIds);


    void renewArticle(@Param("articleId") Long articleId, @Param("like") Integer like, @Param("viewCount") Integer viewCount);
}
