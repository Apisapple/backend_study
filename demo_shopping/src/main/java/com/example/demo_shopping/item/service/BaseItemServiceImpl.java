package com.example.demo_shopping.item.service;

import com.example.demo_shopping.item.data.ItemResponseData;
import com.example.demo_shopping.item.entity.Item;
import com.example.demo_shopping.item.exception.ErrorCode;
import com.example.demo_shopping.item.exception.ItemErrorException;
import com.example.demo_shopping.item.repository.ItemRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BaseItemServiceImpl implements ItemService {

  private final ItemRepository itemRepository;

  @Override
  public ItemResponseData findItemByItemNumber(String itemNumber) throws ItemErrorException {

    var item = itemRepository.findItemByItemNumber(itemNumber).orElseThrow(() -> new ItemErrorException(
        ErrorCode.CANNOT_FOUND_ITEM.getMsg(),
        ErrorCode.CANNOT_FOUND_ITEM.getCode())
    );

    return ItemResponseData.builder()
        .itemNumber(item.getItemNumber())
        .brand(item.getBrand())
        .name(item.getName())
        .price(item.getPrice())
        .stockQuantity(item.getStockQuantity())
        .likePoint(item.getLikePoint())
        .lastModified(item.getLastModifiedTime())
        .build();
  }

  @Override
  public List<ItemResponseData> findItemByName(String name) {
    List<Item> itemList = itemRepository.findItemsByNameContains(name);
    return itemList.stream()
        .map(Item::convertItemResponseData)
        .collect(Collectors.toList());
  }
}
