package com.youbenben.youbenben.offerapproval;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class OfferApprovalSerializer extends YoubenbenObjectPlainCustomSerializer<OfferApproval>{

	@Override
	public void serialize(OfferApproval offerApproval, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, offerApproval, provider);
		
	}
}


