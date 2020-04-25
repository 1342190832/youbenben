package com.youbenben.youbenben.transporttask;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class TransportTaskSerializer extends YoubenbenObjectPlainCustomSerializer<TransportTask>{

	@Override
	public void serialize(TransportTask transportTask, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, transportTask, provider);
		
	}
}


