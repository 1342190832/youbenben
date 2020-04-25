
package com.youbenben.youbenben;
import java.util.Map;

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

public class BeanFactoryImpl{


	public RetailStoreCountryCenter createRetailStoreCountryCenter(Map<String,Object> options){
		return new RetailStoreCountryCenter();
	}


	public Catalog createCatalog(Map<String,Object> options){
		return new Catalog();
	}


	public LevelOneCategory createLevelOneCategory(Map<String,Object> options){
		return new LevelOneCategory();
	}


	public LevelTwoCategory createLevelTwoCategory(Map<String,Object> options){
		return new LevelTwoCategory();
	}


	public LevelThreeCategory createLevelThreeCategory(Map<String,Object> options){
		return new LevelThreeCategory();
	}


	public Product createProduct(Map<String,Object> options){
		return new Product();
	}


	public Sku createSku(Map<String,Object> options){
		return new Sku();
	}


	public RetailStoreProvinceCenter createRetailStoreProvinceCenter(Map<String,Object> options){
		return new RetailStoreProvinceCenter();
	}


	public ProvinceCenterDepartment createProvinceCenterDepartment(Map<String,Object> options){
		return new ProvinceCenterDepartment();
	}


	public ProvinceCenterEmployee createProvinceCenterEmployee(Map<String,Object> options){
		return new ProvinceCenterEmployee();
	}


	public RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(Map<String,Object> options){
		return new RetailStoreCityServiceCenter();
	}


	public CityPartner createCityPartner(Map<String,Object> options){
		return new CityPartner();
	}


	public PotentialCustomer createPotentialCustomer(Map<String,Object> options){
		return new PotentialCustomer();
	}


	public PotentialCustomerContactPerson createPotentialCustomerContactPerson(Map<String,Object> options){
		return new PotentialCustomerContactPerson();
	}


	public PotentialCustomerContact createPotentialCustomerContact(Map<String,Object> options){
		return new PotentialCustomerContact();
	}


	public CityEvent createCityEvent(Map<String,Object> options){
		return new CityEvent();
	}


	public EventAttendance createEventAttendance(Map<String,Object> options){
		return new EventAttendance();
	}


	public RetailStore createRetailStore(Map<String,Object> options){
		return new RetailStore();
	}


	public RetailStoreCreation createRetailStoreCreation(Map<String,Object> options){
		return new RetailStoreCreation();
	}


	public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(Map<String,Object> options){
		return new RetailStoreInvestmentInvitation();
	}


	public RetailStoreFranchising createRetailStoreFranchising(Map<String,Object> options){
		return new RetailStoreFranchising();
	}


	public RetailStoreDecoration createRetailStoreDecoration(Map<String,Object> options){
		return new RetailStoreDecoration();
	}


	public RetailStoreOpening createRetailStoreOpening(Map<String,Object> options){
		return new RetailStoreOpening();
	}


	public RetailStoreClosing createRetailStoreClosing(Map<String,Object> options){
		return new RetailStoreClosing();
	}


	public RetailStoreMember createRetailStoreMember(Map<String,Object> options){
		return new RetailStoreMember();
	}


	public ConsumerOrder createConsumerOrder(Map<String,Object> options){
		return new ConsumerOrder();
	}


	public ConsumerOrderConfirmation createConsumerOrderConfirmation(Map<String,Object> options){
		return new ConsumerOrderConfirmation();
	}


	public ConsumerOrderApproval createConsumerOrderApproval(Map<String,Object> options){
		return new ConsumerOrderApproval();
	}


	public ConsumerOrderProcessing createConsumerOrderProcessing(Map<String,Object> options){
		return new ConsumerOrderProcessing();
	}


	public ConsumerOrderShipment createConsumerOrderShipment(Map<String,Object> options){
		return new ConsumerOrderShipment();
	}


	public ConsumerOrderDelivery createConsumerOrderDelivery(Map<String,Object> options){
		return new ConsumerOrderDelivery();
	}


	public ConsumerOrderLineItem createConsumerOrderLineItem(Map<String,Object> options){
		return new ConsumerOrderLineItem();
	}


	public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(Map<String,Object> options){
		return new ConsumerOrderShippingGroup();
	}


	public ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(Map<String,Object> options){
		return new ConsumerOrderPaymentGroup();
	}


	public ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(Map<String,Object> options){
		return new ConsumerOrderPriceAdjustment();
	}


	public RetailStoreMemberCoupon createRetailStoreMemberCoupon(Map<String,Object> options){
		return new RetailStoreMemberCoupon();
	}


