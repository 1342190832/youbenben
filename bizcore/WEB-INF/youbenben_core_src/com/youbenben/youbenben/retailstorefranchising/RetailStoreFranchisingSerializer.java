package com.youbenben.youbenben.retailstorefranchising;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreFranchisingSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreFranchising>{

	@Override
	public void serialize(RetailStoreFranchising retailStoreFranchising, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreFranchising, provider);
		
	}
}


