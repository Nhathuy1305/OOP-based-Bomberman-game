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

    private boolean isFinalNode(Node current_node) {
        return current_node.equals(final_node);
    }

    private boolean isEmpty(PriorityQueue<Node> open_list) {
        return open_list.size() == 0;
    }

    private void setBlock(int row, int col) {
        this.search_area[row][col].setIs_block(true);
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
            setBlock(row, col);
        }
    }

    public List<Node> findPath() {
        open_list.add(initial_node);
        while (!isEmpty(open_list)) {
            Node current_node = open_list.poll();
            closed_set.add(current_node);
            assert current_node != null;
            if (isFinalNode(current_node)) {
                return getPath(current_node);
            } else {
                addAdjacentNodes(current_node);
            }
        }
        return new ArrayList<Node>();
    }

    public List<Node> getPath(Node current_node) {
        List<Node> path = new ArrayList<Node>();
        path.add(current_node);
        Node parent;
        while ((parent = current_node.getParent()) != null) {
            path.add(0, parent);
            current_node = parent;
        }
        return path;
    }

    private void checkNode(Node current_node, int col, int row) {
        Node adjacent_node = getSearch_area()[row][col];
        if (!adjacent_node.isIs_block() && !getClosed_set().contains(adjacent_node)) {
            if (!getOpen_list().contains(adjacent_node)) {
                adjacent_node.setNodeData(current_node);
                getOpen_list().add(adjacent_node);
            } else {
                boolean changed = adjacent_node.checkBetterPath(current_node);
                if (changed) {
                    getOpen_list().remove(adjacent_node);
                    getOpen_list().add(adjacent_node);
                }
            }
        }
    }

    private void addAdjacentUpperRow(Node current_node) {
        int row = current_node.getRow();
        int col = current_node.getCol();
        int upper_row = row - 1;
        if (upper_row >= 0) {
            if (col - 1 >= 0) {
                checkNode(current_node, col - 1, upper_row);
            }
            if (col + 1 < getSearch_area()[0].length) {
                checkNode(current_node, col + 1, upper_row);
            }
            checkNode(current_node, col, upper_row);
        }
    }

    private void addAdjacentLowerRow(Node current_node) {
        int row = current_node.getRow();
        int col = current_node.getCol();
        int lower_row = row + 1;
        if (lower_row < getSearch_area().length) {
            if (col - 1 >= 0) {
                checkNode(current_node, col - 1, lower_row);
            }
            if (col + 1 < getSearch_area()[0].length) {
                checkNode(current_node, col + 1, lower_row);
            }
            checkNode(current_node, col, lower_row);
        }
    }

    private void addAdjacentMiddleRow(Node current_node) {
        int row = current_node.getRow();
        int col = current_node.getCol();
        if (col - 1 >= 0) {
            checkNode(current_node, col - 1, row);
        }
        if (col + 1 < getSearch_area()[0].length) {
            checkNode(current_node, col + 1, row);
        }
    }

    private void addAdjacentNodes(Node current_node) {
        addAdjacentUpperRow(current_node);
        addAdjacentLowerRow(current_node);
        addAdjacentMiddleRow(current_node);
    }
}
