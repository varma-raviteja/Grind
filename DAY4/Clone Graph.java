// BFS

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList();
        Map<Integer, Node> cloneMap = new HashMap();
        queue.add(node);
        cloneMap.put(node.val, new Node(node.val));
       
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            Node clone = cloneMap.getOrDefault(cur.val, new Node(cur.val));
            cloneMap.put(cur.val, clone);
            for (Node child : cur.neighbors) {
                Node childClone = cloneMap.getOrDefault(child.val, new Node(child.val));
                clone.neighbors.add(childClone);
                if (!cloneMap.containsKey(child.val)) {
                    queue.add(child);
                }
                cloneMap.put(child.val, childClone);
            }
        }
        return cloneMap.get(node.val);
    }
}


// DFS
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        return dfs(node, map);
    }
    private Node dfs(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val, new ArrayList<Node>());
        map.put(node, clone);
        for (Node nb: node.neighbors) {
            clone.neighbors.add(dfs(nb, map));
        }
        return clone;
    }
}
