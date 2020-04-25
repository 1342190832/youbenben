package com.xingyou.xingyou.cityevent;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class CityEventSerializer extends XingyouObjectPlainCustomSerializer<CityEvent>{

	@Override
	public void serialize(CityEvent cityEvent, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, cityEvent, provider);
		
	}
}


