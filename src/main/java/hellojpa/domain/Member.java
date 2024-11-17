package hellojpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Member extends BaseEntity {
    // 메타데이터는 Entity class내에 적어두는 것을 선호.
    // Index도 마찬가지. index도 @table에 집어넣기
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    Long id;
    String name;
    @Embedded
    Address address;

    @OneToMany(mappedBy = "member")
    List<Order> orders = new ArrayList<>();

}
