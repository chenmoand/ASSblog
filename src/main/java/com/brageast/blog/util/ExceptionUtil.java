package com.brageast.blog.util;

/**
 *
 *
 */

@Deprecated
public class  ExceptionUtil  {

    public static <E extends Exception> void isException(EStatement eStatement, Class<E> classz) throws E {
//        ArrayList
//        eStatement.init();
//        Assert
    }
    @FunctionalInterface
    public interface EStatement {
        void init();
    }
}
