package com.example.agent.dtos;

import javax.xml.datatype.XMLGregorianCalendar;

import com.example.agent.entities.Soba;

public class SobaDTO {

	
	private Soba soba;
	private String from;
	private String to;
	public Soba getSoba() {
		return soba;
	}
	public void setSoba(Soba soba) {
		this.soba = soba;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public SobaDTO(Soba soba, String from, String to) {
		super();
		this.soba = soba;
		this.from = from;
		this.to = to;
	}
	public SobaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
