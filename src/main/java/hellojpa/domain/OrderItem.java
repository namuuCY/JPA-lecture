package hellojpa.domain;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    Long id;

    //    @Column(name = "ORDER_ID")
//    Long orderId;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    Order order;

//    @Column(name = "MEMBER_ID")
//    Long memberId;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    Item item;

    int orderPrice;
    int count;

}
