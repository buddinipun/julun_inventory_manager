package com.aptota.app.service.UserLogin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptota.app.dao.ItemDao;
import com.aptota.app.model.Item;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.UserLogin.ItemService;

@Service
public class ItemServiceimpl implements ItemService{
	
	@Autowired
	ItemDao itemdao;

	@Override
	public Response registerItem(Item item) {
		
		Response response  = itemdao.saveItem(item);
		return response;
	}

	@Override
	public List<Item> getAllItems() {
		 
		return itemdao.getAllItems();
	}

	@Override
	public Response getItemByItemId(int ItemId) {
		// TODO Auto-generated method stub
		return itemdao.getItemById(ItemId);
	}

	

	
	
	


}
