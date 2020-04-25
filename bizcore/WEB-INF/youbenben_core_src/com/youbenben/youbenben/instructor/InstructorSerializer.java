package com.youbenben.youbenben.instructor;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class InstructorSerializer extends YoubenbenObjectPlainCustomSerializer<Instructor>{

	@Override
	public void serialize(Instructor instructor, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, instructor, provider);
		
	}
}


