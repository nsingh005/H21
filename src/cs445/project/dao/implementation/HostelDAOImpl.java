package cs445.project.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cs445.project.base.Bed;
import cs445.project.base.Hostel;
import cs445.project.dao.connection.DBConnectionFactory;
import cs445.project.dao.connection.ServiceLocatorException;

public class HostelDAOImpl {
	private DBConnectionFactory services = null;
	
	public HostelDAOImpl(DBConnectionFactory services) {
		this.services = services;
	}
	
	public Integer insert(Hostel hostel) throws ServiceLocatorException,
		SQLException {
		Integer    hostelId = 0;
		Connection con = null;
		
		try{
			hostelId = getMaxHostelId() +1;
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("insert into hostel (hostelId,name,addressId,policyId,contactId) "
					+ " values (?,?,?,?,?);");
			stmt.setInt(1, hostelId);
			stmt.setString(2,hostel.getName());
			stmt.setInt(3,hostel.getAddress().getAddressId());
			stmt.setInt(4,hostel.getPolicy().getPolicyId());
			stmt.setInt(5,hostel.getContact().getContactId());
						
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
		
		return hostelId;
	}
	
	public void update(Hostel hostel) throws ServiceLocatorException,
		SQLException {
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("update hostel set name=?,addressId=?,policyId=?,contactId=? "
					+ " where hostelId=?;");
			
			stmt.setString(1,hostel.getName());
			stmt.setInt(2,hostel.getAddress().getAddressId());
			stmt.setInt(3,hostel.getPolicy().getPolicyId());
			stmt.setInt(4,hostel.getContact().getContactId());
			stmt.setInt(5,hostel.getHostelId());
			
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
	
	public Hostel getHostelById(Integer hostelId)
			throws ServiceLocatorException, SQLException {
		Connection con = null;
		Hostel hostel =  null;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from hostel "
					+" inner join address using (addressId) "
					+" inner join contact using (contactId) "
					+" inner join policy using (policyId) "
					+" where hostelId = ?;");
			stmt.setInt(1, hostelId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				hostel = createHostelInstance(rs);
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				con.close();
			}
		}	
		
		return hostel;
	}
	
	public List<Hostel> getAllHostel()
			throws ServiceLocatorException, SQLException {
		Connection con = null;
		List<Hostel> hostels =  new ArrayList<Hostel>();
		
		try{
			Hostel hostel;
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from hostel "
					+" inner join address using (addressId) "
					+" inner join contact using (contactId) "
					+" inner join policy using (policyId) ");
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				hostel = createHostelInstance(rs);
				hostels.add(hostel);
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				con.close();
			}
		}	
		
		return hostels;
	}
	
	public List<Hostel> getAvailableBedsInAllHostels(Date startDate, Date endDate)
			throws ServiceLocatorException, SQLException {
		Connection con = null;
		List<Hostel> hostels =  new ArrayList<Hostel>();
		
		try{
			Hostel hostel;
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from hostel "
					+" inner join address using (addressId) "
					+" inner join contact using (contactId) "
					+" inner join policy using (policyId) ");
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				hostel = createHostelInstanceAvlBeds(rs,startDate,endDate);
				hostels.add(hostel);
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				con.close();
			}
		}	
		
		return hostels;
	}
	
	Hostel createHostelInstanceAvlBeds (ResultSet rs,Date startDate,Date endDate) throws SQLException {
		Hostel hostel = new Hostel();
		hostel.setHostelId(rs.getInt("hostelId"));
		hostel.setName(rs.getString("name"));
		hostel.setAddress(new AddressDAOImpl(services).createAddressInstance(rs));
		hostel.setContact(new ContactDAOImpl(services).createContactInstance(rs));
		hostel.setPolicy(new PolicyDAOImpl(services).createHostelPolicyInstance(rs));
		
		BedDAOImpl bedDAO = new BedDAOImpl(services);
		List<Bed> beds = null;
		try {
			beds = bedDAO.findAvailableBedsInHostel(rs.getInt("hostelId"), startDate, endDate);
		} catch (ServiceLocatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hostel.setBeds(beds);
		
		return hostel;		
	}
	
	Hostel createHostelInstance (ResultSet rs) throws SQLException {
		Hostel hostel = new Hostel();
		hostel.setHostelId(rs.getInt("hostelId"));
		hostel.setName(rs.getString("name"));
		hostel.setAddress(new AddressDAOImpl(services).createAddressInstance(rs));
		hostel.setContact(new ContactDAOImpl(services).createContactInstance(rs));
		hostel.setPolicy(new PolicyDAOImpl(services).createHostelPolicyInstance(rs));
		
		BedDAOImpl bedDAO = new BedDAOImpl(services);
		List<Bed> beds = null;
		try {
			beds = bedDAO.findBedsInHostel(rs.getInt("hostelId"));
		} catch (ServiceLocatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hostel.setBeds(beds);
		
		return hostel;		
	}
	
	private Integer getMaxHostelId() throws ServiceLocatorException,
	SQLException {
		Integer hostelId = 0;
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select max(hostelId) from hostel;");			
			ResultSet rs =  stmt.executeQuery(); 
			if(rs.next())
				hostelId = rs.getInt(1);
			
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
		
		return hostelId;		
	}
}
