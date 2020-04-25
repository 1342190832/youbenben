
package com.xingyou.xingyou;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
public class XingyouChecker extends BaseChecker{

	
	public XingyouChecker() {
		this.messageList = new ArrayList<Message>();
	}
	

	public static final String  ID_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ="franchised_outlet_province_center.id";
	public XingyouChecker checkIdOfFranchisedOutletProvinceCenter(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ="franchised_outlet_province_center.name";
	public XingyouChecker checkNameOfFranchisedOutletProvinceCenter(String name)
	{		
	 	checkStringLengthRange(name,4, 36,NAME_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  SERVICE_NUMBER_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ="franchised_outlet_province_center.service_number";
	public XingyouChecker checkServiceNumberOfFranchisedOutletProvinceCenter(String serviceNumber)
	{		
	 	checkStringLengthRange(serviceNumber,4, 52,SERVICE_NUMBER_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ="franchised_outlet_province_center.founded";
	public XingyouChecker checkFoundedOfFranchisedOutletProvinceCenter(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  WEB_SITE_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ="franchised_outlet_province_center.web_site";
	public XingyouChecker checkWebSiteOfFranchisedOutletProvinceCenter(String webSite)
	{		
	 	checkUrl(webSite,13, 104,WEB_SITE_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  ADDRESS_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ="franchised_outlet_province_center.address";
	public XingyouChecker checkAddressOfFranchisedOutletProvinceCenter(String address)
	{		
	 	checkStringLengthRange(address,4, 56,ADDRESS_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  OPERATED_BY_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ="franchised_outlet_province_center.operated_by";
	public XingyouChecker checkOperatedByOfFranchisedOutletProvinceCenter(String operatedBy)
	{		
	 	checkStringLengthRange(operatedBy,2, 24,OPERATED_BY_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  LEGAL_REPRESENTATIVE_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ="franchised_outlet_province_center.legal_representative";
	public XingyouChecker checkLegalRepresentativeOfFranchisedOutletProvinceCenter(String legalRepresentative)
	{		
	 	checkStringLengthRange(legalRepresentative,1, 12,LEGAL_REPRESENTATIVE_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ="franchised_outlet_province_center.description";
	public XingyouChecker checkDescriptionOfFranchisedOutletProvinceCenter(String description)
	{		
	 	checkStringLengthRange(description,4, 60,DESCRIPTION_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ="franchised_outlet_province_center.version";
	public XingyouChecker checkVersionOfFranchisedOutletProvinceCenter(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FRANCHISED_OUTLET_PROVINCE_CENTER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CATALOG ="catalog.id";
	public XingyouChecker checkIdOfCatalog(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CATALOG ="catalog.name";
	public XingyouChecker checkNameOfCatalog(String name)
	{		
	 	checkStringLengthRange(name,1, 8,NAME_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_CATALOG ="catalog.owner";
	public XingyouChecker checkOwnerIdOfCatalog(String ownerId)
	{		
	 	checkIdOfCatalog(ownerId ); 		
		
		return this;
	}	

	public static final String  SUB_COUNT_OF_CATALOG ="catalog.sub_count";
	public XingyouChecker checkSubCountOfCatalog(int subCount)
	{		
	 	checkIntegerRange(subCount,0, 3,SUB_COUNT_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_CATALOG ="catalog.amount";
	public XingyouChecker checkAmountOfCatalog(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 10.11,AMOUNT_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CATALOG ="catalog.version";
	public XingyouChecker checkVersionOfCatalog(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEVEL_ONE_CATEGORY ="level_one_category.id";
	public XingyouChecker checkIdOfLevelOneCategory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  CATALOG_OF_LEVEL_ONE_CATEGORY ="level_one_category.catalog";
	public XingyouChecker checkCatalogIdOfLevelOneCategory(String catalogId)
	{		
	 	checkIdOfLevelOneCategory(catalogId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LEVEL_ONE_CATEGORY ="level_one_category.name";
	public XingyouChecker checkNameOfLevelOneCategory(String name)
	{		
	 	checkStringLengthRange(name,1, 8,NAME_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEVEL_ONE_CATEGORY ="level_one_category.version";
	public XingyouChecker checkVersionOfLevelOneCategory(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEVEL_TWO_CATEGORY ="level_two_category.id";
	public XingyouChecker checkIdOfLevelTwoCategory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	

	public static final String  PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY ="level_two_category.parent_category";
	public XingyouChecker checkParentCategoryIdOfLevelTwoCategory(String parentCategoryId)
	{		
	 	checkIdOfLevelTwoCategory(parentCategoryId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LEVEL_TWO_CATEGORY ="level_two_category.name";
	public XingyouChecker checkNameOfLevelTwoCategory(String name)
	{		
	 	checkStringLengthRange(name,1, 8,NAME_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEVEL_TWO_CATEGORY ="level_two_category.version";
	public XingyouChecker checkVersionOfLevelTwoCategory(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEVEL_THREE_CATEGORY ="level_three_category.id";
	public XingyouChecker checkIdOfLevelThreeCategory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_THREE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  PARENT_CATEGORY_OF_LEVEL_THREE_CATEGORY ="level_three_category.parent_category";
	public XingyouChecker checkParentCategoryIdOfLevelThreeCategory(String parentCategoryId)
	{		
	 	checkIdOfLevelThreeCategory(parentCategoryId ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LEVEL_THREE_CATEGORY ="level_three_category.name";
	public XingyouChecker checkNameOfLevelThreeCategory(String name)
	{		
	 	checkStringLengthRange(name,1, 8,NAME_OF_LEVEL_THREE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEVEL_THREE_CATEGORY ="level_three_category.version";
	public XingyouChecker checkVersionOfLevelThreeCategory(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_THREE_CATEGORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_PRODUCT ="product.id";
	public XingyouChecker checkIdOfProduct(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PRODUCT ="product.name";
	public XingyouChecker checkNameOfProduct(String name)
	{		
	 	checkStringLengthRange(name,1, 20,NAME_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  PARENT_CATEGORY_OF_PRODUCT ="product.parent_category";
	public XingyouChecker checkParentCategoryIdOfProduct(String parentCategoryId)
	{		
	 	checkIdOfProduct(parentCategoryId ); 		
		
		return this;
	}	

	public static final String  ORIGIN_OF_PRODUCT ="product.origin";
	public XingyouChecker checkOriginOfProduct(String origin)
	{		
	 	checkStringLengthRange(origin,1, 8,ORIGIN_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  REMARK_OF_PRODUCT ="product.remark";
	public XingyouChecker checkRemarkOfProduct(String remark)
	{		
	 	checkStringLengthRange(remark,6, 88,REMARK_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  BRAND_OF_PRODUCT ="product.brand";
	public XingyouChecker checkBrandOfProduct(String brand)
	{		
	 	checkStringLengthRange(brand,1, 12,BRAND_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  PICTURE_OF_PRODUCT ="product.picture";
	public XingyouChecker checkPictureOfProduct(String picture)
	{		
	 	checkImage(picture,0, 512,PICTURE_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PRODUCT ="product.version";
	public XingyouChecker checkVersionOfProduct(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT ); 		
		
		return this;
	}	

	public static final String  ID_OF_SKU ="sku.id";
	public XingyouChecker checkIdOfSku(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SKU ); 		
		
		return this;
	}	

	public static final String  NAME_OF_SKU ="sku.name";
	public XingyouChecker checkNameOfSku(String name)
	{		
	 	checkStringLengthRange(name,2, 28,NAME_OF_SKU ); 		
		
		return this;
	}	

	public static final String  SIZE_OF_SKU ="sku.size";
	public XingyouChecker checkSizeOfSku(String size)
	{		
	 	checkStringLengthRange(size,0, 4,SIZE_OF_SKU ); 		
		
		return this;
	}	

	public static final String  PRODUCT_OF_SKU ="sku.product";
	public XingyouChecker checkProductIdOfSku(String productId)
	{		
	 	checkIdOfSku(productId ); 		
		
		return this;
	}	

	public static final String  BARCODE_OF_SKU ="sku.barcode";
	public XingyouChecker checkBarcodeOfSku(String barcode)
	{		
	 	checkStringLengthRange(barcode,4, 52,BARCODE_OF_SKU ); 		
		
		return this;
	}	

	public static final String  PACKAGE_TYPE_OF_SKU ="sku.package_type";
	public XingyouChecker checkPackageTypeOfSku(String packageType)
	{		
	 	checkStringLengthRange(packageType,2, 16,PACKAGE_TYPE_OF_SKU ); 		
		
		return this;
	}	

	public static final String  NET_CONTENT_OF_SKU ="sku.net_content";
	public XingyouChecker checkNetContentOfSku(String netContent)
	{		
	 	checkStringLengthRange(netContent,6, 92,NET_CONTENT_OF_SKU ); 		
		
		return this;
	}	

	public static final String  PRICE_OF_SKU ="sku.price";
	public XingyouChecker checkPriceOfSku(BigDecimal price)
	{		
	 	checkMoneyAmount(price,0.00, 1323.33,PRICE_OF_SKU ); 		
		
		return this;
	}	

	public static final String  PICTURE_OF_SKU ="sku.picture";
	public XingyouChecker checkPictureOfSku(String picture)
	{		
	 	checkImage(picture,0, 512,PICTURE_OF_SKU ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SKU ="sku.version";
	public XingyouChecker checkVersionOfSku(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SKU ); 		
		
		return this;
	}	

	public static final String  ID_OF_FRANCHISED_OUTLET_CITY_CENTER ="franchised_outlet_city_center.id";
	public XingyouChecker checkIdOfFranchisedOutletCityCenter(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FRANCHISED_OUTLET_CITY_CENTER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_FRANCHISED_OUTLET_CITY_CENTER ="franchised_outlet_city_center.name";
	public XingyouChecker checkNameOfFranchisedOutletCityCenter(String name)
	{		
	 	checkStringLengthRange(name,5, 40,NAME_OF_FRANCHISED_OUTLET_CITY_CENTER ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_FRANCHISED_OUTLET_CITY_CENTER ="franchised_outlet_city_center.founded";
	public XingyouChecker checkFoundedOfFranchisedOutletCityCenter(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_FRANCHISED_OUTLET_CITY_CENTER ); 		
		
		return this;
	}	

	public static final String  CITY_OF_FRANCHISED_OUTLET_CITY_CENTER ="franchised_outlet_city_center.city";
	public XingyouChecker checkCityIdOfFranchisedOutletCityCenter(String cityId)
	{		
	 	checkIdOfFranchisedOutletCityCenter(cityId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FRANCHISED_OUTLET_CITY_CENTER ="franchised_outlet_city_center.version";
	public XingyouChecker checkVersionOfFranchisedOutletCityCenter(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FRANCHISED_OUTLET_CITY_CENTER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CITY_CENTER_DEPARTMENT ="city_center_department.id";
	public XingyouChecker checkIdOfCityCenterDepartment(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CITY_CENTER_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CITY_CENTER_DEPARTMENT ="city_center_department.name";
	public XingyouChecker checkNameOfCityCenterDepartment(String name)
	{		
	 	checkStringLengthRange(name,1, 20,NAME_OF_CITY_CENTER_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_CITY_CENTER_DEPARTMENT ="city_center_department.founded";
	public XingyouChecker checkFoundedOfCityCenterDepartment(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_CITY_CENTER_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  CITY_CENTER_OF_CITY_CENTER_DEPARTMENT ="city_center_department.city_center";
	public XingyouChecker checkCityCenterIdOfCityCenterDepartment(String cityCenterId)
	{		
	 	checkIdOfCityCenterDepartment(cityCenterId ); 		
		
		return this;
	}	

	public static final String  MANAGER_OF_CITY_CENTER_DEPARTMENT ="city_center_department.manager";
	public XingyouChecker checkManagerOfCityCenterDepartment(String manager)
	{		
	 	checkStringLengthRange(manager,1, 8,MANAGER_OF_CITY_CENTER_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CITY_CENTER_DEPARTMENT ="city_center_department.version";
	public XingyouChecker checkVersionOfCityCenterDepartment(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY_CENTER_DEPARTMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_CITY_CENTER_EMPLOYEE ="city_center_employee.id";
	public XingyouChecker checkIdOfCityCenterEmployee(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CITY_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CITY_CENTER_EMPLOYEE ="city_center_employee.name";
	public XingyouChecker checkNameOfCityCenterEmployee(String name)
	{		
	 	checkStringLengthRange(name,1, 8,NAME_OF_CITY_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_CITY_CENTER_EMPLOYEE ="city_center_employee.mobile";
	public XingyouChecker checkMobileOfCityCenterEmployee(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_CITY_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  EMAIL_OF_CITY_CENTER_EMPLOYEE ="city_center_employee.email";
	public XingyouChecker checkEmailOfCityCenterEmployee(String email)
	{		
	 	checkEmail(email,8, 84,EMAIL_OF_CITY_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_CITY_CENTER_EMPLOYEE ="city_center_employee.founded";
	public XingyouChecker checkFoundedOfCityCenterEmployee(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_CITY_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  DEPARTMENT_OF_CITY_CENTER_EMPLOYEE ="city_center_employee.department";
	public XingyouChecker checkDepartmentIdOfCityCenterEmployee(String departmentId)
	{		
	 	checkIdOfCityCenterEmployee(departmentId ); 		
		
		return this;
	}	

	public static final String  CITY_CENTER_OF_CITY_CENTER_EMPLOYEE ="city_center_employee.city_center";
	public XingyouChecker checkCityCenterIdOfCityCenterEmployee(String cityCenterId)
	{		
	 	checkIdOfCityCenterEmployee(cityCenterId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CITY_CENTER_EMPLOYEE ="city_center_employee.version";
	public XingyouChecker checkVersionOfCityCenterEmployee(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY_CENTER_EMPLOYEE ); 		
		
		return this;
	}	

	public static final String  ID_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER ="franchised_outlet_city_service_center.id";
	public XingyouChecker checkIdOfFranchisedOutletCityServiceCenter(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER ="franchised_outlet_city_service_center.name";
	public XingyouChecker checkNameOfFranchisedOutletCityServiceCenter(String name)
	{		
	 	checkStringLengthRange(name,2, 20,NAME_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	

	public static final String  FOUNDED_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER ="franchised_outlet_city_service_center.founded";
	public XingyouChecker checkFoundedOfFranchisedOutletCityServiceCenter(Date founded)
	{		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	

	public static final String  BELONGS_TO_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER ="franchised_outlet_city_service_center.belongs_to";
	public XingyouChecker checkBelongsToIdOfFranchisedOutletCityServiceCenter(String belongsToId)
	{		
	 	checkIdOfFranchisedOutletCityServiceCenter(belongsToId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER ="franchised_outlet_city_service_center.version";
	public XingyouChecker checkVersionOfFranchisedOutletCityServiceCenter(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FRANCHISED_OUTLET_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CITY_PARTNER ="city_partner.id";
	public XingyouChecker checkIdOfCityPartner(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CITY_PARTNER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CITY_PARTNER ="city_partner.name";
	public XingyouChecker checkNameOfCityPartner(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_CITY_PARTNER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_CITY_PARTNER ="city_partner.mobile";
	public XingyouChecker checkMobileOfCityPartner(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_CITY_PARTNER ); 		
		
		return this;
	}	

	public static final String  TOWN_SERVICE_CENTER_OF_CITY_PARTNER ="city_partner.town_service_center";
	public XingyouChecker checkTownServiceCenterIdOfCityPartner(String townServiceCenterId)
	{		
	 	checkIdOfCityPartner(townServiceCenterId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_CITY_PARTNER ="city_partner.description";
	public XingyouChecker checkDescriptionOfCityPartner(String description)
	{		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_CITY_PARTNER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CITY_PARTNER ="city_partner.version";
	public XingyouChecker checkVersionOfCityPartner(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY_PARTNER ); 		
		
		return this;
	}	

	public static final String  ID_OF_POTENTIAL_CUSTOMER ="potential_customer.id";
	public XingyouChecker checkIdOfPotentialCustomer(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_POTENTIAL_CUSTOMER ="potential_customer.name";
	public XingyouChecker checkNameOfPotentialCustomer(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_POTENTIAL_CUSTOMER ="potential_customer.mobile";
	public XingyouChecker checkMobileOfPotentialCustomer(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	

	public static final String  CITY_SERVICE_CENTER_OF_POTENTIAL_CUSTOMER ="potential_customer.city_service_center";
	public XingyouChecker checkCityServiceCenterIdOfPotentialCustomer(String cityServiceCenterId)
	{		
	 	checkIdOfPotentialCustomer(cityServiceCenterId ); 		
		
		return this;
	}	

	public static final String  CITY_PARTNER_OF_POTENTIAL_CUSTOMER ="potential_customer.city_partner";
	public XingyouChecker checkCityPartnerIdOfPotentialCustomer(String cityPartnerId)
	{		
	 	checkIdOfPotentialCustomer(cityPartnerId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER ="potential_customer.description";
	public XingyouChecker checkDescriptionOfPotentialCustomer(String description)
	{		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_POTENTIAL_CUSTOMER ="potential_customer.version";
	public XingyouChecker checkVersionOfPotentialCustomer(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	

	public static final String  ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.id";
	public XingyouChecker checkIdOfPotentialCustomerContactPerson(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	

	public static final String  NAME_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.name";
	public XingyouChecker checkNameOfPotentialCustomerContactPerson(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.mobile";
	public XingyouChecker checkMobileOfPotentialCustomerContactPerson(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	

	public static final String  POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.potential_customer";
	public XingyouChecker checkPotentialCustomerIdOfPotentialCustomerContactPerson(String potentialCustomerId)
	{		
	 	checkIdOfPotentialCustomerContactPerson(potentialCustomerId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.description";
	public XingyouChecker checkDescriptionOfPotentialCustomerContactPerson(String description)
	{		
	 	checkStringLengthRange(description,7, 96,DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.version";
	public XingyouChecker checkVersionOfPotentialCustomerContactPerson(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	

	public static final String  ID_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.id";
	public XingyouChecker checkIdOfPotentialCustomerContact(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.name";
	public XingyouChecker checkNameOfPotentialCustomerContact(String name)
	{		
	 	checkStringLengthRange(name,3, 40,NAME_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  CONTACT_DATE_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_date";
	public XingyouChecker checkContactDateOfPotentialCustomerContact(Date contactDate)
	{		
	 	checkDateRange(contactDate,parseDate("1900-01-01"), parseDate("2016-09-09"),CONTACT_DATE_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  CONTACT_METHOD_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_method";
	public XingyouChecker checkContactMethodOfPotentialCustomerContact(String contactMethod)
	{		
	 	checkStringLengthRange(contactMethod,1, 16,CONTACT_METHOD_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.potential_customer";
	public XingyouChecker checkPotentialCustomerIdOfPotentialCustomerContact(String potentialCustomerId)
	{		
	 	checkIdOfPotentialCustomerContact(potentialCustomerId ); 		
		
		return this;
	}	

	public static final String  CITY_PARTNER_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.city_partner";
	public XingyouChecker checkCityPartnerIdOfPotentialCustomerContact(String cityPartnerId)
	{		
	 	checkIdOfPotentialCustomerContact(cityPartnerId ); 		
		
		return this;
	}	

	public static final String  CONTACT_TO_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_to";
	public XingyouChecker checkContactToIdOfPotentialCustomerContact(String contactToId)
	{		
	 	checkIdOfPotentialCustomerContact(contactToId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.description";
	public XingyouChecker checkDescriptionOfPotentialCustomerContact(String description)
	{		
	 	checkStringLengthRange(description,2, 24,DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.version";
	public XingyouChecker checkVersionOfPotentialCustomerContact(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	

	public static final String  ID_OF_CITY_EVENT ="city_event.id";
	public XingyouChecker checkIdOfCityEvent(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CITY_EVENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CITY_EVENT ="city_event.name";
	public XingyouChecker checkNameOfCityEvent(String name)
	{		
	 	checkStringLengthRange(name,3, 24,NAME_OF_CITY_EVENT ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_CITY_EVENT ="city_event.mobile";
	public XingyouChecker checkMobileOfCityEvent(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_CITY_EVENT ); 		
		
		return this;
	}	

	public static final String  CITY_SERVICE_CENTER_OF_CITY_EVENT ="city_event.city_service_center";
	public XingyouChecker checkCityServiceCenterIdOfCityEvent(String cityServiceCenterId)
	{		
	 	checkIdOfCityEvent(cityServiceCenterId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_CITY_EVENT ="city_event.description";
	public XingyouChecker checkDescriptionOfCityEvent(String description)
	{		
	 	checkStringLengthRange(description,4, 52,DESCRIPTION_OF_CITY_EVENT ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CITY_EVENT ="city_event.version";
	public XingyouChecker checkVersionOfCityEvent(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY_EVENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_EVENT_ATTENDANCE ="event_attendance.id";
	public XingyouChecker checkIdOfEventAttendance(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_EVENT_ATTENDANCE ="event_attendance.name";
	public XingyouChecker checkNameOfEventAttendance(String name)
	{		
	 	checkStringLengthRange(name,3, 40,NAME_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  POTENTIAL_CUSTOMER_OF_EVENT_ATTENDANCE ="event_attendance.potential_customer";
	public XingyouChecker checkPotentialCustomerIdOfEventAttendance(String potentialCustomerId)
	{		
	 	checkIdOfEventAttendance(potentialCustomerId ); 		
		
		return this;
	}	

	public static final String  CITY_EVENT_OF_EVENT_ATTENDANCE ="event_attendance.city_event";
	public XingyouChecker checkCityEventIdOfEventAttendance(String cityEventId)
	{		
	 	checkIdOfEventAttendance(cityEventId ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_EVENT_ATTENDANCE ="event_attendance.description";
	public XingyouChecker checkDescriptionOfEventAttendance(String description)
	{		
	 	checkStringLengthRange(description,3, 36,DESCRIPTION_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EVENT_ATTENDANCE ="event_attendance.version";
	public XingyouChecker checkVersionOfEventAttendance(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	

	public static final String  ID_OF_MOBILE_APP ="mobile_app.id";
	public XingyouChecker checkIdOfMobileApp(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_MOBILE_APP ); 		
		
		return this;
	}	

	public static final String  NAME_OF_MOBILE_APP ="mobile_app.name";
	public XingyouChecker checkNameOfMobileApp(String name)
	{		
	 	checkStringLengthRange(name,2, 20,NAME_OF_MOBILE_APP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_MOBILE_APP ="mobile_app.version";
	public XingyouChecker checkVersionOfMobileApp(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MOBILE_APP ); 		
		
		return this;
	}	

	public static final String  ID_OF_PAGE ="page.id";
	public XingyouChecker checkIdOfPage(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  PAGE_TITLE_OF_PAGE ="page.page_title";
	public XingyouChecker checkPageTitleOfPage(String pageTitle)
	{		
	 	checkStringLengthRange(pageTitle,1, 8,PAGE_TITLE_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_PAGE ="page.link_to_url";
	public XingyouChecker checkLinkToUrlOfPage(String linkToUrl)
	{		
	 	checkStringLengthRange(linkToUrl,5, 200,LINK_TO_URL_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  PAGE_TYPE_OF_PAGE ="page.page_type";
	public XingyouChecker checkPageTypeIdOfPage(String pageTypeId)
	{		
	 	checkIdOfPage(pageTypeId ); 		
		
		return this;
	}	

	public static final String  MOBILE_APP_OF_PAGE ="page.mobile_app";
	public XingyouChecker checkMobileAppIdOfPage(String mobileAppId)
	{		
	 	checkIdOfPage(mobileAppId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PAGE ="page.version";
	public XingyouChecker checkVersionOfPage(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_PAGE_TYPE ="page_type.id";
	public XingyouChecker checkIdOfPageType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PAGE_TYPE ="page_type.name";
	public XingyouChecker checkNameOfPageType(String name)
	{		
	 	checkStringLengthRange(name,1, 48,NAME_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_PAGE_TYPE ="page_type.code";
	public XingyouChecker checkCodeOfPageType(String code)
	{		
	 	checkStringLengthRange(code,1, 56,CODE_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  MOBILE_APP_OF_PAGE_TYPE ="page_type.mobile_app";
	public XingyouChecker checkMobileAppIdOfPageType(String mobileAppId)
	{		
	 	checkIdOfPageType(mobileAppId ); 		
		
		return this;
	}	

	public static final String  FOOTER_TAB_OF_PAGE_TYPE ="page_type.footer_tab";
	public XingyouChecker checkFooterTabOfPageType(boolean footerTab)
	{		
	 	checkBooleanRange(footerTab,0, true|false,FOOTER_TAB_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PAGE_TYPE ="page_type.version";
	public XingyouChecker checkVersionOfPageType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_SLIDE ="slide.id";
	public XingyouChecker checkIdOfSlide(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  DISPLAY_ORDER_OF_SLIDE ="slide.display_order";
	public XingyouChecker checkDisplayOrderOfSlide(int displayOrder)
	{		
	 	checkIntegerRange(displayOrder,1, 100,DISPLAY_ORDER_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_SLIDE ="slide.name";
	public XingyouChecker checkNameOfSlide(String name)
	{		
	 	checkStringLengthRange(name,1, 20,NAME_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  IMAGE_URL_OF_SLIDE ="slide.image_url";
	public XingyouChecker checkImageUrlOfSlide(String imageUrl)
	{		
	 	checkImage(imageUrl,0, 512,IMAGE_URL_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  VIDEO_URL_OF_SLIDE ="slide.video_url";
	public XingyouChecker checkVideoUrlOfSlide(String videoUrl)
	{		
	 	checkImage(videoUrl,0, 512,VIDEO_URL_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_SLIDE ="slide.link_to_url";
	public XingyouChecker checkLinkToUrlOfSlide(String linkToUrl)
	{
		if(linkToUrl == null) {
			return this;
		}
		
	 	checkStringLengthRange(linkToUrl,0, 68,LINK_TO_URL_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  PAGE_OF_SLIDE ="slide.page";
	public XingyouChecker checkPageIdOfSlide(String pageId)
	{		
	 	checkIdOfSlide(pageId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SLIDE ="slide.version";
	public XingyouChecker checkVersionOfSlide(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  ID_OF_UI_ACTION ="ui_action.id";
	public XingyouChecker checkIdOfUiAction(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  CODE_OF_UI_ACTION ="ui_action.code";
	public XingyouChecker checkCodeOfUiAction(String code)
	{		
	 	checkStringLengthRange(code,2, 24,CODE_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  ICON_OF_UI_ACTION ="ui_action.icon";
	public XingyouChecker checkIconOfUiAction(String icon)
	{		
	 	checkStringLengthRange(icon,4, 40,ICON_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_UI_ACTION ="ui_action.title";
	public XingyouChecker checkTitleOfUiAction(String title)
	{		
	 	checkStringLengthRange(title,1, 8,TITLE_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  BRIEF_OF_UI_ACTION ="ui_action.brief";
	public XingyouChecker checkBriefOfUiAction(String brief)
	{		
	 	checkStringLengthRange(brief,2, 36,BRIEF_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  IMAGE_URL_OF_UI_ACTION ="ui_action.image_url";
	public XingyouChecker checkImageUrlOfUiAction(String imageUrl)
	{		
	 	checkImage(imageUrl,0, 512,IMAGE_URL_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_UI_ACTION ="ui_action.link_to_url";
	public XingyouChecker checkLinkToUrlOfUiAction(String linkToUrl)
	{		
	 	checkStringLengthRange(linkToUrl,5, 68,LINK_TO_URL_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  EXTRA_DATA_OF_UI_ACTION ="ui_action.extra_data";
	public XingyouChecker checkExtraDataOfUiAction(String extraData)
	{		
	 	checkLongtext(extraData,0, 1048576,EXTRA_DATA_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  PAGE_OF_UI_ACTION ="ui_action.page";
	public XingyouChecker checkPageIdOfUiAction(String pageId)
	{		
	 	checkIdOfUiAction(pageId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_UI_ACTION ="ui_action.version";
	public XingyouChecker checkVersionOfUiAction(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_SECTION ="section.id";
	public XingyouChecker checkIdOfSection(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_SECTION ="section.title";
	public XingyouChecker checkTitleOfSection(String title)
	{		
	 	checkStringLengthRange(title,1, 8,TITLE_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  BRIEF_OF_SECTION ="section.brief";
	public XingyouChecker checkBriefOfSection(String brief)
	{		
	 	checkStringLengthRange(brief,3, 28,BRIEF_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  ICON_OF_SECTION ="section.icon";
	public XingyouChecker checkIconOfSection(String icon)
	{		
	 	checkStringLengthRange(icon,4, 40,ICON_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  VIEW_GROUP_OF_SECTION ="section.view_group";
	public XingyouChecker checkViewGroupOfSection(String viewGroup)
	{		
	 	checkStringLengthRange(viewGroup,4, 40,VIEW_GROUP_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_SECTION ="section.link_to_url";
	public XingyouChecker checkLinkToUrlOfSection(String linkToUrl)
	{		
	 	checkStringLengthRange(linkToUrl,5, 68,LINK_TO_URL_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  PAGE_OF_SECTION ="section.page";
	public XingyouChecker checkPageIdOfSection(String pageId)
	{		
	 	checkIdOfSection(pageId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SECTION ="section.version";
	public XingyouChecker checkVersionOfSection(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public XingyouChecker checkIdOfUserDomain(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public XingyouChecker checkNameOfUserDomain(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public XingyouChecker checkVersionOfUserDomain(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public XingyouChecker checkIdOfUserWhiteList(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public XingyouChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public XingyouChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public XingyouChecker checkDomainIdOfUserWhiteList(String domainId)
	{		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public XingyouChecker checkVersionOfUserWhiteList(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public XingyouChecker checkIdOfSecUser(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public XingyouChecker checkLoginOfSecUser(String login)
	{		
	 	checkStringLengthRange(login,0, 256,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public XingyouChecker checkMobileOfSecUser(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public XingyouChecker checkEmailOfSecUser(String email)
	{		
	 	checkEmail(email,0, 256,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public XingyouChecker checkPwdOfSecUser(String pwd)
	{		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_OPENID_OF_SEC_USER ="sec_user.weixin_openid";
	public XingyouChecker checkWeixinOpenidOfSecUser(String weixinOpenid)
	{		
	 	checkStringLengthRange(weixinOpenid,0, 128,WEIXIN_OPENID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_APPID_OF_SEC_USER ="sec_user.weixin_appid";
	public XingyouChecker checkWeixinAppidOfSecUser(String weixinAppid)
	{		
	 	checkStringLengthRange(weixinAppid,0, 128,WEIXIN_APPID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ACCESS_TOKEN_OF_SEC_USER ="sec_user.access_token";
	public XingyouChecker checkAccessTokenOfSecUser(String accessToken)
	{		
	 	checkStringLengthRange(accessToken,0, 128,ACCESS_TOKEN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public XingyouChecker checkVerificationCodeOfSecUser(int verificationCode)
	{		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public XingyouChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public XingyouChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public XingyouChecker checkDomainIdOfSecUser(String domainId)
	{		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public XingyouChecker checkVersionOfSecUser(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_APP ="user_app.id";
	public XingyouChecker checkIdOfUserApp(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public XingyouChecker checkTitleOfUserApp(String title)
	{		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public XingyouChecker checkSecUserIdOfUserApp(String secUserId)
	{		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public XingyouChecker checkAppIconOfUserApp(String appIcon)
	{		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public XingyouChecker checkFullAccessOfUserApp(boolean fullAccess)
	{		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public XingyouChecker checkPermissionOfUserApp(String permission)
	{		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public XingyouChecker checkObjectTypeOfUserApp(String objectType)
	{		
	 	checkStringLengthRange(objectType,1, 100,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public XingyouChecker checkObjectIdOfUserApp(String objectId)
	{		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public XingyouChecker checkLocationOfUserApp(String location)
	{		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public XingyouChecker checkVersionOfUserApp(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  ID_OF_QUICK_LINK ="quick_link.id";
	public XingyouChecker checkIdOfQuickLink(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  NAME_OF_QUICK_LINK ="quick_link.name";
	public XingyouChecker checkNameOfQuickLink(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ICON_OF_QUICK_LINK ="quick_link.icon";
	public XingyouChecker checkIconOfQuickLink(String icon)
	{		
	 	checkStringLengthRange(icon,1, 200,ICON_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  IMAGE_PATH_OF_QUICK_LINK ="quick_link.image_path";
	public XingyouChecker checkImagePathOfQuickLink(String imagePath)
	{		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  LINK_TARGET_OF_QUICK_LINK ="quick_link.link_target";
	public XingyouChecker checkLinkTargetOfQuickLink(String linkTarget)
	{		
	 	checkStringLengthRange(linkTarget,1, 200,LINK_TARGET_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  APP_OF_QUICK_LINK ="quick_link.app";
	public XingyouChecker checkAppIdOfQuickLink(String appId)
	{		
	 	checkIdOfQuickLink(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_QUICK_LINK ="quick_link.version";
	public XingyouChecker checkVersionOfQuickLink(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public XingyouChecker checkIdOfListAccess(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public XingyouChecker checkNameOfListAccess(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public XingyouChecker checkInternalNameOfListAccess(String internalName)
	{		
	 	checkStringLengthRange(internalName,1, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public XingyouChecker checkReadPermissionOfListAccess(boolean readPermission)
	{		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public XingyouChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public XingyouChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public XingyouChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public XingyouChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public XingyouChecker checkAppIdOfListAccess(String appId)
	{		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public XingyouChecker checkVersionOfListAccess(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public XingyouChecker checkIdOfLoginHistory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public XingyouChecker checkFromIpOfLoginHistory(String fromIp)
	{		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public XingyouChecker checkDescriptionOfLoginHistory(String description)
	{		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public XingyouChecker checkSecUserIdOfLoginHistory(String secUserId)
	{		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public XingyouChecker checkVersionOfLoginHistory(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_CONTAINER ="candidate_container.id";
	public XingyouChecker checkIdOfCandidateContainer(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_CONTAINER ="candidate_container.name";
	public XingyouChecker checkNameOfCandidateContainer(String name)
	{		
	 	checkStringLengthRange(name,2, 28,NAME_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_CONTAINER ="candidate_container.version";
	public XingyouChecker checkVersionOfCandidateContainer(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_ELEMENT ="candidate_element.id";
	public XingyouChecker checkIdOfCandidateElement(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_ELEMENT ="candidate_element.name";
	public XingyouChecker checkNameOfCandidateElement(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_CANDIDATE_ELEMENT ="candidate_element.type";
	public XingyouChecker checkTypeOfCandidateElement(String type)
	{		
	 	checkStringLengthRange(type,1, 200,TYPE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  IMAGE_OF_CANDIDATE_ELEMENT ="candidate_element.image";
	public XingyouChecker checkImageOfCandidateElement(String image)
	{		
	 	checkImage(image,0, 512,IMAGE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  CONTAINER_OF_CANDIDATE_ELEMENT ="candidate_element.container";
	public XingyouChecker checkContainerIdOfCandidateElement(String containerId)
	{		
	 	checkIdOfCandidateElement(containerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_ELEMENT ="candidate_element.version";
	public XingyouChecker checkVersionOfCandidateElement(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.id";
	public XingyouChecker checkIdOfWechatWorkappIdentify(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  CORP_ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.corp_id";
	public XingyouChecker checkCorpIdOfWechatWorkappIdentify(String corpId)
	{		
	 	checkStringLengthRange(corpId,0, 100,CORP_ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  USER_ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.user_id";
	public XingyouChecker checkUserIdOfWechatWorkappIdentify(String userId)
	{		
	 	checkStringLengthRange(userId,1, 100,USER_ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.sec_user";
	public XingyouChecker checkSecUserIdOfWechatWorkappIdentify(String secUserId)
	{		
	 	checkIdOfWechatWorkappIdentify(secUserId ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.last_login_time";
	public XingyouChecker checkLastLoginTimeOfWechatWorkappIdentify(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2100-01-01T00:00:00"),LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.version";
	public XingyouChecker checkVersionOfWechatWorkappIdentify(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.id";
	public XingyouChecker checkIdOfWechatMiniappIdentify(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  OPEN_ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.open_id";
	public XingyouChecker checkOpenIdOfWechatMiniappIdentify(String openId)
	{		
	 	checkStringLengthRange(openId,5, 128,OPEN_ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  APP_ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.app_id";
	public XingyouChecker checkAppIdOfWechatMiniappIdentify(String appId)
	{		
	 	checkStringLengthRange(appId,5, 128,APP_ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.sec_user";
	public XingyouChecker checkSecUserIdOfWechatMiniappIdentify(String secUserId)
	{		
	 	checkIdOfWechatMiniappIdentify(secUserId ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.last_login_time";
	public XingyouChecker checkLastLoginTimeOfWechatMiniappIdentify(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2100-01-01T00:00:00"),LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.version";
	public XingyouChecker checkVersionOfWechatMiniappIdentify(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  ID_OF_KEYPAIR_IDENTIFY ="keypair_identify.id";
	public XingyouChecker checkIdOfKeypairIdentify(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_KEYPAIR_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  PUBLIC_KEY_OF_KEYPAIR_IDENTIFY ="keypair_identify.public_key";
	public XingyouChecker checkPublicKeyOfKeypairIdentify(String publicKey)
	{		
	 	checkLongtext(publicKey,0, 1048576,PUBLIC_KEY_OF_KEYPAIR_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  KEY_TYPE_OF_KEYPAIR_IDENTIFY ="keypair_identify.key_type";
	public XingyouChecker checkKeyTypeIdOfKeypairIdentify(String keyTypeId)
	{		
	 	checkIdOfKeypairIdentify(keyTypeId ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_KEYPAIR_IDENTIFY ="keypair_identify.sec_user";
	public XingyouChecker checkSecUserIdOfKeypairIdentify(String secUserId)
	{		
	 	checkIdOfKeypairIdentify(secUserId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_KEYPAIR_IDENTIFY ="keypair_identify.version";
	public XingyouChecker checkVersionOfKeypairIdentify(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_KEYPAIR_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  ID_OF_PUBLIC_KEY_TYPE ="public_key_type.id";
	public XingyouChecker checkIdOfPublicKeyType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PUBLIC_KEY_TYPE ="public_key_type.name";
	public XingyouChecker checkNameOfPublicKeyType(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_PUBLIC_KEY_TYPE ="public_key_type.code";
	public XingyouChecker checkCodeOfPublicKeyType(String code)
	{		
	 	checkStringLengthRange(code,1, 12,CODE_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_PUBLIC_KEY_TYPE ="public_key_type.domain";
	public XingyouChecker checkDomainIdOfPublicKeyType(String domainId)
	{		
	 	checkIdOfPublicKeyType(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PUBLIC_KEY_TYPE ="public_key_type.version";
	public XingyouChecker checkVersionOfPublicKeyType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_TREE_NODE ="tree_node.id";
	public XingyouChecker checkIdOfTreeNode(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  NODE_ID_OF_TREE_NODE ="tree_node.node_id";
	public XingyouChecker checkNodeIdOfTreeNode(String nodeId)
	{		
	 	checkStringLengthRange(nodeId,3, 40,NODE_ID_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  NODE_TYPE_OF_TREE_NODE ="tree_node.node_type";
	public XingyouChecker checkNodeTypeOfTreeNode(String nodeType)
	{		
	 	checkStringLengthRange(nodeType,3, 32,NODE_TYPE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  LEFT_VALUE_OF_TREE_NODE ="tree_node.left_value";
	public XingyouChecker checkLeftValueOfTreeNode(int leftValue)
	{		
	 	checkIntegerRange(leftValue,1, 10000000,LEFT_VALUE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  RIGHT_VALUE_OF_TREE_NODE ="tree_node.right_value";
	public XingyouChecker checkRightValueOfTreeNode(int rightValue)
	{		
	 	checkIntegerRange(rightValue,2, 10000000,RIGHT_VALUE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TREE_NODE ="tree_node.version";
	public XingyouChecker checkVersionOfTreeNode(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TREE_NODE ); 		
		
		return this;
	}	
}



















