package storageLayer;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class TestDatabase {
	@Test
	public void testGetConnection() {
		try {
			assertEquals(Database.getConnection(), null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void TestReleaseConnection(){
		assertEquals(true,true);
	}
}
