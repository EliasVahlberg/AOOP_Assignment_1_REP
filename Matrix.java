/**
 * @author Elias Vahlberg & $ Hamed Haghjo on 2021-03-24
 */
public class Matrix
{
    private int r;
    private int c;
    private double[][] elements;

    public Matrix(int r, int c)
    {
        this.r = r;
        this.c = c;
        this.elements = new double[r][c];
    }

    public double getElement(int i, int j)
    {
        if (i >= r || i < 0 || j >= c || j < 0)
            throw new IndexOutOfBoundsException();
        return elements[i][j];
    }

    public void setElement(int i, int j, double element)
    {
        elements[i][j] = element;
    }

    public int getR()
    {
        return r;
    }

    public int getC()
    {
        return c;
    }

    public static Matrix add(Matrix mat1, Matrix mat2)
    {
        if (mat1.getR() != mat2.getR() || mat1.getC() != mat2.getC())
            throw new IllegalArgumentException("Incompatible dimensions");
        Matrix matSum = new Matrix(mat1.getR(), mat1.getC());
        for (int i = 0; i < mat1.getR(); i++)
        {
            for (int j = 0; j < mat1.getC(); j++)
            {
                matSum.setElement(i, j, mat1.getElement(i, j) + mat2.getElement(i, j));
            }
        }
        return matSum;
    }

    public static Matrix multiply(Matrix mat1, Matrix mat2)
    {
        if (mat1.getC() != mat2.getR())
            throw new IllegalArgumentException("Incompatible dimensions");
        Matrix matProd = new Matrix(mat1.getR(), mat2.getC());
        for (int i = 0; i < mat1.getR(); i++)
        {
            for (int j = 0; j < mat2.getC(); j++)
            {
                double sum = 0;
                for (int k = 0; k < mat1.getC(); k++)
                {
                    sum += mat1.getElement(i, k) * mat2.getElement(k, j);
                }
                matProd.setElement(i, j, sum);
            }
        }
        return matProd;
    }
}