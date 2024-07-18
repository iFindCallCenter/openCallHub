package com.och.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.SysCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 分类配置表(SysCategory)表数据库访问层
 *
 * @author danmo
 * @since 2023-10-31 11:06:55
 */
@Repository()
@Mapper
public interface SysCategoryMapper extends BaseMapper<SysCategory> {

    List<SysCategory> categoryList(@Param("type") Integer type);
}

