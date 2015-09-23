package com.spring.sample.training.qualifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DessertConfig.class})
public class DessertTest {
	
	@Autowired
	private Dessert primaryDessert;
	
	@Autowired
	@Qualifier("cake")
	private Dessert cakeDessert;
	
	@Test
	public void testPrimaryDessert() {
		assertEquals("Cookies", primaryDessert.getName());
	}

	@Test
	public void testCakeDessert() {
		assertEquals("Cake", cakeDessert.getName());
	}
}
