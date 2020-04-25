package com.youbenben.youbenben.supplyordershipment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SupplyOrderShipmentSerializer extends YoubenbenObjectPlainCustomSerializer<SupplyOrderShipment>{

	@Override
	public void serialize(SupplyOrderShipment supplyOrderShipment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderShipment, provider);
		
	}
}


