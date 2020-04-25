package com.youbenben.youbenben.citypartner;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class CityPartnerSerializer extends YoubenbenObjectPlainCustomSerializer<CityPartner>{

	@Override
	public void serialize(CityPartner cityPartner, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, cityPartner, provider);
		
	}
}


