package com.youbenben.youbenben.consumerordershippinggroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ConsumerOrderShippingGroupSerializer extends YoubenbenObjectPlainCustomSerializer<ConsumerOrderShippingGroup>{

	@Override
	public void serialize(ConsumerOrderShippingGroup consumerOrderShippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderShippingGroup, provider);
		
	}
}


