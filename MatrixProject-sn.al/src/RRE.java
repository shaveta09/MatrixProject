
public class RRE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] matrix = new double[2][3];
		matrix[0][0] = 1.0;
		matrix[0][1] = 2.0;
		matrix[1][0] = 3.0;
		matrix[1][1] = 4.0;
		matrix[0][2] = 5.0;
		matrix[1][2] = 6.0;
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j< matrix[0].length; j++)
				System.out.print((matrix[i][j]) + " ");
			System.out.println();
		}
		System.out.println("New Matrix:");
	}
	
	public static void gaussian(double a[][], int index[]) 
	{
	    int n = index.length;
	    double c[] = new double[n];
	    for (int i=0; i<n; ++i) 
	        index[i] = i;
	    for (int i=0; i<n; ++i) 
	    {
	        double c1 = 0;
	        for (int j=0; j<n; ++j) 
	        {
	            double c0 = Math.abs(a[i][j]);
	            if (c0 > c1) c1 = c0;
	        }
	        c[i] = c1;
	    }
	    
	    int k = 0;
	    for (int j=0; j<n-1; ++j) 
	    {
	        double pi1 = 0;
	        for (int i=j; i<n; ++i) 
	        {
	            double pi0 = Math.abs(a[index[i]][j]);
	            pi0 /= c[index[i]];
	            if (pi0 > pi1) 
	            {
	                pi1 = pi0;
	                k = i;
	            }
	        }
	// Interchange rows according to the pivoting order
	        int itmp = index[j];
	        index[j] = index[k];
	        index[k] = itmp;
	        for (int i=j+1; i<n; ++i) 	
	        {
	            double pj = a[index[i]][j]/a[index[j]][j];
	// Record pivoting ratios below the diagonal
	            a[index[i]][j] = pj;
	// Modify other elements accordingly
	            for (int l=j+1; l<n; ++l)
	                a[index[i]][l] -= pj*a[index[j]][l];
	        }
	    }
	}
}
/* 
 //gaussian
	public static void gaussian(int matrix[][], //int index[a]// int rows, int columns)
	{
		int a = matrix.length;
		int matrixIndex[] = new int[a];
		int n = matrixIndex.length;
		int c[] = new int[n];
		for (int i=0; i<n; ++i)
			matrixIndex[i] = i;
		for (int i=0; i<n; ++i)
		{
			int c1 = 0;
			for (int j=0; j<n; ++j)
			{
				int c0 = Math.abs(matrix[i][j]);
				if (c0 > c1) c1 = c0;
			}
			c[i] = c1;
		}
		int k = 0;
		for (int j=0; j<n-1; ++j) 
		{
			int pi1 = 0;
			for (int i=j; i<n; ++i) 
			{
				int pi0 = Math.abs(matrix[matrixIndex[i]][j]);
				pi0 /= c[matrixIndex[i]];
				if (pi0 > pi1) 
				{
					pi1 = pi0;
					k = i;
				}
			}
			int itmp = matrixIndex[j];
			matrixIndex[j] = matrixIndex[k];
			matrixIndex[k] = itmp;
			System.out.println("Your new matrix:");
			for (int i=j+1; i<n; ++i) 	
			{
				int pj = matrix[matrixIndex[i]][j]/matrix[matrixIndex[j]][j];
				matrix[matrixIndex[i]][j] = pj;
				for (int l=j+1; l<n; ++l)
					System.out.print((matrix[matrixIndex[i]][l] -= pj*matrix[matrixIndex[j]][l]) + " ");
			}
			System.out.println();
		}
	}
*/
