package com.youbenben.youbenben.offeracceptance;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class OfferAcceptanceSerializer extends YoubenbenObjectPlainCustomSerializer<OfferAcceptance>{

	@Override
	public void serialize(OfferAcceptance offerAcceptance, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, offerAcceptance, provider);
		
	}
}


