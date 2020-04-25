package com.youbenben.youbenben.retailstoremembercoupon;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreMemberCouponSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreMemberCoupon>{

	@Override
	public void serialize(RetailStoreMemberCoupon retailStoreMemberCoupon, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreMemberCoupon, provider);
		
	}
}


