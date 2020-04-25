package com.youbenben.youbenben.consumerorderapproval;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ConsumerOrderApprovalSerializer extends YoubenbenObjectPlainCustomSerializer<ConsumerOrderApproval>{

	@Override
	public void serialize(ConsumerOrderApproval consumerOrderApproval, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderApproval, provider);
		
	}
}


