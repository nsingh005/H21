package cs445.project.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cs445.project.base.Address;
import cs445.project.dao.connection.DBConnectionFactory;
import cs445.project.dao.connection.ServiceLocatorException;



public class AddressDAOImpl {
	private DBConnectionFactory services = null;
	
	public AddressDAOImpl(DBConnectionFactory services) {
		this.services = services;
	}
	
	public Integer insert(Address address) throws ServiceLocatorException,
		SQLException {
		Integer    addressId = 0;
		Connection con = null;
		
		try{
			addressId = getMaxAddressId() +1;
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("insert into address (addressId,street,city,state,postalCode,"
					+ "country) values (?,?,?,?,?,?);");
			stmt.setInt(1, addressId);
			stmt.setString(2,address.getStreet());
			stmt.setString(3,address.getCity());
			stmt.setString(4,address.getState());
			stmt.setString(5,address.getPostalCode());
			stmt.setString(6,address.getCountry());
			
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
		
		return addressId;
	}
	
	public void update(Address address) throws ServiceLocatorException,
		SQLException {
		Connection con = null;
		
		try{			
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("update address set street=?,city=?,state=?,postalCode=?,"
					+ "country=? where addressId=?;");
			
			stmt.setString(1,address.getStreet());
			stmt.setString(2,address.getCity());
			stmt.setString(3,address.getState());
			stmt.setString(4,address.getPostalCode());
			stmt.setString(5,address.getCountry());
			stmt.setInt(6, address.getAddressId());
			
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
	
	public Address getAddressById(Integer addressId)
			throws ServiceLocatorException, SQLException {
		Connection con = null;
		Address address =  null;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from address where addressId = ?;");
			stmt.setInt(1, addressId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				address = createAddressInstance(rs);
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
		
		return address;
	}
	
	Address createAddressInstance (ResultSet rs) throws SQLException {
		Address address = new Address();
		address.setAddressId(rs.getInt("addressId"));
		address.setCity(rs.getString("city"));
		address.setCountry(rs.getString("country"));
		address.setPostalCode(rs.getString("postalCode"));
		address.setState(rs.getString("state"));
		address.setStreet(rs.getString("street"));
		
		return address;		
	}
	
	private Integer getMaxAddressId() throws ServiceLocatorException,
	SQLException {
		Integer addressId = 0;
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select max(addressId) from address;");			
			ResultSet rs =  stmt.executeQuery(); 
			if(rs.next())
				addressId = rs.getInt(1);
			
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
		
		return addressId;		
	}
}
