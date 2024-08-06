package com.och.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import com.och.common.base.BaseServiceImpl;
import com.och.common.constant.SysSettingConfig;
import com.och.common.enums.DeleteStatusEnum;
import com.och.system.domain.entity.VoiceFile;
import com.och.system.domain.query.file.VoiceFileAddQuery;
import com.och.system.domain.query.file.VoiceFileQuery;
import com.och.system.domain.vo.file.VoiceFileVo;
import com.och.system.mapper.VoiceFileMapper;
import com.och.system.service.IVoiceFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 语音文件表(VoiceFile)表服务实现类
 *
 * @author danmo
 * @since 2023-11-01 14:35:02
 */
@Service
public class VoiceFileServiceImpl extends BaseServiceImpl<VoiceFileMapper, VoiceFile> implements IVoiceFileService {

    @Autowired
    private SysSettingConfig settingConfig;

    @Override
    public void add(VoiceFileAddQuery query) {
        VoiceFile voiceFile = new VoiceFile();
        voiceFile.setQuery2Entity(query);
        save(voiceFile);
    }

    @Override
    public void edit(VoiceFileAddQuery query) {
        VoiceFile voiceFile = new VoiceFile();
        voiceFile.setQuery2Entity(query);
        update(voiceFile, new LambdaQueryWrapper<VoiceFile>().eq(VoiceFile::getId, query.getId()));
    }

    @Override
    public void delete(VoiceFileQuery query) {
        List<Long> ids = new LinkedList<>();
        if (Objects.nonNull(query.getId())) {
            ids.add(query.getId());
        }
        if (CollectionUtil.isNotEmpty(query.getIds())) {
            ids.addAll(query.getIds());
        }
        if (CollectionUtil.isEmpty(ids)) {
            return;
        }
        List<VoiceFile> list = ids.stream().map(id -> {
            VoiceFile voiceFile = new VoiceFile();
            voiceFile.setId(id);
            voiceFile.setDelFlag(DeleteStatusEnum.DELETE_YES.getIndex());
            return voiceFile;
        }).collect(Collectors.toList());
        updateBatchById(list);
    }

    @Override
    public VoiceFileVo getDetail(Long id) {
        return this.baseMapper.getDetail(id);
    }

    @Override
    public List<VoiceFileVo> getPageList(VoiceFileQuery query) {
        startPage(query.getPageIndex(), query.getPageSize(),query.getSortField(), query.getSort());
        return getList(query);
    }

    @Override
    public List<VoiceFileVo> getList(VoiceFileQuery query) {
        return this.baseMapper.getList(query);
    }
}

