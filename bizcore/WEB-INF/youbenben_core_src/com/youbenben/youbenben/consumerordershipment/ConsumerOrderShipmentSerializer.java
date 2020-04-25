package com.youbenben.youbenben.consumerordershipment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ConsumerOrderShipmentSerializer extends YoubenbenObjectPlainCustomSerializer<ConsumerOrderShipment>{

	@Override
	public void serialize(ConsumerOrderShipment consumerOrderShipment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderShipment, provider);
		
	}
}


