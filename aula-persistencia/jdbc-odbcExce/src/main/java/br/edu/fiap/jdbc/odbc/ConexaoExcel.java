package br.edu.fiap.jdbc.odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoExcel {
	private Connection connection;

	/***
	 * Metodo responsavel por conectar ao Excel
	 * @return {@link Connection}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		connection = DriverManager.getConnection("jdbc:odbc:odbcExcel");
		return connection;
	}

}
