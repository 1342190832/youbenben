package com.xingyou.xingyou;


import com.xingyou.xingyou.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterManager;

import com.xingyou.xingyou.catalog.CatalogManager;

import com.xingyou.xingyou.levelonecategory.LevelOneCategoryManager;

import com.xingyou.xingyou.leveltwocategory.LevelTwoCategoryManager;

import com.xingyou.xingyou.levelthreecategory.LevelThreeCategoryManager;

import com.xingyou.xingyou.product.ProductManager;

import com.xingyou.xingyou.sku.SkuManager;

import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenterManager;

import com.xingyou.xingyou.citycenterdepartment.CityCenterDepartmentManager;

import com.xingyou.xingyou.citycenteremployee.CityCenterEmployeeManager;

import com.xingyou.xingyou.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterManager;

import com.xingyou.xingyou.citypartner.CityPartnerManager;

import com.xingyou.xingyou.potentialcustomer.PotentialCustomerManager;

import com.xingyou.xingyou.potentialcustomercontactperson.PotentialCustomerContactPersonManager;

import com.xingyou.xingyou.potentialcustomercontact.PotentialCustomerContactManager;

import com.xingyou.xingyou.cityevent.CityEventManager;

import com.xingyou.xingyou.eventattendance.EventAttendanceManager;

import com.xingyou.xingyou.mobileapp.MobileAppManager;

import com.xingyou.xingyou.page.PageManager;

import com.xingyou.xingyou.pagetype.PageTypeManager;

import com.xingyou.xingyou.slide.SlideManager;

import com.xingyou.xingyou.uiaction.UiActionManager;

import com.xingyou.xingyou.section.SectionManager;

import com.xingyou.xingyou.userdomain.UserDomainManager;

import com.xingyou.xingyou.userwhitelist.UserWhiteListManager;

import com.xingyou.xingyou.secuser.SecUserManager;

import com.xingyou.xingyou.userapp.UserAppManager;

import com.xingyou.xingyou.quicklink.QuickLinkManager;

import com.xingyou.xingyou.listaccess.ListAccessManager;

import com.xingyou.xingyou.loginhistory.LoginHistoryManager;

import com.xingyou.xingyou.candidatecontainer.CandidateContainerManager;

import com.xingyou.xingyou.candidateelement.CandidateElementManager;

import com.xingyou.xingyou.wechatworkappidentify.WechatWorkappIdentifyManager;

import com.xingyou.xingyou.wechatminiappidentify.WechatMiniappIdentifyManager;

import com.xingyou.xingyou.keypairidentify.KeypairIdentifyManager;

import com.xingyou.xingyou.publickeytype.PublicKeyTypeManager;

import com.xingyou.xingyou.treenode.TreeNodeManager;


public class ManagerGroup {

	protected FranchisedOutletProvinceCenterManager franchisedOutletProvinceCenterManager;

	protected CatalogManager catalogManager;

	protected LevelOneCategoryManager levelOneCategoryManager;

	protected LevelTwoCategoryManager levelTwoCategoryManager;

	protected LevelThreeCategoryManager levelThreeCategoryManager;

	protected ProductManager productManager;

	protected SkuManager skuManager;

	protected FranchisedOutletCityCenterManager franchisedOutletCityCenterManager;

	protected CityCenterDepartmentManager cityCenterDepartmentManager;

	protected CityCenterEmployeeManager cityCenterEmployeeManager;

	protected FranchisedOutletCityServiceCenterManager franchisedOutletCityServiceCenterManager;

	protected CityPartnerManager cityPartnerManager;

	protected PotentialCustomerManager potentialCustomerManager;

	protected PotentialCustomerContactPersonManager potentialCustomerContactPersonManager;

	protected PotentialCustomerContactManager potentialCustomerContactManager;

	protected CityEventManager cityEventManager;

	protected EventAttendanceManager eventAttendanceManager;

	protected MobileAppManager mobileAppManager;

	protected PageManager pageManager;

