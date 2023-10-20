package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ItemRepository;
import com.example.demo.entity.Items;

@Service

public class ItemServiceImpl implements ItemService{

	@Autowired
    ItemRepository dao;

	@Override
	public List<Items> findALL() {
		// TODO Auto-generated method stub
		return this.dao.findAll();
	}

	@Override
	public Optional<Items> findItemsById(Long Id) {
		// TODO Auto-generated method stub
		return this.dao.findById(Id);
	}

	@Override
	public void addItem(Items items) {
		// TODO Auto-generated method stub
		dao.save(items);
	}

}
