package br.estudo.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.estudo.modelo.Aluno;
import br.estudo.modelo.Professor;

public class Principal {
	
	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Joaquim");
		aluno1.setIdade(15);
		aluno1.setEndereco("Rua 1 - casa 10");
		aluno1.setTelefone("(11) 33333-1234");
		aluno1.setNome_Responsavel("Emanuel");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Bruno");
		aluno2.setIdade(14);
		aluno2.setEndereco("Rua 1 - casa 22");
		aluno2.setTelefone("(11) 44444-1234");
		aluno2.setNome_Responsavel("Fernando");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Amanda");
		aluno3.setIdade(15);
		aluno3.setEndereco("Rua 1 - casa 15");
		aluno3.setTelefone("(11) 55555-1234");
		aluno3.setNome_Responsavel("Maria das Dores");

		Aluno aluno4 = new Aluno();
		aluno4.setNome("Pedro");
		aluno4.setIdade(16);
		aluno4.setEndereco("Rua 1 - casa 40");
		aluno4.setTelefone("(11) 66666-1234");
		aluno4.setNome_Responsavel("Jorge");
		
		Professor professor1 = new Professor();
		professor1.setNome("Armando");
		professor1.setIdade(49);
		professor1.setDisciplina("Matemática");
		professor1.setEndereco("Rua 2 - casa 30");
		professor1.setTelefone("(11) 31111-1111");
		
		Professor professor2 = new Professor();
		professor2.setNome("Rosa");
		professor2.setIdade(30);
		professor2.setDisciplina("Português");
		professor2.setEndereco("Rua 2 - casa 01");
		professor2.setTelefone("(11) 11111-1111");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("escola");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(aluno1);
		em.persist(aluno2);
		em.persist(aluno3);
		em.persist(aluno4);
		em.persist(professor1);
		em.persist(professor2);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Dados cadastrados com sucesso");
		
		System.exit(0);
		
	}

}
