package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Rule;

public class RuleService {

	public List<Rule> findAll() {
		List<Rule> list = new ArrayList<>();
		list.add(new Rule(1, "Regra 1", "(name < 10)", "true", "Regra para analisar se nome existe", true));
		list.add(new Rule(2, "Regra 2", "(name < 10 && age > 18)", "false", "Regra para analisar se cliente é maior", true));
		list.add(new Rule(3, "Regra 3", "(age > 18 && credit == 'good')", "true", "Regra para analisar qualidade do crédito", true));
		
		return list;
	}
}
