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

            Team team = new Team();
            team.setName("TeamA");
            member.setTeam(team);
            em.persist(team);

            em.flush();
            em.clear();

            Member m = em.find(Member.class, member.getId());

            System.out.println(m.getTeam().getClass());

            System.out.println("========");
            System.out.println(m.getTeam().getName());
            System.out.println("========");


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
