package cs445.project.facilitator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cs445.project.base.Bed;
import cs445.project.base.BedState;
import cs445.project.base.Hostel;
import cs445.project.structs.AvailableBedInfo;
import cs445.project.structs.SearchGeneric;
import cs445.project.structs.SearchResult;
import cs445.project.structs.SearchStruct;

public class SearchFacilitator {

	DBSaveRestore dbSaveRestore;
	
	
	public SearchFacilitator() {
		dbSaveRestore = new DBSaveRestore();
	}
	
	public void deleteSearchData(){		
		dbSaveRestore.deleteSearchData();
	}
	
	public List<Hostel> getAvailableBedsInHostels(Date startDate,Date endDate){
		
		if(startDate.after(endDate)){
			return null;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		
		if(startDate.before(cal.getTime())){
			return null;
		}
		
		List<Hostel> hostels = dbSaveRestore.getAvailableBedsInAllHostels(startDate,endDate);
		
		return hostels;
	}
	
	public void addSearchDate(List<SearchResult> searchResultSet){
		//Save Searched Data
		dbSaveRestore.addSearchData(searchResultSet);
	}
	
	public List<SearchResult> search(SearchStruct searchStruct,List<Hostel> hostels) {
		if(searchStruct == null || hostels == null)
			return null;
		
		if(hostels.size() == 0)
			return null;
		
		Date startDate = searchStruct.getStartDate();
		Date endDate = searchStruct.getEndDate();
		
		if(startDate.after(endDate)){
			return null;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		
		if(startDate.before(cal.getTime())){
			return null;
		}
		
		List<SearchResult> searchResultSet =  new ArrayList<SearchResult>();
		Integer serachId = 1;
		Integer totalBedPrice = 0;

		
		//Search the data as per searchStruct
		for(Hostel hostel: hostels) {
			if(hostel.getAddress().getCity().compareTo(searchStruct.getCity()) == 0){
				SearchResult searchResult = new SearchResult();
				Integer days = daysBetween(searchStruct.getStartDate(),searchStruct.getEndDate());
				Integer totalBeds = days*searchStruct.getNumberOfBeds();
				
				//Search is for hostel in this city				
				List<Bed> matchedBeds = new ArrayList<Bed>();
				List<Bed> hostelBeds = hostel.getBeds();
				Integer bedsRequestedPerDay = searchStruct.getNumberOfBeds();
				Integer bedsAddedPerDay = 0;
				Integer numberOfSearchOptions = getNumberOfSearchOptions(searchStruct.getStartDate(),days,hostelBeds,bedsRequestedPerDay); 
				for(int j=0;j<numberOfSearchOptions;j++) {
					Date requestedDate = searchStruct.getStartDate();
					//Traverse all the beds in the hostel and add the matched data in the searchResult
					for(int i=0;i< hostelBeds.size();i++){
											
						Bed bed = hostelBeds.get(i);					
						 
						if(requestedDate.compareTo(bed.getDate()) == 0  && 
								bed.getState().compareTo(BedState.AVAILABLE)==0) {
							totalBedPrice+=bed.getPrice();
							bed.setState(BedState.SEARCHED);
							bedsAddedPerDay++;
							matchedBeds.add(bed);
							if(matchedBeds.size() == totalBeds) {
								//One search is over so save it and continue with other search
								searchResult.setBeds(matchedBeds);
								searchResult.setHostelId(hostel.getHostelId());
								searchResult.setHostelName(hostel.getName());
								searchResult.setHostelAddress(hostel.getAddress());
								searchResult.setSearchId(serachId++);
								searchResult.setTotalPrice(totalBedPrice);
								searchResult.setStartDate(searchStruct.getStartDate());
								searchResult.setEndDate(searchStruct.getEndDate());
								
								searchResultSet.add(searchResult);
								matchedBeds.clear();
								totalBedPrice=0;
								searchResult = new SearchResult();
							}
						}
						
						//If bedsAdded per Day == bedsRequestedPerDay then move to the next day
						if(bedsAddedPerDay == bedsRequestedPerDay){
							bedsAddedPerDay=0;							
							requestedDate = addDays(requestedDate,1);
							continue;							
						}
					}	
					
				}				
			}
		}
		
		return searchResultSet;
	}
	
	public List<SearchGeneric> searchGeneric(SearchStruct searchStruct,List<Hostel> hostels){
		
		if(searchStruct == null || hostels == null)
			return null;
		
		if(hostels.size() == 0)
			return null;
		
		Date startDate = searchStruct.getStartDate();
		Date endDate = searchStruct.getEndDate();
		
		if(startDate.after(endDate)){
			return null;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		
		if(startDate.before(cal.getTime())){
			return null;
		}
		
		List<SearchGeneric> searchGenericList = new ArrayList<SearchGeneric>();
		
		for(Hostel h: hostels) {
			if(h.getAddress().getCity().compareTo(searchStruct.getCity()) == 0) {
				if(h.getBeds().size() > 0){
					SearchGeneric s = new SearchGeneric();
					s.setHostelId(h.getHostelId());
					s.setHostelName(h.getName());
					
					Date    date     = h.getBeds().get(0).getDate();				
					Integer maxPrice =h.getBeds().get(0).getPrice();
					Integer minPrice =maxPrice;
					List<AvailableBedInfo> bedInfoList = new ArrayList<AvailableBedInfo>();
					Integer bedCountPerDay = 0;
					
					for(Bed b : h.getBeds()){					
						
						// If date is different then we are into the next date beds
						// so save the previous data
						if(date.compareTo(b.getDate()) !=0 ) {
							AvailableBedInfo bedInfo = new AvailableBedInfo();
							bedInfo.setStartDate(date);
							bedInfo.setEndDate(addDays(date, 1));
							bedInfo.setMaxPrice(maxPrice);
							bedInfo.setMinPrice(minPrice);
							bedInfo.setBedsAvailable(bedCountPerDay);
							bedInfoList.add(bedInfo);
							
							//Reset the maxPrice/minPrice and update the date
							maxPrice = minPrice = b.getPrice();
							date = b.getDate();
							bedCountPerDay = 0;
						}	
						
						bedCountPerDay++;
						
						if(minPrice > b.getPrice()){
							minPrice = b.getPrice();
						}
						
						if(maxPrice < b.getPrice()){
							maxPrice = b.getPrice();
						}				
					}
					
					//Add the last Bed set
					if(h.getBeds().size() > 0){
						AvailableBedInfo bedInfo = new AvailableBedInfo();
						bedInfo.setStartDate(date);
						bedInfo.setEndDate(addDays(date, 1));
						bedInfo.setMaxPrice(maxPrice);
						bedInfo.setMinPrice(minPrice);
						bedInfo.setBedsAvailable(bedCountPerDay);
						bedInfoList.add(bedInfo);
					}
					s.setAvailableBedInfo(bedInfoList);
					searchGenericList.add(s);
				}
			}
		}
		
		return searchGenericList;
	}
	
	public List<Hostel> viewAll() {
		List<Hostel> hostels = null;
		
		DBSaveRestore dbSaveRestore = new DBSaveRestore();
		hostels = dbSaveRestore.getHostelList();
		return hostels;
	}
	
	//Number of search Options depends on the number of beds available at start date
	private Integer getNumberOfSearchOptions(Date startDate, Integer days,List<Bed> beds,Integer bedsRequestedPerDay) {
		Integer bedsAvailablePerDay = 0;
		Integer getNumberOfSearchOptions=0;
		Date date = startDate;
		List<Integer> bedsAvailablePerDayList = new ArrayList<Integer>();
		
		//Check for each day if the required number of beds are available or not
		for(int i=0;i<days;i++){
			bedsAvailablePerDay=0;
			for(Bed bed: beds) {
				if(bed.getDate().compareTo(date) == 0) {
					bedsAvailablePerDay++;
				}
			}
			
			if(bedsAvailablePerDay < bedsRequestedPerDay){
				getNumberOfSearchOptions=0;
				return 0;
			}
			else{
					bedsAvailablePerDayList.add(bedsAvailablePerDay/bedsRequestedPerDay);
			}
			date = addDays(date, 1);
		}
		
		//Get the Minimum count
		getNumberOfSearchOptions = bedsAvailablePerDayList.get(0);
		for(Integer count:bedsAvailablePerDayList){
			if(getNumberOfSearchOptions > count) {
				getNumberOfSearchOptions = count;
			}
		}
		
		return getNumberOfSearchOptions;
	}
	private int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
    private Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        
        return cal.getTime() ;
    }
}
