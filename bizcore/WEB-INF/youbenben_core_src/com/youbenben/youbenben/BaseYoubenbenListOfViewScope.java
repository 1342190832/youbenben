package com.youbenben.youbenben;

import java.util.HashMap;
import java.util.Map;
import com.terapico.caf.viewpage.SerializeScope;

import com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenter;
import com.youbenben.youbenben.catalog.Catalog;
import com.youbenben.youbenben.levelonecategory.LevelOneCategory;
import com.youbenben.youbenben.leveltwocategory.LevelTwoCategory;
import com.youbenben.youbenben.levelthreecategory.LevelThreeCategory;
import com.youbenben.youbenben.product.Product;
import com.youbenben.youbenben.sku.Sku;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartment;
import com.youbenben.youbenben.citycenteremployee.CityCenterEmployee;
import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;
import com.youbenben.youbenben.citypartner.CityPartner;
import com.youbenben.youbenben.potentialcustomer.PotentialCustomer;
import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContact;
import com.youbenben.youbenben.cityevent.CityEvent;
import com.youbenben.youbenben.eventattendance.EventAttendance;
import com.youbenben.youbenben.mobileapp.MobileApp;
import com.youbenben.youbenben.page.Page;
import com.youbenben.youbenben.pagetype.PageType;
import com.youbenben.youbenben.slide.Slide;
import com.youbenben.youbenben.uiaction.UiAction;
import com.youbenben.youbenben.section.Section;
import com.youbenben.youbenben.userdomain.UserDomain;
import com.youbenben.youbenben.userwhitelist.UserWhiteList;
import com.youbenben.youbenben.secuser.SecUser;
import com.youbenben.youbenben.userapp.UserApp;
import com.youbenben.youbenben.quicklink.QuickLink;
import com.youbenben.youbenben.listaccess.ListAccess;
import com.youbenben.youbenben.loginhistory.LoginHistory;
import com.youbenben.youbenben.candidatecontainer.CandidateContainer;
import com.youbenben.youbenben.candidateelement.CandidateElement;
import com.youbenben.youbenben.wechatworkappidentify.WechatWorkappIdentify;
import com.youbenben.youbenben.wechatminiappidentify.WechatMiniappIdentify;
import com.youbenben.youbenben.keypairidentify.KeypairIdentify;
import com.youbenben.youbenben.publickeytype.PublicKeyType;
import com.youbenben.youbenben.treenode.TreeNode;


public class BaseYoubenbenListOfViewScope {