	public MemberWishlist createMemberWishlist(Map<String,Object> options){
		return new MemberWishlist();
	}


	public MemberRewardPoint createMemberRewardPoint(Map<String,Object> options){
		return new MemberRewardPoint();
	}


	public MemberRewardPointRedemption createMemberRewardPointRedemption(Map<String,Object> options){
		return new MemberRewardPointRedemption();
	}


	public MemberWishlistProduct createMemberWishlistProduct(Map<String,Object> options){
		return new MemberWishlistProduct();
	}


	public RetailStoreMemberAddress createRetailStoreMemberAddress(Map<String,Object> options){
		return new RetailStoreMemberAddress();
	}


	public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(Map<String,Object> options){
		return new RetailStoreMemberGiftCard();
	}


	public RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(Map<String,Object> options){
		return new RetailStoreMemberGiftCardConsumeRecord();
	}


	public GoodsSupplier createGoodsSupplier(Map<String,Object> options){
		return new GoodsSupplier();
	}


	public SupplierProduct createSupplierProduct(Map<String,Object> options){
		return new SupplierProduct();
	}


	public ProductSupplyDuration createProductSupplyDuration(Map<String,Object> options){
		return new ProductSupplyDuration();
	}


	public SupplyOrder createSupplyOrder(Map<String,Object> options){
		return new SupplyOrder();
	}


	public SupplyOrderConfirmation createSupplyOrderConfirmation(Map<String,Object> options){
		return new SupplyOrderConfirmation();
	}


	public SupplyOrderApproval createSupplyOrderApproval(Map<String,Object> options){
		return new SupplyOrderApproval();
	}


	public SupplyOrderProcessing createSupplyOrderProcessing(Map<String,Object> options){
		return new SupplyOrderProcessing();
	}


	public SupplyOrderPicking createSupplyOrderPicking(Map<String,Object> options){
		return new SupplyOrderPicking();
	}


	public SupplyOrderShipment createSupplyOrderShipment(Map<String,Object> options){
		return new SupplyOrderShipment();
	}


	public SupplyOrderDelivery createSupplyOrderDelivery(Map<String,Object> options){
		return new SupplyOrderDelivery();
	}


	public SupplyOrderLineItem createSupplyOrderLineItem(Map<String,Object> options){
		return new SupplyOrderLineItem();
	}


	public SupplyOrderShippingGroup createSupplyOrderShippingGroup(Map<String,Object> options){
		return new SupplyOrderShippingGroup();
	}


	public SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(Map<String,Object> options){
		return new SupplyOrderPaymentGroup();
	}


	public RetailStoreOrder createRetailStoreOrder(Map<String,Object> options){
		return new RetailStoreOrder();
	}


	public RetailStoreOrderConfirmation createRetailStoreOrderConfirmation(Map<String,Object> options){
		return new RetailStoreOrderConfirmation();
	}


	public RetailStoreOrderApproval createRetailStoreOrderApproval(Map<String,Object> options){
		return new RetailStoreOrderApproval();
	}


	public RetailStoreOrderProcessing createRetailStoreOrderProcessing(Map<String,Object> options){
		return new RetailStoreOrderProcessing();
	}


	public RetailStoreOrderPicking createRetailStoreOrderPicking(Map<String,Object> options){
		return new RetailStoreOrderPicking();
	}


	public RetailStoreOrderShipment createRetailStoreOrderShipment(Map<String,Object> options){
		return new RetailStoreOrderShipment();
	}


	public RetailStoreOrderDelivery createRetailStoreOrderDelivery(Map<String,Object> options){
		return new RetailStoreOrderDelivery();
	}


	public RetailStoreOrderLineItem createRetailStoreOrderLineItem(Map<String,Object> options){
		return new RetailStoreOrderLineItem();
	}


	public RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(Map<String,Object> options){
		return new RetailStoreOrderShippingGroup();
	}


	public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(Map<String,Object> options){
		return new RetailStoreOrderPaymentGroup();
	}


	public Warehouse createWarehouse(Map<String,Object> options){
		return new Warehouse();
	}


	public StorageSpace createStorageSpace(Map<String,Object> options){
		return new StorageSpace();
	}


	public SmartPallet createSmartPallet(Map<String,Object> options){
		return new SmartPallet();
	}


	public GoodsShelf createGoodsShelf(Map<String,Object> options){
		return new GoodsShelf();
	}


	public GoodsShelfStockCount createGoodsShelfStockCount(Map<String,Object> options){
		return new GoodsShelfStockCount();
	}


