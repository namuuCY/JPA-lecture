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
            // JPQL을 통해서도 가져 올 수 있다.
            // 조건을 사용할때, 페이징
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setMaxResults(3)
                            .getResultList();
            for (Member member : result) {
                System.out.println(member.toString());
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
