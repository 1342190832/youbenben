package com.youbenben.youbenben;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenter;
import com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterDAO;
import com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterTokens;
import com.youbenben.youbenben.catalog.Catalog;
import com.youbenben.youbenben.catalog.CatalogDAO;
import com.youbenben.youbenben.catalog.CatalogTokens;
import com.youbenben.youbenben.levelonecategory.LevelOneCategory;
import com.youbenben.youbenben.levelonecategory.LevelOneCategoryDAO;
import com.youbenben.youbenben.levelonecategory.LevelOneCategoryTokens;
import com.youbenben.youbenben.leveltwocategory.LevelTwoCategory;
import com.youbenben.youbenben.leveltwocategory.LevelTwoCategoryDAO;
import com.youbenben.youbenben.leveltwocategory.LevelTwoCategoryTokens;
import com.youbenben.youbenben.levelthreecategory.LevelThreeCategory;
import com.youbenben.youbenben.levelthreecategory.LevelThreeCategoryDAO;
import com.youbenben.youbenben.levelthreecategory.LevelThreeCategoryTokens;
import com.youbenben.youbenben.product.Product;
import com.youbenben.youbenben.product.ProductDAO;
import com.youbenben.youbenben.product.ProductTokens;
import com.youbenben.youbenben.sku.Sku;
import com.youbenben.youbenben.sku.SkuDAO;
import com.youbenben.youbenben.sku.SkuTokens;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenterTokens;
import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartment;
import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartmentDAO;
import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartmentTokens;
import com.youbenben.youbenben.citycenteremployee.CityCenterEmployee;
import com.youbenben.youbenben.citycenteremployee.CityCenterEmployeeDAO;
import com.youbenben.youbenben.citycenteremployee.CityCenterEmployeeTokens;
import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;
import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterDAO;
import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterTokens;
import com.youbenben.youbenben.citypartner.CityPartner;
import com.youbenben.youbenben.citypartner.CityPartnerDAO;
import com.youbenben.youbenben.citypartner.CityPartnerTokens;
import com.youbenben.youbenben.potentialcustomer.PotentialCustomer;
import com.youbenben.youbenben.potentialcustomer.PotentialCustomerDAO;
import com.youbenben.youbenben.potentialcustomer.PotentialCustomerTokens;
import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPersonDAO;
import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPersonTokens;
import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContact;
import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContactDAO;
import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContactTokens;
import com.youbenben.youbenben.cityevent.CityEvent;
import com.youbenben.youbenben.cityevent.CityEventDAO;
import com.youbenben.youbenben.cityevent.CityEventTokens;
import com.youbenben.youbenben.eventattendance.EventAttendance;
import com.youbenben.youbenben.eventattendance.EventAttendanceDAO;
import com.youbenben.youbenben.eventattendance.EventAttendanceTokens;
import com.youbenben.youbenben.mobileapp.MobileApp;
import com.youbenben.youbenben.mobileapp.MobileAppDAO;
import com.youbenben.youbenben.mobileapp.MobileAppTokens;
import com.youbenben.youbenben.page.Page;
import com.youbenben.youbenben.page.PageDAO;
import com.youbenben.youbenben.page.PageTokens;
import com.youbenben.youbenben.pagetype.PageType;
import com.youbenben.youbenben.pagetype.PageTypeDAO;
import com.youbenben.youbenben.pagetype.PageTypeTokens;
import com.youbenben.youbenben.slide.Slide;
import com.youbenben.youbenben.slide.SlideDAO;
import com.youbenben.youbenben.slide.SlideTokens;
import com.youbenben.youbenben.uiaction.UiAction;
import com.youbenben.youbenben.uiaction.UiActionDAO;
import com.youbenben.youbenben.uiaction.UiActionTokens;
import com.youbenben.youbenben.section.Section;
import com.youbenben.youbenben.section.SectionDAO;
import com.youbenben.youbenben.section.SectionTokens;
import com.youbenben.youbenben.userdomain.UserDomain;
import com.youbenben.youbenben.userdomain.UserDomainDAO;
import com.youbenben.youbenben.userdomain.UserDomainTokens;
import com.youbenben.youbenben.userwhitelist.UserWhiteList;
import com.youbenben.youbenben.userwhitelist.UserWhiteListDAO;
import com.youbenben.youbenben.userwhitelist.UserWhiteListTokens;
import com.youbenben.youbenben.secuser.SecUser;
import com.youbenben.youbenben.secuser.SecUserDAO;
import com.youbenben.youbenben.secuser.SecUserTokens;
import com.youbenben.youbenben.userapp.UserApp;
import com.youbenben.youbenben.userapp.UserAppDAO;
import com.youbenben.youbenben.userapp.UserAppTokens;
import com.youbenben.youbenben.quicklink.QuickLink;
import com.youbenben.youbenben.quicklink.QuickLinkDAO;
import com.youbenben.youbenben.quicklink.QuickLinkTokens;
import com.youbenben.youbenben.listaccess.ListAccess;
import com.youbenben.youbenben.listaccess.ListAccessDAO;
import com.youbenben.youbenben.listaccess.ListAccessTokens;
import com.youbenben.youbenben.loginhistory.LoginHistory;
import com.youbenben.youbenben.loginhistory.LoginHistoryDAO;
import com.youbenben.youbenben.loginhistory.LoginHistoryTokens;
import com.youbenben.youbenben.candidatecontainer.CandidateContainer;
import com.youbenben.youbenben.candidatecontainer.CandidateContainerDAO;
import com.youbenben.youbenben.candidatecontainer.CandidateContainerTokens;
import com.youbenben.youbenben.candidateelement.CandidateElement;
import com.youbenben.youbenben.candidateelement.CandidateElementDAO;
import com.youbenben.youbenben.candidateelement.CandidateElementTokens;
import com.youbenben.youbenben.wechatworkappidentify.WechatWorkappIdentify;
import com.youbenben.youbenben.wechatworkappidentify.WechatWorkappIdentifyDAO;
import com.youbenben.youbenben.wechatworkappidentify.WechatWorkappIdentifyTokens;
import com.youbenben.youbenben.wechatminiappidentify.WechatMiniappIdentify;
import com.youbenben.youbenben.wechatminiappidentify.WechatMiniappIdentifyDAO;
import com.youbenben.youbenben.wechatminiappidentify.WechatMiniappIdentifyTokens;
import com.youbenben.youbenben.keypairidentify.KeypairIdentify;
import com.youbenben.youbenben.keypairidentify.KeypairIdentifyDAO;
import com.youbenben.youbenben.keypairidentify.KeypairIdentifyTokens;
import com.youbenben.youbenben.publickeytype.PublicKeyType;
import com.youbenben.youbenben.publickeytype.PublicKeyTypeDAO;
import com.youbenben.youbenben.publickeytype.PublicKeyTypeTokens;
import com.youbenben.youbenben.treenode.TreeNode;
import com.youbenben.youbenben.treenode.TreeNodeDAO;
import com.youbenben.youbenben.treenode.TreeNodeTokens;

