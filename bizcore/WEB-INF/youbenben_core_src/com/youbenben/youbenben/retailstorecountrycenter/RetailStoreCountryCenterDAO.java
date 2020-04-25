
package com.youbenben.youbenben.retailstorecountrycenter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.interviewtype.InterviewType;
import com.youbenben.youbenben.warehouse.Warehouse;
import com.youbenben.youbenben.catalog.Catalog;
import com.youbenben.youbenben.supplyorder.SupplyOrder;
import com.youbenben.youbenben.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.youbenben.youbenben.publicholiday.PublicHoliday;
import com.youbenben.youbenben.transportfleet.TransportFleet;
import com.youbenben.youbenben.responsibilitytype.ResponsibilityType;
import com.youbenben.youbenben.retailstoreorder.RetailStoreOrder;
import com.youbenben.youbenben.levelonedepartment.LevelOneDepartment;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.skilltype.SkillType;
import com.youbenben.youbenben.terminationreason.TerminationReason;
import com.youbenben.youbenben.employee.Employee;
import com.youbenben.youbenben.accountset.AccountSet;
import com.youbenben.youbenben.salarygrade.SalaryGrade;
import com.youbenben.youbenben.goodssupplier.GoodsSupplier;
import com.youbenben.youbenben.companytraining.CompanyTraining;
import com.youbenben.youbenben.leavetype.LeaveType;
import com.youbenben.youbenben.terminationtype.TerminationType;
import com.youbenben.youbenben.trainingcoursetype.TrainingCourseType;
import com.youbenben.youbenben.instructor.Instructor;
import com.youbenben.youbenben.occupationtype.OccupationType;
import com.youbenben.youbenben.retailstoremember.RetailStoreMember;

import com.youbenben.youbenben.occupationtype.OccupationTypeDAO;
import com.youbenben.youbenben.terminationreason.TerminationReasonDAO;
import com.youbenben.youbenben.salarygrade.SalaryGradeDAO;
import com.youbenben.youbenben.skilltype.SkillTypeDAO;
import com.youbenben.youbenben.retailstoreorder.RetailStoreOrderDAO;
import com.youbenben.youbenben.leavetype.LeaveTypeDAO;
import com.youbenben.youbenben.supplyorder.SupplyOrderDAO;
import com.youbenben.youbenben.transportfleet.TransportFleetDAO;
import com.youbenben.youbenben.responsibilitytype.ResponsibilityTypeDAO;
import com.youbenben.youbenben.employee.EmployeeDAO;
import com.youbenben.youbenben.catalog.CatalogDAO;
import com.youbenben.youbenben.trainingcoursetype.TrainingCourseTypeDAO;
import com.youbenben.youbenben.publicholiday.PublicHolidayDAO;
import com.youbenben.youbenben.levelonedepartment.LevelOneDepartmentDAO;
import com.youbenben.youbenben.retailstoremember.RetailStoreMemberDAO;
import com.youbenben.youbenben.warehouse.WarehouseDAO;
import com.youbenben.youbenben.terminationtype.TerminationTypeDAO;
import com.youbenben.youbenben.retailstore.RetailStoreDAO;
import com.youbenben.youbenben.accountset.AccountSetDAO;
import com.youbenben.youbenben.companytraining.CompanyTrainingDAO;
import com.youbenben.youbenben.interviewtype.InterviewTypeDAO;
import com.youbenben.youbenben.instructor.InstructorDAO;
import com.youbenben.youbenben.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.youbenben.youbenben.goodssupplier.GoodsSupplierDAO;


public interface RetailStoreCountryCenterDAO extends BaseDAO{

