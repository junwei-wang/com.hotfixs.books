package com.hotfixs.thinkinginjava.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangjunwei
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlInteger {
    String name() default "";

    Constrains constrains() default @Constrains;
}
