package com.mmd.MMDSpringboot.model;

import java.io.Serializable;

public class DataId implements Serializable {

	private int projectid;
	private int rowid;
	private String columnname;
	
	public DataId() {}
	public DataId(int projectid, int rowid, String columnname) {
		this.projectid = projectid;this.rowid = rowid;this.columnname = columnname;}
	
	public int getProjectid() {return projectid;}
	public void setProjectid(int projectid) {this.projectid = projectid;}
	
	public int getRowid() {return rowid;}
	public void setRowid(int rowid) {this.rowid = rowid;}
	
	public String getColumnname() {return columnname;}
	public void setColumnname(String columnname) {this.columnname = columnname;}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columnname == null) ? 0 : columnname.hashCode());
		result = prime * result + projectid;
		result = prime * result + rowid;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataId other = (DataId) obj;
		if (columnname == null) {
			if (other.columnname != null)
				return false;
		} else if (!columnname.equals(other.columnname))
			return false;
		if (projectid != other.projectid)
			return false;
		if (rowid != other.rowid)
			return false;
		return true;
	}
	
	
	
	
	
}
