package com.hotfixs.thinkinginjava.annotations.inherited;

/**
 * @author wangjunwei
 */
@EntityAnnotation
public abstract class AbstractFoo {
    @MethodAnnotation
    public abstract void doBar();
}
