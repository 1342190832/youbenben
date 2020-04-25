package com.youbenben.youbenben.originalvouchercreation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class OriginalVoucherCreationSerializer extends YoubenbenObjectPlainCustomSerializer<OriginalVoucherCreation>{

	@Override
	public void serialize(OriginalVoucherCreation originalVoucherCreation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, originalVoucherCreation, provider);
		
	}
}


