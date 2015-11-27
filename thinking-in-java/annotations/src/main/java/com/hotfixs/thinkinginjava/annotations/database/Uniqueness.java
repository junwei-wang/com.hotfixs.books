package com.hotfixs.thinkinginjava.annotations.database;

/**
 * @author wangjunwei
 */
public @interface Uniqueness {
    Constrains constrains() default @Constrains(unique = true);
}
