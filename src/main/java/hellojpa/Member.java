package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    // JPA는 내부적으로 Reflection을 사용
    // 내부적으로 객체를 생성해낸다. => 기본 생성자가 꼭필요하다.
    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType; // Enum type을 쓰고 싶을 때

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP) // date + time timestamp타입.
    private Date lastModifiedDate; // 보통 DB는 date, time, timestamp 구분됨.

    @Lob
    private String Description; // @Lob : large object
    // 문자 타입이면 clob, 파일이면 blob

    @Transient
    private int temp; //  이렇게 실행할 경우, DB에는 사용 X
}
