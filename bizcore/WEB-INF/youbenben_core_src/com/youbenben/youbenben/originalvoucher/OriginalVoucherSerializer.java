package com.youbenben.youbenben.originalvoucher;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class OriginalVoucherSerializer extends YoubenbenObjectPlainCustomSerializer<OriginalVoucher>{

	@Override
	public void serialize(OriginalVoucher originalVoucher, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, originalVoucher, provider);
		
	}
}


