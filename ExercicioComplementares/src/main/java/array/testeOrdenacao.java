package array;

import java.util.Arrays;

public class testeOrdenacao {

  public static void main(String[] args)  {
    int[] Array1 = {1,2,3,4,5};
    int[] Array2 = {6,7,8,9,10};
    
    int lenght = Array1.length + Array2.length;
    
    int[] join = new int[lenght];
    int point = 0;
    
    for (int count : Array1)
    {
      join[point] = count;
      point++;
    }
    
    for (int count2 : Array2)
    {
      join[point] = count2;
      point++;
    }

    System.out.println("-----------------------------------------------------------");
    System.out.println("Resultado do Array1: " + Arrays.toString(Array1));
    System.out.println("Resultado do Array2: " + Arrays.toString(Array2));
    System.out.println("Resultado do join entre os Arrays: " + Arrays.toString(join));
    System.out.println("-----------------------------------------------------------");

  }
}
