import java.util.Arrays;
import java.util.List;

class Point{
    int x,y;

    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

/**
 * Akla gelen ilk çözüm "Time limit exceeded" durumuna takılmıştır
 */
public class SolutionRecursive {

    private static int resultCount=Integer.MAX_VALUE;
    public static String[][] strToArray(List<String> grid){
        if(grid==null || grid.size()==0)
            return null;

        String[][] gridArray = new String[grid.size()][grid.get(0).length()];
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid.get(i).length(); j++){
                gridArray[i][j] = "" + grid.get(i).charAt(j);
            }
        }
        return gridArray;
    }

    public static void printGridArray(String[][] gridArray){
        for(int i=0 ; i<gridArray.length ; i++){
            for(int j=0 ; j<gridArray[i].length ; j++){
                System.out.print(gridArray[i][j]);
            }
            System.out.println();
        }
    }



    public static void travelOnGridArray(String[][] gridArray, Point start , Point goal , Point prePoint , int count){

        //System.out.printf("Travel on Grid %d %d %d %d \n" , start.x, start.y, goal.x, goal.y);
        //printGridArray(gridArray);

        if(start.x==goal.x && start.y==goal.y){
            if(count < resultCount)
                resultCount = count;
        }


        // check boundry
        boolean inBoundry = false;
        try{
            String pos = gridArray[start.x][start.y];
            if(!pos.equalsIgnoreCase("X")){
                String[][] copyGrid= Arrays.stream(gridArray)
                        .map(a ->  Arrays.copyOf(a, a.length))
                        .toArray(String[][]::new);

                copyGrid[start.x][start.y] = "X";

                // pass-by-value ERROR ???
                //gridArray[start.x][start.y] = "X";

                // recursive call
                travelOnGridArray(copyGrid , new Point(start.x+1, start.y), goal , start , prePoint!=null && prePoint.y==start.y ? count : Integer.valueOf(count+1));
                travelOnGridArray(copyGrid , new Point(start.x, start.y+1), goal , start , prePoint!=null && prePoint.x==start.x ? count : Integer.valueOf(count+1));
                travelOnGridArray(copyGrid , new Point(start.x-1, start.y), goal , start , prePoint!=null && prePoint.y==start.y ? count : Integer.valueOf(count+1));
                travelOnGridArray(copyGrid , new Point(start.x, start.y-1), goal , start , prePoint!=null && prePoint.x==start.x ? count : Integer.valueOf(count+1));
            }
        }catch (Exception e){
            //e.printStackTrace();
        }
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

        // string to array()
        System.out.println("----- ----- -----");
        System.out.println("STRING TO GRID ARRAY");
        String[][] gridArray = strToArray(grid);
        printGridArray(gridArray);

        System.out.println("----- ----- -----");
        System.out.println("STRING TO GRID ARRAY");
        travelOnGridArray(gridArray, new Point(startX, startY), new Point(goalX, goalY),null,0);

        /**
         * Öncelikle başlangıç noktasından varış noktasına nasıl gidileceği hesaplanır
         *
         * start noktasından goal noktasına herhangi bir şekilde gidebilir - yukarı aşağıya sağa ya da sola gibi
         */


        /**
         * soru recursive degerlendirilebilir (greedy algoritması gibi) iki nokta birbiri için 4 secenekten ikisini barındıracaktır
         *
         * bunun anlamı gidilecek değer sağ & üst veye sağ & alt gibi aslında iki seçenekli bir yol barındırmaktadır
         */

        /**
         * soru tek tek gidiliyormus gibi çözülüp sonunda merge edilme sağlanabilir
         *
         * örneğin (0,0) noktasından (0,1) noktasında ve sonrasında (0,2) noksasına gelsin. en son adım olarak (0,2) noktasından da (1,2) noktasına geçsin diyelim
         *
         *  (0,0) -> (0,1) -> (0,2) noktaları (0,0) -> (0,2) olarak merge edilebilir
         */

        /**
         * bir diğer husus ise gidilen noktalar bir daha gibilmemesi için işaret konulabilir
         *
         * (0,0) -> (0,1) -> (0,2) -> (0,1)* gibi durum olmamalı
         */

        /**
         * start noktasından goal noktasına birden fazla karmaşık yol olabilir
         *
         * her bir yol bulunup merge edilip bu yollar arasında en kısasına bakılmalıdır
         */

        return resultCount;
    }

}
