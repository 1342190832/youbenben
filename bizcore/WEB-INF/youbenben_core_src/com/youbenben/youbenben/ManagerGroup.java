package com.youbenben.youbenben;


import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterManager;

import com.youbenben.youbenben.catalog.CatalogManager;

import com.youbenben.youbenben.levelonecategory.LevelOneCategoryManager;

import com.youbenben.youbenben.leveltwocategory.LevelTwoCategoryManager;

import com.youbenben.youbenben.levelthreecategory.LevelThreeCategoryManager;

import com.youbenben.youbenben.product.ProductManager;

import com.youbenben.youbenben.sku.SkuManager;

import com.youbenben.youbenben.retailstoreprovincecenter.RetailStoreProvinceCenterManager;

import com.youbenben.youbenben.provincecenterdepartment.ProvinceCenterDepartmentManager;

import com.youbenben.youbenben.provincecenteremployee.ProvinceCenterEmployeeManager;

import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenterManager;

import com.youbenben.youbenben.citypartner.CityPartnerManager;

import com.youbenben.youbenben.potentialcustomer.PotentialCustomerManager;

import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPersonManager;

import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContactManager;

import com.youbenben.youbenben.cityevent.CityEventManager;

import com.youbenben.youbenben.eventattendance.EventAttendanceManager;

import com.youbenben.youbenben.retailstore.RetailStoreManager;

import com.youbenben.youbenben.retailstorecreation.RetailStoreCreationManager;

import com.youbenben.youbenben.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationManager;

import com.youbenben.youbenben.retailstorefranchising.RetailStoreFranchisingManager;

import com.youbenben.youbenben.retailstoredecoration.RetailStoreDecorationManager;

import com.youbenben.youbenben.retailstoreopening.RetailStoreOpeningManager;

import com.youbenben.youbenben.retailstoreclosing.RetailStoreClosingManager;

import com.youbenben.youbenben.retailstoremember.RetailStoreMemberManager;

import com.youbenben.youbenben.consumerorder.ConsumerOrderManager;

import com.youbenben.youbenben.consumerorderconfirmation.ConsumerOrderConfirmationManager;

import com.youbenben.youbenben.consumerorderapproval.ConsumerOrderApprovalManager;

import com.youbenben.youbenben.consumerorderprocessing.ConsumerOrderProcessingManager;

import com.youbenben.youbenben.consumerordershipment.ConsumerOrderShipmentManager;

import com.youbenben.youbenben.consumerorderdelivery.ConsumerOrderDeliveryManager;

import com.youbenben.youbenben.consumerorderlineitem.ConsumerOrderLineItemManager;

import com.youbenben.youbenben.consumerordershippinggroup.ConsumerOrderShippingGroupManager;

import com.youbenben.youbenben.consumerorderpaymentgroup.ConsumerOrderPaymentGroupManager;

import com.youbenben.youbenben.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentManager;

import com.youbenben.youbenben.retailstoremembercoupon.RetailStoreMemberCouponManager;

import com.youbenben.youbenben.memberwishlist.MemberWishlistManager;

import com.youbenben.youbenben.memberrewardpoint.MemberRewardPointManager;

import com.youbenben.youbenben.memberrewardpointredemption.MemberRewardPointRedemptionManager;

import com.youbenben.youbenben.memberwishlistproduct.MemberWishlistProductManager;

import com.youbenben.youbenben.retailstorememberaddress.RetailStoreMemberAddressManager;

import com.youbenben.youbenben.retailstoremembergiftcard.RetailStoreMemberGiftCardManager;

import com.youbenben.youbenben.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordManager;

import com.youbenben.youbenben.goodssupplier.GoodsSupplierManager;

import com.youbenben.youbenben.supplierproduct.SupplierProductManager;

import com.youbenben.youbenben.productsupplyduration.ProductSupplyDurationManager;

import com.youbenben.youbenben.supplyorder.SupplyOrderManager;

import com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmationManager;

import com.youbenben.youbenben.supplyorderapproval.SupplyOrderApprovalManager;

import com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessingManager;

import com.youbenben.youbenben.supplyorderpicking.SupplyOrderPickingManager;

import com.youbenben.youbenben.supplyordershipment.SupplyOrderShipmentManager;

import com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDeliveryManager;

import com.youbenben.youbenben.supplyorderlineitem.SupplyOrderLineItemManager;

import com.youbenben.youbenben.supplyordershippinggroup.SupplyOrderShippingGroupManager;

import com.youbenben.youbenben.supplyorderpaymentgroup.SupplyOrderPaymentGroupManager;

import com.youbenben.youbenben.retailstoreorder.RetailStoreOrderManager;

import com.youbenben.youbenben.retailstoreorderconfirmation.RetailStoreOrderConfirmationManager;

import com.youbenben.youbenben.retailstoreorderapproval.RetailStoreOrderApprovalManager;

import com.youbenben.youbenben.retailstoreorderprocessing.RetailStoreOrderProcessingManager;

import com.youbenben.youbenben.retailstoreorderpicking.RetailStoreOrderPickingManager;

import com.youbenben.youbenben.retailstoreordershipment.RetailStoreOrderShipmentManager;

import com.youbenben.youbenben.retailstoreorderdelivery.RetailStoreOrderDeliveryManager;

import com.youbenben.youbenben.retailstoreorderlineitem.RetailStoreOrderLineItemManager;

import com.youbenben.youbenben.retailstoreordershippinggroup.RetailStoreOrderShippingGroupManager;

import com.youbenben.youbenben.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupManager;

import com.youbenben.youbenben.warehouse.WarehouseManager;

import com.youbenben.youbenben.storagespace.StorageSpaceManager;

import com.youbenben.youbenben.smartpallet.SmartPalletManager;

import com.youbenben.youbenben.goodsshelf.GoodsShelfManager;

import com.youbenben.youbenben.goodsshelfstockcount.GoodsShelfStockCountManager;

import com.youbenben.youbenben.stockcountissuetrack.StockCountIssueTrackManager;

import com.youbenben.youbenben.goodsallocation.GoodsAllocationManager;

import com.youbenben.youbenben.goods.GoodsManager;

import com.youbenben.youbenben.goodspackaging.GoodsPackagingManager;

import com.youbenben.youbenben.goodsmovement.GoodsMovementManager;

import com.youbenben.youbenben.supplierspace.SupplierSpaceManager;

import com.youbenben.youbenben.receivingspace.ReceivingSpaceManager;

import com.youbenben.youbenben.shippingspace.ShippingSpaceManager;

import com.youbenben.youbenben.damagespace.DamageSpaceManager;

import com.youbenben.youbenben.warehouseasset.WarehouseAssetManager;

import com.youbenben.youbenben.transportfleet.TransportFleetManager;

