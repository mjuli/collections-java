package set;

/*
 * Crie um conjunto contendo as cores do arco-íris e:
 * 1 - Exiba todas as cores uma abaixo da outra
 * 2 - A quantidade de cores que o arco-íris tem
 * 3 - Exiba as cores em ordem alfabética
 * 4 - Exiba as cores na ordem inversa da que foi informada
 * 5 - Exiba todas as cores que começam com a letra ”v”
 * 6 - Remova todas as cores que não começam com a letra “v”
 * 7 - Limpe o conjunto
 * 8 - Confira se o conjunto está vazio
 */

import java.util.*;

public class Rainbow {
  public static void main(String[] args) {
    Set<String> arcoIris = new HashSet<>(Arrays.asList("vermelha", "laranja", "amarela", "verde", "azul", "anil", "violeta"));

    System.out.println("1 - Exiba todas as cores uma abaixo da outra:");
    for (String cor : arcoIris) System.out.println(cor);

    System.out.println("2 - A quantidade de cores que o arco-íris tem: " + arcoIris.size());

    System.out.println("3 - Exiba as cores em ordem alfabética");
    Set<String> arcoIrisTree = new TreeSet<>(arcoIris);
    System.out.println(arcoIrisTree);

    System.out.println("4 - Exiba as cores na ordem inversa da que foi informada");
    List<String> arcoIrisList = new ArrayList<>(Arrays.asList("vermelha", "laranja", "amarela", "verde", "azul", "anil", "violeta"));
    Collections.reverse(arcoIrisList);
    System.out.println(arcoIrisList);

    System.out.println("5 - Exiba todas as cores que começam com a letra v");
    for (String cor : arcoIris) {
      if(cor.charAt(0) == 'v')
        System.out.println(cor);
    }

    System.out.println("6 - Remova todas as cores que não começam com a letra v");
    /*Iterator<String> iterator = arcoIris.iterator();
    while(iterator.hasNext()){
      String next = iterator.next();
      if(next.charAt(0) != 'v')
        iterator.remove();
    }*/

    arcoIris.removeIf(s -> s.charAt(0) != 'v');
    System.out.println(arcoIris);

    System.out.println("7 - Limpe o conjunto");
    arcoIris.clear();
    System.out.println(arcoIris);

    System.out.println("8 - Confira se o conjunto está vazio: " + arcoIris.isEmpty());
  }
}