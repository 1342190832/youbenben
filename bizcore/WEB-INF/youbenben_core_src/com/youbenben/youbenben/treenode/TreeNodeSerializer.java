package com.youbenben.youbenben.treenode;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class TreeNodeSerializer extends YoubenbenObjectPlainCustomSerializer<TreeNode>{

	@Override
	public void serialize(TreeNode treeNode, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, treeNode, provider);
		
	}
}

















