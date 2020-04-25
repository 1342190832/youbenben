package com.youbenben.youbenben.goods;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class GoodsSerializer extends YoubenbenObjectPlainCustomSerializer<Goods>{

	@Override
	public void serialize(Goods goods, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, goods, provider);
		
	}
}


