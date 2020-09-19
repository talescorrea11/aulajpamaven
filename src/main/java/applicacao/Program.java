package applicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "email@email.com.br");
		Pessoa p2 = new Pessoa(null, "Maria da Silva", "maria@email.com.br");
		Pessoa p3 = new Pessoa(null, "Rodrigo da Silva", "rodrigo@email.com.br");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//em.getTransaction().begin();
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println(p);
		
		/*
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		em.getTransaction().commit();
		*/
		
		System.out.println("Pronto");
		em.close();
		emf.close();
		
		
		
		
		/*
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		*/
		
	}

}
