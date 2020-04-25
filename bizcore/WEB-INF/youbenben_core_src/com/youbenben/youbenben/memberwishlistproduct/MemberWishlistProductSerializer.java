package com.youbenben.youbenben.memberwishlistproduct;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class MemberWishlistProductSerializer extends YoubenbenObjectPlainCustomSerializer<MemberWishlistProduct>{

	@Override
	public void serialize(MemberWishlistProduct memberWishlistProduct, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, memberWishlistProduct, provider);
		
	}
}


