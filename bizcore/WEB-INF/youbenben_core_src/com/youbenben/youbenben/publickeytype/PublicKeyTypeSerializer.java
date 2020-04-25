package com.youbenben.youbenben.publickeytype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class PublicKeyTypeSerializer extends YoubenbenObjectPlainCustomSerializer<PublicKeyType>{

	@Override
	public void serialize(PublicKeyType publicKeyType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, publicKeyType, provider);
		
	}
}


