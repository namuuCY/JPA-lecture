package hellojpa.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Embeddable
@EqualsAndHashCode
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    String city;
    String street;
    String zipcode;

    public String fullAddress() {
        return getCity() + getStreet() + " " + getZipcode();
    }

    public boolean isValid() {
        return false;
    }
}
