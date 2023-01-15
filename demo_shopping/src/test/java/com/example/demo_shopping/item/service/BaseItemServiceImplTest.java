package com.example.demo_shopping.item.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo_shopping.item.repository.ItemRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BaseItemServiceImplTest {

  @InjectMocks
  BaseItemServiceImpl baseItemService;

  @Mock
  ItemRepository itemRepository;
}