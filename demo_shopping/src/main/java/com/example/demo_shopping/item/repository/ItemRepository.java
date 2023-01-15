package com.example.demo_shopping.item.repository;

import com.example.demo_shopping.item.entity.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {


  Optional<Item> findItemByItemNumber(String itemNumber);

  List<Item> findItemsByNameContains(String name);
}
