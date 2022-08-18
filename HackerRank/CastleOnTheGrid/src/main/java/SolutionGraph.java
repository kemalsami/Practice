import java.util.*;

class SPoint{
    int x,y;

    SPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof SPoint)) return false;
        SPoint obj = (SPoint)o;
        return this.x==obj.x && this.y==obj.y;
    }

    public int hashCode(){
        return x + y;
    }
}

class Graph{

    int vertex;

    int edge;

    // Adjacency matrix
    int[][] adjacencyMatrix;

    // Function to fill the empty
    // adjacency matrix
    Graph(int v, int e)
    {
        this.vertex = v;
        this.edge = e;

        adjacencyMatrix = new int[v][v];
        for(int row = 0; row < v; row++)
            Arrays.fill(adjacencyMatrix[row], 0);
    }

    Graph(){
    }

    public void setAdjacencyMatrix(List<String> grid){

        if(grid==null || grid.size()==0)
            this.adjacencyMatrix = null;

        this.vertex = grid.size()*grid.size();
        this.adjacencyMatrix = new int[this.vertex][this.vertex];
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid.size(); j++){

                if(grid.get(i).charAt(j)!='X'){

                    try{
                        if(grid.get(i).charAt(j+1)!='X'){
                            this.adjacencyMatrix[i*grid.size()+j][i*grid.size()+j+1] = 1;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        if(grid.get(i).charAt(j-1)!='X'){
                            this.adjacencyMatrix[i*grid.size()+j][i*grid.size()+j-1] = 1;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        if(grid.get(i+1).charAt(j)!='X'){
                            this.adjacencyMatrix[i*grid.size()+j][(i+1)*grid.size()+j] = 1;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        if(grid.get(i-1).charAt(j)!='X'){
                            this.adjacencyMatrix[i*grid.size()+j][(i-1)*grid.size()+j] = 1;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }

            }
        }
    }


    // Function to add an edge to the graph
    void addEdge(int start, int e)
    {
        // Considering a bidirectional edge
        this.adjacencyMatrix[start][e] = 1;
        this.adjacencyMatrix[e][start] = 1;
    }

    // Function to perform BFS on the graph
    void BFS(int start , int goal)
    {

        // Visited vector to so that
        // a vertex is not visited more than once
        // Initializing the vector to false as no
        // vertex is visited at the beginning
        int count=Integer.MAX_VALUE;
        boolean[] visited = new boolean[this.vertex];
        Arrays.fill(visited, false);
        List<Integer> q = new ArrayList<>();
        q.add(start);

        // Set source as visited
        visited[start] = true;

        int vis;
        while (!q.isEmpty())
        {
            vis = q.get(0);

            // Print the current node
            System.out.print(vis + " ");
            q.remove(q.get(0));

            // For every adjacent vertex to
            // the current vertex
            for(int i = 0; i < this.vertex; i++)
            {
                if (this.adjacencyMatrix[vis][i] == 1 && (!visited[i]))
                {

                    // Push the adjacent node to
                    // the queue
                    q.add(i);

                    // Set
                    visited[i] = true;

                    if(i == goal){
                        // Calculate count
                        int listCount = calculateCount(q);
                        count = listCount < count ? listCount : count;

                        System.out.println("--------------------");
                        System.out.println("List : " + q.toString());
                        System.out.println("Size : " + listCount);
                    }

                }
            }
        }
    }

    int calculateCount(List<Integer> q){
        int count=0;
        int diff=0;
        for(int i=0; i<q.size()-1; i++){

            int newDiff = q.get(i) - q.get(i+1);
            if(newDiff!=diff){
                diff = newDiff;
                count++;
            }

        }

        return count;
    }
}

/**
 *  1- Bu çözümde verilen grid listesi öncelikle graph data structure yapısına çevrilecektir
 *  2- Graph ile depth-first traversal & breadth-first traversal yaklaşımları denenecektir
 *
 *      . X .
 *      . X .
 *      . . .
 *
 *
 *  - https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
 *
 */
public class SolutionGraph {

    private static int scount=Integer.MAX_VALUE;
    private static Set<Integer> set = new HashSet<>();

    private static List<Integer> list = new ArrayList<>();

    public static void printGridArray(int[][] gridArray){
        for(int i=0 ; i<gridArray.length ; i++){

            System.out.print( i + " -- ");

            for(int j=0 ; j<gridArray[i].length ; j++){
                System.out.print(gridArray[i][j]);
            }
            System.out.println();
        }
    }

    /**
     *  Start
     *
     */
    public static int[][] adjacencyMatrix(List<String> grid){

        if(grid==null || grid.size()==0)
            return null;

        int[][] gridArray = new int[grid.size()*grid.size()][grid.size()*grid.size()];
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid.size(); j++){

                if(grid.get(i).charAt(j)!='X'){

                    try{
                        if(grid.get(i).charAt(j+1)!='X'){
                            gridArray[i*grid.size()+j][i*grid.size()+j+1] = 1;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        if(grid.get(i).charAt(j-1)!='X'){
                            gridArray[i*grid.size()+j][i*grid.size()+j-1] = 1;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        if(grid.get(i+1).charAt(j)!='X'){
                            gridArray[i*grid.size()+j][(i+1)*grid.size()+j] = 1;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        if(grid.get(i-1).charAt(j)!='X'){
                            gridArray[i*grid.size()+j][(i-1)*grid.size()+j] = 1;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }

            }
        }

        return gridArray;
    }



    public static void printGridArray(ArrayList<ArrayList<Integer>> gridArrayList){

        for(int i=0 ; i<gridArrayList.size() ; i++){
            System.out.print( i + " -- ");
            for(int j=0 ; gridArrayList.get(i)!=null && j<gridArrayList.get(i).size() ; j++){
                    System.out.print(gridArrayList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> adjacencyMatrixArrayList(List<String> grid){

        if(grid==null || grid.size()==0)
            return null;

        ArrayList<ArrayList<Integer>> gridArrayList = new ArrayList<>(grid.size() * grid.size());
        for(int i=0; i<grid.size() * grid.size(); i++){
            gridArrayList.add(null);
        }

        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid.size(); j++){

                ArrayList<Integer> edgeList = new ArrayList<Integer>();

                if(grid.get(i).charAt(j)!='X'){

                    try{
                        if(grid.get(i).charAt(j+1)!='X'){
                            edgeList.add(i*grid.size()+j+1);
                            //gridArray[i*grid.size()+j][i*grid.size()+j+1] = 1;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        if(grid.get(i).charAt(j-1)!='X'){
                            //gridArray[i*grid.size()+j][i*grid.size()+j-1] = 1;
                            edgeList.add(i*grid.size()+j-1);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        if(grid.get(i+1).charAt(j)!='X'){
                            //gridArray[i*grid.size()+j][(i+1)*grid.size()+j] = 1;
                            edgeList.add((i+1)*grid.size()+j);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        if(grid.get(i-1).charAt(j)!='X'){
                            //gridArray[i*grid.size()+j][(i-1)*grid.size()+j] = 1;
                            edgeList.add((i-1)*grid.size()+j);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    gridArrayList.set(i*grid.size()+j,edgeList);
                }

            }
        }
        return gridArrayList;
    }

    public static void travelOnAdjacencyMatrix(int[][] gridArray , int prev, int start , int goal, int count){

        //System.out.println("----- travelOnAdjacencyMatrix -----");
        //printGridArray(gridArray);

        if(start==goal){
            // System.out.println("Path found...");
            if(count < scount){
                scount = count;

                if(false && count < 20){
                    System.out.println("\nPath Count : " + count);
                    System.out.println("\nPath : " + list.toString());
                }
            }
        }

        for(int i=0; i<gridArray.length; i++){
            if(gridArray[start][i]==1 && !set.contains(i)){
                set.add(i);
                list.add(i);
                //gridArray[start][i] = 0;


                travelOnAdjacencyMatrix(gridArray, start, i, goal, (prev==-1 || (prev-start)==(start-i)) ? Integer.valueOf(count+1) : count);

                set.remove(i);
                list.remove(list.size()-1);
            }
        }

    }






    // function to print the shortest distance and path
    // between source vertex and destination vertex
    private static LinkedList<Integer> findShortestDistance(
            ArrayList<ArrayList<Integer>> adj,
            int s, int dest, int v)
    {
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from s
        int pred[] = new int[v];
        int dist[] = new int[v];

        if (BFS(adj, s, dest, v, pred, dist) == false) {
            System.out.println("Given source and destination" +
                    "are not connected");
            return null;
        }

        // LinkedList to store path
        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        /*
        // Print distance
        System.out.println("Shortest path length is: " + dist[dest]);

        // Print path
        System.out.print("Path is ::");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
         */

        return path;

    }


    // a modified version of BFS that stores predecessor
    // of each vertex in array pred
    // and its distance from source in array dist
    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
                               int dest, int v, int pred[], int dist[])
    {
        // a queue to maintain queue of vertices whose
        // adjacency list is to be scanned as per normal
        // BFS algorithm using LinkedList of Integer type
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        boolean visited[] = new boolean[v];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        // bfs Algorithm
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (visited[adj.get(u).get(i)] == false) {
                    visited[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));

                    // stopping condition (when we find
                    // our destination)
                    if (adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }






    public static ArrayList<ArrayList<Integer>> createAdjacencyMatrix(List<String> grid){

        if(grid==null || grid.size()==0)
            return null;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0; i<grid.size() * grid.size(); i++){

            ArrayList<Integer> adjacencyList = new ArrayList<>();

            int row = i/grid.size();
            int column = i%grid.size();
            if(grid.get(row).charAt(column)=='X'){
                list.add(adjacencyList);
                continue;
            }


            // check for same row
            String ith_Line = grid.get(row);
            for(int j=column+1, c=1; j<ith_Line.length(); c++,j++){
                if(ith_Line.charAt(j)=='X')
                    break;

                adjacencyList.add(i+c);
            }

            for(int j=column-1, c=1; j>=0; j--,c++){
                // j 2,1,0
                if(ith_Line.charAt(j)=='X')
                    break;

                adjacencyList.add(i-c);
            }

            // check for same column
            for(int j=row+1; j<grid.size(); j++){
                String jth_Line = grid.get(j);
                if(jth_Line.charAt(column)=='X')
                    break;

                adjacencyList.add(j*grid.size() + column);
            }

            for(int j=row-1; j>=0; j--){
                String jth_Line = grid.get(j);
                if(jth_Line.charAt(column)=='X')
                    break;

                adjacencyList.add(j*grid.size() + column);
            }

            list.add(adjacencyList);

        }

        return list;
    }

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER startX
     *  3. INTEGER startY
     *  4. INTEGER goalX
     *  5. INTEGER goalY
     */
    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {

        /*
        int[][] gridArray = adjacencyMatrix(grid);
        printGridArray(gridArray);


        System.out.println("Finding Path...");
        set.add(grid.size()*startX+startY);
        travelOnAdjacencyMatrix(gridArray , -1 , grid.size()*startX+startY , grid.size()*goalX+goalY, 0) ;
         */

        /*
        Graph graph = new Graph();
        graph.setAdjacencyMatrix(grid);
        printGridArray(graph.adjacencyMatrix);
        graph.BFS(grid.size()*startX+startY , grid.size()*goalX+goalY);
         */

        /*
        ArrayList<ArrayList<Integer>> adjacencyMatrixArrayList = adjacencyMatrixArrayList(grid);
        printGridArray(adjacencyMatrixArrayList);
        printShortestDistance(adjacencyMatrixArrayList, 91, 96, adjacencyMatrixArrayList.size());
         */

        /**
         *
         *  1- create adjacency matrix from List<String> grid
         *      1.1- Adjacency matrix size should be square of grid size
         *      1.2- Adjacency points should be select carefully
         *
         *          Example: In below example, (0,0) adjacent with (0,1), (0,2), (0,3), (1,0), (2,0)
         *              . . . .
         *              . X . X
         *              . . . X
         *              X . . .
         *
         *  2- Find shortest path by using BST
         */

        ArrayList<ArrayList<Integer>> adjacencyMatrixArrayList = createAdjacencyMatrix(grid);
        printGridArray(adjacencyMatrixArrayList);
        LinkedList<Integer> path = findShortestDistance(adjacencyMatrixArrayList, grid.size()*startX+startY , grid.size()*goalX+goalY, adjacencyMatrixArrayList.size());
        return path.size()-1;
    }

}
