package com.och.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.CorpInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 企业信息表(CorpInfo)
 *
 * @author danmo
 * @date 2023-07-07 14:37:57
 */
@Repository()
@Mapper
public interface CorpInfoMapper extends BaseMapper<CorpInfo> {


}

