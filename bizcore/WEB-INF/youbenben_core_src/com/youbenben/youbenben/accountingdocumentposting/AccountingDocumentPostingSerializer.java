package com.youbenben.youbenben.accountingdocumentposting;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class AccountingDocumentPostingSerializer extends YoubenbenObjectPlainCustomSerializer<AccountingDocumentPosting>{

	@Override
	public void serialize(AccountingDocumentPosting accountingDocumentPosting, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingDocumentPosting, provider);
		
	}
}


