package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Items;

public interface ItemService {
	
	public List<Items>findALL();
	public Optional<Items> findItemsById(Long Id);
	public void addItem(Items items);
	
}
