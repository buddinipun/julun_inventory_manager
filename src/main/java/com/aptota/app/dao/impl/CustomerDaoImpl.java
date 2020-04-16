package com.aptota.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aptota.app.dao.CustomerDao;
import com.aptota.app.model.Customer;
import com.aptota.app.model.response.Response;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	

	@PersistenceContext
	private EntityManager eneitymanager;

	@Override
	public Response saveCustomer(Customer customer) {
		
		Session session = null;
		Response response = null;
		String username = (customer.getCustomerName() != null && !customer.getCustomerName().isEmpty() && !customer.getCustomerName().equals("") && customer.getCustomerName().trim().length() > 0) ? customer.getCustomerName().toLowerCase().trim() : customer.getCustomerName();
	       
		
	try {
	
		session = eneitymanager.unwrap(Session.class);
		//System.out.println(session);
		
		Customer exsitingCust = (Customer) session.createCriteria(Customer.class)
		.add(Restrictions.disjunction())
		.add(Restrictions.eq("nic", customer.getNic()))
		.add(Restrictions.eq("customerName", username))
		.add(Restrictions.eq("contact1", customer.getContact1()))
		.uniqueResult();
		
		if(exsitingCust == null ) {
			
			session.save(customer);
			
			response = new Response("SUCCESS", 200, "Customer registered successfully", customer);
		}
		
		else {
			
			response = new Response("FAILS", 304, "Exsisting Customer " , customer);
		}
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		response = new Response("FAILS", 300, "ERROR on Customer registion " , customer);
		} finally {
			if(session != null && session.isOpen()) {
				
				session.close();
			}
		}
		return response;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = eneitymanager.unwrap(Session.class);
			 return session.createCriteria(Customer.class)
			 .list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			
//			if(session != null && session.isOpen()) {
//				
//				session.close();
//			}
		}
	}

	@Override
	public List<String> searchCustomer(String q) {
		// TODO Auto-generated method stub
		List<String> usernames = new ArrayList<String>();

		Session session = eneitymanager.unwrap(Session.class);
		Query query = session
				.createQuery("select  c.nic from Customer c where c.nic like ?0");
		//query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		usernames  = query.setParameter(0, "%" + q + "%").list();



		return usernames;
	}

    @Override
    public Response getCustomerByNic(String nic) {
        Session session = null;
        Response response = null;
	    try {

            session = eneitymanager.unwrap(Session.class);

            Customer exsitingCust = (Customer) session.createCriteria(Customer.class)
                    .add(Restrictions.disjunction())
                    .add(Restrictions.eq("nic", nic))
                    .uniqueResult();

            response = new Response("SUCCESS",200,"successfuly recived customer details of nic : " + nic, exsitingCust);

        }catch (Exception ex) {
	        ex.printStackTrace();

            response = new Response("FAILS",300,"Error on  customer details of nic : " + nic + " : " + ex.getMessage() , null);

        }
        return response;
    }


}
