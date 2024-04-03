package com.shop.service;


import com.shop.dto.ItemDto;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
public class ItemService {
    private final ItemRepository itemRepository;


    public List<Item> findAll() {
        return itemRepository.findAll();

    }

    public Item createItem(ItemDto itemDto) {
        if(itemDto.getTitle().length() > 10 || itemDto.getTitle().isEmpty()){
            throw new IllegalArgumentException("제목이 비었거나 너무 깁니다.");
        }
        if(itemDto.getPrice() > 1000000){
            throw new IllegalArgumentException("너무 비쌉니다");
        }

        //1 dto to entity
        Item newItem = itemDto.toEntity();
        //2.save entity

        return itemRepository.save(newItem);
    }

    public ItemDto showDetail(Long id) {

        Item item = itemRepository.findById(id).orElse(null);
        log.info("item :" + (item != null ? item.toString() : null));

        if(item == null) {
            throw new IllegalArgumentException("item이 비었습니다");
        }
        ItemDto itemDto = item.createDto(item);
        log.info("itemDto :" + itemDto.toString());

        return itemDto;
    }
}
