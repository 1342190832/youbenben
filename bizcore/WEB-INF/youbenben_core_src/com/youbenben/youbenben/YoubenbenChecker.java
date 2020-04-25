
package com.youbenben.youbenben;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
public class YoubenbenChecker extends BaseChecker{

	
	public YoubenbenChecker() {
		this.messageList = new ArrayList<Message>();
	}
	

	public static final String  ID_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.id";
	public YoubenbenChecker checkIdOfRetailStoreCountryCenter(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.name";
	public YoubenbenChecker checkNameOfRetailStoreCountryCenter(String name)
	{		
	 	checkStringLengthRange(name,4, 36,NAME_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	

	public static final String  SERVICE_NUMBER_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.service_number";
	public YoubenbenChecker checkServiceNumberOfRetailStoreCountryCenter(String serviceNumber)
	{		
	 	checkStringLengthRange(serviceNumber,3, 36,SERVICE_NUMBER_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.founded";
	public YoubenbenChecker checkFoundedOfRetailStoreCountryCenter(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	

	public static final String  WEB_SITE_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.web_site";
	public YoubenbenChecker checkWebSiteOfRetailStoreCountryCenter(String webSite)
	{		
	 	checkUrl(webSite,13, 104,WEB_SITE_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	

	public static final String  ADDRESS_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.address";
	public YoubenbenChecker checkAddressOfRetailStoreCountryCenter(String address)
	{		
	 	checkStringLengthRange(address,4, 56,ADDRESS_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	

	public static final String  OPERATED_BY_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.operated_by";
	public YoubenbenChecker checkOperatedByOfRetailStoreCountryCenter(String operatedBy)
	{		
	 	checkStringLengthRange(operatedBy,2, 24,OPERATED_BY_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	

	public static final String  LEGAL_REPRESENTATIVE_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.legal_representative";
	public YoubenbenChecker checkLegalRepresentativeOfRetailStoreCountryCenter(String legalRepresentative)
	{		
	 	checkStringLengthRange(legalRepresentative,1, 12,LEGAL_REPRESENTATIVE_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.description";
	public YoubenbenChecker checkDescriptionOfRetailStoreCountryCenter(String description)
	{		
	 	checkStringLengthRange(description,4, 56,DESCRIPTION_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.version";
	public YoubenbenChecker checkVersionOfRetailStoreCountryCenter(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CATALOG ="catalog.id";
	public YoubenbenChecker checkIdOfCatalog(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CATALOG ="catalog.name";
	public YoubenbenChecker checkNameOfCatalog(String name)
	{		
	 	checkStringLengthRange(name,4, 201,NAME_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_CATALOG ="catalog.owner";
	public YoubenbenChecker checkOwnerIdOfCatalog(String ownerId)
	{		
	 	checkIdOfCatalog(ownerId ); 		
		
		return this;
	}	

	public static final String  SUB_COUNT_OF_CATALOG ="catalog.sub_count";
	public YoubenbenChecker checkSubCountOfCatalog(int subCount)
	{		
	 	checkIntegerRange(subCount,0, 10,SUB_COUNT_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_CATALOG ="catalog.amount";
	public YoubenbenChecker checkAmountOfCatalog(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 10.11,AMOUNT_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CATALOG ="catalog.version";
	public YoubenbenChecker checkVersionOfCatalog(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEVEL_ONE_CATEGORY ="level_one_category.id";
	public YoubenbenChecker checkIdOfLevelOneCategory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  CATALOG_OF_LEVEL_ONE_CATEGORY ="level_one_category.catalog";
	public YoubenbenChecker checkCatalogIdOfLevelOneCategory(String catalogId)
	{		
	 	checkIdOfLevelOneCategory(catalogId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LEVEL_ONE_CATEGORY ="level_one_category.name";
	public YoubenbenChecker checkNameOfLevelOneCategory(String name)
	{		
	 	checkStringLengthRange(name,1, 8,NAME_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEVEL_ONE_CATEGORY ="level_one_category.version";
	public YoubenbenChecker checkVersionOfLevelOneCategory(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEVEL_TWO_CATEGORY ="level_two_category.id";
	public YoubenbenChecker checkIdOfLevelTwoCategory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	

	public static final String  PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY ="level_two_category.parent_category";
	public YoubenbenChecker checkParentCategoryIdOfLevelTwoCategory(String parentCategoryId)
	{		
	 	checkIdOfLevelTwoCategory(parentCategoryId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LEVEL_TWO_CATEGORY ="level_two_category.name";
	public YoubenbenChecker checkNameOfLevelTwoCategory(String name)
	{		
	 	checkStringLengthRange(name,1, 8,NAME_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEVEL_TWO_CATEGORY ="level_two_category.version";
	public YoubenbenChecker checkVersionOfLevelTwoCategory(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEVEL_THREE_CATEGORY ="level_three_category.id";
	public YoubenbenChecker checkIdOfLevelThreeCategory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_THREE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  PARENT_CATEGORY_OF_LEVEL_THREE_CATEGORY ="level_three_category.parent_category";
	public YoubenbenChecker checkParentCategoryIdOfLevelThreeCategory(String parentCategoryId)
	{		
	 	checkIdOfLevelThreeCategory(parentCategoryId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LEVEL_THREE_CATEGORY ="level_three_category.name";
	public YoubenbenChecker checkNameOfLevelThreeCategory(String name)
	{		
	 	checkStringLengthRange(name,1, 8,NAME_OF_LEVEL_THREE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEVEL_THREE_CATEGORY ="level_three_category.version";
	public YoubenbenChecker checkVersionOfLevelThreeCategory(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_THREE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_PRODUCT ="product.id";
	public YoubenbenChecker checkIdOfProduct(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PRODUCT ="product.name";
	public YoubenbenChecker checkNameOfProduct(String name)
	{		
	 	checkStringLengthRange(name,1, 16,NAME_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  PARENT_CATEGORY_OF_PRODUCT ="product.parent_category";
	public YoubenbenChecker checkParentCategoryIdOfProduct(String parentCategoryId)
	{		
	 	checkIdOfProduct(parentCategoryId ); 		
		
		return this;
	}	

	public static final String  ORIGIN_OF_PRODUCT ="product.origin";
	public YoubenbenChecker checkOriginOfProduct(String origin)
	{		
	 	checkStringLengthRange(origin,1, 8,ORIGIN_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  REMARK_OF_PRODUCT ="product.remark";
	public YoubenbenChecker checkRemarkOfProduct(String remark)
	{		
	 	checkStringLengthRange(remark,6, 88,REMARK_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  BRAND_OF_PRODUCT ="product.brand";
	public YoubenbenChecker checkBrandOfProduct(String brand)
	{		
	 	checkStringLengthRange(brand,6, 92,BRAND_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  PICTURE_OF_PRODUCT ="product.picture";
	public YoubenbenChecker checkPictureOfProduct(String picture)
	{		
	 	checkImage(picture,0, 512,PICTURE_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PRODUCT ="product.version";
	public YoubenbenChecker checkVersionOfProduct(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  ID_OF_SKU ="sku.id";
	public YoubenbenChecker checkIdOfSku(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SKU ); 		
		
		return this;
	}	

	public static final String  NAME_OF_SKU ="sku.name";
	public YoubenbenChecker checkNameOfSku(String name)
	{		
	 	checkStringLengthRange(name,2, 28,NAME_OF_SKU ); 		
		
		return this;
	}	

	public static final String  SIZE_OF_SKU ="sku.size";
	public YoubenbenChecker checkSizeOfSku(String size)
	{		
	 	checkStringLengthRange(size,0, 4,SIZE_OF_SKU ); 		
		
		return this;
	}	

	public static final String  PRODUCT_OF_SKU ="sku.product";
	public YoubenbenChecker checkProductIdOfSku(String productId)
	{		
	 	checkIdOfSku(productId ); 		
		
		return this;
	}	

	public static final String  BARCODE_OF_SKU ="sku.barcode";
	public YoubenbenChecker checkBarcodeOfSku(String barcode)
	{		
	 	checkStringLengthRange(barcode,4, 52,BARCODE_OF_SKU ); 		
		
		return this;
	}	

	public static final String  PACKAGE_TYPE_OF_SKU ="sku.package_type";
	public YoubenbenChecker checkPackageTypeOfSku(String packageType)
	{		
	 	checkStringLengthRange(packageType,2, 16,PACKAGE_TYPE_OF_SKU ); 		
		
		return this;
	}	

	public static final String  NET_CONTENT_OF_SKU ="sku.net_content";
	public YoubenbenChecker checkNetContentOfSku(String netContent)
	{		
	 	checkStringLengthRange(netContent,6, 92,NET_CONTENT_OF_SKU ); 		
		
		return this;
	}	

	public static final String  PRICE_OF_SKU ="sku.price";
	public YoubenbenChecker checkPriceOfSku(BigDecimal price)
	{		
	 	checkMoneyAmount(price,0.00, 1323.33,PRICE_OF_SKU ); 		
		
		return this;
	}	

	public static final String  PICTURE_OF_SKU ="sku.picture";
	public YoubenbenChecker checkPictureOfSku(String picture)
	{		
	 	checkImage(picture,0, 512,PICTURE_OF_SKU ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SKU ="sku.version";
	public YoubenbenChecker checkVersionOfSku(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SKU ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.id";
	public YoubenbenChecker checkIdOfRetailStoreProvinceCenter(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.name";
	public YoubenbenChecker checkNameOfRetailStoreProvinceCenter(String name)
	{		
	 	checkStringLengthRange(name,4, 40,NAME_OF_RETAIL_STORE_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.founded";
	public YoubenbenChecker checkFoundedOfRetailStoreProvinceCenter(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  COUNTRY_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.country";
	public YoubenbenChecker checkCountryIdOfRetailStoreProvinceCenter(String countryId)
	{		
	 	checkIdOfRetailStoreProvinceCenter(countryId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.version";
	public YoubenbenChecker checkVersionOfRetailStoreProvinceCenter(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  ID_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.id";
	public YoubenbenChecker checkIdOfProvinceCenterDepartment(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.name";
	public YoubenbenChecker checkNameOfProvinceCenterDepartment(String name)
	{		
	 	checkStringLengthRange(name,1, 20,NAME_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.founded";
	public YoubenbenChecker checkFoundedOfProvinceCenterDepartment(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  PROVINCE_CENTER_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.province_center";
	public YoubenbenChecker checkProvinceCenterIdOfProvinceCenterDepartment(String provinceCenterId)
	{		
	 	checkIdOfProvinceCenterDepartment(provinceCenterId ); 		
		
		return this;
	}	

	public static final String  MANAGER_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.manager";
	public YoubenbenChecker checkManagerOfProvinceCenterDepartment(String manager)
	{		
	 	checkStringLengthRange(manager,1, 12,MANAGER_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.version";
	public YoubenbenChecker checkVersionOfProvinceCenterDepartment(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.id";
	public YoubenbenChecker checkIdOfProvinceCenterEmployee(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.name";
	public YoubenbenChecker checkNameOfProvinceCenterEmployee(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.mobile";
	public YoubenbenChecker checkMobileOfProvinceCenterEmployee(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  EMAIL_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.email";
	public YoubenbenChecker checkEmailOfProvinceCenterEmployee(String email)
	{		
	 	checkEmail(email,8, 84,EMAIL_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.founded";
	public YoubenbenChecker checkFoundedOfProvinceCenterEmployee(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  DEPARTMENT_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.department";
	public YoubenbenChecker checkDepartmentIdOfProvinceCenterEmployee(String departmentId)
	{		
	 	checkIdOfProvinceCenterEmployee(departmentId ); 		
		
		return this;
	}	

	public static final String  PROVINCE_CENTER_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.province_center";
	public YoubenbenChecker checkProvinceCenterIdOfProvinceCenterEmployee(String provinceCenterId)
	{		
	 	checkIdOfProvinceCenterEmployee(provinceCenterId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.version";
	public YoubenbenChecker checkVersionOfProvinceCenterEmployee(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.id";
	public YoubenbenChecker checkIdOfRetailStoreCityServiceCenter(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.name";
	public YoubenbenChecker checkNameOfRetailStoreCityServiceCenter(String name)
	{		
	 	checkStringLengthRange(name,2, 20,NAME_OF_RETAIL_STORE_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.founded";
	public YoubenbenChecker checkFoundedOfRetailStoreCityServiceCenter(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	

	public static final String  BELONGS_TO_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.belongs_to";
	public YoubenbenChecker checkBelongsToIdOfRetailStoreCityServiceCenter(String belongsToId)
	{		
	 	checkIdOfRetailStoreCityServiceCenter(belongsToId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.version";
	public YoubenbenChecker checkVersionOfRetailStoreCityServiceCenter(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CITY_PARTNER ="city_partner.id";
	public YoubenbenChecker checkIdOfCityPartner(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CITY_PARTNER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CITY_PARTNER ="city_partner.name";
	public YoubenbenChecker checkNameOfCityPartner(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_CITY_PARTNER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_CITY_PARTNER ="city_partner.mobile";
	public YoubenbenChecker checkMobileOfCityPartner(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_CITY_PARTNER ); 		
		
		return this;
	}	

	public static final String  CITY_SERVICE_CENTER_OF_CITY_PARTNER ="city_partner.city_service_center";
	public YoubenbenChecker checkCityServiceCenterIdOfCityPartner(String cityServiceCenterId)
	{		
	 	checkIdOfCityPartner(cityServiceCenterId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_CITY_PARTNER ="city_partner.description";
	public YoubenbenChecker checkDescriptionOfCityPartner(String description)
	{		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_CITY_PARTNER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CITY_PARTNER ="city_partner.version";
	public YoubenbenChecker checkVersionOfCityPartner(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY_PARTNER ); 		
		
		return this;
	}	

	public static final String  ID_OF_POTENTIAL_CUSTOMER ="potential_customer.id";
	public YoubenbenChecker checkIdOfPotentialCustomer(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_POTENTIAL_CUSTOMER ="potential_customer.name";
	public YoubenbenChecker checkNameOfPotentialCustomer(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_POTENTIAL_CUSTOMER ="potential_customer.mobile";
	public YoubenbenChecker checkMobileOfPotentialCustomer(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	

	public static final String  CITY_SERVICE_CENTER_OF_POTENTIAL_CUSTOMER ="potential_customer.city_service_center";
	public YoubenbenChecker checkCityServiceCenterIdOfPotentialCustomer(String cityServiceCenterId)
	{		
	 	checkIdOfPotentialCustomer(cityServiceCenterId ); 		
		
		return this;
	}	

	public static final String  CITY_PARTNER_OF_POTENTIAL_CUSTOMER ="potential_customer.city_partner";
	public YoubenbenChecker checkCityPartnerIdOfPotentialCustomer(String cityPartnerId)
	{		
	 	checkIdOfPotentialCustomer(cityPartnerId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER ="potential_customer.description";
	public YoubenbenChecker checkDescriptionOfPotentialCustomer(String description)
	{		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_POTENTIAL_CUSTOMER ="potential_customer.version";
	public YoubenbenChecker checkVersionOfPotentialCustomer(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	

	public static final String  ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.id";
	public YoubenbenChecker checkIdOfPotentialCustomerContactPerson(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	

	public static final String  NAME_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.name";
	public YoubenbenChecker checkNameOfPotentialCustomerContactPerson(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.mobile";
	public YoubenbenChecker checkMobileOfPotentialCustomerContactPerson(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	

	public static final String  POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.potential_customer";
	public YoubenbenChecker checkPotentialCustomerIdOfPotentialCustomerContactPerson(String potentialCustomerId)
	{		
	 	checkIdOfPotentialCustomerContactPerson(potentialCustomerId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.description";
	public YoubenbenChecker checkDescriptionOfPotentialCustomerContactPerson(String description)
	{		
	 	checkStringLengthRange(description,7, 96,DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.version";
	public YoubenbenChecker checkVersionOfPotentialCustomerContactPerson(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	

	public static final String  ID_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.id";
	public YoubenbenChecker checkIdOfPotentialCustomerContact(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.name";
	public YoubenbenChecker checkNameOfPotentialCustomerContact(String name)
	{		
	 	checkStringLengthRange(name,3, 40,NAME_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  CONTACT_DATE_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_date";
	public YoubenbenChecker checkContactDateOfPotentialCustomerContact(Date contactDate)
	{		
	 	checkDateRange(contactDate,parseDate("1900-01-01"), parseDate("2016-09-09"),CONTACT_DATE_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  CONTACT_METHOD_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_method";
	public YoubenbenChecker checkContactMethodOfPotentialCustomerContact(String contactMethod)
	{		
	 	checkStringLengthRange(contactMethod,1, 16,CONTACT_METHOD_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.potential_customer";
	public YoubenbenChecker checkPotentialCustomerIdOfPotentialCustomerContact(String potentialCustomerId)
	{		
	 	checkIdOfPotentialCustomerContact(potentialCustomerId ); 		
		
		return this;
	}	

	public static final String  CITY_PARTNER_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.city_partner";
	public YoubenbenChecker checkCityPartnerIdOfPotentialCustomerContact(String cityPartnerId)
	{		
	 	checkIdOfPotentialCustomerContact(cityPartnerId ); 		
		
		return this;
	}	

	public static final String  CONTACT_TO_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_to";
	public YoubenbenChecker checkContactToIdOfPotentialCustomerContact(String contactToId)
	{		
	 	checkIdOfPotentialCustomerContact(contactToId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.description";
	public YoubenbenChecker checkDescriptionOfPotentialCustomerContact(String description)
	{		
	 	checkStringLengthRange(description,2, 24,DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.version";
	public YoubenbenChecker checkVersionOfPotentialCustomerContact(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  ID_OF_CITY_EVENT ="city_event.id";
	public YoubenbenChecker checkIdOfCityEvent(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CITY_EVENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CITY_EVENT ="city_event.name";
	public YoubenbenChecker checkNameOfCityEvent(String name)
	{		
	 	checkStringLengthRange(name,3, 24,NAME_OF_CITY_EVENT ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_CITY_EVENT ="city_event.mobile";
	public YoubenbenChecker checkMobileOfCityEvent(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_CITY_EVENT ); 		
		
		return this;
	}	

	public static final String  CITY_SERVICE_CENTER_OF_CITY_EVENT ="city_event.city_service_center";
	public YoubenbenChecker checkCityServiceCenterIdOfCityEvent(String cityServiceCenterId)
	{		
	 	checkIdOfCityEvent(cityServiceCenterId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_CITY_EVENT ="city_event.description";
	public YoubenbenChecker checkDescriptionOfCityEvent(String description)
	{		
	 	checkStringLengthRange(description,4, 52,DESCRIPTION_OF_CITY_EVENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CITY_EVENT ="city_event.version";
	public YoubenbenChecker checkVersionOfCityEvent(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY_EVENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_EVENT_ATTENDANCE ="event_attendance.id";
	public YoubenbenChecker checkIdOfEventAttendance(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_EVENT_ATTENDANCE ="event_attendance.name";
	public YoubenbenChecker checkNameOfEventAttendance(String name)
	{		
	 	checkStringLengthRange(name,3, 40,NAME_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  POTENTIAL_CUSTOMER_OF_EVENT_ATTENDANCE ="event_attendance.potential_customer";
	public YoubenbenChecker checkPotentialCustomerIdOfEventAttendance(String potentialCustomerId)
	{		
	 	checkIdOfEventAttendance(potentialCustomerId ); 		
		
		return this;
	}	

	public static final String  CITY_EVENT_OF_EVENT_ATTENDANCE ="event_attendance.city_event";
	public YoubenbenChecker checkCityEventIdOfEventAttendance(String cityEventId)
	{		
	 	checkIdOfEventAttendance(cityEventId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_EVENT_ATTENDANCE ="event_attendance.description";
	public YoubenbenChecker checkDescriptionOfEventAttendance(String description)
	{		
	 	checkStringLengthRange(description,3, 36,DESCRIPTION_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EVENT_ATTENDANCE ="event_attendance.version";
	public YoubenbenChecker checkVersionOfEventAttendance(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE ="retail_store.id";
	public YoubenbenChecker checkIdOfRetailStore(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_RETAIL_STORE ="retail_store.name";
	public YoubenbenChecker checkNameOfRetailStore(String name)
	{		
	 	checkStringLengthRange(name,3, 24,NAME_OF_RETAIL_STORE ); 		
		
		return this;
	}	

	public static final String  TELEPHONE_OF_RETAIL_STORE ="retail_store.telephone";
	public YoubenbenChecker checkTelephoneOfRetailStore(String telephone)
	{		
	 	checkStringLengthRange(telephone,3, 44,TELEPHONE_OF_RETAIL_STORE ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_RETAIL_STORE ="retail_store.owner";
	public YoubenbenChecker checkOwnerOfRetailStore(String owner)
	{		
	 	checkStringLengthRange(owner,1, 12,OWNER_OF_RETAIL_STORE ); 		
		
		return this;
	}	

	public static final String  RETAIL_STORE_COUNTRY_CENTER_OF_RETAIL_STORE ="retail_store.retail_store_country_center";
	public YoubenbenChecker checkRetailStoreCountryCenterIdOfRetailStore(String retailStoreCountryCenterId)
	{		
	 	checkIdOfRetailStore(retailStoreCountryCenterId ); 		
		
		return this;
	}	

	public static final String  CITY_SERVICE_CENTER_OF_RETAIL_STORE ="retail_store.city_service_center";
	public YoubenbenChecker checkCityServiceCenterIdOfRetailStore(String cityServiceCenterId)
	{		
	 	checkIdOfRetailStore(cityServiceCenterId ); 		
		
		return this;
	}	

	public static final String  CREATION_OF_RETAIL_STORE ="retail_store.creation";
	public YoubenbenChecker checkCreationIdOfRetailStore(String creationId)
	{		
	 	checkIdOfRetailStore(creationId ); 		
		
		return this;
	}	

	public static final String  INVESTMENT_INVITATION_OF_RETAIL_STORE ="retail_store.investment_invitation";
	public YoubenbenChecker checkInvestmentInvitationIdOfRetailStore(String investmentInvitationId)
	{		
	 	checkIdOfRetailStore(investmentInvitationId ); 		
		
		return this;
	}	

	public static final String  FRANCHISING_OF_RETAIL_STORE ="retail_store.franchising";
	public YoubenbenChecker checkFranchisingIdOfRetailStore(String franchisingId)
	{		
	 	checkIdOfRetailStore(franchisingId ); 		
		
		return this;
	}	

	public static final String  DECORATION_OF_RETAIL_STORE ="retail_store.decoration";
	public YoubenbenChecker checkDecorationIdOfRetailStore(String decorationId)
	{		
	 	checkIdOfRetailStore(decorationId ); 		
		
		return this;
	}	

	public static final String  OPENING_OF_RETAIL_STORE ="retail_store.opening";
	public YoubenbenChecker checkOpeningIdOfRetailStore(String openingId)
	{		
	 	checkIdOfRetailStore(openingId ); 		
		
		return this;
	}	

	public static final String  CLOSING_OF_RETAIL_STORE ="retail_store.closing";
	public YoubenbenChecker checkClosingIdOfRetailStore(String closingId)
	{		
	 	checkIdOfRetailStore(closingId ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_RETAIL_STORE ="retail_store.founded";
	public YoubenbenChecker checkFoundedOfRetailStore(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_RETAIL_STORE ="retail_store.latitude";
	public YoubenbenChecker checkLatitudeOfRetailStore(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_RETAIL_STORE ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_RETAIL_STORE ="retail_store.longitude";
	public YoubenbenChecker checkLongitudeOfRetailStore(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_RETAIL_STORE ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_RETAIL_STORE ="retail_store.description";
	public YoubenbenChecker checkDescriptionOfRetailStore(String description)
	{		
	 	checkStringLengthRange(description,6, 84,DESCRIPTION_OF_RETAIL_STORE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE ="retail_store.version";
	public YoubenbenChecker checkVersionOfRetailStore(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_CREATION ="retail_store_creation.id";
	public YoubenbenChecker checkIdOfRetailStoreCreation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_CREATION ); 		
		
		return this;
	}	

	public static final String  COMMENT_OF_RETAIL_STORE_CREATION ="retail_store_creation.comment";
	public YoubenbenChecker checkCommentOfRetailStoreCreation(String comment)
	{		
	 	checkStringLengthRange(comment,2, 20,COMMENT_OF_RETAIL_STORE_CREATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_CREATION ="retail_store_creation.version";
	public YoubenbenChecker checkVersionOfRetailStoreCreation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_CREATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.id";
	public YoubenbenChecker checkIdOfRetailStoreInvestmentInvitation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_INVESTMENT_INVITATION ); 		
		
		return this;
	}	

	public static final String  COMMENT_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.comment";
	public YoubenbenChecker checkCommentOfRetailStoreInvestmentInvitation(String comment)
	{		
	 	checkStringLengthRange(comment,2, 24,COMMENT_OF_RETAIL_STORE_INVESTMENT_INVITATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.version";
	public YoubenbenChecker checkVersionOfRetailStoreInvestmentInvitation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_INVESTMENT_INVITATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.id";
	public YoubenbenChecker checkIdOfRetailStoreFranchising(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_FRANCHISING ); 		
		
		return this;
	}	

	public static final String  COMMENT_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.comment";
	public YoubenbenChecker checkCommentOfRetailStoreFranchising(String comment)
	{		
	 	checkStringLengthRange(comment,2, 16,COMMENT_OF_RETAIL_STORE_FRANCHISING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.version";
	public YoubenbenChecker checkVersionOfRetailStoreFranchising(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_FRANCHISING ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.id";
	public YoubenbenChecker checkIdOfRetailStoreDecoration(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_DECORATION ); 		
		
		return this;
	}	

	public static final String  COMMENT_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.comment";
	public YoubenbenChecker checkCommentOfRetailStoreDecoration(String comment)
	{		
	 	checkStringLengthRange(comment,1, 8,COMMENT_OF_RETAIL_STORE_DECORATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.version";
	public YoubenbenChecker checkVersionOfRetailStoreDecoration(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_DECORATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_OPENING ="retail_store_opening.id";
	public YoubenbenChecker checkIdOfRetailStoreOpening(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_OPENING ); 		
		
		return this;
	}	

	public static final String  COMMENT_OF_RETAIL_STORE_OPENING ="retail_store_opening.comment";
	public YoubenbenChecker checkCommentOfRetailStoreOpening(String comment)
	{		
	 	checkStringLengthRange(comment,1, 8,COMMENT_OF_RETAIL_STORE_OPENING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_OPENING ="retail_store_opening.version";
	public YoubenbenChecker checkVersionOfRetailStoreOpening(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_OPENING ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_CLOSING ="retail_store_closing.id";
	public YoubenbenChecker checkIdOfRetailStoreClosing(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_CLOSING ); 		
		
		return this;
	}	

	public static final String  COMMENT_OF_RETAIL_STORE_CLOSING ="retail_store_closing.comment";
	public YoubenbenChecker checkCommentOfRetailStoreClosing(String comment)
	{		
	 	checkStringLengthRange(comment,1, 8,COMMENT_OF_RETAIL_STORE_CLOSING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_CLOSING ="retail_store_closing.version";
	public YoubenbenChecker checkVersionOfRetailStoreClosing(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_CLOSING ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_MEMBER ="retail_store_member.id";
	public YoubenbenChecker checkIdOfRetailStoreMember(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_MEMBER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_RETAIL_STORE_MEMBER ="retail_store_member.name";
	public YoubenbenChecker checkNameOfRetailStoreMember(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_RETAIL_STORE_MEMBER ); 		
		
		return this;
	}	

	public static final String  MOBILE_PHONE_OF_RETAIL_STORE_MEMBER ="retail_store_member.mobile_phone";
	public YoubenbenChecker checkMobilePhoneOfRetailStoreMember(String mobilePhone)
	{		
	 	checkChinaMobilePhone(mobilePhone,5, 44,MOBILE_PHONE_OF_RETAIL_STORE_MEMBER ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_RETAIL_STORE_MEMBER ="retail_store_member.owner";
	public YoubenbenChecker checkOwnerIdOfRetailStoreMember(String ownerId)
	{		
	 	checkIdOfRetailStoreMember(ownerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_MEMBER ="retail_store_member.version";
	public YoubenbenChecker checkVersionOfRetailStoreMember(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CONSUMER_ORDER ="consumer_order.id";
	public YoubenbenChecker checkIdOfConsumerOrder(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_CONSUMER_ORDER ="consumer_order.title";
	public YoubenbenChecker checkTitleOfConsumerOrder(String title)
	{		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_CONSUMER_ORDER ); 		
		
		return this;
	}	

	public static final String  CONSUMER_OF_CONSUMER_ORDER ="consumer_order.consumer";
	public YoubenbenChecker checkConsumerIdOfConsumerOrder(String consumerId)
	{		
	 	checkIdOfConsumerOrder(consumerId ); 		
		
		return this;
	}	

	public static final String  CONFIRMATION_OF_CONSUMER_ORDER ="consumer_order.confirmation";
	public YoubenbenChecker checkConfirmationIdOfConsumerOrder(String confirmationId)
	{		
	 	checkIdOfConsumerOrder(confirmationId ); 		
		
		return this;
	}	

	public static final String  APPROVAL_OF_CONSUMER_ORDER ="consumer_order.approval";
	public YoubenbenChecker checkApprovalIdOfConsumerOrder(String approvalId)
	{		
	 	checkIdOfConsumerOrder(approvalId ); 		
		
		return this;
	}	

	public static final String  PROCESSING_OF_CONSUMER_ORDER ="consumer_order.processing";
	public YoubenbenChecker checkProcessingIdOfConsumerOrder(String processingId)
	{		
	 	checkIdOfConsumerOrder(processingId ); 		
		
		return this;
	}	

	public static final String  SHIPMENT_OF_CONSUMER_ORDER ="consumer_order.shipment";
	public YoubenbenChecker checkShipmentIdOfConsumerOrder(String shipmentId)
	{		
	 	checkIdOfConsumerOrder(shipmentId ); 		
		
		return this;
	}	

	public static final String  DELIVERY_OF_CONSUMER_ORDER ="consumer_order.delivery";
	public YoubenbenChecker checkDeliveryIdOfConsumerOrder(String deliveryId)
	{		
	 	checkIdOfConsumerOrder(deliveryId ); 		
		
		return this;
	}	

	public static final String  STORE_OF_CONSUMER_ORDER ="consumer_order.store";
	public YoubenbenChecker checkStoreIdOfConsumerOrder(String storeId)
	{		
	 	checkIdOfConsumerOrder(storeId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CONSUMER_ORDER ="consumer_order.version";
	public YoubenbenChecker checkVersionOfConsumerOrder(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.id";
	public YoubenbenChecker checkIdOfConsumerOrderConfirmation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  WHO_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.who";
	public YoubenbenChecker checkWhoOfConsumerOrderConfirmation(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  CONFIRM_TIME_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.confirm_time";
	public YoubenbenChecker checkConfirmTimeOfConsumerOrderConfirmation(Date confirmTime)
	{		
	 	checkDateRange(confirmTime,parseDate("1900-01-01"), parseDate("2018-07-09"),CONFIRM_TIME_OF_CONSUMER_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.version";
	public YoubenbenChecker checkVersionOfConsumerOrderConfirmation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.id";
	public YoubenbenChecker checkIdOfConsumerOrderApproval(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  WHO_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.who";
	public YoubenbenChecker checkWhoOfConsumerOrderApproval(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  APPROVE_TIME_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.approve_time";
	public YoubenbenChecker checkApproveTimeOfConsumerOrderApproval(Date approveTime)
	{		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-07-09"),APPROVE_TIME_OF_CONSUMER_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.version";
	public YoubenbenChecker checkVersionOfConsumerOrderApproval(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  ID_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.id";
	public YoubenbenChecker checkIdOfConsumerOrderProcessing(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.who";
	public YoubenbenChecker checkWhoOfConsumerOrderProcessing(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  PROCESS_TIME_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.process_time";
	public YoubenbenChecker checkProcessTimeOfConsumerOrderProcessing(Date processTime)
	{		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_CONSUMER_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.version";
	public YoubenbenChecker checkVersionOfConsumerOrderProcessing(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  ID_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.id";
	public YoubenbenChecker checkIdOfConsumerOrderShipment(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  WHO_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.who";
	public YoubenbenChecker checkWhoOfConsumerOrderShipment(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  SHIP_TIME_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.ship_time";
	public YoubenbenChecker checkShipTimeOfConsumerOrderShipment(Date shipTime)
	{		
	 	checkDateRange(shipTime,parseDate("1900-01-01"), parseDate("2018-07-09"),SHIP_TIME_OF_CONSUMER_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.version";
	public YoubenbenChecker checkVersionOfConsumerOrderShipment(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.id";
	public YoubenbenChecker checkIdOfConsumerOrderDelivery(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  WHO_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.who";
	public YoubenbenChecker checkWhoOfConsumerOrderDelivery(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  DELIVERY_TIME_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.delivery_time";
	public YoubenbenChecker checkDeliveryTimeOfConsumerOrderDelivery(Date deliveryTime)
	{		
	 	checkDateRange(deliveryTime,parseDate("1900-01-01"), parseDate("2018-07-09"),DELIVERY_TIME_OF_CONSUMER_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.version";
	public YoubenbenChecker checkVersionOfConsumerOrderDelivery(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  ID_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.id";
	public YoubenbenChecker checkIdOfConsumerOrderLineItem(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.biz_order";
	public YoubenbenChecker checkBizOrderIdOfConsumerOrderLineItem(String bizOrderId)
	{		
	 	checkIdOfConsumerOrderLineItem(bizOrderId ); 		
		
		return this;
	}	

	public static final String  SKU_ID_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.sku_id";
	public YoubenbenChecker checkSkuIdOfConsumerOrderLineItem(String skuId)
	{		
	 	checkStringLengthRange(skuId,1, 12,SKU_ID_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  SKU_NAME_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.sku_name";
	public YoubenbenChecker checkSkuNameOfConsumerOrderLineItem(String skuName)
	{		
	 	checkStringLengthRange(skuName,2, 20,SKU_NAME_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  PRICE_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.price";
	public YoubenbenChecker checkPriceOfConsumerOrderLineItem(BigDecimal price)
	{		
	 	checkMoneyAmount(price,0.00, 5.97,PRICE_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  QUANTITY_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.quantity";
	public YoubenbenChecker checkQuantityOfConsumerOrderLineItem(BigDecimal quantity)
	{		
	 	checkBigDecimalRange(quantity,0, 1000.00,QUANTITY_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.amount";
	public YoubenbenChecker checkAmountOfConsumerOrderLineItem(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 9999.99,AMOUNT_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.version";
	public YoubenbenChecker checkVersionOfConsumerOrderLineItem(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  ID_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.id";
	public YoubenbenChecker checkIdOfConsumerOrderShippingGroup(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.name";
	public YoubenbenChecker checkNameOfConsumerOrderShippingGroup(String name)
	{		
	 	checkStringLengthRange(name,2, 24,NAME_OF_CONSUMER_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.biz_order";
	public YoubenbenChecker checkBizOrderIdOfConsumerOrderShippingGroup(String bizOrderId)
	{		
	 	checkIdOfConsumerOrderShippingGroup(bizOrderId ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.amount";
	public YoubenbenChecker checkAmountOfConsumerOrderShippingGroup(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 599.99,AMOUNT_OF_CONSUMER_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.version";
	public YoubenbenChecker checkVersionOfConsumerOrderShippingGroup(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  ID_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.id";
	public YoubenbenChecker checkIdOfConsumerOrderPaymentGroup(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.name";
	public YoubenbenChecker checkNameOfConsumerOrderPaymentGroup(String name)
	{		
	 	checkStringLengthRange(name,1, 16,NAME_OF_CONSUMER_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.biz_order";
	public YoubenbenChecker checkBizOrderIdOfConsumerOrderPaymentGroup(String bizOrderId)
	{		
	 	checkIdOfConsumerOrderPaymentGroup(bizOrderId ); 		
		
		return this;
	}	

	public static final String  CARD_NUMBER_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.card_number";
	public YoubenbenChecker checkCardNumberOfConsumerOrderPaymentGroup(String cardNumber)
	{		
	 	checkStringLengthRange(cardNumber,5, 68,CARD_NUMBER_OF_CONSUMER_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.version";
	public YoubenbenChecker checkVersionOfConsumerOrderPaymentGroup(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  ID_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.id";
	public YoubenbenChecker checkIdOfConsumerOrderPriceAdjustment(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.name";
	public YoubenbenChecker checkNameOfConsumerOrderPriceAdjustment(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.biz_order";
	public YoubenbenChecker checkBizOrderIdOfConsumerOrderPriceAdjustment(String bizOrderId)
	{		
	 	checkIdOfConsumerOrderPriceAdjustment(bizOrderId ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.amount";
	public YoubenbenChecker checkAmountOfConsumerOrderPriceAdjustment(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 599.99,AMOUNT_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
		return this;
	}	

	public static final String  PROVIDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.provider";
	public YoubenbenChecker checkProviderOfConsumerOrderPriceAdjustment(String provider)
	{		
	 	checkStringLengthRange(provider,1, 20,PROVIDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.version";
	public YoubenbenChecker checkVersionOfConsumerOrderPriceAdjustment(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.id";
	public YoubenbenChecker checkIdOfRetailStoreMemberCoupon(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_MEMBER_COUPON ); 		
		
		return this;
	}	

	public static final String  NAME_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.name";
	public YoubenbenChecker checkNameOfRetailStoreMemberCoupon(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_RETAIL_STORE_MEMBER_COUPON ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.owner";
	public YoubenbenChecker checkOwnerIdOfRetailStoreMemberCoupon(String ownerId)
	{		
	 	checkIdOfRetailStoreMemberCoupon(ownerId ); 		
		
		return this;
	}	

	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.number";
	public YoubenbenChecker checkNumberOfRetailStoreMemberCoupon(String number)
	{		
	 	checkStringLengthRange(number,2, 28,NUMBER_OF_RETAIL_STORE_MEMBER_COUPON ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.version";
	public YoubenbenChecker checkVersionOfRetailStoreMemberCoupon(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_COUPON ); 		
		
		return this;
	}	

	public static final String  ID_OF_MEMBER_WISHLIST ="member_wishlist.id";
	public YoubenbenChecker checkIdOfMemberWishlist(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_MEMBER_WISHLIST ); 		
		
		return this;
	}	

	public static final String  NAME_OF_MEMBER_WISHLIST ="member_wishlist.name";
	public YoubenbenChecker checkNameOfMemberWishlist(String name)
	{		
	 	checkStringLengthRange(name,3, 24,NAME_OF_MEMBER_WISHLIST ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_MEMBER_WISHLIST ="member_wishlist.owner";
	public YoubenbenChecker checkOwnerIdOfMemberWishlist(String ownerId)
	{		
	 	checkIdOfMemberWishlist(ownerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_MEMBER_WISHLIST ="member_wishlist.version";
	public YoubenbenChecker checkVersionOfMemberWishlist(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_WISHLIST ); 		
		
		return this;
	}	

	public static final String  ID_OF_MEMBER_REWARD_POINT ="member_reward_point.id";
	public YoubenbenChecker checkIdOfMemberRewardPoint(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_MEMBER_REWARD_POINT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_MEMBER_REWARD_POINT ="member_reward_point.name";
	public YoubenbenChecker checkNameOfMemberRewardPoint(String name)
	{		
	 	checkStringLengthRange(name,2, 24,NAME_OF_MEMBER_REWARD_POINT ); 		
		
		return this;
	}	

	public static final String  POINT_OF_MEMBER_REWARD_POINT ="member_reward_point.point";
	public YoubenbenChecker checkPointOfMemberRewardPoint(int point)
	{		
	 	checkIntegerRange(point,0, 20,POINT_OF_MEMBER_REWARD_POINT ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_MEMBER_REWARD_POINT ="member_reward_point.owner";
	public YoubenbenChecker checkOwnerIdOfMemberRewardPoint(String ownerId)
	{		
	 	checkIdOfMemberRewardPoint(ownerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_MEMBER_REWARD_POINT ="member_reward_point.version";
	public YoubenbenChecker checkVersionOfMemberRewardPoint(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_REWARD_POINT ); 		
		
		return this;
	}	

	public static final String  ID_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.id";
	public YoubenbenChecker checkIdOfMemberRewardPointRedemption(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_MEMBER_REWARD_POINT_REDEMPTION ); 		
		
		return this;
	}	

	public static final String  NAME_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.name";
	public YoubenbenChecker checkNameOfMemberRewardPointRedemption(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_MEMBER_REWARD_POINT_REDEMPTION ); 		
		
		return this;
	}	

	public static final String  POINT_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.point";
	public YoubenbenChecker checkPointOfMemberRewardPointRedemption(int point)
	{		
	 	checkIntegerRange(point,0, 20,POINT_OF_MEMBER_REWARD_POINT_REDEMPTION ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.owner";
	public YoubenbenChecker checkOwnerIdOfMemberRewardPointRedemption(String ownerId)
	{		
	 	checkIdOfMemberRewardPointRedemption(ownerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.version";
	public YoubenbenChecker checkVersionOfMemberRewardPointRedemption(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_REWARD_POINT_REDEMPTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.id";
	public YoubenbenChecker checkIdOfMemberWishlistProduct(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_MEMBER_WISHLIST_PRODUCT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.name";
	public YoubenbenChecker checkNameOfMemberWishlistProduct(String name)
	{		
	 	checkStringLengthRange(name,2, 20,NAME_OF_MEMBER_WISHLIST_PRODUCT ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.owner";
	public YoubenbenChecker checkOwnerIdOfMemberWishlistProduct(String ownerId)
	{		
	 	checkIdOfMemberWishlistProduct(ownerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.version";
	public YoubenbenChecker checkVersionOfMemberWishlistProduct(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_WISHLIST_PRODUCT ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.id";
	public YoubenbenChecker checkIdOfRetailStoreMemberAddress(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.name";
	public YoubenbenChecker checkNameOfRetailStoreMemberAddress(String name)
	{		
	 	checkStringLengthRange(name,1, 24,NAME_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.owner";
	public YoubenbenChecker checkOwnerIdOfRetailStoreMemberAddress(String ownerId)
	{		
	 	checkIdOfRetailStoreMemberAddress(ownerId ); 		
		
		return this;
	}	

	public static final String  MOBILE_PHONE_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.mobile_phone";
	public YoubenbenChecker checkMobilePhoneOfRetailStoreMemberAddress(String mobilePhone)
	{		
	 	checkChinaMobilePhone(mobilePhone,5, 44,MOBILE_PHONE_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
		return this;
	}	

	public static final String  ADDRESS_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.address";
	public YoubenbenChecker checkAddressOfRetailStoreMemberAddress(String address)
	{		
	 	checkStringLengthRange(address,4, 56,ADDRESS_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.version";
	public YoubenbenChecker checkVersionOfRetailStoreMemberAddress(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.id";
	public YoubenbenChecker checkIdOfRetailStoreMemberGiftCard(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
		return this;
	}	

	public static final String  NAME_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.name";
	public YoubenbenChecker checkNameOfRetailStoreMemberGiftCard(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.owner";
	public YoubenbenChecker checkOwnerIdOfRetailStoreMemberGiftCard(String ownerId)
	{		
	 	checkIdOfRetailStoreMemberGiftCard(ownerId ); 		
		
		return this;
	}	

	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.number";
	public YoubenbenChecker checkNumberOfRetailStoreMemberGiftCard(String number)
	{		
	 	checkStringLengthRange(number,2, 28,NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
		return this;
	}	

	public static final String  REMAIN_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.remain";
	public YoubenbenChecker checkRemainOfRetailStoreMemberGiftCard(BigDecimal remain)
	{		
	 	checkMoneyAmount(remain,0.00, 213.99,REMAIN_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.version";
	public YoubenbenChecker checkVersionOfRetailStoreMemberGiftCard(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.id";
	public YoubenbenChecker checkIdOfRetailStoreMemberGiftCardConsumeRecord(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
		return this;
	}	

	public static final String  OCCURE_TIME_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.occure_time";
	public YoubenbenChecker checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(Date occureTime)
	{		
	 	checkDatePast(occureTime,parseDate("1900-01-01"), new Date(),OCCURE_TIME_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.owner";
	public YoubenbenChecker checkOwnerIdOfRetailStoreMemberGiftCardConsumeRecord(String ownerId)
	{		
	 	checkIdOfRetailStoreMemberGiftCardConsumeRecord(ownerId ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.biz_order";
	public YoubenbenChecker checkBizOrderIdOfRetailStoreMemberGiftCardConsumeRecord(String bizOrderId)
	{		
	 	checkIdOfRetailStoreMemberGiftCardConsumeRecord(bizOrderId ); 		
		
		return this;
	}	

	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.number";
	public YoubenbenChecker checkNumberOfRetailStoreMemberGiftCardConsumeRecord(String number)
	{		
	 	checkStringLengthRange(number,2, 28,NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.amount";
	public YoubenbenChecker checkAmountOfRetailStoreMemberGiftCardConsumeRecord(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 20.99,AMOUNT_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.version";
	public YoubenbenChecker checkVersionOfRetailStoreMemberGiftCardConsumeRecord(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
		return this;
	}	

	public static final String  ID_OF_GOODS_SUPPLIER ="goods_supplier.id";
	public YoubenbenChecker checkIdOfGoodsSupplier(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_GOODS_SUPPLIER ="goods_supplier.name";
	public YoubenbenChecker checkNameOfGoodsSupplier(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	

	public static final String  SUPPLY_PRODUCT_OF_GOODS_SUPPLIER ="goods_supplier.supply_product";
	public YoubenbenChecker checkSupplyProductOfGoodsSupplier(String supplyProduct)
	{		
	 	checkStringLengthRange(supplyProduct,1, 16,SUPPLY_PRODUCT_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	

	public static final String  BELONG_TO_OF_GOODS_SUPPLIER ="goods_supplier.belong_to";
	public YoubenbenChecker checkBelongToIdOfGoodsSupplier(String belongToId)
	{		
	 	checkIdOfGoodsSupplier(belongToId ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_GOODS_SUPPLIER ="goods_supplier.contact_number";
	public YoubenbenChecker checkContactNumberOfGoodsSupplier(String contactNumber)
	{		
	 	checkChinaMobilePhone(contactNumber,5, 44,CONTACT_NUMBER_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_GOODS_SUPPLIER ="goods_supplier.description";
	public YoubenbenChecker checkDescriptionOfGoodsSupplier(String description)
	{		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GOODS_SUPPLIER ="goods_supplier.version";
	public YoubenbenChecker checkVersionOfGoodsSupplier(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLIER_PRODUCT ="supplier_product.id";
	public YoubenbenChecker checkIdOfSupplierProduct(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLIER_PRODUCT ); 		
		
		return this;
	}	

	public static final String  PRODUCT_NAME_OF_SUPPLIER_PRODUCT ="supplier_product.product_name";
	public YoubenbenChecker checkProductNameOfSupplierProduct(String productName)
	{		
	 	checkStringLengthRange(productName,2, 20,PRODUCT_NAME_OF_SUPPLIER_PRODUCT ); 		
		
		return this;
	}	

	public static final String  PRODUCT_DESCRIPTION_OF_SUPPLIER_PRODUCT ="supplier_product.product_description";
	public YoubenbenChecker checkProductDescriptionOfSupplierProduct(String productDescription)
	{		
	 	checkStringLengthRange(productDescription,4, 48,PRODUCT_DESCRIPTION_OF_SUPPLIER_PRODUCT ); 		
		
		return this;
	}	

	public static final String  PRODUCT_UNIT_OF_SUPPLIER_PRODUCT ="supplier_product.product_unit";
	public YoubenbenChecker checkProductUnitOfSupplierProduct(String productUnit)
	{		
	 	checkStringLengthRange(productUnit,0, 8,PRODUCT_UNIT_OF_SUPPLIER_PRODUCT ); 		
		
		return this;
	}	

	public static final String  SUPPLIER_OF_SUPPLIER_PRODUCT ="supplier_product.supplier";
	public YoubenbenChecker checkSupplierIdOfSupplierProduct(String supplierId)
	{		
	 	checkIdOfSupplierProduct(supplierId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLIER_PRODUCT ="supplier_product.version";
	public YoubenbenChecker checkVersionOfSupplierProduct(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLIER_PRODUCT ); 		
		
		return this;
	}	

	public static final String  ID_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.id";
	public YoubenbenChecker checkIdOfProductSupplyDuration(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PRODUCT_SUPPLY_DURATION ); 		
		
		return this;
	}	

	public static final String  QUANTITY_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.quantity";
	public YoubenbenChecker checkQuantityOfProductSupplyDuration(int quantity)
	{		
	 	checkIntegerRange(quantity,0, 500,QUANTITY_OF_PRODUCT_SUPPLY_DURATION ); 		
		
		return this;
	}	

	public static final String  DURATION_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.duration";
	public YoubenbenChecker checkDurationOfProductSupplyDuration(String duration)
	{		
	 	checkStringLengthRange(duration,1, 8,DURATION_OF_PRODUCT_SUPPLY_DURATION ); 		
		
		return this;
	}	

	public static final String  PRICE_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.price";
	public YoubenbenChecker checkPriceOfProductSupplyDuration(BigDecimal price)
	{		
	 	checkMoneyAmount(price,0.00, 9999.99,PRICE_OF_PRODUCT_SUPPLY_DURATION ); 		
		
		return this;
	}	

	public static final String  PRODUCT_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.product";
	public YoubenbenChecker checkProductIdOfProductSupplyDuration(String productId)
	{		
	 	checkIdOfProductSupplyDuration(productId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.version";
	public YoubenbenChecker checkVersionOfProductSupplyDuration(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT_SUPPLY_DURATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLY_ORDER ="supply_order.id";
	public YoubenbenChecker checkIdOfSupplyOrder(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER ); 		
		
		return this;
	}	

	public static final String  BUYER_OF_SUPPLY_ORDER ="supply_order.buyer";
	public YoubenbenChecker checkBuyerIdOfSupplyOrder(String buyerId)
	{		
	 	checkIdOfSupplyOrder(buyerId ); 		
		
		return this;
	}	

	public static final String  SELLER_OF_SUPPLY_ORDER ="supply_order.seller";
	public YoubenbenChecker checkSellerIdOfSupplyOrder(String sellerId)
	{		
	 	checkIdOfSupplyOrder(sellerId ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_SUPPLY_ORDER ="supply_order.title";
	public YoubenbenChecker checkTitleOfSupplyOrder(String title)
	{		
	 	checkStringLengthRange(title,3, 44,TITLE_OF_SUPPLY_ORDER ); 		
		
		return this;
	}	

	public static final String  TOTAL_AMOUNT_OF_SUPPLY_ORDER ="supply_order.total_amount";
	public YoubenbenChecker checkTotalAmountOfSupplyOrder(BigDecimal totalAmount)
	{		
	 	checkMoneyAmount(totalAmount,0.00, 3000000000.88,TOTAL_AMOUNT_OF_SUPPLY_ORDER ); 		
		
		return this;
	}	

	public static final String  CONFIRMATION_OF_SUPPLY_ORDER ="supply_order.confirmation";
	public YoubenbenChecker checkConfirmationIdOfSupplyOrder(String confirmationId)
	{		
	 	checkIdOfSupplyOrder(confirmationId ); 		
		
		return this;
	}	

	public static final String  APPROVAL_OF_SUPPLY_ORDER ="supply_order.approval";
	public YoubenbenChecker checkApprovalIdOfSupplyOrder(String approvalId)
	{		
	 	checkIdOfSupplyOrder(approvalId ); 		
		
		return this;
	}	

	public static final String  PROCESSING_OF_SUPPLY_ORDER ="supply_order.processing";
	public YoubenbenChecker checkProcessingIdOfSupplyOrder(String processingId)
	{		
	 	checkIdOfSupplyOrder(processingId ); 		
		
		return this;
	}	

	public static final String  PICKING_OF_SUPPLY_ORDER ="supply_order.picking";
	public YoubenbenChecker checkPickingIdOfSupplyOrder(String pickingId)
	{		
	 	checkIdOfSupplyOrder(pickingId ); 		
		
		return this;
	}	

	public static final String  SHIPMENT_OF_SUPPLY_ORDER ="supply_order.shipment";
	public YoubenbenChecker checkShipmentIdOfSupplyOrder(String shipmentId)
	{		
	 	checkIdOfSupplyOrder(shipmentId ); 		
		
		return this;
	}	

	public static final String  DELIVERY_OF_SUPPLY_ORDER ="supply_order.delivery";
	public YoubenbenChecker checkDeliveryIdOfSupplyOrder(String deliveryId)
	{		
	 	checkIdOfSupplyOrder(deliveryId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLY_ORDER ="supply_order.version";
	public YoubenbenChecker checkVersionOfSupplyOrder(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.id";
	public YoubenbenChecker checkIdOfSupplyOrderConfirmation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  WHO_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.who";
	public YoubenbenChecker checkWhoOfSupplyOrderConfirmation(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  CONFIRM_TIME_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.confirm_time";
	public YoubenbenChecker checkConfirmTimeOfSupplyOrderConfirmation(Date confirmTime)
	{		
	 	checkDateRange(confirmTime,parseDate("1900-01-01"), parseDate("2018-07-09"),CONFIRM_TIME_OF_SUPPLY_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.version";
	public YoubenbenChecker checkVersionOfSupplyOrderConfirmation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.id";
	public YoubenbenChecker checkIdOfSupplyOrderApproval(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  WHO_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.who";
	public YoubenbenChecker checkWhoOfSupplyOrderApproval(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  APPROVE_TIME_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.approve_time";
	public YoubenbenChecker checkApproveTimeOfSupplyOrderApproval(Date approveTime)
	{		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-07-09"),APPROVE_TIME_OF_SUPPLY_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.version";
	public YoubenbenChecker checkVersionOfSupplyOrderApproval(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.id";
	public YoubenbenChecker checkIdOfSupplyOrderProcessing(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.who";
	public YoubenbenChecker checkWhoOfSupplyOrderProcessing(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  PROCESS_TIME_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.process_time";
	public YoubenbenChecker checkProcessTimeOfSupplyOrderProcessing(Date processTime)
	{		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_SUPPLY_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.version";
	public YoubenbenChecker checkVersionOfSupplyOrderProcessing(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.id";
	public YoubenbenChecker checkIdOfSupplyOrderPicking(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_PICKING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.who";
	public YoubenbenChecker checkWhoOfSupplyOrderPicking(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_PICKING ); 		
		
		return this;
	}	

	public static final String  PROCESS_TIME_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.process_time";
	public YoubenbenChecker checkProcessTimeOfSupplyOrderPicking(Date processTime)
	{		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_SUPPLY_ORDER_PICKING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.version";
	public YoubenbenChecker checkVersionOfSupplyOrderPicking(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_PICKING ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.id";
	public YoubenbenChecker checkIdOfSupplyOrderShipment(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  WHO_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.who";
	public YoubenbenChecker checkWhoOfSupplyOrderShipment(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  SHIP_TIME_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.ship_time";
	public YoubenbenChecker checkShipTimeOfSupplyOrderShipment(Date shipTime)
	{		
	 	checkDateRange(shipTime,parseDate("1900-01-01"), parseDate("2018-07-09"),SHIP_TIME_OF_SUPPLY_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.version";
	public YoubenbenChecker checkVersionOfSupplyOrderShipment(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.id";
	public YoubenbenChecker checkIdOfSupplyOrderDelivery(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  WHO_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.who";
	public YoubenbenChecker checkWhoOfSupplyOrderDelivery(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  DELIVERY_TIME_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.delivery_time";
	public YoubenbenChecker checkDeliveryTimeOfSupplyOrderDelivery(Date deliveryTime)
	{		
	 	checkDateRange(deliveryTime,parseDate("1900-01-01"), parseDate("2018-07-09"),DELIVERY_TIME_OF_SUPPLY_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.version";
	public YoubenbenChecker checkVersionOfSupplyOrderDelivery(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.id";
	public YoubenbenChecker checkIdOfSupplyOrderLineItem(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.biz_order";
	public YoubenbenChecker checkBizOrderIdOfSupplyOrderLineItem(String bizOrderId)
	{		
	 	checkIdOfSupplyOrderLineItem(bizOrderId ); 		
		
		return this;
	}	

	public static final String  SKU_ID_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.sku_id";
	public YoubenbenChecker checkSkuIdOfSupplyOrderLineItem(String skuId)
	{		
	 	checkStringLengthRange(skuId,1, 12,SKU_ID_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  SKU_NAME_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.sku_name";
	public YoubenbenChecker checkSkuNameOfSupplyOrderLineItem(String skuName)
	{		
	 	checkStringLengthRange(skuName,2, 20,SKU_NAME_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.amount";
	public YoubenbenChecker checkAmountOfSupplyOrderLineItem(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 5.97,AMOUNT_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  QUANTITY_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.quantity";
	public YoubenbenChecker checkQuantityOfSupplyOrderLineItem(int quantity)
	{		
	 	checkIntegerRange(quantity,0, 10000,QUANTITY_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  UNIT_OF_MEASUREMENT_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.unit_of_measurement";
	public YoubenbenChecker checkUnitOfMeasurementOfSupplyOrderLineItem(String unitOfMeasurement)
	{		
	 	checkStringLengthRange(unitOfMeasurement,0, 8,UNIT_OF_MEASUREMENT_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.version";
	public YoubenbenChecker checkVersionOfSupplyOrderLineItem(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.id";
	public YoubenbenChecker checkIdOfSupplyOrderShippingGroup(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  NAME_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.name";
	public YoubenbenChecker checkNameOfSupplyOrderShippingGroup(String name)
	{		
	 	checkStringLengthRange(name,3, 36,NAME_OF_SUPPLY_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.biz_order";
	public YoubenbenChecker checkBizOrderIdOfSupplyOrderShippingGroup(String bizOrderId)
	{		
	 	checkIdOfSupplyOrderShippingGroup(bizOrderId ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.amount";
	public YoubenbenChecker checkAmountOfSupplyOrderShippingGroup(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 5.99,AMOUNT_OF_SUPPLY_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.version";
	public YoubenbenChecker checkVersionOfSupplyOrderShippingGroup(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.id";
	public YoubenbenChecker checkIdOfSupplyOrderPaymentGroup(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  NAME_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.name";
	public YoubenbenChecker checkNameOfSupplyOrderPaymentGroup(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_SUPPLY_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.biz_order";
	public YoubenbenChecker checkBizOrderIdOfSupplyOrderPaymentGroup(String bizOrderId)
	{		
	 	checkIdOfSupplyOrderPaymentGroup(bizOrderId ); 		
		
		return this;
	}	

	public static final String  CARD_NUMBER_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.card_number";
	public YoubenbenChecker checkCardNumberOfSupplyOrderPaymentGroup(String cardNumber)
	{		
	 	checkStringLengthRange(cardNumber,5, 68,CARD_NUMBER_OF_SUPPLY_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.version";
	public YoubenbenChecker checkVersionOfSupplyOrderPaymentGroup(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_ORDER ="retail_store_order.id";
	public YoubenbenChecker checkIdOfRetailStoreOrder(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER ); 		
		
		return this;
	}	

	public static final String  BUYER_OF_RETAIL_STORE_ORDER ="retail_store_order.buyer";
	public YoubenbenChecker checkBuyerIdOfRetailStoreOrder(String buyerId)
	{		
	 	checkIdOfRetailStoreOrder(buyerId ); 		
		
		return this;
	}	

	public static final String  SELLER_OF_RETAIL_STORE_ORDER ="retail_store_order.seller";
	public YoubenbenChecker checkSellerIdOfRetailStoreOrder(String sellerId)
	{		
	 	checkIdOfRetailStoreOrder(sellerId ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_RETAIL_STORE_ORDER ="retail_store_order.title";
	public YoubenbenChecker checkTitleOfRetailStoreOrder(String title)
	{		
	 	checkStringLengthRange(title,5, 72,TITLE_OF_RETAIL_STORE_ORDER ); 		
		
		return this;
	}	

	public static final String  TOTAL_AMOUNT_OF_RETAIL_STORE_ORDER ="retail_store_order.total_amount";
	public YoubenbenChecker checkTotalAmountOfRetailStoreOrder(BigDecimal totalAmount)
	{		
	 	checkMoneyAmount(totalAmount,0.00, 3000000000.88,TOTAL_AMOUNT_OF_RETAIL_STORE_ORDER ); 		
		
		return this;
	}	

	public static final String  CONFIRMATION_OF_RETAIL_STORE_ORDER ="retail_store_order.confirmation";
	public YoubenbenChecker checkConfirmationIdOfRetailStoreOrder(String confirmationId)
	{		
	 	checkIdOfRetailStoreOrder(confirmationId ); 		
		
		return this;
	}	

	public static final String  APPROVAL_OF_RETAIL_STORE_ORDER ="retail_store_order.approval";
	public YoubenbenChecker checkApprovalIdOfRetailStoreOrder(String approvalId)
	{		
	 	checkIdOfRetailStoreOrder(approvalId ); 		
		
		return this;
	}	

	public static final String  PROCESSING_OF_RETAIL_STORE_ORDER ="retail_store_order.processing";
	public YoubenbenChecker checkProcessingIdOfRetailStoreOrder(String processingId)
	{		
	 	checkIdOfRetailStoreOrder(processingId ); 		
		
		return this;
	}	

	public static final String  PICKING_OF_RETAIL_STORE_ORDER ="retail_store_order.picking";
	public YoubenbenChecker checkPickingIdOfRetailStoreOrder(String pickingId)
	{		
	 	checkIdOfRetailStoreOrder(pickingId ); 		
		
		return this;
	}	

	public static final String  SHIPMENT_OF_RETAIL_STORE_ORDER ="retail_store_order.shipment";
	public YoubenbenChecker checkShipmentIdOfRetailStoreOrder(String shipmentId)
	{		
	 	checkIdOfRetailStoreOrder(shipmentId ); 		
		
		return this;
	}	

	public static final String  DELIVERY_OF_RETAIL_STORE_ORDER ="retail_store_order.delivery";
	public YoubenbenChecker checkDeliveryIdOfRetailStoreOrder(String deliveryId)
	{		
	 	checkIdOfRetailStoreOrder(deliveryId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_ORDER ="retail_store_order.version";
	public YoubenbenChecker checkVersionOfRetailStoreOrder(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.id";
	public YoubenbenChecker checkIdOfRetailStoreOrderConfirmation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  WHO_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.who";
	public YoubenbenChecker checkWhoOfRetailStoreOrderConfirmation(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  CONFIRM_TIME_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.confirm_time";
	public YoubenbenChecker checkConfirmTimeOfRetailStoreOrderConfirmation(Date confirmTime)
	{		
	 	checkDateRange(confirmTime,parseDate("1900-01-01"), parseDate("2018-07-09"),CONFIRM_TIME_OF_RETAIL_STORE_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.version";
	public YoubenbenChecker checkVersionOfRetailStoreOrderConfirmation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.id";
	public YoubenbenChecker checkIdOfRetailStoreOrderApproval(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  WHO_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.who";
	public YoubenbenChecker checkWhoOfRetailStoreOrderApproval(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  APPROVE_TIME_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.approve_time";
	public YoubenbenChecker checkApproveTimeOfRetailStoreOrderApproval(Date approveTime)
	{		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-07-09"),APPROVE_TIME_OF_RETAIL_STORE_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.version";
	public YoubenbenChecker checkVersionOfRetailStoreOrderApproval(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.id";
	public YoubenbenChecker checkIdOfRetailStoreOrderProcessing(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.who";
	public YoubenbenChecker checkWhoOfRetailStoreOrderProcessing(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  PROCESS_TIME_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.process_time";
	public YoubenbenChecker checkProcessTimeOfRetailStoreOrderProcessing(Date processTime)
	{		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_RETAIL_STORE_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.version";
	public YoubenbenChecker checkVersionOfRetailStoreOrderProcessing(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_PROCESSING ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.id";
	public YoubenbenChecker checkIdOfRetailStoreOrderPicking(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_PICKING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.who";
	public YoubenbenChecker checkWhoOfRetailStoreOrderPicking(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_PICKING ); 		
		
		return this;
	}	

	public static final String  PROCESS_TIME_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.process_time";
	public YoubenbenChecker checkProcessTimeOfRetailStoreOrderPicking(Date processTime)
	{		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_RETAIL_STORE_ORDER_PICKING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.version";
	public YoubenbenChecker checkVersionOfRetailStoreOrderPicking(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_PICKING ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.id";
	public YoubenbenChecker checkIdOfRetailStoreOrderShipment(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  WHO_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.who";
	public YoubenbenChecker checkWhoOfRetailStoreOrderShipment(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  SHIP_TIME_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.ship_time";
	public YoubenbenChecker checkShipTimeOfRetailStoreOrderShipment(Date shipTime)
	{		
	 	checkDateRange(shipTime,parseDate("1900-01-01"), parseDate("2018-07-09"),SHIP_TIME_OF_RETAIL_STORE_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.version";
	public YoubenbenChecker checkVersionOfRetailStoreOrderShipment(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_SHIPMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.id";
	public YoubenbenChecker checkIdOfRetailStoreOrderDelivery(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  WHO_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.who";
	public YoubenbenChecker checkWhoOfRetailStoreOrderDelivery(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  DELIVERY_TIME_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.delivery_time";
	public YoubenbenChecker checkDeliveryTimeOfRetailStoreOrderDelivery(Date deliveryTime)
	{		
	 	checkDateRange(deliveryTime,parseDate("1900-01-01"), parseDate("2018-07-09"),DELIVERY_TIME_OF_RETAIL_STORE_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.version";
	public YoubenbenChecker checkVersionOfRetailStoreOrderDelivery(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_DELIVERY ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.id";
	public YoubenbenChecker checkIdOfRetailStoreOrderLineItem(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.biz_order";
	public YoubenbenChecker checkBizOrderIdOfRetailStoreOrderLineItem(String bizOrderId)
	{		
	 	checkIdOfRetailStoreOrderLineItem(bizOrderId ); 		
		
		return this;
	}	

	public static final String  SKU_ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.sku_id";
	public YoubenbenChecker checkSkuIdOfRetailStoreOrderLineItem(String skuId)
	{		
	 	checkStringLengthRange(skuId,1, 12,SKU_ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  SKU_NAME_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.sku_name";
	public YoubenbenChecker checkSkuNameOfRetailStoreOrderLineItem(String skuName)
	{		
	 	checkStringLengthRange(skuName,2, 20,SKU_NAME_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.amount";
	public YoubenbenChecker checkAmountOfRetailStoreOrderLineItem(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 3.97,AMOUNT_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  QUANTITY_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.quantity";
	public YoubenbenChecker checkQuantityOfRetailStoreOrderLineItem(int quantity)
	{		
	 	checkIntegerRange(quantity,0, 10000,QUANTITY_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  UNIT_OF_MEASUREMENT_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.unit_of_measurement";
	public YoubenbenChecker checkUnitOfMeasurementOfRetailStoreOrderLineItem(String unitOfMeasurement)
	{		
	 	checkStringLengthRange(unitOfMeasurement,0, 8,UNIT_OF_MEASUREMENT_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.version";
	public YoubenbenChecker checkVersionOfRetailStoreOrderLineItem(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.id";
	public YoubenbenChecker checkIdOfRetailStoreOrderShippingGroup(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  NAME_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.name";
	public YoubenbenChecker checkNameOfRetailStoreOrderShippingGroup(String name)
	{		
	 	checkStringLengthRange(name,3, 36,NAME_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.biz_order";
	public YoubenbenChecker checkBizOrderIdOfRetailStoreOrderShippingGroup(String bizOrderId)
	{		
	 	checkIdOfRetailStoreOrderShippingGroup(bizOrderId ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.amount";
	public YoubenbenChecker checkAmountOfRetailStoreOrderShippingGroup(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 5.99,AMOUNT_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.version";
	public YoubenbenChecker checkVersionOfRetailStoreOrderShippingGroup(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	

	public static final String  ID_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.id";
	public YoubenbenChecker checkIdOfRetailStoreOrderPaymentGroup(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  NAME_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.name";
	public YoubenbenChecker checkNameOfRetailStoreOrderPaymentGroup(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.biz_order";
	public YoubenbenChecker checkBizOrderIdOfRetailStoreOrderPaymentGroup(String bizOrderId)
	{		
	 	checkIdOfRetailStoreOrderPaymentGroup(bizOrderId ); 		
		
		return this;
	}	

	public static final String  CARD_NUMBER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.card_number";
	public YoubenbenChecker checkCardNumberOfRetailStoreOrderPaymentGroup(String cardNumber)
	{		
	 	checkStringLengthRange(cardNumber,5, 68,CARD_NUMBER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.version";
	public YoubenbenChecker checkVersionOfRetailStoreOrderPaymentGroup(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	

	public static final String  ID_OF_WAREHOUSE ="warehouse.id";
	public YoubenbenChecker checkIdOfWarehouse(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WAREHOUSE ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_WAREHOUSE ="warehouse.location";
	public YoubenbenChecker checkLocationOfWarehouse(String location)
	{		
	 	checkStringLengthRange(location,2, 24,LOCATION_OF_WAREHOUSE ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_WAREHOUSE ="warehouse.contact_number";
	public YoubenbenChecker checkContactNumberOfWarehouse(String contactNumber)
	{		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_WAREHOUSE ); 		
		
		return this;
	}	

	public static final String  TOTAL_AREA_OF_WAREHOUSE ="warehouse.total_area";
	public YoubenbenChecker checkTotalAreaOfWarehouse(String totalArea)
	{		
	 	checkStringLengthRange(totalArea,3, 36,TOTAL_AREA_OF_WAREHOUSE ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_WAREHOUSE ="warehouse.owner";
	public YoubenbenChecker checkOwnerIdOfWarehouse(String ownerId)
	{		
	 	checkIdOfWarehouse(ownerId ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_WAREHOUSE ="warehouse.latitude";
	public YoubenbenChecker checkLatitudeOfWarehouse(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_WAREHOUSE ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_WAREHOUSE ="warehouse.longitude";
	public YoubenbenChecker checkLongitudeOfWarehouse(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_WAREHOUSE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WAREHOUSE ="warehouse.version";
	public YoubenbenChecker checkVersionOfWarehouse(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WAREHOUSE ); 		
		
		return this;
	}	

	public static final String  ID_OF_STORAGE_SPACE ="storage_space.id";
	public YoubenbenChecker checkIdOfStorageSpace(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_STORAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_STORAGE_SPACE ="storage_space.location";
	public YoubenbenChecker checkLocationOfStorageSpace(String location)
	{		
	 	checkStringLengthRange(location,3, 36,LOCATION_OF_STORAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_STORAGE_SPACE ="storage_space.contact_number";
	public YoubenbenChecker checkContactNumberOfStorageSpace(String contactNumber)
	{		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_STORAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  TOTAL_AREA_OF_STORAGE_SPACE ="storage_space.total_area";
	public YoubenbenChecker checkTotalAreaOfStorageSpace(String totalArea)
	{		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_STORAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  WAREHOUSE_OF_STORAGE_SPACE ="storage_space.warehouse";
	public YoubenbenChecker checkWarehouseIdOfStorageSpace(String warehouseId)
	{		
	 	checkIdOfStorageSpace(warehouseId ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_STORAGE_SPACE ="storage_space.latitude";
	public YoubenbenChecker checkLatitudeOfStorageSpace(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_STORAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_STORAGE_SPACE ="storage_space.longitude";
	public YoubenbenChecker checkLongitudeOfStorageSpace(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_STORAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_STORAGE_SPACE ="storage_space.version";
	public YoubenbenChecker checkVersionOfStorageSpace(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_STORAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  ID_OF_SMART_PALLET ="smart_pallet.id";
	public YoubenbenChecker checkIdOfSmartPallet(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SMART_PALLET ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_SMART_PALLET ="smart_pallet.location";
	public YoubenbenChecker checkLocationOfSmartPallet(String location)
	{		
	 	checkStringLengthRange(location,7, 104,LOCATION_OF_SMART_PALLET ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_SMART_PALLET ="smart_pallet.contact_number";
	public YoubenbenChecker checkContactNumberOfSmartPallet(String contactNumber)
	{		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_SMART_PALLET ); 		
		
		return this;
	}	

	public static final String  TOTAL_AREA_OF_SMART_PALLET ="smart_pallet.total_area";
	public YoubenbenChecker checkTotalAreaOfSmartPallet(String totalArea)
	{		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_SMART_PALLET ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_SMART_PALLET ="smart_pallet.latitude";
	public YoubenbenChecker checkLatitudeOfSmartPallet(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_SMART_PALLET ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_SMART_PALLET ="smart_pallet.longitude";
	public YoubenbenChecker checkLongitudeOfSmartPallet(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_SMART_PALLET ); 		
		
		return this;
	}	

	public static final String  WAREHOUSE_OF_SMART_PALLET ="smart_pallet.warehouse";
	public YoubenbenChecker checkWarehouseIdOfSmartPallet(String warehouseId)
	{		
	 	checkIdOfSmartPallet(warehouseId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SMART_PALLET ="smart_pallet.version";
	public YoubenbenChecker checkVersionOfSmartPallet(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SMART_PALLET ); 		
		
		return this;
	}	

	public static final String  ID_OF_GOODS_SHELF ="goods_shelf.id";
	public YoubenbenChecker checkIdOfGoodsShelf(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_SHELF ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_GOODS_SHELF ="goods_shelf.location";
	public YoubenbenChecker checkLocationOfGoodsShelf(String location)
	{		
	 	checkStringLengthRange(location,2, 20,LOCATION_OF_GOODS_SHELF ); 		
		
		return this;
	}	

	public static final String  STORAGE_SPACE_OF_GOODS_SHELF ="goods_shelf.storage_space";
	public YoubenbenChecker checkStorageSpaceIdOfGoodsShelf(String storageSpaceId)
	{		
	 	checkIdOfGoodsShelf(storageSpaceId ); 		
		
		return this;
	}	

	public static final String  SUPPLIER_SPACE_OF_GOODS_SHELF ="goods_shelf.supplier_space";
	public YoubenbenChecker checkSupplierSpaceIdOfGoodsShelf(String supplierSpaceId)
	{		
	 	checkIdOfGoodsShelf(supplierSpaceId ); 		
		
		return this;
	}	

	public static final String  DAMAGE_SPACE_OF_GOODS_SHELF ="goods_shelf.damage_space";
	public YoubenbenChecker checkDamageSpaceIdOfGoodsShelf(String damageSpaceId)
	{		
	 	checkIdOfGoodsShelf(damageSpaceId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GOODS_SHELF ="goods_shelf.version";
	public YoubenbenChecker checkVersionOfGoodsShelf(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_SHELF ); 		
		
		return this;
	}	

	public static final String  ID_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.id";
	public YoubenbenChecker checkIdOfGoodsShelfStockCount(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.title";
	public YoubenbenChecker checkTitleOfGoodsShelfStockCount(String title)
	{		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
		return this;
	}	

	public static final String  COUNT_TIME_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.count_time";
	public YoubenbenChecker checkCountTimeOfGoodsShelfStockCount(Date countTime)
	{		
	 	checkDateRange(countTime,parseDate("1900-01-01"), parseDate("2017-04-01"),COUNT_TIME_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
		return this;
	}	

	public static final String  SUMMARY_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.summary";
	public YoubenbenChecker checkSummaryOfGoodsShelfStockCount(String summary)
	{		
	 	checkStringLengthRange(summary,5, 72,SUMMARY_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
		return this;
	}	

	public static final String  SHELF_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.shelf";
	public YoubenbenChecker checkShelfIdOfGoodsShelfStockCount(String shelfId)
	{		
	 	checkIdOfGoodsShelfStockCount(shelfId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.version";
	public YoubenbenChecker checkVersionOfGoodsShelfStockCount(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
		return this;
	}	

	public static final String  ID_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.id";
	public YoubenbenChecker checkIdOfStockCountIssueTrack(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.title";
	public YoubenbenChecker checkTitleOfStockCountIssueTrack(String title)
	{		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
		return this;
	}	

	public static final String  COUNT_TIME_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.count_time";
	public YoubenbenChecker checkCountTimeOfStockCountIssueTrack(Date countTime)
	{		
	 	checkDateRange(countTime,parseDate("1900-01-01"), parseDate("2017-04-01"),COUNT_TIME_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
		return this;
	}	

	public static final String  SUMMARY_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.summary";
	public YoubenbenChecker checkSummaryOfStockCountIssueTrack(String summary)
	{		
	 	checkStringLengthRange(summary,3, 40,SUMMARY_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
		return this;
	}	

	public static final String  STOCK_COUNT_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.stock_count";
	public YoubenbenChecker checkStockCountIdOfStockCountIssueTrack(String stockCountId)
	{		
	 	checkIdOfStockCountIssueTrack(stockCountId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.version";
	public YoubenbenChecker checkVersionOfStockCountIssueTrack(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
		return this;
	}	

	public static final String  ID_OF_GOODS_ALLOCATION ="goods_allocation.id";
	public YoubenbenChecker checkIdOfGoodsAllocation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_ALLOCATION ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_GOODS_ALLOCATION ="goods_allocation.location";
	public YoubenbenChecker checkLocationOfGoodsAllocation(String location)
	{		
	 	checkStringLengthRange(location,2, 20,LOCATION_OF_GOODS_ALLOCATION ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_GOODS_ALLOCATION ="goods_allocation.latitude";
	public YoubenbenChecker checkLatitudeOfGoodsAllocation(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_GOODS_ALLOCATION ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_GOODS_ALLOCATION ="goods_allocation.longitude";
	public YoubenbenChecker checkLongitudeOfGoodsAllocation(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_GOODS_ALLOCATION ); 		
		
		return this;
	}	

	public static final String  GOODS_SHELF_OF_GOODS_ALLOCATION ="goods_allocation.goods_shelf";
	public YoubenbenChecker checkGoodsShelfIdOfGoodsAllocation(String goodsShelfId)
	{		
	 	checkIdOfGoodsAllocation(goodsShelfId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GOODS_ALLOCATION ="goods_allocation.version";
	public YoubenbenChecker checkVersionOfGoodsAllocation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_ALLOCATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_GOODS ="goods.id";
	public YoubenbenChecker checkIdOfGoods(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_GOODS ="goods.name";
	public YoubenbenChecker checkNameOfGoods(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_GOODS ); 		
		
		return this;
	}	

	public static final String  RFID_OF_GOODS ="goods.rfid";
	public YoubenbenChecker checkRfidOfGoods(String rfid)
	{		
	 	checkStringLengthRange(rfid,2, 28,RFID_OF_GOODS ); 		
		
		return this;
	}	

	public static final String  UOM_OF_GOODS ="goods.uom";
	public YoubenbenChecker checkUomOfGoods(String uom)
	{		
	 	checkStringLengthRange(uom,0, 4,UOM_OF_GOODS ); 		
		
		return this;
	}	

	public static final String  MAX_PACKAGE_OF_GOODS ="goods.max_package";
	public YoubenbenChecker checkMaxPackageOfGoods(int maxPackage)
	{		
	 	checkIntegerRange(maxPackage,0, 10,MAX_PACKAGE_OF_GOODS ); 		
		
		return this;
	}	

	public static final String  EXPIRE_TIME_OF_GOODS ="goods.expire_time";
	public YoubenbenChecker checkExpireTimeOfGoods(Date expireTime)
	{		
	 	checkDateRange(expireTime,parseDate("1900-01-01"), parseDate("2019-09-09"),EXPIRE_TIME_OF_GOODS ); 		
		
		return this;
	}	

	public static final String  SKU_OF_GOODS ="goods.sku";
	public YoubenbenChecker checkSkuIdOfGoods(String skuId)
	{		
	 	checkIdOfGoods(skuId ); 		
		
		return this;
	}	

	public static final String  RECEIVING_SPACE_OF_GOODS ="goods.receiving_space";
	public YoubenbenChecker checkReceivingSpaceIdOfGoods(String receivingSpaceId)
	{		
	 	checkIdOfGoods(receivingSpaceId ); 		
		
		return this;
	}	

	public static final String  GOODS_ALLOCATION_OF_GOODS ="goods.goods_allocation";
	public YoubenbenChecker checkGoodsAllocationIdOfGoods(String goodsAllocationId)
	{		
	 	checkIdOfGoods(goodsAllocationId ); 		
		
		return this;
	}	

	public static final String  SMART_PALLET_OF_GOODS ="goods.smart_pallet";
	public YoubenbenChecker checkSmartPalletIdOfGoods(String smartPalletId)
	{		
	 	checkIdOfGoods(smartPalletId ); 		
		
		return this;
	}	

	public static final String  SHIPPING_SPACE_OF_GOODS ="goods.shipping_space";
	public YoubenbenChecker checkShippingSpaceIdOfGoods(String shippingSpaceId)
	{		
	 	checkIdOfGoods(shippingSpaceId ); 		
		
		return this;
	}	

	public static final String  TRANSPORT_TASK_OF_GOODS ="goods.transport_task";
	public YoubenbenChecker checkTransportTaskIdOfGoods(String transportTaskId)
	{		
	 	checkIdOfGoods(transportTaskId ); 		
		
		return this;
	}	

	public static final String  RETAIL_STORE_OF_GOODS ="goods.retail_store";
	public YoubenbenChecker checkRetailStoreIdOfGoods(String retailStoreId)
	{		
	 	checkIdOfGoods(retailStoreId ); 		
		
		return this;
	}	

	public static final String  BIZ_ORDER_OF_GOODS ="goods.biz_order";
	public YoubenbenChecker checkBizOrderIdOfGoods(String bizOrderId)
	{		
	 	checkIdOfGoods(bizOrderId ); 		
		
		return this;
	}	

	public static final String  RETAIL_STORE_ORDER_OF_GOODS ="goods.retail_store_order";
	public YoubenbenChecker checkRetailStoreOrderIdOfGoods(String retailStoreOrderId)
	{		
	 	checkIdOfGoods(retailStoreOrderId ); 		
		
		return this;
	}	

	public static final String  PACKAGING_OF_GOODS ="goods.packaging";
	public YoubenbenChecker checkPackagingIdOfGoods(String packagingId)
	{		
	 	checkIdOfGoods(packagingId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GOODS ="goods.version";
	public YoubenbenChecker checkVersionOfGoods(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS ); 		
		
		return this;
	}	

	public static final String  ID_OF_GOODS_PACKAGING ="goods_packaging.id";
	public YoubenbenChecker checkIdOfGoodsPackaging(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	

	public static final String  PACKAGE_NAME_OF_GOODS_PACKAGING ="goods_packaging.package_name";
	public YoubenbenChecker checkPackageNameOfGoodsPackaging(String packageName)
	{		
	 	checkStringLengthRange(packageName,1, 8,PACKAGE_NAME_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	

	public static final String  RFID_OF_GOODS_PACKAGING ="goods_packaging.rfid";
	public YoubenbenChecker checkRfidOfGoodsPackaging(String rfid)
	{		
	 	checkStringLengthRange(rfid,2, 28,RFID_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	

	public static final String  PACKAGE_TIME_OF_GOODS_PACKAGING ="goods_packaging.package_time";
	public YoubenbenChecker checkPackageTimeOfGoodsPackaging(Date packageTime)
	{		
	 	checkDateRange(packageTime,parseDate("1900-01-01"), parseDate("2017-09-09"),PACKAGE_TIME_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_GOODS_PACKAGING ="goods_packaging.description";
	public YoubenbenChecker checkDescriptionOfGoodsPackaging(String description)
	{		
	 	checkStringLengthRange(description,3, 36,DESCRIPTION_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GOODS_PACKAGING ="goods_packaging.version";
	public YoubenbenChecker checkVersionOfGoodsPackaging(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	

	public static final String  ID_OF_GOODS_MOVEMENT ="goods_movement.id";
	public YoubenbenChecker checkIdOfGoodsMovement(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	

	public static final String  MOVE_TIME_OF_GOODS_MOVEMENT ="goods_movement.move_time";
	public YoubenbenChecker checkMoveTimeOfGoodsMovement(DateTime moveTime)
	{		
	 	checkDateTime(moveTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2017-08-09T09:09:09"),MOVE_TIME_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	

	public static final String  FACILITY_OF_GOODS_MOVEMENT ="goods_movement.facility";
	public YoubenbenChecker checkFacilityOfGoodsMovement(String facility)
	{		
	 	checkStringLengthRange(facility,1, 12,FACILITY_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	

	public static final String  FACILITY_ID_OF_GOODS_MOVEMENT ="goods_movement.facility_id";
	public YoubenbenChecker checkFacilityIdOfGoodsMovement(String facilityId)
	{		
	 	checkStringLengthRange(facilityId,1, 12,FACILITY_ID_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	

	public static final String  FROM_IP_OF_GOODS_MOVEMENT ="goods_movement.from_ip";
	public YoubenbenChecker checkFromIpOfGoodsMovement(String fromIp)
	{		
	 	checkStringLengthRange(fromIp,4, 48,FROM_IP_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	

	public static final String  USER_AGENT_OF_GOODS_MOVEMENT ="goods_movement.user_agent";
	public YoubenbenChecker checkUserAgentOfGoodsMovement(String userAgent)
	{		
	 	checkStringLengthRange(userAgent,28, 444,USER_AGENT_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	

	public static final String  SESSION_ID_OF_GOODS_MOVEMENT ="goods_movement.session_id";
	public YoubenbenChecker checkSessionIdOfGoodsMovement(String sessionId)
	{		
	 	checkStringLengthRange(sessionId,6, 80,SESSION_ID_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_GOODS_MOVEMENT ="goods_movement.latitude";
	public YoubenbenChecker checkLatitudeOfGoodsMovement(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_GOODS_MOVEMENT ="goods_movement.longitude";
	public YoubenbenChecker checkLongitudeOfGoodsMovement(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	

	public static final String  GOODS_OF_GOODS_MOVEMENT ="goods_movement.goods";
	public YoubenbenChecker checkGoodsIdOfGoodsMovement(String goodsId)
	{		
	 	checkIdOfGoodsMovement(goodsId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GOODS_MOVEMENT ="goods_movement.version";
	public YoubenbenChecker checkVersionOfGoodsMovement(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_SUPPLIER_SPACE ="supplier_space.id";
	public YoubenbenChecker checkIdOfSupplierSpace(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_SUPPLIER_SPACE ="supplier_space.location";
	public YoubenbenChecker checkLocationOfSupplierSpace(String location)
	{		
	 	checkStringLengthRange(location,2, 20,LOCATION_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_SUPPLIER_SPACE ="supplier_space.contact_number";
	public YoubenbenChecker checkContactNumberOfSupplierSpace(String contactNumber)
	{		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	

	public static final String  TOTAL_AREA_OF_SUPPLIER_SPACE ="supplier_space.total_area";
	public YoubenbenChecker checkTotalAreaOfSupplierSpace(String totalArea)
	{		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	

	public static final String  WAREHOUSE_OF_SUPPLIER_SPACE ="supplier_space.warehouse";
	public YoubenbenChecker checkWarehouseIdOfSupplierSpace(String warehouseId)
	{		
	 	checkIdOfSupplierSpace(warehouseId ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_SUPPLIER_SPACE ="supplier_space.latitude";
	public YoubenbenChecker checkLatitudeOfSupplierSpace(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_SUPPLIER_SPACE ="supplier_space.longitude";
	public YoubenbenChecker checkLongitudeOfSupplierSpace(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SUPPLIER_SPACE ="supplier_space.version";
	public YoubenbenChecker checkVersionOfSupplierSpace(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	

	public static final String  ID_OF_RECEIVING_SPACE ="receiving_space.id";
	public YoubenbenChecker checkIdOfReceivingSpace(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_RECEIVING_SPACE ="receiving_space.location";
	public YoubenbenChecker checkLocationOfReceivingSpace(String location)
	{		
	 	checkStringLengthRange(location,2, 20,LOCATION_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_RECEIVING_SPACE ="receiving_space.contact_number";
	public YoubenbenChecker checkContactNumberOfReceivingSpace(String contactNumber)
	{		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_RECEIVING_SPACE ="receiving_space.description";
	public YoubenbenChecker checkDescriptionOfReceivingSpace(String description)
	{		
	 	checkStringLengthRange(description,4, 52,DESCRIPTION_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	

	public static final String  TOTAL_AREA_OF_RECEIVING_SPACE ="receiving_space.total_area";
	public YoubenbenChecker checkTotalAreaOfReceivingSpace(String totalArea)
	{		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	

	public static final String  WAREHOUSE_OF_RECEIVING_SPACE ="receiving_space.warehouse";
	public YoubenbenChecker checkWarehouseIdOfReceivingSpace(String warehouseId)
	{		
	 	checkIdOfReceivingSpace(warehouseId ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_RECEIVING_SPACE ="receiving_space.latitude";
	public YoubenbenChecker checkLatitudeOfReceivingSpace(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_RECEIVING_SPACE ="receiving_space.longitude";
	public YoubenbenChecker checkLongitudeOfReceivingSpace(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RECEIVING_SPACE ="receiving_space.version";
	public YoubenbenChecker checkVersionOfReceivingSpace(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	

	public static final String  ID_OF_SHIPPING_SPACE ="shipping_space.id";
	public YoubenbenChecker checkIdOfShippingSpace(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_SHIPPING_SPACE ="shipping_space.location";
	public YoubenbenChecker checkLocationOfShippingSpace(String location)
	{		
	 	checkStringLengthRange(location,2, 20,LOCATION_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_SHIPPING_SPACE ="shipping_space.contact_number";
	public YoubenbenChecker checkContactNumberOfShippingSpace(String contactNumber)
	{		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	

	public static final String  TOTAL_AREA_OF_SHIPPING_SPACE ="shipping_space.total_area";
	public YoubenbenChecker checkTotalAreaOfShippingSpace(String totalArea)
	{		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	

	public static final String  WAREHOUSE_OF_SHIPPING_SPACE ="shipping_space.warehouse";
	public YoubenbenChecker checkWarehouseIdOfShippingSpace(String warehouseId)
	{		
	 	checkIdOfShippingSpace(warehouseId ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_SHIPPING_SPACE ="shipping_space.latitude";
	public YoubenbenChecker checkLatitudeOfShippingSpace(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_SHIPPING_SPACE ="shipping_space.longitude";
	public YoubenbenChecker checkLongitudeOfShippingSpace(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_SHIPPING_SPACE ="shipping_space.description";
	public YoubenbenChecker checkDescriptionOfShippingSpace(String description)
	{		
	 	checkStringLengthRange(description,4, 52,DESCRIPTION_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SHIPPING_SPACE ="shipping_space.version";
	public YoubenbenChecker checkVersionOfShippingSpace(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	

	public static final String  ID_OF_DAMAGE_SPACE ="damage_space.id";
	public YoubenbenChecker checkIdOfDamageSpace(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_DAMAGE_SPACE ="damage_space.location";
	public YoubenbenChecker checkLocationOfDamageSpace(String location)
	{		
	 	checkStringLengthRange(location,2, 20,LOCATION_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_DAMAGE_SPACE ="damage_space.contact_number";
	public YoubenbenChecker checkContactNumberOfDamageSpace(String contactNumber)
	{		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  TOTAL_AREA_OF_DAMAGE_SPACE ="damage_space.total_area";
	public YoubenbenChecker checkTotalAreaOfDamageSpace(String totalArea)
	{		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_DAMAGE_SPACE ="damage_space.latitude";
	public YoubenbenChecker checkLatitudeOfDamageSpace(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_DAMAGE_SPACE ="damage_space.longitude";
	public YoubenbenChecker checkLongitudeOfDamageSpace(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  WAREHOUSE_OF_DAMAGE_SPACE ="damage_space.warehouse";
	public YoubenbenChecker checkWarehouseIdOfDamageSpace(String warehouseId)
	{		
	 	checkIdOfDamageSpace(warehouseId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_DAMAGE_SPACE ="damage_space.version";
	public YoubenbenChecker checkVersionOfDamageSpace(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	

	public static final String  ID_OF_WAREHOUSE_ASSET ="warehouse_asset.id";
	public YoubenbenChecker checkIdOfWarehouseAsset(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WAREHOUSE_ASSET ); 		
		
		return this;
	}	

	public static final String  NAME_OF_WAREHOUSE_ASSET ="warehouse_asset.name";
	public YoubenbenChecker checkNameOfWarehouseAsset(String name)
	{		
	 	checkStringLengthRange(name,1, 20,NAME_OF_WAREHOUSE_ASSET ); 		
		
		return this;
	}	

	public static final String  POSITION_OF_WAREHOUSE_ASSET ="warehouse_asset.position";
	public YoubenbenChecker checkPositionOfWarehouseAsset(String position)
	{		
	 	checkStringLengthRange(position,3, 40,POSITION_OF_WAREHOUSE_ASSET ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_WAREHOUSE_ASSET ="warehouse_asset.owner";
	public YoubenbenChecker checkOwnerIdOfWarehouseAsset(String ownerId)
	{		
	 	checkIdOfWarehouseAsset(ownerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WAREHOUSE_ASSET ="warehouse_asset.version";
	public YoubenbenChecker checkVersionOfWarehouseAsset(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WAREHOUSE_ASSET ); 		
		
		return this;
	}	

	public static final String  ID_OF_TRANSPORT_FLEET ="transport_fleet.id";
	public YoubenbenChecker checkIdOfTransportFleet(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TRANSPORT_FLEET ); 		
		
		return this;
	}	

	public static final String  NAME_OF_TRANSPORT_FLEET ="transport_fleet.name";
	public YoubenbenChecker checkNameOfTransportFleet(String name)
	{		
	 	checkStringLengthRange(name,2, 20,NAME_OF_TRANSPORT_FLEET ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_TRANSPORT_FLEET ="transport_fleet.contact_number";
	public YoubenbenChecker checkContactNumberOfTransportFleet(String contactNumber)
	{		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_TRANSPORT_FLEET ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_TRANSPORT_FLEET ="transport_fleet.owner";
	public YoubenbenChecker checkOwnerIdOfTransportFleet(String ownerId)
	{		
	 	checkIdOfTransportFleet(ownerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TRANSPORT_FLEET ="transport_fleet.version";
	public YoubenbenChecker checkVersionOfTransportFleet(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_FLEET ); 		
		
		return this;
	}	

	public static final String  ID_OF_TRANSPORT_TRUCK ="transport_truck.id";
	public YoubenbenChecker checkIdOfTransportTruck(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	

	public static final String  NAME_OF_TRANSPORT_TRUCK ="transport_truck.name";
	public YoubenbenChecker checkNameOfTransportTruck(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	

	public static final String  PLATE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.plate_number";
	public YoubenbenChecker checkPlateNumberOfTransportTruck(String plateNumber)
	{		
	 	checkStringLengthRange(plateNumber,2, 16,PLATE_NUMBER_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.contact_number";
	public YoubenbenChecker checkContactNumberOfTransportTruck(String contactNumber)
	{		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	

	public static final String  VEHICLE_LICENSE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.vehicle_license_number";
	public YoubenbenChecker checkVehicleLicenseNumberOfTransportTruck(String vehicleLicenseNumber)
	{		
	 	checkStringLengthRange(vehicleLicenseNumber,2, 24,VEHICLE_LICENSE_NUMBER_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	

	public static final String  ENGINE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.engine_number";
	public YoubenbenChecker checkEngineNumberOfTransportTruck(String engineNumber)
	{		
	 	checkStringLengthRange(engineNumber,2, 28,ENGINE_NUMBER_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	

	public static final String  MAKE_DATE_OF_TRANSPORT_TRUCK ="transport_truck.make_date";
	public YoubenbenChecker checkMakeDateOfTransportTruck(Date makeDate)
	{		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2010-09-09"),MAKE_DATE_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	

	public static final String  MILEAGE_OF_TRANSPORT_TRUCK ="transport_truck.mileage";
	public YoubenbenChecker checkMileageOfTransportTruck(String mileage)
	{		
	 	checkStringLengthRange(mileage,2, 24,MILEAGE_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	

	public static final String  BODY_COLOR_OF_TRANSPORT_TRUCK ="transport_truck.body_color";
	public YoubenbenChecker checkBodyColorOfTransportTruck(String bodyColor)
	{		
	 	checkStringLengthRange(bodyColor,1, 8,BODY_COLOR_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_TRANSPORT_TRUCK ="transport_truck.owner";
	public YoubenbenChecker checkOwnerIdOfTransportTruck(String ownerId)
	{		
	 	checkIdOfTransportTruck(ownerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TRANSPORT_TRUCK ="transport_truck.version";
	public YoubenbenChecker checkVersionOfTransportTruck(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	

	public static final String  ID_OF_TRUCK_DRIVER ="truck_driver.id";
	public YoubenbenChecker checkIdOfTruckDriver(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TRUCK_DRIVER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_TRUCK_DRIVER ="truck_driver.name";
	public YoubenbenChecker checkNameOfTruckDriver(String name)
	{		
	 	checkStringLengthRange(name,2, 24,NAME_OF_TRUCK_DRIVER ); 		
		
		return this;
	}	

	public static final String  DRIVER_LICENSE_NUMBER_OF_TRUCK_DRIVER ="truck_driver.driver_license_number";
	public YoubenbenChecker checkDriverLicenseNumberOfTruckDriver(String driverLicenseNumber)
	{		
	 	checkStringLengthRange(driverLicenseNumber,3, 44,DRIVER_LICENSE_NUMBER_OF_TRUCK_DRIVER ); 		
		
		return this;
	}	

	public static final String  CONTACT_NUMBER_OF_TRUCK_DRIVER ="truck_driver.contact_number";
	public YoubenbenChecker checkContactNumberOfTruckDriver(String contactNumber)
	{		
	 	checkChinaMobilePhone(contactNumber,5, 44,CONTACT_NUMBER_OF_TRUCK_DRIVER ); 		
		
		return this;
	}	

	public static final String  BELONGS_TO_OF_TRUCK_DRIVER ="truck_driver.belongs_to";
	public YoubenbenChecker checkBelongsToIdOfTruckDriver(String belongsToId)
	{		
	 	checkIdOfTruckDriver(belongsToId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TRUCK_DRIVER ="truck_driver.version";
	public YoubenbenChecker checkVersionOfTruckDriver(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRUCK_DRIVER ); 		
		
		return this;
	}	

	public static final String  ID_OF_TRANSPORT_TASK ="transport_task.id";
	public YoubenbenChecker checkIdOfTransportTask(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	

	public static final String  NAME_OF_TRANSPORT_TASK ="transport_task.name";
	public YoubenbenChecker checkNameOfTransportTask(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	

	public static final String  START_OF_TRANSPORT_TASK ="transport_task.start";
	public YoubenbenChecker checkStartOfTransportTask(String start)
	{		
	 	checkStringLengthRange(start,2, 20,START_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	

	public static final String  BEGIN_TIME_OF_TRANSPORT_TASK ="transport_task.begin_time";
	public YoubenbenChecker checkBeginTimeOfTransportTask(Date beginTime)
	{		
	 	checkDatePast(beginTime,parseDate("1900-01-01"), new Date(),BEGIN_TIME_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	

	public static final String  END_OF_TRANSPORT_TASK ="transport_task.end";
	public YoubenbenChecker checkEndIdOfTransportTask(String endId)
	{		
	 	checkIdOfTransportTask(endId ); 		
		
		return this;
	}	

	public static final String  DRIVER_OF_TRANSPORT_TASK ="transport_task.driver";
	public YoubenbenChecker checkDriverIdOfTransportTask(String driverId)
	{		
	 	checkIdOfTransportTask(driverId ); 		
		
		return this;
	}	

	public static final String  TRUCK_OF_TRANSPORT_TASK ="transport_task.truck";
	public YoubenbenChecker checkTruckIdOfTransportTask(String truckId)
	{		
	 	checkIdOfTransportTask(truckId ); 		
		
		return this;
	}	

	public static final String  BELONGS_TO_OF_TRANSPORT_TASK ="transport_task.belongs_to";
	public YoubenbenChecker checkBelongsToIdOfTransportTask(String belongsToId)
	{		
	 	checkIdOfTransportTask(belongsToId ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_TRANSPORT_TASK ="transport_task.latitude";
	public YoubenbenChecker checkLatitudeOfTransportTask(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_TRANSPORT_TASK ="transport_task.longitude";
	public YoubenbenChecker checkLongitudeOfTransportTask(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TRANSPORT_TASK ="transport_task.version";
	public YoubenbenChecker checkVersionOfTransportTask(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	

	public static final String  ID_OF_TRANSPORT_TASK_TRACK ="transport_task_track.id";
	public YoubenbenChecker checkIdOfTransportTaskTrack(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	

	public static final String  TRACK_TIME_OF_TRANSPORT_TASK_TRACK ="transport_task_track.track_time";
	public YoubenbenChecker checkTrackTimeOfTransportTaskTrack(Date trackTime)
	{		
	 	checkDatePast(trackTime,parseDate("1900-01-01"), new Date(),TRACK_TIME_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	

	public static final String  LATITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.latitude";
	public YoubenbenChecker checkLatitudeOfTransportTaskTrack(BigDecimal latitude)
	{		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	

	public static final String  LONGITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.longitude";
	public YoubenbenChecker checkLongitudeOfTransportTaskTrack(BigDecimal longitude)
	{		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	

	public static final String  MOVEMENT_OF_TRANSPORT_TASK_TRACK ="transport_task_track.movement";
	public YoubenbenChecker checkMovementIdOfTransportTaskTrack(String movementId)
	{		
	 	checkIdOfTransportTaskTrack(movementId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TRANSPORT_TASK_TRACK ="transport_task_track.version";
	public YoubenbenChecker checkVersionOfTransportTaskTrack(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	

	public static final String  ID_OF_ACCOUNT_SET ="account_set.id";
	public YoubenbenChecker checkIdOfAccountSet(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNT_SET ); 		
		
		return this;
	}	

	public static final String  NAME_OF_ACCOUNT_SET ="account_set.name";
	public YoubenbenChecker checkNameOfAccountSet(String name)
	{		
	 	checkStringLengthRange(name,3, 24,NAME_OF_ACCOUNT_SET ); 		
		
		return this;
	}	

	public static final String  YEAR_SET_OF_ACCOUNT_SET ="account_set.year_set";
	public YoubenbenChecker checkYearSetOfAccountSet(String yearSet)
	{		
	 	checkStringLengthRange(yearSet,2, 20,YEAR_SET_OF_ACCOUNT_SET ); 		
		
		return this;
	}	

	public static final String  EFFECTIVE_DATE_OF_ACCOUNT_SET ="account_set.effective_date";
	public YoubenbenChecker checkEffectiveDateOfAccountSet(Date effectiveDate)
	{		
	 	checkDateRange(effectiveDate,parseDate("1900-01-01"), parseDate("2017-05-28"),EFFECTIVE_DATE_OF_ACCOUNT_SET ); 		
		
		return this;
	}	

	public static final String  ACCOUNTING_SYSTEM_OF_ACCOUNT_SET ="account_set.accounting_system";
	public YoubenbenChecker checkAccountingSystemOfAccountSet(String accountingSystem)
	{		
	 	checkStringLengthRange(accountingSystem,3, 28,ACCOUNTING_SYSTEM_OF_ACCOUNT_SET ); 		
		
		return this;
	}	

	public static final String  DOMESTIC_CURRENCY_CODE_OF_ACCOUNT_SET ="account_set.domestic_currency_code";
	public YoubenbenChecker checkDomesticCurrencyCodeOfAccountSet(String domesticCurrencyCode)
	{		
	 	checkStringLengthRange(domesticCurrencyCode,1, 12,DOMESTIC_CURRENCY_CODE_OF_ACCOUNT_SET ); 		
		
		return this;
	}	

	public static final String  DOMESTIC_CURRENCY_NAME_OF_ACCOUNT_SET ="account_set.domestic_currency_name";
	public YoubenbenChecker checkDomesticCurrencyNameOfAccountSet(String domesticCurrencyName)
	{		
	 	checkStringLengthRange(domesticCurrencyName,1, 12,DOMESTIC_CURRENCY_NAME_OF_ACCOUNT_SET ); 		
		
		return this;
	}	

	public static final String  OPENING_BANK_OF_ACCOUNT_SET ="account_set.opening_bank";
	public YoubenbenChecker checkOpeningBankOfAccountSet(String openingBank)
	{		
	 	checkStringLengthRange(openingBank,2, 16,OPENING_BANK_OF_ACCOUNT_SET ); 		
		
		return this;
	}	

	public static final String  ACCOUNT_NUMBER_OF_ACCOUNT_SET ="account_set.account_number";
	public YoubenbenChecker checkAccountNumberOfAccountSet(String accountNumber)
	{		
	 	checkStringLengthRange(accountNumber,4, 56,ACCOUNT_NUMBER_OF_ACCOUNT_SET ); 		
		
		return this;
	}	

	public static final String  COUNTRY_CENTER_OF_ACCOUNT_SET ="account_set.country_center";
	public YoubenbenChecker checkCountryCenterIdOfAccountSet(String countryCenterId)
	{		
	 	checkIdOfAccountSet(countryCenterId ); 		
		
		return this;
	}	

	public static final String  RETAIL_STORE_OF_ACCOUNT_SET ="account_set.retail_store";
	public YoubenbenChecker checkRetailStoreIdOfAccountSet(String retailStoreId)
	{		
	 	checkIdOfAccountSet(retailStoreId ); 		
		
		return this;
	}	

	public static final String  GOODS_SUPPLIER_OF_ACCOUNT_SET ="account_set.goods_supplier";
	public YoubenbenChecker checkGoodsSupplierIdOfAccountSet(String goodsSupplierId)
	{		
	 	checkIdOfAccountSet(goodsSupplierId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ACCOUNT_SET ="account_set.version";
	public YoubenbenChecker checkVersionOfAccountSet(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNT_SET ); 		
		
		return this;
	}	

	public static final String  ID_OF_ACCOUNTING_SUBJECT ="accounting_subject.id";
	public YoubenbenChecker checkIdOfAccountingSubject(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	

	public static final String  ACCOUNTING_SUBJECT_CODE_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_code";
	public YoubenbenChecker checkAccountingSubjectCodeOfAccountingSubject(String accountingSubjectCode)
	{		
	 	checkStringLengthRange(accountingSubjectCode,2, 24,ACCOUNTING_SUBJECT_CODE_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	

	public static final String  ACCOUNTING_SUBJECT_NAME_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_name";
	public YoubenbenChecker checkAccountingSubjectNameOfAccountingSubject(String accountingSubjectName)
	{		
	 	checkStringLengthRange(accountingSubjectName,2, 16,ACCOUNTING_SUBJECT_NAME_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	

	public static final String  ACCOUNTING_SUBJECT_CLASS_CODE_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_class_code";
	public YoubenbenChecker checkAccountingSubjectClassCodeOfAccountingSubject(int accountingSubjectClassCode)
	{		
	 	checkIntegerRange(accountingSubjectClassCode,0, 6,ACCOUNTING_SUBJECT_CLASS_CODE_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	

	public static final String  ACCOUNTING_SUBJECT_CLASS_NAME_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_class_name";
	public YoubenbenChecker checkAccountingSubjectClassNameOfAccountingSubject(String accountingSubjectClassName)
	{		
	 	checkStringLengthRange(accountingSubjectClassName,1, 24,ACCOUNTING_SUBJECT_CLASS_NAME_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	

	public static final String  ACCOUNT_SET_OF_ACCOUNTING_SUBJECT ="accounting_subject.account_set";
	public YoubenbenChecker checkAccountSetIdOfAccountingSubject(String accountSetId)
	{		
	 	checkIdOfAccountingSubject(accountSetId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ACCOUNTING_SUBJECT ="accounting_subject.version";
	public YoubenbenChecker checkVersionOfAccountingSubject(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	

	public static final String  ID_OF_ACCOUNTING_PERIOD ="accounting_period.id";
	public YoubenbenChecker checkIdOfAccountingPeriod(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_PERIOD ); 		
		
		return this;
	}	

	public static final String  NAME_OF_ACCOUNTING_PERIOD ="accounting_period.name";
	public YoubenbenChecker checkNameOfAccountingPeriod(String name)
	{		
	 	checkStringLengthRange(name,3, 32,NAME_OF_ACCOUNTING_PERIOD ); 		
		
		return this;
	}	

	public static final String  START_DATE_OF_ACCOUNTING_PERIOD ="accounting_period.start_date";
	public YoubenbenChecker checkStartDateOfAccountingPeriod(Date startDate)
	{		
	 	checkDateRange(startDate,parseDate("1900-01-01"), parseDate("2017-01-09"),START_DATE_OF_ACCOUNTING_PERIOD ); 		
		
		return this;
	}	

	public static final String  END_DATE_OF_ACCOUNTING_PERIOD ="accounting_period.end_date";
	public YoubenbenChecker checkEndDateOfAccountingPeriod(Date endDate)
	{		
	 	checkDateRange(endDate,parseDate("1900-01-01"), parseDate("2017-01-09"),END_DATE_OF_ACCOUNTING_PERIOD ); 		
		
		return this;
	}	

	public static final String  ACCOUNT_SET_OF_ACCOUNTING_PERIOD ="accounting_period.account_set";
	public YoubenbenChecker checkAccountSetIdOfAccountingPeriod(String accountSetId)
	{		
	 	checkIdOfAccountingPeriod(accountSetId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ACCOUNTING_PERIOD ="accounting_period.version";
	public YoubenbenChecker checkVersionOfAccountingPeriod(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_PERIOD ); 		
		
		return this;
	}	

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.id";
	public YoubenbenChecker checkIdOfAccountingDocumentType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_DOCUMENT_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.name";
	public YoubenbenChecker checkNameOfAccountingDocumentType(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_ACCOUNTING_DOCUMENT_TYPE ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.description";
	public YoubenbenChecker checkDescriptionOfAccountingDocumentType(String description)
	{		
	 	checkStringLengthRange(description,18, 280,DESCRIPTION_OF_ACCOUNTING_DOCUMENT_TYPE ); 		
		
		return this;
	}	

	public static final String  ACCOUNTING_PERIOD_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.accounting_period";
	public YoubenbenChecker checkAccountingPeriodIdOfAccountingDocumentType(String accountingPeriodId)
	{		
	 	checkIdOfAccountingDocumentType(accountingPeriodId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.version";
	public YoubenbenChecker checkVersionOfAccountingDocumentType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_ACCOUNTING_DOCUMENT ="accounting_document.id";
	public YoubenbenChecker checkIdOfAccountingDocument(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_DOCUMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_ACCOUNTING_DOCUMENT ="accounting_document.name";
	public YoubenbenChecker checkNameOfAccountingDocument(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_ACCOUNTING_DOCUMENT ); 		
		
		return this;
	}	

	public static final String  ACCOUNTING_DOCUMENT_DATE_OF_ACCOUNTING_DOCUMENT ="accounting_document.accounting_document_date";
	public YoubenbenChecker checkAccountingDocumentDateOfAccountingDocument(Date accountingDocumentDate)
	{		
	 	checkDateRange(accountingDocumentDate,parseDate("1900-01-01"), parseDate("2018-09-09"),ACCOUNTING_DOCUMENT_DATE_OF_ACCOUNTING_DOCUMENT ); 		
		
		return this;
	}	

	public static final String  ACCOUNTING_PERIOD_OF_ACCOUNTING_DOCUMENT ="accounting_document.accounting_period";
	public YoubenbenChecker checkAccountingPeriodIdOfAccountingDocument(String accountingPeriodId)
	{		
	 	checkIdOfAccountingDocument(accountingPeriodId ); 		
		
		return this;
	}	

	public static final String  DOCUMENT_TYPE_OF_ACCOUNTING_DOCUMENT ="accounting_document.document_type";
	public YoubenbenChecker checkDocumentTypeIdOfAccountingDocument(String documentTypeId)
	{		
	 	checkIdOfAccountingDocument(documentTypeId ); 		
		
		return this;
	}	

	public static final String  CREATION_OF_ACCOUNTING_DOCUMENT ="accounting_document.creation";
	public YoubenbenChecker checkCreationIdOfAccountingDocument(String creationId)
	{		
	 	checkIdOfAccountingDocument(creationId ); 		
		
		return this;
	}	

	public static final String  CONFIRMATION_OF_ACCOUNTING_DOCUMENT ="accounting_document.confirmation";
	public YoubenbenChecker checkConfirmationIdOfAccountingDocument(String confirmationId)
	{		
	 	checkIdOfAccountingDocument(confirmationId ); 		
		
		return this;
	}	

	public static final String  AUDITING_OF_ACCOUNTING_DOCUMENT ="accounting_document.auditing";
	public YoubenbenChecker checkAuditingIdOfAccountingDocument(String auditingId)
	{		
	 	checkIdOfAccountingDocument(auditingId ); 		
		
		return this;
	}	

	public static final String  POSTING_OF_ACCOUNTING_DOCUMENT ="accounting_document.posting";
	public YoubenbenChecker checkPostingIdOfAccountingDocument(String postingId)
	{		
	 	checkIdOfAccountingDocument(postingId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT ="accounting_document.version";
	public YoubenbenChecker checkVersionOfAccountingDocument(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.id";
	public YoubenbenChecker checkIdOfAccountingDocumentCreation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_DOCUMENT_CREATION ); 		
		
		return this;
	}	

	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.who";
	public YoubenbenChecker checkWhoOfAccountingDocumentCreation(String who)
	{		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_CREATION ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.comments";
	public YoubenbenChecker checkCommentsOfAccountingDocumentCreation(String comments)
	{		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ACCOUNTING_DOCUMENT_CREATION ); 		
		
		return this;
	}	

	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.make_date";
	public YoubenbenChecker checkMakeDateOfAccountingDocumentCreation(Date makeDate)
	{		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CREATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.version";
	public YoubenbenChecker checkVersionOfAccountingDocumentCreation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_CREATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.id";
	public YoubenbenChecker checkIdOfAccountingDocumentConfirmation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.who";
	public YoubenbenChecker checkWhoOfAccountingDocumentConfirmation(String who)
	{		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.comments";
	public YoubenbenChecker checkCommentsOfAccountingDocumentConfirmation(String comments)
	{		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.make_date";
	public YoubenbenChecker checkMakeDateOfAccountingDocumentConfirmation(Date makeDate)
	{		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.version";
	public YoubenbenChecker checkVersionOfAccountingDocumentConfirmation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.id";
	public YoubenbenChecker checkIdOfAccountingDocumentAuditing(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_DOCUMENT_AUDITING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.who";
	public YoubenbenChecker checkWhoOfAccountingDocumentAuditing(String who)
	{		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_AUDITING ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.comments";
	public YoubenbenChecker checkCommentsOfAccountingDocumentAuditing(String comments)
	{		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_ACCOUNTING_DOCUMENT_AUDITING ); 		
		
		return this;
	}	

	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.make_date";
	public YoubenbenChecker checkMakeDateOfAccountingDocumentAuditing(Date makeDate)
	{		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_AUDITING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.version";
	public YoubenbenChecker checkVersionOfAccountingDocumentAuditing(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_AUDITING ); 		
		
		return this;
	}	

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.id";
	public YoubenbenChecker checkIdOfAccountingDocumentPosting(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_DOCUMENT_POSTING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.who";
	public YoubenbenChecker checkWhoOfAccountingDocumentPosting(String who)
	{		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_POSTING ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.comments";
	public YoubenbenChecker checkCommentsOfAccountingDocumentPosting(String comments)
	{		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_ACCOUNTING_DOCUMENT_POSTING ); 		
		
		return this;
	}	

	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.make_date";
	public YoubenbenChecker checkMakeDateOfAccountingDocumentPosting(Date makeDate)
	{		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_POSTING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.version";
	public YoubenbenChecker checkVersionOfAccountingDocumentPosting(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_POSTING ); 		
		
		return this;
	}	

	public static final String  ID_OF_ORIGINAL_VOUCHER ="original_voucher.id";
	public YoubenbenChecker checkIdOfOriginalVoucher(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_ORIGINAL_VOUCHER ="original_voucher.title";
	public YoubenbenChecker checkTitleOfOriginalVoucher(String title)
	{		
	 	checkStringLengthRange(title,2, 28,TITLE_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	

	public static final String  MADE_BY_OF_ORIGINAL_VOUCHER ="original_voucher.made_by";
	public YoubenbenChecker checkMadeByOfOriginalVoucher(String madeBy)
	{		
	 	checkStringLengthRange(madeBy,1, 12,MADE_BY_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	

	public static final String  RECEIVED_BY_OF_ORIGINAL_VOUCHER ="original_voucher.received_by";
	public YoubenbenChecker checkReceivedByOfOriginalVoucher(String receivedBy)
	{		
	 	checkStringLengthRange(receivedBy,1, 12,RECEIVED_BY_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	

	public static final String  VOUCHER_TYPE_OF_ORIGINAL_VOUCHER ="original_voucher.voucher_type";
	public YoubenbenChecker checkVoucherTypeOfOriginalVoucher(String voucherType)
	{		
	 	checkStringLengthRange(voucherType,1, 16,VOUCHER_TYPE_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	

	public static final String  VOUCHER_IMAGE_OF_ORIGINAL_VOUCHER ="original_voucher.voucher_image";
	public YoubenbenChecker checkVoucherImageOfOriginalVoucher(String voucherImage)
	{		
	 	checkImage(voucherImage,0, 512,VOUCHER_IMAGE_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	

	public static final String  BELONGS_TO_OF_ORIGINAL_VOUCHER ="original_voucher.belongs_to";
	public YoubenbenChecker checkBelongsToIdOfOriginalVoucher(String belongsToId)
	{		
	 	checkIdOfOriginalVoucher(belongsToId ); 		
		
		return this;
	}	

	public static final String  CREATION_OF_ORIGINAL_VOUCHER ="original_voucher.creation";
	public YoubenbenChecker checkCreationIdOfOriginalVoucher(String creationId)
	{		
	 	checkIdOfOriginalVoucher(creationId ); 		
		
		return this;
	}	

	public static final String  CONFIRMATION_OF_ORIGINAL_VOUCHER ="original_voucher.confirmation";
	public YoubenbenChecker checkConfirmationIdOfOriginalVoucher(String confirmationId)
	{		
	 	checkIdOfOriginalVoucher(confirmationId ); 		
		
		return this;
	}	

	public static final String  AUDITING_OF_ORIGINAL_VOUCHER ="original_voucher.auditing";
	public YoubenbenChecker checkAuditingIdOfOriginalVoucher(String auditingId)
	{		
	 	checkIdOfOriginalVoucher(auditingId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ORIGINAL_VOUCHER ="original_voucher.version";
	public YoubenbenChecker checkVersionOfOriginalVoucher(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	

	public static final String  ID_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.id";
	public YoubenbenChecker checkIdOfOriginalVoucherCreation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ORIGINAL_VOUCHER_CREATION ); 		
		
		return this;
	}	

	public static final String  WHO_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.who";
	public YoubenbenChecker checkWhoOfOriginalVoucherCreation(String who)
	{		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ORIGINAL_VOUCHER_CREATION ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.comments";
	public YoubenbenChecker checkCommentsOfOriginalVoucherCreation(String comments)
	{		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ORIGINAL_VOUCHER_CREATION ); 		
		
		return this;
	}	

	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.make_date";
	public YoubenbenChecker checkMakeDateOfOriginalVoucherCreation(Date makeDate)
	{		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ORIGINAL_VOUCHER_CREATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.version";
	public YoubenbenChecker checkVersionOfOriginalVoucherCreation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER_CREATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.id";
	public YoubenbenChecker checkIdOfOriginalVoucherConfirmation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ORIGINAL_VOUCHER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  WHO_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.who";
	public YoubenbenChecker checkWhoOfOriginalVoucherConfirmation(String who)
	{		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ORIGINAL_VOUCHER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.comments";
	public YoubenbenChecker checkCommentsOfOriginalVoucherConfirmation(String comments)
	{		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ORIGINAL_VOUCHER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.make_date";
	public YoubenbenChecker checkMakeDateOfOriginalVoucherConfirmation(Date makeDate)
	{		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ORIGINAL_VOUCHER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.version";
	public YoubenbenChecker checkVersionOfOriginalVoucherConfirmation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER_CONFIRMATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.id";
	public YoubenbenChecker checkIdOfOriginalVoucherAuditing(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ORIGINAL_VOUCHER_AUDITING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.who";
	public YoubenbenChecker checkWhoOfOriginalVoucherAuditing(String who)
	{		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ORIGINAL_VOUCHER_AUDITING ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.comments";
	public YoubenbenChecker checkCommentsOfOriginalVoucherAuditing(String comments)
	{		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_ORIGINAL_VOUCHER_AUDITING ); 		
		
		return this;
	}	

	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.make_date";
	public YoubenbenChecker checkMakeDateOfOriginalVoucherAuditing(Date makeDate)
	{		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ORIGINAL_VOUCHER_AUDITING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.version";
	public YoubenbenChecker checkVersionOfOriginalVoucherAuditing(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER_AUDITING ); 		
		
		return this;
	}	

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.id";
	public YoubenbenChecker checkIdOfAccountingDocumentLine(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.name";
	public YoubenbenChecker checkNameOfAccountingDocumentLine(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.code";
	public YoubenbenChecker checkCodeOfAccountingDocumentLine(String code)
	{		
	 	checkStringLengthRange(code,2, 24,CODE_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	

	public static final String  DIRECT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.direct";
	public YoubenbenChecker checkDirectOfAccountingDocumentLine(String direct)
	{		
	 	checkStringLengthRange(direct,0, 4,DIRECT_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.amount";
	public YoubenbenChecker checkAmountOfAccountingDocumentLine(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 989127.99,AMOUNT_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	

	public static final String  BELONGS_TO_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.belongs_to";
	public YoubenbenChecker checkBelongsToIdOfAccountingDocumentLine(String belongsToId)
	{		
	 	checkIdOfAccountingDocumentLine(belongsToId ); 		
		
		return this;
	}	

	public static final String  ACCOUNTING_SUBJECT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.accounting_subject";
	public YoubenbenChecker checkAccountingSubjectIdOfAccountingDocumentLine(String accountingSubjectId)
	{		
	 	checkIdOfAccountingDocumentLine(accountingSubjectId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.version";
	public YoubenbenChecker checkVersionOfAccountingDocumentLine(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.id";
	public YoubenbenChecker checkIdOfLevelOneDepartment(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  BELONGS_TO_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.belongs_to";
	public YoubenbenChecker checkBelongsToIdOfLevelOneDepartment(String belongsToId)
	{		
	 	checkIdOfLevelOneDepartment(belongsToId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.name";
	public YoubenbenChecker checkNameOfLevelOneDepartment(String name)
	{		
	 	checkStringLengthRange(name,1, 20,NAME_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.description";
	public YoubenbenChecker checkDescriptionOfLevelOneDepartment(String description)
	{		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  MANAGER_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.manager";
	public YoubenbenChecker checkManagerOfLevelOneDepartment(String manager)
	{		
	 	checkStringLengthRange(manager,1, 12,MANAGER_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.founded";
	public YoubenbenChecker checkFoundedOfLevelOneDepartment(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.version";
	public YoubenbenChecker checkVersionOfLevelOneDepartment(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.id";
	public YoubenbenChecker checkIdOfLevelTwoDepartment(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_TWO_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  BELONGS_TO_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.belongs_to";
	public YoubenbenChecker checkBelongsToIdOfLevelTwoDepartment(String belongsToId)
	{		
	 	checkIdOfLevelTwoDepartment(belongsToId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.name";
	public YoubenbenChecker checkNameOfLevelTwoDepartment(String name)
	{		
	 	checkStringLengthRange(name,3, 40,NAME_OF_LEVEL_TWO_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.description";
	public YoubenbenChecker checkDescriptionOfLevelTwoDepartment(String description)
	{		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_LEVEL_TWO_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.founded";
	public YoubenbenChecker checkFoundedOfLevelTwoDepartment(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_LEVEL_TWO_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.version";
	public YoubenbenChecker checkVersionOfLevelTwoDepartment(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.id";
	public YoubenbenChecker checkIdOfLevelThreeDepartment(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_THREE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  BELONGS_TO_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.belongs_to";
	public YoubenbenChecker checkBelongsToIdOfLevelThreeDepartment(String belongsToId)
	{		
	 	checkIdOfLevelThreeDepartment(belongsToId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.name";
	public YoubenbenChecker checkNameOfLevelThreeDepartment(String name)
	{		
	 	checkStringLengthRange(name,5, 52,NAME_OF_LEVEL_THREE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.description";
	public YoubenbenChecker checkDescriptionOfLevelThreeDepartment(String description)
	{		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_LEVEL_THREE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.founded";
	public YoubenbenChecker checkFoundedOfLevelThreeDepartment(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_LEVEL_THREE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.version";
	public YoubenbenChecker checkVersionOfLevelThreeDepartment(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_THREE_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_SKILL_TYPE ="skill_type.id";
	public YoubenbenChecker checkIdOfSkillType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SKILL_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_SKILL_TYPE ="skill_type.code";
	public YoubenbenChecker checkCodeOfSkillType(String code)
	{		
	 	checkStringLengthRange(code,2, 20,CODE_OF_SKILL_TYPE ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_SKILL_TYPE ="skill_type.company";
	public YoubenbenChecker checkCompanyIdOfSkillType(String companyId)
	{		
	 	checkIdOfSkillType(companyId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_SKILL_TYPE ="skill_type.description";
	public YoubenbenChecker checkDescriptionOfSkillType(String description)
	{		
	 	checkStringLengthRange(description,1, 24,DESCRIPTION_OF_SKILL_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SKILL_TYPE ="skill_type.version";
	public YoubenbenChecker checkVersionOfSkillType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SKILL_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_RESPONSIBILITY_TYPE ="responsibility_type.id";
	public YoubenbenChecker checkIdOfResponsibilityType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RESPONSIBILITY_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_RESPONSIBILITY_TYPE ="responsibility_type.code";
	public YoubenbenChecker checkCodeOfResponsibilityType(String code)
	{		
	 	checkStringLengthRange(code,2, 20,CODE_OF_RESPONSIBILITY_TYPE ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_RESPONSIBILITY_TYPE ="responsibility_type.company";
	public YoubenbenChecker checkCompanyIdOfResponsibilityType(String companyId)
	{		
	 	checkIdOfResponsibilityType(companyId ); 		
		
		return this;
	}	

	public static final String  BASE_DESCRIPTION_OF_RESPONSIBILITY_TYPE ="responsibility_type.base_description";
	public YoubenbenChecker checkBaseDescriptionOfResponsibilityType(String baseDescription)
	{		
	 	checkStringLengthRange(baseDescription,2, 16,BASE_DESCRIPTION_OF_RESPONSIBILITY_TYPE ); 		
		
		return this;
	}	

	public static final String  DETAIL_DESCRIPTION_OF_RESPONSIBILITY_TYPE ="responsibility_type.detail_description";
	public YoubenbenChecker checkDetailDescriptionOfResponsibilityType(String detailDescription)
	{		
	 	checkStringLengthRange(detailDescription,8, 116,DETAIL_DESCRIPTION_OF_RESPONSIBILITY_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_RESPONSIBILITY_TYPE ="responsibility_type.version";
	public YoubenbenChecker checkVersionOfResponsibilityType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RESPONSIBILITY_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_TERMINATION_REASON ="termination_reason.id";
	public YoubenbenChecker checkIdOfTerminationReason(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TERMINATION_REASON ); 		
		
		return this;
	}	

	public static final String  CODE_OF_TERMINATION_REASON ="termination_reason.code";
	public YoubenbenChecker checkCodeOfTerminationReason(String code)
	{		
	 	checkStringLengthRange(code,2, 28,CODE_OF_TERMINATION_REASON ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_TERMINATION_REASON ="termination_reason.company";
	public YoubenbenChecker checkCompanyIdOfTerminationReason(String companyId)
	{		
	 	checkIdOfTerminationReason(companyId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_TERMINATION_REASON ="termination_reason.description";
	public YoubenbenChecker checkDescriptionOfTerminationReason(String description)
	{		
	 	checkStringLengthRange(description,2, 36,DESCRIPTION_OF_TERMINATION_REASON ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TERMINATION_REASON ="termination_reason.version";
	public YoubenbenChecker checkVersionOfTerminationReason(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TERMINATION_REASON ); 		
		
		return this;
	}	

	public static final String  ID_OF_TERMINATION_TYPE ="termination_type.id";
	public YoubenbenChecker checkIdOfTerminationType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TERMINATION_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_TERMINATION_TYPE ="termination_type.code";
	public YoubenbenChecker checkCodeOfTerminationType(String code)
	{		
	 	checkStringLengthRange(code,2, 28,CODE_OF_TERMINATION_TYPE ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_TERMINATION_TYPE ="termination_type.company";
	public YoubenbenChecker checkCompanyIdOfTerminationType(String companyId)
	{		
	 	checkIdOfTerminationType(companyId ); 		
		
		return this;
	}	

	public static final String  BASE_DESCRIPTION_OF_TERMINATION_TYPE ="termination_type.base_description";
	public YoubenbenChecker checkBaseDescriptionOfTerminationType(String baseDescription)
	{		
	 	checkStringLengthRange(baseDescription,1, 16,BASE_DESCRIPTION_OF_TERMINATION_TYPE ); 		
		
		return this;
	}	

	public static final String  DETAIL_DESCRIPTION_OF_TERMINATION_TYPE ="termination_type.detail_description";
	public YoubenbenChecker checkDetailDescriptionOfTerminationType(String detailDescription)
	{		
	 	checkStringLengthRange(detailDescription,16, 248,DETAIL_DESCRIPTION_OF_TERMINATION_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TERMINATION_TYPE ="termination_type.version";
	public YoubenbenChecker checkVersionOfTerminationType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TERMINATION_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_OCCUPATION_TYPE ="occupation_type.id";
	public YoubenbenChecker checkIdOfOccupationType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_OCCUPATION_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_OCCUPATION_TYPE ="occupation_type.code";
	public YoubenbenChecker checkCodeOfOccupationType(String code)
	{		
	 	checkStringLengthRange(code,2, 24,CODE_OF_OCCUPATION_TYPE ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_OCCUPATION_TYPE ="occupation_type.company";
	public YoubenbenChecker checkCompanyIdOfOccupationType(String companyId)
	{		
	 	checkIdOfOccupationType(companyId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_OCCUPATION_TYPE ="occupation_type.description";
	public YoubenbenChecker checkDescriptionOfOccupationType(String description)
	{		
	 	checkStringLengthRange(description,1, 28,DESCRIPTION_OF_OCCUPATION_TYPE ); 		
		
		return this;
	}	

	public static final String  DETAIL_DESCRIPTION_OF_OCCUPATION_TYPE ="occupation_type.detail_description";
	public YoubenbenChecker checkDetailDescriptionOfOccupationType(String detailDescription)
	{		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_OCCUPATION_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_OCCUPATION_TYPE ="occupation_type.version";
	public YoubenbenChecker checkVersionOfOccupationType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OCCUPATION_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEAVE_TYPE ="leave_type.id";
	public YoubenbenChecker checkIdOfLeaveType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEAVE_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_LEAVE_TYPE ="leave_type.code";
	public YoubenbenChecker checkCodeOfLeaveType(String code)
	{		
	 	checkStringLengthRange(code,2, 24,CODE_OF_LEAVE_TYPE ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_LEAVE_TYPE ="leave_type.company";
	public YoubenbenChecker checkCompanyIdOfLeaveType(String companyId)
	{		
	 	checkIdOfLeaveType(companyId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_LEAVE_TYPE ="leave_type.description";
	public YoubenbenChecker checkDescriptionOfLeaveType(String description)
	{		
	 	checkStringLengthRange(description,1, 16,DESCRIPTION_OF_LEAVE_TYPE ); 		
		
		return this;
	}	

	public static final String  DETAIL_DESCRIPTION_OF_LEAVE_TYPE ="leave_type.detail_description";
	public YoubenbenChecker checkDetailDescriptionOfLeaveType(String detailDescription)
	{		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_LEAVE_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEAVE_TYPE ="leave_type.version";
	public YoubenbenChecker checkVersionOfLeaveType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEAVE_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_SALARY_GRADE ="salary_grade.id";
	public YoubenbenChecker checkIdOfSalaryGrade(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SALARY_GRADE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_SALARY_GRADE ="salary_grade.code";
	public YoubenbenChecker checkCodeOfSalaryGrade(String code)
	{		
	 	checkStringLengthRange(code,2, 24,CODE_OF_SALARY_GRADE ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_SALARY_GRADE ="salary_grade.company";
	public YoubenbenChecker checkCompanyIdOfSalaryGrade(String companyId)
	{		
	 	checkIdOfSalaryGrade(companyId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_SALARY_GRADE ="salary_grade.name";
	public YoubenbenChecker checkNameOfSalaryGrade(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_SALARY_GRADE ); 		
		
		return this;
	}	

	public static final String  DETAIL_DESCRIPTION_OF_SALARY_GRADE ="salary_grade.detail_description";
	public YoubenbenChecker checkDetailDescriptionOfSalaryGrade(String detailDescription)
	{		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_SALARY_GRADE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SALARY_GRADE ="salary_grade.version";
	public YoubenbenChecker checkVersionOfSalaryGrade(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SALARY_GRADE ); 		
		
		return this;
	}	

	public static final String  ID_OF_INTERVIEW_TYPE ="interview_type.id";
	public YoubenbenChecker checkIdOfInterviewType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_INTERVIEW_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_INTERVIEW_TYPE ="interview_type.code";
	public YoubenbenChecker checkCodeOfInterviewType(String code)
	{		
	 	checkStringLengthRange(code,3, 32,CODE_OF_INTERVIEW_TYPE ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_INTERVIEW_TYPE ="interview_type.company";
	public YoubenbenChecker checkCompanyIdOfInterviewType(String companyId)
	{		
	 	checkIdOfInterviewType(companyId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_INTERVIEW_TYPE ="interview_type.description";
	public YoubenbenChecker checkDescriptionOfInterviewType(String description)
	{		
	 	checkStringLengthRange(description,2, 24,DESCRIPTION_OF_INTERVIEW_TYPE ); 		
		
		return this;
	}	

	public static final String  DETAIL_DESCRIPTION_OF_INTERVIEW_TYPE ="interview_type.detail_description";
	public YoubenbenChecker checkDetailDescriptionOfInterviewType(String detailDescription)
	{		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_INTERVIEW_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_INTERVIEW_TYPE ="interview_type.version";
	public YoubenbenChecker checkVersionOfInterviewType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_INTERVIEW_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_TRAINING_COURSE_TYPE ="training_course_type.id";
	public YoubenbenChecker checkIdOfTrainingCourseType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TRAINING_COURSE_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_TRAINING_COURSE_TYPE ="training_course_type.code";
	public YoubenbenChecker checkCodeOfTrainingCourseType(String code)
	{		
	 	checkStringLengthRange(code,2, 16,CODE_OF_TRAINING_COURSE_TYPE ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_TRAINING_COURSE_TYPE ="training_course_type.company";
	public YoubenbenChecker checkCompanyIdOfTrainingCourseType(String companyId)
	{		
	 	checkIdOfTrainingCourseType(companyId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_TRAINING_COURSE_TYPE ="training_course_type.name";
	public YoubenbenChecker checkNameOfTrainingCourseType(String name)
	{		
	 	checkStringLengthRange(name,1, 16,NAME_OF_TRAINING_COURSE_TYPE ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_TRAINING_COURSE_TYPE ="training_course_type.description";
	public YoubenbenChecker checkDescriptionOfTrainingCourseType(String description)
	{		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_TRAINING_COURSE_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TRAINING_COURSE_TYPE ="training_course_type.version";
	public YoubenbenChecker checkVersionOfTrainingCourseType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRAINING_COURSE_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_PUBLIC_HOLIDAY ="public_holiday.id";
	public YoubenbenChecker checkIdOfPublicHoliday(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PUBLIC_HOLIDAY ); 		
		
		return this;
	}	

	public static final String  CODE_OF_PUBLIC_HOLIDAY ="public_holiday.code";
	public YoubenbenChecker checkCodeOfPublicHoliday(String code)
	{		
	 	checkStringLengthRange(code,2, 16,CODE_OF_PUBLIC_HOLIDAY ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_PUBLIC_HOLIDAY ="public_holiday.company";
	public YoubenbenChecker checkCompanyIdOfPublicHoliday(String companyId)
	{		
	 	checkIdOfPublicHoliday(companyId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PUBLIC_HOLIDAY ="public_holiday.name";
	public YoubenbenChecker checkNameOfPublicHoliday(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PUBLIC_HOLIDAY ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_PUBLIC_HOLIDAY ="public_holiday.description";
	public YoubenbenChecker checkDescriptionOfPublicHoliday(String description)
	{		
	 	checkStringLengthRange(description,3, 40,DESCRIPTION_OF_PUBLIC_HOLIDAY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PUBLIC_HOLIDAY ="public_holiday.version";
	public YoubenbenChecker checkVersionOfPublicHoliday(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PUBLIC_HOLIDAY ); 		
		
		return this;
	}	

	public static final String  ID_OF_TERMINATION ="termination.id";
	public YoubenbenChecker checkIdOfTermination(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TERMINATION ); 		
		
		return this;
	}	

	public static final String  REASON_OF_TERMINATION ="termination.reason";
	public YoubenbenChecker checkReasonIdOfTermination(String reasonId)
	{		
	 	checkIdOfTermination(reasonId ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_TERMINATION ="termination.type";
	public YoubenbenChecker checkTypeIdOfTermination(String typeId)
	{		
	 	checkIdOfTermination(typeId ); 		
		
		return this;
	}	

	public static final String  COMMENT_OF_TERMINATION ="termination.comment";
	public YoubenbenChecker checkCommentOfTermination(String comment)
	{		
	 	checkStringLengthRange(comment,2, 16,COMMENT_OF_TERMINATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TERMINATION ="termination.version";
	public YoubenbenChecker checkVersionOfTermination(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TERMINATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_VIEW ="view.id";
	public YoubenbenChecker checkIdOfView(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_VIEW ); 		
		
		return this;
	}	

	public static final String  WHO_OF_VIEW ="view.who";
	public YoubenbenChecker checkWhoOfView(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_VIEW ); 		
		
		return this;
	}	

	public static final String  ASSESSMENT_OF_VIEW ="view.assessment";
	public YoubenbenChecker checkAssessmentOfView(String assessment)
	{		
	 	checkStringLengthRange(assessment,3, 40,ASSESSMENT_OF_VIEW ); 		
		
		return this;
	}	

	public static final String  INTERVIEW_TIME_OF_VIEW ="view.interview_time";
	public YoubenbenChecker checkInterviewTimeOfView(Date interviewTime)
	{		
	 	checkDateRange(interviewTime,parseDate("1900-01-01"), parseDate("2017-03-03"),INTERVIEW_TIME_OF_VIEW ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_VIEW ="view.version";
	public YoubenbenChecker checkVersionOfView(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_VIEW ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE ="employee.id";
	public YoubenbenChecker checkIdOfEmployee(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_EMPLOYEE ="employee.company";
	public YoubenbenChecker checkCompanyIdOfEmployee(String companyId)
	{		
	 	checkIdOfEmployee(companyId ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_EMPLOYEE ="employee.title";
	public YoubenbenChecker checkTitleOfEmployee(String title)
	{		
	 	checkStringLengthRange(title,1, 12,TITLE_OF_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  DEPARTMENT_OF_EMPLOYEE ="employee.department";
	public YoubenbenChecker checkDepartmentIdOfEmployee(String departmentId)
	{		
	 	checkIdOfEmployee(departmentId ); 		
		
		return this;
	}	

	public static final String  FAMILY_NAME_OF_EMPLOYEE ="employee.family_name";
	public YoubenbenChecker checkFamilyNameOfEmployee(String familyName)
	{		
	 	checkStringLengthRange(familyName,0, 4,FAMILY_NAME_OF_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  GIVEN_NAME_OF_EMPLOYEE ="employee.given_name";
	public YoubenbenChecker checkGivenNameOfEmployee(String givenName)
	{		
	 	checkStringLengthRange(givenName,1, 8,GIVEN_NAME_OF_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  EMAIL_OF_EMPLOYEE ="employee.email";
	public YoubenbenChecker checkEmailOfEmployee(String email)
	{		
	 	checkEmail(email,6, 52,EMAIL_OF_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  CITY_OF_EMPLOYEE ="employee.city";
	public YoubenbenChecker checkCityOfEmployee(String city)
	{		
	 	checkStringLengthRange(city,1, 8,CITY_OF_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  ADDRESS_OF_EMPLOYEE ="employee.address";
	public YoubenbenChecker checkAddressOfEmployee(String address)
	{		
	 	checkStringLengthRange(address,2, 16,ADDRESS_OF_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  CELL_PHONE_OF_EMPLOYEE ="employee.cell_phone";
	public YoubenbenChecker checkCellPhoneOfEmployee(String cellPhone)
	{		
	 	checkChinaMobilePhone(cellPhone,5, 44,CELL_PHONE_OF_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  OCCUPATION_OF_EMPLOYEE ="employee.occupation";
	public YoubenbenChecker checkOccupationIdOfEmployee(String occupationId)
	{		
	 	checkIdOfEmployee(occupationId ); 		
		
		return this;
	}	

	public static final String  RESPONSIBLE_FOR_OF_EMPLOYEE ="employee.responsible_for";
	public YoubenbenChecker checkResponsibleForIdOfEmployee(String responsibleForId)
	{		
	 	checkIdOfEmployee(responsibleForId ); 		
		
		return this;
	}	

	public static final String  CURRENT_SALARY_GRADE_OF_EMPLOYEE ="employee.current_salary_grade";
	public YoubenbenChecker checkCurrentSalaryGradeIdOfEmployee(String currentSalaryGradeId)
	{		
	 	checkIdOfEmployee(currentSalaryGradeId ); 		
		
		return this;
	}	

	public static final String  SALARY_ACCOUNT_OF_EMPLOYEE ="employee.salary_account";
	public YoubenbenChecker checkSalaryAccountOfEmployee(String salaryAccount)
	{		
	 	checkStringLengthRange(salaryAccount,4, 60,SALARY_ACCOUNT_OF_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  JOB_APPLICATION_OF_EMPLOYEE ="employee.job_application";
	public YoubenbenChecker checkJobApplicationIdOfEmployee(String jobApplicationId)
	{		
	 	checkIdOfEmployee(jobApplicationId ); 		
		
		return this;
	}	

	public static final String  PROFESSION_INTERVIEW_OF_EMPLOYEE ="employee.profession_interview";
	public YoubenbenChecker checkProfessionInterviewIdOfEmployee(String professionInterviewId)
	{		
	 	checkIdOfEmployee(professionInterviewId ); 		
		
		return this;
	}	

	public static final String  HR_INTERVIEW_OF_EMPLOYEE ="employee.hr_interview";
	public YoubenbenChecker checkHrInterviewIdOfEmployee(String hrInterviewId)
	{		
	 	checkIdOfEmployee(hrInterviewId ); 		
		
		return this;
	}	

	public static final String  OFFER_APPROVAL_OF_EMPLOYEE ="employee.offer_approval";
	public YoubenbenChecker checkOfferApprovalIdOfEmployee(String offerApprovalId)
	{		
	 	checkIdOfEmployee(offerApprovalId ); 		
		
		return this;
	}	

	public static final String  OFFER_ACCEPTANCE_OF_EMPLOYEE ="employee.offer_acceptance";
	public YoubenbenChecker checkOfferAcceptanceIdOfEmployee(String offerAcceptanceId)
	{		
	 	checkIdOfEmployee(offerAcceptanceId ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_BOARDING_OF_EMPLOYEE ="employee.employee_boarding";
	public YoubenbenChecker checkEmployeeBoardingIdOfEmployee(String employeeBoardingId)
	{		
	 	checkIdOfEmployee(employeeBoardingId ); 		
		
		return this;
	}	

	public static final String  TERMINATION_OF_EMPLOYEE ="employee.termination";
	public YoubenbenChecker checkTerminationIdOfEmployee(String terminationId)
	{		
	 	checkIdOfEmployee(terminationId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE ="employee.version";
	public YoubenbenChecker checkVersionOfEmployee(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  ID_OF_JOB_APPLICATION ="job_application.id";
	public YoubenbenChecker checkIdOfJobApplication(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_JOB_APPLICATION ); 		
		
		return this;
	}	

	public static final String  APPLICATION_TIME_OF_JOB_APPLICATION ="job_application.application_time";
	public YoubenbenChecker checkApplicationTimeOfJobApplication(Date applicationTime)
	{		
	 	checkDateRange(applicationTime,parseDate("1900-01-01"), parseDate("2018-03-04"),APPLICATION_TIME_OF_JOB_APPLICATION ); 		
		
		return this;
	}	

	public static final String  WHO_OF_JOB_APPLICATION ="job_application.who";
	public YoubenbenChecker checkWhoOfJobApplication(String who)
	{		
	 	checkStringLengthRange(who,2, 20,WHO_OF_JOB_APPLICATION ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_JOB_APPLICATION ="job_application.comments";
	public YoubenbenChecker checkCommentsOfJobApplication(String comments)
	{		
	 	checkStringLengthRange(comments,8, 124,COMMENTS_OF_JOB_APPLICATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_JOB_APPLICATION ="job_application.version";
	public YoubenbenChecker checkVersionOfJobApplication(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_JOB_APPLICATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_PROFESSION_INTERVIEW ="profession_interview.id";
	public YoubenbenChecker checkIdOfProfessionInterview(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PROFESSION_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  WHO_OF_PROFESSION_INTERVIEW ="profession_interview.who";
	public YoubenbenChecker checkWhoOfProfessionInterview(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_PROFESSION_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  INTERVIEW_TIME_OF_PROFESSION_INTERVIEW ="profession_interview.interview_time";
	public YoubenbenChecker checkInterviewTimeOfProfessionInterview(Date interviewTime)
	{		
	 	checkDateRange(interviewTime,parseDate("1900-01-01"), parseDate("2018-03-04"),INTERVIEW_TIME_OF_PROFESSION_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_PROFESSION_INTERVIEW ="profession_interview.comments";
	public YoubenbenChecker checkCommentsOfProfessionInterview(String comments)
	{		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_PROFESSION_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PROFESSION_INTERVIEW ="profession_interview.version";
	public YoubenbenChecker checkVersionOfProfessionInterview(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROFESSION_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  ID_OF_HR_INTERVIEW ="hr_interview.id";
	public YoubenbenChecker checkIdOfHrInterview(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_HR_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  WHO_OF_HR_INTERVIEW ="hr_interview.who";
	public YoubenbenChecker checkWhoOfHrInterview(String who)
	{		
	 	checkStringLengthRange(who,2, 20,WHO_OF_HR_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  INTERVIEW_TIME_OF_HR_INTERVIEW ="hr_interview.interview_time";
	public YoubenbenChecker checkInterviewTimeOfHrInterview(Date interviewTime)
	{		
	 	checkDateRange(interviewTime,parseDate("1900-01-01"), parseDate("2018-03-04"),INTERVIEW_TIME_OF_HR_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_HR_INTERVIEW ="hr_interview.comments";
	public YoubenbenChecker checkCommentsOfHrInterview(String comments)
	{		
	 	checkStringLengthRange(comments,4, 52,COMMENTS_OF_HR_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_HR_INTERVIEW ="hr_interview.version";
	public YoubenbenChecker checkVersionOfHrInterview(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_HR_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  ID_OF_OFFER_APPROVAL ="offer_approval.id";
	public YoubenbenChecker checkIdOfOfferApproval(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_OFFER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  WHO_OF_OFFER_APPROVAL ="offer_approval.who";
	public YoubenbenChecker checkWhoOfOfferApproval(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_OFFER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  APPROVE_TIME_OF_OFFER_APPROVAL ="offer_approval.approve_time";
	public YoubenbenChecker checkApproveTimeOfOfferApproval(Date approveTime)
	{		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-03-04"),APPROVE_TIME_OF_OFFER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_OFFER_APPROVAL ="offer_approval.comments";
	public YoubenbenChecker checkCommentsOfOfferApproval(String comments)
	{		
	 	checkStringLengthRange(comments,3, 40,COMMENTS_OF_OFFER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_OFFER_APPROVAL ="offer_approval.version";
	public YoubenbenChecker checkVersionOfOfferApproval(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OFFER_APPROVAL ); 		
		
		return this;
	}	

	public static final String  ID_OF_OFFER_ACCEPTANCE ="offer_acceptance.id";
	public YoubenbenChecker checkIdOfOfferAcceptance(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_OFFER_ACCEPTANCE ); 		
		
		return this;
	}	

	public static final String  WHO_OF_OFFER_ACCEPTANCE ="offer_acceptance.who";
	public YoubenbenChecker checkWhoOfOfferAcceptance(String who)
	{		
	 	checkStringLengthRange(who,1, 12,WHO_OF_OFFER_ACCEPTANCE ); 		
		
		return this;
	}	

	public static final String  ACCEPT_TIME_OF_OFFER_ACCEPTANCE ="offer_acceptance.accept_time";
	public YoubenbenChecker checkAcceptTimeOfOfferAcceptance(Date acceptTime)
	{		
	 	checkDateRange(acceptTime,parseDate("1900-01-01"), parseDate("2018-03-04"),ACCEPT_TIME_OF_OFFER_ACCEPTANCE ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_OFFER_ACCEPTANCE ="offer_acceptance.comments";
	public YoubenbenChecker checkCommentsOfOfferAcceptance(String comments)
	{		
	 	checkStringLengthRange(comments,3, 40,COMMENTS_OF_OFFER_ACCEPTANCE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_OFFER_ACCEPTANCE ="offer_acceptance.version";
	public YoubenbenChecker checkVersionOfOfferAcceptance(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OFFER_ACCEPTANCE ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_BOARDING ="employee_boarding.id";
	public YoubenbenChecker checkIdOfEmployeeBoarding(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_BOARDING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_EMPLOYEE_BOARDING ="employee_boarding.who";
	public YoubenbenChecker checkWhoOfEmployeeBoarding(String who)
	{		
	 	checkStringLengthRange(who,2, 20,WHO_OF_EMPLOYEE_BOARDING ); 		
		
		return this;
	}	

	public static final String  EMPLOY_TIME_OF_EMPLOYEE_BOARDING ="employee_boarding.employ_time";
	public YoubenbenChecker checkEmployTimeOfEmployeeBoarding(Date employTime)
	{		
	 	checkDateRange(employTime,parseDate("1900-01-01"), parseDate("2018-03-04"),EMPLOY_TIME_OF_EMPLOYEE_BOARDING ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_EMPLOYEE_BOARDING ="employee_boarding.comments";
	public YoubenbenChecker checkCommentsOfEmployeeBoarding(String comments)
	{		
	 	checkStringLengthRange(comments,3, 44,COMMENTS_OF_EMPLOYEE_BOARDING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_BOARDING ="employee_boarding.version";
	public YoubenbenChecker checkVersionOfEmployeeBoarding(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_BOARDING ); 		
		
		return this;
	}	

	public static final String  ID_OF_INSTRUCTOR ="instructor.id";
	public YoubenbenChecker checkIdOfInstructor(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_INSTRUCTOR ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_INSTRUCTOR ="instructor.title";
	public YoubenbenChecker checkTitleOfInstructor(String title)
	{		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_INSTRUCTOR ); 		
		
		return this;
	}	

	public static final String  FAMILY_NAME_OF_INSTRUCTOR ="instructor.family_name";
	public YoubenbenChecker checkFamilyNameOfInstructor(String familyName)
	{		
	 	checkStringLengthRange(familyName,0, 4,FAMILY_NAME_OF_INSTRUCTOR ); 		
		
		return this;
	}	

	public static final String  GIVEN_NAME_OF_INSTRUCTOR ="instructor.given_name";
	public YoubenbenChecker checkGivenNameOfInstructor(String givenName)
	{		
	 	checkStringLengthRange(givenName,1, 8,GIVEN_NAME_OF_INSTRUCTOR ); 		
		
		return this;
	}	

	public static final String  CELL_PHONE_OF_INSTRUCTOR ="instructor.cell_phone";
	public YoubenbenChecker checkCellPhoneOfInstructor(String cellPhone)
	{		
	 	checkChinaMobilePhone(cellPhone,5, 44,CELL_PHONE_OF_INSTRUCTOR ); 		
		
		return this;
	}	

	public static final String  EMAIL_OF_INSTRUCTOR ="instructor.email";
	public YoubenbenChecker checkEmailOfInstructor(String email)
	{		
	 	checkEmail(email,10, 80,EMAIL_OF_INSTRUCTOR ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_INSTRUCTOR ="instructor.company";
	public YoubenbenChecker checkCompanyIdOfInstructor(String companyId)
	{		
	 	checkIdOfInstructor(companyId ); 		
		
		return this;
	}	

	public static final String  INTRODUCTION_OF_INSTRUCTOR ="instructor.introduction";
	public YoubenbenChecker checkIntroductionOfInstructor(String introduction)
	{		
	 	checkStringLengthRange(introduction,4, 60,INTRODUCTION_OF_INSTRUCTOR ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_INSTRUCTOR ="instructor.version";
	public YoubenbenChecker checkVersionOfInstructor(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_INSTRUCTOR ); 		
		
		return this;
	}	

	public static final String  ID_OF_COMPANY_TRAINING ="company_training.id";
	public YoubenbenChecker checkIdOfCompanyTraining(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_COMPANY_TRAINING ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_COMPANY_TRAINING ="company_training.title";
	public YoubenbenChecker checkTitleOfCompanyTraining(String title)
	{		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_COMPANY_TRAINING ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_COMPANY_TRAINING ="company_training.company";
	public YoubenbenChecker checkCompanyIdOfCompanyTraining(String companyId)
	{		
	 	checkIdOfCompanyTraining(companyId ); 		
		
		return this;
	}	

	public static final String  INSTRUCTOR_OF_COMPANY_TRAINING ="company_training.instructor";
	public YoubenbenChecker checkInstructorIdOfCompanyTraining(String instructorId)
	{		
	 	checkIdOfCompanyTraining(instructorId ); 		
		
		return this;
	}	

	public static final String  TRAINING_COURSE_TYPE_OF_COMPANY_TRAINING ="company_training.training_course_type";
	public YoubenbenChecker checkTrainingCourseTypeIdOfCompanyTraining(String trainingCourseTypeId)
	{		
	 	checkIdOfCompanyTraining(trainingCourseTypeId ); 		
		
		return this;
	}	

	public static final String  TIME_START_OF_COMPANY_TRAINING ="company_training.time_start";
	public YoubenbenChecker checkTimeStartOfCompanyTraining(Date timeStart)
	{		
	 	checkDatePast(timeStart,parseDate("1900-01-01"), new Date(),TIME_START_OF_COMPANY_TRAINING ); 		
		
		return this;
	}	

	public static final String  DURATION_HOURS_OF_COMPANY_TRAINING ="company_training.duration_hours";
	public YoubenbenChecker checkDurationHoursOfCompanyTraining(int durationHours)
	{		
	 	checkIntegerRange(durationHours,0, 3,DURATION_HOURS_OF_COMPANY_TRAINING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_COMPANY_TRAINING ="company_training.version";
	public YoubenbenChecker checkVersionOfCompanyTraining(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_COMPANY_TRAINING ); 		
		
		return this;
	}	

	public static final String  ID_OF_SCORING ="scoring.id";
	public YoubenbenChecker checkIdOfScoring(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SCORING ); 		
		
		return this;
	}	

	public static final String  SCORED_BY_OF_SCORING ="scoring.scored_by";
	public YoubenbenChecker checkScoredByOfScoring(String scoredBy)
	{		
	 	checkStringLengthRange(scoredBy,1, 12,SCORED_BY_OF_SCORING ); 		
		
		return this;
	}	

	public static final String  SCORE_OF_SCORING ="scoring.score";
	public YoubenbenChecker checkScoreOfScoring(int score)
	{		
	 	checkIntegerRange(score,0, 100,SCORE_OF_SCORING ); 		
		
		return this;
	}	

	public static final String  COMMENT_OF_SCORING ="scoring.comment";
	public YoubenbenChecker checkCommentOfScoring(String comment)
	{		
	 	checkStringLengthRange(comment,3, 36,COMMENT_OF_SCORING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SCORING ="scoring.version";
	public YoubenbenChecker checkVersionOfScoring(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SCORING ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.id";
	public YoubenbenChecker checkIdOfEmployeeCompanyTraining(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_COMPANY_TRAINING ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.employee";
	public YoubenbenChecker checkEmployeeIdOfEmployeeCompanyTraining(String employeeId)
	{		
	 	checkIdOfEmployeeCompanyTraining(employeeId ); 		
		
		return this;
	}	

	public static final String  TRAINING_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.training";
	public YoubenbenChecker checkTrainingIdOfEmployeeCompanyTraining(String trainingId)
	{		
	 	checkIdOfEmployeeCompanyTraining(trainingId ); 		
		
		return this;
	}	

	public static final String  SCORING_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.scoring";
	public YoubenbenChecker checkScoringIdOfEmployeeCompanyTraining(String scoringId)
	{		
	 	checkIdOfEmployeeCompanyTraining(scoringId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.version";
	public YoubenbenChecker checkVersionOfEmployeeCompanyTraining(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_COMPANY_TRAINING ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_SKILL ="employee_skill.id";
	public YoubenbenChecker checkIdOfEmployeeSkill(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_SKILL ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_OF_EMPLOYEE_SKILL ="employee_skill.employee";
	public YoubenbenChecker checkEmployeeIdOfEmployeeSkill(String employeeId)
	{		
	 	checkIdOfEmployeeSkill(employeeId ); 		
		
		return this;
	}	

	public static final String  SKILL_TYPE_OF_EMPLOYEE_SKILL ="employee_skill.skill_type";
	public YoubenbenChecker checkSkillTypeIdOfEmployeeSkill(String skillTypeId)
	{		
	 	checkIdOfEmployeeSkill(skillTypeId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_EMPLOYEE_SKILL ="employee_skill.description";
	public YoubenbenChecker checkDescriptionOfEmployeeSkill(String description)
	{		
	 	checkStringLengthRange(description,2, 28,DESCRIPTION_OF_EMPLOYEE_SKILL ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_SKILL ="employee_skill.version";
	public YoubenbenChecker checkVersionOfEmployeeSkill(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_SKILL ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_PERFORMANCE ="employee_performance.id";
	public YoubenbenChecker checkIdOfEmployeePerformance(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_PERFORMANCE ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_OF_EMPLOYEE_PERFORMANCE ="employee_performance.employee";
	public YoubenbenChecker checkEmployeeIdOfEmployeePerformance(String employeeId)
	{		
	 	checkIdOfEmployeePerformance(employeeId ); 		
		
		return this;
	}	

	public static final String  PERFORMANCE_COMMENT_OF_EMPLOYEE_PERFORMANCE ="employee_performance.performance_comment";
	public YoubenbenChecker checkPerformanceCommentOfEmployeePerformance(String performanceComment)
	{		
	 	checkStringLengthRange(performanceComment,2, 28,PERFORMANCE_COMMENT_OF_EMPLOYEE_PERFORMANCE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_PERFORMANCE ="employee_performance.version";
	public YoubenbenChecker checkVersionOfEmployeePerformance(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_PERFORMANCE ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.id";
	public YoubenbenChecker checkIdOfEmployeeWorkExperience(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.employee";
	public YoubenbenChecker checkEmployeeIdOfEmployeeWorkExperience(String employeeId)
	{		
	 	checkIdOfEmployeeWorkExperience(employeeId ); 		
		
		return this;
	}	

	public static final String  START_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.start";
	public YoubenbenChecker checkStartOfEmployeeWorkExperience(Date start)
	{		
	 	checkDateRange(start,parseDate("1900-01-01"), parseDate("2008-01-10"),START_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	

	public static final String  END_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.end";
	public YoubenbenChecker checkEndOfEmployeeWorkExperience(Date end)
	{		
	 	checkDateRange(end,parseDate("1900-01-01"), parseDate("2018-01-10"),END_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	

	public static final String  COMPANY_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.company";
	public YoubenbenChecker checkCompanyOfEmployeeWorkExperience(String company)
	{		
	 	checkStringLengthRange(company,3, 32,COMPANY_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.description";
	public YoubenbenChecker checkDescriptionOfEmployeeWorkExperience(String description)
	{		
	 	checkStringLengthRange(description,6, 84,DESCRIPTION_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.version";
	public YoubenbenChecker checkVersionOfEmployeeWorkExperience(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_LEAVE ="employee_leave.id";
	public YoubenbenChecker checkIdOfEmployeeLeave(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_LEAVE ); 		
		
		return this;
	}	

	public static final String  WHO_OF_EMPLOYEE_LEAVE ="employee_leave.who";
	public YoubenbenChecker checkWhoIdOfEmployeeLeave(String whoId)
	{		
	 	checkIdOfEmployeeLeave(whoId ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_EMPLOYEE_LEAVE ="employee_leave.type";
	public YoubenbenChecker checkTypeIdOfEmployeeLeave(String typeId)
	{		
	 	checkIdOfEmployeeLeave(typeId ); 		
		
		return this;
	}	

	public static final String  LEAVE_DURATION_HOUR_OF_EMPLOYEE_LEAVE ="employee_leave.leave_duration_hour";
	public YoubenbenChecker checkLeaveDurationHourOfEmployeeLeave(int leaveDurationHour)
	{		
	 	checkIntegerRange(leaveDurationHour,0, 8,LEAVE_DURATION_HOUR_OF_EMPLOYEE_LEAVE ); 		
		
		return this;
	}	

	public static final String  REMARK_OF_EMPLOYEE_LEAVE ="employee_leave.remark";
	public YoubenbenChecker checkRemarkOfEmployeeLeave(String remark)
	{		
	 	checkStringLengthRange(remark,3, 44,REMARK_OF_EMPLOYEE_LEAVE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_LEAVE ="employee_leave.version";
	public YoubenbenChecker checkVersionOfEmployeeLeave(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_LEAVE ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_INTERVIEW ="employee_interview.id";
	public YoubenbenChecker checkIdOfEmployeeInterview(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_OF_EMPLOYEE_INTERVIEW ="employee_interview.employee";
	public YoubenbenChecker checkEmployeeIdOfEmployeeInterview(String employeeId)
	{		
	 	checkIdOfEmployeeInterview(employeeId ); 		
		
		return this;
	}	

	public static final String  INTERVIEW_TYPE_OF_EMPLOYEE_INTERVIEW ="employee_interview.interview_type";
	public YoubenbenChecker checkInterviewTypeIdOfEmployeeInterview(String interviewTypeId)
	{		
	 	checkIdOfEmployeeInterview(interviewTypeId ); 		
		
		return this;
	}	

	public static final String  REMARK_OF_EMPLOYEE_INTERVIEW ="employee_interview.remark";
	public YoubenbenChecker checkRemarkOfEmployeeInterview(String remark)
	{		
	 	checkStringLengthRange(remark,3, 40,REMARK_OF_EMPLOYEE_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_INTERVIEW ="employee_interview.version";
	public YoubenbenChecker checkVersionOfEmployeeInterview(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_INTERVIEW ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.id";
	public YoubenbenChecker checkIdOfEmployeeAttendance(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.employee";
	public YoubenbenChecker checkEmployeeIdOfEmployeeAttendance(String employeeId)
	{		
	 	checkIdOfEmployeeAttendance(employeeId ); 		
		
		return this;
	}	

	public static final String  ENTER_TIME_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.enter_time";
	public YoubenbenChecker checkEnterTimeOfEmployeeAttendance(Date enterTime)
	{		
	 	checkDateRange(enterTime,parseDate("1900-01-01"), parseDate("2017-01-01"),ENTER_TIME_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  LEAVE_TIME_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.leave_time";
	public YoubenbenChecker checkLeaveTimeOfEmployeeAttendance(Date leaveTime)
	{		
	 	checkDateRange(leaveTime,parseDate("1900-01-01"), parseDate("2017-03-01"),LEAVE_TIME_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  DURATION_HOURS_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.duration_hours";
	public YoubenbenChecker checkDurationHoursOfEmployeeAttendance(int durationHours)
	{		
	 	checkIntegerRange(durationHours,0, 8,DURATION_HOURS_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  REMARK_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.remark";
	public YoubenbenChecker checkRemarkOfEmployeeAttendance(String remark)
	{		
	 	checkStringLengthRange(remark,2, 28,REMARK_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.version";
	public YoubenbenChecker checkVersionOfEmployeeAttendance(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.id";
	public YoubenbenChecker checkIdOfEmployeeQualifier(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.employee";
	public YoubenbenChecker checkEmployeeIdOfEmployeeQualifier(String employeeId)
	{		
	 	checkIdOfEmployeeQualifier(employeeId ); 		
		
		return this;
	}	

	public static final String  QUALIFIED_TIME_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.qualified_time";
	public YoubenbenChecker checkQualifiedTimeOfEmployeeQualifier(Date qualifiedTime)
	{		
	 	checkDateRange(qualifiedTime,parseDate("1900-01-01"), parseDate("2017-01-01"),QUALIFIED_TIME_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.type";
	public YoubenbenChecker checkTypeOfEmployeeQualifier(String type)
	{		
	 	checkStringLengthRange(type,1, 20,TYPE_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.level";
	public YoubenbenChecker checkLevelOfEmployeeQualifier(String level)
	{		
	 	checkStringLengthRange(level,1, 8,LEVEL_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	

	public static final String  REMARK_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.remark";
	public YoubenbenChecker checkRemarkOfEmployeeQualifier(String remark)
	{		
	 	checkStringLengthRange(remark,3, 36,REMARK_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.version";
	public YoubenbenChecker checkVersionOfEmployeeQualifier(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_EDUCATION ="employee_education.id";
	public YoubenbenChecker checkIdOfEmployeeEducation(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_EDUCATION ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_OF_EMPLOYEE_EDUCATION ="employee_education.employee";
	public YoubenbenChecker checkEmployeeIdOfEmployeeEducation(String employeeId)
	{		
	 	checkIdOfEmployeeEducation(employeeId ); 		
		
		return this;
	}	

	public static final String  COMPLETE_TIME_OF_EMPLOYEE_EDUCATION ="employee_education.complete_time";
	public YoubenbenChecker checkCompleteTimeOfEmployeeEducation(Date completeTime)
	{		
	 	checkDateRange(completeTime,parseDate("1900-01-01"), parseDate("2017-01-01"),COMPLETE_TIME_OF_EMPLOYEE_EDUCATION ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_EMPLOYEE_EDUCATION ="employee_education.type";
	public YoubenbenChecker checkTypeOfEmployeeEducation(String type)
	{		
	 	checkStringLengthRange(type,1, 16,TYPE_OF_EMPLOYEE_EDUCATION ); 		
		
		return this;
	}	

	public static final String  REMARK_OF_EMPLOYEE_EDUCATION ="employee_education.remark";
	public YoubenbenChecker checkRemarkOfEmployeeEducation(String remark)
	{		
	 	checkStringLengthRange(remark,3, 36,REMARK_OF_EMPLOYEE_EDUCATION ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_EDUCATION ="employee_education.version";
	public YoubenbenChecker checkVersionOfEmployeeEducation(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_EDUCATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_AWARD ="employee_award.id";
	public YoubenbenChecker checkIdOfEmployeeAward(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_AWARD ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_OF_EMPLOYEE_AWARD ="employee_award.employee";
	public YoubenbenChecker checkEmployeeIdOfEmployeeAward(String employeeId)
	{		
	 	checkIdOfEmployeeAward(employeeId ); 		
		
		return this;
	}	

	public static final String  COMPLETE_TIME_OF_EMPLOYEE_AWARD ="employee_award.complete_time";
	public YoubenbenChecker checkCompleteTimeOfEmployeeAward(Date completeTime)
	{		
	 	checkDateRange(completeTime,parseDate("1900-01-01"), parseDate("2017-01-01"),COMPLETE_TIME_OF_EMPLOYEE_AWARD ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_EMPLOYEE_AWARD ="employee_award.type";
	public YoubenbenChecker checkTypeOfEmployeeAward(String type)
	{		
	 	checkStringLengthRange(type,2, 20,TYPE_OF_EMPLOYEE_AWARD ); 		
		
		return this;
	}	

	public static final String  REMARK_OF_EMPLOYEE_AWARD ="employee_award.remark";
	public YoubenbenChecker checkRemarkOfEmployeeAward(String remark)
	{		
	 	checkStringLengthRange(remark,3, 36,REMARK_OF_EMPLOYEE_AWARD ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_AWARD ="employee_award.version";
	public YoubenbenChecker checkVersionOfEmployeeAward(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_AWARD ); 		
		
		return this;
	}	

	public static final String  ID_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.id";
	public YoubenbenChecker checkIdOfEmployeeSalarySheet(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	

	public static final String  EMPLOYEE_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.employee";
	public YoubenbenChecker checkEmployeeIdOfEmployeeSalarySheet(String employeeId)
	{		
	 	checkIdOfEmployeeSalarySheet(employeeId ); 		
		
		return this;
	}	

	public static final String  CURRENT_SALARY_GRADE_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.current_salary_grade";
	public YoubenbenChecker checkCurrentSalaryGradeIdOfEmployeeSalarySheet(String currentSalaryGradeId)
	{		
	 	checkIdOfEmployeeSalarySheet(currentSalaryGradeId ); 		
		
		return this;
	}	

	public static final String  BASE_SALARY_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.base_salary";
	public YoubenbenChecker checkBaseSalaryOfEmployeeSalarySheet(BigDecimal baseSalary)
	{		
	 	checkMoneyAmount(baseSalary,0.00, 3000.10,BASE_SALARY_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	

	public static final String  BONUS_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.bonus";
	public YoubenbenChecker checkBonusOfEmployeeSalarySheet(BigDecimal bonus)
	{		
	 	checkMoneyAmount(bonus,0.00, 1000.10,BONUS_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	

	public static final String  REWARD_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.reward";
	public YoubenbenChecker checkRewardOfEmployeeSalarySheet(BigDecimal reward)
	{		
	 	checkMoneyAmount(reward,0.00, 1000.10,REWARD_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	

	public static final String  PERSONAL_TAX_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.personal_tax";
	public YoubenbenChecker checkPersonalTaxOfEmployeeSalarySheet(BigDecimal personalTax)
	{		
	 	checkMoneyAmount(personalTax,0.00, 792.88,PERSONAL_TAX_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	

	public static final String  SOCIAL_SECURITY_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.social_security";
	public YoubenbenChecker checkSocialSecurityOfEmployeeSalarySheet(BigDecimal socialSecurity)
	{		
	 	checkMoneyAmount(socialSecurity,0.00, 1100.22,SOCIAL_SECURITY_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	

	public static final String  HOUSING_FOUND_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.housing_found";
	public YoubenbenChecker checkHousingFoundOfEmployeeSalarySheet(BigDecimal housingFound)
	{		
	 	checkMoneyAmount(housingFound,0.00, 1222.99,HOUSING_FOUND_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	

	public static final String  JOB_INSURANCE_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.job_insurance";
	public YoubenbenChecker checkJobInsuranceOfEmployeeSalarySheet(BigDecimal jobInsurance)
	{		
	 	checkMoneyAmount(jobInsurance,0.00, 8.88,JOB_INSURANCE_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	

	public static final String  PAYING_OFF_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.paying_off";
	public YoubenbenChecker checkPayingOffIdOfEmployeeSalarySheet(String payingOffId)
	{		
	 	checkIdOfEmployeeSalarySheet(payingOffId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.version";
	public YoubenbenChecker checkVersionOfEmployeeSalarySheet(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	

	public static final String  ID_OF_PAYING_OFF ="paying_off.id";
	public YoubenbenChecker checkIdOfPayingOff(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PAYING_OFF ); 		
		
		return this;
	}	

	public static final String  WHO_OF_PAYING_OFF ="paying_off.who";
	public YoubenbenChecker checkWhoOfPayingOff(String who)
	{		
	 	checkStringLengthRange(who,1, 8,WHO_OF_PAYING_OFF ); 		
		
		return this;
	}	

	public static final String  PAID_FOR_OF_PAYING_OFF ="paying_off.paid_for";
	public YoubenbenChecker checkPaidForIdOfPayingOff(String paidForId)
	{		
	 	checkIdOfPayingOff(paidForId ); 		
		
		return this;
	}	

	public static final String  PAID_TIME_OF_PAYING_OFF ="paying_off.paid_time";
	public YoubenbenChecker checkPaidTimeOfPayingOff(Date paidTime)
	{		
	 	checkDateRange(paidTime,parseDate("1900-01-01"), parseDate("2018-01-19"),PAID_TIME_OF_PAYING_OFF ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_PAYING_OFF ="paying_off.amount";
	public YoubenbenChecker checkAmountOfPayingOff(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 5223.88,AMOUNT_OF_PAYING_OFF ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PAYING_OFF ="paying_off.version";
	public YoubenbenChecker checkVersionOfPayingOff(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAYING_OFF ); 		
		
		return this;
	}	

	public static final String  ID_OF_MOBILE_APP ="mobile_app.id";
	public YoubenbenChecker checkIdOfMobileApp(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_MOBILE_APP ); 		
		
		return this;
	}	

	public static final String  NAME_OF_MOBILE_APP ="mobile_app.name";
	public YoubenbenChecker checkNameOfMobileApp(String name)
	{		
	 	checkStringLengthRange(name,2, 20,NAME_OF_MOBILE_APP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_MOBILE_APP ="mobile_app.version";
	public YoubenbenChecker checkVersionOfMobileApp(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MOBILE_APP ); 		
		
		return this;
	}	

	public static final String  ID_OF_PAGE ="page.id";
	public YoubenbenChecker checkIdOfPage(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  PAGE_TITLE_OF_PAGE ="page.page_title";
	public YoubenbenChecker checkPageTitleOfPage(String pageTitle)
	{		
	 	checkStringLengthRange(pageTitle,1, 8,PAGE_TITLE_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_PAGE ="page.link_to_url";
	public YoubenbenChecker checkLinkToUrlOfPage(String linkToUrl)
	{		
	 	checkStringLengthRange(linkToUrl,5, 200,LINK_TO_URL_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  PAGE_TYPE_OF_PAGE ="page.page_type";
	public YoubenbenChecker checkPageTypeIdOfPage(String pageTypeId)
	{		
	 	checkIdOfPage(pageTypeId ); 		
		
		return this;
	}	

	public static final String  MOBILE_APP_OF_PAGE ="page.mobile_app";
	public YoubenbenChecker checkMobileAppIdOfPage(String mobileAppId)
	{		
	 	checkIdOfPage(mobileAppId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PAGE ="page.version";
	public YoubenbenChecker checkVersionOfPage(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_PAGE_TYPE ="page_type.id";
	public YoubenbenChecker checkIdOfPageType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PAGE_TYPE ="page_type.name";
	public YoubenbenChecker checkNameOfPageType(String name)
	{		
	 	checkStringLengthRange(name,1, 48,NAME_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_PAGE_TYPE ="page_type.code";
	public YoubenbenChecker checkCodeOfPageType(String code)
	{		
	 	checkStringLengthRange(code,1, 56,CODE_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  MOBILE_APP_OF_PAGE_TYPE ="page_type.mobile_app";
	public YoubenbenChecker checkMobileAppIdOfPageType(String mobileAppId)
	{		
	 	checkIdOfPageType(mobileAppId ); 		
		
		return this;
	}	

	public static final String  FOOTER_TAB_OF_PAGE_TYPE ="page_type.footer_tab";
	public YoubenbenChecker checkFooterTabOfPageType(boolean footerTab)
	{		
	 	checkBooleanRange(footerTab,0, true|false,FOOTER_TAB_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PAGE_TYPE ="page_type.version";
	public YoubenbenChecker checkVersionOfPageType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_SLIDE ="slide.id";
	public YoubenbenChecker checkIdOfSlide(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  DISPLAY_ORDER_OF_SLIDE ="slide.display_order";
	public YoubenbenChecker checkDisplayOrderOfSlide(int displayOrder)
	{		
	 	checkIntegerRange(displayOrder,1, 100,DISPLAY_ORDER_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_SLIDE ="slide.name";
	public YoubenbenChecker checkNameOfSlide(String name)
	{		
	 	checkStringLengthRange(name,1, 20,NAME_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  IMAGE_URL_OF_SLIDE ="slide.image_url";
	public YoubenbenChecker checkImageUrlOfSlide(String imageUrl)
	{		
	 	checkImage(imageUrl,0, 512,IMAGE_URL_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  VIDEO_URL_OF_SLIDE ="slide.video_url";
	public YoubenbenChecker checkVideoUrlOfSlide(String videoUrl)
	{		
	 	checkImage(videoUrl,0, 512,VIDEO_URL_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_SLIDE ="slide.link_to_url";
	public YoubenbenChecker checkLinkToUrlOfSlide(String linkToUrl)
	{
		if(linkToUrl == null) {
			return this;
		}
		
	 	checkStringLengthRange(linkToUrl,0, 68,LINK_TO_URL_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  PAGE_OF_SLIDE ="slide.page";
	public YoubenbenChecker checkPageIdOfSlide(String pageId)
	{		
	 	checkIdOfSlide(pageId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SLIDE ="slide.version";
	public YoubenbenChecker checkVersionOfSlide(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  ID_OF_UI_ACTION ="ui_action.id";
	public YoubenbenChecker checkIdOfUiAction(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  CODE_OF_UI_ACTION ="ui_action.code";
	public YoubenbenChecker checkCodeOfUiAction(String code)
	{		
	 	checkStringLengthRange(code,2, 24,CODE_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  ICON_OF_UI_ACTION ="ui_action.icon";
	public YoubenbenChecker checkIconOfUiAction(String icon)
	{		
	 	checkStringLengthRange(icon,4, 40,ICON_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_UI_ACTION ="ui_action.title";
	public YoubenbenChecker checkTitleOfUiAction(String title)
	{		
	 	checkStringLengthRange(title,1, 8,TITLE_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  BRIEF_OF_UI_ACTION ="ui_action.brief";
	public YoubenbenChecker checkBriefOfUiAction(String brief)
	{		
	 	checkStringLengthRange(brief,2, 36,BRIEF_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  IMAGE_URL_OF_UI_ACTION ="ui_action.image_url";
	public YoubenbenChecker checkImageUrlOfUiAction(String imageUrl)
	{		
	 	checkImage(imageUrl,0, 512,IMAGE_URL_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_UI_ACTION ="ui_action.link_to_url";
	public YoubenbenChecker checkLinkToUrlOfUiAction(String linkToUrl)
	{		
	 	checkStringLengthRange(linkToUrl,5, 68,LINK_TO_URL_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  EXTRA_DATA_OF_UI_ACTION ="ui_action.extra_data";
	public YoubenbenChecker checkExtraDataOfUiAction(String extraData)
	{		
	 	checkLongtext(extraData,0, 1048576,EXTRA_DATA_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  PAGE_OF_UI_ACTION ="ui_action.page";
	public YoubenbenChecker checkPageIdOfUiAction(String pageId)
	{		
	 	checkIdOfUiAction(pageId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_UI_ACTION ="ui_action.version";
	public YoubenbenChecker checkVersionOfUiAction(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_SECTION ="section.id";
	public YoubenbenChecker checkIdOfSection(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_SECTION ="section.title";
	public YoubenbenChecker checkTitleOfSection(String title)
	{		
	 	checkStringLengthRange(title,1, 8,TITLE_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  BRIEF_OF_SECTION ="section.brief";
	public YoubenbenChecker checkBriefOfSection(String brief)
	{		
	 	checkStringLengthRange(brief,3, 28,BRIEF_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  ICON_OF_SECTION ="section.icon";
	public YoubenbenChecker checkIconOfSection(String icon)
	{		
	 	checkStringLengthRange(icon,4, 40,ICON_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  VIEW_GROUP_OF_SECTION ="section.view_group";
	public YoubenbenChecker checkViewGroupOfSection(String viewGroup)
	{		
	 	checkStringLengthRange(viewGroup,4, 40,VIEW_GROUP_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_SECTION ="section.link_to_url";
	public YoubenbenChecker checkLinkToUrlOfSection(String linkToUrl)
	{		
	 	checkStringLengthRange(linkToUrl,5, 68,LINK_TO_URL_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  PAGE_OF_SECTION ="section.page";
	public YoubenbenChecker checkPageIdOfSection(String pageId)
	{		
	 	checkIdOfSection(pageId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SECTION ="section.version";
	public YoubenbenChecker checkVersionOfSection(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public YoubenbenChecker checkIdOfUserDomain(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public YoubenbenChecker checkNameOfUserDomain(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public YoubenbenChecker checkVersionOfUserDomain(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public YoubenbenChecker checkIdOfUserWhiteList(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public YoubenbenChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public YoubenbenChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public YoubenbenChecker checkDomainIdOfUserWhiteList(String domainId)
	{		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public YoubenbenChecker checkVersionOfUserWhiteList(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public YoubenbenChecker checkIdOfSecUser(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public YoubenbenChecker checkLoginOfSecUser(String login)
	{		
	 	checkStringLengthRange(login,0, 256,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public YoubenbenChecker checkMobileOfSecUser(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public YoubenbenChecker checkEmailOfSecUser(String email)
	{		
	 	checkEmail(email,0, 256,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public YoubenbenChecker checkPwdOfSecUser(String pwd)
	{		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_OPENID_OF_SEC_USER ="sec_user.weixin_openid";
	public YoubenbenChecker checkWeixinOpenidOfSecUser(String weixinOpenid)
	{		
	 	checkStringLengthRange(weixinOpenid,0, 128,WEIXIN_OPENID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_APPID_OF_SEC_USER ="sec_user.weixin_appid";
	public YoubenbenChecker checkWeixinAppidOfSecUser(String weixinAppid)
	{		
	 	checkStringLengthRange(weixinAppid,0, 128,WEIXIN_APPID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ACCESS_TOKEN_OF_SEC_USER ="sec_user.access_token";
	public YoubenbenChecker checkAccessTokenOfSecUser(String accessToken)
	{		
	 	checkStringLengthRange(accessToken,0, 128,ACCESS_TOKEN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public YoubenbenChecker checkVerificationCodeOfSecUser(int verificationCode)
	{		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public YoubenbenChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public YoubenbenChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public YoubenbenChecker checkDomainIdOfSecUser(String domainId)
	{		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public YoubenbenChecker checkVersionOfSecUser(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_APP ="user_app.id";
	public YoubenbenChecker checkIdOfUserApp(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public YoubenbenChecker checkTitleOfUserApp(String title)
	{		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public YoubenbenChecker checkSecUserIdOfUserApp(String secUserId)
	{		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public YoubenbenChecker checkAppIconOfUserApp(String appIcon)
	{		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public YoubenbenChecker checkFullAccessOfUserApp(boolean fullAccess)
	{		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public YoubenbenChecker checkPermissionOfUserApp(String permission)
	{		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public YoubenbenChecker checkObjectTypeOfUserApp(String objectType)
	{		
	 	checkStringLengthRange(objectType,1, 100,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public YoubenbenChecker checkObjectIdOfUserApp(String objectId)
	{		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public YoubenbenChecker checkLocationOfUserApp(String location)
	{		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public YoubenbenChecker checkVersionOfUserApp(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  ID_OF_QUICK_LINK ="quick_link.id";
	public YoubenbenChecker checkIdOfQuickLink(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  NAME_OF_QUICK_LINK ="quick_link.name";
	public YoubenbenChecker checkNameOfQuickLink(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ICON_OF_QUICK_LINK ="quick_link.icon";
	public YoubenbenChecker checkIconOfQuickLink(String icon)
	{		
	 	checkStringLengthRange(icon,1, 200,ICON_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  IMAGE_PATH_OF_QUICK_LINK ="quick_link.image_path";
	public YoubenbenChecker checkImagePathOfQuickLink(String imagePath)
	{		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  LINK_TARGET_OF_QUICK_LINK ="quick_link.link_target";
	public YoubenbenChecker checkLinkTargetOfQuickLink(String linkTarget)
	{		
	 	checkStringLengthRange(linkTarget,1, 200,LINK_TARGET_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  APP_OF_QUICK_LINK ="quick_link.app";
	public YoubenbenChecker checkAppIdOfQuickLink(String appId)
	{		
	 	checkIdOfQuickLink(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_QUICK_LINK ="quick_link.version";
	public YoubenbenChecker checkVersionOfQuickLink(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public YoubenbenChecker checkIdOfListAccess(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public YoubenbenChecker checkNameOfListAccess(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public YoubenbenChecker checkInternalNameOfListAccess(String internalName)
	{		
	 	checkStringLengthRange(internalName,1, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public YoubenbenChecker checkReadPermissionOfListAccess(boolean readPermission)
	{		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public YoubenbenChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public YoubenbenChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public YoubenbenChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public YoubenbenChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public YoubenbenChecker checkAppIdOfListAccess(String appId)
	{		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public YoubenbenChecker checkVersionOfListAccess(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public YoubenbenChecker checkIdOfLoginHistory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public YoubenbenChecker checkFromIpOfLoginHistory(String fromIp)
	{		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public YoubenbenChecker checkDescriptionOfLoginHistory(String description)
	{		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public YoubenbenChecker checkSecUserIdOfLoginHistory(String secUserId)
	{		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public YoubenbenChecker checkVersionOfLoginHistory(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_CONTAINER ="candidate_container.id";
	public YoubenbenChecker checkIdOfCandidateContainer(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_CONTAINER ="candidate_container.name";
	public YoubenbenChecker checkNameOfCandidateContainer(String name)
	{		
	 	checkStringLengthRange(name,2, 28,NAME_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_CONTAINER ="candidate_container.version";
	public YoubenbenChecker checkVersionOfCandidateContainer(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_ELEMENT ="candidate_element.id";
	public YoubenbenChecker checkIdOfCandidateElement(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_ELEMENT ="candidate_element.name";
	public YoubenbenChecker checkNameOfCandidateElement(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_CANDIDATE_ELEMENT ="candidate_element.type";
	public YoubenbenChecker checkTypeOfCandidateElement(String type)
	{		
	 	checkStringLengthRange(type,1, 200,TYPE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  IMAGE_OF_CANDIDATE_ELEMENT ="candidate_element.image";
	public YoubenbenChecker checkImageOfCandidateElement(String image)
	{		
	 	checkImage(image,0, 512,IMAGE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  CONTAINER_OF_CANDIDATE_ELEMENT ="candidate_element.container";
	public YoubenbenChecker checkContainerIdOfCandidateElement(String containerId)
	{		
	 	checkIdOfCandidateElement(containerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_ELEMENT ="candidate_element.version";
	public YoubenbenChecker checkVersionOfCandidateElement(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.id";
	public YoubenbenChecker checkIdOfWechatWorkappIdentify(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  CORP_ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.corp_id";
	public YoubenbenChecker checkCorpIdOfWechatWorkappIdentify(String corpId)
	{		
	 	checkStringLengthRange(corpId,0, 100,CORP_ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  USER_ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.user_id";
	public YoubenbenChecker checkUserIdOfWechatWorkappIdentify(String userId)
	{		
	 	checkStringLengthRange(userId,1, 100,USER_ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.sec_user";
	public YoubenbenChecker checkSecUserIdOfWechatWorkappIdentify(String secUserId)
	{		
	 	checkIdOfWechatWorkappIdentify(secUserId ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.last_login_time";
	public YoubenbenChecker checkLastLoginTimeOfWechatWorkappIdentify(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2100-01-01T00:00:00"),LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.version";
	public YoubenbenChecker checkVersionOfWechatWorkappIdentify(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.id";
	public YoubenbenChecker checkIdOfWechatMiniappIdentify(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  OPEN_ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.open_id";
	public YoubenbenChecker checkOpenIdOfWechatMiniappIdentify(String openId)
	{		
	 	checkStringLengthRange(openId,5, 128,OPEN_ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  APP_ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.app_id";
	public YoubenbenChecker checkAppIdOfWechatMiniappIdentify(String appId)
	{		
	 	checkStringLengthRange(appId,5, 128,APP_ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.sec_user";
	public YoubenbenChecker checkSecUserIdOfWechatMiniappIdentify(String secUserId)
	{		
	 	checkIdOfWechatMiniappIdentify(secUserId ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.last_login_time";
	public YoubenbenChecker checkLastLoginTimeOfWechatMiniappIdentify(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2100-01-01T00:00:00"),LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.version";
	public YoubenbenChecker checkVersionOfWechatMiniappIdentify(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  ID_OF_KEYPAIR_IDENTIFY ="keypair_identify.id";
	public YoubenbenChecker checkIdOfKeypairIdentify(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_KEYPAIR_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  PUBLIC_KEY_OF_KEYPAIR_IDENTIFY ="keypair_identify.public_key";
	public YoubenbenChecker checkPublicKeyOfKeypairIdentify(String publicKey)
	{		
	 	checkLongtext(publicKey,0, 1048576,PUBLIC_KEY_OF_KEYPAIR_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  KEY_TYPE_OF_KEYPAIR_IDENTIFY ="keypair_identify.key_type";
	public YoubenbenChecker checkKeyTypeIdOfKeypairIdentify(String keyTypeId)
	{		
	 	checkIdOfKeypairIdentify(keyTypeId ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_KEYPAIR_IDENTIFY ="keypair_identify.sec_user";
	public YoubenbenChecker checkSecUserIdOfKeypairIdentify(String secUserId)
	{		
	 	checkIdOfKeypairIdentify(secUserId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_KEYPAIR_IDENTIFY ="keypair_identify.version";
	public YoubenbenChecker checkVersionOfKeypairIdentify(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_KEYPAIR_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  ID_OF_PUBLIC_KEY_TYPE ="public_key_type.id";
	public YoubenbenChecker checkIdOfPublicKeyType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PUBLIC_KEY_TYPE ="public_key_type.name";
	public YoubenbenChecker checkNameOfPublicKeyType(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_PUBLIC_KEY_TYPE ="public_key_type.code";
	public YoubenbenChecker checkCodeOfPublicKeyType(String code)
	{		
	 	checkStringLengthRange(code,1, 12,CODE_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_PUBLIC_KEY_TYPE ="public_key_type.domain";
	public YoubenbenChecker checkDomainIdOfPublicKeyType(String domainId)
	{		
	 	checkIdOfPublicKeyType(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PUBLIC_KEY_TYPE ="public_key_type.version";
	public YoubenbenChecker checkVersionOfPublicKeyType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_TREE_NODE ="tree_node.id";
	public YoubenbenChecker checkIdOfTreeNode(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  NODE_ID_OF_TREE_NODE ="tree_node.node_id";
	public YoubenbenChecker checkNodeIdOfTreeNode(String nodeId)
	{		
	 	checkStringLengthRange(nodeId,3, 40,NODE_ID_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  NODE_TYPE_OF_TREE_NODE ="tree_node.node_type";
	public YoubenbenChecker checkNodeTypeOfTreeNode(String nodeType)
	{		
	 	checkStringLengthRange(nodeType,3, 32,NODE_TYPE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  LEFT_VALUE_OF_TREE_NODE ="tree_node.left_value";
	public YoubenbenChecker checkLeftValueOfTreeNode(int leftValue)
	{		
	 	checkIntegerRange(leftValue,1, 10000000,LEFT_VALUE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  RIGHT_VALUE_OF_TREE_NODE ="tree_node.right_value";
	public YoubenbenChecker checkRightValueOfTreeNode(int rightValue)
	{		
	 	checkIntegerRange(rightValue,2, 10000000,RIGHT_VALUE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TREE_NODE ="tree_node.version";
	public YoubenbenChecker checkVersionOfTreeNode(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TREE_NODE ); 		
		
		return this;
	}	
}



















