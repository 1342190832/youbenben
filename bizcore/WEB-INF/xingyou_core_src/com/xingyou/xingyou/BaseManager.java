
package  com.xingyou.xingyou;

import com.terapico.caf.baseelement.CandidateQuery;

public interface BaseManager{
	<D> D daoOf(XingyouUserContext userContext);
	
	Object queryCandidates(XingyouUserContext userContext, CandidateQuery query) throws Exception;
	
	Object queryCandidatesForAssign(XingyouUserContext userContext, CandidateQuery query) throws Exception;

	Object queryCandidatesForSearch(XingyouUserContext userContext, CandidateQuery query) throws Exception;
}
















