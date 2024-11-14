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
