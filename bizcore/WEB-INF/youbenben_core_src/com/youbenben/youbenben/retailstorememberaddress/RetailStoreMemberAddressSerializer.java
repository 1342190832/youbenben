package com.youbenben.youbenben.retailstorememberaddress;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreMemberAddressSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreMemberAddress>{

	@Override
	public void serialize(RetailStoreMemberAddress retailStoreMemberAddress, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreMemberAddress, provider);
		
	}
}


