package com.hotfixs.thinkinginjava.annotations.inherited;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author wangjunwei
 */
public class AbstractFooExtensionTest {
    @Test
    public void testAnnotationInherited() throws NoSuchMethodException {
        assertTrue(AbstractFoo.class.isAnnotationPresent(EntityAnnotation.class));
        Method superClassMethod = InterfaceFoo.class.getMethod("doBar", new Class[] {});
        assertTrue(superClassMethod.isAnnotationPresent(MethodAnnotation.class));

        assertTrue(AbstractFooExtension.class.isAnnotationPresent(EntityAnnotation.class));
        Method method = AbstractFooExtension.class.getMethod("doBar", new Class[] {});
        assertFalse(method.isAnnotationPresent(MethodAnnotation.class));
    }
}