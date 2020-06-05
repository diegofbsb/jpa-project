package br.com.jpa.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;
import br.com.jpa.modelo.Movimentacao;
import br.com.jpa.modelo.TipoMovimentacao;

public class ComntaComRelacionamentoManyToOny {

	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	     EntityManager em = emf.createEntityManager();
	        
       // Conta conta = new Conta();
        Conta conta = em.find(Conta.class, 2L);
        
//        conta.setTitular("Reinaldo AAA");
//        conta.setNumero(1234);
//        conta.setAgencia(4321);
//        conta.setSaldo(100.0);
        
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churras");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		//movimentacao.setConta(conta);
		
		em.getTransaction().begin();
		//em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();
	}
}
