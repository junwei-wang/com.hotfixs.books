package com.hotfixs.thinkinginjava.annotations.inherited;

/**
 * @author wangjunwei
 */
@EntityAnnotation
public interface InterfaceFoo {
    @MethodAnnotation
    void doBar();
}
