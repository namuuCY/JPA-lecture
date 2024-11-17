package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity {

    // abstract 붙이는걸 추천. 이것만 써서는 안되니까 무조건임

    // superclass : 기본으로 필요한 속성, 매핑정보 추가하기 위해서 사용.
    // 상속관계 매핑이 아니고, 엔티티가 아니다!
    @Column(name = "INSERT_MEMBER")
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

}
