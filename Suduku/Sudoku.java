import java.util.Arrays;
import java.io.FileNotFoundException;
public class Sudoku {
    public static void main(String[] args) throws {
        int [][] data = new int[9][9];
        data = readData();
        System.out.println(isValid);
    

    }

    public static int [][] readData(){
        int[][] data = new int[9][9];
        FileInputStream fis = new FileInputStream("C:\Users\shish\Desktop\Suduku\data.txt");
        Scanner sc = new Scanner(fis);
        for(int i=0; i<data.length;i++){
            for(int j=0;j<data.length;j++){
                data[i][j] = sc.nextInt();
            }
        }
    }

    public static boolean beginCheck(int [][] data ){
        for(int row = 0; row< data.length; row++){
            for(int col = 0; col< data.length; col++){
                if((data[row][col] < 1) || (data[row][col]>9) || (!rowAndColumnWiseCheck(data, row, column)))
                    return false;
            
            }
        }
        return true;
    }

public static boolean rowAndColumnWiseCheck( int[][] data, int i, int j) {  // checking the index of i and j
    //CHECK Rows
    for( int col =0; col<data.length; col++){
        if(j!= col && data[i][j]== data[i][col])    // Making sure so that Same value must not be repeated on the same vertical or horizantal line
            return false;
    }

    // Checking columns 
    for( int row =0; row<data.length; row++){
        if(j!= row && data[i][j]== data[row][j])    // Making sure so that Same value must not be repeated on the same vertical or horizantal line
            return false;

    return true;
    }

}
}
