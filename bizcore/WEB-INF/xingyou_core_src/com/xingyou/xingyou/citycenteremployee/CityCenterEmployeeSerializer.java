package com.xingyou.xingyou.citycenteremployee;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class CityCenterEmployeeSerializer extends XingyouObjectPlainCustomSerializer<CityCenterEmployee>{

	@Override
	public void serialize(CityCenterEmployee cityCenterEmployee, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, cityCenterEmployee, provider);
		
	}
}


