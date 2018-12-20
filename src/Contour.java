import java.util.Scanner;
import java.util.Arrays;
public class Contour {
    private static boolean checkInclusion(String s1, String s2) {
        int [] map = new int [256];
        for (char ch : s1.toCharArray()) map [ch] ++;
        for (int idx = 0, start = 0; idx < s2.length(); idx ++) {
            char ch = s2.charAt (idx);
            if (-- map [ch] < 0) while (map [ch] != 0) map [s2.charAt (start ++)] ++;
            else if (idx - start + 1 == s1.length()) return true;
        }
        return false;
    }
    private static double[] solve(double a, double b, double c){
        double[] solution = new double[2];
        double[] double_solution = new double[1];
        double[] empty = {};
        double delta;
        if (a == 0) {
            if (b == 0) {
                return empty;
            }
            double_solution[0] = -c / b;
            return double_solution;
        }
        delta = b * b - 4 * a * c;
        if (delta < 0) {
            return empty;
        }
        if (delta < 0.00000000001) {
            double_solution[0] = -b / (2 * a);
            return double_solution;
        }
        solution[0] = (-b + Math.sqrt(delta)) / (2 * a);
        solution[1] = (-b - Math.sqrt(delta)) / (2 * a);
        return solution;
    }
    public static void main(String[] args) {
//        Scanner read = new Scanner(System.in);
//        System.out.print("Enter no. of cols: ");
//        int col = read.nextInt();
//        System.out.print("Enter no. of rows: ");
//        int row = read.nextInt();
//        int[][] map = new int[col][row];
//        System.out.println("Enter map:");
//        for (int j = 0; j < row; j += 1) {
//            for (int i = 0; i < col; i += 1) {
//                if(read.hasNextInt()) {
//                    map[i][j] = read.nextInt();
//                }
//            }
//        }
//        int[][] new_map = new int[col][row];
//        new_map[0][0] = 1;
//        int[][] pos = new int [col * row][2];
//        int number_of_points = 1;
//        long t1 = System.nanoTime();
//        for (int i = 0; i < number_of_points; i += 1) {
//            int xr = pos[i][0] + 1;
//            if (pos[i][0] < col - 1 && Math.abs(map[xr][pos[i][1]] - map[pos[i][0]][pos[i][1]]) <= 2 && new_map[xr][pos[i][1]] == 0) {
//                new_map[xr][pos[i][1]] = 1;
//                pos[number_of_points][0] = xr;
//                pos[number_of_points][1] = pos[i][1];
//                number_of_points += 1;
//            }
//            int xl = pos[i][0] - 1;
//            if (pos[i][0] > 0 && Math.abs(map[xl][pos[i][1]] - map[pos[i][0]][pos[i][1]]) <= 2 && new_map[xl][pos[i][1]] == 0) {
//                new_map[xl][pos[i][1]] = 1;
//                pos[number_of_points][0] = xl;
//                pos[number_of_points][1] = pos[i][1];
//                number_of_points += 1;
//            }
//            int yr = pos[i][1] + 1;
//            if (pos[i][1] < row - 1 && Math.abs(map[pos[i][0]][yr] - map[pos[i][0]][pos[i][1]]) <= 2 && new_map[pos[i][0]][yr] == 0) {
//                new_map[pos[i][0]][yr] = 1;
//                pos[number_of_points][0] = pos[i][0];
//                pos[number_of_points][1] = yr;
//                number_of_points += 1;
//            }
//            int yl = pos[i][1] - 1;
//            if (pos[i][1] > 0 && Math.abs(map[pos[i][0]][yl] - map[pos[i][0]][pos[i][1]]) <= 2 && new_map[pos[i][0]][yl] == 0) {
//                new_map[pos[i][0]][yl] = 1;
//                pos[number_of_points][0] = pos[i][0];
//                pos[number_of_points][1] = yl;
//                number_of_points += 1;
//            }
//        }
//        long t2 = System.nanoTime();
//        for (int j = 0; j < row; j += 1) {
//            for (int i = 0; i < col; i += 1) {
//                System.out.print(new_map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.print("Computed in: " + (t2 - t1));
//        Scanner read = new Scanner(System.in);
//        String s1 = read.nextLine();
//        String s2 = read.nextLine();
//        long t1 = System.nanoTime();
//        System.out.print(checkInclusion(s1, s2));
//        long t2 = System.nanoTime();
//        System.out.print("\nComputed in: " + (t2 - t1));
        System.out.println(Arrays.toString(solve(1, 2, 1)));
        System.out.println("Hello World!");
    }
}
