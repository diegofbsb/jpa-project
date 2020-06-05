package br.com.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class CriaContaSalva {

	public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        
        Conta conta = new Conta();
        conta.setTitular("Reinaldo");
        conta.setNumero(1234);
        conta.setAgencia(4321);
        conta.setSaldo(100.0);
        em.persist(conta);
  
        //Usado para salvar os dados
        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();
        
        // mesmo depois de fechar a tranção o merge identifica
        //que os dados são os mesmos no banco e faz a atualização
        // usado em calculos quando temos que salvar dados.
        EntityManager em2 = emf.createEntityManager();
        System.out.println("ID da Conta da Márcia:" + conta.getId());
        conta.setSaldo(200.00);
        em2.getTransaction().begin();
        em2.merge(conta);
        em2.getTransaction().commit();
    }
}