import com.youbenben.youbenben.transporttruck.TransportTruckManager;

import com.youbenben.youbenben.truckdriver.TruckDriverManager;

import com.youbenben.youbenben.transporttask.TransportTaskManager;

import com.youbenben.youbenben.transporttasktrack.TransportTaskTrackManager;

import com.youbenben.youbenben.accountset.AccountSetManager;

import com.youbenben.youbenben.accountingsubject.AccountingSubjectManager;

import com.youbenben.youbenben.accountingperiod.AccountingPeriodManager;

import com.youbenben.youbenben.accountingdocumenttype.AccountingDocumentTypeManager;

import com.youbenben.youbenben.accountingdocument.AccountingDocumentManager;

import com.youbenben.youbenben.accountingdocumentcreation.AccountingDocumentCreationManager;

import com.youbenben.youbenben.accountingdocumentconfirmation.AccountingDocumentConfirmationManager;

import com.youbenben.youbenben.accountingdocumentauditing.AccountingDocumentAuditingManager;

import com.youbenben.youbenben.accountingdocumentposting.AccountingDocumentPostingManager;

import com.youbenben.youbenben.originalvoucher.OriginalVoucherManager;

import com.youbenben.youbenben.originalvouchercreation.OriginalVoucherCreationManager;

import com.youbenben.youbenben.originalvoucherconfirmation.OriginalVoucherConfirmationManager;

import com.youbenben.youbenben.originalvoucherauditing.OriginalVoucherAuditingManager;

import com.youbenben.youbenben.accountingdocumentline.AccountingDocumentLineManager;

import com.youbenben.youbenben.levelonedepartment.LevelOneDepartmentManager;

import com.youbenben.youbenben.leveltwodepartment.LevelTwoDepartmentManager;

import com.youbenben.youbenben.levelthreedepartment.LevelThreeDepartmentManager;

import com.youbenben.youbenben.skilltype.SkillTypeManager;

import com.youbenben.youbenben.responsibilitytype.ResponsibilityTypeManager;

import com.youbenben.youbenben.terminationreason.TerminationReasonManager;

import com.youbenben.youbenben.terminationtype.TerminationTypeManager;

import com.youbenben.youbenben.occupationtype.OccupationTypeManager;

import com.youbenben.youbenben.leavetype.LeaveTypeManager;

import com.youbenben.youbenben.salarygrade.SalaryGradeManager;

import com.youbenben.youbenben.interviewtype.InterviewTypeManager;

import com.youbenben.youbenben.trainingcoursetype.TrainingCourseTypeManager;

import com.youbenben.youbenben.publicholiday.PublicHolidayManager;

import com.youbenben.youbenben.termination.TerminationManager;

import com.youbenben.youbenben.view.ViewManager;

import com.youbenben.youbenben.employee.EmployeeManager;

import com.youbenben.youbenben.jobapplication.JobApplicationManager;

import com.youbenben.youbenben.professioninterview.ProfessionInterviewManager;

import com.youbenben.youbenben.hrinterview.HrInterviewManager;

import com.youbenben.youbenben.offerapproval.OfferApprovalManager;

import com.youbenben.youbenben.offeracceptance.OfferAcceptanceManager;

import com.youbenben.youbenben.employeeboarding.EmployeeBoardingManager;

import com.youbenben.youbenben.instructor.InstructorManager;

import com.youbenben.youbenben.companytraining.CompanyTrainingManager;

import com.youbenben.youbenben.scoring.ScoringManager;

import com.youbenben.youbenben.employeecompanytraining.EmployeeCompanyTrainingManager;

import com.youbenben.youbenben.employeeskill.EmployeeSkillManager;

import com.youbenben.youbenben.employeeperformance.EmployeePerformanceManager;

import com.youbenben.youbenben.employeeworkexperience.EmployeeWorkExperienceManager;

import com.youbenben.youbenben.employeeleave.EmployeeLeaveManager;

import com.youbenben.youbenben.employeeinterview.EmployeeInterviewManager;

import com.youbenben.youbenben.employeeattendance.EmployeeAttendanceManager;

import com.youbenben.youbenben.employeequalifier.EmployeeQualifierManager;

import com.youbenben.youbenben.employeeeducation.EmployeeEducationManager;

import com.youbenben.youbenben.employeeaward.EmployeeAwardManager;

import com.youbenben.youbenben.employeesalarysheet.EmployeeSalarySheetManager;

import com.youbenben.youbenben.payingoff.PayingOffManager;

import com.youbenben.youbenben.mobileapp.MobileAppManager;

import com.youbenben.youbenben.page.PageManager;

import com.youbenben.youbenben.pagetype.PageTypeManager;

import com.youbenben.youbenben.slide.SlideManager;

import com.youbenben.youbenben.uiaction.UiActionManager;

import com.youbenben.youbenben.section.SectionManager;

import com.youbenben.youbenben.userdomain.UserDomainManager;

import com.youbenben.youbenben.userwhitelist.UserWhiteListManager;

import com.youbenben.youbenben.secuser.SecUserManager;

import com.youbenben.youbenben.userapp.UserAppManager;

import com.youbenben.youbenben.quicklink.QuickLinkManager;

import com.youbenben.youbenben.listaccess.ListAccessManager;

import com.youbenben.youbenben.loginhistory.LoginHistoryManager;

import com.youbenben.youbenben.candidatecontainer.CandidateContainerManager;

import com.youbenben.youbenben.candidateelement.CandidateElementManager;

import com.youbenben.youbenben.wechatworkappidentify.WechatWorkappIdentifyManager;

import com.youbenben.youbenben.wechatminiappidentify.WechatMiniappIdentifyManager;

import com.youbenben.youbenben.keypairidentify.KeypairIdentifyManager;

import com.youbenben.youbenben.publickeytype.PublicKeyTypeManager;

import com.youbenben.youbenben.treenode.TreeNodeManager;


public class ManagerGroup {

	protected RetailStoreCountryCenterManager retailStoreCountryCenterManager;

	protected CatalogManager catalogManager;

	protected LevelOneCategoryManager levelOneCategoryManager;

	protected LevelTwoCategoryManager levelTwoCategoryManager;

	protected LevelThreeCategoryManager levelThreeCategoryManager;

	protected ProductManager productManager;

	protected SkuManager skuManager;

	protected RetailStoreProvinceCenterManager retailStoreProvinceCenterManager;

	protected ProvinceCenterDepartmentManager provinceCenterDepartmentManager;

	protected ProvinceCenterEmployeeManager provinceCenterEmployeeManager;

	protected RetailStoreCityServiceCenterManager retailStoreCityServiceCenterManager;

	protected CityPartnerManager cityPartnerManager;

