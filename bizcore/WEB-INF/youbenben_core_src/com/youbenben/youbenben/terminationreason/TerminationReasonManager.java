
package com.youbenben.youbenben.terminationreason;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface TerminationReasonManager extends BaseManager{

		

	public TerminationReason createTerminationReason(YoubenbenUserContext userContext, String code,String companyId,String description) throws Exception;
	public TerminationReason updateTerminationReason(YoubenbenUserContext userContext,String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TerminationReason loadTerminationReason(YoubenbenUserContext userContext, String terminationReasonId, String [] tokensExpr) throws Exception;
	public TerminationReason internalSaveTerminationReason(YoubenbenUserContext userContext, TerminationReason terminationReason) throws Exception;
	public TerminationReason internalSaveTerminationReason(YoubenbenUserContext userContext, TerminationReason terminationReason,Map<String,Object>option) throws Exception;

	public TerminationReason transferToAnotherCompany(YoubenbenUserContext userContext, String terminationReasonId, String anotherCompanyId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String terminationReasonId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, TerminationReason newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  TerminationManager getTerminationManager(YoubenbenUserContext userContext, String terminationReasonId, String typeId, String comment ,String [] tokensExpr)  throws Exception;

	public  TerminationReason addTermination(YoubenbenUserContext userContext, String terminationReasonId, String typeId, String comment , String [] tokensExpr)  throws Exception;
	public  TerminationReason removeTermination(YoubenbenUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion,String [] tokensExpr)  throws Exception;
	public  TerminationReason updateTermination(YoubenbenUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


