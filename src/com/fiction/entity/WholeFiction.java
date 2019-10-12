package com.fiction.entity;

public class WholeFiction {
	private int fiction_Id;
	private String fiction_Name;
	private String fiction_Writer;
	private int fiction_Hot;
	private String fiction_Status;
	private int fiction_Now;
	private String fiction_Time;
	
	public WholeFiction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WholeFiction(int fiction_Id, String fiction_Name,
			String fiction_Writer, int fiction_Hot, String fiction_Status,
			int fiction_Now, String fiction_Time) {
		super();
		this.fiction_Id = fiction_Id;
		this.fiction_Name = fiction_Name;
		this.fiction_Writer = fiction_Writer;
		this.fiction_Hot = fiction_Hot;
		this.fiction_Status = fiction_Status;
		this.fiction_Now = fiction_Now;
		this.fiction_Time = fiction_Time;
	}
	public WholeFiction(String fiction_Name, String fiction_Writer,
			String fiction_Status, int fiction_Now, String fiction_Time) {
		super();
		this.fiction_Name = fiction_Name;
		this.fiction_Writer = fiction_Writer;
		this.fiction_Status = fiction_Status;
		this.fiction_Now = fiction_Now;
		this.fiction_Time = fiction_Time;
	}
	public WholeFiction(int fiction_Id,String fiction_Name, String fiction_Writer,
			String fiction_Status, int fiction_Now, String fiction_Time) {
		super();
		this.fiction_Id = fiction_Id;
		this.fiction_Name = fiction_Name;
		this.fiction_Writer = fiction_Writer;
		this.fiction_Status = fiction_Status;
		this.fiction_Now = fiction_Now;
		this.fiction_Time = fiction_Time;
	}
	public int getFiction_Id() {
		return fiction_Id;
	}
	public void setFiction_Id(int fiction_Id) {
		this.fiction_Id = fiction_Id;
	}
	public String getFiction_Name() {
		return fiction_Name;
	}
	public void setFiction_Name(String fiction_Name) {
		this.fiction_Name = fiction_Name;
	}
	public String getFiction_Writer() {
		return fiction_Writer;
	}
	public void setFiction_Writer(String fiction_Writer) {
		this.fiction_Writer = fiction_Writer;
	}
	public int getFiction_Hot() {
		return fiction_Hot;
	}
	public void setFiction_Hot(int fiction_Hot) {
		this.fiction_Hot = fiction_Hot;
	}
	public String getFiction_Status() {
		return fiction_Status;
	}
	public void setFiction_Status(String fiction_Status) {
		this.fiction_Status = fiction_Status;
	}
	public int getFiction_Now() {
		return fiction_Now;
	}
	public void setFiction_Now(int fiction_Now) {
		this.fiction_Now = fiction_Now;
	}
	public String getFiction_Time() {
		return fiction_Time;
	}
	public void setFiction_Time(String fiction_Time) {
		this.fiction_Time = fiction_Time;
	}
}
