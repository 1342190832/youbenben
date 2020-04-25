
package com.xingyou.xingyou.citycenterdepartment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.SmartList;
import com.xingyou.xingyou.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.xingyou.xingyou.citycenteremployee.CityCenterEmployee;

@JsonSerialize(using = CityCenterDepartmentSerializer.class)
public class CityCenterDepartment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String CITY_CENTER_PROPERTY           = "cityCenter"        ;
	public static final String MANAGER_PROPERTY               = "manager"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CITY_CENTER_EMPLOYEE_LIST                = "cityCenterEmployeeList";

	public static final String INTERNAL_TYPE="CityCenterDepartment";
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
	protected		FranchisedOutletCityCenter	mCityCenter         ;
	protected		String              	mManager            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<CityCenterEmployee>	mCityCenterEmployeeList;

	
		
	public 	CityCenterDepartment(){
		// lazy load for all the properties
	}
	public 	static CityCenterDepartment withId(String id){
		CityCenterDepartment cityCenterDepartment = new CityCenterDepartment();
		cityCenterDepartment.setId(id);
		cityCenterDepartment.setVersion(Integer.MAX_VALUE);
		return cityCenterDepartment;
	}
	public 	static CityCenterDepartment refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCityCenter( null );

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
		if(MANAGER_PROPERTY.equals(property)){
			changeManagerProperty(newValueExpr);
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
			
			
			
	protected void changeManagerProperty(String newValueExpr){
	
		String oldValue = getManager();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateManager(newValue);
		this.onChangeProperty(MANAGER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(CITY_CENTER_PROPERTY.equals(property)){
			return getCityCenter();
		}
		if(MANAGER_PROPERTY.equals(property)){
			return getManager();
		}
		if(CITY_CENTER_EMPLOYEE_LIST.equals(property)){
			List<BaseEntity> list = getCityCenterEmployeeList().stream().map(item->item).collect(Collectors.toList());
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
	public CityCenterDepartment updateId(String id){
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
	public CityCenterDepartment updateName(String name){
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
	public CityCenterDepartment updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setCityCenter(FranchisedOutletCityCenter cityCenter){
		this.mCityCenter = cityCenter;;
	}
	public FranchisedOutletCityCenter getCityCenter(){
		return this.mCityCenter;
	}
	public CityCenterDepartment updateCityCenter(FranchisedOutletCityCenter cityCenter){
		this.mCityCenter = cityCenter;;
		this.changed = true;
		return this;
	}
	public void mergeCityCenter(FranchisedOutletCityCenter cityCenter){
		if(cityCenter != null) { setCityCenter(cityCenter);}
	}
	
	
	public void clearCityCenter(){
		setCityCenter ( null );
		this.changed = true;
	}
	
	public void setManager(String manager){
		this.mManager = trimString(manager);;
	}
	public String getManager(){
		return this.mManager;
	}
	public CityCenterDepartment updateManager(String manager){
		this.mManager = trimString(manager);;
		this.changed = true;
		return this;
	}
	public void mergeManager(String manager){
		if(manager != null) { setManager(manager);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public CityCenterDepartment updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			cityCenterEmployee.setDepartment(this);
		}

		this.mCityCenterEmployeeList = cityCenterEmployeeList;
		this.mCityCenterEmployeeList.setListInternalName (CITY_CENTER_EMPLOYEE_LIST );
		
	}
	
	public  void addCityCenterEmployee(CityCenterEmployee cityCenterEmployee){
		cityCenterEmployee.setDepartment(this);
		getCityCenterEmployeeList().add(cityCenterEmployee);
	}
	public  void addCityCenterEmployeeList(SmartList<CityCenterEmployee> cityCenterEmployeeList){
		for( CityCenterEmployee cityCenterEmployee:cityCenterEmployeeList){
			cityCenterEmployee.setDepartment(this);
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
        // cityCenterEmployee.clearDepartment(); //disconnect with Department
        cityCenterEmployee.clearFromAll(); //disconnect with Department
		
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
		cityCenterEmployee.setDepartment(null);
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCityCenter(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getCityCenterEmployeeList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getCityCenterEmployeeList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, CITY_CENTER_PROPERTY, getCityCenter());
		appendKeyValuePair(result, MANAGER_PROPERTY, getManager());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CITY_CENTER_EMPLOYEE_LIST, getCityCenterEmployeeList());
		if(!getCityCenterEmployeeList().isEmpty()){
			appendKeyValuePair(result, "cityCenterEmployeeCount", getCityCenterEmployeeList().getTotalCount());
			appendKeyValuePair(result, "cityCenterEmployeeCurrentPageNumber", getCityCenterEmployeeList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityCenterDepartment){
		
		
			CityCenterDepartment dest =(CityCenterDepartment)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setFounded(getFounded());
			dest.setCityCenter(getCityCenter());
			dest.setManager(getManager());
			dest.setVersion(getVersion());
			dest.setCityCenterEmployeeList(getCityCenterEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityCenterDepartment){
		
			
			CityCenterDepartment dest =(CityCenterDepartment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeCityCenter(getCityCenter());
			dest.mergeManager(getManager());
			dest.mergeVersion(getVersion());
			dest.mergeCityCenterEmployeeList(getCityCenterEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityCenterDepartment){
		
			
			CityCenterDepartment dest =(CityCenterDepartment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeManager(getManager());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getFounded(), getCityCenter(), getManager(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("CityCenterDepartment{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getCityCenter() != null ){
 			stringBuilder.append("\tcityCenter='FranchisedOutletCityCenter("+getCityCenter().getId()+")';");
 		}
		stringBuilder.append("\tmanager='"+getManager()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

