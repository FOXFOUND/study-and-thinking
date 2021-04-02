package algorithm.test.levelOrder;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {

    public static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

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

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }
        levelOrderSub(root, 0);

        List<Entity> entityList = new ArrayList<>();
        map.forEach((k, v) -> {
            Entity entity = new Entity();
            entity.level = k;
            entity.arrayList = v;
            entityList.add(entity);
        });
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        List<Entity> res = entityList.stream().sorted(Comparator.comparing(Entity::getLevel)).collect(Collectors.toList());
        for (Entity entity : res) {
            lists.add(entity.getArrayList());
        }
        return lists;

    }

    private void levelOrderSub(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        levelOrderSub(root.left, level + 1);
        ArrayList<Integer> arrayList = map.getOrDefault(level, new ArrayList<Integer>());
        arrayList.add(root.val);
        map.put(level, arrayList);
        levelOrderSub(root.right, level + 1);

    }

}
