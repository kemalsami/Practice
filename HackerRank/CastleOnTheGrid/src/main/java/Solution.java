import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void printGridArray(ArrayList<ArrayList<Integer>> gridArrayList){
        for(int i=0 ; i<gridArrayList.size() ; i++){
            System.out.print( i + " -- ");
            for(int j=0 ; gridArrayList.get(i)!=null && j<gridArrayList.get(i).size() ; j++){
                System.out.print(gridArrayList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> createAdjacencyMatrix(List<String> grid){

        if(grid==null || grid.size()==0)
            return null;

        ArrayList<ArrayList<Integer>> adjacencyMatrix = new ArrayList<>();
        for(int i=0; i<grid.size() * grid.size(); i++){

            ArrayList<Integer> adjacentList = new ArrayList<>();
            int row = i/grid.size();
            int column = i%grid.size();

            // check current character X or not
            if(grid.get(row).charAt(column)=='X'){
                adjacencyMatrix.add(new ArrayList<>());
                continue;
            }


            // look row adjacency
            String currentLine = grid.get(row);
            for(int j=column+1, c=1; j<currentLine.length(); j++, c++){
                if(currentLine.charAt(j)=='X')
                    break;

                adjacentList.add(i+c);
            }

            for(int j=column-1, c=1; j>=0; j--, c++){
                if(currentLine.charAt(j)=='X')
                    break;

                adjacentList.add(i-c);
            }

            // look column adjacency
            for(int j=row-1, c=1; j>=0; j--, c++){
                if(grid.get(j).charAt(column)=='X')
                    break;

                adjacentList.add(i-(c*grid.size()));
            }

            for(int j=row+1, c=1; j<grid.size(); j++, c++){
                if(grid.get(j).charAt(column)=='X')
                    break;

                adjacentList.add(i+(c*grid.size()));
            }
            adjacencyMatrix.add(adjacentList);
        }
        return adjacencyMatrix;
    }

    public static int BFS(ArrayList<ArrayList<Integer>> adjacencyMatrix, int start, int goal){
        LinkedList<Integer> queue = new LinkedList<>();
        int[] prev = new int[adjacencyMatrix.size()];                   // previous adjacency
        int[] dist = new int[adjacencyMatrix.size()];                   // distance size
        boolean[] visitedList = new boolean[adjacencyMatrix.size()];    // visited

        queue.add(start);
        dist[start] = 0;
        visitedList[start] = true;

        while(!queue.isEmpty()){

            int visited = queue.remove();
            for(int i=0; i<adjacencyMatrix.get(visited).size(); i++){
                int adjPoint = adjacencyMatrix.get(visited).get(i);
                if(visitedList[adjPoint]==false){
                    visitedList[adjPoint] = true;                       // set point to visited
                    queue.add(adjPoint);                                // add to queue
                    prev[adjPoint] = visited;                           // set previous point
                    dist[adjPoint] = dist[visited] + 1;                 // set distance size

                    if(adjacencyMatrix.get(visited).get(i)==goal){
                        // TODO: Burada problemin durumuna göre istenilen sonuç dönülebilir
                        return dist[adjPoint];
                    }
                }
            }
        }

        return -1;

    }

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {

        ArrayList<ArrayList<Integer>> adjacencyMatrix = createAdjacencyMatrix(grid);

        printGridArray(adjacencyMatrix);

        return BFS(adjacencyMatrix , grid.size()*startX+startY , grid.size()*goalX+goalY);
    }

}
