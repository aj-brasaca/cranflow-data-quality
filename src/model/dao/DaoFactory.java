package model.dao;

import db.DbConnection;
import model.dao.impl.RuleDaoJDBC;
import model.dao.impl.RuleGroupDaoJDBC;

public class DaoFactory {

	public static RuleDao createRuleDao() {
		return new RuleDaoJDBC(DbConnection.getConnection());
	}
	
	public static RuleGroupDao createRuleGroupDao() {
		return new RuleGroupDaoJDBC(DbConnection.getConnection());
	}
}
