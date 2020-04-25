package com.youbenben.youbenben;


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


public class YoubenbenBaseViewScope {

	protected static SerializeScope FranchisedOutletProvinceCenterBaseSummaryScope = SerializeScope.INCLUDE()
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
		;
	/** 用于FranchisedOutletProvinceCenter的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletProvinceCenterSummaryScope() {
		return FranchisedOutletProvinceCenterBaseSummaryScope;
	}

	protected static SerializeScope CatalogBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Catalog.ID_PROPERTY)
		.field(Catalog.NAME_PROPERTY)
		.field(Catalog.SUB_COUNT_PROPERTY)
		.field(Catalog.AMOUNT_PROPERTY)
		;
	/** 用于Catalog的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCatalogSummaryScope() {
		return CatalogBaseSummaryScope;
	}

	protected static SerializeScope LevelOneCategoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelOneCategory.ID_PROPERTY)
		.field(LevelOneCategory.NAME_PROPERTY)
		;
	/** 用于LevelOneCategory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelOneCategorySummaryScope() {
		return LevelOneCategoryBaseSummaryScope;
	}

	protected static SerializeScope LevelTwoCategoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoCategory.ID_PROPERTY)
		.field(LevelTwoCategory.NAME_PROPERTY)
		;
	/** 用于LevelTwoCategory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoCategorySummaryScope() {
		return LevelTwoCategoryBaseSummaryScope;
	}

	protected static SerializeScope LevelThreeCategoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeCategory.ID_PROPERTY)
		.field(LevelThreeCategory.NAME_PROPERTY)
		;
	/** 用于LevelThreeCategory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeCategorySummaryScope() {
		return LevelThreeCategoryBaseSummaryScope;
	}

	protected static SerializeScope ProductBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Product.ID_PROPERTY)
		.field(Product.NAME_PROPERTY)
		.field(Product.ORIGIN_PROPERTY)
		.field(Product.REMARK_PROPERTY)
		.field(Product.BRAND_PROPERTY)
		.field(Product.PICTURE_PROPERTY)
		.field(Product.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于Product的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProductSummaryScope() {
		return ProductBaseSummaryScope;
	}

	protected static SerializeScope SkuBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Sku.ID_PROPERTY)
		.field(Sku.NAME_PROPERTY)
		.field(Sku.SIZE_PROPERTY)
		.field(Sku.BARCODE_PROPERTY)
		.field(Sku.PACKAGE_TYPE_PROPERTY)
		.field(Sku.NET_CONTENT_PROPERTY)
		.field(Sku.PRICE_PROPERTY)
		.field(Sku.PICTURE_PROPERTY)
		;
	/** 用于Sku的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSkuSummaryScope() {
		return SkuBaseSummaryScope;
	}

	protected static SerializeScope FranchisedOutletCityCenterBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(FranchisedOutletCityCenter.ID_PROPERTY)
		.field(FranchisedOutletCityCenter.NAME_PROPERTY)
		.field(FranchisedOutletCityCenter.FOUNDED_PROPERTY)
		.field(FranchisedOutletCityCenter.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于FranchisedOutletCityCenter的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletCityCenterSummaryScope() {
		return FranchisedOutletCityCenterBaseSummaryScope;
	}

	protected static SerializeScope CityCenterDepartmentBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityCenterDepartment.ID_PROPERTY)
		.field(CityCenterDepartment.NAME_PROPERTY)
		.field(CityCenterDepartment.FOUNDED_PROPERTY)
		.field(CityCenterDepartment.MANAGER_PROPERTY)
		;
	/** 用于CityCenterDepartment的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityCenterDepartmentSummaryScope() {
		return CityCenterDepartmentBaseSummaryScope;
	}

	protected static SerializeScope CityCenterEmployeeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityCenterEmployee.ID_PROPERTY)
		.field(CityCenterEmployee.NAME_PROPERTY)
		.field(CityCenterEmployee.MOBILE_PROPERTY)
		.field(CityCenterEmployee.EMAIL_PROPERTY)
		.field(CityCenterEmployee.FOUNDED_PROPERTY)
		;
	/** 用于CityCenterEmployee的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityCenterEmployeeSummaryScope() {
		return CityCenterEmployeeBaseSummaryScope;
	}

	protected static SerializeScope FranchisedOutletCityServiceCenterBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(FranchisedOutletCityServiceCenter.ID_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.NAME_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.FOUNDED_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于FranchisedOutletCityServiceCenter的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletCityServiceCenterSummaryScope() {
		return FranchisedOutletCityServiceCenterBaseSummaryScope;
	}

	protected static SerializeScope CityPartnerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityPartner.ID_PROPERTY)
		.field(CityPartner.NAME_PROPERTY)
		.field(CityPartner.MOBILE_PROPERTY)
		.field(CityPartner.DESCRIPTION_PROPERTY)
		.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于CityPartner的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityPartnerSummaryScope() {
		return CityPartnerBaseSummaryScope;
	}

	protected static SerializeScope PotentialCustomerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomer.ID_PROPERTY)
		.field(PotentialCustomer.NAME_PROPERTY)
		.field(PotentialCustomer.MOBILE_PROPERTY)
		.field(PotentialCustomer.DESCRIPTION_PROPERTY)
		.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerSummaryScope() {
		return PotentialCustomerBaseSummaryScope;
	}

	protected static SerializeScope PotentialCustomerContactPersonBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContactPerson.ID_PROPERTY)
		.field(PotentialCustomerContactPerson.NAME_PROPERTY)
		.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
		.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY)
		;
	/** 用于PotentialCustomerContactPerson的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactPersonSummaryScope() {
		return PotentialCustomerContactPersonBaseSummaryScope;
	}

	protected static SerializeScope PotentialCustomerContactBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContact.ID_PROPERTY)
		.field(PotentialCustomerContact.NAME_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
		.field(PotentialCustomerContact.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomerContact的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactSummaryScope() {
		return PotentialCustomerContactBaseSummaryScope;
	}

	protected static SerializeScope CityEventBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityEvent.ID_PROPERTY)
		.field(CityEvent.NAME_PROPERTY)
		.field(CityEvent.MOBILE_PROPERTY)
		.field(CityEvent.DESCRIPTION_PROPERTY)
		.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于CityEvent的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityEventSummaryScope() {
		return CityEventBaseSummaryScope;
	}

	protected static SerializeScope EventAttendanceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(EventAttendance.ID_PROPERTY)
		.field(EventAttendance.NAME_PROPERTY)
		.field(EventAttendance.DESCRIPTION_PROPERTY)
		;
	/** 用于EventAttendance的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEventAttendanceSummaryScope() {
		return EventAttendanceBaseSummaryScope;
	}

	protected static SerializeScope MobileAppBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(MobileApp.ID_PROPERTY)
		.field(MobileApp.NAME_PROPERTY)
		;
	/** 用于MobileApp的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMobileAppSummaryScope() {
		return MobileAppBaseSummaryScope;
	}

	protected static SerializeScope PageBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Page.ID_PROPERTY)
		.field(Page.PAGE_TITLE_PROPERTY)
		.field(Page.LINK_TO_URL_PROPERTY)
		;
	/** 用于Page的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPageSummaryScope() {
		return PageBaseSummaryScope;
	}

	protected static SerializeScope PageTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PageType.ID_PROPERTY)
		.field(PageType.NAME_PROPERTY)
		.field(PageType.CODE_PROPERTY)
		.field(PageType.FOOTER_TAB_PROPERTY)
		;
	/** 用于PageType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPageTypeSummaryScope() {
		return PageTypeBaseSummaryScope;
	}

	protected static SerializeScope SlideBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Slide.ID_PROPERTY)
		.field(Slide.DISPLAY_ORDER_PROPERTY)
		.field(Slide.NAME_PROPERTY)
		.field(Slide.IMAGE_URL_PROPERTY)
		.field(Slide.VIDEO_URL_PROPERTY)
		.field(Slide.LINK_TO_URL_PROPERTY)
		;
	/** 用于Slide的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSlideSummaryScope() {
		return SlideBaseSummaryScope;
	}

	protected static SerializeScope UiActionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UiAction.ID_PROPERTY)
		.field(UiAction.CODE_PROPERTY)
		.field(UiAction.ICON_PROPERTY)
		.field(UiAction.TITLE_PROPERTY)
		.field(UiAction.BRIEF_PROPERTY)
		.field(UiAction.IMAGE_URL_PROPERTY)
		.field(UiAction.LINK_TO_URL_PROPERTY)
		.field(UiAction.EXTRA_DATA_PROPERTY)
		;
	/** 用于UiAction的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUiActionSummaryScope() {
		return UiActionBaseSummaryScope;
	}

	protected static SerializeScope SectionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Section.ID_PROPERTY)
		.field(Section.TITLE_PROPERTY)
		.field(Section.BRIEF_PROPERTY)
		.field(Section.ICON_PROPERTY)
		.field(Section.VIEW_GROUP_PROPERTY)
		.field(Section.LINK_TO_URL_PROPERTY)
		;
	/** 用于Section的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSectionSummaryScope() {
		return SectionBaseSummaryScope;
	}

	protected static SerializeScope UserDomainBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSummaryScope() {
		return UserDomainBaseSummaryScope;
	}

	protected static SerializeScope UserWhiteListBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSummaryScope() {
		return UserWhiteListBaseSummaryScope;
	}

	protected static SerializeScope SecUserBaseSummaryScope = SerializeScope.INCLUDE()
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
		;
	/** 用于SecUser的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserSummaryScope() {
		return SecUserBaseSummaryScope;
	}

	protected static SerializeScope UserAppBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppSummaryScope() {
		return UserAppBaseSummaryScope;
	}

	protected static SerializeScope QuickLinkBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSummaryScope() {
		return QuickLinkBaseSummaryScope;
	}

	protected static SerializeScope ListAccessBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessSummaryScope() {
		return ListAccessBaseSummaryScope;
	}

	protected static SerializeScope LoginHistoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySummaryScope() {
		return LoginHistoryBaseSummaryScope;
	}

	protected static SerializeScope CandidateContainerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSummaryScope() {
		return CandidateContainerBaseSummaryScope;
	}

	protected static SerializeScope CandidateElementBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSummaryScope() {
		return CandidateElementBaseSummaryScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifySummaryScope() {
		return WechatWorkappIdentifyBaseSummaryScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifySummaryScope() {
		return WechatMiniappIdentifyBaseSummaryScope;
	}

	protected static SerializeScope KeypairIdentifyBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(KeypairIdentify.ID_PROPERTY)
		.field(KeypairIdentify.PUBLIC_KEY_PROPERTY)
		.field(KeypairIdentify.CREATE_TIME_PROPERTY)
		;
	/** 用于KeypairIdentify的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getKeypairIdentifySummaryScope() {
		return KeypairIdentifyBaseSummaryScope;
	}

	protected static SerializeScope PublicKeyTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PublicKeyType.ID_PROPERTY)
		.field(PublicKeyType.NAME_PROPERTY)
		.field(PublicKeyType.CODE_PROPERTY)
		;
	/** 用于PublicKeyType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPublicKeyTypeSummaryScope() {
		return PublicKeyTypeBaseSummaryScope;
	}

	protected static SerializeScope TreeNodeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(TreeNode.ID_PROPERTY)
		.field(TreeNode.NODE_ID_PROPERTY)
		.field(TreeNode.NODE_TYPE_PROPERTY)
		.field(TreeNode.LEFT_VALUE_PROPERTY)
		.field(TreeNode.RIGHT_VALUE_PROPERTY)
		;
	/** 用于TreeNode的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTreeNodeSummaryScope() {
		return TreeNodeBaseSummaryScope;
	}

	protected static SerializeScope FranchisedOutletProvinceCenterBaseSecondaryListItemScope = SerializeScope.INCLUDE()
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
		;
	/** 用于FranchisedOutletProvinceCenter的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletProvinceCenterSecondaryListItemScope() {
		return FranchisedOutletProvinceCenterBaseSecondaryListItemScope;
	}

	protected static SerializeScope CatalogBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Catalog.ID_PROPERTY)
		.field(Catalog.NAME_PROPERTY)
		.field(Catalog.SUB_COUNT_PROPERTY)
		.field(Catalog.AMOUNT_PROPERTY)
		;
	/** 用于Catalog的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCatalogSecondaryListItemScope() {
		return CatalogBaseSecondaryListItemScope;
	}

	protected static SerializeScope LevelOneCategoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelOneCategory.ID_PROPERTY)
		.field(LevelOneCategory.NAME_PROPERTY)
		;
	/** 用于LevelOneCategory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelOneCategorySecondaryListItemScope() {
		return LevelOneCategoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope LevelTwoCategoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoCategory.ID_PROPERTY)
		.field(LevelTwoCategory.NAME_PROPERTY)
		;
	/** 用于LevelTwoCategory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoCategorySecondaryListItemScope() {
		return LevelTwoCategoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope LevelThreeCategoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeCategory.ID_PROPERTY)
		.field(LevelThreeCategory.NAME_PROPERTY)
		;
	/** 用于LevelThreeCategory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeCategorySecondaryListItemScope() {
		return LevelThreeCategoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope ProductBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Product.ID_PROPERTY)
		.field(Product.NAME_PROPERTY)
		.field(Product.ORIGIN_PROPERTY)
		.field(Product.REMARK_PROPERTY)
		.field(Product.BRAND_PROPERTY)
		.field(Product.PICTURE_PROPERTY)
		.field(Product.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于Product的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProductSecondaryListItemScope() {
		return ProductBaseSecondaryListItemScope;
	}

	protected static SerializeScope SkuBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Sku.ID_PROPERTY)
		.field(Sku.NAME_PROPERTY)
		.field(Sku.SIZE_PROPERTY)
		.field(Sku.BARCODE_PROPERTY)
		.field(Sku.PACKAGE_TYPE_PROPERTY)
		.field(Sku.NET_CONTENT_PROPERTY)
		.field(Sku.PRICE_PROPERTY)
		.field(Sku.PICTURE_PROPERTY)
		;
	/** 用于Sku的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSkuSecondaryListItemScope() {
		return SkuBaseSecondaryListItemScope;
	}

	protected static SerializeScope FranchisedOutletCityCenterBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(FranchisedOutletCityCenter.ID_PROPERTY)
		.field(FranchisedOutletCityCenter.NAME_PROPERTY)
		.field(FranchisedOutletCityCenter.FOUNDED_PROPERTY)
		.field(FranchisedOutletCityCenter.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于FranchisedOutletCityCenter的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletCityCenterSecondaryListItemScope() {
		return FranchisedOutletCityCenterBaseSecondaryListItemScope;
	}

	protected static SerializeScope CityCenterDepartmentBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityCenterDepartment.ID_PROPERTY)
		.field(CityCenterDepartment.NAME_PROPERTY)
		.field(CityCenterDepartment.FOUNDED_PROPERTY)
		.field(CityCenterDepartment.MANAGER_PROPERTY)
		;
	/** 用于CityCenterDepartment的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityCenterDepartmentSecondaryListItemScope() {
		return CityCenterDepartmentBaseSecondaryListItemScope;
	}

	protected static SerializeScope CityCenterEmployeeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityCenterEmployee.ID_PROPERTY)
		.field(CityCenterEmployee.NAME_PROPERTY)
		.field(CityCenterEmployee.MOBILE_PROPERTY)
		.field(CityCenterEmployee.EMAIL_PROPERTY)
		.field(CityCenterEmployee.FOUNDED_PROPERTY)
		;
	/** 用于CityCenterEmployee的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityCenterEmployeeSecondaryListItemScope() {
		return CityCenterEmployeeBaseSecondaryListItemScope;
	}

	protected static SerializeScope FranchisedOutletCityServiceCenterBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(FranchisedOutletCityServiceCenter.ID_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.NAME_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.FOUNDED_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于FranchisedOutletCityServiceCenter的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletCityServiceCenterSecondaryListItemScope() {
		return FranchisedOutletCityServiceCenterBaseSecondaryListItemScope;
	}

	protected static SerializeScope CityPartnerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityPartner.ID_PROPERTY)
		.field(CityPartner.NAME_PROPERTY)
		.field(CityPartner.MOBILE_PROPERTY)
		.field(CityPartner.DESCRIPTION_PROPERTY)
		.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于CityPartner的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityPartnerSecondaryListItemScope() {
		return CityPartnerBaseSecondaryListItemScope;
	}

	protected static SerializeScope PotentialCustomerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomer.ID_PROPERTY)
		.field(PotentialCustomer.NAME_PROPERTY)
		.field(PotentialCustomer.MOBILE_PROPERTY)
		.field(PotentialCustomer.DESCRIPTION_PROPERTY)
		.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerSecondaryListItemScope() {
		return PotentialCustomerBaseSecondaryListItemScope;
	}

	protected static SerializeScope PotentialCustomerContactPersonBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContactPerson.ID_PROPERTY)
		.field(PotentialCustomerContactPerson.NAME_PROPERTY)
		.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
		.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY)
		;
	/** 用于PotentialCustomerContactPerson的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactPersonSecondaryListItemScope() {
		return PotentialCustomerContactPersonBaseSecondaryListItemScope;
	}

	protected static SerializeScope PotentialCustomerContactBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContact.ID_PROPERTY)
		.field(PotentialCustomerContact.NAME_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
		.field(PotentialCustomerContact.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomerContact的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactSecondaryListItemScope() {
		return PotentialCustomerContactBaseSecondaryListItemScope;
	}

	protected static SerializeScope CityEventBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityEvent.ID_PROPERTY)
		.field(CityEvent.NAME_PROPERTY)
		.field(CityEvent.MOBILE_PROPERTY)
		.field(CityEvent.DESCRIPTION_PROPERTY)
		.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于CityEvent的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityEventSecondaryListItemScope() {
		return CityEventBaseSecondaryListItemScope;
	}

	protected static SerializeScope EventAttendanceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(EventAttendance.ID_PROPERTY)
		.field(EventAttendance.NAME_PROPERTY)
		.field(EventAttendance.DESCRIPTION_PROPERTY)
		;
	/** 用于EventAttendance的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEventAttendanceSecondaryListItemScope() {
		return EventAttendanceBaseSecondaryListItemScope;
	}

	protected static SerializeScope MobileAppBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(MobileApp.ID_PROPERTY)
		.field(MobileApp.NAME_PROPERTY)
		;
	/** 用于MobileApp的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMobileAppSecondaryListItemScope() {
		return MobileAppBaseSecondaryListItemScope;
	}

	protected static SerializeScope PageBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Page.ID_PROPERTY)
		.field(Page.PAGE_TITLE_PROPERTY)
		.field(Page.LINK_TO_URL_PROPERTY)
		;
	/** 用于Page的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPageSecondaryListItemScope() {
		return PageBaseSecondaryListItemScope;
	}

	protected static SerializeScope PageTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PageType.ID_PROPERTY)
		.field(PageType.NAME_PROPERTY)
		.field(PageType.CODE_PROPERTY)
		.field(PageType.FOOTER_TAB_PROPERTY)
		;
	/** 用于PageType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPageTypeSecondaryListItemScope() {
		return PageTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope SlideBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Slide.ID_PROPERTY)
		.field(Slide.DISPLAY_ORDER_PROPERTY)
		.field(Slide.NAME_PROPERTY)
		.field(Slide.IMAGE_URL_PROPERTY)
		.field(Slide.VIDEO_URL_PROPERTY)
		.field(Slide.LINK_TO_URL_PROPERTY)
		;
	/** 用于Slide的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSlideSecondaryListItemScope() {
		return SlideBaseSecondaryListItemScope;
	}

	protected static SerializeScope UiActionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UiAction.ID_PROPERTY)
		.field(UiAction.CODE_PROPERTY)
		.field(UiAction.ICON_PROPERTY)
		.field(UiAction.TITLE_PROPERTY)
		.field(UiAction.BRIEF_PROPERTY)
		.field(UiAction.IMAGE_URL_PROPERTY)
		.field(UiAction.LINK_TO_URL_PROPERTY)
		.field(UiAction.EXTRA_DATA_PROPERTY)
		;
	/** 用于UiAction的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUiActionSecondaryListItemScope() {
		return UiActionBaseSecondaryListItemScope;
	}

	protected static SerializeScope SectionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Section.ID_PROPERTY)
		.field(Section.TITLE_PROPERTY)
		.field(Section.BRIEF_PROPERTY)
		.field(Section.ICON_PROPERTY)
		.field(Section.VIEW_GROUP_PROPERTY)
		.field(Section.LINK_TO_URL_PROPERTY)
		;
	/** 用于Section的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSectionSecondaryListItemScope() {
		return SectionBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserDomainBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSecondaryListItemScope() {
		return UserDomainBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSecondaryListItemScope() {
		return UserWhiteListBaseSecondaryListItemScope;
	}

	protected static SerializeScope SecUserBaseSecondaryListItemScope = SerializeScope.INCLUDE()
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
		;
	/** 用于SecUser的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserSecondaryListItemScope() {
		return SecUserBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserAppBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppSecondaryListItemScope() {
		return UserAppBaseSecondaryListItemScope;
	}

	protected static SerializeScope QuickLinkBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSecondaryListItemScope() {
		return QuickLinkBaseSecondaryListItemScope;
	}

	protected static SerializeScope ListAccessBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessSecondaryListItemScope() {
		return ListAccessBaseSecondaryListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySecondaryListItemScope() {
		return LoginHistoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSecondaryListItemScope() {
		return CandidateContainerBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateElementBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSecondaryListItemScope() {
		return CandidateElementBaseSecondaryListItemScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifySecondaryListItemScope() {
		return WechatWorkappIdentifyBaseSecondaryListItemScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifySecondaryListItemScope() {
		return WechatMiniappIdentifyBaseSecondaryListItemScope;
	}

	protected static SerializeScope KeypairIdentifyBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(KeypairIdentify.ID_PROPERTY)
		.field(KeypairIdentify.PUBLIC_KEY_PROPERTY)
		.field(KeypairIdentify.CREATE_TIME_PROPERTY)
		;
	/** 用于KeypairIdentify的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getKeypairIdentifySecondaryListItemScope() {
		return KeypairIdentifyBaseSecondaryListItemScope;
	}

	protected static SerializeScope PublicKeyTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PublicKeyType.ID_PROPERTY)
		.field(PublicKeyType.NAME_PROPERTY)
		.field(PublicKeyType.CODE_PROPERTY)
		;
	/** 用于PublicKeyType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPublicKeyTypeSecondaryListItemScope() {
		return PublicKeyTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope TreeNodeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(TreeNode.ID_PROPERTY)
		.field(TreeNode.NODE_ID_PROPERTY)
		.field(TreeNode.NODE_TYPE_PROPERTY)
		.field(TreeNode.LEFT_VALUE_PROPERTY)
		.field(TreeNode.RIGHT_VALUE_PROPERTY)
		;
	/** 用于TreeNode的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTreeNodeSecondaryListItemScope() {
		return TreeNodeBaseSecondaryListItemScope;
	}

	protected static SerializeScope FranchisedOutletProvinceCenterBaseListItemScope = SerializeScope.INCLUDE()
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
		.field(FranchisedOutletProvinceCenter.CATALOG_LIST, getCatalogSecondaryListItemScope())
		;
	/** 用于FranchisedOutletProvinceCenter对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletProvinceCenterListItemScope() {
		return FranchisedOutletProvinceCenterBaseListItemScope;
	}

	protected static SerializeScope CatalogBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Catalog.ID_PROPERTY)
		.field(Catalog.NAME_PROPERTY)
		.field(Catalog.OWNER_PROPERTY, getFranchisedOutletProvinceCenterSummaryScope())
		.field(Catalog.SUB_COUNT_PROPERTY)
		.field(Catalog.AMOUNT_PROPERTY)
		.field(Catalog.LEVEL_ONE_CATEGORY_LIST, getLevelOneCategorySecondaryListItemScope())
		;
	/** 用于Catalog对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCatalogListItemScope() {
		return CatalogBaseListItemScope;
	}

	protected static SerializeScope LevelOneCategoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelOneCategory.ID_PROPERTY)
		.field(LevelOneCategory.CATALOG_PROPERTY, getCatalogSummaryScope())
		.field(LevelOneCategory.NAME_PROPERTY)
		.field(LevelOneCategory.LEVEL_TWO_CATEGORY_LIST, getLevelTwoCategorySecondaryListItemScope())
		;
	/** 用于LevelOneCategory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelOneCategoryListItemScope() {
		return LevelOneCategoryBaseListItemScope;
	}

	protected static SerializeScope LevelTwoCategoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoCategory.ID_PROPERTY)
		.field(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, getLevelOneCategorySummaryScope())
		.field(LevelTwoCategory.NAME_PROPERTY)
		.field(LevelTwoCategory.LEVEL_THREE_CATEGORY_LIST, getLevelThreeCategorySecondaryListItemScope())
		;
	/** 用于LevelTwoCategory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoCategoryListItemScope() {
		return LevelTwoCategoryBaseListItemScope;
	}

	protected static SerializeScope LevelThreeCategoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeCategory.ID_PROPERTY)
		.field(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, getLevelTwoCategorySummaryScope())
		.field(LevelThreeCategory.NAME_PROPERTY)
		.field(LevelThreeCategory.PRODUCT_LIST, getProductSecondaryListItemScope())
		;
	/** 用于LevelThreeCategory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeCategoryListItemScope() {
		return LevelThreeCategoryBaseListItemScope;
	}

	protected static SerializeScope ProductBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Product.ID_PROPERTY)
		.field(Product.NAME_PROPERTY)
		.field(Product.PARENT_CATEGORY_PROPERTY, getLevelThreeCategorySummaryScope())
		.field(Product.ORIGIN_PROPERTY)
		.field(Product.REMARK_PROPERTY)
		.field(Product.BRAND_PROPERTY)
		.field(Product.PICTURE_PROPERTY)
		.field(Product.LAST_UPDATE_TIME_PROPERTY)
		.field(Product.SKU_LIST, getSkuSecondaryListItemScope())
		;
	/** 用于Product对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProductListItemScope() {
		return ProductBaseListItemScope;
	}

	protected static SerializeScope SkuBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Sku.ID_PROPERTY)
		.field(Sku.NAME_PROPERTY)
		.field(Sku.SIZE_PROPERTY)
		.field(Sku.PRODUCT_PROPERTY, getProductSummaryScope())
		.field(Sku.BARCODE_PROPERTY)
		.field(Sku.PACKAGE_TYPE_PROPERTY)
		.field(Sku.NET_CONTENT_PROPERTY)
		.field(Sku.PRICE_PROPERTY)
		.field(Sku.PICTURE_PROPERTY)
		;
	/** 用于Sku对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSkuListItemScope() {
		return SkuBaseListItemScope;
	}

	protected static SerializeScope FranchisedOutletCityCenterBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(FranchisedOutletCityCenter.ID_PROPERTY)
		.field(FranchisedOutletCityCenter.NAME_PROPERTY)
		.field(FranchisedOutletCityCenter.FOUNDED_PROPERTY)
		.field(FranchisedOutletCityCenter.CITY_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
		.field(FranchisedOutletCityCenter.LAST_UPDATE_TIME_PROPERTY)
		.field(FranchisedOutletCityCenter.FRANCHISED_OUTLET_CITY_CENTER_LIST, getFranchisedOutletCityCenterSecondaryListItemScope())
		.field(FranchisedOutletCityCenter.CITY_CENTER_DEPARTMENT_LIST, getCityCenterDepartmentSecondaryListItemScope())
		.field(FranchisedOutletCityCenter.CITY_CENTER_EMPLOYEE_LIST, getCityCenterEmployeeSecondaryListItemScope())
		.field(FranchisedOutletCityCenter.FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST, getFranchisedOutletCityServiceCenterSecondaryListItemScope())
		;
	/** 用于FranchisedOutletCityCenter对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletCityCenterListItemScope() {
		return FranchisedOutletCityCenterBaseListItemScope;
	}

	protected static SerializeScope CityCenterDepartmentBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityCenterDepartment.ID_PROPERTY)
		.field(CityCenterDepartment.NAME_PROPERTY)
		.field(CityCenterDepartment.FOUNDED_PROPERTY)
		.field(CityCenterDepartment.CITY_CENTER_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
		.field(CityCenterDepartment.MANAGER_PROPERTY)
		.field(CityCenterDepartment.CITY_CENTER_EMPLOYEE_LIST, getCityCenterEmployeeSecondaryListItemScope())
		;
	/** 用于CityCenterDepartment对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityCenterDepartmentListItemScope() {
		return CityCenterDepartmentBaseListItemScope;
	}

	protected static SerializeScope CityCenterEmployeeBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityCenterEmployee.ID_PROPERTY)
		.field(CityCenterEmployee.NAME_PROPERTY)
		.field(CityCenterEmployee.MOBILE_PROPERTY)
		.field(CityCenterEmployee.EMAIL_PROPERTY)
		.field(CityCenterEmployee.FOUNDED_PROPERTY)
		.field(CityCenterEmployee.DEPARTMENT_PROPERTY, getCityCenterDepartmentSummaryScope())
		.field(CityCenterEmployee.CITY_CENTER_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
		;
	/** 用于CityCenterEmployee对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityCenterEmployeeListItemScope() {
		return CityCenterEmployeeBaseListItemScope;
	}

	protected static SerializeScope FranchisedOutletCityServiceCenterBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(FranchisedOutletCityServiceCenter.ID_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.NAME_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.FOUNDED_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.BELONGS_TO_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
		.field(FranchisedOutletCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.CITY_PARTNER_LIST, getCityPartnerSecondaryListItemScope())
		.field(FranchisedOutletCityServiceCenter.POTENTIAL_CUSTOMER_LIST, getPotentialCustomerSecondaryListItemScope())
		.field(FranchisedOutletCityServiceCenter.CITY_EVENT_LIST, getCityEventSecondaryListItemScope())
		;
	/** 用于FranchisedOutletCityServiceCenter对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletCityServiceCenterListItemScope() {
		return FranchisedOutletCityServiceCenterBaseListItemScope;
	}

	protected static SerializeScope CityPartnerBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityPartner.ID_PROPERTY)
		.field(CityPartner.NAME_PROPERTY)
		.field(CityPartner.MOBILE_PROPERTY)
		.field(CityPartner.TOWN_SERVICE_CENTER_PROPERTY, getFranchisedOutletCityServiceCenterSummaryScope())
		.field(CityPartner.DESCRIPTION_PROPERTY)
		.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
		.field(CityPartner.POTENTIAL_CUSTOMER_LIST, getPotentialCustomerSecondaryListItemScope())
		.field(CityPartner.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactSecondaryListItemScope())
		;
	/** 用于CityPartner对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityPartnerListItemScope() {
		return CityPartnerBaseListItemScope;
	}

	protected static SerializeScope PotentialCustomerBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomer.ID_PROPERTY)
		.field(PotentialCustomer.NAME_PROPERTY)
		.field(PotentialCustomer.MOBILE_PROPERTY)
		.field(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, getFranchisedOutletCityServiceCenterSummaryScope())
		.field(PotentialCustomer.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
		.field(PotentialCustomer.DESCRIPTION_PROPERTY)
		.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
		.field(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST, getPotentialCustomerContactPersonSecondaryListItemScope())
		.field(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactSecondaryListItemScope())
		.field(PotentialCustomer.EVENT_ATTENDANCE_LIST, getEventAttendanceSecondaryListItemScope())
		;
	/** 用于PotentialCustomer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerListItemScope() {
		return PotentialCustomerBaseListItemScope;
	}

	protected static SerializeScope PotentialCustomerContactPersonBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContactPerson.ID_PROPERTY)
		.field(PotentialCustomerContactPerson.NAME_PROPERTY)
		.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
		.field(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactSecondaryListItemScope())
		;
	/** 用于PotentialCustomerContactPerson对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactPersonListItemScope() {
		return PotentialCustomerContactPersonBaseListItemScope;
	}

	protected static SerializeScope PotentialCustomerContactBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContact.ID_PROPERTY)
		.field(PotentialCustomerContact.NAME_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
		.field(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(PotentialCustomerContact.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
		.field(PotentialCustomerContact.CONTACT_TO_PROPERTY, getPotentialCustomerContactPersonSummaryScope())
		.field(PotentialCustomerContact.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomerContact对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactListItemScope() {
		return PotentialCustomerContactBaseListItemScope;
	}

	protected static SerializeScope CityEventBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityEvent.ID_PROPERTY)
		.field(CityEvent.NAME_PROPERTY)
		.field(CityEvent.MOBILE_PROPERTY)
		.field(CityEvent.CITY_SERVICE_CENTER_PROPERTY, getFranchisedOutletCityServiceCenterSummaryScope())
		.field(CityEvent.DESCRIPTION_PROPERTY)
		.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
		.field(CityEvent.EVENT_ATTENDANCE_LIST, getEventAttendanceSecondaryListItemScope())
		;
	/** 用于CityEvent对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityEventListItemScope() {
		return CityEventBaseListItemScope;
	}

	protected static SerializeScope EventAttendanceBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(EventAttendance.ID_PROPERTY)
		.field(EventAttendance.NAME_PROPERTY)
		.field(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(EventAttendance.CITY_EVENT_PROPERTY, getCityEventSummaryScope())
		.field(EventAttendance.DESCRIPTION_PROPERTY)
		;
	/** 用于EventAttendance对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEventAttendanceListItemScope() {
		return EventAttendanceBaseListItemScope;
	}

	protected static SerializeScope MobileAppBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(MobileApp.ID_PROPERTY)
		.field(MobileApp.NAME_PROPERTY)
		.field(MobileApp.PAGE_LIST, getPageSecondaryListItemScope())
		.field(MobileApp.PAGE_TYPE_LIST, getPageTypeSecondaryListItemScope())
		;
	/** 用于MobileApp对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMobileAppListItemScope() {
		return MobileAppBaseListItemScope;
	}

	protected static SerializeScope PageBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Page.ID_PROPERTY)
		.field(Page.PAGE_TITLE_PROPERTY)
		.field(Page.LINK_TO_URL_PROPERTY)
		.field(Page.PAGE_TYPE_PROPERTY, getPageTypeSummaryScope())
		.field(Page.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
		.field(Page.SLIDE_LIST, getSlideSecondaryListItemScope())
		.field(Page.UI_ACTION_LIST, getUiActionSecondaryListItemScope())
		.field(Page.SECTION_LIST, getSectionSecondaryListItemScope())
		;
	/** 用于Page对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPageListItemScope() {
		return PageBaseListItemScope;
	}

	protected static SerializeScope PageTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PageType.ID_PROPERTY)
		.field(PageType.NAME_PROPERTY)
		.field(PageType.CODE_PROPERTY)
		.field(PageType.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
		.field(PageType.FOOTER_TAB_PROPERTY)
		.field(PageType.PAGE_LIST, getPageSecondaryListItemScope())
		;
	/** 用于PageType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPageTypeListItemScope() {
		return PageTypeBaseListItemScope;
	}

	protected static SerializeScope SlideBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Slide.ID_PROPERTY)
		.field(Slide.DISPLAY_ORDER_PROPERTY)
		.field(Slide.NAME_PROPERTY)
		.field(Slide.IMAGE_URL_PROPERTY)
		.field(Slide.VIDEO_URL_PROPERTY)
		.field(Slide.LINK_TO_URL_PROPERTY)
		.field(Slide.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于Slide对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSlideListItemScope() {
		return SlideBaseListItemScope;
	}

	protected static SerializeScope UiActionBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UiAction.ID_PROPERTY)
		.field(UiAction.CODE_PROPERTY)
		.field(UiAction.ICON_PROPERTY)
		.field(UiAction.TITLE_PROPERTY)
		.field(UiAction.BRIEF_PROPERTY)
		.field(UiAction.IMAGE_URL_PROPERTY)
		.field(UiAction.LINK_TO_URL_PROPERTY)
		.field(UiAction.EXTRA_DATA_PROPERTY)
		.field(UiAction.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于UiAction对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUiActionListItemScope() {
		return UiActionBaseListItemScope;
	}

	protected static SerializeScope SectionBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Section.ID_PROPERTY)
		.field(Section.TITLE_PROPERTY)
		.field(Section.BRIEF_PROPERTY)
		.field(Section.ICON_PROPERTY)
		.field(Section.VIEW_GROUP_PROPERTY)
		.field(Section.LINK_TO_URL_PROPERTY)
		.field(Section.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于Section对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSectionListItemScope() {
		return SectionBaseListItemScope;
	}

	protected static SerializeScope UserDomainBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListSecondaryListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserSecondaryListItemScope())
		.field(UserDomain.PUBLIC_KEY_TYPE_LIST, getPublicKeyTypeSecondaryListItemScope())
		;
	/** 用于UserDomain对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainListItemScope() {
		return UserDomainBaseListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListListItemScope() {
		return UserWhiteListBaseListItemScope;
	}

	protected static SerializeScope SecUserBaseListItemScope = SerializeScope.INCLUDE()
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
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.USER_APP_LIST, getUserAppSecondaryListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistorySecondaryListItemScope())
		.field(SecUser.WECHAT_WORKAPP_IDENTIFY_LIST, getWechatWorkappIdentifySecondaryListItemScope())
		.field(SecUser.WECHAT_MINIAPP_IDENTIFY_LIST, getWechatMiniappIdentifySecondaryListItemScope())
		.field(SecUser.KEYPAIR_IDENTIFY_LIST, getKeypairIdentifySecondaryListItemScope())
		;
	/** 用于SecUser对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserListItemScope() {
		return SecUserBaseListItemScope;
	}

	protected static SerializeScope UserAppBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkSecondaryListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessSecondaryListItemScope())
		;
	/** 用于UserApp对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppListItemScope() {
		return UserAppBaseListItemScope;
	}

	protected static SerializeScope QuickLinkBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkListItemScope() {
		return QuickLinkBaseListItemScope;
	}

	protected static SerializeScope ListAccessBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessListItemScope() {
		return ListAccessBaseListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryListItemScope() {
		return LoginHistoryBaseListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementSecondaryListItemScope())
		;
	/** 用于CandidateContainer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerListItemScope() {
		return CandidateContainerBaseListItemScope;
	}

	protected static SerializeScope CandidateElementBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementListItemScope() {
		return CandidateElementBaseListItemScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifyListItemScope() {
		return WechatWorkappIdentifyBaseListItemScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifyListItemScope() {
		return WechatMiniappIdentifyBaseListItemScope;
	}

	protected static SerializeScope KeypairIdentifyBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(KeypairIdentify.ID_PROPERTY)
		.field(KeypairIdentify.PUBLIC_KEY_PROPERTY)
		.field(KeypairIdentify.KEY_TYPE_PROPERTY, getPublicKeyTypeSummaryScope())
		.field(KeypairIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(KeypairIdentify.CREATE_TIME_PROPERTY)
		;
	/** 用于KeypairIdentify对象的列表时需要序列化的属性列表 */
	public static SerializeScope getKeypairIdentifyListItemScope() {
		return KeypairIdentifyBaseListItemScope;
	}

