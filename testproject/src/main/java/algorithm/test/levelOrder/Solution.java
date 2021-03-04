package algorithm.test.levelOrder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 通过次数259,603提交次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    class Entity {
        int level;
        ArrayList<Integer> arrayList;

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public ArrayList<Integer> getArrayList() {
            return arrayList;
        }

        public void setArrayList(ArrayList<Integer> arrayList) {
            this.arrayList = arrayList;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        levelOrderSub(root, 0);
        List<Entity> entityList = new ArrayList<>();
        map.forEach((k, v) -> {
            Entity entity = new Entity();
            entity.level = k;
            entity.arrayList = v;
            entityList.add(entity);
        });
        List<Entity> res = entityList.stream().sorted(Comparator.comparing(Entity::getLevel)).collect(Collectors.toList());
        for (Entity entity : res) {
            lists.add(entity.getArrayList());
        }
        return lists;
    }

    private void levelOrderSub(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        levelOrderSub(root.left, i + 1);
        ArrayList<Integer> list = map.getOrDefault(i, new ArrayList<Integer>());
        list.add(root.val);
        map.put(i, list);
        levelOrderSub(root.right, i + 1);

    }
}
