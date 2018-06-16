package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AdminKorisnikDto;
import com.example.demo.dto.AgentRegisterDto;

public interface IAdminService {

	public List<AdminKorisnikDto> getAllKorisnik();
	public void blokKorisnik(int id);
	public void aktivirajKorisnik(int id);
	public void obrisiKorisnik(int id);
	public void registrujAgenta(AgentRegisterDto agentRegisterDto);
}
