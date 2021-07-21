package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Rule implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String ruleName;
	private String booleanExpression;
	private String valueReturn;
	private String description;
	
	public Rule() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getBooleanExpression() {
		return booleanExpression;
	}

	public void setBooleanExpression(String booleanExpression) {
		this.booleanExpression = booleanExpression;
	}

	public String getValueReturn() {
		return valueReturn;
	}

	public void setValueReturn(String valueReturn) {
		this.valueReturn = valueReturn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ruleName);
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
		return Objects.equals(id, other.id) && Objects.equals(ruleName, other.ruleName);
	}

	@Override
	public String toString() {
		return "Rule [id=" + id + ", ruleName=" + ruleName + ", booleanExpression=" + booleanExpression
				+ ", valueReturn=" + valueReturn + ", description=" + description + "]";
	}
		
}
