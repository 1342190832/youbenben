package com.xingyou.xingyou;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
public class XingyouObjectChecker extends XingyouChecker{

	Set<BaseEntity> checkedObjectSet;
	
	protected void markAsChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			checkedObjectSet =  new HashSet<BaseEntity>();
		}
		checkedObjectSet.add(baseEntity);
		
		
	}
	
	protected boolean isChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			return false;
			
		}
		return checkedObjectSet.contains(baseEntity);
	}
	@FunctionalInterface
	public interface CheckerParameterFunction<P1> {
		XingyouChecker apply(P1 valueToCheck);
	}
	@FunctionalInterface
	public interface AssignParameterFunction {
		XingyouObjectChecker apply(BaseEntity targetEntity);
	}
	
	protected boolean isReferenceObject(BaseEntity target) {
		
		if(target.getId()==null) {
			return false;
		}
		if(target.getId().isEmpty()) {
			return false;
		}
		if(target.getVersion() > 0) {
			return false;
		}
		
		return true;
		
	}
	protected boolean isObjectForCreate(BaseEntity target) {
		if(target.getVersion() > 0) {
			return false;
		}
		if(target.getId()==null) {
			return true;
		}
		if(!target.getId().isEmpty()) {
			return false;
		}
		
		
		return true;
		
	}
	protected void setEntityProperty(BaseEntity targetEntity, String property, Object value) {
		if(!targetEntity.isChanged()) {
			return;
		}
		try {
			targetEntity.setPropertyOf(property, value);
		} catch (Exception e) {
			throw new IllegalArgumentException(concat("set property <",property,"> with value ",value.toString()," of ",targetEntity.toString()," failed"));
		}
		
	}
	
	public <T> XingyouObjectChecker commonObjectPropertyAssign(BaseEntity target, String propertyName, AssignParameterFunction assigmentFunction) {
		assigmentFunction.apply(target);
		return this;
	}
	public <T> XingyouObjectChecker commonObjectPropertyCheck(BaseEntity target, String propertyName, CheckerParameterFunction<T> checkerFunction) {
		
		
		if(!target.isChanged()) {
			return this;
		}
		
		if(isReferenceObject(target)&&!propertyName.equals("id")) {
			//this is an object reference, so all other properties except id check will be ignored
			//id will be checked in this case
			return this; //with an Id, but version is 0 regard as refencer
		}
		if(isObjectForCreate(target)&&propertyName.equals("id")) {
			// ignore check id for new object to create
			return this;
		}
		pushPosition(propertyName);
		T valueToCheck=(T)target.propertyOf(propertyName);
		checkerFunction.apply(valueToCheck);
		popPosition();
		
		return this;
	}
	public  XingyouChecker commonObjectElementCheck(BaseEntity target, String propertyName, CheckerParameterFunction<BaseEntity> checkerFunction) {
		
		pushPosition(propertyName);
		checkerFunction.apply(target);
		popPosition();
		return this;
	}
	protected String wrapArrayIndex(int andIncrement) {
		return "["+andIncrement+"]";
	}
	protected String concat(String ...args) {
		
		return Arrays.asList(args).stream().collect(Collectors.joining(""));
		
	}
	// use like commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);

	public XingyouObjectChecker checkAndFixFranchisedOutletProvinceCenter(BaseEntity franchisedOutletProvinceCenterAsBaseEntity){

		if( isChecked(franchisedOutletProvinceCenterAsBaseEntity) ){
			return this;
		}
		markAsChecked(franchisedOutletProvinceCenterAsBaseEntity);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"id",this::checkIdOfFranchisedOutletProvinceCenter);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"name",this::checkNameOfFranchisedOutletProvinceCenter);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"serviceNumber",this::checkServiceNumberOfFranchisedOutletProvinceCenter);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"founded",this::checkFoundedOfFranchisedOutletProvinceCenter);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"webSite",this::checkWebSiteOfFranchisedOutletProvinceCenter);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"address",this::checkAddressOfFranchisedOutletProvinceCenter);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"operatedBy",this::checkOperatedByOfFranchisedOutletProvinceCenter);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"legalRepresentative",this::checkLegalRepresentativeOfFranchisedOutletProvinceCenter);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"description",this::checkDescriptionOfFranchisedOutletProvinceCenter);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"version",this::checkVersionOfFranchisedOutletProvinceCenter);
		commonObjectPropertyCheck(franchisedOutletProvinceCenterAsBaseEntity,"catalogList",this::checkCatalogListOfFranchisedOutletProvinceCenter);
		return this;

	}

	public XingyouObjectChecker checkAndFixCatalog(BaseEntity catalogAsBaseEntity){

		if( isChecked(catalogAsBaseEntity) ){
			return this;
		}
		markAsChecked(catalogAsBaseEntity);
		commonObjectPropertyCheck(catalogAsBaseEntity,"id",this::checkIdOfCatalog);
		commonObjectPropertyCheck(catalogAsBaseEntity,"name",this::checkNameOfCatalog);
		commonObjectPropertyCheck(catalogAsBaseEntity,"owner",this::checkOwnerOfCatalog);
		commonObjectPropertyCheck(catalogAsBaseEntity,"subCount",this::checkSubCountOfCatalog);
		commonObjectPropertyCheck(catalogAsBaseEntity,"amount",this::checkAmountOfCatalog);
		commonObjectPropertyCheck(catalogAsBaseEntity,"version",this::checkVersionOfCatalog);
		commonObjectPropertyCheck(catalogAsBaseEntity,"levelOneCategoryList",this::checkLevelOneCategoryListOfCatalog);
		return this;

	}

	public XingyouObjectChecker checkAndFixLevelOneCategory(BaseEntity levelOneCategoryAsBaseEntity){

		if( isChecked(levelOneCategoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(levelOneCategoryAsBaseEntity);
		commonObjectPropertyCheck(levelOneCategoryAsBaseEntity,"id",this::checkIdOfLevelOneCategory);
		commonObjectPropertyCheck(levelOneCategoryAsBaseEntity,"catalog",this::checkCatalogOfLevelOneCategory);
		commonObjectPropertyCheck(levelOneCategoryAsBaseEntity,"name",this::checkNameOfLevelOneCategory);
		commonObjectPropertyCheck(levelOneCategoryAsBaseEntity,"version",this::checkVersionOfLevelOneCategory);
		commonObjectPropertyCheck(levelOneCategoryAsBaseEntity,"levelTwoCategoryList",this::checkLevelTwoCategoryListOfLevelOneCategory);
		return this;

	}

	public XingyouObjectChecker checkAndFixLevelTwoCategory(BaseEntity levelTwoCategoryAsBaseEntity){

		if( isChecked(levelTwoCategoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(levelTwoCategoryAsBaseEntity);
		commonObjectPropertyCheck(levelTwoCategoryAsBaseEntity,"id",this::checkIdOfLevelTwoCategory);
		commonObjectPropertyCheck(levelTwoCategoryAsBaseEntity,"parentCategory",this::checkParentCategoryOfLevelTwoCategory);
		commonObjectPropertyCheck(levelTwoCategoryAsBaseEntity,"name",this::checkNameOfLevelTwoCategory);
		commonObjectPropertyCheck(levelTwoCategoryAsBaseEntity,"version",this::checkVersionOfLevelTwoCategory);
		commonObjectPropertyCheck(levelTwoCategoryAsBaseEntity,"levelThreeCategoryList",this::checkLevelThreeCategoryListOfLevelTwoCategory);
		return this;

	}

	public XingyouObjectChecker checkAndFixLevelThreeCategory(BaseEntity levelThreeCategoryAsBaseEntity){

		if( isChecked(levelThreeCategoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(levelThreeCategoryAsBaseEntity);
		commonObjectPropertyCheck(levelThreeCategoryAsBaseEntity,"id",this::checkIdOfLevelThreeCategory);
		commonObjectPropertyCheck(levelThreeCategoryAsBaseEntity,"parentCategory",this::checkParentCategoryOfLevelThreeCategory);
		commonObjectPropertyCheck(levelThreeCategoryAsBaseEntity,"name",this::checkNameOfLevelThreeCategory);
		commonObjectPropertyCheck(levelThreeCategoryAsBaseEntity,"version",this::checkVersionOfLevelThreeCategory);
		commonObjectPropertyCheck(levelThreeCategoryAsBaseEntity,"productList",this::checkProductListOfLevelThreeCategory);
		return this;

	}

	public XingyouObjectChecker checkAndFixProduct(BaseEntity productAsBaseEntity){

		if( isChecked(productAsBaseEntity) ){
			return this;
		}
		markAsChecked(productAsBaseEntity);
		commonObjectPropertyCheck(productAsBaseEntity,"id",this::checkIdOfProduct);
		commonObjectPropertyCheck(productAsBaseEntity,"name",this::checkNameOfProduct);
		commonObjectPropertyCheck(productAsBaseEntity,"parentCategory",this::checkParentCategoryOfProduct);
		commonObjectPropertyCheck(productAsBaseEntity,"origin",this::checkOriginOfProduct);
		commonObjectPropertyCheck(productAsBaseEntity,"remark",this::checkRemarkOfProduct);
		commonObjectPropertyCheck(productAsBaseEntity,"brand",this::checkBrandOfProduct);
		commonObjectPropertyCheck(productAsBaseEntity,"picture",this::checkPictureOfProduct);
		commonObjectPropertyAssign(productAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfProduct);
		commonObjectPropertyCheck(productAsBaseEntity,"version",this::checkVersionOfProduct);
		commonObjectPropertyCheck(productAsBaseEntity,"skuList",this::checkSkuListOfProduct);
		return this;

	}

	public XingyouObjectChecker checkAndFixSku(BaseEntity skuAsBaseEntity){

		if( isChecked(skuAsBaseEntity) ){
			return this;
		}
		markAsChecked(skuAsBaseEntity);
		commonObjectPropertyCheck(skuAsBaseEntity,"id",this::checkIdOfSku);
		commonObjectPropertyCheck(skuAsBaseEntity,"name",this::checkNameOfSku);
		commonObjectPropertyCheck(skuAsBaseEntity,"size",this::checkSizeOfSku);
		commonObjectPropertyCheck(skuAsBaseEntity,"product",this::checkProductOfSku);
		commonObjectPropertyCheck(skuAsBaseEntity,"barcode",this::checkBarcodeOfSku);
		commonObjectPropertyCheck(skuAsBaseEntity,"packageType",this::checkPackageTypeOfSku);
		commonObjectPropertyCheck(skuAsBaseEntity,"netContent",this::checkNetContentOfSku);
		commonObjectPropertyCheck(skuAsBaseEntity,"price",this::checkPriceOfSku);
		commonObjectPropertyCheck(skuAsBaseEntity,"picture",this::checkPictureOfSku);
		commonObjectPropertyCheck(skuAsBaseEntity,"version",this::checkVersionOfSku);
		return this;

	}

	public XingyouObjectChecker checkAndFixFranchisedOutletCityCenter(BaseEntity franchisedOutletCityCenterAsBaseEntity){

		if( isChecked(franchisedOutletCityCenterAsBaseEntity) ){
			return this;
		}
		markAsChecked(franchisedOutletCityCenterAsBaseEntity);
		commonObjectPropertyCheck(franchisedOutletCityCenterAsBaseEntity,"id",this::checkIdOfFranchisedOutletCityCenter);
		commonObjectPropertyCheck(franchisedOutletCityCenterAsBaseEntity,"name",this::checkNameOfFranchisedOutletCityCenter);
		commonObjectPropertyCheck(franchisedOutletCityCenterAsBaseEntity,"founded",this::checkFoundedOfFranchisedOutletCityCenter);
		commonObjectPropertyCheck(franchisedOutletCityCenterAsBaseEntity,"city",this::checkCityOfFranchisedOutletCityCenter);
		commonObjectPropertyAssign(franchisedOutletCityCenterAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfFranchisedOutletCityCenter);
		commonObjectPropertyCheck(franchisedOutletCityCenterAsBaseEntity,"version",this::checkVersionOfFranchisedOutletCityCenter);
		commonObjectPropertyCheck(franchisedOutletCityCenterAsBaseEntity,"franchisedOutletCityCenterList",this::checkFranchisedOutletCityCenterListOfFranchisedOutletCityCenter);
		commonObjectPropertyCheck(franchisedOutletCityCenterAsBaseEntity,"cityCenterDepartmentList",this::checkCityCenterDepartmentListOfFranchisedOutletCityCenter);
		commonObjectPropertyCheck(franchisedOutletCityCenterAsBaseEntity,"cityCenterEmployeeList",this::checkCityCenterEmployeeListOfFranchisedOutletCityCenter);
		commonObjectPropertyCheck(franchisedOutletCityCenterAsBaseEntity,"franchisedOutletCityServiceCenterList",this::checkFranchisedOutletCityServiceCenterListOfFranchisedOutletCityCenter);
		return this;

	}

	public XingyouObjectChecker checkAndFixCityCenterDepartment(BaseEntity cityCenterDepartmentAsBaseEntity){

		if( isChecked(cityCenterDepartmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(cityCenterDepartmentAsBaseEntity);
		commonObjectPropertyCheck(cityCenterDepartmentAsBaseEntity,"id",this::checkIdOfCityCenterDepartment);
		commonObjectPropertyCheck(cityCenterDepartmentAsBaseEntity,"name",this::checkNameOfCityCenterDepartment);
		commonObjectPropertyCheck(cityCenterDepartmentAsBaseEntity,"founded",this::checkFoundedOfCityCenterDepartment);
		commonObjectPropertyCheck(cityCenterDepartmentAsBaseEntity,"cityCenter",this::checkCityCenterOfCityCenterDepartment);
		commonObjectPropertyCheck(cityCenterDepartmentAsBaseEntity,"manager",this::checkManagerOfCityCenterDepartment);
		commonObjectPropertyCheck(cityCenterDepartmentAsBaseEntity,"version",this::checkVersionOfCityCenterDepartment);
		commonObjectPropertyCheck(cityCenterDepartmentAsBaseEntity,"cityCenterEmployeeList",this::checkCityCenterEmployeeListOfCityCenterDepartment);
		return this;

	}

	public XingyouObjectChecker checkAndFixCityCenterEmployee(BaseEntity cityCenterEmployeeAsBaseEntity){

		if( isChecked(cityCenterEmployeeAsBaseEntity) ){
			return this;
		}
		markAsChecked(cityCenterEmployeeAsBaseEntity);
		commonObjectPropertyCheck(cityCenterEmployeeAsBaseEntity,"id",this::checkIdOfCityCenterEmployee);
		commonObjectPropertyCheck(cityCenterEmployeeAsBaseEntity,"name",this::checkNameOfCityCenterEmployee);
		commonObjectPropertyCheck(cityCenterEmployeeAsBaseEntity,"mobile",this::checkMobileOfCityCenterEmployee);
		commonObjectPropertyCheck(cityCenterEmployeeAsBaseEntity,"email",this::checkEmailOfCityCenterEmployee);
		commonObjectPropertyCheck(cityCenterEmployeeAsBaseEntity,"founded",this::checkFoundedOfCityCenterEmployee);
		commonObjectPropertyCheck(cityCenterEmployeeAsBaseEntity,"department",this::checkDepartmentOfCityCenterEmployee);
		commonObjectPropertyCheck(cityCenterEmployeeAsBaseEntity,"cityCenter",this::checkCityCenterOfCityCenterEmployee);
		commonObjectPropertyCheck(cityCenterEmployeeAsBaseEntity,"version",this::checkVersionOfCityCenterEmployee);
		return this;

	}

	public XingyouObjectChecker checkAndFixFranchisedOutletCityServiceCenter(BaseEntity franchisedOutletCityServiceCenterAsBaseEntity){

		if( isChecked(franchisedOutletCityServiceCenterAsBaseEntity) ){
			return this;
		}
		markAsChecked(franchisedOutletCityServiceCenterAsBaseEntity);
		commonObjectPropertyCheck(franchisedOutletCityServiceCenterAsBaseEntity,"id",this::checkIdOfFranchisedOutletCityServiceCenter);
		commonObjectPropertyCheck(franchisedOutletCityServiceCenterAsBaseEntity,"name",this::checkNameOfFranchisedOutletCityServiceCenter);
		commonObjectPropertyCheck(franchisedOutletCityServiceCenterAsBaseEntity,"founded",this::checkFoundedOfFranchisedOutletCityServiceCenter);
		commonObjectPropertyCheck(franchisedOutletCityServiceCenterAsBaseEntity,"belongsTo",this::checkBelongsToOfFranchisedOutletCityServiceCenter);
		commonObjectPropertyAssign(franchisedOutletCityServiceCenterAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfFranchisedOutletCityServiceCenter);
		commonObjectPropertyCheck(franchisedOutletCityServiceCenterAsBaseEntity,"version",this::checkVersionOfFranchisedOutletCityServiceCenter);
		commonObjectPropertyCheck(franchisedOutletCityServiceCenterAsBaseEntity,"cityPartnerList",this::checkCityPartnerListOfFranchisedOutletCityServiceCenter);
		commonObjectPropertyCheck(franchisedOutletCityServiceCenterAsBaseEntity,"potentialCustomerList",this::checkPotentialCustomerListOfFranchisedOutletCityServiceCenter);
		commonObjectPropertyCheck(franchisedOutletCityServiceCenterAsBaseEntity,"cityEventList",this::checkCityEventListOfFranchisedOutletCityServiceCenter);
		return this;

	}

	public XingyouObjectChecker checkAndFixCityPartner(BaseEntity cityPartnerAsBaseEntity){

		if( isChecked(cityPartnerAsBaseEntity) ){
			return this;
		}
		markAsChecked(cityPartnerAsBaseEntity);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"id",this::checkIdOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"name",this::checkNameOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"mobile",this::checkMobileOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"townServiceCenter",this::checkTownServiceCenterOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"description",this::checkDescriptionOfCityPartner);
		commonObjectPropertyAssign(cityPartnerAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"version",this::checkVersionOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"potentialCustomerList",this::checkPotentialCustomerListOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"potentialCustomerContactList",this::checkPotentialCustomerContactListOfCityPartner);
		return this;

	}

	public XingyouObjectChecker checkAndFixPotentialCustomer(BaseEntity potentialCustomerAsBaseEntity){

		if( isChecked(potentialCustomerAsBaseEntity) ){
			return this;
		}
		markAsChecked(potentialCustomerAsBaseEntity);
		commonObjectPropertyCheck(potentialCustomerAsBaseEntity,"id",this::checkIdOfPotentialCustomer);
		commonObjectPropertyCheck(potentialCustomerAsBaseEntity,"name",this::checkNameOfPotentialCustomer);
		commonObjectPropertyCheck(potentialCustomerAsBaseEntity,"mobile",this::checkMobileOfPotentialCustomer);
		commonObjectPropertyCheck(potentialCustomerAsBaseEntity,"cityServiceCenter",this::checkCityServiceCenterOfPotentialCustomer);
		commonObjectPropertyCheck(potentialCustomerAsBaseEntity,"cityPartner",this::checkCityPartnerOfPotentialCustomer);
		commonObjectPropertyCheck(potentialCustomerAsBaseEntity,"description",this::checkDescriptionOfPotentialCustomer);
		commonObjectPropertyAssign(potentialCustomerAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfPotentialCustomer);
		commonObjectPropertyCheck(potentialCustomerAsBaseEntity,"version",this::checkVersionOfPotentialCustomer);
		commonObjectPropertyCheck(potentialCustomerAsBaseEntity,"potentialCustomerContactPersonList",this::checkPotentialCustomerContactPersonListOfPotentialCustomer);
		commonObjectPropertyCheck(potentialCustomerAsBaseEntity,"potentialCustomerContactList",this::checkPotentialCustomerContactListOfPotentialCustomer);
		commonObjectPropertyCheck(potentialCustomerAsBaseEntity,"eventAttendanceList",this::checkEventAttendanceListOfPotentialCustomer);
		return this;

	}

	public XingyouObjectChecker checkAndFixPotentialCustomerContactPerson(BaseEntity potentialCustomerContactPersonAsBaseEntity){

		if( isChecked(potentialCustomerContactPersonAsBaseEntity) ){
			return this;
		}
		markAsChecked(potentialCustomerContactPersonAsBaseEntity);
		commonObjectPropertyCheck(potentialCustomerContactPersonAsBaseEntity,"id",this::checkIdOfPotentialCustomerContactPerson);
		commonObjectPropertyCheck(potentialCustomerContactPersonAsBaseEntity,"name",this::checkNameOfPotentialCustomerContactPerson);
		commonObjectPropertyCheck(potentialCustomerContactPersonAsBaseEntity,"mobile",this::checkMobileOfPotentialCustomerContactPerson);
		commonObjectPropertyCheck(potentialCustomerContactPersonAsBaseEntity,"potentialCustomer",this::checkPotentialCustomerOfPotentialCustomerContactPerson);
		commonObjectPropertyCheck(potentialCustomerContactPersonAsBaseEntity,"description",this::checkDescriptionOfPotentialCustomerContactPerson);
		commonObjectPropertyCheck(potentialCustomerContactPersonAsBaseEntity,"version",this::checkVersionOfPotentialCustomerContactPerson);
		commonObjectPropertyCheck(potentialCustomerContactPersonAsBaseEntity,"potentialCustomerContactList",this::checkPotentialCustomerContactListOfPotentialCustomerContactPerson);
		return this;

	}

	public XingyouObjectChecker checkAndFixPotentialCustomerContact(BaseEntity potentialCustomerContactAsBaseEntity){

		if( isChecked(potentialCustomerContactAsBaseEntity) ){
			return this;
		}
		markAsChecked(potentialCustomerContactAsBaseEntity);
		commonObjectPropertyCheck(potentialCustomerContactAsBaseEntity,"id",this::checkIdOfPotentialCustomerContact);
		commonObjectPropertyCheck(potentialCustomerContactAsBaseEntity,"name",this::checkNameOfPotentialCustomerContact);
		commonObjectPropertyCheck(potentialCustomerContactAsBaseEntity,"contactDate",this::checkContactDateOfPotentialCustomerContact);
		commonObjectPropertyCheck(potentialCustomerContactAsBaseEntity,"contactMethod",this::checkContactMethodOfPotentialCustomerContact);
		commonObjectPropertyCheck(potentialCustomerContactAsBaseEntity,"potentialCustomer",this::checkPotentialCustomerOfPotentialCustomerContact);
		commonObjectPropertyCheck(potentialCustomerContactAsBaseEntity,"cityPartner",this::checkCityPartnerOfPotentialCustomerContact);
		commonObjectPropertyCheck(potentialCustomerContactAsBaseEntity,"contactTo",this::checkContactToOfPotentialCustomerContact);
		commonObjectPropertyCheck(potentialCustomerContactAsBaseEntity,"description",this::checkDescriptionOfPotentialCustomerContact);
		commonObjectPropertyAssign(potentialCustomerContactAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfPotentialCustomerContact);
		commonObjectPropertyCheck(potentialCustomerContactAsBaseEntity,"version",this::checkVersionOfPotentialCustomerContact);
		return this;

	}

	public XingyouObjectChecker checkAndFixCityEvent(BaseEntity cityEventAsBaseEntity){

		if( isChecked(cityEventAsBaseEntity) ){
			return this;
		}
		markAsChecked(cityEventAsBaseEntity);
		commonObjectPropertyCheck(cityEventAsBaseEntity,"id",this::checkIdOfCityEvent);
		commonObjectPropertyCheck(cityEventAsBaseEntity,"name",this::checkNameOfCityEvent);
		commonObjectPropertyCheck(cityEventAsBaseEntity,"mobile",this::checkMobileOfCityEvent);
		commonObjectPropertyCheck(cityEventAsBaseEntity,"cityServiceCenter",this::checkCityServiceCenterOfCityEvent);
		commonObjectPropertyCheck(cityEventAsBaseEntity,"description",this::checkDescriptionOfCityEvent);
		commonObjectPropertyAssign(cityEventAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfCityEvent);
		commonObjectPropertyCheck(cityEventAsBaseEntity,"version",this::checkVersionOfCityEvent);
		commonObjectPropertyCheck(cityEventAsBaseEntity,"eventAttendanceList",this::checkEventAttendanceListOfCityEvent);
		return this;

	}

	public XingyouObjectChecker checkAndFixEventAttendance(BaseEntity eventAttendanceAsBaseEntity){

		if( isChecked(eventAttendanceAsBaseEntity) ){
			return this;
		}
		markAsChecked(eventAttendanceAsBaseEntity);
		commonObjectPropertyCheck(eventAttendanceAsBaseEntity,"id",this::checkIdOfEventAttendance);
		commonObjectPropertyCheck(eventAttendanceAsBaseEntity,"name",this::checkNameOfEventAttendance);
		commonObjectPropertyCheck(eventAttendanceAsBaseEntity,"potentialCustomer",this::checkPotentialCustomerOfEventAttendance);
		commonObjectPropertyCheck(eventAttendanceAsBaseEntity,"cityEvent",this::checkCityEventOfEventAttendance);
		commonObjectPropertyCheck(eventAttendanceAsBaseEntity,"description",this::checkDescriptionOfEventAttendance);
		commonObjectPropertyCheck(eventAttendanceAsBaseEntity,"version",this::checkVersionOfEventAttendance);
		return this;

	}

	public XingyouObjectChecker checkAndFixMobileApp(BaseEntity mobileAppAsBaseEntity){

		if( isChecked(mobileAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(mobileAppAsBaseEntity);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"id",this::checkIdOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"name",this::checkNameOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"version",this::checkVersionOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"pageList",this::checkPageListOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"pageTypeList",this::checkPageTypeListOfMobileApp);
		return this;

	}

	public XingyouObjectChecker checkAndFixPage(BaseEntity pageAsBaseEntity){

		if( isChecked(pageAsBaseEntity) ){
			return this;
		}
		markAsChecked(pageAsBaseEntity);
		commonObjectPropertyCheck(pageAsBaseEntity,"id",this::checkIdOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"pageTitle",this::checkPageTitleOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"pageType",this::checkPageTypeOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"mobileApp",this::checkMobileAppOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"version",this::checkVersionOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"slideList",this::checkSlideListOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"uiActionList",this::checkUiActionListOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"sectionList",this::checkSectionListOfPage);
		return this;

	}

	public XingyouObjectChecker checkAndFixPageType(BaseEntity pageTypeAsBaseEntity){

		if( isChecked(pageTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(pageTypeAsBaseEntity);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"id",this::checkIdOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"name",this::checkNameOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"code",this::checkCodeOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"mobileApp",this::checkMobileAppOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"footerTab",this::checkFooterTabOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"version",this::checkVersionOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"pageList",this::checkPageListOfPageType);
		return this;

	}

	public XingyouObjectChecker checkAndFixSlide(BaseEntity slideAsBaseEntity){

		if( isChecked(slideAsBaseEntity) ){
			return this;
		}
		markAsChecked(slideAsBaseEntity);
		commonObjectPropertyCheck(slideAsBaseEntity,"id",this::checkIdOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"displayOrder",this::checkDisplayOrderOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"name",this::checkNameOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"imageUrl",this::checkImageUrlOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"videoUrl",this::checkVideoUrlOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"page",this::checkPageOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"version",this::checkVersionOfSlide);
		return this;

	}

	public XingyouObjectChecker checkAndFixUiAction(BaseEntity uiActionAsBaseEntity){

		if( isChecked(uiActionAsBaseEntity) ){
			return this;
		}
		markAsChecked(uiActionAsBaseEntity);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"id",this::checkIdOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"code",this::checkCodeOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"icon",this::checkIconOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"title",this::checkTitleOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"brief",this::checkBriefOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"imageUrl",this::checkImageUrlOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"extraData",this::checkExtraDataOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"page",this::checkPageOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"version",this::checkVersionOfUiAction);
		return this;

	}

	public XingyouObjectChecker checkAndFixSection(BaseEntity sectionAsBaseEntity){

		if( isChecked(sectionAsBaseEntity) ){
			return this;
		}
		markAsChecked(sectionAsBaseEntity);
		commonObjectPropertyCheck(sectionAsBaseEntity,"id",this::checkIdOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"title",this::checkTitleOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"brief",this::checkBriefOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"icon",this::checkIconOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"viewGroup",this::checkViewGroupOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"page",this::checkPageOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"version",this::checkVersionOfSection);
		return this;

	}

	public XingyouObjectChecker checkAndFixUserDomain(BaseEntity userDomainAsBaseEntity){

		if( isChecked(userDomainAsBaseEntity) ){
			return this;
		}
		markAsChecked(userDomainAsBaseEntity);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"id",this::checkIdOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"name",this::checkNameOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"version",this::checkVersionOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"userWhiteListList",this::checkUserWhiteListListOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"secUserList",this::checkSecUserListOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"publicKeyTypeList",this::checkPublicKeyTypeListOfUserDomain);
		return this;

	}

	public XingyouObjectChecker checkAndFixUserWhiteList(BaseEntity userWhiteListAsBaseEntity){

		if( isChecked(userWhiteListAsBaseEntity) ){
			return this;
		}
		markAsChecked(userWhiteListAsBaseEntity);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"id",this::checkIdOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userIdentity",this::checkUserIdentityOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userSpecialFunctions",this::checkUserSpecialFunctionsOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"domain",this::checkDomainOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"version",this::checkVersionOfUserWhiteList);
		return this;

	}

	public XingyouObjectChecker checkAndFixSecUser(BaseEntity secUserAsBaseEntity){

		if( isChecked(secUserAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserAsBaseEntity);
		commonObjectPropertyCheck(secUserAsBaseEntity,"id",this::checkIdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"login",this::checkLoginOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"mobile",this::checkMobileOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"email",this::checkEmailOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"pwd",this::checkPwdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinOpenid",this::checkWeixinOpenidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinAppid",this::checkWeixinAppidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"accessToken",this::checkAccessTokenOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCode",this::checkVerificationCodeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCodeExpire",this::checkVerificationCodeExpireOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"domain",this::checkDomainOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"version",this::checkVersionOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"userAppList",this::checkUserAppListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"loginHistoryList",this::checkLoginHistoryListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"wechatWorkappIdentifyList",this::checkWechatWorkappIdentifyListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"wechatMiniappIdentifyList",this::checkWechatMiniappIdentifyListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"keypairIdentifyList",this::checkKeypairIdentifyListOfSecUser);
		return this;

	}

	public XingyouObjectChecker checkAndFixUserApp(BaseEntity userAppAsBaseEntity){

		if( isChecked(userAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAppAsBaseEntity);
		commonObjectPropertyCheck(userAppAsBaseEntity,"id",this::checkIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"title",this::checkTitleOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"secUser",this::checkSecUserOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"appIcon",this::checkAppIconOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"fullAccess",this::checkFullAccessOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"permission",this::checkPermissionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectType",this::checkObjectTypeOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectId",this::checkObjectIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"location",this::checkLocationOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"version",this::checkVersionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"quickLinkList",this::checkQuickLinkListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"listAccessList",this::checkListAccessListOfUserApp);
		return this;

	}

	public XingyouObjectChecker checkAndFixQuickLink(BaseEntity quickLinkAsBaseEntity){

		if( isChecked(quickLinkAsBaseEntity) ){
			return this;
		}
		markAsChecked(quickLinkAsBaseEntity);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"id",this::checkIdOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"name",this::checkNameOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"icon",this::checkIconOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"imagePath",this::checkImagePathOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"linkTarget",this::checkLinkTargetOfQuickLink);
		commonObjectPropertyAssign(quickLinkAsBaseEntity,"createTime",this::assignCreateTimeOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"app",this::checkAppOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"version",this::checkVersionOfQuickLink);
		return this;

	}

	public XingyouObjectChecker checkAndFixListAccess(BaseEntity listAccessAsBaseEntity){

		if( isChecked(listAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(listAccessAsBaseEntity);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"id",this::checkIdOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"name",this::checkNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"internalName",this::checkInternalNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"readPermission",this::checkReadPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"createPermission",this::checkCreatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"deletePermission",this::checkDeletePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"updatePermission",this::checkUpdatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"executionPermission",this::checkExecutionPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"app",this::checkAppOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"version",this::checkVersionOfListAccess);
		return this;

	}

	public XingyouObjectChecker checkAndFixLoginHistory(BaseEntity loginHistoryAsBaseEntity){

		if( isChecked(loginHistoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(loginHistoryAsBaseEntity);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"id",this::checkIdOfLoginHistory);
		commonObjectPropertyAssign(loginHistoryAsBaseEntity,"loginTime",this::assignLoginTimeOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"fromIp",this::checkFromIpOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"description",this::checkDescriptionOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"secUser",this::checkSecUserOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"version",this::checkVersionOfLoginHistory);
		return this;

	}

	public XingyouObjectChecker checkAndFixCandidateContainer(BaseEntity candidateContainerAsBaseEntity){

		if( isChecked(candidateContainerAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateContainerAsBaseEntity);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"id",this::checkIdOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"name",this::checkNameOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"version",this::checkVersionOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"candidateElementList",this::checkCandidateElementListOfCandidateContainer);
		return this;

	}

	public XingyouObjectChecker checkAndFixCandidateElement(BaseEntity candidateElementAsBaseEntity){

		if( isChecked(candidateElementAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateElementAsBaseEntity);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"id",this::checkIdOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"name",this::checkNameOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"type",this::checkTypeOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"image",this::checkImageOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"container",this::checkContainerOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"version",this::checkVersionOfCandidateElement);
		return this;

	}

	public XingyouObjectChecker checkAndFixWechatWorkappIdentify(BaseEntity wechatWorkappIdentifyAsBaseEntity){

		if( isChecked(wechatWorkappIdentifyAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatWorkappIdentifyAsBaseEntity);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"id",this::checkIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"corpId",this::checkCorpIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"userId",this::checkUserIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"secUser",this::checkSecUserOfWechatWorkappIdentify);
		commonObjectPropertyAssign(wechatWorkappIdentifyAsBaseEntity,"createTime",this::assignCreateTimeOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"version",this::checkVersionOfWechatWorkappIdentify);
		return this;

	}

	public XingyouObjectChecker checkAndFixWechatMiniappIdentify(BaseEntity wechatMiniappIdentifyAsBaseEntity){

		if( isChecked(wechatMiniappIdentifyAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatMiniappIdentifyAsBaseEntity);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"id",this::checkIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"openId",this::checkOpenIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"appId",this::checkAppIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"secUser",this::checkSecUserOfWechatMiniappIdentify);
		commonObjectPropertyAssign(wechatMiniappIdentifyAsBaseEntity,"createTime",this::assignCreateTimeOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"version",this::checkVersionOfWechatMiniappIdentify);
		return this;

	}

	public XingyouObjectChecker checkAndFixKeypairIdentify(BaseEntity keypairIdentifyAsBaseEntity){

		if( isChecked(keypairIdentifyAsBaseEntity) ){
			return this;
		}
		markAsChecked(keypairIdentifyAsBaseEntity);
		commonObjectPropertyCheck(keypairIdentifyAsBaseEntity,"id",this::checkIdOfKeypairIdentify);
		commonObjectPropertyCheck(keypairIdentifyAsBaseEntity,"publicKey",this::checkPublicKeyOfKeypairIdentify);
		commonObjectPropertyCheck(keypairIdentifyAsBaseEntity,"keyType",this::checkKeyTypeOfKeypairIdentify);
		commonObjectPropertyCheck(keypairIdentifyAsBaseEntity,"secUser",this::checkSecUserOfKeypairIdentify);
		commonObjectPropertyAssign(keypairIdentifyAsBaseEntity,"createTime",this::assignCreateTimeOfKeypairIdentify);
		commonObjectPropertyCheck(keypairIdentifyAsBaseEntity,"version",this::checkVersionOfKeypairIdentify);
		return this;

	}

	public XingyouObjectChecker checkAndFixPublicKeyType(BaseEntity publicKeyTypeAsBaseEntity){

		if( isChecked(publicKeyTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(publicKeyTypeAsBaseEntity);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"id",this::checkIdOfPublicKeyType);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"name",this::checkNameOfPublicKeyType);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"code",this::checkCodeOfPublicKeyType);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"domain",this::checkDomainOfPublicKeyType);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"version",this::checkVersionOfPublicKeyType);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"keypairIdentifyList",this::checkKeypairIdentifyListOfPublicKeyType);
		return this;

	}

	public XingyouObjectChecker checkAndFixTreeNode(BaseEntity treeNodeAsBaseEntity){

		if( isChecked(treeNodeAsBaseEntity) ){
			return this;
		}
		markAsChecked(treeNodeAsBaseEntity);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"id",this::checkIdOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"nodeId",this::checkNodeIdOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"nodeType",this::checkNodeTypeOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"leftValue",this::checkLeftValueOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"rightValue",this::checkRightValueOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"version",this::checkVersionOfTreeNode);
		return this;

	}


	public XingyouObjectChecker checkCatalogListOfFranchisedOutletProvinceCenter(List<BaseEntity> catalogList){
		AtomicInteger index = new AtomicInteger();
		catalogList.stream().forEach(catalog->
			commonObjectElementCheck(catalog,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCatalog));
		return this;
	}

	public XingyouObjectChecker checkLevelOneCategoryListOfCatalog(List<BaseEntity> levelOneCategoryList){
		AtomicInteger index = new AtomicInteger();
		levelOneCategoryList.stream().forEach(levelOneCategory->
			commonObjectElementCheck(levelOneCategory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLevelOneCategory));
		return this;
	}

	public static final String OWNER_OF_CATALOG = "catalog.owner";


	public XingyouObjectChecker checkOwnerOfCatalog(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_CATALOG);
			return this;
		}
		checkAndFixFranchisedOutletProvinceCenter(ownerAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkLevelTwoCategoryListOfLevelOneCategory(List<BaseEntity> levelTwoCategoryList){
		AtomicInteger index = new AtomicInteger();
		levelTwoCategoryList.stream().forEach(levelTwoCategory->
			commonObjectElementCheck(levelTwoCategory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLevelTwoCategory));
		return this;
	}

	public static final String CATALOG_OF_LEVEL_ONE_CATEGORY = "level_one_category.catalog";


	public XingyouObjectChecker checkCatalogOfLevelOneCategory(BaseEntity catalogAsBaseEntity){

		if(catalogAsBaseEntity == null){
			checkBaseEntityReference(catalogAsBaseEntity,true,CATALOG_OF_LEVEL_ONE_CATEGORY);
			return this;
		}
		checkAndFixCatalog(catalogAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkLevelThreeCategoryListOfLevelTwoCategory(List<BaseEntity> levelThreeCategoryList){
		AtomicInteger index = new AtomicInteger();
		levelThreeCategoryList.stream().forEach(levelThreeCategory->
			commonObjectElementCheck(levelThreeCategory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLevelThreeCategory));
		return this;
	}

	public static final String PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY = "level_two_category.parent_category";


	public XingyouObjectChecker checkParentCategoryOfLevelTwoCategory(BaseEntity parentCategoryAsBaseEntity){

		if(parentCategoryAsBaseEntity == null){
			checkBaseEntityReference(parentCategoryAsBaseEntity,true,PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY);
			return this;
		}
		checkAndFixLevelOneCategory(parentCategoryAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkProductListOfLevelThreeCategory(List<BaseEntity> productList){
		AtomicInteger index = new AtomicInteger();
		productList.stream().forEach(product->
			commonObjectElementCheck(product,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixProduct));
		return this;
	}

	public static final String PARENT_CATEGORY_OF_LEVEL_THREE_CATEGORY = "level_three_category.parent_category";


	public XingyouObjectChecker checkParentCategoryOfLevelThreeCategory(BaseEntity parentCategoryAsBaseEntity){

		if(parentCategoryAsBaseEntity == null){
			checkBaseEntityReference(parentCategoryAsBaseEntity,true,PARENT_CATEGORY_OF_LEVEL_THREE_CATEGORY);
			return this;
		}
		checkAndFixLevelTwoCategory(parentCategoryAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkSkuListOfProduct(List<BaseEntity> skuList){
		AtomicInteger index = new AtomicInteger();
		skuList.stream().forEach(sku->
			commonObjectElementCheck(sku,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSku));
		return this;
	}

	public static final String PARENT_CATEGORY_OF_PRODUCT = "product.parent_category";


	public XingyouObjectChecker checkParentCategoryOfProduct(BaseEntity parentCategoryAsBaseEntity){

		if(parentCategoryAsBaseEntity == null){
			checkBaseEntityReference(parentCategoryAsBaseEntity,true,PARENT_CATEGORY_OF_PRODUCT);
			return this;
		}
		checkAndFixLevelThreeCategory(parentCategoryAsBaseEntity);
		return this;
	}


	public static final String PRODUCT_OF_SKU = "sku.product";


	public XingyouObjectChecker checkProductOfSku(BaseEntity productAsBaseEntity){

		if(productAsBaseEntity == null){
			checkBaseEntityReference(productAsBaseEntity,true,PRODUCT_OF_SKU);
			return this;
		}
		checkAndFixProduct(productAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkFranchisedOutletCityCenterListOfFranchisedOutletCityCenter(List<BaseEntity> franchisedOutletCityCenterList){
		AtomicInteger index = new AtomicInteger();
		franchisedOutletCityCenterList.stream().forEach(franchisedOutletCityCenter->
			commonObjectElementCheck(franchisedOutletCityCenter,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFranchisedOutletCityCenter));
		return this;
	}

	public XingyouObjectChecker checkCityCenterDepartmentListOfFranchisedOutletCityCenter(List<BaseEntity> cityCenterDepartmentList){
		AtomicInteger index = new AtomicInteger();
		cityCenterDepartmentList.stream().forEach(cityCenterDepartment->
			commonObjectElementCheck(cityCenterDepartment,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCityCenterDepartment));
		return this;
	}

	public XingyouObjectChecker checkCityCenterEmployeeListOfFranchisedOutletCityCenter(List<BaseEntity> cityCenterEmployeeList){
		AtomicInteger index = new AtomicInteger();
		cityCenterEmployeeList.stream().forEach(cityCenterEmployee->
			commonObjectElementCheck(cityCenterEmployee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCityCenterEmployee));
		return this;
	}

	public XingyouObjectChecker checkFranchisedOutletCityServiceCenterListOfFranchisedOutletCityCenter(List<BaseEntity> franchisedOutletCityServiceCenterList){
		AtomicInteger index = new AtomicInteger();
		franchisedOutletCityServiceCenterList.stream().forEach(franchisedOutletCityServiceCenter->
			commonObjectElementCheck(franchisedOutletCityServiceCenter,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFranchisedOutletCityServiceCenter));
		return this;
	}

	public static final String CITY_OF_FRANCHISED_OUTLET_CITY_CENTER = "franchised_outlet_city_center.city";


	public XingyouObjectChecker checkCityOfFranchisedOutletCityCenter(BaseEntity cityAsBaseEntity){

		if(cityAsBaseEntity == null){
			checkBaseEntityReference(cityAsBaseEntity,true,CITY_OF_FRANCHISED_OUTLET_CITY_CENTER);
			return this;
		}
		checkAndFixFranchisedOutletCityCenter(cityAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkCityCenterEmployeeListOfCityCenterDepartment(List<BaseEntity> cityCenterEmployeeList){
		AtomicInteger index = new AtomicInteger();
		cityCenterEmployeeList.stream().forEach(cityCenterEmployee->
			commonObjectElementCheck(cityCenterEmployee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCityCenterEmployee));
		return this;
	}

	public static final String CITY_CENTER_OF_CITY_CENTER_DEPARTMENT = "city_center_department.city_center";


	public XingyouObjectChecker checkCityCenterOfCityCenterDepartment(BaseEntity cityCenterAsBaseEntity){

		if(cityCenterAsBaseEntity == null){
			checkBaseEntityReference(cityCenterAsBaseEntity,true,CITY_CENTER_OF_CITY_CENTER_DEPARTMENT);
			return this;
		}
		checkAndFixFranchisedOutletCityCenter(cityCenterAsBaseEntity);
		return this;
	}


	public static final String DEPARTMENT_OF_CITY_CENTER_EMPLOYEE = "city_center_employee.department";


	public XingyouObjectChecker checkDepartmentOfCityCenterEmployee(BaseEntity departmentAsBaseEntity){

		if(departmentAsBaseEntity == null){
			checkBaseEntityReference(departmentAsBaseEntity,true,DEPARTMENT_OF_CITY_CENTER_EMPLOYEE);
			return this;
		}
		checkAndFixCityCenterDepartment(departmentAsBaseEntity);
		return this;
	}


	public static final String CITY_CENTER_OF_CITY_CENTER_EMPLOYEE = "city_center_employee.city_center";


	public XingyouObjectChecker checkCityCenterOfCityCenterEmployee(BaseEntity cityCenterAsBaseEntity){

		if(cityCenterAsBaseEntity == null){
			checkBaseEntityReference(cityCenterAsBaseEntity,true,CITY_CENTER_OF_CITY_CENTER_EMPLOYEE);
			return this;
		}
		checkAndFixFranchisedOutletCityCenter(cityCenterAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkCityPartnerListOfFranchisedOutletCityServiceCenter(List<BaseEntity> cityPartnerList){
		AtomicInteger index = new AtomicInteger();
		cityPartnerList.stream().forEach(cityPartner->
			commonObjectElementCheck(cityPartner,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCityPartner));
		return this;
	}

	public XingyouObjectChecker checkPotentialCustomerListOfFranchisedOutletCityServiceCenter(List<BaseEntity> potentialCustomerList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerList.stream().forEach(potentialCustomer->
			commonObjectElementCheck(potentialCustomer,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomer));
		return this;
	}

	public XingyouObjectChecker checkCityEventListOfFranchisedOutletCityServiceCenter(List<BaseEntity> cityEventList){
		AtomicInteger index = new AtomicInteger();
		cityEventList.stream().forEach(cityEvent->
			commonObjectElementCheck(cityEvent,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCityEvent));
		return this;
	}

	public static final String BELONGS_TO_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER = "franchised_outlet_city_service_center.belongs_to";


	public XingyouObjectChecker checkBelongsToOfFranchisedOutletCityServiceCenter(BaseEntity belongsToAsBaseEntity){

		if(belongsToAsBaseEntity == null){
			checkBaseEntityReference(belongsToAsBaseEntity,true,BELONGS_TO_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER);
			return this;
		}
		checkAndFixFranchisedOutletCityCenter(belongsToAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkPotentialCustomerListOfCityPartner(List<BaseEntity> potentialCustomerList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerList.stream().forEach(potentialCustomer->
			commonObjectElementCheck(potentialCustomer,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomer));
		return this;
	}

	public XingyouObjectChecker checkPotentialCustomerContactListOfCityPartner(List<BaseEntity> potentialCustomerContactList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerContactList.stream().forEach(potentialCustomerContact->
			commonObjectElementCheck(potentialCustomerContact,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomerContact));
		return this;
	}

	public static final String TOWN_SERVICE_CENTER_OF_CITY_PARTNER = "city_partner.town_service_center";


	public XingyouObjectChecker checkTownServiceCenterOfCityPartner(BaseEntity townServiceCenterAsBaseEntity){

		if(townServiceCenterAsBaseEntity == null){
			checkBaseEntityReference(townServiceCenterAsBaseEntity,true,TOWN_SERVICE_CENTER_OF_CITY_PARTNER);
			return this;
		}
		checkAndFixFranchisedOutletCityServiceCenter(townServiceCenterAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkPotentialCustomerContactPersonListOfPotentialCustomer(List<BaseEntity> potentialCustomerContactPersonList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerContactPersonList.stream().forEach(potentialCustomerContactPerson->
			commonObjectElementCheck(potentialCustomerContactPerson,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomerContactPerson));
		return this;
	}

	public XingyouObjectChecker checkPotentialCustomerContactListOfPotentialCustomer(List<BaseEntity> potentialCustomerContactList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerContactList.stream().forEach(potentialCustomerContact->
			commonObjectElementCheck(potentialCustomerContact,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomerContact));
		return this;
	}

	public XingyouObjectChecker checkEventAttendanceListOfPotentialCustomer(List<BaseEntity> eventAttendanceList){
		AtomicInteger index = new AtomicInteger();
		eventAttendanceList.stream().forEach(eventAttendance->
			commonObjectElementCheck(eventAttendance,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEventAttendance));
		return this;
	}

	public static final String CITY_SERVICE_CENTER_OF_POTENTIAL_CUSTOMER = "potential_customer.city_service_center";


	public XingyouObjectChecker checkCityServiceCenterOfPotentialCustomer(BaseEntity cityServiceCenterAsBaseEntity){

		if(cityServiceCenterAsBaseEntity == null){
			checkBaseEntityReference(cityServiceCenterAsBaseEntity,true,CITY_SERVICE_CENTER_OF_POTENTIAL_CUSTOMER);
			return this;
		}
		checkAndFixFranchisedOutletCityServiceCenter(cityServiceCenterAsBaseEntity);
		return this;
	}


	public static final String CITY_PARTNER_OF_POTENTIAL_CUSTOMER = "potential_customer.city_partner";


	public XingyouObjectChecker checkCityPartnerOfPotentialCustomer(BaseEntity cityPartnerAsBaseEntity){

		if(cityPartnerAsBaseEntity == null){
			checkBaseEntityReference(cityPartnerAsBaseEntity,true,CITY_PARTNER_OF_POTENTIAL_CUSTOMER);
			return this;
		}
		checkAndFixCityPartner(cityPartnerAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkPotentialCustomerContactListOfPotentialCustomerContactPerson(List<BaseEntity> potentialCustomerContactList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerContactList.stream().forEach(potentialCustomerContact->
			commonObjectElementCheck(potentialCustomerContact,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomerContact));
		return this;
	}

	public static final String POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON = "potential_customer_contact_person.potential_customer";


	public XingyouObjectChecker checkPotentialCustomerOfPotentialCustomerContactPerson(BaseEntity potentialCustomerAsBaseEntity){

		if(potentialCustomerAsBaseEntity == null){
			checkBaseEntityReference(potentialCustomerAsBaseEntity,true,POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON);
			return this;
		}
		checkAndFixPotentialCustomer(potentialCustomerAsBaseEntity);
		return this;
	}


	public static final String POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT = "potential_customer_contact.potential_customer";


	public XingyouObjectChecker checkPotentialCustomerOfPotentialCustomerContact(BaseEntity potentialCustomerAsBaseEntity){

		if(potentialCustomerAsBaseEntity == null){
			checkBaseEntityReference(potentialCustomerAsBaseEntity,true,POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT);
			return this;
		}
		checkAndFixPotentialCustomer(potentialCustomerAsBaseEntity);
		return this;
	}


	public static final String CITY_PARTNER_OF_POTENTIAL_CUSTOMER_CONTACT = "potential_customer_contact.city_partner";


	public XingyouObjectChecker checkCityPartnerOfPotentialCustomerContact(BaseEntity cityPartnerAsBaseEntity){

		if(cityPartnerAsBaseEntity == null){
			checkBaseEntityReference(cityPartnerAsBaseEntity,true,CITY_PARTNER_OF_POTENTIAL_CUSTOMER_CONTACT);
			return this;
		}
		checkAndFixCityPartner(cityPartnerAsBaseEntity);
		return this;
	}


	public static final String CONTACT_TO_OF_POTENTIAL_CUSTOMER_CONTACT = "potential_customer_contact.contact_to";


	public XingyouObjectChecker checkContactToOfPotentialCustomerContact(BaseEntity contactToAsBaseEntity){

		if(contactToAsBaseEntity == null){
			checkBaseEntityReference(contactToAsBaseEntity,true,CONTACT_TO_OF_POTENTIAL_CUSTOMER_CONTACT);
			return this;
		}
		checkAndFixPotentialCustomerContactPerson(contactToAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkEventAttendanceListOfCityEvent(List<BaseEntity> eventAttendanceList){
		AtomicInteger index = new AtomicInteger();
		eventAttendanceList.stream().forEach(eventAttendance->
			commonObjectElementCheck(eventAttendance,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEventAttendance));
		return this;
	}

	public static final String CITY_SERVICE_CENTER_OF_CITY_EVENT = "city_event.city_service_center";


	public XingyouObjectChecker checkCityServiceCenterOfCityEvent(BaseEntity cityServiceCenterAsBaseEntity){

		if(cityServiceCenterAsBaseEntity == null){
			checkBaseEntityReference(cityServiceCenterAsBaseEntity,true,CITY_SERVICE_CENTER_OF_CITY_EVENT);
			return this;
		}
		checkAndFixFranchisedOutletCityServiceCenter(cityServiceCenterAsBaseEntity);
		return this;
	}


	public static final String POTENTIAL_CUSTOMER_OF_EVENT_ATTENDANCE = "event_attendance.potential_customer";


	public XingyouObjectChecker checkPotentialCustomerOfEventAttendance(BaseEntity potentialCustomerAsBaseEntity){

		if(potentialCustomerAsBaseEntity == null){
			checkBaseEntityReference(potentialCustomerAsBaseEntity,true,POTENTIAL_CUSTOMER_OF_EVENT_ATTENDANCE);
			return this;
		}
		checkAndFixPotentialCustomer(potentialCustomerAsBaseEntity);
		return this;
	}


	public static final String CITY_EVENT_OF_EVENT_ATTENDANCE = "event_attendance.city_event";


	public XingyouObjectChecker checkCityEventOfEventAttendance(BaseEntity cityEventAsBaseEntity){

		if(cityEventAsBaseEntity == null){
			checkBaseEntityReference(cityEventAsBaseEntity,true,CITY_EVENT_OF_EVENT_ATTENDANCE);
			return this;
		}
		checkAndFixCityEvent(cityEventAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkPageListOfMobileApp(List<BaseEntity> pageList){
		AtomicInteger index = new AtomicInteger();
		pageList.stream().forEach(page->
			commonObjectElementCheck(page,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPage));
		return this;
	}

	public XingyouObjectChecker checkPageTypeListOfMobileApp(List<BaseEntity> pageTypeList){
		AtomicInteger index = new AtomicInteger();
		pageTypeList.stream().forEach(pageType->
			commonObjectElementCheck(pageType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPageType));
		return this;
	}

	public XingyouObjectChecker checkSlideListOfPage(List<BaseEntity> slideList){
		AtomicInteger index = new AtomicInteger();
		slideList.stream().forEach(slide->
			commonObjectElementCheck(slide,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSlide));
		return this;
	}

	public XingyouObjectChecker checkUiActionListOfPage(List<BaseEntity> uiActionList){
		AtomicInteger index = new AtomicInteger();
		uiActionList.stream().forEach(uiAction->
			commonObjectElementCheck(uiAction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUiAction));
		return this;
	}

	public XingyouObjectChecker checkSectionListOfPage(List<BaseEntity> sectionList){
		AtomicInteger index = new AtomicInteger();
		sectionList.stream().forEach(section->
			commonObjectElementCheck(section,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSection));
		return this;
	}

	public static final String PAGE_TYPE_OF_PAGE = "page.page_type";


	public XingyouObjectChecker checkPageTypeOfPage(BaseEntity pageTypeAsBaseEntity){

		if(pageTypeAsBaseEntity == null){
			checkBaseEntityReference(pageTypeAsBaseEntity,true,PAGE_TYPE_OF_PAGE);
			return this;
		}
		checkAndFixPageType(pageTypeAsBaseEntity);
		return this;
	}


	public static final String MOBILE_APP_OF_PAGE = "page.mobile_app";


	public XingyouObjectChecker checkMobileAppOfPage(BaseEntity mobileAppAsBaseEntity){

		if(mobileAppAsBaseEntity == null){
			checkBaseEntityReference(mobileAppAsBaseEntity,true,MOBILE_APP_OF_PAGE);
			return this;
		}
		checkAndFixMobileApp(mobileAppAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkPageListOfPageType(List<BaseEntity> pageList){
		AtomicInteger index = new AtomicInteger();
		pageList.stream().forEach(page->
			commonObjectElementCheck(page,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPage));
		return this;
	}

	public static final String MOBILE_APP_OF_PAGE_TYPE = "page_type.mobile_app";


	public XingyouObjectChecker checkMobileAppOfPageType(BaseEntity mobileAppAsBaseEntity){

		if(mobileAppAsBaseEntity == null){
			checkBaseEntityReference(mobileAppAsBaseEntity,true,MOBILE_APP_OF_PAGE_TYPE);
			return this;
		}
		checkAndFixMobileApp(mobileAppAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_SLIDE = "slide.page";


	public XingyouObjectChecker checkPageOfSlide(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_SLIDE);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_UI_ACTION = "ui_action.page";


	public XingyouObjectChecker checkPageOfUiAction(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_UI_ACTION);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_SECTION = "section.page";


	public XingyouObjectChecker checkPageOfSection(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_SECTION);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkUserWhiteListListOfUserDomain(List<BaseEntity> userWhiteListList){
		AtomicInteger index = new AtomicInteger();
		userWhiteListList.stream().forEach(userWhiteList->
			commonObjectElementCheck(userWhiteList,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserWhiteList));
		return this;
	}

	public XingyouObjectChecker checkSecUserListOfUserDomain(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public XingyouObjectChecker checkPublicKeyTypeListOfUserDomain(List<BaseEntity> publicKeyTypeList){
		AtomicInteger index = new AtomicInteger();
		publicKeyTypeList.stream().forEach(publicKeyType->
			commonObjectElementCheck(publicKeyType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPublicKeyType));
		return this;
	}

	public static final String DOMAIN_OF_USER_WHITE_LIST = "user_white_list.domain";


	public XingyouObjectChecker checkDomainOfUserWhiteList(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_USER_WHITE_LIST);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkUserAppListOfSecUser(List<BaseEntity> userAppList){
		AtomicInteger index = new AtomicInteger();
		userAppList.stream().forEach(userApp->
			commonObjectElementCheck(userApp,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserApp));
		return this;
	}

	public XingyouObjectChecker checkLoginHistoryListOfSecUser(List<BaseEntity> loginHistoryList){
		AtomicInteger index = new AtomicInteger();
		loginHistoryList.stream().forEach(loginHistory->
			commonObjectElementCheck(loginHistory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLoginHistory));
		return this;
	}

	public XingyouObjectChecker checkWechatWorkappIdentifyListOfSecUser(List<BaseEntity> wechatWorkappIdentifyList){
		AtomicInteger index = new AtomicInteger();
		wechatWorkappIdentifyList.stream().forEach(wechatWorkappIdentify->
			commonObjectElementCheck(wechatWorkappIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatWorkappIdentify));
		return this;
	}

	public XingyouObjectChecker checkWechatMiniappIdentifyListOfSecUser(List<BaseEntity> wechatMiniappIdentifyList){
		AtomicInteger index = new AtomicInteger();
		wechatMiniappIdentifyList.stream().forEach(wechatMiniappIdentify->
			commonObjectElementCheck(wechatMiniappIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatMiniappIdentify));
		return this;
	}

	public XingyouObjectChecker checkKeypairIdentifyListOfSecUser(List<BaseEntity> keypairIdentifyList){
		AtomicInteger index = new AtomicInteger();
		keypairIdentifyList.stream().forEach(keypairIdentify->
			commonObjectElementCheck(keypairIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixKeypairIdentify));
		return this;
	}

	public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";


	public XingyouObjectChecker checkDomainOfSecUser(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_SEC_USER);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkQuickLinkListOfUserApp(List<BaseEntity> quickLinkList){
		AtomicInteger index = new AtomicInteger();
		quickLinkList.stream().forEach(quickLink->
			commonObjectElementCheck(quickLink,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixQuickLink));
		return this;
	}

	public XingyouObjectChecker checkListAccessListOfUserApp(List<BaseEntity> listAccessList){
		AtomicInteger index = new AtomicInteger();
		listAccessList.stream().forEach(listAccess->
			commonObjectElementCheck(listAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixListAccess));
		return this;
	}

	public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";


	public XingyouObjectChecker checkSecUserOfUserApp(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_USER_APP);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String APP_OF_QUICK_LINK = "quick_link.app";


	public XingyouObjectChecker checkAppOfQuickLink(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_QUICK_LINK);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_LIST_ACCESS = "list_access.app";


	public XingyouObjectChecker checkAppOfListAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_LIST_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";


	public XingyouObjectChecker checkSecUserOfLoginHistory(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_LOGIN_HISTORY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkCandidateElementListOfCandidateContainer(List<BaseEntity> candidateElementList){
		AtomicInteger index = new AtomicInteger();
		candidateElementList.stream().forEach(candidateElement->
			commonObjectElementCheck(candidateElement,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCandidateElement));
		return this;
	}

	public static final String CONTAINER_OF_CANDIDATE_ELEMENT = "candidate_element.container";


	public XingyouObjectChecker checkContainerOfCandidateElement(BaseEntity containerAsBaseEntity){

		if(containerAsBaseEntity == null){
			checkBaseEntityReference(containerAsBaseEntity,true,CONTAINER_OF_CANDIDATE_ELEMENT);
			return this;
		}
		checkAndFixCandidateContainer(containerAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY = "wechat_workapp_identify.sec_user";


	public XingyouObjectChecker checkSecUserOfWechatWorkappIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY = "wechat_miniapp_identify.sec_user";


	public XingyouObjectChecker checkSecUserOfWechatMiniappIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String KEY_TYPE_OF_KEYPAIR_IDENTIFY = "keypair_identify.key_type";


	public XingyouObjectChecker checkKeyTypeOfKeypairIdentify(BaseEntity keyTypeAsBaseEntity){

		if(keyTypeAsBaseEntity == null){
			checkBaseEntityReference(keyTypeAsBaseEntity,true,KEY_TYPE_OF_KEYPAIR_IDENTIFY);
			return this;
		}
		checkAndFixPublicKeyType(keyTypeAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_KEYPAIR_IDENTIFY = "keypair_identify.sec_user";


	public XingyouObjectChecker checkSecUserOfKeypairIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_KEYPAIR_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public XingyouObjectChecker checkKeypairIdentifyListOfPublicKeyType(List<BaseEntity> keypairIdentifyList){
		AtomicInteger index = new AtomicInteger();
		keypairIdentifyList.stream().forEach(keypairIdentify->
			commonObjectElementCheck(keypairIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixKeypairIdentify));
		return this;
	}

	public static final String DOMAIN_OF_PUBLIC_KEY_TYPE = "public_key_type.domain";


	public XingyouObjectChecker checkDomainOfPublicKeyType(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_PUBLIC_KEY_TYPE);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}

	public XingyouObjectChecker assignLastUpdateTimeOfProduct(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignLastUpdateTimeOfFranchisedOutletCityCenter(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignLastUpdateTimeOfFranchisedOutletCityServiceCenter(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignLastUpdateTimeOfCityPartner(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignLastUpdateTimeOfPotentialCustomer(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignLastUpdateTimeOfPotentialCustomerContact(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignLastUpdateTimeOfCityEvent(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignCreateTimeOfQuickLink(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignLoginTimeOfLoginHistory(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"loginTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignCreateTimeOfWechatWorkappIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignCreateTimeOfWechatMiniappIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public XingyouObjectChecker assignCreateTimeOfKeypairIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}

}

