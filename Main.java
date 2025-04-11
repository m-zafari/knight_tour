

import java.util.Scanner;

/**
 *
 * @author MohammadZafari <mhdzafari80@gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the place of knight:\nfor (x,y) in range (0,7) enter: x y\n");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			KnightTour knightTour = new KnightTour(x, y);
			KnightTour.NumPlace(x, y);
			KnightTour.Place(x, y);
			KnightTour.solve();
		}
    

    }
}
