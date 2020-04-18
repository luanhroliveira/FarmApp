package com.farmapp.farmapp.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.farmapp.farmapp.entidades.Drogaria;
import com.farmapp.farmapp.entidades.Medicamento;
import com.farmapp.farmapp.entidades.Pagamento;
import com.farmapp.farmapp.entidades.Pedido;
import com.farmapp.farmapp.entidades.PedidoItem;
import com.farmapp.farmapp.entidades.User;
import com.farmapp.farmapp.entidades.enums.StatusPedido;
import com.farmapp.farmapp.repositories.DrogariaRepository;
import com.farmapp.farmapp.repositories.MedicamentoRepository;
import com.farmapp.farmapp.repositories.PedidoItemRepository;
import com.farmapp.farmapp.repositories.PedidoRepository;
import com.farmapp.farmapp.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@Autowired
	private DrogariaRepository drogariaRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private  PedidoRepository pedidoRepository;
	
	@Autowired
	private  PedidoItemRepository pedidoItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Medicamento med1 = new Medicamento(null, "Dorflex", "Bula", 10.00);
		Medicamento med2 = new Medicamento(null, "Paracetamol", "Bula", 5.00);
		Medicamento med3 = new Medicamento(null, "Dipirona", "Bula", 7.00);
		
		medicamentoRepository.saveAll(Arrays.asList(med1, med2, med3));
		
		Drogaria d = new Drogaria(null, "Farmais");
		Drogaria d1 = new Drogaria(null, "Farmax");
		
		drogariaRepository.saveAll(Arrays.asList(d,d1));
		
		med1.getDrogarias().add(d);
		med2.getDrogarias().add(d1);
		med3.getDrogarias().add(d);
		
		medicamentoRepository.saveAll(Arrays.asList(med1, med2, med3));
		
		User u1 = new User(null, "Joao", "12345678911", "joao@gmail.com", "Av. Pereira", "123456789", "123");
		User u2 = new User(null, "Maria", "1564897321", "maria@gmail.com", "Av. Caxias", "987654213", "456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));

		Pedido p1 = new Pedido(null, new Date(), StatusPedido.PAID, u1);
		Pedido p2 = new Pedido(null, new Date(), StatusPedido.WAITING_PAYMENT, u2);
		
		pedidoRepository.saveAll(Arrays.asList(p1, p2));
		
		PedidoItem pi1 = new PedidoItem(p1, med1, 2, med1.getPreco());
		PedidoItem pi2 = new PedidoItem(p2, med3, 2, med3.getPreco());
		PedidoItem pi3 = new PedidoItem(p1, med2, 2, med2.getPreco());
		
		pedidoItemRepository.saveAll(Arrays.asList(pi1, pi2, pi3));
		
		Pagamento pag1 = new Pagamento(null, new Date(), p1);
		p1.setPagamento(pag1);
		
		pedidoRepository.save(p1);
		
	}
	
	
	
	
	
}
