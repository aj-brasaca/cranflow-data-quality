package model.dao;

import java.util.List;

import model.entities.Rule;
import model.entities.RuleGroup;

public interface RuleDao {

	void insert(Rule obj);
	void update(Rule obj);
	void deleteById(Integer id);
	Rule findById(Integer id);
	List<Rule> findAll();
	List<Rule> findByRuleGroup(RuleGroup ruleGroup);

}