	protected static SerializeScope PublicKeyTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PublicKeyType.ID_PROPERTY)
		.field(PublicKeyType.NAME_PROPERTY)
		.field(PublicKeyType.CODE_PROPERTY)
		.field(PublicKeyType.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(PublicKeyType.KEYPAIR_IDENTIFY_LIST, getKeypairIdentifySecondaryListItemScope())
		;
	/** 用于PublicKeyType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPublicKeyTypeListItemScope() {
		return PublicKeyTypeBaseListItemScope;
	}

	protected static SerializeScope TreeNodeBaseListItemScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(TreeNode.ID_PROPERTY)
		.field(TreeNode.NODE_ID_PROPERTY)
		.field(TreeNode.NODE_TYPE_PROPERTY)
		.field(TreeNode.LEFT_VALUE_PROPERTY)
		.field(TreeNode.RIGHT_VALUE_PROPERTY)
		;
	/** 用于TreeNode对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTreeNodeListItemScope() {
		return TreeNodeBaseListItemScope;
	}

	protected static SerializeScope FranchisedOutletProvinceCenterBaseDetailScope = SerializeScope.INCLUDE()
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
		.field(FranchisedOutletProvinceCenter.CATALOG_LIST, getCatalogListItemScope())
		;
	/** 用于FranchisedOutletProvinceCenter对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletProvinceCenterDetailScope() {
		return FranchisedOutletProvinceCenterBaseDetailScope;
	}

	protected static SerializeScope CatalogBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Catalog.ID_PROPERTY)
		.field(Catalog.NAME_PROPERTY)
		.field(Catalog.OWNER_PROPERTY, getFranchisedOutletProvinceCenterSummaryScope())
		.field(Catalog.SUB_COUNT_PROPERTY)
		.field(Catalog.AMOUNT_PROPERTY)
		.field(Catalog.LEVEL_ONE_CATEGORY_LIST, getLevelOneCategoryListItemScope())
		;
	/** 用于Catalog对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCatalogDetailScope() {
		return CatalogBaseDetailScope;
	}

	protected static SerializeScope LevelOneCategoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelOneCategory.ID_PROPERTY)
		.field(LevelOneCategory.CATALOG_PROPERTY, getCatalogSummaryScope())
		.field(LevelOneCategory.NAME_PROPERTY)
		.field(LevelOneCategory.LEVEL_TWO_CATEGORY_LIST, getLevelTwoCategoryListItemScope())
		;
	/** 用于LevelOneCategory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelOneCategoryDetailScope() {
		return LevelOneCategoryBaseDetailScope;
	}

	protected static SerializeScope LevelTwoCategoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoCategory.ID_PROPERTY)
		.field(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, getLevelOneCategorySummaryScope())
		.field(LevelTwoCategory.NAME_PROPERTY)
		.field(LevelTwoCategory.LEVEL_THREE_CATEGORY_LIST, getLevelThreeCategoryListItemScope())
		;
	/** 用于LevelTwoCategory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoCategoryDetailScope() {
		return LevelTwoCategoryBaseDetailScope;
	}

	protected static SerializeScope LevelThreeCategoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeCategory.ID_PROPERTY)
		.field(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, getLevelTwoCategorySummaryScope())
		.field(LevelThreeCategory.NAME_PROPERTY)
		.field(LevelThreeCategory.PRODUCT_LIST, getProductListItemScope())
		;
	/** 用于LevelThreeCategory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeCategoryDetailScope() {
		return LevelThreeCategoryBaseDetailScope;
	}

	protected static SerializeScope ProductBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Product.ID_PROPERTY)
		.field(Product.NAME_PROPERTY)
		.field(Product.PARENT_CATEGORY_PROPERTY, getLevelThreeCategorySummaryScope())
		.field(Product.ORIGIN_PROPERTY)
		.field(Product.REMARK_PROPERTY)
		.field(Product.BRAND_PROPERTY)
		.field(Product.PICTURE_PROPERTY)
		.field(Product.LAST_UPDATE_TIME_PROPERTY)
		.field(Product.SKU_LIST, getSkuListItemScope())
		;
	/** 用于Product对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProductDetailScope() {
		return ProductBaseDetailScope;
	}

	protected static SerializeScope SkuBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Sku.ID_PROPERTY)
		.field(Sku.NAME_PROPERTY)
		.field(Sku.SIZE_PROPERTY)
		.field(Sku.PRODUCT_PROPERTY, getProductSummaryScope())
		.field(Sku.BARCODE_PROPERTY)
		.field(Sku.PACKAGE_TYPE_PROPERTY)
		.field(Sku.NET_CONTENT_PROPERTY)
		.field(Sku.PRICE_PROPERTY)
		.field(Sku.PICTURE_PROPERTY)
		;
	/** 用于Sku对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSkuDetailScope() {
		return SkuBaseDetailScope;
	}

	protected static SerializeScope FranchisedOutletCityCenterBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(FranchisedOutletCityCenter.ID_PROPERTY)
		.field(FranchisedOutletCityCenter.NAME_PROPERTY)
		.field(FranchisedOutletCityCenter.FOUNDED_PROPERTY)
		.field(FranchisedOutletCityCenter.CITY_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
		.field(FranchisedOutletCityCenter.LAST_UPDATE_TIME_PROPERTY)
		.field(FranchisedOutletCityCenter.FRANCHISED_OUTLET_CITY_CENTER_LIST, getFranchisedOutletCityCenterListItemScope())
		.field(FranchisedOutletCityCenter.CITY_CENTER_DEPARTMENT_LIST, getCityCenterDepartmentListItemScope())
		.field(FranchisedOutletCityCenter.CITY_CENTER_EMPLOYEE_LIST, getCityCenterEmployeeListItemScope())
		.field(FranchisedOutletCityCenter.FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST, getFranchisedOutletCityServiceCenterListItemScope())
		;
	/** 用于FranchisedOutletCityCenter对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletCityCenterDetailScope() {
		return FranchisedOutletCityCenterBaseDetailScope;
	}

	protected static SerializeScope CityCenterDepartmentBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityCenterDepartment.ID_PROPERTY)
		.field(CityCenterDepartment.NAME_PROPERTY)
		.field(CityCenterDepartment.FOUNDED_PROPERTY)
		.field(CityCenterDepartment.CITY_CENTER_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
		.field(CityCenterDepartment.MANAGER_PROPERTY)
		.field(CityCenterDepartment.CITY_CENTER_EMPLOYEE_LIST, getCityCenterEmployeeListItemScope())
		;
	/** 用于CityCenterDepartment对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityCenterDepartmentDetailScope() {
		return CityCenterDepartmentBaseDetailScope;
	}

	protected static SerializeScope CityCenterEmployeeBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityCenterEmployee.ID_PROPERTY)
		.field(CityCenterEmployee.NAME_PROPERTY)
		.field(CityCenterEmployee.MOBILE_PROPERTY)
		.field(CityCenterEmployee.EMAIL_PROPERTY)
		.field(CityCenterEmployee.FOUNDED_PROPERTY)
		.field(CityCenterEmployee.DEPARTMENT_PROPERTY, getCityCenterDepartmentSummaryScope())
		.field(CityCenterEmployee.CITY_CENTER_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
		;
	/** 用于CityCenterEmployee对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityCenterEmployeeDetailScope() {
		return CityCenterEmployeeBaseDetailScope;
	}

	protected static SerializeScope FranchisedOutletCityServiceCenterBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(FranchisedOutletCityServiceCenter.ID_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.NAME_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.FOUNDED_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.BELONGS_TO_PROPERTY, getFranchisedOutletCityCenterSummaryScope())
		.field(FranchisedOutletCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
		.field(FranchisedOutletCityServiceCenter.CITY_PARTNER_LIST, getCityPartnerListItemScope())
		.field(FranchisedOutletCityServiceCenter.POTENTIAL_CUSTOMER_LIST, getPotentialCustomerListItemScope())
		.field(FranchisedOutletCityServiceCenter.CITY_EVENT_LIST, getCityEventListItemScope())
		;
	/** 用于FranchisedOutletCityServiceCenter对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFranchisedOutletCityServiceCenterDetailScope() {
		return FranchisedOutletCityServiceCenterBaseDetailScope;
	}

	protected static SerializeScope CityPartnerBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityPartner.ID_PROPERTY)
		.field(CityPartner.NAME_PROPERTY)
		.field(CityPartner.MOBILE_PROPERTY)
		.field(CityPartner.TOWN_SERVICE_CENTER_PROPERTY, getFranchisedOutletCityServiceCenterSummaryScope())
		.field(CityPartner.DESCRIPTION_PROPERTY)
		.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
		.field(CityPartner.POTENTIAL_CUSTOMER_LIST, getPotentialCustomerListItemScope())
		.field(CityPartner.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactListItemScope())
		;
	/** 用于CityPartner对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityPartnerDetailScope() {
		return CityPartnerBaseDetailScope;
	}

	protected static SerializeScope PotentialCustomerBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomer.ID_PROPERTY)
		.field(PotentialCustomer.NAME_PROPERTY)
		.field(PotentialCustomer.MOBILE_PROPERTY)
		.field(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, getFranchisedOutletCityServiceCenterSummaryScope())
		.field(PotentialCustomer.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
		.field(PotentialCustomer.DESCRIPTION_PROPERTY)
		.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
		.field(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST, getPotentialCustomerContactPersonListItemScope())
		.field(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactListItemScope())
		.field(PotentialCustomer.EVENT_ATTENDANCE_LIST, getEventAttendanceListItemScope())
		;
	/** 用于PotentialCustomer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerDetailScope() {
		return PotentialCustomerBaseDetailScope;
	}

	protected static SerializeScope PotentialCustomerContactPersonBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContactPerson.ID_PROPERTY)
		.field(PotentialCustomerContactPerson.NAME_PROPERTY)
		.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
		.field(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactListItemScope())
		;
	/** 用于PotentialCustomerContactPerson对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactPersonDetailScope() {
		return PotentialCustomerContactPersonBaseDetailScope;
	}

	protected static SerializeScope PotentialCustomerContactBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContact.ID_PROPERTY)
		.field(PotentialCustomerContact.NAME_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
		.field(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(PotentialCustomerContact.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
		.field(PotentialCustomerContact.CONTACT_TO_PROPERTY, getPotentialCustomerContactPersonSummaryScope())
		.field(PotentialCustomerContact.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomerContact对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactDetailScope() {
		return PotentialCustomerContactBaseDetailScope;
	}

	protected static SerializeScope CityEventBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CityEvent.ID_PROPERTY)
		.field(CityEvent.NAME_PROPERTY)
		.field(CityEvent.MOBILE_PROPERTY)
		.field(CityEvent.CITY_SERVICE_CENTER_PROPERTY, getFranchisedOutletCityServiceCenterSummaryScope())
		.field(CityEvent.DESCRIPTION_PROPERTY)
		.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
		.field(CityEvent.EVENT_ATTENDANCE_LIST, getEventAttendanceListItemScope())
		;
	/** 用于CityEvent对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityEventDetailScope() {
		return CityEventBaseDetailScope;
	}

	protected static SerializeScope EventAttendanceBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(EventAttendance.ID_PROPERTY)
		.field(EventAttendance.NAME_PROPERTY)
		.field(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(EventAttendance.CITY_EVENT_PROPERTY, getCityEventSummaryScope())
		.field(EventAttendance.DESCRIPTION_PROPERTY)
		;
	/** 用于EventAttendance对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEventAttendanceDetailScope() {
		return EventAttendanceBaseDetailScope;
	}

	protected static SerializeScope MobileAppBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(MobileApp.ID_PROPERTY)
		.field(MobileApp.NAME_PROPERTY)
		.field(MobileApp.PAGE_LIST, getPageListItemScope())
		.field(MobileApp.PAGE_TYPE_LIST, getPageTypeListItemScope())
		;
	/** 用于MobileApp对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMobileAppDetailScope() {
		return MobileAppBaseDetailScope;
	}

	protected static SerializeScope PageBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Page.ID_PROPERTY)
		.field(Page.PAGE_TITLE_PROPERTY)
		.field(Page.LINK_TO_URL_PROPERTY)
		.field(Page.PAGE_TYPE_PROPERTY, getPageTypeSummaryScope())
		.field(Page.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
		.field(Page.SLIDE_LIST, getSlideListItemScope())
		.field(Page.UI_ACTION_LIST, getUiActionListItemScope())
		.field(Page.SECTION_LIST, getSectionListItemScope())
		;
	/** 用于Page对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPageDetailScope() {
		return PageBaseDetailScope;
	}

	protected static SerializeScope PageTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PageType.ID_PROPERTY)
		.field(PageType.NAME_PROPERTY)
		.field(PageType.CODE_PROPERTY)
		.field(PageType.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
		.field(PageType.FOOTER_TAB_PROPERTY)
		.field(PageType.PAGE_LIST, getPageListItemScope())
		;
	/** 用于PageType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPageTypeDetailScope() {
		return PageTypeBaseDetailScope;
	}

	protected static SerializeScope SlideBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Slide.ID_PROPERTY)
		.field(Slide.DISPLAY_ORDER_PROPERTY)
		.field(Slide.NAME_PROPERTY)
		.field(Slide.IMAGE_URL_PROPERTY)
		.field(Slide.VIDEO_URL_PROPERTY)
		.field(Slide.LINK_TO_URL_PROPERTY)
		.field(Slide.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于Slide对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSlideDetailScope() {
		return SlideBaseDetailScope;
	}

	protected static SerializeScope UiActionBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UiAction.ID_PROPERTY)
		.field(UiAction.CODE_PROPERTY)
		.field(UiAction.ICON_PROPERTY)
		.field(UiAction.TITLE_PROPERTY)
		.field(UiAction.BRIEF_PROPERTY)
		.field(UiAction.IMAGE_URL_PROPERTY)
		.field(UiAction.LINK_TO_URL_PROPERTY)
		.field(UiAction.EXTRA_DATA_PROPERTY)
		.field(UiAction.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于UiAction对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUiActionDetailScope() {
		return UiActionBaseDetailScope;
	}

	protected static SerializeScope SectionBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(Section.ID_PROPERTY)
		.field(Section.TITLE_PROPERTY)
		.field(Section.BRIEF_PROPERTY)
		.field(Section.ICON_PROPERTY)
		.field(Section.VIEW_GROUP_PROPERTY)
		.field(Section.LINK_TO_URL_PROPERTY)
		.field(Section.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于Section对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSectionDetailScope() {
		return SectionBaseDetailScope;
	}

	protected static SerializeScope UserDomainBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserListItemScope())
		.field(UserDomain.PUBLIC_KEY_TYPE_LIST, getPublicKeyTypeListItemScope())
		;
	/** 用于UserDomain对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainDetailScope() {
		return UserDomainBaseDetailScope;
	}

	protected static SerializeScope UserWhiteListBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListDetailScope() {
		return UserWhiteListBaseDetailScope;
	}

	protected static SerializeScope SecUserBaseDetailScope = SerializeScope.INCLUDE()
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
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.USER_APP_LIST, getUserAppListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistoryListItemScope())
		.field(SecUser.WECHAT_WORKAPP_IDENTIFY_LIST, getWechatWorkappIdentifyListItemScope())
		.field(SecUser.WECHAT_MINIAPP_IDENTIFY_LIST, getWechatMiniappIdentifyListItemScope())
		.field(SecUser.KEYPAIR_IDENTIFY_LIST, getKeypairIdentifyListItemScope())
		;
	/** 用于SecUser对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserDetailScope() {
		return SecUserBaseDetailScope;
	}

	protected static SerializeScope UserAppBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessListItemScope())
		;
	/** 用于UserApp对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppDetailScope() {
		return UserAppBaseDetailScope;
	}

	protected static SerializeScope QuickLinkBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkDetailScope() {
		return QuickLinkBaseDetailScope;
	}

	protected static SerializeScope ListAccessBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessDetailScope() {
		return ListAccessBaseDetailScope;
	}

	protected static SerializeScope LoginHistoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryDetailScope() {
		return LoginHistoryBaseDetailScope;
	}

	protected static SerializeScope CandidateContainerBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementListItemScope())
		;
	/** 用于CandidateContainer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerDetailScope() {
		return CandidateContainerBaseDetailScope;
	}

	protected static SerializeScope CandidateElementBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementDetailScope() {
		return CandidateElementBaseDetailScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifyDetailScope() {
		return WechatWorkappIdentifyBaseDetailScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifyDetailScope() {
		return WechatMiniappIdentifyBaseDetailScope;
	}

	protected static SerializeScope KeypairIdentifyBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(KeypairIdentify.ID_PROPERTY)
		.field(KeypairIdentify.PUBLIC_KEY_PROPERTY)
		.field(KeypairIdentify.KEY_TYPE_PROPERTY, getPublicKeyTypeSummaryScope())
		.field(KeypairIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(KeypairIdentify.CREATE_TIME_PROPERTY)
		;
	/** 用于KeypairIdentify对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getKeypairIdentifyDetailScope() {
		return KeypairIdentifyBaseDetailScope;
	}

	protected static SerializeScope PublicKeyTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(PublicKeyType.ID_PROPERTY)
		.field(PublicKeyType.NAME_PROPERTY)
		.field(PublicKeyType.CODE_PROPERTY)
		.field(PublicKeyType.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(PublicKeyType.KEYPAIR_IDENTIFY_LIST, getKeypairIdentifyListItemScope())
		;
	/** 用于PublicKeyType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPublicKeyTypeDetailScope() {
		return PublicKeyTypeBaseDetailScope;
	}

	protected static SerializeScope TreeNodeBaseDetailScope = SerializeScope.INCLUDE()
		.field(YoubenbenBaseConstants.X_LINK_TO_URL)
		.field(TreeNode.ID_PROPERTY)
		.field(TreeNode.NODE_ID_PROPERTY)
		.field(TreeNode.NODE_TYPE_PROPERTY)
		.field(TreeNode.LEFT_VALUE_PROPERTY)
		.field(TreeNode.RIGHT_VALUE_PROPERTY)
		;
	/** 用于TreeNode对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTreeNodeDetailScope() {
		return TreeNodeBaseDetailScope;
	}

	

}
















