package br.com.jpa.test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Categoria;
import br.com.jpa.modelo.Conta;
import br.com.jpa.modelo.Movimentacao;
import br.com.jpa.modelo.TipoMovimentacao;

public class CriaRelacionamentoOneToOne {

	public static void main(String[] args) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	     EntityManager em = emf.createEntityManager();
	     
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");
		
//		List<Categoria> categorias = new ArrayList<Categoria>();
//		categorias.add(categoria);
//		categorias.add(categoria2);
		
		Conta conta = new Conta();
		conta.setId(4L);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("SS");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300.00));
		movimentacao.setCategoria(Arrays.asList(categoria,categoria2));
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("RRR");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(500.00));
		movimentacao2.setConta(conta);

		em.getTransaction().begin();
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);
		em.getTransaction().commit();
		em.close();
	}

}
