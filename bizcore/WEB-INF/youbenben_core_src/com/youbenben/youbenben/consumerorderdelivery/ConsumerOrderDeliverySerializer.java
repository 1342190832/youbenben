package com.youbenben.youbenben.consumerorderdelivery;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ConsumerOrderDeliverySerializer extends YoubenbenObjectPlainCustomSerializer<ConsumerOrderDelivery>{

	@Override
	public void serialize(ConsumerOrderDelivery consumerOrderDelivery, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderDelivery, provider);
		
	}
}


