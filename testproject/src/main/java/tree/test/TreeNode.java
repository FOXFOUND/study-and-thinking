package tree.test;

import java.util.List;

/**
 * b+树节点
 */
public class TreeNode {
    private Integer type;  // 类型  卫星节点,叶子节点
    private List<TreeNodeSub>  nodeSubList;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<TreeNodeSub> getNodeSubList() {
        return nodeSubList;
    }

    public void setNodeSubList(List<TreeNodeSub> nodeSubList) {
        this.nodeSubList = nodeSubList;
    }
}


class  TreeNodeSub{
    private Integer value;
    private TreeNode left;
    private TreeNode right;
    private TreeNode son;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getSon() {
        return son;
    }

    public void setSon(TreeNode son) {
        this.son = son;
    }
}
