package com.och.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.CallDisplay;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 号码管理(CallDisplay)表数据库访问层
 *
 * @author danmo
 * @since 2023-10-23 10:45:58
 */
@Repository()
@Mapper
public interface CallDisplayMapper extends BaseMapper<CallDisplay> {

}