	public StockCountIssueTrack createStockCountIssueTrack(Map<String,Object> options){
		return new StockCountIssueTrack();
	}


	public GoodsAllocation createGoodsAllocation(Map<String,Object> options){
		return new GoodsAllocation();
	}


	public Goods createGoods(Map<String,Object> options){
		return new Goods();
	}


	public GoodsPackaging createGoodsPackaging(Map<String,Object> options){
		return new GoodsPackaging();
	}


	public GoodsMovement createGoodsMovement(Map<String,Object> options){
		return new GoodsMovement();
	}


	public SupplierSpace createSupplierSpace(Map<String,Object> options){
		return new SupplierSpace();
	}


	public ReceivingSpace createReceivingSpace(Map<String,Object> options){
		return new ReceivingSpace();
	}


	public ShippingSpace createShippingSpace(Map<String,Object> options){
		return new ShippingSpace();
	}


	public DamageSpace createDamageSpace(Map<String,Object> options){
		return new DamageSpace();
	}


	public WarehouseAsset createWarehouseAsset(Map<String,Object> options){
		return new WarehouseAsset();
	}


	public TransportFleet createTransportFleet(Map<String,Object> options){
		return new TransportFleet();
	}


	public TransportTruck createTransportTruck(Map<String,Object> options){
		return new TransportTruck();
	}


	public TruckDriver createTruckDriver(Map<String,Object> options){
		return new TruckDriver();
	}


	public TransportTask createTransportTask(Map<String,Object> options){
		return new TransportTask();
	}


	public TransportTaskTrack createTransportTaskTrack(Map<String,Object> options){
		return new TransportTaskTrack();
	}


	public AccountSet createAccountSet(Map<String,Object> options){
		return new AccountSet();
	}


	public AccountingSubject createAccountingSubject(Map<String,Object> options){
		return new AccountingSubject();
	}


	public AccountingPeriod createAccountingPeriod(Map<String,Object> options){
		return new AccountingPeriod();
	}


	public AccountingDocumentType createAccountingDocumentType(Map<String,Object> options){
		return new AccountingDocumentType();
	}


	public AccountingDocument createAccountingDocument(Map<String,Object> options){
		return new AccountingDocument();
	}


	public AccountingDocumentCreation createAccountingDocumentCreation(Map<String,Object> options){
		return new AccountingDocumentCreation();
	}


	public AccountingDocumentConfirmation createAccountingDocumentConfirmation(Map<String,Object> options){
		return new AccountingDocumentConfirmation();
	}


	public AccountingDocumentAuditing createAccountingDocumentAuditing(Map<String,Object> options){
		return new AccountingDocumentAuditing();
	}


	public AccountingDocumentPosting createAccountingDocumentPosting(Map<String,Object> options){
		return new AccountingDocumentPosting();
	}


	public OriginalVoucher createOriginalVoucher(Map<String,Object> options){
		return new OriginalVoucher();
	}


	public OriginalVoucherCreation createOriginalVoucherCreation(Map<String,Object> options){
		return new OriginalVoucherCreation();
	}


	public OriginalVoucherConfirmation createOriginalVoucherConfirmation(Map<String,Object> options){
		return new OriginalVoucherConfirmation();
	}


	public OriginalVoucherAuditing createOriginalVoucherAuditing(Map<String,Object> options){
		return new OriginalVoucherAuditing();
	}


	public AccountingDocumentLine createAccountingDocumentLine(Map<String,Object> options){
		return new AccountingDocumentLine();
	}


	public LevelOneDepartment createLevelOneDepartment(Map<String,Object> options){
		return new LevelOneDepartment();
	}


	public LevelTwoDepartment createLevelTwoDepartment(Map<String,Object> options){
		return new LevelTwoDepartment();
	}


	public LevelThreeDepartment createLevelThreeDepartment(Map<String,Object> options){
		return new LevelThreeDepartment();
	}


	public SkillType createSkillType(Map<String,Object> options){
		return new SkillType();
	}


	public ResponsibilityType createResponsibilityType(Map<String,Object> options){
		return new ResponsibilityType();
	}


	public TerminationReason createTerminationReason(Map<String,Object> options){
		return new TerminationReason();
	}


	public TerminationType createTerminationType(Map<String,Object> options){
		return new TerminationType();
	}


	public OccupationType createOccupationType(Map<String,Object> options){
		return new OccupationType();
	}


	public LeaveType createLeaveType(Map<String,Object> options){
		return new LeaveType();
	}