	protected PageTypeManager pageTypeManager;

	protected SlideManager slideManager;

	protected UiActionManager uiActionManager;

	protected SectionManager sectionManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected UserAppManager userAppManager;

	protected QuickLinkManager quickLinkManager;

	protected ListAccessManager listAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected CandidateContainerManager candidateContainerManager;

	protected CandidateElementManager candidateElementManager;

	protected WechatWorkappIdentifyManager wechatWorkappIdentifyManager;

	protected WechatMiniappIdentifyManager wechatMiniappIdentifyManager;

	protected KeypairIdentifyManager keypairIdentifyManager;

	protected PublicKeyTypeManager publicKeyTypeManager;

	protected TreeNodeManager treeNodeManager;



	public FranchisedOutletProvinceCenterManager getFranchisedOutletProvinceCenterManager(){
		return this.franchisedOutletProvinceCenterManager;
	}
	public void setFranchisedOutletProvinceCenterManager(FranchisedOutletProvinceCenterManager manager){
		this.franchisedOutletProvinceCenterManager = manager;
	}


	public CatalogManager getCatalogManager(){
		return this.catalogManager;
	}
	public void setCatalogManager(CatalogManager manager){
		this.catalogManager = manager;
	}


	public LevelOneCategoryManager getLevelOneCategoryManager(){
		return this.levelOneCategoryManager;
	}
	public void setLevelOneCategoryManager(LevelOneCategoryManager manager){
		this.levelOneCategoryManager = manager;
	}


	public LevelTwoCategoryManager getLevelTwoCategoryManager(){
		return this.levelTwoCategoryManager;
	}
	public void setLevelTwoCategoryManager(LevelTwoCategoryManager manager){
		this.levelTwoCategoryManager = manager;
	}


	public LevelThreeCategoryManager getLevelThreeCategoryManager(){
		return this.levelThreeCategoryManager;
	}
	public void setLevelThreeCategoryManager(LevelThreeCategoryManager manager){
		this.levelThreeCategoryManager = manager;
	}


	public ProductManager getProductManager(){
		return this.productManager;
	}
	public void setProductManager(ProductManager manager){
		this.productManager = manager;
	}


	public SkuManager getSkuManager(){
		return this.skuManager;
	}
	public void setSkuManager(SkuManager manager){
		this.skuManager = manager;
	}


	public FranchisedOutletCityCenterManager getFranchisedOutletCityCenterManager(){
		return this.franchisedOutletCityCenterManager;
	}
	public void setFranchisedOutletCityCenterManager(FranchisedOutletCityCenterManager manager){
		this.franchisedOutletCityCenterManager = manager;
	}


	public CityCenterDepartmentManager getCityCenterDepartmentManager(){
		return this.cityCenterDepartmentManager;
	}
	public void setCityCenterDepartmentManager(CityCenterDepartmentManager manager){
		this.cityCenterDepartmentManager = manager;
	}


	public CityCenterEmployeeManager getCityCenterEmployeeManager(){
		return this.cityCenterEmployeeManager;
	}
	public void setCityCenterEmployeeManager(CityCenterEmployeeManager manager){
		this.cityCenterEmployeeManager = manager;
	}


	public FranchisedOutletCityServiceCenterManager getFranchisedOutletCityServiceCenterManager(){
		return this.franchisedOutletCityServiceCenterManager;
	}
	public void setFranchisedOutletCityServiceCenterManager(FranchisedOutletCityServiceCenterManager manager){
		this.franchisedOutletCityServiceCenterManager = manager;
	}


	public CityPartnerManager getCityPartnerManager(){
		return this.cityPartnerManager;
	}
	public void setCityPartnerManager(CityPartnerManager manager){
		this.cityPartnerManager = manager;
	}


	public PotentialCustomerManager getPotentialCustomerManager(){
		return this.potentialCustomerManager;
	}
	public void setPotentialCustomerManager(PotentialCustomerManager manager){
		this.potentialCustomerManager = manager;
	}


