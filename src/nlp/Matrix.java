package nlp;

public class Matrix {
    public static void main(String[] args) {
        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int b[][] = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        int ans[][] = multiply(a, b);

        System.out.println("A:");
        printMatrix(a);
        System.out.println("B:");
        printMatrix(b);
        System.out.println("Answer:");
        printMatrix(ans);
    }

    private static void printMatrix(int[][] ans) {
        for (int[] row : ans) {
            for (int ele : row) {
                System.out.print(" " + ele + " ");
            }
            System.out.println(" ");
        }
    }

    public static int[][] multiply(int mat1[][], int mat2[][]) {
        int rows1 = mat1.length; //2
        int cols1 = mat1[0].length; //3
        int rows2 = mat2.length;//3
        int cols2 = mat2[0].length;//3

        int[][] ans = new int[rows1][cols2];

        if (cols1 == rows2) {
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < cols2; j++) {
                    ans[i][j] = 0;
                    for (int k = 0; k < cols1; k++) {
                        ans[i][j] += mat1[i][k] * mat2[k][j];
                    }
                }
            }
            return ans;
        } else {
            System.out.println("Matrices cannot be multiplied");
            return null;
        }
    }
}