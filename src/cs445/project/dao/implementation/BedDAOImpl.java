package cs445.project.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cs445.project.base.Bed;
import cs445.project.base.BedState;
import cs445.project.dao.connection.DBConnectionFactory;
import cs445.project.dao.connection.ServiceLocatorException;

public class BedDAOImpl {
	private DBConnectionFactory services = null;
	
	public BedDAOImpl(DBConnectionFactory services) {
		this.services = services;
	}
	
	public void insert(Bed bed) throws SQLException,ServiceLocatorException {
		Connection con = null;
		
		try{				
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("insert into beds (hostelId,date,room,bed,price,state)"
					+ " values (?,?,?,?,?,?);");
			stmt.setInt(1, bed.getHostelId());
			stmt.setDate(2,new java.sql.Date( bed.getDate().getTime()));
			stmt.setInt(3,bed.getRoomNumber());
			stmt.setInt(4, bed.getBedNumber());
			stmt.setInt(5, bed.getPrice());
			stmt.setString(6, bed.getState().name());
			
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

	}
	
	
	public void insertBedList(List<Bed> beds) throws SQLException,ServiceLocatorException {
		Connection con = null;
		
		try{				
			con = services.createConnection();
			for(Bed bed: beds) {
				PreparedStatement stmt = con.prepareStatement("insert into beds (hostelId,date,room,bed,price,state)"
						+ " values (?,?,?,?,?,?);");
				stmt.setInt(1, bed.getHostelId());
				stmt.setDate(2,new java.sql.Date( bed.getDate().getTime()));
				stmt.setInt(3,bed.getRoomNumber());
				stmt.setInt(4, bed.getBedNumber());
				stmt.setInt(5, bed.getPrice());
				stmt.setString(6, bed.getState().name());
				
				stmt.execute();
				stmt.close();
			}
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
	
	public void updateBedList(List<Bed> beds) throws SQLException,ServiceLocatorException {
		Connection con = null;
		
		try{				
			con = services.createConnection();
			for(Bed bed: beds) {
				PreparedStatement stmt = con.prepareStatement("update beds set price=? "
						+ " where hostelId=? and date=? and room=? and bed=?;");
				stmt.setInt(1, bed.getPrice());
				stmt.setInt(2,bed.getHostelId());
				stmt.setDate(3,new java.sql.Date( bed.getDate().getTime()));
				stmt.setInt(4,bed.getRoomNumber());
				stmt.setInt(5, bed.getBedNumber());
				
				if (stmt.executeUpdate() == 0) {
					insert(bed);
				}
				stmt.close();
			}
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
	
	public void updateBedStatus(List<Bed> beds) throws SQLException,ServiceLocatorException {
		Connection con = null;
		
		try{				
			con = services.createConnection();
			for(Bed bed: beds) {
				PreparedStatement stmt = con.prepareStatement("update beds set state=? "
						+ " where hostelId=? and date=? and room=? and bed=?;");
				stmt.setString(1, bed.getState().name());
				stmt.setInt(2,bed.getHostelId());
				stmt.setDate(3,new java.sql.Date( bed.getDate().getTime()));
				stmt.setInt(4,bed.getRoomNumber());
				stmt.setInt(5, bed.getBedNumber());
				
				if (stmt.executeUpdate() == 0) {
					insert(bed);
				}
				stmt.close();
			}
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
	
	public List<Bed> findBedsInHostel(Integer hostelId)
			throws SQLException,ServiceLocatorException {
		List<Bed> beds =  new ArrayList<Bed>();
		Connection con = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select *  from beds "
					+ " where hostelId = ?;");
			stmt.setInt(1, hostelId);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				beds.add(createBedInstance(rs));
			}
			stmt.close();
			rs.close();
		}
		finally {
			if(con != null){
				con.close();			
		    }
		}
		return beds;
	}
	
	public List<Bed> findAvailableBedsInHostel(Integer hostelId,Date startDate,Date endDate)
			throws SQLException,ServiceLocatorException {
		List<Bed> beds =  new ArrayList<Bed>();
		Connection con = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select *  from beds "
					+ " where hostelId = ? and date>=? and date<? and state=?;");
			stmt.setInt(1, hostelId);
			stmt.setDate(2, new java.sql.Date(startDate.getTime()));
			stmt.setDate(3, new java.sql.Date(endDate.getTime()));
			stmt.setString(4, BedState.AVAILABLE.name());
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				beds.add(createBedInstance(rs));
			}
			stmt.close();
			rs.close();
		}
		finally {
			if(con != null){
				con.close();			
		    }
		}
		return beds;
	}
	
	 Bed createBedInstance(ResultSet rs) throws SQLException, ServiceLocatorException {
		Bed bed = new Bed();
		
		bed.setHostelId(rs.getInt("hostelId"));
		bed.setDate(rs.getDate("date"));
		bed.setRoomNumber(rs.getInt("room"));
		bed.setBedNumber(rs.getInt("bed"));
		bed.setPrice(rs.getInt("price"));
		bed.setState(BedState.valueOf(rs.getString("state")));
				
		return bed;
		
	}
	
}
