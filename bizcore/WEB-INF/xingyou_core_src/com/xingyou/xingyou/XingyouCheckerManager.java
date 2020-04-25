package com.xingyou.xingyou;
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

public class XingyouCheckerManager extends BaseManagerImpl {
	public SmartList<BaseEntity> requestCandidateValuesForSearch(XingyouUserContext ctx, String ownerMemberName,
			String ownerId, String resultMemberName, String resutlClassName, String targetClassName, String filterKey, int pageNo) {
		return ((BaseDAO)daoOf(ctx)).requestCandidateValuesForSearch(ownerMemberName, ownerId, resultMemberName,
				resutlClassName, targetClassName, filterKey, pageNo);
	}
	
	protected Object daoOf(XingyouUserContext ctx) {
		throw new UnsupportedOperationException("You must implement it in your specific Manager implementation");
	}
	
	
	public Object queryCandidates(XingyouUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidates(userContext, query);
	}
	
	public Object queryCandidatesForAssign(XingyouUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidatesForAssign(userContext, query);
	}

	public Object queryCandidatesForSearch(XingyouUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidatesForSearch(userContext, query);
	}
	
	protected XingyouObjectChecker checkerOf(XingyouUserContext ctx) {
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
	
	protected void cacheVerifyCode(XingyouUserContext ctx, String mobile, String verifyCode) {
		String cacheKey = String.format("vcode:%s:%s", mobile, "login");
		ctx.putToCache(cacheKey, verifyCode, XingyouBaseConstants.DEFAULT_CACHE_TIME_FOR_VCODE);
	}

	protected String getVerifyCodeFromCache(XingyouUserContext ctx, String mobile) {
		String cacheKey = String.format("vcode:%s:%s", mobile, "login");
		return (String) ctx.getCachedObject(cacheKey, String.class);
	}
	protected void checkVerifyCode(XingyouUserContext ctx, String inputVerifyCode, String mobile) throws Exception {
		String cachedVerifyCode = getVerifyCodeFromCache(ctx, mobile);
		if (cachedVerifyCode == null) {
			throw new Exception("请先获取验证码");
		}
		if (!cachedVerifyCode.equals(inputVerifyCode)) {
			throw new Exception("验证码不正确");
		}
	}
	
	public com.xingyou.xingyou.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterManager franchisedOutletProvinceCenterManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getFranchisedOutletProvinceCenterManager();
	}
	public com.xingyou.xingyou.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterDAO franchisedOutletProvinceCenterDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getFranchisedOutletProvinceCenterDAO();
	}
	public com.xingyou.xingyou.catalog.CatalogManager catalogManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getCatalogManager();
	}
	public com.xingyou.xingyou.catalog.CatalogDAO catalogDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getCatalogDAO();
	}
	public com.xingyou.xingyou.levelonecategory.LevelOneCategoryManager levelOneCategoryManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getLevelOneCategoryManager();
	}
	public com.xingyou.xingyou.levelonecategory.LevelOneCategoryDAO levelOneCategoryDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getLevelOneCategoryDAO();
	}
	public com.xingyou.xingyou.leveltwocategory.LevelTwoCategoryManager levelTwoCategoryManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getLevelTwoCategoryManager();
	}
	public com.xingyou.xingyou.leveltwocategory.LevelTwoCategoryDAO levelTwoCategoryDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getLevelTwoCategoryDAO();
	}
	public com.xingyou.xingyou.levelthreecategory.LevelThreeCategoryManager levelThreeCategoryManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getLevelThreeCategoryManager();
	}
	public com.xingyou.xingyou.levelthreecategory.LevelThreeCategoryDAO levelThreeCategoryDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getLevelThreeCategoryDAO();
	}
	public com.xingyou.xingyou.product.ProductManager productManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getProductManager();
	}
	public com.xingyou.xingyou.product.ProductDAO productDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getProductDAO();
	}
	public com.xingyou.xingyou.sku.SkuManager skuManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getSkuManager();
	}
	public com.xingyou.xingyou.sku.SkuDAO skuDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getSkuDAO();
	}
	public com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenterManager franchisedOutletCityCenterManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getFranchisedOutletCityCenterManager();
	}
	public com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO franchisedOutletCityCenterDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getFranchisedOutletCityCenterDAO();
	}
	public com.xingyou.xingyou.citycenterdepartment.CityCenterDepartmentManager cityCenterDepartmentManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getCityCenterDepartmentManager();
	}
	public com.xingyou.xingyou.citycenterdepartment.CityCenterDepartmentDAO cityCenterDepartmentDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getCityCenterDepartmentDAO();
	}
	public com.xingyou.xingyou.citycenteremployee.CityCenterEmployeeManager cityCenterEmployeeManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getCityCenterEmployeeManager();
	}
	public com.xingyou.xingyou.citycenteremployee.CityCenterEmployeeDAO cityCenterEmployeeDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getCityCenterEmployeeDAO();
	}
	public com.xingyou.xingyou.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterManager franchisedOutletCityServiceCenterManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getFranchisedOutletCityServiceCenterManager();
	}
	public com.xingyou.xingyou.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterDAO franchisedOutletCityServiceCenterDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getFranchisedOutletCityServiceCenterDAO();
	}
	public com.xingyou.xingyou.citypartner.CityPartnerManager cityPartnerManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getCityPartnerManager();
	}
	public com.xingyou.xingyou.citypartner.CityPartnerDAO cityPartnerDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getCityPartnerDAO();
	}
	public com.xingyou.xingyou.potentialcustomer.PotentialCustomerManager potentialCustomerManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getPotentialCustomerManager();
	}
	public com.xingyou.xingyou.potentialcustomer.PotentialCustomerDAO potentialCustomerDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getPotentialCustomerDAO();
	}
	public com.xingyou.xingyou.potentialcustomercontactperson.PotentialCustomerContactPersonManager potentialCustomerContactPersonManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getPotentialCustomerContactPersonManager();
	}
	public com.xingyou.xingyou.potentialcustomercontactperson.PotentialCustomerContactPersonDAO potentialCustomerContactPersonDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getPotentialCustomerContactPersonDAO();
	}
	public com.xingyou.xingyou.potentialcustomercontact.PotentialCustomerContactManager potentialCustomerContactManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getPotentialCustomerContactManager();
	}
	public com.xingyou.xingyou.potentialcustomercontact.PotentialCustomerContactDAO potentialCustomerContactDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getPotentialCustomerContactDAO();
	}
	public com.xingyou.xingyou.cityevent.CityEventManager cityEventManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getCityEventManager();
	}
	public com.xingyou.xingyou.cityevent.CityEventDAO cityEventDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getCityEventDAO();
	}
	public com.xingyou.xingyou.eventattendance.EventAttendanceManager eventAttendanceManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getEventAttendanceManager();
	}
	public com.xingyou.xingyou.eventattendance.EventAttendanceDAO eventAttendanceDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getEventAttendanceDAO();
	}
	public com.xingyou.xingyou.mobileapp.MobileAppManager mobileAppManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getMobileAppManager();
	}
	public com.xingyou.xingyou.mobileapp.MobileAppDAO mobileAppDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getMobileAppDAO();
	}
	public com.xingyou.xingyou.page.PageManager pageManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getPageManager();
	}
	public com.xingyou.xingyou.page.PageDAO pageDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getPageDAO();
	}
	public com.xingyou.xingyou.pagetype.PageTypeManager pageTypeManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getPageTypeManager();
	}
	public com.xingyou.xingyou.pagetype.PageTypeDAO pageTypeDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getPageTypeDAO();
	}
	public com.xingyou.xingyou.slide.SlideManager slideManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getSlideManager();
	}
	public com.xingyou.xingyou.slide.SlideDAO slideDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getSlideDAO();
	}
	public com.xingyou.xingyou.uiaction.UiActionManager uiActionManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getUiActionManager();
	}
	public com.xingyou.xingyou.uiaction.UiActionDAO uiActionDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getUiActionDAO();
	}
	public com.xingyou.xingyou.section.SectionManager sectionManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getSectionManager();
	}
	public com.xingyou.xingyou.section.SectionDAO sectionDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getSectionDAO();
	}
	public com.xingyou.xingyou.userdomain.UserDomainManager userDomainManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getUserDomainManager();
	}
	public com.xingyou.xingyou.userdomain.UserDomainDAO userDomainDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getUserDomainDAO();
	}
	public com.xingyou.xingyou.userwhitelist.UserWhiteListManager userWhiteListManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getUserWhiteListManager();
	}
	public com.xingyou.xingyou.userwhitelist.UserWhiteListDAO userWhiteListDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getUserWhiteListDAO();
	}
	public com.xingyou.xingyou.secuser.SecUserManager secUserManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getSecUserManager();
	}
	public com.xingyou.xingyou.secuser.SecUserDAO secUserDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getSecUserDAO();
	}
	public com.xingyou.xingyou.userapp.UserAppManager userAppManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getUserAppManager();
	}
	public com.xingyou.xingyou.userapp.UserAppDAO userAppDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getUserAppDAO();
	}
	public com.xingyou.xingyou.quicklink.QuickLinkManager quickLinkManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getQuickLinkManager();
	}
	public com.xingyou.xingyou.quicklink.QuickLinkDAO quickLinkDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getQuickLinkDAO();
	}
	public com.xingyou.xingyou.listaccess.ListAccessManager listAccessManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getListAccessManager();
	}
	public com.xingyou.xingyou.listaccess.ListAccessDAO listAccessDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getListAccessDAO();
	}
	public com.xingyou.xingyou.loginhistory.LoginHistoryManager loginHistoryManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getLoginHistoryManager();
	}
	public com.xingyou.xingyou.loginhistory.LoginHistoryDAO loginHistoryDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getLoginHistoryDAO();
	}
	public com.xingyou.xingyou.candidatecontainer.CandidateContainerManager candidateContainerManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getCandidateContainerManager();
	}
	public com.xingyou.xingyou.candidatecontainer.CandidateContainerDAO candidateContainerDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getCandidateContainerDAO();
	}
	public com.xingyou.xingyou.candidateelement.CandidateElementManager candidateElementManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getCandidateElementManager();
	}
	public com.xingyou.xingyou.candidateelement.CandidateElementDAO candidateElementDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getCandidateElementDAO();
	}
	public com.xingyou.xingyou.wechatworkappidentify.WechatWorkappIdentifyManager wechatWorkappIdentifyManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getWechatWorkappIdentifyManager();
	}
	public com.xingyou.xingyou.wechatworkappidentify.WechatWorkappIdentifyDAO wechatWorkappIdentifyDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getWechatWorkappIdentifyDAO();
	}
	public com.xingyou.xingyou.wechatminiappidentify.WechatMiniappIdentifyManager wechatMiniappIdentifyManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getWechatMiniappIdentifyManager();
	}
	public com.xingyou.xingyou.wechatminiappidentify.WechatMiniappIdentifyDAO wechatMiniappIdentifyDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getWechatMiniappIdentifyDAO();
	}
	public com.xingyou.xingyou.keypairidentify.KeypairIdentifyManager keypairIdentifyManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getKeypairIdentifyManager();
	}
	public com.xingyou.xingyou.keypairidentify.KeypairIdentifyDAO keypairIdentifyDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getKeypairIdentifyDAO();
	}
	public com.xingyou.xingyou.publickeytype.PublicKeyTypeManager publicKeyTypeManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getPublicKeyTypeManager();
	}
	public com.xingyou.xingyou.publickeytype.PublicKeyTypeDAO publicKeyTypeDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getPublicKeyTypeDAO();
	}
	public com.xingyou.xingyou.treenode.TreeNodeManager treeNodeManagerOf(XingyouUserContext userContext){
		return userContext.getManagerGroup().getTreeNodeManager();
	}
	public com.xingyou.xingyou.treenode.TreeNodeDAO treeNodeDaoOf(XingyouUserContext userContext){
		return userContext.getDAOGroup().getTreeNodeDAO();
	}
	
	
	
	

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, XingyouException exception) {
		
		
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


















