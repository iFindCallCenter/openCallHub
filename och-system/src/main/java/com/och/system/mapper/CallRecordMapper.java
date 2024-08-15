package com.och.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.CallRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 呼叫记录表(CallRecord)表数据库访问层
 *
 * @author danmo
 * @since 2024-08-12 15:31:42
 */
@Repository()
@Mapper
public interface CallRecordMapper extends BaseMapper<CallRecord> {

}

