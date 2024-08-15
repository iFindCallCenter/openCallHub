package com.och.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.CallSchedule;
import com.och.system.domain.query.schedule.CallScheduleQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 日程安排表(CallSchedule)表数据库访问层
 *
 * @author danmo
 * @since 2024-08-09 17:14:31
 */
@Repository()
@Mapper
public interface CallScheduleMapper extends BaseMapper<CallSchedule> {

    List<CallSchedule> getList(CallScheduleQuery query);

}

