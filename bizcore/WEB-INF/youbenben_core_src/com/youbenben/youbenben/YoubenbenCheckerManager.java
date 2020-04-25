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
	
	public com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterManager retailStoreCountryCenterManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreCountryCenterManager();
	}
	public com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO retailStoreCountryCenterDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO();
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
	public com.youbenben.youbenben.retailstoreprovincecenter.RetailStoreProvinceCenterManager retailStoreProvinceCenterManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreProvinceCenterManager();
	}
	public com.youbenben.youbenben.retailstoreprovincecenter.RetailStoreProvinceCenterDAO retailStoreProvinceCenterDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreProvinceCenterDAO();
	}
	public com.youbenben.youbenben.provincecenterdepartment.ProvinceCenterDepartmentManager provinceCenterDepartmentManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getProvinceCenterDepartmentManager();
	}
	public com.youbenben.youbenben.provincecenterdepartment.ProvinceCenterDepartmentDAO provinceCenterDepartmentDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getProvinceCenterDepartmentDAO();
	}
	public com.youbenben.youbenben.provincecenteremployee.ProvinceCenterEmployeeManager provinceCenterEmployeeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getProvinceCenterEmployeeManager();
	}
	public com.youbenben.youbenben.provincecenteremployee.ProvinceCenterEmployeeDAO provinceCenterEmployeeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getProvinceCenterEmployeeDAO();
	}
	public com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenterManager retailStoreCityServiceCenterManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreCityServiceCenterManager();
	}
	public com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreCityServiceCenterDAO();
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
	public com.youbenben.youbenben.retailstore.RetailStoreManager retailStoreManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreManager();
	}
	public com.youbenben.youbenben.retailstore.RetailStoreDAO retailStoreDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreDAO();
	}
	public com.youbenben.youbenben.retailstorecreation.RetailStoreCreationManager retailStoreCreationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreCreationManager();
	}
	public com.youbenben.youbenben.retailstorecreation.RetailStoreCreationDAO retailStoreCreationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreCreationDAO();
	}
	public com.youbenben.youbenben.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationManager retailStoreInvestmentInvitationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager();
	}
	public com.youbenben.youbenben.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationDAO retailStoreInvestmentInvitationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO();
	}
	public com.youbenben.youbenben.retailstorefranchising.RetailStoreFranchisingManager retailStoreFranchisingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreFranchisingManager();
	}
	public com.youbenben.youbenben.retailstorefranchising.RetailStoreFranchisingDAO retailStoreFranchisingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreFranchisingDAO();
	}
	public com.youbenben.youbenben.retailstoredecoration.RetailStoreDecorationManager retailStoreDecorationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreDecorationManager();
	}
	public com.youbenben.youbenben.retailstoredecoration.RetailStoreDecorationDAO retailStoreDecorationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreDecorationDAO();
	}
	public com.youbenben.youbenben.retailstoreopening.RetailStoreOpeningManager retailStoreOpeningManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOpeningManager();
	}
	public com.youbenben.youbenben.retailstoreopening.RetailStoreOpeningDAO retailStoreOpeningDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOpeningDAO();
	}
	public com.youbenben.youbenben.retailstoreclosing.RetailStoreClosingManager retailStoreClosingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreClosingManager();
	}
	public com.youbenben.youbenben.retailstoreclosing.RetailStoreClosingDAO retailStoreClosingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreClosingDAO();
	}
	public com.youbenben.youbenben.retailstoremember.RetailStoreMemberManager retailStoreMemberManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreMemberManager();
	}
	public com.youbenben.youbenben.retailstoremember.RetailStoreMemberDAO retailStoreMemberDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreMemberDAO();
	}
	public com.youbenben.youbenben.consumerorder.ConsumerOrderManager consumerOrderManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderManager();
	}
	public com.youbenben.youbenben.consumerorder.ConsumerOrderDAO consumerOrderDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderDAO();
	}
	public com.youbenben.youbenben.consumerorderconfirmation.ConsumerOrderConfirmationManager consumerOrderConfirmationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderConfirmationManager();
	}
	public com.youbenben.youbenben.consumerorderconfirmation.ConsumerOrderConfirmationDAO consumerOrderConfirmationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderConfirmationDAO();
	}
	public com.youbenben.youbenben.consumerorderapproval.ConsumerOrderApprovalManager consumerOrderApprovalManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderApprovalManager();
	}
	public com.youbenben.youbenben.consumerorderapproval.ConsumerOrderApprovalDAO consumerOrderApprovalDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderApprovalDAO();
	}
	public com.youbenben.youbenben.consumerorderprocessing.ConsumerOrderProcessingManager consumerOrderProcessingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderProcessingManager();
	}
	public com.youbenben.youbenben.consumerorderprocessing.ConsumerOrderProcessingDAO consumerOrderProcessingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderProcessingDAO();
	}
	public com.youbenben.youbenben.consumerordershipment.ConsumerOrderShipmentManager consumerOrderShipmentManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderShipmentManager();
	}
	public com.youbenben.youbenben.consumerordershipment.ConsumerOrderShipmentDAO consumerOrderShipmentDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderShipmentDAO();
	}
	public com.youbenben.youbenben.consumerorderdelivery.ConsumerOrderDeliveryManager consumerOrderDeliveryManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderDeliveryManager();
	}
	public com.youbenben.youbenben.consumerorderdelivery.ConsumerOrderDeliveryDAO consumerOrderDeliveryDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderDeliveryDAO();
	}
	public com.youbenben.youbenben.consumerorderlineitem.ConsumerOrderLineItemManager consumerOrderLineItemManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderLineItemManager();
	}
	public com.youbenben.youbenben.consumerorderlineitem.ConsumerOrderLineItemDAO consumerOrderLineItemDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderLineItemDAO();
	}
	public com.youbenben.youbenben.consumerordershippinggroup.ConsumerOrderShippingGroupManager consumerOrderShippingGroupManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderShippingGroupManager();
	}
	public com.youbenben.youbenben.consumerordershippinggroup.ConsumerOrderShippingGroupDAO consumerOrderShippingGroupDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderShippingGroupDAO();
	}
	public com.youbenben.youbenben.consumerorderpaymentgroup.ConsumerOrderPaymentGroupManager consumerOrderPaymentGroupManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderPaymentGroupManager();
	}
	public com.youbenben.youbenben.consumerorderpaymentgroup.ConsumerOrderPaymentGroupDAO consumerOrderPaymentGroupDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderPaymentGroupDAO();
	}
	public com.youbenben.youbenben.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentManager consumerOrderPriceAdjustmentManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderPriceAdjustmentManager();
	}
	public com.youbenben.youbenben.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentDAO consumerOrderPriceAdjustmentDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderPriceAdjustmentDAO();
	}
	public com.youbenben.youbenben.retailstoremembercoupon.RetailStoreMemberCouponManager retailStoreMemberCouponManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreMemberCouponManager();
	}
	public com.youbenben.youbenben.retailstoremembercoupon.RetailStoreMemberCouponDAO retailStoreMemberCouponDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreMemberCouponDAO();
	}
	public com.youbenben.youbenben.memberwishlist.MemberWishlistManager memberWishlistManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getMemberWishlistManager();
	}
	public com.youbenben.youbenben.memberwishlist.MemberWishlistDAO memberWishlistDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getMemberWishlistDAO();
	}
	public com.youbenben.youbenben.memberrewardpoint.MemberRewardPointManager memberRewardPointManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getMemberRewardPointManager();
	}
	public com.youbenben.youbenben.memberrewardpoint.MemberRewardPointDAO memberRewardPointDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getMemberRewardPointDAO();
	}
	public com.youbenben.youbenben.memberrewardpointredemption.MemberRewardPointRedemptionManager memberRewardPointRedemptionManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getMemberRewardPointRedemptionManager();
	}
	public com.youbenben.youbenben.memberrewardpointredemption.MemberRewardPointRedemptionDAO memberRewardPointRedemptionDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getMemberRewardPointRedemptionDAO();
	}
	public com.youbenben.youbenben.memberwishlistproduct.MemberWishlistProductManager memberWishlistProductManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getMemberWishlistProductManager();
	}
	public com.youbenben.youbenben.memberwishlistproduct.MemberWishlistProductDAO memberWishlistProductDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getMemberWishlistProductDAO();
	}
	public com.youbenben.youbenben.retailstorememberaddress.RetailStoreMemberAddressManager retailStoreMemberAddressManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreMemberAddressManager();
	}
	public com.youbenben.youbenben.retailstorememberaddress.RetailStoreMemberAddressDAO retailStoreMemberAddressDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreMemberAddressDAO();
	}
	public com.youbenben.youbenben.retailstoremembergiftcard.RetailStoreMemberGiftCardManager retailStoreMemberGiftCardManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreMemberGiftCardManager();
	}
	public com.youbenben.youbenben.retailstoremembergiftcard.RetailStoreMemberGiftCardDAO retailStoreMemberGiftCardDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO();
	}
	public com.youbenben.youbenben.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordManager retailStoreMemberGiftCardConsumeRecordManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreMemberGiftCardConsumeRecordManager();
	}
	public com.youbenben.youbenben.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO retailStoreMemberGiftCardConsumeRecordDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreMemberGiftCardConsumeRecordDAO();
	}
	public com.youbenben.youbenben.goodssupplier.GoodsSupplierManager goodsSupplierManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getGoodsSupplierManager();
	}
	public com.youbenben.youbenben.goodssupplier.GoodsSupplierDAO goodsSupplierDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getGoodsSupplierDAO();
	}
	public com.youbenben.youbenben.supplierproduct.SupplierProductManager supplierProductManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplierProductManager();
	}
	public com.youbenben.youbenben.supplierproduct.SupplierProductDAO supplierProductDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplierProductDAO();
	}
	public com.youbenben.youbenben.productsupplyduration.ProductSupplyDurationManager productSupplyDurationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getProductSupplyDurationManager();
	}
	public com.youbenben.youbenben.productsupplyduration.ProductSupplyDurationDAO productSupplyDurationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getProductSupplyDurationDAO();
	}
	public com.youbenben.youbenben.supplyorder.SupplyOrderManager supplyOrderManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderManager();
	}
	public com.youbenben.youbenben.supplyorder.SupplyOrderDAO supplyOrderDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderDAO();
	}
	public com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmationManager supplyOrderConfirmationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderConfirmationManager();
	}
	public com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmationDAO supplyOrderConfirmationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderConfirmationDAO();
	}
	public com.youbenben.youbenben.supplyorderapproval.SupplyOrderApprovalManager supplyOrderApprovalManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderApprovalManager();
	}
	public com.youbenben.youbenben.supplyorderapproval.SupplyOrderApprovalDAO supplyOrderApprovalDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderApprovalDAO();
	}
	public com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessingManager supplyOrderProcessingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderProcessingManager();
	}
	public com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessingDAO supplyOrderProcessingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderProcessingDAO();
	}
	public com.youbenben.youbenben.supplyorderpicking.SupplyOrderPickingManager supplyOrderPickingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderPickingManager();
	}
	public com.youbenben.youbenben.supplyorderpicking.SupplyOrderPickingDAO supplyOrderPickingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderPickingDAO();
	}
	public com.youbenben.youbenben.supplyordershipment.SupplyOrderShipmentManager supplyOrderShipmentManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderShipmentManager();
	}
	public com.youbenben.youbenben.supplyordershipment.SupplyOrderShipmentDAO supplyOrderShipmentDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderShipmentDAO();
	}
	public com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDeliveryManager supplyOrderDeliveryManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderDeliveryManager();
	}
	public com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDeliveryDAO supplyOrderDeliveryDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderDeliveryDAO();
	}
	public com.youbenben.youbenben.supplyorderlineitem.SupplyOrderLineItemManager supplyOrderLineItemManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderLineItemManager();
	}
	public com.youbenben.youbenben.supplyorderlineitem.SupplyOrderLineItemDAO supplyOrderLineItemDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderLineItemDAO();
	}
	public com.youbenben.youbenben.supplyordershippinggroup.SupplyOrderShippingGroupManager supplyOrderShippingGroupManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderShippingGroupManager();
	}
	public com.youbenben.youbenben.supplyordershippinggroup.SupplyOrderShippingGroupDAO supplyOrderShippingGroupDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderShippingGroupDAO();
	}
	public com.youbenben.youbenben.supplyorderpaymentgroup.SupplyOrderPaymentGroupManager supplyOrderPaymentGroupManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderPaymentGroupManager();
	}
	public com.youbenben.youbenben.supplyorderpaymentgroup.SupplyOrderPaymentGroupDAO supplyOrderPaymentGroupDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO();
	}
	public com.youbenben.youbenben.retailstoreorder.RetailStoreOrderManager retailStoreOrderManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderManager();
	}
	public com.youbenben.youbenben.retailstoreorder.RetailStoreOrderDAO retailStoreOrderDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderDAO();
	}
	public com.youbenben.youbenben.retailstoreorderconfirmation.RetailStoreOrderConfirmationManager retailStoreOrderConfirmationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderConfirmationManager();
	}
	public com.youbenben.youbenben.retailstoreorderconfirmation.RetailStoreOrderConfirmationDAO retailStoreOrderConfirmationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderConfirmationDAO();
	}
	public com.youbenben.youbenben.retailstoreorderapproval.RetailStoreOrderApprovalManager retailStoreOrderApprovalManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderApprovalManager();
	}
	public com.youbenben.youbenben.retailstoreorderapproval.RetailStoreOrderApprovalDAO retailStoreOrderApprovalDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderApprovalDAO();
	}
	public com.youbenben.youbenben.retailstoreorderprocessing.RetailStoreOrderProcessingManager retailStoreOrderProcessingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderProcessingManager();
	}
	public com.youbenben.youbenben.retailstoreorderprocessing.RetailStoreOrderProcessingDAO retailStoreOrderProcessingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderProcessingDAO();
	}
	public com.youbenben.youbenben.retailstoreorderpicking.RetailStoreOrderPickingManager retailStoreOrderPickingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderPickingManager();
	}
	public com.youbenben.youbenben.retailstoreorderpicking.RetailStoreOrderPickingDAO retailStoreOrderPickingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderPickingDAO();
	}
	public com.youbenben.youbenben.retailstoreordershipment.RetailStoreOrderShipmentManager retailStoreOrderShipmentManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderShipmentManager();
	}
	public com.youbenben.youbenben.retailstoreordershipment.RetailStoreOrderShipmentDAO retailStoreOrderShipmentDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderShipmentDAO();
	}
	public com.youbenben.youbenben.retailstoreorderdelivery.RetailStoreOrderDeliveryManager retailStoreOrderDeliveryManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderDeliveryManager();
	}
	public com.youbenben.youbenben.retailstoreorderdelivery.RetailStoreOrderDeliveryDAO retailStoreOrderDeliveryDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO();
	}
	public com.youbenben.youbenben.retailstoreorderlineitem.RetailStoreOrderLineItemManager retailStoreOrderLineItemManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderLineItemManager();
	}
	public com.youbenben.youbenben.retailstoreorderlineitem.RetailStoreOrderLineItemDAO retailStoreOrderLineItemDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderLineItemDAO();
	}
	public com.youbenben.youbenben.retailstoreordershippinggroup.RetailStoreOrderShippingGroupManager retailStoreOrderShippingGroupManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderShippingGroupManager();
	}
	public com.youbenben.youbenben.retailstoreordershippinggroup.RetailStoreOrderShippingGroupDAO retailStoreOrderShippingGroupDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO();
	}
	public com.youbenben.youbenben.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupManager retailStoreOrderPaymentGroupManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderPaymentGroupManager();
	}
	public com.youbenben.youbenben.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupDAO retailStoreOrderPaymentGroupDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO();
	}
	public com.youbenben.youbenben.warehouse.WarehouseManager warehouseManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getWarehouseManager();
	}
	public com.youbenben.youbenben.warehouse.WarehouseDAO warehouseDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getWarehouseDAO();
	}
	public com.youbenben.youbenben.storagespace.StorageSpaceManager storageSpaceManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getStorageSpaceManager();
	}
	public com.youbenben.youbenben.storagespace.StorageSpaceDAO storageSpaceDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getStorageSpaceDAO();
	}
	public com.youbenben.youbenben.smartpallet.SmartPalletManager smartPalletManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSmartPalletManager();
	}
	public com.youbenben.youbenben.smartpallet.SmartPalletDAO smartPalletDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSmartPalletDAO();
	}
	public com.youbenben.youbenben.goodsshelf.GoodsShelfManager goodsShelfManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getGoodsShelfManager();
	}
	public com.youbenben.youbenben.goodsshelf.GoodsShelfDAO goodsShelfDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getGoodsShelfDAO();
	}
	public com.youbenben.youbenben.goodsshelfstockcount.GoodsShelfStockCountManager goodsShelfStockCountManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getGoodsShelfStockCountManager();
	}
	public com.youbenben.youbenben.goodsshelfstockcount.GoodsShelfStockCountDAO goodsShelfStockCountDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getGoodsShelfStockCountDAO();
	}
	public com.youbenben.youbenben.stockcountissuetrack.StockCountIssueTrackManager stockCountIssueTrackManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getStockCountIssueTrackManager();
	}
	public com.youbenben.youbenben.stockcountissuetrack.StockCountIssueTrackDAO stockCountIssueTrackDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getStockCountIssueTrackDAO();
	}
	public com.youbenben.youbenben.goodsallocation.GoodsAllocationManager goodsAllocationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getGoodsAllocationManager();
	}
	public com.youbenben.youbenben.goodsallocation.GoodsAllocationDAO goodsAllocationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getGoodsAllocationDAO();
	}
	public com.youbenben.youbenben.goods.GoodsManager goodsManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getGoodsManager();
	}
	public com.youbenben.youbenben.goods.GoodsDAO goodsDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getGoodsDAO();
	}
	public com.youbenben.youbenben.goodspackaging.GoodsPackagingManager goodsPackagingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getGoodsPackagingManager();
	}
	public com.youbenben.youbenben.goodspackaging.GoodsPackagingDAO goodsPackagingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getGoodsPackagingDAO();
	}
	public com.youbenben.youbenben.goodsmovement.GoodsMovementManager goodsMovementManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getGoodsMovementManager();
	}
	public com.youbenben.youbenben.goodsmovement.GoodsMovementDAO goodsMovementDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getGoodsMovementDAO();
	}
	public com.youbenben.youbenben.supplierspace.SupplierSpaceManager supplierSpaceManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSupplierSpaceManager();
	}
	public com.youbenben.youbenben.supplierspace.SupplierSpaceDAO supplierSpaceDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSupplierSpaceDAO();
	}
	public com.youbenben.youbenben.receivingspace.ReceivingSpaceManager receivingSpaceManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getReceivingSpaceManager();
	}
	public com.youbenben.youbenben.receivingspace.ReceivingSpaceDAO receivingSpaceDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getReceivingSpaceDAO();
	}
	public com.youbenben.youbenben.shippingspace.ShippingSpaceManager shippingSpaceManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getShippingSpaceManager();
	}
	public com.youbenben.youbenben.shippingspace.ShippingSpaceDAO shippingSpaceDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getShippingSpaceDAO();
	}
	public com.youbenben.youbenben.damagespace.DamageSpaceManager damageSpaceManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getDamageSpaceManager();
	}
	public com.youbenben.youbenben.damagespace.DamageSpaceDAO damageSpaceDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getDamageSpaceDAO();
	}
	public com.youbenben.youbenben.warehouseasset.WarehouseAssetManager warehouseAssetManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getWarehouseAssetManager();
	}
	public com.youbenben.youbenben.warehouseasset.WarehouseAssetDAO warehouseAssetDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getWarehouseAssetDAO();
	}
	public com.youbenben.youbenben.transportfleet.TransportFleetManager transportFleetManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getTransportFleetManager();
	}
	public com.youbenben.youbenben.transportfleet.TransportFleetDAO transportFleetDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getTransportFleetDAO();
	}
	public com.youbenben.youbenben.transporttruck.TransportTruckManager transportTruckManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getTransportTruckManager();
	}
	public com.youbenben.youbenben.transporttruck.TransportTruckDAO transportTruckDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getTransportTruckDAO();
	}
	public com.youbenben.youbenben.truckdriver.TruckDriverManager truckDriverManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getTruckDriverManager();
	}
	public com.youbenben.youbenben.truckdriver.TruckDriverDAO truckDriverDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getTruckDriverDAO();
	}
	public com.youbenben.youbenben.transporttask.TransportTaskManager transportTaskManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getTransportTaskManager();
	}
	public com.youbenben.youbenben.transporttask.TransportTaskDAO transportTaskDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getTransportTaskDAO();
	}
	public com.youbenben.youbenben.transporttasktrack.TransportTaskTrackManager transportTaskTrackManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getTransportTaskTrackManager();
	}
	public com.youbenben.youbenben.transporttasktrack.TransportTaskTrackDAO transportTaskTrackDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getTransportTaskTrackDAO();
	}
	public com.youbenben.youbenben.accountset.AccountSetManager accountSetManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getAccountSetManager();
	}
	public com.youbenben.youbenben.accountset.AccountSetDAO accountSetDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getAccountSetDAO();
	}
	public com.youbenben.youbenben.accountingsubject.AccountingSubjectManager accountingSubjectManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getAccountingSubjectManager();
	}
	public com.youbenben.youbenben.accountingsubject.AccountingSubjectDAO accountingSubjectDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getAccountingSubjectDAO();
	}
	public com.youbenben.youbenben.accountingperiod.AccountingPeriodManager accountingPeriodManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getAccountingPeriodManager();
	}
	public com.youbenben.youbenben.accountingperiod.AccountingPeriodDAO accountingPeriodDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getAccountingPeriodDAO();
	}
	public com.youbenben.youbenben.accountingdocumenttype.AccountingDocumentTypeManager accountingDocumentTypeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getAccountingDocumentTypeManager();
	}
	public com.youbenben.youbenben.accountingdocumenttype.AccountingDocumentTypeDAO accountingDocumentTypeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getAccountingDocumentTypeDAO();
	}
	public com.youbenben.youbenben.accountingdocument.AccountingDocumentManager accountingDocumentManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getAccountingDocumentManager();
	}
	public com.youbenben.youbenben.accountingdocument.AccountingDocumentDAO accountingDocumentDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getAccountingDocumentDAO();
	}
	public com.youbenben.youbenben.accountingdocumentcreation.AccountingDocumentCreationManager accountingDocumentCreationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getAccountingDocumentCreationManager();
	}
	public com.youbenben.youbenben.accountingdocumentcreation.AccountingDocumentCreationDAO accountingDocumentCreationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getAccountingDocumentCreationDAO();
	}
	public com.youbenben.youbenben.accountingdocumentconfirmation.AccountingDocumentConfirmationManager accountingDocumentConfirmationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getAccountingDocumentConfirmationManager();
	}
	public com.youbenben.youbenben.accountingdocumentconfirmation.AccountingDocumentConfirmationDAO accountingDocumentConfirmationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getAccountingDocumentConfirmationDAO();
	}
	public com.youbenben.youbenben.accountingdocumentauditing.AccountingDocumentAuditingManager accountingDocumentAuditingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getAccountingDocumentAuditingManager();
	}
	public com.youbenben.youbenben.accountingdocumentauditing.AccountingDocumentAuditingDAO accountingDocumentAuditingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getAccountingDocumentAuditingDAO();
	}
	public com.youbenben.youbenben.accountingdocumentposting.AccountingDocumentPostingManager accountingDocumentPostingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getAccountingDocumentPostingManager();
	}
	public com.youbenben.youbenben.accountingdocumentposting.AccountingDocumentPostingDAO accountingDocumentPostingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getAccountingDocumentPostingDAO();
	}
	public com.youbenben.youbenben.originalvoucher.OriginalVoucherManager originalVoucherManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getOriginalVoucherManager();
	}
	public com.youbenben.youbenben.originalvoucher.OriginalVoucherDAO originalVoucherDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getOriginalVoucherDAO();
	}
	public com.youbenben.youbenben.originalvouchercreation.OriginalVoucherCreationManager originalVoucherCreationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getOriginalVoucherCreationManager();
	}
	public com.youbenben.youbenben.originalvouchercreation.OriginalVoucherCreationDAO originalVoucherCreationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getOriginalVoucherCreationDAO();
	}
	public com.youbenben.youbenben.originalvoucherconfirmation.OriginalVoucherConfirmationManager originalVoucherConfirmationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getOriginalVoucherConfirmationManager();
	}
	public com.youbenben.youbenben.originalvoucherconfirmation.OriginalVoucherConfirmationDAO originalVoucherConfirmationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getOriginalVoucherConfirmationDAO();
	}
	public com.youbenben.youbenben.originalvoucherauditing.OriginalVoucherAuditingManager originalVoucherAuditingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getOriginalVoucherAuditingManager();
	}
	public com.youbenben.youbenben.originalvoucherauditing.OriginalVoucherAuditingDAO originalVoucherAuditingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getOriginalVoucherAuditingDAO();
	}
	public com.youbenben.youbenben.accountingdocumentline.AccountingDocumentLineManager accountingDocumentLineManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getAccountingDocumentLineManager();
	}
	public com.youbenben.youbenben.accountingdocumentline.AccountingDocumentLineDAO accountingDocumentLineDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getAccountingDocumentLineDAO();
	}
	public com.youbenben.youbenben.levelonedepartment.LevelOneDepartmentManager levelOneDepartmentManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getLevelOneDepartmentManager();
	}
	public com.youbenben.youbenben.levelonedepartment.LevelOneDepartmentDAO levelOneDepartmentDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getLevelOneDepartmentDAO();
	}
	public com.youbenben.youbenben.leveltwodepartment.LevelTwoDepartmentManager levelTwoDepartmentManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getLevelTwoDepartmentManager();
	}
	public com.youbenben.youbenben.leveltwodepartment.LevelTwoDepartmentDAO levelTwoDepartmentDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getLevelTwoDepartmentDAO();
	}
	public com.youbenben.youbenben.levelthreedepartment.LevelThreeDepartmentManager levelThreeDepartmentManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getLevelThreeDepartmentManager();
	}
	public com.youbenben.youbenben.levelthreedepartment.LevelThreeDepartmentDAO levelThreeDepartmentDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getLevelThreeDepartmentDAO();
	}
	public com.youbenben.youbenben.skilltype.SkillTypeManager skillTypeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSkillTypeManager();
	}
	public com.youbenben.youbenben.skilltype.SkillTypeDAO skillTypeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSkillTypeDAO();
	}
	public com.youbenben.youbenben.responsibilitytype.ResponsibilityTypeManager responsibilityTypeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getResponsibilityTypeManager();
	}
	public com.youbenben.youbenben.responsibilitytype.ResponsibilityTypeDAO responsibilityTypeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getResponsibilityTypeDAO();
	}
	public com.youbenben.youbenben.terminationreason.TerminationReasonManager terminationReasonManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getTerminationReasonManager();
	}
	public com.youbenben.youbenben.terminationreason.TerminationReasonDAO terminationReasonDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getTerminationReasonDAO();
	}
	public com.youbenben.youbenben.terminationtype.TerminationTypeManager terminationTypeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getTerminationTypeManager();
	}
	public com.youbenben.youbenben.terminationtype.TerminationTypeDAO terminationTypeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getTerminationTypeDAO();
	}
	public com.youbenben.youbenben.occupationtype.OccupationTypeManager occupationTypeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getOccupationTypeManager();
	}
	public com.youbenben.youbenben.occupationtype.OccupationTypeDAO occupationTypeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getOccupationTypeDAO();
	}
	public com.youbenben.youbenben.leavetype.LeaveTypeManager leaveTypeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getLeaveTypeManager();
	}
	public com.youbenben.youbenben.leavetype.LeaveTypeDAO leaveTypeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getLeaveTypeDAO();
	}
	public com.youbenben.youbenben.salarygrade.SalaryGradeManager salaryGradeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getSalaryGradeManager();
	}
	public com.youbenben.youbenben.salarygrade.SalaryGradeDAO salaryGradeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getSalaryGradeDAO();
	}
	public com.youbenben.youbenben.interviewtype.InterviewTypeManager interviewTypeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getInterviewTypeManager();
	}
	public com.youbenben.youbenben.interviewtype.InterviewTypeDAO interviewTypeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getInterviewTypeDAO();
	}
	public com.youbenben.youbenben.trainingcoursetype.TrainingCourseTypeManager trainingCourseTypeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getTrainingCourseTypeManager();
	}
	public com.youbenben.youbenben.trainingcoursetype.TrainingCourseTypeDAO trainingCourseTypeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getTrainingCourseTypeDAO();
	}
	public com.youbenben.youbenben.publicholiday.PublicHolidayManager publicHolidayManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getPublicHolidayManager();
	}
	public com.youbenben.youbenben.publicholiday.PublicHolidayDAO publicHolidayDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getPublicHolidayDAO();
	}
	public com.youbenben.youbenben.termination.TerminationManager terminationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getTerminationManager();
	}
	public com.youbenben.youbenben.termination.TerminationDAO terminationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getTerminationDAO();
	}
	public com.youbenben.youbenben.view.ViewManager viewManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getViewManager();
	}
	public com.youbenben.youbenben.view.ViewDAO viewDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getViewDAO();
	}
	public com.youbenben.youbenben.employee.EmployeeManager employeeManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeManager();
	}
	public com.youbenben.youbenben.employee.EmployeeDAO employeeDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeDAO();
	}
	public com.youbenben.youbenben.jobapplication.JobApplicationManager jobApplicationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getJobApplicationManager();
	}
	public com.youbenben.youbenben.jobapplication.JobApplicationDAO jobApplicationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getJobApplicationDAO();
	}
	public com.youbenben.youbenben.professioninterview.ProfessionInterviewManager professionInterviewManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getProfessionInterviewManager();
	}
	public com.youbenben.youbenben.professioninterview.ProfessionInterviewDAO professionInterviewDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getProfessionInterviewDAO();
	}
	public com.youbenben.youbenben.hrinterview.HrInterviewManager hrInterviewManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getHrInterviewManager();
	}
	public com.youbenben.youbenben.hrinterview.HrInterviewDAO hrInterviewDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getHrInterviewDAO();
	}
	public com.youbenben.youbenben.offerapproval.OfferApprovalManager offerApprovalManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getOfferApprovalManager();
	}
	public com.youbenben.youbenben.offerapproval.OfferApprovalDAO offerApprovalDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getOfferApprovalDAO();
	}
	public com.youbenben.youbenben.offeracceptance.OfferAcceptanceManager offerAcceptanceManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getOfferAcceptanceManager();
	}
	public com.youbenben.youbenben.offeracceptance.OfferAcceptanceDAO offerAcceptanceDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getOfferAcceptanceDAO();
	}
	public com.youbenben.youbenben.employeeboarding.EmployeeBoardingManager employeeBoardingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeBoardingManager();
	}
	public com.youbenben.youbenben.employeeboarding.EmployeeBoardingDAO employeeBoardingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeBoardingDAO();
	}
	public com.youbenben.youbenben.instructor.InstructorManager instructorManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getInstructorManager();
	}
	public com.youbenben.youbenben.instructor.InstructorDAO instructorDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getInstructorDAO();
	}
	public com.youbenben.youbenben.companytraining.CompanyTrainingManager companyTrainingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getCompanyTrainingManager();
	}
	public com.youbenben.youbenben.companytraining.CompanyTrainingDAO companyTrainingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getCompanyTrainingDAO();
	}
	public com.youbenben.youbenben.scoring.ScoringManager scoringManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getScoringManager();
	}
	public com.youbenben.youbenben.scoring.ScoringDAO scoringDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getScoringDAO();
	}
	public com.youbenben.youbenben.employeecompanytraining.EmployeeCompanyTrainingManager employeeCompanyTrainingManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeCompanyTrainingManager();
	}
	public com.youbenben.youbenben.employeecompanytraining.EmployeeCompanyTrainingDAO employeeCompanyTrainingDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeCompanyTrainingDAO();
	}
	public com.youbenben.youbenben.employeeskill.EmployeeSkillManager employeeSkillManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeSkillManager();
	}
	public com.youbenben.youbenben.employeeskill.EmployeeSkillDAO employeeSkillDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeSkillDAO();
	}
	public com.youbenben.youbenben.employeeperformance.EmployeePerformanceManager employeePerformanceManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeePerformanceManager();
	}
	public com.youbenben.youbenben.employeeperformance.EmployeePerformanceDAO employeePerformanceDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeePerformanceDAO();
	}
	public com.youbenben.youbenben.employeeworkexperience.EmployeeWorkExperienceManager employeeWorkExperienceManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeWorkExperienceManager();
	}
	public com.youbenben.youbenben.employeeworkexperience.EmployeeWorkExperienceDAO employeeWorkExperienceDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeWorkExperienceDAO();
	}
	public com.youbenben.youbenben.employeeleave.EmployeeLeaveManager employeeLeaveManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeLeaveManager();
	}
	public com.youbenben.youbenben.employeeleave.EmployeeLeaveDAO employeeLeaveDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeLeaveDAO();
	}
	public com.youbenben.youbenben.employeeinterview.EmployeeInterviewManager employeeInterviewManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeInterviewManager();
	}
	public com.youbenben.youbenben.employeeinterview.EmployeeInterviewDAO employeeInterviewDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeInterviewDAO();
	}
	public com.youbenben.youbenben.employeeattendance.EmployeeAttendanceManager employeeAttendanceManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeAttendanceManager();
	}
	public com.youbenben.youbenben.employeeattendance.EmployeeAttendanceDAO employeeAttendanceDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeAttendanceDAO();
	}
	public com.youbenben.youbenben.employeequalifier.EmployeeQualifierManager employeeQualifierManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeQualifierManager();
	}
	public com.youbenben.youbenben.employeequalifier.EmployeeQualifierDAO employeeQualifierDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeQualifierDAO();
	}
	public com.youbenben.youbenben.employeeeducation.EmployeeEducationManager employeeEducationManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeEducationManager();
	}
	public com.youbenben.youbenben.employeeeducation.EmployeeEducationDAO employeeEducationDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeEducationDAO();
	}
	public com.youbenben.youbenben.employeeaward.EmployeeAwardManager employeeAwardManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeAwardManager();
	}
	public com.youbenben.youbenben.employeeaward.EmployeeAwardDAO employeeAwardDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeAwardDAO();
	}
	public com.youbenben.youbenben.employeesalarysheet.EmployeeSalarySheetManager employeeSalarySheetManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getEmployeeSalarySheetManager();
	}
	public com.youbenben.youbenben.employeesalarysheet.EmployeeSalarySheetDAO employeeSalarySheetDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getEmployeeSalarySheetDAO();
	}
	public com.youbenben.youbenben.payingoff.PayingOffManager payingOffManagerOf(YoubenbenUserContext userContext){
		return userContext.getManagerGroup().getPayingOffManager();
	}
	public com.youbenben.youbenben.payingoff.PayingOffDAO payingOffDaoOf(YoubenbenUserContext userContext){
		return userContext.getDAOGroup().getPayingOffDAO();
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


















