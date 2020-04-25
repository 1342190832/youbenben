
package com.youbenben.youbenben.franchisedoutletcitycenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartment;
import com.youbenben.youbenben.citycenteremployee.CityCenterEmployee;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;

@JsonSerialize(using = FranchisedOutletCityCenterSerializer.class)
public class FranchisedOutletCityCenter extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String CITY_PROPERTY                  = "city"              ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String FRANCHISED_OUTLET_CITY_CENTER_LIST       = "franchisedOutletCityCenterList";
	public static final String CITY_CENTER_DEPARTMENT_LIST              = "cityCenterDepartmentList";
	public static final String CITY_CENTER_EMPLOYEE_LIST                = "cityCenterEmployeeList";
	public static final String FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST = "franchisedOutletCityServiceCenterList";

	public static final String INTERNAL_TYPE="FranchisedOutletCityCenter";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		Date                	mFounded            ;
	protected		FranchisedOutletCityCenter	mCity               ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<FranchisedOutletCityCenter>	mFranchisedOutletCityCenterList;
	protected		SmartList<CityCenterDepartment>	mCityCenterDepartmentList;
	protected		SmartList<CityCenterEmployee>	mCityCenterEmployeeList;
	protected		SmartList<FranchisedOutletCityServiceCenter>	mFranchisedOutletCityServiceCenterList;

	
		
	public 	FranchisedOutletCityCenter(){
		// lazy load for all the properties
	}
	public 	static FranchisedOutletCityCenter withId(String id){
		FranchisedOutletCityCenter franchisedOutletCityCenter = new FranchisedOutletCityCenter();
		franchisedOutletCityCenter.setId(id);
		franchisedOutletCityCenter.setVersion(Integer.MAX_VALUE);
		return franchisedOutletCityCenter;
	}
	public 	static FranchisedOutletCityCenter refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCity( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
	
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
	
		Date oldValue = getFounded();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFounded(newValue);
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
	
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(CITY_PROPERTY.equals(property)){
			return getCity();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(FRANCHISED_OUTLET_CITY_CENTER_LIST.equals(property)){
			List<BaseEntity> list = getFranchisedOutletCityCenterList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CITY_CENTER_DEPARTMENT_LIST.equals(property)){
			List<BaseEntity> list = getCityCenterDepartmentList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CITY_CENTER_EMPLOYEE_LIST.equals(property)){
			List<BaseEntity> list = getCityCenterEmployeeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST.equals(property)){
			List<BaseEntity> list = getFranchisedOutletCityServiceCenterList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public FranchisedOutletCityCenter updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public FranchisedOutletCityCenter updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public FranchisedOutletCityCenter updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setCity(FranchisedOutletCityCenter city){
		this.mCity = city;;
	}
	public FranchisedOutletCityCenter getCity(){
		return this.mCity;
	}
	public FranchisedOutletCityCenter updateCity(FranchisedOutletCityCenter city){
		this.mCity = city;;
		this.changed = true;
		return this;
	}
	public void mergeCity(FranchisedOutletCityCenter city){
		if(city != null) { setCity(city);}
	}
	
	
	public void clearCity(){
		setCity ( null );
		this.changed = true;
	}
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public FranchisedOutletCityCenter updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public FranchisedOutletCityCenter updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<FranchisedOutletCityCenter> getFranchisedOutletCityCenterList(){
		if(this.mFranchisedOutletCityCenterList == null){
			this.mFranchisedOutletCityCenterList = new SmartList<FranchisedOutletCityCenter>();
			this.mFranchisedOutletCityCenterList.setListInternalName (FRANCHISED_OUTLET_CITY_CENTER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mFranchisedOutletCityCenterList;	
	}
	public  void setFranchisedOutletCityCenterList(SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList){
		for( FranchisedOutletCityCenter franchisedOutletCityCenter:franchisedOutletCityCenterList){
			franchisedOutletCityCenter.setCity(this);
		}

		this.mFranchisedOutletCityCenterList = franchisedOutletCityCenterList;
		this.mFranchisedOutletCityCenterList.setListInternalName (FRANCHISED_OUTLET_CITY_CENTER_LIST );
		
	}
	
	public  void addFranchisedOutletCityCenter(FranchisedOutletCityCenter franchisedOutletCityCenter){
		franchisedOutletCityCenter.setCity(this);
		getFranchisedOutletCityCenterList().add(franchisedOutletCityCenter);
	}
	public  void addFranchisedOutletCityCenterList(SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList){
		for( FranchisedOutletCityCenter franchisedOutletCityCenter:franchisedOutletCityCenterList){
			franchisedOutletCityCenter.setCity(this);
		}
		getFranchisedOutletCityCenterList().addAll(franchisedOutletCityCenterList);
	}
	public  void mergeFranchisedOutletCityCenterList(SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList){
		if(franchisedOutletCityCenterList==null){
			return;
		}
		if(franchisedOutletCityCenterList.isEmpty()){
			return;
		}
		addFranchisedOutletCityCenterList( franchisedOutletCityCenterList );
		
	}
	public  FranchisedOutletCityCenter removeFranchisedOutletCityCenter(FranchisedOutletCityCenter franchisedOutletCityCenterIndex){
		
		int index = getFranchisedOutletCityCenterList().indexOf(franchisedOutletCityCenterIndex);
        if(index < 0){
        	String message = "FranchisedOutletCityCenter("+franchisedOutletCityCenterIndex.getId()+") with version='"+franchisedOutletCityCenterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        FranchisedOutletCityCenter franchisedOutletCityCenter = getFranchisedOutletCityCenterList().get(index);        
        // franchisedOutletCityCenter.clearCity(); //disconnect with City
        franchisedOutletCityCenter.clearFromAll(); //disconnect with City
		
		boolean result = getFranchisedOutletCityCenterList().planToRemove(franchisedOutletCityCenter);
        if(!result){
        	String message = "FranchisedOutletCityCenter("+franchisedOutletCityCenterIndex.getId()+") with version='"+franchisedOutletCityCenterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return franchisedOutletCityCenter;
        
	
	}
	//断舍离
	public  void breakWithFranchisedOutletCityCenter(FranchisedOutletCityCenter franchisedOutletCityCenter){
		
		if(franchisedOutletCityCenter == null){
			return;
		}
		franchisedOutletCityCenter.setCity(null);
		//getFranchisedOutletCityCenterList().remove();
	
	}
	
	public  boolean hasFranchisedOutletCityCenter(FranchisedOutletCityCenter franchisedOutletCityCenter){
	
		return getFranchisedOutletCityCenterList().contains(franchisedOutletCityCenter);
  
	}
	
	public void copyFranchisedOutletCityCenterFrom(FranchisedOutletCityCenter franchisedOutletCityCenter) {

		FranchisedOutletCityCenter franchisedOutletCityCenterInList = findTheFranchisedOutletCityCenter(franchisedOutletCityCenter);
		FranchisedOutletCityCenter newFranchisedOutletCityCenter = new FranchisedOutletCityCenter();
		franchisedOutletCityCenterInList.copyTo(newFranchisedOutletCityCenter);
		newFranchisedOutletCityCenter.setVersion(0);//will trigger copy
		getFranchisedOutletCityCenterList().add(newFranchisedOutletCityCenter);
		addItemToFlexiableObject(COPIED_CHILD, newFranchisedOutletCityCenter);
	}
	
	public  FranchisedOutletCityCenter findTheFranchisedOutletCityCenter(FranchisedOutletCityCenter franchisedOutletCityCenter){
		
		int index =  getFranchisedOutletCityCenterList().indexOf(franchisedOutletCityCenter);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "FranchisedOutletCityCenter("+franchisedOutletCityCenter.getId()+") with version='"+franchisedOutletCityCenter.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getFranchisedOutletCityCenterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpFranchisedOutletCityCenterList(){
		getFranchisedOutletCityCenterList().clear();
	}
	
	
	


	public  SmartList<CityCenterDepartment> getCityCenterDepartmentList(){
		if(this.mCityCenterDepartmentList == null){
			this.mCityCenterDepartmentList = new SmartList<CityCenterDepartment>();
			this.mCityCenterDepartmentList.setListInternalName (CITY_CENTER_DEPARTMENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCityCenterDepartmentList;	
	}
	public  void setCityCenterDepartmentList(SmartList<CityCenterDepartment> cityCenterDepartmentList){
		for( CityCenterDepartment cityCenterDepartment:cityCenterDepartmentList){
			cityCenterDepartment.setCityCenter(this);
		}

		this.mCityCenterDepartmentList = cityCenterDepartmentList;
		this.mCityCenterDepartmentList.setListInternalName (CITY_CENTER_DEPARTMENT_LIST );
		
	}
	
	public  void addCityCenterDepartment(CityCenterDepartment cityCenterDepartment){
		cityCenterDepartment.setCityCenter(this);
		getCityCenterDepartmentList().add(cityCenterDepartment);
	}
	public  void addCityCenterDepartmentList(SmartList<CityCenterDepartment> cityCenterDepartmentList){
		for( CityCenterDepartment cityCenterDepartment:cityCenterDepartmentList){
			cityCenterDepartment.setCityCenter(this);
		}
		getCityCenterDepartmentList().addAll(cityCenterDepartmentList);
	}
	public  void mergeCityCenterDepartmentList(SmartList<CityCenterDepartment> cityCenterDepartmentList){
		if(cityCenterDepartmentList==null){
			return;
		}
		if(cityCenterDepartmentList.isEmpty()){
			return;
		}
		addCityCenterDepartmentList( cityCenterDepartmentList );
		
	}
	public  CityCenterDepartment removeCityCenterDepartment(CityCenterDepartment cityCenterDepartmentIndex){
		
		int index = getCityCenterDepartmentList().indexOf(cityCenterDepartmentIndex);
        if(index < 0){
        	String message = "CityCenterDepartment("+cityCenterDepartmentIndex.getId()+") with version='"+cityCenterDepartmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        CityCenterDepartment cityCenterDepartment = getCityCenterDepartmentList().get(index);        
        // cityCenterDepartment.clearCityCenter(); //disconnect with CityCenter
        cityCenterDepartment.clearFromAll(); //disconnect with CityCenter
		
		boolean result = getCityCenterDepartmentList().planToRemove(cityCenterDepartment);
        if(!result){
        	String message = "CityCenterDepartment("+cityCenterDepartmentIndex.getId()+") with version='"+cityCenterDepartmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return cityCenterDepartment;
        
	
	}
	//断舍离
	public  void breakWithCityCenterDepartment(CityCenterDepartment cityCenterDepartment){
		
		if(cityCenterDepartment == null){
			return;
		}
		cityCenterDepartment.setCityCenter(null);
		//getCityCenterDepartmentList().remove();
	
	}
	
	public  boolean hasCityCenterDepartment(CityCenterDepartment cityCenterDepartment){
	
		return getCityCenterDepartmentList().contains(cityCenterDepartment);
  
	}
	
	public void copyCityCenterDepartmentFrom(CityCenterDepartment cityCenterDepartment) {

		CityCenterDepartment cityCenterDepartmentInList = findTheCityCenterDepartment(cityCenterDepartment);
		CityCenterDepartment newCityCenterDepartment = new CityCenterDepartment();
		cityCenterDepartmentInList.copyTo(newCityCenterDepartment);
		newCityCenterDepartment.setVersion(0);//will trigger copy
		getCityCenterDepartmentList().add(newCityCenterDepartment);
		addItemToFlexiableObject(COPIED_CHILD, newCityCenterDepartment);
	}
	
	public  CityCenterDepartment findTheCityCenterDepartment(CityCenterDepartment cityCenterDepartment){
		
		int index =  getCityCenterDepartmentList().indexOf(cityCenterDepartment);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "CityCenterDepartment("+cityCenterDepartment.getId()+") with version='"+cityCenterDepartment.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCityCenterDepartmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCityCenterDepartmentList(){
		getCityCenterDepartmentList().clear();
	}
	
	
	


	public  SmartList<CityCenterEmployee> getCityCenterEmployeeList(){
		if(this.mCityCenterEmployeeList == null){
			this.mCityCenterEmployeeList = new SmartList<CityCenterEmployee>();
			this.mCityCenterEmployeeList.setListInternalName (CITY_CENTER_EMPLOYEE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCityCenterEmployeeList;	
	}
	public  void setCityCenterEmployeeList(SmartList<CityCenterEmployee> cityCenterEmployeeList){
		for( CityCenterEmployee cityCenterEmployee:cityCenterEmployeeList){
			cityCenterEmployee.setCityCenter(this);
		}

		this.mCityCenterEmployeeList = cityCenterEmployeeList;
		this.mCityCenterEmployeeList.setListInternalName (CITY_CENTER_EMPLOYEE_LIST );
		
	}
	
	public  void addCityCenterEmployee(CityCenterEmployee cityCenterEmployee){
		cityCenterEmployee.setCityCenter(this);
		getCityCenterEmployeeList().add(cityCenterEmployee);
	}
	public  void addCityCenterEmployeeList(SmartList<CityCenterEmployee> cityCenterEmployeeList){
		for( CityCenterEmployee cityCenterEmployee:cityCenterEmployeeList){
			cityCenterEmployee.setCityCenter(this);
		}
		getCityCenterEmployeeList().addAll(cityCenterEmployeeList);
	}
	public  void mergeCityCenterEmployeeList(SmartList<CityCenterEmployee> cityCenterEmployeeList){
		if(cityCenterEmployeeList==null){
			return;
		}
		if(cityCenterEmployeeList.isEmpty()){
			return;
		}
		addCityCenterEmployeeList( cityCenterEmployeeList );
		
	}
	public  CityCenterEmployee removeCityCenterEmployee(CityCenterEmployee cityCenterEmployeeIndex){
		
		int index = getCityCenterEmployeeList().indexOf(cityCenterEmployeeIndex);
        if(index < 0){
        	String message = "CityCenterEmployee("+cityCenterEmployeeIndex.getId()+") with version='"+cityCenterEmployeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        CityCenterEmployee cityCenterEmployee = getCityCenterEmployeeList().get(index);        
        // cityCenterEmployee.clearCityCenter(); //disconnect with CityCenter
        cityCenterEmployee.clearFromAll(); //disconnect with CityCenter
		
		boolean result = getCityCenterEmployeeList().planToRemove(cityCenterEmployee);
        if(!result){
        	String message = "CityCenterEmployee("+cityCenterEmployeeIndex.getId()+") with version='"+cityCenterEmployeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return cityCenterEmployee;
        
	
	}
	//断舍离
	public  void breakWithCityCenterEmployee(CityCenterEmployee cityCenterEmployee){
		
		if(cityCenterEmployee == null){
			return;
		}
		cityCenterEmployee.setCityCenter(null);
		//getCityCenterEmployeeList().remove();
	
	}
	
	public  boolean hasCityCenterEmployee(CityCenterEmployee cityCenterEmployee){
	
		return getCityCenterEmployeeList().contains(cityCenterEmployee);
  
	}
	
	public void copyCityCenterEmployeeFrom(CityCenterEmployee cityCenterEmployee) {

		CityCenterEmployee cityCenterEmployeeInList = findTheCityCenterEmployee(cityCenterEmployee);
		CityCenterEmployee newCityCenterEmployee = new CityCenterEmployee();
		cityCenterEmployeeInList.copyTo(newCityCenterEmployee);
		newCityCenterEmployee.setVersion(0);//will trigger copy
		getCityCenterEmployeeList().add(newCityCenterEmployee);
		addItemToFlexiableObject(COPIED_CHILD, newCityCenterEmployee);
	}
	
	public  CityCenterEmployee findTheCityCenterEmployee(CityCenterEmployee cityCenterEmployee){
		
		int index =  getCityCenterEmployeeList().indexOf(cityCenterEmployee);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "CityCenterEmployee("+cityCenterEmployee.getId()+") with version='"+cityCenterEmployee.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCityCenterEmployeeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCityCenterEmployeeList(){
		getCityCenterEmployeeList().clear();
	}
	
	
	


	public  SmartList<FranchisedOutletCityServiceCenter> getFranchisedOutletCityServiceCenterList(){
		if(this.mFranchisedOutletCityServiceCenterList == null){
			this.mFranchisedOutletCityServiceCenterList = new SmartList<FranchisedOutletCityServiceCenter>();
			this.mFranchisedOutletCityServiceCenterList.setListInternalName (FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mFranchisedOutletCityServiceCenterList;	
	}
	public  void setFranchisedOutletCityServiceCenterList(SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList){
		for( FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter:franchisedOutletCityServiceCenterList){
			franchisedOutletCityServiceCenter.setBelongsTo(this);
		}

		this.mFranchisedOutletCityServiceCenterList = franchisedOutletCityServiceCenterList;
		this.mFranchisedOutletCityServiceCenterList.setListInternalName (FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST );
		
	}
	
	public  void addFranchisedOutletCityServiceCenter(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter){
		franchisedOutletCityServiceCenter.setBelongsTo(this);
		getFranchisedOutletCityServiceCenterList().add(franchisedOutletCityServiceCenter);
	}
	public  void addFranchisedOutletCityServiceCenterList(SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList){
		for( FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter:franchisedOutletCityServiceCenterList){
			franchisedOutletCityServiceCenter.setBelongsTo(this);
		}
		getFranchisedOutletCityServiceCenterList().addAll(franchisedOutletCityServiceCenterList);
	}
	public  void mergeFranchisedOutletCityServiceCenterList(SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList){
		if(franchisedOutletCityServiceCenterList==null){
			return;
		}
		if(franchisedOutletCityServiceCenterList.isEmpty()){
			return;
		}
		addFranchisedOutletCityServiceCenterList( franchisedOutletCityServiceCenterList );
		
	}
	public  FranchisedOutletCityServiceCenter removeFranchisedOutletCityServiceCenter(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenterIndex){
		
		int index = getFranchisedOutletCityServiceCenterList().indexOf(franchisedOutletCityServiceCenterIndex);
        if(index < 0){
        	String message = "FranchisedOutletCityServiceCenter("+franchisedOutletCityServiceCenterIndex.getId()+") with version='"+franchisedOutletCityServiceCenterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = getFranchisedOutletCityServiceCenterList().get(index);        
        // franchisedOutletCityServiceCenter.clearBelongsTo(); //disconnect with BelongsTo
        franchisedOutletCityServiceCenter.clearFromAll(); //disconnect with BelongsTo
		
		boolean result = getFranchisedOutletCityServiceCenterList().planToRemove(franchisedOutletCityServiceCenter);
        if(!result){
        	String message = "FranchisedOutletCityServiceCenter("+franchisedOutletCityServiceCenterIndex.getId()+") with version='"+franchisedOutletCityServiceCenterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return franchisedOutletCityServiceCenter;
        
	
	}
	//断舍离
	public  void breakWithFranchisedOutletCityServiceCenter(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter){
		
		if(franchisedOutletCityServiceCenter == null){
			return;
		}
		franchisedOutletCityServiceCenter.setBelongsTo(null);
		//getFranchisedOutletCityServiceCenterList().remove();
	
	}
	
	public  boolean hasFranchisedOutletCityServiceCenter(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter){
	
		return getFranchisedOutletCityServiceCenterList().contains(franchisedOutletCityServiceCenter);
  
	}
	
	public void copyFranchisedOutletCityServiceCenterFrom(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter) {

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenterInList = findTheFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenter);
		FranchisedOutletCityServiceCenter newFranchisedOutletCityServiceCenter = new FranchisedOutletCityServiceCenter();
		franchisedOutletCityServiceCenterInList.copyTo(newFranchisedOutletCityServiceCenter);
		newFranchisedOutletCityServiceCenter.setVersion(0);//will trigger copy
		getFranchisedOutletCityServiceCenterList().add(newFranchisedOutletCityServiceCenter);
		addItemToFlexiableObject(COPIED_CHILD, newFranchisedOutletCityServiceCenter);
	}
	
	public  FranchisedOutletCityServiceCenter findTheFranchisedOutletCityServiceCenter(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter){
		
		int index =  getFranchisedOutletCityServiceCenterList().indexOf(franchisedOutletCityServiceCenter);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "FranchisedOutletCityServiceCenter("+franchisedOutletCityServiceCenter.getId()+") with version='"+franchisedOutletCityServiceCenter.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getFranchisedOutletCityServiceCenterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpFranchisedOutletCityServiceCenterList(){
		getFranchisedOutletCityServiceCenterList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCity(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getFranchisedOutletCityCenterList(), internalType);
		collectFromList(this, entityList, getCityCenterDepartmentList(), internalType);
		collectFromList(this, entityList, getCityCenterEmployeeList(), internalType);
		collectFromList(this, entityList, getFranchisedOutletCityServiceCenterList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getFranchisedOutletCityCenterList());
		listOfList.add( getCityCenterDepartmentList());
		listOfList.add( getCityCenterEmployeeList());
		listOfList.add( getFranchisedOutletCityServiceCenterList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, CITY_PROPERTY, getCity());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, FRANCHISED_OUTLET_CITY_CENTER_LIST, getFranchisedOutletCityCenterList());
		if(!getFranchisedOutletCityCenterList().isEmpty()){
			appendKeyValuePair(result, "franchisedOutletCityCenterCount", getFranchisedOutletCityCenterList().getTotalCount());
			appendKeyValuePair(result, "franchisedOutletCityCenterCurrentPageNumber", getFranchisedOutletCityCenterList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CITY_CENTER_DEPARTMENT_LIST, getCityCenterDepartmentList());
		if(!getCityCenterDepartmentList().isEmpty()){
			appendKeyValuePair(result, "cityCenterDepartmentCount", getCityCenterDepartmentList().getTotalCount());
			appendKeyValuePair(result, "cityCenterDepartmentCurrentPageNumber", getCityCenterDepartmentList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CITY_CENTER_EMPLOYEE_LIST, getCityCenterEmployeeList());
		if(!getCityCenterEmployeeList().isEmpty()){
			appendKeyValuePair(result, "cityCenterEmployeeCount", getCityCenterEmployeeList().getTotalCount());
			appendKeyValuePair(result, "cityCenterEmployeeCurrentPageNumber", getCityCenterEmployeeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST, getFranchisedOutletCityServiceCenterList());
		if(!getFranchisedOutletCityServiceCenterList().isEmpty()){
			appendKeyValuePair(result, "franchisedOutletCityServiceCenterCount", getFranchisedOutletCityServiceCenterList().getTotalCount());
			appendKeyValuePair(result, "franchisedOutletCityServiceCenterCurrentPageNumber", getFranchisedOutletCityServiceCenterList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FranchisedOutletCityCenter){
		
		
			FranchisedOutletCityCenter dest =(FranchisedOutletCityCenter)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setFounded(getFounded());
			dest.setCity(getCity());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setFranchisedOutletCityCenterList(getFranchisedOutletCityCenterList());
			dest.setCityCenterDepartmentList(getCityCenterDepartmentList());
			dest.setCityCenterEmployeeList(getCityCenterEmployeeList());
			dest.setFranchisedOutletCityServiceCenterList(getFranchisedOutletCityServiceCenterList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FranchisedOutletCityCenter){
		
			
			FranchisedOutletCityCenter dest =(FranchisedOutletCityCenter)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeCity(getCity());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeFranchisedOutletCityCenterList(getFranchisedOutletCityCenterList());
			dest.mergeCityCenterDepartmentList(getCityCenterDepartmentList());
			dest.mergeCityCenterEmployeeList(getCityCenterEmployeeList());
			dest.mergeFranchisedOutletCityServiceCenterList(getFranchisedOutletCityServiceCenterList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FranchisedOutletCityCenter){
		
			
			FranchisedOutletCityCenter dest =(FranchisedOutletCityCenter)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getFounded(), getCity(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("FranchisedOutletCityCenter{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getCity() != null ){
 			stringBuilder.append("\tcity='FranchisedOutletCityCenter("+getCity().getId()+")';");
 		}
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

