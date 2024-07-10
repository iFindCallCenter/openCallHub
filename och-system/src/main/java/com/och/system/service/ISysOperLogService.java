package com.och.system.service;

import com.och.common.base.IBaseService;
import com.och.system.domain.entity.SysOperLog;
import com.och.system.domain.query.BaseQuery;
import com.och.system.domain.query.log.SysOperationLogQuery;

import java.util.List;

/**
 * 系统操作日志记录(SysOperLog)表服务接口
 *
 * @author danmo
 * @since 2024-03-12 19:09:58
 */
public interface ISysOperLogService extends IBaseService<SysOperLog> {

    List<SysOperLog> getList(SysOperationLogQuery query);

    void delete(SysOperationLogQuery query);

    void emptyOperation(BaseQuery query);
}

