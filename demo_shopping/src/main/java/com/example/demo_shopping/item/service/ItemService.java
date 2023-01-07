package com.example.demo_shopping.item.service;

import com.example.demo_shopping.item.data.ItemResponseData;

public interface ItemService {
  ItemResponseData findItemById(Long id);
}