	protected PotentialCustomerManager potentialCustomerManager;

	protected PotentialCustomerContactPersonManager potentialCustomerContactPersonManager;

	protected PotentialCustomerContactManager potentialCustomerContactManager;

	protected CityEventManager cityEventManager;

	protected EventAttendanceManager eventAttendanceManager;

	protected RetailStoreManager retailStoreManager;

	protected RetailStoreCreationManager retailStoreCreationManager;

	protected RetailStoreInvestmentInvitationManager retailStoreInvestmentInvitationManager;

	protected RetailStoreFranchisingManager retailStoreFranchisingManager;

	protected RetailStoreDecorationManager retailStoreDecorationManager;

	protected RetailStoreOpeningManager retailStoreOpeningManager;

	protected RetailStoreClosingManager retailStoreClosingManager;

	protected RetailStoreMemberManager retailStoreMemberManager;

	protected ConsumerOrderManager consumerOrderManager;

	protected ConsumerOrderConfirmationManager consumerOrderConfirmationManager;

	protected ConsumerOrderApprovalManager consumerOrderApprovalManager;

	protected ConsumerOrderProcessingManager consumerOrderProcessingManager;

	protected ConsumerOrderShipmentManager consumerOrderShipmentManager;

	protected ConsumerOrderDeliveryManager consumerOrderDeliveryManager;

	protected ConsumerOrderLineItemManager consumerOrderLineItemManager;

	protected ConsumerOrderShippingGroupManager consumerOrderShippingGroupManager;

	protected ConsumerOrderPaymentGroupManager consumerOrderPaymentGroupManager;

	protected ConsumerOrderPriceAdjustmentManager consumerOrderPriceAdjustmentManager;

	protected RetailStoreMemberCouponManager retailStoreMemberCouponManager;

	protected MemberWishlistManager memberWishlistManager;

	protected MemberRewardPointManager memberRewardPointManager;

	protected MemberRewardPointRedemptionManager memberRewardPointRedemptionManager;

	protected MemberWishlistProductManager memberWishlistProductManager;

	protected RetailStoreMemberAddressManager retailStoreMemberAddressManager;

	protected RetailStoreMemberGiftCardManager retailStoreMemberGiftCardManager;

	protected RetailStoreMemberGiftCardConsumeRecordManager retailStoreMemberGiftCardConsumeRecordManager;

	protected GoodsSupplierManager goodsSupplierManager;

	protected SupplierProductManager supplierProductManager;

	protected ProductSupplyDurationManager productSupplyDurationManager;

	protected SupplyOrderManager supplyOrderManager;

	protected SupplyOrderConfirmationManager supplyOrderConfirmationManager;

	protected SupplyOrderApprovalManager supplyOrderApprovalManager;

	protected SupplyOrderProcessingManager supplyOrderProcessingManager;

	protected SupplyOrderPickingManager supplyOrderPickingManager;

	protected SupplyOrderShipmentManager supplyOrderShipmentManager;

	protected SupplyOrderDeliveryManager supplyOrderDeliveryManager;

	protected SupplyOrderLineItemManager supplyOrderLineItemManager;

	protected SupplyOrderShippingGroupManager supplyOrderShippingGroupManager;

	protected SupplyOrderPaymentGroupManager supplyOrderPaymentGroupManager;

	protected RetailStoreOrderManager retailStoreOrderManager;

	protected RetailStoreOrderConfirmationManager retailStoreOrderConfirmationManager;

	protected RetailStoreOrderApprovalManager retailStoreOrderApprovalManager;

	protected RetailStoreOrderProcessingManager retailStoreOrderProcessingManager;

	protected RetailStoreOrderPickingManager retailStoreOrderPickingManager;

	protected RetailStoreOrderShipmentManager retailStoreOrderShipmentManager;

	protected RetailStoreOrderDeliveryManager retailStoreOrderDeliveryManager;

	protected RetailStoreOrderLineItemManager retailStoreOrderLineItemManager;

	protected RetailStoreOrderShippingGroupManager retailStoreOrderShippingGroupManager;

	protected RetailStoreOrderPaymentGroupManager retailStoreOrderPaymentGroupManager;

	protected WarehouseManager warehouseManager;

	protected StorageSpaceManager storageSpaceManager;

	protected SmartPalletManager smartPalletManager;

	protected GoodsShelfManager goodsShelfManager;

	protected GoodsShelfStockCountManager goodsShelfStockCountManager;

	protected StockCountIssueTrackManager stockCountIssueTrackManager;

	protected GoodsAllocationManager goodsAllocationManager;

	protected GoodsManager goodsManager;

	protected GoodsPackagingManager goodsPackagingManager;

	protected GoodsMovementManager goodsMovementManager;

	protected SupplierSpaceManager supplierSpaceManager;

	protected ReceivingSpaceManager receivingSpaceManager;

	protected ShippingSpaceManager shippingSpaceManager;

	protected DamageSpaceManager damageSpaceManager;

	protected WarehouseAssetManager warehouseAssetManager;

	protected TransportFleetManager transportFleetManager;

	protected TransportTruckManager transportTruckManager;

	protected TruckDriverManager truckDriverManager;

	protected TransportTaskManager transportTaskManager;

	protected TransportTaskTrackManager transportTaskTrackManager;

	protected AccountSetManager accountSetManager;

	protected AccountingSubjectManager accountingSubjectManager;

	protected AccountingPeriodManager accountingPeriodManager;

	protected AccountingDocumentTypeManager accountingDocumentTypeManager;

	protected AccountingDocumentManager accountingDocumentManager;

	protected AccountingDocumentCreationManager accountingDocumentCreationManager;

	protected AccountingDocumentConfirmationManager accountingDocumentConfirmationManager;

	protected AccountingDocumentAuditingManager accountingDocumentAuditingManager;

	protected AccountingDocumentPostingManager accountingDocumentPostingManager;

	protected OriginalVoucherManager originalVoucherManager;

	protected OriginalVoucherCreationManager originalVoucherCreationManager;

	protected OriginalVoucherConfirmationManager originalVoucherConfirmationManager;

	protected OriginalVoucherAuditingManager originalVoucherAuditingManager;

	protected AccountingDocumentLineManager accountingDocumentLineManager;

	protected LevelOneDepartmentManager levelOneDepartmentManager;

	protected LevelTwoDepartmentManager levelTwoDepartmentManager;

	protected LevelThreeDepartmentManager levelThreeDepartmentManager;

	protected SkillTypeManager skillTypeManager;

	protected ResponsibilityTypeManager responsibilityTypeManager;

	protected TerminationReasonManager terminationReasonManager;

	protected TerminationTypeManager terminationTypeManager;

	protected OccupationTypeManager occupationTypeManager;

