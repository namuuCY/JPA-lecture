package hellojpa;

import jakarta.persistence.*;
import java.util.List;


public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("m2");
            em.persist(member);

            Member findMember = em.find(Member.class, 1L);
            Team team1 = findMember.getTeam();
            member.setTeam(team1);

            em.flush();

            List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members) {
                System.out.println(m.getUsername());
            }

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
