package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AdminKorisnikDto;
import com.example.demo.dto.AgentRegisterDto;

public interface IAdminService {

	public List<AdminKorisnikDto> getAllKorisnik();
	public void promeniStatusKorisnik(String id,boolean blokiran);
	public void obrisiKorisnik(String id);
	public void registrujAgenta(AgentRegisterDto agentRegisterDto);
}
