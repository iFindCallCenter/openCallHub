package com.och.system.service;


import com.github.pagehelper.PageInfo;
import com.och.common.base.IBaseService;
import com.och.system.domain.entity.VoiceFile;
import com.och.system.domain.query.file.VoiceFileAddQuery;
import com.och.system.domain.query.file.VoiceFileQuery;
import com.och.system.domain.vo.file.VoiceFileVo;

import java.util.List;

/**
 * 语音文件表(VoiceFile)表服务接口
 *
 * @author danmo
 * @since 2023-11-01 14:35:02
 */
public interface IVoiceFileService extends IBaseService<VoiceFile> {

    void add(VoiceFileAddQuery query);

    void edit(VoiceFileAddQuery query);

    void delete(VoiceFileQuery query);

    VoiceFileVo getDetail(Long id);

    List<VoiceFileVo> getPageList(VoiceFileQuery query);

    List<VoiceFileVo> getList(VoiceFileQuery query);
}