public class DAOGroup {

	protected FranchisedOutletProvinceCenterDAO franchisedOutletProvinceCenterDAO;

	protected CatalogDAO catalogDAO;

	protected LevelOneCategoryDAO levelOneCategoryDAO;

	protected LevelTwoCategoryDAO levelTwoCategoryDAO;

	protected LevelThreeCategoryDAO levelThreeCategoryDAO;

	protected ProductDAO productDAO;

	protected SkuDAO skuDAO;

	protected FranchisedOutletCityCenterDAO franchisedOutletCityCenterDAO;

	protected CityCenterDepartmentDAO cityCenterDepartmentDAO;

	protected CityCenterEmployeeDAO cityCenterEmployeeDAO;

	protected FranchisedOutletCityServiceCenterDAO franchisedOutletCityServiceCenterDAO;

	protected CityPartnerDAO cityPartnerDAO;

	protected PotentialCustomerDAO potentialCustomerDAO;

	protected PotentialCustomerContactPersonDAO potentialCustomerContactPersonDAO;

	protected PotentialCustomerContactDAO potentialCustomerContactDAO;

	protected CityEventDAO cityEventDAO;

	protected EventAttendanceDAO eventAttendanceDAO;

	protected MobileAppDAO mobileAppDAO;

	protected PageDAO pageDAO;

	protected PageTypeDAO pageTypeDAO;

	protected SlideDAO slideDAO;

	protected UiActionDAO uiActionDAO;

	protected SectionDAO sectionDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserWhiteListDAO userWhiteListDAO;

	protected SecUserDAO secUserDAO;

	protected UserAppDAO userAppDAO;

	protected QuickLinkDAO quickLinkDAO;

