package com.xingyou.xingyou.potentialcustomercontactperson;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class PotentialCustomerContactPersonSerializer extends XingyouObjectPlainCustomSerializer<PotentialCustomerContactPerson>{

	@Override
	public void serialize(PotentialCustomerContactPerson potentialCustomerContactPerson, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, potentialCustomerContactPerson, provider);
		
	}
}


