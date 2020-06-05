package br.com.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class CriandoContaDelete {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		//Busca conta por ID 
		 Conta conta = em.find(Conta.class, 1L);
		 
		//antes de remover é uma transação manager quando persiste se torna uma removed
		 em.getTransaction().begin();
		 em.remove(conta);
		 em.getTransaction().commit();
		 em.close();

	}
}
