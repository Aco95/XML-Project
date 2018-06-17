package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminKorisnikDto;
import com.example.demo.dto.AgentRegisterDto;
import com.example.demo.entities.Korisnik;
import com.example.demo.entities.Uloga;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImp implements IAdminService {

	@Autowired
	AdminRepository  adminRepository;
	
	@Override
	public List<AdminKorisnikDto> getAllKorisnik() {
		ModelMapper modelMapper=new ModelMapper();
		List<Korisnik> korisnici=adminRepository.findAll();
		List<AdminKorisnikDto> korisniciDto=new ArrayList<AdminKorisnikDto>();
		for(Korisnik korisnik : korisnici) {
			korisniciDto.add(modelMapper.map(korisnik, AdminKorisnikDto.class));
		}
		return korisniciDto;
		
	}
	@Override
	public void promeniStatusKorisnik(String id,boolean blokiran) {
		Optional<Korisnik> korisnik=adminRepository.findById(id);
		korisnik.get().setBlokiran(blokiran);
		adminRepository.save(korisnik.get());
		return;
	}

	@Override
	public void obrisiKorisnik(String id) {
		adminRepository.deleteById(id);
		return;
	}

	@Override
	public void registrujAgenta(AgentRegisterDto agentRegisterDto) {
		Korisnik agent=new Korisnik();
		agent.setUloga(Uloga.AGENT);
		agent.setAdresa(agentRegisterDto.getAdresa());
		agent.setIme(agentRegisterDto.getIme());
		agent.setPrezime(agentRegisterDto.getPrezime());
		agent.setMaticniBroj(agentRegisterDto.getMaticniBroj());
		adminRepository.save(agent);
	}
	
	
	
}
