package com.xingyou.xingyou.candidateelement;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class CandidateElementSerializer extends XingyouObjectPlainCustomSerializer<CandidateElement>{

	@Override
	public void serialize(CandidateElement candidateElement, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, candidateElement, provider);
		
	}
}


