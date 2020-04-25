package com.youbenben.youbenben.accountingperiod;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class AccountingPeriodSerializer extends YoubenbenObjectPlainCustomSerializer<AccountingPeriod>{

	@Override
	public void serialize(AccountingPeriod accountingPeriod, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingPeriod, provider);
		
	}
}


