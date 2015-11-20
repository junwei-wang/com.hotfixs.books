package com.hotfixs.thinkinginjava.annotations.inherited;

import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author wangjunwei
 */
public class InterfaceFooImplementationTest {
    @Test
    public void testAnnotationInherited() throws NoSuchMethodException {
        assertTrue(InterfaceFoo.class.isAnnotationPresent(EntityAnnotation.class));
        Method interfaceMethod = InterfaceFoo.class.getMethod("doBar", new Class[] {});
        assertTrue(interfaceMethod.isAnnotationPresent(MethodAnnotation.class));

        assertFalse(InterfaceFooImplementation.class.isAnnotationPresent(EntityAnnotation.class));
        Method method = InterfaceFooImplementation.class.getMethod("doBar", new Class[] {});
        assertFalse(method.isAnnotationPresent(MethodAnnotation.class));
    }
}