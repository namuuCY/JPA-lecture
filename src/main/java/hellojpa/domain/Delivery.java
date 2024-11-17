package hellojpa.domain;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    Long id;

    String city;
    String street;
    String zipcode;
    DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    Order order;



}
