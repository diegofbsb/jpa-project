package br.com.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.jpa.modelo.Categoria;
import br.com.jpa.modelo.Conta;
import br.com.jpa.modelo.Movimentacao;

public class TesteJpqlPorCategoria {

	public static void main(String[] args) {

		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	     EntityManager em = emf.createEntityManager();
	     
	     Categoria categoria = new Categoria();
	     categoria.setId(3L);
	     
	     String jpql = "select m from Movimentacao m join m.categoria c"
	     		+ " where m.categoria = :pCategoria";
	     //Queri sem a tipagem
	    // Query query = em.createQuery(jpql);
	     
	     //query com a tipagem, garantindo a integridade dos dados
	     TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
	     query.setParameter("pCategoria", categoria);
	     List<Movimentacao> result =  query.getResultList();
		
	     for (Movimentacao movimentacao : result) {
	    	 System.out.println("===============================");
			System.out.println(movimentacao.getDescricao());
		}
	}
}
