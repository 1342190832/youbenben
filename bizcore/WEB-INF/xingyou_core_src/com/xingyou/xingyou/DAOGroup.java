package com.xingyou.xingyou;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import com.xingyou.xingyou.franchisedoutletprovincecenter.FranchisedOutletProvinceCenter;
import com.xingyou.xingyou.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterDAO;
import com.xingyou.xingyou.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterTokens;
import com.xingyou.xingyou.catalog.Catalog;
import com.xingyou.xingyou.catalog.CatalogDAO;
import com.xingyou.xingyou.catalog.CatalogTokens;
import com.xingyou.xingyou.levelonecategory.LevelOneCategory;
import com.xingyou.xingyou.levelonecategory.LevelOneCategoryDAO;
import com.xingyou.xingyou.levelonecategory.LevelOneCategoryTokens;
import com.xingyou.xingyou.leveltwocategory.LevelTwoCategory;
import com.xingyou.xingyou.leveltwocategory.LevelTwoCategoryDAO;
import com.xingyou.xingyou.leveltwocategory.LevelTwoCategoryTokens;
import com.xingyou.xingyou.levelthreecategory.LevelThreeCategory;
import com.xingyou.xingyou.levelthreecategory.LevelThreeCategoryDAO;
import com.xingyou.xingyou.levelthreecategory.LevelThreeCategoryTokens;
import com.xingyou.xingyou.product.Product;
import com.xingyou.xingyou.product.ProductDAO;
import com.xingyou.xingyou.product.ProductTokens;
import com.xingyou.xingyou.sku.Sku;
import com.xingyou.xingyou.sku.SkuDAO;
import com.xingyou.xingyou.sku.SkuTokens;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenterTokens;
import com.xingyou.xingyou.citycenterdepartment.CityCenterDepartment;
import com.xingyou.xingyou.citycenterdepartment.CityCenterDepartmentDAO;
import com.xingyou.xingyou.citycenterdepartment.CityCenterDepartmentTokens;
import com.xingyou.xingyou.citycenteremployee.CityCenterEmployee;
import com.xingyou.xingyou.citycenteremployee.CityCenterEmployeeDAO;
import com.xingyou.xingyou.citycenteremployee.CityCenterEmployeeTokens;
import com.xingyou.xingyou.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;
import com.xingyou.xingyou.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterDAO;
import com.xingyou.xingyou.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterTokens;
import com.xingyou.xingyou.citypartner.CityPartner;
import com.xingyou.xingyou.citypartner.CityPartnerDAO;
import com.xingyou.xingyou.citypartner.CityPartnerTokens;
import com.xingyou.xingyou.potentialcustomer.PotentialCustomer;
import com.xingyou.xingyou.potentialcustomer.PotentialCustomerDAO;
import com.xingyou.xingyou.potentialcustomer.PotentialCustomerTokens;
import com.xingyou.xingyou.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.xingyou.xingyou.potentialcustomercontactperson.PotentialCustomerContactPersonDAO;
import com.xingyou.xingyou.potentialcustomercontactperson.PotentialCustomerContactPersonTokens;
import com.xingyou.xingyou.potentialcustomercontact.PotentialCustomerContact;
import com.xingyou.xingyou.potentialcustomercontact.PotentialCustomerContactDAO;
import com.xingyou.xingyou.potentialcustomercontact.PotentialCustomerContactTokens;
import com.xingyou.xingyou.cityevent.CityEvent;
import com.xingyou.xingyou.cityevent.CityEventDAO;
import com.xingyou.xingyou.cityevent.CityEventTokens;
import com.xingyou.xingyou.eventattendance.EventAttendance;
import com.xingyou.xingyou.eventattendance.EventAttendanceDAO;
import com.xingyou.xingyou.eventattendance.EventAttendanceTokens;
import com.xingyou.xingyou.mobileapp.MobileApp;
import com.xingyou.xingyou.mobileapp.MobileAppDAO;
import com.xingyou.xingyou.mobileapp.MobileAppTokens;
import com.xingyou.xingyou.page.Page;
import com.xingyou.xingyou.page.PageDAO;
import com.xingyou.xingyou.page.PageTokens;
import com.xingyou.xingyou.pagetype.PageType;
import com.xingyou.xingyou.pagetype.PageTypeDAO;
import com.xingyou.xingyou.pagetype.PageTypeTokens;
import com.xingyou.xingyou.slide.Slide;
import com.xingyou.xingyou.slide.SlideDAO;
import com.xingyou.xingyou.slide.SlideTokens;
import com.xingyou.xingyou.uiaction.UiAction;
import com.xingyou.xingyou.uiaction.UiActionDAO;
import com.xingyou.xingyou.uiaction.UiActionTokens;
import com.xingyou.xingyou.section.Section;
import com.xingyou.xingyou.section.SectionDAO;
import com.xingyou.xingyou.section.SectionTokens;
import com.xingyou.xingyou.userdomain.UserDomain;
import com.xingyou.xingyou.userdomain.UserDomainDAO;
import com.xingyou.xingyou.userdomain.UserDomainTokens;
import com.xingyou.xingyou.userwhitelist.UserWhiteList;
import com.xingyou.xingyou.userwhitelist.UserWhiteListDAO;
import com.xingyou.xingyou.userwhitelist.UserWhiteListTokens;
import com.xingyou.xingyou.secuser.SecUser;
import com.xingyou.xingyou.secuser.SecUserDAO;
import com.xingyou.xingyou.secuser.SecUserTokens;
import com.xingyou.xingyou.userapp.UserApp;
import com.xingyou.xingyou.userapp.UserAppDAO;
import com.xingyou.xingyou.userapp.UserAppTokens;
import com.xingyou.xingyou.quicklink.QuickLink;
import com.xingyou.xingyou.quicklink.QuickLinkDAO;
import com.xingyou.xingyou.quicklink.QuickLinkTokens;
import com.xingyou.xingyou.listaccess.ListAccess;
import com.xingyou.xingyou.listaccess.ListAccessDAO;
import com.xingyou.xingyou.listaccess.ListAccessTokens;
import com.xingyou.xingyou.loginhistory.LoginHistory;
import com.xingyou.xingyou.loginhistory.LoginHistoryDAO;
import com.xingyou.xingyou.loginhistory.LoginHistoryTokens;
import com.xingyou.xingyou.candidatecontainer.CandidateContainer;
import com.xingyou.xingyou.candidatecontainer.CandidateContainerDAO;
import com.xingyou.xingyou.candidatecontainer.CandidateContainerTokens;
import com.xingyou.xingyou.candidateelement.CandidateElement;
import com.xingyou.xingyou.candidateelement.CandidateElementDAO;
import com.xingyou.xingyou.candidateelement.CandidateElementTokens;
import com.xingyou.xingyou.wechatworkappidentify.WechatWorkappIdentify;
import com.xingyou.xingyou.wechatworkappidentify.WechatWorkappIdentifyDAO;
import com.xingyou.xingyou.wechatworkappidentify.WechatWorkappIdentifyTokens;
import com.xingyou.xingyou.wechatminiappidentify.WechatMiniappIdentify;
import com.xingyou.xingyou.wechatminiappidentify.WechatMiniappIdentifyDAO;
import com.xingyou.xingyou.wechatminiappidentify.WechatMiniappIdentifyTokens;
import com.xingyou.xingyou.keypairidentify.KeypairIdentify;
import com.xingyou.xingyou.keypairidentify.KeypairIdentifyDAO;
import com.xingyou.xingyou.keypairidentify.KeypairIdentifyTokens;
import com.xingyou.xingyou.publickeytype.PublicKeyType;
import com.xingyou.xingyou.publickeytype.PublicKeyTypeDAO;
import com.xingyou.xingyou.publickeytype.PublicKeyTypeTokens;
import com.xingyou.xingyou.treenode.TreeNode;
import com.xingyou.xingyou.treenode.TreeNodeDAO;
import com.xingyou.xingyou.treenode.TreeNodeTokens;

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

