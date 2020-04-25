package com.xingyou.xingyou.sku;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class SkuSerializer extends XingyouObjectPlainCustomSerializer<Sku>{

	@Override
	public void serialize(Sku sku, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, sku, provider);
		
	}
}


