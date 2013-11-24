package cs445.project.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cs445.project.base.User;
import cs445.project.dao.connection.DBConnectionFactory;
import cs445.project.dao.connection.ServiceLocatorException;

public class UserDAOImpl {
	private DBConnectionFactory services = null;
	
	public UserDAOImpl(DBConnectionFactory services) {
		this.services = services;
	}
	
	public Integer insert(User user) throws ServiceLocatorException,
	SQLException {
		Integer userId=0;
		Connection con = null;
		try{
			userId = getMaxUserId()+1;
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("insert into users (userId,firstName,lastName,email,"
					+"ccNumber,expirationDate,securityCode,phone) values (?,?,?,?,?,?,?,?);");
			stmt.setInt(1,userId);
			stmt.setString(2,user.getFirstName());
			stmt.setString(3,user.getLastName());
			stmt.setString(4,user.getEmail());
			stmt.setString(5,user.getCcNumber());
			stmt.setDate(6,new java.sql.Date(user.getCcExpiryDate().getTime()));
			stmt.setInt(7, user.getSecurityCode());
			stmt.setString(8, user.getPhone());

			stmt.execute();
			stmt.close();
		}catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			 if(con != null){
				 con.close();
			 }
		}		
		return userId;
	}
	
	public void update(User user) throws ServiceLocatorException,
	SQLException {
		Connection con = null;		
		try{			
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement(" update users set firstName=?,lastName=?,email=?,ccNumber=?,"
					+"expirationDate=?,securityCode=?,phone=? where userId=?");			

			stmt.setString(1,user.getFirstName());
			stmt.setString(2,user.getLastName());
			stmt.setString(3,user.getEmail());
			stmt.setString(4,user.getCcNumber());
			stmt.setDate(5,new java.sql.Date(user.getCcExpiryDate().getTime()));
			stmt.setInt(6, user.getSecurityCode());
			stmt.setString(7, user.getPhone());
			stmt.setInt(8,user.getUserId());
			
			stmt.executeUpdate(); 
			stmt.close();
		}catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			 if(con != null){
				 con.close();
			 }
		}
	}
	
	public User getUserById(Integer userId) throws SQLException {
		Connection con = null;
		User user =  null;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from users where userId = ?;");
			stmt.setInt(1, userId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				user = createUserInstance(rs);
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			if(con!=null){
				con.close();
			}
		}	
		
		return user;
	}
	
	public List<User> getAllUsers() throws SQLException {
		Connection con = null;
		List<User> users = new ArrayList<User>();
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from users ;");
			
			ResultSet rs = stmt.executeQuery();
			User user;
			while(rs.next()){
				user = createUserInstance(rs);
				users.add(user);
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			if(con!=null){
				con.close();
			}
		}
		
		return users;
	}
	
	User createUserInstance(ResultSet rs) throws SQLException {
		User user = new User();
		
		user.setUserId(rs.getInt("userId"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setEmail(rs.getString("email"));
		user.setCcNumber(rs.getString("ccNumber"));
		user.setCcExpiryDate(rs.getDate("expirationDate"));
		user.setSecurityCode(rs.getInt("securityCode"));
		user.setPhone(rs.getString("phone"));
		
		return user;
	}
	
	private Integer getMaxUserId() throws SQLException {
		Integer maxUserId =0;
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select max(userId) from users;");			
			ResultSet rs =  stmt.executeQuery(); 
			if(rs.next())
				maxUserId = rs.getInt(1);
			
			stmt.close();		
		}catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			 if(con != null){
				 con.close();
			 }
		}
		
		return maxUserId;
	}
}