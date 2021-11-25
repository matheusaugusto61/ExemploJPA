package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

    public static void main(String[] args){
        //Instanciando Entity Manager que encapsula uma conexão com o banco e serve para efetuar o crud
        //Instanciando Entity Manager Factory que é utilizado para instanciar objetos Entity Manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        //Inserindo um objeto do tipo Pessoa no banco
        Pessoa p1 = new Pessoa(null, "Matheus Augusto", "contato.matheusaugusto18@gmail.com");
        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();
        //Resgatando um objeto do banco
        Pessoa p2 = em.find(Pessoa.class, 4);
        //Editando um objeto no banco
        p2.setNome("Mudei o nome");
        em.getTransaction().begin();
        em.merge(p2);
        em.getTransaction().commit();
        //Removendo um objeto do banco
        em.getTransaction().begin();
        Pessoa p3 = em.find(Pessoa.class, 6);
        em.remove(p3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
