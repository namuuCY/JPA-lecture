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
            member.setUsername("member1");
            member.setHomeAddress(new Address("homecity", "street", "zipcode"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressHistory().add(new AddressEntity(new Address("old1", "street", "zipcode")));
            member.getAddressHistory().add(new AddressEntity(new Address("old2", "street", "zipcode")));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("===============");
            Member find = em.find(Member.class, member.getId());

            find.setHomeAddress(new Address("newnewCity", "street", "zipcode"));

            find.getFavoriteFoods().remove("치킨");
            find.getFavoriteFoods().add("한식");

            find.getAddressHistory().remove(new AddressEntity(new Address("old1", "street", "zipcode")) );
            find.getAddressHistory().add(new AddressEntity(new Address("newcity1", "street", "10000")));

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
