package com.youbenben.youbenben.tree;


import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;

public interface TreeService {
    //load the subtree which root is node id/node type, and only one tree found.
    Node loadTree(YoubenbenUserContext ctx, String nodeId, String nodeType) throws Exception;

    default Node loadTree(YoubenbenUserContext ctx, BaseEntity pEntity) throws Exception {
        return loadTree(ctx, pEntity.getId(), pEntity.getInternalType());
    }

    default Node loadTree(YoubenbenUserContext ctx, String nodeId, Class nodeClass) throws Exception {
        return loadTree(ctx, nodeId, nodeClass.getSimpleName());
    }

    Node loadAncestors(YoubenbenUserContext ctx, String nodeId, String nodeType) throws Exception;

    default Node loadAncestors(YoubenbenUserContext ctx, BaseEntity pEntity) throws Exception {
        return loadAncestors(ctx, pEntity.getId(), pEntity.getInternalType());
    }

    default Node loadAncestors(YoubenbenUserContext ctx, String nodeId, Class nodeClass) throws Exception {
        return loadAncestors(ctx, nodeId, nodeClass.getSimpleName());
    }

    default Node addChild(YoubenbenUserContext ctx, Node tree, BaseEntity pEntity) throws Exception {
        return addChild(ctx, tree, pEntity.getId(), pEntity.getInternalType());
    }

    //add child in the tree as current node's last son, returns the parent
    Node addChild(YoubenbenUserContext ctx, Node tree, String childId, String childType) throws Exception;

    default Node addChild(YoubenbenUserContext ctx, Node tree, String childId, Class childType) throws Exception {
        return addChild(ctx, tree, childId, childType.getSimpleName());
    }

    Node deleteChild(YoubenbenUserContext ctx, Node parent, Node child) throws Exception;
}

