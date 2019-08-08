package com.brageast.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brageast.blog.entity.Permissions;
import com.brageast.blog.mapper.PermissionsMapper;
import com.brageast.blog.service.PermissionService;
import com.brageast.blog.util.entity.Combination;

public class PermissionServiceImpl
        extends ServiceImpl<PermissionsMapper, Permissions>
        implements PermissionService {

    @Override
    public Page<Permissions> getPermissions(Page<Permissions> page) {
        return baseMapper.getPermissions(page);
    }

    @Override
    public Permissions findPermissions(Integer id) {
        return baseMapper.findPermissions(id);
    }

    @Override
    public boolean addPermissions(Combination<String, String>... prs) {
        try {
            baseMapper.addPermissions(prs);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deletePermissions(Integer id) {
        try {
            baseMapper.deleteAllGroupPermissions(id);
            baseMapper.deletePermissions(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
