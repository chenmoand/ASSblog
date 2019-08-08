package com.brageast.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.Permissions;
import com.brageast.blog.util.entity.Combination;
import org.apache.ibatis.annotations.Param;


public interface PermissionsMapper extends BaseMapper<Permissions> {
    // 查询所有权限
    Page<Permissions> getPermissions(Page<Permissions> page);
    // 查询单个权限
    Permissions findPermissions(Integer id);
    // 增加一条权限或者多条权限
    void addPermissions(@Param("prs") Combination<String,String>... prs);
    // 删除一个权限
    void deletePermissions(Integer id);
    // 删除一个权限后,删除所有关联组的权限
    void deleteAllGroupPermissions(Integer per_id);
}
