package map;

import java.util.*;

/*
Dada a população estimada de alguns estados do NE brasileiro, faça:
Estado = PE - População = 9.616.621
Estado = AL - População = 3.351.543
Estado = CE - População = 9.187.103
Estado = RN - População = 3.534.265

1- Crie um dicionário e relacione os estados e suas populações;
2 - Substitua a população do estado do RN por 3.534.165;
3 - Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277;
4 - Exiba a população PE;
5 - Exiba todos os estados e suas populações na ordem que foi informado;
6 - Exiba os estados e suas populações em ordem alfabética;
7 - Exiba o estado com o menor população e sua quantidade;
8 - Exiba o estado com a maior população e sua quantidade;
9 - Exiba a soma da população desses estados;
10 - Exiba a média da população deste dicionário de estados;
11 - Remova os estados com a população menor que 4.000.000;
12 - Apague o dicionário de estados;
13 - Confira se o dicionário está vazio.
*/

public class Populacao {
  public static void main(String[] args) {

    System.out.println("1- Crie um dicionário e relacione os estados e suas populações;");
    Map<String, Integer> populacao = new HashMap<>(){{
      put("PE", 9_616_621);
      put("AL", 3_351_543);
      put("CE", 9_187_103);
      put("RN", 3_534_265);
    }};
    System.out.println(populacao);

    System.out.println("2 - Substitua a população do estado do RN por 3.534.165;");
    populacao.put("RN", 3_534_165);
    System.out.println(populacao);

    System.out.println("3 - Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277;");
    System.out.println("populacao.containsKey(\"PB\"): " + populacao.containsKey("PB"));
    populacao.put("PB", 4_039_277);
    System.out.println(populacao);

    System.out.println("4 - Exiba a população PE: " + populacao.get("PE"));

    System.out.println("5 - Exiba todos os estados e suas populações na ordem que foi informado;");
    Map<String, Integer> populacaoLinked = new LinkedHashMap<>();
    populacaoLinked.put("PE", 9_616_621);
    populacaoLinked.put("AL", 3_351_543);
    populacaoLinked.put("CE", 9_187_103);
    populacaoLinked.put("RN", 3_534_265);
    System.out.println(populacaoLinked);

    System.out.println("6 - Exiba os estados e suas populações em ordem alfabética;");
    Map<String, Integer> populacaoTree = new TreeMap<>(populacao);
    System.out.println(populacaoTree);

    System.out.println("7 - Exiba o estado com o menor população e sua quantidade;");
    Collection<Integer> quantidade = populacao.values();
    Integer menorQuantidade = Collections.min(quantidade);
    populacao.forEach((estado, qtd) -> {
      if (menorQuantidade == qtd) System.out.println(estado + " - " + qtd);
    });

    System.out.println("8 - Exiba o estado com a maior população e sua quantidade;");
    Integer maiorQuantidade = Collections.max(quantidade);
    populacao.forEach((estado, qtd) -> {
      if (maiorQuantidade == qtd) System.out.println(estado + " - " + qtd);
    });

    System.out.println("9 - Exiba a soma da população desses estados;");
    int soma = 0;
    Collection<Integer> quantidades = populacao.values();
    for (int qtd : quantidades) soma += qtd;
    System.out.println(soma);

    System.out.println("10 - Exiba a média da população deste dicionário de estados: " + (soma/populacao.size()));

    System.out.println("11 - Remova os estados com a população menor que 4.000.000;");
    /*Iterator<Map.Entry<String, Integer>> iterator = populacao.entrySet().iterator();
    while(iterator.hasNext()){
      if(iterator.next().getValue() < 4_000_000)
        iterator.remove();
    }
    System.out.println(populacao);*/

    Iterator<Integer> iterator1 = populacao.values().iterator();
    while (iterator1.hasNext()) {
      if (iterator1.next() <= 4000000) iterator1.remove();
    }
    System.out.println(populacao);

    System.out.println("12 - Apague o dicionário de estados;");
    populacao.clear();
    System.out.println(populacao);

    System.out.println("13 - Confira se o dicionário está vazio: " + populacao.isEmpty());

  }
}
