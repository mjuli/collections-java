package set;

/*
Crie uma classe LinguagemFavorita que possua os atributos
nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
3 linguagens e faça um programa que ordene esse conjunto
por:
Ordem de Inserção
Ordem Natural (nome)
IDE
Ano de criação e nome
Nome, ano de criacao e IDE
Ao final, exiba as linguagens no console, um abaixo da outra.
*/

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Set<LinguagemFavorita> linguagensFavoritas = new HashSet<>(){{
      add(new LinguagemFavorita("JS", 1995, "VS Code"));
      add(new LinguagemFavorita("Python", 1991, "PyCharm"));
      add(new LinguagemFavorita("Java", 1991, "Intellij"));
    }};

    System.out.println("Ordem de inserção: ");
    Set<LinguagemFavorita> linguagensFavoritasLinked = new LinkedHashSet<>(){{
      add(new LinguagemFavorita("JS", 1995, "VS Code"));
      add(new LinguagemFavorita("Python", 1991, "PyCharm"));
      add(new LinguagemFavorita("Java", 1991, "Intellij"));
    }};
    System.out.println(linguagensFavoritasLinked);

    System.out.println("Ordem natural(nome):");
    Set<LinguagemFavorita> linguagensFavoritasTree = new TreeSet<>(linguagensFavoritas);
    System.out.println(linguagensFavoritasTree);

    System.out.println("Ordem IDE:");
    Set<LinguagemFavorita> linguagemFavoritasIde = new TreeSet<>(new ComparatorIDE());
    linguagemFavoritasIde.addAll(linguagensFavoritas);
    System.out.println(linguagemFavoritasIde);

    System.out.println("Ordem ano de criação e nome:");
    Set<LinguagemFavorita> linguagemFavoritasAnoCriacaoNome = new TreeSet<>(new ComparatorAnoCriacaoNome());
    linguagemFavoritasAnoCriacaoNome.addAll(linguagensFavoritas);
    System.out.println(linguagemFavoritasAnoCriacaoNome);

    System.out.println("Ordem nome, ano de criação e IDE:");
    Set<LinguagemFavorita> linguagemFavoritasNomeAnoCriacaoIde = new TreeSet<>(new ComparatorNomeAnoCriacaoIDE());
    linguagemFavoritasNomeAnoCriacaoIde.addAll(linguagensFavoritas);
    System.out.println(linguagemFavoritasNomeAnoCriacaoIde);

    System.out.println("Linguagens: ");
    for (LinguagemFavorita lf : linguagensFavoritas) System.out.println(lf.getNome());
  }
}

class ComparatorIDE implements Comparator<LinguagemFavorita>{
  @Override
  public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
    return lf1.getIde().compareToIgnoreCase(lf2.getIde());
  }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita> {
  @Override
  public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
    int anoCriacao = Integer.compare(lf1.getAnoDeCriacao(), lf2.getAnoDeCriacao());

    if(anoCriacao != 0) return anoCriacao;

    return lf1.getNome().compareToIgnoreCase(lf2.getNome());
  }
}

class ComparatorNomeAnoCriacaoIDE implements Comparator<LinguagemFavorita> {
  @Override
  public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
    int nome = lf1.getNome().compareToIgnoreCase(lf2.getNome());

    if(nome != 0) return nome;

    int anoCriacao = Integer.compare(lf1.getAnoDeCriacao(), lf2.getAnoDeCriacao());

    if(anoCriacao != 0) return anoCriacao;

    return lf1.getIde().compareToIgnoreCase(lf2.getIde());
  }
}
