package com.youbenben.youbenben.trainingcoursetype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class TrainingCourseTypeSerializer extends YoubenbenObjectPlainCustomSerializer<TrainingCourseType>{

	@Override
	public void serialize(TrainingCourseType trainingCourseType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, trainingCourseType, provider);
		
	}
}


