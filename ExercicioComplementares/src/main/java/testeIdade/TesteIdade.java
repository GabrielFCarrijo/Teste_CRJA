package testeIdade;

import java.util.Scanner;

public class TesteIdade {

  public static void main(String[] args) {

    Scanner scanner =  new Scanner(System.in);

    int soma, mult;

    System.out.println("Qual idade da 1° Mulher ?");
    int woman = scanner.nextInt();

    System.out.println("Qual idade da 2° Mulher ?");
    int woman2 = scanner.nextInt();

    System.out.println("Qual idade do 1° Homen ?");
    int men = scanner.nextInt();

    System.out.println("Qual idade da 2° Homen ?");
    int men2 = scanner.nextInt();

    if (men > men2 && woman > woman2){
       soma = men + woman;
       mult = men2 * woman2;

    } else if(men2 > men && woman > woman2){
       soma = men2 + woman2;
       mult = men * woman;

    } else if (men > men2 && woman2 > woman){
       soma = men + woman;
       mult = men2 * woman2;

    } else {
      soma = men2 + woman;
      mult = men * woman2;

    }

    System.out.println("Soma das idades do homem mais velho com a mulher mais nova é : "+ soma);
    System.out.println("Produto das idades do homem mais novo com a mulher mais velha: "+ mult);
    scanner.close();
  }
}
