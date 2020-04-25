
package com.youbenben.youbenben.jobapplication;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.youbenben.youbenben.*;
import com.youbenben.youbenben.tree.*;
import com.youbenben.youbenben.treenode.*;
import com.youbenben.youbenben.YoubenbenUserContextImpl;
import com.youbenben.youbenben.iamservice.*;
import com.youbenben.youbenben.services.IamService;
import com.youbenben.youbenben.secuser.SecUser;
import com.youbenben.youbenben.userapp.UserApp;
import com.youbenben.youbenben.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.youbenben.youbenben.employee.Employee;


import com.youbenben.youbenben.employeeboarding.EmployeeBoarding;
import com.youbenben.youbenben.hrinterview.HrInterview;
import com.youbenben.youbenben.termination.Termination;
import com.youbenben.youbenben.salarygrade.SalaryGrade;
import com.youbenben.youbenben.jobapplication.JobApplication;
import com.youbenben.youbenben.offerapproval.OfferApproval;
import com.youbenben.youbenben.offeracceptance.OfferAcceptance;
import com.youbenben.youbenben.responsibilitytype.ResponsibilityType;
import com.youbenben.youbenben.levelthreedepartment.LevelThreeDepartment;
import com.youbenben.youbenben.occupationtype.OccupationType;
import com.youbenben.youbenben.professioninterview.ProfessionInterview;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;






