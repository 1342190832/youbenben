
package com.xingyou.xingyou.candidateelement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface CandidateElementManager extends BaseManager{

		

	public CandidateElement createCandidateElement(XingyouUserContext userContext, String name,String type,String image,String containerId) throws Exception;
	public CandidateElement updateCandidateElement(XingyouUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateElement loadCandidateElement(XingyouUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception;
	public CandidateElement internalSaveCandidateElement(XingyouUserContext userContext, CandidateElement candidateElement) throws Exception;
	public CandidateElement internalSaveCandidateElement(XingyouUserContext userContext, CandidateElement candidateElement,Map<String,Object>option) throws Exception;

	public CandidateElement transferToAnotherContainer(XingyouUserContext userContext, String candidateElementId, String anotherContainerId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String candidateElementId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, CandidateElement newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByContainer(XingyouUserContext userContext,String containerId) throws Exception;
	public Object listPageByContainer(XingyouUserContext userContext,String containerId, int start, int count) throws Exception;
  

}


