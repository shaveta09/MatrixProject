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
                 
               int[][] matrix2 = new int[0][0];
               int row2 = 0, column2 = 0;
               if(matrices == 2)
               {
                 System.out.println("# of rows in the second matrix?");
                 row2 = scan.nextInt();
                 System.out.println("---");
                 
                 System.out.println("# of columns in the second matrix?");
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
                    
//               if(matrices == 1)
//               {
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
//               }
                
//               if(matrices == 2)
//               {
//                    System.out.println("What would you like to do with these matrices?");
//                    System.out.println("1. Addition");
//                    
//                    
//                    option = scan.nextInt();
//               }
               
               if(option == 1)
               {
            	  System.out.println("Pick a matrix.");
            	  int chosen = scan.nextInt();
            	  if(chosen == 1)
            		  scalarmult(matrix1, row1, column1);
            	  if(chosen == 2)
            		  scalarmult(matrix2, row2, column2);
               }
               if(option == 2)
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
               if(option == 3)
               {
            	   trans(matrix1, row1, column1);
               }
               if(option == 6)
               {
            		  add(matrix1, matrix2, row1, column1);
               }
               if(option == 7)
               {
            		  sub(matrix1, matrix2, row1, column1);
               }
               if(option == 8)
               {
            		  mult(matrix1, matrix2, row1, column1);
               } 
          }
          
          public static void scalarmult(int[][] matrix, int rows, int columns)
          {
        	  Scanner scan = new Scanner(System.in);
        	  
        	  System.out.println("What constant would you like to multiply with?");
        	  int multiple = scan.nextInt();
        	  
        	  System.out.println("The new matrix is:");
              for (int i = 0; i < rows; i++) 
              {
                  for(int j = 0; j < columns; j++) 
                  {
                      System.out.print((matrix[i][j]*multiple) + " ");
                  }
                  System.out.println();
              }
          }
          
          public static void deter(int[][] matrix)
          {
        	  if(matrix.length == 2 && matrix[0].length == 2)
        	  {
        		  int diag1 = matrix[0][0] * matrix[1][1];
        		  int diag2 = matrix[0][1] * matrix[1][0];
        		  int determinant = diag1 - diag2;
        		  System.out.println("determinant: " + determinant);
        	  }
        	  if(matrix.length == 3 && matrix[0].length == 3)
        	  {
        		  int p1 = matrix[0][0] * ((matrix[1][1]*matrix[2][2]) - (matrix[2][1]*matrix[1][2]));
        		  int p2 = matrix[0][1] * ((matrix[1][0]*matrix[2][2]) - (matrix[2][0]*matrix[1][2]));
        		  int p3 = matrix[0][2] * ((matrix[1][0]*matrix[2][1]) - (matrix[2][0]*matrix[1][1]));
        		  int determinant = p1 - p2 + p3;
        		  System.out.println("determinant: " + determinant);
        	  }
        	  
          }
          
          public static void trans(int[][] matrix, int rows, int columns)
          {
        	  int temp = rows;
        	  rows = columns;
        	  columns = temp;
        	  for (int i = 0; i < rows; i++) 
              {
                  for(int j = 0; j < columns; j++) 
                  {
                      System.out.print(matrix[j][i] + " ");
                  }
                  System.out.println();
              }
          }
          
          public static void add(int[][] matrix1, int[][] matrix2, int rows, int columns)
          {
                   int add[][] = new int[rows][columns];  
                   for(int i = 0; i < rows; i++)
                   {
                       for(int j = 0; j < columns; j++)
                       { 
                           add[i][j] = matrix1[i][j] + matrix2[i][j];
                        }
                    }
                    
                   for(int i = 0; i < rows; i++)
                   {
                     for(int j = 0; j < columns; j++)
                     {
                         System.out.print(add[i][j] + " ");
                     }
                     System.out.println(); 
                   }
                   System.out.println("Is the added result of the two matrices.");
          }  
                
          public static void sub(int[][] matrix1, int[][] matrix2,  int rows, int columns)
          {
                   int sub[][] = new int[rows][columns];  
                   for(int i = 0; i < rows; i++)
                   {
                       for(int j = 0; j < columns; j++)
                       { 
                           sub[i][j] = matrix1[i][j] - matrix2[i][j];
                        }
                    }
                    
                   for(int i = 0; i < rows; i++)
                   {
                     for(int j = 0; j < columns; j++)
                     {
                         System.out.print(sub[i][j] + " ");
                     }
                     System.out.println(); 
                   }
                   System.out.println("Is the subtracted result of the two matrices.");
          }
                
          public static void mult(int[][] matrix1, int[][] matrix2, int rows, int columns)
          {
                   int mult[][] = new int[rows][columns];  
                   for(int i = 0; i < rows; i++)
                   {
                       for(int j = 0; j < columns; j++)
                       { 
                           mult[i][j] = matrix1[i][j] * matrix2[i][j];
                        }
                    }
                    
                   for(int i = 0; i < rows; i++)
                   {
                     for(int j = 0; j < columns; j++)
                     {
                         System.out.print(mult[i][j] + " ");
                     }
                     System.out.println(); 
                   }
                   System.out.println("Is the multiplied result of the two matrices.");
          }
        } 

