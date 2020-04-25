package com.youbenben.youbenben.damagespace;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class DamageSpaceSerializer extends YoubenbenObjectPlainCustomSerializer<DamageSpace>{

	@Override
	public void serialize(DamageSpace damageSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, damageSpace, provider);
		
	}
}


