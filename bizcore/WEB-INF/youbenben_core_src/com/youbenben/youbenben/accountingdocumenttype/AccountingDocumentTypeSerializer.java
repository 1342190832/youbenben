package com.youbenben.youbenben.accountingdocumenttype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class AccountingDocumentTypeSerializer extends YoubenbenObjectPlainCustomSerializer<AccountingDocumentType>{

	@Override
	public void serialize(AccountingDocumentType accountingDocumentType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingDocumentType, provider);
		
	}
}


