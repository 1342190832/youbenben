package com.xingyou.xingyou.leveltwocategory;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class LevelTwoCategorySerializer extends XingyouObjectPlainCustomSerializer<LevelTwoCategory>{

	@Override
	public void serialize(LevelTwoCategory levelTwoCategory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, levelTwoCategory, provider);
		
	}
}


