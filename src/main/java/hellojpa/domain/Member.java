package hellojpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Member {
    // 메타데이터는 Entity class내에 적어두는 것을 선호.
    // Index도 마찬가지. index도 @table에 집어넣기
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    Long id;
    String name;
    String city;
    String street;
    String zipcode;

}
