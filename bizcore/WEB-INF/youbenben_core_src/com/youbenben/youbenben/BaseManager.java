
package  com.youbenben.youbenben;

import com.terapico.caf.baseelement.CandidateQuery;

public interface BaseManager{
	<D> D daoOf(YoubenbenUserContext userContext);
	
	Object queryCandidates(YoubenbenUserContext userContext, CandidateQuery query) throws Exception;
	
	Object queryCandidatesForAssign(YoubenbenUserContext userContext, CandidateQuery query) throws Exception;

	Object queryCandidatesForSearch(YoubenbenUserContext userContext, CandidateQuery query) throws Exception;
}
















