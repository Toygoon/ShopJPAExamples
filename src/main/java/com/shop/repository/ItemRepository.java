package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * ItemRepository
 * Item Entity를 JPA가 DB 통신하기 위한 추상 클래스
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
    // 상품 이름으로 객체를 찾는 메서드
    List<Item> findItemByName(String name);

    // 상품 이름이나 설명으로 객체를 찾는 메서드
    List<Item> findItemByNameOrDetail(String name, String detail);

    // 파라미터로 전달된 가격보다 더 저렴한 상품을 찾는 메서드
    List<Item> findItemByPriceLessThan(int price);
}
