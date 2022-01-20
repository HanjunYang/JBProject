package JBProject;

import JBProject.Domain.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        try{
//            Member member = new Member();
//            member.setMemberId("aaa");
//            member.setMemberPw("123");
//            member.setMemberName("찌뿌");
//            member.setMemeberPhone("01067665461");
//
//            em.persist(member);
//
//            transaction.commit();
//        }catch(Exception e){transaction.rollback();}
//        finally {
//            em.close();
//        }
//
//        emf.close();
//
//
    }
}





