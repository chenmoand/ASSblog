package com.brageast.blog.util;

/**
 * 这是一个失败的类, 泛型不能 大于或者小于判断??
 * 莫得感情
 * @author chenmo
 */
@Deprecated
public abstract class Formula {
    /**
     * A是否小于B
     * @param a
     * @param b
     * @param <T>
     * @return 运算结果
     */
    public static <T extends Number> Operation<T> A_less_B(T a, T b) {
        return new Operation<>(a, b, Symbol.LESS);
    }

    /**
     * A是否大于B;
     * @param a
     * @param b
     * @param <T>
     * @return 运算结果
     */
    public static <T extends Number> Operation<T> A_greater_B(T a, T b) {
        return new Operation<>(a, b, Symbol.GREATER);
    }

    public static class Operation<T> {
        private T t1;
        private T t2;
        private Symbol symbol;
        private Operation(){}

        public Operation(T t1, T t2, Symbol symbol) {
            this.t1 = t1;
            this.t2 = t2;
            this.symbol = symbol;
        }

        public T Return() {
            return null;
        }
        /*private boolean choose() {
            switch (symbol) {
                case LESS:

                case GREATER:

                    break;
            }
        }*/
    }
/*    @FunctionalInterface
    private static interface Check {
        boolean Rules();
    }*/
    private static enum Symbol {
        LESS /*小于*/, GREATER /*大于*/
    }
}
