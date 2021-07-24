package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbConnection;
import db.DbException;
import db.DbIntegrityException;

import model.dao.RuleGroupDao;
import model.entities.RuleGroup;


public class RuleGroupDaoJDBC implements RuleGroupDao {

	private Connection conn;

	public RuleGroupDaoJDBC(Connection conn) {
			this.conn = conn;
		}

	@Override
	public RuleGroup findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM RuleGroup WHERE rgId = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				RuleGroup obj = new RuleGroup();
				obj.setRgId(rs.getInt("rgId"));
				obj.setRgName(rs.getString("rgName"));
				obj.setRgCsvFileName(rs.getString("rgCsvFileName"));
				obj.setRgDelimiter(rs.getString("rgDelimiter"));
				obj.setRgCharSet(rs.getString("rgCharset"));
				obj.setRgDate(rs.getString("rgDate"));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DbConnection.closeStatement(st);
			DbConnection.closeResultSet(rs);
		}
	
	}

	@Override
	public List<RuleGroup> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM RuleGroup ORDER BY rgName");
			rs = st.executeQuery();

			List<RuleGroup> list = new ArrayList<>();

			while (rs.next()) {
				RuleGroup obj = new RuleGroup();
				obj.setRgId(rs.getInt("rgId"));
				obj.setRgName(rs.getString("rgName"));
				obj.setRgCsvFileName(rs.getString("rgCsvFileName"));
				obj.setRgDelimiter(rs.getString("rgDelimiter"));
				obj.setRgCharSet(rs.getString("rgCharset"));
				obj.setRgDate(rs.getString("rgDate"));
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DbConnection.closeStatement(st);
			DbConnection.closeResultSet(rs);
		}
	
	}

	@Override
	public void insert(RuleGroup obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO RuleGroup " + "(rgId, rgName, rgCsvFileName, rgDelimiter, rgCharset, rgDate) " 
		                                                        + "VALUES "  + "(null, ?, ?, ?, ?. ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getRgName());
			st.setString(2, obj.getRgCsvFileName());
			st.setString(3, obj.getRgDelimiter());
			st.setString(4, obj.getRgCharSet());
			st.setString(5, obj.getRgDate());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setRgId(id);
				}
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DbConnection.closeStatement(st);
		}
	}

	@Override
	public void update(RuleGroup obj) {
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE RuleGroup " + "SET rgName = ?, rgCsvFileName = ?, rgDelimiter = ?, "
		                                                   +  " rgCharset = ?, rgDate = ? " + "WHERE rgId = ?");

			st.setString(2, obj.getRgName());
			st.setString(3, obj.getRgCsvFileName());
			st.setString(4, obj.getRgDelimiter());
			st.setString(5, obj.getRgCharSet());
			st.setString(6, obj.getRgDate());

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DbConnection.closeStatement(st);
		}
	
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM RuleGroup WHERE rgId = ?");

			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DbConnection.closeStatement(st);
		}
	}
}

