package com.example.demo.DTO;

import java.util.List;

import com.example.demo.entities.Smestaj;

public class RezultatPretrageDTO {
	
	private List<Smestaj> trazeniSmestaji;
	
	private boolean greska;
	

	public List<Smestaj> getTrazeniSmestaji() {
		return trazeniSmestaji;
	}

	public void setTrazeniSmestaji(List<Smestaj> trazeniSmestaji) {
		this.trazeniSmestaji = trazeniSmestaji;
	}

	public boolean isGreska() {
		return greska;
	}

	public void setGreska(boolean greska) {
		this.greska = greska;
	}

	public RezultatPretrageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RezultatPretrageDTO(List<Smestaj> trazeniSmestaji, boolean greska) {
		super();
		this.trazeniSmestaji = trazeniSmestaji;
		this.greska = greska;
	}
	
	

}
