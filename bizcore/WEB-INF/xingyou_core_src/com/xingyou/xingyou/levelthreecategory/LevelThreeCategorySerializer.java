package com.xingyou.xingyou.levelthreecategory;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class LevelThreeCategorySerializer extends XingyouObjectPlainCustomSerializer<LevelThreeCategory>{

	@Override
	public void serialize(LevelThreeCategory levelThreeCategory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, levelThreeCategory, provider);
		
	}
}


