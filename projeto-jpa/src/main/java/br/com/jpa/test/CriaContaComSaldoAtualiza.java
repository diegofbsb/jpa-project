package br.com.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class CriaContaComSaldoAtualiza {

	public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        
        //Busca conta por ID 
        Conta conta = em.find(Conta.class, 1L);
        
        //seta dados
        conta.setTitular("Márcia");
        conta.setNumero(12345);
        conta.setAgencia(54321);
        conta.setSaldo(100.0);

        //atualisa dados no banco
        em.getTransaction().begin();
        em.merge(conta);
        em.getTransaction().commit();
        em.close();
    }
}
