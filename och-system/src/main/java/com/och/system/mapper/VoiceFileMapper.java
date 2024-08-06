package com.och.system.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.VoiceFile;
import com.och.system.domain.query.file.VoiceFileQuery;
import com.och.system.domain.vo.file.VoiceFileVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 语音文件表(VoiceFile)表数据库访问层
 *
 * @author danmo
 * @since 2023-11-01 14:35:02
 */
@Repository()
@Mapper
public interface VoiceFileMapper extends BaseMapper<VoiceFile> {

    @InterceptorIgnore(tenantLine = "true")
    VoiceFileVo getDetail(@Param("id") Long id);

    List<VoiceFileVo> getList(VoiceFileQuery query);
}

