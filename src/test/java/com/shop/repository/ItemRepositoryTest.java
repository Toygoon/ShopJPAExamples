package com.shop.repository;

import com.shop.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
class ItemRepositoryTest {
    // 생성할 Item 개수
    private static final int TEST_ITEMS = 10;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        Item item = null;

        for (int i = 1; i <= TEST_ITEMS; i++) {
            item = new Item();

            item.setName("테스트 상품 " + i);
            item.setPrice(10000 + i);
            item.setDetail("테스트 상품 상세 설명 " + i);
            item.setSold(new Random().nextBoolean());
            item.setStockCount(100 + i);
            item.setRegDate(LocalDateTime.now());
            item.setUpdatedAt(LocalDateTime.now());

            itemRepository.save(item);
        }
    }

    @Test
    @DisplayName("상품 조회 테스트")
    public void findItemByNameTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findItemByName("테스트 상품 " + (new Random().nextInt() % TEST_ITEMS + 1));

        for (Item item : itemList)
            System.out.println(item);

    }
}