package com.ifma.locaimovel.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ifma.locaimovel.entiteis.Cliente;
import com.ifma.locaimovel.repositoreies.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner  {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null, "Maria Brown", "44568723456", "2015-09-04");
		Cliente c2 = new Cliente(null, "Alex Green", "98566324561", "2000-10-12"); 
		
		//salvar os dois objetos no banco de dados usando o ClinteRepository
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
	}
	
	
}
