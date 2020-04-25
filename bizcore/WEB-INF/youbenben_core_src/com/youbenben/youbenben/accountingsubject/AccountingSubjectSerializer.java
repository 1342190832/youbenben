package com.youbenben.youbenben.accountingsubject;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class AccountingSubjectSerializer extends YoubenbenObjectPlainCustomSerializer<AccountingSubject>{

	@Override
	public void serialize(AccountingSubject accountingSubject, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingSubject, provider);
		
	}
}


