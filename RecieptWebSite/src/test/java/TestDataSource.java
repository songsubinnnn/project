import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.greenart.config.RootConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class TestDataSource {
	@Autowired
	private DataSource dataSource;
	
	

	@Test
	public void test() throws SQLException {
		int result = 0;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT 1");
				ResultSet rs = stmt.executeQuery();) {
			if (rs.next()) {
				result = rs.getInt(1);
			}
		}
		Assert.assertEquals(1, result);
	}

}
