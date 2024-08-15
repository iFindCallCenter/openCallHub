package com.och.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.CallDisplayPoolRel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 号码池号码关联表(CallDisplayPoolRel)表数据库访问层
 *
 * @author danmo
 * @since 2024-08-09 14:58:05
 */
@Repository()
@Mapper
public interface CallDisplayPoolRelMapper extends BaseMapper<CallDisplayPoolRel> {

}

