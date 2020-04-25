package com.youbenben.youbenben.retailstoreprovincecenter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreProvinceCenterSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreProvinceCenter>{

	@Override
	public void serialize(RetailStoreProvinceCenter retailStoreProvinceCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreProvinceCenter, provider);
		
	}
}


