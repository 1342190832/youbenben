package com.youbenben.youbenben.franchisedoutletcityservicecenter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class FranchisedOutletCityServiceCenterSerializer extends YoubenbenObjectPlainCustomSerializer<FranchisedOutletCityServiceCenter>{

	@Override
	public void serialize(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, franchisedOutletCityServiceCenter, provider);
		
	}
}

