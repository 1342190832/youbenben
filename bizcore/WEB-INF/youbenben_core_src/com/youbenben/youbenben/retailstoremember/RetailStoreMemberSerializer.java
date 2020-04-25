package com.youbenben.youbenben.retailstoremember;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreMemberSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreMember>{

	@Override
	public void serialize(RetailStoreMember retailStoreMember, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreMember, provider);
		
	}
}


