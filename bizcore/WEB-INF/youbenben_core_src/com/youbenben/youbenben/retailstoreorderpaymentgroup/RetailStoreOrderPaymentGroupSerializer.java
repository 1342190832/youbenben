package com.youbenben.youbenben.retailstoreorderpaymentgroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreOrderPaymentGroupSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreOrderPaymentGroup>{

	@Override
	public void serialize(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderPaymentGroup, provider);
		
	}
}


