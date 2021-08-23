package com.devHyeun.gitEx04.domain.item;


import lombok.*;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;        // 이름
    private int price;          // 가격
    private int stockQuentity;  // 재고수량
}
