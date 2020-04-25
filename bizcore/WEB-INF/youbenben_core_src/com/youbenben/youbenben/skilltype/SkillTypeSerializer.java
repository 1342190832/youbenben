package com.youbenben.youbenben.skilltype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SkillTypeSerializer extends YoubenbenObjectPlainCustomSerializer<SkillType>{

	@Override
	public void serialize(SkillType skillType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, skillType, provider);
		
	}
}


