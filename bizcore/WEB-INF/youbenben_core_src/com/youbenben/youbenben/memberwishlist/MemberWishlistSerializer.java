package com.youbenben.youbenben.memberwishlist;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class MemberWishlistSerializer extends YoubenbenObjectPlainCustomSerializer<MemberWishlist>{

	@Override
	public void serialize(MemberWishlist memberWishlist, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, memberWishlist, provider);
		
	}
}


