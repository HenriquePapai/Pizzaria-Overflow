import java.util.Scanner;
import java.util.ArrayList;

class Pedido {
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
    System.out.println("--- Tamanhos disponiveis ---");
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
}

public class Main {
  public static void main(String[] args) {

    Pedido primeiro = new Pedido();
    Scanner teclado = new Scanner(System.in);
    System.out.println("Nome do cliente: ");
    String nome = teclado.nextLine();

    System.out.println("Documento do cliente: ");
    int documento = teclado.nextInt();

    System.out.println("Telefone do cliente: ");
    int telefone = teclado.nextInt();

    System.out.println("Endereco do cliente: ");
    teclado.nextLine();
    String endereco = teclado.nextLine();

    System.out.println("\n");
    primeiro.setPedido(nome, documento, telefone, endereco);

    Boolean verify = false;
    int valorTotal = 0;

    while (verify == false) {
      System.out.println("Quantas pizzas deseja?");
      int quantidade = teclado.nextInt();

      primeiro.tamanhoPizza();
      teclado.nextLine();
      for (int i = 0; i < quantidade; i++) {
        System.out.println("\nPizza " + (i + 1) + ": ");
        System.out.println("Qual tamanho deseja?");
        String tamanho = teclado.nextLine();
        System.out.println("Qual o sabor? ");
        String sabor = teclado.nextLine();

        primeiro.setPizzas(tamanho, sabor);

        valorTotal = valorTotal + primeiro.valorPedido(tamanho);
      }
      System.out.println("\n--- Pedido ---");
      primeiro.getPedido();
      System.out.println("Valor Total: " + valorTotal + "\n");
      System.out.println("O pedido está correto?");
      String resposta = teclado.nextLine();

      if (resposta.equals("sim")) {
        verify = true;
      } else if (resposta.equals("nao")) {
        verify = false;
        System.out.print("\n");
      }
      // Limpar informações
    }
    System.out.println("Pedido realizado com sucesso!");
  }
}