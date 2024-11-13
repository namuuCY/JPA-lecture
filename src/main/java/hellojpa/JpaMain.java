package hellojpa;

import jakarta.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        // jdbc에는 transcation 이 중요하다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(151L, "B");
            em.persist(member1);
            em.persist(member2);
            System.out.println("==============");
            // commit 하고 나서야 query를 날린다.
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
