package com.xingyou.xingyou.franchisedoutletcitycenter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class FranchisedOutletCityCenterSerializer extends XingyouObjectPlainCustomSerializer<FranchisedOutletCityCenter>{

	@Override
	public void serialize(FranchisedOutletCityCenter franchisedOutletCityCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, franchisedOutletCityCenter, provider);
		
	}
}


