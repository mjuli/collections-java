package StreamAPI;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciciosStreamAPI {

  public static void main(String[] args) {
    List<String> numerosAleatorios =
            Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

    System.out.println("Imprima todos os elementos dessa lista de String: ");
    //numerosAleatorios.forEach(item -> System.out.println(item));
    numerosAleatorios.forEach(System.out::println);


    System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
    Set<String> collectSet = numerosAleatorios.stream()
            .limit(5)
            .collect(Collectors.toSet());
    System.out.println(collectSet);

/*
    numerosAleatorios.stream()
            .limit(5)
            .collect(Collectors.toSet())
            .forEach(System.out::println);
    Set<String> numerosAleatorios5Primeiros = numerosAleatorios.stream()
            .limit(5)
            .collect(Collectors.toSet());
    System.out.println(numerosAleatorios5Primeiros);
*/


    System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
    numerosAleatorios.forEach(Integer::parseInt);
    List<Integer> numerosAleatoriosInt = numerosAleatorios
            .stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    System.out.println(numerosAleatorios);
    System.out.println(numerosAleatoriosInt);

//    List<Integer> numerosAleatorios1 = numerosAleatorios.stream()
//            .map(Integer::parseInt).collect(Collectors.toList());
    List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());


    System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
    List<Integer> numerosAleatoriosPares = numerosAleatoriosInt
            .stream()
            .filter(num -> (num > 2) && (num % 2 == 0))
            .collect(Collectors.toList());
    System.out.println(numerosAleatoriosPares);


//    numerosAleatoriosInt.removeIf(n -> (n <= 2) || (n % 2 != 0));
//    System.out.println(numerosAleatoriosInt);

    System.out.println("Mostre a média dos números: ");
    OptionalDouble average = numerosAleatoriosInt
            .stream()
            .mapToInt(Integer::intValue)
            .average();
    System.out.println(average);

//    numerosAleatorios1.stream()
//            .average()
//            .ifPresent(System.out::println);
//    numerosAleatorios.stream()
//            .mapToInt(Integer::parseInt)
//            .average()
//            .ifPresent(System.out::println);
//
    System.out.println("Remova os valores ímpares: ");

    numerosAleatoriosInt.removeIf(num -> num % 2 != 0);
    System.out.println(numerosAleatorios);

//        Para você
    System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
    numerosAleatoriosInteger.stream()
            .skip(3)
            .forEach(System.out::println);

    long countNumerosUnicos = numerosAleatoriosInteger.stream()
            .distinct()
            .count();
    System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);
    Set<Integer> numerosAleatoriosSet = new HashSet<>(numerosAleatoriosInteger);
    System.out.println(numerosAleatoriosSet.size());

    System.out.print("Mostre o menor valor da lista: ");
    numerosAleatoriosInteger.stream()
            .mapToInt(Integer::intValue)
            .min()
            .ifPresent(System.out::println);

    System.out.println(Collections.min(numerosAleatoriosInteger));

    System.out.print("Mostre o maior valor da lista: ");
    numerosAleatoriosInteger.stream()
            .mapToInt(Integer::intValue)
            .max()
            .ifPresent(System.out::println);
    System.out.println(Collections.max(numerosAleatoriosInteger));

    int somaDosNumerosPares = numerosAleatoriosInteger.stream()
            .filter(i -> (i % 2 == 0))
            .mapToInt(Integer::intValue)
            .sum();
    System.out.println("Pegue apenas os números ímpares e some: " + somaDosNumerosPares);

    System.out.println("Mostre a lista na ordem númerica: ");
    List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
    System.out.println(numerosOrdemNatural);

    System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
//        dica: collect(Collectors.groupingBy(new Function())
    Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream()
            .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
    System.out.println(collectNumerosMultiplosDe3E5);
  }
}
