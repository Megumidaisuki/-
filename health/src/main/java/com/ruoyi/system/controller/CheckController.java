package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Check;
import com.ruoyi.system.service.ICheckService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 健康检查Controller
 * 
 * @author ruoyi
 * @date 2024-09-18
 */
@RestController
@RequestMapping("/system/check")
public class CheckController extends BaseController
{
    @Autowired
    private ICheckService checkService;

    /**
     * 查询健康检查列表
     */
    @PreAuthorize("@ss.hasPermi('system:check:list')")
    @GetMapping("/list")
    public TableDataInfo list(Check check)
    {
        startPage();
        List<Check> list = checkService.selectCheckList(check);
        return getDataTable(list);
    }

    /**
     * 导出健康检查列表
     */
    @PreAuthorize("@ss.hasPermi('system:check:export')")
    @Log(title = "健康检查", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Check check)
    {
        List<Check> list = checkService.selectCheckList(check);
        ExcelUtil<Check> util = new ExcelUtil<Check>(Check.class);
        util.exportExcel(response, list, "健康检查数据");
    }

    /**
     * 获取健康检查详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:check:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(checkService.selectCheckByUserId(userId));
    }

    /**
     * 新增健康检查
     */
    @PreAuthorize("@ss.hasPermi('system:check:add')")
    @Log(title = "健康检查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Check check)
    {
        return toAjax(checkService.insertCheck(check));
    }

    /**
     * 修改健康检查
     */
    @PreAuthorize("@ss.hasPermi('system:check:edit')")
    @Log(title = "健康检查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Check check)
    {
        return toAjax(checkService.updateCheck(check));
    }

    /**
     * 删除健康检查
     */
    @PreAuthorize("@ss.hasPermi('system:check:remove')")
    @Log(title = "健康检查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(checkService.deleteCheckByUserIds(userIds));
    }
}
