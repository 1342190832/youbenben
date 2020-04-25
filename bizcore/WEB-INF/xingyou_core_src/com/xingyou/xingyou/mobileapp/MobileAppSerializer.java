package com.xingyou.xingyou.mobileapp;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class MobileAppSerializer extends XingyouObjectPlainCustomSerializer<MobileApp>{

	@Override
	public void serialize(MobileApp mobileApp, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, mobileApp, provider);
		
	}
}


