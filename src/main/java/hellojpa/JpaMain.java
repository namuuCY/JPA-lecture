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
            member.setId(101L);
            member.setName("Hello,JPA2");

            System.out.println("-----------------Before-------------------");
            em.persist(member);
            System.out.println("-----------------After-------------------");

            Member findMember = em.find(Member.class, 101L);
            System.out.println(findMember.toString()); // DB가 아닌, 1차캐시에서 조회

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
