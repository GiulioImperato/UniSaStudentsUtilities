package storageLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Connector per il database
 * 
 * @author Tropeano Domenico Antonio
 *
 */
public class Database {

	private static String protocol;
	private static String hostname;
	private static String port;
	private static String username;
	private static String password;
	private static String dbName;
	private static Properties userInfo;
	private static Connection connection;
	private static String mySqlUrl;
	//private static final boolean DEBUG = false;
	private static final boolean LOCAL = false;

	static {
		protocol = "jdbc:mysql://";

		if (LOCAL) {
			hostname = "localhost:";
			port = "3306/";
			dbName = "myDB";
			mySqlUrl = protocol + hostname + port + dbName;
			username = "root";
			password = "root";
			userInfo = new Properties();
			userInfo.put("user", username);
			userInfo.put("password", password);

		} else {
			hostname = "mysql3.gear.host:";
			port = "3306/";
			dbName = "redteam";
			mySqlUrl = protocol + hostname + port + dbName;

			/**********************************/
			username = "oromis95";
			password = "P@ssw0rd";
			userInfo = new Properties();
			userInfo.put("user", username);
			userInfo.put("password", password);
		}
		openConnection();
	}

	/**
	 * Controlla se la connessione col db è stata già aperta
	 * 
	 * @return {@code true} if the connection is open, {@code false} otherwise.
	 * @author Domenico Antonio Tropeano
	 */
	public static boolean isConnectionOpen() {
		boolean isOpen = false;
		try {
			if (connection != null && !connection.isClosed()) {
				isOpen = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isOpen;
	}

	/**
	 * Tenta di aprire la connessione al db, se la connessione è già aperta non
	 * ha alcun effetto
	 * 
	 * @author Tropeano Domenico Antonio
	 */
	public static void openConnection() {
		if (!isConnectionOpen()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(mySqlUrl, userInfo);
				System.out.println("Connection: " + connection);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Chiude la connessione
	 * 
	 * @return {@code true} se la connessione viene chiusa, {@code false} se non
	 *         esiste alcuna connessione.
	 * @author Tropeano Domenico Antonio
	 */
	public static boolean closeConnection() {
		boolean isClosed = false;

		if (isConnectionOpen()) {
			try {
				connection.close();
				isClosed = connection.isClosed();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isClosed;
	}

	/**
	 * Presa una stringa fornisce un prepared statement per la sessione corrente
	 * 
	 * @param statement
	 * @return PreparedStatement
	 * @author Domenico Antonio Tropeano
	 */
	public static PreparedStatement getPreparedStatement(String statement) {
		openConnection();
		PreparedStatement preparedStatement = null;

		if (statement != null && !statement.equals("")) {
			try {
				preparedStatement = connection.prepareStatement(statement);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return preparedStatement;
	}

}
