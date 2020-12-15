package tree.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.list.TreeList;

import java.util.Comparator;
import java.util.List;

public class BPlusTreeTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 20, 2, 3, 7, 9};
        /**
         * 构建B+树的注意事项:
         * 1.B+树的分裂是自底向上的
         * 2.B+树的叶子节点存数据,卫星节点用来存索引
         * 3.卫星节点的节点树  对于m阶树来说 1<x< m-1
         *
         */
        buildBPlusTree(arr);
    }

    /**
     * 构建B+树
     *
     * @param arr
     */
    private static void buildBPlusTree(int[] arr) {
        TreeNode rootNode = new TreeNode();
        rootNode.setType(0);
        List<TreeNodeSub> treeNodeSubList = new TreeList<>();
        TreeNodeSub treeNodeSub = new TreeNodeSub();
        treeNodeSub.setValue(arr[0]);
        treeNodeSub.setLeft(null);
        treeNodeSub.setRight(null);
        treeNodeSub.setSon(null);
        rootNode.setNodeSubList(treeNodeSubList);
        int treeHeight = 1;
        TreeNode currentNode = rootNode;
        int currentNodeLength = currentNode.getNodeSubList().size();

        List<TreeNodeSub> currentTreeNodeSubs = currentNode.getNodeSubList();
        for (int i = 1; i < arr.length; i++) {

            TreeNodeSub treeNodeSubTemp = new TreeNodeSub();
            treeNodeSubTemp.setValue(arr[i]);
            treeNodeSubTemp.setLeft(null);
            treeNodeSubTemp.setRight(null);
            treeNodeSubTemp.setSon(null);
            currentTreeNodeSubs.add(treeNodeSubTemp);
            currentTreeNodeSubs.sort(new Comparator<TreeNodeSub>() {
                @Override
                public int compare(TreeNodeSub o1, TreeNodeSub o2) {
                    return o1.getValue().intValue() - o2.getValue().intValue();
                }
            });



        }

        for (int j = 0; j < currentTreeNodeSubs.size(); j++) {
            TreeNodeSub tempCurrentTreeNodeSub = currentTreeNodeSubs.get(j);
            TreeNodeSub left = j - 1 > 0 ? currentTreeNodeSubs.get(j - 1) : null;
            List<TreeNodeSub> leftNodeSubList = new TreeList<>();
            leftNodeSubList.add(left);
            TreeNode leftTreeNode = new TreeNode();
            leftTreeNode.setType(0);
            leftTreeNode.setNodeSubList(leftNodeSubList);
            TreeNodeSub right = j + 1 > currentNodeLength - 1 ? null : currentTreeNodeSubs.get(j + 1);
            List<TreeNodeSub> rightNodeSubList = new TreeList<>();
            rightNodeSubList.add(right);
            TreeNode rightTreeNode = new TreeNode();
            rightTreeNode.setType(0);
            rightTreeNode.setNodeSubList(rightNodeSubList);
            tempCurrentTreeNodeSub.setLeft(leftTreeNode);
            tempCurrentTreeNodeSub.setRight(rightTreeNode);

        }
        System.out.println(JSON.toJSONString(rootNode));
    }
}
