package com.example.demo.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.dao.ItemRepository;
import com.example.demo.entity.Items;
import com.example.demo.service.ItemService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService service;
	
    @Autowired
    ItemRepository dao;
    
    @GetMapping("/getAllItems-startswith-T")
    public List<Items> findAllWithT() {
        List<Items> items = service.findALL();

        items = items.stream()
                .filter(item -> item.getBrand().startsWith("T"))
                .sorted(Comparator.comparingDouble(Items::getPrice).reversed())
                .collect(Collectors.toList());

        return items;
    }
    
    @GetMapping("/getAllItems")
    public List<Items> findAll() {
        List<Items> items = service.findALL();

        items = items.stream()
                .sorted(Comparator.comparingDouble(Items::getPrice).reversed())
                .collect(Collectors.toList());

        return items;
    }

    @GetMapping("/itemsById")
    public Set<Items> getItemsByIds(@RequestParam List<Long> ids) {
        Set<Items> itemsSet = ids.stream()
                .flatMap(id -> service.findItemsById(id).stream())
                .collect(Collectors.toSet());

        return itemsSet;
    }

    @PostMapping("/additem")
    public ResponseEntity<Map<String,String>> singup(@RequestBody Items items)
    {
        this.service.addItem(items);
        Map<String,String> response=new HashMap<String,String>();
        response.put("status", "success");
        response.put("message", "Item added!!");
        
        return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
    }
    
}