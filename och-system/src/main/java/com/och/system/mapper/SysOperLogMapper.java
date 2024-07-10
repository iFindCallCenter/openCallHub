package com.och.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.SysOperLog;
import com.och.system.domain.query.log.SysOperationLogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统操作日志记录(SysOperLog)表数据库访问层
 *
 * @author danmo
 * @since 2024-03-12 19:09:58
 */
@Repository()
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

    List<SysOperLog> getList(SysOperationLogQuery query);
}

