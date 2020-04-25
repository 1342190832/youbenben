
package com.xingyou.xingyou.treenode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface TreeNodeManager extends BaseManager{

		

	public TreeNode createTreeNode(XingyouUserContext userContext, String nodeId,String nodeType,int leftValue,int rightValue) throws Exception;
	public TreeNode updateTreeNode(XingyouUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TreeNode loadTreeNode(XingyouUserContext userContext, String treeNodeId, String [] tokensExpr) throws Exception;
	public TreeNode internalSaveTreeNode(XingyouUserContext userContext, TreeNode treeNode) throws Exception;
	public TreeNode internalSaveTreeNode(XingyouUserContext userContext, TreeNode treeNode,Map<String,Object>option) throws Exception;



	public void delete(XingyouUserContext userContext, String treeNodeId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, TreeNode newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}





















