package onlineMedicineshoppingSystem.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;

    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    private String address;

//    private List<Order> myOrder = new ArrayList<>();

}

