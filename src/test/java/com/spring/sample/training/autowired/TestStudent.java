package com.spring.sample.training.autowired;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.sample.training.nonautowired.Student;
import com.spring.sample.training.nonautowired.StudentConfig;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=StudentConfig.class)
public class TestStudent {
	
	@Autowired
	private Student student;
	
	@Test
	public void testStudent() {
		assertEquals("Student A", student.getName());
		assertEquals("Java Programming Course", student.getSubject().name());
	}
}
