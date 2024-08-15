package com.och.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.CallDisplayPool;
import com.och.system.domain.query.display.CallDisplayPoolQuery;
import com.och.system.domain.vo.display.CallDisplayPoolVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 号码池管理(CallDisplayPool)表数据库访问层
 *
 * @author danmo
 * @since 202408-09 14:57:14
 */
@Repository()
@Mapper
public interface CallDisplayPoolMapper extends BaseMapper<CallDisplayPool> {

    CallDisplayPoolVo getPoolDetail(@Param("id") Long id);

    List<Long> selectIdsByQuery(CallDisplayPoolQuery query);

    List<CallDisplayPoolVo> getList(CallDisplayPoolQuery query);
}

