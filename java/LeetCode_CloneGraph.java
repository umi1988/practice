import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class LeetCode_CloneGraph {
    public static Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Map<Node,Node> map = new HashMap<>(); //create HashMap to keep track of all the cloned nodes
        Queue<Node> queue = new LinkedList<>(); //queue to perform BFS
        queue.add(node);
        map.put(node, new Node(node.val));
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            Node currClone = map.get(curr);
            System.out.println("Value of Node " + currClone.val);
            System.out.println("Address of Node " + currClone);
            for(Node neighbour : curr.neighbors){
                if(!map.containsKey(neighbour)){
                    //clone he neighbor node and add it to map
                    map.put(neighbour, new Node(neighbour.val));
                    queue.add(neighbour);
                }
                currClone.neighbors.add(map.get(neighbour));
            }
        }
        return map.get(node);
    }

    public static void bfs(Node source)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(source);
        HashMap<Node,Boolean> visit =
                new HashMap<Node,Boolean>();
        visit.put(source,true);
        while (!q.isEmpty())
        {
            Node u = q.poll();
            System.out.println("Value of Node " + u.val);
            System.out.println("Address of Node " + u);
            if (u.neighbors != null)
            {
                List<Node> v = u.neighbors;
                for (Node g : v)
                {
                    if (visit.get(g) == null)
                    {
                        q.add(g);
                        visit.put(g,true);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        List<Node> v = new ArrayList<>();
        v.add(node2);
        v.add(node4);
        node1.neighbors = v;
        v = new ArrayList<>();
        v.add(node1);
        v.add(node3);
        node2.neighbors = v;
        v = new ArrayList<>();
        v.add(node2);
        v.add(node4);
        node3.neighbors = v;
        v = new ArrayList<>();
        v.add(node3);
        v.add(node1);
        node4.neighbors = v;

//        System.out.println(node1.val);
//        System.out.println(node2.val);
//        System.out.println(node3.val);
//        System.out.println(node4.val);

        System.out.println("BFS traversal of a graph before cloning");
        bfs(node1);
        System.out.println("BFS traversal of a graph after cloning");
        cloneGraph(node1);
    }
}
