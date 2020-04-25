package com.youbenben.youbenben.storagespace;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class StorageSpaceSerializer extends YoubenbenObjectPlainCustomSerializer<StorageSpace>{

	@Override
	public void serialize(StorageSpace storageSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, storageSpace, provider);
		
	}
}


