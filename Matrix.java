import java.util.Scanner;
            
    public class Matrix
        {
           public static void main(String[] args) {
                 
               int option = 0;
               System.out.println("Welcome to the Matrix program!");  
               Scanner scan = new Scanner(System.in); 
                 
               System.out.println("How many matrices would you like to use?");
               int matrices = scan.nextInt();
               System.out.println("---");
                 
               System.out.println("# of rows of this matrix?");
               int row1 = scan.nextInt();
               System.out.println("---");
                 
               System.out.println("# of columns of this matrix?");
               int column1 = scan.nextInt();
               System.out.println("---");
                 
               int[][] matrix1 = new int [row1][column1];
                    
                    for (int i = 0; i < row1; i++) 
                    {
                       for(int j = 0; j < column1; j++) 
                        {
                           System.out.println("Input the integer in row["+ (i + 1) +"] column["+ (j + 1) +"] of this matrix");
                           matrix1[i][j] = scan.nextInt();
                        }
                    }
                
                
               System.out.println("---");
               System.out.println("This matrix is:");
                    for (int i = 0; i < row1; i++) 
                    {
                        for(int j = 0; j < column1; j++) 
                        {
                            System.out.print(matrix1[i][j] + " ");
                        }
                        System.out.println();
                    }
               System.out.println("---");
                 
               if(matrices == 2)
               {
                 System.out.println("# of rows in the second matrix?");
                 int row2 = scan.nextInt();
                 System.out.println("---");
                 
                 System.out.println("# of columns in the second matrix?");
                 int column2 = scan.nextInt();
                 System.out.println("---");
                 
                 int[][] matrix2 = new int [row2][column2];

                    for (int i = 0; i < row2; i++) 
                    {
                       for(int j = 0; j < column2; j++) 
                        {
                           System.out.println("Input the integer in row["+ (i + 1) +"] column["+ (j + 1) +"] in the second matrix");
                           matrix2[i][j] = scan.nextInt();
                        }
                    }
               
                
                 System.out.println("---");
                 System.out.println("The second matrix is:");
                    for (int i = 0; i < row2; i++) 
                    {
                        for(int j = 0; j < column2; j++) 
                        {
                            System.out.print(matrix2[i][j] + " ");
                        }
                        System.out.println();
                    }
               }
               System.out.println("---");
                    
               if(matrices == 1)
               {
                     System.out.println("What would you like to do with this matrix?");
                     System.out.println("1. Scalar Multiplication");
                     System.out.println("2. Determinant");
                     System.out.println("3. Transpose");
                     System.out.println("4. Inverse");
                     System.out.println("5. Row-reduced Echelon Form of Augmented Matrix");
                     option = scan.nextInt();
               }
                
               if(matrices == 2)
               {
                    System.out.println("What would you like to do with these matrices?");
                    System.out.println("1. Addition");
                    System.out.println("2. Subtraction");
                    System.out.println("3. Multiplication");
                    option = scan.nextInt();
               }
          }    
        } 

