package com.och.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.och.common.base.BaseServiceImpl;
import com.och.common.enums.DeleteStatusEnum;
import com.och.common.utils.SpringUtils;
import com.och.system.domain.entity.SysRole;
import com.och.system.domain.entity.SysRoleMenu;
import com.och.system.domain.query.role.SysRoleAddQuery;
import com.och.system.domain.query.role.SysRoleQuery;
import com.och.system.domain.vo.role.SysRoleVo;
import com.och.system.mapper.SysRoleMapper;
import com.och.system.service.ISysRoleMenuService;
import com.och.system.service.ISysRoleService;
import com.och.system.service.ISysUserRoleService;
import com.och.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色信息表(SysRole)表服务实现类
 *
 * @author danmo
 * @since 2024-02-22 11:22:25
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private ISysUserRoleService iSysUserRoleService;

    @Autowired
    private ISysRoleMenuService iSysRoleMenuService;

    @Override
    public List<SysRoleVo> getRoleByUserId(Long userId) {
        return  this.baseMapper.getRoleByUserId(userId);
    }

    @Override
    public void add(SysRoleAddQuery query) {
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(query, sysRole);
        if (save(sysRole)) {
            if (CollectionUtil.isNotEmpty(query.getMenuIds())) {
                List<SysRoleMenu> sysRoleMenus = query.getMenuIds().stream().map(menuId -> {
                    SysRoleMenu sysRoleMenu = new SysRoleMenu();
                    sysRoleMenu.setRoleId(sysRole.getRoleId());
                    sysRoleMenu.setMenuId(menuId);
                    return sysRoleMenu;
                }).collect(Collectors.toList());
                iSysRoleMenuService.saveBatch(sysRoleMenus);
            }
        }
        ;
    }

    @Override
    public void edit(SysRoleAddQuery query) {
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(query, sysRole);
        sysRole.setRoleId(query.getRoleId());
        if (updateById(sysRole)) {
            if (CollectionUtil.isNotEmpty(query.getMenuIds())) {
                iSysRoleMenuService.updateBatch(query.getRoleId(), query.getMenuIds());
            }
        }
    }

    @Override
    public SysRoleVo getDetail(SysRoleQuery query) {
        return this.baseMapper.getDetail(query);
    }

    @Override
    public void delete(SysRoleQuery query) {
        if (CollectionUtil.isEmpty(query.getRoleIds())) {
            return;
        }
        List<SysRole> list = query.getRoleIds().stream().map(id -> {
            SysRole sysRole = new SysRole();
            sysRole.setRoleId(id);
            sysRole.setDelFlag(DeleteStatusEnum.DELETE_YES.getIndex());
            return sysRole;
        }).collect(Collectors.toList());
        boolean update = updateBatchById(list);
        if (update) {
            iSysRoleMenuService.update(new LambdaUpdateWrapper<SysRoleMenu>().set(SysRoleMenu::getDelFlag, DeleteStatusEnum.DELETE_YES.getIndex()).in(SysRoleMenu::getRoleId, query.getRoleIds()));
        }
    }

    @Override
    public List<SysRoleVo> getList(SysRoleQuery query) {
        List<SysRoleVo> list = this.baseMapper.getList(query);
        ISysUserService bean = SpringUtils.getBean(ISysUserService.class);
        bean.decorate(list);
        return list;
    }

    @Override
    public List<SysRoleVo> getPageList(SysRoleQuery query)
    {
        startPage(query.getPageIndex(), query.getPageSize());
        return getList(query);
    }
}

