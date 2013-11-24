package cs445.project.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cs445.project.base.Bed;
import cs445.project.base.BedState;
import cs445.project.dao.connection.DBConnectionFactory;
import cs445.project.dao.connection.ServiceLocatorException;
import cs445.project.structs.SearchResult;

public class SearchDAOImpl {
	private DBConnectionFactory services = null;
	
	public SearchDAOImpl(DBConnectionFactory services) {
		this.services = services;
	}
	
	public void insert(List<SearchResult> searchResultSet) throws SQLException {
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt;
			
			for(SearchResult searchResult: searchResultSet) {
				stmt = con.prepareStatement("insert into search_result (searchId,hostelId,hostelName,startDate,endDate,totalPrice) "
						+ " values (?,?,?,?,?,?);");
				stmt.setInt(1, searchResult.getSearchId());
				stmt.setInt(2, searchResult.getHostelId());
				stmt.setString(3,searchResult.getHostelName());
				stmt.setDate(4,new java.sql.Date(searchResult.getStartDate().getTime()));
				stmt.setDate(5,new java.sql.Date(searchResult.getEndDate().getTime()));
				stmt.setInt(6,searchResult.getTotalPrice());
				
				stmt.execute();
				stmt.close();
				
				for(Bed bed: searchResult.getBeds()) {
					stmt = con.prepareStatement("insert into searched_beds (searchId,room,bed,price,state,hostelId,date) " +
							" values (?,?,?,?,?,?,?);");
					stmt.setInt(1, searchResult.getSearchId());
					stmt.setInt(2, bed.getRoomNumber());
					stmt.setInt(3, bed.getBedNumber());
					stmt.setInt(4, bed.getPrice());
					stmt.setString(5, bed.getState().name());
					stmt.setInt(6, bed.getHostelId());
					stmt.setDate(7, new java.sql.Date(bed.getDate().getTime()));
					
					stmt.execute();
					stmt.close();	
				}
				

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
	
	public void delete() throws SQLException {
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt;
			
			stmt = con.prepareStatement("truncate table  searched_beds;");
			//stmt = con.prepareStatement("delete from ;");
						
			stmt.execute();
			stmt.close();		
			
			stmt = con.prepareStatement("truncate table search_result;");
						
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
	
	public void deleteById(Integer searchId) throws SQLException {
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt;
			
			stmt = con.prepareStatement("delete from searched_beds where searchId=?;");
			stmt.setInt(1, searchId);
						
			stmt.execute();
			stmt.close();		
			
			stmt = con.prepareStatement("delete from search_result where searchId=?;");
			stmt.setInt(1, searchId);
			
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
	
	public List<SearchResult> getSearchResultSet() throws SQLException {
		Connection con = null;
		List<SearchResult> searchResultSet =  new ArrayList<SearchResult>();
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from search_result; ");
			
			ResultSet rs = stmt.executeQuery();
			SearchResult searchResult;
			while(rs.next()){
				searchResult = createSearchResultInstance(rs);
				searchResultSet.add(searchResult);
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
		
		return searchResultSet;
	}
	
	public SearchResult getSearchResultById(Integer searchId) throws SQLException {
		Connection con = null;
		SearchResult searchResult = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from search_result where searchId=?; ");
			stmt.setInt(1, searchId);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				searchResult = createSearchResultInstance(rs);
				
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
		
		return searchResult;
	}
	
	public List<Bed> getSearchedBedBySearchId(Integer searchId) throws SQLException {
		Connection con = null;
		List<Bed> beds = new ArrayList<Bed>();
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from searched_beds where searchId = ?; ");
			stmt.setInt(1, searchId);
			
			ResultSet rs = stmt.executeQuery();
			Bed bed;
			while(rs.next()){
				bed = createSearchedBedInstance(rs);
				beds.add(bed);
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
		return beds;		
	}
	
	Bed createSearchedBedInstance(ResultSet rs) throws SQLException {
		Bed bed = new Bed();
		
		bed.setBedNumber(rs.getInt("bed"));
		bed.setRoomNumber(rs.getInt("room"));
		bed.setDate(rs.getDate("date"));
		bed.setPrice(rs.getInt("price"));
		bed.setHostelId(rs.getInt("hostelId"));
		bed.setState(BedState.valueOf(rs.getString("state")));		
		
		return bed;
	}
	
	SearchResult createSearchResultInstance(ResultSet rs) throws SQLException {
		SearchResult searchResult = new SearchResult();
		
		searchResult.setSearchId(rs.getInt("searchId"));
		searchResult.setHostelId(rs.getInt("hostelId"));
		searchResult.setEndDate(rs.getDate("endDate"));
		searchResult.setStartDate(rs.getDate("startDate"));
		searchResult.setHostelName(rs.getString("hostelName"));
		searchResult.setTotalPrice(rs.getInt("totalPrice"));		
		searchResult.setBeds(getSearchedBedBySearchId(searchResult.getSearchId()));
		
		return searchResult;
	}
}