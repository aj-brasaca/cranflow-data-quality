package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Center implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer ctId;
	private String ctCenterName;
	private String ctAccountableName;
	private String ctEmail;
	
	public Center() {
	}
	
	public Center(Integer ctId, String ctCenterName, String ctAccountableName, String ctEmail) {
		super();
		this.ctId = ctId;
		this.ctCenterName = ctCenterName;
		this.ctAccountableName = ctAccountableName;
		this.ctEmail = ctEmail;
	}

	public Integer getCtId() {
		return ctId;
	}

	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}

	public String getCtCenterName() {
		return ctCenterName;
	}

	public void setCtCenterName(String ctCenterName) {
		this.ctCenterName = ctCenterName;
	}

	public String getCtAccountableName() {
		return ctAccountableName;
	}

	public void setCtAccountableName(String ctAccountableName) {
		this.ctAccountableName = ctAccountableName;
	}

	public String getCtEmail() {
		return ctEmail;
	}

	public void setCtEmail(String ctEmail) {
		this.ctEmail = ctEmail;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ctCenterName, ctId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Center other = (Center) obj;
		return Objects.equals(ctCenterName, other.ctCenterName) && Objects.equals(ctId, other.ctId);
	}

}
