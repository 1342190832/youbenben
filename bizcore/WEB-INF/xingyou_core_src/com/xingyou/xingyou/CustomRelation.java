
package com.xingyou.xingyou;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("Catalog"                               , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("LevelOneCategory"                      , BaseRelation.TRUST_CHAIN_ALL, "catalog");
		//replaceGenericRelation("LevelTwoCategory"                      , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("LevelThreeCategory"                    , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("Product"                               , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("Sku"                                   , BaseRelation.TRUST_CHAIN_ALL, "product");
		//replaceGenericRelation("FranchisedOutletCityCenter"            , BaseRelation.TRUST_CHAIN_ALL, "city");
		//replaceGenericRelation("CityCenterDepartment"                  , BaseRelation.TRUST_CHAIN_ALL, "cityCenter");
		//replaceGenericRelation("CityCenterEmployee"                    , BaseRelation.TRUST_CHAIN_ALL, "department");
		//replaceGenericRelation("CityCenterEmployee"                    , BaseRelation.TRUST_CHAIN_ALL, "cityCenter");
		//replaceGenericRelation("FranchisedOutletCityServiceCenter"     , BaseRelation.TRUST_CHAIN_ALL, "belongsTo");
		//replaceGenericRelation("CityPartner"                           , BaseRelation.TRUST_CHAIN_ALL, "townServiceCenter");
		//replaceGenericRelation("PotentialCustomer"                     , BaseRelation.TRUST_CHAIN_ALL, "cityServiceCenter");
		//replaceGenericRelation("PotentialCustomer"                     , BaseRelation.TRUST_CHAIN_ALL, "cityPartner");
		//replaceGenericRelation("PotentialCustomerContactPerson"        , BaseRelation.TRUST_CHAIN_ALL, "potentialCustomer");
		//replaceGenericRelation("PotentialCustomerContact"              , BaseRelation.TRUST_CHAIN_ALL, "potentialCustomer");
		//replaceGenericRelation("PotentialCustomerContact"              , BaseRelation.TRUST_CHAIN_ALL, "cityPartner");
		//replaceGenericRelation("PotentialCustomerContact"              , BaseRelation.TRUST_CHAIN_ALL, "contactTo");
		//replaceGenericRelation("CityEvent"                             , BaseRelation.TRUST_CHAIN_ALL, "cityServiceCenter");
		//replaceGenericRelation("EventAttendance"                       , BaseRelation.TRUST_CHAIN_ALL, "potentialCustomer");
		//replaceGenericRelation("EventAttendance"                       , BaseRelation.TRUST_CHAIN_ALL, "cityEvent");
		//replaceGenericRelation("Page"                                  , BaseRelation.TRUST_CHAIN_ALL, "pageType");
		//replaceGenericRelation("Page"                                  , BaseRelation.TRUST_CHAIN_ALL, "mobileApp");
		//replaceGenericRelation("PageType"                              , BaseRelation.TRUST_CHAIN_ALL, "mobileApp");
		//replaceGenericRelation("Slide"                                 , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("UiAction"                              , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("Section"                               , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("UserWhiteList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("QuickLink"                             , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("CandidateElement"                      , BaseRelation.TRUST_CHAIN_ALL, "container");
		//replaceGenericRelation("WechatWorkappIdentify"                 , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("WechatMiniappIdentify"                 , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("KeypairIdentify"                       , BaseRelation.TRUST_CHAIN_ALL, "keyType");
		//replaceGenericRelation("KeypairIdentify"                       , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("PublicKeyType"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] catalogRelatedObjectNames = {"owner:FranchisedOutletProvinceCenter"};
		//replaceRelationIndex("Catalog",catalogRelatedObjectNames);

		//String [] levelOneCategoryRelatedObjectNames = {"catalog:Catalog"};
		//replaceRelationIndex("LevelOneCategory",levelOneCategoryRelatedObjectNames);

		//String [] levelTwoCategoryRelatedObjectNames = {"parent_category:LevelOneCategory"};
		//replaceRelationIndex("LevelTwoCategory",levelTwoCategoryRelatedObjectNames);

		//String [] levelThreeCategoryRelatedObjectNames = {"parent_category:LevelTwoCategory"};
		//replaceRelationIndex("LevelThreeCategory",levelThreeCategoryRelatedObjectNames);

		//String [] productRelatedObjectNames = {"parent_category:LevelThreeCategory"};
		//replaceRelationIndex("Product",productRelatedObjectNames);

		//String [] skuRelatedObjectNames = {"product:Product"};
		//replaceRelationIndex("Sku",skuRelatedObjectNames);

		//String [] franchisedOutletCityCenterRelatedObjectNames = {"city:FranchisedOutletCityCenter"};
		//replaceRelationIndex("FranchisedOutletCityCenter",franchisedOutletCityCenterRelatedObjectNames);

		//String [] cityCenterDepartmentRelatedObjectNames = {"city_center:FranchisedOutletCityCenter"};
		//replaceRelationIndex("CityCenterDepartment",cityCenterDepartmentRelatedObjectNames);

		//String [] cityCenterEmployeeRelatedObjectNames = {"department:CityCenterDepartment","city_center:FranchisedOutletCityCenter"};
		//replaceRelationIndex("CityCenterEmployee",cityCenterEmployeeRelatedObjectNames);

		//String [] franchisedOutletCityServiceCenterRelatedObjectNames = {"belongs_to:FranchisedOutletCityCenter"};
		//replaceRelationIndex("FranchisedOutletCityServiceCenter",franchisedOutletCityServiceCenterRelatedObjectNames);

		//String [] cityPartnerRelatedObjectNames = {"town_service_center:FranchisedOutletCityServiceCenter"};
		//replaceRelationIndex("CityPartner",cityPartnerRelatedObjectNames);

		//String [] potentialCustomerRelatedObjectNames = {"city_service_center:FranchisedOutletCityServiceCenter","city_partner:CityPartner"};
		//replaceRelationIndex("PotentialCustomer",potentialCustomerRelatedObjectNames);

		//String [] potentialCustomerContactPersonRelatedObjectNames = {"potential_customer:PotentialCustomer"};
		//replaceRelationIndex("PotentialCustomerContactPerson",potentialCustomerContactPersonRelatedObjectNames);

		//String [] potentialCustomerContactRelatedObjectNames = {"potential_customer:PotentialCustomer","city_partner:CityPartner","contact_to:PotentialCustomerContactPerson"};
		//replaceRelationIndex("PotentialCustomerContact",potentialCustomerContactRelatedObjectNames);

		//String [] cityEventRelatedObjectNames = {"city_service_center:FranchisedOutletCityServiceCenter"};
		//replaceRelationIndex("CityEvent",cityEventRelatedObjectNames);

		//String [] eventAttendanceRelatedObjectNames = {"potential_customer:PotentialCustomer","city_event:CityEvent"};
		//replaceRelationIndex("EventAttendance",eventAttendanceRelatedObjectNames);

		//String [] pageRelatedObjectNames = {"page_type:PageType","mobile_app:MobileApp"};
		//replaceRelationIndex("Page",pageRelatedObjectNames);

		//String [] pageTypeRelatedObjectNames = {"mobile_app:MobileApp"};
		//replaceRelationIndex("PageType",pageTypeRelatedObjectNames);

		//String [] slideRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("Slide",slideRelatedObjectNames);

		//String [] uiActionRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("UiAction",uiActionRelatedObjectNames);

		//String [] sectionRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("Section",sectionRelatedObjectNames);

		//String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] quickLinkRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("QuickLink",quickLinkRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		//String [] candidateElementRelatedObjectNames = {"container:CandidateContainer"};
		//replaceRelationIndex("CandidateElement",candidateElementRelatedObjectNames);

		//String [] wechatWorkappIdentifyRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("WechatWorkappIdentify",wechatWorkappIdentifyRelatedObjectNames);

		//String [] wechatMiniappIdentifyRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("WechatMiniappIdentify",wechatMiniappIdentifyRelatedObjectNames);

		//String [] keypairIdentifyRelatedObjectNames = {"key_type:PublicKeyType","sec_user:SecUser"};
		//replaceRelationIndex("KeypairIdentify",keypairIdentifyRelatedObjectNames);

		//String [] publicKeyTypeRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("PublicKeyType",publicKeyTypeRelatedObjectNames);

		
		
	
	}
	
	
	@Override
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{

		String relation = super.getRelation(fromType, fromId, targetField, targetId);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}

}




















