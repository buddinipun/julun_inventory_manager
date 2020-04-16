package com.aptota.app.service.UserLogin;

import java.util.List;

import com.aptota.app.model.Item;
import com.aptota.app.model.response.Response;


public interface ItemService {
	
	public Response registerItem(Item item);
	public List<Item> getAllItems();
	public Response getItemByItemId(int ItemId);
	
	

}
