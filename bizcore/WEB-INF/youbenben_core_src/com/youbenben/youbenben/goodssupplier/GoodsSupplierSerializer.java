package com.youbenben.youbenben.goodssupplier;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class GoodsSupplierSerializer extends YoubenbenObjectPlainCustomSerializer<GoodsSupplier>{

	@Override
	public void serialize(GoodsSupplier goodsSupplier, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, goodsSupplier, provider);
		
	}
}


