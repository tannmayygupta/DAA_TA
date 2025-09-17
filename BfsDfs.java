import java.util.*;

public class BfsDfs {

    int V;
    int[][] adjMatrix;
    List<List<Integer>> adjList;

    public BfsDfs(int V) {
        this.V = V;
        
        adjMatrix = new int[V][V];
        
        adjList = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        
        adjMatrix[v][u] = 1;
        
        adjList.get(u).add(v);
        
        adjList.get(v).add(u);
    }



    private void dfsList(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        
        for (int u : adjList.get(v)) {
            if (visited[u] == false) {
                dfsList(u, visited);
            }
        }
    }

    public void DFS_List(int start) {
        
        boolean[] visited = new boolean[V];

        System.out.print("DFS (Adjacency List): ");
        
        dfsList(start, visited);
        
        System.out.println();
    }

    public void BFS_List(int start) {
        boolean[] visited = new boolean[V];
        
        Queue<Integer> q = new LinkedList<>();
        
        visited[start] = true;
        
        q.add(start);

        System.out.print("BFS (Adjacency List): ");
        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");
            for (int u : adjList.get(v)) {
                if (!visited[u]) {
                    visited[u] = true;
                    q.add(u);
                }
            }
        }
        
        System.out.println();
    }

    private void dfsMatrixUtil(int v, boolean[] visited) {
        
        visited[v] = true;
        
        System.out.print(v + " ");
        
        for (int u = 0; u < V; u++) {
            if (adjMatrix[v][u] == 1 && !visited[u]) {
                dfsMatrixUtil(u, visited);
            }
        }
    }

    public void DFS_Matrix(int start) {
        
        boolean[] visited = new boolean[V];
        
        System.out.print("DFS (Adjacency Matrix): ");
        
        dfsMatrixUtil(start, visited);
        
        System.out.println();
    }

    public void BFS_Matrix(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        System.out.print("BFS (Adjacency Matrix): ");
        
        while (!q.isEmpty()) {
            
            int v = q.poll();

            System.out.print(v + " ");
            
            for (int u = 0; u < V; u++) {
                if (adjMatrix[v][u] == 1 && !visited[u]) {
                    visited[u] = true;
                    q.add(u);
                }
            
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int V = 5;
        
        BfsDfs g = new BfsDfs(V);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        g.DFS_List(0);
        g.BFS_List(0);
        g.DFS_Matrix(0);
        g.BFS_Matrix(0);
    }
}
