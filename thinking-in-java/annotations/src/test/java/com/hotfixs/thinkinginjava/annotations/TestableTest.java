package com.hotfixs.thinkinginjava.annotations;

import org.junit.Test;

/**
 * @author wangjunwei
 */
public class TestableTest {

    @Test
    public void testExecute() throws Exception {
        new Testable().execute();
    }
}