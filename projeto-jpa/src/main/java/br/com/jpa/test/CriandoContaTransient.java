package br.com.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class CriandoContaTransient {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setNumero(321321);
		conta.setAgencia(123123);
		
		//antes de persistir é uma transação transient quando persiste se torna uma manager
		em.persist(conta);
		

	}

}
