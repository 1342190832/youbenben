package com.xingyou.xingyou.citypartner;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class CityPartnerSerializer extends XingyouObjectPlainCustomSerializer<CityPartner>{

	@Override
	public void serialize(CityPartner cityPartner, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, cityPartner, provider);
		
	}
}


