package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id @GeneratedValue
    Long id;

    String name;

    @ManyToMany(mappedBy = "products")
    List<Member> members = new ArrayList<>();

}
