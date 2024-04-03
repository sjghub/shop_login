package com.shop.dto;

import com.shop.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ItemDto {
    private Long id;
    private String title;
    private Integer price;

    public Item toEntity() {
        return new Item(id, title, price);
    }
}
