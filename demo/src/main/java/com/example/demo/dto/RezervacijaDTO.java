package com.example.demo.dto;

public class RezervacijaDTO {
	
	private String room_id;
	private String dateFrom;
	private String dateTo;
	private String user_id;
	
	
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	public RezervacijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RezervacijaDTO(String room_id, String dateFrom, String dateTo, String user_id) {
		super();
		this.room_id = room_id;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.user_id = user_id;
	}
	
	
	

}
