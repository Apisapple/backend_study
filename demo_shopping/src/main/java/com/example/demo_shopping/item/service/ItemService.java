package com.example.demo_shopping.item.service;

import com.example.demo_shopping.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
  private final ItemRepository itemRepository;
}
