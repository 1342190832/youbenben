package com.youbenben.youbenben.stockcountissuetrack;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class StockCountIssueTrackSerializer extends YoubenbenObjectPlainCustomSerializer<StockCountIssueTrack>{

	@Override
	public void serialize(StockCountIssueTrack stockCountIssueTrack, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, stockCountIssueTrack, provider);
		
	}
}


