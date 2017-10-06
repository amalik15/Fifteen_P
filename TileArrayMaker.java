import java.util.Random;

public class TileArrayMaker {

    //create a shuffled tile array array for the game. Also the shuffle will have a game complexity lower than 105
    public static void createTials(Tiles tile[], int tileNum) {
        int numArray[] = new int[tileNum];
        int complexityArray[] = new int[tileNum];
        int complexity = 105;

        while (complexity > 104) {
            numArray = arrayRandom(tileNum);
            for (int i = 0; i < tileNum; i++) {
                int base = numArray[i];
                int counter = 0;

                for (int j = i + 1; j < tileNum; j++) {
                    if (numArray[j] < base) {
                        counter++;
                    }
                }
                complexityArray[i] = counter;
            }
            complexity = 0;
            for (int i = 0; i < tileNum; i++) {
                complexity += complexityArray[i];
            }

            MoveHistory.complexity = complexity;
        }

        String[] tmp = new String[tile.length];
        for (int i = 0; i < tileNum; i++) {
            tile[i] = new Tiles();
            if (numArray[i] == tileNum - 1) {
                tile[i].setArrayLocation(i);
                tile[i].setTileContent(" ");
                tmp[i] = " ";
            }
            else {
                tile[i].setArrayLocation(i);
                tile[i].setTileContent(Integer.toString(numArray[i] + 1));
                tmp[i] = Integer.toString(numArray[i] + 1);
            }

        }
        MoveHistory.stack.push(tmp);
        MoveHistory.moveNum++;

    }

    //return a suffled array
    public static int[] arrayRandom(int size) {
        int array1[] = new int[size];
        int array2[] = new int[size];

        for (int i = 0; i < size; i++) {
            array1[i] = i;
        }

        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int index = random.nextInt(16);

            if (array1[index] != 999) {
                array2[i] = array1[index] + 1;
                array1[index] = 999;
            } else {
                i--;
            }
        }
        return array2;
    }

    //set the neighbors of all the buttons
    public static void setNeighbors(Tiles tile[], int tileNum) {
        tile[0].setNeighbors(-1, -1, 1, 4);
        tile[1].setNeighbors(0, -1, 2, 5);
        tile[2].setNeighbors(1, -1, 3, 6);
        tile[3].setNeighbors(2, -1, -1, 7);
        tile[4].setNeighbors(-1, 0, 5, 8);
        tile[5].setNeighbors(4, 1, 6, 9);
        tile[6].setNeighbors(5, 2, 7, 10);
        tile[7].setNeighbors(6, 3, -1, 11);
        tile[8].setNeighbors(-1, 4, 9, 12);
        tile[9].setNeighbors(8, 5, 10, 13);
        tile[10].setNeighbors(9, 6, 11, 14);
        tile[11].setNeighbors(10, 7, -1, 15);
        tile[12].setNeighbors(-1, 8, 13, -1);
        tile[13].setNeighbors(12, 9, 14, -1);
        tile[14].setNeighbors(13, 10, 15, -1);
        tile[15].setNeighbors(14, 11, -1, -1);
    }
}