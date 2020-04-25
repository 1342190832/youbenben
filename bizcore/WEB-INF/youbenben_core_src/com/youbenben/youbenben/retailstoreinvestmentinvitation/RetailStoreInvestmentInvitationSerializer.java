package com.youbenben.youbenben.retailstoreinvestmentinvitation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreInvestmentInvitationSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreInvestmentInvitation>{

	@Override
	public void serialize(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreInvestmentInvitation, provider);
		
	}
}


