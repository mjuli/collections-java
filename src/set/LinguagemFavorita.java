package set;

import java.util.Objects;

public class LinguagemFavorita implements Comparable<LinguagemFavorita> {
  private String nome;
  private Integer anoDeCriacao;
  private String ide;

  public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
    this.nome = nome;
    this.anoDeCriacao = anoDeCriacao;
    this.ide = ide;
  }

  public String getNome() {
    return nome;
  }

  public Integer getAnoDeCriacao() {
    return anoDeCriacao;
  }

  public String getIde() {
    return ide;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LinguagemFavorita that = (LinguagemFavorita) o;
    return Objects.equals(getNome(), that.getNome()) && Objects.equals(getAnoDeCriacao(), that.getAnoDeCriacao()) && Objects.equals(getIde(), that.getIde());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNome(), getAnoDeCriacao(), getIde());
  }

  @Override
  public String toString() {
    return "\n{" +
            "nome='" + nome + '\'' +
            ", anoDeCriacao=" + anoDeCriacao +
            ", ide='" + ide + '\'' +
            '}';
  }

  @Override
  public int compareTo(LinguagemFavorita lf) {
    return this.getNome().compareToIgnoreCase(lf.getNome());
  }
}
