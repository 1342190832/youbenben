
package com.xingyou.xingyou.candidatecontainer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface CandidateContainerManager extends BaseManager{

		

	public CandidateContainer createCandidateContainer(XingyouUserContext userContext, String name) throws Exception;
	public CandidateContainer updateCandidateContainer(XingyouUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateContainer loadCandidateContainer(XingyouUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(XingyouUserContext userContext, CandidateContainer candidateContainer) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(XingyouUserContext userContext, CandidateContainer candidateContainer,Map<String,Object>option) throws Exception;



	public void delete(XingyouUserContext userContext, String candidateContainerId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, CandidateContainer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CandidateElementManager getCandidateElementManager(XingyouUserContext userContext, String candidateContainerId, String name, String type, String image ,String [] tokensExpr)  throws Exception;

	public  CandidateContainer addCandidateElement(XingyouUserContext userContext, String candidateContainerId, String name, String type, String image , String [] tokensExpr)  throws Exception;
	public  CandidateContainer removeCandidateElement(XingyouUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion,String [] tokensExpr)  throws Exception;
	public  CandidateContainer updateCandidateElement(XingyouUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


