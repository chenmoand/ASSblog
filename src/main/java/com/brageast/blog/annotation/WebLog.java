package com.brageast.blog.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface WebLog {
    /**
     * 描述信息
     *
     * @return
     */
    String description() default "";
}
