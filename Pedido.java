import java.util.ArrayList;

public class Pedido {
  private String nome;
  private int cpf;
  private int telefone;
  private String endereco;
  ArrayList<String> pizza = new ArrayList<String>();

  public void setPedido(String nome, int cpf, int telefone, String endereco) {
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.endereco = endereco;
  }

  public void setPizzas(String tamanho, String pizza) {
    this.pizza.add(tamanho);
    this.pizza.add(pizza);
  }

  public void getPedido() {
    for (int i = 0; i < this.pizza.size(); i = i + 2) {
      System.out.println("Tamanho: " + this.pizza.get(i));
      System.out.println("Pizza: " + this.pizza.get(i + 1));
      System.out.println("\n");
    }
  }

  public void tamanhoPizza() {
    System.out.println("\n--- Tamanhos disponiveis ---");
    System.out.println("Grande - 16 pedaços - R$ 100,00");
    System.out.println("Media - 12 pedaços - R$ 80,00");
    System.out.println("Pequena - 8 pedaços - R$ 60,00");
    System.out.println("Broto - 4 pedaços - R$ 40,00");
  }

  public int valorPedido(String tamanho) {
    int valor = 0;
    String tam = tamanho.toLowerCase();
    if (tam.equals("grande")){
      valor = 80;
    } else if (tam.equals("media")) {
      valor = 60;
    } else if (tam.equals("pequena")) {
      valor = 40;
    } else if (tam.equals("broto")) {
      valor = 20;
    }
    return valor;
  }
  public void apagarPedido() {
    this.pizza.clear();
  }
}
    
