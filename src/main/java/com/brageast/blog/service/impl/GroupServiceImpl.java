package com.brageast.blog.service.impl;

import com.brageast.blog.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    /**
     *
     * @author chenmo
     * 伪造查询数据库....毕竟创建数据库太麻烦
     *
     */
    @Override
    public Set<String> getGroup() {
        return new HashSet<String>(){{
            add("admin"); add("guest"); add("root");
        }};
    }

    @Override
    public Set<String> getPermissions() {
        return new HashSet<String>(){{
            add("admin"); add("guest"); add("root");
        }};
    }
}
