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

            Member member = new Member();
            member.setId(100L);
            member.setName("Hello,JPA");
            // 위까지는 비영속 상태
            em.persist(member); // 영속
            System.out.println("-----------------Before-------------------");
            System.out.println("-----------------After-------------------");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
