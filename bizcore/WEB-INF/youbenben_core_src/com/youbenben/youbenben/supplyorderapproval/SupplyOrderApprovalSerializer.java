package com.youbenben.youbenben.supplyorderapproval;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SupplyOrderApprovalSerializer extends YoubenbenObjectPlainCustomSerializer<SupplyOrderApproval>{

	@Override
	public void serialize(SupplyOrderApproval supplyOrderApproval, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderApproval, provider);
		
	}
}


