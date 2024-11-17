package hellojpa;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;



}
