package com.youbenben.youbenben.leveltwodepartment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class LevelTwoDepartmentSerializer extends YoubenbenObjectPlainCustomSerializer<LevelTwoDepartment>{

	@Override
	public void serialize(LevelTwoDepartment levelTwoDepartment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, levelTwoDepartment, provider);
		
	}
}


