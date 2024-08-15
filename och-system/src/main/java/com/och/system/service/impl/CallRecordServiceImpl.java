package com.och.system.service.impl;

import com.och.common.base.BaseServiceImpl;
import com.och.system.domain.entity.CallRecord;
import com.och.system.mapper.CallRecordMapper;
import com.och.system.service.ICallRecordService;
import org.springframework.stereotype.Service;

/**
 * 呼叫记录表(CallRecord)表服务实现类
 *
 * @author danmo
 * @since 2024-08-12 15:31:42
 */
@Service
public class CallRecordServiceImpl extends BaseServiceImpl<CallRecordMapper, CallRecord> implements ICallRecordService {

}

