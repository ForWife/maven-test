package com.neu.po;

//参数映射时，不是必填属性时，int ->Integer
public class Userinfo {
	private Integer user_id;
	private String user_name;
	private String pwd;
	private String other;
	private Integer number;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
