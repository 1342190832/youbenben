package com.youbenben.youbenben;
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
public class YoubenbenObjectChecker extends YoubenbenChecker{

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
		YoubenbenChecker apply(P1 valueToCheck);
	}
	@FunctionalInterface
	public interface AssignParameterFunction {
		YoubenbenObjectChecker apply(BaseEntity targetEntity);
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
	
	public <T> YoubenbenObjectChecker commonObjectPropertyAssign(BaseEntity target, String propertyName, AssignParameterFunction assigmentFunction) {
		assigmentFunction.apply(target);
		return this;
	}
	public <T> YoubenbenObjectChecker commonObjectPropertyCheck(BaseEntity target, String propertyName, CheckerParameterFunction<T> checkerFunction) {
		
		
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
	public  YoubenbenChecker commonObjectElementCheck(BaseEntity target, String propertyName, CheckerParameterFunction<BaseEntity> checkerFunction) {
		
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

	public YoubenbenObjectChecker checkAndFixRetailStoreCountryCenter(BaseEntity retailStoreCountryCenterAsBaseEntity){

		if( isChecked(retailStoreCountryCenterAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreCountryCenterAsBaseEntity);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"id",this::checkIdOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"name",this::checkNameOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"serviceNumber",this::checkServiceNumberOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"founded",this::checkFoundedOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"webSite",this::checkWebSiteOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"address",this::checkAddressOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"operatedBy",this::checkOperatedByOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"legalRepresentative",this::checkLegalRepresentativeOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"description",this::checkDescriptionOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"version",this::checkVersionOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"catalogList",this::checkCatalogListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"retailStoreProvinceCenterList",this::checkRetailStoreProvinceCenterListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"retailStoreList",this::checkRetailStoreListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"retailStoreMemberList",this::checkRetailStoreMemberListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"goodsSupplierList",this::checkGoodsSupplierListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"supplyOrderList",this::checkSupplyOrderListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"retailStoreOrderList",this::checkRetailStoreOrderListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"warehouseList",this::checkWarehouseListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"transportFleetList",this::checkTransportFleetListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"accountSetList",this::checkAccountSetListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"levelOneDepartmentList",this::checkLevelOneDepartmentListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"skillTypeList",this::checkSkillTypeListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"responsibilityTypeList",this::checkResponsibilityTypeListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"terminationReasonList",this::checkTerminationReasonListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"terminationTypeList",this::checkTerminationTypeListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"occupationTypeList",this::checkOccupationTypeListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"leaveTypeList",this::checkLeaveTypeListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"salaryGradeList",this::checkSalaryGradeListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"interviewTypeList",this::checkInterviewTypeListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"trainingCourseTypeList",this::checkTrainingCourseTypeListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"publicHolidayList",this::checkPublicHolidayListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"employeeList",this::checkEmployeeListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"instructorList",this::checkInstructorListOfRetailStoreCountryCenter);
		commonObjectPropertyCheck(retailStoreCountryCenterAsBaseEntity,"companyTrainingList",this::checkCompanyTrainingListOfRetailStoreCountryCenter);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixCatalog(BaseEntity catalogAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixLevelOneCategory(BaseEntity levelOneCategoryAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixLevelTwoCategory(BaseEntity levelTwoCategoryAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixLevelThreeCategory(BaseEntity levelThreeCategoryAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixProduct(BaseEntity productAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixSku(BaseEntity skuAsBaseEntity){

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
		commonObjectPropertyCheck(skuAsBaseEntity,"goodsList",this::checkGoodsListOfSku);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreProvinceCenter(BaseEntity retailStoreProvinceCenterAsBaseEntity){

		if( isChecked(retailStoreProvinceCenterAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreProvinceCenterAsBaseEntity);
		commonObjectPropertyCheck(retailStoreProvinceCenterAsBaseEntity,"id",this::checkIdOfRetailStoreProvinceCenter);
		commonObjectPropertyCheck(retailStoreProvinceCenterAsBaseEntity,"name",this::checkNameOfRetailStoreProvinceCenter);
		commonObjectPropertyCheck(retailStoreProvinceCenterAsBaseEntity,"founded",this::checkFoundedOfRetailStoreProvinceCenter);
		commonObjectPropertyCheck(retailStoreProvinceCenterAsBaseEntity,"country",this::checkCountryOfRetailStoreProvinceCenter);
		commonObjectPropertyAssign(retailStoreProvinceCenterAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfRetailStoreProvinceCenter);
		commonObjectPropertyCheck(retailStoreProvinceCenterAsBaseEntity,"version",this::checkVersionOfRetailStoreProvinceCenter);
		commonObjectPropertyCheck(retailStoreProvinceCenterAsBaseEntity,"provinceCenterDepartmentList",this::checkProvinceCenterDepartmentListOfRetailStoreProvinceCenter);
		commonObjectPropertyCheck(retailStoreProvinceCenterAsBaseEntity,"provinceCenterEmployeeList",this::checkProvinceCenterEmployeeListOfRetailStoreProvinceCenter);
		commonObjectPropertyCheck(retailStoreProvinceCenterAsBaseEntity,"retailStoreCityServiceCenterList",this::checkRetailStoreCityServiceCenterListOfRetailStoreProvinceCenter);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixProvinceCenterDepartment(BaseEntity provinceCenterDepartmentAsBaseEntity){

		if( isChecked(provinceCenterDepartmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(provinceCenterDepartmentAsBaseEntity);
		commonObjectPropertyCheck(provinceCenterDepartmentAsBaseEntity,"id",this::checkIdOfProvinceCenterDepartment);
		commonObjectPropertyCheck(provinceCenterDepartmentAsBaseEntity,"name",this::checkNameOfProvinceCenterDepartment);
		commonObjectPropertyCheck(provinceCenterDepartmentAsBaseEntity,"founded",this::checkFoundedOfProvinceCenterDepartment);
		commonObjectPropertyCheck(provinceCenterDepartmentAsBaseEntity,"provinceCenter",this::checkProvinceCenterOfProvinceCenterDepartment);
		commonObjectPropertyCheck(provinceCenterDepartmentAsBaseEntity,"manager",this::checkManagerOfProvinceCenterDepartment);
		commonObjectPropertyCheck(provinceCenterDepartmentAsBaseEntity,"version",this::checkVersionOfProvinceCenterDepartment);
		commonObjectPropertyCheck(provinceCenterDepartmentAsBaseEntity,"provinceCenterEmployeeList",this::checkProvinceCenterEmployeeListOfProvinceCenterDepartment);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixProvinceCenterEmployee(BaseEntity provinceCenterEmployeeAsBaseEntity){

		if( isChecked(provinceCenterEmployeeAsBaseEntity) ){
			return this;
		}
		markAsChecked(provinceCenterEmployeeAsBaseEntity);
		commonObjectPropertyCheck(provinceCenterEmployeeAsBaseEntity,"id",this::checkIdOfProvinceCenterEmployee);
		commonObjectPropertyCheck(provinceCenterEmployeeAsBaseEntity,"name",this::checkNameOfProvinceCenterEmployee);
		commonObjectPropertyCheck(provinceCenterEmployeeAsBaseEntity,"mobile",this::checkMobileOfProvinceCenterEmployee);
		commonObjectPropertyCheck(provinceCenterEmployeeAsBaseEntity,"email",this::checkEmailOfProvinceCenterEmployee);
		commonObjectPropertyCheck(provinceCenterEmployeeAsBaseEntity,"founded",this::checkFoundedOfProvinceCenterEmployee);
		commonObjectPropertyCheck(provinceCenterEmployeeAsBaseEntity,"department",this::checkDepartmentOfProvinceCenterEmployee);
		commonObjectPropertyCheck(provinceCenterEmployeeAsBaseEntity,"provinceCenter",this::checkProvinceCenterOfProvinceCenterEmployee);
		commonObjectPropertyCheck(provinceCenterEmployeeAsBaseEntity,"version",this::checkVersionOfProvinceCenterEmployee);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreCityServiceCenter(BaseEntity retailStoreCityServiceCenterAsBaseEntity){

		if( isChecked(retailStoreCityServiceCenterAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreCityServiceCenterAsBaseEntity);
		commonObjectPropertyCheck(retailStoreCityServiceCenterAsBaseEntity,"id",this::checkIdOfRetailStoreCityServiceCenter);
		commonObjectPropertyCheck(retailStoreCityServiceCenterAsBaseEntity,"name",this::checkNameOfRetailStoreCityServiceCenter);
		commonObjectPropertyCheck(retailStoreCityServiceCenterAsBaseEntity,"founded",this::checkFoundedOfRetailStoreCityServiceCenter);
		commonObjectPropertyCheck(retailStoreCityServiceCenterAsBaseEntity,"belongsTo",this::checkBelongsToOfRetailStoreCityServiceCenter);
		commonObjectPropertyAssign(retailStoreCityServiceCenterAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfRetailStoreCityServiceCenter);
		commonObjectPropertyCheck(retailStoreCityServiceCenterAsBaseEntity,"version",this::checkVersionOfRetailStoreCityServiceCenter);
		commonObjectPropertyCheck(retailStoreCityServiceCenterAsBaseEntity,"cityPartnerList",this::checkCityPartnerListOfRetailStoreCityServiceCenter);
		commonObjectPropertyCheck(retailStoreCityServiceCenterAsBaseEntity,"potentialCustomerList",this::checkPotentialCustomerListOfRetailStoreCityServiceCenter);
		commonObjectPropertyCheck(retailStoreCityServiceCenterAsBaseEntity,"cityEventList",this::checkCityEventListOfRetailStoreCityServiceCenter);
		commonObjectPropertyCheck(retailStoreCityServiceCenterAsBaseEntity,"retailStoreList",this::checkRetailStoreListOfRetailStoreCityServiceCenter);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixCityPartner(BaseEntity cityPartnerAsBaseEntity){

		if( isChecked(cityPartnerAsBaseEntity) ){
			return this;
		}
		markAsChecked(cityPartnerAsBaseEntity);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"id",this::checkIdOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"name",this::checkNameOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"mobile",this::checkMobileOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"cityServiceCenter",this::checkCityServiceCenterOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"description",this::checkDescriptionOfCityPartner);
		commonObjectPropertyAssign(cityPartnerAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"version",this::checkVersionOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"potentialCustomerList",this::checkPotentialCustomerListOfCityPartner);
		commonObjectPropertyCheck(cityPartnerAsBaseEntity,"potentialCustomerContactList",this::checkPotentialCustomerContactListOfCityPartner);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixPotentialCustomer(BaseEntity potentialCustomerAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixPotentialCustomerContactPerson(BaseEntity potentialCustomerContactPersonAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixPotentialCustomerContact(BaseEntity potentialCustomerContactAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixCityEvent(BaseEntity cityEventAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixEventAttendance(BaseEntity eventAttendanceAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixRetailStore(BaseEntity retailStoreAsBaseEntity){

		if( isChecked(retailStoreAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreAsBaseEntity);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"id",this::checkIdOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"name",this::checkNameOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"telephone",this::checkTelephoneOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"owner",this::checkOwnerOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"retailStoreCountryCenter",this::checkRetailStoreCountryCenterOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"cityServiceCenter",this::checkCityServiceCenterOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"creation",this::checkCreationOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"investmentInvitation",this::checkInvestmentInvitationOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"franchising",this::checkFranchisingOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"decoration",this::checkDecorationOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"opening",this::checkOpeningOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"closing",this::checkClosingOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"founded",this::checkFoundedOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"latitude",this::checkLatitudeOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"longitude",this::checkLongitudeOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"description",this::checkDescriptionOfRetailStore);
		commonObjectPropertyAssign(retailStoreAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"version",this::checkVersionOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"consumerOrderList",this::checkConsumerOrderListOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"retailStoreOrderList",this::checkRetailStoreOrderListOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"goodsList",this::checkGoodsListOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"transportTaskList",this::checkTransportTaskListOfRetailStore);
		commonObjectPropertyCheck(retailStoreAsBaseEntity,"accountSetList",this::checkAccountSetListOfRetailStore);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreCreation(BaseEntity retailStoreCreationAsBaseEntity){

		if( isChecked(retailStoreCreationAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreCreationAsBaseEntity);
		commonObjectPropertyCheck(retailStoreCreationAsBaseEntity,"id",this::checkIdOfRetailStoreCreation);
		commonObjectPropertyCheck(retailStoreCreationAsBaseEntity,"comment",this::checkCommentOfRetailStoreCreation);
		commonObjectPropertyCheck(retailStoreCreationAsBaseEntity,"version",this::checkVersionOfRetailStoreCreation);
		commonObjectPropertyCheck(retailStoreCreationAsBaseEntity,"retailStoreList",this::checkRetailStoreListOfRetailStoreCreation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreInvestmentInvitation(BaseEntity retailStoreInvestmentInvitationAsBaseEntity){

		if( isChecked(retailStoreInvestmentInvitationAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreInvestmentInvitationAsBaseEntity);
		commonObjectPropertyCheck(retailStoreInvestmentInvitationAsBaseEntity,"id",this::checkIdOfRetailStoreInvestmentInvitation);
		commonObjectPropertyCheck(retailStoreInvestmentInvitationAsBaseEntity,"comment",this::checkCommentOfRetailStoreInvestmentInvitation);
		commonObjectPropertyCheck(retailStoreInvestmentInvitationAsBaseEntity,"version",this::checkVersionOfRetailStoreInvestmentInvitation);
		commonObjectPropertyCheck(retailStoreInvestmentInvitationAsBaseEntity,"retailStoreList",this::checkRetailStoreListOfRetailStoreInvestmentInvitation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreFranchising(BaseEntity retailStoreFranchisingAsBaseEntity){

		if( isChecked(retailStoreFranchisingAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreFranchisingAsBaseEntity);
		commonObjectPropertyCheck(retailStoreFranchisingAsBaseEntity,"id",this::checkIdOfRetailStoreFranchising);
		commonObjectPropertyCheck(retailStoreFranchisingAsBaseEntity,"comment",this::checkCommentOfRetailStoreFranchising);
		commonObjectPropertyCheck(retailStoreFranchisingAsBaseEntity,"version",this::checkVersionOfRetailStoreFranchising);
		commonObjectPropertyCheck(retailStoreFranchisingAsBaseEntity,"retailStoreList",this::checkRetailStoreListOfRetailStoreFranchising);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreDecoration(BaseEntity retailStoreDecorationAsBaseEntity){

		if( isChecked(retailStoreDecorationAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreDecorationAsBaseEntity);
		commonObjectPropertyCheck(retailStoreDecorationAsBaseEntity,"id",this::checkIdOfRetailStoreDecoration);
		commonObjectPropertyCheck(retailStoreDecorationAsBaseEntity,"comment",this::checkCommentOfRetailStoreDecoration);
		commonObjectPropertyCheck(retailStoreDecorationAsBaseEntity,"version",this::checkVersionOfRetailStoreDecoration);
		commonObjectPropertyCheck(retailStoreDecorationAsBaseEntity,"retailStoreList",this::checkRetailStoreListOfRetailStoreDecoration);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOpening(BaseEntity retailStoreOpeningAsBaseEntity){

		if( isChecked(retailStoreOpeningAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOpeningAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOpeningAsBaseEntity,"id",this::checkIdOfRetailStoreOpening);
		commonObjectPropertyCheck(retailStoreOpeningAsBaseEntity,"comment",this::checkCommentOfRetailStoreOpening);
		commonObjectPropertyCheck(retailStoreOpeningAsBaseEntity,"version",this::checkVersionOfRetailStoreOpening);
		commonObjectPropertyCheck(retailStoreOpeningAsBaseEntity,"retailStoreList",this::checkRetailStoreListOfRetailStoreOpening);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreClosing(BaseEntity retailStoreClosingAsBaseEntity){

		if( isChecked(retailStoreClosingAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreClosingAsBaseEntity);
		commonObjectPropertyCheck(retailStoreClosingAsBaseEntity,"id",this::checkIdOfRetailStoreClosing);
		commonObjectPropertyCheck(retailStoreClosingAsBaseEntity,"comment",this::checkCommentOfRetailStoreClosing);
		commonObjectPropertyCheck(retailStoreClosingAsBaseEntity,"version",this::checkVersionOfRetailStoreClosing);
		commonObjectPropertyCheck(retailStoreClosingAsBaseEntity,"retailStoreList",this::checkRetailStoreListOfRetailStoreClosing);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreMember(BaseEntity retailStoreMemberAsBaseEntity){

		if( isChecked(retailStoreMemberAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreMemberAsBaseEntity);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"id",this::checkIdOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"name",this::checkNameOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"mobilePhone",this::checkMobilePhoneOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"owner",this::checkOwnerOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"version",this::checkVersionOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"consumerOrderList",this::checkConsumerOrderListOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"retailStoreMemberCouponList",this::checkRetailStoreMemberCouponListOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"memberWishlistList",this::checkMemberWishlistListOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"memberRewardPointList",this::checkMemberRewardPointListOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"memberRewardPointRedemptionList",this::checkMemberRewardPointRedemptionListOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"retailStoreMemberAddressList",this::checkRetailStoreMemberAddressListOfRetailStoreMember);
		commonObjectPropertyCheck(retailStoreMemberAsBaseEntity,"retailStoreMemberGiftCardList",this::checkRetailStoreMemberGiftCardListOfRetailStoreMember);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixConsumerOrder(BaseEntity consumerOrderAsBaseEntity){

		if( isChecked(consumerOrderAsBaseEntity) ){
			return this;
		}
		markAsChecked(consumerOrderAsBaseEntity);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"id",this::checkIdOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"title",this::checkTitleOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"consumer",this::checkConsumerOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"confirmation",this::checkConfirmationOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"approval",this::checkApprovalOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"processing",this::checkProcessingOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"shipment",this::checkShipmentOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"delivery",this::checkDeliveryOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"store",this::checkStoreOfConsumerOrder);
		commonObjectPropertyAssign(consumerOrderAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"version",this::checkVersionOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"consumerOrderLineItemList",this::checkConsumerOrderLineItemListOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"consumerOrderShippingGroupList",this::checkConsumerOrderShippingGroupListOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"consumerOrderPaymentGroupList",this::checkConsumerOrderPaymentGroupListOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"consumerOrderPriceAdjustmentList",this::checkConsumerOrderPriceAdjustmentListOfConsumerOrder);
		commonObjectPropertyCheck(consumerOrderAsBaseEntity,"retailStoreMemberGiftCardConsumeRecordList",this::checkRetailStoreMemberGiftCardConsumeRecordListOfConsumerOrder);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixConsumerOrderConfirmation(BaseEntity consumerOrderConfirmationAsBaseEntity){

		if( isChecked(consumerOrderConfirmationAsBaseEntity) ){
			return this;
		}
		markAsChecked(consumerOrderConfirmationAsBaseEntity);
		commonObjectPropertyCheck(consumerOrderConfirmationAsBaseEntity,"id",this::checkIdOfConsumerOrderConfirmation);
		commonObjectPropertyCheck(consumerOrderConfirmationAsBaseEntity,"who",this::checkWhoOfConsumerOrderConfirmation);
		commonObjectPropertyCheck(consumerOrderConfirmationAsBaseEntity,"confirmTime",this::checkConfirmTimeOfConsumerOrderConfirmation);
		commonObjectPropertyCheck(consumerOrderConfirmationAsBaseEntity,"version",this::checkVersionOfConsumerOrderConfirmation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixConsumerOrderApproval(BaseEntity consumerOrderApprovalAsBaseEntity){

		if( isChecked(consumerOrderApprovalAsBaseEntity) ){
			return this;
		}
		markAsChecked(consumerOrderApprovalAsBaseEntity);
		commonObjectPropertyCheck(consumerOrderApprovalAsBaseEntity,"id",this::checkIdOfConsumerOrderApproval);
		commonObjectPropertyCheck(consumerOrderApprovalAsBaseEntity,"who",this::checkWhoOfConsumerOrderApproval);
		commonObjectPropertyCheck(consumerOrderApprovalAsBaseEntity,"approveTime",this::checkApproveTimeOfConsumerOrderApproval);
		commonObjectPropertyCheck(consumerOrderApprovalAsBaseEntity,"version",this::checkVersionOfConsumerOrderApproval);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixConsumerOrderProcessing(BaseEntity consumerOrderProcessingAsBaseEntity){

		if( isChecked(consumerOrderProcessingAsBaseEntity) ){
			return this;
		}
		markAsChecked(consumerOrderProcessingAsBaseEntity);
		commonObjectPropertyCheck(consumerOrderProcessingAsBaseEntity,"id",this::checkIdOfConsumerOrderProcessing);
		commonObjectPropertyCheck(consumerOrderProcessingAsBaseEntity,"who",this::checkWhoOfConsumerOrderProcessing);
		commonObjectPropertyCheck(consumerOrderProcessingAsBaseEntity,"processTime",this::checkProcessTimeOfConsumerOrderProcessing);
		commonObjectPropertyCheck(consumerOrderProcessingAsBaseEntity,"version",this::checkVersionOfConsumerOrderProcessing);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixConsumerOrderShipment(BaseEntity consumerOrderShipmentAsBaseEntity){

		if( isChecked(consumerOrderShipmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(consumerOrderShipmentAsBaseEntity);
		commonObjectPropertyCheck(consumerOrderShipmentAsBaseEntity,"id",this::checkIdOfConsumerOrderShipment);
		commonObjectPropertyCheck(consumerOrderShipmentAsBaseEntity,"who",this::checkWhoOfConsumerOrderShipment);
		commonObjectPropertyCheck(consumerOrderShipmentAsBaseEntity,"shipTime",this::checkShipTimeOfConsumerOrderShipment);
		commonObjectPropertyCheck(consumerOrderShipmentAsBaseEntity,"version",this::checkVersionOfConsumerOrderShipment);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixConsumerOrderDelivery(BaseEntity consumerOrderDeliveryAsBaseEntity){

		if( isChecked(consumerOrderDeliveryAsBaseEntity) ){
			return this;
		}
		markAsChecked(consumerOrderDeliveryAsBaseEntity);
		commonObjectPropertyCheck(consumerOrderDeliveryAsBaseEntity,"id",this::checkIdOfConsumerOrderDelivery);
		commonObjectPropertyCheck(consumerOrderDeliveryAsBaseEntity,"who",this::checkWhoOfConsumerOrderDelivery);
		commonObjectPropertyCheck(consumerOrderDeliveryAsBaseEntity,"deliveryTime",this::checkDeliveryTimeOfConsumerOrderDelivery);
		commonObjectPropertyCheck(consumerOrderDeliveryAsBaseEntity,"version",this::checkVersionOfConsumerOrderDelivery);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixConsumerOrderLineItem(BaseEntity consumerOrderLineItemAsBaseEntity){

		if( isChecked(consumerOrderLineItemAsBaseEntity) ){
			return this;
		}
		markAsChecked(consumerOrderLineItemAsBaseEntity);
		commonObjectPropertyCheck(consumerOrderLineItemAsBaseEntity,"id",this::checkIdOfConsumerOrderLineItem);
		commonObjectPropertyCheck(consumerOrderLineItemAsBaseEntity,"bizOrder",this::checkBizOrderOfConsumerOrderLineItem);
		commonObjectPropertyCheck(consumerOrderLineItemAsBaseEntity,"skuId",this::checkSkuIdOfConsumerOrderLineItem);
		commonObjectPropertyCheck(consumerOrderLineItemAsBaseEntity,"skuName",this::checkSkuNameOfConsumerOrderLineItem);
		commonObjectPropertyCheck(consumerOrderLineItemAsBaseEntity,"price",this::checkPriceOfConsumerOrderLineItem);
		commonObjectPropertyCheck(consumerOrderLineItemAsBaseEntity,"quantity",this::checkQuantityOfConsumerOrderLineItem);
		commonObjectPropertyCheck(consumerOrderLineItemAsBaseEntity,"amount",this::checkAmountOfConsumerOrderLineItem);
		commonObjectPropertyAssign(consumerOrderLineItemAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfConsumerOrderLineItem);
		commonObjectPropertyCheck(consumerOrderLineItemAsBaseEntity,"version",this::checkVersionOfConsumerOrderLineItem);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixConsumerOrderShippingGroup(BaseEntity consumerOrderShippingGroupAsBaseEntity){

		if( isChecked(consumerOrderShippingGroupAsBaseEntity) ){
			return this;
		}
		markAsChecked(consumerOrderShippingGroupAsBaseEntity);
		commonObjectPropertyCheck(consumerOrderShippingGroupAsBaseEntity,"id",this::checkIdOfConsumerOrderShippingGroup);
		commonObjectPropertyCheck(consumerOrderShippingGroupAsBaseEntity,"name",this::checkNameOfConsumerOrderShippingGroup);
		commonObjectPropertyCheck(consumerOrderShippingGroupAsBaseEntity,"bizOrder",this::checkBizOrderOfConsumerOrderShippingGroup);
		commonObjectPropertyCheck(consumerOrderShippingGroupAsBaseEntity,"amount",this::checkAmountOfConsumerOrderShippingGroup);
		commonObjectPropertyCheck(consumerOrderShippingGroupAsBaseEntity,"version",this::checkVersionOfConsumerOrderShippingGroup);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixConsumerOrderPaymentGroup(BaseEntity consumerOrderPaymentGroupAsBaseEntity){

		if( isChecked(consumerOrderPaymentGroupAsBaseEntity) ){
			return this;
		}
		markAsChecked(consumerOrderPaymentGroupAsBaseEntity);
		commonObjectPropertyCheck(consumerOrderPaymentGroupAsBaseEntity,"id",this::checkIdOfConsumerOrderPaymentGroup);
		commonObjectPropertyCheck(consumerOrderPaymentGroupAsBaseEntity,"name",this::checkNameOfConsumerOrderPaymentGroup);
		commonObjectPropertyCheck(consumerOrderPaymentGroupAsBaseEntity,"bizOrder",this::checkBizOrderOfConsumerOrderPaymentGroup);
		commonObjectPropertyCheck(consumerOrderPaymentGroupAsBaseEntity,"cardNumber",this::checkCardNumberOfConsumerOrderPaymentGroup);
		commonObjectPropertyCheck(consumerOrderPaymentGroupAsBaseEntity,"version",this::checkVersionOfConsumerOrderPaymentGroup);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixConsumerOrderPriceAdjustment(BaseEntity consumerOrderPriceAdjustmentAsBaseEntity){

		if( isChecked(consumerOrderPriceAdjustmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(consumerOrderPriceAdjustmentAsBaseEntity);
		commonObjectPropertyCheck(consumerOrderPriceAdjustmentAsBaseEntity,"id",this::checkIdOfConsumerOrderPriceAdjustment);
		commonObjectPropertyCheck(consumerOrderPriceAdjustmentAsBaseEntity,"name",this::checkNameOfConsumerOrderPriceAdjustment);
		commonObjectPropertyCheck(consumerOrderPriceAdjustmentAsBaseEntity,"bizOrder",this::checkBizOrderOfConsumerOrderPriceAdjustment);
		commonObjectPropertyCheck(consumerOrderPriceAdjustmentAsBaseEntity,"amount",this::checkAmountOfConsumerOrderPriceAdjustment);
		commonObjectPropertyCheck(consumerOrderPriceAdjustmentAsBaseEntity,"provider",this::checkProviderOfConsumerOrderPriceAdjustment);
		commonObjectPropertyCheck(consumerOrderPriceAdjustmentAsBaseEntity,"version",this::checkVersionOfConsumerOrderPriceAdjustment);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreMemberCoupon(BaseEntity retailStoreMemberCouponAsBaseEntity){

		if( isChecked(retailStoreMemberCouponAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreMemberCouponAsBaseEntity);
		commonObjectPropertyCheck(retailStoreMemberCouponAsBaseEntity,"id",this::checkIdOfRetailStoreMemberCoupon);
		commonObjectPropertyCheck(retailStoreMemberCouponAsBaseEntity,"name",this::checkNameOfRetailStoreMemberCoupon);
		commonObjectPropertyCheck(retailStoreMemberCouponAsBaseEntity,"owner",this::checkOwnerOfRetailStoreMemberCoupon);
		commonObjectPropertyCheck(retailStoreMemberCouponAsBaseEntity,"number",this::checkNumberOfRetailStoreMemberCoupon);
		commonObjectPropertyAssign(retailStoreMemberCouponAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfRetailStoreMemberCoupon);
		commonObjectPropertyCheck(retailStoreMemberCouponAsBaseEntity,"version",this::checkVersionOfRetailStoreMemberCoupon);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixMemberWishlist(BaseEntity memberWishlistAsBaseEntity){

		if( isChecked(memberWishlistAsBaseEntity) ){
			return this;
		}
		markAsChecked(memberWishlistAsBaseEntity);
		commonObjectPropertyCheck(memberWishlistAsBaseEntity,"id",this::checkIdOfMemberWishlist);
		commonObjectPropertyCheck(memberWishlistAsBaseEntity,"name",this::checkNameOfMemberWishlist);
		commonObjectPropertyCheck(memberWishlistAsBaseEntity,"owner",this::checkOwnerOfMemberWishlist);
		commonObjectPropertyCheck(memberWishlistAsBaseEntity,"version",this::checkVersionOfMemberWishlist);
		commonObjectPropertyCheck(memberWishlistAsBaseEntity,"memberWishlistProductList",this::checkMemberWishlistProductListOfMemberWishlist);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixMemberRewardPoint(BaseEntity memberRewardPointAsBaseEntity){

		if( isChecked(memberRewardPointAsBaseEntity) ){
			return this;
		}
		markAsChecked(memberRewardPointAsBaseEntity);
		commonObjectPropertyCheck(memberRewardPointAsBaseEntity,"id",this::checkIdOfMemberRewardPoint);
		commonObjectPropertyCheck(memberRewardPointAsBaseEntity,"name",this::checkNameOfMemberRewardPoint);
		commonObjectPropertyCheck(memberRewardPointAsBaseEntity,"point",this::checkPointOfMemberRewardPoint);
		commonObjectPropertyCheck(memberRewardPointAsBaseEntity,"owner",this::checkOwnerOfMemberRewardPoint);
		commonObjectPropertyCheck(memberRewardPointAsBaseEntity,"version",this::checkVersionOfMemberRewardPoint);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixMemberRewardPointRedemption(BaseEntity memberRewardPointRedemptionAsBaseEntity){

		if( isChecked(memberRewardPointRedemptionAsBaseEntity) ){
			return this;
		}
		markAsChecked(memberRewardPointRedemptionAsBaseEntity);
		commonObjectPropertyCheck(memberRewardPointRedemptionAsBaseEntity,"id",this::checkIdOfMemberRewardPointRedemption);
		commonObjectPropertyCheck(memberRewardPointRedemptionAsBaseEntity,"name",this::checkNameOfMemberRewardPointRedemption);
		commonObjectPropertyCheck(memberRewardPointRedemptionAsBaseEntity,"point",this::checkPointOfMemberRewardPointRedemption);
		commonObjectPropertyCheck(memberRewardPointRedemptionAsBaseEntity,"owner",this::checkOwnerOfMemberRewardPointRedemption);
		commonObjectPropertyCheck(memberRewardPointRedemptionAsBaseEntity,"version",this::checkVersionOfMemberRewardPointRedemption);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixMemberWishlistProduct(BaseEntity memberWishlistProductAsBaseEntity){

		if( isChecked(memberWishlistProductAsBaseEntity) ){
			return this;
		}
		markAsChecked(memberWishlistProductAsBaseEntity);
		commonObjectPropertyCheck(memberWishlistProductAsBaseEntity,"id",this::checkIdOfMemberWishlistProduct);
		commonObjectPropertyCheck(memberWishlistProductAsBaseEntity,"name",this::checkNameOfMemberWishlistProduct);
		commonObjectPropertyCheck(memberWishlistProductAsBaseEntity,"owner",this::checkOwnerOfMemberWishlistProduct);
		commonObjectPropertyCheck(memberWishlistProductAsBaseEntity,"version",this::checkVersionOfMemberWishlistProduct);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreMemberAddress(BaseEntity retailStoreMemberAddressAsBaseEntity){

		if( isChecked(retailStoreMemberAddressAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreMemberAddressAsBaseEntity);
		commonObjectPropertyCheck(retailStoreMemberAddressAsBaseEntity,"id",this::checkIdOfRetailStoreMemberAddress);
		commonObjectPropertyCheck(retailStoreMemberAddressAsBaseEntity,"name",this::checkNameOfRetailStoreMemberAddress);
		commonObjectPropertyCheck(retailStoreMemberAddressAsBaseEntity,"owner",this::checkOwnerOfRetailStoreMemberAddress);
		commonObjectPropertyCheck(retailStoreMemberAddressAsBaseEntity,"mobilePhone",this::checkMobilePhoneOfRetailStoreMemberAddress);
		commonObjectPropertyCheck(retailStoreMemberAddressAsBaseEntity,"address",this::checkAddressOfRetailStoreMemberAddress);
		commonObjectPropertyCheck(retailStoreMemberAddressAsBaseEntity,"version",this::checkVersionOfRetailStoreMemberAddress);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreMemberGiftCard(BaseEntity retailStoreMemberGiftCardAsBaseEntity){

		if( isChecked(retailStoreMemberGiftCardAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreMemberGiftCardAsBaseEntity);
		commonObjectPropertyCheck(retailStoreMemberGiftCardAsBaseEntity,"id",this::checkIdOfRetailStoreMemberGiftCard);
		commonObjectPropertyCheck(retailStoreMemberGiftCardAsBaseEntity,"name",this::checkNameOfRetailStoreMemberGiftCard);
		commonObjectPropertyCheck(retailStoreMemberGiftCardAsBaseEntity,"owner",this::checkOwnerOfRetailStoreMemberGiftCard);
		commonObjectPropertyCheck(retailStoreMemberGiftCardAsBaseEntity,"number",this::checkNumberOfRetailStoreMemberGiftCard);
		commonObjectPropertyCheck(retailStoreMemberGiftCardAsBaseEntity,"remain",this::checkRemainOfRetailStoreMemberGiftCard);
		commonObjectPropertyCheck(retailStoreMemberGiftCardAsBaseEntity,"version",this::checkVersionOfRetailStoreMemberGiftCard);
		commonObjectPropertyCheck(retailStoreMemberGiftCardAsBaseEntity,"retailStoreMemberGiftCardConsumeRecordList",this::checkRetailStoreMemberGiftCardConsumeRecordListOfRetailStoreMemberGiftCard);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreMemberGiftCardConsumeRecord(BaseEntity retailStoreMemberGiftCardConsumeRecordAsBaseEntity){

		if( isChecked(retailStoreMemberGiftCardConsumeRecordAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreMemberGiftCardConsumeRecordAsBaseEntity);
		commonObjectPropertyCheck(retailStoreMemberGiftCardConsumeRecordAsBaseEntity,"id",this::checkIdOfRetailStoreMemberGiftCardConsumeRecord);
		commonObjectPropertyCheck(retailStoreMemberGiftCardConsumeRecordAsBaseEntity,"occureTime",this::checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord);
		commonObjectPropertyCheck(retailStoreMemberGiftCardConsumeRecordAsBaseEntity,"owner",this::checkOwnerOfRetailStoreMemberGiftCardConsumeRecord);
		commonObjectPropertyCheck(retailStoreMemberGiftCardConsumeRecordAsBaseEntity,"bizOrder",this::checkBizOrderOfRetailStoreMemberGiftCardConsumeRecord);
		commonObjectPropertyCheck(retailStoreMemberGiftCardConsumeRecordAsBaseEntity,"number",this::checkNumberOfRetailStoreMemberGiftCardConsumeRecord);
		commonObjectPropertyCheck(retailStoreMemberGiftCardConsumeRecordAsBaseEntity,"amount",this::checkAmountOfRetailStoreMemberGiftCardConsumeRecord);
		commonObjectPropertyCheck(retailStoreMemberGiftCardConsumeRecordAsBaseEntity,"version",this::checkVersionOfRetailStoreMemberGiftCardConsumeRecord);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixGoodsSupplier(BaseEntity goodsSupplierAsBaseEntity){

		if( isChecked(goodsSupplierAsBaseEntity) ){
			return this;
		}
		markAsChecked(goodsSupplierAsBaseEntity);
		commonObjectPropertyCheck(goodsSupplierAsBaseEntity,"id",this::checkIdOfGoodsSupplier);
		commonObjectPropertyCheck(goodsSupplierAsBaseEntity,"name",this::checkNameOfGoodsSupplier);
		commonObjectPropertyCheck(goodsSupplierAsBaseEntity,"supplyProduct",this::checkSupplyProductOfGoodsSupplier);
		commonObjectPropertyCheck(goodsSupplierAsBaseEntity,"belongTo",this::checkBelongToOfGoodsSupplier);
		commonObjectPropertyCheck(goodsSupplierAsBaseEntity,"contactNumber",this::checkContactNumberOfGoodsSupplier);
		commonObjectPropertyCheck(goodsSupplierAsBaseEntity,"description",this::checkDescriptionOfGoodsSupplier);
		commonObjectPropertyAssign(goodsSupplierAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfGoodsSupplier);
		commonObjectPropertyCheck(goodsSupplierAsBaseEntity,"version",this::checkVersionOfGoodsSupplier);
		commonObjectPropertyCheck(goodsSupplierAsBaseEntity,"supplierProductList",this::checkSupplierProductListOfGoodsSupplier);
		commonObjectPropertyCheck(goodsSupplierAsBaseEntity,"supplyOrderList",this::checkSupplyOrderListOfGoodsSupplier);
		commonObjectPropertyCheck(goodsSupplierAsBaseEntity,"accountSetList",this::checkAccountSetListOfGoodsSupplier);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplierProduct(BaseEntity supplierProductAsBaseEntity){

		if( isChecked(supplierProductAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplierProductAsBaseEntity);
		commonObjectPropertyCheck(supplierProductAsBaseEntity,"id",this::checkIdOfSupplierProduct);
		commonObjectPropertyCheck(supplierProductAsBaseEntity,"productName",this::checkProductNameOfSupplierProduct);
		commonObjectPropertyCheck(supplierProductAsBaseEntity,"productDescription",this::checkProductDescriptionOfSupplierProduct);
		commonObjectPropertyCheck(supplierProductAsBaseEntity,"productUnit",this::checkProductUnitOfSupplierProduct);
		commonObjectPropertyCheck(supplierProductAsBaseEntity,"supplier",this::checkSupplierOfSupplierProduct);
		commonObjectPropertyCheck(supplierProductAsBaseEntity,"version",this::checkVersionOfSupplierProduct);
		commonObjectPropertyCheck(supplierProductAsBaseEntity,"productSupplyDurationList",this::checkProductSupplyDurationListOfSupplierProduct);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixProductSupplyDuration(BaseEntity productSupplyDurationAsBaseEntity){

		if( isChecked(productSupplyDurationAsBaseEntity) ){
			return this;
		}
		markAsChecked(productSupplyDurationAsBaseEntity);
		commonObjectPropertyCheck(productSupplyDurationAsBaseEntity,"id",this::checkIdOfProductSupplyDuration);
		commonObjectPropertyCheck(productSupplyDurationAsBaseEntity,"quantity",this::checkQuantityOfProductSupplyDuration);
		commonObjectPropertyCheck(productSupplyDurationAsBaseEntity,"duration",this::checkDurationOfProductSupplyDuration);
		commonObjectPropertyCheck(productSupplyDurationAsBaseEntity,"price",this::checkPriceOfProductSupplyDuration);
		commonObjectPropertyCheck(productSupplyDurationAsBaseEntity,"product",this::checkProductOfProductSupplyDuration);
		commonObjectPropertyCheck(productSupplyDurationAsBaseEntity,"version",this::checkVersionOfProductSupplyDuration);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplyOrder(BaseEntity supplyOrderAsBaseEntity){

		if( isChecked(supplyOrderAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplyOrderAsBaseEntity);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"id",this::checkIdOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"buyer",this::checkBuyerOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"seller",this::checkSellerOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"title",this::checkTitleOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"totalAmount",this::checkTotalAmountOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"confirmation",this::checkConfirmationOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"approval",this::checkApprovalOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"processing",this::checkProcessingOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"picking",this::checkPickingOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"shipment",this::checkShipmentOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"delivery",this::checkDeliveryOfSupplyOrder);
		commonObjectPropertyAssign(supplyOrderAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"version",this::checkVersionOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"supplyOrderLineItemList",this::checkSupplyOrderLineItemListOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"supplyOrderShippingGroupList",this::checkSupplyOrderShippingGroupListOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"supplyOrderPaymentGroupList",this::checkSupplyOrderPaymentGroupListOfSupplyOrder);
		commonObjectPropertyCheck(supplyOrderAsBaseEntity,"goodsList",this::checkGoodsListOfSupplyOrder);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplyOrderConfirmation(BaseEntity supplyOrderConfirmationAsBaseEntity){

		if( isChecked(supplyOrderConfirmationAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplyOrderConfirmationAsBaseEntity);
		commonObjectPropertyCheck(supplyOrderConfirmationAsBaseEntity,"id",this::checkIdOfSupplyOrderConfirmation);
		commonObjectPropertyCheck(supplyOrderConfirmationAsBaseEntity,"who",this::checkWhoOfSupplyOrderConfirmation);
		commonObjectPropertyCheck(supplyOrderConfirmationAsBaseEntity,"confirmTime",this::checkConfirmTimeOfSupplyOrderConfirmation);
		commonObjectPropertyCheck(supplyOrderConfirmationAsBaseEntity,"version",this::checkVersionOfSupplyOrderConfirmation);
		commonObjectPropertyCheck(supplyOrderConfirmationAsBaseEntity,"consumerOrderList",this::checkConsumerOrderListOfSupplyOrderConfirmation);
		commonObjectPropertyCheck(supplyOrderConfirmationAsBaseEntity,"supplyOrderList",this::checkSupplyOrderListOfSupplyOrderConfirmation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplyOrderApproval(BaseEntity supplyOrderApprovalAsBaseEntity){

		if( isChecked(supplyOrderApprovalAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplyOrderApprovalAsBaseEntity);
		commonObjectPropertyCheck(supplyOrderApprovalAsBaseEntity,"id",this::checkIdOfSupplyOrderApproval);
		commonObjectPropertyCheck(supplyOrderApprovalAsBaseEntity,"who",this::checkWhoOfSupplyOrderApproval);
		commonObjectPropertyCheck(supplyOrderApprovalAsBaseEntity,"approveTime",this::checkApproveTimeOfSupplyOrderApproval);
		commonObjectPropertyCheck(supplyOrderApprovalAsBaseEntity,"version",this::checkVersionOfSupplyOrderApproval);
		commonObjectPropertyCheck(supplyOrderApprovalAsBaseEntity,"consumerOrderList",this::checkConsumerOrderListOfSupplyOrderApproval);
		commonObjectPropertyCheck(supplyOrderApprovalAsBaseEntity,"supplyOrderList",this::checkSupplyOrderListOfSupplyOrderApproval);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplyOrderProcessing(BaseEntity supplyOrderProcessingAsBaseEntity){

		if( isChecked(supplyOrderProcessingAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplyOrderProcessingAsBaseEntity);
		commonObjectPropertyCheck(supplyOrderProcessingAsBaseEntity,"id",this::checkIdOfSupplyOrderProcessing);
		commonObjectPropertyCheck(supplyOrderProcessingAsBaseEntity,"who",this::checkWhoOfSupplyOrderProcessing);
		commonObjectPropertyCheck(supplyOrderProcessingAsBaseEntity,"processTime",this::checkProcessTimeOfSupplyOrderProcessing);
		commonObjectPropertyCheck(supplyOrderProcessingAsBaseEntity,"version",this::checkVersionOfSupplyOrderProcessing);
		commonObjectPropertyCheck(supplyOrderProcessingAsBaseEntity,"consumerOrderList",this::checkConsumerOrderListOfSupplyOrderProcessing);
		commonObjectPropertyCheck(supplyOrderProcessingAsBaseEntity,"supplyOrderList",this::checkSupplyOrderListOfSupplyOrderProcessing);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplyOrderPicking(BaseEntity supplyOrderPickingAsBaseEntity){

		if( isChecked(supplyOrderPickingAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplyOrderPickingAsBaseEntity);
		commonObjectPropertyCheck(supplyOrderPickingAsBaseEntity,"id",this::checkIdOfSupplyOrderPicking);
		commonObjectPropertyCheck(supplyOrderPickingAsBaseEntity,"who",this::checkWhoOfSupplyOrderPicking);
		commonObjectPropertyCheck(supplyOrderPickingAsBaseEntity,"processTime",this::checkProcessTimeOfSupplyOrderPicking);
		commonObjectPropertyCheck(supplyOrderPickingAsBaseEntity,"version",this::checkVersionOfSupplyOrderPicking);
		commonObjectPropertyCheck(supplyOrderPickingAsBaseEntity,"supplyOrderList",this::checkSupplyOrderListOfSupplyOrderPicking);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplyOrderShipment(BaseEntity supplyOrderShipmentAsBaseEntity){

		if( isChecked(supplyOrderShipmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplyOrderShipmentAsBaseEntity);
		commonObjectPropertyCheck(supplyOrderShipmentAsBaseEntity,"id",this::checkIdOfSupplyOrderShipment);
		commonObjectPropertyCheck(supplyOrderShipmentAsBaseEntity,"who",this::checkWhoOfSupplyOrderShipment);
		commonObjectPropertyCheck(supplyOrderShipmentAsBaseEntity,"shipTime",this::checkShipTimeOfSupplyOrderShipment);
		commonObjectPropertyCheck(supplyOrderShipmentAsBaseEntity,"version",this::checkVersionOfSupplyOrderShipment);
		commonObjectPropertyCheck(supplyOrderShipmentAsBaseEntity,"consumerOrderList",this::checkConsumerOrderListOfSupplyOrderShipment);
		commonObjectPropertyCheck(supplyOrderShipmentAsBaseEntity,"supplyOrderList",this::checkSupplyOrderListOfSupplyOrderShipment);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplyOrderDelivery(BaseEntity supplyOrderDeliveryAsBaseEntity){

		if( isChecked(supplyOrderDeliveryAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplyOrderDeliveryAsBaseEntity);
		commonObjectPropertyCheck(supplyOrderDeliveryAsBaseEntity,"id",this::checkIdOfSupplyOrderDelivery);
		commonObjectPropertyCheck(supplyOrderDeliveryAsBaseEntity,"who",this::checkWhoOfSupplyOrderDelivery);
		commonObjectPropertyCheck(supplyOrderDeliveryAsBaseEntity,"deliveryTime",this::checkDeliveryTimeOfSupplyOrderDelivery);
		commonObjectPropertyCheck(supplyOrderDeliveryAsBaseEntity,"version",this::checkVersionOfSupplyOrderDelivery);
		commonObjectPropertyCheck(supplyOrderDeliveryAsBaseEntity,"consumerOrderList",this::checkConsumerOrderListOfSupplyOrderDelivery);
		commonObjectPropertyCheck(supplyOrderDeliveryAsBaseEntity,"supplyOrderList",this::checkSupplyOrderListOfSupplyOrderDelivery);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplyOrderLineItem(BaseEntity supplyOrderLineItemAsBaseEntity){

		if( isChecked(supplyOrderLineItemAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplyOrderLineItemAsBaseEntity);
		commonObjectPropertyCheck(supplyOrderLineItemAsBaseEntity,"id",this::checkIdOfSupplyOrderLineItem);
		commonObjectPropertyCheck(supplyOrderLineItemAsBaseEntity,"bizOrder",this::checkBizOrderOfSupplyOrderLineItem);
		commonObjectPropertyCheck(supplyOrderLineItemAsBaseEntity,"skuId",this::checkSkuIdOfSupplyOrderLineItem);
		commonObjectPropertyCheck(supplyOrderLineItemAsBaseEntity,"skuName",this::checkSkuNameOfSupplyOrderLineItem);
		commonObjectPropertyCheck(supplyOrderLineItemAsBaseEntity,"amount",this::checkAmountOfSupplyOrderLineItem);
		commonObjectPropertyCheck(supplyOrderLineItemAsBaseEntity,"quantity",this::checkQuantityOfSupplyOrderLineItem);
		commonObjectPropertyCheck(supplyOrderLineItemAsBaseEntity,"unitOfMeasurement",this::checkUnitOfMeasurementOfSupplyOrderLineItem);
		commonObjectPropertyCheck(supplyOrderLineItemAsBaseEntity,"version",this::checkVersionOfSupplyOrderLineItem);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplyOrderShippingGroup(BaseEntity supplyOrderShippingGroupAsBaseEntity){

		if( isChecked(supplyOrderShippingGroupAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplyOrderShippingGroupAsBaseEntity);
		commonObjectPropertyCheck(supplyOrderShippingGroupAsBaseEntity,"id",this::checkIdOfSupplyOrderShippingGroup);
		commonObjectPropertyCheck(supplyOrderShippingGroupAsBaseEntity,"name",this::checkNameOfSupplyOrderShippingGroup);
		commonObjectPropertyCheck(supplyOrderShippingGroupAsBaseEntity,"bizOrder",this::checkBizOrderOfSupplyOrderShippingGroup);
		commonObjectPropertyCheck(supplyOrderShippingGroupAsBaseEntity,"amount",this::checkAmountOfSupplyOrderShippingGroup);
		commonObjectPropertyCheck(supplyOrderShippingGroupAsBaseEntity,"version",this::checkVersionOfSupplyOrderShippingGroup);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplyOrderPaymentGroup(BaseEntity supplyOrderPaymentGroupAsBaseEntity){

		if( isChecked(supplyOrderPaymentGroupAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplyOrderPaymentGroupAsBaseEntity);
		commonObjectPropertyCheck(supplyOrderPaymentGroupAsBaseEntity,"id",this::checkIdOfSupplyOrderPaymentGroup);
		commonObjectPropertyCheck(supplyOrderPaymentGroupAsBaseEntity,"name",this::checkNameOfSupplyOrderPaymentGroup);
		commonObjectPropertyCheck(supplyOrderPaymentGroupAsBaseEntity,"bizOrder",this::checkBizOrderOfSupplyOrderPaymentGroup);
		commonObjectPropertyCheck(supplyOrderPaymentGroupAsBaseEntity,"cardNumber",this::checkCardNumberOfSupplyOrderPaymentGroup);
		commonObjectPropertyCheck(supplyOrderPaymentGroupAsBaseEntity,"version",this::checkVersionOfSupplyOrderPaymentGroup);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOrder(BaseEntity retailStoreOrderAsBaseEntity){

		if( isChecked(retailStoreOrderAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOrderAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"id",this::checkIdOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"buyer",this::checkBuyerOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"seller",this::checkSellerOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"title",this::checkTitleOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"totalAmount",this::checkTotalAmountOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"confirmation",this::checkConfirmationOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"approval",this::checkApprovalOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"processing",this::checkProcessingOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"picking",this::checkPickingOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"shipment",this::checkShipmentOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"delivery",this::checkDeliveryOfRetailStoreOrder);
		commonObjectPropertyAssign(retailStoreOrderAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"version",this::checkVersionOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"retailStoreOrderLineItemList",this::checkRetailStoreOrderLineItemListOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"retailStoreOrderShippingGroupList",this::checkRetailStoreOrderShippingGroupListOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"retailStoreOrderPaymentGroupList",this::checkRetailStoreOrderPaymentGroupListOfRetailStoreOrder);
		commonObjectPropertyCheck(retailStoreOrderAsBaseEntity,"goodsList",this::checkGoodsListOfRetailStoreOrder);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOrderConfirmation(BaseEntity retailStoreOrderConfirmationAsBaseEntity){

		if( isChecked(retailStoreOrderConfirmationAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOrderConfirmationAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOrderConfirmationAsBaseEntity,"id",this::checkIdOfRetailStoreOrderConfirmation);
		commonObjectPropertyCheck(retailStoreOrderConfirmationAsBaseEntity,"who",this::checkWhoOfRetailStoreOrderConfirmation);
		commonObjectPropertyCheck(retailStoreOrderConfirmationAsBaseEntity,"confirmTime",this::checkConfirmTimeOfRetailStoreOrderConfirmation);
		commonObjectPropertyCheck(retailStoreOrderConfirmationAsBaseEntity,"version",this::checkVersionOfRetailStoreOrderConfirmation);
		commonObjectPropertyCheck(retailStoreOrderConfirmationAsBaseEntity,"retailStoreOrderList",this::checkRetailStoreOrderListOfRetailStoreOrderConfirmation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOrderApproval(BaseEntity retailStoreOrderApprovalAsBaseEntity){

		if( isChecked(retailStoreOrderApprovalAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOrderApprovalAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOrderApprovalAsBaseEntity,"id",this::checkIdOfRetailStoreOrderApproval);
		commonObjectPropertyCheck(retailStoreOrderApprovalAsBaseEntity,"who",this::checkWhoOfRetailStoreOrderApproval);
		commonObjectPropertyCheck(retailStoreOrderApprovalAsBaseEntity,"approveTime",this::checkApproveTimeOfRetailStoreOrderApproval);
		commonObjectPropertyCheck(retailStoreOrderApprovalAsBaseEntity,"version",this::checkVersionOfRetailStoreOrderApproval);
		commonObjectPropertyCheck(retailStoreOrderApprovalAsBaseEntity,"retailStoreOrderList",this::checkRetailStoreOrderListOfRetailStoreOrderApproval);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOrderProcessing(BaseEntity retailStoreOrderProcessingAsBaseEntity){

		if( isChecked(retailStoreOrderProcessingAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOrderProcessingAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOrderProcessingAsBaseEntity,"id",this::checkIdOfRetailStoreOrderProcessing);
		commonObjectPropertyCheck(retailStoreOrderProcessingAsBaseEntity,"who",this::checkWhoOfRetailStoreOrderProcessing);
		commonObjectPropertyCheck(retailStoreOrderProcessingAsBaseEntity,"processTime",this::checkProcessTimeOfRetailStoreOrderProcessing);
		commonObjectPropertyCheck(retailStoreOrderProcessingAsBaseEntity,"version",this::checkVersionOfRetailStoreOrderProcessing);
		commonObjectPropertyCheck(retailStoreOrderProcessingAsBaseEntity,"retailStoreOrderList",this::checkRetailStoreOrderListOfRetailStoreOrderProcessing);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOrderPicking(BaseEntity retailStoreOrderPickingAsBaseEntity){

		if( isChecked(retailStoreOrderPickingAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOrderPickingAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOrderPickingAsBaseEntity,"id",this::checkIdOfRetailStoreOrderPicking);
		commonObjectPropertyCheck(retailStoreOrderPickingAsBaseEntity,"who",this::checkWhoOfRetailStoreOrderPicking);
		commonObjectPropertyCheck(retailStoreOrderPickingAsBaseEntity,"processTime",this::checkProcessTimeOfRetailStoreOrderPicking);
		commonObjectPropertyCheck(retailStoreOrderPickingAsBaseEntity,"version",this::checkVersionOfRetailStoreOrderPicking);
		commonObjectPropertyCheck(retailStoreOrderPickingAsBaseEntity,"retailStoreOrderList",this::checkRetailStoreOrderListOfRetailStoreOrderPicking);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOrderShipment(BaseEntity retailStoreOrderShipmentAsBaseEntity){

		if( isChecked(retailStoreOrderShipmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOrderShipmentAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOrderShipmentAsBaseEntity,"id",this::checkIdOfRetailStoreOrderShipment);
		commonObjectPropertyCheck(retailStoreOrderShipmentAsBaseEntity,"who",this::checkWhoOfRetailStoreOrderShipment);
		commonObjectPropertyCheck(retailStoreOrderShipmentAsBaseEntity,"shipTime",this::checkShipTimeOfRetailStoreOrderShipment);
		commonObjectPropertyCheck(retailStoreOrderShipmentAsBaseEntity,"version",this::checkVersionOfRetailStoreOrderShipment);
		commonObjectPropertyCheck(retailStoreOrderShipmentAsBaseEntity,"retailStoreOrderList",this::checkRetailStoreOrderListOfRetailStoreOrderShipment);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOrderDelivery(BaseEntity retailStoreOrderDeliveryAsBaseEntity){

		if( isChecked(retailStoreOrderDeliveryAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOrderDeliveryAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOrderDeliveryAsBaseEntity,"id",this::checkIdOfRetailStoreOrderDelivery);
		commonObjectPropertyCheck(retailStoreOrderDeliveryAsBaseEntity,"who",this::checkWhoOfRetailStoreOrderDelivery);
		commonObjectPropertyCheck(retailStoreOrderDeliveryAsBaseEntity,"deliveryTime",this::checkDeliveryTimeOfRetailStoreOrderDelivery);
		commonObjectPropertyCheck(retailStoreOrderDeliveryAsBaseEntity,"version",this::checkVersionOfRetailStoreOrderDelivery);
		commonObjectPropertyCheck(retailStoreOrderDeliveryAsBaseEntity,"retailStoreOrderList",this::checkRetailStoreOrderListOfRetailStoreOrderDelivery);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOrderLineItem(BaseEntity retailStoreOrderLineItemAsBaseEntity){

		if( isChecked(retailStoreOrderLineItemAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOrderLineItemAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOrderLineItemAsBaseEntity,"id",this::checkIdOfRetailStoreOrderLineItem);
		commonObjectPropertyCheck(retailStoreOrderLineItemAsBaseEntity,"bizOrder",this::checkBizOrderOfRetailStoreOrderLineItem);
		commonObjectPropertyCheck(retailStoreOrderLineItemAsBaseEntity,"skuId",this::checkSkuIdOfRetailStoreOrderLineItem);
		commonObjectPropertyCheck(retailStoreOrderLineItemAsBaseEntity,"skuName",this::checkSkuNameOfRetailStoreOrderLineItem);
		commonObjectPropertyCheck(retailStoreOrderLineItemAsBaseEntity,"amount",this::checkAmountOfRetailStoreOrderLineItem);
		commonObjectPropertyCheck(retailStoreOrderLineItemAsBaseEntity,"quantity",this::checkQuantityOfRetailStoreOrderLineItem);
		commonObjectPropertyCheck(retailStoreOrderLineItemAsBaseEntity,"unitOfMeasurement",this::checkUnitOfMeasurementOfRetailStoreOrderLineItem);
		commonObjectPropertyCheck(retailStoreOrderLineItemAsBaseEntity,"version",this::checkVersionOfRetailStoreOrderLineItem);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOrderShippingGroup(BaseEntity retailStoreOrderShippingGroupAsBaseEntity){

		if( isChecked(retailStoreOrderShippingGroupAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOrderShippingGroupAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOrderShippingGroupAsBaseEntity,"id",this::checkIdOfRetailStoreOrderShippingGroup);
		commonObjectPropertyCheck(retailStoreOrderShippingGroupAsBaseEntity,"name",this::checkNameOfRetailStoreOrderShippingGroup);
		commonObjectPropertyCheck(retailStoreOrderShippingGroupAsBaseEntity,"bizOrder",this::checkBizOrderOfRetailStoreOrderShippingGroup);
		commonObjectPropertyCheck(retailStoreOrderShippingGroupAsBaseEntity,"amount",this::checkAmountOfRetailStoreOrderShippingGroup);
		commonObjectPropertyCheck(retailStoreOrderShippingGroupAsBaseEntity,"version",this::checkVersionOfRetailStoreOrderShippingGroup);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixRetailStoreOrderPaymentGroup(BaseEntity retailStoreOrderPaymentGroupAsBaseEntity){

		if( isChecked(retailStoreOrderPaymentGroupAsBaseEntity) ){
			return this;
		}
		markAsChecked(retailStoreOrderPaymentGroupAsBaseEntity);
		commonObjectPropertyCheck(retailStoreOrderPaymentGroupAsBaseEntity,"id",this::checkIdOfRetailStoreOrderPaymentGroup);
		commonObjectPropertyCheck(retailStoreOrderPaymentGroupAsBaseEntity,"name",this::checkNameOfRetailStoreOrderPaymentGroup);
		commonObjectPropertyCheck(retailStoreOrderPaymentGroupAsBaseEntity,"bizOrder",this::checkBizOrderOfRetailStoreOrderPaymentGroup);
		commonObjectPropertyCheck(retailStoreOrderPaymentGroupAsBaseEntity,"cardNumber",this::checkCardNumberOfRetailStoreOrderPaymentGroup);
		commonObjectPropertyCheck(retailStoreOrderPaymentGroupAsBaseEntity,"version",this::checkVersionOfRetailStoreOrderPaymentGroup);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixWarehouse(BaseEntity warehouseAsBaseEntity){

		if( isChecked(warehouseAsBaseEntity) ){
			return this;
		}
		markAsChecked(warehouseAsBaseEntity);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"id",this::checkIdOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"location",this::checkLocationOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"contactNumber",this::checkContactNumberOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"totalArea",this::checkTotalAreaOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"owner",this::checkOwnerOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"latitude",this::checkLatitudeOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"longitude",this::checkLongitudeOfWarehouse);
		commonObjectPropertyAssign(warehouseAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"version",this::checkVersionOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"storageSpaceList",this::checkStorageSpaceListOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"smartPalletList",this::checkSmartPalletListOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"supplierSpaceList",this::checkSupplierSpaceListOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"receivingSpaceList",this::checkReceivingSpaceListOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"shippingSpaceList",this::checkShippingSpaceListOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"damageSpaceList",this::checkDamageSpaceListOfWarehouse);
		commonObjectPropertyCheck(warehouseAsBaseEntity,"warehouseAssetList",this::checkWarehouseAssetListOfWarehouse);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixStorageSpace(BaseEntity storageSpaceAsBaseEntity){

		if( isChecked(storageSpaceAsBaseEntity) ){
			return this;
		}
		markAsChecked(storageSpaceAsBaseEntity);
		commonObjectPropertyCheck(storageSpaceAsBaseEntity,"id",this::checkIdOfStorageSpace);
		commonObjectPropertyCheck(storageSpaceAsBaseEntity,"location",this::checkLocationOfStorageSpace);
		commonObjectPropertyCheck(storageSpaceAsBaseEntity,"contactNumber",this::checkContactNumberOfStorageSpace);
		commonObjectPropertyCheck(storageSpaceAsBaseEntity,"totalArea",this::checkTotalAreaOfStorageSpace);
		commonObjectPropertyCheck(storageSpaceAsBaseEntity,"warehouse",this::checkWarehouseOfStorageSpace);
		commonObjectPropertyCheck(storageSpaceAsBaseEntity,"latitude",this::checkLatitudeOfStorageSpace);
		commonObjectPropertyCheck(storageSpaceAsBaseEntity,"longitude",this::checkLongitudeOfStorageSpace);
		commonObjectPropertyAssign(storageSpaceAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfStorageSpace);
		commonObjectPropertyCheck(storageSpaceAsBaseEntity,"version",this::checkVersionOfStorageSpace);
		commonObjectPropertyCheck(storageSpaceAsBaseEntity,"goodsShelfList",this::checkGoodsShelfListOfStorageSpace);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSmartPallet(BaseEntity smartPalletAsBaseEntity){

		if( isChecked(smartPalletAsBaseEntity) ){
			return this;
		}
		markAsChecked(smartPalletAsBaseEntity);
		commonObjectPropertyCheck(smartPalletAsBaseEntity,"id",this::checkIdOfSmartPallet);
		commonObjectPropertyCheck(smartPalletAsBaseEntity,"location",this::checkLocationOfSmartPallet);
		commonObjectPropertyCheck(smartPalletAsBaseEntity,"contactNumber",this::checkContactNumberOfSmartPallet);
		commonObjectPropertyCheck(smartPalletAsBaseEntity,"totalArea",this::checkTotalAreaOfSmartPallet);
		commonObjectPropertyCheck(smartPalletAsBaseEntity,"latitude",this::checkLatitudeOfSmartPallet);
		commonObjectPropertyCheck(smartPalletAsBaseEntity,"longitude",this::checkLongitudeOfSmartPallet);
		commonObjectPropertyCheck(smartPalletAsBaseEntity,"warehouse",this::checkWarehouseOfSmartPallet);
		commonObjectPropertyAssign(smartPalletAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfSmartPallet);
		commonObjectPropertyCheck(smartPalletAsBaseEntity,"version",this::checkVersionOfSmartPallet);
		commonObjectPropertyCheck(smartPalletAsBaseEntity,"goodsList",this::checkGoodsListOfSmartPallet);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixGoodsShelf(BaseEntity goodsShelfAsBaseEntity){

		if( isChecked(goodsShelfAsBaseEntity) ){
			return this;
		}
		markAsChecked(goodsShelfAsBaseEntity);
		commonObjectPropertyCheck(goodsShelfAsBaseEntity,"id",this::checkIdOfGoodsShelf);
		commonObjectPropertyCheck(goodsShelfAsBaseEntity,"location",this::checkLocationOfGoodsShelf);
		commonObjectPropertyCheck(goodsShelfAsBaseEntity,"storageSpace",this::checkStorageSpaceOfGoodsShelf);
		commonObjectPropertyCheck(goodsShelfAsBaseEntity,"supplierSpace",this::checkSupplierSpaceOfGoodsShelf);
		commonObjectPropertyCheck(goodsShelfAsBaseEntity,"damageSpace",this::checkDamageSpaceOfGoodsShelf);
		commonObjectPropertyAssign(goodsShelfAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfGoodsShelf);
		commonObjectPropertyCheck(goodsShelfAsBaseEntity,"version",this::checkVersionOfGoodsShelf);
		commonObjectPropertyCheck(goodsShelfAsBaseEntity,"goodsShelfStockCountList",this::checkGoodsShelfStockCountListOfGoodsShelf);
		commonObjectPropertyCheck(goodsShelfAsBaseEntity,"goodsAllocationList",this::checkGoodsAllocationListOfGoodsShelf);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixGoodsShelfStockCount(BaseEntity goodsShelfStockCountAsBaseEntity){

		if( isChecked(goodsShelfStockCountAsBaseEntity) ){
			return this;
		}
		markAsChecked(goodsShelfStockCountAsBaseEntity);
		commonObjectPropertyCheck(goodsShelfStockCountAsBaseEntity,"id",this::checkIdOfGoodsShelfStockCount);
		commonObjectPropertyCheck(goodsShelfStockCountAsBaseEntity,"title",this::checkTitleOfGoodsShelfStockCount);
		commonObjectPropertyCheck(goodsShelfStockCountAsBaseEntity,"countTime",this::checkCountTimeOfGoodsShelfStockCount);
		commonObjectPropertyCheck(goodsShelfStockCountAsBaseEntity,"summary",this::checkSummaryOfGoodsShelfStockCount);
		commonObjectPropertyCheck(goodsShelfStockCountAsBaseEntity,"shelf",this::checkShelfOfGoodsShelfStockCount);
		commonObjectPropertyCheck(goodsShelfStockCountAsBaseEntity,"version",this::checkVersionOfGoodsShelfStockCount);
		commonObjectPropertyCheck(goodsShelfStockCountAsBaseEntity,"stockCountIssueTrackList",this::checkStockCountIssueTrackListOfGoodsShelfStockCount);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixStockCountIssueTrack(BaseEntity stockCountIssueTrackAsBaseEntity){

		if( isChecked(stockCountIssueTrackAsBaseEntity) ){
			return this;
		}
		markAsChecked(stockCountIssueTrackAsBaseEntity);
		commonObjectPropertyCheck(stockCountIssueTrackAsBaseEntity,"id",this::checkIdOfStockCountIssueTrack);
		commonObjectPropertyCheck(stockCountIssueTrackAsBaseEntity,"title",this::checkTitleOfStockCountIssueTrack);
		commonObjectPropertyCheck(stockCountIssueTrackAsBaseEntity,"countTime",this::checkCountTimeOfStockCountIssueTrack);
		commonObjectPropertyCheck(stockCountIssueTrackAsBaseEntity,"summary",this::checkSummaryOfStockCountIssueTrack);
		commonObjectPropertyCheck(stockCountIssueTrackAsBaseEntity,"stockCount",this::checkStockCountOfStockCountIssueTrack);
		commonObjectPropertyCheck(stockCountIssueTrackAsBaseEntity,"version",this::checkVersionOfStockCountIssueTrack);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixGoodsAllocation(BaseEntity goodsAllocationAsBaseEntity){

		if( isChecked(goodsAllocationAsBaseEntity) ){
			return this;
		}
		markAsChecked(goodsAllocationAsBaseEntity);
		commonObjectPropertyCheck(goodsAllocationAsBaseEntity,"id",this::checkIdOfGoodsAllocation);
		commonObjectPropertyCheck(goodsAllocationAsBaseEntity,"location",this::checkLocationOfGoodsAllocation);
		commonObjectPropertyCheck(goodsAllocationAsBaseEntity,"latitude",this::checkLatitudeOfGoodsAllocation);
		commonObjectPropertyCheck(goodsAllocationAsBaseEntity,"longitude",this::checkLongitudeOfGoodsAllocation);
		commonObjectPropertyCheck(goodsAllocationAsBaseEntity,"goodsShelf",this::checkGoodsShelfOfGoodsAllocation);
		commonObjectPropertyCheck(goodsAllocationAsBaseEntity,"version",this::checkVersionOfGoodsAllocation);
		commonObjectPropertyCheck(goodsAllocationAsBaseEntity,"goodsList",this::checkGoodsListOfGoodsAllocation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixGoods(BaseEntity goodsAsBaseEntity){

		if( isChecked(goodsAsBaseEntity) ){
			return this;
		}
		markAsChecked(goodsAsBaseEntity);
		commonObjectPropertyCheck(goodsAsBaseEntity,"id",this::checkIdOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"name",this::checkNameOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"rfid",this::checkRfidOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"uom",this::checkUomOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"maxPackage",this::checkMaxPackageOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"expireTime",this::checkExpireTimeOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"sku",this::checkSkuOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"receivingSpace",this::checkReceivingSpaceOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"goodsAllocation",this::checkGoodsAllocationOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"smartPallet",this::checkSmartPalletOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"shippingSpace",this::checkShippingSpaceOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"transportTask",this::checkTransportTaskOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"retailStore",this::checkRetailStoreOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"bizOrder",this::checkBizOrderOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"retailStoreOrder",this::checkRetailStoreOrderOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"packaging",this::checkPackagingOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"version",this::checkVersionOfGoods);
		commonObjectPropertyCheck(goodsAsBaseEntity,"goodsMovementList",this::checkGoodsMovementListOfGoods);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixGoodsPackaging(BaseEntity goodsPackagingAsBaseEntity){

		if( isChecked(goodsPackagingAsBaseEntity) ){
			return this;
		}
		markAsChecked(goodsPackagingAsBaseEntity);
		commonObjectPropertyCheck(goodsPackagingAsBaseEntity,"id",this::checkIdOfGoodsPackaging);
		commonObjectPropertyCheck(goodsPackagingAsBaseEntity,"packageName",this::checkPackageNameOfGoodsPackaging);
		commonObjectPropertyCheck(goodsPackagingAsBaseEntity,"rfid",this::checkRfidOfGoodsPackaging);
		commonObjectPropertyCheck(goodsPackagingAsBaseEntity,"packageTime",this::checkPackageTimeOfGoodsPackaging);
		commonObjectPropertyCheck(goodsPackagingAsBaseEntity,"description",this::checkDescriptionOfGoodsPackaging);
		commonObjectPropertyCheck(goodsPackagingAsBaseEntity,"version",this::checkVersionOfGoodsPackaging);
		commonObjectPropertyCheck(goodsPackagingAsBaseEntity,"goodsList",this::checkGoodsListOfGoodsPackaging);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixGoodsMovement(BaseEntity goodsMovementAsBaseEntity){

		if( isChecked(goodsMovementAsBaseEntity) ){
			return this;
		}
		markAsChecked(goodsMovementAsBaseEntity);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"id",this::checkIdOfGoodsMovement);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"moveTime",this::checkMoveTimeOfGoodsMovement);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"facility",this::checkFacilityOfGoodsMovement);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"facilityId",this::checkFacilityIdOfGoodsMovement);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"fromIp",this::checkFromIpOfGoodsMovement);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"userAgent",this::checkUserAgentOfGoodsMovement);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"sessionId",this::checkSessionIdOfGoodsMovement);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"latitude",this::checkLatitudeOfGoodsMovement);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"longitude",this::checkLongitudeOfGoodsMovement);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"goods",this::checkGoodsOfGoodsMovement);
		commonObjectPropertyCheck(goodsMovementAsBaseEntity,"version",this::checkVersionOfGoodsMovement);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSupplierSpace(BaseEntity supplierSpaceAsBaseEntity){

		if( isChecked(supplierSpaceAsBaseEntity) ){
			return this;
		}
		markAsChecked(supplierSpaceAsBaseEntity);
		commonObjectPropertyCheck(supplierSpaceAsBaseEntity,"id",this::checkIdOfSupplierSpace);
		commonObjectPropertyCheck(supplierSpaceAsBaseEntity,"location",this::checkLocationOfSupplierSpace);
		commonObjectPropertyCheck(supplierSpaceAsBaseEntity,"contactNumber",this::checkContactNumberOfSupplierSpace);
		commonObjectPropertyCheck(supplierSpaceAsBaseEntity,"totalArea",this::checkTotalAreaOfSupplierSpace);
		commonObjectPropertyCheck(supplierSpaceAsBaseEntity,"warehouse",this::checkWarehouseOfSupplierSpace);
		commonObjectPropertyCheck(supplierSpaceAsBaseEntity,"latitude",this::checkLatitudeOfSupplierSpace);
		commonObjectPropertyCheck(supplierSpaceAsBaseEntity,"longitude",this::checkLongitudeOfSupplierSpace);
		commonObjectPropertyAssign(supplierSpaceAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfSupplierSpace);
		commonObjectPropertyCheck(supplierSpaceAsBaseEntity,"version",this::checkVersionOfSupplierSpace);
		commonObjectPropertyCheck(supplierSpaceAsBaseEntity,"goodsShelfList",this::checkGoodsShelfListOfSupplierSpace);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixReceivingSpace(BaseEntity receivingSpaceAsBaseEntity){

		if( isChecked(receivingSpaceAsBaseEntity) ){
			return this;
		}
		markAsChecked(receivingSpaceAsBaseEntity);
		commonObjectPropertyCheck(receivingSpaceAsBaseEntity,"id",this::checkIdOfReceivingSpace);
		commonObjectPropertyCheck(receivingSpaceAsBaseEntity,"location",this::checkLocationOfReceivingSpace);
		commonObjectPropertyCheck(receivingSpaceAsBaseEntity,"contactNumber",this::checkContactNumberOfReceivingSpace);
		commonObjectPropertyCheck(receivingSpaceAsBaseEntity,"description",this::checkDescriptionOfReceivingSpace);
		commonObjectPropertyCheck(receivingSpaceAsBaseEntity,"totalArea",this::checkTotalAreaOfReceivingSpace);
		commonObjectPropertyCheck(receivingSpaceAsBaseEntity,"warehouse",this::checkWarehouseOfReceivingSpace);
		commonObjectPropertyCheck(receivingSpaceAsBaseEntity,"latitude",this::checkLatitudeOfReceivingSpace);
		commonObjectPropertyCheck(receivingSpaceAsBaseEntity,"longitude",this::checkLongitudeOfReceivingSpace);
		commonObjectPropertyAssign(receivingSpaceAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfReceivingSpace);
		commonObjectPropertyCheck(receivingSpaceAsBaseEntity,"version",this::checkVersionOfReceivingSpace);
		commonObjectPropertyCheck(receivingSpaceAsBaseEntity,"goodsList",this::checkGoodsListOfReceivingSpace);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixShippingSpace(BaseEntity shippingSpaceAsBaseEntity){

		if( isChecked(shippingSpaceAsBaseEntity) ){
			return this;
		}
		markAsChecked(shippingSpaceAsBaseEntity);
		commonObjectPropertyCheck(shippingSpaceAsBaseEntity,"id",this::checkIdOfShippingSpace);
		commonObjectPropertyCheck(shippingSpaceAsBaseEntity,"location",this::checkLocationOfShippingSpace);
		commonObjectPropertyCheck(shippingSpaceAsBaseEntity,"contactNumber",this::checkContactNumberOfShippingSpace);
		commonObjectPropertyCheck(shippingSpaceAsBaseEntity,"totalArea",this::checkTotalAreaOfShippingSpace);
		commonObjectPropertyCheck(shippingSpaceAsBaseEntity,"warehouse",this::checkWarehouseOfShippingSpace);
		commonObjectPropertyCheck(shippingSpaceAsBaseEntity,"latitude",this::checkLatitudeOfShippingSpace);
		commonObjectPropertyCheck(shippingSpaceAsBaseEntity,"longitude",this::checkLongitudeOfShippingSpace);
		commonObjectPropertyCheck(shippingSpaceAsBaseEntity,"description",this::checkDescriptionOfShippingSpace);
		commonObjectPropertyAssign(shippingSpaceAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfShippingSpace);
		commonObjectPropertyCheck(shippingSpaceAsBaseEntity,"version",this::checkVersionOfShippingSpace);
		commonObjectPropertyCheck(shippingSpaceAsBaseEntity,"goodsList",this::checkGoodsListOfShippingSpace);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixDamageSpace(BaseEntity damageSpaceAsBaseEntity){

		if( isChecked(damageSpaceAsBaseEntity) ){
			return this;
		}
		markAsChecked(damageSpaceAsBaseEntity);
		commonObjectPropertyCheck(damageSpaceAsBaseEntity,"id",this::checkIdOfDamageSpace);
		commonObjectPropertyCheck(damageSpaceAsBaseEntity,"location",this::checkLocationOfDamageSpace);
		commonObjectPropertyCheck(damageSpaceAsBaseEntity,"contactNumber",this::checkContactNumberOfDamageSpace);
		commonObjectPropertyCheck(damageSpaceAsBaseEntity,"totalArea",this::checkTotalAreaOfDamageSpace);
		commonObjectPropertyCheck(damageSpaceAsBaseEntity,"latitude",this::checkLatitudeOfDamageSpace);
		commonObjectPropertyCheck(damageSpaceAsBaseEntity,"longitude",this::checkLongitudeOfDamageSpace);
		commonObjectPropertyCheck(damageSpaceAsBaseEntity,"warehouse",this::checkWarehouseOfDamageSpace);
		commonObjectPropertyAssign(damageSpaceAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfDamageSpace);
		commonObjectPropertyCheck(damageSpaceAsBaseEntity,"version",this::checkVersionOfDamageSpace);
		commonObjectPropertyCheck(damageSpaceAsBaseEntity,"goodsShelfList",this::checkGoodsShelfListOfDamageSpace);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixWarehouseAsset(BaseEntity warehouseAssetAsBaseEntity){

		if( isChecked(warehouseAssetAsBaseEntity) ){
			return this;
		}
		markAsChecked(warehouseAssetAsBaseEntity);
		commonObjectPropertyCheck(warehouseAssetAsBaseEntity,"id",this::checkIdOfWarehouseAsset);
		commonObjectPropertyCheck(warehouseAssetAsBaseEntity,"name",this::checkNameOfWarehouseAsset);
		commonObjectPropertyCheck(warehouseAssetAsBaseEntity,"position",this::checkPositionOfWarehouseAsset);
		commonObjectPropertyCheck(warehouseAssetAsBaseEntity,"owner",this::checkOwnerOfWarehouseAsset);
		commonObjectPropertyAssign(warehouseAssetAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfWarehouseAsset);
		commonObjectPropertyCheck(warehouseAssetAsBaseEntity,"version",this::checkVersionOfWarehouseAsset);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixTransportFleet(BaseEntity transportFleetAsBaseEntity){

		if( isChecked(transportFleetAsBaseEntity) ){
			return this;
		}
		markAsChecked(transportFleetAsBaseEntity);
		commonObjectPropertyCheck(transportFleetAsBaseEntity,"id",this::checkIdOfTransportFleet);
		commonObjectPropertyCheck(transportFleetAsBaseEntity,"name",this::checkNameOfTransportFleet);
		commonObjectPropertyCheck(transportFleetAsBaseEntity,"contactNumber",this::checkContactNumberOfTransportFleet);
		commonObjectPropertyCheck(transportFleetAsBaseEntity,"owner",this::checkOwnerOfTransportFleet);
		commonObjectPropertyAssign(transportFleetAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfTransportFleet);
		commonObjectPropertyCheck(transportFleetAsBaseEntity,"version",this::checkVersionOfTransportFleet);
		commonObjectPropertyCheck(transportFleetAsBaseEntity,"transportTruckList",this::checkTransportTruckListOfTransportFleet);
		commonObjectPropertyCheck(transportFleetAsBaseEntity,"truckDriverList",this::checkTruckDriverListOfTransportFleet);
		commonObjectPropertyCheck(transportFleetAsBaseEntity,"transportTaskList",this::checkTransportTaskListOfTransportFleet);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixTransportTruck(BaseEntity transportTruckAsBaseEntity){

		if( isChecked(transportTruckAsBaseEntity) ){
			return this;
		}
		markAsChecked(transportTruckAsBaseEntity);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"id",this::checkIdOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"name",this::checkNameOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"plateNumber",this::checkPlateNumberOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"contactNumber",this::checkContactNumberOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"vehicleLicenseNumber",this::checkVehicleLicenseNumberOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"engineNumber",this::checkEngineNumberOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"makeDate",this::checkMakeDateOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"mileage",this::checkMileageOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"bodyColor",this::checkBodyColorOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"owner",this::checkOwnerOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"version",this::checkVersionOfTransportTruck);
		commonObjectPropertyCheck(transportTruckAsBaseEntity,"transportTaskList",this::checkTransportTaskListOfTransportTruck);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixTruckDriver(BaseEntity truckDriverAsBaseEntity){

		if( isChecked(truckDriverAsBaseEntity) ){
			return this;
		}
		markAsChecked(truckDriverAsBaseEntity);
		commonObjectPropertyCheck(truckDriverAsBaseEntity,"id",this::checkIdOfTruckDriver);
		commonObjectPropertyCheck(truckDriverAsBaseEntity,"name",this::checkNameOfTruckDriver);
		commonObjectPropertyCheck(truckDriverAsBaseEntity,"driverLicenseNumber",this::checkDriverLicenseNumberOfTruckDriver);
		commonObjectPropertyCheck(truckDriverAsBaseEntity,"contactNumber",this::checkContactNumberOfTruckDriver);
		commonObjectPropertyCheck(truckDriverAsBaseEntity,"belongsTo",this::checkBelongsToOfTruckDriver);
		commonObjectPropertyCheck(truckDriverAsBaseEntity,"version",this::checkVersionOfTruckDriver);
		commonObjectPropertyCheck(truckDriverAsBaseEntity,"transportTaskList",this::checkTransportTaskListOfTruckDriver);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixTransportTask(BaseEntity transportTaskAsBaseEntity){

		if( isChecked(transportTaskAsBaseEntity) ){
			return this;
		}
		markAsChecked(transportTaskAsBaseEntity);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"id",this::checkIdOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"name",this::checkNameOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"start",this::checkStartOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"beginTime",this::checkBeginTimeOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"end",this::checkEndOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"driver",this::checkDriverOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"truck",this::checkTruckOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"belongsTo",this::checkBelongsToOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"latitude",this::checkLatitudeOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"longitude",this::checkLongitudeOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"version",this::checkVersionOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"goodsList",this::checkGoodsListOfTransportTask);
		commonObjectPropertyCheck(transportTaskAsBaseEntity,"transportTaskTrackList",this::checkTransportTaskTrackListOfTransportTask);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixTransportTaskTrack(BaseEntity transportTaskTrackAsBaseEntity){

		if( isChecked(transportTaskTrackAsBaseEntity) ){
			return this;
		}
		markAsChecked(transportTaskTrackAsBaseEntity);
		commonObjectPropertyCheck(transportTaskTrackAsBaseEntity,"id",this::checkIdOfTransportTaskTrack);
		commonObjectPropertyCheck(transportTaskTrackAsBaseEntity,"trackTime",this::checkTrackTimeOfTransportTaskTrack);
		commonObjectPropertyCheck(transportTaskTrackAsBaseEntity,"latitude",this::checkLatitudeOfTransportTaskTrack);
		commonObjectPropertyCheck(transportTaskTrackAsBaseEntity,"longitude",this::checkLongitudeOfTransportTaskTrack);
		commonObjectPropertyCheck(transportTaskTrackAsBaseEntity,"movement",this::checkMovementOfTransportTaskTrack);
		commonObjectPropertyCheck(transportTaskTrackAsBaseEntity,"version",this::checkVersionOfTransportTaskTrack);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixAccountSet(BaseEntity accountSetAsBaseEntity){

		if( isChecked(accountSetAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountSetAsBaseEntity);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"id",this::checkIdOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"name",this::checkNameOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"yearSet",this::checkYearSetOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"effectiveDate",this::checkEffectiveDateOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"accountingSystem",this::checkAccountingSystemOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"domesticCurrencyCode",this::checkDomesticCurrencyCodeOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"domesticCurrencyName",this::checkDomesticCurrencyNameOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"openingBank",this::checkOpeningBankOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"accountNumber",this::checkAccountNumberOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"countryCenter",this::checkCountryCenterOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"retailStore",this::checkRetailStoreOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"goodsSupplier",this::checkGoodsSupplierOfAccountSet);
		commonObjectPropertyAssign(accountSetAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"version",this::checkVersionOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"accountingSubjectList",this::checkAccountingSubjectListOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"accountingPeriodList",this::checkAccountingPeriodListOfAccountSet);
		commonObjectPropertyCheck(accountSetAsBaseEntity,"accountingDocumentTypeList",this::checkAccountingDocumentTypeListOfAccountSet);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixAccountingSubject(BaseEntity accountingSubjectAsBaseEntity){

		if( isChecked(accountingSubjectAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountingSubjectAsBaseEntity);
		commonObjectPropertyCheck(accountingSubjectAsBaseEntity,"id",this::checkIdOfAccountingSubject);
		commonObjectPropertyCheck(accountingSubjectAsBaseEntity,"accountingSubjectCode",this::checkAccountingSubjectCodeOfAccountingSubject);
		commonObjectPropertyCheck(accountingSubjectAsBaseEntity,"accountingSubjectName",this::checkAccountingSubjectNameOfAccountingSubject);
		commonObjectPropertyCheck(accountingSubjectAsBaseEntity,"accountingSubjectClassCode",this::checkAccountingSubjectClassCodeOfAccountingSubject);
		commonObjectPropertyCheck(accountingSubjectAsBaseEntity,"accountingSubjectClassName",this::checkAccountingSubjectClassNameOfAccountingSubject);
		commonObjectPropertyCheck(accountingSubjectAsBaseEntity,"accountSet",this::checkAccountSetOfAccountingSubject);
		commonObjectPropertyCheck(accountingSubjectAsBaseEntity,"version",this::checkVersionOfAccountingSubject);
		commonObjectPropertyCheck(accountingSubjectAsBaseEntity,"accountingDocumentLineList",this::checkAccountingDocumentLineListOfAccountingSubject);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixAccountingPeriod(BaseEntity accountingPeriodAsBaseEntity){

		if( isChecked(accountingPeriodAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountingPeriodAsBaseEntity);
		commonObjectPropertyCheck(accountingPeriodAsBaseEntity,"id",this::checkIdOfAccountingPeriod);
		commonObjectPropertyCheck(accountingPeriodAsBaseEntity,"name",this::checkNameOfAccountingPeriod);
		commonObjectPropertyCheck(accountingPeriodAsBaseEntity,"startDate",this::checkStartDateOfAccountingPeriod);
		commonObjectPropertyCheck(accountingPeriodAsBaseEntity,"endDate",this::checkEndDateOfAccountingPeriod);
		commonObjectPropertyCheck(accountingPeriodAsBaseEntity,"accountSet",this::checkAccountSetOfAccountingPeriod);
		commonObjectPropertyCheck(accountingPeriodAsBaseEntity,"version",this::checkVersionOfAccountingPeriod);
		commonObjectPropertyCheck(accountingPeriodAsBaseEntity,"accountingDocumentList",this::checkAccountingDocumentListOfAccountingPeriod);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixAccountingDocumentType(BaseEntity accountingDocumentTypeAsBaseEntity){

		if( isChecked(accountingDocumentTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountingDocumentTypeAsBaseEntity);
		commonObjectPropertyCheck(accountingDocumentTypeAsBaseEntity,"id",this::checkIdOfAccountingDocumentType);
		commonObjectPropertyCheck(accountingDocumentTypeAsBaseEntity,"name",this::checkNameOfAccountingDocumentType);
		commonObjectPropertyCheck(accountingDocumentTypeAsBaseEntity,"description",this::checkDescriptionOfAccountingDocumentType);
		commonObjectPropertyCheck(accountingDocumentTypeAsBaseEntity,"accountingPeriod",this::checkAccountingPeriodOfAccountingDocumentType);
		commonObjectPropertyCheck(accountingDocumentTypeAsBaseEntity,"version",this::checkVersionOfAccountingDocumentType);
		commonObjectPropertyCheck(accountingDocumentTypeAsBaseEntity,"accountingDocumentList",this::checkAccountingDocumentListOfAccountingDocumentType);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixAccountingDocument(BaseEntity accountingDocumentAsBaseEntity){

		if( isChecked(accountingDocumentAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountingDocumentAsBaseEntity);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"id",this::checkIdOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"name",this::checkNameOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"accountingDocumentDate",this::checkAccountingDocumentDateOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"accountingPeriod",this::checkAccountingPeriodOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"documentType",this::checkDocumentTypeOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"creation",this::checkCreationOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"confirmation",this::checkConfirmationOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"auditing",this::checkAuditingOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"posting",this::checkPostingOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"version",this::checkVersionOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"originalVoucherList",this::checkOriginalVoucherListOfAccountingDocument);
		commonObjectPropertyCheck(accountingDocumentAsBaseEntity,"accountingDocumentLineList",this::checkAccountingDocumentLineListOfAccountingDocument);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixAccountingDocumentCreation(BaseEntity accountingDocumentCreationAsBaseEntity){

		if( isChecked(accountingDocumentCreationAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountingDocumentCreationAsBaseEntity);
		commonObjectPropertyCheck(accountingDocumentCreationAsBaseEntity,"id",this::checkIdOfAccountingDocumentCreation);
		commonObjectPropertyCheck(accountingDocumentCreationAsBaseEntity,"who",this::checkWhoOfAccountingDocumentCreation);
		commonObjectPropertyCheck(accountingDocumentCreationAsBaseEntity,"comments",this::checkCommentsOfAccountingDocumentCreation);
		commonObjectPropertyCheck(accountingDocumentCreationAsBaseEntity,"makeDate",this::checkMakeDateOfAccountingDocumentCreation);
		commonObjectPropertyCheck(accountingDocumentCreationAsBaseEntity,"version",this::checkVersionOfAccountingDocumentCreation);
		commonObjectPropertyCheck(accountingDocumentCreationAsBaseEntity,"accountingDocumentList",this::checkAccountingDocumentListOfAccountingDocumentCreation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixAccountingDocumentConfirmation(BaseEntity accountingDocumentConfirmationAsBaseEntity){

		if( isChecked(accountingDocumentConfirmationAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountingDocumentConfirmationAsBaseEntity);
		commonObjectPropertyCheck(accountingDocumentConfirmationAsBaseEntity,"id",this::checkIdOfAccountingDocumentConfirmation);
		commonObjectPropertyCheck(accountingDocumentConfirmationAsBaseEntity,"who",this::checkWhoOfAccountingDocumentConfirmation);
		commonObjectPropertyCheck(accountingDocumentConfirmationAsBaseEntity,"comments",this::checkCommentsOfAccountingDocumentConfirmation);
		commonObjectPropertyCheck(accountingDocumentConfirmationAsBaseEntity,"makeDate",this::checkMakeDateOfAccountingDocumentConfirmation);
		commonObjectPropertyCheck(accountingDocumentConfirmationAsBaseEntity,"version",this::checkVersionOfAccountingDocumentConfirmation);
		commonObjectPropertyCheck(accountingDocumentConfirmationAsBaseEntity,"accountingDocumentList",this::checkAccountingDocumentListOfAccountingDocumentConfirmation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixAccountingDocumentAuditing(BaseEntity accountingDocumentAuditingAsBaseEntity){

		if( isChecked(accountingDocumentAuditingAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountingDocumentAuditingAsBaseEntity);
		commonObjectPropertyCheck(accountingDocumentAuditingAsBaseEntity,"id",this::checkIdOfAccountingDocumentAuditing);
		commonObjectPropertyCheck(accountingDocumentAuditingAsBaseEntity,"who",this::checkWhoOfAccountingDocumentAuditing);
		commonObjectPropertyCheck(accountingDocumentAuditingAsBaseEntity,"comments",this::checkCommentsOfAccountingDocumentAuditing);
		commonObjectPropertyCheck(accountingDocumentAuditingAsBaseEntity,"makeDate",this::checkMakeDateOfAccountingDocumentAuditing);
		commonObjectPropertyCheck(accountingDocumentAuditingAsBaseEntity,"version",this::checkVersionOfAccountingDocumentAuditing);
		commonObjectPropertyCheck(accountingDocumentAuditingAsBaseEntity,"accountingDocumentList",this::checkAccountingDocumentListOfAccountingDocumentAuditing);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixAccountingDocumentPosting(BaseEntity accountingDocumentPostingAsBaseEntity){

		if( isChecked(accountingDocumentPostingAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountingDocumentPostingAsBaseEntity);
		commonObjectPropertyCheck(accountingDocumentPostingAsBaseEntity,"id",this::checkIdOfAccountingDocumentPosting);
		commonObjectPropertyCheck(accountingDocumentPostingAsBaseEntity,"who",this::checkWhoOfAccountingDocumentPosting);
		commonObjectPropertyCheck(accountingDocumentPostingAsBaseEntity,"comments",this::checkCommentsOfAccountingDocumentPosting);
		commonObjectPropertyCheck(accountingDocumentPostingAsBaseEntity,"makeDate",this::checkMakeDateOfAccountingDocumentPosting);
		commonObjectPropertyCheck(accountingDocumentPostingAsBaseEntity,"version",this::checkVersionOfAccountingDocumentPosting);
		commonObjectPropertyCheck(accountingDocumentPostingAsBaseEntity,"accountingDocumentList",this::checkAccountingDocumentListOfAccountingDocumentPosting);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixOriginalVoucher(BaseEntity originalVoucherAsBaseEntity){

		if( isChecked(originalVoucherAsBaseEntity) ){
			return this;
		}
		markAsChecked(originalVoucherAsBaseEntity);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"id",this::checkIdOfOriginalVoucher);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"title",this::checkTitleOfOriginalVoucher);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"madeBy",this::checkMadeByOfOriginalVoucher);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"receivedBy",this::checkReceivedByOfOriginalVoucher);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"voucherType",this::checkVoucherTypeOfOriginalVoucher);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"voucherImage",this::checkVoucherImageOfOriginalVoucher);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"belongsTo",this::checkBelongsToOfOriginalVoucher);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"creation",this::checkCreationOfOriginalVoucher);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"confirmation",this::checkConfirmationOfOriginalVoucher);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"auditing",this::checkAuditingOfOriginalVoucher);
		commonObjectPropertyCheck(originalVoucherAsBaseEntity,"version",this::checkVersionOfOriginalVoucher);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixOriginalVoucherCreation(BaseEntity originalVoucherCreationAsBaseEntity){

		if( isChecked(originalVoucherCreationAsBaseEntity) ){
			return this;
		}
		markAsChecked(originalVoucherCreationAsBaseEntity);
		commonObjectPropertyCheck(originalVoucherCreationAsBaseEntity,"id",this::checkIdOfOriginalVoucherCreation);
		commonObjectPropertyCheck(originalVoucherCreationAsBaseEntity,"who",this::checkWhoOfOriginalVoucherCreation);
		commonObjectPropertyCheck(originalVoucherCreationAsBaseEntity,"comments",this::checkCommentsOfOriginalVoucherCreation);
		commonObjectPropertyCheck(originalVoucherCreationAsBaseEntity,"makeDate",this::checkMakeDateOfOriginalVoucherCreation);
		commonObjectPropertyCheck(originalVoucherCreationAsBaseEntity,"version",this::checkVersionOfOriginalVoucherCreation);
		commonObjectPropertyCheck(originalVoucherCreationAsBaseEntity,"originalVoucherList",this::checkOriginalVoucherListOfOriginalVoucherCreation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixOriginalVoucherConfirmation(BaseEntity originalVoucherConfirmationAsBaseEntity){

		if( isChecked(originalVoucherConfirmationAsBaseEntity) ){
			return this;
		}
		markAsChecked(originalVoucherConfirmationAsBaseEntity);
		commonObjectPropertyCheck(originalVoucherConfirmationAsBaseEntity,"id",this::checkIdOfOriginalVoucherConfirmation);
		commonObjectPropertyCheck(originalVoucherConfirmationAsBaseEntity,"who",this::checkWhoOfOriginalVoucherConfirmation);
		commonObjectPropertyCheck(originalVoucherConfirmationAsBaseEntity,"comments",this::checkCommentsOfOriginalVoucherConfirmation);
		commonObjectPropertyCheck(originalVoucherConfirmationAsBaseEntity,"makeDate",this::checkMakeDateOfOriginalVoucherConfirmation);
		commonObjectPropertyCheck(originalVoucherConfirmationAsBaseEntity,"version",this::checkVersionOfOriginalVoucherConfirmation);
		commonObjectPropertyCheck(originalVoucherConfirmationAsBaseEntity,"originalVoucherList",this::checkOriginalVoucherListOfOriginalVoucherConfirmation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixOriginalVoucherAuditing(BaseEntity originalVoucherAuditingAsBaseEntity){

		if( isChecked(originalVoucherAuditingAsBaseEntity) ){
			return this;
		}
		markAsChecked(originalVoucherAuditingAsBaseEntity);
		commonObjectPropertyCheck(originalVoucherAuditingAsBaseEntity,"id",this::checkIdOfOriginalVoucherAuditing);
		commonObjectPropertyCheck(originalVoucherAuditingAsBaseEntity,"who",this::checkWhoOfOriginalVoucherAuditing);
		commonObjectPropertyCheck(originalVoucherAuditingAsBaseEntity,"comments",this::checkCommentsOfOriginalVoucherAuditing);
		commonObjectPropertyCheck(originalVoucherAuditingAsBaseEntity,"makeDate",this::checkMakeDateOfOriginalVoucherAuditing);
		commonObjectPropertyCheck(originalVoucherAuditingAsBaseEntity,"version",this::checkVersionOfOriginalVoucherAuditing);
		commonObjectPropertyCheck(originalVoucherAuditingAsBaseEntity,"originalVoucherList",this::checkOriginalVoucherListOfOriginalVoucherAuditing);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixAccountingDocumentLine(BaseEntity accountingDocumentLineAsBaseEntity){

		if( isChecked(accountingDocumentLineAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountingDocumentLineAsBaseEntity);
		commonObjectPropertyCheck(accountingDocumentLineAsBaseEntity,"id",this::checkIdOfAccountingDocumentLine);
		commonObjectPropertyCheck(accountingDocumentLineAsBaseEntity,"name",this::checkNameOfAccountingDocumentLine);
		commonObjectPropertyCheck(accountingDocumentLineAsBaseEntity,"code",this::checkCodeOfAccountingDocumentLine);
		commonObjectPropertyCheck(accountingDocumentLineAsBaseEntity,"direct",this::checkDirectOfAccountingDocumentLine);
		commonObjectPropertyCheck(accountingDocumentLineAsBaseEntity,"amount",this::checkAmountOfAccountingDocumentLine);
		commonObjectPropertyCheck(accountingDocumentLineAsBaseEntity,"belongsTo",this::checkBelongsToOfAccountingDocumentLine);
		commonObjectPropertyCheck(accountingDocumentLineAsBaseEntity,"accountingSubject",this::checkAccountingSubjectOfAccountingDocumentLine);
		commonObjectPropertyCheck(accountingDocumentLineAsBaseEntity,"version",this::checkVersionOfAccountingDocumentLine);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixLevelOneDepartment(BaseEntity levelOneDepartmentAsBaseEntity){

		if( isChecked(levelOneDepartmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(levelOneDepartmentAsBaseEntity);
		commonObjectPropertyCheck(levelOneDepartmentAsBaseEntity,"id",this::checkIdOfLevelOneDepartment);
		commonObjectPropertyCheck(levelOneDepartmentAsBaseEntity,"belongsTo",this::checkBelongsToOfLevelOneDepartment);
		commonObjectPropertyCheck(levelOneDepartmentAsBaseEntity,"name",this::checkNameOfLevelOneDepartment);
		commonObjectPropertyCheck(levelOneDepartmentAsBaseEntity,"description",this::checkDescriptionOfLevelOneDepartment);
		commonObjectPropertyCheck(levelOneDepartmentAsBaseEntity,"manager",this::checkManagerOfLevelOneDepartment);
		commonObjectPropertyCheck(levelOneDepartmentAsBaseEntity,"founded",this::checkFoundedOfLevelOneDepartment);
		commonObjectPropertyCheck(levelOneDepartmentAsBaseEntity,"version",this::checkVersionOfLevelOneDepartment);
		commonObjectPropertyCheck(levelOneDepartmentAsBaseEntity,"levelTwoDepartmentList",this::checkLevelTwoDepartmentListOfLevelOneDepartment);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixLevelTwoDepartment(BaseEntity levelTwoDepartmentAsBaseEntity){

		if( isChecked(levelTwoDepartmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(levelTwoDepartmentAsBaseEntity);
		commonObjectPropertyCheck(levelTwoDepartmentAsBaseEntity,"id",this::checkIdOfLevelTwoDepartment);
		commonObjectPropertyCheck(levelTwoDepartmentAsBaseEntity,"belongsTo",this::checkBelongsToOfLevelTwoDepartment);
		commonObjectPropertyCheck(levelTwoDepartmentAsBaseEntity,"name",this::checkNameOfLevelTwoDepartment);
		commonObjectPropertyCheck(levelTwoDepartmentAsBaseEntity,"description",this::checkDescriptionOfLevelTwoDepartment);
		commonObjectPropertyCheck(levelTwoDepartmentAsBaseEntity,"founded",this::checkFoundedOfLevelTwoDepartment);
		commonObjectPropertyCheck(levelTwoDepartmentAsBaseEntity,"version",this::checkVersionOfLevelTwoDepartment);
		commonObjectPropertyCheck(levelTwoDepartmentAsBaseEntity,"levelThreeDepartmentList",this::checkLevelThreeDepartmentListOfLevelTwoDepartment);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixLevelThreeDepartment(BaseEntity levelThreeDepartmentAsBaseEntity){

		if( isChecked(levelThreeDepartmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(levelThreeDepartmentAsBaseEntity);
		commonObjectPropertyCheck(levelThreeDepartmentAsBaseEntity,"id",this::checkIdOfLevelThreeDepartment);
		commonObjectPropertyCheck(levelThreeDepartmentAsBaseEntity,"belongsTo",this::checkBelongsToOfLevelThreeDepartment);
		commonObjectPropertyCheck(levelThreeDepartmentAsBaseEntity,"name",this::checkNameOfLevelThreeDepartment);
		commonObjectPropertyCheck(levelThreeDepartmentAsBaseEntity,"description",this::checkDescriptionOfLevelThreeDepartment);
		commonObjectPropertyCheck(levelThreeDepartmentAsBaseEntity,"founded",this::checkFoundedOfLevelThreeDepartment);
		commonObjectPropertyCheck(levelThreeDepartmentAsBaseEntity,"version",this::checkVersionOfLevelThreeDepartment);
		commonObjectPropertyCheck(levelThreeDepartmentAsBaseEntity,"employeeList",this::checkEmployeeListOfLevelThreeDepartment);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSkillType(BaseEntity skillTypeAsBaseEntity){

		if( isChecked(skillTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(skillTypeAsBaseEntity);
		commonObjectPropertyCheck(skillTypeAsBaseEntity,"id",this::checkIdOfSkillType);
		commonObjectPropertyCheck(skillTypeAsBaseEntity,"code",this::checkCodeOfSkillType);
		commonObjectPropertyCheck(skillTypeAsBaseEntity,"company",this::checkCompanyOfSkillType);
		commonObjectPropertyCheck(skillTypeAsBaseEntity,"description",this::checkDescriptionOfSkillType);
		commonObjectPropertyCheck(skillTypeAsBaseEntity,"version",this::checkVersionOfSkillType);
		commonObjectPropertyCheck(skillTypeAsBaseEntity,"employeeSkillList",this::checkEmployeeSkillListOfSkillType);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixResponsibilityType(BaseEntity responsibilityTypeAsBaseEntity){

		if( isChecked(responsibilityTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(responsibilityTypeAsBaseEntity);
		commonObjectPropertyCheck(responsibilityTypeAsBaseEntity,"id",this::checkIdOfResponsibilityType);
		commonObjectPropertyCheck(responsibilityTypeAsBaseEntity,"code",this::checkCodeOfResponsibilityType);
		commonObjectPropertyCheck(responsibilityTypeAsBaseEntity,"company",this::checkCompanyOfResponsibilityType);
		commonObjectPropertyCheck(responsibilityTypeAsBaseEntity,"baseDescription",this::checkBaseDescriptionOfResponsibilityType);
		commonObjectPropertyCheck(responsibilityTypeAsBaseEntity,"detailDescription",this::checkDetailDescriptionOfResponsibilityType);
		commonObjectPropertyCheck(responsibilityTypeAsBaseEntity,"version",this::checkVersionOfResponsibilityType);
		commonObjectPropertyCheck(responsibilityTypeAsBaseEntity,"employeeList",this::checkEmployeeListOfResponsibilityType);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixTerminationReason(BaseEntity terminationReasonAsBaseEntity){

		if( isChecked(terminationReasonAsBaseEntity) ){
			return this;
		}
		markAsChecked(terminationReasonAsBaseEntity);
		commonObjectPropertyCheck(terminationReasonAsBaseEntity,"id",this::checkIdOfTerminationReason);
		commonObjectPropertyCheck(terminationReasonAsBaseEntity,"code",this::checkCodeOfTerminationReason);
		commonObjectPropertyCheck(terminationReasonAsBaseEntity,"company",this::checkCompanyOfTerminationReason);
		commonObjectPropertyCheck(terminationReasonAsBaseEntity,"description",this::checkDescriptionOfTerminationReason);
		commonObjectPropertyCheck(terminationReasonAsBaseEntity,"version",this::checkVersionOfTerminationReason);
		commonObjectPropertyCheck(terminationReasonAsBaseEntity,"terminationList",this::checkTerminationListOfTerminationReason);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixTerminationType(BaseEntity terminationTypeAsBaseEntity){

		if( isChecked(terminationTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(terminationTypeAsBaseEntity);
		commonObjectPropertyCheck(terminationTypeAsBaseEntity,"id",this::checkIdOfTerminationType);
		commonObjectPropertyCheck(terminationTypeAsBaseEntity,"code",this::checkCodeOfTerminationType);
		commonObjectPropertyCheck(terminationTypeAsBaseEntity,"company",this::checkCompanyOfTerminationType);
		commonObjectPropertyCheck(terminationTypeAsBaseEntity,"baseDescription",this::checkBaseDescriptionOfTerminationType);
		commonObjectPropertyCheck(terminationTypeAsBaseEntity,"detailDescription",this::checkDetailDescriptionOfTerminationType);
		commonObjectPropertyCheck(terminationTypeAsBaseEntity,"version",this::checkVersionOfTerminationType);
		commonObjectPropertyCheck(terminationTypeAsBaseEntity,"terminationList",this::checkTerminationListOfTerminationType);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixOccupationType(BaseEntity occupationTypeAsBaseEntity){

		if( isChecked(occupationTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(occupationTypeAsBaseEntity);
		commonObjectPropertyCheck(occupationTypeAsBaseEntity,"id",this::checkIdOfOccupationType);
		commonObjectPropertyCheck(occupationTypeAsBaseEntity,"code",this::checkCodeOfOccupationType);
		commonObjectPropertyCheck(occupationTypeAsBaseEntity,"company",this::checkCompanyOfOccupationType);
		commonObjectPropertyCheck(occupationTypeAsBaseEntity,"description",this::checkDescriptionOfOccupationType);
		commonObjectPropertyCheck(occupationTypeAsBaseEntity,"detailDescription",this::checkDetailDescriptionOfOccupationType);
		commonObjectPropertyCheck(occupationTypeAsBaseEntity,"version",this::checkVersionOfOccupationType);
		commonObjectPropertyCheck(occupationTypeAsBaseEntity,"employeeList",this::checkEmployeeListOfOccupationType);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixLeaveType(BaseEntity leaveTypeAsBaseEntity){

		if( isChecked(leaveTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(leaveTypeAsBaseEntity);
		commonObjectPropertyCheck(leaveTypeAsBaseEntity,"id",this::checkIdOfLeaveType);
		commonObjectPropertyCheck(leaveTypeAsBaseEntity,"code",this::checkCodeOfLeaveType);
		commonObjectPropertyCheck(leaveTypeAsBaseEntity,"company",this::checkCompanyOfLeaveType);
		commonObjectPropertyCheck(leaveTypeAsBaseEntity,"description",this::checkDescriptionOfLeaveType);
		commonObjectPropertyCheck(leaveTypeAsBaseEntity,"detailDescription",this::checkDetailDescriptionOfLeaveType);
		commonObjectPropertyCheck(leaveTypeAsBaseEntity,"version",this::checkVersionOfLeaveType);
		commonObjectPropertyCheck(leaveTypeAsBaseEntity,"employeeLeaveList",this::checkEmployeeLeaveListOfLeaveType);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixSalaryGrade(BaseEntity salaryGradeAsBaseEntity){

		if( isChecked(salaryGradeAsBaseEntity) ){
			return this;
		}
		markAsChecked(salaryGradeAsBaseEntity);
		commonObjectPropertyCheck(salaryGradeAsBaseEntity,"id",this::checkIdOfSalaryGrade);
		commonObjectPropertyCheck(salaryGradeAsBaseEntity,"code",this::checkCodeOfSalaryGrade);
		commonObjectPropertyCheck(salaryGradeAsBaseEntity,"company",this::checkCompanyOfSalaryGrade);
		commonObjectPropertyCheck(salaryGradeAsBaseEntity,"name",this::checkNameOfSalaryGrade);
		commonObjectPropertyCheck(salaryGradeAsBaseEntity,"detailDescription",this::checkDetailDescriptionOfSalaryGrade);
		commonObjectPropertyCheck(salaryGradeAsBaseEntity,"version",this::checkVersionOfSalaryGrade);
		commonObjectPropertyCheck(salaryGradeAsBaseEntity,"employeeList",this::checkEmployeeListOfSalaryGrade);
		commonObjectPropertyCheck(salaryGradeAsBaseEntity,"employeeSalarySheetList",this::checkEmployeeSalarySheetListOfSalaryGrade);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixInterviewType(BaseEntity interviewTypeAsBaseEntity){

		if( isChecked(interviewTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(interviewTypeAsBaseEntity);
		commonObjectPropertyCheck(interviewTypeAsBaseEntity,"id",this::checkIdOfInterviewType);
		commonObjectPropertyCheck(interviewTypeAsBaseEntity,"code",this::checkCodeOfInterviewType);
		commonObjectPropertyCheck(interviewTypeAsBaseEntity,"company",this::checkCompanyOfInterviewType);
		commonObjectPropertyCheck(interviewTypeAsBaseEntity,"description",this::checkDescriptionOfInterviewType);
		commonObjectPropertyCheck(interviewTypeAsBaseEntity,"detailDescription",this::checkDetailDescriptionOfInterviewType);
		commonObjectPropertyCheck(interviewTypeAsBaseEntity,"version",this::checkVersionOfInterviewType);
		commonObjectPropertyCheck(interviewTypeAsBaseEntity,"employeeInterviewList",this::checkEmployeeInterviewListOfInterviewType);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixTrainingCourseType(BaseEntity trainingCourseTypeAsBaseEntity){

		if( isChecked(trainingCourseTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(trainingCourseTypeAsBaseEntity);
		commonObjectPropertyCheck(trainingCourseTypeAsBaseEntity,"id",this::checkIdOfTrainingCourseType);
		commonObjectPropertyCheck(trainingCourseTypeAsBaseEntity,"code",this::checkCodeOfTrainingCourseType);
		commonObjectPropertyCheck(trainingCourseTypeAsBaseEntity,"company",this::checkCompanyOfTrainingCourseType);
		commonObjectPropertyCheck(trainingCourseTypeAsBaseEntity,"name",this::checkNameOfTrainingCourseType);
		commonObjectPropertyCheck(trainingCourseTypeAsBaseEntity,"description",this::checkDescriptionOfTrainingCourseType);
		commonObjectPropertyCheck(trainingCourseTypeAsBaseEntity,"version",this::checkVersionOfTrainingCourseType);
		commonObjectPropertyCheck(trainingCourseTypeAsBaseEntity,"companyTrainingList",this::checkCompanyTrainingListOfTrainingCourseType);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixPublicHoliday(BaseEntity publicHolidayAsBaseEntity){

		if( isChecked(publicHolidayAsBaseEntity) ){
			return this;
		}
		markAsChecked(publicHolidayAsBaseEntity);
		commonObjectPropertyCheck(publicHolidayAsBaseEntity,"id",this::checkIdOfPublicHoliday);
		commonObjectPropertyCheck(publicHolidayAsBaseEntity,"code",this::checkCodeOfPublicHoliday);
		commonObjectPropertyCheck(publicHolidayAsBaseEntity,"company",this::checkCompanyOfPublicHoliday);
		commonObjectPropertyCheck(publicHolidayAsBaseEntity,"name",this::checkNameOfPublicHoliday);
		commonObjectPropertyCheck(publicHolidayAsBaseEntity,"description",this::checkDescriptionOfPublicHoliday);
		commonObjectPropertyCheck(publicHolidayAsBaseEntity,"version",this::checkVersionOfPublicHoliday);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixTermination(BaseEntity terminationAsBaseEntity){

		if( isChecked(terminationAsBaseEntity) ){
			return this;
		}
		markAsChecked(terminationAsBaseEntity);
		commonObjectPropertyCheck(terminationAsBaseEntity,"id",this::checkIdOfTermination);
		commonObjectPropertyCheck(terminationAsBaseEntity,"reason",this::checkReasonOfTermination);
		commonObjectPropertyCheck(terminationAsBaseEntity,"type",this::checkTypeOfTermination);
		commonObjectPropertyCheck(terminationAsBaseEntity,"comment",this::checkCommentOfTermination);
		commonObjectPropertyCheck(terminationAsBaseEntity,"version",this::checkVersionOfTermination);
		commonObjectPropertyCheck(terminationAsBaseEntity,"employeeList",this::checkEmployeeListOfTermination);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixView(BaseEntity viewAsBaseEntity){

		if( isChecked(viewAsBaseEntity) ){
			return this;
		}
		markAsChecked(viewAsBaseEntity);
		commonObjectPropertyCheck(viewAsBaseEntity,"id",this::checkIdOfView);
		commonObjectPropertyCheck(viewAsBaseEntity,"who",this::checkWhoOfView);
		commonObjectPropertyCheck(viewAsBaseEntity,"assessment",this::checkAssessmentOfView);
		commonObjectPropertyCheck(viewAsBaseEntity,"interviewTime",this::checkInterviewTimeOfView);
		commonObjectPropertyCheck(viewAsBaseEntity,"version",this::checkVersionOfView);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployee(BaseEntity employeeAsBaseEntity){

		if( isChecked(employeeAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeAsBaseEntity);
		commonObjectPropertyCheck(employeeAsBaseEntity,"id",this::checkIdOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"company",this::checkCompanyOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"title",this::checkTitleOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"department",this::checkDepartmentOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"familyName",this::checkFamilyNameOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"givenName",this::checkGivenNameOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"email",this::checkEmailOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"city",this::checkCityOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"address",this::checkAddressOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"cellPhone",this::checkCellPhoneOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"occupation",this::checkOccupationOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"responsibleFor",this::checkResponsibleForOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"currentSalaryGrade",this::checkCurrentSalaryGradeOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"salaryAccount",this::checkSalaryAccountOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"jobApplication",this::checkJobApplicationOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"professionInterview",this::checkProfessionInterviewOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"hrInterview",this::checkHrInterviewOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"offerApproval",this::checkOfferApprovalOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"offerAcceptance",this::checkOfferAcceptanceOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeBoarding",this::checkEmployeeBoardingOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"termination",this::checkTerminationOfEmployee);
		commonObjectPropertyAssign(employeeAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"version",this::checkVersionOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeCompanyTrainingList",this::checkEmployeeCompanyTrainingListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeSkillList",this::checkEmployeeSkillListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeePerformanceList",this::checkEmployeePerformanceListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeWorkExperienceList",this::checkEmployeeWorkExperienceListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeLeaveList",this::checkEmployeeLeaveListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeInterviewList",this::checkEmployeeInterviewListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeAttendanceList",this::checkEmployeeAttendanceListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeQualifierList",this::checkEmployeeQualifierListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeEducationList",this::checkEmployeeEducationListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeAwardList",this::checkEmployeeAwardListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"employeeSalarySheetList",this::checkEmployeeSalarySheetListOfEmployee);
		commonObjectPropertyCheck(employeeAsBaseEntity,"payingOffList",this::checkPayingOffListOfEmployee);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixJobApplication(BaseEntity jobApplicationAsBaseEntity){

		if( isChecked(jobApplicationAsBaseEntity) ){
			return this;
		}
		markAsChecked(jobApplicationAsBaseEntity);
		commonObjectPropertyCheck(jobApplicationAsBaseEntity,"id",this::checkIdOfJobApplication);
		commonObjectPropertyCheck(jobApplicationAsBaseEntity,"applicationTime",this::checkApplicationTimeOfJobApplication);
		commonObjectPropertyCheck(jobApplicationAsBaseEntity,"who",this::checkWhoOfJobApplication);
		commonObjectPropertyCheck(jobApplicationAsBaseEntity,"comments",this::checkCommentsOfJobApplication);
		commonObjectPropertyCheck(jobApplicationAsBaseEntity,"version",this::checkVersionOfJobApplication);
		commonObjectPropertyCheck(jobApplicationAsBaseEntity,"employeeList",this::checkEmployeeListOfJobApplication);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixProfessionInterview(BaseEntity professionInterviewAsBaseEntity){

		if( isChecked(professionInterviewAsBaseEntity) ){
			return this;
		}
		markAsChecked(professionInterviewAsBaseEntity);
		commonObjectPropertyCheck(professionInterviewAsBaseEntity,"id",this::checkIdOfProfessionInterview);
		commonObjectPropertyCheck(professionInterviewAsBaseEntity,"who",this::checkWhoOfProfessionInterview);
		commonObjectPropertyCheck(professionInterviewAsBaseEntity,"interviewTime",this::checkInterviewTimeOfProfessionInterview);
		commonObjectPropertyCheck(professionInterviewAsBaseEntity,"comments",this::checkCommentsOfProfessionInterview);
		commonObjectPropertyCheck(professionInterviewAsBaseEntity,"version",this::checkVersionOfProfessionInterview);
		commonObjectPropertyCheck(professionInterviewAsBaseEntity,"employeeList",this::checkEmployeeListOfProfessionInterview);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixHrInterview(BaseEntity hrInterviewAsBaseEntity){

		if( isChecked(hrInterviewAsBaseEntity) ){
			return this;
		}
		markAsChecked(hrInterviewAsBaseEntity);
		commonObjectPropertyCheck(hrInterviewAsBaseEntity,"id",this::checkIdOfHrInterview);
		commonObjectPropertyCheck(hrInterviewAsBaseEntity,"who",this::checkWhoOfHrInterview);
		commonObjectPropertyCheck(hrInterviewAsBaseEntity,"interviewTime",this::checkInterviewTimeOfHrInterview);
		commonObjectPropertyCheck(hrInterviewAsBaseEntity,"comments",this::checkCommentsOfHrInterview);
		commonObjectPropertyCheck(hrInterviewAsBaseEntity,"version",this::checkVersionOfHrInterview);
		commonObjectPropertyCheck(hrInterviewAsBaseEntity,"employeeList",this::checkEmployeeListOfHrInterview);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixOfferApproval(BaseEntity offerApprovalAsBaseEntity){

		if( isChecked(offerApprovalAsBaseEntity) ){
			return this;
		}
		markAsChecked(offerApprovalAsBaseEntity);
		commonObjectPropertyCheck(offerApprovalAsBaseEntity,"id",this::checkIdOfOfferApproval);
		commonObjectPropertyCheck(offerApprovalAsBaseEntity,"who",this::checkWhoOfOfferApproval);
		commonObjectPropertyCheck(offerApprovalAsBaseEntity,"approveTime",this::checkApproveTimeOfOfferApproval);
		commonObjectPropertyCheck(offerApprovalAsBaseEntity,"comments",this::checkCommentsOfOfferApproval);
		commonObjectPropertyCheck(offerApprovalAsBaseEntity,"version",this::checkVersionOfOfferApproval);
		commonObjectPropertyCheck(offerApprovalAsBaseEntity,"employeeList",this::checkEmployeeListOfOfferApproval);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixOfferAcceptance(BaseEntity offerAcceptanceAsBaseEntity){

		if( isChecked(offerAcceptanceAsBaseEntity) ){
			return this;
		}
		markAsChecked(offerAcceptanceAsBaseEntity);
		commonObjectPropertyCheck(offerAcceptanceAsBaseEntity,"id",this::checkIdOfOfferAcceptance);
		commonObjectPropertyCheck(offerAcceptanceAsBaseEntity,"who",this::checkWhoOfOfferAcceptance);
		commonObjectPropertyCheck(offerAcceptanceAsBaseEntity,"acceptTime",this::checkAcceptTimeOfOfferAcceptance);
		commonObjectPropertyCheck(offerAcceptanceAsBaseEntity,"comments",this::checkCommentsOfOfferAcceptance);
		commonObjectPropertyCheck(offerAcceptanceAsBaseEntity,"version",this::checkVersionOfOfferAcceptance);
		commonObjectPropertyCheck(offerAcceptanceAsBaseEntity,"employeeList",this::checkEmployeeListOfOfferAcceptance);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeBoarding(BaseEntity employeeBoardingAsBaseEntity){

		if( isChecked(employeeBoardingAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeBoardingAsBaseEntity);
		commonObjectPropertyCheck(employeeBoardingAsBaseEntity,"id",this::checkIdOfEmployeeBoarding);
		commonObjectPropertyCheck(employeeBoardingAsBaseEntity,"who",this::checkWhoOfEmployeeBoarding);
		commonObjectPropertyCheck(employeeBoardingAsBaseEntity,"employTime",this::checkEmployTimeOfEmployeeBoarding);
		commonObjectPropertyCheck(employeeBoardingAsBaseEntity,"comments",this::checkCommentsOfEmployeeBoarding);
		commonObjectPropertyCheck(employeeBoardingAsBaseEntity,"version",this::checkVersionOfEmployeeBoarding);
		commonObjectPropertyCheck(employeeBoardingAsBaseEntity,"employeeList",this::checkEmployeeListOfEmployeeBoarding);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixInstructor(BaseEntity instructorAsBaseEntity){

		if( isChecked(instructorAsBaseEntity) ){
			return this;
		}
		markAsChecked(instructorAsBaseEntity);
		commonObjectPropertyCheck(instructorAsBaseEntity,"id",this::checkIdOfInstructor);
		commonObjectPropertyCheck(instructorAsBaseEntity,"title",this::checkTitleOfInstructor);
		commonObjectPropertyCheck(instructorAsBaseEntity,"familyName",this::checkFamilyNameOfInstructor);
		commonObjectPropertyCheck(instructorAsBaseEntity,"givenName",this::checkGivenNameOfInstructor);
		commonObjectPropertyCheck(instructorAsBaseEntity,"cellPhone",this::checkCellPhoneOfInstructor);
		commonObjectPropertyCheck(instructorAsBaseEntity,"email",this::checkEmailOfInstructor);
		commonObjectPropertyCheck(instructorAsBaseEntity,"company",this::checkCompanyOfInstructor);
		commonObjectPropertyCheck(instructorAsBaseEntity,"introduction",this::checkIntroductionOfInstructor);
		commonObjectPropertyAssign(instructorAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfInstructor);
		commonObjectPropertyCheck(instructorAsBaseEntity,"version",this::checkVersionOfInstructor);
		commonObjectPropertyCheck(instructorAsBaseEntity,"companyTrainingList",this::checkCompanyTrainingListOfInstructor);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixCompanyTraining(BaseEntity companyTrainingAsBaseEntity){

		if( isChecked(companyTrainingAsBaseEntity) ){
			return this;
		}
		markAsChecked(companyTrainingAsBaseEntity);
		commonObjectPropertyCheck(companyTrainingAsBaseEntity,"id",this::checkIdOfCompanyTraining);
		commonObjectPropertyCheck(companyTrainingAsBaseEntity,"title",this::checkTitleOfCompanyTraining);
		commonObjectPropertyCheck(companyTrainingAsBaseEntity,"company",this::checkCompanyOfCompanyTraining);
		commonObjectPropertyCheck(companyTrainingAsBaseEntity,"instructor",this::checkInstructorOfCompanyTraining);
		commonObjectPropertyCheck(companyTrainingAsBaseEntity,"trainingCourseType",this::checkTrainingCourseTypeOfCompanyTraining);
		commonObjectPropertyCheck(companyTrainingAsBaseEntity,"timeStart",this::checkTimeStartOfCompanyTraining);
		commonObjectPropertyCheck(companyTrainingAsBaseEntity,"durationHours",this::checkDurationHoursOfCompanyTraining);
		commonObjectPropertyAssign(companyTrainingAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfCompanyTraining);
		commonObjectPropertyCheck(companyTrainingAsBaseEntity,"version",this::checkVersionOfCompanyTraining);
		commonObjectPropertyCheck(companyTrainingAsBaseEntity,"employeeCompanyTrainingList",this::checkEmployeeCompanyTrainingListOfCompanyTraining);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixScoring(BaseEntity scoringAsBaseEntity){

		if( isChecked(scoringAsBaseEntity) ){
			return this;
		}
		markAsChecked(scoringAsBaseEntity);
		commonObjectPropertyCheck(scoringAsBaseEntity,"id",this::checkIdOfScoring);
		commonObjectPropertyCheck(scoringAsBaseEntity,"scoredBy",this::checkScoredByOfScoring);
		commonObjectPropertyCheck(scoringAsBaseEntity,"score",this::checkScoreOfScoring);
		commonObjectPropertyCheck(scoringAsBaseEntity,"comment",this::checkCommentOfScoring);
		commonObjectPropertyCheck(scoringAsBaseEntity,"version",this::checkVersionOfScoring);
		commonObjectPropertyCheck(scoringAsBaseEntity,"employeeCompanyTrainingList",this::checkEmployeeCompanyTrainingListOfScoring);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeCompanyTraining(BaseEntity employeeCompanyTrainingAsBaseEntity){

		if( isChecked(employeeCompanyTrainingAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeCompanyTrainingAsBaseEntity);
		commonObjectPropertyCheck(employeeCompanyTrainingAsBaseEntity,"id",this::checkIdOfEmployeeCompanyTraining);
		commonObjectPropertyCheck(employeeCompanyTrainingAsBaseEntity,"employee",this::checkEmployeeOfEmployeeCompanyTraining);
		commonObjectPropertyCheck(employeeCompanyTrainingAsBaseEntity,"training",this::checkTrainingOfEmployeeCompanyTraining);
		commonObjectPropertyCheck(employeeCompanyTrainingAsBaseEntity,"scoring",this::checkScoringOfEmployeeCompanyTraining);
		commonObjectPropertyCheck(employeeCompanyTrainingAsBaseEntity,"version",this::checkVersionOfEmployeeCompanyTraining);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeSkill(BaseEntity employeeSkillAsBaseEntity){

		if( isChecked(employeeSkillAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeSkillAsBaseEntity);
		commonObjectPropertyCheck(employeeSkillAsBaseEntity,"id",this::checkIdOfEmployeeSkill);
		commonObjectPropertyCheck(employeeSkillAsBaseEntity,"employee",this::checkEmployeeOfEmployeeSkill);
		commonObjectPropertyCheck(employeeSkillAsBaseEntity,"skillType",this::checkSkillTypeOfEmployeeSkill);
		commonObjectPropertyCheck(employeeSkillAsBaseEntity,"description",this::checkDescriptionOfEmployeeSkill);
		commonObjectPropertyCheck(employeeSkillAsBaseEntity,"version",this::checkVersionOfEmployeeSkill);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeePerformance(BaseEntity employeePerformanceAsBaseEntity){

		if( isChecked(employeePerformanceAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeePerformanceAsBaseEntity);
		commonObjectPropertyCheck(employeePerformanceAsBaseEntity,"id",this::checkIdOfEmployeePerformance);
		commonObjectPropertyCheck(employeePerformanceAsBaseEntity,"employee",this::checkEmployeeOfEmployeePerformance);
		commonObjectPropertyCheck(employeePerformanceAsBaseEntity,"performanceComment",this::checkPerformanceCommentOfEmployeePerformance);
		commonObjectPropertyCheck(employeePerformanceAsBaseEntity,"version",this::checkVersionOfEmployeePerformance);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeWorkExperience(BaseEntity employeeWorkExperienceAsBaseEntity){

		if( isChecked(employeeWorkExperienceAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeWorkExperienceAsBaseEntity);
		commonObjectPropertyCheck(employeeWorkExperienceAsBaseEntity,"id",this::checkIdOfEmployeeWorkExperience);
		commonObjectPropertyCheck(employeeWorkExperienceAsBaseEntity,"employee",this::checkEmployeeOfEmployeeWorkExperience);
		commonObjectPropertyCheck(employeeWorkExperienceAsBaseEntity,"start",this::checkStartOfEmployeeWorkExperience);
		commonObjectPropertyCheck(employeeWorkExperienceAsBaseEntity,"end",this::checkEndOfEmployeeWorkExperience);
		commonObjectPropertyCheck(employeeWorkExperienceAsBaseEntity,"company",this::checkCompanyOfEmployeeWorkExperience);
		commonObjectPropertyCheck(employeeWorkExperienceAsBaseEntity,"description",this::checkDescriptionOfEmployeeWorkExperience);
		commonObjectPropertyCheck(employeeWorkExperienceAsBaseEntity,"version",this::checkVersionOfEmployeeWorkExperience);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeLeave(BaseEntity employeeLeaveAsBaseEntity){

		if( isChecked(employeeLeaveAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeLeaveAsBaseEntity);
		commonObjectPropertyCheck(employeeLeaveAsBaseEntity,"id",this::checkIdOfEmployeeLeave);
		commonObjectPropertyCheck(employeeLeaveAsBaseEntity,"who",this::checkWhoOfEmployeeLeave);
		commonObjectPropertyCheck(employeeLeaveAsBaseEntity,"type",this::checkTypeOfEmployeeLeave);
		commonObjectPropertyCheck(employeeLeaveAsBaseEntity,"leaveDurationHour",this::checkLeaveDurationHourOfEmployeeLeave);
		commonObjectPropertyCheck(employeeLeaveAsBaseEntity,"remark",this::checkRemarkOfEmployeeLeave);
		commonObjectPropertyCheck(employeeLeaveAsBaseEntity,"version",this::checkVersionOfEmployeeLeave);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeInterview(BaseEntity employeeInterviewAsBaseEntity){

		if( isChecked(employeeInterviewAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeInterviewAsBaseEntity);
		commonObjectPropertyCheck(employeeInterviewAsBaseEntity,"id",this::checkIdOfEmployeeInterview);
		commonObjectPropertyCheck(employeeInterviewAsBaseEntity,"employee",this::checkEmployeeOfEmployeeInterview);
		commonObjectPropertyCheck(employeeInterviewAsBaseEntity,"interviewType",this::checkInterviewTypeOfEmployeeInterview);
		commonObjectPropertyCheck(employeeInterviewAsBaseEntity,"remark",this::checkRemarkOfEmployeeInterview);
		commonObjectPropertyCheck(employeeInterviewAsBaseEntity,"version",this::checkVersionOfEmployeeInterview);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeAttendance(BaseEntity employeeAttendanceAsBaseEntity){

		if( isChecked(employeeAttendanceAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeAttendanceAsBaseEntity);
		commonObjectPropertyCheck(employeeAttendanceAsBaseEntity,"id",this::checkIdOfEmployeeAttendance);
		commonObjectPropertyCheck(employeeAttendanceAsBaseEntity,"employee",this::checkEmployeeOfEmployeeAttendance);
		commonObjectPropertyCheck(employeeAttendanceAsBaseEntity,"enterTime",this::checkEnterTimeOfEmployeeAttendance);
		commonObjectPropertyCheck(employeeAttendanceAsBaseEntity,"leaveTime",this::checkLeaveTimeOfEmployeeAttendance);
		commonObjectPropertyCheck(employeeAttendanceAsBaseEntity,"durationHours",this::checkDurationHoursOfEmployeeAttendance);
		commonObjectPropertyCheck(employeeAttendanceAsBaseEntity,"remark",this::checkRemarkOfEmployeeAttendance);
		commonObjectPropertyCheck(employeeAttendanceAsBaseEntity,"version",this::checkVersionOfEmployeeAttendance);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeQualifier(BaseEntity employeeQualifierAsBaseEntity){

		if( isChecked(employeeQualifierAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeQualifierAsBaseEntity);
		commonObjectPropertyCheck(employeeQualifierAsBaseEntity,"id",this::checkIdOfEmployeeQualifier);
		commonObjectPropertyCheck(employeeQualifierAsBaseEntity,"employee",this::checkEmployeeOfEmployeeQualifier);
		commonObjectPropertyCheck(employeeQualifierAsBaseEntity,"qualifiedTime",this::checkQualifiedTimeOfEmployeeQualifier);
		commonObjectPropertyCheck(employeeQualifierAsBaseEntity,"type",this::checkTypeOfEmployeeQualifier);
		commonObjectPropertyCheck(employeeQualifierAsBaseEntity,"level",this::checkLevelOfEmployeeQualifier);
		commonObjectPropertyCheck(employeeQualifierAsBaseEntity,"remark",this::checkRemarkOfEmployeeQualifier);
		commonObjectPropertyCheck(employeeQualifierAsBaseEntity,"version",this::checkVersionOfEmployeeQualifier);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeEducation(BaseEntity employeeEducationAsBaseEntity){

		if( isChecked(employeeEducationAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeEducationAsBaseEntity);
		commonObjectPropertyCheck(employeeEducationAsBaseEntity,"id",this::checkIdOfEmployeeEducation);
		commonObjectPropertyCheck(employeeEducationAsBaseEntity,"employee",this::checkEmployeeOfEmployeeEducation);
		commonObjectPropertyCheck(employeeEducationAsBaseEntity,"completeTime",this::checkCompleteTimeOfEmployeeEducation);
		commonObjectPropertyCheck(employeeEducationAsBaseEntity,"type",this::checkTypeOfEmployeeEducation);
		commonObjectPropertyCheck(employeeEducationAsBaseEntity,"remark",this::checkRemarkOfEmployeeEducation);
		commonObjectPropertyCheck(employeeEducationAsBaseEntity,"version",this::checkVersionOfEmployeeEducation);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeAward(BaseEntity employeeAwardAsBaseEntity){

		if( isChecked(employeeAwardAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeAwardAsBaseEntity);
		commonObjectPropertyCheck(employeeAwardAsBaseEntity,"id",this::checkIdOfEmployeeAward);
		commonObjectPropertyCheck(employeeAwardAsBaseEntity,"employee",this::checkEmployeeOfEmployeeAward);
		commonObjectPropertyCheck(employeeAwardAsBaseEntity,"completeTime",this::checkCompleteTimeOfEmployeeAward);
		commonObjectPropertyCheck(employeeAwardAsBaseEntity,"type",this::checkTypeOfEmployeeAward);
		commonObjectPropertyCheck(employeeAwardAsBaseEntity,"remark",this::checkRemarkOfEmployeeAward);
		commonObjectPropertyCheck(employeeAwardAsBaseEntity,"version",this::checkVersionOfEmployeeAward);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixEmployeeSalarySheet(BaseEntity employeeSalarySheetAsBaseEntity){

		if( isChecked(employeeSalarySheetAsBaseEntity) ){
			return this;
		}
		markAsChecked(employeeSalarySheetAsBaseEntity);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"id",this::checkIdOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"employee",this::checkEmployeeOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"currentSalaryGrade",this::checkCurrentSalaryGradeOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"baseSalary",this::checkBaseSalaryOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"bonus",this::checkBonusOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"reward",this::checkRewardOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"personalTax",this::checkPersonalTaxOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"socialSecurity",this::checkSocialSecurityOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"housingFound",this::checkHousingFoundOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"jobInsurance",this::checkJobInsuranceOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"payingOff",this::checkPayingOffOfEmployeeSalarySheet);
		commonObjectPropertyCheck(employeeSalarySheetAsBaseEntity,"version",this::checkVersionOfEmployeeSalarySheet);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixPayingOff(BaseEntity payingOffAsBaseEntity){

		if( isChecked(payingOffAsBaseEntity) ){
			return this;
		}
		markAsChecked(payingOffAsBaseEntity);
		commonObjectPropertyCheck(payingOffAsBaseEntity,"id",this::checkIdOfPayingOff);
		commonObjectPropertyCheck(payingOffAsBaseEntity,"who",this::checkWhoOfPayingOff);
		commonObjectPropertyCheck(payingOffAsBaseEntity,"paidFor",this::checkPaidForOfPayingOff);
		commonObjectPropertyCheck(payingOffAsBaseEntity,"paidTime",this::checkPaidTimeOfPayingOff);
		commonObjectPropertyCheck(payingOffAsBaseEntity,"amount",this::checkAmountOfPayingOff);
		commonObjectPropertyCheck(payingOffAsBaseEntity,"version",this::checkVersionOfPayingOff);
		commonObjectPropertyCheck(payingOffAsBaseEntity,"employeeSalarySheetList",this::checkEmployeeSalarySheetListOfPayingOff);
		return this;

	}

	public YoubenbenObjectChecker checkAndFixMobileApp(BaseEntity mobileAppAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixPage(BaseEntity pageAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixPageType(BaseEntity pageTypeAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixSlide(BaseEntity slideAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixUiAction(BaseEntity uiActionAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixSection(BaseEntity sectionAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixUserDomain(BaseEntity userDomainAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixUserWhiteList(BaseEntity userWhiteListAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixSecUser(BaseEntity secUserAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixUserApp(BaseEntity userAppAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixQuickLink(BaseEntity quickLinkAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixListAccess(BaseEntity listAccessAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixLoginHistory(BaseEntity loginHistoryAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixCandidateContainer(BaseEntity candidateContainerAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixCandidateElement(BaseEntity candidateElementAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixWechatWorkappIdentify(BaseEntity wechatWorkappIdentifyAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixWechatMiniappIdentify(BaseEntity wechatMiniappIdentifyAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixKeypairIdentify(BaseEntity keypairIdentifyAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixPublicKeyType(BaseEntity publicKeyTypeAsBaseEntity){

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

	public YoubenbenObjectChecker checkAndFixTreeNode(BaseEntity treeNodeAsBaseEntity){

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


	public YoubenbenObjectChecker checkCatalogListOfRetailStoreCountryCenter(List<BaseEntity> catalogList){
		AtomicInteger index = new AtomicInteger();
		catalogList.stream().forEach(catalog->
			commonObjectElementCheck(catalog,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCatalog));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreProvinceCenterListOfRetailStoreCountryCenter(List<BaseEntity> retailStoreProvinceCenterList){
		AtomicInteger index = new AtomicInteger();
		retailStoreProvinceCenterList.stream().forEach(retailStoreProvinceCenter->
			commonObjectElementCheck(retailStoreProvinceCenter,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreProvinceCenter));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreListOfRetailStoreCountryCenter(List<BaseEntity> retailStoreList){
		AtomicInteger index = new AtomicInteger();
		retailStoreList.stream().forEach(retailStore->
			commonObjectElementCheck(retailStore,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStore));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreMemberListOfRetailStoreCountryCenter(List<BaseEntity> retailStoreMemberList){
		AtomicInteger index = new AtomicInteger();
		retailStoreMemberList.stream().forEach(retailStoreMember->
			commonObjectElementCheck(retailStoreMember,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreMember));
		return this;
	}

	public YoubenbenObjectChecker checkGoodsSupplierListOfRetailStoreCountryCenter(List<BaseEntity> goodsSupplierList){
		AtomicInteger index = new AtomicInteger();
		goodsSupplierList.stream().forEach(goodsSupplier->
			commonObjectElementCheck(goodsSupplier,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoodsSupplier));
		return this;
	}

	public YoubenbenObjectChecker checkSupplyOrderListOfRetailStoreCountryCenter(List<BaseEntity> supplyOrderList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderList.stream().forEach(supplyOrder->
			commonObjectElementCheck(supplyOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrder));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreOrderListOfRetailStoreCountryCenter(List<BaseEntity> retailStoreOrderList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderList.stream().forEach(retailStoreOrder->
			commonObjectElementCheck(retailStoreOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrder));
		return this;
	}

	public YoubenbenObjectChecker checkWarehouseListOfRetailStoreCountryCenter(List<BaseEntity> warehouseList){
		AtomicInteger index = new AtomicInteger();
		warehouseList.stream().forEach(warehouse->
			commonObjectElementCheck(warehouse,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWarehouse));
		return this;
	}

	public YoubenbenObjectChecker checkTransportFleetListOfRetailStoreCountryCenter(List<BaseEntity> transportFleetList){
		AtomicInteger index = new AtomicInteger();
		transportFleetList.stream().forEach(transportFleet->
			commonObjectElementCheck(transportFleet,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTransportFleet));
		return this;
	}

	public YoubenbenObjectChecker checkAccountSetListOfRetailStoreCountryCenter(List<BaseEntity> accountSetList){
		AtomicInteger index = new AtomicInteger();
		accountSetList.stream().forEach(accountSet->
			commonObjectElementCheck(accountSet,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountSet));
		return this;
	}

	public YoubenbenObjectChecker checkLevelOneDepartmentListOfRetailStoreCountryCenter(List<BaseEntity> levelOneDepartmentList){
		AtomicInteger index = new AtomicInteger();
		levelOneDepartmentList.stream().forEach(levelOneDepartment->
			commonObjectElementCheck(levelOneDepartment,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLevelOneDepartment));
		return this;
	}

	public YoubenbenObjectChecker checkSkillTypeListOfRetailStoreCountryCenter(List<BaseEntity> skillTypeList){
		AtomicInteger index = new AtomicInteger();
		skillTypeList.stream().forEach(skillType->
			commonObjectElementCheck(skillType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSkillType));
		return this;
	}

	public YoubenbenObjectChecker checkResponsibilityTypeListOfRetailStoreCountryCenter(List<BaseEntity> responsibilityTypeList){
		AtomicInteger index = new AtomicInteger();
		responsibilityTypeList.stream().forEach(responsibilityType->
			commonObjectElementCheck(responsibilityType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixResponsibilityType));
		return this;
	}

	public YoubenbenObjectChecker checkTerminationReasonListOfRetailStoreCountryCenter(List<BaseEntity> terminationReasonList){
		AtomicInteger index = new AtomicInteger();
		terminationReasonList.stream().forEach(terminationReason->
			commonObjectElementCheck(terminationReason,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTerminationReason));
		return this;
	}

	public YoubenbenObjectChecker checkTerminationTypeListOfRetailStoreCountryCenter(List<BaseEntity> terminationTypeList){
		AtomicInteger index = new AtomicInteger();
		terminationTypeList.stream().forEach(terminationType->
			commonObjectElementCheck(terminationType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTerminationType));
		return this;
	}

	public YoubenbenObjectChecker checkOccupationTypeListOfRetailStoreCountryCenter(List<BaseEntity> occupationTypeList){
		AtomicInteger index = new AtomicInteger();
		occupationTypeList.stream().forEach(occupationType->
			commonObjectElementCheck(occupationType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixOccupationType));
		return this;
	}

	public YoubenbenObjectChecker checkLeaveTypeListOfRetailStoreCountryCenter(List<BaseEntity> leaveTypeList){
		AtomicInteger index = new AtomicInteger();
		leaveTypeList.stream().forEach(leaveType->
			commonObjectElementCheck(leaveType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLeaveType));
		return this;
	}

	public YoubenbenObjectChecker checkSalaryGradeListOfRetailStoreCountryCenter(List<BaseEntity> salaryGradeList){
		AtomicInteger index = new AtomicInteger();
		salaryGradeList.stream().forEach(salaryGrade->
			commonObjectElementCheck(salaryGrade,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSalaryGrade));
		return this;
	}

	public YoubenbenObjectChecker checkInterviewTypeListOfRetailStoreCountryCenter(List<BaseEntity> interviewTypeList){
		AtomicInteger index = new AtomicInteger();
		interviewTypeList.stream().forEach(interviewType->
			commonObjectElementCheck(interviewType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixInterviewType));
		return this;
	}

	public YoubenbenObjectChecker checkTrainingCourseTypeListOfRetailStoreCountryCenter(List<BaseEntity> trainingCourseTypeList){
		AtomicInteger index = new AtomicInteger();
		trainingCourseTypeList.stream().forEach(trainingCourseType->
			commonObjectElementCheck(trainingCourseType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTrainingCourseType));
		return this;
	}

	public YoubenbenObjectChecker checkPublicHolidayListOfRetailStoreCountryCenter(List<BaseEntity> publicHolidayList){
		AtomicInteger index = new AtomicInteger();
		publicHolidayList.stream().forEach(publicHoliday->
			commonObjectElementCheck(publicHoliday,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPublicHoliday));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeListOfRetailStoreCountryCenter(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public YoubenbenObjectChecker checkInstructorListOfRetailStoreCountryCenter(List<BaseEntity> instructorList){
		AtomicInteger index = new AtomicInteger();
		instructorList.stream().forEach(instructor->
			commonObjectElementCheck(instructor,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixInstructor));
		return this;
	}

	public YoubenbenObjectChecker checkCompanyTrainingListOfRetailStoreCountryCenter(List<BaseEntity> companyTrainingList){
		AtomicInteger index = new AtomicInteger();
		companyTrainingList.stream().forEach(companyTraining->
			commonObjectElementCheck(companyTraining,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCompanyTraining));
		return this;
	}

	public YoubenbenObjectChecker checkLevelOneCategoryListOfCatalog(List<BaseEntity> levelOneCategoryList){
		AtomicInteger index = new AtomicInteger();
		levelOneCategoryList.stream().forEach(levelOneCategory->
			commonObjectElementCheck(levelOneCategory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLevelOneCategory));
		return this;
	}

	public static final String OWNER_OF_CATALOG = "catalog.owner";


	public YoubenbenObjectChecker checkOwnerOfCatalog(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_CATALOG);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(ownerAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkLevelTwoCategoryListOfLevelOneCategory(List<BaseEntity> levelTwoCategoryList){
		AtomicInteger index = new AtomicInteger();
		levelTwoCategoryList.stream().forEach(levelTwoCategory->
			commonObjectElementCheck(levelTwoCategory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLevelTwoCategory));
		return this;
	}

	public static final String CATALOG_OF_LEVEL_ONE_CATEGORY = "level_one_category.catalog";


	public YoubenbenObjectChecker checkCatalogOfLevelOneCategory(BaseEntity catalogAsBaseEntity){

		if(catalogAsBaseEntity == null){
			checkBaseEntityReference(catalogAsBaseEntity,true,CATALOG_OF_LEVEL_ONE_CATEGORY);
			return this;
		}
		checkAndFixCatalog(catalogAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkLevelThreeCategoryListOfLevelTwoCategory(List<BaseEntity> levelThreeCategoryList){
		AtomicInteger index = new AtomicInteger();
		levelThreeCategoryList.stream().forEach(levelThreeCategory->
			commonObjectElementCheck(levelThreeCategory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLevelThreeCategory));
		return this;
	}

	public static final String PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY = "level_two_category.parent_category";


	public YoubenbenObjectChecker checkParentCategoryOfLevelTwoCategory(BaseEntity parentCategoryAsBaseEntity){

		if(parentCategoryAsBaseEntity == null){
			checkBaseEntityReference(parentCategoryAsBaseEntity,true,PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY);
			return this;
		}
		checkAndFixLevelOneCategory(parentCategoryAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkProductListOfLevelThreeCategory(List<BaseEntity> productList){
		AtomicInteger index = new AtomicInteger();
		productList.stream().forEach(product->
			commonObjectElementCheck(product,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixProduct));
		return this;
	}

	public static final String PARENT_CATEGORY_OF_LEVEL_THREE_CATEGORY = "level_three_category.parent_category";


	public YoubenbenObjectChecker checkParentCategoryOfLevelThreeCategory(BaseEntity parentCategoryAsBaseEntity){

		if(parentCategoryAsBaseEntity == null){
			checkBaseEntityReference(parentCategoryAsBaseEntity,true,PARENT_CATEGORY_OF_LEVEL_THREE_CATEGORY);
			return this;
		}
		checkAndFixLevelTwoCategory(parentCategoryAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkSkuListOfProduct(List<BaseEntity> skuList){
		AtomicInteger index = new AtomicInteger();
		skuList.stream().forEach(sku->
			commonObjectElementCheck(sku,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSku));
		return this;
	}

	public static final String PARENT_CATEGORY_OF_PRODUCT = "product.parent_category";


	public YoubenbenObjectChecker checkParentCategoryOfProduct(BaseEntity parentCategoryAsBaseEntity){

		if(parentCategoryAsBaseEntity == null){
			checkBaseEntityReference(parentCategoryAsBaseEntity,true,PARENT_CATEGORY_OF_PRODUCT);
			return this;
		}
		checkAndFixLevelThreeCategory(parentCategoryAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsListOfSku(List<BaseEntity> goodsList){
		AtomicInteger index = new AtomicInteger();
		goodsList.stream().forEach(goods->
			commonObjectElementCheck(goods,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoods));
		return this;
	}

	public static final String PRODUCT_OF_SKU = "sku.product";


	public YoubenbenObjectChecker checkProductOfSku(BaseEntity productAsBaseEntity){

		if(productAsBaseEntity == null){
			checkBaseEntityReference(productAsBaseEntity,true,PRODUCT_OF_SKU);
			return this;
		}
		checkAndFixProduct(productAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkProvinceCenterDepartmentListOfRetailStoreProvinceCenter(List<BaseEntity> provinceCenterDepartmentList){
		AtomicInteger index = new AtomicInteger();
		provinceCenterDepartmentList.stream().forEach(provinceCenterDepartment->
			commonObjectElementCheck(provinceCenterDepartment,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixProvinceCenterDepartment));
		return this;
	}

	public YoubenbenObjectChecker checkProvinceCenterEmployeeListOfRetailStoreProvinceCenter(List<BaseEntity> provinceCenterEmployeeList){
		AtomicInteger index = new AtomicInteger();
		provinceCenterEmployeeList.stream().forEach(provinceCenterEmployee->
			commonObjectElementCheck(provinceCenterEmployee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixProvinceCenterEmployee));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreCityServiceCenterListOfRetailStoreProvinceCenter(List<BaseEntity> retailStoreCityServiceCenterList){
		AtomicInteger index = new AtomicInteger();
		retailStoreCityServiceCenterList.stream().forEach(retailStoreCityServiceCenter->
			commonObjectElementCheck(retailStoreCityServiceCenter,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreCityServiceCenter));
		return this;
	}

	public static final String COUNTRY_OF_RETAIL_STORE_PROVINCE_CENTER = "retail_store_province_center.country";


	public YoubenbenObjectChecker checkCountryOfRetailStoreProvinceCenter(BaseEntity countryAsBaseEntity){

		if(countryAsBaseEntity == null){
			checkBaseEntityReference(countryAsBaseEntity,true,COUNTRY_OF_RETAIL_STORE_PROVINCE_CENTER);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(countryAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkProvinceCenterEmployeeListOfProvinceCenterDepartment(List<BaseEntity> provinceCenterEmployeeList){
		AtomicInteger index = new AtomicInteger();
		provinceCenterEmployeeList.stream().forEach(provinceCenterEmployee->
			commonObjectElementCheck(provinceCenterEmployee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixProvinceCenterEmployee));
		return this;
	}

	public static final String PROVINCE_CENTER_OF_PROVINCE_CENTER_DEPARTMENT = "province_center_department.province_center";


	public YoubenbenObjectChecker checkProvinceCenterOfProvinceCenterDepartment(BaseEntity provinceCenterAsBaseEntity){

		if(provinceCenterAsBaseEntity == null){
			checkBaseEntityReference(provinceCenterAsBaseEntity,true,PROVINCE_CENTER_OF_PROVINCE_CENTER_DEPARTMENT);
			return this;
		}
		checkAndFixRetailStoreProvinceCenter(provinceCenterAsBaseEntity);
		return this;
	}


	public static final String DEPARTMENT_OF_PROVINCE_CENTER_EMPLOYEE = "province_center_employee.department";


	public YoubenbenObjectChecker checkDepartmentOfProvinceCenterEmployee(BaseEntity departmentAsBaseEntity){

		if(departmentAsBaseEntity == null){
			checkBaseEntityReference(departmentAsBaseEntity,true,DEPARTMENT_OF_PROVINCE_CENTER_EMPLOYEE);
			return this;
		}
		checkAndFixProvinceCenterDepartment(departmentAsBaseEntity);
		return this;
	}


	public static final String PROVINCE_CENTER_OF_PROVINCE_CENTER_EMPLOYEE = "province_center_employee.province_center";


	public YoubenbenObjectChecker checkProvinceCenterOfProvinceCenterEmployee(BaseEntity provinceCenterAsBaseEntity){

		if(provinceCenterAsBaseEntity == null){
			checkBaseEntityReference(provinceCenterAsBaseEntity,true,PROVINCE_CENTER_OF_PROVINCE_CENTER_EMPLOYEE);
			return this;
		}
		checkAndFixRetailStoreProvinceCenter(provinceCenterAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkCityPartnerListOfRetailStoreCityServiceCenter(List<BaseEntity> cityPartnerList){
		AtomicInteger index = new AtomicInteger();
		cityPartnerList.stream().forEach(cityPartner->
			commonObjectElementCheck(cityPartner,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCityPartner));
		return this;
	}

	public YoubenbenObjectChecker checkPotentialCustomerListOfRetailStoreCityServiceCenter(List<BaseEntity> potentialCustomerList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerList.stream().forEach(potentialCustomer->
			commonObjectElementCheck(potentialCustomer,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomer));
		return this;
	}

	public YoubenbenObjectChecker checkCityEventListOfRetailStoreCityServiceCenter(List<BaseEntity> cityEventList){
		AtomicInteger index = new AtomicInteger();
		cityEventList.stream().forEach(cityEvent->
			commonObjectElementCheck(cityEvent,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCityEvent));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreListOfRetailStoreCityServiceCenter(List<BaseEntity> retailStoreList){
		AtomicInteger index = new AtomicInteger();
		retailStoreList.stream().forEach(retailStore->
			commonObjectElementCheck(retailStore,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStore));
		return this;
	}

	public static final String BELONGS_TO_OF_RETAIL_STORE_CITY_SERVICE_CENTER = "retail_store_city_service_center.belongs_to";


	public YoubenbenObjectChecker checkBelongsToOfRetailStoreCityServiceCenter(BaseEntity belongsToAsBaseEntity){

		if(belongsToAsBaseEntity == null){
			checkBaseEntityReference(belongsToAsBaseEntity,true,BELONGS_TO_OF_RETAIL_STORE_CITY_SERVICE_CENTER);
			return this;
		}
		checkAndFixRetailStoreProvinceCenter(belongsToAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkPotentialCustomerListOfCityPartner(List<BaseEntity> potentialCustomerList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerList.stream().forEach(potentialCustomer->
			commonObjectElementCheck(potentialCustomer,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomer));
		return this;
	}

	public YoubenbenObjectChecker checkPotentialCustomerContactListOfCityPartner(List<BaseEntity> potentialCustomerContactList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerContactList.stream().forEach(potentialCustomerContact->
			commonObjectElementCheck(potentialCustomerContact,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomerContact));
		return this;
	}

	public static final String CITY_SERVICE_CENTER_OF_CITY_PARTNER = "city_partner.city_service_center";


	public YoubenbenObjectChecker checkCityServiceCenterOfCityPartner(BaseEntity cityServiceCenterAsBaseEntity){

		if(cityServiceCenterAsBaseEntity == null){
			checkBaseEntityReference(cityServiceCenterAsBaseEntity,true,CITY_SERVICE_CENTER_OF_CITY_PARTNER);
			return this;
		}
		checkAndFixRetailStoreCityServiceCenter(cityServiceCenterAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkPotentialCustomerContactPersonListOfPotentialCustomer(List<BaseEntity> potentialCustomerContactPersonList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerContactPersonList.stream().forEach(potentialCustomerContactPerson->
			commonObjectElementCheck(potentialCustomerContactPerson,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomerContactPerson));
		return this;
	}

	public YoubenbenObjectChecker checkPotentialCustomerContactListOfPotentialCustomer(List<BaseEntity> potentialCustomerContactList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerContactList.stream().forEach(potentialCustomerContact->
			commonObjectElementCheck(potentialCustomerContact,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomerContact));
		return this;
	}

	public YoubenbenObjectChecker checkEventAttendanceListOfPotentialCustomer(List<BaseEntity> eventAttendanceList){
		AtomicInteger index = new AtomicInteger();
		eventAttendanceList.stream().forEach(eventAttendance->
			commonObjectElementCheck(eventAttendance,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEventAttendance));
		return this;
	}

	public static final String CITY_SERVICE_CENTER_OF_POTENTIAL_CUSTOMER = "potential_customer.city_service_center";


	public YoubenbenObjectChecker checkCityServiceCenterOfPotentialCustomer(BaseEntity cityServiceCenterAsBaseEntity){

		if(cityServiceCenterAsBaseEntity == null){
			checkBaseEntityReference(cityServiceCenterAsBaseEntity,true,CITY_SERVICE_CENTER_OF_POTENTIAL_CUSTOMER);
			return this;
		}
		checkAndFixRetailStoreCityServiceCenter(cityServiceCenterAsBaseEntity);
		return this;
	}


	public static final String CITY_PARTNER_OF_POTENTIAL_CUSTOMER = "potential_customer.city_partner";


	public YoubenbenObjectChecker checkCityPartnerOfPotentialCustomer(BaseEntity cityPartnerAsBaseEntity){

		if(cityPartnerAsBaseEntity == null){
			checkBaseEntityReference(cityPartnerAsBaseEntity,true,CITY_PARTNER_OF_POTENTIAL_CUSTOMER);
			return this;
		}
		checkAndFixCityPartner(cityPartnerAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkPotentialCustomerContactListOfPotentialCustomerContactPerson(List<BaseEntity> potentialCustomerContactList){
		AtomicInteger index = new AtomicInteger();
		potentialCustomerContactList.stream().forEach(potentialCustomerContact->
			commonObjectElementCheck(potentialCustomerContact,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPotentialCustomerContact));
		return this;
	}

	public static final String POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON = "potential_customer_contact_person.potential_customer";


	public YoubenbenObjectChecker checkPotentialCustomerOfPotentialCustomerContactPerson(BaseEntity potentialCustomerAsBaseEntity){

		if(potentialCustomerAsBaseEntity == null){
			checkBaseEntityReference(potentialCustomerAsBaseEntity,true,POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON);
			return this;
		}
		checkAndFixPotentialCustomer(potentialCustomerAsBaseEntity);
		return this;
	}


	public static final String POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT = "potential_customer_contact.potential_customer";


	public YoubenbenObjectChecker checkPotentialCustomerOfPotentialCustomerContact(BaseEntity potentialCustomerAsBaseEntity){

		if(potentialCustomerAsBaseEntity == null){
			checkBaseEntityReference(potentialCustomerAsBaseEntity,true,POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT);
			return this;
		}
		checkAndFixPotentialCustomer(potentialCustomerAsBaseEntity);
		return this;
	}


	public static final String CITY_PARTNER_OF_POTENTIAL_CUSTOMER_CONTACT = "potential_customer_contact.city_partner";


	public YoubenbenObjectChecker checkCityPartnerOfPotentialCustomerContact(BaseEntity cityPartnerAsBaseEntity){

		if(cityPartnerAsBaseEntity == null){
			checkBaseEntityReference(cityPartnerAsBaseEntity,true,CITY_PARTNER_OF_POTENTIAL_CUSTOMER_CONTACT);
			return this;
		}
		checkAndFixCityPartner(cityPartnerAsBaseEntity);
		return this;
	}


	public static final String CONTACT_TO_OF_POTENTIAL_CUSTOMER_CONTACT = "potential_customer_contact.contact_to";


	public YoubenbenObjectChecker checkContactToOfPotentialCustomerContact(BaseEntity contactToAsBaseEntity){

		if(contactToAsBaseEntity == null){
			checkBaseEntityReference(contactToAsBaseEntity,true,CONTACT_TO_OF_POTENTIAL_CUSTOMER_CONTACT);
			return this;
		}
		checkAndFixPotentialCustomerContactPerson(contactToAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEventAttendanceListOfCityEvent(List<BaseEntity> eventAttendanceList){
		AtomicInteger index = new AtomicInteger();
		eventAttendanceList.stream().forEach(eventAttendance->
			commonObjectElementCheck(eventAttendance,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEventAttendance));
		return this;
	}

	public static final String CITY_SERVICE_CENTER_OF_CITY_EVENT = "city_event.city_service_center";


	public YoubenbenObjectChecker checkCityServiceCenterOfCityEvent(BaseEntity cityServiceCenterAsBaseEntity){

		if(cityServiceCenterAsBaseEntity == null){
			checkBaseEntityReference(cityServiceCenterAsBaseEntity,true,CITY_SERVICE_CENTER_OF_CITY_EVENT);
			return this;
		}
		checkAndFixRetailStoreCityServiceCenter(cityServiceCenterAsBaseEntity);
		return this;
	}


	public static final String POTENTIAL_CUSTOMER_OF_EVENT_ATTENDANCE = "event_attendance.potential_customer";


	public YoubenbenObjectChecker checkPotentialCustomerOfEventAttendance(BaseEntity potentialCustomerAsBaseEntity){

		if(potentialCustomerAsBaseEntity == null){
			checkBaseEntityReference(potentialCustomerAsBaseEntity,true,POTENTIAL_CUSTOMER_OF_EVENT_ATTENDANCE);
			return this;
		}
		checkAndFixPotentialCustomer(potentialCustomerAsBaseEntity);
		return this;
	}


	public static final String CITY_EVENT_OF_EVENT_ATTENDANCE = "event_attendance.city_event";


	public YoubenbenObjectChecker checkCityEventOfEventAttendance(BaseEntity cityEventAsBaseEntity){

		if(cityEventAsBaseEntity == null){
			checkBaseEntityReference(cityEventAsBaseEntity,true,CITY_EVENT_OF_EVENT_ATTENDANCE);
			return this;
		}
		checkAndFixCityEvent(cityEventAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkConsumerOrderListOfRetailStore(List<BaseEntity> consumerOrderList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderList.stream().forEach(consumerOrder->
			commonObjectElementCheck(consumerOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrder));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreOrderListOfRetailStore(List<BaseEntity> retailStoreOrderList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderList.stream().forEach(retailStoreOrder->
			commonObjectElementCheck(retailStoreOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrder));
		return this;
	}

	public YoubenbenObjectChecker checkGoodsListOfRetailStore(List<BaseEntity> goodsList){
		AtomicInteger index = new AtomicInteger();
		goodsList.stream().forEach(goods->
			commonObjectElementCheck(goods,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoods));
		return this;
	}

	public YoubenbenObjectChecker checkTransportTaskListOfRetailStore(List<BaseEntity> transportTaskList){
		AtomicInteger index = new AtomicInteger();
		transportTaskList.stream().forEach(transportTask->
			commonObjectElementCheck(transportTask,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTransportTask));
		return this;
	}

	public YoubenbenObjectChecker checkAccountSetListOfRetailStore(List<BaseEntity> accountSetList){
		AtomicInteger index = new AtomicInteger();
		accountSetList.stream().forEach(accountSet->
			commonObjectElementCheck(accountSet,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountSet));
		return this;
	}

	public static final String RETAIL_STORE_COUNTRY_CENTER_OF_RETAIL_STORE = "retail_store.retail_store_country_center";


	public YoubenbenObjectChecker checkRetailStoreCountryCenterOfRetailStore(BaseEntity retailStoreCountryCenterAsBaseEntity){

		if(retailStoreCountryCenterAsBaseEntity == null){
			checkBaseEntityReference(retailStoreCountryCenterAsBaseEntity,true,RETAIL_STORE_COUNTRY_CENTER_OF_RETAIL_STORE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(retailStoreCountryCenterAsBaseEntity);
		return this;
	}


	public static final String CITY_SERVICE_CENTER_OF_RETAIL_STORE = "retail_store.city_service_center";


	public YoubenbenObjectChecker checkCityServiceCenterOfRetailStore(BaseEntity cityServiceCenterAsBaseEntity){

		if(cityServiceCenterAsBaseEntity == null){
			checkBaseEntityReference(cityServiceCenterAsBaseEntity,true,CITY_SERVICE_CENTER_OF_RETAIL_STORE);
			return this;
		}
		checkAndFixRetailStoreCityServiceCenter(cityServiceCenterAsBaseEntity);
		return this;
	}


	public static final String CREATION_OF_RETAIL_STORE = "retail_store.creation";


	public YoubenbenObjectChecker checkCreationOfRetailStore(BaseEntity creationAsBaseEntity){

		if(creationAsBaseEntity == null){
			checkBaseEntityReference(creationAsBaseEntity,true,CREATION_OF_RETAIL_STORE);
			return this;
		}
		checkAndFixRetailStoreCreation(creationAsBaseEntity);
		return this;
	}


	public static final String INVESTMENT_INVITATION_OF_RETAIL_STORE = "retail_store.investment_invitation";


	public YoubenbenObjectChecker checkInvestmentInvitationOfRetailStore(BaseEntity investmentInvitationAsBaseEntity){

		if(investmentInvitationAsBaseEntity == null){
			checkBaseEntityReference(investmentInvitationAsBaseEntity,true,INVESTMENT_INVITATION_OF_RETAIL_STORE);
			return this;
		}
		checkAndFixRetailStoreInvestmentInvitation(investmentInvitationAsBaseEntity);
		return this;
	}


	public static final String FRANCHISING_OF_RETAIL_STORE = "retail_store.franchising";


	public YoubenbenObjectChecker checkFranchisingOfRetailStore(BaseEntity franchisingAsBaseEntity){

		if(franchisingAsBaseEntity == null){
			checkBaseEntityReference(franchisingAsBaseEntity,true,FRANCHISING_OF_RETAIL_STORE);
			return this;
		}
		checkAndFixRetailStoreFranchising(franchisingAsBaseEntity);
		return this;
	}


	public static final String DECORATION_OF_RETAIL_STORE = "retail_store.decoration";


	public YoubenbenObjectChecker checkDecorationOfRetailStore(BaseEntity decorationAsBaseEntity){

		if(decorationAsBaseEntity == null){
			checkBaseEntityReference(decorationAsBaseEntity,true,DECORATION_OF_RETAIL_STORE);
			return this;
		}
		checkAndFixRetailStoreDecoration(decorationAsBaseEntity);
		return this;
	}


	public static final String OPENING_OF_RETAIL_STORE = "retail_store.opening";


	public YoubenbenObjectChecker checkOpeningOfRetailStore(BaseEntity openingAsBaseEntity){

		if(openingAsBaseEntity == null){
			checkBaseEntityReference(openingAsBaseEntity,true,OPENING_OF_RETAIL_STORE);
			return this;
		}
		checkAndFixRetailStoreOpening(openingAsBaseEntity);
		return this;
	}


	public static final String CLOSING_OF_RETAIL_STORE = "retail_store.closing";


	public YoubenbenObjectChecker checkClosingOfRetailStore(BaseEntity closingAsBaseEntity){

		if(closingAsBaseEntity == null){
			checkBaseEntityReference(closingAsBaseEntity,true,CLOSING_OF_RETAIL_STORE);
			return this;
		}
		checkAndFixRetailStoreClosing(closingAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkRetailStoreListOfRetailStoreCreation(List<BaseEntity> retailStoreList){
		AtomicInteger index = new AtomicInteger();
		retailStoreList.stream().forEach(retailStore->
			commonObjectElementCheck(retailStore,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStore));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreListOfRetailStoreInvestmentInvitation(List<BaseEntity> retailStoreList){
		AtomicInteger index = new AtomicInteger();
		retailStoreList.stream().forEach(retailStore->
			commonObjectElementCheck(retailStore,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStore));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreListOfRetailStoreFranchising(List<BaseEntity> retailStoreList){
		AtomicInteger index = new AtomicInteger();
		retailStoreList.stream().forEach(retailStore->
			commonObjectElementCheck(retailStore,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStore));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreListOfRetailStoreDecoration(List<BaseEntity> retailStoreList){
		AtomicInteger index = new AtomicInteger();
		retailStoreList.stream().forEach(retailStore->
			commonObjectElementCheck(retailStore,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStore));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreListOfRetailStoreOpening(List<BaseEntity> retailStoreList){
		AtomicInteger index = new AtomicInteger();
		retailStoreList.stream().forEach(retailStore->
			commonObjectElementCheck(retailStore,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStore));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreListOfRetailStoreClosing(List<BaseEntity> retailStoreList){
		AtomicInteger index = new AtomicInteger();
		retailStoreList.stream().forEach(retailStore->
			commonObjectElementCheck(retailStore,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStore));
		return this;
	}

	public YoubenbenObjectChecker checkConsumerOrderListOfRetailStoreMember(List<BaseEntity> consumerOrderList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderList.stream().forEach(consumerOrder->
			commonObjectElementCheck(consumerOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrder));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreMemberCouponListOfRetailStoreMember(List<BaseEntity> retailStoreMemberCouponList){
		AtomicInteger index = new AtomicInteger();
		retailStoreMemberCouponList.stream().forEach(retailStoreMemberCoupon->
			commonObjectElementCheck(retailStoreMemberCoupon,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreMemberCoupon));
		return this;
	}

	public YoubenbenObjectChecker checkMemberWishlistListOfRetailStoreMember(List<BaseEntity> memberWishlistList){
		AtomicInteger index = new AtomicInteger();
		memberWishlistList.stream().forEach(memberWishlist->
			commonObjectElementCheck(memberWishlist,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixMemberWishlist));
		return this;
	}

	public YoubenbenObjectChecker checkMemberRewardPointListOfRetailStoreMember(List<BaseEntity> memberRewardPointList){
		AtomicInteger index = new AtomicInteger();
		memberRewardPointList.stream().forEach(memberRewardPoint->
			commonObjectElementCheck(memberRewardPoint,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixMemberRewardPoint));
		return this;
	}

	public YoubenbenObjectChecker checkMemberRewardPointRedemptionListOfRetailStoreMember(List<BaseEntity> memberRewardPointRedemptionList){
		AtomicInteger index = new AtomicInteger();
		memberRewardPointRedemptionList.stream().forEach(memberRewardPointRedemption->
			commonObjectElementCheck(memberRewardPointRedemption,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixMemberRewardPointRedemption));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreMemberAddressListOfRetailStoreMember(List<BaseEntity> retailStoreMemberAddressList){
		AtomicInteger index = new AtomicInteger();
		retailStoreMemberAddressList.stream().forEach(retailStoreMemberAddress->
			commonObjectElementCheck(retailStoreMemberAddress,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreMemberAddress));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreMemberGiftCardListOfRetailStoreMember(List<BaseEntity> retailStoreMemberGiftCardList){
		AtomicInteger index = new AtomicInteger();
		retailStoreMemberGiftCardList.stream().forEach(retailStoreMemberGiftCard->
			commonObjectElementCheck(retailStoreMemberGiftCard,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreMemberGiftCard));
		return this;
	}

	public static final String OWNER_OF_RETAIL_STORE_MEMBER = "retail_store_member.owner";


	public YoubenbenObjectChecker checkOwnerOfRetailStoreMember(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_RETAIL_STORE_MEMBER);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(ownerAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkConsumerOrderLineItemListOfConsumerOrder(List<BaseEntity> consumerOrderLineItemList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderLineItemList.stream().forEach(consumerOrderLineItem->
			commonObjectElementCheck(consumerOrderLineItem,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrderLineItem));
		return this;
	}

	public YoubenbenObjectChecker checkConsumerOrderShippingGroupListOfConsumerOrder(List<BaseEntity> consumerOrderShippingGroupList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderShippingGroupList.stream().forEach(consumerOrderShippingGroup->
			commonObjectElementCheck(consumerOrderShippingGroup,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrderShippingGroup));
		return this;
	}

	public YoubenbenObjectChecker checkConsumerOrderPaymentGroupListOfConsumerOrder(List<BaseEntity> consumerOrderPaymentGroupList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderPaymentGroupList.stream().forEach(consumerOrderPaymentGroup->
			commonObjectElementCheck(consumerOrderPaymentGroup,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrderPaymentGroup));
		return this;
	}

	public YoubenbenObjectChecker checkConsumerOrderPriceAdjustmentListOfConsumerOrder(List<BaseEntity> consumerOrderPriceAdjustmentList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderPriceAdjustmentList.stream().forEach(consumerOrderPriceAdjustment->
			commonObjectElementCheck(consumerOrderPriceAdjustment,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrderPriceAdjustment));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreMemberGiftCardConsumeRecordListOfConsumerOrder(List<BaseEntity> retailStoreMemberGiftCardConsumeRecordList){
		AtomicInteger index = new AtomicInteger();
		retailStoreMemberGiftCardConsumeRecordList.stream().forEach(retailStoreMemberGiftCardConsumeRecord->
			commonObjectElementCheck(retailStoreMemberGiftCardConsumeRecord,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreMemberGiftCardConsumeRecord));
		return this;
	}

	public static final String CONSUMER_OF_CONSUMER_ORDER = "consumer_order.consumer";


	public YoubenbenObjectChecker checkConsumerOfConsumerOrder(BaseEntity consumerAsBaseEntity){

		if(consumerAsBaseEntity == null){
			checkBaseEntityReference(consumerAsBaseEntity,true,CONSUMER_OF_CONSUMER_ORDER);
			return this;
		}
		checkAndFixRetailStoreMember(consumerAsBaseEntity);
		return this;
	}


	public static final String CONFIRMATION_OF_CONSUMER_ORDER = "consumer_order.confirmation";


	public YoubenbenObjectChecker checkConfirmationOfConsumerOrder(BaseEntity confirmationAsBaseEntity){

		if(confirmationAsBaseEntity == null){
			checkBaseEntityReference(confirmationAsBaseEntity,true,CONFIRMATION_OF_CONSUMER_ORDER);
			return this;
		}
		checkAndFixSupplyOrderConfirmation(confirmationAsBaseEntity);
		return this;
	}


	public static final String APPROVAL_OF_CONSUMER_ORDER = "consumer_order.approval";


	public YoubenbenObjectChecker checkApprovalOfConsumerOrder(BaseEntity approvalAsBaseEntity){

		if(approvalAsBaseEntity == null){
			checkBaseEntityReference(approvalAsBaseEntity,true,APPROVAL_OF_CONSUMER_ORDER);
			return this;
		}
		checkAndFixSupplyOrderApproval(approvalAsBaseEntity);
		return this;
	}


	public static final String PROCESSING_OF_CONSUMER_ORDER = "consumer_order.processing";


	public YoubenbenObjectChecker checkProcessingOfConsumerOrder(BaseEntity processingAsBaseEntity){

		if(processingAsBaseEntity == null){
			checkBaseEntityReference(processingAsBaseEntity,true,PROCESSING_OF_CONSUMER_ORDER);
			return this;
		}
		checkAndFixSupplyOrderProcessing(processingAsBaseEntity);
		return this;
	}


	public static final String SHIPMENT_OF_CONSUMER_ORDER = "consumer_order.shipment";


	public YoubenbenObjectChecker checkShipmentOfConsumerOrder(BaseEntity shipmentAsBaseEntity){

		if(shipmentAsBaseEntity == null){
			checkBaseEntityReference(shipmentAsBaseEntity,true,SHIPMENT_OF_CONSUMER_ORDER);
			return this;
		}
		checkAndFixSupplyOrderShipment(shipmentAsBaseEntity);
		return this;
	}


	public static final String DELIVERY_OF_CONSUMER_ORDER = "consumer_order.delivery";


	public YoubenbenObjectChecker checkDeliveryOfConsumerOrder(BaseEntity deliveryAsBaseEntity){

		if(deliveryAsBaseEntity == null){
			checkBaseEntityReference(deliveryAsBaseEntity,true,DELIVERY_OF_CONSUMER_ORDER);
			return this;
		}
		checkAndFixSupplyOrderDelivery(deliveryAsBaseEntity);
		return this;
	}


	public static final String STORE_OF_CONSUMER_ORDER = "consumer_order.store";


	public YoubenbenObjectChecker checkStoreOfConsumerOrder(BaseEntity storeAsBaseEntity){

		if(storeAsBaseEntity == null){
			checkBaseEntityReference(storeAsBaseEntity,true,STORE_OF_CONSUMER_ORDER);
			return this;
		}
		checkAndFixRetailStore(storeAsBaseEntity);
		return this;
	}


	public static final String BIZ_ORDER_OF_CONSUMER_ORDER_LINE_ITEM = "consumer_order_line_item.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfConsumerOrderLineItem(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_CONSUMER_ORDER_LINE_ITEM);
			return this;
		}
		checkAndFixConsumerOrder(bizOrderAsBaseEntity);
		return this;
	}


	public static final String BIZ_ORDER_OF_CONSUMER_ORDER_SHIPPING_GROUP = "consumer_order_shipping_group.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfConsumerOrderShippingGroup(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_CONSUMER_ORDER_SHIPPING_GROUP);
			return this;
		}
		checkAndFixConsumerOrder(bizOrderAsBaseEntity);
		return this;
	}


	public static final String BIZ_ORDER_OF_CONSUMER_ORDER_PAYMENT_GROUP = "consumer_order_payment_group.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfConsumerOrderPaymentGroup(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_CONSUMER_ORDER_PAYMENT_GROUP);
			return this;
		}
		checkAndFixConsumerOrder(bizOrderAsBaseEntity);
		return this;
	}


	public static final String BIZ_ORDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT = "consumer_order_price_adjustment.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfConsumerOrderPriceAdjustment(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT);
			return this;
		}
		checkAndFixConsumerOrder(bizOrderAsBaseEntity);
		return this;
	}


	public static final String OWNER_OF_RETAIL_STORE_MEMBER_COUPON = "retail_store_member_coupon.owner";


	public YoubenbenObjectChecker checkOwnerOfRetailStoreMemberCoupon(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_RETAIL_STORE_MEMBER_COUPON);
			return this;
		}
		checkAndFixRetailStoreMember(ownerAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkMemberWishlistProductListOfMemberWishlist(List<BaseEntity> memberWishlistProductList){
		AtomicInteger index = new AtomicInteger();
		memberWishlistProductList.stream().forEach(memberWishlistProduct->
			commonObjectElementCheck(memberWishlistProduct,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixMemberWishlistProduct));
		return this;
	}

	public static final String OWNER_OF_MEMBER_WISHLIST = "member_wishlist.owner";


	public YoubenbenObjectChecker checkOwnerOfMemberWishlist(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_MEMBER_WISHLIST);
			return this;
		}
		checkAndFixRetailStoreMember(ownerAsBaseEntity);
		return this;
	}


	public static final String OWNER_OF_MEMBER_REWARD_POINT = "member_reward_point.owner";


	public YoubenbenObjectChecker checkOwnerOfMemberRewardPoint(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_MEMBER_REWARD_POINT);
			return this;
		}
		checkAndFixRetailStoreMember(ownerAsBaseEntity);
		return this;
	}


	public static final String OWNER_OF_MEMBER_REWARD_POINT_REDEMPTION = "member_reward_point_redemption.owner";


	public YoubenbenObjectChecker checkOwnerOfMemberRewardPointRedemption(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_MEMBER_REWARD_POINT_REDEMPTION);
			return this;
		}
		checkAndFixRetailStoreMember(ownerAsBaseEntity);
		return this;
	}


	public static final String OWNER_OF_MEMBER_WISHLIST_PRODUCT = "member_wishlist_product.owner";


	public YoubenbenObjectChecker checkOwnerOfMemberWishlistProduct(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_MEMBER_WISHLIST_PRODUCT);
			return this;
		}
		checkAndFixMemberWishlist(ownerAsBaseEntity);
		return this;
	}


	public static final String OWNER_OF_RETAIL_STORE_MEMBER_ADDRESS = "retail_store_member_address.owner";


	public YoubenbenObjectChecker checkOwnerOfRetailStoreMemberAddress(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_RETAIL_STORE_MEMBER_ADDRESS);
			return this;
		}
		checkAndFixRetailStoreMember(ownerAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkRetailStoreMemberGiftCardConsumeRecordListOfRetailStoreMemberGiftCard(List<BaseEntity> retailStoreMemberGiftCardConsumeRecordList){
		AtomicInteger index = new AtomicInteger();
		retailStoreMemberGiftCardConsumeRecordList.stream().forEach(retailStoreMemberGiftCardConsumeRecord->
			commonObjectElementCheck(retailStoreMemberGiftCardConsumeRecord,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreMemberGiftCardConsumeRecord));
		return this;
	}

	public static final String OWNER_OF_RETAIL_STORE_MEMBER_GIFT_CARD = "retail_store_member_gift_card.owner";


	public YoubenbenObjectChecker checkOwnerOfRetailStoreMemberGiftCard(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_RETAIL_STORE_MEMBER_GIFT_CARD);
			return this;
		}
		checkAndFixRetailStoreMember(ownerAsBaseEntity);
		return this;
	}


	public static final String OWNER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD = "retail_store_member_gift_card_consume_record.owner";


	public YoubenbenObjectChecker checkOwnerOfRetailStoreMemberGiftCardConsumeRecord(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD);
			return this;
		}
		checkAndFixRetailStoreMemberGiftCard(ownerAsBaseEntity);
		return this;
	}


	public static final String BIZ_ORDER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD = "retail_store_member_gift_card_consume_record.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfRetailStoreMemberGiftCardConsumeRecord(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD);
			return this;
		}
		checkAndFixConsumerOrder(bizOrderAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkSupplierProductListOfGoodsSupplier(List<BaseEntity> supplierProductList){
		AtomicInteger index = new AtomicInteger();
		supplierProductList.stream().forEach(supplierProduct->
			commonObjectElementCheck(supplierProduct,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplierProduct));
		return this;
	}

	public YoubenbenObjectChecker checkSupplyOrderListOfGoodsSupplier(List<BaseEntity> supplyOrderList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderList.stream().forEach(supplyOrder->
			commonObjectElementCheck(supplyOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrder));
		return this;
	}

	public YoubenbenObjectChecker checkAccountSetListOfGoodsSupplier(List<BaseEntity> accountSetList){
		AtomicInteger index = new AtomicInteger();
		accountSetList.stream().forEach(accountSet->
			commonObjectElementCheck(accountSet,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountSet));
		return this;
	}

	public static final String BELONG_TO_OF_GOODS_SUPPLIER = "goods_supplier.belong_to";


	public YoubenbenObjectChecker checkBelongToOfGoodsSupplier(BaseEntity belongToAsBaseEntity){

		if(belongToAsBaseEntity == null){
			checkBaseEntityReference(belongToAsBaseEntity,true,BELONG_TO_OF_GOODS_SUPPLIER);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(belongToAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkProductSupplyDurationListOfSupplierProduct(List<BaseEntity> productSupplyDurationList){
		AtomicInteger index = new AtomicInteger();
		productSupplyDurationList.stream().forEach(productSupplyDuration->
			commonObjectElementCheck(productSupplyDuration,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixProductSupplyDuration));
		return this;
	}

	public static final String SUPPLIER_OF_SUPPLIER_PRODUCT = "supplier_product.supplier";


	public YoubenbenObjectChecker checkSupplierOfSupplierProduct(BaseEntity supplierAsBaseEntity){

		if(supplierAsBaseEntity == null){
			checkBaseEntityReference(supplierAsBaseEntity,true,SUPPLIER_OF_SUPPLIER_PRODUCT);
			return this;
		}
		checkAndFixGoodsSupplier(supplierAsBaseEntity);
		return this;
	}


	public static final String PRODUCT_OF_PRODUCT_SUPPLY_DURATION = "product_supply_duration.product";


	public YoubenbenObjectChecker checkProductOfProductSupplyDuration(BaseEntity productAsBaseEntity){

		if(productAsBaseEntity == null){
			checkBaseEntityReference(productAsBaseEntity,true,PRODUCT_OF_PRODUCT_SUPPLY_DURATION);
			return this;
		}
		checkAndFixSupplierProduct(productAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkSupplyOrderLineItemListOfSupplyOrder(List<BaseEntity> supplyOrderLineItemList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderLineItemList.stream().forEach(supplyOrderLineItem->
			commonObjectElementCheck(supplyOrderLineItem,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrderLineItem));
		return this;
	}

	public YoubenbenObjectChecker checkSupplyOrderShippingGroupListOfSupplyOrder(List<BaseEntity> supplyOrderShippingGroupList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderShippingGroupList.stream().forEach(supplyOrderShippingGroup->
			commonObjectElementCheck(supplyOrderShippingGroup,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrderShippingGroup));
		return this;
	}

	public YoubenbenObjectChecker checkSupplyOrderPaymentGroupListOfSupplyOrder(List<BaseEntity> supplyOrderPaymentGroupList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderPaymentGroupList.stream().forEach(supplyOrderPaymentGroup->
			commonObjectElementCheck(supplyOrderPaymentGroup,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrderPaymentGroup));
		return this;
	}

	public YoubenbenObjectChecker checkGoodsListOfSupplyOrder(List<BaseEntity> goodsList){
		AtomicInteger index = new AtomicInteger();
		goodsList.stream().forEach(goods->
			commonObjectElementCheck(goods,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoods));
		return this;
	}

	public static final String BUYER_OF_SUPPLY_ORDER = "supply_order.buyer";


	public YoubenbenObjectChecker checkBuyerOfSupplyOrder(BaseEntity buyerAsBaseEntity){

		if(buyerAsBaseEntity == null){
			checkBaseEntityReference(buyerAsBaseEntity,true,BUYER_OF_SUPPLY_ORDER);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(buyerAsBaseEntity);
		return this;
	}


	public static final String SELLER_OF_SUPPLY_ORDER = "supply_order.seller";


	public YoubenbenObjectChecker checkSellerOfSupplyOrder(BaseEntity sellerAsBaseEntity){

		if(sellerAsBaseEntity == null){
			checkBaseEntityReference(sellerAsBaseEntity,true,SELLER_OF_SUPPLY_ORDER);
			return this;
		}
		checkAndFixGoodsSupplier(sellerAsBaseEntity);
		return this;
	}


	public static final String CONFIRMATION_OF_SUPPLY_ORDER = "supply_order.confirmation";


	public YoubenbenObjectChecker checkConfirmationOfSupplyOrder(BaseEntity confirmationAsBaseEntity){

		if(confirmationAsBaseEntity == null){
			checkBaseEntityReference(confirmationAsBaseEntity,true,CONFIRMATION_OF_SUPPLY_ORDER);
			return this;
		}
		checkAndFixSupplyOrderConfirmation(confirmationAsBaseEntity);
		return this;
	}


	public static final String APPROVAL_OF_SUPPLY_ORDER = "supply_order.approval";


	public YoubenbenObjectChecker checkApprovalOfSupplyOrder(BaseEntity approvalAsBaseEntity){

		if(approvalAsBaseEntity == null){
			checkBaseEntityReference(approvalAsBaseEntity,true,APPROVAL_OF_SUPPLY_ORDER);
			return this;
		}
		checkAndFixSupplyOrderApproval(approvalAsBaseEntity);
		return this;
	}


	public static final String PROCESSING_OF_SUPPLY_ORDER = "supply_order.processing";


	public YoubenbenObjectChecker checkProcessingOfSupplyOrder(BaseEntity processingAsBaseEntity){

		if(processingAsBaseEntity == null){
			checkBaseEntityReference(processingAsBaseEntity,true,PROCESSING_OF_SUPPLY_ORDER);
			return this;
		}
		checkAndFixSupplyOrderProcessing(processingAsBaseEntity);
		return this;
	}


	public static final String PICKING_OF_SUPPLY_ORDER = "supply_order.picking";


	public YoubenbenObjectChecker checkPickingOfSupplyOrder(BaseEntity pickingAsBaseEntity){

		if(pickingAsBaseEntity == null){
			checkBaseEntityReference(pickingAsBaseEntity,true,PICKING_OF_SUPPLY_ORDER);
			return this;
		}
		checkAndFixSupplyOrderPicking(pickingAsBaseEntity);
		return this;
	}


	public static final String SHIPMENT_OF_SUPPLY_ORDER = "supply_order.shipment";


	public YoubenbenObjectChecker checkShipmentOfSupplyOrder(BaseEntity shipmentAsBaseEntity){

		if(shipmentAsBaseEntity == null){
			checkBaseEntityReference(shipmentAsBaseEntity,true,SHIPMENT_OF_SUPPLY_ORDER);
			return this;
		}
		checkAndFixSupplyOrderShipment(shipmentAsBaseEntity);
		return this;
	}


	public static final String DELIVERY_OF_SUPPLY_ORDER = "supply_order.delivery";


	public YoubenbenObjectChecker checkDeliveryOfSupplyOrder(BaseEntity deliveryAsBaseEntity){

		if(deliveryAsBaseEntity == null){
			checkBaseEntityReference(deliveryAsBaseEntity,true,DELIVERY_OF_SUPPLY_ORDER);
			return this;
		}
		checkAndFixSupplyOrderDelivery(deliveryAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkConsumerOrderListOfSupplyOrderConfirmation(List<BaseEntity> consumerOrderList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderList.stream().forEach(consumerOrder->
			commonObjectElementCheck(consumerOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrder));
		return this;
	}

	public YoubenbenObjectChecker checkSupplyOrderListOfSupplyOrderConfirmation(List<BaseEntity> supplyOrderList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderList.stream().forEach(supplyOrder->
			commonObjectElementCheck(supplyOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrder));
		return this;
	}

	public YoubenbenObjectChecker checkConsumerOrderListOfSupplyOrderApproval(List<BaseEntity> consumerOrderList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderList.stream().forEach(consumerOrder->
			commonObjectElementCheck(consumerOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrder));
		return this;
	}

	public YoubenbenObjectChecker checkSupplyOrderListOfSupplyOrderApproval(List<BaseEntity> supplyOrderList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderList.stream().forEach(supplyOrder->
			commonObjectElementCheck(supplyOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrder));
		return this;
	}

	public YoubenbenObjectChecker checkConsumerOrderListOfSupplyOrderProcessing(List<BaseEntity> consumerOrderList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderList.stream().forEach(consumerOrder->
			commonObjectElementCheck(consumerOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrder));
		return this;
	}

	public YoubenbenObjectChecker checkSupplyOrderListOfSupplyOrderProcessing(List<BaseEntity> supplyOrderList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderList.stream().forEach(supplyOrder->
			commonObjectElementCheck(supplyOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrder));
		return this;
	}

	public YoubenbenObjectChecker checkSupplyOrderListOfSupplyOrderPicking(List<BaseEntity> supplyOrderList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderList.stream().forEach(supplyOrder->
			commonObjectElementCheck(supplyOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrder));
		return this;
	}

	public YoubenbenObjectChecker checkConsumerOrderListOfSupplyOrderShipment(List<BaseEntity> consumerOrderList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderList.stream().forEach(consumerOrder->
			commonObjectElementCheck(consumerOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrder));
		return this;
	}

	public YoubenbenObjectChecker checkSupplyOrderListOfSupplyOrderShipment(List<BaseEntity> supplyOrderList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderList.stream().forEach(supplyOrder->
			commonObjectElementCheck(supplyOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrder));
		return this;
	}

	public YoubenbenObjectChecker checkConsumerOrderListOfSupplyOrderDelivery(List<BaseEntity> consumerOrderList){
		AtomicInteger index = new AtomicInteger();
		consumerOrderList.stream().forEach(consumerOrder->
			commonObjectElementCheck(consumerOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixConsumerOrder));
		return this;
	}

	public YoubenbenObjectChecker checkSupplyOrderListOfSupplyOrderDelivery(List<BaseEntity> supplyOrderList){
		AtomicInteger index = new AtomicInteger();
		supplyOrderList.stream().forEach(supplyOrder->
			commonObjectElementCheck(supplyOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplyOrder));
		return this;
	}

	public static final String BIZ_ORDER_OF_SUPPLY_ORDER_LINE_ITEM = "supply_order_line_item.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfSupplyOrderLineItem(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_SUPPLY_ORDER_LINE_ITEM);
			return this;
		}
		checkAndFixSupplyOrder(bizOrderAsBaseEntity);
		return this;
	}


	public static final String BIZ_ORDER_OF_SUPPLY_ORDER_SHIPPING_GROUP = "supply_order_shipping_group.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfSupplyOrderShippingGroup(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_SUPPLY_ORDER_SHIPPING_GROUP);
			return this;
		}
		checkAndFixSupplyOrder(bizOrderAsBaseEntity);
		return this;
	}


	public static final String BIZ_ORDER_OF_SUPPLY_ORDER_PAYMENT_GROUP = "supply_order_payment_group.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfSupplyOrderPaymentGroup(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_SUPPLY_ORDER_PAYMENT_GROUP);
			return this;
		}
		checkAndFixSupplyOrder(bizOrderAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkRetailStoreOrderLineItemListOfRetailStoreOrder(List<BaseEntity> retailStoreOrderLineItemList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderLineItemList.stream().forEach(retailStoreOrderLineItem->
			commonObjectElementCheck(retailStoreOrderLineItem,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrderLineItem));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreOrderShippingGroupListOfRetailStoreOrder(List<BaseEntity> retailStoreOrderShippingGroupList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderShippingGroupList.stream().forEach(retailStoreOrderShippingGroup->
			commonObjectElementCheck(retailStoreOrderShippingGroup,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrderShippingGroup));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreOrderPaymentGroupListOfRetailStoreOrder(List<BaseEntity> retailStoreOrderPaymentGroupList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderPaymentGroupList.stream().forEach(retailStoreOrderPaymentGroup->
			commonObjectElementCheck(retailStoreOrderPaymentGroup,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrderPaymentGroup));
		return this;
	}

	public YoubenbenObjectChecker checkGoodsListOfRetailStoreOrder(List<BaseEntity> goodsList){
		AtomicInteger index = new AtomicInteger();
		goodsList.stream().forEach(goods->
			commonObjectElementCheck(goods,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoods));
		return this;
	}

	public static final String BUYER_OF_RETAIL_STORE_ORDER = "retail_store_order.buyer";


	public YoubenbenObjectChecker checkBuyerOfRetailStoreOrder(BaseEntity buyerAsBaseEntity){

		if(buyerAsBaseEntity == null){
			checkBaseEntityReference(buyerAsBaseEntity,true,BUYER_OF_RETAIL_STORE_ORDER);
			return this;
		}
		checkAndFixRetailStore(buyerAsBaseEntity);
		return this;
	}


	public static final String SELLER_OF_RETAIL_STORE_ORDER = "retail_store_order.seller";


	public YoubenbenObjectChecker checkSellerOfRetailStoreOrder(BaseEntity sellerAsBaseEntity){

		if(sellerAsBaseEntity == null){
			checkBaseEntityReference(sellerAsBaseEntity,true,SELLER_OF_RETAIL_STORE_ORDER);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(sellerAsBaseEntity);
		return this;
	}


	public static final String CONFIRMATION_OF_RETAIL_STORE_ORDER = "retail_store_order.confirmation";


	public YoubenbenObjectChecker checkConfirmationOfRetailStoreOrder(BaseEntity confirmationAsBaseEntity){

		if(confirmationAsBaseEntity == null){
			checkBaseEntityReference(confirmationAsBaseEntity,true,CONFIRMATION_OF_RETAIL_STORE_ORDER);
			return this;
		}
		checkAndFixRetailStoreOrderConfirmation(confirmationAsBaseEntity);
		return this;
	}


	public static final String APPROVAL_OF_RETAIL_STORE_ORDER = "retail_store_order.approval";


	public YoubenbenObjectChecker checkApprovalOfRetailStoreOrder(BaseEntity approvalAsBaseEntity){

		if(approvalAsBaseEntity == null){
			checkBaseEntityReference(approvalAsBaseEntity,true,APPROVAL_OF_RETAIL_STORE_ORDER);
			return this;
		}
		checkAndFixRetailStoreOrderApproval(approvalAsBaseEntity);
		return this;
	}


	public static final String PROCESSING_OF_RETAIL_STORE_ORDER = "retail_store_order.processing";


	public YoubenbenObjectChecker checkProcessingOfRetailStoreOrder(BaseEntity processingAsBaseEntity){

		if(processingAsBaseEntity == null){
			checkBaseEntityReference(processingAsBaseEntity,true,PROCESSING_OF_RETAIL_STORE_ORDER);
			return this;
		}
		checkAndFixRetailStoreOrderProcessing(processingAsBaseEntity);
		return this;
	}


	public static final String PICKING_OF_RETAIL_STORE_ORDER = "retail_store_order.picking";


	public YoubenbenObjectChecker checkPickingOfRetailStoreOrder(BaseEntity pickingAsBaseEntity){

		if(pickingAsBaseEntity == null){
			checkBaseEntityReference(pickingAsBaseEntity,true,PICKING_OF_RETAIL_STORE_ORDER);
			return this;
		}
		checkAndFixRetailStoreOrderPicking(pickingAsBaseEntity);
		return this;
	}


	public static final String SHIPMENT_OF_RETAIL_STORE_ORDER = "retail_store_order.shipment";


	public YoubenbenObjectChecker checkShipmentOfRetailStoreOrder(BaseEntity shipmentAsBaseEntity){

		if(shipmentAsBaseEntity == null){
			checkBaseEntityReference(shipmentAsBaseEntity,true,SHIPMENT_OF_RETAIL_STORE_ORDER);
			return this;
		}
		checkAndFixRetailStoreOrderShipment(shipmentAsBaseEntity);
		return this;
	}


	public static final String DELIVERY_OF_RETAIL_STORE_ORDER = "retail_store_order.delivery";


	public YoubenbenObjectChecker checkDeliveryOfRetailStoreOrder(BaseEntity deliveryAsBaseEntity){

		if(deliveryAsBaseEntity == null){
			checkBaseEntityReference(deliveryAsBaseEntity,true,DELIVERY_OF_RETAIL_STORE_ORDER);
			return this;
		}
		checkAndFixRetailStoreOrderDelivery(deliveryAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkRetailStoreOrderListOfRetailStoreOrderConfirmation(List<BaseEntity> retailStoreOrderList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderList.stream().forEach(retailStoreOrder->
			commonObjectElementCheck(retailStoreOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrder));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreOrderListOfRetailStoreOrderApproval(List<BaseEntity> retailStoreOrderList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderList.stream().forEach(retailStoreOrder->
			commonObjectElementCheck(retailStoreOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrder));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreOrderListOfRetailStoreOrderProcessing(List<BaseEntity> retailStoreOrderList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderList.stream().forEach(retailStoreOrder->
			commonObjectElementCheck(retailStoreOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrder));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreOrderListOfRetailStoreOrderPicking(List<BaseEntity> retailStoreOrderList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderList.stream().forEach(retailStoreOrder->
			commonObjectElementCheck(retailStoreOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrder));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreOrderListOfRetailStoreOrderShipment(List<BaseEntity> retailStoreOrderList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderList.stream().forEach(retailStoreOrder->
			commonObjectElementCheck(retailStoreOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrder));
		return this;
	}

	public YoubenbenObjectChecker checkRetailStoreOrderListOfRetailStoreOrderDelivery(List<BaseEntity> retailStoreOrderList){
		AtomicInteger index = new AtomicInteger();
		retailStoreOrderList.stream().forEach(retailStoreOrder->
			commonObjectElementCheck(retailStoreOrder,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRetailStoreOrder));
		return this;
	}

	public static final String BIZ_ORDER_OF_RETAIL_STORE_ORDER_LINE_ITEM = "retail_store_order_line_item.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfRetailStoreOrderLineItem(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_RETAIL_STORE_ORDER_LINE_ITEM);
			return this;
		}
		checkAndFixRetailStoreOrder(bizOrderAsBaseEntity);
		return this;
	}


	public static final String BIZ_ORDER_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP = "retail_store_order_shipping_group.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfRetailStoreOrderShippingGroup(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP);
			return this;
		}
		checkAndFixRetailStoreOrder(bizOrderAsBaseEntity);
		return this;
	}


	public static final String BIZ_ORDER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP = "retail_store_order_payment_group.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfRetailStoreOrderPaymentGroup(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP);
			return this;
		}
		checkAndFixRetailStoreOrder(bizOrderAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkStorageSpaceListOfWarehouse(List<BaseEntity> storageSpaceList){
		AtomicInteger index = new AtomicInteger();
		storageSpaceList.stream().forEach(storageSpace->
			commonObjectElementCheck(storageSpace,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixStorageSpace));
		return this;
	}

	public YoubenbenObjectChecker checkSmartPalletListOfWarehouse(List<BaseEntity> smartPalletList){
		AtomicInteger index = new AtomicInteger();
		smartPalletList.stream().forEach(smartPallet->
			commonObjectElementCheck(smartPallet,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSmartPallet));
		return this;
	}

	public YoubenbenObjectChecker checkSupplierSpaceListOfWarehouse(List<BaseEntity> supplierSpaceList){
		AtomicInteger index = new AtomicInteger();
		supplierSpaceList.stream().forEach(supplierSpace->
			commonObjectElementCheck(supplierSpace,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSupplierSpace));
		return this;
	}

	public YoubenbenObjectChecker checkReceivingSpaceListOfWarehouse(List<BaseEntity> receivingSpaceList){
		AtomicInteger index = new AtomicInteger();
		receivingSpaceList.stream().forEach(receivingSpace->
			commonObjectElementCheck(receivingSpace,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixReceivingSpace));
		return this;
	}

	public YoubenbenObjectChecker checkShippingSpaceListOfWarehouse(List<BaseEntity> shippingSpaceList){
		AtomicInteger index = new AtomicInteger();
		shippingSpaceList.stream().forEach(shippingSpace->
			commonObjectElementCheck(shippingSpace,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixShippingSpace));
		return this;
	}

	public YoubenbenObjectChecker checkDamageSpaceListOfWarehouse(List<BaseEntity> damageSpaceList){
		AtomicInteger index = new AtomicInteger();
		damageSpaceList.stream().forEach(damageSpace->
			commonObjectElementCheck(damageSpace,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDamageSpace));
		return this;
	}

	public YoubenbenObjectChecker checkWarehouseAssetListOfWarehouse(List<BaseEntity> warehouseAssetList){
		AtomicInteger index = new AtomicInteger();
		warehouseAssetList.stream().forEach(warehouseAsset->
			commonObjectElementCheck(warehouseAsset,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWarehouseAsset));
		return this;
	}

	public static final String OWNER_OF_WAREHOUSE = "warehouse.owner";


	public YoubenbenObjectChecker checkOwnerOfWarehouse(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_WAREHOUSE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(ownerAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsShelfListOfStorageSpace(List<BaseEntity> goodsShelfList){
		AtomicInteger index = new AtomicInteger();
		goodsShelfList.stream().forEach(goodsShelf->
			commonObjectElementCheck(goodsShelf,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoodsShelf));
		return this;
	}

	public static final String WAREHOUSE_OF_STORAGE_SPACE = "storage_space.warehouse";


	public YoubenbenObjectChecker checkWarehouseOfStorageSpace(BaseEntity warehouseAsBaseEntity){

		if(warehouseAsBaseEntity == null){
			checkBaseEntityReference(warehouseAsBaseEntity,true,WAREHOUSE_OF_STORAGE_SPACE);
			return this;
		}
		checkAndFixWarehouse(warehouseAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsListOfSmartPallet(List<BaseEntity> goodsList){
		AtomicInteger index = new AtomicInteger();
		goodsList.stream().forEach(goods->
			commonObjectElementCheck(goods,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoods));
		return this;
	}

	public static final String WAREHOUSE_OF_SMART_PALLET = "smart_pallet.warehouse";


	public YoubenbenObjectChecker checkWarehouseOfSmartPallet(BaseEntity warehouseAsBaseEntity){

		if(warehouseAsBaseEntity == null){
			checkBaseEntityReference(warehouseAsBaseEntity,true,WAREHOUSE_OF_SMART_PALLET);
			return this;
		}
		checkAndFixWarehouse(warehouseAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsShelfStockCountListOfGoodsShelf(List<BaseEntity> goodsShelfStockCountList){
		AtomicInteger index = new AtomicInteger();
		goodsShelfStockCountList.stream().forEach(goodsShelfStockCount->
			commonObjectElementCheck(goodsShelfStockCount,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoodsShelfStockCount));
		return this;
	}

	public YoubenbenObjectChecker checkGoodsAllocationListOfGoodsShelf(List<BaseEntity> goodsAllocationList){
		AtomicInteger index = new AtomicInteger();
		goodsAllocationList.stream().forEach(goodsAllocation->
			commonObjectElementCheck(goodsAllocation,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoodsAllocation));
		return this;
	}

	public static final String STORAGE_SPACE_OF_GOODS_SHELF = "goods_shelf.storage_space";


	public YoubenbenObjectChecker checkStorageSpaceOfGoodsShelf(BaseEntity storageSpaceAsBaseEntity){

		if(storageSpaceAsBaseEntity == null){
			checkBaseEntityReference(storageSpaceAsBaseEntity,true,STORAGE_SPACE_OF_GOODS_SHELF);
			return this;
		}
		checkAndFixStorageSpace(storageSpaceAsBaseEntity);
		return this;
	}


	public static final String SUPPLIER_SPACE_OF_GOODS_SHELF = "goods_shelf.supplier_space";


	public YoubenbenObjectChecker checkSupplierSpaceOfGoodsShelf(BaseEntity supplierSpaceAsBaseEntity){

		if(supplierSpaceAsBaseEntity == null){
			checkBaseEntityReference(supplierSpaceAsBaseEntity,true,SUPPLIER_SPACE_OF_GOODS_SHELF);
			return this;
		}
		checkAndFixSupplierSpace(supplierSpaceAsBaseEntity);
		return this;
	}


	public static final String DAMAGE_SPACE_OF_GOODS_SHELF = "goods_shelf.damage_space";


	public YoubenbenObjectChecker checkDamageSpaceOfGoodsShelf(BaseEntity damageSpaceAsBaseEntity){

		if(damageSpaceAsBaseEntity == null){
			checkBaseEntityReference(damageSpaceAsBaseEntity,true,DAMAGE_SPACE_OF_GOODS_SHELF);
			return this;
		}
		checkAndFixDamageSpace(damageSpaceAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkStockCountIssueTrackListOfGoodsShelfStockCount(List<BaseEntity> stockCountIssueTrackList){
		AtomicInteger index = new AtomicInteger();
		stockCountIssueTrackList.stream().forEach(stockCountIssueTrack->
			commonObjectElementCheck(stockCountIssueTrack,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixStockCountIssueTrack));
		return this;
	}

	public static final String SHELF_OF_GOODS_SHELF_STOCK_COUNT = "goods_shelf_stock_count.shelf";


	public YoubenbenObjectChecker checkShelfOfGoodsShelfStockCount(BaseEntity shelfAsBaseEntity){

		if(shelfAsBaseEntity == null){
			checkBaseEntityReference(shelfAsBaseEntity,true,SHELF_OF_GOODS_SHELF_STOCK_COUNT);
			return this;
		}
		checkAndFixGoodsShelf(shelfAsBaseEntity);
		return this;
	}


	public static final String STOCK_COUNT_OF_STOCK_COUNT_ISSUE_TRACK = "stock_count_issue_track.stock_count";


	public YoubenbenObjectChecker checkStockCountOfStockCountIssueTrack(BaseEntity stockCountAsBaseEntity){

		if(stockCountAsBaseEntity == null){
			checkBaseEntityReference(stockCountAsBaseEntity,true,STOCK_COUNT_OF_STOCK_COUNT_ISSUE_TRACK);
			return this;
		}
		checkAndFixGoodsShelfStockCount(stockCountAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsListOfGoodsAllocation(List<BaseEntity> goodsList){
		AtomicInteger index = new AtomicInteger();
		goodsList.stream().forEach(goods->
			commonObjectElementCheck(goods,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoods));
		return this;
	}

	public static final String GOODS_SHELF_OF_GOODS_ALLOCATION = "goods_allocation.goods_shelf";


	public YoubenbenObjectChecker checkGoodsShelfOfGoodsAllocation(BaseEntity goodsShelfAsBaseEntity){

		if(goodsShelfAsBaseEntity == null){
			checkBaseEntityReference(goodsShelfAsBaseEntity,true,GOODS_SHELF_OF_GOODS_ALLOCATION);
			return this;
		}
		checkAndFixGoodsShelf(goodsShelfAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsMovementListOfGoods(List<BaseEntity> goodsMovementList){
		AtomicInteger index = new AtomicInteger();
		goodsMovementList.stream().forEach(goodsMovement->
			commonObjectElementCheck(goodsMovement,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoodsMovement));
		return this;
	}

	public static final String SKU_OF_GOODS = "goods.sku";


	public YoubenbenObjectChecker checkSkuOfGoods(BaseEntity skuAsBaseEntity){

		if(skuAsBaseEntity == null){
			checkBaseEntityReference(skuAsBaseEntity,true,SKU_OF_GOODS);
			return this;
		}
		checkAndFixSku(skuAsBaseEntity);
		return this;
	}


	public static final String RECEIVING_SPACE_OF_GOODS = "goods.receiving_space";


	public YoubenbenObjectChecker checkReceivingSpaceOfGoods(BaseEntity receivingSpaceAsBaseEntity){

		if(receivingSpaceAsBaseEntity == null){
			checkBaseEntityReference(receivingSpaceAsBaseEntity,true,RECEIVING_SPACE_OF_GOODS);
			return this;
		}
		checkAndFixReceivingSpace(receivingSpaceAsBaseEntity);
		return this;
	}


	public static final String GOODS_ALLOCATION_OF_GOODS = "goods.goods_allocation";


	public YoubenbenObjectChecker checkGoodsAllocationOfGoods(BaseEntity goodsAllocationAsBaseEntity){

		if(goodsAllocationAsBaseEntity == null){
			checkBaseEntityReference(goodsAllocationAsBaseEntity,true,GOODS_ALLOCATION_OF_GOODS);
			return this;
		}
		checkAndFixGoodsAllocation(goodsAllocationAsBaseEntity);
		return this;
	}


	public static final String SMART_PALLET_OF_GOODS = "goods.smart_pallet";


	public YoubenbenObjectChecker checkSmartPalletOfGoods(BaseEntity smartPalletAsBaseEntity){

		if(smartPalletAsBaseEntity == null){
			checkBaseEntityReference(smartPalletAsBaseEntity,true,SMART_PALLET_OF_GOODS);
			return this;
		}
		checkAndFixSmartPallet(smartPalletAsBaseEntity);
		return this;
	}


	public static final String SHIPPING_SPACE_OF_GOODS = "goods.shipping_space";


	public YoubenbenObjectChecker checkShippingSpaceOfGoods(BaseEntity shippingSpaceAsBaseEntity){

		if(shippingSpaceAsBaseEntity == null){
			checkBaseEntityReference(shippingSpaceAsBaseEntity,true,SHIPPING_SPACE_OF_GOODS);
			return this;
		}
		checkAndFixShippingSpace(shippingSpaceAsBaseEntity);
		return this;
	}


	public static final String TRANSPORT_TASK_OF_GOODS = "goods.transport_task";


	public YoubenbenObjectChecker checkTransportTaskOfGoods(BaseEntity transportTaskAsBaseEntity){

		if(transportTaskAsBaseEntity == null){
			checkBaseEntityReference(transportTaskAsBaseEntity,true,TRANSPORT_TASK_OF_GOODS);
			return this;
		}
		checkAndFixTransportTask(transportTaskAsBaseEntity);
		return this;
	}


	public static final String RETAIL_STORE_OF_GOODS = "goods.retail_store";


	public YoubenbenObjectChecker checkRetailStoreOfGoods(BaseEntity retailStoreAsBaseEntity){

		if(retailStoreAsBaseEntity == null){
			checkBaseEntityReference(retailStoreAsBaseEntity,true,RETAIL_STORE_OF_GOODS);
			return this;
		}
		checkAndFixRetailStore(retailStoreAsBaseEntity);
		return this;
	}


	public static final String BIZ_ORDER_OF_GOODS = "goods.biz_order";


	public YoubenbenObjectChecker checkBizOrderOfGoods(BaseEntity bizOrderAsBaseEntity){

		if(bizOrderAsBaseEntity == null){
			checkBaseEntityReference(bizOrderAsBaseEntity,true,BIZ_ORDER_OF_GOODS);
			return this;
		}
		checkAndFixSupplyOrder(bizOrderAsBaseEntity);
		return this;
	}


	public static final String RETAIL_STORE_ORDER_OF_GOODS = "goods.retail_store_order";


	public YoubenbenObjectChecker checkRetailStoreOrderOfGoods(BaseEntity retailStoreOrderAsBaseEntity){

		if(retailStoreOrderAsBaseEntity == null){
			checkBaseEntityReference(retailStoreOrderAsBaseEntity,true,RETAIL_STORE_ORDER_OF_GOODS);
			return this;
		}
		checkAndFixRetailStoreOrder(retailStoreOrderAsBaseEntity);
		return this;
	}


	public static final String PACKAGING_OF_GOODS = "goods.packaging";


	public YoubenbenObjectChecker checkPackagingOfGoods(BaseEntity packagingAsBaseEntity){

		if(packagingAsBaseEntity == null){
			checkBaseEntityReference(packagingAsBaseEntity,true,PACKAGING_OF_GOODS);
			return this;
		}
		checkAndFixGoodsPackaging(packagingAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsListOfGoodsPackaging(List<BaseEntity> goodsList){
		AtomicInteger index = new AtomicInteger();
		goodsList.stream().forEach(goods->
			commonObjectElementCheck(goods,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoods));
		return this;
	}

	public static final String GOODS_OF_GOODS_MOVEMENT = "goods_movement.goods";


	public YoubenbenObjectChecker checkGoodsOfGoodsMovement(BaseEntity goodsAsBaseEntity){

		if(goodsAsBaseEntity == null){
			checkBaseEntityReference(goodsAsBaseEntity,true,GOODS_OF_GOODS_MOVEMENT);
			return this;
		}
		checkAndFixGoods(goodsAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsShelfListOfSupplierSpace(List<BaseEntity> goodsShelfList){
		AtomicInteger index = new AtomicInteger();
		goodsShelfList.stream().forEach(goodsShelf->
			commonObjectElementCheck(goodsShelf,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoodsShelf));
		return this;
	}

	public static final String WAREHOUSE_OF_SUPPLIER_SPACE = "supplier_space.warehouse";


	public YoubenbenObjectChecker checkWarehouseOfSupplierSpace(BaseEntity warehouseAsBaseEntity){

		if(warehouseAsBaseEntity == null){
			checkBaseEntityReference(warehouseAsBaseEntity,true,WAREHOUSE_OF_SUPPLIER_SPACE);
			return this;
		}
		checkAndFixWarehouse(warehouseAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsListOfReceivingSpace(List<BaseEntity> goodsList){
		AtomicInteger index = new AtomicInteger();
		goodsList.stream().forEach(goods->
			commonObjectElementCheck(goods,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoods));
		return this;
	}

	public static final String WAREHOUSE_OF_RECEIVING_SPACE = "receiving_space.warehouse";


	public YoubenbenObjectChecker checkWarehouseOfReceivingSpace(BaseEntity warehouseAsBaseEntity){

		if(warehouseAsBaseEntity == null){
			checkBaseEntityReference(warehouseAsBaseEntity,true,WAREHOUSE_OF_RECEIVING_SPACE);
			return this;
		}
		checkAndFixWarehouse(warehouseAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsListOfShippingSpace(List<BaseEntity> goodsList){
		AtomicInteger index = new AtomicInteger();
		goodsList.stream().forEach(goods->
			commonObjectElementCheck(goods,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoods));
		return this;
	}

	public static final String WAREHOUSE_OF_SHIPPING_SPACE = "shipping_space.warehouse";


	public YoubenbenObjectChecker checkWarehouseOfShippingSpace(BaseEntity warehouseAsBaseEntity){

		if(warehouseAsBaseEntity == null){
			checkBaseEntityReference(warehouseAsBaseEntity,true,WAREHOUSE_OF_SHIPPING_SPACE);
			return this;
		}
		checkAndFixWarehouse(warehouseAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsShelfListOfDamageSpace(List<BaseEntity> goodsShelfList){
		AtomicInteger index = new AtomicInteger();
		goodsShelfList.stream().forEach(goodsShelf->
			commonObjectElementCheck(goodsShelf,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoodsShelf));
		return this;
	}

	public static final String WAREHOUSE_OF_DAMAGE_SPACE = "damage_space.warehouse";


	public YoubenbenObjectChecker checkWarehouseOfDamageSpace(BaseEntity warehouseAsBaseEntity){

		if(warehouseAsBaseEntity == null){
			checkBaseEntityReference(warehouseAsBaseEntity,true,WAREHOUSE_OF_DAMAGE_SPACE);
			return this;
		}
		checkAndFixWarehouse(warehouseAsBaseEntity);
		return this;
	}


	public static final String OWNER_OF_WAREHOUSE_ASSET = "warehouse_asset.owner";


	public YoubenbenObjectChecker checkOwnerOfWarehouseAsset(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_WAREHOUSE_ASSET);
			return this;
		}
		checkAndFixWarehouse(ownerAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkTransportTruckListOfTransportFleet(List<BaseEntity> transportTruckList){
		AtomicInteger index = new AtomicInteger();
		transportTruckList.stream().forEach(transportTruck->
			commonObjectElementCheck(transportTruck,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTransportTruck));
		return this;
	}

	public YoubenbenObjectChecker checkTruckDriverListOfTransportFleet(List<BaseEntity> truckDriverList){
		AtomicInteger index = new AtomicInteger();
		truckDriverList.stream().forEach(truckDriver->
			commonObjectElementCheck(truckDriver,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTruckDriver));
		return this;
	}

	public YoubenbenObjectChecker checkTransportTaskListOfTransportFleet(List<BaseEntity> transportTaskList){
		AtomicInteger index = new AtomicInteger();
		transportTaskList.stream().forEach(transportTask->
			commonObjectElementCheck(transportTask,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTransportTask));
		return this;
	}

	public static final String OWNER_OF_TRANSPORT_FLEET = "transport_fleet.owner";


	public YoubenbenObjectChecker checkOwnerOfTransportFleet(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_TRANSPORT_FLEET);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(ownerAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkTransportTaskListOfTransportTruck(List<BaseEntity> transportTaskList){
		AtomicInteger index = new AtomicInteger();
		transportTaskList.stream().forEach(transportTask->
			commonObjectElementCheck(transportTask,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTransportTask));
		return this;
	}

	public static final String OWNER_OF_TRANSPORT_TRUCK = "transport_truck.owner";


	public YoubenbenObjectChecker checkOwnerOfTransportTruck(BaseEntity ownerAsBaseEntity){

		if(ownerAsBaseEntity == null){
			checkBaseEntityReference(ownerAsBaseEntity,true,OWNER_OF_TRANSPORT_TRUCK);
			return this;
		}
		checkAndFixTransportFleet(ownerAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkTransportTaskListOfTruckDriver(List<BaseEntity> transportTaskList){
		AtomicInteger index = new AtomicInteger();
		transportTaskList.stream().forEach(transportTask->
			commonObjectElementCheck(transportTask,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTransportTask));
		return this;
	}

	public static final String BELONGS_TO_OF_TRUCK_DRIVER = "truck_driver.belongs_to";


	public YoubenbenObjectChecker checkBelongsToOfTruckDriver(BaseEntity belongsToAsBaseEntity){

		if(belongsToAsBaseEntity == null){
			checkBaseEntityReference(belongsToAsBaseEntity,true,BELONGS_TO_OF_TRUCK_DRIVER);
			return this;
		}
		checkAndFixTransportFleet(belongsToAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkGoodsListOfTransportTask(List<BaseEntity> goodsList){
		AtomicInteger index = new AtomicInteger();
		goodsList.stream().forEach(goods->
			commonObjectElementCheck(goods,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGoods));
		return this;
	}

	public YoubenbenObjectChecker checkTransportTaskTrackListOfTransportTask(List<BaseEntity> transportTaskTrackList){
		AtomicInteger index = new AtomicInteger();
		transportTaskTrackList.stream().forEach(transportTaskTrack->
			commonObjectElementCheck(transportTaskTrack,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTransportTaskTrack));
		return this;
	}

	public static final String END_OF_TRANSPORT_TASK = "transport_task.end";


	public YoubenbenObjectChecker checkEndOfTransportTask(BaseEntity endAsBaseEntity){

		if(endAsBaseEntity == null){
			checkBaseEntityReference(endAsBaseEntity,true,END_OF_TRANSPORT_TASK);
			return this;
		}
		checkAndFixRetailStore(endAsBaseEntity);
		return this;
	}


	public static final String DRIVER_OF_TRANSPORT_TASK = "transport_task.driver";


	public YoubenbenObjectChecker checkDriverOfTransportTask(BaseEntity driverAsBaseEntity){

		if(driverAsBaseEntity == null){
			checkBaseEntityReference(driverAsBaseEntity,true,DRIVER_OF_TRANSPORT_TASK);
			return this;
		}
		checkAndFixTruckDriver(driverAsBaseEntity);
		return this;
	}


	public static final String TRUCK_OF_TRANSPORT_TASK = "transport_task.truck";


	public YoubenbenObjectChecker checkTruckOfTransportTask(BaseEntity truckAsBaseEntity){

		if(truckAsBaseEntity == null){
			checkBaseEntityReference(truckAsBaseEntity,true,TRUCK_OF_TRANSPORT_TASK);
			return this;
		}
		checkAndFixTransportTruck(truckAsBaseEntity);
		return this;
	}


	public static final String BELONGS_TO_OF_TRANSPORT_TASK = "transport_task.belongs_to";


	public YoubenbenObjectChecker checkBelongsToOfTransportTask(BaseEntity belongsToAsBaseEntity){

		if(belongsToAsBaseEntity == null){
			checkBaseEntityReference(belongsToAsBaseEntity,true,BELONGS_TO_OF_TRANSPORT_TASK);
			return this;
		}
		checkAndFixTransportFleet(belongsToAsBaseEntity);
		return this;
	}


	public static final String MOVEMENT_OF_TRANSPORT_TASK_TRACK = "transport_task_track.movement";


	public YoubenbenObjectChecker checkMovementOfTransportTaskTrack(BaseEntity movementAsBaseEntity){

		if(movementAsBaseEntity == null){
			checkBaseEntityReference(movementAsBaseEntity,true,MOVEMENT_OF_TRANSPORT_TASK_TRACK);
			return this;
		}
		checkAndFixTransportTask(movementAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkAccountingSubjectListOfAccountSet(List<BaseEntity> accountingSubjectList){
		AtomicInteger index = new AtomicInteger();
		accountingSubjectList.stream().forEach(accountingSubject->
			commonObjectElementCheck(accountingSubject,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingSubject));
		return this;
	}

	public YoubenbenObjectChecker checkAccountingPeriodListOfAccountSet(List<BaseEntity> accountingPeriodList){
		AtomicInteger index = new AtomicInteger();
		accountingPeriodList.stream().forEach(accountingPeriod->
			commonObjectElementCheck(accountingPeriod,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingPeriod));
		return this;
	}

	public YoubenbenObjectChecker checkAccountingDocumentTypeListOfAccountSet(List<BaseEntity> accountingDocumentTypeList){
		AtomicInteger index = new AtomicInteger();
		accountingDocumentTypeList.stream().forEach(accountingDocumentType->
			commonObjectElementCheck(accountingDocumentType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingDocumentType));
		return this;
	}

	public static final String COUNTRY_CENTER_OF_ACCOUNT_SET = "account_set.country_center";


	public YoubenbenObjectChecker checkCountryCenterOfAccountSet(BaseEntity countryCenterAsBaseEntity){

		if(countryCenterAsBaseEntity == null){
			checkBaseEntityReference(countryCenterAsBaseEntity,true,COUNTRY_CENTER_OF_ACCOUNT_SET);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(countryCenterAsBaseEntity);
		return this;
	}


	public static final String RETAIL_STORE_OF_ACCOUNT_SET = "account_set.retail_store";


	public YoubenbenObjectChecker checkRetailStoreOfAccountSet(BaseEntity retailStoreAsBaseEntity){

		if(retailStoreAsBaseEntity == null){
			checkBaseEntityReference(retailStoreAsBaseEntity,true,RETAIL_STORE_OF_ACCOUNT_SET);
			return this;
		}
		checkAndFixRetailStore(retailStoreAsBaseEntity);
		return this;
	}


	public static final String GOODS_SUPPLIER_OF_ACCOUNT_SET = "account_set.goods_supplier";


	public YoubenbenObjectChecker checkGoodsSupplierOfAccountSet(BaseEntity goodsSupplierAsBaseEntity){

		if(goodsSupplierAsBaseEntity == null){
			checkBaseEntityReference(goodsSupplierAsBaseEntity,true,GOODS_SUPPLIER_OF_ACCOUNT_SET);
			return this;
		}
		checkAndFixGoodsSupplier(goodsSupplierAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkAccountingDocumentLineListOfAccountingSubject(List<BaseEntity> accountingDocumentLineList){
		AtomicInteger index = new AtomicInteger();
		accountingDocumentLineList.stream().forEach(accountingDocumentLine->
			commonObjectElementCheck(accountingDocumentLine,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingDocumentLine));
		return this;
	}

	public static final String ACCOUNT_SET_OF_ACCOUNTING_SUBJECT = "accounting_subject.account_set";


	public YoubenbenObjectChecker checkAccountSetOfAccountingSubject(BaseEntity accountSetAsBaseEntity){

		if(accountSetAsBaseEntity == null){
			checkBaseEntityReference(accountSetAsBaseEntity,true,ACCOUNT_SET_OF_ACCOUNTING_SUBJECT);
			return this;
		}
		checkAndFixAccountSet(accountSetAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkAccountingDocumentListOfAccountingPeriod(List<BaseEntity> accountingDocumentList){
		AtomicInteger index = new AtomicInteger();
		accountingDocumentList.stream().forEach(accountingDocument->
			commonObjectElementCheck(accountingDocument,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingDocument));
		return this;
	}

	public static final String ACCOUNT_SET_OF_ACCOUNTING_PERIOD = "accounting_period.account_set";


	public YoubenbenObjectChecker checkAccountSetOfAccountingPeriod(BaseEntity accountSetAsBaseEntity){

		if(accountSetAsBaseEntity == null){
			checkBaseEntityReference(accountSetAsBaseEntity,true,ACCOUNT_SET_OF_ACCOUNTING_PERIOD);
			return this;
		}
		checkAndFixAccountSet(accountSetAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkAccountingDocumentListOfAccountingDocumentType(List<BaseEntity> accountingDocumentList){
		AtomicInteger index = new AtomicInteger();
		accountingDocumentList.stream().forEach(accountingDocument->
			commonObjectElementCheck(accountingDocument,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingDocument));
		return this;
	}

	public static final String ACCOUNTING_PERIOD_OF_ACCOUNTING_DOCUMENT_TYPE = "accounting_document_type.accounting_period";


	public YoubenbenObjectChecker checkAccountingPeriodOfAccountingDocumentType(BaseEntity accountingPeriodAsBaseEntity){

		if(accountingPeriodAsBaseEntity == null){
			checkBaseEntityReference(accountingPeriodAsBaseEntity,true,ACCOUNTING_PERIOD_OF_ACCOUNTING_DOCUMENT_TYPE);
			return this;
		}
		checkAndFixAccountSet(accountingPeriodAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkOriginalVoucherListOfAccountingDocument(List<BaseEntity> originalVoucherList){
		AtomicInteger index = new AtomicInteger();
		originalVoucherList.stream().forEach(originalVoucher->
			commonObjectElementCheck(originalVoucher,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixOriginalVoucher));
		return this;
	}

	public YoubenbenObjectChecker checkAccountingDocumentLineListOfAccountingDocument(List<BaseEntity> accountingDocumentLineList){
		AtomicInteger index = new AtomicInteger();
		accountingDocumentLineList.stream().forEach(accountingDocumentLine->
			commonObjectElementCheck(accountingDocumentLine,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingDocumentLine));
		return this;
	}

	public static final String ACCOUNTING_PERIOD_OF_ACCOUNTING_DOCUMENT = "accounting_document.accounting_period";


	public YoubenbenObjectChecker checkAccountingPeriodOfAccountingDocument(BaseEntity accountingPeriodAsBaseEntity){

		if(accountingPeriodAsBaseEntity == null){
			checkBaseEntityReference(accountingPeriodAsBaseEntity,true,ACCOUNTING_PERIOD_OF_ACCOUNTING_DOCUMENT);
			return this;
		}
		checkAndFixAccountingPeriod(accountingPeriodAsBaseEntity);
		return this;
	}


	public static final String DOCUMENT_TYPE_OF_ACCOUNTING_DOCUMENT = "accounting_document.document_type";


	public YoubenbenObjectChecker checkDocumentTypeOfAccountingDocument(BaseEntity documentTypeAsBaseEntity){

		if(documentTypeAsBaseEntity == null){
			checkBaseEntityReference(documentTypeAsBaseEntity,true,DOCUMENT_TYPE_OF_ACCOUNTING_DOCUMENT);
			return this;
		}
		checkAndFixAccountingDocumentType(documentTypeAsBaseEntity);
		return this;
	}


	public static final String CREATION_OF_ACCOUNTING_DOCUMENT = "accounting_document.creation";


	public YoubenbenObjectChecker checkCreationOfAccountingDocument(BaseEntity creationAsBaseEntity){

		if(creationAsBaseEntity == null){
			checkBaseEntityReference(creationAsBaseEntity,true,CREATION_OF_ACCOUNTING_DOCUMENT);
			return this;
		}
		checkAndFixAccountingDocumentCreation(creationAsBaseEntity);
		return this;
	}


	public static final String CONFIRMATION_OF_ACCOUNTING_DOCUMENT = "accounting_document.confirmation";


	public YoubenbenObjectChecker checkConfirmationOfAccountingDocument(BaseEntity confirmationAsBaseEntity){

		if(confirmationAsBaseEntity == null){
			checkBaseEntityReference(confirmationAsBaseEntity,true,CONFIRMATION_OF_ACCOUNTING_DOCUMENT);
			return this;
		}
		checkAndFixAccountingDocumentConfirmation(confirmationAsBaseEntity);
		return this;
	}


	public static final String AUDITING_OF_ACCOUNTING_DOCUMENT = "accounting_document.auditing";


	public YoubenbenObjectChecker checkAuditingOfAccountingDocument(BaseEntity auditingAsBaseEntity){

		if(auditingAsBaseEntity == null){
			checkBaseEntityReference(auditingAsBaseEntity,true,AUDITING_OF_ACCOUNTING_DOCUMENT);
			return this;
		}
		checkAndFixAccountingDocumentAuditing(auditingAsBaseEntity);
		return this;
	}


	public static final String POSTING_OF_ACCOUNTING_DOCUMENT = "accounting_document.posting";


	public YoubenbenObjectChecker checkPostingOfAccountingDocument(BaseEntity postingAsBaseEntity){

		if(postingAsBaseEntity == null){
			checkBaseEntityReference(postingAsBaseEntity,true,POSTING_OF_ACCOUNTING_DOCUMENT);
			return this;
		}
		checkAndFixAccountingDocumentPosting(postingAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkAccountingDocumentListOfAccountingDocumentCreation(List<BaseEntity> accountingDocumentList){
		AtomicInteger index = new AtomicInteger();
		accountingDocumentList.stream().forEach(accountingDocument->
			commonObjectElementCheck(accountingDocument,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingDocument));
		return this;
	}

	public YoubenbenObjectChecker checkAccountingDocumentListOfAccountingDocumentConfirmation(List<BaseEntity> accountingDocumentList){
		AtomicInteger index = new AtomicInteger();
		accountingDocumentList.stream().forEach(accountingDocument->
			commonObjectElementCheck(accountingDocument,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingDocument));
		return this;
	}

	public YoubenbenObjectChecker checkAccountingDocumentListOfAccountingDocumentAuditing(List<BaseEntity> accountingDocumentList){
		AtomicInteger index = new AtomicInteger();
		accountingDocumentList.stream().forEach(accountingDocument->
			commonObjectElementCheck(accountingDocument,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingDocument));
		return this;
	}

	public YoubenbenObjectChecker checkAccountingDocumentListOfAccountingDocumentPosting(List<BaseEntity> accountingDocumentList){
		AtomicInteger index = new AtomicInteger();
		accountingDocumentList.stream().forEach(accountingDocument->
			commonObjectElementCheck(accountingDocument,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountingDocument));
		return this;
	}

	public static final String BELONGS_TO_OF_ORIGINAL_VOUCHER = "original_voucher.belongs_to";


	public YoubenbenObjectChecker checkBelongsToOfOriginalVoucher(BaseEntity belongsToAsBaseEntity){

		if(belongsToAsBaseEntity == null){
			checkBaseEntityReference(belongsToAsBaseEntity,true,BELONGS_TO_OF_ORIGINAL_VOUCHER);
			return this;
		}
		checkAndFixAccountingDocument(belongsToAsBaseEntity);
		return this;
	}


	public static final String CREATION_OF_ORIGINAL_VOUCHER = "original_voucher.creation";


	public YoubenbenObjectChecker checkCreationOfOriginalVoucher(BaseEntity creationAsBaseEntity){

		if(creationAsBaseEntity == null){
			checkBaseEntityReference(creationAsBaseEntity,true,CREATION_OF_ORIGINAL_VOUCHER);
			return this;
		}
		checkAndFixOriginalVoucherCreation(creationAsBaseEntity);
		return this;
	}


	public static final String CONFIRMATION_OF_ORIGINAL_VOUCHER = "original_voucher.confirmation";


	public YoubenbenObjectChecker checkConfirmationOfOriginalVoucher(BaseEntity confirmationAsBaseEntity){

		if(confirmationAsBaseEntity == null){
			checkBaseEntityReference(confirmationAsBaseEntity,true,CONFIRMATION_OF_ORIGINAL_VOUCHER);
			return this;
		}
		checkAndFixOriginalVoucherConfirmation(confirmationAsBaseEntity);
		return this;
	}


	public static final String AUDITING_OF_ORIGINAL_VOUCHER = "original_voucher.auditing";


	public YoubenbenObjectChecker checkAuditingOfOriginalVoucher(BaseEntity auditingAsBaseEntity){

		if(auditingAsBaseEntity == null){
			checkBaseEntityReference(auditingAsBaseEntity,true,AUDITING_OF_ORIGINAL_VOUCHER);
			return this;
		}
		checkAndFixOriginalVoucherAuditing(auditingAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkOriginalVoucherListOfOriginalVoucherCreation(List<BaseEntity> originalVoucherList){
		AtomicInteger index = new AtomicInteger();
		originalVoucherList.stream().forEach(originalVoucher->
			commonObjectElementCheck(originalVoucher,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixOriginalVoucher));
		return this;
	}

	public YoubenbenObjectChecker checkOriginalVoucherListOfOriginalVoucherConfirmation(List<BaseEntity> originalVoucherList){
		AtomicInteger index = new AtomicInteger();
		originalVoucherList.stream().forEach(originalVoucher->
			commonObjectElementCheck(originalVoucher,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixOriginalVoucher));
		return this;
	}

	public YoubenbenObjectChecker checkOriginalVoucherListOfOriginalVoucherAuditing(List<BaseEntity> originalVoucherList){
		AtomicInteger index = new AtomicInteger();
		originalVoucherList.stream().forEach(originalVoucher->
			commonObjectElementCheck(originalVoucher,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixOriginalVoucher));
		return this;
	}

	public static final String BELONGS_TO_OF_ACCOUNTING_DOCUMENT_LINE = "accounting_document_line.belongs_to";


	public YoubenbenObjectChecker checkBelongsToOfAccountingDocumentLine(BaseEntity belongsToAsBaseEntity){

		if(belongsToAsBaseEntity == null){
			checkBaseEntityReference(belongsToAsBaseEntity,true,BELONGS_TO_OF_ACCOUNTING_DOCUMENT_LINE);
			return this;
		}
		checkAndFixAccountingDocument(belongsToAsBaseEntity);
		return this;
	}


	public static final String ACCOUNTING_SUBJECT_OF_ACCOUNTING_DOCUMENT_LINE = "accounting_document_line.accounting_subject";


	public YoubenbenObjectChecker checkAccountingSubjectOfAccountingDocumentLine(BaseEntity accountingSubjectAsBaseEntity){

		if(accountingSubjectAsBaseEntity == null){
			checkBaseEntityReference(accountingSubjectAsBaseEntity,true,ACCOUNTING_SUBJECT_OF_ACCOUNTING_DOCUMENT_LINE);
			return this;
		}
		checkAndFixAccountingSubject(accountingSubjectAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkLevelTwoDepartmentListOfLevelOneDepartment(List<BaseEntity> levelTwoDepartmentList){
		AtomicInteger index = new AtomicInteger();
		levelTwoDepartmentList.stream().forEach(levelTwoDepartment->
			commonObjectElementCheck(levelTwoDepartment,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLevelTwoDepartment));
		return this;
	}

	public static final String BELONGS_TO_OF_LEVEL_ONE_DEPARTMENT = "level_one_department.belongs_to";


	public YoubenbenObjectChecker checkBelongsToOfLevelOneDepartment(BaseEntity belongsToAsBaseEntity){

		if(belongsToAsBaseEntity == null){
			checkBaseEntityReference(belongsToAsBaseEntity,true,BELONGS_TO_OF_LEVEL_ONE_DEPARTMENT);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(belongsToAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkLevelThreeDepartmentListOfLevelTwoDepartment(List<BaseEntity> levelThreeDepartmentList){
		AtomicInteger index = new AtomicInteger();
		levelThreeDepartmentList.stream().forEach(levelThreeDepartment->
			commonObjectElementCheck(levelThreeDepartment,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLevelThreeDepartment));
		return this;
	}

	public static final String BELONGS_TO_OF_LEVEL_TWO_DEPARTMENT = "level_two_department.belongs_to";


	public YoubenbenObjectChecker checkBelongsToOfLevelTwoDepartment(BaseEntity belongsToAsBaseEntity){

		if(belongsToAsBaseEntity == null){
			checkBaseEntityReference(belongsToAsBaseEntity,true,BELONGS_TO_OF_LEVEL_TWO_DEPARTMENT);
			return this;
		}
		checkAndFixLevelOneDepartment(belongsToAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeListOfLevelThreeDepartment(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public static final String BELONGS_TO_OF_LEVEL_THREE_DEPARTMENT = "level_three_department.belongs_to";


	public YoubenbenObjectChecker checkBelongsToOfLevelThreeDepartment(BaseEntity belongsToAsBaseEntity){

		if(belongsToAsBaseEntity == null){
			checkBaseEntityReference(belongsToAsBaseEntity,true,BELONGS_TO_OF_LEVEL_THREE_DEPARTMENT);
			return this;
		}
		checkAndFixLevelTwoDepartment(belongsToAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeSkillListOfSkillType(List<BaseEntity> employeeSkillList){
		AtomicInteger index = new AtomicInteger();
		employeeSkillList.stream().forEach(employeeSkill->
			commonObjectElementCheck(employeeSkill,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeSkill));
		return this;
	}

	public static final String COMPANY_OF_SKILL_TYPE = "skill_type.company";


	public YoubenbenObjectChecker checkCompanyOfSkillType(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_SKILL_TYPE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeListOfResponsibilityType(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public static final String COMPANY_OF_RESPONSIBILITY_TYPE = "responsibility_type.company";


	public YoubenbenObjectChecker checkCompanyOfResponsibilityType(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_RESPONSIBILITY_TYPE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkTerminationListOfTerminationReason(List<BaseEntity> terminationList){
		AtomicInteger index = new AtomicInteger();
		terminationList.stream().forEach(termination->
			commonObjectElementCheck(termination,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTermination));
		return this;
	}

	public static final String COMPANY_OF_TERMINATION_REASON = "termination_reason.company";


	public YoubenbenObjectChecker checkCompanyOfTerminationReason(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_TERMINATION_REASON);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkTerminationListOfTerminationType(List<BaseEntity> terminationList){
		AtomicInteger index = new AtomicInteger();
		terminationList.stream().forEach(termination->
			commonObjectElementCheck(termination,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTermination));
		return this;
	}

	public static final String COMPANY_OF_TERMINATION_TYPE = "termination_type.company";


	public YoubenbenObjectChecker checkCompanyOfTerminationType(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_TERMINATION_TYPE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeListOfOccupationType(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public static final String COMPANY_OF_OCCUPATION_TYPE = "occupation_type.company";


	public YoubenbenObjectChecker checkCompanyOfOccupationType(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_OCCUPATION_TYPE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeLeaveListOfLeaveType(List<BaseEntity> employeeLeaveList){
		AtomicInteger index = new AtomicInteger();
		employeeLeaveList.stream().forEach(employeeLeave->
			commonObjectElementCheck(employeeLeave,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeLeave));
		return this;
	}

	public static final String COMPANY_OF_LEAVE_TYPE = "leave_type.company";


	public YoubenbenObjectChecker checkCompanyOfLeaveType(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_LEAVE_TYPE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeListOfSalaryGrade(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeSalarySheetListOfSalaryGrade(List<BaseEntity> employeeSalarySheetList){
		AtomicInteger index = new AtomicInteger();
		employeeSalarySheetList.stream().forEach(employeeSalarySheet->
			commonObjectElementCheck(employeeSalarySheet,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeSalarySheet));
		return this;
	}

	public static final String COMPANY_OF_SALARY_GRADE = "salary_grade.company";


	public YoubenbenObjectChecker checkCompanyOfSalaryGrade(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_SALARY_GRADE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeInterviewListOfInterviewType(List<BaseEntity> employeeInterviewList){
		AtomicInteger index = new AtomicInteger();
		employeeInterviewList.stream().forEach(employeeInterview->
			commonObjectElementCheck(employeeInterview,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeInterview));
		return this;
	}

	public static final String COMPANY_OF_INTERVIEW_TYPE = "interview_type.company";


	public YoubenbenObjectChecker checkCompanyOfInterviewType(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_INTERVIEW_TYPE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkCompanyTrainingListOfTrainingCourseType(List<BaseEntity> companyTrainingList){
		AtomicInteger index = new AtomicInteger();
		companyTrainingList.stream().forEach(companyTraining->
			commonObjectElementCheck(companyTraining,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCompanyTraining));
		return this;
	}

	public static final String COMPANY_OF_TRAINING_COURSE_TYPE = "training_course_type.company";


	public YoubenbenObjectChecker checkCompanyOfTrainingCourseType(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_TRAINING_COURSE_TYPE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public static final String COMPANY_OF_PUBLIC_HOLIDAY = "public_holiday.company";


	public YoubenbenObjectChecker checkCompanyOfPublicHoliday(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_PUBLIC_HOLIDAY);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeListOfTermination(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public static final String REASON_OF_TERMINATION = "termination.reason";


	public YoubenbenObjectChecker checkReasonOfTermination(BaseEntity reasonAsBaseEntity){

		if(reasonAsBaseEntity == null){
			checkBaseEntityReference(reasonAsBaseEntity,true,REASON_OF_TERMINATION);
			return this;
		}
		checkAndFixTerminationReason(reasonAsBaseEntity);
		return this;
	}


	public static final String TYPE_OF_TERMINATION = "termination.type";


	public YoubenbenObjectChecker checkTypeOfTermination(BaseEntity typeAsBaseEntity){

		if(typeAsBaseEntity == null){
			checkBaseEntityReference(typeAsBaseEntity,true,TYPE_OF_TERMINATION);
			return this;
		}
		checkAndFixTerminationType(typeAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeCompanyTrainingListOfEmployee(List<BaseEntity> employeeCompanyTrainingList){
		AtomicInteger index = new AtomicInteger();
		employeeCompanyTrainingList.stream().forEach(employeeCompanyTraining->
			commonObjectElementCheck(employeeCompanyTraining,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeCompanyTraining));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeSkillListOfEmployee(List<BaseEntity> employeeSkillList){
		AtomicInteger index = new AtomicInteger();
		employeeSkillList.stream().forEach(employeeSkill->
			commonObjectElementCheck(employeeSkill,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeSkill));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeePerformanceListOfEmployee(List<BaseEntity> employeePerformanceList){
		AtomicInteger index = new AtomicInteger();
		employeePerformanceList.stream().forEach(employeePerformance->
			commonObjectElementCheck(employeePerformance,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeePerformance));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeWorkExperienceListOfEmployee(List<BaseEntity> employeeWorkExperienceList){
		AtomicInteger index = new AtomicInteger();
		employeeWorkExperienceList.stream().forEach(employeeWorkExperience->
			commonObjectElementCheck(employeeWorkExperience,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeWorkExperience));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeLeaveListOfEmployee(List<BaseEntity> employeeLeaveList){
		AtomicInteger index = new AtomicInteger();
		employeeLeaveList.stream().forEach(employeeLeave->
			commonObjectElementCheck(employeeLeave,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeLeave));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeInterviewListOfEmployee(List<BaseEntity> employeeInterviewList){
		AtomicInteger index = new AtomicInteger();
		employeeInterviewList.stream().forEach(employeeInterview->
			commonObjectElementCheck(employeeInterview,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeInterview));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeAttendanceListOfEmployee(List<BaseEntity> employeeAttendanceList){
		AtomicInteger index = new AtomicInteger();
		employeeAttendanceList.stream().forEach(employeeAttendance->
			commonObjectElementCheck(employeeAttendance,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeAttendance));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeQualifierListOfEmployee(List<BaseEntity> employeeQualifierList){
		AtomicInteger index = new AtomicInteger();
		employeeQualifierList.stream().forEach(employeeQualifier->
			commonObjectElementCheck(employeeQualifier,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeQualifier));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeEducationListOfEmployee(List<BaseEntity> employeeEducationList){
		AtomicInteger index = new AtomicInteger();
		employeeEducationList.stream().forEach(employeeEducation->
			commonObjectElementCheck(employeeEducation,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeEducation));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeAwardListOfEmployee(List<BaseEntity> employeeAwardList){
		AtomicInteger index = new AtomicInteger();
		employeeAwardList.stream().forEach(employeeAward->
			commonObjectElementCheck(employeeAward,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeAward));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeSalarySheetListOfEmployee(List<BaseEntity> employeeSalarySheetList){
		AtomicInteger index = new AtomicInteger();
		employeeSalarySheetList.stream().forEach(employeeSalarySheet->
			commonObjectElementCheck(employeeSalarySheet,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeSalarySheet));
		return this;
	}

	public YoubenbenObjectChecker checkPayingOffListOfEmployee(List<BaseEntity> payingOffList){
		AtomicInteger index = new AtomicInteger();
		payingOffList.stream().forEach(payingOff->
			commonObjectElementCheck(payingOff,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPayingOff));
		return this;
	}

	public static final String COMPANY_OF_EMPLOYEE = "employee.company";


	public YoubenbenObjectChecker checkCompanyOfEmployee(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_EMPLOYEE);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public static final String DEPARTMENT_OF_EMPLOYEE = "employee.department";


	public YoubenbenObjectChecker checkDepartmentOfEmployee(BaseEntity departmentAsBaseEntity){

		if(departmentAsBaseEntity == null){
			checkBaseEntityReference(departmentAsBaseEntity,true,DEPARTMENT_OF_EMPLOYEE);
			return this;
		}
		checkAndFixLevelThreeDepartment(departmentAsBaseEntity);
		return this;
	}


	public static final String OCCUPATION_OF_EMPLOYEE = "employee.occupation";


	public YoubenbenObjectChecker checkOccupationOfEmployee(BaseEntity occupationAsBaseEntity){

		if(occupationAsBaseEntity == null){
			checkBaseEntityReference(occupationAsBaseEntity,true,OCCUPATION_OF_EMPLOYEE);
			return this;
		}
		checkAndFixOccupationType(occupationAsBaseEntity);
		return this;
	}


	public static final String RESPONSIBLE_FOR_OF_EMPLOYEE = "employee.responsible_for";


	public YoubenbenObjectChecker checkResponsibleForOfEmployee(BaseEntity responsibleForAsBaseEntity){

		if(responsibleForAsBaseEntity == null){
			checkBaseEntityReference(responsibleForAsBaseEntity,true,RESPONSIBLE_FOR_OF_EMPLOYEE);
			return this;
		}
		checkAndFixResponsibilityType(responsibleForAsBaseEntity);
		return this;
	}


	public static final String CURRENT_SALARY_GRADE_OF_EMPLOYEE = "employee.current_salary_grade";


	public YoubenbenObjectChecker checkCurrentSalaryGradeOfEmployee(BaseEntity currentSalaryGradeAsBaseEntity){

		if(currentSalaryGradeAsBaseEntity == null){
			checkBaseEntityReference(currentSalaryGradeAsBaseEntity,true,CURRENT_SALARY_GRADE_OF_EMPLOYEE);
			return this;
		}
		checkAndFixSalaryGrade(currentSalaryGradeAsBaseEntity);
		return this;
	}


	public static final String JOB_APPLICATION_OF_EMPLOYEE = "employee.job_application";


	public YoubenbenObjectChecker checkJobApplicationOfEmployee(BaseEntity jobApplicationAsBaseEntity){

		if(jobApplicationAsBaseEntity == null){
			checkBaseEntityReference(jobApplicationAsBaseEntity,true,JOB_APPLICATION_OF_EMPLOYEE);
			return this;
		}
		checkAndFixJobApplication(jobApplicationAsBaseEntity);
		return this;
	}


	public static final String PROFESSION_INTERVIEW_OF_EMPLOYEE = "employee.profession_interview";


	public YoubenbenObjectChecker checkProfessionInterviewOfEmployee(BaseEntity professionInterviewAsBaseEntity){

		if(professionInterviewAsBaseEntity == null){
			checkBaseEntityReference(professionInterviewAsBaseEntity,true,PROFESSION_INTERVIEW_OF_EMPLOYEE);
			return this;
		}
		checkAndFixProfessionInterview(professionInterviewAsBaseEntity);
		return this;
	}


	public static final String HR_INTERVIEW_OF_EMPLOYEE = "employee.hr_interview";


	public YoubenbenObjectChecker checkHrInterviewOfEmployee(BaseEntity hrInterviewAsBaseEntity){

		if(hrInterviewAsBaseEntity == null){
			checkBaseEntityReference(hrInterviewAsBaseEntity,true,HR_INTERVIEW_OF_EMPLOYEE);
			return this;
		}
		checkAndFixHrInterview(hrInterviewAsBaseEntity);
		return this;
	}


	public static final String OFFER_APPROVAL_OF_EMPLOYEE = "employee.offer_approval";


	public YoubenbenObjectChecker checkOfferApprovalOfEmployee(BaseEntity offerApprovalAsBaseEntity){

		if(offerApprovalAsBaseEntity == null){
			checkBaseEntityReference(offerApprovalAsBaseEntity,true,OFFER_APPROVAL_OF_EMPLOYEE);
			return this;
		}
		checkAndFixOfferApproval(offerApprovalAsBaseEntity);
		return this;
	}


	public static final String OFFER_ACCEPTANCE_OF_EMPLOYEE = "employee.offer_acceptance";


	public YoubenbenObjectChecker checkOfferAcceptanceOfEmployee(BaseEntity offerAcceptanceAsBaseEntity){

		if(offerAcceptanceAsBaseEntity == null){
			checkBaseEntityReference(offerAcceptanceAsBaseEntity,true,OFFER_ACCEPTANCE_OF_EMPLOYEE);
			return this;
		}
		checkAndFixOfferAcceptance(offerAcceptanceAsBaseEntity);
		return this;
	}


	public static final String EMPLOYEE_BOARDING_OF_EMPLOYEE = "employee.employee_boarding";


	public YoubenbenObjectChecker checkEmployeeBoardingOfEmployee(BaseEntity employeeBoardingAsBaseEntity){

		if(employeeBoardingAsBaseEntity == null){
			checkBaseEntityReference(employeeBoardingAsBaseEntity,true,EMPLOYEE_BOARDING_OF_EMPLOYEE);
			return this;
		}
		checkAndFixEmployeeBoarding(employeeBoardingAsBaseEntity);
		return this;
	}


	public static final String TERMINATION_OF_EMPLOYEE = "employee.termination";


	public YoubenbenObjectChecker checkTerminationOfEmployee(BaseEntity terminationAsBaseEntity){

		if(terminationAsBaseEntity == null){
			checkBaseEntityReference(terminationAsBaseEntity,true,TERMINATION_OF_EMPLOYEE);
			return this;
		}
		checkAndFixTermination(terminationAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeListOfJobApplication(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeListOfProfessionInterview(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeListOfHrInterview(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeListOfOfferApproval(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeListOfOfferAcceptance(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public YoubenbenObjectChecker checkEmployeeListOfEmployeeBoarding(List<BaseEntity> employeeList){
		AtomicInteger index = new AtomicInteger();
		employeeList.stream().forEach(employee->
			commonObjectElementCheck(employee,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployee));
		return this;
	}

	public YoubenbenObjectChecker checkCompanyTrainingListOfInstructor(List<BaseEntity> companyTrainingList){
		AtomicInteger index = new AtomicInteger();
		companyTrainingList.stream().forEach(companyTraining->
			commonObjectElementCheck(companyTraining,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCompanyTraining));
		return this;
	}

	public static final String COMPANY_OF_INSTRUCTOR = "instructor.company";


	public YoubenbenObjectChecker checkCompanyOfInstructor(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_INSTRUCTOR);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeCompanyTrainingListOfCompanyTraining(List<BaseEntity> employeeCompanyTrainingList){
		AtomicInteger index = new AtomicInteger();
		employeeCompanyTrainingList.stream().forEach(employeeCompanyTraining->
			commonObjectElementCheck(employeeCompanyTraining,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeCompanyTraining));
		return this;
	}

	public static final String COMPANY_OF_COMPANY_TRAINING = "company_training.company";


	public YoubenbenObjectChecker checkCompanyOfCompanyTraining(BaseEntity companyAsBaseEntity){

		if(companyAsBaseEntity == null){
			checkBaseEntityReference(companyAsBaseEntity,true,COMPANY_OF_COMPANY_TRAINING);
			return this;
		}
		checkAndFixRetailStoreCountryCenter(companyAsBaseEntity);
		return this;
	}


	public static final String INSTRUCTOR_OF_COMPANY_TRAINING = "company_training.instructor";


	public YoubenbenObjectChecker checkInstructorOfCompanyTraining(BaseEntity instructorAsBaseEntity){

		if(instructorAsBaseEntity == null){
			checkBaseEntityReference(instructorAsBaseEntity,true,INSTRUCTOR_OF_COMPANY_TRAINING);
			return this;
		}
		checkAndFixInstructor(instructorAsBaseEntity);
		return this;
	}


	public static final String TRAINING_COURSE_TYPE_OF_COMPANY_TRAINING = "company_training.training_course_type";


	public YoubenbenObjectChecker checkTrainingCourseTypeOfCompanyTraining(BaseEntity trainingCourseTypeAsBaseEntity){

		if(trainingCourseTypeAsBaseEntity == null){
			checkBaseEntityReference(trainingCourseTypeAsBaseEntity,true,TRAINING_COURSE_TYPE_OF_COMPANY_TRAINING);
			return this;
		}
		checkAndFixTrainingCourseType(trainingCourseTypeAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeCompanyTrainingListOfScoring(List<BaseEntity> employeeCompanyTrainingList){
		AtomicInteger index = new AtomicInteger();
		employeeCompanyTrainingList.stream().forEach(employeeCompanyTraining->
			commonObjectElementCheck(employeeCompanyTraining,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeCompanyTraining));
		return this;
	}

	public static final String EMPLOYEE_OF_EMPLOYEE_COMPANY_TRAINING = "employee_company_training.employee";


	public YoubenbenObjectChecker checkEmployeeOfEmployeeCompanyTraining(BaseEntity employeeAsBaseEntity){

		if(employeeAsBaseEntity == null){
			checkBaseEntityReference(employeeAsBaseEntity,true,EMPLOYEE_OF_EMPLOYEE_COMPANY_TRAINING);
			return this;
		}
		checkAndFixEmployee(employeeAsBaseEntity);
		return this;
	}


	public static final String TRAINING_OF_EMPLOYEE_COMPANY_TRAINING = "employee_company_training.training";


	public YoubenbenObjectChecker checkTrainingOfEmployeeCompanyTraining(BaseEntity trainingAsBaseEntity){

		if(trainingAsBaseEntity == null){
			checkBaseEntityReference(trainingAsBaseEntity,true,TRAINING_OF_EMPLOYEE_COMPANY_TRAINING);
			return this;
		}
		checkAndFixCompanyTraining(trainingAsBaseEntity);
		return this;
	}


	public static final String SCORING_OF_EMPLOYEE_COMPANY_TRAINING = "employee_company_training.scoring";


	public YoubenbenObjectChecker checkScoringOfEmployeeCompanyTraining(BaseEntity scoringAsBaseEntity){

		if(scoringAsBaseEntity == null){
			checkBaseEntityReference(scoringAsBaseEntity,true,SCORING_OF_EMPLOYEE_COMPANY_TRAINING);
			return this;
		}
		checkAndFixScoring(scoringAsBaseEntity);
		return this;
	}


	public static final String EMPLOYEE_OF_EMPLOYEE_SKILL = "employee_skill.employee";


	public YoubenbenObjectChecker checkEmployeeOfEmployeeSkill(BaseEntity employeeAsBaseEntity){

		if(employeeAsBaseEntity == null){
			checkBaseEntityReference(employeeAsBaseEntity,true,EMPLOYEE_OF_EMPLOYEE_SKILL);
			return this;
		}
		checkAndFixEmployee(employeeAsBaseEntity);
		return this;
	}


	public static final String SKILL_TYPE_OF_EMPLOYEE_SKILL = "employee_skill.skill_type";


	public YoubenbenObjectChecker checkSkillTypeOfEmployeeSkill(BaseEntity skillTypeAsBaseEntity){

		if(skillTypeAsBaseEntity == null){
			checkBaseEntityReference(skillTypeAsBaseEntity,true,SKILL_TYPE_OF_EMPLOYEE_SKILL);
			return this;
		}
		checkAndFixSkillType(skillTypeAsBaseEntity);
		return this;
	}


	public static final String EMPLOYEE_OF_EMPLOYEE_PERFORMANCE = "employee_performance.employee";


	public YoubenbenObjectChecker checkEmployeeOfEmployeePerformance(BaseEntity employeeAsBaseEntity){

		if(employeeAsBaseEntity == null){
			checkBaseEntityReference(employeeAsBaseEntity,true,EMPLOYEE_OF_EMPLOYEE_PERFORMANCE);
			return this;
		}
		checkAndFixEmployee(employeeAsBaseEntity);
		return this;
	}


	public static final String EMPLOYEE_OF_EMPLOYEE_WORK_EXPERIENCE = "employee_work_experience.employee";


	public YoubenbenObjectChecker checkEmployeeOfEmployeeWorkExperience(BaseEntity employeeAsBaseEntity){

		if(employeeAsBaseEntity == null){
			checkBaseEntityReference(employeeAsBaseEntity,true,EMPLOYEE_OF_EMPLOYEE_WORK_EXPERIENCE);
			return this;
		}
		checkAndFixEmployee(employeeAsBaseEntity);
		return this;
	}


	public static final String WHO_OF_EMPLOYEE_LEAVE = "employee_leave.who";


	public YoubenbenObjectChecker checkWhoOfEmployeeLeave(BaseEntity whoAsBaseEntity){

		if(whoAsBaseEntity == null){
			checkBaseEntityReference(whoAsBaseEntity,true,WHO_OF_EMPLOYEE_LEAVE);
			return this;
		}
		checkAndFixEmployee(whoAsBaseEntity);
		return this;
	}


	public static final String TYPE_OF_EMPLOYEE_LEAVE = "employee_leave.type";


	public YoubenbenObjectChecker checkTypeOfEmployeeLeave(BaseEntity typeAsBaseEntity){

		if(typeAsBaseEntity == null){
			checkBaseEntityReference(typeAsBaseEntity,true,TYPE_OF_EMPLOYEE_LEAVE);
			return this;
		}
		checkAndFixLeaveType(typeAsBaseEntity);
		return this;
	}


	public static final String EMPLOYEE_OF_EMPLOYEE_INTERVIEW = "employee_interview.employee";


	public YoubenbenObjectChecker checkEmployeeOfEmployeeInterview(BaseEntity employeeAsBaseEntity){

		if(employeeAsBaseEntity == null){
			checkBaseEntityReference(employeeAsBaseEntity,true,EMPLOYEE_OF_EMPLOYEE_INTERVIEW);
			return this;
		}
		checkAndFixEmployee(employeeAsBaseEntity);
		return this;
	}


	public static final String INTERVIEW_TYPE_OF_EMPLOYEE_INTERVIEW = "employee_interview.interview_type";


	public YoubenbenObjectChecker checkInterviewTypeOfEmployeeInterview(BaseEntity interviewTypeAsBaseEntity){

		if(interviewTypeAsBaseEntity == null){
			checkBaseEntityReference(interviewTypeAsBaseEntity,true,INTERVIEW_TYPE_OF_EMPLOYEE_INTERVIEW);
			return this;
		}
		checkAndFixInterviewType(interviewTypeAsBaseEntity);
		return this;
	}


	public static final String EMPLOYEE_OF_EMPLOYEE_ATTENDANCE = "employee_attendance.employee";


	public YoubenbenObjectChecker checkEmployeeOfEmployeeAttendance(BaseEntity employeeAsBaseEntity){

		if(employeeAsBaseEntity == null){
			checkBaseEntityReference(employeeAsBaseEntity,true,EMPLOYEE_OF_EMPLOYEE_ATTENDANCE);
			return this;
		}
		checkAndFixEmployee(employeeAsBaseEntity);
		return this;
	}


	public static final String EMPLOYEE_OF_EMPLOYEE_QUALIFIER = "employee_qualifier.employee";


	public YoubenbenObjectChecker checkEmployeeOfEmployeeQualifier(BaseEntity employeeAsBaseEntity){

		if(employeeAsBaseEntity == null){
			checkBaseEntityReference(employeeAsBaseEntity,true,EMPLOYEE_OF_EMPLOYEE_QUALIFIER);
			return this;
		}
		checkAndFixEmployee(employeeAsBaseEntity);
		return this;
	}


	public static final String EMPLOYEE_OF_EMPLOYEE_EDUCATION = "employee_education.employee";


	public YoubenbenObjectChecker checkEmployeeOfEmployeeEducation(BaseEntity employeeAsBaseEntity){

		if(employeeAsBaseEntity == null){
			checkBaseEntityReference(employeeAsBaseEntity,true,EMPLOYEE_OF_EMPLOYEE_EDUCATION);
			return this;
		}
		checkAndFixEmployee(employeeAsBaseEntity);
		return this;
	}


	public static final String EMPLOYEE_OF_EMPLOYEE_AWARD = "employee_award.employee";


	public YoubenbenObjectChecker checkEmployeeOfEmployeeAward(BaseEntity employeeAsBaseEntity){

		if(employeeAsBaseEntity == null){
			checkBaseEntityReference(employeeAsBaseEntity,true,EMPLOYEE_OF_EMPLOYEE_AWARD);
			return this;
		}
		checkAndFixEmployee(employeeAsBaseEntity);
		return this;
	}


	public static final String EMPLOYEE_OF_EMPLOYEE_SALARY_SHEET = "employee_salary_sheet.employee";


	public YoubenbenObjectChecker checkEmployeeOfEmployeeSalarySheet(BaseEntity employeeAsBaseEntity){

		if(employeeAsBaseEntity == null){
			checkBaseEntityReference(employeeAsBaseEntity,true,EMPLOYEE_OF_EMPLOYEE_SALARY_SHEET);
			return this;
		}
		checkAndFixEmployee(employeeAsBaseEntity);
		return this;
	}


	public static final String CURRENT_SALARY_GRADE_OF_EMPLOYEE_SALARY_SHEET = "employee_salary_sheet.current_salary_grade";


	public YoubenbenObjectChecker checkCurrentSalaryGradeOfEmployeeSalarySheet(BaseEntity currentSalaryGradeAsBaseEntity){

		if(currentSalaryGradeAsBaseEntity == null){
			checkBaseEntityReference(currentSalaryGradeAsBaseEntity,true,CURRENT_SALARY_GRADE_OF_EMPLOYEE_SALARY_SHEET);
			return this;
		}
		checkAndFixSalaryGrade(currentSalaryGradeAsBaseEntity);
		return this;
	}


	public static final String PAYING_OFF_OF_EMPLOYEE_SALARY_SHEET = "employee_salary_sheet.paying_off";


	public YoubenbenObjectChecker checkPayingOffOfEmployeeSalarySheet(BaseEntity payingOffAsBaseEntity){

		if(payingOffAsBaseEntity == null){
			checkBaseEntityReference(payingOffAsBaseEntity,true,PAYING_OFF_OF_EMPLOYEE_SALARY_SHEET);
			return this;
		}
		checkAndFixPayingOff(payingOffAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkEmployeeSalarySheetListOfPayingOff(List<BaseEntity> employeeSalarySheetList){
		AtomicInteger index = new AtomicInteger();
		employeeSalarySheetList.stream().forEach(employeeSalarySheet->
			commonObjectElementCheck(employeeSalarySheet,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixEmployeeSalarySheet));
		return this;
	}

	public static final String PAID_FOR_OF_PAYING_OFF = "paying_off.paid_for";


	public YoubenbenObjectChecker checkPaidForOfPayingOff(BaseEntity paidForAsBaseEntity){

		if(paidForAsBaseEntity == null){
			checkBaseEntityReference(paidForAsBaseEntity,true,PAID_FOR_OF_PAYING_OFF);
			return this;
		}
		checkAndFixEmployee(paidForAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkPageListOfMobileApp(List<BaseEntity> pageList){
		AtomicInteger index = new AtomicInteger();
		pageList.stream().forEach(page->
			commonObjectElementCheck(page,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPage));
		return this;
	}

	public YoubenbenObjectChecker checkPageTypeListOfMobileApp(List<BaseEntity> pageTypeList){
		AtomicInteger index = new AtomicInteger();
		pageTypeList.stream().forEach(pageType->
			commonObjectElementCheck(pageType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPageType));
		return this;
	}

	public YoubenbenObjectChecker checkSlideListOfPage(List<BaseEntity> slideList){
		AtomicInteger index = new AtomicInteger();
		slideList.stream().forEach(slide->
			commonObjectElementCheck(slide,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSlide));
		return this;
	}

	public YoubenbenObjectChecker checkUiActionListOfPage(List<BaseEntity> uiActionList){
		AtomicInteger index = new AtomicInteger();
		uiActionList.stream().forEach(uiAction->
			commonObjectElementCheck(uiAction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUiAction));
		return this;
	}

	public YoubenbenObjectChecker checkSectionListOfPage(List<BaseEntity> sectionList){
		AtomicInteger index = new AtomicInteger();
		sectionList.stream().forEach(section->
			commonObjectElementCheck(section,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSection));
		return this;
	}

	public static final String PAGE_TYPE_OF_PAGE = "page.page_type";


	public YoubenbenObjectChecker checkPageTypeOfPage(BaseEntity pageTypeAsBaseEntity){

		if(pageTypeAsBaseEntity == null){
			checkBaseEntityReference(pageTypeAsBaseEntity,true,PAGE_TYPE_OF_PAGE);
			return this;
		}
		checkAndFixPageType(pageTypeAsBaseEntity);
		return this;
	}


	public static final String MOBILE_APP_OF_PAGE = "page.mobile_app";


	public YoubenbenObjectChecker checkMobileAppOfPage(BaseEntity mobileAppAsBaseEntity){

		if(mobileAppAsBaseEntity == null){
			checkBaseEntityReference(mobileAppAsBaseEntity,true,MOBILE_APP_OF_PAGE);
			return this;
		}
		checkAndFixMobileApp(mobileAppAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkPageListOfPageType(List<BaseEntity> pageList){
		AtomicInteger index = new AtomicInteger();
		pageList.stream().forEach(page->
			commonObjectElementCheck(page,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPage));
		return this;
	}

	public static final String MOBILE_APP_OF_PAGE_TYPE = "page_type.mobile_app";


	public YoubenbenObjectChecker checkMobileAppOfPageType(BaseEntity mobileAppAsBaseEntity){

		if(mobileAppAsBaseEntity == null){
			checkBaseEntityReference(mobileAppAsBaseEntity,true,MOBILE_APP_OF_PAGE_TYPE);
			return this;
		}
		checkAndFixMobileApp(mobileAppAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_SLIDE = "slide.page";


	public YoubenbenObjectChecker checkPageOfSlide(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_SLIDE);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_UI_ACTION = "ui_action.page";


	public YoubenbenObjectChecker checkPageOfUiAction(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_UI_ACTION);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_SECTION = "section.page";


	public YoubenbenObjectChecker checkPageOfSection(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_SECTION);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkUserWhiteListListOfUserDomain(List<BaseEntity> userWhiteListList){
		AtomicInteger index = new AtomicInteger();
		userWhiteListList.stream().forEach(userWhiteList->
			commonObjectElementCheck(userWhiteList,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserWhiteList));
		return this;
	}

	public YoubenbenObjectChecker checkSecUserListOfUserDomain(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public YoubenbenObjectChecker checkPublicKeyTypeListOfUserDomain(List<BaseEntity> publicKeyTypeList){
		AtomicInteger index = new AtomicInteger();
		publicKeyTypeList.stream().forEach(publicKeyType->
			commonObjectElementCheck(publicKeyType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPublicKeyType));
		return this;
	}

	public static final String DOMAIN_OF_USER_WHITE_LIST = "user_white_list.domain";


	public YoubenbenObjectChecker checkDomainOfUserWhiteList(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_USER_WHITE_LIST);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkUserAppListOfSecUser(List<BaseEntity> userAppList){
		AtomicInteger index = new AtomicInteger();
		userAppList.stream().forEach(userApp->
			commonObjectElementCheck(userApp,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserApp));
		return this;
	}

	public YoubenbenObjectChecker checkLoginHistoryListOfSecUser(List<BaseEntity> loginHistoryList){
		AtomicInteger index = new AtomicInteger();
		loginHistoryList.stream().forEach(loginHistory->
			commonObjectElementCheck(loginHistory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLoginHistory));
		return this;
	}

	public YoubenbenObjectChecker checkWechatWorkappIdentifyListOfSecUser(List<BaseEntity> wechatWorkappIdentifyList){
		AtomicInteger index = new AtomicInteger();
		wechatWorkappIdentifyList.stream().forEach(wechatWorkappIdentify->
			commonObjectElementCheck(wechatWorkappIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatWorkappIdentify));
		return this;
	}

	public YoubenbenObjectChecker checkWechatMiniappIdentifyListOfSecUser(List<BaseEntity> wechatMiniappIdentifyList){
		AtomicInteger index = new AtomicInteger();
		wechatMiniappIdentifyList.stream().forEach(wechatMiniappIdentify->
			commonObjectElementCheck(wechatMiniappIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatMiniappIdentify));
		return this;
	}

	public YoubenbenObjectChecker checkKeypairIdentifyListOfSecUser(List<BaseEntity> keypairIdentifyList){
		AtomicInteger index = new AtomicInteger();
		keypairIdentifyList.stream().forEach(keypairIdentify->
			commonObjectElementCheck(keypairIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixKeypairIdentify));
		return this;
	}

	public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";


	public YoubenbenObjectChecker checkDomainOfSecUser(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_SEC_USER);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkQuickLinkListOfUserApp(List<BaseEntity> quickLinkList){
		AtomicInteger index = new AtomicInteger();
		quickLinkList.stream().forEach(quickLink->
			commonObjectElementCheck(quickLink,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixQuickLink));
		return this;
	}

	public YoubenbenObjectChecker checkListAccessListOfUserApp(List<BaseEntity> listAccessList){
		AtomicInteger index = new AtomicInteger();
		listAccessList.stream().forEach(listAccess->
			commonObjectElementCheck(listAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixListAccess));
		return this;
	}

	public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";


	public YoubenbenObjectChecker checkSecUserOfUserApp(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_USER_APP);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String APP_OF_QUICK_LINK = "quick_link.app";


	public YoubenbenObjectChecker checkAppOfQuickLink(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_QUICK_LINK);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_LIST_ACCESS = "list_access.app";


	public YoubenbenObjectChecker checkAppOfListAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_LIST_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";


	public YoubenbenObjectChecker checkSecUserOfLoginHistory(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_LOGIN_HISTORY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkCandidateElementListOfCandidateContainer(List<BaseEntity> candidateElementList){
		AtomicInteger index = new AtomicInteger();
		candidateElementList.stream().forEach(candidateElement->
			commonObjectElementCheck(candidateElement,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCandidateElement));
		return this;
	}

	public static final String CONTAINER_OF_CANDIDATE_ELEMENT = "candidate_element.container";


	public YoubenbenObjectChecker checkContainerOfCandidateElement(BaseEntity containerAsBaseEntity){

		if(containerAsBaseEntity == null){
			checkBaseEntityReference(containerAsBaseEntity,true,CONTAINER_OF_CANDIDATE_ELEMENT);
			return this;
		}
		checkAndFixCandidateContainer(containerAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY = "wechat_workapp_identify.sec_user";


	public YoubenbenObjectChecker checkSecUserOfWechatWorkappIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY = "wechat_miniapp_identify.sec_user";


	public YoubenbenObjectChecker checkSecUserOfWechatMiniappIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String KEY_TYPE_OF_KEYPAIR_IDENTIFY = "keypair_identify.key_type";


	public YoubenbenObjectChecker checkKeyTypeOfKeypairIdentify(BaseEntity keyTypeAsBaseEntity){

		if(keyTypeAsBaseEntity == null){
			checkBaseEntityReference(keyTypeAsBaseEntity,true,KEY_TYPE_OF_KEYPAIR_IDENTIFY);
			return this;
		}
		checkAndFixPublicKeyType(keyTypeAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_KEYPAIR_IDENTIFY = "keypair_identify.sec_user";


	public YoubenbenObjectChecker checkSecUserOfKeypairIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_KEYPAIR_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public YoubenbenObjectChecker checkKeypairIdentifyListOfPublicKeyType(List<BaseEntity> keypairIdentifyList){
		AtomicInteger index = new AtomicInteger();
		keypairIdentifyList.stream().forEach(keypairIdentify->
			commonObjectElementCheck(keypairIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixKeypairIdentify));
		return this;
	}

	public static final String DOMAIN_OF_PUBLIC_KEY_TYPE = "public_key_type.domain";


	public YoubenbenObjectChecker checkDomainOfPublicKeyType(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_PUBLIC_KEY_TYPE);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}

	public YoubenbenObjectChecker assignLastUpdateTimeOfProduct(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfRetailStoreProvinceCenter(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfRetailStoreCityServiceCenter(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfCityPartner(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfPotentialCustomer(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfPotentialCustomerContact(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfCityEvent(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfRetailStore(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfConsumerOrder(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfConsumerOrderLineItem(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfRetailStoreMemberCoupon(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfGoodsSupplier(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfSupplyOrder(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfRetailStoreOrder(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfWarehouse(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfStorageSpace(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfSmartPallet(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfGoodsShelf(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfSupplierSpace(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfReceivingSpace(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfShippingSpace(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfDamageSpace(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfWarehouseAsset(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfTransportFleet(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfAccountSet(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfEmployee(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfInstructor(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLastUpdateTimeOfCompanyTraining(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignCreateTimeOfQuickLink(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignLoginTimeOfLoginHistory(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"loginTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignCreateTimeOfWechatWorkappIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignCreateTimeOfWechatMiniappIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public YoubenbenObjectChecker assignCreateTimeOfKeypairIdentify(BaseEntity targetEntity){
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

