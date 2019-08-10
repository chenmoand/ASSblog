package com.brageast.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Set;

@Data
//@AllArgsConstructor 加这个注解就会报错
@TableName("Blog_User")
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    @Email
    private String email;

    private Set<Group> groups;

//    private String permissions;

//    public Set<String> getListPermissions(){
//        return new HashSet<>(Arrays.asList(getPermissions().split(",")));
//    }
}
