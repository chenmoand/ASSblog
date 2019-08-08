package com.brageast.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brageast.blog.entity.Permissions;
import com.brageast.blog.util.entity.Combination;
import org.apache.ibatis.annotations.Param;

public interface PermissionService extends IService<Permissions> {
    Page<Permissions> getPermissions(Page<Permissions> page);
    Permissions findPermissions(Integer id);
    boolean addPermissions(@Param("prs") Combination<String,String>... prs);
    boolean deletePermissions(Integer id);
}
