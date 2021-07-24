package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class RuleGroup implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer rgId;
	private String rgName;
	private String rgCsvFileName;
	private String rgDelimiter;
	private String rgCharset;
	private String rgDate;
	
	public RuleGroup() {
	}

	public RuleGroup(Integer rgId, String rgName, String rgCsvFileName, String rgDelimiter, String rgCharset,
			String rgDate) {
		this.rgId = rgId;
		this.rgName = rgName;
		this.rgCsvFileName = rgCsvFileName;
		this.rgDelimiter = rgDelimiter;
		this.rgCharset = rgCharset;
		this.rgDate = rgDate;
	}

	public Integer getRgId() {
		return rgId;
	}

	public void setRgId(Integer rgId) {
		this.rgId = rgId;
	}

	public String getRgName() {
		return rgName;
	}

	public void setRgName(String rgName) {
		this.rgName = rgName;
	}

	public String getRgCsvFileName() {
		return rgCsvFileName;
	}

	public void setRgCsvFileName(String rgCsvFileName) {
		this.rgCsvFileName = rgCsvFileName;
	}

	public String getRgDelimiter() {
		return rgDelimiter;
	}

	public void setRgDelimiter(String rgDelimiter) {
		this.rgDelimiter = rgDelimiter;
	}

	public String getRgCharSet() {
		return rgCharset;
	}

	public void setRgCharSet(String rgCharset) {
		this.rgCharset = rgCharset;
	}

	public String getRgDate() {
		return rgDate;
	}

	public void setRgDate(String rgDate) {
		this.rgDate = rgDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rgId, rgName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuleGroup other = (RuleGroup) obj;
		return Objects.equals(rgId, other.rgId) && Objects.equals(rgName, other.rgName);
	}

	@Override
	public String toString() {
		return "RuleGroup [rgId=" + rgId + ", rgName=" + rgName + ", rgCsvFileName=" + rgCsvFileName + ", rgDelimiter="
				+ rgDelimiter + ", rgCharset=" + rgCharset + ", rgDate=" + rgDate + "]";
	}
		
}
