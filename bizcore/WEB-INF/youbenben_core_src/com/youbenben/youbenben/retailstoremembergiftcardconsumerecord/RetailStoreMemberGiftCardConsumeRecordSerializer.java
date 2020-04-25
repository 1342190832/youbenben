package com.youbenben.youbenben.retailstoremembergiftcardconsumerecord;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreMemberGiftCardConsumeRecordSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreMemberGiftCardConsumeRecord>{

	@Override
	public void serialize(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreMemberGiftCardConsumeRecord, provider);
		
	}
}


