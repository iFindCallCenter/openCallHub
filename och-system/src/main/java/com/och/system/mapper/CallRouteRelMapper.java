package com.och.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.CallRouteRel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 号码路由网关配置关联表(CallRouteRel)表数据库访问层
 *
 * @author danmo
 * @since 2023-10-18 14:52:28
 */
@Repository()
@Mapper
public interface CallRouteRelMapper extends BaseMapper<CallRouteRel> {

}

