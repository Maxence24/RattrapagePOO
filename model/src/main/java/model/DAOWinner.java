package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.entity.mobileelements.MobileElements;

public class DAOWinner {
	
	private final Connection connection;
	
	public DAOWinner(final Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	protected Connection getConnection() {
		return this.connection;
	}


	public MobileElements NewWinner(String Winner) {
		try {
			final String sql = "{call NewWinner(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, Winner);
			call.execute();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}