public class JobApplicationManagerImpl extends CustomYoubenbenCheckerManager implements JobApplicationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = JobApplicationTokens.start().withTokenFromListName(listName).done();
		JobApplication  jobApplication = (JobApplication) this.loadJobApplication(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = jobApplication.collectRefercencesFromLists();
		jobApplicationDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, jobApplication, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new JobApplicationGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "JobApplication";
	@Override
	public JobApplicationDAO daoOf(YoubenbenUserContext userContext) {
		return jobApplicationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws JobApplicationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new JobApplicationManagerException(message);

	}



 	protected JobApplication saveJobApplication(YoubenbenUserContext userContext, JobApplication jobApplication, String [] tokensExpr) throws Exception{	
 		//return getJobApplicationDAO().save(jobApplication, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveJobApplication(userContext, jobApplication, tokens);
 	}
 	
 	protected JobApplication saveJobApplicationDetail(YoubenbenUserContext userContext, JobApplication jobApplication) throws Exception{	

 		
 		return saveJobApplication(userContext, jobApplication, allTokens());
 	}
 	
 	public JobApplication loadJobApplication(YoubenbenUserContext userContext, String jobApplicationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfJobApplication(jobApplicationId);
		checkerOf(userContext).throwExceptionIfHasErrors( JobApplicationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,jobApplication, tokens);
 	}
 	
 	
 	 public JobApplication searchJobApplication(YoubenbenUserContext userContext, String jobApplicationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfJobApplication(jobApplicationId);
		checkerOf(userContext).throwExceptionIfHasErrors( JobApplicationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,jobApplication, tokens);
 	}
 	
 	

 	protected JobApplication present(YoubenbenUserContext userContext, JobApplication jobApplication, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,jobApplication,tokens);
		
		
		JobApplication  jobApplicationToPresent = jobApplicationDaoOf(userContext).present(jobApplication, tokens);
		
		List<BaseEntity> entityListToNaming = jobApplicationToPresent.collectRefercencesFromLists();
		jobApplicationDaoOf(userContext).alias(entityListToNaming);
		
		return  jobApplicationToPresent;
		
		
	}
 
 	
 	
 	public JobApplication loadJobApplicationDetail(YoubenbenUserContext userContext, String jobApplicationId) throws Exception{	
 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, allTokens());
 		return present(userContext,jobApplication, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String jobApplicationId) throws Exception{	
 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, viewTokens());
 		return present(userContext,jobApplication, allTokens());
		
 	}
 	protected JobApplication saveJobApplication(YoubenbenUserContext userContext, JobApplication jobApplication, Map<String,Object>tokens) throws Exception{	
 		return jobApplicationDaoOf(userContext).save(jobApplication, tokens);
 	}
 	protected JobApplication loadJobApplication(YoubenbenUserContext userContext, String jobApplicationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfJobApplication(jobApplicationId);
		checkerOf(userContext).throwExceptionIfHasErrors( JobApplicationManagerException.class);

 
 		return jobApplicationDaoOf(userContext).load(jobApplicationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, JobApplication jobApplication, Map<String, Object> tokens){
		super.addActions(userContext, jobApplication, tokens);
		
		addAction(userContext, jobApplication, tokens,"@create","createJobApplication","createJobApplication/","main","primary");
		addAction(userContext, jobApplication, tokens,"@update","updateJobApplication","updateJobApplication/"+jobApplication.getId()+"/","main","primary");
		addAction(userContext, jobApplication, tokens,"@copy","cloneJobApplication","cloneJobApplication/"+jobApplication.getId()+"/","main","primary");
		
		addAction(userContext, jobApplication, tokens,"job_application.addEmployee","addEmployee","addEmployee/"+jobApplication.getId()+"/","employeeList","primary");
		addAction(userContext, jobApplication, tokens,"job_application.removeEmployee","removeEmployee","removeEmployee/"+jobApplication.getId()+"/","employeeList","primary");
		addAction(userContext, jobApplication, tokens,"job_application.updateEmployee","updateEmployee","updateEmployee/"+jobApplication.getId()+"/","employeeList","primary");
		addAction(userContext, jobApplication, tokens,"job_application.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+jobApplication.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, JobApplication jobApplication, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public JobApplication createJobApplication(YoubenbenUserContext userContext, Date applicationTime,String who,String comments) throws Exception
	//public JobApplication createJobApplication(YoubenbenUserContext userContext,Date applicationTime, String who, String comments) throws Exception
	{

		

		

		checkerOf(userContext).checkApplicationTimeOfJobApplication(applicationTime);
		checkerOf(userContext).checkWhoOfJobApplication(who);
		checkerOf(userContext).checkCommentsOfJobApplication(comments);
	
		checkerOf(userContext).throwExceptionIfHasErrors(JobApplicationManagerException.class);


		JobApplication jobApplication=createNewJobApplication();	

		jobApplication.setApplicationTime(applicationTime);
		jobApplication.setWho(who);
		jobApplication.setComments(comments);

		jobApplication = saveJobApplication(userContext, jobApplication, emptyOptions());
		
		onNewInstanceCreated(userContext, jobApplication);
		return jobApplication;


	}
	protected JobApplication createNewJobApplication()
	{

		return new JobApplication();
	}

	protected void checkParamsForUpdatingJobApplication(YoubenbenUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfJobApplication(jobApplicationId);
		checkerOf(userContext).checkVersionOfJobApplication( jobApplicationVersion);
		

		if(JobApplication.APPLICATION_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkApplicationTimeOfJobApplication(parseDate(newValueExpr));
		
			
		}
		if(JobApplication.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfJobApplication(parseString(newValueExpr));
		
			
		}
		if(JobApplication.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfJobApplication(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(JobApplicationManagerException.class);


	}



	public JobApplication clone(YoubenbenUserContext userContext, String fromJobApplicationId) throws Exception{

		return jobApplicationDaoOf(userContext).clone(fromJobApplicationId, this.allTokens());
	}

	public JobApplication internalSaveJobApplication(YoubenbenUserContext userContext, JobApplication jobApplication) throws Exception
	{
		return internalSaveJobApplication(userContext, jobApplication, allTokens());

	}
	public JobApplication internalSaveJobApplication(YoubenbenUserContext userContext, JobApplication jobApplication, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingJobApplication(userContext, jobApplicationId, jobApplicationVersion, property, newValueExpr, tokensExpr);


		synchronized(jobApplication){
			//will be good when the jobApplication loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to JobApplication.
			if (jobApplication.isChanged()){
			
			}
			jobApplication = saveJobApplication(userContext, jobApplication, options);
			return jobApplication;

		}

	}

	public JobApplication updateJobApplication(YoubenbenUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingJobApplication(userContext, jobApplicationId, jobApplicationVersion, property, newValueExpr, tokensExpr);



		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		if(jobApplication.getVersion() != jobApplicationVersion){
			String message = "The target version("+jobApplication.getVersion()+") is not equals to version("+jobApplicationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(jobApplication){
			//will be good when the jobApplication loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to JobApplication.
			
			jobApplication.changeProperty(property, newValueExpr);
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
			//return saveJobApplication(userContext, jobApplication, tokens().done());
		}

	}

	public JobApplication updateJobApplicationProperty(YoubenbenUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingJobApplication(userContext, jobApplicationId, jobApplicationVersion, property, newValueExpr, tokensExpr);

		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		if(jobApplication.getVersion() != jobApplicationVersion){
			String message = "The target version("+jobApplication.getVersion()+") is not equals to version("+jobApplicationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(jobApplication){
			//will be good when the jobApplication loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to JobApplication.

			jobApplication.changeProperty(property, newValueExpr);
			
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
			//return saveJobApplication(userContext, jobApplication, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected JobApplicationTokens tokens(){
		return JobApplicationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return JobApplicationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return JobApplicationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String jobApplicationId, int jobApplicationVersion) throws Exception {
		//deleteInternal(userContext, jobApplicationId, jobApplicationVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String jobApplicationId, int jobApplicationVersion) throws Exception{

		jobApplicationDaoOf(userContext).delete(jobApplicationId, jobApplicationVersion);
	}

	public JobApplication forgetByAll(YoubenbenUserContext userContext, String jobApplicationId, int jobApplicationVersion) throws Exception {
		return forgetByAllInternal(userContext, jobApplicationId, jobApplicationVersion);
	}
	protected JobApplication forgetByAllInternal(YoubenbenUserContext userContext,
			String jobApplicationId, int jobApplicationVersion) throws Exception{

		return jobApplicationDaoOf(userContext).disconnectFromAll(jobApplicationId, jobApplicationVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new JobApplicationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return jobApplicationDaoOf(userContext).deleteAll();
	}


	//disconnect JobApplication with company in Employee
	protected JobApplication breakWithEmployeeByCompany(YoubenbenUserContext userContext, String jobApplicationId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithCompany(jobApplication, companyId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with department in Employee
	protected JobApplication breakWithEmployeeByDepartment(YoubenbenUserContext userContext, String jobApplicationId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithDepartment(jobApplication, departmentId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with occupation in Employee
	protected JobApplication breakWithEmployeeByOccupation(YoubenbenUserContext userContext, String jobApplicationId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithOccupation(jobApplication, occupationId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with responsible_for in Employee
	protected JobApplication breakWithEmployeeByResponsibleFor(YoubenbenUserContext userContext, String jobApplicationId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(jobApplication, responsibleForId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with current_salary_grade in Employee
	protected JobApplication breakWithEmployeeByCurrentSalaryGrade(YoubenbenUserContext userContext, String jobApplicationId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(jobApplication, currentSalaryGradeId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with profession_interview in Employee
	protected JobApplication breakWithEmployeeByProfessionInterview(YoubenbenUserContext userContext, String jobApplicationId, String professionInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithProfessionInterview(jobApplication, professionInterviewId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with hr_interview in Employee
	protected JobApplication breakWithEmployeeByHrInterview(YoubenbenUserContext userContext, String jobApplicationId, String hrInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithHrInterview(jobApplication, hrInterviewId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with offer_approval in Employee
	protected JobApplication breakWithEmployeeByOfferApproval(YoubenbenUserContext userContext, String jobApplicationId, String offerApprovalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithOfferApproval(jobApplication, offerApprovalId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with offer_acceptance in Employee
	protected JobApplication breakWithEmployeeByOfferAcceptance(YoubenbenUserContext userContext, String jobApplicationId, String offerAcceptanceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithOfferAcceptance(jobApplication, offerAcceptanceId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with employee_boarding in Employee
	protected JobApplication breakWithEmployeeByEmployeeBoarding(YoubenbenUserContext userContext, String jobApplicationId, String employeeBoardingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithEmployeeBoarding(jobApplication, employeeBoardingId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with termination in Employee
	protected JobApplication breakWithEmployeeByTermination(YoubenbenUserContext userContext, String jobApplicationId, String terminationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				jobApplicationDaoOf(userContext).planToRemoveEmployeeListWithTermination(jobApplication, terminationId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}






	protected void checkParamsForAddingEmployee(YoubenbenUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfJobApplication(jobApplicationId);

		
		checkerOf(userContext).checkCompanyIdOfEmployee(companyId);
		
		checkerOf(userContext).checkTitleOfEmployee(title);
		
		checkerOf(userContext).checkDepartmentIdOfEmployee(departmentId);
		
		checkerOf(userContext).checkFamilyNameOfEmployee(familyName);
		
		checkerOf(userContext).checkGivenNameOfEmployee(givenName);
		
		checkerOf(userContext).checkEmailOfEmployee(email);
		
		checkerOf(userContext).checkCityOfEmployee(city);
		
		checkerOf(userContext).checkAddressOfEmployee(address);
		
		checkerOf(userContext).checkCellPhoneOfEmployee(cellPhone);
		
		checkerOf(userContext).checkOccupationIdOfEmployee(occupationId);
		
		checkerOf(userContext).checkResponsibleForIdOfEmployee(responsibleForId);
		
		checkerOf(userContext).checkCurrentSalaryGradeIdOfEmployee(currentSalaryGradeId);
		
		checkerOf(userContext).checkSalaryAccountOfEmployee(salaryAccount);
		
		checkerOf(userContext).checkProfessionInterviewIdOfEmployee(professionInterviewId);
		
		checkerOf(userContext).checkHrInterviewIdOfEmployee(hrInterviewId);
		
		checkerOf(userContext).checkOfferApprovalIdOfEmployee(offerApprovalId);
		
		checkerOf(userContext).checkOfferAcceptanceIdOfEmployee(offerAcceptanceId);
		
		checkerOf(userContext).checkEmployeeBoardingIdOfEmployee(employeeBoardingId);
		
		checkerOf(userContext).checkTerminationIdOfEmployee(terminationId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(JobApplicationManagerException.class);


	}
	public  JobApplication addEmployee(YoubenbenUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,jobApplicationId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId);

		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, emptyOptions());
		synchronized(jobApplication){
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			jobApplication.addEmployee( employee );
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(YoubenbenUserContext userContext, String jobApplicationId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfJobApplication(jobApplicationId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(JobApplicationManagerException.class);

	}
	public  JobApplication updateEmployeeProperties(YoubenbenUserContext userContext, String jobApplicationId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,jobApplicationId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		JobApplication jobApplicationToUpdate = loadJobApplication(userContext, jobApplicationId, options);

		if(jobApplicationToUpdate.getEmployeeList().isEmpty()){
			throw new JobApplicationManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = jobApplicationToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,jobApplicationId,name, code, used,tokensExpr);
		JobApplication jobApplication = saveJobApplication(userContext, jobApplicationToUpdate, tokens().withEmployeeList().done());
		synchronized(jobApplication){
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(YoubenbenUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId) throws Exception{

		Employee employee = new Employee();
		
		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		employee.setCompany(company);		
		employee.setTitle(title);		
		LevelThreeDepartment  department = new LevelThreeDepartment();
		department.setId(departmentId);		
		employee.setDepartment(department);		
		employee.setFamilyName(familyName);		
		employee.setGivenName(givenName);		
		employee.setEmail(email);		
		employee.setCity(city);		
		employee.setAddress(address);		
		employee.setCellPhone(cellPhone);		
		OccupationType  occupation = new OccupationType();
		occupation.setId(occupationId);		
		employee.setOccupation(occupation);		
		ResponsibilityType  responsibleFor = new ResponsibilityType();
		responsibleFor.setId(responsibleForId);		
		employee.setResponsibleFor(responsibleFor);		
		SalaryGrade  currentSalaryGrade = new SalaryGrade();
		currentSalaryGrade.setId(currentSalaryGradeId);		
		employee.setCurrentSalaryGrade(currentSalaryGrade);		
		employee.setSalaryAccount(salaryAccount);		
		ProfessionInterview  professionInterview = new ProfessionInterview();
		professionInterview.setId(professionInterviewId);		
		employee.setProfessionInterview(professionInterview);		
		HrInterview  hrInterview = new HrInterview();
		hrInterview.setId(hrInterviewId);		
		employee.setHrInterview(hrInterview);		
		OfferApproval  offerApproval = new OfferApproval();
		offerApproval.setId(offerApprovalId);		
		employee.setOfferApproval(offerApproval);		
		OfferAcceptance  offerAcceptance = new OfferAcceptance();
		offerAcceptance.setId(offerAcceptanceId);		
		employee.setOfferAcceptance(offerAcceptance);		
		EmployeeBoarding  employeeBoarding = new EmployeeBoarding();
		employeeBoarding.setId(employeeBoardingId);		
		employee.setEmployeeBoarding(employeeBoarding);		
		Termination  termination = new Termination();
		termination.setId(terminationId);		
		employee.setTermination(termination);		
		employee.setLastUpdateTime(userContext.now());
	
		
		return employee;


	}

	protected Employee createIndexedEmployee(String id, int version){

		Employee employee = new Employee();
		employee.setId(id);
		employee.setVersion(version);
		return employee;

	}

	protected void checkParamsForRemovingEmployeeList(YoubenbenUserContext userContext, String jobApplicationId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfJobApplication(jobApplicationId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(JobApplicationManagerException.class);

	}
	public  JobApplication removeEmployeeList(YoubenbenUserContext userContext, String jobApplicationId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, jobApplicationId,  employeeIds, tokensExpr);


			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
			synchronized(jobApplication){
				//Will be good when the jobApplication loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				jobApplicationDaoOf(userContext).planToRemoveEmployeeList(jobApplication, employeeIds, allTokens());
				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, jobApplication.getEmployeeList());
				return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(YoubenbenUserContext userContext, String jobApplicationId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfJobApplication( jobApplicationId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(JobApplicationManagerException.class);

	}
	public  JobApplication removeEmployee(YoubenbenUserContext userContext, String jobApplicationId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,jobApplicationId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		synchronized(jobApplication){
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			jobApplication.removeEmployee( employee );
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(YoubenbenUserContext userContext, String jobApplicationId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfJobApplication( jobApplicationId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(JobApplicationManagerException.class);

	}
	public  JobApplication copyEmployeeFrom(YoubenbenUserContext userContext, String jobApplicationId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,jobApplicationId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		synchronized(jobApplication){
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			jobApplication.copyEmployeeFrom( employee );
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)jobApplication.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(YoubenbenUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfJobApplication(jobApplicationId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		

		if(Employee.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.FAMILY_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFamilyNameOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.GIVEN_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkGivenNameOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.CITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCityOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.ADDRESS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAddressOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.CELL_PHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCellPhoneOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.SALARY_ACCOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSalaryAccountOfEmployee(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(JobApplicationManagerException.class);

	}

	public  JobApplication updateEmployee(YoubenbenUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, jobApplicationId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, loadTokens);

		synchronized(jobApplication){
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//jobApplication.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = jobApplication.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new JobApplicationManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, JobApplication newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(YoubenbenUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(YoubenbenUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(YoubenbenUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(YoubenbenUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(YoubenbenUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		YoubenbenUserContextImpl userContext = (YoubenbenUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(YoubenbenUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(YoubenbenUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(YoubenbenUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   JobApplication newJobApplication = this.createJobApplication(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newJobApplication
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, JobApplication.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((YoubenbenBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<JobApplication> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String jobApplicationId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getJobApplicationDetailScope().clone();
		JobApplication merchantObj = (JobApplication) this.view(userContext, jobApplicationId);
    String merchantObjId = jobApplicationId;
    String linkToUrl =	"jobApplicationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "工作申请"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-applicationTime")
				    .put("fieldName", "applicationTime")
				    .put("label", "申请时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("applicationTime", merchantObj.getApplicationTime());

		propList.add(
				MapUtil.put("id", "3-who")
				    .put("fieldName", "who")
				    .put("label", "谁")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("who", merchantObj.getWho());

		propList.add(
				MapUtil.put("id", "4-comments")
				    .put("fieldName", "comments")
				    .put("label", "评论")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("comments", merchantObj.getComments());

		//处理 sectionList

		//处理Section：employeeListSection
		Map employeeListSection = ListofUtils.buildSection(
		    "employeeListSection",
		    "员工列表",
		    null,
		    "",
		    "__no_group",
		    "employeeManager/listByJobApplication/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeListSection);

		result.put("employeeListSection", ListofUtils.toShortList(merchantObj.getEmployeeList(), "employee"));
		vscope.field("employeeListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( Employee.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


