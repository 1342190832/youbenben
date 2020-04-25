package com.xingyou.xingyou.potentialcustomercontact;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class PotentialCustomerContactSerializer extends XingyouObjectPlainCustomSerializer<PotentialCustomerContact>{

	@Override
	public void serialize(PotentialCustomerContact potentialCustomerContact, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, potentialCustomerContact, provider);
		
	}
}


