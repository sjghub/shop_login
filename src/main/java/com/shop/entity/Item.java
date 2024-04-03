package com.shop.entity;

import com.shop.dto.ItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private Integer price;

    public ItemDto createDto(Item item) {
        return new ItemDto(item.getId(), item.getTitle(), item.getPrice());
    }
}
