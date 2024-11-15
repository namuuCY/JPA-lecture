package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberProduct {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    Product product;

}
