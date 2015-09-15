package com.spring.sample.training.autowired;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

	@Autowired
	private CompactDisc compactDisc;
	
	
	@Autowired
	private MediaPlayer player;
	
	@Test
	public void testNotNull() {
		assertNotNull(compactDisc);
		assertNotNull(player);
	}
	
	@Test
	public void testPlay() {
		assertEquals("Playing: My Club artist: The Beatles", player.play());
	}
}
