package com.youbenben.youbenben.productsupplyduration;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ProductSupplyDurationSerializer extends YoubenbenObjectPlainCustomSerializer<ProductSupplyDuration>{

	@Override
	public void serialize(ProductSupplyDuration productSupplyDuration, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, productSupplyDuration, provider);
		
	}
}


