package com.xingyou.xingyou.citycenterdepartment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class CityCenterDepartmentSerializer extends XingyouObjectPlainCustomSerializer<CityCenterDepartment>{

	@Override
	public void serialize(CityCenterDepartment cityCenterDepartment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, cityCenterDepartment, provider);
		
	}
}


