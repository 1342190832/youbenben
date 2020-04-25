package com.youbenben.youbenben.potentialcustomercontactperson;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class PotentialCustomerContactPersonSerializer extends YoubenbenObjectPlainCustomSerializer<PotentialCustomerContactPerson>{

	@Override
	public void serialize(PotentialCustomerContactPerson potentialCustomerContactPerson, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, potentialCustomerContactPerson, provider);
		
	}
}


