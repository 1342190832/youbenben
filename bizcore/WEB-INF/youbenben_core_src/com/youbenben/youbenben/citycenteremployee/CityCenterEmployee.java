
package com.youbenben.youbenben.citycenteremployee;

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
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;

@JsonSerialize(using = CityCenterEmployeeSerializer.class)
public class CityCenterEmployee extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String DEPARTMENT_PROPERTY            = "department"        ;
	public static final String CITY_CENTER_PROPERTY           = "cityCenter"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="CityCenterEmployee";
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
	protected		String              	mMobile             ;
	protected		String              	mEmail              ;
	protected		Date                	mFounded            ;
	protected		CityCenterDepartment	mDepartment         ;
	protected		FranchisedOutletCityCenter	mCityCenter         ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	CityCenterEmployee(){
		// lazy load for all the properties
	}
	public 	static CityCenterEmployee withId(String id){
		CityCenterEmployee cityCenterEmployee = new CityCenterEmployee();
		cityCenterEmployee.setId(id);
		cityCenterEmployee.setVersion(Integer.MAX_VALUE);
		return cityCenterEmployee;
	}
	public 	static CityCenterEmployee refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDepartment( null );
		setCityCenter( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(MOBILE_PROPERTY.equals(property)){
			changeMobileProperty(newValueExpr);
		}
		if(EMAIL_PROPERTY.equals(property)){
			changeEmailProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
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
			
			
			
	protected void changeMobileProperty(String newValueExpr){
	
		String oldValue = getMobile();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMobile(newValue);
		this.onChangeProperty(MOBILE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeEmailProperty(String newValueExpr){
	
		String oldValue = getEmail();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEmail(newValue);
		this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(MOBILE_PROPERTY.equals(property)){
			return getMobile();
		}
		if(EMAIL_PROPERTY.equals(property)){
			return getEmail();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(DEPARTMENT_PROPERTY.equals(property)){
			return getDepartment();
		}
		if(CITY_CENTER_PROPERTY.equals(property)){
			return getCityCenter();
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
	public CityCenterEmployee updateId(String id){
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
	public CityCenterEmployee updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setMobile(String mobile){
		this.mMobile = trimString(mobile);;
	}
	public String getMobile(){
		return this.mMobile;
	}
	public CityCenterEmployee updateMobile(String mobile){
		this.mMobile = trimString(mobile);;
		this.changed = true;
		return this;
	}
	public void mergeMobile(String mobile){
		if(mobile != null) { setMobile(mobile);}
	}
	
	
	
	public String getMaskedMobile(){
		String mobilePhoneNumber = getMobile();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setEmail(String email){
		this.mEmail = trimString(email);;
	}
	public String getEmail(){
		return this.mEmail;
	}
	public CityCenterEmployee updateEmail(String email){
		this.mEmail = trimString(email);;
		this.changed = true;
		return this;
	}
	public void mergeEmail(String email){
		if(email != null) { setEmail(email);}
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public CityCenterEmployee updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setDepartment(CityCenterDepartment department){
		this.mDepartment = department;;
	}
	public CityCenterDepartment getDepartment(){
		return this.mDepartment;
	}
	public CityCenterEmployee updateDepartment(CityCenterDepartment department){
		this.mDepartment = department;;
		this.changed = true;
		return this;
	}
	public void mergeDepartment(CityCenterDepartment department){
		if(department != null) { setDepartment(department);}
	}
	
	
	public void clearDepartment(){
		setDepartment ( null );
		this.changed = true;
	}
	
	public void setCityCenter(FranchisedOutletCityCenter cityCenter){
		this.mCityCenter = cityCenter;;
	}
	public FranchisedOutletCityCenter getCityCenter(){
		return this.mCityCenter;
	}
	public CityCenterEmployee updateCityCenter(FranchisedOutletCityCenter cityCenter){
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
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public CityCenterEmployee updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDepartment(), internalType);
		addToEntityList(this, entityList, getCityCenter(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
		appendKeyValuePair(result, EMAIL_PROPERTY, getEmail());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, DEPARTMENT_PROPERTY, getDepartment());
		appendKeyValuePair(result, CITY_CENTER_PROPERTY, getCityCenter());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityCenterEmployee){
		
		
			CityCenterEmployee dest =(CityCenterEmployee)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setMobile(getMobile());
			dest.setEmail(getEmail());
			dest.setFounded(getFounded());
			dest.setDepartment(getDepartment());
			dest.setCityCenter(getCityCenter());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityCenterEmployee){
		
			
			CityCenterEmployee dest =(CityCenterEmployee)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeEmail(getEmail());
			dest.mergeFounded(getFounded());
			dest.mergeDepartment(getDepartment());
			dest.mergeCityCenter(getCityCenter());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityCenterEmployee){
		
			
			CityCenterEmployee dest =(CityCenterEmployee)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeEmail(getEmail());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getMobile(), getEmail(), getFounded(), getDepartment(), getCityCenter(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("CityCenterEmployee{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getDepartment() != null ){
 			stringBuilder.append("\tdepartment='CityCenterDepartment("+getDepartment().getId()+")';");
 		}
		if(getCityCenter() != null ){
 			stringBuilder.append("\tcityCenter='FranchisedOutletCityCenter("+getCityCenter().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

