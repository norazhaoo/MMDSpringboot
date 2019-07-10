package com.mmd.MMDSpringboot.column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ColumnModel {

	@Id
	@GeneratedValue
	private Long columnid;
	
	private String columnname;
	private String columntype;
	public Long getColumnid() {
		return columnid;
	}
	public void setColumnid(Long columnid) {
		this.columnid = columnid;
	}
	public String getColumnname() {
		return columnname;
	}
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}
	public String getColumntype() {
		return columntype;
	}
	public void setColumntype(String columntype) {
		this.columntype = columntype;
	}
	
	@Override
	public String toString() {
		return "ColumnModel [columnid=" + columnid + ", columnname=" + columnname + ", columntype=" + columntype + "]";
	}
	

	
}
