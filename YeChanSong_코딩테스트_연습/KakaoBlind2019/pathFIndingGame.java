import java.util.*;

class Solution {

    private static Node root;
    private static ArrayList<Integer> preOrderList = new ArrayList<>();
    private static ArrayList<Integer> postOrderList = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        treeSetting(nodeinfo);
        preOrder(root);
        postOrder(root);
        answer[0] = preOrderList.stream().mapToInt(Integer::valueOf).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::valueOf).toArray();
        return answer;
    }

    private static void treeSetting(int[][] nodeInfo) {
        int[][] numberedNodeInfo = new int[nodeInfo.length][];
        for(int i=0;i<nodeInfo.length;i++) {
            numberedNodeInfo[i] =
                    new int[] {nodeInfo[i][1], nodeInfo[i][0], i};
        }
        Arrays.sort(numberedNodeInfo, (a, b) -> {
            // numberedNode y, x, num
            if (a[0] == b[0]) return a[1] - b[1];
            else return b[0] - a[0];
        });

        ArrayList<Node> nodeList = new ArrayList<>();
        for(int i=0;i<numberedNodeInfo.length;i++) {
            nodeList.add(new Node(
                    numberedNodeInfo[i][2], numberedNodeInfo[i][0], numberedNodeInfo[i][1], null, null
            ));
        }
        root = nodeList.get(0);
        childSetting(nodeList);
    }

    private static void childSetting(ArrayList<Node> nodeList) {
        if (nodeList.isEmpty()) return;
        Node parant = nodeList.get(0);

        ArrayList<Node> leftSubTree = new ArrayList<>();
        ArrayList<Node> rightSubTree = new ArrayList<>();
        nodeList.forEach( node -> {
            if (node.x < parant.x) leftSubTree.add(node);
            else if (node.x > parant.x) rightSubTree.add(node);
        });
        if (!leftSubTree.isEmpty()){
            Node leftRoot = leftSubTree.get(0);
            parant.left = leftRoot;
        }
        if (!rightSubTree.isEmpty()) {
            Node rightRoot = rightSubTree.get(0);
            parant.right = rightRoot;
        }
        childSetting(leftSubTree);
        childSetting(rightSubTree);
    }

    private static void preOrder(Node root) {
        if (root == null) return;
        preOrderList.add(root.num+1);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        postOrderList.add(root.num+1);
    }

    private static class Node {
        int y;
        int x;
        int num;
        Node left;
        Node right;
        Node(int num, int y, int x, Node left, Node right) {
            this.num = num;
            this.y = y;
            this.x = x;
            this.left = left;
            this.right = right;
        }
    }
}