package com.youbenben.youbenben.franchisedoutletcitycenter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class FranchisedOutletCityCenterSerializer extends YoubenbenObjectPlainCustomSerializer<FranchisedOutletCityCenter>{

	@Override
	public void serialize(FranchisedOutletCityCenter franchisedOutletCityCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, franchisedOutletCityCenter, provider);
		
	}
}


