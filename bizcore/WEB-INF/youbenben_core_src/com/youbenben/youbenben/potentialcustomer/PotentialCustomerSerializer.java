package com.youbenben.youbenben.potentialcustomer;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class PotentialCustomerSerializer extends YoubenbenObjectPlainCustomSerializer<PotentialCustomer>{

	@Override
	public void serialize(PotentialCustomer potentialCustomer, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, potentialCustomer, provider);
		
	}
}


