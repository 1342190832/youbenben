package com.youbenben.youbenben.payingoff;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class PayingOffSerializer extends YoubenbenObjectPlainCustomSerializer<PayingOff>{

	@Override
	public void serialize(PayingOff payingOff, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, payingOff, provider);
		
	}
}


