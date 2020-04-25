package com.youbenben.youbenben.potentialcustomercontact;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class PotentialCustomerContactSerializer extends YoubenbenObjectPlainCustomSerializer<PotentialCustomerContact>{

	@Override
	public void serialize(PotentialCustomerContact potentialCustomerContact, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, potentialCustomerContact, provider);
		
	}
}


