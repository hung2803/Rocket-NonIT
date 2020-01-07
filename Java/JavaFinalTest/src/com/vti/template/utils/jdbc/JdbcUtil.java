package com.vti.template.utils.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.vti.template.utils.Constant;

/**
 * This class is JDBC Util.
 * 
 * default date format : YYYY-MM-DD
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public class JdbcUtil {

	private static JdbcUtil instance;

	private Connection connection;
	private Statement statement;
	private PreparedStatement prepared;

	/**
	 * This method is design pattern singleton to get object JDBCManager.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @return Instance of JDBCManager
	 */
	public static JdbcUtil getInstance() {
		if (null == instance) {
			instance = new JdbcUtil();
		}
		return instance;
	}

	/**
	 * Constructor for class JdbcUtil.
	 * 
	 * Not allow Object use JdbcUtil can create new JDBCManager()
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 */
	private JdbcUtil() {

	}

	/**
	 * This method connects database with CONNECTION_URL.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @return is successful
	 */
	private boolean connect() {
		try {
			// if connect is null or close then connect again
			if (null == connection || connection.isClosed()) {
				// register the driver class with DriverManager
				Class.forName(Constant.DRIVER_SQL_NAME);

				// set username & password SQL
				Properties properties = new Properties();
				properties.setProperty("user", Constant.DATABASE_USERNAME);
				properties.setProperty("password", Constant.DATABASE_PASSWORD);

				// open connect
				connection = DriverManager.getConnection(Constant.CONNECTION_STRING, properties);
			}
			return true;
		} catch (SQLException e) {
			System.out.println(Constant.ERROR_CONNECT_DATABASE_STR);
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(Constant.ERROR_DRIVER_NAME);
			System.out.println(e);
		}
		return false;
	}

	/**
	 * This method disconnects connection .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 */
	public void disconnect() {
		try {
			// // if connect is a connection then disconnect
			if (null != connection && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(Constant.ERROR_DISCONNECT_DATABASE_STR);
			System.out.println(e);
		}
	}

	/**
	 * This method uses for Select, Insert, Update, Delete statement .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param sql
	 *            - statement query sql
	 * @return ResultSet
	 */
	public ResultSet selectStatement(String sql) {
		// if hasn't connect
		if (!connect() || null == sql) {
			return null;
		}
		
		// if has connect
		try {
			// create new statement
			statement = connection.createStatement();

			// execute Query
			return statement.executeQuery(sql);

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * This method Only uses for insert, update, delete .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param sql
	 *            - statement query sql
	 * @return int (-1 is not connect, -2 is update not success, else is change
	 *         rowcount)
	 */
	public int updateStatement(String sql) {
		// if has not connect
		if (!connect()) {
			return Constant.ERROR_CONNECT_DATABASE_INT;
		}

		// if has connect
		// if not param
		if (null == sql) {
			return Constant.ERROR_SQL_EXCEPTION_INT;
		}
		try {
			// create new statement
			statement = connection.createStatement();

			// execute statement update
			return statement.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println(e);
			return Constant.ERROR_SQL_EXCEPTION_INT;
		}
	}

	/**
	 * This method use for select, insert, update, delete Preparation Statement.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param sql
	 *            - statement query sql
	 * @param params
	 *            - need number(from 1), values
	 * @return ResultSet
	 */
	public ResultSet selectPreparationStatement(String sql, List<SqlParameter> params) {
		// if has not connect
		if (!connect()) {
			return null;
		}

		// if has connect
		// if not parameters
		if (params == null || params.size() == 0 || null == sql) {
			return null;
		}

		try {
			// create new statement
			prepared = connection.prepareStatement(sql);

			// set parameters to statement
			for (SqlParameter param : params) {
				prepared.setObject(param.getNumber(), param.getValues());
			}

			// execute Query Update
			ResultSet result = prepared.executeQuery();
			//connection.commit();

			// return rows
			return result;

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * This method only use for insert, update, delete Preparation Statement.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param sql
	 *            - statement query sql
	 * @param params
	 *            - query with list number(from 1), values need insert, update,
	 *            delete
	 * @return int (-1 is not connect or invalid fields, -2 is update not
	 *         success, else is rowcount)
	 */
	public int updatePreparationStatement(String sql, List<SqlParameter> params) {
		// if has not connect
		if (!connect()) {
			return Constant.ERROR_CONNECT_DATABASE_INT;
		}

		// if has connect
		// if not parameters
		if (params == null || params.size() == 0 || null == sql) {
			return Constant.ERROR_SQL_EXCEPTION_INT;
		}
		try {
			// create new statement
			prepared = connection.prepareStatement(sql);

			// set 1 param to statement
			for (SqlParameter param : params) {
				prepared.setObject(param.getNumber(), param.getValues());
			}

			// execute Query Update
			int result = prepared.executeUpdate();
			//connection.commit();

			// return row change
			return result;

		} catch (SQLException e) {
			System.out.println(e);
			return Constant.ERROR_SQL_EXCEPTION_INT;
		}
	}

}
