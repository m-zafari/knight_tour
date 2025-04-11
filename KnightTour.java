import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author MohammadZafari <mhdzafari80@gmail.com>
 */
public class KnightTour {

    Scanner scanner = new Scanner(System.in);

    public KnightTour(int a, int b) {
        X = a;
        Y = b;
    }
    public final int N = 8;
    final int X;
    final int Y;
    public int NEXTx_check = 100;
    public int NEXTy_ckeck = 100;
    public int NEXTx = 0;
    public int NEXTy = 0;
    public final int[] xNext = {-2, -2, -1, -1, 1, 1, 2, 2};
    public final int[] yNext = {-1, 1, 2, -2, 2, -2, 1, -1};
    final int[][] P = {
        {2, 3, 4, 4, 4, 4, 3, 2},
        {3, 4, 6, 6, 6, 6, 4, 3},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {3, 4, 6, 6, 6, 6, 4, 3},
        {2, 3, 4, 4, 4, 4, 3, 2}};

    public void NumPlace(int i, int j) {
        System.out.println("\nnum of possible move:");
        System.out.println(P[i][j]);
    }

    public void Place(int x, int y) {
        System.out.println("\npossible next move:");
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if ((x - i) * (x - i) + (y - j) * (y - j) == 5) {
                    System.out.println("(" + i + "," + j + ")");
                }
            }
        }
    }
    

    //is used by findMin();
    public boolean isOK(int x, int y, int path[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && path[x][y] == -1);
    }

    //find next move;
    public void findMin(int i, int j, int path[][]) {
    	
    	Random randomno = new Random();
    	ArrayList<Integer> temp_a = new ArrayList<Integer>();
    	ArrayList<Integer> temp_b = new ArrayList<Integer>();
    	int Min = 100;
    
        for (int k = 0; k < 8; k++) {

            int nex_x = i + xNext[k];
            int nex_y = j + yNext[k];

            if (isOK(nex_x, nex_y, path)){
            	if(P[nex_x][nex_y] <= Min) {
            		Min = P[nex_x][nex_y];
            		temp_a.add(nex_x);
            		temp_b.add(nex_y);
            	}
            }	
        if(temp_a.size() > 0) {
        	int index = randomno.nextInt(temp_a.size());
        	//System.out.println(index);
        	NEXTx = temp_a.get(index);
        	NEXTy = temp_b.get(index);
        }
       }
    }

    public void printSolution(int path[][]) {
    	System.out.println("\nHamilton knight tour:");
    	for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.printf("%2d ",path[x][y] );
            }
        System.out.println();
        }
    }

    public boolean solve() {
        int path[][] = {
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},};

        path[X][Y] = 0;

        if (!solveUtil(X, Y, 1, path)) {
        	printSolution(path);
            System.out.println("\nThe path was not completed.");
            return false;
        } 
        else {
            printSolution(path);
        }

        return true;
    }

    public boolean solveUtil(int x, int y, int movei, int path[][]) {
                
        if (movei == N * N) {
            return true;
        }
        
        NEXTx_check = NEXTx;
        NEXTy_ckeck = NEXTy;
        
        findMin(x, y, path);
        
        if (NEXTx_check == NEXTx & NEXTy_ckeck == NEXTy) {
        	return false;
        }
        path[NEXTx][NEXTy] = movei;
        
        return solveUtil(NEXTx, NEXTy, movei + 1,path);
    }
}
