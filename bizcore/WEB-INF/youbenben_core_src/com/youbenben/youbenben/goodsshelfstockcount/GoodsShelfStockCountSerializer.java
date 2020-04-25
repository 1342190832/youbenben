package com.youbenben.youbenben.goodsshelfstockcount;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class GoodsShelfStockCountSerializer extends YoubenbenObjectPlainCustomSerializer<GoodsShelfStockCount>{

	@Override
	public void serialize(GoodsShelfStockCount goodsShelfStockCount, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, goodsShelfStockCount, provider);
		
	}
}