	protected LeaveTypeManager leaveTypeManager;

	protected SalaryGradeManager salaryGradeManager;

	protected InterviewTypeManager interviewTypeManager;

	protected TrainingCourseTypeManager trainingCourseTypeManager;

	protected PublicHolidayManager publicHolidayManager;

	protected TerminationManager terminationManager;

	protected ViewManager viewManager;

	protected EmployeeManager employeeManager;

	protected JobApplicationManager jobApplicationManager;

	protected ProfessionInterviewManager professionInterviewManager;

	protected HrInterviewManager hrInterviewManager;

	protected OfferApprovalManager offerApprovalManager;

	protected OfferAcceptanceManager offerAcceptanceManager;

	protected EmployeeBoardingManager employeeBoardingManager;

	protected InstructorManager instructorManager;

	protected CompanyTrainingManager companyTrainingManager;

	protected ScoringManager scoringManager;

	protected EmployeeCompanyTrainingManager employeeCompanyTrainingManager;

	protected EmployeeSkillManager employeeSkillManager;

	protected EmployeePerformanceManager employeePerformanceManager;

	protected EmployeeWorkExperienceManager employeeWorkExperienceManager;

	protected EmployeeLeaveManager employeeLeaveManager;

	protected EmployeeInterviewManager employeeInterviewManager;

	protected EmployeeAttendanceManager employeeAttendanceManager;

	protected EmployeeQualifierManager employeeQualifierManager;

	protected EmployeeEducationManager employeeEducationManager;

	protected EmployeeAwardManager employeeAwardManager;

	protected EmployeeSalarySheetManager employeeSalarySheetManager;

	protected PayingOffManager payingOffManager;

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



