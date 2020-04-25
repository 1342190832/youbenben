package com.youbenben.youbenben.provincecenterdepartment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ProvinceCenterDepartmentSerializer extends YoubenbenObjectPlainCustomSerializer<ProvinceCenterDepartment>{

	@Override
	public void serialize(ProvinceCenterDepartment provinceCenterDepartment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, provinceCenterDepartment, provider);
		
	}
}


