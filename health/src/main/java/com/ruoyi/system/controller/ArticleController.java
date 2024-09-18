package com.ruoyi.system.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.service.ICommentService;
import com.ruoyi.system.service.utils.RedisService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Article;
import com.ruoyi.system.service.IArticleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2024-08-22
 */
@RestController
@RequestMapping("/system/article")
public class ArticleController extends BaseController
{
    @Autowired
    private IArticleService articleService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private RedisService redisService;
    /**
     * 展示热门推荐
     */

    @PreAuthorize("@ss.hasPermi('system:article:list')")
    @GetMapping("/frontList")
    public TableDataInfo frontList()
    {
        Article article = new Article();
        startPage();
        List<Article> list = articleService.selectArticleList(article);
        Collections.sort(list,(o1, o2) -> o2.getViewCount().compareTo(o1.getViewCount()));
        return getDataTable(list);
    }
    //科普and交流分享
    @PreAuthorize("@ss.hasPermi('system:article:list')")
    @GetMapping("/scienceList")
    public TableDataInfo scienceList(@RequestParam Integer status)
    {

        Article article = new Article();
        if(status == 0){
            //科普
            article.setStatus(0L);
        } else if (status ==1) {
            //交流分享
            article.setStatus(1L);
        }
        startPage();
        List<Article> list = articleService.selectArticleList(article);
        Collections.sort(list,(o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime()));
        return getDataTable(list);
    }


    @PreAuthorize("@ss.hasPermi('system:article:list')")
    @PostMapping("/addLike")
    public AjaxResult addLike(Long id,Integer status)
    {
        if(status == 0){
            //文章点赞
            redisService.incrementLikeCount(id);
        }else if(status == 1){
            //评论点赞
            redisService.incrementCommentLikeCount(id);
        }
        return AjaxResult.success();
    }

    @PreAuthorize("@ss.hasPermi('system:article:list')")
    @PostMapping("/addView")
    public AjaxResult addView(Long id)
    {
        redisService.incrementViewCount(id);
        return AjaxResult.success();
    }
    /**
     * 获取文章详细信息
     */

    @PreAuthorize("@ss.hasPermi('system:article:list')")
    @GetMapping(value = "/{articleId}")
    public AjaxResult getInfo(@PathVariable("articleId") Long articleId)
    {
        return success(articleService.selectArticleByArticleId(articleId));
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(Article article)
    {
        startPage();
        List<Article> list = articleService.selectArticleList(article);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:article:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Article article)
    {
        List<Article> list = articleService.selectArticleList(article);
        ExcelUtil<Article> util = new ExcelUtil<Article>(Article.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }



    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:article:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Article article)
    {
        return toAjax(articleService.insertArticle(article));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:article:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Article article)
    {
        return toAjax(articleService.updateArticle(article));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:article:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{articleIds}")
    public AjaxResult remove(@PathVariable Long[] articleIds)
    {
        return toAjax(articleService.deleteArticleByArticleIds(articleIds));
    }
}