	protected ListAccessDAO listAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected CandidateContainerDAO candidateContainerDAO;

	protected CandidateElementDAO candidateElementDAO;

	protected WechatWorkappIdentifyDAO wechatWorkappIdentifyDAO;

	protected WechatMiniappIdentifyDAO wechatMiniappIdentifyDAO;

	protected KeypairIdentifyDAO keypairIdentifyDAO;

	protected PublicKeyTypeDAO publicKeyTypeDAO;

	protected TreeNodeDAO treeNodeDAO;



	public FranchisedOutletProvinceCenterDAO getFranchisedOutletProvinceCenterDAO(){
		return this.franchisedOutletProvinceCenterDAO;
	}
	public void setFranchisedOutletProvinceCenterDAO(FranchisedOutletProvinceCenterDAO dao){
		this.franchisedOutletProvinceCenterDAO = dao;
	}


	public CatalogDAO getCatalogDAO(){
		return this.catalogDAO;
	}
	public void setCatalogDAO(CatalogDAO dao){
		this.catalogDAO = dao;
	}


	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
		return this.levelOneCategoryDAO;
	}
	public void setLevelOneCategoryDAO(LevelOneCategoryDAO dao){
		this.levelOneCategoryDAO = dao;
	}


	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
		return this.levelTwoCategoryDAO;
	}
	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO dao){
		this.levelTwoCategoryDAO = dao;
	}


	public LevelThreeCategoryDAO getLevelThreeCategoryDAO(){
		return this.levelThreeCategoryDAO;
	}
	public void setLevelThreeCategoryDAO(LevelThreeCategoryDAO dao){
		this.levelThreeCategoryDAO = dao;
	}


	public ProductDAO getProductDAO(){
		return this.productDAO;
	}
	public void setProductDAO(ProductDAO dao){
		this.productDAO = dao;
	}


	public SkuDAO getSkuDAO(){
		return this.skuDAO;
	}
	public void setSkuDAO(SkuDAO dao){
		this.skuDAO = dao;
	}


	public FranchisedOutletCityCenterDAO getFranchisedOutletCityCenterDAO(){
		return this.franchisedOutletCityCenterDAO;
	}
	public void setFranchisedOutletCityCenterDAO(FranchisedOutletCityCenterDAO dao){
		this.franchisedOutletCityCenterDAO = dao;
	}


	public CityCenterDepartmentDAO getCityCenterDepartmentDAO(){
		return this.cityCenterDepartmentDAO;
	}
	public void setCityCenterDepartmentDAO(CityCenterDepartmentDAO dao){
		this.cityCenterDepartmentDAO = dao;
	}


	public CityCenterEmployeeDAO getCityCenterEmployeeDAO(){
		return this.cityCenterEmployeeDAO;
	}
	public void setCityCenterEmployeeDAO(CityCenterEmployeeDAO dao){
		this.cityCenterEmployeeDAO = dao;
	}


	public FranchisedOutletCityServiceCenterDAO getFranchisedOutletCityServiceCenterDAO(){
		return this.franchisedOutletCityServiceCenterDAO;
	}
	public void setFranchisedOutletCityServiceCenterDAO(FranchisedOutletCityServiceCenterDAO dao){
		this.franchisedOutletCityServiceCenterDAO = dao;
	}


	public CityPartnerDAO getCityPartnerDAO(){
		return this.cityPartnerDAO;
	}
	public void setCityPartnerDAO(CityPartnerDAO dao){
		this.cityPartnerDAO = dao;
	}


	public PotentialCustomerDAO getPotentialCustomerDAO(){
		return this.potentialCustomerDAO;
	}
	public void setPotentialCustomerDAO(PotentialCustomerDAO dao){
		this.potentialCustomerDAO = dao;
	}


	public PotentialCustomerContactPersonDAO getPotentialCustomerContactPersonDAO(){
		return this.potentialCustomerContactPersonDAO;
	}
	public void setPotentialCustomerContactPersonDAO(PotentialCustomerContactPersonDAO dao){
		this.potentialCustomerContactPersonDAO = dao;
	}


	public PotentialCustomerContactDAO getPotentialCustomerContactDAO(){
		return this.potentialCustomerContactDAO;
	}
	public void setPotentialCustomerContactDAO(PotentialCustomerContactDAO dao){
		this.potentialCustomerContactDAO = dao;
	}


	public CityEventDAO getCityEventDAO(){
		return this.cityEventDAO;
	}
	public void setCityEventDAO(CityEventDAO dao){
		this.cityEventDAO = dao;
	}


	public EventAttendanceDAO getEventAttendanceDAO(){
		return this.eventAttendanceDAO;
	}
	public void setEventAttendanceDAO(EventAttendanceDAO dao){
		this.eventAttendanceDAO = dao;
	}


	public MobileAppDAO getMobileAppDAO(){
		return this.mobileAppDAO;
	}
	public void setMobileAppDAO(MobileAppDAO dao){
		this.mobileAppDAO = dao;
	}


	public PageDAO getPageDAO(){
		return this.pageDAO;
	}
	public void setPageDAO(PageDAO dao){
		this.pageDAO = dao;
	}


	public PageTypeDAO getPageTypeDAO(){
		return this.pageTypeDAO;
	}
	public void setPageTypeDAO(PageTypeDAO dao){
		this.pageTypeDAO = dao;
	}


	public SlideDAO getSlideDAO(){
		return this.slideDAO;
	}
	public void setSlideDAO(SlideDAO dao){
		this.slideDAO = dao;
	}


	public UiActionDAO getUiActionDAO(){
		return this.uiActionDAO;
	}
	public void setUiActionDAO(UiActionDAO dao){
		this.uiActionDAO = dao;
	}


	public SectionDAO getSectionDAO(){
		return this.sectionDAO;
	}
	public void setSectionDAO(SectionDAO dao){
		this.sectionDAO = dao;
	}


	public UserDomainDAO getUserDomainDAO(){
		return this.userDomainDAO;
	}
	public void setUserDomainDAO(UserDomainDAO dao){
		this.userDomainDAO = dao;
	}


	public UserWhiteListDAO getUserWhiteListDAO(){
		return this.userWhiteListDAO;
	}
	public void setUserWhiteListDAO(UserWhiteListDAO dao){
		this.userWhiteListDAO = dao;
	}


	public SecUserDAO getSecUserDAO(){
		return this.secUserDAO;
	}
	public void setSecUserDAO(SecUserDAO dao){
		this.secUserDAO = dao;
	}


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public QuickLinkDAO getQuickLinkDAO(){
		return this.quickLinkDAO;
	}
	public void setQuickLinkDAO(QuickLinkDAO dao){
		this.quickLinkDAO = dao;
	}


	public ListAccessDAO getListAccessDAO(){
		return this.listAccessDAO;
	}
	public void setListAccessDAO(ListAccessDAO dao){
		this.listAccessDAO = dao;
	}


	public LoginHistoryDAO getLoginHistoryDAO(){
		return this.loginHistoryDAO;
	}
	public void setLoginHistoryDAO(LoginHistoryDAO dao){
		this.loginHistoryDAO = dao;
	}


	public CandidateContainerDAO getCandidateContainerDAO(){
		return this.candidateContainerDAO;
	}
	public void setCandidateContainerDAO(CandidateContainerDAO dao){
		this.candidateContainerDAO = dao;
	}


	public CandidateElementDAO getCandidateElementDAO(){
		return this.candidateElementDAO;
	}
	public void setCandidateElementDAO(CandidateElementDAO dao){
		this.candidateElementDAO = dao;
	}


	public WechatWorkappIdentifyDAO getWechatWorkappIdentifyDAO(){
		return this.wechatWorkappIdentifyDAO;
	}
	public void setWechatWorkappIdentifyDAO(WechatWorkappIdentifyDAO dao){
		this.wechatWorkappIdentifyDAO = dao;
	}


	public WechatMiniappIdentifyDAO getWechatMiniappIdentifyDAO(){
		return this.wechatMiniappIdentifyDAO;
	}
	public void setWechatMiniappIdentifyDAO(WechatMiniappIdentifyDAO dao){
		this.wechatMiniappIdentifyDAO = dao;
	}


	public KeypairIdentifyDAO getKeypairIdentifyDAO(){
		return this.keypairIdentifyDAO;
	}
	public void setKeypairIdentifyDAO(KeypairIdentifyDAO dao){
		this.keypairIdentifyDAO = dao;
	}


	public PublicKeyTypeDAO getPublicKeyTypeDAO(){
		return this.publicKeyTypeDAO;
	}
	public void setPublicKeyTypeDAO(PublicKeyTypeDAO dao){
		this.publicKeyTypeDAO = dao;
	}


	public TreeNodeDAO getTreeNodeDAO(){
		return this.treeNodeDAO;
	}
	public void setTreeNodeDAO(TreeNodeDAO dao){
		this.treeNodeDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    void enhanceList(DAOGroup daoGoup, List list) throws Exception;
	    List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> list) throws Exception;
	    BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception;
	    BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception;
	    SmartList<? extends BaseEntity> queryList(DAOGroup daoGoup, String sql, Object... parmeters) throws Exception;
	}
	private static Map<String, BasicLoader> internalLoaderMap;
	static {
		internalLoaderMap = new HashMap<String, BasicLoader>();

		internalLoaderMap.put("FranchisedOutletProvinceCenter", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFranchisedOutletProvinceCenterDAO().load(id, FranchisedOutletProvinceCenterTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFranchisedOutletProvinceCenterDAO().enhanceList((List<FranchisedOutletProvinceCenter>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFranchisedOutletProvinceCenterDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFranchisedOutletProvinceCenterDAO().present((FranchisedOutletProvinceCenter)data, tokens);
			}
			@Override
			public SmartList<FranchisedOutletProvinceCenter> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getFranchisedOutletProvinceCenterDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)FranchisedOutletProvinceCenter.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Catalog", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCatalogDAO().load(id, CatalogTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCatalogDAO().enhanceList((List<Catalog>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCatalogDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCatalogDAO().present((Catalog)data, tokens);
			}
			@Override
			public SmartList<Catalog> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCatalogDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Catalog.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LevelOneCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().load(id, LevelOneCategoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLevelOneCategoryDAO().enhanceList((List<LevelOneCategory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().present((LevelOneCategory)data, tokens);
			}
			@Override
			public SmartList<LevelOneCategory> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LevelOneCategory.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LevelTwoCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().load(id, LevelTwoCategoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLevelTwoCategoryDAO().enhanceList((List<LevelTwoCategory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().present((LevelTwoCategory)data, tokens);
			}
			@Override
			public SmartList<LevelTwoCategory> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LevelTwoCategory.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LevelThreeCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelThreeCategoryDAO().load(id, LevelThreeCategoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLevelThreeCategoryDAO().enhanceList((List<LevelThreeCategory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelThreeCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelThreeCategoryDAO().present((LevelThreeCategory)data, tokens);
			}
			@Override
			public SmartList<LevelThreeCategory> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLevelThreeCategoryDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LevelThreeCategory.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Product", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProductDAO().load(id, ProductTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getProductDAO().enhanceList((List<Product>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductDAO().present((Product)data, tokens);
			}
			@Override
			public SmartList<Product> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getProductDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Product.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Sku", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSkuDAO().load(id, SkuTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSkuDAO().enhanceList((List<Sku>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSkuDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSkuDAO().present((Sku)data, tokens);
			}
			@Override
			public SmartList<Sku> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSkuDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Sku.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("FranchisedOutletCityCenter", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFranchisedOutletCityCenterDAO().load(id, FranchisedOutletCityCenterTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFranchisedOutletCityCenterDAO().enhanceList((List<FranchisedOutletCityCenter>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFranchisedOutletCityCenterDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFranchisedOutletCityCenterDAO().present((FranchisedOutletCityCenter)data, tokens);
			}
			@Override
			public SmartList<FranchisedOutletCityCenter> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getFranchisedOutletCityCenterDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)FranchisedOutletCityCenter.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CityCenterDepartment", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCityCenterDepartmentDAO().load(id, CityCenterDepartmentTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCityCenterDepartmentDAO().enhanceList((List<CityCenterDepartment>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityCenterDepartmentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityCenterDepartmentDAO().present((CityCenterDepartment)data, tokens);
			}
			@Override
			public SmartList<CityCenterDepartment> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCityCenterDepartmentDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CityCenterDepartment.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CityCenterEmployee", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCityCenterEmployeeDAO().load(id, CityCenterEmployeeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCityCenterEmployeeDAO().enhanceList((List<CityCenterEmployee>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityCenterEmployeeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityCenterEmployeeDAO().present((CityCenterEmployee)data, tokens);
			}
			@Override
			public SmartList<CityCenterEmployee> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCityCenterEmployeeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CityCenterEmployee.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("FranchisedOutletCityServiceCenter", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFranchisedOutletCityServiceCenterDAO().load(id, FranchisedOutletCityServiceCenterTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFranchisedOutletCityServiceCenterDAO().enhanceList((List<FranchisedOutletCityServiceCenter>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFranchisedOutletCityServiceCenterDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFranchisedOutletCityServiceCenterDAO().present((FranchisedOutletCityServiceCenter)data, tokens);
			}
			@Override
			public SmartList<FranchisedOutletCityServiceCenter> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getFranchisedOutletCityServiceCenterDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)FranchisedOutletCityServiceCenter.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CityPartner", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCityPartnerDAO().load(id, CityPartnerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCityPartnerDAO().enhanceList((List<CityPartner>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityPartnerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityPartnerDAO().present((CityPartner)data, tokens);
			}
			@Override
			public SmartList<CityPartner> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCityPartnerDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CityPartner.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PotentialCustomer", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPotentialCustomerDAO().load(id, PotentialCustomerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPotentialCustomerDAO().enhanceList((List<PotentialCustomer>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerDAO().present((PotentialCustomer)data, tokens);
			}
			@Override
			public SmartList<PotentialCustomer> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPotentialCustomerDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PotentialCustomer.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PotentialCustomerContactPerson", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPotentialCustomerContactPersonDAO().load(id, PotentialCustomerContactPersonTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPotentialCustomerContactPersonDAO().enhanceList((List<PotentialCustomerContactPerson>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerContactPersonDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerContactPersonDAO().present((PotentialCustomerContactPerson)data, tokens);
			}
			@Override
			public SmartList<PotentialCustomerContactPerson> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPotentialCustomerContactPersonDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PotentialCustomerContactPerson.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PotentialCustomerContact", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPotentialCustomerContactDAO().load(id, PotentialCustomerContactTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPotentialCustomerContactDAO().enhanceList((List<PotentialCustomerContact>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerContactDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerContactDAO().present((PotentialCustomerContact)data, tokens);
			}
			@Override
			public SmartList<PotentialCustomerContact> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPotentialCustomerContactDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PotentialCustomerContact.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CityEvent", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCityEventDAO().load(id, CityEventTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCityEventDAO().enhanceList((List<CityEvent>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityEventDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityEventDAO().present((CityEvent)data, tokens);
			}
			@Override
			public SmartList<CityEvent> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCityEventDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CityEvent.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EventAttendance", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEventAttendanceDAO().load(id, EventAttendanceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEventAttendanceDAO().enhanceList((List<EventAttendance>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEventAttendanceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEventAttendanceDAO().present((EventAttendance)data, tokens);
			}
			@Override
			public SmartList<EventAttendance> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEventAttendanceDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EventAttendance.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("MobileApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getMobileAppDAO().load(id, MobileAppTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getMobileAppDAO().enhanceList((List<MobileApp>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMobileAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMobileAppDAO().present((MobileApp)data, tokens);
			}
			@Override
			public SmartList<MobileApp> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getMobileAppDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)MobileApp.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Page", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPageDAO().load(id, PageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPageDAO().enhanceList((List<Page>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageDAO().present((Page)data, tokens);
			}
			@Override
			public SmartList<Page> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPageDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Page.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PageType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPageTypeDAO().load(id, PageTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPageTypeDAO().enhanceList((List<PageType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageTypeDAO().present((PageType)data, tokens);
			}
			@Override
			public SmartList<PageType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPageTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PageType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Slide", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSlideDAO().load(id, SlideTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSlideDAO().enhanceList((List<Slide>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSlideDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSlideDAO().present((Slide)data, tokens);
			}
			@Override
			public SmartList<Slide> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSlideDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Slide.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UiAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUiActionDAO().load(id, UiActionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUiActionDAO().enhanceList((List<UiAction>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUiActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUiActionDAO().present((UiAction)data, tokens);
			}
			@Override
			public SmartList<UiAction> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUiActionDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UiAction.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Section", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSectionDAO().load(id, SectionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSectionDAO().enhanceList((List<Section>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSectionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSectionDAO().present((Section)data, tokens);
			}
			@Override
			public SmartList<Section> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSectionDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Section.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserDomainDAO().enhanceList((List<UserDomain>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
			@Override
			public SmartList<UserDomain> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUserDomainDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UserDomain.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserWhiteList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, UserWhiteListTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserWhiteListDAO().enhanceList((List<UserWhiteList>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().present((UserWhiteList)data, tokens);
			}
			@Override
			public SmartList<UserWhiteList> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUserWhiteListDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UserWhiteList.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSecUserDAO().enhanceList((List<SecUser>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
			@Override
			public SmartList<SecUser> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSecUserDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SecUser.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserAppDAO().enhanceList((List<UserApp>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
			@Override
			public SmartList<UserApp> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUserAppDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UserApp.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("QuickLink", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, QuickLinkTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getQuickLinkDAO().enhanceList((List<QuickLink>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().present((QuickLink)data, tokens);
			}
			@Override
			public SmartList<QuickLink> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getQuickLinkDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)QuickLink.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getListAccessDAO().enhanceList((List<ListAccess>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
			@Override
			public SmartList<ListAccess> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getListAccessDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ListAccess.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLoginHistoryDAO().enhanceList((List<LoginHistory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
			@Override
			public SmartList<LoginHistory> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLoginHistoryDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LoginHistory.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CandidateContainer", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, CandidateContainerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateContainerDAO().enhanceList((List<CandidateContainer>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().present((CandidateContainer)data, tokens);
			}
			@Override
			public SmartList<CandidateContainer> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCandidateContainerDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CandidateContainer.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CandidateElement", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, CandidateElementTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateElementDAO().enhanceList((List<CandidateElement>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().present((CandidateElement)data, tokens);
			}
			@Override
			public SmartList<CandidateElement> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCandidateElementDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CandidateElement.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("WechatWorkappIdentify", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().load(id, WechatWorkappIdentifyTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWechatWorkappIdentifyDAO().enhanceList((List<WechatWorkappIdentify>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().present((WechatWorkappIdentify)data, tokens);
			}
			@Override
			public SmartList<WechatWorkappIdentify> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)WechatWorkappIdentify.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("WechatMiniappIdentify", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().load(id, WechatMiniappIdentifyTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWechatMiniappIdentifyDAO().enhanceList((List<WechatMiniappIdentify>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().present((WechatMiniappIdentify)data, tokens);
			}
			@Override
			public SmartList<WechatMiniappIdentify> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)WechatMiniappIdentify.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("KeypairIdentify", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getKeypairIdentifyDAO().load(id, KeypairIdentifyTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getKeypairIdentifyDAO().enhanceList((List<KeypairIdentify>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getKeypairIdentifyDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getKeypairIdentifyDAO().present((KeypairIdentify)data, tokens);
			}
			@Override
			public SmartList<KeypairIdentify> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getKeypairIdentifyDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)KeypairIdentify.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PublicKeyType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPublicKeyTypeDAO().load(id, PublicKeyTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPublicKeyTypeDAO().enhanceList((List<PublicKeyType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPublicKeyTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPublicKeyTypeDAO().present((PublicKeyType)data, tokens);
			}
			@Override
			public SmartList<PublicKeyType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPublicKeyTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PublicKeyType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TreeNode", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTreeNodeDAO().load(id, TreeNodeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTreeNodeDAO().enhanceList((List<TreeNode>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTreeNodeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTreeNodeDAO().present((TreeNode)data, tokens);
			}
			@Override
			public SmartList<TreeNode> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTreeNodeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TreeNode.withId(id)).collect(Collectors.toList());
			}
		});

	}
	public BaseEntity loadBasicData(String type, String id){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicData(this, id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}

	public List<BaseEntity> wrapperList(String type, List<String> ids){
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return null;
  	    }
  	    try{
  	    	return loader.wrapperList(this, ids);
  	    }catch(Exception e) {
  	    	e.printStackTrace();
  	    	return null;
  	    }
  	}

	public BaseEntity loadBasicDataWithTokens(String type, String id, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicDataWithToken(this, id, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity present(BaseEntity data, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(data.getInternalType());
	    if (loader == null || data == null) {
	    	return null;
	    }
	    try{
	    	return loader.present(this, data, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public <T> void enhanceList(List list, Class<T> clazz) throws Exception{
	    BasicLoader loader = internalLoaderMap.get(clazz.getSimpleName());
	    if (loader == null) {
	    	return ;
	    }

	    loader.enhanceList(this, list);
	}

	public void enhanceList(List list, String type) throws Exception{
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return ;
  	    }

  	    loader.enhanceList(this, list);
  	}
  	
  	public SmartList<? extends BaseEntity> queryList(String type, String sql, Object ... parameters) throws Exception{
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return new SmartList();
  	    }

  	    return loader.queryList(this, sql, parameters);
  	}
}

