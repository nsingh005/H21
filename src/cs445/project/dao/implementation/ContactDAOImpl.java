package cs445.project.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cs445.project.base.Contact;
import cs445.project.dao.connection.DBConnectionFactory;
import cs445.project.dao.connection.ServiceLocatorException;

public class ContactDAOImpl {
	private DBConnectionFactory services = null;
	
	public ContactDAOImpl(DBConnectionFactory services) {
		this.services = services;
	}
	
	public Integer insert(Contact contact) throws ServiceLocatorException,
		SQLException {
		Integer    contactId = 0;
		Connection con = null;
		
		try{
			contactId = getMaxContactId() +1;
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("insert into contact (contactId,phone,email,facebook,"
					+ "webURL) values (?,?,?,?,?);");
			stmt.setInt(1, contactId);
			stmt.setString(2,contact.getPhoneNumber());
			stmt.setString(3,contact.getEmailId());
			stmt.setString(4,contact.getFacebookId());
			stmt.setString(5,contact.getWebURL());
			
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
		
		return contactId;
	}
	
	public void update(Contact contact) throws ServiceLocatorException,
		SQLException {
		
		Connection con = null;
		
		try{			
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("update contact set phone=?,email=?,facebook=?,"
					+ "webURL=? where contactId=?;");
			
			stmt.setString(2,contact.getPhoneNumber());
			stmt.setString(3,contact.getEmailId());
			stmt.setString(4,contact.getFacebookId());
			stmt.setString(5,contact.getWebURL());
			stmt.setInt(1, contact.getContactId());
			
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
	
	public Contact getContactById(Integer contactId)
			throws ServiceLocatorException, SQLException {
		Connection con = null;
		Contact contact =  null;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from contact where contactId = ?;");
			stmt.setInt(1, contactId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				contact = createContactInstance(rs);
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				con.close();
			}
		}	
		
		return contact;
	}
	
	Contact createContactInstance (ResultSet rs) throws SQLException {
		Contact contact = new Contact();
		contact.setContactId(rs.getInt("contactId"));
		contact.setPhoneNumber(rs.getString("phone"));
		contact.setEmailId(rs.getString("email"));
		contact.setFacebookId(rs.getString("facebook"));
		contact.setWebURL(rs.getString("webURL"));
		
		return contact;
		
	}
	private Integer getMaxContactId() throws ServiceLocatorException,
	SQLException {
		Integer contactId = 0;
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select max(contactId) from contact;");			
			ResultSet rs =  stmt.executeQuery(); 
			if(rs.next())
				contactId = rs.getInt(1);
			
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
		
		return contactId;		
	}
}
