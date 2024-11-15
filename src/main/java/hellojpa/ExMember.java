package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@SequenceGenerator(name = "M_SEQ_GEN", sequenceName = "M_SEQ", initialValue = 1, allocationSize = 50)
public class ExMember {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "M_SEQ_GEN")
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

}
