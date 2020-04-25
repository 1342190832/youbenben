package com.youbenben.youbenben.leavetype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class LeaveTypeSerializer extends YoubenbenObjectPlainCustomSerializer<LeaveType>{

	@Override
	public void serialize(LeaveType leaveType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, leaveType, provider);
		
	}
}


