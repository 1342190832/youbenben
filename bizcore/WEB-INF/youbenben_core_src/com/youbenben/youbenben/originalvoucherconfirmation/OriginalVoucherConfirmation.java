
package com.youbenben.youbenben.originalvoucherconfirmation;

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
import com.youbenben.youbenben.originalvoucher.OriginalVoucher;

@JsonSerialize(using = OriginalVoucherConfirmationSerializer.class)
public class OriginalVoucherConfirmation extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String COMMENTS_PROPERTY              = "comments"          ;
	public static final String MAKE_DATE_PROPERTY             = "makeDate"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ORIGINAL_VOUCHER_LIST                    = "originalVoucherList";

	public static final String INTERNAL_TYPE="OriginalVoucherConfirmation";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getWho();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		String              	mComments           ;
	protected		Date                	mMakeDate           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<OriginalVoucher>	mOriginalVoucherList;

	
		
	public 	OriginalVoucherConfirmation(){
		// lazy load for all the properties
	}
	public 	static OriginalVoucherConfirmation withId(String id){
		OriginalVoucherConfirmation originalVoucherConfirmation = new OriginalVoucherConfirmation();
		originalVoucherConfirmation.setId(id);
		originalVoucherConfirmation.setVersion(Integer.MAX_VALUE);
		return originalVoucherConfirmation;
	}
	public 	static OriginalVoucherConfirmation refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(COMMENTS_PROPERTY.equals(property)){
			changeCommentsProperty(newValueExpr);
		}
		if(MAKE_DATE_PROPERTY.equals(property)){
			changeMakeDateProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeWhoProperty(String newValueExpr){
	
		String oldValue = getWho();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateWho(newValue);
		this.onChangeProperty(WHO_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCommentsProperty(String newValueExpr){
	
		String oldValue = getComments();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateComments(newValue);
		this.onChangeProperty(COMMENTS_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeMakeDateProperty(String newValueExpr){
	
		Date oldValue = getMakeDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMakeDate(newValue);
		this.onChangeProperty(MAKE_DATE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(WHO_PROPERTY.equals(property)){
			return getWho();
		}
		if(COMMENTS_PROPERTY.equals(property)){
			return getComments();
		}
		if(MAKE_DATE_PROPERTY.equals(property)){
			return getMakeDate();
		}
		if(ORIGINAL_VOUCHER_LIST.equals(property)){
			List<BaseEntity> list = getOriginalVoucherList().stream().map(item->item).collect(Collectors.toList());
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
	public OriginalVoucherConfirmation updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	public OriginalVoucherConfirmation updateWho(String who){
		this.mWho = trimString(who);;
		this.changed = true;
		return this;
	}
	public void mergeWho(String who){
		if(who != null) { setWho(who);}
	}
	
	
	public void setComments(String comments){
		this.mComments = trimString(comments);;
	}
	public String getComments(){
		return this.mComments;
	}
	public OriginalVoucherConfirmation updateComments(String comments){
		this.mComments = trimString(comments);;
		this.changed = true;
		return this;
	}
	public void mergeComments(String comments){
		if(comments != null) { setComments(comments);}
	}
	
	
	public void setMakeDate(Date makeDate){
		this.mMakeDate = makeDate;;
	}
	public Date getMakeDate(){
		return this.mMakeDate;
	}
	public OriginalVoucherConfirmation updateMakeDate(Date makeDate){
		this.mMakeDate = makeDate;;
		this.changed = true;
		return this;
	}
	public void mergeMakeDate(Date makeDate){
		setMakeDate(makeDate);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public OriginalVoucherConfirmation updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<OriginalVoucher> getOriginalVoucherList(){
		if(this.mOriginalVoucherList == null){
			this.mOriginalVoucherList = new SmartList<OriginalVoucher>();
			this.mOriginalVoucherList.setListInternalName (ORIGINAL_VOUCHER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mOriginalVoucherList;	
	}
	public  void setOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setConfirmation(this);
		}

		this.mOriginalVoucherList = originalVoucherList;
		this.mOriginalVoucherList.setListInternalName (ORIGINAL_VOUCHER_LIST );
		
	}
	
	public  void addOriginalVoucher(OriginalVoucher originalVoucher){
		originalVoucher.setConfirmation(this);
		getOriginalVoucherList().add(originalVoucher);
	}
	public  void addOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setConfirmation(this);
		}
		getOriginalVoucherList().addAll(originalVoucherList);
	}
	public  void mergeOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		if(originalVoucherList==null){
			return;
		}
		if(originalVoucherList.isEmpty()){
			return;
		}
		addOriginalVoucherList( originalVoucherList );
		
	}
	public  OriginalVoucher removeOriginalVoucher(OriginalVoucher originalVoucherIndex){
		
		int index = getOriginalVoucherList().indexOf(originalVoucherIndex);
        if(index < 0){
        	String message = "OriginalVoucher("+originalVoucherIndex.getId()+") with version='"+originalVoucherIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        OriginalVoucher originalVoucher = getOriginalVoucherList().get(index);        
        // originalVoucher.clearConfirmation(); //disconnect with Confirmation
        originalVoucher.clearFromAll(); //disconnect with Confirmation
		
		boolean result = getOriginalVoucherList().planToRemove(originalVoucher);
        if(!result){
        	String message = "OriginalVoucher("+originalVoucherIndex.getId()+") with version='"+originalVoucherIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return originalVoucher;
        
	
	}
	//断舍离
	public  void breakWithOriginalVoucher(OriginalVoucher originalVoucher){
		
		if(originalVoucher == null){
			return;
		}
		originalVoucher.setConfirmation(null);
		//getOriginalVoucherList().remove();
	
	}
	
	public  boolean hasOriginalVoucher(OriginalVoucher originalVoucher){
	
		return getOriginalVoucherList().contains(originalVoucher);
  
	}
	
	public void copyOriginalVoucherFrom(OriginalVoucher originalVoucher) {

		OriginalVoucher originalVoucherInList = findTheOriginalVoucher(originalVoucher);
		OriginalVoucher newOriginalVoucher = new OriginalVoucher();
		originalVoucherInList.copyTo(newOriginalVoucher);
		newOriginalVoucher.setVersion(0);//will trigger copy
		getOriginalVoucherList().add(newOriginalVoucher);
		addItemToFlexiableObject(COPIED_CHILD, newOriginalVoucher);
	}
	
	public  OriginalVoucher findTheOriginalVoucher(OriginalVoucher originalVoucher){
		
		int index =  getOriginalVoucherList().indexOf(originalVoucher);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "OriginalVoucher("+originalVoucher.getId()+") with version='"+originalVoucher.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getOriginalVoucherList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpOriginalVoucherList(){
		getOriginalVoucherList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getOriginalVoucherList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getOriginalVoucherList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, COMMENTS_PROPERTY, getComments());
		appendKeyValuePair(result, MAKE_DATE_PROPERTY, getMakeDate());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, ORIGINAL_VOUCHER_LIST, getOriginalVoucherList());
		if(!getOriginalVoucherList().isEmpty()){
			appendKeyValuePair(result, "originalVoucherCount", getOriginalVoucherList().getTotalCount());
			appendKeyValuePair(result, "originalVoucherCurrentPageNumber", getOriginalVoucherList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof OriginalVoucherConfirmation){
		
		
			OriginalVoucherConfirmation dest =(OriginalVoucherConfirmation)baseDest;
		
			dest.setId(getId());
			dest.setWho(getWho());
			dest.setComments(getComments());
			dest.setMakeDate(getMakeDate());
			dest.setVersion(getVersion());
			dest.setOriginalVoucherList(getOriginalVoucherList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof OriginalVoucherConfirmation){
		
			
			OriginalVoucherConfirmation dest =(OriginalVoucherConfirmation)baseDest;
		
			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergeComments(getComments());
			dest.mergeMakeDate(getMakeDate());
			dest.mergeVersion(getVersion());
			dest.mergeOriginalVoucherList(getOriginalVoucherList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof OriginalVoucherConfirmation){
		
			
			OriginalVoucherConfirmation dest =(OriginalVoucherConfirmation)baseDest;
		
			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergeComments(getComments());
			dest.mergeMakeDate(getMakeDate());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getWho(), getComments(), getMakeDate(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("OriginalVoucherConfirmation{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tcomments='"+getComments()+"';");
		stringBuilder.append("\tmakeDate='"+getMakeDate()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

