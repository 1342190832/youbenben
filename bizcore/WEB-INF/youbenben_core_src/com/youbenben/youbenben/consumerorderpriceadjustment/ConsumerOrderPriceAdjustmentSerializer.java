package com.youbenben.youbenben.consumerorderpriceadjustment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ConsumerOrderPriceAdjustmentSerializer extends YoubenbenObjectPlainCustomSerializer<ConsumerOrderPriceAdjustment>{

	@Override
	public void serialize(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderPriceAdjustment, provider);
		
	}
}


