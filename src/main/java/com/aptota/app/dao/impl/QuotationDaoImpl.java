package com.aptota.app.dao.impl;

import com.aptota.app.dao.QuotationDao;
import com.aptota.app.model.Quotation;
import com.aptota.app.model.QuotationItem;
import com.aptota.app.model.order.ViewQuotation;
import com.aptota.app.model.requests.GetQuotation;
import com.aptota.app.model.response.GetQuotationItem;
import com.aptota.app.model.response.Response;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.rmi.PortableRemoteObject;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuotationDaoImpl implements QuotationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Response saveQuotationMainDetails(Quotation quotation) {


        Session session = null;
        com.aptota.app.model.response.Response response = null;
        int quotationId = 0;
        if (quotation != null) {
            try {

                session = entityManager.unwrap(Session.class);
                System.out.println("With in the quotation main item Session" + session);

                quotation.setQuatationStatus("A");
                quotationId = (int) session.save(quotation);
                System.out.println("Item Saved successfully");
                response = new com.aptota.app.model.response.Response("SUCCESS", 200, "Item Saved successfully", quotationId);


            } catch (Exception e) {
                response = new com.aptota.app.model.response.Response("FAILS", 300, "ERROR on Item registion ", quotationId);
                e.printStackTrace();
                System.out.println("ERROR on Item registion");

            } finally {


//                if (session != null && session.isOpen()) {
//
//                    session.close();
//
//                }
            }
        } else {
            response = new com.aptota.app.model.response.Response("FAILS", 300, "Null Quotation Code foud ", null);

        }


        return response;
    }

	@Override
	public Response saveQuotationItemDetails(JSONArray itemString, int quotationId) {
		// TODO Auto-generated method stub
		
		 Session session = null;
		 int quotationItemId = 0;
	        com.aptota.app.model.response.Response response = null;
	        
	        if (itemString != null && !itemString.equals("") && itemString.length() > 0 && quotationId !=0) {
	            try {
	            	   // System.out.println("1");
	                session = entityManager.unwrap(Session.class);
	                System.out.println("With in the quotation items Session" + session);
	               
	                for (int i = 0; i < itemString.length(); i++) {
						JSONObject obj = itemString.getJSONObject(i);

						int itemCode = obj.getInt("itemCode");
						int quantity = obj.getInt("quantity");
						double amount = obj.getInt("amount");
						
						
						System.out.println("itemCode is : " + itemCode + "quantity : " + quantity + "amount : " + amount);
						QuotationItem quotationitem = new QuotationItem();
						 quotationitem.setQuotationRefId(quotationId);
						 quotationitem.setItemRefId(itemCode);
						 quotationitem.setAmount(amount);
						 quotationitem.setQuantity(quantity);
						 
						 System.out.println("quontity on quantity item is : " + quantity);
						
						 quotationItemId = (int) session.save(quotationitem);
			             System.out.println("Quotation Item " + quotationItemId +" Saved successfully");
						 
						
					}
	               
	                response = new com.aptota.app.model.response.Response("SUCCESS", 200, "Item Saved successfully", quotationId);


	            } catch (Exception e) {
	                response = new com.aptota.app.model.response.Response("FAILS", 300, "ERROR on Item registion ", quotationId);
	                e.printStackTrace();
	                System.out.println("ERROR on Item registion");

	            } finally {


	                if (session != null && session.isOpen()) {

	                    session.close();

	                }
	            }
	        } else {
	            response = new com.aptota.app.model.response.Response("FAILS", 300, "Null Quotation Code foud ", null);

	        }


	        return response;
	}

	@Override
	@Transactional
	public Response getQuotationAllQuotations(GetQuotation getQuotation) {

    	List<ViewQuotation> quotationlist = new ArrayList<>();
    	Response response = null;
		Session session = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ViewQuotation quotation = null;
		String fromDate = null;
		String toDate = null;
		String salesExec = null;
		int customerId = 0;
		String loginUserRole = null;
		String appendfromDate = null;
		String appendtoDate = null;
		String apppendSalesExeCode = null;
		String apendCustomerCode = null;
		String appendCashierUser = null;

		if (getQuotation != null) {
			fromDate = getQuotation.getFromDate();
			toDate = getQuotation.getToDate();
			salesExec = getQuotation.getSalesExeName();
			customerId = getQuotation.getCutomerId();
			loginUserRole = getQuotation.getLoginUserRole();

			if (loginUserRole != null && !loginUserRole.isEmpty() && loginUserRole.equals("") && loginUserRole.trim().length() >0 && loginUserRole.trim().equals("ROLE_SALES_EXEC")) {

				apppendSalesExeCode = " AND q.c_user = '" + getQuotation.getExecutiveName() + "'";
			} else {
				if (salesExec!= null && salesExec.trim().toLowerCase().equals("all")) {
					apppendSalesExeCode = "";

				} else {
					apppendSalesExeCode = " AND q.c_user = '" + salesExec + "'";

				}

			}

			if (customerId == 0) {
				apendCustomerCode = "";
			//	System.out.println("customer Id is111111111111111111111111111111111111111111111. " + customerId);
			} else {
			//	System.out.println("customer Id is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>. " + customerId);
				apendCustomerCode = " AND q.customer_ref_id = '" + customerId + "' ";
			}

			if (fromDate != "" && fromDate != null && !fromDate.isEmpty() && fromDate.equals("") && fromDate.trim().length() >0) {
				appendfromDate = " AND q.c_date >= '" + fromDate + "' ";
			} else {
				appendfromDate = "";
			}
			if (toDate != "" && toDate != null && !toDate.isEmpty() && toDate.equals("") && toDate.trim().length() >0) {
				appendtoDate = " AND q.to_date  <= '" + toDate + "' ";
			} else {
				appendtoDate = "";
			}


			String query = "select q.quotation_id, c.customer_name, q.c_date, q.c_user, q.quatation_type, q.exp_delivery_date from quotation q join customer c ON c.idcustomer = q.customer_ref_id where q.quatation_status = 'A' " + apendCustomerCode + apppendSalesExeCode + appendfromDate + appendtoDate;
			System.out.println("query is : " + query);

			try {
				session = entityManager.unwrap(Session.class);
				SessionImpl sessionImpl = (SessionImpl) session;
				connection = sessionImpl.connection();


				preparedStatement = connection.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					quotation = new ViewQuotation();
					quotation.setMarketingexeName(rs.getString("c_user"));
					quotation.setCreateDate(rs.getDate("c_date"));
					quotation.setCustomerName(rs.getString("customer_name"));
					quotation.setQuotationType(rs.getString("quatation_type"));
					quotation.setExpectedDelivery(rs.getDate("exp_delivery_date"));
					quotation.setQuotationId(rs.getInt("quotation_id"));

					quotationlist.add(quotation);


				}
				if (rs != null) {
					rs.close();
				}
				response = new Response("SUCCESS", 200, "sucessfully recived quotation details", quotationlist);

			} catch (Exception ex) {
				ex.printStackTrace();
				response = new Response("FAILS", 300, "Error on retriving quotation details" + ex, quotationlist);


			}
//			

		} else {

			response = new Response("FAILS", 300,"NULL value for quotation details", null);

		}

		return response;
	}

	@Override
	public Response getQuotationItemDetails(int quotationId) {
		Session session = null;
		List<GetQuotationItem> quotationItems = new ArrayList<>();
		Response response = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String quotation_type = null;
		String base_price = null;

		String query = "SELECT i.item_code,i.item_description,qi.item_ref_id,qi.amount,qi.quantity,qi.quotation_item_id, q.quatation_type from quotation q \n" +
				"join quotation_item qi on qi.quotation_ref_id = q.quotation_id\n" +
				"join item i on i.iditem = qi.item_ref_id where q.quotation_id = '"+quotationId+"'";
		System.out.println("query is : " + query);
		try {
			session = entityManager.unwrap(Session.class);
			SessionImpl sessionImpl = (SessionImpl) session;
			connection = sessionImpl.connection();


			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				GetQuotationItem quotationItem = new GetQuotationItem();
				quotationItem.setItemDesciption(rs.getString("item_description"));
				quotationItem.setItemCode(rs.getString("item_code"));
				quotationItem.setAmount(rs.getInt("amount"));
				quotationItem.setQuotationItemId(rs.getInt("quotation_item_id"));
				quotationItem.setItemRefId(rs.getInt("item_ref_id"));
				quotationItem.setQuantity(rs.getInt("quantity"));
				
				if(quotation_type == null) {
				
				quotation_type = rs.getString("quatation_type");
				
				
				}
				
				
				System.out.println("quotationItem.getItemRefId() is : " + quotationItem.getItemRefId());
				System.out.println("quotation_type is : " + quotation_type);
				if(quotation_type.equals("customer")) {
					
					String itemBaseValue = "SELECT customer_price FROM item where iditem = '"+quotationItem.getItemRefId()+"'";
					preparedStatement = connection.prepareStatement(itemBaseValue);
					ResultSet rs2 = preparedStatement.executeQuery();
					
					while (rs2.next()) {
						base_price = rs2.getString("customer_price");
						
					}
				} else if (quotation_type.equals("agent")) {
					
					String itemBaseValue = "SELECT dealer_price FROM item where iditem = '"+quotationItem.getItemRefId()+"'";
					preparedStatement = connection.prepareStatement(itemBaseValue);
					ResultSet rs2 = preparedStatement.executeQuery();
					
					while (rs2.next()) {
						base_price = rs2.getString("dealer_price");
						
					}
					
				} else if(quotation_type.equals("distributer")) {
					
					String itemBaseValue = "SELECT distributer_price FROM item where iditem = '"+quotationItem.getItemRefId()+"'";
					preparedStatement = connection.prepareStatement(itemBaseValue);
					ResultSet rs2 = preparedStatement.executeQuery();
					
					while (rs2.next()) {
						base_price = rs2.getString("distributer_price");
						
					}
					
				}
				quotationItem.setBasePrice(base_price);
				quotationItems.add(quotationItem);


			}
			if (rs != null) {
				rs.close();
			}
			String quotationTypeSearch = (quotation_type != null && !quotation_type.isEmpty() && !quotation_type.equals("") && quotation_type.trim().length() > 0) ? quotation_type.toLowerCase().trim() : quotation_type;
			

		
//			quotationItems = session.createCriteria(QuotationItem.class)
//							  .add(Restrictions.eq("quotationRefId",quotationId))
//							  .list();

//			Query query = session.createQuery("from QuotationItem q JOIN Item i ON i.iditem = q.itemRefId where q.quotationItemId = " + quotationId);
//			List <Object []> rows =  ((org.hibernate.query.Query) query).list();
//
//			for (Object[] row : rows) {
//				GetQuotationItem quotationItem = new GetQuotationItem();
//				quotationItem.setItemCode(row[0].toString());
//				quotationItem.setItemName(row[1].toString());
////				quotationItem.setQuotationItemId(Integer.parseInt(row[2].toString()));
////				quotationItem.setAmount(Integer.parseInt(row[3].toString()));
//				System.out.println("quotationItem is >>>>>>>>>>>>>>>>>>>>>>>> " + row[0].toString());
//				quotationItems.add(quotationItem);
//			}




			response = new Response("Success",200,"retrived item list successfully", quotationItems);
		}catch (Exception ex) {
			ex.printStackTrace();
			response = new Response("Error",300,"Error on retriving quotation items for QuotationId : " + quotationId + ex.getMessage(), quotationItems);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return response;
	}

	@Override
	public Response updateQuotationItemDetails(JSONArray itemString, int quotationId) {

		Session session = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		QuotationItem quotationItem = new QuotationItem();

		com.aptota.app.model.response.Response response = null;

		if (itemString != null && !itemString.equals("")) {

			String updateSQL = "update\n" +
					"        inventory_manager.quotation_item \n" +
					"    set\n" +
					"        amount=?, quantity=?,\n" +
				 //	"        item_ref_id=?,\n" +
				//  "        quotation_ref_id=? \n" +
					"    where\n" +
					"        quotation_item_id=? ";

			try {
				System.out.println("1");
				session = entityManager.unwrap(Session.class);
				System.out.println("With in the quotation updateSession" + itemString);

				for (int i = 0; i < itemString.length(); i++) {
					JSONObject obj = itemString.getJSONObject(i);

					String itemCode = obj.getString("itemCode");
					int quantity = obj.getInt("quantity");
					double amount = obj.getDouble("amount");
					int quotationItemId = obj.getInt("quotation_item_id");
					int itemrefId = obj.getInt("itemrefId");

					System.out.println("itemCode is : " + itemCode + "quantity : " + quantity + "quotation_item_id is " + quotationItemId + "amount is : " + amount);

//					quotationItem.setQuotationItemId(quotationItemId);
//					quotationItem.setItemRefId(itemrefId);
//					quotationItem.setAmount(quantity);
//					quotationItem.setQuotationRefId(quotationId);
//
//					session.beginTransaction();
//					session.saveOrUpdate(quotationItem);
//
//					session.getTransaction().commit();



					SessionImpl sessionImpl = (SessionImpl) session;
					connection = sessionImpl.connection();

					preparedStatement = connection.prepareStatement(updateSQL);
					preparedStatement.setDouble(1,amount);
					preparedStatement.setInt(2,quantity);
					//preparedStatement.setInt(3,quotationId);
					preparedStatement.setInt(3,quotationItemId);
					preparedStatement.executeUpdate();

				}

				response = new com.aptota.app.model.response.Response("SUCCESS", 200, "Item Saved successfully", quotationItem);


			} catch (Exception e) {
				response = new com.aptota.app.model.response.Response("FAILS", 300, "ERROR on Item registion ", null);
				e.printStackTrace();
				System.out.println("ERROR on Item registion");

			} finally {


				if (session != null && session.isOpen()) {

					session.close();

				}
			}
		} else {
			response = new com.aptota.app.model.response.Response("FAILS", 300, "Null Quotation Code foud ", null);

		}


		return response;
	}

	@Override
	public Response getQuotationById(int quotationId) {
		// TODO Auto-generated method stub
		Session session = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ViewQuotation quotation = null;
		Response response = null;
		System.out.println("quotation Id is : " + quotationId);
		if(quotationId != 0) {
		
			String query = "select q.quotation_id, c.customer_name, q.c_date, q.c_user, q.quatation_type, q.exp_delivery_date, q.amount from quotation q join customer c ON c.idcustomer = q.customer_ref_id where q.quatation_status = 'A' and q.quotation_id = " + quotationId;
			System.out.println("query is : " + query);
			System.out.println("query Id is : " + query);
			
			try {
				session = entityManager.unwrap(Session.class);
				SessionImpl sessionImpl = (SessionImpl) session;
				connection = sessionImpl.connection();


				preparedStatement = connection.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery();
				System.out.println("1 ");
				

				while (rs.next()) {
					quotation = new ViewQuotation();
					quotation.setMarketingexeName(rs.getString("c_user"));
					quotation.setCreateDate(rs.getDate("c_date"));
					quotation.setCustomerName(rs.getString("customer_name"));
					quotation.setQuotationType(rs.getString("quatation_type"));
					quotation.setExpectedDelivery(rs.getDate("exp_delivery_date"));
					quotation.setQuotationId(rs.getInt("quotation_id"));
					quotation.setTotalValue(rs.getDouble("amount"));

					//quotationlist.add(quotation);


				}
				if (rs != null) {
					rs.close();
				}
				response = new Response("SUCCESS", 200, "sucessfully recived quotation details", quotation);

			} catch (Exception ex) {
				ex.printStackTrace();
				response = new Response("FAILS", 300, "Error on retriving quotation details" + ex, quotation);


			}
//			

		} else {

			response = new Response("FAILS", 300,"NULL value for quotation details", null);

		}
		return response;
	}
}
