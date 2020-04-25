package com.youbenben.youbenben.memberrewardpoint;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class MemberRewardPointSerializer extends YoubenbenObjectPlainCustomSerializer<MemberRewardPoint>{

	@Override
	public void serialize(MemberRewardPoint memberRewardPoint, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, memberRewardPoint, provider);
		
	}
}


