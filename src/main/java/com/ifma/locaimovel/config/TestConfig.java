package com.ifma.locaimovel.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ifma.locaimovel.entiteis.Cliente;
import com.ifma.locaimovel.entiteis.Locacao;
import com.ifma.locaimovel.repositoreies.ClienteRepository;
import com.ifma.locaimovel.repositoreies.LocacaoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private LocacaoRepository locacaoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(null, "Maria Brown", "44568723456", "2015-09-04");
		Cliente c2 = new Cliente(null, "Alex Green", "98566324561", "2000-10-12");

		Locacao l1 = new Locacao(null, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"),c1);
		Locacao l2 = new Locacao(null, Instant.parse("2018-07-21T03:42:10Z"), Instant.parse("2019-07-21T03:42:10Z"),c2);
		Locacao l3 = new Locacao(null, Instant.parse("2017-07-22T15:21:22Z"), Instant.parse("2018-07-21T03:42:10Z"),c1);

		// salvar os dois objetos no banco de dados usando o Repository

		clienteRepository.saveAll(Arrays.asList(c1, c2));

		locacaoRepository.saveAll(Arrays.asList(l1, l2, l3));
	}

}
