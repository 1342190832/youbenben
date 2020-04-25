
package com.youbenben.youbenben.terminationtype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface TerminationTypeManager extends BaseManager{

		

	public TerminationType createTerminationType(YoubenbenUserContext userContext, String code,String companyId,String baseDescription,String detailDescription) throws Exception;
	public TerminationType updateTerminationType(YoubenbenUserContext userContext,String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TerminationType loadTerminationType(YoubenbenUserContext userContext, String terminationTypeId, String [] tokensExpr) throws Exception;
	public TerminationType internalSaveTerminationType(YoubenbenUserContext userContext, TerminationType terminationType) throws Exception;
	public TerminationType internalSaveTerminationType(YoubenbenUserContext userContext, TerminationType terminationType,Map<String,Object>option) throws Exception;

	public TerminationType transferToAnotherCompany(YoubenbenUserContext userContext, String terminationTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String terminationTypeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, TerminationType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  TerminationManager getTerminationManager(YoubenbenUserContext userContext, String terminationTypeId, String reasonId, String comment ,String [] tokensExpr)  throws Exception;

	public  TerminationType addTermination(YoubenbenUserContext userContext, String terminationTypeId, String reasonId, String comment , String [] tokensExpr)  throws Exception;
	public  TerminationType removeTermination(YoubenbenUserContext userContext, String terminationTypeId, String terminationId, int terminationVersion,String [] tokensExpr)  throws Exception;
	public  TerminationType updateTermination(YoubenbenUserContext userContext, String terminationTypeId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


