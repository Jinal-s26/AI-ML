public class knighttour2 {
    public static int[][] arr;
    public static void main(String[] args) {
        displaytour(6);
    }

    private static void displaytour(int size) {tF
        arr = new int[size][size];
        checkposition(0,0,1);
    }

    private static boolean checkposition(int i, int j, int move) {
        int size = arr.length;
        if((i<0 || i>=size) || (j<0 || j>=size) || (arr[i][j]!=0)){
            return false;
        }
        if(move==size*size){
            printmat();
            return true;
        }
        //System.out.println(i+", "+j);
        arr[i][j] = move;
        checkposition(i+2, j+1, move+1);
        checkposition(i+2, j-1, move+1);
        checkposition(i-2, j+1, move+1);
        checkposition(i-2, j-1, move+1);
        checkposition(j+2, i-1, move+1);
        checkposition(j+2, i+1, move+1);
        checkposition(j-2, i-1, move+1);
        checkposition(j-2, i-1, move+1);
        arr[i][j] = 0;
        return false;

    }

    private static void printmat() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                String str = Integer.toString(arr[i][j]);
                if(str.length()==1){
                    str = "0"+str; 
                }
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println("==========/n");
    }
}
