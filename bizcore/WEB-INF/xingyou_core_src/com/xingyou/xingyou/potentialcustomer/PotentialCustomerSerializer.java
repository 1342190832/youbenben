package com.xingyou.xingyou.potentialcustomer;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class PotentialCustomerSerializer extends XingyouObjectPlainCustomSerializer<PotentialCustomer>{

	@Override
	public void serialize(PotentialCustomer potentialCustomer, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, potentialCustomer, provider);
		
	}
}


