package com.youbenben.youbenben.supplierproduct;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SupplierProductSerializer extends YoubenbenObjectPlainCustomSerializer<SupplierProduct>{

	@Override
	public void serialize(SupplierProduct supplierProduct, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplierProduct, provider);
		
	}
}


