
package com.youbenben.youbenben.retailstoremember;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.youbenben.youbenben.*;
import com.youbenben.youbenben.tree.*;
import com.youbenben.youbenben.treenode.*;
import com.youbenben.youbenben.YoubenbenUserContextImpl;
import com.youbenben.youbenben.iamservice.*;
import com.youbenben.youbenben.services.IamService;
import com.youbenben.youbenben.secuser.SecUser;
import com.youbenben.youbenben.userapp.UserApp;
import com.youbenben.youbenben.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.youbenben.youbenben.memberrewardpointredemption.MemberRewardPointRedemption;
import com.youbenben.youbenben.memberwishlist.MemberWishlist;
import com.youbenben.youbenben.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.youbenben.youbenben.memberrewardpoint.MemberRewardPoint;
import com.youbenben.youbenben.retailstorememberaddress.RetailStoreMemberAddress;
import com.youbenben.youbenben.consumerorder.ConsumerOrder;
import com.youbenben.youbenben.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDelivery;
import com.youbenben.youbenben.supplyorderapproval.SupplyOrderApproval;
import com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmation;
import com.youbenben.youbenben.supplyordershipment.SupplyOrderShipment;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.retailstoremember.RetailStoreMember;
import com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessing;






public class RetailStoreMemberManagerImpl extends CustomYoubenbenCheckerManager implements RetailStoreMemberManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreMemberTokens.start().withTokenFromListName(listName).done();
		RetailStoreMember  retailStoreMember = (RetailStoreMember) this.loadRetailStoreMember(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreMember.collectRefercencesFromLists();
		retailStoreMemberDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreMember, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreMemberGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreMember";
	@Override
	public RetailStoreMemberDAO daoOf(YoubenbenUserContext userContext) {
		return retailStoreMemberDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreMemberManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreMemberManagerException(message);

	}



 	protected RetailStoreMember saveRetailStoreMember(YoubenbenUserContext userContext, RetailStoreMember retailStoreMember, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberDAO().save(retailStoreMember, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMember(userContext, retailStoreMember, tokens);
 	}
 	
 	protected RetailStoreMember saveRetailStoreMemberDetail(YoubenbenUserContext userContext, RetailStoreMember retailStoreMember) throws Exception{	

 		
 		return saveRetailStoreMember(userContext, retailStoreMember, allTokens());
 	}
 	
 	public RetailStoreMember loadRetailStoreMember(YoubenbenUserContext userContext, String retailStoreMemberId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMember, tokens);
 	}
 	
 	
 	 public RetailStoreMember searchRetailStoreMember(YoubenbenUserContext userContext, String retailStoreMemberId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMember, tokens);
 	}
 	
 	

 	protected RetailStoreMember present(YoubenbenUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMember,tokens);
		
		
		RetailStoreMember  retailStoreMemberToPresent = retailStoreMemberDaoOf(userContext).present(retailStoreMember, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreMemberToPresent.collectRefercencesFromLists();
		retailStoreMemberDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreMemberToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreMember loadRetailStoreMemberDetail(YoubenbenUserContext userContext, String retailStoreMemberId) throws Exception{	
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, allTokens());
 		return present(userContext,retailStoreMember, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String retailStoreMemberId) throws Exception{	
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, viewTokens());
 		return present(userContext,retailStoreMember, allTokens());
		
 	}
 	protected RetailStoreMember saveRetailStoreMember(YoubenbenUserContext userContext, RetailStoreMember retailStoreMember, Map<String,Object>tokens) throws Exception{	
 		return retailStoreMemberDaoOf(userContext).save(retailStoreMember, tokens);
 	}
 	protected RetailStoreMember loadRetailStoreMember(YoubenbenUserContext userContext, String retailStoreMemberId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberManagerException.class);

 
 		return retailStoreMemberDaoOf(userContext).load(retailStoreMemberId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMember, tokens);
		
		addAction(userContext, retailStoreMember, tokens,"@create","createRetailStoreMember","createRetailStoreMember/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"@update","updateRetailStoreMember","updateRetailStoreMember/"+retailStoreMember.getId()+"/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"@copy","cloneRetailStoreMember","cloneRetailStoreMember/"+retailStoreMember.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMember.getId()+"/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberCoupon","addRetailStoreMemberCoupon","addRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberCoupon","removeRetailStoreMemberCoupon","removeRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberCouponFrom","copyRetailStoreMemberCouponFrom","copyRetailStoreMemberCouponFrom/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberWishlist","addMemberWishlist","addMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberWishlist","removeMemberWishlist","removeMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberWishlist","updateMemberWishlist","updateMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberWishlistFrom","copyMemberWishlistFrom","copyMemberWishlistFrom/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberRewardPoint","addMemberRewardPoint","addMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberRewardPoint","removeMemberRewardPoint","removeMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberRewardPoint","updateMemberRewardPoint","updateMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberRewardPointFrom","copyMemberRewardPointFrom","copyMemberRewardPointFrom/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberRewardPointRedemption","addMemberRewardPointRedemption","addMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberRewardPointRedemption","removeMemberRewardPointRedemption","removeMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberRewardPointRedemption","updateMemberRewardPointRedemption","updateMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberRewardPointRedemptionFrom","copyMemberRewardPointRedemptionFrom","copyMemberRewardPointRedemptionFrom/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberAddress","addRetailStoreMemberAddress","addRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberAddress","removeRetailStoreMemberAddress","removeRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberAddress","updateRetailStoreMemberAddress","updateRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberAddressFrom","copyRetailStoreMemberAddressFrom","copyRetailStoreMemberAddressFrom/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberGiftCard","addRetailStoreMemberGiftCard","addRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberGiftCard","removeRetailStoreMemberGiftCard","removeRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberGiftCard","updateRetailStoreMemberGiftCard","updateRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberGiftCardFrom","copyRetailStoreMemberGiftCardFrom","copyRetailStoreMemberGiftCardFrom/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreMember createRetailStoreMember(YoubenbenUserContext userContext, String name,String mobilePhone,String ownerId) throws Exception
	//public RetailStoreMember createRetailStoreMember(YoubenbenUserContext userContext,String name, String mobilePhone, String ownerId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfRetailStoreMember(name);
		checkerOf(userContext).checkMobilePhoneOfRetailStoreMember(mobilePhone);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


		RetailStoreMember retailStoreMember=createNewRetailStoreMember();	

		retailStoreMember.setName(name);
		retailStoreMember.setMobilePhone(mobilePhone);
			
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, ownerId,emptyOptions());
		retailStoreMember.setOwner(owner);
		
		

		retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreMember);
		return retailStoreMember;


	}
	protected RetailStoreMember createNewRetailStoreMember()
	{

		return new RetailStoreMember();
	}

	protected void checkParamsForUpdatingRetailStoreMember(YoubenbenUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkVersionOfRetailStoreMember( retailStoreMemberVersion);
		

		if(RetailStoreMember.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreMember(parseString(newValueExpr));
		
			
		}
		if(RetailStoreMember.MOBILE_PHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobilePhoneOfRetailStoreMember(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}



	public RetailStoreMember clone(YoubenbenUserContext userContext, String fromRetailStoreMemberId) throws Exception{

		return retailStoreMemberDaoOf(userContext).clone(fromRetailStoreMemberId, this.allTokens());
	}

	public RetailStoreMember internalSaveRetailStoreMember(YoubenbenUserContext userContext, RetailStoreMember retailStoreMember) throws Exception
	{
		return internalSaveRetailStoreMember(userContext, retailStoreMember, allTokens());

	}
	public RetailStoreMember internalSaveRetailStoreMember(YoubenbenUserContext userContext, RetailStoreMember retailStoreMember, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreMember(userContext, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreMember){
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMember.
			if (retailStoreMember.isChanged()){
			
			}
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, options);
			return retailStoreMember;

		}

	}

	public RetailStoreMember updateRetailStoreMember(YoubenbenUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMember(userContext, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr, tokensExpr);



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		if(retailStoreMember.getVersion() != retailStoreMemberVersion){
			String message = "The target version("+retailStoreMember.getVersion()+") is not equals to version("+retailStoreMemberVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMember){
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMember.
			
			retailStoreMember.changeProperty(property, newValueExpr);
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
		}

	}

	public RetailStoreMember updateRetailStoreMemberProperty(YoubenbenUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMember(userContext, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr, tokensExpr);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		if(retailStoreMember.getVersion() != retailStoreMemberVersion){
			String message = "The target version("+retailStoreMember.getVersion()+") is not equals to version("+retailStoreMemberVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMember){
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMember.

			retailStoreMember.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreMemberTokens tokens(){
		return RetailStoreMemberTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortRetailStoreMemberCouponListWith("id","desc")
		.sortMemberWishlistListWith("id","desc")
		.sortMemberRewardPointListWith("id","desc")
		.sortMemberRewardPointRedemptionListWith("id","desc")
		.sortRetailStoreMemberAddressListWith("id","desc")
		.sortRetailStoreMemberGiftCardListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(YoubenbenUserContext userContext, String retailStoreMemberId, String anotherOwnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherOwnerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

 	}
 	public RetailStoreMember transferToAnotherOwner(YoubenbenUserContext userContext, String retailStoreMemberId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberId,anotherOwnerId);
 
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());	
		synchronized(retailStoreMember){
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, anotherOwnerId, emptyOptions());		
			retailStoreMember.updateOwner(owner);		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, emptyOptions());
			
			return present(userContext,retailStoreMember, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreCountryCenter requestCandidateOwner(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForRetailStoreMember(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(YoubenbenUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newOwnerId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String retailStoreMemberId, int retailStoreMemberVersion) throws Exception {
		//deleteInternal(userContext, retailStoreMemberId, retailStoreMemberVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String retailStoreMemberId, int retailStoreMemberVersion) throws Exception{

		retailStoreMemberDaoOf(userContext).delete(retailStoreMemberId, retailStoreMemberVersion);
	}

	public RetailStoreMember forgetByAll(YoubenbenUserContext userContext, String retailStoreMemberId, int retailStoreMemberVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreMemberId, retailStoreMemberVersion);
	}
	protected RetailStoreMember forgetByAllInternal(YoubenbenUserContext userContext,
			String retailStoreMemberId, int retailStoreMemberVersion) throws Exception{

		return retailStoreMemberDaoOf(userContext).disconnectFromAll(retailStoreMemberId, retailStoreMemberVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return retailStoreMemberDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreMember with confirmation in ConsumerOrder
	protected RetailStoreMember breakWithConsumerOrderByConfirmation(YoubenbenUserContext userContext, String retailStoreMemberId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());

			synchronized(retailStoreMember){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreMemberDaoOf(userContext).planToRemoveConsumerOrderListWithConfirmation(retailStoreMember, confirmationId, this.emptyOptions());

				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
				return retailStoreMember;
			}
	}
	//disconnect RetailStoreMember with approval in ConsumerOrder
	protected RetailStoreMember breakWithConsumerOrderByApproval(YoubenbenUserContext userContext, String retailStoreMemberId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());

			synchronized(retailStoreMember){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreMemberDaoOf(userContext).planToRemoveConsumerOrderListWithApproval(retailStoreMember, approvalId, this.emptyOptions());

				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
				return retailStoreMember;
			}
	}
	//disconnect RetailStoreMember with processing in ConsumerOrder
	protected RetailStoreMember breakWithConsumerOrderByProcessing(YoubenbenUserContext userContext, String retailStoreMemberId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());

			synchronized(retailStoreMember){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreMemberDaoOf(userContext).planToRemoveConsumerOrderListWithProcessing(retailStoreMember, processingId, this.emptyOptions());

				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
				return retailStoreMember;
			}
	}
	//disconnect RetailStoreMember with shipment in ConsumerOrder
	protected RetailStoreMember breakWithConsumerOrderByShipment(YoubenbenUserContext userContext, String retailStoreMemberId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());

			synchronized(retailStoreMember){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreMemberDaoOf(userContext).planToRemoveConsumerOrderListWithShipment(retailStoreMember, shipmentId, this.emptyOptions());

				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
				return retailStoreMember;
			}
	}
	//disconnect RetailStoreMember with delivery in ConsumerOrder
	protected RetailStoreMember breakWithConsumerOrderByDelivery(YoubenbenUserContext userContext, String retailStoreMemberId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());

			synchronized(retailStoreMember){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreMemberDaoOf(userContext).planToRemoveConsumerOrderListWithDelivery(retailStoreMember, deliveryId, this.emptyOptions());

				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
				return retailStoreMember;
			}
	}
	//disconnect RetailStoreMember with store in ConsumerOrder
	protected RetailStoreMember breakWithConsumerOrderByStore(YoubenbenUserContext userContext, String retailStoreMemberId, String storeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());

			synchronized(retailStoreMember){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreMemberDaoOf(userContext).planToRemoveConsumerOrderListWithStore(retailStoreMember, storeId, this.emptyOptions());

				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
				return retailStoreMember;
			}
	}






	protected void checkParamsForAddingConsumerOrder(YoubenbenUserContext userContext, String retailStoreMemberId, String title, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);

		
		checkerOf(userContext).checkTitleOfConsumerOrder(title);
		
		checkerOf(userContext).checkConfirmationIdOfConsumerOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfConsumerOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfConsumerOrder(processingId);
		
		checkerOf(userContext).checkShipmentIdOfConsumerOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfConsumerOrder(deliveryId);
		
		checkerOf(userContext).checkStoreIdOfConsumerOrder(storeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember addConsumerOrder(YoubenbenUserContext userContext, String retailStoreMemberId, String title, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingConsumerOrder(userContext,retailStoreMemberId,title, confirmationId, approvalId, processingId, shipmentId, deliveryId, storeId,tokensExpr);

		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, confirmationId, approvalId, processingId, shipmentId, deliveryId, storeId);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addConsumerOrder( consumerOrder );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(YoubenbenUserContext userContext, String retailStoreMemberId,String id,String title,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);

		checkerOf(userContext).checkTitleOfConsumerOrder( title);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember updateConsumerOrderProperties(YoubenbenUserContext userContext, String retailStoreMemberId, String id,String title, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderProperties(userContext,retailStoreMemberId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getConsumerOrderList().isEmpty()){
			throw new RetailStoreMemberManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrder item = retailStoreMemberToUpdate.getConsumerOrderList().first();

		item.updateTitle( title );


		//checkParamsForAddingConsumerOrder(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withConsumerOrderList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}


	protected ConsumerOrder createConsumerOrder(YoubenbenUserContext userContext, String title, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		SupplyOrderConfirmation  confirmation = new SupplyOrderConfirmation();
		confirmation.setId(confirmationId);		
		consumerOrder.setConfirmation(confirmation);		
		SupplyOrderApproval  approval = new SupplyOrderApproval();
		approval.setId(approvalId);		
		consumerOrder.setApproval(approval);		
		SupplyOrderProcessing  processing = new SupplyOrderProcessing();
		processing.setId(processingId);		
		consumerOrder.setProcessing(processing);		
		SupplyOrderShipment  shipment = new SupplyOrderShipment();
		shipment.setId(shipmentId);		
		consumerOrder.setShipment(shipment);		
		SupplyOrderDelivery  delivery = new SupplyOrderDelivery();
		delivery.setId(deliveryId);		
		consumerOrder.setDelivery(delivery);		
		RetailStore  store = new RetailStore();
		store.setId(storeId);		
		consumerOrder.setStore(store);		
		consumerOrder.setLastUpdateTime(userContext.now());
	
		
		return consumerOrder;


	}

	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;

	}

	protected void checkParamsForRemovingConsumerOrderList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeConsumerOrderList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderList(userContext, retailStoreMemberId,  consumerOrderIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveConsumerOrderList(retailStoreMember, consumerOrderIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getConsumerOrderList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrder(YoubenbenUserContext userContext, String retailStoreMemberId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeConsumerOrder(YoubenbenUserContext userContext, String retailStoreMemberId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrder(userContext,retailStoreMemberId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeConsumerOrder( consumerOrder );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrder(YoubenbenUserContext userContext, String retailStoreMemberId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember copyConsumerOrderFrom(YoubenbenUserContext userContext, String retailStoreMemberId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrder(userContext,retailStoreMemberId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			consumerOrder.updateLastUpdateTime(userContext.now());

			retailStoreMember.copyConsumerOrderFrom( consumerOrder );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrder(YoubenbenUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}

	public  RetailStoreMember updateConsumerOrder(YoubenbenUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrder(userContext, retailStoreMemberId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeConsumerOrder( consumerOrder );
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);

			ConsumerOrder consumerOrder = retailStoreMember.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new RetailStoreMemberManagerException(consumerOrder+" is NOT FOUND" );
			}

			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String number,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);

		
		checkerOf(userContext).checkNameOfRetailStoreMemberCoupon(name);
		
		checkerOf(userContext).checkNumberOfRetailStoreMemberCoupon(number);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember addRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String number, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreMemberCoupon(userContext,retailStoreMemberId,name, number,tokensExpr);

		RetailStoreMemberCoupon retailStoreMemberCoupon = createRetailStoreMemberCoupon(userContext,name, number);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberCoupon( retailStoreMemberCoupon );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberCouponManager().onNewInstanceCreated(userContext, retailStoreMemberCoupon);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberCouponProperties(YoubenbenUserContext userContext, String retailStoreMemberId,String id,String name,String number,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(id);

		checkerOf(userContext).checkNameOfRetailStoreMemberCoupon( name);
		checkerOf(userContext).checkNumberOfRetailStoreMemberCoupon( number);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember updateRetailStoreMemberCouponProperties(YoubenbenUserContext userContext, String retailStoreMemberId, String id,String name,String number, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberCouponProperties(userContext,retailStoreMemberId,id,name,number,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberCouponListList()
				.searchRetailStoreMemberCouponListWith(RetailStoreMemberCoupon.ID_PROPERTY, "is", id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getRetailStoreMemberCouponList().isEmpty()){
			throw new RetailStoreMemberManagerException("RetailStoreMemberCoupon is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreMemberCoupon item = retailStoreMemberToUpdate.getRetailStoreMemberCouponList().first();

		item.updateName( name );
		item.updateNumber( number );


		//checkParamsForAddingRetailStoreMemberCoupon(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withRetailStoreMemberCouponList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreMemberCoupon createRetailStoreMemberCoupon(YoubenbenUserContext userContext, String name, String number) throws Exception{

		RetailStoreMemberCoupon retailStoreMemberCoupon = new RetailStoreMemberCoupon();
		
		
		retailStoreMemberCoupon.setName(name);		
		retailStoreMemberCoupon.setNumber(number);		
		retailStoreMemberCoupon.setLastUpdateTime(userContext.now());
	
		
		return retailStoreMemberCoupon;


	}

	protected RetailStoreMemberCoupon createIndexedRetailStoreMemberCoupon(String id, int version){

		RetailStoreMemberCoupon retailStoreMemberCoupon = new RetailStoreMemberCoupon();
		retailStoreMemberCoupon.setId(id);
		retailStoreMemberCoupon.setVersion(version);
		return retailStoreMemberCoupon;

	}

	protected void checkParamsForRemovingRetailStoreMemberCouponList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberCouponIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String retailStoreMemberCouponIdItem: retailStoreMemberCouponIds){
			checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeRetailStoreMemberCouponList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberCouponIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreMemberCouponList(userContext, retailStoreMemberId,  retailStoreMemberCouponIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveRetailStoreMemberCouponList(retailStoreMember, retailStoreMemberCouponIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getRetailStoreMemberCouponList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberCoupon(retailStoreMemberCouponVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreMemberCoupon(userContext,retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion,tokensExpr);

		RetailStoreMemberCoupon retailStoreMemberCoupon = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberCoupon( retailStoreMemberCoupon );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			deleteRelationInGraph(userContext, retailStoreMemberCoupon);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberCoupon(retailStoreMemberCouponVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember copyRetailStoreMemberCouponFrom(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreMemberCoupon(userContext,retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion,tokensExpr);

		RetailStoreMemberCoupon retailStoreMemberCoupon = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreMemberCoupon.updateLastUpdateTime(userContext.now());

			retailStoreMember.copyRetailStoreMemberCouponFrom( retailStoreMemberCoupon );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberCouponManager().onNewInstanceCreated(userContext, (RetailStoreMemberCoupon)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberCoupon(retailStoreMemberCouponVersion);
		

		if(RetailStoreMemberCoupon.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreMemberCoupon(parseString(newValueExpr));
		
		}
		
		if(RetailStoreMemberCoupon.NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNumberOfRetailStoreMemberCoupon(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}

	public  RetailStoreMember updateRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberCouponList().searchRetailStoreMemberCouponListWith(RetailStoreMemberCoupon.ID_PROPERTY, "eq", retailStoreMemberCouponId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberCoupon( retailStoreMemberCoupon );
			//make changes to AcceleraterAccount.
			RetailStoreMemberCoupon retailStoreMemberCouponIndex = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);

			RetailStoreMemberCoupon retailStoreMemberCoupon = retailStoreMember.findTheRetailStoreMemberCoupon(retailStoreMemberCouponIndex);
			if(retailStoreMemberCoupon == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberCoupon+" is NOT FOUND" );
			}

			retailStoreMemberCoupon.changeProperty(property, newValueExpr);
			retailStoreMemberCoupon.updateLastUpdateTime(userContext.now());
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingMemberWishlist(YoubenbenUserContext userContext, String retailStoreMemberId, String name,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);

		
		checkerOf(userContext).checkNameOfMemberWishlist(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember addMemberWishlist(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingMemberWishlist(userContext,retailStoreMemberId,name,tokensExpr);

		MemberWishlist memberWishlist = createMemberWishlist(userContext,name);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberWishlist( memberWishlist );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			
			userContext.getManagerGroup().getMemberWishlistManager().onNewInstanceCreated(userContext, memberWishlist);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMemberWishlistProperties(YoubenbenUserContext userContext, String retailStoreMemberId,String id,String name,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberWishlist(id);

		checkerOf(userContext).checkNameOfMemberWishlist( name);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember updateMemberWishlistProperties(YoubenbenUserContext userContext, String retailStoreMemberId, String id,String name, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingMemberWishlistProperties(userContext,retailStoreMemberId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMemberWishlistListList()
				.searchMemberWishlistListWith(MemberWishlist.ID_PROPERTY, "is", id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getMemberWishlistList().isEmpty()){
			throw new RetailStoreMemberManagerException("MemberWishlist is NOT FOUND with id: '"+id+"'");
		}

		MemberWishlist item = retailStoreMemberToUpdate.getMemberWishlistList().first();

		item.updateName( name );


		//checkParamsForAddingMemberWishlist(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withMemberWishlistList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}


	protected MemberWishlist createMemberWishlist(YoubenbenUserContext userContext, String name) throws Exception{

		MemberWishlist memberWishlist = new MemberWishlist();
		
		
		memberWishlist.setName(name);
	
		
		return memberWishlist;


	}

	protected MemberWishlist createIndexedMemberWishlist(String id, int version){

		MemberWishlist memberWishlist = new MemberWishlist();
		memberWishlist.setId(id);
		memberWishlist.setVersion(version);
		return memberWishlist;

	}

	protected void checkParamsForRemovingMemberWishlistList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String memberWishlistIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String memberWishlistIdItem: memberWishlistIds){
			checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeMemberWishlistList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String memberWishlistIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingMemberWishlistList(userContext, retailStoreMemberId,  memberWishlistIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveMemberWishlistList(retailStoreMember, memberWishlistIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getMemberWishlistList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingMemberWishlist(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
		checkerOf(userContext).checkVersionOfMemberWishlist(memberWishlistVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeMemberWishlist(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingMemberWishlist(userContext,retailStoreMemberId, memberWishlistId, memberWishlistVersion,tokensExpr);

		MemberWishlist memberWishlist = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberWishlist( memberWishlist );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			deleteRelationInGraph(userContext, memberWishlist);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingMemberWishlist(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
		checkerOf(userContext).checkVersionOfMemberWishlist(memberWishlistVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember copyMemberWishlistFrom(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingMemberWishlist(userContext,retailStoreMemberId, memberWishlistId, memberWishlistVersion,tokensExpr);

		MemberWishlist memberWishlist = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreMember.copyMemberWishlistFrom( memberWishlist );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			
			userContext.getManagerGroup().getMemberWishlistManager().onNewInstanceCreated(userContext, (MemberWishlist)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingMemberWishlist(YoubenbenUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
		checkerOf(userContext).checkVersionOfMemberWishlist(memberWishlistVersion);
		

		if(MemberWishlist.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfMemberWishlist(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}

	public  RetailStoreMember updateMemberWishlist(YoubenbenUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingMemberWishlist(userContext, retailStoreMemberId, memberWishlistId, memberWishlistVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withMemberWishlistList().searchMemberWishlistListWith(MemberWishlist.ID_PROPERTY, "eq", memberWishlistId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberWishlist( memberWishlist );
			//make changes to AcceleraterAccount.
			MemberWishlist memberWishlistIndex = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);

			MemberWishlist memberWishlist = retailStoreMember.findTheMemberWishlist(memberWishlistIndex);
			if(memberWishlist == null){
				throw new RetailStoreMemberManagerException(memberWishlist+" is NOT FOUND" );
			}

			memberWishlist.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingMemberRewardPoint(YoubenbenUserContext userContext, String retailStoreMemberId, String name, int point,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);

		
		checkerOf(userContext).checkNameOfMemberRewardPoint(name);
		
		checkerOf(userContext).checkPointOfMemberRewardPoint(point);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember addMemberRewardPoint(YoubenbenUserContext userContext, String retailStoreMemberId, String name, int point, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingMemberRewardPoint(userContext,retailStoreMemberId,name, point,tokensExpr);

		MemberRewardPoint memberRewardPoint = createMemberRewardPoint(userContext,name, point);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberRewardPoint( memberRewardPoint );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			
			userContext.getManagerGroup().getMemberRewardPointManager().onNewInstanceCreated(userContext, memberRewardPoint);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMemberRewardPointProperties(YoubenbenUserContext userContext, String retailStoreMemberId,String id,String name,int point,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPoint(id);

		checkerOf(userContext).checkNameOfMemberRewardPoint( name);
		checkerOf(userContext).checkPointOfMemberRewardPoint( point);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember updateMemberRewardPointProperties(YoubenbenUserContext userContext, String retailStoreMemberId, String id,String name,int point, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingMemberRewardPointProperties(userContext,retailStoreMemberId,id,name,point,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMemberRewardPointListList()
				.searchMemberRewardPointListWith(MemberRewardPoint.ID_PROPERTY, "is", id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getMemberRewardPointList().isEmpty()){
			throw new RetailStoreMemberManagerException("MemberRewardPoint is NOT FOUND with id: '"+id+"'");
		}

		MemberRewardPoint item = retailStoreMemberToUpdate.getMemberRewardPointList().first();

		item.updateName( name );
		item.updatePoint( point );


		//checkParamsForAddingMemberRewardPoint(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withMemberRewardPointList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}


	protected MemberRewardPoint createMemberRewardPoint(YoubenbenUserContext userContext, String name, int point) throws Exception{

		MemberRewardPoint memberRewardPoint = new MemberRewardPoint();
		
		
		memberRewardPoint.setName(name);		
		memberRewardPoint.setPoint(point);
	
		
		return memberRewardPoint;


	}

	protected MemberRewardPoint createIndexedMemberRewardPoint(String id, int version){

		MemberRewardPoint memberRewardPoint = new MemberRewardPoint();
		memberRewardPoint.setId(id);
		memberRewardPoint.setVersion(version);
		return memberRewardPoint;

	}

	protected void checkParamsForRemovingMemberRewardPointList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String memberRewardPointIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String memberRewardPointIdItem: memberRewardPointIds){
			checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeMemberRewardPointList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String memberRewardPointIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingMemberRewardPointList(userContext, retailStoreMemberId,  memberRewardPointIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveMemberRewardPointList(retailStoreMember, memberRewardPointIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getMemberRewardPointList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingMemberRewardPoint(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);
		checkerOf(userContext).checkVersionOfMemberRewardPoint(memberRewardPointVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeMemberRewardPoint(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingMemberRewardPoint(userContext,retailStoreMemberId, memberRewardPointId, memberRewardPointVersion,tokensExpr);

		MemberRewardPoint memberRewardPoint = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberRewardPoint( memberRewardPoint );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			deleteRelationInGraph(userContext, memberRewardPoint);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingMemberRewardPoint(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);
		checkerOf(userContext).checkVersionOfMemberRewardPoint(memberRewardPointVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember copyMemberRewardPointFrom(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingMemberRewardPoint(userContext,retailStoreMemberId, memberRewardPointId, memberRewardPointVersion,tokensExpr);

		MemberRewardPoint memberRewardPoint = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreMember.copyMemberRewardPointFrom( memberRewardPoint );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			
			userContext.getManagerGroup().getMemberRewardPointManager().onNewInstanceCreated(userContext, (MemberRewardPoint)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingMemberRewardPoint(YoubenbenUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);
		checkerOf(userContext).checkVersionOfMemberRewardPoint(memberRewardPointVersion);
		

		if(MemberRewardPoint.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfMemberRewardPoint(parseString(newValueExpr));
		
		}
		
		if(MemberRewardPoint.POINT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPointOfMemberRewardPoint(parseInt(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}

	public  RetailStoreMember updateMemberRewardPoint(YoubenbenUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingMemberRewardPoint(userContext, retailStoreMemberId, memberRewardPointId, memberRewardPointVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withMemberRewardPointList().searchMemberRewardPointListWith(MemberRewardPoint.ID_PROPERTY, "eq", memberRewardPointId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberRewardPoint( memberRewardPoint );
			//make changes to AcceleraterAccount.
			MemberRewardPoint memberRewardPointIndex = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);

			MemberRewardPoint memberRewardPoint = retailStoreMember.findTheMemberRewardPoint(memberRewardPointIndex);
			if(memberRewardPoint == null){
				throw new RetailStoreMemberManagerException(memberRewardPoint+" is NOT FOUND" );
			}

			memberRewardPoint.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingMemberRewardPointRedemption(YoubenbenUserContext userContext, String retailStoreMemberId, String name, int point,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);

		
		checkerOf(userContext).checkNameOfMemberRewardPointRedemption(name);
		
		checkerOf(userContext).checkPointOfMemberRewardPointRedemption(point);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember addMemberRewardPointRedemption(YoubenbenUserContext userContext, String retailStoreMemberId, String name, int point, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingMemberRewardPointRedemption(userContext,retailStoreMemberId,name, point,tokensExpr);

		MemberRewardPointRedemption memberRewardPointRedemption = createMemberRewardPointRedemption(userContext,name, point);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberRewardPointRedemption( memberRewardPointRedemption );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			
			userContext.getManagerGroup().getMemberRewardPointRedemptionManager().onNewInstanceCreated(userContext, memberRewardPointRedemption);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMemberRewardPointRedemptionProperties(YoubenbenUserContext userContext, String retailStoreMemberId,String id,String name,int point,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(id);

		checkerOf(userContext).checkNameOfMemberRewardPointRedemption( name);
		checkerOf(userContext).checkPointOfMemberRewardPointRedemption( point);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember updateMemberRewardPointRedemptionProperties(YoubenbenUserContext userContext, String retailStoreMemberId, String id,String name,int point, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingMemberRewardPointRedemptionProperties(userContext,retailStoreMemberId,id,name,point,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMemberRewardPointRedemptionListList()
				.searchMemberRewardPointRedemptionListWith(MemberRewardPointRedemption.ID_PROPERTY, "is", id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getMemberRewardPointRedemptionList().isEmpty()){
			throw new RetailStoreMemberManagerException("MemberRewardPointRedemption is NOT FOUND with id: '"+id+"'");
		}

		MemberRewardPointRedemption item = retailStoreMemberToUpdate.getMemberRewardPointRedemptionList().first();

		item.updateName( name );
		item.updatePoint( point );


		//checkParamsForAddingMemberRewardPointRedemption(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withMemberRewardPointRedemptionList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}


	protected MemberRewardPointRedemption createMemberRewardPointRedemption(YoubenbenUserContext userContext, String name, int point) throws Exception{

		MemberRewardPointRedemption memberRewardPointRedemption = new MemberRewardPointRedemption();
		
		
		memberRewardPointRedemption.setName(name);		
		memberRewardPointRedemption.setPoint(point);
	
		
		return memberRewardPointRedemption;


	}

	protected MemberRewardPointRedemption createIndexedMemberRewardPointRedemption(String id, int version){

		MemberRewardPointRedemption memberRewardPointRedemption = new MemberRewardPointRedemption();
		memberRewardPointRedemption.setId(id);
		memberRewardPointRedemption.setVersion(version);
		return memberRewardPointRedemption;

	}

	protected void checkParamsForRemovingMemberRewardPointRedemptionList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String memberRewardPointRedemptionIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String memberRewardPointRedemptionIdItem: memberRewardPointRedemptionIds){
			checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeMemberRewardPointRedemptionList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String memberRewardPointRedemptionIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingMemberRewardPointRedemptionList(userContext, retailStoreMemberId,  memberRewardPointRedemptionIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveMemberRewardPointRedemptionList(retailStoreMember, memberRewardPointRedemptionIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getMemberRewardPointRedemptionList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingMemberRewardPointRedemption(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		checkerOf(userContext).checkVersionOfMemberRewardPointRedemption(memberRewardPointRedemptionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeMemberRewardPointRedemption(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingMemberRewardPointRedemption(userContext,retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion,tokensExpr);

		MemberRewardPointRedemption memberRewardPointRedemption = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberRewardPointRedemption( memberRewardPointRedemption );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			deleteRelationInGraph(userContext, memberRewardPointRedemption);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingMemberRewardPointRedemption(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		checkerOf(userContext).checkVersionOfMemberRewardPointRedemption(memberRewardPointRedemptionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember copyMemberRewardPointRedemptionFrom(YoubenbenUserContext userContext, String retailStoreMemberId,
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingMemberRewardPointRedemption(userContext,retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion,tokensExpr);

		MemberRewardPointRedemption memberRewardPointRedemption = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreMember.copyMemberRewardPointRedemptionFrom( memberRewardPointRedemption );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			
			userContext.getManagerGroup().getMemberRewardPointRedemptionManager().onNewInstanceCreated(userContext, (MemberRewardPointRedemption)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingMemberRewardPointRedemption(YoubenbenUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		checkerOf(userContext).checkVersionOfMemberRewardPointRedemption(memberRewardPointRedemptionVersion);
		

		if(MemberRewardPointRedemption.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfMemberRewardPointRedemption(parseString(newValueExpr));
		
		}
		
		if(MemberRewardPointRedemption.POINT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPointOfMemberRewardPointRedemption(parseInt(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}

	public  RetailStoreMember updateMemberRewardPointRedemption(YoubenbenUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingMemberRewardPointRedemption(userContext, retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withMemberRewardPointRedemptionList().searchMemberRewardPointRedemptionListWith(MemberRewardPointRedemption.ID_PROPERTY, "eq", memberRewardPointRedemptionId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberRewardPointRedemption( memberRewardPointRedemption );
			//make changes to AcceleraterAccount.
			MemberRewardPointRedemption memberRewardPointRedemptionIndex = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);

			MemberRewardPointRedemption memberRewardPointRedemption = retailStoreMember.findTheMemberRewardPointRedemption(memberRewardPointRedemptionIndex);
			if(memberRewardPointRedemption == null){
				throw new RetailStoreMemberManagerException(memberRewardPointRedemption+" is NOT FOUND" );
			}

			memberRewardPointRedemption.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);

		
		checkerOf(userContext).checkNameOfRetailStoreMemberAddress(name);
		
		checkerOf(userContext).checkMobilePhoneOfRetailStoreMemberAddress(mobilePhone);
		
		checkerOf(userContext).checkAddressOfRetailStoreMemberAddress(address);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember addRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreMemberAddress(userContext,retailStoreMemberId,name, mobilePhone, address,tokensExpr);

		RetailStoreMemberAddress retailStoreMemberAddress = createRetailStoreMemberAddress(userContext,name, mobilePhone, address);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberAddress( retailStoreMemberAddress );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberAddressManager().onNewInstanceCreated(userContext, retailStoreMemberAddress);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberAddressProperties(YoubenbenUserContext userContext, String retailStoreMemberId,String id,String name,String mobilePhone,String address,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberAddress(id);

		checkerOf(userContext).checkNameOfRetailStoreMemberAddress( name);
		checkerOf(userContext).checkMobilePhoneOfRetailStoreMemberAddress( mobilePhone);
		checkerOf(userContext).checkAddressOfRetailStoreMemberAddress( address);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember updateRetailStoreMemberAddressProperties(YoubenbenUserContext userContext, String retailStoreMemberId, String id,String name,String mobilePhone,String address, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberAddressProperties(userContext,retailStoreMemberId,id,name,mobilePhone,address,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberAddressListList()
				.searchRetailStoreMemberAddressListWith(RetailStoreMemberAddress.ID_PROPERTY, "is", id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getRetailStoreMemberAddressList().isEmpty()){
			throw new RetailStoreMemberManagerException("RetailStoreMemberAddress is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreMemberAddress item = retailStoreMemberToUpdate.getRetailStoreMemberAddressList().first();

		item.updateName( name );
		item.updateMobilePhone( mobilePhone );
		item.updateAddress( address );


		//checkParamsForAddingRetailStoreMemberAddress(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withRetailStoreMemberAddressList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreMemberAddress createRetailStoreMemberAddress(YoubenbenUserContext userContext, String name, String mobilePhone, String address) throws Exception{

		RetailStoreMemberAddress retailStoreMemberAddress = new RetailStoreMemberAddress();
		
		
		retailStoreMemberAddress.setName(name);		
		retailStoreMemberAddress.setMobilePhone(mobilePhone);		
		retailStoreMemberAddress.setAddress(address);
	
		
		return retailStoreMemberAddress;


	}

	protected RetailStoreMemberAddress createIndexedRetailStoreMemberAddress(String id, int version){

		RetailStoreMemberAddress retailStoreMemberAddress = new RetailStoreMemberAddress();
		retailStoreMemberAddress.setId(id);
		retailStoreMemberAddress.setVersion(version);
		return retailStoreMemberAddress;

	}

	protected void checkParamsForRemovingRetailStoreMemberAddressList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberAddressIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String retailStoreMemberAddressIdItem: retailStoreMemberAddressIds){
			checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeRetailStoreMemberAddressList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberAddressIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreMemberAddressList(userContext, retailStoreMemberId,  retailStoreMemberAddressIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveRetailStoreMemberAddressList(retailStoreMember, retailStoreMemberAddressIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getRetailStoreMemberAddressList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberAddress(retailStoreMemberAddressVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreMemberAddress(userContext,retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion,tokensExpr);

		RetailStoreMemberAddress retailStoreMemberAddress = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberAddress( retailStoreMemberAddress );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			deleteRelationInGraph(userContext, retailStoreMemberAddress);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberAddress(retailStoreMemberAddressVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember copyRetailStoreMemberAddressFrom(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreMemberAddress(userContext,retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion,tokensExpr);

		RetailStoreMemberAddress retailStoreMemberAddress = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreMember.copyRetailStoreMemberAddressFrom( retailStoreMemberAddress );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberAddressManager().onNewInstanceCreated(userContext, (RetailStoreMemberAddress)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberAddress(retailStoreMemberAddressVersion);
		

		if(RetailStoreMemberAddress.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreMemberAddress(parseString(newValueExpr));
		
		}
		
		if(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobilePhoneOfRetailStoreMemberAddress(parseString(newValueExpr));
		
		}
		
		if(RetailStoreMemberAddress.ADDRESS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAddressOfRetailStoreMemberAddress(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}

	public  RetailStoreMember updateRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreMemberAddress(userContext, retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberAddressList().searchRetailStoreMemberAddressListWith(RetailStoreMemberAddress.ID_PROPERTY, "eq", retailStoreMemberAddressId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberAddress( retailStoreMemberAddress );
			//make changes to AcceleraterAccount.
			RetailStoreMemberAddress retailStoreMemberAddressIndex = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);

			RetailStoreMemberAddress retailStoreMemberAddress = retailStoreMember.findTheRetailStoreMemberAddress(retailStoreMemberAddressIndex);
			if(retailStoreMemberAddress == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberAddress+" is NOT FOUND" );
			}

			retailStoreMemberAddress.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String number, BigDecimal remain,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);

		
		checkerOf(userContext).checkNameOfRetailStoreMemberGiftCard(name);
		
		checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCard(number);
		
		checkerOf(userContext).checkRemainOfRetailStoreMemberGiftCard(remain);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember addRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String number, BigDecimal remain, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreMemberGiftCard(userContext,retailStoreMemberId,name, number, remain,tokensExpr);

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createRetailStoreMemberGiftCard(userContext,name, number, remain);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberGiftCard( retailStoreMemberGiftCard );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberGiftCardManager().onNewInstanceCreated(userContext, retailStoreMemberGiftCard);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberGiftCardProperties(YoubenbenUserContext userContext, String retailStoreMemberId,String id,String name,String number,BigDecimal remain,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(id);

		checkerOf(userContext).checkNameOfRetailStoreMemberGiftCard( name);
		checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCard( number);
		checkerOf(userContext).checkRemainOfRetailStoreMemberGiftCard( remain);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember updateRetailStoreMemberGiftCardProperties(YoubenbenUserContext userContext, String retailStoreMemberId, String id,String name,String number,BigDecimal remain, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberGiftCardProperties(userContext,retailStoreMemberId,id,name,number,remain,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberGiftCardListList()
				.searchRetailStoreMemberGiftCardListWith(RetailStoreMemberGiftCard.ID_PROPERTY, "is", id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getRetailStoreMemberGiftCardList().isEmpty()){
			throw new RetailStoreMemberManagerException("RetailStoreMemberGiftCard is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreMemberGiftCard item = retailStoreMemberToUpdate.getRetailStoreMemberGiftCardList().first();

		item.updateName( name );
		item.updateNumber( number );
		item.updateRemain( remain );


		//checkParamsForAddingRetailStoreMemberGiftCard(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withRetailStoreMemberGiftCardList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String name, String number, BigDecimal remain) throws Exception{

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		
		
		retailStoreMemberGiftCard.setName(name);		
		retailStoreMemberGiftCard.setNumber(number);		
		retailStoreMemberGiftCard.setRemain(remain);
	
		
		return retailStoreMemberGiftCard;


	}

	protected RetailStoreMemberGiftCard createIndexedRetailStoreMemberGiftCard(String id, int version){

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		retailStoreMemberGiftCard.setId(id);
		retailStoreMemberGiftCard.setVersion(version);
		return retailStoreMemberGiftCard;

	}

	protected void checkParamsForRemovingRetailStoreMemberGiftCardList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberGiftCardIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String retailStoreMemberGiftCardIdItem: retailStoreMemberGiftCardIds){
			checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeRetailStoreMemberGiftCardList(YoubenbenUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberGiftCardIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreMemberGiftCardList(userContext, retailStoreMemberId,  retailStoreMemberGiftCardIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveRetailStoreMemberGiftCardList(retailStoreMember, retailStoreMemberGiftCardIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getRetailStoreMemberGiftCardList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreMemberGiftCard(userContext,retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion,tokensExpr);

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberGiftCard( retailStoreMemberGiftCard );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			deleteRelationInGraph(userContext, retailStoreMemberGiftCard);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember copyRetailStoreMemberGiftCardFrom(YoubenbenUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreMemberGiftCard(userContext,retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion,tokensExpr);

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreMember.copyRetailStoreMemberGiftCardFrom( retailStoreMemberGiftCard );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberGiftCardManager().onNewInstanceCreated(userContext, (RetailStoreMemberGiftCard)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardVersion);
		

		if(RetailStoreMemberGiftCard.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreMemberGiftCard(parseString(newValueExpr));
		
		}
		
		if(RetailStoreMemberGiftCard.NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCard(parseString(newValueExpr));
		
		}
		
		if(RetailStoreMemberGiftCard.REMAIN_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemainOfRetailStoreMemberGiftCard(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}

	public  RetailStoreMember updateRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreMemberGiftCard(userContext, retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberGiftCardList().searchRetailStoreMemberGiftCardListWith(RetailStoreMemberGiftCard.ID_PROPERTY, "eq", retailStoreMemberGiftCardId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberGiftCard( retailStoreMemberGiftCard );
			//make changes to AcceleraterAccount.
			RetailStoreMemberGiftCard retailStoreMemberGiftCardIndex = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);

			RetailStoreMemberGiftCard retailStoreMemberGiftCard = retailStoreMember.findTheRetailStoreMemberGiftCard(retailStoreMemberGiftCardIndex);
			if(retailStoreMemberGiftCard == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberGiftCard+" is NOT FOUND" );
			}

			retailStoreMemberGiftCard.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreMember newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(YoubenbenUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(YoubenbenUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(YoubenbenUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(YoubenbenUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(YoubenbenUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		YoubenbenUserContextImpl userContext = (YoubenbenUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(YoubenbenUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(YoubenbenUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(YoubenbenUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   RetailStoreMember newRetailStoreMember = this.createRetailStoreMember(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreMember
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreMember.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((YoubenbenBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<RetailStoreMember> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> ownerList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(ownerList, RetailStoreCountryCenter.class);


    }
	
	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception {
		return listPageByOwner(userContext, ownerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception {
		SmartList<RetailStoreMember> list = retailStoreMemberDaoOf(userContext).findRetailStoreMemberByOwner(ownerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(RetailStoreMember.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(ownerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("生超会员列表");
		page.setRequestName("listByOwner");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOwner/%s/",  getBeanName(), ownerId)));

		page.assemblerContent(userContext, "listByOwner");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String retailStoreMemberId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getRetailStoreMemberDetailScope().clone();
		RetailStoreMember merchantObj = (RetailStoreMember) this.view(userContext, retailStoreMemberId);
    String merchantObjId = retailStoreMemberId;
    String linkToUrl =	"retailStoreMemberManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超会员"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-mobilePhone")
				    .put("fieldName", "mobilePhone")
				    .put("label", "移动电话")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("mobilePhone", merchantObj.getMobilePhone());

		propList.add(
				MapUtil.put("id", "4-owner")
				    .put("fieldName", "owner")
				    .put("label", "所有人")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

		//处理 sectionList

		//处理Section：consumerOrderListSection
		Map consumerOrderListSection = ListofUtils.buildSection(
		    "consumerOrderListSection",
		    "消费者的订单列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderManager/listByConsumer/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(consumerOrderListSection);

		result.put("consumerOrderListSection", ListofUtils.toShortList(merchantObj.getConsumerOrderList(), "consumerOrder"));
		vscope.field("consumerOrderListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( ConsumerOrder.class.getName(), null));

		//处理Section：retailStoreMemberCouponListSection
		Map retailStoreMemberCouponListSection = ListofUtils.buildSection(
		    "retailStoreMemberCouponListSection",
		    "零售会员优惠券列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreMemberCouponManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreMemberCouponListSection);

		result.put("retailStoreMemberCouponListSection", ListofUtils.toShortList(merchantObj.getRetailStoreMemberCouponList(), "retailStoreMemberCoupon"));
		vscope.field("retailStoreMemberCouponListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreMemberCoupon.class.getName(), null));

		//处理Section：memberWishlistListSection
		Map memberWishlistListSection = ListofUtils.buildSection(
		    "memberWishlistListSection",
		    "成员的清单列表",
		    null,
		    "",
		    "__no_group",
		    "memberWishlistManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(memberWishlistListSection);

		result.put("memberWishlistListSection", ListofUtils.toShortList(merchantObj.getMemberWishlistList(), "memberWishlist"));
		vscope.field("memberWishlistListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( MemberWishlist.class.getName(), null));

		//处理Section：memberRewardPointListSection
		Map memberRewardPointListSection = ListofUtils.buildSection(
		    "memberRewardPointListSection",
		    "会员奖励积分表",
		    null,
		    "",
		    "__no_group",
		    "memberRewardPointManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(memberRewardPointListSection);

		result.put("memberRewardPointListSection", ListofUtils.toShortList(merchantObj.getMemberRewardPointList(), "memberRewardPoint"));
		vscope.field("memberRewardPointListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( MemberRewardPoint.class.getName(), null));

		//处理Section：memberRewardPointRedemptionListSection
		Map memberRewardPointRedemptionListSection = ListofUtils.buildSection(
		    "memberRewardPointRedemptionListSection",
		    "会员奖励积分兑换名单",
		    null,
		    "",
		    "__no_group",
		    "memberRewardPointRedemptionManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(memberRewardPointRedemptionListSection);

		result.put("memberRewardPointRedemptionListSection", ListofUtils.toShortList(merchantObj.getMemberRewardPointRedemptionList(), "memberRewardPointRedemption"));
		vscope.field("memberRewardPointRedemptionListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( MemberRewardPointRedemption.class.getName(), null));

		//处理Section：retailStoreMemberAddressListSection
		Map retailStoreMemberAddressListSection = ListofUtils.buildSection(
		    "retailStoreMemberAddressListSection",
		    "零售店会员地址列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreMemberAddressManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreMemberAddressListSection);

		result.put("retailStoreMemberAddressListSection", ListofUtils.toShortList(merchantObj.getRetailStoreMemberAddressList(), "retailStoreMemberAddress"));
		vscope.field("retailStoreMemberAddressListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreMemberAddress.class.getName(), null));

		//处理Section：retailStoreMemberGiftCardListSection
		Map retailStoreMemberGiftCardListSection = ListofUtils.buildSection(
		    "retailStoreMemberGiftCardListSection",
		    "零售店会员礼品卡列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreMemberGiftCardManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreMemberGiftCardListSection);

		result.put("retailStoreMemberGiftCardListSection", ListofUtils.toShortList(merchantObj.getRetailStoreMemberGiftCardList(), "retailStoreMemberGiftCard"));
		vscope.field("retailStoreMemberGiftCardListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreMemberGiftCard.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


