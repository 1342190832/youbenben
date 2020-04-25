package com.youbenben.youbenben;

import java.util.HashMap;
import java.util.Map;
import com.terapico.caf.viewpage.SerializeScope;

import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;
import com.youbenben.youbenben.catalog.Catalog;
import com.youbenben.youbenben.levelonecategory.LevelOneCategory;
import com.youbenben.youbenben.leveltwocategory.LevelTwoCategory;
import com.youbenben.youbenben.levelthreecategory.LevelThreeCategory;
import com.youbenben.youbenben.product.Product;
import com.youbenben.youbenben.sku.Sku;
import com.youbenben.youbenben.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.youbenben.youbenben.provincecenterdepartment.ProvinceCenterDepartment;
import com.youbenben.youbenben.provincecenteremployee.ProvinceCenterEmployee;
import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.youbenben.youbenben.citypartner.CityPartner;
import com.youbenben.youbenben.potentialcustomer.PotentialCustomer;
import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContact;
import com.youbenben.youbenben.cityevent.CityEvent;
import com.youbenben.youbenben.eventattendance.EventAttendance;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.retailstorecreation.RetailStoreCreation;
import com.youbenben.youbenben.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.youbenben.youbenben.retailstorefranchising.RetailStoreFranchising;
import com.youbenben.youbenben.retailstoredecoration.RetailStoreDecoration;
import com.youbenben.youbenben.retailstoreopening.RetailStoreOpening;
import com.youbenben.youbenben.retailstoreclosing.RetailStoreClosing;
import com.youbenben.youbenben.retailstoremember.RetailStoreMember;
import com.youbenben.youbenben.consumerorder.ConsumerOrder;
import com.youbenben.youbenben.consumerorderconfirmation.ConsumerOrderConfirmation;
import com.youbenben.youbenben.consumerorderapproval.ConsumerOrderApproval;
import com.youbenben.youbenben.consumerorderprocessing.ConsumerOrderProcessing;
import com.youbenben.youbenben.consumerordershipment.ConsumerOrderShipment;
import com.youbenben.youbenben.consumerorderdelivery.ConsumerOrderDelivery;
import com.youbenben.youbenben.consumerorderlineitem.ConsumerOrderLineItem;
import com.youbenben.youbenben.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.youbenben.youbenben.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.youbenben.youbenben.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.youbenben.youbenben.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.youbenben.youbenben.memberwishlist.MemberWishlist;
import com.youbenben.youbenben.memberrewardpoint.MemberRewardPoint;
import com.youbenben.youbenben.memberrewardpointredemption.MemberRewardPointRedemption;
import com.youbenben.youbenben.memberwishlistproduct.MemberWishlistProduct;
import com.youbenben.youbenben.retailstorememberaddress.RetailStoreMemberAddress;
import com.youbenben.youbenben.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.youbenben.youbenben.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.youbenben.youbenben.goodssupplier.GoodsSupplier;
import com.youbenben.youbenben.supplierproduct.SupplierProduct;
import com.youbenben.youbenben.productsupplyduration.ProductSupplyDuration;
import com.youbenben.youbenben.supplyorder.SupplyOrder;
import com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmation;
import com.youbenben.youbenben.supplyorderapproval.SupplyOrderApproval;
import com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessing;
import com.youbenben.youbenben.supplyorderpicking.SupplyOrderPicking;
import com.youbenben.youbenben.supplyordershipment.SupplyOrderShipment;
import com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDelivery;
import com.youbenben.youbenben.supplyorderlineitem.SupplyOrderLineItem;
import com.youbenben.youbenben.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.youbenben.youbenben.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.youbenben.youbenben.retailstoreorder.RetailStoreOrder;
import com.youbenben.youbenben.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.youbenben.youbenben.retailstoreorderapproval.RetailStoreOrderApproval;
import com.youbenben.youbenben.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.youbenben.youbenben.retailstoreorderpicking.RetailStoreOrderPicking;
import com.youbenben.youbenben.retailstoreordershipment.RetailStoreOrderShipment;
import com.youbenben.youbenben.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.youbenben.youbenben.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.youbenben.youbenben.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.youbenben.youbenben.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.youbenben.youbenben.warehouse.Warehouse;
import com.youbenben.youbenben.storagespace.StorageSpace;
import com.youbenben.youbenben.smartpallet.SmartPallet;
import com.youbenben.youbenben.goodsshelf.GoodsShelf;
import com.youbenben.youbenben.goodsshelfstockcount.GoodsShelfStockCount;
import com.youbenben.youbenben.stockcountissuetrack.StockCountIssueTrack;
import com.youbenben.youbenben.goodsallocation.GoodsAllocation;
import com.youbenben.youbenben.goods.Goods;
import com.youbenben.youbenben.goodspackaging.GoodsPackaging;
import com.youbenben.youbenben.goodsmovement.GoodsMovement;
import com.youbenben.youbenben.supplierspace.SupplierSpace;
import com.youbenben.youbenben.receivingspace.ReceivingSpace;
import com.youbenben.youbenben.shippingspace.ShippingSpace;
import com.youbenben.youbenben.damagespace.DamageSpace;
import com.youbenben.youbenben.warehouseasset.WarehouseAsset;
import com.youbenben.youbenben.transportfleet.TransportFleet;
import com.youbenben.youbenben.transporttruck.TransportTruck;
import com.youbenben.youbenben.truckdriver.TruckDriver;
import com.youbenben.youbenben.transporttask.TransportTask;
import com.youbenben.youbenben.transporttasktrack.TransportTaskTrack;
import com.youbenben.youbenben.accountset.AccountSet;
import com.youbenben.youbenben.accountingsubject.AccountingSubject;
import com.youbenben.youbenben.accountingperiod.AccountingPeriod;
import com.youbenben.youbenben.accountingdocumenttype.AccountingDocumentType;
import com.youbenben.youbenben.accountingdocument.AccountingDocument;
import com.youbenben.youbenben.accountingdocumentcreation.AccountingDocumentCreation;
import com.youbenben.youbenben.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.youbenben.youbenben.accountingdocumentauditing.AccountingDocumentAuditing;
import com.youbenben.youbenben.accountingdocumentposting.AccountingDocumentPosting;
import com.youbenben.youbenben.originalvoucher.OriginalVoucher;
import com.youbenben.youbenben.originalvouchercreation.OriginalVoucherCreation;
import com.youbenben.youbenben.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.youbenben.youbenben.originalvoucherauditing.OriginalVoucherAuditing;
import com.youbenben.youbenben.accountingdocumentline.AccountingDocumentLine;
import com.youbenben.youbenben.levelonedepartment.LevelOneDepartment;
import com.youbenben.youbenben.leveltwodepartment.LevelTwoDepartment;
import com.youbenben.youbenben.levelthreedepartment.LevelThreeDepartment;
import com.youbenben.youbenben.skilltype.SkillType;
import com.youbenben.youbenben.responsibilitytype.ResponsibilityType;
import com.youbenben.youbenben.terminationreason.TerminationReason;
import com.youbenben.youbenben.terminationtype.TerminationType;
import com.youbenben.youbenben.occupationtype.OccupationType;
import com.youbenben.youbenben.leavetype.LeaveType;
import com.youbenben.youbenben.salarygrade.SalaryGrade;
import com.youbenben.youbenben.interviewtype.InterviewType;
import com.youbenben.youbenben.trainingcoursetype.TrainingCourseType;
import com.youbenben.youbenben.publicholiday.PublicHoliday;
import com.youbenben.youbenben.termination.Termination;
import com.youbenben.youbenben.view.View;
import com.youbenben.youbenben.employee.Employee;
import com.youbenben.youbenben.jobapplication.JobApplication;
import com.youbenben.youbenben.professioninterview.ProfessionInterview;
import com.youbenben.youbenben.hrinterview.HrInterview;
import com.youbenben.youbenben.offerapproval.OfferApproval;
import com.youbenben.youbenben.offeracceptance.OfferAcceptance;
import com.youbenben.youbenben.employeeboarding.EmployeeBoarding;
import com.youbenben.youbenben.instructor.Instructor;
import com.youbenben.youbenben.companytraining.CompanyTraining;
import com.youbenben.youbenben.scoring.Scoring;
import com.youbenben.youbenben.employeecompanytraining.EmployeeCompanyTraining;
import com.youbenben.youbenben.employeeskill.EmployeeSkill;
import com.youbenben.youbenben.employeeperformance.EmployeePerformance;
import com.youbenben.youbenben.employeeworkexperience.EmployeeWorkExperience;
import com.youbenben.youbenben.employeeleave.EmployeeLeave;
import com.youbenben.youbenben.employeeinterview.EmployeeInterview;
import com.youbenben.youbenben.employeeattendance.EmployeeAttendance;
import com.youbenben.youbenben.employeequalifier.EmployeeQualifier;
import com.youbenben.youbenben.employeeeducation.EmployeeEducation;
import com.youbenben.youbenben.employeeaward.EmployeeAward;
import com.youbenben.youbenben.employeesalarysheet.EmployeeSalarySheet;
import com.youbenben.youbenben.payingoff.PayingOff;
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

	/** RetailStoreCountryCenter的简单属性序列化列表 */
	protected SerializeScope getRetailStoreCountryCenterSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreCountryCenter.ID_PROPERTY)
			.field(RetailStoreCountryCenter.NAME_PROPERTY)
			.field(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY)
			.field(RetailStoreCountryCenter.FOUNDED_PROPERTY)
			.field(RetailStoreCountryCenter.WEB_SITE_PROPERTY)
			.field(RetailStoreCountryCenter.ADDRESS_PROPERTY)
			.field(RetailStoreCountryCenter.OPERATED_BY_PROPERTY)
			.field(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY)
			.field(RetailStoreCountryCenter.DESCRIPTION_PROPERTY)
			.field(RetailStoreCountryCenter.VERSION_PROPERTY)
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

	/** RetailStoreProvinceCenter的简单属性序列化列表 */
	protected SerializeScope getRetailStoreProvinceCenterSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreProvinceCenter.ID_PROPERTY)
			.field(RetailStoreProvinceCenter.NAME_PROPERTY)
			.field(RetailStoreProvinceCenter.FOUNDED_PROPERTY)
			.field(RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreProvinceCenter.VERSION_PROPERTY)
		;
	}

	/** ProvinceCenterDepartment的简单属性序列化列表 */
	protected SerializeScope getProvinceCenterDepartmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ProvinceCenterDepartment.ID_PROPERTY)
			.field(ProvinceCenterDepartment.NAME_PROPERTY)
			.field(ProvinceCenterDepartment.FOUNDED_PROPERTY)
			.field(ProvinceCenterDepartment.MANAGER_PROPERTY)
			.field(ProvinceCenterDepartment.VERSION_PROPERTY)
		;
	}

	/** ProvinceCenterEmployee的简单属性序列化列表 */
	protected SerializeScope getProvinceCenterEmployeeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ProvinceCenterEmployee.ID_PROPERTY)
			.field(ProvinceCenterEmployee.NAME_PROPERTY)
			.field(ProvinceCenterEmployee.MOBILE_PROPERTY)
			.field(ProvinceCenterEmployee.EMAIL_PROPERTY)
			.field(ProvinceCenterEmployee.FOUNDED_PROPERTY)
			.field(ProvinceCenterEmployee.VERSION_PROPERTY)
		;
	}

	/** RetailStoreCityServiceCenter的简单属性序列化列表 */
	protected SerializeScope getRetailStoreCityServiceCenterSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreCityServiceCenter.ID_PROPERTY)
			.field(RetailStoreCityServiceCenter.NAME_PROPERTY)
			.field(RetailStoreCityServiceCenter.FOUNDED_PROPERTY)
			.field(RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreCityServiceCenter.VERSION_PROPERTY)
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

	/** RetailStore的简单属性序列化列表 */
	protected SerializeScope getRetailStoreSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStore.ID_PROPERTY)
			.field(RetailStore.NAME_PROPERTY)
			.field(RetailStore.TELEPHONE_PROPERTY)
			.field(RetailStore.OWNER_PROPERTY)
			.field(RetailStore.FOUNDED_PROPERTY)
			.field(RetailStore.LATITUDE_PROPERTY)
			.field(RetailStore.LONGITUDE_PROPERTY)
			.field(RetailStore.DESCRIPTION_PROPERTY)
			.field(RetailStore.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStore.VERSION_PROPERTY)
		;
	}

	/** RetailStoreCreation的简单属性序列化列表 */
	protected SerializeScope getRetailStoreCreationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreCreation.ID_PROPERTY)
			.field(RetailStoreCreation.COMMENT_PROPERTY)
			.field(RetailStoreCreation.VERSION_PROPERTY)
		;
	}

	/** RetailStoreInvestmentInvitation的简单属性序列化列表 */
	protected SerializeScope getRetailStoreInvestmentInvitationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreInvestmentInvitation.ID_PROPERTY)
			.field(RetailStoreInvestmentInvitation.COMMENT_PROPERTY)
			.field(RetailStoreInvestmentInvitation.VERSION_PROPERTY)
		;
	}

	/** RetailStoreFranchising的简单属性序列化列表 */
	protected SerializeScope getRetailStoreFranchisingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreFranchising.ID_PROPERTY)
			.field(RetailStoreFranchising.COMMENT_PROPERTY)
			.field(RetailStoreFranchising.VERSION_PROPERTY)
		;
	}

	/** RetailStoreDecoration的简单属性序列化列表 */
	protected SerializeScope getRetailStoreDecorationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreDecoration.ID_PROPERTY)
			.field(RetailStoreDecoration.COMMENT_PROPERTY)
			.field(RetailStoreDecoration.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOpening的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOpeningSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOpening.ID_PROPERTY)
			.field(RetailStoreOpening.COMMENT_PROPERTY)
			.field(RetailStoreOpening.VERSION_PROPERTY)
		;
	}

	/** RetailStoreClosing的简单属性序列化列表 */
	protected SerializeScope getRetailStoreClosingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreClosing.ID_PROPERTY)
			.field(RetailStoreClosing.COMMENT_PROPERTY)
			.field(RetailStoreClosing.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMember的简单属性序列化列表 */
	protected SerializeScope getRetailStoreMemberSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMember.ID_PROPERTY)
			.field(RetailStoreMember.NAME_PROPERTY)
			.field(RetailStoreMember.MOBILE_PHONE_PROPERTY)
			.field(RetailStoreMember.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrder的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrder.ID_PROPERTY)
			.field(ConsumerOrder.TITLE_PROPERTY)
			.field(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(ConsumerOrder.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderConfirmation的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderConfirmationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderConfirmation.ID_PROPERTY)
			.field(ConsumerOrderConfirmation.WHO_PROPERTY)
			.field(ConsumerOrderConfirmation.CONFIRM_TIME_PROPERTY)
			.field(ConsumerOrderConfirmation.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderApproval的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderApprovalSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderApproval.ID_PROPERTY)
			.field(ConsumerOrderApproval.WHO_PROPERTY)
			.field(ConsumerOrderApproval.APPROVE_TIME_PROPERTY)
			.field(ConsumerOrderApproval.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderProcessing的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderProcessingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderProcessing.ID_PROPERTY)
			.field(ConsumerOrderProcessing.WHO_PROPERTY)
			.field(ConsumerOrderProcessing.PROCESS_TIME_PROPERTY)
			.field(ConsumerOrderProcessing.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderShipment的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderShipmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderShipment.ID_PROPERTY)
			.field(ConsumerOrderShipment.WHO_PROPERTY)
			.field(ConsumerOrderShipment.SHIP_TIME_PROPERTY)
			.field(ConsumerOrderShipment.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderDelivery的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderDeliverySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderDelivery.ID_PROPERTY)
			.field(ConsumerOrderDelivery.WHO_PROPERTY)
			.field(ConsumerOrderDelivery.DELIVERY_TIME_PROPERTY)
			.field(ConsumerOrderDelivery.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderLineItem的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderLineItemSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderLineItem.ID_PROPERTY)
			.field(ConsumerOrderLineItem.SKU_ID_PROPERTY)
			.field(ConsumerOrderLineItem.SKU_NAME_PROPERTY)
			.field(ConsumerOrderLineItem.PRICE_PROPERTY)
			.field(ConsumerOrderLineItem.QUANTITY_PROPERTY)
			.field(ConsumerOrderLineItem.AMOUNT_PROPERTY)
			.field(ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY)
			.field(ConsumerOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderShippingGroup的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderShippingGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderShippingGroup.ID_PROPERTY)
			.field(ConsumerOrderShippingGroup.NAME_PROPERTY)
			.field(ConsumerOrderShippingGroup.AMOUNT_PROPERTY)
			.field(ConsumerOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderPaymentGroup的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderPaymentGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderPaymentGroup.ID_PROPERTY)
			.field(ConsumerOrderPaymentGroup.NAME_PROPERTY)
			.field(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY)
			.field(ConsumerOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderPriceAdjustment的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderPriceAdjustmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderPriceAdjustment.ID_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.NAME_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberCoupon的简单属性序列化列表 */
	protected SerializeScope getRetailStoreMemberCouponSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberCoupon.ID_PROPERTY)
			.field(RetailStoreMemberCoupon.NAME_PROPERTY)
			.field(RetailStoreMemberCoupon.NUMBER_PROPERTY)
			.field(RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreMemberCoupon.VERSION_PROPERTY)
		;
	}

	/** MemberWishlist的简单属性序列化列表 */
	protected SerializeScope getMemberWishlistSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(MemberWishlist.ID_PROPERTY)
			.field(MemberWishlist.NAME_PROPERTY)
			.field(MemberWishlist.VERSION_PROPERTY)
		;
	}

	/** MemberRewardPoint的简单属性序列化列表 */
	protected SerializeScope getMemberRewardPointSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(MemberRewardPoint.ID_PROPERTY)
			.field(MemberRewardPoint.NAME_PROPERTY)
			.field(MemberRewardPoint.POINT_PROPERTY)
			.field(MemberRewardPoint.VERSION_PROPERTY)
		;
	}

	/** MemberRewardPointRedemption的简单属性序列化列表 */
	protected SerializeScope getMemberRewardPointRedemptionSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(MemberRewardPointRedemption.ID_PROPERTY)
			.field(MemberRewardPointRedemption.NAME_PROPERTY)
			.field(MemberRewardPointRedemption.POINT_PROPERTY)
			.field(MemberRewardPointRedemption.VERSION_PROPERTY)
		;
	}

	/** MemberWishlistProduct的简单属性序列化列表 */
	protected SerializeScope getMemberWishlistProductSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(MemberWishlistProduct.ID_PROPERTY)
			.field(MemberWishlistProduct.NAME_PROPERTY)
			.field(MemberWishlistProduct.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberAddress的简单属性序列化列表 */
	protected SerializeScope getRetailStoreMemberAddressSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberAddress.ID_PROPERTY)
			.field(RetailStoreMemberAddress.NAME_PROPERTY)
			.field(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY)
			.field(RetailStoreMemberAddress.ADDRESS_PROPERTY)
			.field(RetailStoreMemberAddress.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberGiftCard的简单属性序列化列表 */
	protected SerializeScope getRetailStoreMemberGiftCardSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberGiftCard.ID_PROPERTY)
			.field(RetailStoreMemberGiftCard.NAME_PROPERTY)
			.field(RetailStoreMemberGiftCard.NUMBER_PROPERTY)
			.field(RetailStoreMemberGiftCard.REMAIN_PROPERTY)
			.field(RetailStoreMemberGiftCard.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberGiftCardConsumeRecord的简单属性序列化列表 */
	protected SerializeScope getRetailStoreMemberGiftCardConsumeRecordSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.VERSION_PROPERTY)
		;
	}

	/** GoodsSupplier的简单属性序列化列表 */
	protected SerializeScope getGoodsSupplierSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsSupplier.ID_PROPERTY)
			.field(GoodsSupplier.NAME_PROPERTY)
			.field(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY)
			.field(GoodsSupplier.CONTACT_NUMBER_PROPERTY)
			.field(GoodsSupplier.DESCRIPTION_PROPERTY)
			.field(GoodsSupplier.LAST_UPDATE_TIME_PROPERTY)
			.field(GoodsSupplier.VERSION_PROPERTY)
		;
	}

	/** SupplierProduct的简单属性序列化列表 */
	protected SerializeScope getSupplierProductSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplierProduct.ID_PROPERTY)
			.field(SupplierProduct.PRODUCT_NAME_PROPERTY)
			.field(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY)
			.field(SupplierProduct.PRODUCT_UNIT_PROPERTY)
			.field(SupplierProduct.VERSION_PROPERTY)
		;
	}

	/** ProductSupplyDuration的简单属性序列化列表 */
	protected SerializeScope getProductSupplyDurationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ProductSupplyDuration.ID_PROPERTY)
			.field(ProductSupplyDuration.QUANTITY_PROPERTY)
			.field(ProductSupplyDuration.DURATION_PROPERTY)
			.field(ProductSupplyDuration.PRICE_PROPERTY)
			.field(ProductSupplyDuration.VERSION_PROPERTY)
		;
	}

	/** SupplyOrder的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrder.ID_PROPERTY)
			.field(SupplyOrder.TITLE_PROPERTY)
			.field(SupplyOrder.TOTAL_AMOUNT_PROPERTY)
			.field(SupplyOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(SupplyOrder.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderConfirmation的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderConfirmationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderConfirmation.ID_PROPERTY)
			.field(SupplyOrderConfirmation.WHO_PROPERTY)
			.field(SupplyOrderConfirmation.CONFIRM_TIME_PROPERTY)
			.field(SupplyOrderConfirmation.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderApproval的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderApprovalSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderApproval.ID_PROPERTY)
			.field(SupplyOrderApproval.WHO_PROPERTY)
			.field(SupplyOrderApproval.APPROVE_TIME_PROPERTY)
			.field(SupplyOrderApproval.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderProcessing的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderProcessingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderProcessing.ID_PROPERTY)
			.field(SupplyOrderProcessing.WHO_PROPERTY)
			.field(SupplyOrderProcessing.PROCESS_TIME_PROPERTY)
			.field(SupplyOrderProcessing.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderPicking的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderPickingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderPicking.ID_PROPERTY)
			.field(SupplyOrderPicking.WHO_PROPERTY)
			.field(SupplyOrderPicking.PROCESS_TIME_PROPERTY)
			.field(SupplyOrderPicking.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderShipment的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderShipmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderShipment.ID_PROPERTY)
			.field(SupplyOrderShipment.WHO_PROPERTY)
			.field(SupplyOrderShipment.SHIP_TIME_PROPERTY)
			.field(SupplyOrderShipment.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderDelivery的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderDeliverySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderDelivery.ID_PROPERTY)
			.field(SupplyOrderDelivery.WHO_PROPERTY)
			.field(SupplyOrderDelivery.DELIVERY_TIME_PROPERTY)
			.field(SupplyOrderDelivery.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderLineItem的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderLineItemSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderLineItem.ID_PROPERTY)
			.field(SupplyOrderLineItem.SKU_ID_PROPERTY)
			.field(SupplyOrderLineItem.SKU_NAME_PROPERTY)
			.field(SupplyOrderLineItem.AMOUNT_PROPERTY)
			.field(SupplyOrderLineItem.QUANTITY_PROPERTY)
			.field(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
			.field(SupplyOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderShippingGroup的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderShippingGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderShippingGroup.ID_PROPERTY)
			.field(SupplyOrderShippingGroup.NAME_PROPERTY)
			.field(SupplyOrderShippingGroup.AMOUNT_PROPERTY)
			.field(SupplyOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderPaymentGroup的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderPaymentGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderPaymentGroup.ID_PROPERTY)
			.field(SupplyOrderPaymentGroup.NAME_PROPERTY)
			.field(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY)
			.field(SupplyOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrder的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrder.ID_PROPERTY)
			.field(RetailStoreOrder.TITLE_PROPERTY)
			.field(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY)
			.field(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreOrder.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderConfirmation的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderConfirmationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderConfirmation.ID_PROPERTY)
			.field(RetailStoreOrderConfirmation.WHO_PROPERTY)
			.field(RetailStoreOrderConfirmation.CONFIRM_TIME_PROPERTY)
			.field(RetailStoreOrderConfirmation.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderApproval的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderApprovalSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderApproval.ID_PROPERTY)
			.field(RetailStoreOrderApproval.WHO_PROPERTY)
			.field(RetailStoreOrderApproval.APPROVE_TIME_PROPERTY)
			.field(RetailStoreOrderApproval.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderProcessing的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderProcessingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderProcessing.ID_PROPERTY)
			.field(RetailStoreOrderProcessing.WHO_PROPERTY)
			.field(RetailStoreOrderProcessing.PROCESS_TIME_PROPERTY)
			.field(RetailStoreOrderProcessing.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderPicking的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderPickingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderPicking.ID_PROPERTY)
			.field(RetailStoreOrderPicking.WHO_PROPERTY)
			.field(RetailStoreOrderPicking.PROCESS_TIME_PROPERTY)
			.field(RetailStoreOrderPicking.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderShipment的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderShipmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderShipment.ID_PROPERTY)
			.field(RetailStoreOrderShipment.WHO_PROPERTY)
			.field(RetailStoreOrderShipment.SHIP_TIME_PROPERTY)
			.field(RetailStoreOrderShipment.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderDelivery的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderDeliverySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderDelivery.ID_PROPERTY)
			.field(RetailStoreOrderDelivery.WHO_PROPERTY)
			.field(RetailStoreOrderDelivery.DELIVERY_TIME_PROPERTY)
			.field(RetailStoreOrderDelivery.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderLineItem的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderLineItemSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderLineItem.ID_PROPERTY)
			.field(RetailStoreOrderLineItem.SKU_ID_PROPERTY)
			.field(RetailStoreOrderLineItem.SKU_NAME_PROPERTY)
			.field(RetailStoreOrderLineItem.AMOUNT_PROPERTY)
			.field(RetailStoreOrderLineItem.QUANTITY_PROPERTY)
			.field(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
			.field(RetailStoreOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderShippingGroup的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderShippingGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderShippingGroup.ID_PROPERTY)
			.field(RetailStoreOrderShippingGroup.NAME_PROPERTY)
			.field(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY)
			.field(RetailStoreOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderPaymentGroup的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderPaymentGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderPaymentGroup.ID_PROPERTY)
			.field(RetailStoreOrderPaymentGroup.NAME_PROPERTY)
			.field(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY)
			.field(RetailStoreOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** Warehouse的简单属性序列化列表 */
	protected SerializeScope getWarehouseSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Warehouse.ID_PROPERTY)
			.field(Warehouse.LOCATION_PROPERTY)
			.field(Warehouse.CONTACT_NUMBER_PROPERTY)
			.field(Warehouse.TOTAL_AREA_PROPERTY)
			.field(Warehouse.LATITUDE_PROPERTY)
			.field(Warehouse.LONGITUDE_PROPERTY)
			.field(Warehouse.LAST_UPDATE_TIME_PROPERTY)
			.field(Warehouse.VERSION_PROPERTY)
		;
	}

	/** StorageSpace的简单属性序列化列表 */
	protected SerializeScope getStorageSpaceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(StorageSpace.ID_PROPERTY)
			.field(StorageSpace.LOCATION_PROPERTY)
			.field(StorageSpace.CONTACT_NUMBER_PROPERTY)
			.field(StorageSpace.TOTAL_AREA_PROPERTY)
			.field(StorageSpace.LATITUDE_PROPERTY)
			.field(StorageSpace.LONGITUDE_PROPERTY)
			.field(StorageSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(StorageSpace.VERSION_PROPERTY)
		;
	}

	/** SmartPallet的简单属性序列化列表 */
	protected SerializeScope getSmartPalletSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SmartPallet.ID_PROPERTY)
			.field(SmartPallet.LOCATION_PROPERTY)
			.field(SmartPallet.CONTACT_NUMBER_PROPERTY)
			.field(SmartPallet.TOTAL_AREA_PROPERTY)
			.field(SmartPallet.LATITUDE_PROPERTY)
			.field(SmartPallet.LONGITUDE_PROPERTY)
			.field(SmartPallet.LAST_UPDATE_TIME_PROPERTY)
			.field(SmartPallet.VERSION_PROPERTY)
		;
	}

	/** GoodsShelf的简单属性序列化列表 */
	protected SerializeScope getGoodsShelfSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsShelf.ID_PROPERTY)
			.field(GoodsShelf.LOCATION_PROPERTY)
			.field(GoodsShelf.LAST_UPDATE_TIME_PROPERTY)
			.field(GoodsShelf.VERSION_PROPERTY)
		;
	}

	/** GoodsShelfStockCount的简单属性序列化列表 */
	protected SerializeScope getGoodsShelfStockCountSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsShelfStockCount.ID_PROPERTY)
			.field(GoodsShelfStockCount.TITLE_PROPERTY)
			.field(GoodsShelfStockCount.COUNT_TIME_PROPERTY)
			.field(GoodsShelfStockCount.SUMMARY_PROPERTY)
			.field(GoodsShelfStockCount.VERSION_PROPERTY)
		;
	}

	/** StockCountIssueTrack的简单属性序列化列表 */
	protected SerializeScope getStockCountIssueTrackSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(StockCountIssueTrack.ID_PROPERTY)
			.field(StockCountIssueTrack.TITLE_PROPERTY)
			.field(StockCountIssueTrack.COUNT_TIME_PROPERTY)
			.field(StockCountIssueTrack.SUMMARY_PROPERTY)
			.field(StockCountIssueTrack.VERSION_PROPERTY)
		;
	}

	/** GoodsAllocation的简单属性序列化列表 */
	protected SerializeScope getGoodsAllocationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsAllocation.ID_PROPERTY)
			.field(GoodsAllocation.LOCATION_PROPERTY)
			.field(GoodsAllocation.LATITUDE_PROPERTY)
			.field(GoodsAllocation.LONGITUDE_PROPERTY)
			.field(GoodsAllocation.VERSION_PROPERTY)
		;
	}

	/** Goods的简单属性序列化列表 */
	protected SerializeScope getGoodsSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Goods.ID_PROPERTY)
			.field(Goods.NAME_PROPERTY)
			.field(Goods.RFID_PROPERTY)
			.field(Goods.UOM_PROPERTY)
			.field(Goods.MAX_PACKAGE_PROPERTY)
			.field(Goods.EXPIRE_TIME_PROPERTY)
			.field(Goods.VERSION_PROPERTY)
		;
	}

	/** GoodsPackaging的简单属性序列化列表 */
	protected SerializeScope getGoodsPackagingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsPackaging.ID_PROPERTY)
			.field(GoodsPackaging.PACKAGE_NAME_PROPERTY)
			.field(GoodsPackaging.RFID_PROPERTY)
			.field(GoodsPackaging.PACKAGE_TIME_PROPERTY)
			.field(GoodsPackaging.DESCRIPTION_PROPERTY)
			.field(GoodsPackaging.VERSION_PROPERTY)
		;
	}

	/** GoodsMovement的简单属性序列化列表 */
	protected SerializeScope getGoodsMovementSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsMovement.ID_PROPERTY)
			.field(GoodsMovement.MOVE_TIME_PROPERTY)
			.field(GoodsMovement.FACILITY_PROPERTY)
			.field(GoodsMovement.FACILITY_ID_PROPERTY)
			.field(GoodsMovement.FROM_IP_PROPERTY)
			.field(GoodsMovement.USER_AGENT_PROPERTY)
			.field(GoodsMovement.SESSION_ID_PROPERTY)
			.field(GoodsMovement.LATITUDE_PROPERTY)
			.field(GoodsMovement.LONGITUDE_PROPERTY)
			.field(GoodsMovement.VERSION_PROPERTY)
		;
	}

	/** SupplierSpace的简单属性序列化列表 */
	protected SerializeScope getSupplierSpaceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplierSpace.ID_PROPERTY)
			.field(SupplierSpace.LOCATION_PROPERTY)
			.field(SupplierSpace.CONTACT_NUMBER_PROPERTY)
			.field(SupplierSpace.TOTAL_AREA_PROPERTY)
			.field(SupplierSpace.LATITUDE_PROPERTY)
			.field(SupplierSpace.LONGITUDE_PROPERTY)
			.field(SupplierSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(SupplierSpace.VERSION_PROPERTY)
		;
	}

	/** ReceivingSpace的简单属性序列化列表 */
	protected SerializeScope getReceivingSpaceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ReceivingSpace.ID_PROPERTY)
			.field(ReceivingSpace.LOCATION_PROPERTY)
			.field(ReceivingSpace.CONTACT_NUMBER_PROPERTY)
			.field(ReceivingSpace.DESCRIPTION_PROPERTY)
			.field(ReceivingSpace.TOTAL_AREA_PROPERTY)
			.field(ReceivingSpace.LATITUDE_PROPERTY)
			.field(ReceivingSpace.LONGITUDE_PROPERTY)
			.field(ReceivingSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(ReceivingSpace.VERSION_PROPERTY)
		;
	}

	/** ShippingSpace的简单属性序列化列表 */
	protected SerializeScope getShippingSpaceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ShippingSpace.ID_PROPERTY)
			.field(ShippingSpace.LOCATION_PROPERTY)
			.field(ShippingSpace.CONTACT_NUMBER_PROPERTY)
			.field(ShippingSpace.TOTAL_AREA_PROPERTY)
			.field(ShippingSpace.LATITUDE_PROPERTY)
			.field(ShippingSpace.LONGITUDE_PROPERTY)
			.field(ShippingSpace.DESCRIPTION_PROPERTY)
			.field(ShippingSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(ShippingSpace.VERSION_PROPERTY)
		;
	}

	/** DamageSpace的简单属性序列化列表 */
	protected SerializeScope getDamageSpaceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(DamageSpace.ID_PROPERTY)
			.field(DamageSpace.LOCATION_PROPERTY)
			.field(DamageSpace.CONTACT_NUMBER_PROPERTY)
			.field(DamageSpace.TOTAL_AREA_PROPERTY)
			.field(DamageSpace.LATITUDE_PROPERTY)
			.field(DamageSpace.LONGITUDE_PROPERTY)
			.field(DamageSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(DamageSpace.VERSION_PROPERTY)
		;
	}

	/** WarehouseAsset的简单属性序列化列表 */
	protected SerializeScope getWarehouseAssetSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(WarehouseAsset.ID_PROPERTY)
			.field(WarehouseAsset.NAME_PROPERTY)
			.field(WarehouseAsset.POSITION_PROPERTY)
			.field(WarehouseAsset.LAST_UPDATE_TIME_PROPERTY)
			.field(WarehouseAsset.VERSION_PROPERTY)
		;
	}

	/** TransportFleet的简单属性序列化列表 */
	protected SerializeScope getTransportFleetSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TransportFleet.ID_PROPERTY)
			.field(TransportFleet.NAME_PROPERTY)
			.field(TransportFleet.CONTACT_NUMBER_PROPERTY)
			.field(TransportFleet.LAST_UPDATE_TIME_PROPERTY)
			.field(TransportFleet.VERSION_PROPERTY)
		;
	}

	/** TransportTruck的简单属性序列化列表 */
	protected SerializeScope getTransportTruckSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TransportTruck.ID_PROPERTY)
			.field(TransportTruck.NAME_PROPERTY)
			.field(TransportTruck.PLATE_NUMBER_PROPERTY)
			.field(TransportTruck.CONTACT_NUMBER_PROPERTY)
			.field(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY)
			.field(TransportTruck.ENGINE_NUMBER_PROPERTY)
			.field(TransportTruck.MAKE_DATE_PROPERTY)
			.field(TransportTruck.MILEAGE_PROPERTY)
			.field(TransportTruck.BODY_COLOR_PROPERTY)
			.field(TransportTruck.VERSION_PROPERTY)
		;
	}

	/** TruckDriver的简单属性序列化列表 */
	protected SerializeScope getTruckDriverSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TruckDriver.ID_PROPERTY)
			.field(TruckDriver.NAME_PROPERTY)
			.field(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY)
			.field(TruckDriver.CONTACT_NUMBER_PROPERTY)
			.field(TruckDriver.VERSION_PROPERTY)
		;
	}

	/** TransportTask的简单属性序列化列表 */
	protected SerializeScope getTransportTaskSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TransportTask.ID_PROPERTY)
			.field(TransportTask.NAME_PROPERTY)
			.field(TransportTask.START_PROPERTY)
			.field(TransportTask.BEGIN_TIME_PROPERTY)
			.field(TransportTask.LATITUDE_PROPERTY)
			.field(TransportTask.LONGITUDE_PROPERTY)
			.field(TransportTask.VERSION_PROPERTY)
		;
	}

	/** TransportTaskTrack的简单属性序列化列表 */
	protected SerializeScope getTransportTaskTrackSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TransportTaskTrack.ID_PROPERTY)
			.field(TransportTaskTrack.TRACK_TIME_PROPERTY)
			.field(TransportTaskTrack.LATITUDE_PROPERTY)
			.field(TransportTaskTrack.LONGITUDE_PROPERTY)
			.field(TransportTaskTrack.VERSION_PROPERTY)
		;
	}

	/** AccountSet的简单属性序列化列表 */
	protected SerializeScope getAccountSetSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountSet.ID_PROPERTY)
			.field(AccountSet.NAME_PROPERTY)
			.field(AccountSet.YEAR_SET_PROPERTY)
			.field(AccountSet.EFFECTIVE_DATE_PROPERTY)
			.field(AccountSet.ACCOUNTING_SYSTEM_PROPERTY)
			.field(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY)
			.field(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY)
			.field(AccountSet.OPENING_BANK_PROPERTY)
			.field(AccountSet.ACCOUNT_NUMBER_PROPERTY)
			.field(AccountSet.LAST_UPDATE_TIME_PROPERTY)
			.field(AccountSet.VERSION_PROPERTY)
		;
	}

	/** AccountingSubject的简单属性序列化列表 */
	protected SerializeScope getAccountingSubjectSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingSubject.ID_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY)
			.field(AccountingSubject.VERSION_PROPERTY)
		;
	}

	/** AccountingPeriod的简单属性序列化列表 */
	protected SerializeScope getAccountingPeriodSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingPeriod.ID_PROPERTY)
			.field(AccountingPeriod.NAME_PROPERTY)
			.field(AccountingPeriod.START_DATE_PROPERTY)
			.field(AccountingPeriod.END_DATE_PROPERTY)
			.field(AccountingPeriod.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentType的简单属性序列化列表 */
	protected SerializeScope getAccountingDocumentTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentType.ID_PROPERTY)
			.field(AccountingDocumentType.NAME_PROPERTY)
			.field(AccountingDocumentType.DESCRIPTION_PROPERTY)
			.field(AccountingDocumentType.VERSION_PROPERTY)
		;
	}

	/** AccountingDocument的简单属性序列化列表 */
	protected SerializeScope getAccountingDocumentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocument.ID_PROPERTY)
			.field(AccountingDocument.NAME_PROPERTY)
			.field(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY)
			.field(AccountingDocument.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentCreation的简单属性序列化列表 */
	protected SerializeScope getAccountingDocumentCreationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentCreation.ID_PROPERTY)
			.field(AccountingDocumentCreation.WHO_PROPERTY)
			.field(AccountingDocumentCreation.COMMENTS_PROPERTY)
			.field(AccountingDocumentCreation.MAKE_DATE_PROPERTY)
			.field(AccountingDocumentCreation.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentConfirmation的简单属性序列化列表 */
	protected SerializeScope getAccountingDocumentConfirmationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentConfirmation.ID_PROPERTY)
			.field(AccountingDocumentConfirmation.WHO_PROPERTY)
			.field(AccountingDocumentConfirmation.COMMENTS_PROPERTY)
			.field(AccountingDocumentConfirmation.MAKE_DATE_PROPERTY)
			.field(AccountingDocumentConfirmation.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentAuditing的简单属性序列化列表 */
	protected SerializeScope getAccountingDocumentAuditingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentAuditing.ID_PROPERTY)
			.field(AccountingDocumentAuditing.WHO_PROPERTY)
			.field(AccountingDocumentAuditing.COMMENTS_PROPERTY)
			.field(AccountingDocumentAuditing.MAKE_DATE_PROPERTY)
			.field(AccountingDocumentAuditing.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentPosting的简单属性序列化列表 */
	protected SerializeScope getAccountingDocumentPostingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentPosting.ID_PROPERTY)
			.field(AccountingDocumentPosting.WHO_PROPERTY)
			.field(AccountingDocumentPosting.COMMENTS_PROPERTY)
			.field(AccountingDocumentPosting.MAKE_DATE_PROPERTY)
			.field(AccountingDocumentPosting.VERSION_PROPERTY)
		;
	}

	/** OriginalVoucher的简单属性序列化列表 */
	protected SerializeScope getOriginalVoucherSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OriginalVoucher.ID_PROPERTY)
			.field(OriginalVoucher.TITLE_PROPERTY)
			.field(OriginalVoucher.MADE_BY_PROPERTY)
			.field(OriginalVoucher.RECEIVED_BY_PROPERTY)
			.field(OriginalVoucher.VOUCHER_TYPE_PROPERTY)
			.field(OriginalVoucher.VOUCHER_IMAGE_PROPERTY)
			.field(OriginalVoucher.VERSION_PROPERTY)
		;
	}

	/** OriginalVoucherCreation的简单属性序列化列表 */
	protected SerializeScope getOriginalVoucherCreationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OriginalVoucherCreation.ID_PROPERTY)
			.field(OriginalVoucherCreation.WHO_PROPERTY)
			.field(OriginalVoucherCreation.COMMENTS_PROPERTY)
			.field(OriginalVoucherCreation.MAKE_DATE_PROPERTY)
			.field(OriginalVoucherCreation.VERSION_PROPERTY)
		;
	}

	/** OriginalVoucherConfirmation的简单属性序列化列表 */
	protected SerializeScope getOriginalVoucherConfirmationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OriginalVoucherConfirmation.ID_PROPERTY)
			.field(OriginalVoucherConfirmation.WHO_PROPERTY)
			.field(OriginalVoucherConfirmation.COMMENTS_PROPERTY)
			.field(OriginalVoucherConfirmation.MAKE_DATE_PROPERTY)
			.field(OriginalVoucherConfirmation.VERSION_PROPERTY)
		;
	}

	/** OriginalVoucherAuditing的简单属性序列化列表 */
	protected SerializeScope getOriginalVoucherAuditingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OriginalVoucherAuditing.ID_PROPERTY)
			.field(OriginalVoucherAuditing.WHO_PROPERTY)
			.field(OriginalVoucherAuditing.COMMENTS_PROPERTY)
			.field(OriginalVoucherAuditing.MAKE_DATE_PROPERTY)
			.field(OriginalVoucherAuditing.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentLine的简单属性序列化列表 */
	protected SerializeScope getAccountingDocumentLineSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentLine.ID_PROPERTY)
			.field(AccountingDocumentLine.NAME_PROPERTY)
			.field(AccountingDocumentLine.CODE_PROPERTY)
			.field(AccountingDocumentLine.DIRECT_PROPERTY)
			.field(AccountingDocumentLine.AMOUNT_PROPERTY)
			.field(AccountingDocumentLine.VERSION_PROPERTY)
		;
	}

	/** LevelOneDepartment的简单属性序列化列表 */
	protected SerializeScope getLevelOneDepartmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelOneDepartment.ID_PROPERTY)
			.field(LevelOneDepartment.NAME_PROPERTY)
			.field(LevelOneDepartment.DESCRIPTION_PROPERTY)
			.field(LevelOneDepartment.MANAGER_PROPERTY)
			.field(LevelOneDepartment.FOUNDED_PROPERTY)
			.field(LevelOneDepartment.VERSION_PROPERTY)
		;
	}

	/** LevelTwoDepartment的简单属性序列化列表 */
	protected SerializeScope getLevelTwoDepartmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelTwoDepartment.ID_PROPERTY)
			.field(LevelTwoDepartment.NAME_PROPERTY)
			.field(LevelTwoDepartment.DESCRIPTION_PROPERTY)
			.field(LevelTwoDepartment.FOUNDED_PROPERTY)
			.field(LevelTwoDepartment.VERSION_PROPERTY)
		;
	}

	/** LevelThreeDepartment的简单属性序列化列表 */
	protected SerializeScope getLevelThreeDepartmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelThreeDepartment.ID_PROPERTY)
			.field(LevelThreeDepartment.NAME_PROPERTY)
			.field(LevelThreeDepartment.DESCRIPTION_PROPERTY)
			.field(LevelThreeDepartment.FOUNDED_PROPERTY)
			.field(LevelThreeDepartment.VERSION_PROPERTY)
		;
	}

	/** SkillType的简单属性序列化列表 */
	protected SerializeScope getSkillTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SkillType.ID_PROPERTY)
			.field(SkillType.CODE_PROPERTY)
			.field(SkillType.DESCRIPTION_PROPERTY)
			.field(SkillType.VERSION_PROPERTY)
		;
	}

	/** ResponsibilityType的简单属性序列化列表 */
	protected SerializeScope getResponsibilityTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ResponsibilityType.ID_PROPERTY)
			.field(ResponsibilityType.CODE_PROPERTY)
			.field(ResponsibilityType.BASE_DESCRIPTION_PROPERTY)
			.field(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY)
			.field(ResponsibilityType.VERSION_PROPERTY)
		;
	}

	/** TerminationReason的简单属性序列化列表 */
	protected SerializeScope getTerminationReasonSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TerminationReason.ID_PROPERTY)
			.field(TerminationReason.CODE_PROPERTY)
			.field(TerminationReason.DESCRIPTION_PROPERTY)
			.field(TerminationReason.VERSION_PROPERTY)
		;
	}

	/** TerminationType的简单属性序列化列表 */
	protected SerializeScope getTerminationTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TerminationType.ID_PROPERTY)
			.field(TerminationType.CODE_PROPERTY)
			.field(TerminationType.BASE_DESCRIPTION_PROPERTY)
			.field(TerminationType.DETAIL_DESCRIPTION_PROPERTY)
			.field(TerminationType.VERSION_PROPERTY)
		;
	}

	/** OccupationType的简单属性序列化列表 */
	protected SerializeScope getOccupationTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OccupationType.ID_PROPERTY)
			.field(OccupationType.CODE_PROPERTY)
			.field(OccupationType.DESCRIPTION_PROPERTY)
			.field(OccupationType.DETAIL_DESCRIPTION_PROPERTY)
			.field(OccupationType.VERSION_PROPERTY)
		;
	}

	/** LeaveType的简单属性序列化列表 */
	protected SerializeScope getLeaveTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LeaveType.ID_PROPERTY)
			.field(LeaveType.CODE_PROPERTY)
			.field(LeaveType.DESCRIPTION_PROPERTY)
			.field(LeaveType.DETAIL_DESCRIPTION_PROPERTY)
			.field(LeaveType.VERSION_PROPERTY)
		;
	}

	/** SalaryGrade的简单属性序列化列表 */
	protected SerializeScope getSalaryGradeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SalaryGrade.ID_PROPERTY)
			.field(SalaryGrade.CODE_PROPERTY)
			.field(SalaryGrade.NAME_PROPERTY)
			.field(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY)
			.field(SalaryGrade.VERSION_PROPERTY)
		;
	}

	/** InterviewType的简单属性序列化列表 */
	protected SerializeScope getInterviewTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(InterviewType.ID_PROPERTY)
			.field(InterviewType.CODE_PROPERTY)
			.field(InterviewType.DESCRIPTION_PROPERTY)
			.field(InterviewType.DETAIL_DESCRIPTION_PROPERTY)
			.field(InterviewType.VERSION_PROPERTY)
		;
	}

	/** TrainingCourseType的简单属性序列化列表 */
	protected SerializeScope getTrainingCourseTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TrainingCourseType.ID_PROPERTY)
			.field(TrainingCourseType.CODE_PROPERTY)
			.field(TrainingCourseType.NAME_PROPERTY)
			.field(TrainingCourseType.DESCRIPTION_PROPERTY)
			.field(TrainingCourseType.VERSION_PROPERTY)
		;
	}

	/** PublicHoliday的简单属性序列化列表 */
	protected SerializeScope getPublicHolidaySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PublicHoliday.ID_PROPERTY)
			.field(PublicHoliday.CODE_PROPERTY)
			.field(PublicHoliday.NAME_PROPERTY)
			.field(PublicHoliday.DESCRIPTION_PROPERTY)
			.field(PublicHoliday.VERSION_PROPERTY)
		;
	}

	/** Termination的简单属性序列化列表 */
	protected SerializeScope getTerminationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Termination.ID_PROPERTY)
			.field(Termination.COMMENT_PROPERTY)
			.field(Termination.VERSION_PROPERTY)
		;
	}

	/** View的简单属性序列化列表 */
	protected SerializeScope getViewSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(View.ID_PROPERTY)
			.field(View.WHO_PROPERTY)
			.field(View.ASSESSMENT_PROPERTY)
			.field(View.INTERVIEW_TIME_PROPERTY)
			.field(View.VERSION_PROPERTY)
		;
	}

	/** Employee的简单属性序列化列表 */
	protected SerializeScope getEmployeeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Employee.ID_PROPERTY)
			.field(Employee.TITLE_PROPERTY)
			.field(Employee.FAMILY_NAME_PROPERTY)
			.field(Employee.GIVEN_NAME_PROPERTY)
			.field(Employee.EMAIL_PROPERTY)
			.field(Employee.CITY_PROPERTY)
			.field(Employee.ADDRESS_PROPERTY)
			.field(Employee.CELL_PHONE_PROPERTY)
			.field(Employee.SALARY_ACCOUNT_PROPERTY)
			.field(Employee.LAST_UPDATE_TIME_PROPERTY)
			.field(Employee.VERSION_PROPERTY)
		;
	}

	/** JobApplication的简单属性序列化列表 */
	protected SerializeScope getJobApplicationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(JobApplication.ID_PROPERTY)
			.field(JobApplication.APPLICATION_TIME_PROPERTY)
			.field(JobApplication.WHO_PROPERTY)
			.field(JobApplication.COMMENTS_PROPERTY)
			.field(JobApplication.VERSION_PROPERTY)
		;
	}

	/** ProfessionInterview的简单属性序列化列表 */
	protected SerializeScope getProfessionInterviewSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ProfessionInterview.ID_PROPERTY)
			.field(ProfessionInterview.WHO_PROPERTY)
			.field(ProfessionInterview.INTERVIEW_TIME_PROPERTY)
			.field(ProfessionInterview.COMMENTS_PROPERTY)
			.field(ProfessionInterview.VERSION_PROPERTY)
		;
	}

	/** HrInterview的简单属性序列化列表 */
	protected SerializeScope getHrInterviewSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(HrInterview.ID_PROPERTY)
			.field(HrInterview.WHO_PROPERTY)
			.field(HrInterview.INTERVIEW_TIME_PROPERTY)
			.field(HrInterview.COMMENTS_PROPERTY)
			.field(HrInterview.VERSION_PROPERTY)
		;
	}

	/** OfferApproval的简单属性序列化列表 */
	protected SerializeScope getOfferApprovalSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OfferApproval.ID_PROPERTY)
			.field(OfferApproval.WHO_PROPERTY)
			.field(OfferApproval.APPROVE_TIME_PROPERTY)
			.field(OfferApproval.COMMENTS_PROPERTY)
			.field(OfferApproval.VERSION_PROPERTY)
		;
	}

	/** OfferAcceptance的简单属性序列化列表 */
	protected SerializeScope getOfferAcceptanceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OfferAcceptance.ID_PROPERTY)
			.field(OfferAcceptance.WHO_PROPERTY)
			.field(OfferAcceptance.ACCEPT_TIME_PROPERTY)
			.field(OfferAcceptance.COMMENTS_PROPERTY)
			.field(OfferAcceptance.VERSION_PROPERTY)
		;
	}

	/** EmployeeBoarding的简单属性序列化列表 */
	protected SerializeScope getEmployeeBoardingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeBoarding.ID_PROPERTY)
			.field(EmployeeBoarding.WHO_PROPERTY)
			.field(EmployeeBoarding.EMPLOY_TIME_PROPERTY)
			.field(EmployeeBoarding.COMMENTS_PROPERTY)
			.field(EmployeeBoarding.VERSION_PROPERTY)
		;
	}

	/** Instructor的简单属性序列化列表 */
	protected SerializeScope getInstructorSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Instructor.ID_PROPERTY)
			.field(Instructor.TITLE_PROPERTY)
			.field(Instructor.FAMILY_NAME_PROPERTY)
			.field(Instructor.GIVEN_NAME_PROPERTY)
			.field(Instructor.CELL_PHONE_PROPERTY)
			.field(Instructor.EMAIL_PROPERTY)
			.field(Instructor.INTRODUCTION_PROPERTY)
			.field(Instructor.LAST_UPDATE_TIME_PROPERTY)
			.field(Instructor.VERSION_PROPERTY)
		;
	}

	/** CompanyTraining的简单属性序列化列表 */
	protected SerializeScope getCompanyTrainingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CompanyTraining.ID_PROPERTY)
			.field(CompanyTraining.TITLE_PROPERTY)
			.field(CompanyTraining.TIME_START_PROPERTY)
			.field(CompanyTraining.DURATION_HOURS_PROPERTY)
			.field(CompanyTraining.LAST_UPDATE_TIME_PROPERTY)
			.field(CompanyTraining.VERSION_PROPERTY)
		;
	}

	/** Scoring的简单属性序列化列表 */
	protected SerializeScope getScoringSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Scoring.ID_PROPERTY)
			.field(Scoring.SCORED_BY_PROPERTY)
			.field(Scoring.SCORE_PROPERTY)
			.field(Scoring.COMMENT_PROPERTY)
			.field(Scoring.VERSION_PROPERTY)
		;
	}

	/** EmployeeCompanyTraining的简单属性序列化列表 */
	protected SerializeScope getEmployeeCompanyTrainingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeCompanyTraining.ID_PROPERTY)
			.field(EmployeeCompanyTraining.VERSION_PROPERTY)
		;
	}

	/** EmployeeSkill的简单属性序列化列表 */
	protected SerializeScope getEmployeeSkillSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeSkill.ID_PROPERTY)
			.field(EmployeeSkill.DESCRIPTION_PROPERTY)
			.field(EmployeeSkill.VERSION_PROPERTY)
		;
	}

	/** EmployeePerformance的简单属性序列化列表 */
	protected SerializeScope getEmployeePerformanceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeePerformance.ID_PROPERTY)
			.field(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY)
			.field(EmployeePerformance.VERSION_PROPERTY)
		;
	}

	/** EmployeeWorkExperience的简单属性序列化列表 */
	protected SerializeScope getEmployeeWorkExperienceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeWorkExperience.ID_PROPERTY)
			.field(EmployeeWorkExperience.START_PROPERTY)
			.field(EmployeeWorkExperience.END_PROPERTY)
			.field(EmployeeWorkExperience.COMPANY_PROPERTY)
			.field(EmployeeWorkExperience.DESCRIPTION_PROPERTY)
			.field(EmployeeWorkExperience.VERSION_PROPERTY)
		;
	}

	/** EmployeeLeave的简单属性序列化列表 */
	protected SerializeScope getEmployeeLeaveSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeLeave.ID_PROPERTY)
			.field(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY)
			.field(EmployeeLeave.REMARK_PROPERTY)
			.field(EmployeeLeave.VERSION_PROPERTY)
		;
	}

	/** EmployeeInterview的简单属性序列化列表 */
	protected SerializeScope getEmployeeInterviewSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeInterview.ID_PROPERTY)
			.field(EmployeeInterview.REMARK_PROPERTY)
			.field(EmployeeInterview.VERSION_PROPERTY)
		;
	}

	/** EmployeeAttendance的简单属性序列化列表 */
	protected SerializeScope getEmployeeAttendanceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeAttendance.ID_PROPERTY)
			.field(EmployeeAttendance.ENTER_TIME_PROPERTY)
			.field(EmployeeAttendance.LEAVE_TIME_PROPERTY)
			.field(EmployeeAttendance.DURATION_HOURS_PROPERTY)
			.field(EmployeeAttendance.REMARK_PROPERTY)
			.field(EmployeeAttendance.VERSION_PROPERTY)
		;
	}

	/** EmployeeQualifier的简单属性序列化列表 */
	protected SerializeScope getEmployeeQualifierSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeQualifier.ID_PROPERTY)
			.field(EmployeeQualifier.QUALIFIED_TIME_PROPERTY)
			.field(EmployeeQualifier.TYPE_PROPERTY)
			.field(EmployeeQualifier.LEVEL_PROPERTY)
			.field(EmployeeQualifier.REMARK_PROPERTY)
			.field(EmployeeQualifier.VERSION_PROPERTY)
		;
	}

	/** EmployeeEducation的简单属性序列化列表 */
	protected SerializeScope getEmployeeEducationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeEducation.ID_PROPERTY)
			.field(EmployeeEducation.COMPLETE_TIME_PROPERTY)
			.field(EmployeeEducation.TYPE_PROPERTY)
			.field(EmployeeEducation.REMARK_PROPERTY)
			.field(EmployeeEducation.VERSION_PROPERTY)
		;
	}

	/** EmployeeAward的简单属性序列化列表 */
	protected SerializeScope getEmployeeAwardSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeAward.ID_PROPERTY)
			.field(EmployeeAward.COMPLETE_TIME_PROPERTY)
			.field(EmployeeAward.TYPE_PROPERTY)
			.field(EmployeeAward.REMARK_PROPERTY)
			.field(EmployeeAward.VERSION_PROPERTY)
		;
	}

	/** EmployeeSalarySheet的简单属性序列化列表 */
	protected SerializeScope getEmployeeSalarySheetSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeSalarySheet.ID_PROPERTY)
			.field(EmployeeSalarySheet.BASE_SALARY_PROPERTY)
			.field(EmployeeSalarySheet.BONUS_PROPERTY)
			.field(EmployeeSalarySheet.REWARD_PROPERTY)
			.field(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY)
			.field(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY)
			.field(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY)
			.field(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY)
			.field(EmployeeSalarySheet.VERSION_PROPERTY)
		;
	}

	/** PayingOff的简单属性序列化列表 */
	protected SerializeScope getPayingOffSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PayingOff.ID_PROPERTY)
			.field(PayingOff.WHO_PROPERTY)
			.field(PayingOff.PAID_TIME_PROPERTY)
			.field(PayingOff.AMOUNT_PROPERTY)
			.field(PayingOff.VERSION_PROPERTY)
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

	/** RetailStoreCountryCenter的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreCountryCenterListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='油奔奔中国运营中心|油奔奔美国运营中心|油奔奔日本运营中心|油奔奔泰国运营中心';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='油奔奔中国正式成立，恭喜恭喜';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreCountryCenter.ID_PROPERTY)
			.field(RetailStoreCountryCenter.NAME_PROPERTY).as("title")
			.field(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY)
			.field(RetailStoreCountryCenter.FOUNDED_PROPERTY)
			.field(RetailStoreCountryCenter.WEB_SITE_PROPERTY)
			.field(RetailStoreCountryCenter.ADDRESS_PROPERTY)
			.field(RetailStoreCountryCenter.OPERATED_BY_PROPERTY)
			.field(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY)
			.field(RetailStoreCountryCenter.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(RetailStoreCountryCenter.VERSION_PROPERTY)
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
			.field(Catalog.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
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
		//	value='饲料|柴油|其他';
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
		//	value='饲料|柴油|其他';
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
		//	value='饲料|柴油|其他';
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
		//	value='香烟|矿泉水|司机枕垫';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='origin';
		//	type='string';
		//	value='四川|广东|江苏|安徽|日本|法国';
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

	/** RetailStoreProvinceCenter的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreProvinceCenterListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='油奔奔山东省运营中心|油奔奔北京运营中心';
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
			.field(RetailStoreProvinceCenter.ID_PROPERTY)
			.field(RetailStoreProvinceCenter.NAME_PROPERTY).as("title")
			.field(RetailStoreProvinceCenter.FOUNDED_PROPERTY).as("brief").with_prefix("成立: ")
			.field(RetailStoreProvinceCenter.COUNTRY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreProvinceCenter.VERSION_PROPERTY)
		;
	}

	/** ProvinceCenterDepartment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getProvinceCenterDepartmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='供应链部|采购部|管理部|财务部|法务部|市场部|人力资源部|调度部|加油站';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='manager';
		//	type='string';
		//	value='刘强|王德宏';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ProvinceCenterDepartment.ID_PROPERTY)
			.field(ProvinceCenterDepartment.NAME_PROPERTY).as("title")
			.field(ProvinceCenterDepartment.FOUNDED_PROPERTY)
			.field(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
			.field(ProvinceCenterDepartment.MANAGER_PROPERTY).as("brief").with_prefix("经理: ")
			.field(ProvinceCenterDepartment.VERSION_PROPERTY)
		;
	}

	/** ProvinceCenterEmployee的ListOf时需要序列化的属性列表 */
	protected SerializeScope getProvinceCenterEmployeeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='刘强|王德宏';
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
			.field(ProvinceCenterEmployee.ID_PROPERTY)
			.field(ProvinceCenterEmployee.NAME_PROPERTY).as("title")
			.field(ProvinceCenterEmployee.MOBILE_PROPERTY).as("brief").with_prefix("手机号码: ")
			.field(ProvinceCenterEmployee.EMAIL_PROPERTY)
			.field(ProvinceCenterEmployee.FOUNDED_PROPERTY)
			.field(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, getProvinceCenterDepartmentSummaryScope())
			.field(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
			.field(ProvinceCenterEmployee.VERSION_PROPERTY)
		;
	}

	/** RetailStoreCityServiceCenter的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreCityServiceCenterListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='油奔奔济南|油奔奔菏泽|油奔奔滨州';
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
			.field(RetailStoreCityServiceCenter.ID_PROPERTY)
			.field(RetailStoreCityServiceCenter.NAME_PROPERTY).as("title")
			.field(RetailStoreCityServiceCenter.FOUNDED_PROPERTY).as("brief").with_prefix("成立: ")
			.field(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
			.field(RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreCityServiceCenter.VERSION_PROPERTY)
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
			.field(CityPartner.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
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
			.field(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
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
			.field(CityEvent.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
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

	/** RetailStore的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='槐荫区油奔奔|历下区油奔奔|长清区油奔奔';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='啤酒饮料矿泉水，香肠瓜子方便面, 请让一让';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStore.ID_PROPERTY)
			.field(RetailStore.NAME_PROPERTY).as("title")
			.field(RetailStore.TELEPHONE_PROPERTY)
			.field(RetailStore.OWNER_PROPERTY)
			.field(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(RetailStore.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
			.field(RetailStore.CREATION_PROPERTY, getRetailStoreCreationSummaryScope())
			.field(RetailStore.INVESTMENT_INVITATION_PROPERTY, getRetailStoreInvestmentInvitationSummaryScope())
			.field(RetailStore.FRANCHISING_PROPERTY, getRetailStoreFranchisingSummaryScope())
			.field(RetailStore.DECORATION_PROPERTY, getRetailStoreDecorationSummaryScope())
			.field(RetailStore.OPENING_PROPERTY, getRetailStoreOpeningSummaryScope())
			.field(RetailStore.CLOSING_PROPERTY, getRetailStoreClosingSummaryScope())
			.field(RetailStore.FOUNDED_PROPERTY)
			.field(RetailStore.LATITUDE_PROPERTY)
			.field(RetailStore.LONGITUDE_PROPERTY)
			.field(RetailStore.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(RetailStore.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStore.VERSION_PROPERTY)
		;
	}

	/** RetailStoreCreation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreCreationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment';
		//	type='string';
		//	value='已经建好了';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreCreation.ID_PROPERTY)
			.field(RetailStoreCreation.COMMENT_PROPERTY).as("title")
			.field(RetailStoreCreation.VERSION_PROPERTY)
		;
	}

	/** RetailStoreInvestmentInvitation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreInvestmentInvitationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment';
		//	type='string';
		//	value='欢迎前来咨询';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreInvestmentInvitation.ID_PROPERTY)
			.field(RetailStoreInvestmentInvitation.COMMENT_PROPERTY).as("title")
			.field(RetailStoreInvestmentInvitation.VERSION_PROPERTY)
		;
	}

	/** RetailStoreFranchising的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreFranchisingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment';
		//	type='string';
		//	value='谢谢加盟';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreFranchising.ID_PROPERTY)
			.field(RetailStoreFranchising.COMMENT_PROPERTY).as("title")
			.field(RetailStoreFranchising.VERSION_PROPERTY)
		;
	}

	/** RetailStoreDecoration的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreDecorationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment';
		//	type='string';
		//	value='装修';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreDecoration.ID_PROPERTY)
			.field(RetailStoreDecoration.COMMENT_PROPERTY).as("title")
			.field(RetailStoreDecoration.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOpening的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOpeningListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment';
		//	type='string';
		//	value='装修';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOpening.ID_PROPERTY)
			.field(RetailStoreOpening.COMMENT_PROPERTY).as("title")
			.field(RetailStoreOpening.VERSION_PROPERTY)
		;
	}

	/** RetailStoreClosing的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreClosingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment';
		//	type='string';
		//	value='关闭';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreClosing.ID_PROPERTY)
			.field(RetailStoreClosing.COMMENT_PROPERTY).as("title")
			.field(RetailStoreClosing.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMember的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreMemberListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='李亚青';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='mobile_phone';
		//	type='string_china_mobile_phone';
		//	value='18099887766';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMember.ID_PROPERTY)
			.field(RetailStoreMember.NAME_PROPERTY).as("title")
			.field(RetailStoreMember.MOBILE_PHONE_PROPERTY).as("brief").with_prefix("移动电话: ")
			.field(RetailStoreMember.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(RetailStoreMember.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrder的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='消费订单';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrder.ID_PROPERTY)
			.field(ConsumerOrder.TITLE_PROPERTY).as("title")
			.field(ConsumerOrder.CONSUMER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(ConsumerOrder.CONFIRMATION_PROPERTY, getSupplyOrderConfirmationSummaryScope())
			.field(ConsumerOrder.APPROVAL_PROPERTY, getSupplyOrderApprovalSummaryScope())
			.field(ConsumerOrder.PROCESSING_PROPERTY, getSupplyOrderProcessingSummaryScope())
			.field(ConsumerOrder.SHIPMENT_PROPERTY, getSupplyOrderShipmentSummaryScope())
			.field(ConsumerOrder.DELIVERY_PROPERTY, getSupplyOrderDeliverySummaryScope())
			.field(ConsumerOrder.STORE_PROPERTY, getRetailStoreSummaryScope())
			.field(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(ConsumerOrder.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderConfirmation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderConfirmationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='确认者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='confirm_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderConfirmation.ID_PROPERTY)
			.field(ConsumerOrderConfirmation.WHO_PROPERTY).as("title")
			.field(ConsumerOrderConfirmation.CONFIRM_TIME_PROPERTY).as("brief").with_prefix("确认时间: ")
			.field(ConsumerOrderConfirmation.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderApproval的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderApprovalListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='批准者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='approve_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderApproval.ID_PROPERTY)
			.field(ConsumerOrderApproval.WHO_PROPERTY).as("title")
			.field(ConsumerOrderApproval.APPROVE_TIME_PROPERTY).as("brief").with_prefix("批准时间: ")
			.field(ConsumerOrderApproval.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderProcessing的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderProcessingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='处理者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='process_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderProcessing.ID_PROPERTY)
			.field(ConsumerOrderProcessing.WHO_PROPERTY).as("title")
			.field(ConsumerOrderProcessing.PROCESS_TIME_PROPERTY).as("brief").with_prefix("处理时间: ")
			.field(ConsumerOrderProcessing.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderShipment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderShipmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='运货者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='ship_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderShipment.ID_PROPERTY)
			.field(ConsumerOrderShipment.WHO_PROPERTY).as("title")
			.field(ConsumerOrderShipment.SHIP_TIME_PROPERTY).as("brief").with_prefix("船的时间: ")
			.field(ConsumerOrderShipment.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderDelivery的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderDeliveryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='送货者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='delivery_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderDelivery.ID_PROPERTY)
			.field(ConsumerOrderDelivery.WHO_PROPERTY).as("title")
			.field(ConsumerOrderDelivery.DELIVERY_TIME_PROPERTY).as("brief").with_prefix("交货时间: ")
			.field(ConsumerOrderDelivery.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderLineItem的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderLineItemListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='sku_name';
		//	type='string';
		//	value='大瓶矿泉水';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='sku_id';
		//	type='string';
		//	value='SKU';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderLineItem.ID_PROPERTY)
			.field(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
			.field(ConsumerOrderLineItem.SKU_ID_PROPERTY).as("brief").with_prefix("产品ID: ")
			.field(ConsumerOrderLineItem.SKU_NAME_PROPERTY).as("title")
			.field(ConsumerOrderLineItem.PRICE_PROPERTY)
			.field(ConsumerOrderLineItem.QUANTITY_PROPERTY)
			.field(ConsumerOrderLineItem.AMOUNT_PROPERTY)
			.field(ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY)
			.field(ConsumerOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderShippingGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderShippingGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='送货到刘强家';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='amount';
		//	type='money';
		//	value='$599.99';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderShippingGroup.ID_PROPERTY)
			.field(ConsumerOrderShippingGroup.NAME_PROPERTY).as("title")
			.field(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
			.field(ConsumerOrderShippingGroup.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(ConsumerOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderPaymentGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderPaymentGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='信用卡|支付宝|微信支付';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='card_number';
		//	type='string';
		//	value='4111 1111 1111 - ';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderPaymentGroup.ID_PROPERTY)
			.field(ConsumerOrderPaymentGroup.NAME_PROPERTY).as("title")
			.field(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
			.field(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY).as("brief").with_prefix("卡号码: ")
			.field(ConsumerOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderPriceAdjustment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderPriceAdjustmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='端午促销';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='amount';
		//	type='money';
		//	value='$599.99';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderPriceAdjustment.ID_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.NAME_PROPERTY).as("title")
			.field(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
			.field(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberCoupon的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreMemberCouponListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='优惠券';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='number';
		//	type='string';
		//	value='CP00001';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberCoupon.ID_PROPERTY)
			.field(RetailStoreMemberCoupon.NAME_PROPERTY).as("title")
			.field(RetailStoreMemberCoupon.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(RetailStoreMemberCoupon.NUMBER_PROPERTY).as("brief").with_prefix("数: ")
			.field(RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreMemberCoupon.VERSION_PROPERTY)
		;
	}

	/** MemberWishlist的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMemberWishlistListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='每周购买清单|每月购买清单';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(MemberWishlist.ID_PROPERTY)
			.field(MemberWishlist.NAME_PROPERTY).as("title")
			.field(MemberWishlist.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(MemberWishlist.VERSION_PROPERTY)
		;
	}

	/** MemberRewardPoint的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMemberRewardPointListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='购买积分|每月购买清单';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='point';
		//	type='int';
		//	value='20';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(MemberRewardPoint.ID_PROPERTY)
			.field(MemberRewardPoint.NAME_PROPERTY).as("title")
			.field(MemberRewardPoint.POINT_PROPERTY).as("brief").with_prefix("点: ")
			.field(MemberRewardPoint.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(MemberRewardPoint.VERSION_PROPERTY)
		;
	}

	/** MemberRewardPointRedemption的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMemberRewardPointRedemptionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='积分换锅|积分换刀';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='point';
		//	type='int';
		//	value='20';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(MemberRewardPointRedemption.ID_PROPERTY)
			.field(MemberRewardPointRedemption.NAME_PROPERTY).as("title")
			.field(MemberRewardPointRedemption.POINT_PROPERTY).as("brief").with_prefix("点: ")
			.field(MemberRewardPointRedemption.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(MemberRewardPointRedemption.VERSION_PROPERTY)
		;
	}

	/** MemberWishlistProduct的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMemberWishlistProductListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='农夫山泉|利箭口香糖';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(MemberWishlistProduct.ID_PROPERTY)
			.field(MemberWishlistProduct.NAME_PROPERTY).as("title")
			.field(MemberWishlistProduct.OWNER_PROPERTY, getMemberWishlistSummaryScope())
			.field(MemberWishlistProduct.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberAddress的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreMemberAddressListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='家里|办公室|出差临时地址';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='mobile_phone';
		//	type='string_china_mobile_phone';
		//	value='18099887766';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberAddress.ID_PROPERTY)
			.field(RetailStoreMemberAddress.NAME_PROPERTY).as("title")
			.field(RetailStoreMemberAddress.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY).as("brief").with_prefix("移动电话: ")
			.field(RetailStoreMemberAddress.ADDRESS_PROPERTY)
			.field(RetailStoreMemberAddress.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberGiftCard的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreMemberGiftCardListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='礼品卡';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='remain';
		//	type='money';
		//	value='$213.99';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberGiftCard.ID_PROPERTY)
			.field(RetailStoreMemberGiftCard.NAME_PROPERTY).as("title")
			.field(RetailStoreMemberGiftCard.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(RetailStoreMemberGiftCard.NUMBER_PROPERTY)
			.field(RetailStoreMemberGiftCard.REMAIN_PROPERTY).as("brief").with_prefix("保持: ")
			.field(RetailStoreMemberGiftCard.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberGiftCardConsumeRecord的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreMemberGiftCardConsumeRecordListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='number';
		//	type='string';
		//	value='GF00001';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='amount';
		//	type='money';
		//	value='$20.99';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, getRetailStoreMemberGiftCardSummaryScope())
			.field(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
			.field(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY).as("title")
			.field(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(RetailStoreMemberGiftCardConsumeRecord.VERSION_PROPERTY)
		;
	}

	/** GoodsSupplier的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsSupplierListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='宝洁|中粮|福临门';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='啤酒饮料矿泉水，香肠瓜子方便面都提供';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsSupplier.ID_PROPERTY)
			.field(GoodsSupplier.NAME_PROPERTY).as("title")
			.field(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY)
			.field(GoodsSupplier.BELONG_TO_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(GoodsSupplier.CONTACT_NUMBER_PROPERTY)
			.field(GoodsSupplier.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(GoodsSupplier.LAST_UPDATE_TIME_PROPERTY)
			.field(GoodsSupplier.VERSION_PROPERTY)
		;
	}

	/** SupplierProduct的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplierProductListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='product_name';
		//	type='string';
		//	value='怡宝矿泉水';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='product_description';
		//	type='string';
		//	value='最好的矿泉水，只卖3块喽';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplierProduct.ID_PROPERTY)
			.field(SupplierProduct.PRODUCT_NAME_PROPERTY).as("title")
			.field(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY).as("brief").with_prefix("产品描述: ")
			.field(SupplierProduct.PRODUCT_UNIT_PROPERTY)
			.field(SupplierProduct.SUPPLIER_PROPERTY, getGoodsSupplierSummaryScope())
			.field(SupplierProduct.VERSION_PROPERTY)
		;
	}

	/** ProductSupplyDuration的ListOf时需要序列化的属性列表 */
	protected SerializeScope getProductSupplyDurationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='duration';
		//	type='string';
		//	value='现货|两天|三天|一周';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='price';
		//	type='money';
		//	value='$9999.99';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ProductSupplyDuration.ID_PROPERTY)
			.field(ProductSupplyDuration.QUANTITY_PROPERTY)
			.field(ProductSupplyDuration.DURATION_PROPERTY).as("title")
			.field(ProductSupplyDuration.PRICE_PROPERTY).as("brief").with_prefix("价格: ")
			.field(ProductSupplyDuration.PRODUCT_PROPERTY, getSupplierProductSummaryScope())
			.field(ProductSupplyDuration.VERSION_PROPERTY)
		;
	}

	/** SupplyOrder的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='油奔奔给供货商下的订单';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='total_amount';
		//	type='money';
		//	value='$3000000000.88';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrder.ID_PROPERTY)
			.field(SupplyOrder.BUYER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(SupplyOrder.SELLER_PROPERTY, getGoodsSupplierSummaryScope())
			.field(SupplyOrder.TITLE_PROPERTY).as("title")
			.field(SupplyOrder.TOTAL_AMOUNT_PROPERTY).as("brief").with_prefix("总金额: ")
			.field(SupplyOrder.CONFIRMATION_PROPERTY, getSupplyOrderConfirmationSummaryScope())
			.field(SupplyOrder.APPROVAL_PROPERTY, getSupplyOrderApprovalSummaryScope())
			.field(SupplyOrder.PROCESSING_PROPERTY, getSupplyOrderProcessingSummaryScope())
			.field(SupplyOrder.PICKING_PROPERTY, getSupplyOrderPickingSummaryScope())
			.field(SupplyOrder.SHIPMENT_PROPERTY, getSupplyOrderShipmentSummaryScope())
			.field(SupplyOrder.DELIVERY_PROPERTY, getSupplyOrderDeliverySummaryScope())
			.field(SupplyOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(SupplyOrder.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderConfirmation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderConfirmationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='确认者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='confirm_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderConfirmation.ID_PROPERTY)
			.field(SupplyOrderConfirmation.WHO_PROPERTY).as("title")
			.field(SupplyOrderConfirmation.CONFIRM_TIME_PROPERTY).as("brief").with_prefix("确认时间: ")
			.field(SupplyOrderConfirmation.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderApproval的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderApprovalListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='批准者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='approve_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderApproval.ID_PROPERTY)
			.field(SupplyOrderApproval.WHO_PROPERTY).as("title")
			.field(SupplyOrderApproval.APPROVE_TIME_PROPERTY).as("brief").with_prefix("批准时间: ")
			.field(SupplyOrderApproval.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderProcessing的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderProcessingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='处理者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='process_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderProcessing.ID_PROPERTY)
			.field(SupplyOrderProcessing.WHO_PROPERTY).as("title")
			.field(SupplyOrderProcessing.PROCESS_TIME_PROPERTY).as("brief").with_prefix("处理时间: ")
			.field(SupplyOrderProcessing.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderPicking的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderPickingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='处理者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='process_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderPicking.ID_PROPERTY)
			.field(SupplyOrderPicking.WHO_PROPERTY).as("title")
			.field(SupplyOrderPicking.PROCESS_TIME_PROPERTY).as("brief").with_prefix("处理时间: ")
			.field(SupplyOrderPicking.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderShipment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderShipmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='运货者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='ship_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderShipment.ID_PROPERTY)
			.field(SupplyOrderShipment.WHO_PROPERTY).as("title")
			.field(SupplyOrderShipment.SHIP_TIME_PROPERTY).as("brief").with_prefix("船的时间: ")
			.field(SupplyOrderShipment.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderDelivery的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderDeliveryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='送货者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='delivery_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderDelivery.ID_PROPERTY)
			.field(SupplyOrderDelivery.WHO_PROPERTY).as("title")
			.field(SupplyOrderDelivery.DELIVERY_TIME_PROPERTY).as("brief").with_prefix("交货时间: ")
			.field(SupplyOrderDelivery.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderLineItem的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderLineItemListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='sku_name';
		//	type='string';
		//	value='大瓶矿泉水';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='amount';
		//	type='money';
		//	value='$5.97';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderLineItem.ID_PROPERTY)
			.field(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
			.field(SupplyOrderLineItem.SKU_ID_PROPERTY)
			.field(SupplyOrderLineItem.SKU_NAME_PROPERTY).as("title")
			.field(SupplyOrderLineItem.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(SupplyOrderLineItem.QUANTITY_PROPERTY)
			.field(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
			.field(SupplyOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderShippingGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderShippingGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='送货到油奔奔2号仓';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='amount';
		//	type='money';
		//	value='$5.99';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderShippingGroup.ID_PROPERTY)
			.field(SupplyOrderShippingGroup.NAME_PROPERTY).as("title")
			.field(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
			.field(SupplyOrderShippingGroup.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(SupplyOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderPaymentGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderPaymentGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='付款办法';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='card_number';
		//	type='string';
		//	value='4111 1111 1111 - ';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderPaymentGroup.ID_PROPERTY)
			.field(SupplyOrderPaymentGroup.NAME_PROPERTY).as("title")
			.field(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
			.field(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY).as("brief").with_prefix("卡号码: ")
			.field(SupplyOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrder的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='历下区区油奔奔给油奔奔长清区下的订单';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='total_amount';
		//	type='money';
		//	value='$3000000000.88';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrder.ID_PROPERTY)
			.field(RetailStoreOrder.BUYER_PROPERTY, getRetailStoreSummaryScope())
			.field(RetailStoreOrder.SELLER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(RetailStoreOrder.TITLE_PROPERTY).as("title")
			.field(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY).as("brief").with_prefix("总金额: ")
			.field(RetailStoreOrder.CONFIRMATION_PROPERTY, getRetailStoreOrderConfirmationSummaryScope())
			.field(RetailStoreOrder.APPROVAL_PROPERTY, getRetailStoreOrderApprovalSummaryScope())
			.field(RetailStoreOrder.PROCESSING_PROPERTY, getRetailStoreOrderProcessingSummaryScope())
			.field(RetailStoreOrder.PICKING_PROPERTY, getRetailStoreOrderPickingSummaryScope())
			.field(RetailStoreOrder.SHIPMENT_PROPERTY, getRetailStoreOrderShipmentSummaryScope())
			.field(RetailStoreOrder.DELIVERY_PROPERTY, getRetailStoreOrderDeliverySummaryScope())
			.field(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreOrder.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderConfirmation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderConfirmationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='确认者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='confirm_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderConfirmation.ID_PROPERTY)
			.field(RetailStoreOrderConfirmation.WHO_PROPERTY).as("title")
			.field(RetailStoreOrderConfirmation.CONFIRM_TIME_PROPERTY).as("brief").with_prefix("确认时间: ")
			.field(RetailStoreOrderConfirmation.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderApproval的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderApprovalListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='批准者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='approve_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderApproval.ID_PROPERTY)
			.field(RetailStoreOrderApproval.WHO_PROPERTY).as("title")
			.field(RetailStoreOrderApproval.APPROVE_TIME_PROPERTY).as("brief").with_prefix("批准时间: ")
			.field(RetailStoreOrderApproval.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderProcessing的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderProcessingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='处理者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='process_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderProcessing.ID_PROPERTY)
			.field(RetailStoreOrderProcessing.WHO_PROPERTY).as("title")
			.field(RetailStoreOrderProcessing.PROCESS_TIME_PROPERTY).as("brief").with_prefix("处理时间: ")
			.field(RetailStoreOrderProcessing.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderPicking的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderPickingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='处理者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='process_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderPicking.ID_PROPERTY)
			.field(RetailStoreOrderPicking.WHO_PROPERTY).as("title")
			.field(RetailStoreOrderPicking.PROCESS_TIME_PROPERTY).as("brief").with_prefix("处理时间: ")
			.field(RetailStoreOrderPicking.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderShipment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderShipmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='运货者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='ship_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderShipment.ID_PROPERTY)
			.field(RetailStoreOrderShipment.WHO_PROPERTY).as("title")
			.field(RetailStoreOrderShipment.SHIP_TIME_PROPERTY).as("brief").with_prefix("船的时间: ")
			.field(RetailStoreOrderShipment.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderDelivery的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderDeliveryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='送货者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='delivery_time';
		//	type='date';
		//	value='2018-07-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderDelivery.ID_PROPERTY)
			.field(RetailStoreOrderDelivery.WHO_PROPERTY).as("title")
			.field(RetailStoreOrderDelivery.DELIVERY_TIME_PROPERTY).as("brief").with_prefix("交货时间: ")
			.field(RetailStoreOrderDelivery.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderLineItem的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderLineItemListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='sku_name';
		//	type='string';
		//	value='大瓶矿泉水';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='amount';
		//	type='money';
		//	value='$3.97';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderLineItem.ID_PROPERTY)
			.field(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
			.field(RetailStoreOrderLineItem.SKU_ID_PROPERTY)
			.field(RetailStoreOrderLineItem.SKU_NAME_PROPERTY).as("title")
			.field(RetailStoreOrderLineItem.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(RetailStoreOrderLineItem.QUANTITY_PROPERTY)
			.field(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
			.field(RetailStoreOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderShippingGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderShippingGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='送货到油奔奔历下区';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='amount';
		//	type='money';
		//	value='$5.99';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderShippingGroup.ID_PROPERTY)
			.field(RetailStoreOrderShippingGroup.NAME_PROPERTY).as("title")
			.field(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
			.field(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(RetailStoreOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderPaymentGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderPaymentGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='付款办法';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='card_number';
		//	type='string';
		//	value='4111 1111 1111 - ';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderPaymentGroup.ID_PROPERTY)
			.field(RetailStoreOrderPaymentGroup.NAME_PROPERTY).as("title")
			.field(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
			.field(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY).as("brief").with_prefix("卡号码: ")
			.field(RetailStoreOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** Warehouse的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWarehouseListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location';
		//	type='string';
		//	value='油奔奔20号';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='contact_number';
		//	type='string';
		//	value='02887654321';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Warehouse.ID_PROPERTY)
			.field(Warehouse.LOCATION_PROPERTY).as("title")
			.field(Warehouse.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(Warehouse.TOTAL_AREA_PROPERTY)
			.field(Warehouse.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(Warehouse.LATITUDE_PROPERTY)
			.field(Warehouse.LONGITUDE_PROPERTY)
			.field(Warehouse.LAST_UPDATE_TIME_PROPERTY)
			.field(Warehouse.VERSION_PROPERTY)
		;
	}

	/** StorageSpace的ListOf时需要序列化的属性列表 */
	protected SerializeScope getStorageSpaceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location';
		//	type='string';
		//	value='油奔奔20号存油区';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='contact_number';
		//	type='string';
		//	value='02887654321';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(StorageSpace.ID_PROPERTY)
			.field(StorageSpace.LOCATION_PROPERTY).as("title")
			.field(StorageSpace.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(StorageSpace.TOTAL_AREA_PROPERTY)
			.field(StorageSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(StorageSpace.LATITUDE_PROPERTY)
			.field(StorageSpace.LONGITUDE_PROPERTY)
			.field(StorageSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(StorageSpace.VERSION_PROPERTY)
		;
	}

	/** SmartPallet的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSmartPalletListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location';
		//	type='string';
		//	value='成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='contact_number';
		//	type='string';
		//	value='02887654321';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SmartPallet.ID_PROPERTY)
			.field(SmartPallet.LOCATION_PROPERTY).as("title")
			.field(SmartPallet.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(SmartPallet.TOTAL_AREA_PROPERTY)
			.field(SmartPallet.LATITUDE_PROPERTY)
			.field(SmartPallet.LONGITUDE_PROPERTY)
			.field(SmartPallet.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(SmartPallet.LAST_UPDATE_TIME_PROPERTY)
			.field(SmartPallet.VERSION_PROPERTY)
		;
	}

	/** GoodsShelf的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsShelfListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location';
		//	type='string';
		//	value='油奔奔油库';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsShelf.ID_PROPERTY)
			.field(GoodsShelf.LOCATION_PROPERTY).as("title")
			.field(GoodsShelf.STORAGE_SPACE_PROPERTY, getStorageSpaceSummaryScope())
			.field(GoodsShelf.SUPPLIER_SPACE_PROPERTY, getSupplierSpaceSummaryScope())
			.field(GoodsShelf.DAMAGE_SPACE_PROPERTY, getDamageSpaceSummaryScope())
			.field(GoodsShelf.LAST_UPDATE_TIME_PROPERTY)
			.field(GoodsShelf.VERSION_PROPERTY)
		;
	}

	/** GoodsShelfStockCount的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsShelfStockCountListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='每日盘点|每周盘点|每月盘点|年终盘点';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='summary';
		//	type='string';
		//	value='使用先进的rfid技术，没有任何错误';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsShelfStockCount.ID_PROPERTY)
			.field(GoodsShelfStockCount.TITLE_PROPERTY).as("title")
			.field(GoodsShelfStockCount.COUNT_TIME_PROPERTY)
			.field(GoodsShelfStockCount.SUMMARY_PROPERTY).as("brief").with_prefix("总结: ")
			.field(GoodsShelfStockCount.SHELF_PROPERTY, getGoodsShelfSummaryScope())
			.field(GoodsShelfStockCount.VERSION_PROPERTY)
		;
	}

	/** StockCountIssueTrack的ListOf时需要序列化的属性列表 */
	protected SerializeScope getStockCountIssueTrackListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='盘点差错';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='summary';
		//	type='string';
		//	value='发现错误已经修正完成';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(StockCountIssueTrack.ID_PROPERTY)
			.field(StockCountIssueTrack.TITLE_PROPERTY).as("title")
			.field(StockCountIssueTrack.COUNT_TIME_PROPERTY)
			.field(StockCountIssueTrack.SUMMARY_PROPERTY).as("brief").with_prefix("总结: ")
			.field(StockCountIssueTrack.STOCK_COUNT_PROPERTY, getGoodsShelfStockCountSummaryScope())
			.field(StockCountIssueTrack.VERSION_PROPERTY)
		;
	}

	/** GoodsAllocation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsAllocationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location';
		//	type='string';
		//	value='油奔奔油库';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='latitude';
		//	type='double';
		//	value='40.776877';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsAllocation.ID_PROPERTY)
			.field(GoodsAllocation.LOCATION_PROPERTY).as("title")
			.field(GoodsAllocation.LATITUDE_PROPERTY).as("brief").with_prefix("纬度: ")
			.field(GoodsAllocation.LONGITUDE_PROPERTY)
			.field(GoodsAllocation.GOODS_SHELF_PROPERTY, getGoodsShelfSummaryScope())
			.field(GoodsAllocation.VERSION_PROPERTY)
		;
	}

	/** Goods的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='可口可乐';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='max_package';
		//	type='int';
		//	value='10';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Goods.ID_PROPERTY)
			.field(Goods.NAME_PROPERTY).as("title")
			.field(Goods.RFID_PROPERTY)
			.field(Goods.UOM_PROPERTY)
			.field(Goods.MAX_PACKAGE_PROPERTY).as("brief").with_prefix("最大包装: ")
			.field(Goods.EXPIRE_TIME_PROPERTY)
			.field(Goods.SKU_PROPERTY, getSkuSummaryScope())
			.field(Goods.RECEIVING_SPACE_PROPERTY, getReceivingSpaceSummaryScope())
			.field(Goods.GOODS_ALLOCATION_PROPERTY, getGoodsAllocationSummaryScope())
			.field(Goods.SMART_PALLET_PROPERTY, getSmartPalletSummaryScope())
			.field(Goods.SHIPPING_SPACE_PROPERTY, getShippingSpaceSummaryScope())
			.field(Goods.TRANSPORT_TASK_PROPERTY, getTransportTaskSummaryScope())
			.field(Goods.RETAIL_STORE_PROPERTY, getRetailStoreSummaryScope())
			.field(Goods.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
			.field(Goods.RETAIL_STORE_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
			.field(Goods.PACKAGING_PROPERTY, getGoodsPackagingSummaryScope())
			.field(Goods.VERSION_PROPERTY)
		;
	}

	/** GoodsPackaging的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsPackagingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='package_name';
		//	type='string';
		//	value='王朔';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='打包完成，准备起运';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsPackaging.ID_PROPERTY)
			.field(GoodsPackaging.PACKAGE_NAME_PROPERTY).as("title")
			.field(GoodsPackaging.RFID_PROPERTY)
			.field(GoodsPackaging.PACKAGE_TIME_PROPERTY)
			.field(GoodsPackaging.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(GoodsPackaging.VERSION_PROPERTY)
		;
	}

	/** GoodsMovement的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsMovementListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='facility';
		//	type='string';
		//	value='油库|卡车|油奔奔';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='user_agent';
		//	type='string';
		//	value='Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B405';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(GoodsMovement.ID_PROPERTY)
			.field(GoodsMovement.MOVE_TIME_PROPERTY)
			.field(GoodsMovement.FACILITY_PROPERTY).as("title")
			.field(GoodsMovement.FACILITY_ID_PROPERTY)
			.field(GoodsMovement.FROM_IP_PROPERTY)
			.field(GoodsMovement.USER_AGENT_PROPERTY).as("brief").with_prefix("用户代理: ")
			.field(GoodsMovement.SESSION_ID_PROPERTY)
			.field(GoodsMovement.LATITUDE_PROPERTY)
			.field(GoodsMovement.LONGITUDE_PROPERTY)
			.field(GoodsMovement.GOODS_PROPERTY, getGoodsSummaryScope())
			.field(GoodsMovement.VERSION_PROPERTY)
		;
	}

	/** SupplierSpace的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplierSpaceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location';
		//	type='string';
		//	value='油奔奔油库';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='contact_number';
		//	type='string';
		//	value='02887654321';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SupplierSpace.ID_PROPERTY)
			.field(SupplierSpace.LOCATION_PROPERTY).as("title")
			.field(SupplierSpace.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(SupplierSpace.TOTAL_AREA_PROPERTY)
			.field(SupplierSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(SupplierSpace.LATITUDE_PROPERTY)
			.field(SupplierSpace.LONGITUDE_PROPERTY)
			.field(SupplierSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(SupplierSpace.VERSION_PROPERTY)
		;
	}

	/** ReceivingSpace的ListOf时需要序列化的属性列表 */
	protected SerializeScope getReceivingSpaceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location';
		//	type='string';
		//	value='油奔奔油库';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='每个收货区可以供一辆车卸油';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ReceivingSpace.ID_PROPERTY)
			.field(ReceivingSpace.LOCATION_PROPERTY).as("title")
			.field(ReceivingSpace.CONTACT_NUMBER_PROPERTY)
			.field(ReceivingSpace.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(ReceivingSpace.TOTAL_AREA_PROPERTY)
			.field(ReceivingSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(ReceivingSpace.LATITUDE_PROPERTY)
			.field(ReceivingSpace.LONGITUDE_PROPERTY)
			.field(ReceivingSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(ReceivingSpace.VERSION_PROPERTY)
		;
	}

	/** ShippingSpace的ListOf时需要序列化的属性列表 */
	protected SerializeScope getShippingSpaceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location';
		//	type='string';
		//	value='油奔奔油库';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='每个收货区可以供一辆车装油';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ShippingSpace.ID_PROPERTY)
			.field(ShippingSpace.LOCATION_PROPERTY).as("title")
			.field(ShippingSpace.CONTACT_NUMBER_PROPERTY)
			.field(ShippingSpace.TOTAL_AREA_PROPERTY)
			.field(ShippingSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(ShippingSpace.LATITUDE_PROPERTY)
			.field(ShippingSpace.LONGITUDE_PROPERTY)
			.field(ShippingSpace.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(ShippingSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(ShippingSpace.VERSION_PROPERTY)
		;
	}

	/** DamageSpace的ListOf时需要序列化的属性列表 */
	protected SerializeScope getDamageSpaceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location';
		//	type='string';
		//	value='油奔奔油库';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='contact_number';
		//	type='string';
		//	value='02887654321';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(DamageSpace.ID_PROPERTY)
			.field(DamageSpace.LOCATION_PROPERTY).as("title")
			.field(DamageSpace.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(DamageSpace.TOTAL_AREA_PROPERTY)
			.field(DamageSpace.LATITUDE_PROPERTY)
			.field(DamageSpace.LONGITUDE_PROPERTY)
			.field(DamageSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(DamageSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(DamageSpace.VERSION_PROPERTY)
		;
	}

	/** WarehouseAsset的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWarehouseAssetListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='叉车|托盘|传送带备件';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='position';
		//	type='string';
		//	value='备用件存放区设备库房';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(WarehouseAsset.ID_PROPERTY)
			.field(WarehouseAsset.NAME_PROPERTY).as("title")
			.field(WarehouseAsset.POSITION_PROPERTY).as("brief").with_prefix("位置: ")
			.field(WarehouseAsset.OWNER_PROPERTY, getWarehouseSummaryScope())
			.field(WarehouseAsset.LAST_UPDATE_TIME_PROPERTY)
			.field(WarehouseAsset.VERSION_PROPERTY)
		;
	}

	/** TransportFleet的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTransportFleetListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='油奔奔车队';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='contact_number';
		//	type='string';
		//	value='02887654321';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TransportFleet.ID_PROPERTY)
			.field(TransportFleet.NAME_PROPERTY).as("title")
			.field(TransportFleet.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(TransportFleet.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(TransportFleet.LAST_UPDATE_TIME_PROPERTY)
			.field(TransportFleet.VERSION_PROPERTY)
		;
	}

	/** TransportTruck的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTransportTruckListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='运油卡车';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='plate_number';
		//	type='string';
		//	value='鲁AK5';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TransportTruck.ID_PROPERTY)
			.field(TransportTruck.NAME_PROPERTY).as("title")
			.field(TransportTruck.PLATE_NUMBER_PROPERTY).as("brief").with_prefix("车辆信息: ")
			.field(TransportTruck.CONTACT_NUMBER_PROPERTY)
			.field(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY)
			.field(TransportTruck.ENGINE_NUMBER_PROPERTY)
			.field(TransportTruck.MAKE_DATE_PROPERTY)
			.field(TransportTruck.MILEAGE_PROPERTY)
			.field(TransportTruck.BODY_COLOR_PROPERTY)
			.field(TransportTruck.OWNER_PROPERTY, getTransportFleetSummaryScope())
			.field(TransportTruck.VERSION_PROPERTY)
		;
	}

	/** TruckDriver的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTruckDriverListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='运货卡车司机';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='driver_license_number';
		//	type='string';
		//	value='51099887733';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TruckDriver.ID_PROPERTY)
			.field(TruckDriver.NAME_PROPERTY).as("title")
			.field(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY).as("brief").with_prefix("驾驶执照号码: ")
			.field(TruckDriver.CONTACT_NUMBER_PROPERTY)
			.field(TruckDriver.BELONGS_TO_PROPERTY, getTransportFleetSummaryScope())
			.field(TruckDriver.VERSION_PROPERTY)
		;
	}

	/** TransportTask的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTransportTaskListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='货运记录';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='start';
		//	type='string';
		//	value='油奔奔油库';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TransportTask.ID_PROPERTY)
			.field(TransportTask.NAME_PROPERTY).as("title")
			.field(TransportTask.START_PROPERTY).as("brief").with_prefix("开始: ")
			.field(TransportTask.BEGIN_TIME_PROPERTY)
			.field(TransportTask.END_PROPERTY, getRetailStoreSummaryScope())
			.field(TransportTask.DRIVER_PROPERTY, getTruckDriverSummaryScope())
			.field(TransportTask.TRUCK_PROPERTY, getTransportTruckSummaryScope())
			.field(TransportTask.BELONGS_TO_PROPERTY, getTransportFleetSummaryScope())
			.field(TransportTask.LATITUDE_PROPERTY)
			.field(TransportTask.LONGITUDE_PROPERTY)
			.field(TransportTask.VERSION_PROPERTY)
		;
	}

	/** TransportTaskTrack的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTransportTaskTrackListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='track_time';
		//	type='date_past';
		//	value='past()';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='latitude';
		//	type='double';
		//	value='30.912929';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TransportTaskTrack.ID_PROPERTY)
			.field(TransportTaskTrack.TRACK_TIME_PROPERTY).as("title")
			.field(TransportTaskTrack.LATITUDE_PROPERTY).as("brief").with_prefix("纬度: ")
			.field(TransportTaskTrack.LONGITUDE_PROPERTY)
			.field(TransportTaskTrack.MOVEMENT_PROPERTY, getTransportTaskSummaryScope())
			.field(TransportTaskTrack.VERSION_PROPERTY)
		;
	}

	/** AccountSet的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountSetListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='账套2017|账套2018|账套2019';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='year_set';
		//	type='string';
		//	value='2017年|2018年|2019年';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountSet.ID_PROPERTY)
			.field(AccountSet.NAME_PROPERTY).as("title")
			.field(AccountSet.YEAR_SET_PROPERTY).as("brief").with_prefix("年组: ")
			.field(AccountSet.EFFECTIVE_DATE_PROPERTY)
			.field(AccountSet.ACCOUNTING_SYSTEM_PROPERTY)
			.field(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY)
			.field(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY)
			.field(AccountSet.OPENING_BANK_PROPERTY)
			.field(AccountSet.ACCOUNT_NUMBER_PROPERTY)
			.field(AccountSet.COUNTRY_CENTER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(AccountSet.RETAIL_STORE_PROPERTY, getRetailStoreSummaryScope())
			.field(AccountSet.GOODS_SUPPLIER_PROPERTY, getGoodsSupplierSummaryScope())
			.field(AccountSet.LAST_UPDATE_TIME_PROPERTY)
			.field(AccountSet.VERSION_PROPERTY)
		;
	}

	/** AccountingSubject的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingSubjectListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='accounting_subject_name';
		//	type='string';
		//	value='银行存款';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='accounting_subject_class_code';
		//	type='int';
		//	value='1|2|3|4|5|6';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingSubject.ID_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY).as("title")
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY).as("brief").with_prefix("会计科目类别代码: ")
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY)
			.field(AccountingSubject.ACCOUNT_SET_PROPERTY, getAccountSetSummaryScope())
			.field(AccountingSubject.VERSION_PROPERTY)
		;
	}

	/** AccountingPeriod的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingPeriodListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='2017年1月|2017年2月|2017年3月|2017年4月|2017年5月|2017年6月|2017年7月|2017年8月|2017年9月|2017年10月|2017年11月|2017年12月';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='start_date';
		//	type='date';
		//	value='2017-01-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingPeriod.ID_PROPERTY)
			.field(AccountingPeriod.NAME_PROPERTY).as("title")
			.field(AccountingPeriod.START_DATE_PROPERTY).as("brief").with_prefix("开始日期: ")
			.field(AccountingPeriod.END_DATE_PROPERTY)
			.field(AccountingPeriod.ACCOUNT_SET_PROPERTY, getAccountSetSummaryScope())
			.field(AccountingPeriod.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingDocumentTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='记账凭证|收款凭证|付款凭证';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentType.ID_PROPERTY)
			.field(AccountingDocumentType.NAME_PROPERTY).as("title")
			.field(AccountingDocumentType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY, getAccountSetSummaryScope())
			.field(AccountingDocumentType.VERSION_PROPERTY)
		;
	}

	/** AccountingDocument的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingDocumentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='记账凭证';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='accounting_document_date';
		//	type='date';
		//	value='2018-09-09';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocument.ID_PROPERTY)
			.field(AccountingDocument.NAME_PROPERTY).as("title")
			.field(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY).as("brief").with_prefix("会计凭证日期: ")
			.field(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, getAccountingPeriodSummaryScope())
			.field(AccountingDocument.DOCUMENT_TYPE_PROPERTY, getAccountingDocumentTypeSummaryScope())
			.field(AccountingDocument.CREATION_PROPERTY, getAccountingDocumentCreationSummaryScope())
			.field(AccountingDocument.CONFIRMATION_PROPERTY, getAccountingDocumentConfirmationSummaryScope())
			.field(AccountingDocument.AUDITING_PROPERTY, getAccountingDocumentAuditingSummaryScope())
			.field(AccountingDocument.POSTING_PROPERTY, getAccountingDocumentPostingSummaryScope())
			.field(AccountingDocument.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentCreation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingDocumentCreationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='财务会计';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='确认提交';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentCreation.ID_PROPERTY)
			.field(AccountingDocumentCreation.WHO_PROPERTY).as("title")
			.field(AccountingDocumentCreation.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(AccountingDocumentCreation.MAKE_DATE_PROPERTY)
			.field(AccountingDocumentCreation.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentConfirmation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingDocumentConfirmationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='财务会计';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='确认通过';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentConfirmation.ID_PROPERTY)
			.field(AccountingDocumentConfirmation.WHO_PROPERTY).as("title")
			.field(AccountingDocumentConfirmation.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(AccountingDocumentConfirmation.MAKE_DATE_PROPERTY)
			.field(AccountingDocumentConfirmation.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentAuditing的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingDocumentAuditingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='财务会计';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='审核通过，要都审核过了才通过哦';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentAuditing.ID_PROPERTY)
			.field(AccountingDocumentAuditing.WHO_PROPERTY).as("title")
			.field(AccountingDocumentAuditing.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(AccountingDocumentAuditing.MAKE_DATE_PROPERTY)
			.field(AccountingDocumentAuditing.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentPosting的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingDocumentPostingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='财务会计';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='审核通过，要都审核过了才通过哦';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentPosting.ID_PROPERTY)
			.field(AccountingDocumentPosting.WHO_PROPERTY).as("title")
			.field(AccountingDocumentPosting.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(AccountingDocumentPosting.MAKE_DATE_PROPERTY)
			.field(AccountingDocumentPosting.VERSION_PROPERTY)
		;
	}

	/** OriginalVoucher的ListOf时需要序列化的属性列表 */
	protected SerializeScope getOriginalVoucherListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='这是手写的发票';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='made_by';
		//	type='string';
		//	value='李亚青';
		//	required='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='voucher_image';
		//	type='string_image';
		//	value='goodthing.jpg';
		//	required='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OriginalVoucher.ID_PROPERTY)
			.field(OriginalVoucher.TITLE_PROPERTY).as("title")
			.field(OriginalVoucher.MADE_BY_PROPERTY).as("brief").with_prefix("由: ")
			.field(OriginalVoucher.RECEIVED_BY_PROPERTY)
			.field(OriginalVoucher.VOUCHER_TYPE_PROPERTY)
			.field(OriginalVoucher.VOUCHER_IMAGE_PROPERTY).as("imageUrl")
			.field(OriginalVoucher.BELONGS_TO_PROPERTY, getAccountingDocumentSummaryScope())
			.field(OriginalVoucher.CREATION_PROPERTY, getOriginalVoucherCreationSummaryScope())
			.field(OriginalVoucher.CONFIRMATION_PROPERTY, getOriginalVoucherConfirmationSummaryScope())
			.field(OriginalVoucher.AUDITING_PROPERTY, getOriginalVoucherAuditingSummaryScope())
			.field(OriginalVoucher.VERSION_PROPERTY)
		;
	}

	/** OriginalVoucherCreation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getOriginalVoucherCreationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='财务会计';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='确认提交';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OriginalVoucherCreation.ID_PROPERTY)
			.field(OriginalVoucherCreation.WHO_PROPERTY).as("title")
			.field(OriginalVoucherCreation.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(OriginalVoucherCreation.MAKE_DATE_PROPERTY)
			.field(OriginalVoucherCreation.VERSION_PROPERTY)
		;
	}

	/** OriginalVoucherConfirmation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getOriginalVoucherConfirmationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='财务会计';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='确认通过';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OriginalVoucherConfirmation.ID_PROPERTY)
			.field(OriginalVoucherConfirmation.WHO_PROPERTY).as("title")
			.field(OriginalVoucherConfirmation.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(OriginalVoucherConfirmation.MAKE_DATE_PROPERTY)
			.field(OriginalVoucherConfirmation.VERSION_PROPERTY)
		;
	}

	/** OriginalVoucherAuditing的ListOf时需要序列化的属性列表 */
	protected SerializeScope getOriginalVoucherAuditingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='财务会计';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='审核通过，要都审核过了才通过哦';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OriginalVoucherAuditing.ID_PROPERTY)
			.field(OriginalVoucherAuditing.WHO_PROPERTY).as("title")
			.field(OriginalVoucherAuditing.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(OriginalVoucherAuditing.MAKE_DATE_PROPERTY)
			.field(OriginalVoucherAuditing.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentLine的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingDocumentLineListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='收到存款';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='amount';
		//	type='money';
		//	value='$989127.99';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentLine.ID_PROPERTY)
			.field(AccountingDocumentLine.NAME_PROPERTY).as("title")
			.field(AccountingDocumentLine.CODE_PROPERTY)
			.field(AccountingDocumentLine.DIRECT_PROPERTY)
			.field(AccountingDocumentLine.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(AccountingDocumentLine.BELONGS_TO_PROPERTY, getAccountingDocumentSummaryScope())
			.field(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, getAccountingSubjectSummaryScope())
			.field(AccountingDocumentLine.VERSION_PROPERTY)
		;
	}

	/** LevelOneDepartment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelOneDepartmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='供应链部|采购部|管理部|财务部|信息技术部|法务部|市场部|人力资源部';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='主要执行集团信息系统建设，维护，规划';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelOneDepartment.ID_PROPERTY)
			.field(LevelOneDepartment.BELONGS_TO_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(LevelOneDepartment.NAME_PROPERTY).as("title")
			.field(LevelOneDepartment.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LevelOneDepartment.MANAGER_PROPERTY)
			.field(LevelOneDepartment.FOUNDED_PROPERTY)
			.field(LevelOneDepartment.VERSION_PROPERTY)
		;
	}

	/** LevelTwoDepartment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelTwoDepartmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='信息系统部大数据部门';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='主要执行集团信息系统建设，维护，规划';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelTwoDepartment.ID_PROPERTY)
			.field(LevelTwoDepartment.BELONGS_TO_PROPERTY, getLevelOneDepartmentSummaryScope())
			.field(LevelTwoDepartment.NAME_PROPERTY).as("title")
			.field(LevelTwoDepartment.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LevelTwoDepartment.FOUNDED_PROPERTY)
			.field(LevelTwoDepartment.VERSION_PROPERTY)
		;
	}

	/** LevelThreeDepartment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelThreeDepartmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='信息系统部大数据清洗组|信息系统部大数据运算组|信息系统部大数据解决方案组';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='主要执行集团信息系统建设，维护，规划';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LevelThreeDepartment.ID_PROPERTY)
			.field(LevelThreeDepartment.BELONGS_TO_PROPERTY, getLevelTwoDepartmentSummaryScope())
			.field(LevelThreeDepartment.NAME_PROPERTY).as("title")
			.field(LevelThreeDepartment.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LevelThreeDepartment.FOUNDED_PROPERTY)
			.field(LevelThreeDepartment.VERSION_PROPERTY)
		;
	}

	/** SkillType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSkillTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='S0000';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='JAVA编程|大数据|并行计算|操作系统|数据库';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SkillType.ID_PROPERTY)
			.field(SkillType.CODE_PROPERTY).as("title")
			.field(SkillType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(SkillType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(SkillType.VERSION_PROPERTY)
		;
	}

	/** ResponsibilityType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getResponsibilityTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='S0000';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='base_description';
		//	type='string';
		//	value='合规管理|财务管理|总务管理|信息管理|库存管理|市场管理|产品管理|采购管理|资产管理|销售管理|安全管理';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ResponsibilityType.ID_PROPERTY)
			.field(ResponsibilityType.CODE_PROPERTY).as("title")
			.field(ResponsibilityType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(ResponsibilityType.BASE_DESCRIPTION_PROPERTY).as("brief").with_prefix("基本描述: ")
			.field(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY)
			.field(ResponsibilityType.VERSION_PROPERTY)
		;
	}

	/** TerminationReason的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTerminationReasonListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='ETR0000';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='业务发展，公司转型|战略调整|业务优化';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TerminationReason.ID_PROPERTY)
			.field(TerminationReason.CODE_PROPERTY).as("title")
			.field(TerminationReason.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(TerminationReason.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(TerminationReason.VERSION_PROPERTY)
		;
	}

	/** TerminationType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTerminationTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='ETT0000';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='base_description';
		//	type='string';
		//	value='合同解除|辞职|退休';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TerminationType.ID_PROPERTY)
			.field(TerminationType.CODE_PROPERTY).as("title")
			.field(TerminationType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(TerminationType.BASE_DESCRIPTION_PROPERTY).as("brief").with_prefix("基本描述: ")
			.field(TerminationType.DETAIL_DESCRIPTION_PROPERTY)
			.field(TerminationType.VERSION_PROPERTY)
		;
	}

	/** OccupationType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getOccupationTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='OT0000';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='需求分析员|软件工程师|高级软件工程师|财务分析师|财务主管|出纳|总经理|副总经历|大数据架构师|销售经理|销售总监|技术总监|区域销售经理';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OccupationType.ID_PROPERTY)
			.field(OccupationType.CODE_PROPERTY).as("title")
			.field(OccupationType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(OccupationType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(OccupationType.DETAIL_DESCRIPTION_PROPERTY)
			.field(OccupationType.VERSION_PROPERTY)
		;
	}

	/** LeaveType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLeaveTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='LT0000';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='带薪年假|病假|事假|婚假|产假|陪产假|丧假|探亲假|哺乳假|待产假|陪待产假';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(LeaveType.ID_PROPERTY)
			.field(LeaveType.CODE_PROPERTY).as("title")
			.field(LeaveType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(LeaveType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LeaveType.DETAIL_DESCRIPTION_PROPERTY)
			.field(LeaveType.VERSION_PROPERTY)
		;
	}

	/** SalaryGrade的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSalaryGradeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='一级薪资|二级薪资|三级薪资|四级薪资|五级薪资|六级薪资|七级薪资';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='detail_description';
		//	type='string';
		//	value='故事还得从遥远的古代开始.................................................';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(SalaryGrade.ID_PROPERTY)
			.field(SalaryGrade.CODE_PROPERTY)
			.field(SalaryGrade.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(SalaryGrade.NAME_PROPERTY).as("title")
			.field(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY).as("brief").with_prefix("详细描述: ")
			.field(SalaryGrade.VERSION_PROPERTY)
		;
	}

	/** InterviewType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getInterviewTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='INTRVW00';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='特别情况面试|离职面试|信息面试|入职面试';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(InterviewType.ID_PROPERTY)
			.field(InterviewType.CODE_PROPERTY).as("title")
			.field(InterviewType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(InterviewType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(InterviewType.DETAIL_DESCRIPTION_PROPERTY)
			.field(InterviewType.VERSION_PROPERTY)
		;
	}

	/** TrainingCourseType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTrainingCourseTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='入职培训|售前培训|技术培训|管理培训|外训';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='培训是提升个人和企业竞争力的法宝';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(TrainingCourseType.ID_PROPERTY)
			.field(TrainingCourseType.CODE_PROPERTY)
			.field(TrainingCourseType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(TrainingCourseType.NAME_PROPERTY).as("title")
			.field(TrainingCourseType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(TrainingCourseType.VERSION_PROPERTY)
		;
	}

	/** PublicHoliday的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPublicHolidayListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='元旦节|春节|妇女节|清明节|端午节|暑假|国庆节|中秋节';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='节日快乐，万事如意！';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PublicHoliday.ID_PROPERTY)
			.field(PublicHoliday.CODE_PROPERTY)
			.field(PublicHoliday.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(PublicHoliday.NAME_PROPERTY).as("title")
			.field(PublicHoliday.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(PublicHoliday.VERSION_PROPERTY)
		;
	}

	/** Termination的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTerminationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment';
		//	type='string';
		//	value='员工离职';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Termination.ID_PROPERTY)
			.field(Termination.REASON_PROPERTY, getTerminationReasonSummaryScope())
			.field(Termination.TYPE_PROPERTY, getTerminationTypeSummaryScope())
			.field(Termination.COMMENT_PROPERTY).as("title")
			.field(Termination.VERSION_PROPERTY)
		;
	}

	/** View的ListOf时需要序列化的属性列表 */
	protected SerializeScope getViewListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='面试官';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='assessment';
		//	type='string';
		//	value='小伙子不错，值得培养';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(View.ID_PROPERTY)
			.field(View.WHO_PROPERTY).as("title")
			.field(View.ASSESSMENT_PROPERTY).as("brief").with_prefix("评估: ")
			.field(View.INTERVIEW_TIME_PROPERTY)
			.field(View.VERSION_PROPERTY)
		;
	}

	/** Employee的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='程序员';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='family_name';
		//	type='string';
		//	value='张|王|李|贺';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Employee.ID_PROPERTY)
			.field(Employee.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(Employee.TITLE_PROPERTY).as("title")
			.field(Employee.DEPARTMENT_PROPERTY, getLevelThreeDepartmentSummaryScope())
			.field(Employee.FAMILY_NAME_PROPERTY).as("brief").with_prefix("姓: ")
			.field(Employee.GIVEN_NAME_PROPERTY)
			.field(Employee.EMAIL_PROPERTY)
			.field(Employee.CITY_PROPERTY)
			.field(Employee.ADDRESS_PROPERTY)
			.field(Employee.CELL_PHONE_PROPERTY)
			.field(Employee.OCCUPATION_PROPERTY, getOccupationTypeSummaryScope())
			.field(Employee.RESPONSIBLE_FOR_PROPERTY, getResponsibilityTypeSummaryScope())
			.field(Employee.CURRENT_SALARY_GRADE_PROPERTY, getSalaryGradeSummaryScope())
			.field(Employee.SALARY_ACCOUNT_PROPERTY)
			.field(Employee.JOB_APPLICATION_PROPERTY, getJobApplicationSummaryScope())
			.field(Employee.PROFESSION_INTERVIEW_PROPERTY, getProfessionInterviewSummaryScope())
			.field(Employee.HR_INTERVIEW_PROPERTY, getHrInterviewSummaryScope())
			.field(Employee.OFFER_APPROVAL_PROPERTY, getOfferApprovalSummaryScope())
			.field(Employee.OFFER_ACCEPTANCE_PROPERTY, getOfferAcceptanceSummaryScope())
			.field(Employee.EMPLOYEE_BOARDING_PROPERTY, getEmployeeBoardingSummaryScope())
			.field(Employee.TERMINATION_PROPERTY, getTerminationSummaryScope())
			.field(Employee.LAST_UPDATE_TIME_PROPERTY)
			.field(Employee.VERSION_PROPERTY)
		;
	}

	/** JobApplication的ListOf时需要序列化的属性列表 */
	protected SerializeScope getJobApplicationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='申请者本人';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='我觉得我符合职位要求，请给我一个机会为公司发展做出贡献，谢谢！';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(JobApplication.ID_PROPERTY)
			.field(JobApplication.APPLICATION_TIME_PROPERTY)
			.field(JobApplication.WHO_PROPERTY).as("title")
			.field(JobApplication.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(JobApplication.VERSION_PROPERTY)
		;
	}

	/** ProfessionInterview的ListOf时需要序列化的属性列表 */
	protected SerializeScope getProfessionInterviewListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='技术部';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='能力各方面表现不错，进入下一轮';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(ProfessionInterview.ID_PROPERTY)
			.field(ProfessionInterview.WHO_PROPERTY).as("title")
			.field(ProfessionInterview.INTERVIEW_TIME_PROPERTY)
			.field(ProfessionInterview.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(ProfessionInterview.VERSION_PROPERTY)
		;
	}

	/** HrInterview的ListOf时需要序列化的属性列表 */
	protected SerializeScope getHrInterviewListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='人力资源部';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='软技能，责任感，气质不错啊';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(HrInterview.ID_PROPERTY)
			.field(HrInterview.WHO_PROPERTY).as("title")
			.field(HrInterview.INTERVIEW_TIME_PROPERTY)
			.field(HrInterview.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(HrInterview.VERSION_PROPERTY)
		;
	}

	/** OfferApproval的ListOf时需要序列化的属性列表 */
	protected SerializeScope getOfferApprovalListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='总经理';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='该员工发展潜力不错，';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OfferApproval.ID_PROPERTY)
			.field(OfferApproval.WHO_PROPERTY).as("title")
			.field(OfferApproval.APPROVE_TIME_PROPERTY)
			.field(OfferApproval.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(OfferApproval.VERSION_PROPERTY)
		;
	}

	/** OfferAcceptance的ListOf时需要序列化的属性列表 */
	protected SerializeScope getOfferAcceptanceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='申请者';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='谢谢，我一个月内上班';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(OfferAcceptance.ID_PROPERTY)
			.field(OfferAcceptance.WHO_PROPERTY).as("title")
			.field(OfferAcceptance.ACCEPT_TIME_PROPERTY)
			.field(OfferAcceptance.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(OfferAcceptance.VERSION_PROPERTY)
		;
	}

	/** EmployeeBoarding的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeBoardingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='人力资源部';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='comments';
		//	type='string';
		//	value='欢迎加入植物医生大家庭';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeBoarding.ID_PROPERTY)
			.field(EmployeeBoarding.WHO_PROPERTY).as("title")
			.field(EmployeeBoarding.EMPLOY_TIME_PROPERTY)
			.field(EmployeeBoarding.COMMENTS_PROPERTY).as("brief").with_prefix("评论: ")
			.field(EmployeeBoarding.VERSION_PROPERTY)
		;
	}

	/** Instructor的ListOf时需要序列化的属性列表 */
	protected SerializeScope getInstructorListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='高级讲师';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='family_name';
		//	type='string';
		//	value='张|王|李|贺';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Instructor.ID_PROPERTY)
			.field(Instructor.TITLE_PROPERTY).as("title")
			.field(Instructor.FAMILY_NAME_PROPERTY).as("brief").with_prefix("姓: ")
			.field(Instructor.GIVEN_NAME_PROPERTY)
			.field(Instructor.CELL_PHONE_PROPERTY)
			.field(Instructor.EMAIL_PROPERTY)
			.field(Instructor.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(Instructor.INTRODUCTION_PROPERTY)
			.field(Instructor.LAST_UPDATE_TIME_PROPERTY)
			.field(Instructor.VERSION_PROPERTY)
		;
	}

	/** CompanyTraining的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCompanyTrainingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='入职培训';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='duration_hours';
		//	type='int';
		//	value='3';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(CompanyTraining.ID_PROPERTY)
			.field(CompanyTraining.TITLE_PROPERTY).as("title")
			.field(CompanyTraining.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(CompanyTraining.INSTRUCTOR_PROPERTY, getInstructorSummaryScope())
			.field(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, getTrainingCourseTypeSummaryScope())
			.field(CompanyTraining.TIME_START_PROPERTY)
			.field(CompanyTraining.DURATION_HOURS_PROPERTY).as("brief").with_prefix("持续时间: ")
			.field(CompanyTraining.LAST_UPDATE_TIME_PROPERTY)
			.field(CompanyTraining.VERSION_PROPERTY)
		;
	}

	/** Scoring的ListOf时需要序列化的属性列表 */
	protected SerializeScope getScoringListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='scored_by';
		//	type='string';
		//	value='王志文';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='score';
		//	type='int';
		//	value='100';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(Scoring.ID_PROPERTY)
			.field(Scoring.SCORED_BY_PROPERTY).as("title")
			.field(Scoring.SCORE_PROPERTY).as("brief").with_prefix("分数: ")
			.field(Scoring.COMMENT_PROPERTY)
			.field(Scoring.VERSION_PROPERTY)
		;
	}

	/** EmployeeCompanyTraining的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeCompanyTrainingListOfViewScope() {
		// DisplayMode{name='auto', titleField=null, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeCompanyTraining.ID_PROPERTY)
			.field(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeCompanyTraining.TRAINING_PROPERTY, getCompanyTrainingSummaryScope())
			.field(EmployeeCompanyTraining.SCORING_PROPERTY, getScoringSummaryScope())
			.field(EmployeeCompanyTraining.VERSION_PROPERTY)
		;
	}

	/** EmployeeSkill的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeSkillListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='高手高手高高手';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeSkill.ID_PROPERTY)
			.field(EmployeeSkill.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeSkill.SKILL_TYPE_PROPERTY, getSkillTypeSummaryScope())
			.field(EmployeeSkill.DESCRIPTION_PROPERTY).as("title")
			.field(EmployeeSkill.VERSION_PROPERTY)
		;
	}

	/** EmployeePerformance的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeePerformanceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='performance_comment';
		//	type='string';
		//	value='绩效大大的不错';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeePerformance.ID_PROPERTY)
			.field(EmployeePerformance.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY).as("title")
			.field(EmployeePerformance.VERSION_PROPERTY)
		;
	}

	/** EmployeeWorkExperience的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeWorkExperienceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='company';
		//	type='string';
		//	value='丝芙兰化妆品公司';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='在此期间取得非常好的绩效，赢得了客户的信赖';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeWorkExperience.ID_PROPERTY)
			.field(EmployeeWorkExperience.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeWorkExperience.START_PROPERTY)
			.field(EmployeeWorkExperience.END_PROPERTY)
			.field(EmployeeWorkExperience.COMPANY_PROPERTY).as("title")
			.field(EmployeeWorkExperience.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(EmployeeWorkExperience.VERSION_PROPERTY)
		;
	}

	/** EmployeeLeave的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeLeaveListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='remark';
		//	type='string';
		//	value='请年假，出去耍！！！！';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='leave_duration_hour';
		//	type='int';
		//	value='8';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeLeave.ID_PROPERTY)
			.field(EmployeeLeave.WHO_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeLeave.TYPE_PROPERTY, getLeaveTypeSummaryScope())
			.field(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY).as("brief").with_prefix("请假时长: ")
			.field(EmployeeLeave.REMARK_PROPERTY).as("title")
			.field(EmployeeLeave.VERSION_PROPERTY)
		;
	}

	/** EmployeeInterview的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeInterviewListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='remark';
		//	type='string';
		//	value='结果不错，面试通过！';
		//	required='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeInterview.ID_PROPERTY)
			.field(EmployeeInterview.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, getInterviewTypeSummaryScope())
			.field(EmployeeInterview.REMARK_PROPERTY).as("title")
			.field(EmployeeInterview.VERSION_PROPERTY)
		;
	}

	/** EmployeeAttendance的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeAttendanceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='remark';
		//	type='string';
		//	value='今天状态不错啊';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='duration_hours';
		//	type='int';
		//	value='8';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeAttendance.ID_PROPERTY)
			.field(EmployeeAttendance.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeAttendance.ENTER_TIME_PROPERTY)
			.field(EmployeeAttendance.LEAVE_TIME_PROPERTY)
			.field(EmployeeAttendance.DURATION_HOURS_PROPERTY).as("brief").with_prefix("持续时间: ")
			.field(EmployeeAttendance.REMARK_PROPERTY).as("title")
			.field(EmployeeAttendance.VERSION_PROPERTY)
		;
	}

	/** EmployeeQualifier的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeQualifierListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='type';
		//	type='string';
		//	value='认证药剂师|认证架构师|认证会计师|认证经济师|OCP|CCNA|CCNP';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='level';
		//	type='string';
		//	value='高级|中级|初级';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeQualifier.ID_PROPERTY)
			.field(EmployeeQualifier.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeQualifier.QUALIFIED_TIME_PROPERTY)
			.field(EmployeeQualifier.TYPE_PROPERTY).as("title")
			.field(EmployeeQualifier.LEVEL_PROPERTY).as("brief").with_prefix("水平: ")
			.field(EmployeeQualifier.REMARK_PROPERTY)
			.field(EmployeeQualifier.VERSION_PROPERTY)
		;
	}

	/** EmployeeEducation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeEducationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='type';
		//	type='string';
		//	value='小学|初中|高中|大学|硕士|博士|职业教育';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='remark';
		//	type='string';
		//	value='考试成绩当年第一名';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeEducation.ID_PROPERTY)
			.field(EmployeeEducation.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeEducation.COMPLETE_TIME_PROPERTY)
			.field(EmployeeEducation.TYPE_PROPERTY).as("title")
			.field(EmployeeEducation.REMARK_PROPERTY).as("brief").with_prefix("备注: ")
			.field(EmployeeEducation.VERSION_PROPERTY)
		;
	}

	/** EmployeeAward的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeAwardListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='type';
		//	type='string';
		//	value='明星员工|销售之星|技术之星|管理之星|终身成就奖';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='remark';
		//	type='string';
		//	value='考试成绩当年第一名';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeAward.ID_PROPERTY)
			.field(EmployeeAward.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeAward.COMPLETE_TIME_PROPERTY)
			.field(EmployeeAward.TYPE_PROPERTY).as("title")
			.field(EmployeeAward.REMARK_PROPERTY).as("brief").with_prefix("备注: ")
			.field(EmployeeAward.VERSION_PROPERTY)
		;
	}

	/** EmployeeSalarySheet的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeSalarySheetListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='base_salary';
		//	type='money';
		//	value='$3000.10';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='bonus';
		//	type='money';
		//	value='$1000.10';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(EmployeeSalarySheet.ID_PROPERTY)
			.field(EmployeeSalarySheet.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, getSalaryGradeSummaryScope())
			.field(EmployeeSalarySheet.BASE_SALARY_PROPERTY).as("title")
			.field(EmployeeSalarySheet.BONUS_PROPERTY).as("brief").with_prefix("奖金: ")
			.field(EmployeeSalarySheet.REWARD_PROPERTY)
			.field(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY)
			.field(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY)
			.field(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY)
			.field(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY)
			.field(EmployeeSalarySheet.PAYING_OFF_PROPERTY, getPayingOffSummaryScope())
			.field(EmployeeSalarySheet.VERSION_PROPERTY)
		;
	}

	/** PayingOff的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPayingOffListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who';
		//	type='string';
		//	value='出纳';
		//	required='true';
		//}
		//, briefField=fieldesc{
		//	name='amount';
		//	type='money';
		//	value='$5223.88';
		//	required='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(YoubenbenBaseConstants.X_LINK_TO_URL)
			.field(PayingOff.ID_PROPERTY)
			.field(PayingOff.WHO_PROPERTY).as("title")
			.field(PayingOff.PAID_FOR_PROPERTY, getEmployeeSummaryScope())
			.field(PayingOff.PAID_TIME_PROPERTY)
			.field(PayingOff.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(PayingOff.VERSION_PROPERTY)
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
		scopes.put(RetailStoreCountryCenter.class.getName(),getRetailStoreCountryCenterListOfViewScope());
		scopes.put(Catalog.class.getName(),getCatalogListOfViewScope());
		scopes.put(LevelOneCategory.class.getName(),getLevelOneCategoryListOfViewScope());
		scopes.put(LevelTwoCategory.class.getName(),getLevelTwoCategoryListOfViewScope());
		scopes.put(LevelThreeCategory.class.getName(),getLevelThreeCategoryListOfViewScope());
		scopes.put(Product.class.getName(),getProductListOfViewScope());
		scopes.put(Sku.class.getName(),getSkuListOfViewScope());
		scopes.put(RetailStoreProvinceCenter.class.getName(),getRetailStoreProvinceCenterListOfViewScope());
		scopes.put(ProvinceCenterDepartment.class.getName(),getProvinceCenterDepartmentListOfViewScope());
		scopes.put(ProvinceCenterEmployee.class.getName(),getProvinceCenterEmployeeListOfViewScope());
		scopes.put(RetailStoreCityServiceCenter.class.getName(),getRetailStoreCityServiceCenterListOfViewScope());
		scopes.put(CityPartner.class.getName(),getCityPartnerListOfViewScope());
		scopes.put(PotentialCustomer.class.getName(),getPotentialCustomerListOfViewScope());
		scopes.put(PotentialCustomerContactPerson.class.getName(),getPotentialCustomerContactPersonListOfViewScope());
		scopes.put(PotentialCustomerContact.class.getName(),getPotentialCustomerContactListOfViewScope());
		scopes.put(CityEvent.class.getName(),getCityEventListOfViewScope());
		scopes.put(EventAttendance.class.getName(),getEventAttendanceListOfViewScope());
		scopes.put(RetailStore.class.getName(),getRetailStoreListOfViewScope());
		scopes.put(RetailStoreCreation.class.getName(),getRetailStoreCreationListOfViewScope());
		scopes.put(RetailStoreInvestmentInvitation.class.getName(),getRetailStoreInvestmentInvitationListOfViewScope());
		scopes.put(RetailStoreFranchising.class.getName(),getRetailStoreFranchisingListOfViewScope());
		scopes.put(RetailStoreDecoration.class.getName(),getRetailStoreDecorationListOfViewScope());
		scopes.put(RetailStoreOpening.class.getName(),getRetailStoreOpeningListOfViewScope());
		scopes.put(RetailStoreClosing.class.getName(),getRetailStoreClosingListOfViewScope());
		scopes.put(RetailStoreMember.class.getName(),getRetailStoreMemberListOfViewScope());
		scopes.put(ConsumerOrder.class.getName(),getConsumerOrderListOfViewScope());
		scopes.put(ConsumerOrderConfirmation.class.getName(),getConsumerOrderConfirmationListOfViewScope());
		scopes.put(ConsumerOrderApproval.class.getName(),getConsumerOrderApprovalListOfViewScope());
		scopes.put(ConsumerOrderProcessing.class.getName(),getConsumerOrderProcessingListOfViewScope());
		scopes.put(ConsumerOrderShipment.class.getName(),getConsumerOrderShipmentListOfViewScope());
		scopes.put(ConsumerOrderDelivery.class.getName(),getConsumerOrderDeliveryListOfViewScope());
		scopes.put(ConsumerOrderLineItem.class.getName(),getConsumerOrderLineItemListOfViewScope());
		scopes.put(ConsumerOrderShippingGroup.class.getName(),getConsumerOrderShippingGroupListOfViewScope());
		scopes.put(ConsumerOrderPaymentGroup.class.getName(),getConsumerOrderPaymentGroupListOfViewScope());
		scopes.put(ConsumerOrderPriceAdjustment.class.getName(),getConsumerOrderPriceAdjustmentListOfViewScope());
		scopes.put(RetailStoreMemberCoupon.class.getName(),getRetailStoreMemberCouponListOfViewScope());
		scopes.put(MemberWishlist.class.getName(),getMemberWishlistListOfViewScope());
		scopes.put(MemberRewardPoint.class.getName(),getMemberRewardPointListOfViewScope());
		scopes.put(MemberRewardPointRedemption.class.getName(),getMemberRewardPointRedemptionListOfViewScope());
		scopes.put(MemberWishlistProduct.class.getName(),getMemberWishlistProductListOfViewScope());
		scopes.put(RetailStoreMemberAddress.class.getName(),getRetailStoreMemberAddressListOfViewScope());
		scopes.put(RetailStoreMemberGiftCard.class.getName(),getRetailStoreMemberGiftCardListOfViewScope());
		scopes.put(RetailStoreMemberGiftCardConsumeRecord.class.getName(),getRetailStoreMemberGiftCardConsumeRecordListOfViewScope());
		scopes.put(GoodsSupplier.class.getName(),getGoodsSupplierListOfViewScope());
		scopes.put(SupplierProduct.class.getName(),getSupplierProductListOfViewScope());
		scopes.put(ProductSupplyDuration.class.getName(),getProductSupplyDurationListOfViewScope());
		scopes.put(SupplyOrder.class.getName(),getSupplyOrderListOfViewScope());
		scopes.put(SupplyOrderConfirmation.class.getName(),getSupplyOrderConfirmationListOfViewScope());
		scopes.put(SupplyOrderApproval.class.getName(),getSupplyOrderApprovalListOfViewScope());
		scopes.put(SupplyOrderProcessing.class.getName(),getSupplyOrderProcessingListOfViewScope());
		scopes.put(SupplyOrderPicking.class.getName(),getSupplyOrderPickingListOfViewScope());
		scopes.put(SupplyOrderShipment.class.getName(),getSupplyOrderShipmentListOfViewScope());
		scopes.put(SupplyOrderDelivery.class.getName(),getSupplyOrderDeliveryListOfViewScope());
		scopes.put(SupplyOrderLineItem.class.getName(),getSupplyOrderLineItemListOfViewScope());
		scopes.put(SupplyOrderShippingGroup.class.getName(),getSupplyOrderShippingGroupListOfViewScope());
		scopes.put(SupplyOrderPaymentGroup.class.getName(),getSupplyOrderPaymentGroupListOfViewScope());
		scopes.put(RetailStoreOrder.class.getName(),getRetailStoreOrderListOfViewScope());
		scopes.put(RetailStoreOrderConfirmation.class.getName(),getRetailStoreOrderConfirmationListOfViewScope());
		scopes.put(RetailStoreOrderApproval.class.getName(),getRetailStoreOrderApprovalListOfViewScope());
		scopes.put(RetailStoreOrderProcessing.class.getName(),getRetailStoreOrderProcessingListOfViewScope());
		scopes.put(RetailStoreOrderPicking.class.getName(),getRetailStoreOrderPickingListOfViewScope());
		scopes.put(RetailStoreOrderShipment.class.getName(),getRetailStoreOrderShipmentListOfViewScope());
		scopes.put(RetailStoreOrderDelivery.class.getName(),getRetailStoreOrderDeliveryListOfViewScope());
		scopes.put(RetailStoreOrderLineItem.class.getName(),getRetailStoreOrderLineItemListOfViewScope());
		scopes.put(RetailStoreOrderShippingGroup.class.getName(),getRetailStoreOrderShippingGroupListOfViewScope());
		scopes.put(RetailStoreOrderPaymentGroup.class.getName(),getRetailStoreOrderPaymentGroupListOfViewScope());
		scopes.put(Warehouse.class.getName(),getWarehouseListOfViewScope());
		scopes.put(StorageSpace.class.getName(),getStorageSpaceListOfViewScope());
		scopes.put(SmartPallet.class.getName(),getSmartPalletListOfViewScope());
		scopes.put(GoodsShelf.class.getName(),getGoodsShelfListOfViewScope());
		scopes.put(GoodsShelfStockCount.class.getName(),getGoodsShelfStockCountListOfViewScope());
		scopes.put(StockCountIssueTrack.class.getName(),getStockCountIssueTrackListOfViewScope());
		scopes.put(GoodsAllocation.class.getName(),getGoodsAllocationListOfViewScope());
		scopes.put(Goods.class.getName(),getGoodsListOfViewScope());
		scopes.put(GoodsPackaging.class.getName(),getGoodsPackagingListOfViewScope());
		scopes.put(GoodsMovement.class.getName(),getGoodsMovementListOfViewScope());
		scopes.put(SupplierSpace.class.getName(),getSupplierSpaceListOfViewScope());
		scopes.put(ReceivingSpace.class.getName(),getReceivingSpaceListOfViewScope());
		scopes.put(ShippingSpace.class.getName(),getShippingSpaceListOfViewScope());
		scopes.put(DamageSpace.class.getName(),getDamageSpaceListOfViewScope());
		scopes.put(WarehouseAsset.class.getName(),getWarehouseAssetListOfViewScope());
		scopes.put(TransportFleet.class.getName(),getTransportFleetListOfViewScope());
		scopes.put(TransportTruck.class.getName(),getTransportTruckListOfViewScope());
		scopes.put(TruckDriver.class.getName(),getTruckDriverListOfViewScope());
		scopes.put(TransportTask.class.getName(),getTransportTaskListOfViewScope());
		scopes.put(TransportTaskTrack.class.getName(),getTransportTaskTrackListOfViewScope());
		scopes.put(AccountSet.class.getName(),getAccountSetListOfViewScope());
		scopes.put(AccountingSubject.class.getName(),getAccountingSubjectListOfViewScope());
		scopes.put(AccountingPeriod.class.getName(),getAccountingPeriodListOfViewScope());
		scopes.put(AccountingDocumentType.class.getName(),getAccountingDocumentTypeListOfViewScope());
		scopes.put(AccountingDocument.class.getName(),getAccountingDocumentListOfViewScope());
		scopes.put(AccountingDocumentCreation.class.getName(),getAccountingDocumentCreationListOfViewScope());
		scopes.put(AccountingDocumentConfirmation.class.getName(),getAccountingDocumentConfirmationListOfViewScope());
		scopes.put(AccountingDocumentAuditing.class.getName(),getAccountingDocumentAuditingListOfViewScope());
		scopes.put(AccountingDocumentPosting.class.getName(),getAccountingDocumentPostingListOfViewScope());
		scopes.put(OriginalVoucher.class.getName(),getOriginalVoucherListOfViewScope());
		scopes.put(OriginalVoucherCreation.class.getName(),getOriginalVoucherCreationListOfViewScope());
		scopes.put(OriginalVoucherConfirmation.class.getName(),getOriginalVoucherConfirmationListOfViewScope());
		scopes.put(OriginalVoucherAuditing.class.getName(),getOriginalVoucherAuditingListOfViewScope());
		scopes.put(AccountingDocumentLine.class.getName(),getAccountingDocumentLineListOfViewScope());
		scopes.put(LevelOneDepartment.class.getName(),getLevelOneDepartmentListOfViewScope());
		scopes.put(LevelTwoDepartment.class.getName(),getLevelTwoDepartmentListOfViewScope());
		scopes.put(LevelThreeDepartment.class.getName(),getLevelThreeDepartmentListOfViewScope());
		scopes.put(SkillType.class.getName(),getSkillTypeListOfViewScope());
		scopes.put(ResponsibilityType.class.getName(),getResponsibilityTypeListOfViewScope());
		scopes.put(TerminationReason.class.getName(),getTerminationReasonListOfViewScope());
		scopes.put(TerminationType.class.getName(),getTerminationTypeListOfViewScope());
		scopes.put(OccupationType.class.getName(),getOccupationTypeListOfViewScope());
		scopes.put(LeaveType.class.getName(),getLeaveTypeListOfViewScope());
		scopes.put(SalaryGrade.class.getName(),getSalaryGradeListOfViewScope());
		scopes.put(InterviewType.class.getName(),getInterviewTypeListOfViewScope());
		scopes.put(TrainingCourseType.class.getName(),getTrainingCourseTypeListOfViewScope());
		scopes.put(PublicHoliday.class.getName(),getPublicHolidayListOfViewScope());
		scopes.put(Termination.class.getName(),getTerminationListOfViewScope());
		scopes.put(View.class.getName(),getViewListOfViewScope());
		scopes.put(Employee.class.getName(),getEmployeeListOfViewScope());
		scopes.put(JobApplication.class.getName(),getJobApplicationListOfViewScope());
		scopes.put(ProfessionInterview.class.getName(),getProfessionInterviewListOfViewScope());
		scopes.put(HrInterview.class.getName(),getHrInterviewListOfViewScope());
		scopes.put(OfferApproval.class.getName(),getOfferApprovalListOfViewScope());
		scopes.put(OfferAcceptance.class.getName(),getOfferAcceptanceListOfViewScope());
		scopes.put(EmployeeBoarding.class.getName(),getEmployeeBoardingListOfViewScope());
		scopes.put(Instructor.class.getName(),getInstructorListOfViewScope());
		scopes.put(CompanyTraining.class.getName(),getCompanyTrainingListOfViewScope());
		scopes.put(Scoring.class.getName(),getScoringListOfViewScope());
		scopes.put(EmployeeCompanyTraining.class.getName(),getEmployeeCompanyTrainingListOfViewScope());
		scopes.put(EmployeeSkill.class.getName(),getEmployeeSkillListOfViewScope());
		scopes.put(EmployeePerformance.class.getName(),getEmployeePerformanceListOfViewScope());
		scopes.put(EmployeeWorkExperience.class.getName(),getEmployeeWorkExperienceListOfViewScope());
		scopes.put(EmployeeLeave.class.getName(),getEmployeeLeaveListOfViewScope());
		scopes.put(EmployeeInterview.class.getName(),getEmployeeInterviewListOfViewScope());
		scopes.put(EmployeeAttendance.class.getName(),getEmployeeAttendanceListOfViewScope());
		scopes.put(EmployeeQualifier.class.getName(),getEmployeeQualifierListOfViewScope());
		scopes.put(EmployeeEducation.class.getName(),getEmployeeEducationListOfViewScope());
		scopes.put(EmployeeAward.class.getName(),getEmployeeAwardListOfViewScope());
		scopes.put(EmployeeSalarySheet.class.getName(),getEmployeeSalarySheetListOfViewScope());
		scopes.put(PayingOff.class.getName(),getPayingOffListOfViewScope());
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
















