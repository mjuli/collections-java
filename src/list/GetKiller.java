package list;

/*
* Utilizando listas, faça um programa que faça 5 perguntas para uma
pessoa sobre um crime. As perguntas são:
"Telefonou para a vítima?"
"Esteve no local do crime?"
"Mora perto da vítima?"
"Devia para a vítima?"
"Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser
classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como
"Assassina". Caso contrário, ela será classificado como "Inocente".
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GetKiller {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String resultado;
    List<String> respostas = new ArrayList<>();
    List<String> afirmativo = new ArrayList<>(Arrays.asList("sim", "s", "si", "y", "yes"));
//    List<String> afirmativo = new ArrayList<>(){{"sim", "s", "si", "y"}};
    String[] perguntas = {
            "Telefonou para a vítima?",
            "Esteve no local do crime?",
            "Mora perto da vítima?",
            "Devia para a vítima?",
            "Já trabalhou com a vítima?"
    };

    for (String pergunta : perguntas) {
      System.out.println(pergunta);
      String resposta = scan.next().toLowerCase();

      if(afirmativo.contains(resposta))
        respostas.add(resposta);
    }

    switch (respostas.size()){
      case 2:
        resultado = "Suspeita";
        break;
      case 3:
      case 4:
        resultado = "Cúmplice";
        break;
      case 5:
        resultado = "Assassina";
        break;
      default:
        resultado = "Inocente";
    }

    System.out.println("A pessoa é " + resultado);
  }
}
