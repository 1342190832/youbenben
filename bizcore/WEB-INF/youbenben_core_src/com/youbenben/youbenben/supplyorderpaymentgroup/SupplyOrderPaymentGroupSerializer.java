package com.youbenben.youbenben.supplyorderpaymentgroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SupplyOrderPaymentGroupSerializer extends YoubenbenObjectPlainCustomSerializer<SupplyOrderPaymentGroup>{

	@Override
	public void serialize(SupplyOrderPaymentGroup supplyOrderPaymentGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderPaymentGroup, provider);
		
	}
}


