package com.youbenben.youbenben.accountingdocumentline;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class AccountingDocumentLineSerializer extends YoubenbenObjectPlainCustomSerializer<AccountingDocumentLine>{

	@Override
	public void serialize(AccountingDocumentLine accountingDocumentLine, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingDocumentLine, provider);
		
	}
}


