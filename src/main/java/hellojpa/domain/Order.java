package hellojpa.domain;import jakarta.persistence.Column;import jakarta.persistence.Entity;import jakarta.persistence.EnumType;import jakarta.persistence.Enumerated;import jakarta.persistence.GeneratedValue;import jakarta.persistence.Id;import jakarta.persistence.JoinColumn;import jakarta.persistence.ManyToOne;import jakarta.persistence.OneToMany;import jakarta.persistence.OneToOne;import jakarta.persistence.Table;import java.time.LocalDateTime;import java.util.ArrayList;import java.util.List;import lombok.AccessLevel;import lombok.Getter;import lombok.Setter;import lombok.experimental.FieldDefaults;@Setter@Getter@FieldDefaults(level = AccessLevel.PRIVATE)@Entity@Table(name = "ORDERS")public class Order extends BaseEntity {    @Id    @GeneratedValue    @Column(name = "ORDER_ID")    Long id;//    @Column(name = "MEMBER_ID")//    Long memberId;    @ManyToOne    @JoinColumn(name = "MEMBER_ID")    Member member;    @OneToOne    @JoinColumn(name = "DELIVERY_ID")    Delivery delivery;    @OneToMany(mappedBy = "order")    List<OrderItem> orderItems = new ArrayList<>();    LocalDateTime orderDate;    @Enumerated(EnumType.STRING)    OrderStatus status;    public void addOrderItem(OrderItem orderItem) {        orderItems.add(orderItem);        orderItem.setOrder(this);    }}