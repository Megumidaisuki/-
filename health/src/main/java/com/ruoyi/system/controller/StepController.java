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
import com.ruoyi.system.domain.Step;
import com.ruoyi.system.service.IStepService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 步数Controller
 * 
 * @author ruoyi
 * @date 2024-09-18
 */
@RestController
@RequestMapping("/system/step")
public class StepController extends BaseController
{
    @Autowired
    private IStepService stepService;

    /**
     * 查询步数列表
     */
    @PreAuthorize("@ss.hasPermi('system:step:list')")
    @GetMapping("/list")
    public TableDataInfo list(Step step)
    {
        startPage();
        List<Step> list = stepService.selectStepList(step);
        return getDataTable(list);
    }

    /**
     * 导出步数列表
     */
    @PreAuthorize("@ss.hasPermi('system:step:export')")
    @Log(title = "步数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Step step)
    {
        List<Step> list = stepService.selectStepList(step);
        ExcelUtil<Step> util = new ExcelUtil<Step>(Step.class);
        util.exportExcel(response, list, "步数数据");
    }

    /**
     * 获取步数详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:step:query')")
    @GetMapping(value = "/{stepId}")
    public AjaxResult getInfo(@PathVariable("stepId") Long stepId)
    {
        return success(stepService.selectStepByStepId(stepId));
    }

    /**
     * 新增步数
     */
    @PreAuthorize("@ss.hasPermi('system:step:add')")
    @Log(title = "步数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Step step)
    {
        return toAjax(stepService.insertStep(step));
    }

    /**
     * 修改步数
     */
    @PreAuthorize("@ss.hasPermi('system:step:edit')")
    @Log(title = "步数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Step step)
    {
        return toAjax(stepService.updateStep(step));
    }

    /**
     * 删除步数
     */
    @PreAuthorize("@ss.hasPermi('system:step:remove')")
    @Log(title = "步数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stepIds}")
    public AjaxResult remove(@PathVariable Long[] stepIds)
    {
        return toAjax(stepService.deleteStepByStepIds(stepIds));
    }
}
