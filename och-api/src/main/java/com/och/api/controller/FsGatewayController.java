package com.och.api.controller;

import com.github.pagehelper.PageInfo;
import com.och.common.base.BaseController;
import com.och.common.base.ResResult;
import com.och.system.domain.entity.FsSipGateway;
import com.och.system.domain.query.fssip.FsSipGatewayAddQuery;
import com.och.system.domain.query.fssip.FsSipGatewayQuery;
import com.och.system.service.IFsSipGatewayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author danmo
 * @date 2023年09月11日 13:37
 */
@Tag(name = "fs网关管理")
@RestController
@RequestMapping("/system/v1/gateway")
public class FsGatewayController extends BaseController {

    @Autowired
    private IFsSipGatewayService iFsSipGatewayService;

    @Operation(summary = "新增网关", method = "POST")
    @PostMapping("/add")
    public ResResult add(@RequestBody @Validated FsSipGatewayAddQuery query) {
        iFsSipGatewayService.add(query);
        return success();
    }

    @Operation(summary = "修改网关", method = "POST")
    @PostMapping("/edit/{id}")
    public ResResult edit(@PathVariable("id") Long id, @RequestBody @Validated FsSipGatewayAddQuery query) {
        query.setId(id);
        iFsSipGatewayService.edit(query);
        return success();
    }

    @Operation(summary = "网关详情", method = "POST")
    @PostMapping("/get/{id}")
    public ResResult<FsSipGateway> get(@PathVariable("id") Long id) {
        return success(iFsSipGatewayService.getDetail(id));
    }

    @Operation(summary = "删除网关", method = "POST")
    @PostMapping("/delete")
    public ResResult delete(@RequestBody FsSipGatewayQuery query) {
        iFsSipGatewayService.delete(query);
        return success();
    }

    @Operation(summary = "网关列表(分页)", method = "POST")
    @PostMapping("/page/list")
    public ResResult<List<FsSipGateway>> pageList(@RequestBody FsSipGatewayQuery query) {
        List<FsSipGateway> list = iFsSipGatewayService.getPageList(query);
        PageInfo<FsSipGateway> pageInfo = new PageInfo<>(list);
        return success(pageInfo);
    }

    @Operation(summary = "网关列表(不分页)", method = "POST")
    @PostMapping("/list")
    public ResResult<List<FsSipGateway>> list(@RequestBody FsSipGatewayQuery query) {
        List<FsSipGateway> list = iFsSipGatewayService.getList(query);
        return success(list);
    }

}
