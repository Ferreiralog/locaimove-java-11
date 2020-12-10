package com.ifma.locaimovel.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ifma.locaimovel.entiteis.Cliente;
import com.ifma.locaimovel.entiteis.Contato;
import com.ifma.locaimovel.entiteis.Endereco;
import com.ifma.locaimovel.entiteis.Imoveis;
import com.ifma.locaimovel.entiteis.Locacao;
import com.ifma.locaimovel.entiteis.enums.ImovelTipo;
import com.ifma.locaimovel.entiteis.enums.StatusLocacao;
import com.ifma.locaimovel.repositoreies.ClienteRepository;
import com.ifma.locaimovel.repositoreies.ContatoRepository;
import com.ifma.locaimovel.repositoreies.ImoveisRepository;
import com.ifma.locaimovel.repositoreies.LocacaoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ImoveisRepository imoveisRepository;
	
	//@Autowired
	//private EnderecoRepository enderecoRepository;

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Autowired
	private ContatoRepository contatoRepository;

	@Override
	public void run(String... args) throws Exception {

		// salvar os dois objetos no banco de dados usando o Repository
			
		

		Cliente c1 = new Cliente(null, "Maria Brown", "44568723456", "2015-09-04");
		Cliente c2 = new Cliente(null, "Alex Green", "98566324561", "2000-10-12");
		Cliente c3 = new Cliente(null, "Joaqim Green", "98766632465", "2002-10-12");

		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//Endereco en1 = new Endereco(null,"Rua das araras","123A","Angelim", "67000000","São Luís","MA");
		//Endereco en2 = new Endereco(null,"Rua 4","23","Cohatrac", "67000000","Paço do Lumir","MA");
		//Endereco en3 = new Endereco(null,"Av. Castelo","1023","Araçagy", "67000000","Ribamar","MA");
		
		//enderecoRepository.saveAll(Arrays.asList(en1,en2,en3));

		Contato con1 = new Contato(null, "976523456", "954736653", "exempl@gmail", c1);
		Contato con2 = new Contato(null, "976523456", "954736653", "exempl@gmail", c2);
		Contato con3 = new Contato(null, "976523456", "954736653", "exempl@gmail", c3);

		contatoRepository.saveAll(Arrays.asList(con1, con2, con3));
		
		Locacao l1 = new Locacao(null, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"),
				StatusLocacao.OCUPADO, c1, "ok");
		Locacao l2 = new Locacao(null, Instant.parse("2018-07-21T03:42:10Z"), Instant.parse("2019-07-21T03:42:10Z"),
				StatusLocacao.DESOCUPADO, c2, "em reforma");
		Locacao l3 = new Locacao(null, Instant.parse("2017-07-21T03:42:10Z"), Instant.parse("2018-07-21T03:42:10Z"),
				StatusLocacao.OCUPADO, c1, "Casa de praia");

		locacaoRepository.saveAll(Arrays.asList(l1, l2, l3));
		
		
		Imoveis im1 = new Imoveis(null, 300.00,3,2, 1, 1800.00,ImovelTipo.APARTAMENTO,l1);		
		Imoveis im2 = new Imoveis(null, 350.00, 2, 2, 1,2600.00, ImovelTipo.CASA, l2);
		Imoveis im3 = new Imoveis(null, 250.00, 3,2,2,1600.00, ImovelTipo.SITIO, l3);
		Imoveis im4 = new Imoveis(null, 5000.00, 5,3,2,100000.00, ImovelTipo.FAZENDA, l1);
		Imoveis im5 = new Imoveis(null, 500.00, null,1,2,10000.00, ImovelTipo.COMERCIAL, l3);
		
		imoveisRepository.saveAll(Arrays.asList(im1,im2,im3,im4,im5));
		
		Endereco en1 = new Endereco(null,"Rua das araras","123A","Angelim", "67000000","São Luís","MA",im1);
		im1.setEndereco(en1);
		imoveisRepository.save(im1);
		
		

		

	}

}
