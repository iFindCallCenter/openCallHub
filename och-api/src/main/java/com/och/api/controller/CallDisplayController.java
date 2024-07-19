package com.och.api.controller;

import com.och.common.base.BaseController;
import com.och.common.base.ResResult;
import com.och.system.domain.entity.CallDisplay;
import com.och.system.domain.query.display.CallDisplayAddQuery;
import com.och.system.domain.query.display.CallDisplayQuery;
import com.och.system.domain.vo.display.CallDisplaySimpleVo;
import com.och.system.domain.vo.display.CallDisplayVo;
import com.och.system.service.ICallDisplayService;
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
@Tag(name = "号码管理")
@RestController
@RequestMapping("call/v1/display")
public class CallDisplayController extends BaseController {

    @Autowired
    private ICallDisplayService iCallDisplayService;

    @Operation(summary = "新增号码", method = "POST")
    @PostMapping("/add")
    public ResResult add(@RequestBody @Validated CallDisplayAddQuery query) {
        iCallDisplayService.add(query);
        return success();
    }

    @Operation(summary = "修改号码", method = "PUT")
    @PutMapping("/edit/{id}")
    public ResResult edit(@PathVariable("id") Long id, @RequestBody @Validated CallDisplayAddQuery query) {
        query.setId(id);
        iCallDisplayService.edit(query);
        return success();
    }

    @Operation(summary = "号码详情", method = "GET")
    @GetMapping("/get/{id}")
    public ResResult<CallDisplayVo> get(@PathVariable("id") Long id) {
        return success(iCallDisplayService.getDetail(id));
    }

    @Operation(summary = "删除号码", method = "POST")
    @PostMapping("/delete")
    public ResResult delete(@RequestBody CallDisplayQuery query) {
        iCallDisplayService.delete(query);
        return success();
    }

    @Operation(summary = "号码列表(分页)", method = "POST")
    @PostMapping("/page/list")
    public ResResult<List<CallDisplayVo>> pageList(@RequestBody CallDisplayQuery query) {
        return success();
    }

    @Operation(summary = "号码列表(不分页)", method = "POST")
    @PostMapping("/list")
    public ResResult<List<CallDisplayVo>> list(@RequestBody CallDisplayQuery query) {
        return success();
    }

}
