package com.devHyeun.gitEx04.domain.order;


import com.devHyeun.gitEx04.domain.member.Member;
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
@Table(name = "ORDERS")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private OrderState status; // 주문상태



    public void setMember(Member member) {

        // 기존관계 제거
        if (this.member != null) {
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);

    }




}