	public PotentialCustomerContactPersonManager getPotentialCustomerContactPersonManager(){
		return this.potentialCustomerContactPersonManager;
	}
	public void setPotentialCustomerContactPersonManager(PotentialCustomerContactPersonManager manager){
		this.potentialCustomerContactPersonManager = manager;
	}


	public PotentialCustomerContactManager getPotentialCustomerContactManager(){
		return this.potentialCustomerContactManager;
	}
	public void setPotentialCustomerContactManager(PotentialCustomerContactManager manager){
		this.potentialCustomerContactManager = manager;
	}


	public CityEventManager getCityEventManager(){
		return this.cityEventManager;
	}
	public void setCityEventManager(CityEventManager manager){
		this.cityEventManager = manager;
	}


	public EventAttendanceManager getEventAttendanceManager(){
		return this.eventAttendanceManager;
	}
	public void setEventAttendanceManager(EventAttendanceManager manager){
		this.eventAttendanceManager = manager;
	}


	public MobileAppManager getMobileAppManager(){
		return this.mobileAppManager;
	}
	public void setMobileAppManager(MobileAppManager manager){
		this.mobileAppManager = manager;
	}


	public PageManager getPageManager(){
		return this.pageManager;
	}
	public void setPageManager(PageManager manager){
		this.pageManager = manager;
	}


	public PageTypeManager getPageTypeManager(){
		return this.pageTypeManager;
	}
	public void setPageTypeManager(PageTypeManager manager){
		this.pageTypeManager = manager;
	}


	public SlideManager getSlideManager(){
		return this.slideManager;
	}
	public void setSlideManager(SlideManager manager){
		this.slideManager = manager;
	}


	public UiActionManager getUiActionManager(){
		return this.uiActionManager;
	}
	public void setUiActionManager(UiActionManager manager){
		this.uiActionManager = manager;
	}


	public SectionManager getSectionManager(){
		return this.sectionManager;
	}
	public void setSectionManager(SectionManager manager){
		this.sectionManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public QuickLinkManager getQuickLinkManager(){
		return this.quickLinkManager;
	}
	public void setQuickLinkManager(QuickLinkManager manager){
		this.quickLinkManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public CandidateContainerManager getCandidateContainerManager(){
		return this.candidateContainerManager;
	}
	public void setCandidateContainerManager(CandidateContainerManager manager){
		this.candidateContainerManager = manager;
	}


	public CandidateElementManager getCandidateElementManager(){
		return this.candidateElementManager;
	}
	public void setCandidateElementManager(CandidateElementManager manager){
		this.candidateElementManager = manager;
	}


	public WechatWorkappIdentifyManager getWechatWorkappIdentifyManager(){
		return this.wechatWorkappIdentifyManager;
	}
	public void setWechatWorkappIdentifyManager(WechatWorkappIdentifyManager manager){
		this.wechatWorkappIdentifyManager = manager;
	}


	public WechatMiniappIdentifyManager getWechatMiniappIdentifyManager(){
		return this.wechatMiniappIdentifyManager;
	}
	public void setWechatMiniappIdentifyManager(WechatMiniappIdentifyManager manager){
		this.wechatMiniappIdentifyManager = manager;
	}


	public KeypairIdentifyManager getKeypairIdentifyManager(){
		return this.keypairIdentifyManager;
	}
	public void setKeypairIdentifyManager(KeypairIdentifyManager manager){
		this.keypairIdentifyManager = manager;
	}


	public PublicKeyTypeManager getPublicKeyTypeManager(){
		return this.publicKeyTypeManager;
	}
	public void setPublicKeyTypeManager(PublicKeyTypeManager manager){
		this.publicKeyTypeManager = manager;
	}


	public TreeNodeManager getTreeNodeManager(){
		return this.treeNodeManager;
	}
	public void setTreeNodeManager(TreeNodeManager manager){
		this.treeNodeManager = manager;
	}


}
















