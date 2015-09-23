package com.spring.sample.training.condition;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MagicConfig.class)
public class MagicConditionTest {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@BeforeClass
	public static void init() {
		System.setProperty("magic", "1");
	}
	
	@Test
	public void test() {
		assertTrue(applicationContext.containsBean("magicBean"));
	}
	
}
