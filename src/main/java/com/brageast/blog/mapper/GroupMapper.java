package com.brageast.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.Group;

public interface GroupMapper extends BaseMapper<Group> {
    // 查询一个组分页
    Page<Group> getGroups(Page<Group> page);
    // 查询一个组的信息
    Group findGroup(Integer id);


}
