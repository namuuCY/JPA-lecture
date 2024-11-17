package hellojpa;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("user1");

            em.persist(member);

            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member.getId());
            System.out.println(m1.getClass());

            Member reference = em.getReference(Member.class, member.getId());
            System.out.println(reference.getClass());
            System.out.println(m1 == reference); //true
            //proxy로 해도 이미 m1으로 멤버를 조회했기 때문에 이것 또한 Member class로 나옴.

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
