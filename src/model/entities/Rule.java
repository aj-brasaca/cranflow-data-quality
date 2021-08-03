package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Rule implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer rlId;
	private String rlName;
	private String rlExpression;
	private String rlValueReturn;
	private String rlDescription;
	//private Integer rlActiveRule;
	private String rlActiveRule;
	//private RuleGroup ruleGroup;
	private String rlGroup;
	
	public Rule() {
	}
	
	public Rule(Integer rlId, String rlName, String rlExpression, String rlValueReturn, String rlDescription,
			String rlActiveRule, String rlGroup) {
		this.rlId = rlId;
		this.rlName = rlName;
		this.rlExpression = rlExpression;
		this.rlValueReturn = rlValueReturn;
		this.rlDescription = rlDescription;
		this.rlActiveRule = rlActiveRule;
		this.rlGroup = rlGroup;
	}

	public Integer getRlId() {
		return rlId;
	}

	public void setRlId(Integer rlId) {
		this.rlId = rlId;
	}

	public String getRlName() {
		return rlName;
	}

	public void setRlName(String rlName) {
		this.rlName = rlName;
	}

	public String getRlExpression() {
		return rlExpression;
	}

	public void setRlExpression(String rlExpression) {
		this.rlExpression = rlExpression;
	}

	public String getRlValueReturn() {
		return rlValueReturn;
	}

	public void setRlValueReturn(String rlValueReturn) {
		this.rlValueReturn = rlValueReturn;
	}

	public String getRlDescription() {
		return rlDescription;
	}

	public void setRlDescription(String rlDescription) {
		this.rlDescription = rlDescription;
	}

	public String getRlActiveRule() {
		return rlActiveRule;
	}

	public void setRlActiveRule(String rlActiveRule) {
		this.rlActiveRule = rlActiveRule;
	}

	/*
	 * public RuleGroup getRuleGroup() { return ruleGroup; }
	 * 
	 * public void setRuleGroup(RuleGroup ruleGroup) { this.ruleGroup = ruleGroup; }
	 */
	
	public String getRlGroup() {
		return rlGroup;
	}

	public void setRlGroup(String rlGroup) {
		this.rlGroup = rlGroup;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rlId, rlName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule other = (Rule) obj;
		return Objects.equals(rlId, other.rlId) && Objects.equals(rlName, other.rlName);
	}



	/*
	 * @Override public String toString() { return "Rule [rlId=" + rlId +
	 * ", rlName=" + rlName + ", rlExpression=" + rlExpression + ", rlValueReturn="
	 * + rlValueReturn + ", rlDescription=" + rlDescription + ", rlActiveRule=" +
	 * rlActiveRule + ", ruleGroup=" + ruleGroup + "]"; }
	 */
		
}
