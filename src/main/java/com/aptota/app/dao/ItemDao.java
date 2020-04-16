package com.aptota.app.dao;

import java.util.List;

import com.aptota.app.model.Item;
import com.aptota.app.model.response.Response;

public interface ItemDao {
	
	Response saveItem(Item item);
	List<Item> getAllItems();
	Response getItemById(int itemId);
	
	

}
