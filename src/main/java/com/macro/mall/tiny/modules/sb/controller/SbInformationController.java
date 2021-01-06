package com.macro.mall.tiny.modules.sb.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.sb.model.SbInformation;
import com.macro.mall.tiny.modules.sb.service.SbInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author macro
 * @since 2021-01-05
 */
@RestController
@Api(tags = "SbInformationController")
@RequestMapping("/sb/sbInformation")
public class SbInformationController {

    @Autowired
    private SbInformationService infoService;

    @ApiOperation("添加")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SbInformation info) {
        boolean success = infoService.create(info);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody SbInformation info) {
        boolean success = infoService.update(id, info);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据MAC获取")
    @RequestMapping(value = "/{mac}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SbInformation> getItem(@PathVariable String mac) {
        SbInformation info = infoService.getByMac(mac);
        return CommonResult.success(info);
    }

    @ApiOperation("分页模糊查询后台资源")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SbInformation>> list(@RequestParam(required = false) String mac,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<SbInformation> infoList = infoService.list(mac, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(infoList));
    }
}

