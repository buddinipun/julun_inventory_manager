package com.aptota.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aptota.app.dao.ItemDao;
import com.aptota.app.model.Customer;
import com.aptota.app.model.Item;
import com.aptota.app.model.response.Response;

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unused")
	@Override
	public Response saveItem(Item item) {
		
		Session session = null;
		Response response = null;
		
		
		try {
		
			session = entityManager.unwrap(Session.class);	
			System.out.println("With in the item register Session" + session);
			System.out.println("With in the item register Item" + session);
			
			if(item != null && session != null ) {
			
			String itemCodeUpper = (item.getItemCode() != null && !item.getItemCode().isEmpty() && !item.getItemCode().equals("") && item.getItemCode().trim().length() > 0) ? item.getItemCode().toUpperCase().trim() : item.getItemCode();
			   
			Item exsistingItem = (Item) session.createCriteria(Item.class)
					.add(Restrictions.eq("itemCode", itemCodeUpper))
					.uniqueResult();
			
			if(exsistingItem ==null) {
				
				item.setItemCode(itemCodeUpper);
				session.save(item);
				System.out.println("Item Saved successfully");
				response = new Response("SUCCESS", 200, "Item Saved successfully", item);
			} else {
				
				response = new Response("FAILS", 304, "Exsisting Item " , item);
				System.out.println("Exsisting Item");
			}
			
			}
			
			else {
				
				response = new Response("FAILS", 300, "Contact system administrator" , null);
				System.out.println("Contact system administrato");
			}
			
		} catch (Exception e) {
			response = new Response("FAILS", 300, "ERROR on Item registion " , item);
			e.printStackTrace();
			System.out.println("ERROR on Item registion");
			
		} finally {
			
			
			if (session != null && session.isOpen()) {
				
				session.close();
				
			}
		}
		
		
		return response;
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = entityManager.unwrap(Session.class);
			 return session.createCriteria(Item.class)
			 .list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			
			if(session != null && session.isOpen()) {
				
				session.close();
//			}
		}
	}
		
	}


	@Override
	public Response getItemById(int itemId) {
		// TODO Auto-generated method stub
		Session session = null;
		Response response = null;
		
		try {
			
			session = entityManager.unwrap(Session.class);
			Item item = (Item) session.createCriteria(Item.class)
			.add(Restrictions.eq("iditem",itemId ))
			.uniqueResult();
			
			response = new Response("SUCCESS", 200, "Item Received successfully", item);
			
		}catch (Exception ex) {
			ex.printStackTrace();
			response = new Response("ERROR", 300, "Error on retriving item Id : " + itemId + "on error : " + ex.getMessage(), null);
		}
		
		finally {
		
		if(session != null && session.isOpen()) {
			
			session.close();
		}
		}
		return response;
	}

	
}
