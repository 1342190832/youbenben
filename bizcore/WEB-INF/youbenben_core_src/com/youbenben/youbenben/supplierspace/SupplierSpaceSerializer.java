package com.youbenben.youbenben.supplierspace;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SupplierSpaceSerializer extends YoubenbenObjectPlainCustomSerializer<SupplierSpace>{

	@Override
	public void serialize(SupplierSpace supplierSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplierSpace, provider);
		
	}
}


