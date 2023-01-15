package com.example.demo_shopping.item.service;

import com.example.demo_shopping.item.data.ItemResponseData;
import com.example.demo_shopping.item.exception.ItemErrorException;
import java.util.List;

public interface ItemService {

  ItemResponseData findItemByItemNumber(String itemNumber) throws ItemErrorException;

  List<ItemResponseData> findItemByName(String name);
}
