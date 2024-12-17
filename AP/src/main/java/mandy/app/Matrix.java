package mandy.app;

public class Matrix {
    private int[][] mat;

    /** Constructs a matrix of integers. */
    public Matrix(int[][] m)
    {
        mat = m;
    }

    /** Reverses the elements in each row of mat.
     * Precondition: The elements in each row have been reversed.
     */
    public void reverseAllRows()
    {
        // To be implemented in part (a)
        // My Answer:
        for (int[] row : mat) {
            ArrayUtil.reverseArray(row);
        }
    }

    /** Reverses the elements of mat, as described in part (b).
     */
    public void reverseMatrix()
    {
        // To be implemented in part (b)
        // My Answer:
        reverseAllRows();
        int start = 0;
        int end = mat.length - 1;
        while (start < end) {
            int[] temp = mat[start];
            mat[start] = mat[end];
            mat[end] = temp;
            start++;
            end--;
        }
    }

    // Other instance variables, constructors, and methods are not shown.
}
