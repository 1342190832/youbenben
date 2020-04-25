package com.youbenben.youbenben.goodsallocation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class GoodsAllocationSerializer extends YoubenbenObjectPlainCustomSerializer<GoodsAllocation>{

	@Override
	public void serialize(GoodsAllocation goodsAllocation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, goodsAllocation, provider);
		
	}
}


