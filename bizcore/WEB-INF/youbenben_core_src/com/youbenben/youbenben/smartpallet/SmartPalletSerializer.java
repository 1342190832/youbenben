package com.youbenben.youbenben.smartpallet;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SmartPalletSerializer extends YoubenbenObjectPlainCustomSerializer<SmartPallet>{

	@Override
	public void serialize(SmartPallet smartPallet, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, smartPallet, provider);
		
	}
}


