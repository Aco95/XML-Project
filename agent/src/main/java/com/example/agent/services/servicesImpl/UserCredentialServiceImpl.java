package com.example.agent.services.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent.demoModel.DemoServicePort;
import com.example.agent.demoModel.DemoServicePortService;
import com.example.agent.demoModel.GetUserCredentialRequest;
import com.example.agent.demoModel.GetUserCredentialResponse;
import com.example.agent.entities.Korisnik;
import com.example.agent.entities.UserCredential;
import com.example.agent.repositories.UserCredentialRepository;
import com.example.agent.services.IUserCredentialService;


@Service
public class UserCredentialServiceImpl implements IUserCredentialService{

	@Autowired
	private UserCredentialRepository userCredentialRepository; 
	
	@Override
	public Optional<UserCredential> getUserByEmail(String email) {
		Optional<UserCredential> korisnik =userCredentialRepository.findOneByEmail(email);
		System.out.println("korisnik servis***");
		return korisnik;
	}

	@Override
	public boolean checkEmail(String email) {
		boolean rezultat=true;

		UserCredential userCredential=null;
		try {
			userCredential=userCredentialRepository.findOneByEmail(email).get();
		} catch (Exception e1) {
			DemoServicePortService demoServicePortService = new DemoServicePortService();
			DemoServicePort port = demoServicePortService.getDemoServicePortSoap11();
			GetUserCredentialRequest getUserCredentialRequest = new GetUserCredentialRequest();
			getUserCredentialRequest.setEmail(email);
		
			try {
				System.out.println(getUserCredentialRequest.getEmail());
				GetUserCredentialResponse getSmestajResponse = port.getUserCredential(getUserCredentialRequest);
				
				com.example.agent.demoModel.UserCredential userCredentialDemo = getSmestajResponse.getUserCredential();
				UserCredential userCredentialAgent=new UserCredential();
				userCredentialAgent.setEmail(userCredentialDemo.getEmail());
				userCredentialAgent.setId(userCredentialDemo.getId());
				userCredentialAgent.setPassword(userCredentialDemo.getPassword());
				userCredentialRepository.save(userCredentialAgent);
				rezultat =true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				rezultat=false;
				return rezultat;
			}
			
		}
	
		return rezultat;
	}
}
