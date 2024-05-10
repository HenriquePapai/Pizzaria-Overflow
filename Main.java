import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Pedido primeiro_pedido = new Pedido();
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
    primeiro_pedido.setPedido(nome, documento, telefone, endereco);

    Boolean verify = false;
    int valorTotal = 0;

    while (verify == false) {
      System.out.println("Quantas pizzas deseja?");
      int quantidade = teclado.nextInt();

      primeiro_pedido.tamanhoPizza();
      teclado.nextLine();
      for (int i = 0; i < quantidade; i++) {
        System.out.println("\nPizza " + (i + 1) + ": ");
        System.out.println("Qual tamanho deseja?");
        String tamanho = teclado.nextLine();
        System.out.println("Qual o sabor? ");
        String sabor = teclado.nextLine();

        primeiro_pedido.setPizzas(tamanho, sabor);

        valorTotal = valorTotal + primeiro_pedido.valorPedido(tamanho);
      }
      System.out.println("\n--- Pedido ---");
      primeiro_pedido.getPedido();
      System.out.println("Valor Total: " + valorTotal + "\n");
      System.out.println("O pedido está correto?");
      String resposta = teclado.nextLine();

      if (resposta.equals("sim")) {
        verify = true;
        teclado.close();
      } else if (resposta.equals("nao")) {
        verify = false;
        primeiro_pedido.apagarPedido();
        valorTotal = 0;
        System.out.print("\n");
      }
    }
    System.out.println("\nPedido realizado com sucesso!");
  }
}