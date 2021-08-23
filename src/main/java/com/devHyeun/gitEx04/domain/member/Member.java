package com.devHyeun.gitEx04.domain.member;


import com.devHyeun.gitEx04.domain.order.Order;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
