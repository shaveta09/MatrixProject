import java.util.Scanner;
            
    public class Matrix
        {
           public static void main(String[] args) {
                 
               int option = 0;
               System.out.println("Welcome to the Matrix program!");  
               Scanner scan = new Scanner(System.in); 
               /* USER CREATES MATRICES */  
               System.out.println("How many matrices would you like to create?");
               int matrices = scan.nextInt();
               System.out.println("---");
               
               if(matrices == 2)
            	   System.out.println("First Matrix:");
               else
            	   System.out.println("Your Matrix:");
               
               // number or rows and columns for matrix 1
               System.out.println("# of rows?");
               int row1 = scan.nextInt();
                 
               System.out.println("# of columns?");
               int column1 = scan.nextInt();
               System.out.println("---");
               
               // input integers into matrix 1
               int[][] matrix1 = new int [row1][column1];
                    
               for (int i = 0; i < row1; i++) 
               {
            	   for(int j = 0; j < column1; j++) 
                   {
            		   System.out.println("Input integer in row["+ (i + 1) +"] column["+ (j + 1) +"]");
                       matrix1[i][j] = scan.nextInt();
                    }
               }
               
               // printing matrix 1
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
               
               // making matrix 2  
               int[][] matrix2 = new int[0][0];
               int row2 = 0, column2 = 0;
               if(matrices == 2)
               {
                 System.out.println("Second Matrix:");
            	 
                 // number of rows and columns in matrix 2
                 System.out.println("# of rows");
                 row2 = scan.nextInt();
                 
                 System.out.println("# of columns");
                 column2 = scan.nextInt();
                 
                 System.out.println("---");
                 
                 matrix2 = new int [row2][column2];

                 for (int i = 0; i < row2; i++) 
                 {
                	 for(int j = 0; j < column2; j++) 
                     {
                		 System.out.println("Input the integer in row["+ (i + 1) +"] column["+ (j + 1) +"] in the second matrix");
                         matrix2[i][j] = scan.nextInt();
                     }
                 }
                 
                 // printing matrix 2
                 System.out.println("This matrix is:");
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
               
               // user chooses operation
               System.out.println("What would you like to do?");
               System.out.println("1. Scalar Multiplication");
               System.out.println("2. Determinant (only for 2x2 or 3x3 matrices)");
               System.out.println("3. Transpose");
               System.out.println("4. Inverse");
               System.out.println("5. Row-reduced Echelon Form of Augmented Matrix");
               System.out.println("6. Addition (only if you have 2 matrices)");
               System.out.println("7. Subtraction (only if you have 2 matrices)");
               System.out.println("8. Multiplication (only if you have 2 matrices)");
               option = scan.nextInt();
               
               /* METHODS CALLS based on user option */
               if(option == 1) // scalar multiplication
               {
            	  System.out.println("Pick a matrix.");
            	  int chosen = scan.nextInt();
            	  if(chosen == 1)
            		  scalarmult(matrix1, row1, column1);
            	  if(chosen == 2)
            		  scalarmult(matrix2, row2, column2);
               }
               if(option == 2) // determinant (only for 2x2 and 3x3)
               {
            	  if(matrix2.length != 0 && matrix2[0].length != 0)
            	  {
            		  System.out.println("Pick a matrix.");
            		  int chosen = scan.nextInt();
            		  if(chosen == 1)
            			  deter(matrix1);
            		  if(chosen == 2)
            			  deter(matrix2);
            	  }
            	  else 
            		  deter(matrix1);
               }
               if(option == 3) // transpose
               {
            	   if(matrix2.length != 0 && matrix2[0].length != 0)
             	  {
             		  System.out.println("Pick a matrix.");
             		  int chosen = scan.nextInt();
             		  if(chosen == 1)
             			  trans(matrix1, row1, column1);
             		  if(chosen == 2)
             			  trans(matrix2, row2, column2);
             	  }
             	  else 
             		  trans(matrix1, row1, column1);
               }
               if(option == 5)
            	   rowred(matrix1,row1,column1);
               if(option == 6) // addition (only with 2 matrices)
               {
            		  add(matrix1, matrix2, row1, column1);
               }
               if(option == 7) // subtraction (only with 2 matrices)
               {
            		  sub(matrix1, matrix2, row1, column1);
               }
               if(option == 8) // multiplication (only with 2 matrices)
               {
            		  mult(matrix1, matrix2, row1, column1);
               } 
          }
          
           
           
           
          
          /* SCALAR MULTIPLCATION METHOD */
          public static void scalarmult(int[][] matrix, int rows, int columns)
          {
        	  Scanner scan = new Scanner(System.in);
        	  // asks constant
        	  System.out.println("Constant to multiply with?");
        	  int multiple = scan.nextInt();
        	  // prints new matrix
        	  System.out.println("Your new matrix:");
              for (int i = 0; i < rows; i++) 
              {
                  for(int j = 0; j < columns; j++) 
                  {
                      System.out.print((matrix[i][j]*multiple) + " ");
                  }
                  System.out.println();
              }
          }
          
          /* DETERMINANT METHOD (only for 2x2 and 3x3) */
          public static void deter(int[][] matrix)
          {
        	  // for 2x2 matrices
        	  if(matrix.length == 2 && matrix[0].length == 2)
        	  {
        		  int diag1 = matrix[0][0] * matrix[1][1];
        		  int diag2 = matrix[0][1] * matrix[1][0];
        		  int determinant = diag1 - diag2;
        		  System.out.println("Determinant: " + determinant);
        	  }
        	  // for 3x3 matrices
        	  if(matrix.length == 3 && matrix[0].length == 3)
        	  {
        		  int p1 = matrix[0][0] * ((matrix[1][1]*matrix[2][2]) - (matrix[2][1]*matrix[1][2]));
        		  int p2 = matrix[0][1] * ((matrix[1][0]*matrix[2][2]) - (matrix[2][0]*matrix[1][2]));
        		  int p3 = matrix[0][2] * ((matrix[1][0]*matrix[2][1]) - (matrix[2][0]*matrix[1][1]));
        		  int determinant = p1 - p2 + p3;
        		  System.out.println("Determinant: " + determinant);
        	  }
        	  
          }
          
          /* TRANSPOSE METHOD */
          public static void trans(int[][] matrix, int rows, int columns)
          {
        	  int temp = rows;
        	  rows = columns;
        	  columns = temp;
        	  System.out.println("Your new matrix:");
        	  for (int i = 0; i < rows; i++) 
              {
                  for(int j = 0; j < columns; j++) 
                  {
                      System.out.print(matrix[j][i] + " ");
                  }
                  System.out.println();
              }
          }
          
          /* ROW REDUCED ECHELON FORM METHOD */
          public static void rowred(int[][] matrix, int rows, int columns)
          {
      		 int lead = 0;
      		 int a = 0;
      		 for(int i = 0; i < rows; i++)
      		 {
      			 if(columns <= lead)
      				 break;
      			 a = i;
      			 while(matrix[a][lead] == 0)
      			 {
      				 a++;
      				 if(rows == a)
      				 {
      					 a = i;
      					 lead++;
      					 if(columns == lead)
      						 break;
      				 }
      			 }
      			 matrix = swap(matrix, a, i);
      			 System.out.println("hello" + matrix[i][lead]);
      			 if(matrix[i][lead] > 0)
      			 {
      				 int bot = matrix[i][lead];
      				 for(int b = 0; b < columns; b++)
      				 {
      					 matrix[i][b] *= 1/bot;
      				 }
//      					 matrix[i][b] *= (1/matrix[i][lead]);
      			 }
      			 for(int k = 0; k < rows; k ++)
      			 {
      				 //rowAddScale
      				 for(int b = 0; b < columns; b++)
      					 matrix[i][b] += (matrix[a][b]*((-1)*matrix[a][lead]));
      			 }
      			 lead++;
      		 }
      		 
      		 //printing matrix
      		for (int f = 0; f < rows; f++) 
            {
                for(int g = 0; g < columns; g++) 
                {
                    System.out.print((matrix[f][g]) + " ");
                }
                System.out.println();
            }
          }
          public static int[][] swap(int[][] matrix, int index1, int index2)
          {
        	  int columns = matrix[0].length;
        	  int temp;
        	  for(int i = 0; i < columns; i++)
        	  {
        		  temp = matrix[index2][i];
        		  matrix[index2][i] = matrix[index1][i];
        		  matrix[index1][i] = temp;
        	  }
        	  return matrix;
          }
          
          /* ADDTION METHOD (for 2 matrices) */
          public static void add(int[][] matrix1, int[][] matrix2, int rows, int columns)
          {
                   int add[][] = new int[rows][columns];  
                   // adding matrices
                   for(int i = 0; i < rows; i++)
                   {
                       for(int j = 0; j < columns; j++)
                       { 
                           add[i][j] = matrix1[i][j] + matrix2[i][j];
                        }
                   }
                   // printing new matrix 
                   System.out.println("Your new matrix: ");
                   for(int i = 0; i < rows; i++)
                   {
                     for(int j = 0; j < columns; j++)
                     {
                         System.out.print(add[i][j] + " ");
                     }
                     System.out.println(); 
                   }
          }  
          
          /* SUBTRACTION METHOD (for 2 matrices) */
          public static void sub(int[][] matrix1, int[][] matrix2,  int rows, int columns)
          {
                   int sub[][] = new int[rows][columns];  
                   //subtracting matrices
                   for(int i = 0; i < rows; i++)
                   {
                       for(int j = 0; j < columns; j++)
                       { 
                           sub[i][j] = matrix1[i][j] - matrix2[i][j];
                        }
                    }
                   // printing new matrix
                   System.out.println("Your new matrix: ");
                   for(int i = 0; i < rows; i++)
                   {
                     for(int j = 0; j < columns; j++)
                     {
                         System.out.print(sub[i][j] + " ");
                     }
                     System.out.println(); 
                   }
          }
          
          /* MULTIPLCATION METHOD (for 2 matrices) */
          public static void mult(int[][] matrix1, int[][] matrix2, int rows, int columns)
          {
                   int mult[][] = new int[rows][columns];  
                   // multiplying matrices
                   for(int i = 0; i < rows; i++)
                   {
                       for(int j = 0; j < columns; j++)
                       { 
                           mult[i][j] = matrix1[i][j] * matrix2[i][j];
                        }
                   }
                   // printing new matrix
                   System.out.println("Your new matrix: ");
                   for(int i = 0; i < rows; i++)
                   {
                     for(int j = 0; j < columns; j++)
                     {
                         System.out.print(mult[i][j] + " ");
                     }
                     System.out.println(); 
                   }
         }
        
        } 
// end of class
