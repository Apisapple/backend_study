package com.example.demo_shopping.item.data;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ItemResponseData {
  private String itemNumber;
  private String name;
  private String brand;
  private Integer price;
  private Long stockQuantity;
  private Long likePoint;
  private LocalDateTime lastModified;
}
