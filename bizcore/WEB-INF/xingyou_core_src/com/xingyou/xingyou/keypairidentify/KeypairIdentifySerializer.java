package com.xingyou.xingyou.keypairidentify;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class KeypairIdentifySerializer extends XingyouObjectPlainCustomSerializer<KeypairIdentify>{

	@Override
	public void serialize(KeypairIdentify keypairIdentify, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, keypairIdentify, provider);
		
	}
}


