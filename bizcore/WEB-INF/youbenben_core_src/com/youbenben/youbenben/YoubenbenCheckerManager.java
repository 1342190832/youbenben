package com.youbenben.youbenben;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.uccaf.BaseUserContext;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class YoubenbenCheckerManager extends BaseManagerImpl {
	public SmartList<BaseEntity> requestCandidateValuesForSearch(YoubenbenUserContext ctx, String ownerMemberName,
			String ownerId, String resultMemberName, String resutlClassName, String targetClassName, String filterKey, int pageNo) {
		return ((BaseDAO)daoOf(ctx)).requestCandidateValuesForSearch(ownerMemberName, ownerId, resultMemberName,
				resutlClassName, targetClassName, filterKey, pageNo);
	}
	
	protected Object daoOf(YoubenbenUserContext ctx) {
		throw new UnsupportedOperationException("You must implement it in your specific Manager implementation");
	}
	
	
	public Object queryCandidates(YoubenbenUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidates(userContext, query);
	}
	
	public Object queryCandidatesForAssign(YoubenbenUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidatesForAssign(userContext, query);
	}

	public Object queryCandidatesForSearch(YoubenbenUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidatesForSearch(userContext, query);
	}
	
	protected YoubenbenObjectChecker checkerOf(YoubenbenUserContext ctx) {
		return ctx.getChecker();
	}
	private static class AsyncManagerJob extends Thread {
		protected Object me;
		protected Object proxy;
		protected Method method;
		protected Object[] args;
		protected MethodProxy methodProxy;

		public AsyncManagerJob(Object me, Object proxy, Method method, Object[] args, MethodProxy methodProxy) {
			super();
			this.me = me;
			this.proxy = proxy;
			this.method = method;
			this.args = args;
			this.methodProxy = methodProxy;
		}

		@Override
		public void run() {
			try {
				method.setAccessible(true);
				method.invoke(me, args);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final Map<String, Object> EO = new HashMap<>();
	protected Object asyncProxy = null;
	protected Object getAsyncProxy() {
		if (asyncProxy != null) {
			return asyncProxy;
		}
		
		Object me = this;
		MethodInterceptor proxy = new MethodInterceptor() {

			@Override
			public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				new AsyncManagerJob(me, proxyObj, method, args, methodProxy).start();
				return null;
			}
		};
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(me.getClass());
		enhancer.setCallback(proxy);
		return asyncProxy = enhancer.create();
	}
	
	protected void cacheVerifyCode(YoubenbenUserContext ctx, String mobile, String verifyCode) {
		String cacheKey = String.format("vcode:%s:%s", mobile, "login");
		ctx.putToCache(cacheKey, verifyCode, YoubenbenBaseConstants.DEFAULT_CACHE_TIME_FOR_VCODE);
	}

	protected String getVerifyCodeFromCache(YoubenbenUserContext ctx, String mobile) {
		String cacheKey = String.format("vcode:%s:%s", mobile, "login");
		return (String) ctx.getCachedObject(cacheKey, String.class);
	}
	protected void checkVerifyCode(YoubenbenUserContext ctx, String inputVerifyCode, String mobile) throws Exception {
		String cachedVerifyCode = getVerifyCodeFromCache(ctx, mobile);
		if (cachedVerifyCode == null) {
			throw new Exception("请先获取验证码");
		}
		if (!cachedVerifyCode.equals(inputVerifyCode)) {
			throw new Exception("验证码不正确");
		}
	}
	
	public com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterManager franchisedOutletProvinceCenterManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getFranchisedOutletProvinceCenterManager();
	}
	public com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterDAO franchisedOutletProvinceCenterDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getFranchisedOutletProvinceCenterDAO();
	}
	public com.youbenben.youbenben.catalog.CatalogManager catalogManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getCatalogManager();
	}
	public com.youbenben.youbenben.catalog.CatalogDAO catalogDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getCatalogDAO();
	}
	public com.youbenben.youbenben.levelonecategory.LevelOneCategoryManager levelOneCategoryManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getLevelOneCategoryManager();
	}
	public com.youbenben.youbenben.levelonecategory.LevelOneCategoryDAO levelOneCategoryDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getLevelOneCategoryDAO();
	}
	public com.youbenben.youbenben.leveltwocategory.LevelTwoCategoryManager levelTwoCategoryManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getLevelTwoCategoryManager();
	}
	public com.youbenben.youbenben.leveltwocategory.LevelTwoCategoryDAO levelTwoCategoryDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getLevelTwoCategoryDAO();
	}
	public com.youbenben.youbenben.levelthreecategory.LevelThreeCategoryManager levelThreeCategoryManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getLevelThreeCategoryManager();
	}
	public com.youbenben.youbenben.levelthreecategory.LevelThreeCategoryDAO levelThreeCategoryDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getLevelThreeCategoryDAO();
	}
	public com.youbenben.youbenben.product.ProductManager productManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getProductManager();
	}
	public com.youbenben.youbenben.product.ProductDAO productDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getProductDAO();
	}
	public com.youbenben.youbenben.sku.SkuManager skuManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSkuManager();
	}
	public com.youbenben.youbenben.sku.SkuDAO skuDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSkuDAO();
	}
	public com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenterManager franchisedOutletCityCenterManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getFranchisedOutletCityCenterManager();
	}
	public com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO franchisedOutletCityCenterDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getFranchisedOutletCityCenterDAO();
	}
	public com.youbenben.youbenben.citycenterdepartment.CityCenterDepartmentManager cityCenterDepartmentManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getCityCenterDepartmentManager();
	}
	public com.youbenben.youbenben.citycenterdepartment.CityCenterDepartmentDAO cityCenterDepartmentDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getCityCenterDepartmentDAO();
	}
	public com.youbenben.youbenben.citycenteremployee.CityCenterEmployeeManager cityCenterEmployeeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getCityCenterEmployeeManager();
	}
	public com.youbenben.youbenben.citycenteremployee.CityCenterEmployeeDAO cityCenterEmployeeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getCityCenterEmployeeDAO();
	}
	public com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterManager franchisedOutletCityServiceCenterManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getFranchisedOutletCityServiceCenterManager();
	}
	public com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterDAO franchisedOutletCityServiceCenterDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getFranchisedOutletCityServiceCenterDAO();
	}
	public com.youbenben.youbenben.citypartner.CityPartnerManager cityPartnerManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getCityPartnerManager();
	}
	public com.youbenben.youbenben.citypartner.CityPartnerDAO cityPartnerDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getCityPartnerDAO();
	}
	public com.youbenben.youbenben.potentialcustomer.PotentialCustomerManager potentialCustomerManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getPotentialCustomerManager();
	}
	public com.youbenben.youbenben.potentialcustomer.PotentialCustomerDAO potentialCustomerDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getPotentialCustomerDAO();
	}
	public com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPersonManager potentialCustomerContactPersonManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getPotentialCustomerContactPersonManager();
	}
	public com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPersonDAO potentialCustomerContactPersonDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getPotentialCustomerContactPersonDAO();
	}
	public com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContactManager potentialCustomerContactManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getPotentialCustomerContactManager();
	}
	public com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContactDAO potentialCustomerContactDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getPotentialCustomerContactDAO();
	}
	public com.youbenben.youbenben.cityevent.CityEventManager cityEventManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getCityEventManager();
	}
	public com.youbenben.youbenben.cityevent.CityEventDAO cityEventDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getCityEventDAO();
	}
	public com.youbenben.youbenben.eventattendance.EventAttendanceManager eventAttendanceManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEventAttendanceManager();
	}
	public com.youbenben.youbenben.eventattendance.EventAttendanceDAO eventAttendanceDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEventAttendanceDAO();
	}
	public com.youbenben.youbenben.mobileapp.MobileAppManager mobileAppManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getMobileAppManager();
	}
	public com.youbenben.youbenben.mobileapp.MobileAppDAO mobileAppDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getMobileAppDAO();
	}
	public com.youbenben.youbenben.page.PageManager pageManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getPageManager();
	}
	public com.youbenben.youbenben.page.PageDAO pageDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getPageDAO();
	}
	public com.youbenben.youbenben.pagetype.PageTypeManager pageTypeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getPageTypeManager();
	}
	public com.youbenben.youbenben.pagetype.PageTypeDAO pageTypeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getPageTypeDAO();
	}
	public com.youbenben.youbenben.slide.SlideManager slideManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSlideManager();
	}
	public com.youbenben.youbenben.slide.SlideDAO slideDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSlideDAO();
	}
	public com.youbenben.youbenben.uiaction.UiActionManager uiActionManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getUiActionManager();
	}
	public com.youbenben.youbenben.uiaction.UiActionDAO uiActionDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getUiActionDAO();
	}
	public com.youbenben.youbenben.section.SectionManager sectionManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSectionManager();
	}
	public com.youbenben.youbenben.section.SectionDAO sectionDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSectionDAO();
	}
	public com.youbenben.youbenben.userdomain.UserDomainManager userDomainManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getUserDomainManager();
	}
	public com.youbenben.youbenben.userdomain.UserDomainDAO userDomainDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getUserDomainDAO();
	}
	public com.youbenben.youbenben.userwhitelist.UserWhiteListManager userWhiteListManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getUserWhiteListManager();
	}
	public com.youbenben.youbenben.userwhitelist.UserWhiteListDAO userWhiteListDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getUserWhiteListDAO();
	}
	public com.youbenben.youbenben.secuser.SecUserManager secUserManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSecUserManager();
	}
	public com.youbenben.youbenben.secuser.SecUserDAO secUserDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSecUserDAO();
	}
	public com.youbenben.youbenben.userapp.UserAppManager userAppManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getUserAppManager();
	}
	public com.youbenben.youbenben.userapp.UserAppDAO userAppDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getUserAppDAO();
	}
	public com.youbenben.youbenben.quicklink.QuickLinkManager quickLinkManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getQuickLinkManager();
	}
	public com.youbenben.youbenben.quicklink.QuickLinkDAO quickLinkDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getQuickLinkDAO();
	}
	public com.youbenben.youbenben.listaccess.ListAccessManager listAccessManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getListAccessManager();
	}
	public com.youbenben.youbenben.listaccess.ListAccessDAO listAccessDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getListAccessDAO();
	}
	public com.youbenben.youbenben.loginhistory.LoginHistoryManager loginHistoryManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getLoginHistoryManager();
	}
	public com.youbenben.youbenben.loginhistory.LoginHistoryDAO loginHistoryDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getLoginHistoryDAO();
	}
	public com.youbenben.youbenben.candidatecontainer.CandidateContainerManager candidateContainerManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getCandidateContainerManager();
	}
	public com.youbenben.youbenben.candidatecontainer.CandidateContainerDAO candidateContainerDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getCandidateContainerDAO();
	}
	public com.youbenben.youbenben.candidateelement.CandidateElementManager candidateElementManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getCandidateElementManager();
	}
	public com.youbenben.youbenben.candidateelement.CandidateElementDAO candidateElementDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getCandidateElementDAO();
	}
	public com.youbenben.youbenben.wechatworkappidentify.WechatWorkappIdentifyManager wechatWorkappIdentifyManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getWechatWorkappIdentifyManager();
	}
	public com.youbenben.youbenben.wechatworkappidentify.WechatWorkappIdentifyDAO wechatWorkappIdentifyDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getWechatWorkappIdentifyDAO();
	}
	public com.youbenben.youbenben.wechatminiappidentify.WechatMiniappIdentifyManager wechatMiniappIdentifyManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getWechatMiniappIdentifyManager();
	}
	public com.youbenben.youbenben.wechatminiappidentify.WechatMiniappIdentifyDAO wechatMiniappIdentifyDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getWechatMiniappIdentifyDAO();
	}
	public com.youbenben.youbenben.keypairidentify.KeypairIdentifyManager keypairIdentifyManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getKeypairIdentifyManager();
	}
	public com.youbenben.youbenben.keypairidentify.KeypairIdentifyDAO keypairIdentifyDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getKeypairIdentifyDAO();
	}
	public com.youbenben.youbenben.publickeytype.PublicKeyTypeManager publicKeyTypeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getPublicKeyTypeManager();
	}
	public com.youbenben.youbenben.publickeytype.PublicKeyTypeDAO publicKeyTypeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getPublicKeyTypeDAO();
	}
	public com.youbenben.youbenben.treenode.TreeNodeManager treeNodeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getTreeNodeManager();
	}
	public com.youbenben.youbenben.treenode.TreeNodeDAO treeNodeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getTreeNodeDAO();
	}
	
	
	
	

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, YoubenbenException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}


