	/** FranchisedOutletProvinceCenter的简单属性序列化列表 */
	protected SerializeScope getFranchisedOutletProvinceCenterSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(FranchisedOutletProvinceCenter.ID_PROPERTY)
			.field(FranchisedOutletProvinceCenter.NAME_PROPERTY)
			.field(FranchisedOutletProvinceCenter.SERVICE_NUMBER_PROPERTY)
			.field(FranchisedOutletProvinceCenter.FOUNDED_PROPERTY)
			.field(FranchisedOutletProvinceCenter.WEB_SITE_PROPERTY)
			.field(FranchisedOutletProvinceCenter.ADDRESS_PROPERTY)
			.field(FranchisedOutletProvinceCenter.OPERATED_BY_PROPERTY)
			.field(FranchisedOutletProvinceCenter.LEGAL_REPRESENTATIVE_PROPERTY)
			.field(FranchisedOutletProvinceCenter.DESCRIPTION_PROPERTY)
			.field(FranchisedOutletProvinceCenter.VERSION_PROPERTY)
		;
	}

	/** Catalog的简单属性序列化列表 */
	protected SerializeScope getCatalogSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Catalog.ID_PROPERTY)
			.field(Catalog.NAME_PROPERTY)
			.field(Catalog.SUB_COUNT_PROPERTY)
			.field(Catalog.AMOUNT_PROPERTY)
			.field(Catalog.VERSION_PROPERTY)
		;
	}

	/** LevelOneCategory的简单属性序列化列表 */
	protected SerializeScope getLevelOneCategorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelOneCategory.ID_PROPERTY)
			.field(LevelOneCategory.NAME_PROPERTY)
			.field(LevelOneCategory.VERSION_PROPERTY)
		;
	}

	/** LevelTwoCategory的简单属性序列化列表 */
	protected SerializeScope getLevelTwoCategorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelTwoCategory.ID_PROPERTY)
			.field(LevelTwoCategory.NAME_PROPERTY)
			.field(LevelTwoCategory.VERSION_PROPERTY)
		;
	}

	/** LevelThreeCategory的简单属性序列化列表 */
	protected SerializeScope getLevelThreeCategorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelThreeCategory.ID_PROPERTY)
			.field(LevelThreeCategory.NAME_PROPERTY)
			.field(LevelThreeCategory.VERSION_PROPERTY)
		;
	}

	/** Product的简单属性序列化列表 */
	protected SerializeScope getProductSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Product.ID_PROPERTY)
			.field(Product.NAME_PROPERTY)
			.field(Product.ORIGIN_PROPERTY)
			.field(Product.REMARK_PROPERTY)
			.field(Product.BRAND_PROPERTY)
			.field(Product.PICTURE_PROPERTY)
			.field(Product.LAST_UPDATE_TIME_PROPERTY)
			.field(Product.VERSION_PROPERTY)
		;
	}

	/** Sku的简单属性序列化列表 */
	protected SerializeScope getSkuSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Sku.ID_PROPERTY)
			.field(Sku.NAME_PROPERTY)
			.field(Sku.SIZE_PROPERTY)
			.field(Sku.BARCODE_PROPERTY)
			.field(Sku.PACKAGE_TYPE_PROPERTY)
			.field(Sku.NET_CONTENT_PROPERTY)
			.field(Sku.PRICE_PROPERTY)
			.field(Sku.PICTURE_PROPERTY)
			.field(Sku.VERSION_PROPERTY)
		;
	}

	/** FranchisedOutletCityCenter的简单属性序列化列表 */
	protected SerializeScope getFranchisedOutletCityCenterSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(FranchisedOutletCityCenter.ID_PROPERTY)
			.field(FranchisedOutletCityCenter.NAME_PROPERTY)
			.field(FranchisedOutletCityCenter.FOUNDED_PROPERTY)
			.field(FranchisedOutletCityCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(FranchisedOutletCityCenter.VERSION_PROPERTY)
		;
	}

	/** CityCenterDepartment的简单属性序列化列表 */
	protected SerializeScope getCityCenterDepartmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CityCenterDepartment.ID_PROPERTY)
			.field(CityCenterDepartment.NAME_PROPERTY)
			.field(CityCenterDepartment.FOUNDED_PROPERTY)
			.field(CityCenterDepartment.MANAGER_PROPERTY)
			.field(CityCenterDepartment.VERSION_PROPERTY)
		;
	}

	/** CityCenterEmployee的简单属性序列化列表 */
	protected SerializeScope getCityCenterEmployeeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CityCenterEmployee.ID_PROPERTY)
			.field(CityCenterEmployee.NAME_PROPERTY)
			.field(CityCenterEmployee.MOBILE_PROPERTY)
			.field(CityCenterEmployee.EMAIL_PROPERTY)
			.field(CityCenterEmployee.FOUNDED_PROPERTY)
			.field(CityCenterEmployee.VERSION_PROPERTY)
		;
	}

	/** FranchisedOutletCityServiceCenter的简单属性序列化列表 */
	protected SerializeScope getFranchisedOutletCityServiceCenterSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(FranchisedOutletCityServiceCenter.ID_PROPERTY)
			.field(FranchisedOutletCityServiceCenter.NAME_PROPERTY)
			.field(FranchisedOutletCityServiceCenter.FOUNDED_PROPERTY)
			.field(FranchisedOutletCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(FranchisedOutletCityServiceCenter.VERSION_PROPERTY)
		;
	}

	/** CityPartner的简单属性序列化列表 */
	protected SerializeScope getCityPartnerSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CityPartner.ID_PROPERTY)
			.field(CityPartner.NAME_PROPERTY)
			.field(CityPartner.MOBILE_PROPERTY)
			.field(CityPartner.DESCRIPTION_PROPERTY)
			.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
			.field(CityPartner.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomer的简单属性序列化列表 */
	protected SerializeScope getPotentialCustomerSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomer.ID_PROPERTY)
			.field(PotentialCustomer.NAME_PROPERTY)
			.field(PotentialCustomer.MOBILE_PROPERTY)
			.field(PotentialCustomer.DESCRIPTION_PROPERTY)
			.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
			.field(PotentialCustomer.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomerContactPerson的简单属性序列化列表 */
	protected SerializeScope getPotentialCustomerContactPersonSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomerContactPerson.ID_PROPERTY)
			.field(PotentialCustomerContactPerson.NAME_PROPERTY)
			.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
			.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY)
			.field(PotentialCustomerContactPerson.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomerContact的简单属性序列化列表 */
	protected SerializeScope getPotentialCustomerContactSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomerContact.ID_PROPERTY)
			.field(PotentialCustomerContact.NAME_PROPERTY)
			.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
			.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
			.field(PotentialCustomerContact.DESCRIPTION_PROPERTY)
			.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
			.field(PotentialCustomerContact.VERSION_PROPERTY)
		;
	}

	/** CityEvent的简单属性序列化列表 */
	protected SerializeScope getCityEventSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CityEvent.ID_PROPERTY)
			.field(CityEvent.NAME_PROPERTY)
			.field(CityEvent.MOBILE_PROPERTY)
			.field(CityEvent.DESCRIPTION_PROPERTY)
			.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
			.field(CityEvent.VERSION_PROPERTY)
		;
	}

	/** EventAttendance的简单属性序列化列表 */
	protected SerializeScope getEventAttendanceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EventAttendance.ID_PROPERTY)
			.field(EventAttendance.NAME_PROPERTY)
			.field(EventAttendance.DESCRIPTION_PROPERTY)
			.field(EventAttendance.VERSION_PROPERTY)
		;
	}

	/** MobileApp的简单属性序列化列表 */
	protected SerializeScope getMobileAppSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(MobileApp.ID_PROPERTY)
			.field(MobileApp.NAME_PROPERTY)
			.field(MobileApp.VERSION_PROPERTY)
		;
	}

	/** Page的简单属性序列化列表 */
	protected SerializeScope getPageSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Page.ID_PROPERTY)
			.field(Page.PAGE_TITLE_PROPERTY)
			.field(Page.LINK_TO_URL_PROPERTY)
			.field(Page.VERSION_PROPERTY)
		;
	}

	/** PageType的简单属性序列化列表 */
	protected SerializeScope getPageTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PageType.ID_PROPERTY)
			.field(PageType.NAME_PROPERTY)
			.field(PageType.CODE_PROPERTY)
			.field(PageType.FOOTER_TAB_PROPERTY)
			.field(PageType.VERSION_PROPERTY)
		;
	}

	/** Slide的简单属性序列化列表 */
	protected SerializeScope getSlideSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Slide.ID_PROPERTY)
			.field(Slide.DISPLAY_ORDER_PROPERTY)
			.field(Slide.NAME_PROPERTY)
			.field(Slide.IMAGE_URL_PROPERTY)
			.field(Slide.VIDEO_URL_PROPERTY)
			.field(Slide.LINK_TO_URL_PROPERTY)
			.field(Slide.VERSION_PROPERTY)
		;
	}

	/** UiAction的简单属性序列化列表 */
	protected SerializeScope getUiActionSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(UiAction.ID_PROPERTY)
			.field(UiAction.CODE_PROPERTY)
			.field(UiAction.ICON_PROPERTY)
			.field(UiAction.TITLE_PROPERTY)
			.field(UiAction.BRIEF_PROPERTY)
			.field(UiAction.IMAGE_URL_PROPERTY)
			.field(UiAction.LINK_TO_URL_PROPERTY)
			.field(UiAction.EXTRA_DATA_PROPERTY)
			.field(UiAction.VERSION_PROPERTY)
		;
	}

	/** Section的简单属性序列化列表 */
	protected SerializeScope getSectionSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Section.ID_PROPERTY)
			.field(Section.TITLE_PROPERTY)
			.field(Section.BRIEF_PROPERTY)
			.field(Section.ICON_PROPERTY)
			.field(Section.VIEW_GROUP_PROPERTY)
			.field(Section.LINK_TO_URL_PROPERTY)
			.field(Section.VERSION_PROPERTY)
		;
	}

	/** UserDomain的简单属性序列化列表 */
	protected SerializeScope getUserDomainSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(UserDomain.ID_PROPERTY)
			.field(UserDomain.NAME_PROPERTY)
			.field(UserDomain.VERSION_PROPERTY)
		;
	}

	/** UserWhiteList的简单属性序列化列表 */
	protected SerializeScope getUserWhiteListSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(UserWhiteList.ID_PROPERTY)
			.field(UserWhiteList.USER_IDENTITY_PROPERTY)
			.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
			.field(UserWhiteList.VERSION_PROPERTY)
		;
	}

	/** SecUser的简单属性序列化列表 */
	protected SerializeScope getSecUserSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SecUser.ID_PROPERTY)
			.field(SecUser.LOGIN_PROPERTY)
			.field(SecUser.MOBILE_PROPERTY)
			.field(SecUser.EMAIL_PROPERTY)
			.field(SecUser.PWD_PROPERTY)
			.field(SecUser.WEIXIN_OPENID_PROPERTY)
			.field(SecUser.WEIXIN_APPID_PROPERTY)
			.field(SecUser.ACCESS_TOKEN_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
			.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
			.field(SecUser.VERSION_PROPERTY)
		;
	}

	/** UserApp的简单属性序列化列表 */
	protected SerializeScope getUserAppSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(UserApp.ID_PROPERTY)
			.field(UserApp.TITLE_PROPERTY)
			.field(UserApp.APP_ICON_PROPERTY)
			.field(UserApp.FULL_ACCESS_PROPERTY)
			.field(UserApp.PERMISSION_PROPERTY)
			.field(UserApp.OBJECT_TYPE_PROPERTY)
			.field(UserApp.OBJECT_ID_PROPERTY)
			.field(UserApp.LOCATION_PROPERTY)
			.field(UserApp.VERSION_PROPERTY)
		;
	}

	/** QuickLink的简单属性序列化列表 */
	protected SerializeScope getQuickLinkSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(QuickLink.ID_PROPERTY)
			.field(QuickLink.NAME_PROPERTY)
			.field(QuickLink.ICON_PROPERTY)
			.field(QuickLink.IMAGE_PATH_PROPERTY)
			.field(QuickLink.LINK_TARGET_PROPERTY)
			.field(QuickLink.CREATE_TIME_PROPERTY)
			.field(QuickLink.VERSION_PROPERTY)
		;
	}

	/** ListAccess的简单属性序列化列表 */
	protected SerializeScope getListAccessSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ListAccess.ID_PROPERTY)
			.field(ListAccess.NAME_PROPERTY)
			.field(ListAccess.INTERNAL_NAME_PROPERTY)
			.field(ListAccess.READ_PERMISSION_PROPERTY)
			.field(ListAccess.CREATE_PERMISSION_PROPERTY)
			.field(ListAccess.DELETE_PERMISSION_PROPERTY)
			.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
			.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
			.field(ListAccess.VERSION_PROPERTY)
		;
	}

	/** LoginHistory的简单属性序列化列表 */
	protected SerializeScope getLoginHistorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LoginHistory.ID_PROPERTY)
			.field(LoginHistory.LOGIN_TIME_PROPERTY)
			.field(LoginHistory.FROM_IP_PROPERTY)
			.field(LoginHistory.DESCRIPTION_PROPERTY)
			.field(LoginHistory.VERSION_PROPERTY)
		;
	}

	/** CandidateContainer的简单属性序列化列表 */
	protected SerializeScope getCandidateContainerSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CandidateContainer.ID_PROPERTY)
			.field(CandidateContainer.NAME_PROPERTY)
			.field(CandidateContainer.VERSION_PROPERTY)
		;
	}

	/** CandidateElement的简单属性序列化列表 */
	protected SerializeScope getCandidateElementSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CandidateElement.ID_PROPERTY)
			.field(CandidateElement.NAME_PROPERTY)
			.field(CandidateElement.TYPE_PROPERTY)
			.field(CandidateElement.IMAGE_PROPERTY)
			.field(CandidateElement.VERSION_PROPERTY)
		;
	}

	/** WechatWorkappIdentify的简单属性序列化列表 */
	protected SerializeScope getWechatWorkappIdentifySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(WechatWorkappIdentify.ID_PROPERTY)
			.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
			.field(WechatWorkappIdentify.USER_ID_PROPERTY)
			.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatWorkappIdentify.VERSION_PROPERTY)
		;
	}

	/** WechatMiniappIdentify的简单属性序列化列表 */
	protected SerializeScope getWechatMiniappIdentifySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(WechatMiniappIdentify.ID_PROPERTY)
			.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
			.field(WechatMiniappIdentify.APP_ID_PROPERTY)
			.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatMiniappIdentify.VERSION_PROPERTY)
		;
	}

	/** KeypairIdentify的简单属性序列化列表 */
	protected SerializeScope getKeypairIdentifySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(KeypairIdentify.ID_PROPERTY)
			.field(KeypairIdentify.PUBLIC_KEY_PROPERTY)
			.field(KeypairIdentify.CREATE_TIME_PROPERTY)
			.field(KeypairIdentify.VERSION_PROPERTY)
		;
	}

	/** PublicKeyType的简单属性序列化列表 */
	protected SerializeScope getPublicKeyTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PublicKeyType.ID_PROPERTY)
			.field(PublicKeyType.NAME_PROPERTY)
			.field(PublicKeyType.CODE_PROPERTY)
			.field(PublicKeyType.VERSION_PROPERTY)
		;
	}

	/** TreeNode的简单属性序列化列表 */
	protected SerializeScope getTreeNodeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TreeNode.ID_PROPERTY)
			.field(TreeNode.NODE_ID_PROPERTY)
			.field(TreeNode.NODE_TYPE_PROPERTY)
			.field(TreeNode.LEFT_VALUE_PROPERTY)
			.field(TreeNode.RIGHT_VALUE_PROPERTY)
			.field(TreeNode.VERSION_PROPERTY)
		;
	}

	/** FranchisedOutletProvinceCenter的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFranchisedOutletProvinceCenterListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='油奔奔山东运营中心|油奔奔北京运营中心|油奔奔河北运营中心|油奔奔天津运营中心';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='山东运营中心正式成立，恭喜恭喜';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(FranchisedOutletProvinceCenter.ID_PROPERTY)
			.field(FranchisedOutletProvinceCenter.NAME_PROPERTY).as("title")
			.field(FranchisedOutletProvinceCenter.SERVICE_NUMBER_PROPERTY)
			.field(FranchisedOutletProvinceCenter.FOUNDED_PROPERTY)
			.field(FranchisedOutletProvinceCenter.WEB_SITE_PROPERTY)
			.field(FranchisedOutletProvinceCenter.ADDRESS_PROPERTY)
			.field(FranchisedOutletProvinceCenter.OPERATED_BY_PROPERTY)
			.field(FranchisedOutletProvinceCenter.LEGAL_REPRESENTATIVE_PROPERTY)
			.field(FranchisedOutletProvinceCenter.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(FranchisedOutletProvinceCenter.VERSION_PROPERTY)
		;
	}

	/** Catalog的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCatalogListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='饲料|柴油|其他';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='amount';
		//	type='money';
		//	value='$10.11';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Catalog.ID_PROPERTY)
			.field(Catalog.NAME_PROPERTY).as("title")
			.field(Catalog.OWNER_PROPERTY, getFranchisedOutletProvinceCenterSummaryScope())
			.field(Catalog.SUB_COUNT_PROPERTY)
			.field(Catalog.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(Catalog.VERSION_PROPERTY)
		;
	}

	/** LevelOneCategory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelOneCategoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='饲料|柴油';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelOneCategory.ID_PROPERTY)
			.field(LevelOneCategory.CATALOG_PROPERTY, getCatalogSummaryScope())
			.field(LevelOneCategory.NAME_PROPERTY).as("title")
			.field(LevelOneCategory.VERSION_PROPERTY)
		;
	}

	/** LevelTwoCategory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelTwoCategoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='饲料|柴油';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelTwoCategory.ID_PROPERTY)
			.field(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, getLevelOneCategorySummaryScope())
			.field(LevelTwoCategory.NAME_PROPERTY).as("title")
			.field(LevelTwoCategory.VERSION_PROPERTY)
		;
	}

	/** LevelThreeCategory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelThreeCategoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='饲料|柴油';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelThreeCategory.ID_PROPERTY)
			.field(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, getLevelTwoCategorySummaryScope())
			.field(LevelThreeCategory.NAME_PROPERTY).as("title")
			.field(LevelThreeCategory.VERSION_PROPERTY)
		;
	}

	/** Product的ListOf时需要序列化的属性列表 */
	protected SerializeScope getProductListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='饲料|柴油|怡宝矿泉水|其他';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='origin';
		//	type='string';
		//	value='山东|广东|江苏|安徽';
		//	required='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='picture';
		//	type='string_image';
		//	value='this is a looooooooooog.jpg';
		//	required='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Product.ID_PROPERTY)
			.field(Product.NAME_PROPERTY).as("title")
			.field(Product.PARENT_CATEGORY_PROPERTY, getLevelThreeCategorySummaryScope())
			.field(Product.ORIGIN_PROPERTY).as("brief").with_prefix("产地: ")
			.field(Product.REMARK_PROPERTY)
			.field(Product.BRAND_PROPERTY)
			.field(Product.PICTURE_PROPERTY).as("imageUrl")
			.field(Product.LAST_UPDATE_TIME_PROPERTY)
			.field(Product.VERSION_PROPERTY)
		;
	}

	/** Sku的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSkuListOfViewScope() {
		// DisplayMode{name='product', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='矿泉水-大罐的';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='net_content';
		//	type='string';
		//	value='包装数量等信息,包装数量等信息,包装数量等信息';
		//	required='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='picture';
		//	type='string_image';
		//	value='coco.jpg';
		//	required='true';
		//}
		//, imageListField=null, propList=[DisplayProperty{name='listPrice', level=null}]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Sku.ID_PROPERTY)
			.field(Sku.NAME_PROPERTY).as("title")
			.field(Sku.SIZE_PROPERTY)
			.field(Sku.PRODUCT_PROPERTY, getProductSummaryScope())
			.field(Sku.BARCODE_PROPERTY)
			.field(Sku.PACKAGE_TYPE_PROPERTY)
			.field(Sku.NET_CONTENT_PROPERTY).as("brief").with_prefix("净含量: ")
			.field(Sku.PRICE_PROPERTY).as("listPrice")
			.field(Sku.PICTURE_PROPERTY).as("imageUrl")
			.field(Sku.VERSION_PROPERTY)
		;
	}

	/** FranchisedOutletCityCenter的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFranchisedOutletCityCenterListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='油奔奔济南市运营中心|油奔奔菏泽市运营中心';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='founded';
		//	type='date_past';
		//	value='past()';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(FranchisedOutletCityCenter.ID_PROPERTY)
			.field(FranchisedOutletCityCenter.NAME_PROPERTY).as("title")
			.field(FranchisedOutletCityCenter.FOUNDED_PROPERTY).as("brief").with_prefix("成立: ")
			.field(FranchisedOutletCityCenter.CITY_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
			.field(FranchisedOutletCityCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(FranchisedOutletCityCenter.VERSION_PROPERTY)
		;
	}

	/** CityCenterDepartment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCityCenterDepartmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='供应链部|采购部|管理部|财务部|法务部|市场部|人力资源部';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='manager';
		//	type='string';
		//	value='张三|李四';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CityCenterDepartment.ID_PROPERTY)
			.field(CityCenterDepartment.NAME_PROPERTY).as("title")
			.field(CityCenterDepartment.FOUNDED_PROPERTY)
			.field(CityCenterDepartment.CITY_CENTER_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
			.field(CityCenterDepartment.MANAGER_PROPERTY).as("brief").with_prefix("经理: ")
			.field(CityCenterDepartment.VERSION_PROPERTY)
		;
	}

	/** CityCenterEmployee的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCityCenterEmployeeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='张三|李四';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='mobile';
		//	type='string_china_mobile_phone';
		//	value='13999998888';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CityCenterEmployee.ID_PROPERTY)
			.field(CityCenterEmployee.NAME_PROPERTY).as("title")
			.field(CityCenterEmployee.MOBILE_PROPERTY).as("brief").with_prefix("手机号码: ")
			.field(CityCenterEmployee.EMAIL_PROPERTY)
			.field(CityCenterEmployee.FOUNDED_PROPERTY)
			.field(CityCenterEmployee.DEPARTMENT_PROPERTY, getCityCenterDepartmentSummaryScope())
			.field(CityCenterEmployee.CITY_CENTER_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
			.field(CityCenterEmployee.VERSION_PROPERTY)
		;
	}

	/** FranchisedOutletCityServiceCenter的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFranchisedOutletCityServiceCenterListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='油奔奔济南|油奔奔菏泽';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='founded';
		//	type='date_past';
		//	value='past()';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(FranchisedOutletCityServiceCenter.ID_PROPERTY)
			.field(FranchisedOutletCityServiceCenter.NAME_PROPERTY).as("title")
			.field(FranchisedOutletCityServiceCenter.FOUNDED_PROPERTY).as("brief").with_prefix("成立: ")
			.field(FranchisedOutletCityServiceCenter.BELONGS_TO_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
			.field(FranchisedOutletCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(FranchisedOutletCityServiceCenter.VERSION_PROPERTY)
		;
	}

	/** CityPartner的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCityPartnerListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='曾倩|黄风格|郭超';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='负责开拓市场，具有极强的开拓能力';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CityPartner.ID_PROPERTY)
			.field(CityPartner.NAME_PROPERTY).as("title")
			.field(CityPartner.MOBILE_PROPERTY)
			.field(CityPartner.TOWN_SERVICE_CENTER_PROPERTY, getFranchisedOutletCityServiceCenterSummaryScope())
			.field(CityPartner.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
			.field(CityPartner.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomer的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPotentialCustomerListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='曾倩|黄风格|郭超';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='负责开拓市场，具有极强的开拓能力';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomer.ID_PROPERTY)
			.field(PotentialCustomer.NAME_PROPERTY).as("title")
			.field(PotentialCustomer.MOBILE_PROPERTY)
			.field(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, getFranchisedOutletCityServiceCenterSummaryScope())
			.field(PotentialCustomer.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
			.field(PotentialCustomer.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
			.field(PotentialCustomer.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomerContactPerson的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPotentialCustomerContactPersonListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='赵先生';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='这人在决策中战友较大的权重，密切观察中.....';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomerContactPerson.ID_PROPERTY)
			.field(PotentialCustomerContactPerson.NAME_PROPERTY).as("title")
			.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
			.field(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
			.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(PotentialCustomerContactPerson.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomerContact的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPotentialCustomerContactListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='和连载客户的联系记录';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='转化希望很大';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomerContact.ID_PROPERTY)
			.field(PotentialCustomerContact.NAME_PROPERTY).as("title")
			.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
			.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
			.field(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
			.field(PotentialCustomerContact.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
			.field(PotentialCustomerContact.CONTACT_TO_PROPERTY, getPotentialCustomerContactPersonSummaryScope())
			.field(PotentialCustomerContact.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
			.field(PotentialCustomerContact.VERSION_PROPERTY)
		;
	}

	/** CityEvent的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCityEventListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='油奔奔见面会|油奔奔说明会';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='给大家讲解油奔奔的发展蓝图';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CityEvent.ID_PROPERTY)
			.field(CityEvent.NAME_PROPERTY).as("title")
			.field(CityEvent.MOBILE_PROPERTY)
			.field(CityEvent.CITY_SERVICE_CENTER_PROPERTY, getFranchisedOutletCityServiceCenterSummaryScope())
			.field(CityEvent.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
			.field(CityEvent.VERSION_PROPERTY)
		;
	}

	/** EventAttendance的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEventAttendanceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='油奔奔见面会参加信息';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='体会不错，考虑加盟';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EventAttendance.ID_PROPERTY)
			.field(EventAttendance.NAME_PROPERTY).as("title")
			.field(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
			.field(EventAttendance.CITY_EVENT_PROPERTY, getCityEventSummaryScope())
			.field(EventAttendance.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(EventAttendance.VERSION_PROPERTY)
		;
	}

	/** MobileApp的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMobileAppListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='移动端配置';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(MobileApp.ID_PROPERTY)
			.field(MobileApp.NAME_PROPERTY).as("title")
			.field(MobileApp.VERSION_PROPERTY)
		;
	}

	/** Page的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPageListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='page_title';
		//	type='string';
		//	value='首页';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='page_type';
		//	type='page_type';
		//	value='$(object)';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Page.ID_PROPERTY)
			.field(Page.PAGE_TITLE_PROPERTY).as("title")
			.field(Page.LINK_TO_URL_PROPERTY)
			.field(Page.PAGE_TYPE_PROPERTY, SerializeScope.INCLUDE()
				.field(PageType.NAME_PROPERTY).as("brief").with_prefix("页面类型: ")
					).move_up()
			.field(Page.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
			.field(Page.VERSION_PROPERTY)
		;
	}

	/** PageType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPageTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='首页|我的|Generic Page|Listof Page|功能大厅|普通';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='home|me|generic-page|listof-page|service-center|simple';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PageType.ID_PROPERTY)
			.field(PageType.NAME_PROPERTY).as("title")
			.field(PageType.CODE_PROPERTY).as("brief").with_prefix("编码: ")
			.field(PageType.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
			.field(PageType.FOOTER_TAB_PROPERTY)
			.field(PageType.VERSION_PROPERTY)
		;
	}

	/** Slide的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSlideListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='首页Focus的内容';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='display_order';
		//	type='int';
		//	value='1|2|3';
		//	required='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_url';
		//	type='string_image';
		//	value='https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg';
		//	required='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Slide.ID_PROPERTY)
			.field(Slide.DISPLAY_ORDER_PROPERTY).as("brief").with_prefix("顺序: ")
			.field(Slide.NAME_PROPERTY).as("title")
			.field(Slide.IMAGE_URL_PROPERTY).as("imageUrl")
			.field(Slide.VIDEO_URL_PROPERTY)
			.field(Slide.LINK_TO_URL_PROPERTY)
			.field(Slide.PAGE_PROPERTY, getPageSummaryScope())
			.field(Slide.VERSION_PROPERTY)
		;
	}

	/** UiAction的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUiActionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='提交|分享|查看|更多';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='brief';
		//	type='string';
		//	value='Submit|Share|View|View More';
		//	required='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_url';
		//	type='string_image';
		//	value='https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg';
		//	required='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(UiAction.ID_PROPERTY)
			.field(UiAction.CODE_PROPERTY)
			.field(UiAction.ICON_PROPERTY)
			.field(UiAction.TITLE_PROPERTY).as("title")
			.field(UiAction.BRIEF_PROPERTY).as("brief").with_prefix("短暂的: ")
			.field(UiAction.IMAGE_URL_PROPERTY).as("imageUrl")
			.field(UiAction.LINK_TO_URL_PROPERTY)
			.field(UiAction.EXTRA_DATA_PROPERTY)
			.field(UiAction.PAGE_PROPERTY, getPageSummaryScope())
			.field(UiAction.VERSION_PROPERTY)
		;
	}

	/** Section的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSectionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='文章|作品';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='brief';
		//	type='string';
		//	value='Article|Artwork';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Section.ID_PROPERTY)
			.field(Section.TITLE_PROPERTY).as("title")
			.field(Section.BRIEF_PROPERTY).as("brief").with_prefix("短暂的: ")
			.field(Section.ICON_PROPERTY)
			.field(Section.VIEW_GROUP_PROPERTY)
			.field(Section.LINK_TO_URL_PROPERTY)
			.field(Section.PAGE_PROPERTY, getPageSummaryScope())
			.field(Section.VERSION_PROPERTY)
		;
	}

	/** UserDomain的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserDomainListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='用户区域';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(UserDomain.ID_PROPERTY)
			.field(UserDomain.NAME_PROPERTY).as("title")
			.field(UserDomain.VERSION_PROPERTY)
		;
	}

	/** UserWhiteList的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserWhiteListListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='user_identity';
		//	type='string';
		//	value='clariones|13808188512';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='user_special_functions';
		//	type='string';
		//	value='tester;ios-spokesperson';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(UserWhiteList.ID_PROPERTY)
			.field(UserWhiteList.USER_IDENTITY_PROPERTY).as("title")
			.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY).as("brief").with_prefix("用户特殊功能: ")
			.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(UserWhiteList.VERSION_PROPERTY)
		;
	}

	/** SecUser的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSecUserListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='login';
		//	type='string';
		//	value='login';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='verification_code';
		//	type='int';
		//	value='0|9999999';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SecUser.ID_PROPERTY)
			.field(SecUser.LOGIN_PROPERTY).as("title")
			.field(SecUser.MOBILE_PROPERTY)
			.field(SecUser.EMAIL_PROPERTY)
			.field(SecUser.PWD_PROPERTY)
			.field(SecUser.WEIXIN_OPENID_PROPERTY)
			.field(SecUser.WEIXIN_APPID_PROPERTY)
			.field(SecUser.ACCESS_TOKEN_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_PROPERTY).as("brief").with_prefix("验证码: ")
			.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
			.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
			.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(SecUser.VERSION_PROPERTY)
		;
	}

	/** UserApp的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserAppListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='审车平台|账户管理|接车公司|审车公司|维修公司|顾客';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='app_icon';
		//	type='string';
		//	value='users|bank|wechat|bar-chart|user|users';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(UserApp.ID_PROPERTY)
			.field(UserApp.TITLE_PROPERTY).as("title")
			.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(UserApp.APP_ICON_PROPERTY).as("brief").with_prefix("应用程序图标: ")
			.field(UserApp.FULL_ACCESS_PROPERTY)
			.field(UserApp.PERMISSION_PROPERTY)
			.field(UserApp.OBJECT_TYPE_PROPERTY)
			.field(UserApp.OBJECT_ID_PROPERTY)
			.field(UserApp.LOCATION_PROPERTY)
			.field(UserApp.VERSION_PROPERTY)
		;
	}

	/** QuickLink的ListOf时需要序列化的属性列表 */
	protected SerializeScope getQuickLinkListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='列表';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='icon';
		//	type='string';
		//	value='facebook|google';
		//	required='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_path';
		//	type='string_image';
		//	value='y-200-200-red.jpg';
		//	required='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(QuickLink.ID_PROPERTY)
			.field(QuickLink.NAME_PROPERTY).as("title")
			.field(QuickLink.ICON_PROPERTY).as("brief").with_prefix("图标: ")
			.field(QuickLink.IMAGE_PATH_PROPERTY).as("imageUrl")
			.field(QuickLink.LINK_TARGET_PROPERTY)
			.field(QuickLink.CREATE_TIME_PROPERTY)
			.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
			.field(QuickLink.VERSION_PROPERTY)
		;
	}

	/** ListAccess的ListOf时需要序列化的属性列表 */
	protected SerializeScope getListAccessListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='列表';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='internal_name';
		//	type='string';
		//	value='levelOneCategoryList';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ListAccess.ID_PROPERTY)
			.field(ListAccess.NAME_PROPERTY).as("title")
			.field(ListAccess.INTERNAL_NAME_PROPERTY).as("brief").with_prefix("内部名称: ")
			.field(ListAccess.READ_PERMISSION_PROPERTY)
			.field(ListAccess.CREATE_PERMISSION_PROPERTY)
			.field(ListAccess.DELETE_PERMISSION_PROPERTY)
			.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
			.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
			.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
			.field(ListAccess.VERSION_PROPERTY)
		;
	}

	/** LoginHistory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLoginHistoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='from_ip';
		//	type='string';
		//	value='192.168.1.1|192.168.1.2';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='登陆成功';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LoginHistory.ID_PROPERTY)
			.field(LoginHistory.LOGIN_TIME_PROPERTY)
			.field(LoginHistory.FROM_IP_PROPERTY).as("title")
			.field(LoginHistory.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(LoginHistory.VERSION_PROPERTY)
		;
	}

	/** CandidateContainer的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCandidateContainerListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='我只是一个容器';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CandidateContainer.ID_PROPERTY)
			.field(CandidateContainer.NAME_PROPERTY).as("title")
			.field(CandidateContainer.VERSION_PROPERTY)
		;
	}

	/** CandidateElement的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCandidateElementListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='搜索到的匹配字段';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='type';
		//	type='string';
		//	value='类型描述';
		//	required='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image';
		//	type='string_image';
		//	value='1.jpg';
		//	required='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CandidateElement.ID_PROPERTY)
			.field(CandidateElement.NAME_PROPERTY).as("title")
			.field(CandidateElement.TYPE_PROPERTY).as("brief").with_prefix("类型: ")
			.field(CandidateElement.IMAGE_PROPERTY).as("imageUrl")
			.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
			.field(CandidateElement.VERSION_PROPERTY)
		;
	}

	/** WechatWorkappIdentify的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWechatWorkappIdentifyListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='corp_id';
		//	type='string';
		//	value='corporation123';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='user_id';
		//	type='string';
		//	value='user123';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(WechatWorkappIdentify.ID_PROPERTY)
			.field(WechatWorkappIdentify.CORP_ID_PROPERTY).as("title")
			.field(WechatWorkappIdentify.USER_ID_PROPERTY).as("brief").with_prefix("用户Id: ")
			.field(WechatWorkappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatWorkappIdentify.VERSION_PROPERTY)
		;
	}

	/** WechatMiniappIdentify的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWechatMiniappIdentifyListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='open_id';
		//	type='string';
		//	value='wechat_open_id_1234567890';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='app_id';
		//	type='string';
		//	value='wechat_miniapp_id_1234567890';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(WechatMiniappIdentify.ID_PROPERTY)
			.field(WechatMiniappIdentify.OPEN_ID_PROPERTY).as("title")
			.field(WechatMiniappIdentify.APP_ID_PROPERTY).as("brief").with_prefix("应用程序Id: ")
			.field(WechatMiniappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatMiniappIdentify.VERSION_PROPERTY)
		;
	}

	/** KeypairIdentify的ListOf时需要序列化的属性列表 */
	protected SerializeScope getKeypairIdentifyListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='public_key';
		//	type='string_longtext';
		//	value='text()';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(KeypairIdentify.ID_PROPERTY)
			.field(KeypairIdentify.PUBLIC_KEY_PROPERTY).as("title")
			.field(KeypairIdentify.KEY_TYPE_PROPERTY, getPublicKeyTypeSummaryScope())
			.field(KeypairIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(KeypairIdentify.CREATE_TIME_PROPERTY)
			.field(KeypairIdentify.VERSION_PROPERTY)
		;
	}

	/** PublicKeyType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPublicKeyTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='rsa|ecc';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='rsa|ecc';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PublicKeyType.ID_PROPERTY)
			.field(PublicKeyType.NAME_PROPERTY).as("title")
			.field(PublicKeyType.CODE_PROPERTY).as("brief").with_prefix("编码: ")
			.field(PublicKeyType.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(PublicKeyType.VERSION_PROPERTY)
		;
	}

	/** TreeNode的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTreeNodeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='node_id';
		//	type='string';
		//	value='node000001';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='node_type';
		//	type='string';
		//	value='nodetype';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TreeNode.ID_PROPERTY)
			.field(TreeNode.NODE_ID_PROPERTY).as("title")
			.field(TreeNode.NODE_TYPE_PROPERTY).as("brief").with_prefix("节点类型: ")
			.field(TreeNode.LEFT_VALUE_PROPERTY)
			.field(TreeNode.RIGHT_VALUE_PROPERTY)
			.field(TreeNode.VERSION_PROPERTY)
		;
	}

	
	public SerializeScope getListOfViewScope(String listClassName, String ownerClassName) {
		return scopes.get(listClassName);
	}
	
	
	protected Map<String, SerializeScope> scopes;
	protected void initAllViewScope() {
		scopes = new HashMap<>();
		scopes.put(FranchisedOutletProvinceCenter.class.getName(),getFranchisedOutletProvinceCenterListOfViewScope());
		scopes.put(Catalog.class.getName(),getCatalogListOfViewScope());
		scopes.put(LevelOneCategory.class.getName(),getLevelOneCategoryListOfViewScope());
		scopes.put(LevelTwoCategory.class.getName(),getLevelTwoCategoryListOfViewScope());
		scopes.put(LevelThreeCategory.class.getName(),getLevelThreeCategoryListOfViewScope());
		scopes.put(Product.class.getName(),getProductListOfViewScope());
		scopes.put(Sku.class.getName(),getSkuListOfViewScope());
		scopes.put(FranchisedOutletCityCenter.class.getName(),getFranchisedOutletCityCenterListOfViewScope());
		scopes.put(CityCenterDepartment.class.getName(),getCityCenterDepartmentListOfViewScope());
		scopes.put(CityCenterEmployee.class.getName(),getCityCenterEmployeeListOfViewScope());
		scopes.put(FranchisedOutletCityServiceCenter.class.getName(),getFranchisedOutletCityServiceCenterListOfViewScope());
		scopes.put(CityPartner.class.getName(),getCityPartnerListOfViewScope());
		scopes.put(PotentialCustomer.class.getName(),getPotentialCustomerListOfViewScope());
		scopes.put(PotentialCustomerContactPerson.class.getName(),getPotentialCustomerContactPersonListOfViewScope());
		scopes.put(PotentialCustomerContact.class.getName(),getPotentialCustomerContactListOfViewScope());
		scopes.put(CityEvent.class.getName(),getCityEventListOfViewScope());
		scopes.put(EventAttendance.class.getName(),getEventAttendanceListOfViewScope());
		scopes.put(MobileApp.class.getName(),getMobileAppListOfViewScope());
		scopes.put(Page.class.getName(),getPageListOfViewScope());
		scopes.put(PageType.class.getName(),getPageTypeListOfViewScope());
		scopes.put(Slide.class.getName(),getSlideListOfViewScope());
		scopes.put(UiAction.class.getName(),getUiActionListOfViewScope());
		scopes.put(Section.class.getName(),getSectionListOfViewScope());
		scopes.put(UserDomain.class.getName(),getUserDomainListOfViewScope());
		scopes.put(UserWhiteList.class.getName(),getUserWhiteListListOfViewScope());
		scopes.put(SecUser.class.getName(),getSecUserListOfViewScope());
		scopes.put(UserApp.class.getName(),getUserAppListOfViewScope());
		scopes.put(QuickLink.class.getName(),getQuickLinkListOfViewScope());
		scopes.put(ListAccess.class.getName(),getListAccessListOfViewScope());
		scopes.put(LoginHistory.class.getName(),getLoginHistoryListOfViewScope());
		scopes.put(CandidateContainer.class.getName(),getCandidateContainerListOfViewScope());
		scopes.put(CandidateElement.class.getName(),getCandidateElementListOfViewScope());
		scopes.put(WechatWorkappIdentify.class.getName(),getWechatWorkappIdentifyListOfViewScope());
		scopes.put(WechatMiniappIdentify.class.getName(),getWechatMiniappIdentifyListOfViewScope());
		scopes.put(KeypairIdentify.class.getName(),getKeypairIdentifyListOfViewScope());
		scopes.put(PublicKeyType.class.getName(),getPublicKeyTypeListOfViewScope());
		scopes.put(TreeNode.class.getName(),getTreeNodeListOfViewScope());
	}

}
















