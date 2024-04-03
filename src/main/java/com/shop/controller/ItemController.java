package com.shop.controller;

import com.shop.dto.ItemDto;
import com.shop.repository.ItemRepository;
import com.shop.entity.Item;
import com.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    public String list(Model model) {

        List<Item> result = itemService.findAll();
        model.addAttribute("items", result);
        return "list";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }


    @PostMapping("/add")
    public String add(ItemDto itemDto) {
        log.info("itemDto : "+itemDto);


        Item saved = itemService.createItem(itemDto);

        log.info("saved : "+ saved.toString());

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id,Model model){
        log.info("id :" + id);
        // 해당되는 entity찾기

        ItemDto itemDto = itemService.showDetail(id);


        // entity to dto


        model.addAttribute("itemDto", itemDto);


        return "detail";
    }

    @GetMapping("/edit/{id}")
    public String getEdit(@PathVariable Long id,Model model) {
        // 1. 수정할 데이터 찾기
        Item itemEntity = itemRepository.findById(id).orElse(null);

        // 2. 수정할 데이터 value값 전달

        model.addAttribute("target", itemEntity);

        return "edit";
    }
    @PostMapping("/edit")
    public String postEdit(ItemDto itemDto){
        //1. dto를 엔티티로 변환
        Item itemEntity = itemDto.toEntity();
        log.info(itemEntity.toString());
        //2. 엔티티 저장
        Item target = itemRepository.findById(itemEntity.getId()).orElse(null);

        if(target != null) {
            itemRepository.save(itemEntity);
        }
        //3. 수정결과 페이지로 이동
        return "redirect:/list";
    }
    @DeleteMapping("/item")
    public ResponseEntity<String> delete(@RequestParam Long id){
        itemRepository.deleteById(id);
        return ResponseEntity.status(200).body("삭제완료");
    }


}
