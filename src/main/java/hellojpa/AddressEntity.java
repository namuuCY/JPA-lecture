package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "ADDRESS")
@Getter
@Setter
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue
    Long id;

    public AddressEntity(Address address) {
        this.address = address;
    }
    Address address;

}
