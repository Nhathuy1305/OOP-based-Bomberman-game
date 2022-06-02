package Entity.animal.intelligent;

// Import library
import java.util.*;

public class AStar {
    private Node[][] search_area;
    private PriorityQueue<Node> open_list;
    private Set<Node> closed_set;
    private Node initial_node;
    private Node final_node;

    public Node[][] getSearch_area() {
        return search_area;
    }

    public void setSearch_area(Node[][] search_area) {
        this.search_area = search_area;
    }

    public PriorityQueue<Node> getOpen_list() {
        return open_list;
    }

    public void setOpen_list(PriorityQueue<Node> open_list) {
        this.open_list = open_list;
    }

    public Set<Node> getClosed_set() {
        return closed_set;
    }

    public void setClosed_set(Set<Node> closed_set) {
        this.closed_set = closed_set;
    }

    public Node getInitial_node() {
        return initial_node;
    }

    public void setInitial_node(Node initial_node) {
        this.initial_node = initial_node;
    }

    public Node getFinal_node() {
        return final_node;
    }

    public void setFinal_node(Node final_node) {
        this.final_node = final_node;
    }

    public AStar(int rows, int cols, Node initial_node, Node final_node) {
        setInitial_node(initial_node);
        setFinal_node(final_node);
        this.search_area = new Node[rows][cols];
        this.open_list = new PriorityQueue<>(Comparator.comparing(Node::getF));
        this.closed_set = new HashSet<>();
        setNodes();
    }

    public void setNodes() {
        for (int i = 0; i < search_area.length; i++) {
            for (int j = 0; j < search_area[0].length; j++) {
                Node node = new Node(i, j);
                node.calculateHeuristic(getFinal_node());
                this.search_area[i][j] = node;
            }
        }
    }

    public void setBlocks(int[][] blocks_array, int count) {
        for (int i = 0; i < count; i++) {
            int row = blocks_array[i][0];
            int col = blocks_array[i][1];
            setBlocks(row, col);
        }
    }

    public List<Node> findPath() {
        open_list.add(initial_node);
        while ()
    }
}
