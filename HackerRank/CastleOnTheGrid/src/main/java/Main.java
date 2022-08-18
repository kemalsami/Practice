import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class Main {

    /**
     *
     * OUTPUT_PATH değeri "Edit Configurations" altında parametre olarak tanımlanmıştır
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {


        System.out.println("Castle on the Grid");

        //System.out.println(System.getenv("OUTPUT_PATH"));
        List<String> grid = new ArrayList<>();
        int problemCase=9;
        int result=-1;

        switch (problemCase){
            case 0:
                grid.add(".X.");
                grid.add(".X.");
                grid.add("...");
                result = Solution.minimumMoves(grid, 0, 0, 0, 2);
                break;

            case 9:
                grid.add(".X..XX...X");
                grid.add("X.........");
                grid.add(".X.......X");
                grid.add("..........");
                grid.add("........X.");
                grid.add(".X...XXX..");
                grid.add(".....X..XX");
                grid.add(".....X.X..");
                grid.add("..........");
                grid.add(".....X..XX");
                result = Solution.minimumMoves(grid, 9, 1, 9, 6);
                break;
        }


        System.out.println("RESULT " + result);


        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
         */

    }

}
