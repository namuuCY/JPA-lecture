package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Long id; // Id
    private String name;
}
