package com.xingyou.xingyou.franchisedoutletprovincecenter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xingyou.xingyou.XingyouObjectPlainCustomSerializer;
public class FranchisedOutletProvinceCenterSerializer extends XingyouObjectPlainCustomSerializer<FranchisedOutletProvinceCenter>{

	@Override
	public void serialize(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, franchisedOutletProvinceCenter, provider);
		
	}
}


