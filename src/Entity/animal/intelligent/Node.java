package Entity.animal.intelligent;

public class Node {
    private int h;
    private int g;
    private int f;
    private int row;
    private int col;
    private boolean is_block;   // This variable to check if the object is blocks.
    private Node parent;

    // Constructor to create object Node.
    public Node(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }

    // Method Getter h
    public int getH() {
        return h;
    }

    // Method Setter h
    public void setH(int h) {
        this.h = h;
    }

    // Method Getter g
    public int getG() {
        return g;
    }

    // Method Setter g
    public void setG(int g) {
        this.g = g;
    }

    // Method Getter f
    public int getF() {
        return f;
    }

    // Method Setter f
    public void setF(int f) {
        this.f = f;
    }

    // Method Getter row
    public int getRow() {
        return row;
    }

    // Method Setter row
    public void setRow(int row) {
        this.row = row;
    }

    // Method Getter column
    public int getCol() {
        return col;
    }

    // Method Setter column
    public void setCol(int col) {
        this.col = col;
    }

    // Method Getter return boolean check if "is block?"
    public boolean isIs_block() {
        return is_block;
    }

    // Method Setter set boolean variable to "is block?"
    public void setIs_block(boolean is_block) {
        this.is_block = is_block;
    }

    // Method Getter to return parent object in Node class
    public Node getParent() {
        return parent;
    }

    // Method Setter to set parent object
    public void setParent(Node parent) {
        this.parent = parent;
    }

    // Method calculateHeuristic() with parameter final_node in Node class to apply AI in Doll enemy.
    public void calculateHeuristic(Node final_node) {
        this.h = Math.abs(final_node.getRow() - getRow()) + Math.abs(final_node.getCol() - getCol());
    }

    public void setNodeData(Node current_node) {
        int g_cost = current_node.getG();
        setParent(current_node);
        setG(g_cost);
        calculateFinalCost();
    }

    public boolean checkBetterPath(Node current_node) {
        int g_cost = current_node.getG();
        if (g_cost < getG()) {
            setNodeData(current_node);
            return true;
        }
        return false;
    }

    public void calculateFinalCost() {
        int final_cost = getG() + getH();
        setF(final_cost);
    }

    // Override "equals" method with obj parameter in Object class to determine the feature in game.
    @Override
    public boolean equals(Object obj) {
        Node other = (Node) obj;
        return this.getRow() == other.getRow() && this.getCol() == other.getCol();
    }

    // Override output string statement
    @Override
    public String toString() {
        return "Node[row=" + row + ",col=" + col + "]";
    }
}
