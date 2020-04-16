package com.aptota.app.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.aptota.app.dao.UserDao;
import com.aptota.app.model.Item;
import com.aptota.app.model.User;
import com.aptota.app.model.UserRole;
import com.aptota.app.model.UIModel.UIUser;
import com.aptota.app.model.response.Response;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Response saveWebUser(UIUser webUserModel, String userName) {
		Session session = null;
		Response response = null; 
		
		PreparedStatement preparedStatement = null;
        Transaction tx = null;
        int resCode;
        String resDes;
        String status;
        System.out.println(">>>>>>>>>> : 1 ");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(webUserModel.getPassword());
        String username = (webUserModel.getUname() != null && !webUserModel.getUname().isEmpty() && !webUserModel.getUname().equals("") && webUserModel.getUname().trim().length() > 0) ? webUserModel.getUname().toLowerCase().trim() : webUserModel.getUname();
        User user = new User();

        user.setPassword(hashedPassword);
        user.setUsername(username);
        user.setFname(webUserModel.getFname());
        user.setLname(webUserModel.getLname());
        user.setContact(webUserModel.getContactNo());
        //user.setBranchCode(webUserModel.getBranchCode());
        user.setEnabled(true);
		
        if(user != null) {
        	
        	System.out.println(">>>>>>>>>> : 2 ");
            
		
		try {
			
			session = entityManager.unwrap(Session.class);
			tx = session.beginTransaction();
			UIUser user2 = (UIUser) session.createCriteria(UIUser.class)
                    .add(Restrictions.eq("uname", username))
                    .uniqueResult();
            System.out.println(">>>>>>>>>> : 3 " + user2 + "session is : " + session);
            if (user2 == null) {
                System.out.println(">>>>>>>>>> : 3 ");
                Integer userId = 1;
                userId =(Integer)session.save(user);
                tx.commit();
                resCode = 300;
                resDes = "saveAgent without user role";
                status = "FAILS";
                //logger.info("saveAgent Fails");
                response = new Response(status,resCode,resDes,user);
                System.out.println("with in user registration : " + userId);
                if (userId > 0) {
                    System.out.println("with in user type registration : " + userId);
                    response = registerUserRole(userId, webUserModel);
                    System.out.println("response with in user type registration : " + response.getMessage());
                    resCode = 200;
                    resDes = "saveAgent Success";
                    status = "SUCCESS";
                    response = new Response(status,resCode,resDes,user);
                }
            } else {
                System.out.println("out of user type registration : ");
                resCode = 304;
                resDes = "User already exsits";
                status = "FAILS";
                //logger.info("User already exsits");
                response = new Response(status,resCode,resDes,user2);

            }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resCode = 304;
            resDes = "error on user creation : " + e;
            status = "FAILS";
            response = new Response(status,resCode,resDes,null);
			
		}
		
	  } else {

          resCode = 300;
          resDes = "App User Data is null";
          status = "FAILS";
         // logger.info("App User Data is null");
          response = new Response(status,resCode,resDes,null);
      }
		return response;
	}

	
	 @Transactional
     public Response registerUserRole(Integer userId, UIUser appU) {
         // TODO Auto-generated method stub
         // System.out.println("inside the user role");
         Transaction tx = null;
         String msg = "";
         UserRole userRole = null;
         //RecoveryTblUser insuranceUser = findByUserName(username);
         userRole = new UserRole();
         Session session = null;
         String userselected = (appU.getUserRole() != null && !appU.getUserRole().isEmpty() && !appU.getUserRole().equals("") && appU.getUserRole().trim().length() > 0) ? appU.getUserRole().toLowerCase().trim() : "default";
         Response response = null;
         int resCode;
         String resDes;
         String status;
         
//         <option value="SuperAdmin">Super Admin</option>
//         <option value="Admin">Admin</option>
//         <option value="Accountant">Accountant</option>
//         <option value="MarketingMng">Marketing Manager</option>
//         <option value="SalesExcecutive">MSales Executive</option>
//         <option value="Coordinator">Coordinator</option>
//         <option value="Stores">Stores</option>

         if (userselected.equalsIgnoreCase("admin")) {
             System.out.println("set user role : : ROLE_ADMIN");
             userRole.setRole("ROLE_ADMIN");
         } else if (userselected.equalsIgnoreCase("SuperAdmin")) {
             // USERROLE.SETROLE("ROLE_ADMIN");
             System.out.println("set user role : : ROLE_SUPERADMIN");
             userRole.setRole("ROLE_SUPERADMIN");
         }else if (userselected.equalsIgnoreCase("Accountant")) {
             // USERROLE.SETROLE("ROLE_ADMIN");
             System.out.println("set user role : : ROLE_ACCOUNTANT");
             userRole.setRole("ROLE_ACCOUNTANT");
         }else if (userselected.equalsIgnoreCase("MarketingMng")) {
             // USERROLE.SETROLE("ROLE_ADMIN");
             System.out.println("set user role : : ROLE_MARKETING_MGT");
             userRole.setRole("ROLE_MARKETING_MGT");
         }else if (userselected.equalsIgnoreCase("SalesExcecutive")) {
             // USERROLE.SETROLE("ROLE_ADMIN");
             System.out.println("set user role : : ROLE_SALES_EXEC");
             userRole.setRole("ROLE_SALES_EXEC");
         }else if (userselected.equalsIgnoreCase("Coordinator")) {
             // USERROLE.SETROLE("ROLE_ADMIN");
             System.out.println("set user role : : ROLE_COORDINATOR");
             userRole.setRole("ROLE_COORDINATOR");
         } else if (userselected.equalsIgnoreCase("Stores")) {
             System.out.println("set user role : : ROLE_STORES");
             userRole.setRole("ROLE_STORES");
         }else if (userselected.equalsIgnoreCase("SalesPerson")) {
             System.out.println("set user role : : SALES_PERSON");
             userRole.setRole("SALES_PERSON");
         } else {
             System.out.println("set user role : : NOT_DEFINED");
             userRole.setRole("NOT_DEFINED");
             resCode = 300;
             resDes = "Save App User Failed invalid user role";
             status = "FAILS";
           //  logger.error("Save App User Failed invalid user role");
             return response = new Response(status, resCode, null, resDes);

         }

         userRole.setUserid(userId);
         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>Save user role userRole.getRole() is : " + userRole.getRole() + "and userRole.getUserId() is : " + userId);


         try {

             session = entityManager.unwrap(Session.class);
             System.out.println("Save user role  session attrbute is : " + session + "and user is : " + userRole);
             tx = session.beginTransaction();
             System.out.println("userRole is : " + userRole);
             session.save(userRole);
             tx.commit();
             msg = "Registration Successfull!";
             resCode = 200;
             resDes = "Registration Successfull!";
             status = "SUCCESS";
            // logger.error("Registration Successfull");
             response = new Response(status, resCode, null, resDes);

         } catch (Exception e) {

            // logger.error(e.getMessage());
             if (tx != null) {
                 tx.rollback();
             }
             resCode = 300;
             resDes = "Registration Failed, with User role  " + e;
             status = "FAILS";
             //logger.error("Registration Failed, with User role " + e);
             System.out.println("Registration Failed, with User role " + e);
             response = new Response(status, resCode, null, resDes);
         } finally {

             if (session != null && session.isOpen()) {
                 session.close();
             }
         }

         return response;
     }

	@Override
	@Transactional
	public String findUserRoleById(int roleId) {
		Session session = null;
		List<UserRole> role;
		UserRole userrole = new UserRole();
		String roleName ="";
		
		 try {

             session = entityManager.unwrap(Session.class);
             Query query = session.createQuery("from UserRole where userid=:userId");
 			 role = (List<UserRole>) query.setParameter("userId", roleId).list();
             //System.out.println("Save user role  session attrbute is : " + session + "and user is : " + userRole);
             
         	if (role.size() > 0) {
				userrole = role.get(0);
			}
         
          roleName = userrole.getRole();
          
          System.out.println("user Role on method call : " + roleName);

         } catch (Exception e) {
        	 
        	 System.out.println(e.getMessage());
        	 e.printStackTrace();

           //logger.error(e.getMessage());
           
         } finally {

             if (session != null && session.isOpen()) {
                 session.close();
             }
         }
		return roleName;
	}


    @Override
    public List<User> getAllExecutiveUsers() {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        Session session = null;
        List<User> salesexecutives = new ArrayList<>();
        try {
            session = entityManager.unwrap(Session.class);
            Query query = session.createQuery("SELECT u.id, u.username from User u JOIN UserRole r ON r.userid = u.id WHERE r.role = 'ROLE_SALES_EXEC'");
            List <Object []> rows =  query.list();

            for (Object[] row : rows) {

                User u1 = new User();
                u1.setId(Integer.parseInt(row[0].toString()));
                u1.setUsername(row[1].toString());

                salesexecutives.add(u1);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        } finally {

            if(session != null && session.isOpen()) {

                session.close();
            }
        }

        return salesexecutives;

    }


	@Override
	public Response saveSalesPerson(UIUser agentUserModel, String userName) {
		Session session = null;
		Response response = null; 
		
		PreparedStatement preparedStatement = null;
        Transaction tx = null;
        int resCode;
        String resDes;
        String status;
        System.out.println(">>>>>>>>>> : 1 ");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(agentUserModel.getPassword());
        String username = (agentUserModel.getUname() != null && !agentUserModel.getUname().isEmpty() && !agentUserModel.getUname().equals("") && agentUserModel.getUname().trim().length() > 0) ? agentUserModel.getUname().toLowerCase().trim() : agentUserModel.getUname();
        User user = new User();

        user.setPassword(hashedPassword);
        user.setUsername(username);
        user.setFname(agentUserModel.getFname());
        user.setLname(agentUserModel.getLname());
        user.setContact(agentUserModel.getContactNo());
        user.setSalesPerson(true);
        user.setEnabled(true);
		
        if(user != null) {
        	
        	System.out.println(">>>>>>>>>> : 2 ");
            
		
		try {
			
			session = entityManager.unwrap(Session.class);
			tx = session.beginTransaction();
			UIUser user2 = (UIUser) session.createCriteria(UIUser.class)
                    .add(Restrictions.eq("uname", username))
                    .uniqueResult();
            System.out.println(">>>>>>>>>> : 3 " + user2 + "session is : " + session);
            if (user2 == null) {
                System.out.println(">>>>>>>>>> : 3 ");
                Integer userId = 1;
                userId =(Integer)session.save(user);
                tx.commit();
                resCode = 300;
                resDes = "saveAgent without user role";
                status = "FAILS";
                //logger.info("saveAgent Fails");
                response = new Response(status,resCode,resDes,user);
                System.out.println("with in user registration : " + userId);
                if (userId > 0) {
                    System.out.println("with in user type registration : " + userId);
                    agentUserModel.setUserRole("SalesPerson");
                    response = registerUserRole(userId, agentUserModel);
                    System.out.println("response with in user type registration : " + response.getMessage());
                    resCode = 200;
                    resDes = "saveAgent Success";
                    status = "SUCCESS";
                    response = new Response(status,resCode,resDes,user);
                }
            } else {
                System.out.println("out of user type registration : ");
                resCode = 304;
                resDes = "User already exsits";
                status = "FAILS";
                //logger.info("User already exsits");
                response = new Response(status,resCode,resDes,user2);

            }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resCode = 304;
            resDes = "error on user creation : " + e;
            status = "FAILS";
            response = new Response(status,resCode,resDes,null);
			
		}
		
	  } else {

          resCode = 300;
          resDes = "App User Data is null";
          status = "FAILS";
         // logger.info("App User Data is null");
          response = new Response(status,resCode,resDes,null);
      }
		return response;
	}


	@Override
	public List<User> getAllSalesPersons() {
		// TODO Auto-generated method stub
		 Session session = null;
		 List<User> salesPerson = new ArrayList<>();
		 try {
			 Query query = session.createQuery("SELECT u.id, u.username,u.fname, u.lname, u.contact from User u WHERE u.salesPerson is true");
	            List <Object []> rows =  query.list();

	            for (Object[] row : rows) {

	                User u1 = new User();
	                u1.setId(Integer.parseInt(row[0].toString()));
	                u1.setUsername(row[1].toString()); 
	                u1.setContact(row[2].toString());
	                u1.setFname(row[3].toString());
	                u1.setLname(row[4].toString());
	                salesPerson.add(u1);
	            }
	            
		 }
		 	catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			} finally {
				
				if(session != null && session.isOpen()) {
					
					session.close();
//				}
			}
				
			}
		 
		 return salesPerson;
	}
	


}
