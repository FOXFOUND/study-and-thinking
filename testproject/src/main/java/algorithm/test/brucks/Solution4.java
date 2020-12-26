package algorithm.test.brucks;

/**
 * 方法一：时光倒流 + 并查集
 * 与其考虑在每次操作后，有多少砖块落下，我们不如倒过来考虑这个过程：
 * 每次我们加上一个砖块，并计算有多少额外的砖块因为这个砖块的增加而和网格的顶部直接或间接相连。
 * 这样我们就可以用并查集来解决这个问题了。
 *
 * 首先我们添加一个虚拟的节点，它的编号为 R * C（网格中的节点编号为 [0, R * C - 1]），
 * 代表网格的顶部，任何第一行的砖块都会与它相连。
 * 对于网格中的每一个位置，如果它在所有操作结束后仍然有砖块
 * ，那么就将它和四连通（上下左右）的四个位置（如果对应位置也有砖块）进行合并
 * 。这样，我们就得到了在所有操作结束后，网格对应的并查集状态。
 *
 * 随后我们逆序地处理这些操作。
 * 对于每一次操作的位置 (r, c)，
 * 如果这个位置原本就没有砖块，那么不会有任何变化
 * ；如果这个位置原本有砖块，那么砖块从无到有的过程就会使得 (r, c) 四连通的四个位置相连，
 * 如果这四个位置中的某些位置有砖块，那么就将这些位置合并，
 * 如果 r == 0，砖块的位置在第一行，那么还需要和网格的顶部合并。
 * 我们在并查集中额外加入数组 sz[] 表示集合中节点的数目，
 * 这样在每次操作后，sz[findset(R * C)] 的变化量就是和顶部相连的砖块数的变化量，
 * 也就是顺序考虑时落下来的砖块数量。
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/bricks-falling-when-hit/solution/da-zhuan-kuai-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution4 {
    private class Node {
        final int hPos;
        final int wPos;

        Node parent;
        int  size;

        Node(int hPos, int wPos) {
            this.hPos = hPos;
            this.wPos = wPos;
            parent = this;
            size = 1;
        }

        Node getParent() {
            Node node = this.parent;
            while (node != node.parent) {
                node = node.parent;
            }
            return node;
        }

        void merge(Node other) {
            Node otherParent = other.getParent();
            Node thisParent  = this.getParent();
            if (otherParent == thisParent) {
                return;
            }
            if (otherParent == root) {
                root.doMerge(thisParent);
                return;
            }
            if (thisParent == root) {
                root.doMerge(otherParent);
                return;
            }
            if (thisParent.size < otherParent.size) {
                otherParent.doMerge(thisParent);
            } else {
                thisParent.doMerge(otherParent);
            }
        }

        private void doMerge(Node other) {
            other.parent = this;
            size += other.size;
            other.size = 1;
        }
    }

    private Node createNode(int hPos, int wPos){
        Node node = new Node(hPos,wPos);
        nodes[hPos][wPos] = node;
        return node;
    }

    private Node     root;
    private Node[][] nodes;


    private int height;
    private int width;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        height = grid.length;
        width = grid[0].length;

        // Copy grid into grid temp
        int[][] gridTemp = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                gridTemp[i][j] = grid[i][j];
            }
        }
        // Remove all hit points in gridTemp
        for (int i = 0; i < hits.length; i++) {
            int hPos = hits[i][0];
            int wPos = hits[i][1];
            gridTemp[hPos][wPos] = 0;
        }

        // Merge top nodes to root node set(in gridTemp)
        root = new Node(-1,-1);
        nodes = new Node[height][width];
        for (int j = 0; j < width; j++) {
            if (gridTemp[0][j] == 1) {
                createNode(0, j).merge(root);
            }
        }

        // Merge other nodes (in gridTemp)
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (gridTemp[i][j] == 1) {
                    Node node = createNode(i, j);
                    Node up   = nodes[i - 1][j];
                    if (up != null) {
                        node.merge(up);
                    }
                    Node left = j > 0 ? nodes[i][j - 1] : null;
                    if (left != null) {
                        node.merge(left);
                    }
                }
            }
        }

        // Now add hit nodes to restore gridTemp into grid
        int[] result = new int[hits.length];
        int before = root.size;
        for (int i = hits.length - 1; i >=0 ; i--){
            int hPos = hits[i][0];
            int wPos = hits[i][1];
            if(grid[hPos][wPos] == 0){
                result[i] = 0;
                continue;
            }
            Node node = createNode(hPos, wPos);
            Node up = hPos > 0 ? nodes[hPos - 1][wPos] : null;
            if(up != null){
                node.merge(up);
            }
            Node left = wPos > 0 ? nodes[hPos][wPos - 1]:null;
            if(left != null){
                node.merge(left);
            }
            Node right = wPos + 1 < width ? nodes[hPos][wPos + 1]:null;
            if(right != null){
                node.merge(right);
            }
            Node down = hPos + 1 < height ? nodes[hPos + 1][wPos]:null;
            if(down != null){
                node.merge(down);
            }
            if(hPos == 0){
                node.merge(root);
            }
            int after = root.size;
            // The new added hit node should not be included if increment in root set
            result[i] = after - before > 1 ? after - before - 1 : 0;
            before = after;
        }
        return result;
    }
}