	public SalaryGrade createSalaryGrade(Map<String,Object> options){
		return new SalaryGrade();
	}


	public InterviewType createInterviewType(Map<String,Object> options){
		return new InterviewType();
	}


	public TrainingCourseType createTrainingCourseType(Map<String,Object> options){
		return new TrainingCourseType();
	}


	public PublicHoliday createPublicHoliday(Map<String,Object> options){
		return new PublicHoliday();
	}


	public Termination createTermination(Map<String,Object> options){
		return new Termination();
	}


	public View createView(Map<String,Object> options){
		return new View();
	}


	public Employee createEmployee(Map<String,Object> options){
		return new Employee();
	}


	public JobApplication createJobApplication(Map<String,Object> options){
		return new JobApplication();
	}


	public ProfessionInterview createProfessionInterview(Map<String,Object> options){
		return new ProfessionInterview();
	}


	public HrInterview createHrInterview(Map<String,Object> options){
		return new HrInterview();
	}


	public OfferApproval createOfferApproval(Map<String,Object> options){
		return new OfferApproval();
	}


	public OfferAcceptance createOfferAcceptance(Map<String,Object> options){
		return new OfferAcceptance();
	}


	public EmployeeBoarding createEmployeeBoarding(Map<String,Object> options){
		return new EmployeeBoarding();
	}


	public Instructor createInstructor(Map<String,Object> options){
		return new Instructor();
	}


	public CompanyTraining createCompanyTraining(Map<String,Object> options){
		return new CompanyTraining();
	}


	public Scoring createScoring(Map<String,Object> options){
		return new Scoring();
	}


	public EmployeeCompanyTraining createEmployeeCompanyTraining(Map<String,Object> options){
		return new EmployeeCompanyTraining();
	}


	public EmployeeSkill createEmployeeSkill(Map<String,Object> options){
		return new EmployeeSkill();
	}


	public EmployeePerformance createEmployeePerformance(Map<String,Object> options){
		return new EmployeePerformance();
	}


	public EmployeeWorkExperience createEmployeeWorkExperience(Map<String,Object> options){
		return new EmployeeWorkExperience();
	}


	public EmployeeLeave createEmployeeLeave(Map<String,Object> options){
		return new EmployeeLeave();
	}


	public EmployeeInterview createEmployeeInterview(Map<String,Object> options){
		return new EmployeeInterview();
	}


	public EmployeeAttendance createEmployeeAttendance(Map<String,Object> options){
		return new EmployeeAttendance();
	}


	public EmployeeQualifier createEmployeeQualifier(Map<String,Object> options){
		return new EmployeeQualifier();
	}


	public EmployeeEducation createEmployeeEducation(Map<String,Object> options){
		return new EmployeeEducation();
	}


	public EmployeeAward createEmployeeAward(Map<String,Object> options){
		return new EmployeeAward();
	}


	public EmployeeSalarySheet createEmployeeSalarySheet(Map<String,Object> options){
		return new EmployeeSalarySheet();
	}


	public PayingOff createPayingOff(Map<String,Object> options){
		return new PayingOff();
	}


	public MobileApp createMobileApp(Map<String,Object> options){
		return new MobileApp();
	}


	public Page createPage(Map<String,Object> options){
		return new Page();
	}


	public PageType createPageType(Map<String,Object> options){
		return new PageType();
	}


	public Slide createSlide(Map<String,Object> options){
		return new Slide();
	}


	public UiAction createUiAction(Map<String,Object> options){
		return new UiAction();
	}


	public Section createSection(Map<String,Object> options){
		return new Section();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public QuickLink createQuickLink(Map<String,Object> options){
		return new QuickLink();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public CandidateContainer createCandidateContainer(Map<String,Object> options){
		return new CandidateContainer();
	}


	public CandidateElement createCandidateElement(Map<String,Object> options){
		return new CandidateElement();
	}


	public WechatWorkappIdentify createWechatWorkappIdentify(Map<String,Object> options){
		return new WechatWorkappIdentify();
	}


	public WechatMiniappIdentify createWechatMiniappIdentify(Map<String,Object> options){
		return new WechatMiniappIdentify();
	}


	public KeypairIdentify createKeypairIdentify(Map<String,Object> options){
		return new KeypairIdentify();
	}


	public PublicKeyType createPublicKeyType(Map<String,Object> options){
		return new PublicKeyType();
	}


	public TreeNode createTreeNode(Map<String,Object> options){
		return new TreeNode();
	}





}

















