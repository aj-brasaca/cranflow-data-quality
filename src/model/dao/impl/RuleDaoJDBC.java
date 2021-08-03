package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DbConnection;
import db.DbException;
import model.dao.RuleDao;
import model.entities.Rule;
import model.entities.RuleGroup;

public class RuleDaoJDBC implements RuleDao {

	private Connection conn;

	public RuleDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Rule obj) {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO Rule "
					+ "(rlId, rlName, rlExpression, rlReturnValue, rlDescription, rlActiveRule, rlGroupId) " + "VALUES "
					+ "(null, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getRlName());
			st.setString(2, obj.getRlExpression());
			st.setString(3, obj.getRlValueReturn());
			st.setString(4, obj.getRlDescription());
			st.setString(5, obj.getRlActiveRule());
			//st.setInt(6, obj.getRuleGroup().getRgId());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setRlId(id);
				}
				DbConnection.closeResultSet(rs);
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
	public void update(Rule obj) {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE Rule "
					+ "SET rlName = ?, rlExpression = ?, rlReturnValue = ?, rlDescription = ?, rlActiveRule = ?, rlGroupId = ? "
					+ "WHERE rlId = ?");

			st.setString(1, obj.getRlName());
			st.setString(2, obj.getRlExpression());
			st.setString(3, obj.getRlValueReturn());
			st.setString(4, obj.getRlDescription());
			st.setString(5, obj.getRlActiveRule());
			//st.setInt(5, obj.getRuleGroup().getRgId());

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
			st = conn.prepareStatement("DELETE FROM Rule WHERE rlId = ?");

			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DbConnection.closeStatement(st);
		}

	}

	@Override
	public Rule findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT Rule.*, RuleGroup.rgName as rgName " + "FROM Rule INNER JOIN RuleGroup "
					+ "ON Rule.rlGroupId = RuleGroup.rgId " + "WHERE Rule.rlId = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				RuleGroup group = instantiateRuleGroup(rs);
				Rule obj = instantiateRule(rs, group);
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

	private Rule instantiateRule(ResultSet rs, RuleGroup group) throws SQLException {
		Rule obj = new Rule();
		obj.setRlId(rs.getInt("rlId"));
		obj.setRlName(rs.getString("rlName"));
		obj.setRlExpression(rs.getString("rlExpression"));
		obj.setRlValueReturn(rs.getString("rlReturnValue"));
		obj.setRlDescription(rs.getString("rlDescription"));
		obj.setRlActiveRule(rs.getString("rlActiveRule"));
		//obj.setRuleGroup(group);
		return obj;
	}

	private RuleGroup instantiateRuleGroup(ResultSet rs) throws SQLException {
		RuleGroup group = new RuleGroup();
		group.setRgId(rs.getInt("rgId"));
		group.setRgName(rs.getString("rgName"));
		group.setRgCsvFileName(rs.getString("rgCsvFileName"));
		group.setRgDelimiter(rs.getString("rgDelimiter"));
		group.setRgCharSet(rs.getString("rgCharset"));
		group.setRgDate(rs.getString("rgDate"));
		return group;
	}

	@Override
	public List<Rule> findAll() {

		List<Rule> list = Arrays.asList(
			(new Rule( 1, "Regra 1", "nomePaciente == 0 && nomeMae < 10", "true", "Nome do paciente igual e nome mãe semelhante", "true", "Grupo 1")),
			(new Rule( 2, "Regra 2", "nomePaciente < 10 && nomeMae < 10 && gemeo == 'não'", "true", "Nome do paciente e mãe semelhantes, gêmeo", "false", "Grupo 1")),
			(new Rule( 3, "Regra 3", "nomePaciente < 10 && gemeo == 'sim'", "true", "Nome do paciente semelhante e gêmeo", "true", "Grupo 1")));
		
		return list;
		
		
		/*
		 * PreparedStatement st = null; ResultSet rs = null;
		 * 
		 * try { st = conn.prepareStatement(
		 * "SELECT RuleGroup.rgName, Rule.* FROM RuleGroup INNER JOIN Rule " +
		 * "ON RuleGroup.rgId = Rule.rlGroupId ORDER BY rgName");
		 * "SELECT Rule.*, RuleGroup.* FROM Rule INNER JOIN RuleGroup " +
		 * "ON Rule.rlGroupId = RuleGroup.rgId ORDER BY rgName");
		 * 
		 * rs = st.executeQuery();
		 * 
		 * List<Rule> list = new ArrayList<>();
		 */

		/*
		 * Map<Integer, RuleGroup> map = new HashMap<>();
		 * 
		 * while (rs.next()) {
		 * 
		 * System.out.println(rs);
		 * 
		 * RuleGroup group = map.get(rs.getInt("rlGroupId"));
		 * 
		 * if (group == null) { group = instantiateRuleGroup(rs);
		 * map.put(rs.getInt("rlGroupId"), group); }
		 */

	/*
	 * Rule obj = instantiateRule(rs, group);
	 * 
	 * list.add(obj);
	 * 
	 * // }
	 * 
	 * return list; }catch(
	 * 
	 * SQLException e) { throw new DbException(e.getMessage()); }finally {
	 * DbConnection.closeStatement(st); DbConnection.closeResultSet(rs); } }
	 */
		
	}

	@Override
	public List<Rule> findByRuleGroup(RuleGroup ruleGroup) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT Rule.*, RuleGroup.rgName as groupName " + "FROM Rule INNER JOIN RuleGroup "
							+ "ON Rule.rlGroupId = RuleGroup.rgId " + "WHERE rgId = ? " + "ORDER BY rlName");

			st.setInt(1, ruleGroup.getRgId());

			rs = st.executeQuery();

			List<Rule> list = new ArrayList<>();
			Map<Integer, RuleGroup> map = new HashMap<>();

			while (rs.next()) {

				RuleGroup group = map.get(rs.getInt("rgId"));

				if (group == null) {
					group = instantiateRuleGroup(rs);
					map.put(rs.getInt("rgId"), group);
				}

				Rule obj = instantiateRule(rs, group);
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

}
