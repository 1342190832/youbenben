package com.youbenben.youbenben.transporttasktrack;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class TransportTaskTrackSerializer extends YoubenbenObjectPlainCustomSerializer<TransportTaskTrack>{

	@Override
	public void serialize(TransportTaskTrack transportTaskTrack, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, transportTaskTrack, provider);
		
	}
}


