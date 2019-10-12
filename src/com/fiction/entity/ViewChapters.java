package com.fiction.entity;

import java.util.List;


public class ViewChapters {
	private int text_Id;
	private String text_Title;
	private String text_Content;
	private String text_Name;
	public ViewChapters() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViewChapters(int text_Id, String text_Title, String text_Content,
			String text_Name) {
		super();
		this.text_Id = text_Id;
		this.text_Title = text_Title;
		this.text_Content = text_Content;
		this.text_Name = text_Name;
	}
	public int getText_Id() {
		return text_Id;
	}
	public void setText_Id(int text_Id) {
		this.text_Id = text_Id;
	}
	public String getText_Title() {
		return text_Title;
	}
	public void setText_Title(String text_Title) {
		this.text_Title = text_Title;
	}
	public String getText_Content() {
		return text_Content;
	}
	public void setText_Content(String text_Content) {
		this.text_Content = text_Content;
	}
	public String getText_Name() {
		return text_Name;
	}
	public void setText_Name(String text_Name) {
		this.text_Name = text_Name;
	}
	
	
}
