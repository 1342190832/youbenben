package com.xingyou.xingyou.page;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class PageSerializer extends XingyouObjectPlainCustomSerializer<Page>{

	@Override
	public void serialize(Page page, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, page, provider);
		
	}
}


