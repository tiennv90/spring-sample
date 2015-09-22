package com.spring.sample.training.datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class })
@ActiveProfiles("dev")
public class DataSourceTest {

	@Autowired
	private DataSource dataSource;

	@Test
	public void shouldBeEmbeddedDatasource() {
		assertNotNull(dataSource);
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		List<String> results = jdbc.query("select id, name from Things",
				new RowMapper<String>() {

					public String mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return rs.getLong("id") + ":" + rs.getString("name");
					}

				});

		assertEquals(1, results.size());
		assertEquals("1:A", results.get(0));
	}
}
