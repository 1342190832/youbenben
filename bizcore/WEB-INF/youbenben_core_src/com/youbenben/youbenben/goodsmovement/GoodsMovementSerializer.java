package com.youbenben.youbenben.goodsmovement;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class GoodsMovementSerializer extends YoubenbenObjectPlainCustomSerializer<GoodsMovement>{

	@Override
	public void serialize(GoodsMovement goodsMovement, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, goodsMovement, provider);
		
	}
}


