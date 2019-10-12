package com.fiction.entity;

public class SelectFiction {
	private int selectqq_Id;
	private String selectqq_Name;
	private String selectqq_Writer;
	private String selectqq_Zuixin;
	private String selectqq_Time;
	private String selectqq_Jianjie;
	private String selectqq_Image;
	
	public SelectFiction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectFiction(int selectqq_Id, String selectqq_Name,
			String selectqq_Writer, String selectqq_Zuixin,
			String selectqq_Time, String selectqq_Jianjie, String selectqq_Image) {
		super();
		this.selectqq_Id = selectqq_Id;
		this.selectqq_Name = selectqq_Name;
		this.selectqq_Writer = selectqq_Writer;
		this.selectqq_Zuixin = selectqq_Zuixin;
		this.selectqq_Time = selectqq_Time;
		this.selectqq_Jianjie = selectqq_Jianjie;
		this.selectqq_Image = selectqq_Image;
	}

	public SelectFiction(String selectqq_Name, String selectqq_Writer,
			String selectqq_Zuixin, String selectqq_Time,
			String selectqq_Jianjie, String selectqq_Image) {
		super();
		this.selectqq_Name = selectqq_Name;
		this.selectqq_Writer = selectqq_Writer;
		this.selectqq_Zuixin = selectqq_Zuixin;
		this.selectqq_Time = selectqq_Time;
		this.selectqq_Jianjie = selectqq_Jianjie;
		this.selectqq_Image = selectqq_Image;
	}
	

	public SelectFiction(int selectqq_Id, String selectqq_Name,
			String selectqq_Writer, String selectqq_Zuixin,
			String selectqq_Time, String selectqq_Jianjie) {
		super();
		this.selectqq_Id = selectqq_Id;
		this.selectqq_Name = selectqq_Name;
		this.selectqq_Writer = selectqq_Writer;
		this.selectqq_Zuixin = selectqq_Zuixin;
		this.selectqq_Time = selectqq_Time;
		this.selectqq_Jianjie = selectqq_Jianjie;
	}

	public int getSelectqq_Id() {
		return selectqq_Id;
	}

	public void setSelectqq_Id(int selectqq_Id) {
		this.selectqq_Id = selectqq_Id;
	}

	public String getSelectqq_Name() {
		return selectqq_Name;
	}

	public void setSelectqq_Name(String selectqq_Name) {
		this.selectqq_Name = selectqq_Name;
	}

	public String getSelectqq_Writer() {
		return selectqq_Writer;
	}

	public void setSelectqq_Writer(String selectqq_Writer) {
		this.selectqq_Writer = selectqq_Writer;
	}

	public String getSelectqq_Zuixin() {
		return selectqq_Zuixin;
	}

	public void setSelectqq_Zuixin(String selectqq_Zuixin) {
		this.selectqq_Zuixin = selectqq_Zuixin;
	}

	public String getSelectqq_Time() {
		return selectqq_Time;
	}

	public void setSelectqq_Time(String selectqq_Time) {
		this.selectqq_Time = selectqq_Time;
	}

	public String getSelectqq_Jianjie() {
		return selectqq_Jianjie;
	}

	public void setSelectqq_Jianjie(String selectqq_Jianjie) {
		this.selectqq_Jianjie = selectqq_Jianjie;
	}

	public String getSelectqq_Image() {
		return selectqq_Image;
	}

	public void setSelectqq_Image(String selectqq_Image) {
		this.selectqq_Image = selectqq_Image;
	}
	
	
}