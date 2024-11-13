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
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");
            System.out.println("================");
            tx.commit(); // query는 get한 것과 update된 것이 둘 다 실행 됨.
            // 마치 collection의 멤버를 바꿨을 때 바꾸고 put할 필요 없는 것 처럼.
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
