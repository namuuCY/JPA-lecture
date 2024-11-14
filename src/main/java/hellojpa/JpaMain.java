package hellojpa;

import jakarta.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

//        <property name="hibernate.hbm2ddl.auto" value="create" />
        // 이 property를 하면 DDL로 새로 생성함.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(44L);
            member.setUsername("asdf");
            member.setRoleType(RoleType.ADMIN);
            // Enumtype.ORDINAL은 enum을 숫자로 대응한다.
            // 그런데 Enum에 GUEST를 추가하면 GUEST 가 다시 0이됨.

            em.persist(member);

            System.out.println("==============");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
