// Assuming the class has the following structure:
// class Node {
//     Node prev;
//     Node next;
//     // Other fields and methods
// }

// class Edge {
//     Node start;
//     Node end;
//     Edge prevInTree;
//     Edge nextInTree;
//     // Other fields and methods
// }

public void removeFromTreeEdgeList() {
    if (this.prevInTree != null) {
        this.prevInTree.nextInTree = this.nextInTree;
    }
    if (this.nextInTree != null) {
        this.nextInTree.prevInTree = this.prevInTree;
    }
    this.prevInTree = null;
    this.nextInTree = null;
}