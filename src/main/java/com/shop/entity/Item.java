package com.shop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Item
 * 상품 정보를 나타내는 Entity
 */

@Entity
@Table(name="item")
@Data
@ToString
public class Item {
    // 상품 코드
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 상품 이름
    @Column(nullable = false, length = 50)
    private String name;

    // 상품 가격
    @Column(nullable = false)
    private int price;

    // 상품 재고 수량
    @Column(nullable = false)
    private int stockCount;

    // 상품 설명
    @Lob
    @Column(nullable = false)
    private String detail;

    // 상품 품절 여부 (enum 대신 boolean 형식으로 사용)
    private boolean isSold;

    // 상품 등록 시간
    private LocalDateTime regDate;

    // 상품 수정 시간
    private LocalDateTime updatedAt;
}
