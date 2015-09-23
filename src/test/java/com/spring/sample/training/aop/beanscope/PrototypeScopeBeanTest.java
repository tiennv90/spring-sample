package com.spring.sample.training.aop.beanscope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ComponentScannedConfig.class)
public class PrototypeScopeBeanTest {
	
	@Autowired
	private ApplicationContext context;
	
    @Test
    public void testProxyScope() {
      Notepad notepad1 = context.getBean(Notepad.class);
      Notepad notepad2 = context.getBean(Notepad.class);
      assertNotSame(notepad1, notepad2);
    }

}
