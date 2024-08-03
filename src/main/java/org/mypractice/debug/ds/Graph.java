package org.mypractice.debug.ds;


import java.util.*;

public class Graph {

    private Map<Node, List<Node>> adjMap;

    public Graph() {
        adjMap = new HashMap<>();
    }

    public boolean addNode(char a) {
        final Node temp = Node.valueOf(a);
        if (adjMap.containsKey(temp)) {
            return false;
        }
        adjMap.put(temp, new ArrayList<>());
        return true;
    }

    public void addEdge(char source, char destination) {
        Optional<Node> sourceNodeOptional = findNode(source);
        Optional<Node> destinationNodeOptional = findNode(destination);

        Node sourceNode = sourceNodeOptional.orElse(Node.valueOf(source));
        Node destinationNode = destinationNodeOptional.orElse(Node.valueOf(destination));
        if (sourceNodeOptional.isEmpty()) {
            adjMap.put(sourceNode,new ArrayList<>());
        }
        if (destinationNodeOptional.isEmpty()) {
            adjMap.put(destinationNode, new ArrayList<>());
        }
        adjMap.get(sourceNode).add(destinationNode);
    }

    public String findPath(char source, char destination) {
        Optional<Node> sourceOptional = findNode(source);
        Optional<Node> destinationOptional = findNode(destination);

        if (sourceOptional.isEmpty() || destinationOptional.isEmpty()) {
            return "";
        }

        Node sourceNode = sourceOptional.get();
        Node destinationNode = destinationOptional.get();

        bfsSearch(sourceNode, destinationNode);
        return printPath(sourceNode, destinationNode);
    }

    private void bfsSearch(Node source, Node destination) {
        adjMap.keySet().forEach(node -> node.setParent(null));
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(source);
        while (!deque.isEmpty()) {
            Node current = deque.poll();
            for (Node node: adjMap.get(current)) {
                node.setParent(current);
                if (node.equals(destination)) {
                    deque.clear();
                }
                deque.add(node);
            }
        }
    }

    private String printPath(Node source, Node node) {

        if (node.equals(source)) {
            return String.valueOf(node.getId());
        } else if (node.getParent() == null) {
            return null;
        }

        String parentPath = printPath(source, node.getParent());
        return parentPath == null ? null : parentPath + String.valueOf(node.getId());
    }



    private Optional<Node> findNode(char a) {
        return adjMap.keySet().stream().filter(node -> node.getId() == a).findAny();
    }

}
