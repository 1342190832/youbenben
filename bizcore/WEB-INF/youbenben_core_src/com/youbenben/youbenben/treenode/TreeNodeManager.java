
package com.youbenben.youbenben.treenode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface TreeNodeManager extends BaseManager{

		

	public TreeNode createTreeNode(YoubenbenUserContext userContext, String nodeId,String nodeType,int leftValue,int rightValue) throws Exception;
	public TreeNode updateTreeNode(YoubenbenUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TreeNode loadTreeNode(YoubenbenUserContext userContext, String treeNodeId, String [] tokensExpr) throws Exception;
	public TreeNode internalSaveTreeNode(YoubenbenUserContext userContext, TreeNode treeNode) throws Exception;
	public TreeNode internalSaveTreeNode(YoubenbenUserContext userContext, TreeNode treeNode,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String treeNodeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, TreeNode newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}





















