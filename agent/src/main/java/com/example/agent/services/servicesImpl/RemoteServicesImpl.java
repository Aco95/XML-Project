package com.example.agent.services.servicesImpl;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent.demoModel.DemoServicePort;
import com.example.agent.demoModel.DemoServicePortService;
import com.example.agent.demoModel.GetAllSmestajRequest;
import com.example.agent.demoModel.GetAllSmestajResponse;
import com.example.agent.entities.Rezervacija;
import com.example.agent.entities.Smestaj;
import com.example.agent.entities.Soba;
import com.example.agent.repositories.RezervacijaRepository;
import com.example.agent.repositories.SmestajRepository;
import com.example.agent.repositories.SobaRepository;
import com.example.agent.services.IRemoteServices;
import com.example.agent.services.RezervacijaService;
import com.example.agent.services.SobaService;

@Service
public class RemoteServicesImpl implements IRemoteServices{
	@Autowired
	private SmestajRepository smestajRepository ;
	
	@Autowired
	private SobaRepository sobaRepository;
	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	public void  getAllSmestajByAgent(String agentId){

		DemoServicePortService demoServicePortService = new DemoServicePortService();
		DemoServicePort port = demoServicePortService.getDemoServicePortSoap11();
		GetAllSmestajRequest getAllSmestajRequest = new GetAllSmestajRequest();
		getAllSmestajRequest.setAgentId(agentId);

			System.out.println(getAllSmestajRequest.getAgentId());
			GetAllSmestajResponse getSmestajResponse = port.getAllSmestaj(getAllSmestajRequest);
			
			List<com.example.agent.demoModel.Smestaj> listSmestajDemo = getSmestajResponse.getSmestajList();
			ModelMapper modelMapper =new ModelMapper();
			for(com.example.agent.demoModel.Smestaj smestajDemo:listSmestajDemo) {
				Smestaj smestaj=modelMapper.map(smestajDemo, Smestaj.class);

				for(Soba soba:smestaj.getSobe()) {
					sobaRepository.save(soba);
					for(Rezervacija rezervacija: soba.getRezervacije()) {
						rezervacijaRepository.save(rezervacija);
					}
				}
				smestajRepository.save(smestaj);
			}

	}

}
