package com.vti.template.utils.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.mysql.cj.util.StringUtils;
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
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;

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
	 * @throws SQLException
	 */
	private void connect() throws SQLException {
		try {
			// if connect is null or close then connect again
			if (null == connection || connection.isClosed()) {
				
				// load the properties file
				Properties properties = new Properties();
				properties.load(new FileInputStream("resources/database.properties"));
				
				// read the property
				String driverSQLName = properties.getProperty("driverSQLName");
				String connectionString = properties.getProperty("connectionString");
				String username = properties.getProperty("username");
				String password = properties.getProperty("password");
				
				// register the driver class with DriverManager
				Class.forName(driverSQLName);

				// open connect
				connection = DriverManager.getConnection(connectionString, username, password);
			}
		} catch (IOException e){
			throw new SQLException(Constant.ERROR_LOAD_FILE_DATABASE_PROPERTIES);
		} catch (SQLException e) {
			throw new SQLException(Constant.ERROR_CONNECT_DATABASE_STR);
		} catch (ClassNotFoundException e) {
			throw new SQLException(Constant.ERROR_DRIVER_NAME);
		}
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
	public void disconnect() /* throws SQLException */ {
		try {
			// if connect is a connection then disconnect
			if (null != connection && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(Constant.ERROR_DISCONNECT_DATABASE_STR);
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
	public ResultSet selectStatement(String sql) throws SQLException {
		// validate sql statement
		if (StringUtils.isNullOrEmpty(sql)) {
			throw new SQLException(Constant.ERROR_SQL_STATEMENT_IS_NULL);
		}

		// Connect to database
		connect();

		// if has connect then create new statement
		statement = connection.createStatement();

		// execute Query
		return statement.executeQuery(sql);
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
	 * @return either (1) the row count for SQL Data Manipulation Language (DML)
	 *         statements or (2) 0 for SQL statements that return nothing
	 */
	public int updateStatement(String sql) throws SQLException {
		// validate sql statement
		if (StringUtils.isNullOrEmpty(sql)) {
			throw new SQLException(Constant.ERROR_SQL_STATEMENT_IS_NULL);
		}

		// Connect to database
		connect();

		// if has connect then create new statement
		statement = connection.createStatement();

		// execute update query
		return statement.executeUpdate(sql);
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
	 * @throws SQLException
	 */
	public ResultSet selectPreparationStatement(String sql, List<SqlParameter> params) throws SQLException {
		// validate sql statement
		if (StringUtils.isNullOrEmpty(sql)) {
			throw new SQLException(Constant.ERROR_SQL_STATEMENT_IS_NULL);
		}

		// validate parameters
		if (params == null || params.size() == 0) {
			throw new SQLException(Constant.ERROR_SQL_PARAMETER_MUST_NON_EMPTY);
		}

		// Connect to database
		connect();

		// if has connect then create new statement
		preparedStatement = connection.prepareStatement(sql);

		// set parameters to statement
		for (SqlParameter param : params) {
			preparedStatement.setObject(param.getIndex(), param.getValue());
		}

		// execute Query
		return preparedStatement.executeQuery();
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
	 * @return either (1) the row count for SQL Data Manipulation Language (DML)
	 *         statements or (2) 0 for SQL statements that return nothingF
	 */
	public int updatePreparationStatement(String sql, List<SqlParameter> params) throws SQLException {
		// validate sql statement
		if (StringUtils.isNullOrEmpty(sql)) {
			throw new SQLException(Constant.ERROR_SQL_STATEMENT_IS_NULL);
		}

		// validate parameters
		if (params == null || params.size() == 0) {
			throw new SQLException(Constant.ERROR_SQL_PARAMETER_MUST_NON_EMPTY);
		}

		// Connect to database
		connect();

		// if has connect then create new statement
		preparedStatement = connection.prepareStatement(sql);

		// set 1 param to statement
		for (SqlParameter param : params) {
			preparedStatement.setObject(param.getIndex(), param.getValue());
		}

		// execute Update Query
		return preparedStatement.executeUpdate();
	}

	/**
	 * This method call procedure
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 13, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 13, 2020
	 * @param callProcedureSQL
	 *            - statement call procedure sql
	 * @param inParams
	 * @param outParams
	 * 
	 * @return CallableStatement
	 * @throws SQLException
	 */
	public CallableStatement callProcedure(
			String callProcedureSQL, 
			List<SqlProcedureParameter.In> inParams,
			List<SqlProcedureParameter.Out> outParams) throws SQLException {

		// validate procedure sql
		if (StringUtils.isNullOrEmpty(callProcedureSQL)) {
			throw new SQLException(Constant.ERROR_SQL_PROCEDURE_NAME_IS_NULL);
		}

		// Connect to database
		connect();

		// if has connect then create new procedure statement
		callableStatement = connection.prepareCall(callProcedureSQL);

		// set in parameters to statement
		if (inParams != null) {
			// set in parameters to statement
			for (SqlProcedureParameter.In param : inParams) {
				callableStatement.setObject(param.getNameParameter(), param.getValues());
			}
		}

		// set out parameters to statement
		if (outParams != null) {
			for (SqlProcedureParameter.Out param : outParams) {
				callableStatement.registerOutParameter(param.getNameParameter(), param.getTypeSql());
			}
		}

		// execute Query
		callableStatement.execute();
		return callableStatement;
	}
	
	/**
	 * This method is turn on transaction. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 14, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 14, 2020
	 * @throws SQLException
	 */
	public void beginTransaction()/* throws SQLException*/{
		try{
			// Connect to database
			connect();
			
			// turn off auto commit
			connection.setAutoCommit(false);
			System.out.println("BEGIN TRANSACTION");
		}catch(SQLException e){
			System.out.println(Constant.ERROR_TRANSACTION_BEGIN);
			// throw new SQLException(Constant.ERROR_TRANSACTION_BEGIN);
		}
	}
	
	/**
	 * This method is turn off transaction. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 14, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 14, 2020
	 * @throws SQLException
	 */
	public void endTransaction() /*throws SQLException*/{
		try{
			// Connect to database
			connect();

			// turn off auto commit
			connection.setAutoCommit(true);
			System.out.println("END TRANSACTION");
		}catch(SQLException e){
			System.out.println(Constant.ERROR_TRANSACTION_END);
			//throw new SQLException(Constant.ERROR_TRANSACTION_END);
		}
	}
	
	/**
	 * This method is rollback transaction. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 14, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 14, 2020
	 * @throws SQLException
	 */
	public void rollbackTransaction() /*throws SQLException*/{
		try{
			// Connect to database
			connect();
			
			// rollback transaction
			connection.rollback();
			System.out.println("ROLLBACK");
		}catch(SQLException e){
			System.out.println(Constant.ERROR_TRANSACTION_ROLLBACK);
			//throw new SQLException(Constant.ERROR_TRANSACTION_ROLLBACK);
		}
	}
	
	/**
	 * This method is commit transaction. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 14, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 14, 2020
	 * @throws SQLException
	 */
	public void commitTransaction() /*throws SQLException*/{
		try{
			// Connect to database
			connect();
		
			// commit transaction
			connection.commit();
			System.out.println("COMMIT");
		}catch(SQLException e){
			System.out.println(Constant.ERROR_TRANSACTION_COMMIT);
			//throw new SQLException(Constant.ERROR_TRANSACTION_COMMIT);
		}
	}


}
