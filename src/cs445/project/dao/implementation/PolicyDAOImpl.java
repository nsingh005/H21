package cs445.project.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cs445.project.base.Policy;
import cs445.project.dao.connection.DBConnectionFactory;
import cs445.project.dao.connection.ServiceLocatorException;

public class PolicyDAOImpl {

	private DBConnectionFactory services = null;
	
	public PolicyDAOImpl(DBConnectionFactory services) {
		this.services = services;
	}
	
	public Integer insert(Policy policy) throws ServiceLocatorException,
	SQLException {
		Integer policyId=0;
		Connection con = null;
		try{
			policyId = getMaxPolicyId()+1;
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("insert into policy (policyId,checkInTime,checkOutTime,smoking,alcohol,"
					+ "cancellationDeadline,cancellationPenalty) "
					+ " values (?,?,?,?,?,?,?);");
			stmt.setInt(1,policyId);
			stmt.setString(2,policy.getCheckInTime());
			stmt.setString(3,policy.getCheckOutTime());
			stmt.setBoolean(4,policy.isSmoking());
			stmt.setBoolean(5,policy.isAlcohol());
			stmt.setInt(6, policy.getCancellationDeadline());
			stmt.setInt(7, policy.getCancellationPenalty());
			
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
		
		return policyId;

	}
	
	public void update(Policy policy) throws ServiceLocatorException,
	SQLException {
		Connection con = null;		
		try{			
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement(" update policy set checkInTime=?,checkOutTime=?,smoking=?,alcohol=?,"
					+ "cancellationDeadline=?,cancellationPenalty=? "
					+" where policyId=?");
			
			stmt.setString(1,policy.getCheckInTime());
			stmt.setString(2,policy.getCheckOutTime());
			stmt.setBoolean(3,policy.isSmoking());
			stmt.setBoolean(4,policy.isAlcohol());
			stmt.setInt(5, policy.getCancellationDeadline());
			stmt.setInt(6, policy.getCancellationPenalty());
			stmt.setInt(7,policy.getPolicyId());
			
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
	
	public Policy getHostelPolicy(Integer policyId)
			throws ServiceLocatorException, SQLException {
		Connection con = null;
		Policy policy =  null;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from policy where policyId = ?;");
			stmt.setInt(1, policyId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				policy = createHostelPolicyInstance(rs);
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
		
		return policy;
	}
	
	Policy createHostelPolicyInstance (ResultSet rs) throws SQLException {
		Policy policy = new Policy();
		
		policy.setPolicyId(rs.getInt("policyId"));
		policy.setCheckInTime(rs.getString("checkInTime"));
		policy.setCheckOutTime(rs.getString("checkOutTime"));
		policy.setSmoking(rs.getBoolean("smoking"));
		policy.setAlcohol(rs.getBoolean("alcohol"));
		policy.setCancellationDeadline(rs.getInt("cancellationDeadline"));
		policy.setCancellationPenalty(rs.getInt("cancellationPenalty"));
		
		return policy;
		
	}
	
	private Integer getMaxPolicyId() throws ServiceLocatorException,
	SQLException {
		Integer policyId = 0;
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select max(policyId) from policy;");			
			ResultSet rs =  stmt.executeQuery(); 
			if(rs.next())
				policyId = rs.getInt(1);
			
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
		
		return policyId;		
	}	
}