	public SmartList<RetailStoreCountryCenter> loadAll();
	public RetailStoreCountryCenter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreCountryCenter> retailStoreCountryCenterList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreCountryCenter present(RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object> options) throws Exception;
	public RetailStoreCountryCenter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreCountryCenter save(RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object> options);
	public SmartList<RetailStoreCountryCenter> saveRetailStoreCountryCenterList(SmartList<RetailStoreCountryCenter> retailStoreCountryCenterList,Map<String,Object> options);
	public SmartList<RetailStoreCountryCenter> removeRetailStoreCountryCenterList(SmartList<RetailStoreCountryCenter> retailStoreCountryCenterList,Map<String,Object> options);
	public SmartList<RetailStoreCountryCenter> findRetailStoreCountryCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreCountryCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreCountryCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreCountryCenterId, int version) throws Exception;
	public RetailStoreCountryCenter disconnectFromAll(String retailStoreCountryCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CatalogDAO getCatalogDAO();
		
	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO();
		
	public RetailStoreDAO getRetailStoreDAO();
		
	public RetailStoreMemberDAO getRetailStoreMemberDAO();
		
	public GoodsSupplierDAO getGoodsSupplierDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	public WarehouseDAO getWarehouseDAO();
		
	public TransportFleetDAO getTransportFleetDAO();
		
	public AccountSetDAO getAccountSetDAO();
		
	public LevelOneDepartmentDAO getLevelOneDepartmentDAO();
		
	public SkillTypeDAO getSkillTypeDAO();
		
	public ResponsibilityTypeDAO getResponsibilityTypeDAO();
		
	public TerminationReasonDAO getTerminationReasonDAO();
		
	public TerminationTypeDAO getTerminationTypeDAO();
		
	public OccupationTypeDAO getOccupationTypeDAO();
		
	public LeaveTypeDAO getLeaveTypeDAO();
		
	public SalaryGradeDAO getSalaryGradeDAO();
		
	public InterviewTypeDAO getInterviewTypeDAO();
		
	public TrainingCourseTypeDAO getTrainingCourseTypeDAO();
		
	public PublicHolidayDAO getPublicHolidayDAO();
		
	public EmployeeDAO getEmployeeDAO();
		
	public InstructorDAO getInstructorDAO();
		
	public CompanyTrainingDAO getCompanyTrainingDAO();
		
	
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForCatalog(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStoreProvinceCenter(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStore(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStoreMember(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForGoodsSupplier(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForSupplyOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStoreOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForWarehouse(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTransportFleet(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForAccountSet(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForLevelOneDepartment(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForSkillType(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForResponsibilityType(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTerminationReason(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTerminationType(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForOccupationType(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForLeaveType(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForSalaryGrade(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForInterviewType(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTrainingCourseType(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForPublicHoliday(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForEmployee(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForInstructor(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForCompanyTraining(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreCountryCenter planToRemoveCatalogList(RetailStoreCountryCenter retailStoreCountryCenter, String catalogIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveRetailStoreProvinceCenterList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreProvinceCenterIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveRetailStoreList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with city_service_center in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreCountryCenter retailStoreCountryCenter, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCityServiceCenter(String retailStoreCountryCenterId, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with creation in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithCreation(RetailStoreCountryCenter retailStoreCountryCenter, String creationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCreation(String retailStoreCountryCenterId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with investment_invitation in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreCountryCenter retailStoreCountryCenter, String investmentInvitationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithInvestmentInvitation(String retailStoreCountryCenterId, String investmentInvitationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with franchising in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithFranchising(RetailStoreCountryCenter retailStoreCountryCenter, String franchisingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithFranchising(String retailStoreCountryCenterId, String franchisingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with decoration in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithDecoration(RetailStoreCountryCenter retailStoreCountryCenter, String decorationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithDecoration(String retailStoreCountryCenterId, String decorationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with opening in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithOpening(RetailStoreCountryCenter retailStoreCountryCenter, String openingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithOpening(String retailStoreCountryCenterId, String openingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with closing in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithClosing(RetailStoreCountryCenter retailStoreCountryCenter, String closingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithClosing(String retailStoreCountryCenterId, String closingId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCountryCenter planToRemoveRetailStoreMemberList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreMemberIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveGoodsSupplierList(RetailStoreCountryCenter retailStoreCountryCenter, String goodsSupplierIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveSupplyOrderList(RetailStoreCountryCenter retailStoreCountryCenter, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with seller in SupplyOrder
	public RetailStoreCountryCenter planToRemoveSupplyOrderListWithSeller(RetailStoreCountryCenter retailStoreCountryCenter, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String retailStoreCountryCenterId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with confirmation in SupplyOrder
	public RetailStoreCountryCenter planToRemoveSupplyOrderListWithConfirmation(RetailStoreCountryCenter retailStoreCountryCenter, String confirmationId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithConfirmation(String retailStoreCountryCenterId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with approval in SupplyOrder
	public RetailStoreCountryCenter planToRemoveSupplyOrderListWithApproval(RetailStoreCountryCenter retailStoreCountryCenter, String approvalId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithApproval(String retailStoreCountryCenterId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with processing in SupplyOrder
	public RetailStoreCountryCenter planToRemoveSupplyOrderListWithProcessing(RetailStoreCountryCenter retailStoreCountryCenter, String processingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithProcessing(String retailStoreCountryCenterId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with picking in SupplyOrder
	public RetailStoreCountryCenter planToRemoveSupplyOrderListWithPicking(RetailStoreCountryCenter retailStoreCountryCenter, String pickingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithPicking(String retailStoreCountryCenterId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with shipment in SupplyOrder
	public RetailStoreCountryCenter planToRemoveSupplyOrderListWithShipment(RetailStoreCountryCenter retailStoreCountryCenter, String shipmentId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithShipment(String retailStoreCountryCenterId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with delivery in SupplyOrder
	public RetailStoreCountryCenter planToRemoveSupplyOrderListWithDelivery(RetailStoreCountryCenter retailStoreCountryCenter, String deliveryId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithDelivery(String retailStoreCountryCenterId, String deliveryId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with buyer in RetailStoreOrder
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderListWithBuyer(RetailStoreCountryCenter retailStoreCountryCenter, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreCountryCenterId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with confirmation in RetailStoreOrder
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderListWithConfirmation(RetailStoreCountryCenter retailStoreCountryCenter, String confirmationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithConfirmation(String retailStoreCountryCenterId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with approval in RetailStoreOrder
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderListWithApproval(RetailStoreCountryCenter retailStoreCountryCenter, String approvalId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithApproval(String retailStoreCountryCenterId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with processing in RetailStoreOrder
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderListWithProcessing(RetailStoreCountryCenter retailStoreCountryCenter, String processingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithProcessing(String retailStoreCountryCenterId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with picking in RetailStoreOrder
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderListWithPicking(RetailStoreCountryCenter retailStoreCountryCenter, String pickingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithPicking(String retailStoreCountryCenterId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with shipment in RetailStoreOrder
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderListWithShipment(RetailStoreCountryCenter retailStoreCountryCenter, String shipmentId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithShipment(String retailStoreCountryCenterId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with delivery in RetailStoreOrder
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderListWithDelivery(RetailStoreCountryCenter retailStoreCountryCenter, String deliveryId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithDelivery(String retailStoreCountryCenterId, String deliveryId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCountryCenter planToRemoveWarehouseList(RetailStoreCountryCenter retailStoreCountryCenter, String warehouseIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveTransportFleetList(RetailStoreCountryCenter retailStoreCountryCenter, String transportFleetIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveAccountSetList(RetailStoreCountryCenter retailStoreCountryCenter, String accountSetIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with retail_store in AccountSet
	public RetailStoreCountryCenter planToRemoveAccountSetListWithRetailStore(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countAccountSetListWithRetailStore(String retailStoreCountryCenterId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with goods_supplier in AccountSet
	public RetailStoreCountryCenter planToRemoveAccountSetListWithGoodsSupplier(RetailStoreCountryCenter retailStoreCountryCenter, String goodsSupplierId, Map<String,Object> options)throws Exception;
	public int countAccountSetListWithGoodsSupplier(String retailStoreCountryCenterId, String goodsSupplierId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCountryCenter planToRemoveLevelOneDepartmentList(RetailStoreCountryCenter retailStoreCountryCenter, String levelOneDepartmentIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveSkillTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String skillTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveResponsibilityTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String responsibilityTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveTerminationReasonList(RetailStoreCountryCenter retailStoreCountryCenter, String terminationReasonIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveTerminationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String terminationTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveOccupationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String occupationTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveLeaveTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String leaveTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveSalaryGradeList(RetailStoreCountryCenter retailStoreCountryCenter, String salaryGradeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveInterviewTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String interviewTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveTrainingCourseTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String trainingCourseTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemovePublicHolidayList(RetailStoreCountryCenter retailStoreCountryCenter, String publicHolidayIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveEmployeeList(RetailStoreCountryCenter retailStoreCountryCenter, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with department in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithDepartment(RetailStoreCountryCenter retailStoreCountryCenter, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String retailStoreCountryCenterId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with occupation in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithOccupation(RetailStoreCountryCenter retailStoreCountryCenter, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String retailStoreCountryCenterId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with responsible_for in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithResponsibleFor(RetailStoreCountryCenter retailStoreCountryCenter, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String retailStoreCountryCenterId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with current_salary_grade in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithCurrentSalaryGrade(RetailStoreCountryCenter retailStoreCountryCenter, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String retailStoreCountryCenterId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with job_application in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithJobApplication(RetailStoreCountryCenter retailStoreCountryCenter, String jobApplicationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithJobApplication(String retailStoreCountryCenterId, String jobApplicationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with profession_interview in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithProfessionInterview(RetailStoreCountryCenter retailStoreCountryCenter, String professionInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithProfessionInterview(String retailStoreCountryCenterId, String professionInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with hr_interview in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithHrInterview(RetailStoreCountryCenter retailStoreCountryCenter, String hrInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithHrInterview(String retailStoreCountryCenterId, String hrInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with offer_approval in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithOfferApproval(RetailStoreCountryCenter retailStoreCountryCenter, String offerApprovalId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferApproval(String retailStoreCountryCenterId, String offerApprovalId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with offer_acceptance in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithOfferAcceptance(RetailStoreCountryCenter retailStoreCountryCenter, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferAcceptance(String retailStoreCountryCenterId, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with employee_boarding in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithEmployeeBoarding(RetailStoreCountryCenter retailStoreCountryCenter, String employeeBoardingId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithEmployeeBoarding(String retailStoreCountryCenterId, String employeeBoardingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with termination in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithTermination(RetailStoreCountryCenter retailStoreCountryCenter, String terminationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithTermination(String retailStoreCountryCenterId, String terminationId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCountryCenter planToRemoveInstructorList(RetailStoreCountryCenter retailStoreCountryCenter, String instructorIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveCompanyTrainingList(RetailStoreCountryCenter retailStoreCountryCenter, String companyTrainingIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with instructor in CompanyTraining
	public RetailStoreCountryCenter planToRemoveCompanyTrainingListWithInstructor(RetailStoreCountryCenter retailStoreCountryCenter, String instructorId, Map<String,Object> options)throws Exception;
	public int countCompanyTrainingListWithInstructor(String retailStoreCountryCenterId, String instructorId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with training_course_type in CompanyTraining
	public RetailStoreCountryCenter planToRemoveCompanyTrainingListWithTrainingCourseType(RetailStoreCountryCenter retailStoreCountryCenter, String trainingCourseTypeId, Map<String,Object> options)throws Exception;
	public int countCompanyTrainingListWithTrainingCourseType(String retailStoreCountryCenterId, String trainingCourseTypeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreCountryCenter> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreCountryCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:Catalog的owner的CatalogList
	public SmartList<Catalog> loadOurCatalogList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreProvinceCenter的country的RetailStoreProvinceCenterList
	public SmartList<RetailStoreProvinceCenter> loadOurRetailStoreProvinceCenterList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStore的retailStoreCountryCenter的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMember的owner的RetailStoreMemberList
	public SmartList<RetailStoreMember> loadOurRetailStoreMemberList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:GoodsSupplier的belongTo的GoodsSupplierList
	public SmartList<GoodsSupplier> loadOurGoodsSupplierList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的buyer的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的seller的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Warehouse的owner的WarehouseList
	public SmartList<Warehouse> loadOurWarehouseList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TransportFleet的owner的TransportFleetList
	public SmartList<TransportFleet> loadOurTransportFleetList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:AccountSet的countryCenter的AccountSetList
	public SmartList<AccountSet> loadOurAccountSetList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:LevelOneDepartment的belongsTo的LevelOneDepartmentList
	public SmartList<LevelOneDepartment> loadOurLevelOneDepartmentList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SkillType的company的SkillTypeList
	public SmartList<SkillType> loadOurSkillTypeList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ResponsibilityType的company的ResponsibilityTypeList
	public SmartList<ResponsibilityType> loadOurResponsibilityTypeList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TerminationReason的company的TerminationReasonList
	public SmartList<TerminationReason> loadOurTerminationReasonList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TerminationType的company的TerminationTypeList
	public SmartList<TerminationType> loadOurTerminationTypeList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:OccupationType的company的OccupationTypeList
	public SmartList<OccupationType> loadOurOccupationTypeList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:LeaveType的company的LeaveTypeList
	public SmartList<LeaveType> loadOurLeaveTypeList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SalaryGrade的company的SalaryGradeList
	public SmartList<SalaryGrade> loadOurSalaryGradeList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:InterviewType的company的InterviewTypeList
	public SmartList<InterviewType> loadOurInterviewTypeList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TrainingCourseType的company的TrainingCourseTypeList
	public SmartList<TrainingCourseType> loadOurTrainingCourseTypeList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PublicHoliday的company的PublicHolidayList
	public SmartList<PublicHoliday> loadOurPublicHolidayList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Employee的company的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Instructor的company的InstructorList
	public SmartList<Instructor> loadOurInstructorList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:CompanyTraining的company的CompanyTrainingList
	public SmartList<CompanyTraining> loadOurCompanyTrainingList(YoubenbenUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
}


