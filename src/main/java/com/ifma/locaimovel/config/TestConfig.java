package com.ifma.locaimovel.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ifma.locaimovel.entiteis.Cliente;
import com.ifma.locaimovel.entiteis.Contato;
import com.ifma.locaimovel.entiteis.Locacao;
import com.ifma.locaimovel.entiteis.enums.StatusLocacao;
import com.ifma.locaimovel.repositoreies.ClienteRepository;
import com.ifma.locaimovel.repositoreies.ContatoRepository;
import com.ifma.locaimovel.repositoreies.LocacaoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Autowired
	private ContatoRepository contatoRepository;

	@Override
	public void run(String... args) throws Exception {

		// salvar os dois objetos no banco de dados usando o Repository

		Contato con1 = new Contato(null, "976523456", "954736653", "exempl@gmail");
		Contato con2 = new Contato(null, "976523456", "954736653", "exempl@gmail");
		Contato con3 = new Contato(null, "976523456", "954736653", "exempl@gmail");
		
		contatoRepository.saveAll(Arrays.asList(con1, con2, con3));

		Cliente c1 = new Cliente(null, "Maria Brown", "44568723456", "2015-09-04");
		Cliente c2 = new Cliente(null, "Alex Green", "98566324561", "2000-10-12");
		Cliente c3 = new Cliente(null, "Joaqim Green", "98766632465", "2002-10-12");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));

		Locacao l1 = new Locacao(null, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"),
				StatusLocacao.OCUPADO, c1, "ok");
		Locacao l2 = new Locacao(null, Instant.parse("2018-07-21T03:42:10Z"), Instant.parse("2019-07-21T03:42:10Z"),
				StatusLocacao.DESOCUPADO, c2, "em reforma");
		Locacao l3 = new Locacao(null, Instant.parse("2017-07-21T03:42:10Z"), Instant.parse("2018-07-21T03:42:10Z"),
				StatusLocacao.OCUPADO, c1, "Casa de praia");
		
		locacaoRepository.saveAll(Arrays.asList(l1, l2, l3));

	}

}
