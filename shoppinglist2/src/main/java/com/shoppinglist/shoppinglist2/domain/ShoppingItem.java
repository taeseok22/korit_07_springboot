package com.shoppinglist.shoppinglist2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String product;
    private String amount;
    private boolean purchased = false;


    // 여러 개의 아이템이 한 명의 유저에게 속하니까
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // CommandLineRunner 상에서 사용할 간단한 생성자 정의 함.


    public ShoppingItem(String product, String amount, boolean purchased, User user) {
        this.product = product;
        this.amount = amount;
        this.purchased = purchased;
        this.user = user;
    }
}
