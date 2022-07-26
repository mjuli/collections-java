package list;

/*
Faça um programa que receba a temperatura média dos 6
primeiros meses do ano e armazene-as em uma lista.

Após isto, calcule a média semestral das temperaturas e
mostre todas as temperaturas acima desta média, e em que
mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2
– Fevereiro e etc).
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Temperatura {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    List<Double> temperaturas  = new ArrayList<>();

    for (int i = 1; i <= 6; i++){
      System.out.println("Digite a temperatura do " + i + "º mês:");
      double temp = scan.nextDouble();
      temperaturas.add(temp);
    }

    double media = getMedia(temperaturas);

    System.out.println("A média das temperaturas foi: " + media);

    getMes(temperaturas, media);
  }

  static double getMedia(List<Double> temperaturas) {
    double soma = 0;

    for (double temperatura : temperaturas)
      soma += temperatura;

    return (soma/temperaturas.size());
  }

  static void getMes(List<Double> temperaturas, double media){
    String mes[] = {"Janeiro", "Fevereiro", "Março", "Abril",
            "Maio", "Junho"};

    System.out.println("Meses com a temperatura acima da média:");

    for (int i = 0; i < temperaturas.size(); i++){
      if(temperaturas.get(i) > media) {
        System.out.println((i + 1) + " - " + mes[i] + ": " + temperaturas.get(i));
      }
    }
  }
}
