
package com.youbenben.youbenben.franchisedoutletprovincecenter;

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
import com.youbenben.youbenben.catalog.Catalog;

@JsonSerialize(using = FranchisedOutletProvinceCenterSerializer.class)
public class FranchisedOutletProvinceCenter extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String SERVICE_NUMBER_PROPERTY        = "serviceNumber"     ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String WEB_SITE_PROPERTY              = "webSite"           ;
	public static final String ADDRESS_PROPERTY               = "address"           ;
	public static final String OPERATED_BY_PROPERTY           = "operatedBy"        ;
	public static final String LEGAL_REPRESENTATIVE_PROPERTY  = "legalRepresentative";
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CATALOG_LIST                             = "catalogList"       ;

	public static final String INTERNAL_TYPE="FranchisedOutletProvinceCenter";
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
	protected		String              	mServiceNumber      ;
	protected		Date                	mFounded            ;
	protected		String              	mWebSite            ;
	protected		String              	mAddress            ;
	protected		String              	mOperatedBy         ;
	protected		String              	mLegalRepresentative;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Catalog>  	mCatalogList        ;

	
		
	public 	FranchisedOutletProvinceCenter(){
		// lazy load for all the properties
	}
	public 	static FranchisedOutletProvinceCenter withId(String id){
		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = new FranchisedOutletProvinceCenter();
		franchisedOutletProvinceCenter.setId(id);
		franchisedOutletProvinceCenter.setVersion(Integer.MAX_VALUE);
		return franchisedOutletProvinceCenter;
	}
	public 	static FranchisedOutletProvinceCenter refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(SERVICE_NUMBER_PROPERTY.equals(property)){
			changeServiceNumberProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
		}
		if(WEB_SITE_PROPERTY.equals(property)){
			changeWebSiteProperty(newValueExpr);
		}
		if(ADDRESS_PROPERTY.equals(property)){
			changeAddressProperty(newValueExpr);
		}
		if(OPERATED_BY_PROPERTY.equals(property)){
			changeOperatedByProperty(newValueExpr);
		}
		if(LEGAL_REPRESENTATIVE_PROPERTY.equals(property)){
			changeLegalRepresentativeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
			
			
			
	protected void changeServiceNumberProperty(String newValueExpr){
	
		String oldValue = getServiceNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateServiceNumber(newValue);
		this.onChangeProperty(SERVICE_NUMBER_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeWebSiteProperty(String newValueExpr){
	
		String oldValue = getWebSite();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateWebSite(newValue);
		this.onChangeProperty(WEB_SITE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAddressProperty(String newValueExpr){
	
		String oldValue = getAddress();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAddress(newValue);
		this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeOperatedByProperty(String newValueExpr){
	
		String oldValue = getOperatedBy();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOperatedBy(newValue);
		this.onChangeProperty(OPERATED_BY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLegalRepresentativeProperty(String newValueExpr){
	
		String oldValue = getLegalRepresentative();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLegalRepresentative(newValue);
		this.onChangeProperty(LEGAL_REPRESENTATIVE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
	
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(SERVICE_NUMBER_PROPERTY.equals(property)){
			return getServiceNumber();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(WEB_SITE_PROPERTY.equals(property)){
			return getWebSite();
		}
		if(ADDRESS_PROPERTY.equals(property)){
			return getAddress();
		}
		if(OPERATED_BY_PROPERTY.equals(property)){
			return getOperatedBy();
		}
		if(LEGAL_REPRESENTATIVE_PROPERTY.equals(property)){
			return getLegalRepresentative();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(CATALOG_LIST.equals(property)){
			List<BaseEntity> list = getCatalogList().stream().map(item->item).collect(Collectors.toList());
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
	public FranchisedOutletProvinceCenter updateId(String id){
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
	public FranchisedOutletProvinceCenter updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setServiceNumber(String serviceNumber){
		this.mServiceNumber = trimString(serviceNumber);;
	}
	public String getServiceNumber(){
		return this.mServiceNumber;
	}
	public FranchisedOutletProvinceCenter updateServiceNumber(String serviceNumber){
		this.mServiceNumber = trimString(serviceNumber);;
		this.changed = true;
		return this;
	}
	public void mergeServiceNumber(String serviceNumber){
		if(serviceNumber != null) { setServiceNumber(serviceNumber);}
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public FranchisedOutletProvinceCenter updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setWebSite(String webSite){
		this.mWebSite = trimString(encodeUrl(webSite));;
	}
	public String getWebSite(){
		return this.mWebSite;
	}
	public FranchisedOutletProvinceCenter updateWebSite(String webSite){
		this.mWebSite = trimString(encodeUrl(webSite));;
		this.changed = true;
		return this;
	}
	public void mergeWebSite(String webSite){
		if(webSite != null) { setWebSite(webSite);}
	}
	
	
	public void setAddress(String address){
		this.mAddress = trimString(address);;
	}
	public String getAddress(){
		return this.mAddress;
	}
	public FranchisedOutletProvinceCenter updateAddress(String address){
		this.mAddress = trimString(address);;
		this.changed = true;
		return this;
	}
	public void mergeAddress(String address){
		if(address != null) { setAddress(address);}
	}
	
	
	public void setOperatedBy(String operatedBy){
		this.mOperatedBy = trimString(operatedBy);;
	}
	public String getOperatedBy(){
		return this.mOperatedBy;
	}
	public FranchisedOutletProvinceCenter updateOperatedBy(String operatedBy){
		this.mOperatedBy = trimString(operatedBy);;
		this.changed = true;
		return this;
	}
	public void mergeOperatedBy(String operatedBy){
		if(operatedBy != null) { setOperatedBy(operatedBy);}
	}
	
	
	public void setLegalRepresentative(String legalRepresentative){
		this.mLegalRepresentative = trimString(legalRepresentative);;
	}
	public String getLegalRepresentative(){
		return this.mLegalRepresentative;
	}
	public FranchisedOutletProvinceCenter updateLegalRepresentative(String legalRepresentative){
		this.mLegalRepresentative = trimString(legalRepresentative);;
		this.changed = true;
		return this;
	}
	public void mergeLegalRepresentative(String legalRepresentative){
		if(legalRepresentative != null) { setLegalRepresentative(legalRepresentative);}
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public FranchisedOutletProvinceCenter updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public FranchisedOutletProvinceCenter updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Catalog> getCatalogList(){
		if(this.mCatalogList == null){
			this.mCatalogList = new SmartList<Catalog>();
			this.mCatalogList.setListInternalName (CATALOG_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCatalogList;	
	}
	public  void setCatalogList(SmartList<Catalog> catalogList){
		for( Catalog catalog:catalogList){
			catalog.setOwner(this);
		}

		this.mCatalogList = catalogList;
		this.mCatalogList.setListInternalName (CATALOG_LIST );
		
	}
	
	public  void addCatalog(Catalog catalog){
		catalog.setOwner(this);
		getCatalogList().add(catalog);
	}
	public  void addCatalogList(SmartList<Catalog> catalogList){
		for( Catalog catalog:catalogList){
			catalog.setOwner(this);
		}
		getCatalogList().addAll(catalogList);
	}
	public  void mergeCatalogList(SmartList<Catalog> catalogList){
		if(catalogList==null){
			return;
		}
		if(catalogList.isEmpty()){
			return;
		}
		addCatalogList( catalogList );
		
	}
	public  Catalog removeCatalog(Catalog catalogIndex){
		
		int index = getCatalogList().indexOf(catalogIndex);
        if(index < 0){
        	String message = "Catalog("+catalogIndex.getId()+") with version='"+catalogIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Catalog catalog = getCatalogList().get(index);        
        // catalog.clearOwner(); //disconnect with Owner
        catalog.clearFromAll(); //disconnect with Owner
		
		boolean result = getCatalogList().planToRemove(catalog);
        if(!result){
        	String message = "Catalog("+catalogIndex.getId()+") with version='"+catalogIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return catalog;
        
	
	}
	//断舍离
	public  void breakWithCatalog(Catalog catalog){
		
		if(catalog == null){
			return;
		}
		catalog.setOwner(null);
		//getCatalogList().remove();
	
	}
	
	public  boolean hasCatalog(Catalog catalog){
	
		return getCatalogList().contains(catalog);
  
	}
	
	public void copyCatalogFrom(Catalog catalog) {

		Catalog catalogInList = findTheCatalog(catalog);
		Catalog newCatalog = new Catalog();
		catalogInList.copyTo(newCatalog);
		newCatalog.setVersion(0);//will trigger copy
		getCatalogList().add(newCatalog);
		addItemToFlexiableObject(COPIED_CHILD, newCatalog);
	}
	
	public  Catalog findTheCatalog(Catalog catalog){
		
		int index =  getCatalogList().indexOf(catalog);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Catalog("+catalog.getId()+") with version='"+catalog.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCatalogList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCatalogList(){
		getCatalogList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getCatalogList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getCatalogList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, SERVICE_NUMBER_PROPERTY, getServiceNumber());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, WEB_SITE_PROPERTY, getWebSite());
		appendKeyValuePair(result, ADDRESS_PROPERTY, getAddress());
		appendKeyValuePair(result, OPERATED_BY_PROPERTY, getOperatedBy());
		appendKeyValuePair(result, LEGAL_REPRESENTATIVE_PROPERTY, getLegalRepresentative());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CATALOG_LIST, getCatalogList());
		if(!getCatalogList().isEmpty()){
			appendKeyValuePair(result, "catalogCount", getCatalogList().getTotalCount());
			appendKeyValuePair(result, "catalogCurrentPageNumber", getCatalogList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FranchisedOutletProvinceCenter){
		
		
			FranchisedOutletProvinceCenter dest =(FranchisedOutletProvinceCenter)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setServiceNumber(getServiceNumber());
			dest.setFounded(getFounded());
			dest.setWebSite(getWebSite());
			dest.setAddress(getAddress());
			dest.setOperatedBy(getOperatedBy());
			dest.setLegalRepresentative(getLegalRepresentative());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setCatalogList(getCatalogList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FranchisedOutletProvinceCenter){
		
			
			FranchisedOutletProvinceCenter dest =(FranchisedOutletProvinceCenter)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeServiceNumber(getServiceNumber());
			dest.mergeFounded(getFounded());
			dest.mergeWebSite(getWebSite());
			dest.mergeAddress(getAddress());
			dest.mergeOperatedBy(getOperatedBy());
			dest.mergeLegalRepresentative(getLegalRepresentative());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());
			dest.mergeCatalogList(getCatalogList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FranchisedOutletProvinceCenter){
		
			
			FranchisedOutletProvinceCenter dest =(FranchisedOutletProvinceCenter)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeServiceNumber(getServiceNumber());
			dest.mergeFounded(getFounded());
			dest.mergeWebSite(getWebSite());
			dest.mergeAddress(getAddress());
			dest.mergeOperatedBy(getOperatedBy());
			dest.mergeLegalRepresentative(getLegalRepresentative());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getServiceNumber(), getFounded(), getWebSite(), getAddress(), getOperatedBy(), getLegalRepresentative(), getDescription(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("FranchisedOutletProvinceCenter{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tserviceNumber='"+getServiceNumber()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\twebSite='"+getWebSite()+"';");
		stringBuilder.append("\taddress='"+getAddress()+"';");
		stringBuilder.append("\toperatedBy='"+getOperatedBy()+"';");
		stringBuilder.append("\tlegalRepresentative='"+getLegalRepresentative()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

