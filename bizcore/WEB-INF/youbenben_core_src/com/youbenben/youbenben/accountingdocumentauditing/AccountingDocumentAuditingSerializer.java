package com.youbenben.youbenben.accountingdocumentauditing;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class AccountingDocumentAuditingSerializer extends YoubenbenObjectPlainCustomSerializer<AccountingDocumentAuditing>{

	@Override
	public void serialize(AccountingDocumentAuditing accountingDocumentAuditing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingDocumentAuditing, provider);
		
	}
}


