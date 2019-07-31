package com.brageast.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brageast.blog.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService extends IService<User> {
    /**
     *
     *  @param page
     *  @return Page<User>
     *  例子 : getUsers(new Page<>(1, 5));
     *
     */
    Page<User> getUsers(Page<User> page);

    /**
     * 不加@Param就报错,,,可能是我菜还是我mybatils-plus我不会用
     * 下面就是增删改查部分了
     */
    void deleteUser(@Param("id") Integer id);
    void insertUser(@Param("id") Integer id, @Param("name") String name, @Param("password") String password,
                    @Param("email") String email, @Param("group") String group, @Param("permissions") String permissions);
    void updataUser(@Param("id") Integer id, @Param("name") String name, @Param("password") String password,
                    @Param("email") String email, @Param("group") String group, @Param("permissions") String permissions);
    User findUser(@Param("id") Integer id);
}
