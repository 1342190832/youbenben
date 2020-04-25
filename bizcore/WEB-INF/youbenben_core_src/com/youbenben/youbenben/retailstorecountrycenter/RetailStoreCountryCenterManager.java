
package com.youbenben.youbenben.retailstorecountrycenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreCountryCenterManager extends BaseManager{

		

	public RetailStoreCountryCenter createRetailStoreCountryCenter(YoubenbenUserContext userContext, String name,String serviceNumber,Date founded,String webSite,String address,String operatedBy,String legalRepresentative,String description) throws Exception;
	public RetailStoreCountryCenter updateRetailStoreCountryCenter(YoubenbenUserContext userContext,String retailStoreCountryCenterId, int retailStoreCountryCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreCountryCenter loadRetailStoreCountryCenter(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String [] tokensExpr) throws Exception;
	public RetailStoreCountryCenter internalSaveRetailStoreCountryCenter(YoubenbenUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter) throws Exception;
	public RetailStoreCountryCenter internalSaveRetailStoreCountryCenter(YoubenbenUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreCountryCenterId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreCountryCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CatalogManager getCatalogManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, int subCount, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addCatalog(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, int subCount, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeCatalog(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String catalogId, int catalogVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateCatalog(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreProvinceCenterManager getRetailStoreProvinceCenterManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, Date founded ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addRetailStoreProvinceCenter(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, Date founded , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStoreProvinceCenter(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStoreProvinceCenter(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreManager getRetailStoreManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String telephone, String owner, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addRetailStore(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String telephone, String owner, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStore(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStore(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreMemberManager getRetailStoreMemberManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String mobilePhone ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addRetailStoreMember(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String mobilePhone , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStoreMember(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStoreMember(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  GoodsSupplierManager getGoodsSupplierManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String supplyProduct, String contactNumber, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addGoodsSupplier(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String supplyProduct, String contactNumber, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeGoodsSupplier(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateGoodsSupplier(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addSupplyOrder(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeSupplyOrder(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateSupplyOrder(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreOrderManager getRetailStoreOrderManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String buyerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String buyerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WarehouseManager getWarehouseManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addWarehouse(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeWarehouse(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String warehouseId, int warehouseVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateWarehouse(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportFleetManager getTransportFleetManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String contactNumber ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addTransportFleet(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String contactNumber , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTransportFleet(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String transportFleetId, int transportFleetVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTransportFleet(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountSetManager getAccountSetManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addAccountSet(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeAccountSet(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String accountSetId, int accountSetVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateAccountSet(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LevelOneDepartmentManager getLevelOneDepartmentManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String description, String manager, Date founded ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addLevelOneDepartment(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String name, String description, String manager, Date founded , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeLevelOneDepartment(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateLevelOneDepartment(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SkillTypeManager getSkillTypeManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addSkillType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeSkillType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String skillTypeId, int skillTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateSkillType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ResponsibilityTypeManager getResponsibilityTypeManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addResponsibilityType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeResponsibilityType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateResponsibilityType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TerminationReasonManager getTerminationReasonManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addTerminationReason(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTerminationReason(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String terminationReasonId, int terminationReasonVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTerminationReason(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TerminationTypeManager getTerminationTypeManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addTerminationType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTerminationType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String terminationTypeId, int terminationTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTerminationType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  OccupationTypeManager getOccupationTypeManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addOccupationType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeOccupationType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String occupationTypeId, int occupationTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateOccupationType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LeaveTypeManager getLeaveTypeManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addLeaveType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeLeaveType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String leaveTypeId, int leaveTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateLeaveType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SalaryGradeManager getSalaryGradeManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String name, String detailDescription ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addSalaryGrade(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String name, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeSalaryGrade(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String salaryGradeId, int salaryGradeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateSalaryGrade(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  InterviewTypeManager getInterviewTypeManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addInterviewType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeInterviewType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String interviewTypeId, int interviewTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateInterviewType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TrainingCourseTypeManager getTrainingCourseTypeManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addTrainingCourseType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTrainingCourseType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTrainingCourseType(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PublicHolidayManager getPublicHolidayManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addPublicHoliday(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removePublicHoliday(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String publicHolidayId, int publicHolidayVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updatePublicHoliday(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addEmployee(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeEmployee(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateEmployee(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  InstructorManager getInstructorManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String title, String familyName, String givenName, String cellPhone, String email, String introduction ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addInstructor(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String title, String familyName, String givenName, String cellPhone, String email, String introduction , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeInstructor(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String instructorId, int instructorVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateInstructor(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CompanyTrainingManager getCompanyTrainingManager(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addCompanyTraining(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeCompanyTraining(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String companyTrainingId, int companyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateCompanyTraining(YoubenbenUserContext userContext, String retailStoreCountryCenterId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