	public RetailStoreCountryCenterManager getRetailStoreCountryCenterManager(){
		return this.retailStoreCountryCenterManager;
	}
	public void setRetailStoreCountryCenterManager(RetailStoreCountryCenterManager manager){
		this.retailStoreCountryCenterManager = manager;
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


	public RetailStoreProvinceCenterManager getRetailStoreProvinceCenterManager(){
		return this.retailStoreProvinceCenterManager;
	}
	public void setRetailStoreProvinceCenterManager(RetailStoreProvinceCenterManager manager){
		this.retailStoreProvinceCenterManager = manager;
	}


	public ProvinceCenterDepartmentManager getProvinceCenterDepartmentManager(){
		return this.provinceCenterDepartmentManager;
	}
	public void setProvinceCenterDepartmentManager(ProvinceCenterDepartmentManager manager){
		this.provinceCenterDepartmentManager = manager;
	}


	public ProvinceCenterEmployeeManager getProvinceCenterEmployeeManager(){
		return this.provinceCenterEmployeeManager;
	}
	public void setProvinceCenterEmployeeManager(ProvinceCenterEmployeeManager manager){
		this.provinceCenterEmployeeManager = manager;
	}


	public RetailStoreCityServiceCenterManager getRetailStoreCityServiceCenterManager(){
		return this.retailStoreCityServiceCenterManager;
	}
	public void setRetailStoreCityServiceCenterManager(RetailStoreCityServiceCenterManager manager){
		this.retailStoreCityServiceCenterManager = manager;
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


	public RetailStoreManager getRetailStoreManager(){
		return this.retailStoreManager;
	}
	public void setRetailStoreManager(RetailStoreManager manager){
		this.retailStoreManager = manager;
	}


	public RetailStoreCreationManager getRetailStoreCreationManager(){
		return this.retailStoreCreationManager;
	}
	public void setRetailStoreCreationManager(RetailStoreCreationManager manager){
		this.retailStoreCreationManager = manager;
	}


	public RetailStoreInvestmentInvitationManager getRetailStoreInvestmentInvitationManager(){
		return this.retailStoreInvestmentInvitationManager;
	}
	public void setRetailStoreInvestmentInvitationManager(RetailStoreInvestmentInvitationManager manager){
		this.retailStoreInvestmentInvitationManager = manager;
	}


	public RetailStoreFranchisingManager getRetailStoreFranchisingManager(){
		return this.retailStoreFranchisingManager;
	}
	public void setRetailStoreFranchisingManager(RetailStoreFranchisingManager manager){
		this.retailStoreFranchisingManager = manager;
	}


	public RetailStoreDecorationManager getRetailStoreDecorationManager(){
		return this.retailStoreDecorationManager;
	}
	public void setRetailStoreDecorationManager(RetailStoreDecorationManager manager){
		this.retailStoreDecorationManager = manager;
	}


	public RetailStoreOpeningManager getRetailStoreOpeningManager(){
		return this.retailStoreOpeningManager;
	}
	public void setRetailStoreOpeningManager(RetailStoreOpeningManager manager){
		this.retailStoreOpeningManager = manager;
	}


	public RetailStoreClosingManager getRetailStoreClosingManager(){
		return this.retailStoreClosingManager;
	}
	public void setRetailStoreClosingManager(RetailStoreClosingManager manager){
		this.retailStoreClosingManager = manager;
	}


	public RetailStoreMemberManager getRetailStoreMemberManager(){
		return this.retailStoreMemberManager;
	}
	public void setRetailStoreMemberManager(RetailStoreMemberManager manager){
		this.retailStoreMemberManager = manager;
	}


	public ConsumerOrderManager getConsumerOrderManager(){
		return this.consumerOrderManager;
	}
	public void setConsumerOrderManager(ConsumerOrderManager manager){
		this.consumerOrderManager = manager;
	}


	public ConsumerOrderConfirmationManager getConsumerOrderConfirmationManager(){
		return this.consumerOrderConfirmationManager;
	}
	public void setConsumerOrderConfirmationManager(ConsumerOrderConfirmationManager manager){
		this.consumerOrderConfirmationManager = manager;
	}


	public ConsumerOrderApprovalManager getConsumerOrderApprovalManager(){
		return this.consumerOrderApprovalManager;
	}
	public void setConsumerOrderApprovalManager(ConsumerOrderApprovalManager manager){
		this.consumerOrderApprovalManager = manager;
	}


	public ConsumerOrderProcessingManager getConsumerOrderProcessingManager(){
		return this.consumerOrderProcessingManager;
	}
	public void setConsumerOrderProcessingManager(ConsumerOrderProcessingManager manager){
		this.consumerOrderProcessingManager = manager;
	}


	public ConsumerOrderShipmentManager getConsumerOrderShipmentManager(){
		return this.consumerOrderShipmentManager;
	}
	public void setConsumerOrderShipmentManager(ConsumerOrderShipmentManager manager){
		this.consumerOrderShipmentManager = manager;
	}


	public ConsumerOrderDeliveryManager getConsumerOrderDeliveryManager(){
		return this.consumerOrderDeliveryManager;
	}
	public void setConsumerOrderDeliveryManager(ConsumerOrderDeliveryManager manager){
		this.consumerOrderDeliveryManager = manager;
	}


	public ConsumerOrderLineItemManager getConsumerOrderLineItemManager(){
		return this.consumerOrderLineItemManager;
	}
	public void setConsumerOrderLineItemManager(ConsumerOrderLineItemManager manager){
		this.consumerOrderLineItemManager = manager;
	}


	public ConsumerOrderShippingGroupManager getConsumerOrderShippingGroupManager(){
		return this.consumerOrderShippingGroupManager;
	}
	public void setConsumerOrderShippingGroupManager(ConsumerOrderShippingGroupManager manager){
		this.consumerOrderShippingGroupManager = manager;
	}


	public ConsumerOrderPaymentGroupManager getConsumerOrderPaymentGroupManager(){
		return this.consumerOrderPaymentGroupManager;
	}
	public void setConsumerOrderPaymentGroupManager(ConsumerOrderPaymentGroupManager manager){
		this.consumerOrderPaymentGroupManager = manager;
	}


	public ConsumerOrderPriceAdjustmentManager getConsumerOrderPriceAdjustmentManager(){
		return this.consumerOrderPriceAdjustmentManager;
	}
	public void setConsumerOrderPriceAdjustmentManager(ConsumerOrderPriceAdjustmentManager manager){
		this.consumerOrderPriceAdjustmentManager = manager;
	}


	public RetailStoreMemberCouponManager getRetailStoreMemberCouponManager(){
		return this.retailStoreMemberCouponManager;
	}
	public void setRetailStoreMemberCouponManager(RetailStoreMemberCouponManager manager){
		this.retailStoreMemberCouponManager = manager;
	}


	public MemberWishlistManager getMemberWishlistManager(){
		return this.memberWishlistManager;
	}
	public void setMemberWishlistManager(MemberWishlistManager manager){
		this.memberWishlistManager = manager;
	}


	public MemberRewardPointManager getMemberRewardPointManager(){
		return this.memberRewardPointManager;
	}
	public void setMemberRewardPointManager(MemberRewardPointManager manager){
		this.memberRewardPointManager = manager;
	}


	public MemberRewardPointRedemptionManager getMemberRewardPointRedemptionManager(){
		return this.memberRewardPointRedemptionManager;
	}
	public void setMemberRewardPointRedemptionManager(MemberRewardPointRedemptionManager manager){
		this.memberRewardPointRedemptionManager = manager;
	}


	public MemberWishlistProductManager getMemberWishlistProductManager(){
		return this.memberWishlistProductManager;
	}
	public void setMemberWishlistProductManager(MemberWishlistProductManager manager){
		this.memberWishlistProductManager = manager;
	}


	public RetailStoreMemberAddressManager getRetailStoreMemberAddressManager(){
		return this.retailStoreMemberAddressManager;
	}
	public void setRetailStoreMemberAddressManager(RetailStoreMemberAddressManager manager){
		this.retailStoreMemberAddressManager = manager;
	}


	public RetailStoreMemberGiftCardManager getRetailStoreMemberGiftCardManager(){
		return this.retailStoreMemberGiftCardManager;
	}
	public void setRetailStoreMemberGiftCardManager(RetailStoreMemberGiftCardManager manager){
		this.retailStoreMemberGiftCardManager = manager;
	}


	public RetailStoreMemberGiftCardConsumeRecordManager getRetailStoreMemberGiftCardConsumeRecordManager(){
		return this.retailStoreMemberGiftCardConsumeRecordManager;
	}
	public void setRetailStoreMemberGiftCardConsumeRecordManager(RetailStoreMemberGiftCardConsumeRecordManager manager){
		this.retailStoreMemberGiftCardConsumeRecordManager = manager;
	}


	public GoodsSupplierManager getGoodsSupplierManager(){
		return this.goodsSupplierManager;
	}
	public void setGoodsSupplierManager(GoodsSupplierManager manager){
		this.goodsSupplierManager = manager;
	}


	public SupplierProductManager getSupplierProductManager(){
		return this.supplierProductManager;
	}
	public void setSupplierProductManager(SupplierProductManager manager){
		this.supplierProductManager = manager;
	}


	public ProductSupplyDurationManager getProductSupplyDurationManager(){
		return this.productSupplyDurationManager;
	}
	public void setProductSupplyDurationManager(ProductSupplyDurationManager manager){
		this.productSupplyDurationManager = manager;
	}


	public SupplyOrderManager getSupplyOrderManager(){
		return this.supplyOrderManager;
	}
	public void setSupplyOrderManager(SupplyOrderManager manager){
		this.supplyOrderManager = manager;
	}


	public SupplyOrderConfirmationManager getSupplyOrderConfirmationManager(){
		return this.supplyOrderConfirmationManager;
	}
	public void setSupplyOrderConfirmationManager(SupplyOrderConfirmationManager manager){
		this.supplyOrderConfirmationManager = manager;
	}


	public SupplyOrderApprovalManager getSupplyOrderApprovalManager(){
		return this.supplyOrderApprovalManager;
	}
	public void setSupplyOrderApprovalManager(SupplyOrderApprovalManager manager){
		this.supplyOrderApprovalManager = manager;
	}


	public SupplyOrderProcessingManager getSupplyOrderProcessingManager(){
		return this.supplyOrderProcessingManager;
	}
	public void setSupplyOrderProcessingManager(SupplyOrderProcessingManager manager){
		this.supplyOrderProcessingManager = manager;
	}


	public SupplyOrderPickingManager getSupplyOrderPickingManager(){
		return this.supplyOrderPickingManager;
	}
	public void setSupplyOrderPickingManager(SupplyOrderPickingManager manager){
		this.supplyOrderPickingManager = manager;
	}


	public SupplyOrderShipmentManager getSupplyOrderShipmentManager(){
		return this.supplyOrderShipmentManager;
	}
	public void setSupplyOrderShipmentManager(SupplyOrderShipmentManager manager){
		this.supplyOrderShipmentManager = manager;
	}


	public SupplyOrderDeliveryManager getSupplyOrderDeliveryManager(){
		return this.supplyOrderDeliveryManager;
	}
	public void setSupplyOrderDeliveryManager(SupplyOrderDeliveryManager manager){
		this.supplyOrderDeliveryManager = manager;
	}


	public SupplyOrderLineItemManager getSupplyOrderLineItemManager(){
		return this.supplyOrderLineItemManager;
	}
	public void setSupplyOrderLineItemManager(SupplyOrderLineItemManager manager){
		this.supplyOrderLineItemManager = manager;
	}


	public SupplyOrderShippingGroupManager getSupplyOrderShippingGroupManager(){
		return this.supplyOrderShippingGroupManager;
	}
	public void setSupplyOrderShippingGroupManager(SupplyOrderShippingGroupManager manager){
		this.supplyOrderShippingGroupManager = manager;
	}


	public SupplyOrderPaymentGroupManager getSupplyOrderPaymentGroupManager(){
		return this.supplyOrderPaymentGroupManager;
	}
	public void setSupplyOrderPaymentGroupManager(SupplyOrderPaymentGroupManager manager){
		this.supplyOrderPaymentGroupManager = manager;
	}


	public RetailStoreOrderManager getRetailStoreOrderManager(){
		return this.retailStoreOrderManager;
	}
	public void setRetailStoreOrderManager(RetailStoreOrderManager manager){
		this.retailStoreOrderManager = manager;
	}


	public RetailStoreOrderConfirmationManager getRetailStoreOrderConfirmationManager(){
		return this.retailStoreOrderConfirmationManager;
	}
	public void setRetailStoreOrderConfirmationManager(RetailStoreOrderConfirmationManager manager){
		this.retailStoreOrderConfirmationManager = manager;
	}


	public RetailStoreOrderApprovalManager getRetailStoreOrderApprovalManager(){
		return this.retailStoreOrderApprovalManager;
	}
	public void setRetailStoreOrderApprovalManager(RetailStoreOrderApprovalManager manager){
		this.retailStoreOrderApprovalManager = manager;
	}


	public RetailStoreOrderProcessingManager getRetailStoreOrderProcessingManager(){
		return this.retailStoreOrderProcessingManager;
	}
	public void setRetailStoreOrderProcessingManager(RetailStoreOrderProcessingManager manager){
		this.retailStoreOrderProcessingManager = manager;
	}


	public RetailStoreOrderPickingManager getRetailStoreOrderPickingManager(){
		return this.retailStoreOrderPickingManager;
	}
	public void setRetailStoreOrderPickingManager(RetailStoreOrderPickingManager manager){
		this.retailStoreOrderPickingManager = manager;
	}


	public RetailStoreOrderShipmentManager getRetailStoreOrderShipmentManager(){
		return this.retailStoreOrderShipmentManager;
	}
	public void setRetailStoreOrderShipmentManager(RetailStoreOrderShipmentManager manager){
		this.retailStoreOrderShipmentManager = manager;
	}


	public RetailStoreOrderDeliveryManager getRetailStoreOrderDeliveryManager(){
		return this.retailStoreOrderDeliveryManager;
	}
	public void setRetailStoreOrderDeliveryManager(RetailStoreOrderDeliveryManager manager){
		this.retailStoreOrderDeliveryManager = manager;
	}


	public RetailStoreOrderLineItemManager getRetailStoreOrderLineItemManager(){
		return this.retailStoreOrderLineItemManager;
	}
	public void setRetailStoreOrderLineItemManager(RetailStoreOrderLineItemManager manager){
		this.retailStoreOrderLineItemManager = manager;
	}


	public RetailStoreOrderShippingGroupManager getRetailStoreOrderShippingGroupManager(){
		return this.retailStoreOrderShippingGroupManager;
	}
	public void setRetailStoreOrderShippingGroupManager(RetailStoreOrderShippingGroupManager manager){
		this.retailStoreOrderShippingGroupManager = manager;
	}


	public RetailStoreOrderPaymentGroupManager getRetailStoreOrderPaymentGroupManager(){
		return this.retailStoreOrderPaymentGroupManager;
	}
	public void setRetailStoreOrderPaymentGroupManager(RetailStoreOrderPaymentGroupManager manager){
		this.retailStoreOrderPaymentGroupManager = manager;
	}


	public WarehouseManager getWarehouseManager(){
		return this.warehouseManager;
	}
	public void setWarehouseManager(WarehouseManager manager){
		this.warehouseManager = manager;
	}


	public StorageSpaceManager getStorageSpaceManager(){
		return this.storageSpaceManager;
	}
	public void setStorageSpaceManager(StorageSpaceManager manager){
		this.storageSpaceManager = manager;
	}


	public SmartPalletManager getSmartPalletManager(){
		return this.smartPalletManager;
	}
	public void setSmartPalletManager(SmartPalletManager manager){
		this.smartPalletManager = manager;
	}


	public GoodsShelfManager getGoodsShelfManager(){
		return this.goodsShelfManager;
	}
	public void setGoodsShelfManager(GoodsShelfManager manager){
		this.goodsShelfManager = manager;
	}


	public GoodsShelfStockCountManager getGoodsShelfStockCountManager(){
		return this.goodsShelfStockCountManager;
	}
	public void setGoodsShelfStockCountManager(GoodsShelfStockCountManager manager){
		this.goodsShelfStockCountManager = manager;
	}


	public StockCountIssueTrackManager getStockCountIssueTrackManager(){
		return this.stockCountIssueTrackManager;
	}
	public void setStockCountIssueTrackManager(StockCountIssueTrackManager manager){
		this.stockCountIssueTrackManager = manager;
	}


	public GoodsAllocationManager getGoodsAllocationManager(){
		return this.goodsAllocationManager;
	}
	public void setGoodsAllocationManager(GoodsAllocationManager manager){
		this.goodsAllocationManager = manager;
	}


	public GoodsManager getGoodsManager(){
		return this.goodsManager;
	}
	public void setGoodsManager(GoodsManager manager){
		this.goodsManager = manager;
	}


	public GoodsPackagingManager getGoodsPackagingManager(){
		return this.goodsPackagingManager;
	}
	public void setGoodsPackagingManager(GoodsPackagingManager manager){
		this.goodsPackagingManager = manager;
	}


	public GoodsMovementManager getGoodsMovementManager(){
		return this.goodsMovementManager;
	}
	public void setGoodsMovementManager(GoodsMovementManager manager){
		this.goodsMovementManager = manager;
	}


	public SupplierSpaceManager getSupplierSpaceManager(){
		return this.supplierSpaceManager;
	}
	public void setSupplierSpaceManager(SupplierSpaceManager manager){
		this.supplierSpaceManager = manager;
	}


	public ReceivingSpaceManager getReceivingSpaceManager(){
		return this.receivingSpaceManager;
	}
	public void setReceivingSpaceManager(ReceivingSpaceManager manager){
		this.receivingSpaceManager = manager;
	}


	public ShippingSpaceManager getShippingSpaceManager(){
		return this.shippingSpaceManager;
	}
	public void setShippingSpaceManager(ShippingSpaceManager manager){
		this.shippingSpaceManager = manager;
	}


	public DamageSpaceManager getDamageSpaceManager(){
		return this.damageSpaceManager;
	}
	public void setDamageSpaceManager(DamageSpaceManager manager){
		this.damageSpaceManager = manager;
	}


	public WarehouseAssetManager getWarehouseAssetManager(){
		return this.warehouseAssetManager;
	}
	public void setWarehouseAssetManager(WarehouseAssetManager manager){
		this.warehouseAssetManager = manager;
	}


	public TransportFleetManager getTransportFleetManager(){
		return this.transportFleetManager;
	}
	public void setTransportFleetManager(TransportFleetManager manager){
		this.transportFleetManager = manager;
	}


	public TransportTruckManager getTransportTruckManager(){
		return this.transportTruckManager;
	}
	public void setTransportTruckManager(TransportTruckManager manager){
		this.transportTruckManager = manager;
	}


	public TruckDriverManager getTruckDriverManager(){
		return this.truckDriverManager;
	}
	public void setTruckDriverManager(TruckDriverManager manager){
		this.truckDriverManager = manager;
	}


	public TransportTaskManager getTransportTaskManager(){
		return this.transportTaskManager;
	}
	public void setTransportTaskManager(TransportTaskManager manager){
		this.transportTaskManager = manager;
	}


	public TransportTaskTrackManager getTransportTaskTrackManager(){
		return this.transportTaskTrackManager;
	}
	public void setTransportTaskTrackManager(TransportTaskTrackManager manager){
		this.transportTaskTrackManager = manager;
	}


	public AccountSetManager getAccountSetManager(){
		return this.accountSetManager;
	}
	public void setAccountSetManager(AccountSetManager manager){
		this.accountSetManager = manager;
	}


	public AccountingSubjectManager getAccountingSubjectManager(){
		return this.accountingSubjectManager;
	}
	public void setAccountingSubjectManager(AccountingSubjectManager manager){
		this.accountingSubjectManager = manager;
	}


	public AccountingPeriodManager getAccountingPeriodManager(){
		return this.accountingPeriodManager;
	}
	public void setAccountingPeriodManager(AccountingPeriodManager manager){
		this.accountingPeriodManager = manager;
	}


	public AccountingDocumentTypeManager getAccountingDocumentTypeManager(){
		return this.accountingDocumentTypeManager;
	}
	public void setAccountingDocumentTypeManager(AccountingDocumentTypeManager manager){
		this.accountingDocumentTypeManager = manager;
	}


	public AccountingDocumentManager getAccountingDocumentManager(){
		return this.accountingDocumentManager;
	}
	public void setAccountingDocumentManager(AccountingDocumentManager manager){
		this.accountingDocumentManager = manager;
	}


	public AccountingDocumentCreationManager getAccountingDocumentCreationManager(){
		return this.accountingDocumentCreationManager;
	}
	public void setAccountingDocumentCreationManager(AccountingDocumentCreationManager manager){
		this.accountingDocumentCreationManager = manager;
	}


	public AccountingDocumentConfirmationManager getAccountingDocumentConfirmationManager(){
		return this.accountingDocumentConfirmationManager;
	}
	public void setAccountingDocumentConfirmationManager(AccountingDocumentConfirmationManager manager){
		this.accountingDocumentConfirmationManager = manager;
	}


	public AccountingDocumentAuditingManager getAccountingDocumentAuditingManager(){
		return this.accountingDocumentAuditingManager;
	}
	public void setAccountingDocumentAuditingManager(AccountingDocumentAuditingManager manager){
		this.accountingDocumentAuditingManager = manager;
	}


	public AccountingDocumentPostingManager getAccountingDocumentPostingManager(){
		return this.accountingDocumentPostingManager;
	}
	public void setAccountingDocumentPostingManager(AccountingDocumentPostingManager manager){
		this.accountingDocumentPostingManager = manager;
	}


	public OriginalVoucherManager getOriginalVoucherManager(){
		return this.originalVoucherManager;
	}
	public void setOriginalVoucherManager(OriginalVoucherManager manager){
		this.originalVoucherManager = manager;
	}


	public OriginalVoucherCreationManager getOriginalVoucherCreationManager(){
		return this.originalVoucherCreationManager;
	}
	public void setOriginalVoucherCreationManager(OriginalVoucherCreationManager manager){
		this.originalVoucherCreationManager = manager;
	}


	public OriginalVoucherConfirmationManager getOriginalVoucherConfirmationManager(){
		return this.originalVoucherConfirmationManager;
	}
	public void setOriginalVoucherConfirmationManager(OriginalVoucherConfirmationManager manager){
		this.originalVoucherConfirmationManager = manager;
	}


	public OriginalVoucherAuditingManager getOriginalVoucherAuditingManager(){
		return this.originalVoucherAuditingManager;
	}
	public void setOriginalVoucherAuditingManager(OriginalVoucherAuditingManager manager){
		this.originalVoucherAuditingManager = manager;
	}


	public AccountingDocumentLineManager getAccountingDocumentLineManager(){
		return this.accountingDocumentLineManager;
	}
	public void setAccountingDocumentLineManager(AccountingDocumentLineManager manager){
		this.accountingDocumentLineManager = manager;
	}


	public LevelOneDepartmentManager getLevelOneDepartmentManager(){
		return this.levelOneDepartmentManager;
	}
	public void setLevelOneDepartmentManager(LevelOneDepartmentManager manager){
		this.levelOneDepartmentManager = manager;
	}


	public LevelTwoDepartmentManager getLevelTwoDepartmentManager(){
		return this.levelTwoDepartmentManager;
	}
	public void setLevelTwoDepartmentManager(LevelTwoDepartmentManager manager){
		this.levelTwoDepartmentManager = manager;
	}


	public LevelThreeDepartmentManager getLevelThreeDepartmentManager(){
		return this.levelThreeDepartmentManager;
	}
	public void setLevelThreeDepartmentManager(LevelThreeDepartmentManager manager){
		this.levelThreeDepartmentManager = manager;
	}


	public SkillTypeManager getSkillTypeManager(){
		return this.skillTypeManager;
	}
	public void setSkillTypeManager(SkillTypeManager manager){
		this.skillTypeManager = manager;
	}


	public ResponsibilityTypeManager getResponsibilityTypeManager(){
		return this.responsibilityTypeManager;
	}
	public void setResponsibilityTypeManager(ResponsibilityTypeManager manager){
		this.responsibilityTypeManager = manager;
	}


	public TerminationReasonManager getTerminationReasonManager(){
		return this.terminationReasonManager;
	}
	public void setTerminationReasonManager(TerminationReasonManager manager){
		this.terminationReasonManager = manager;
	}


	public TerminationTypeManager getTerminationTypeManager(){
		return this.terminationTypeManager;
	}
	public void setTerminationTypeManager(TerminationTypeManager manager){
		this.terminationTypeManager = manager;
	}


	public OccupationTypeManager getOccupationTypeManager(){
		return this.occupationTypeManager;
	}
	public void setOccupationTypeManager(OccupationTypeManager manager){
		this.occupationTypeManager = manager;
	}


	public LeaveTypeManager getLeaveTypeManager(){
		return this.leaveTypeManager;
	}
	public void setLeaveTypeManager(LeaveTypeManager manager){
		this.leaveTypeManager = manager;
	}


	public SalaryGradeManager getSalaryGradeManager(){
		return this.salaryGradeManager;
	}
	public void setSalaryGradeManager(SalaryGradeManager manager){
		this.salaryGradeManager = manager;
	}


	public InterviewTypeManager getInterviewTypeManager(){
		return this.interviewTypeManager;
	}
	public void setInterviewTypeManager(InterviewTypeManager manager){
		this.interviewTypeManager = manager;
	}


	public TrainingCourseTypeManager getTrainingCourseTypeManager(){
		return this.trainingCourseTypeManager;
	}
	public void setTrainingCourseTypeManager(TrainingCourseTypeManager manager){
		this.trainingCourseTypeManager = manager;
	}


	public PublicHolidayManager getPublicHolidayManager(){
		return this.publicHolidayManager;
	}
	public void setPublicHolidayManager(PublicHolidayManager manager){
		this.publicHolidayManager = manager;
	}


	public TerminationManager getTerminationManager(){
		return this.terminationManager;
	}
	public void setTerminationManager(TerminationManager manager){
		this.terminationManager = manager;
	}


	public ViewManager getViewManager(){
		return this.viewManager;
	}
	public void setViewManager(ViewManager manager){
		this.viewManager = manager;
	}


	public EmployeeManager getEmployeeManager(){
		return this.employeeManager;
	}
	public void setEmployeeManager(EmployeeManager manager){
		this.employeeManager = manager;
	}


	public JobApplicationManager getJobApplicationManager(){
		return this.jobApplicationManager;
	}
	public void setJobApplicationManager(JobApplicationManager manager){
		this.jobApplicationManager = manager;
	}


	public ProfessionInterviewManager getProfessionInterviewManager(){
		return this.professionInterviewManager;
	}
	public void setProfessionInterviewManager(ProfessionInterviewManager manager){
		this.professionInterviewManager = manager;
	}


	public HrInterviewManager getHrInterviewManager(){
		return this.hrInterviewManager;
	}
	public void setHrInterviewManager(HrInterviewManager manager){
		this.hrInterviewManager = manager;
	}


	public OfferApprovalManager getOfferApprovalManager(){
		return this.offerApprovalManager;
	}
	public void setOfferApprovalManager(OfferApprovalManager manager){
		this.offerApprovalManager = manager;
	}


	public OfferAcceptanceManager getOfferAcceptanceManager(){
		return this.offerAcceptanceManager;
	}
	public void setOfferAcceptanceManager(OfferAcceptanceManager manager){
		this.offerAcceptanceManager = manager;
	}


	public EmployeeBoardingManager getEmployeeBoardingManager(){
		return this.employeeBoardingManager;
	}
	public void setEmployeeBoardingManager(EmployeeBoardingManager manager){
		this.employeeBoardingManager = manager;
	}


	public InstructorManager getInstructorManager(){
		return this.instructorManager;
	}
	public void setInstructorManager(InstructorManager manager){
		this.instructorManager = manager;
	}


	public CompanyTrainingManager getCompanyTrainingManager(){
		return this.companyTrainingManager;
	}
	public void setCompanyTrainingManager(CompanyTrainingManager manager){
		this.companyTrainingManager = manager;
	}


	public ScoringManager getScoringManager(){
		return this.scoringManager;
	}
	public void setScoringManager(ScoringManager manager){
		this.scoringManager = manager;
	}


	public EmployeeCompanyTrainingManager getEmployeeCompanyTrainingManager(){
		return this.employeeCompanyTrainingManager;
	}
	public void setEmployeeCompanyTrainingManager(EmployeeCompanyTrainingManager manager){
		this.employeeCompanyTrainingManager = manager;
	}


	public EmployeeSkillManager getEmployeeSkillManager(){
		return this.employeeSkillManager;
	}
	public void setEmployeeSkillManager(EmployeeSkillManager manager){
		this.employeeSkillManager = manager;
	}


	public EmployeePerformanceManager getEmployeePerformanceManager(){
		return this.employeePerformanceManager;
	}
	public void setEmployeePerformanceManager(EmployeePerformanceManager manager){
		this.employeePerformanceManager = manager;
	}


	public EmployeeWorkExperienceManager getEmployeeWorkExperienceManager(){
		return this.employeeWorkExperienceManager;
	}
	public void setEmployeeWorkExperienceManager(EmployeeWorkExperienceManager manager){
		this.employeeWorkExperienceManager = manager;
	}


	public EmployeeLeaveManager getEmployeeLeaveManager(){
		return this.employeeLeaveManager;
	}
	public void setEmployeeLeaveManager(EmployeeLeaveManager manager){
		this.employeeLeaveManager = manager;
	}


	public EmployeeInterviewManager getEmployeeInterviewManager(){
		return this.employeeInterviewManager;
	}
	public void setEmployeeInterviewManager(EmployeeInterviewManager manager){
		this.employeeInterviewManager = manager;
	}


	public EmployeeAttendanceManager getEmployeeAttendanceManager(){
		return this.employeeAttendanceManager;
	}
	public void setEmployeeAttendanceManager(EmployeeAttendanceManager manager){
		this.employeeAttendanceManager = manager;
	}


	public EmployeeQualifierManager getEmployeeQualifierManager(){
		return this.employeeQualifierManager;
	}
	public void setEmployeeQualifierManager(EmployeeQualifierManager manager){
		this.employeeQualifierManager = manager;
	}


	public EmployeeEducationManager getEmployeeEducationManager(){
		return this.employeeEducationManager;
	}
	public void setEmployeeEducationManager(EmployeeEducationManager manager){
		this.employeeEducationManager = manager;
	}


	public EmployeeAwardManager getEmployeeAwardManager(){
		return this.employeeAwardManager;
	}
	public void setEmployeeAwardManager(EmployeeAwardManager manager){
		this.employeeAwardManager = manager;
	}


	public EmployeeSalarySheetManager getEmployeeSalarySheetManager(){
		return this.employeeSalarySheetManager;
	}
	public void setEmployeeSalarySheetManager(EmployeeSalarySheetManager manager){
		this.employeeSalarySheetManager = manager;
	}


	public PayingOffManager getPayingOffManager(){
		return this.payingOffManager;
	}
	public void setPayingOffManager(PayingOffManager manager){
		this.payingOffManager = manager;
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
















