import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

class Pedido extends JFrame {
    private JComboBox<String> tamanho;
    private JComboBox<String> sabor;
    private double ValorTotal;
    private JLabel jLabel4;
    private String nomeUsuario;
    private ArrayList<PedidoItem> pedidos = new ArrayList<PedidoItem>();
    private static double valorTotal = 0.0;

    // Método setter para nomeUsuario
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario.toUpperCase(); // Converte para maiúsculas e armazena
    }

    public Pedido() {
        setTitle("Cardápio");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // trava o tamanho da tela
        setLocationRelativeTo(null); // centraliza a tela

        setLayout(null);


        // Label
        JLabel titulo = new JLabel("Cardápio");
        titulo.setBounds(378, 70, 300, 80); // margem esquerda, cima, comprimento, altura
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        add(titulo);

        JLabel jLabel = new JLabel("Tamanho:");
        jLabel.setBounds(290, 173, 200, 50); // margem esquerda, cima, comprimento, altura
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel);

        JLabel jLabel2 = new JLabel("Sabor:");
        jLabel2.setBounds(290, 243, 90, 50); // margem esquerda, cima, comprimento, altura
        jLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel2);

        JLabel jLabel3 = new JLabel("Comanda: 1");
        jLabel3.setBounds(430, 140, 200, 50); // margem esquerda, cima, comprimento, altura
        jLabel3.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel3);

        ValorTotal = valorTotal; // armazena o valor total em uma variável estática
        jLabel4 = new JLabel("Valor total: " + ValorTotal);
        jLabel4.setBounds(290, 368, 200, 50); // margem esquerda, cima, comprimento, altura
        jLabel4.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel4);
        
        

        // Box
        tamanho = new JComboBox<>();
        tamanho.setBounds(290, 210, 400, 40); // margem esquerda, cima, comprimento, altura
        tamanho.setFont(new Font("Arial", Font.BOLD, 20));
        tamanho.addItem("Broto");
        tamanho.addItem("Pequena");
        tamanho.addItem("Média");
        tamanho.addItem("Grande");
        add(tamanho);

        sabor = new JComboBox<>();
        sabor.setBounds(290, 280, 400, 40); // margem esquerda, cima, comprimento, altura
        sabor.setFont(new Font("Arial", Font.BOLD, 20));
        sabor.addItem("4 Queijos");
        sabor.addItem("Calabresa");
        sabor.addItem("Frango com Catupiry");
        sabor.addItem("Marguerita");
        sabor.addItem("Muçarela");
        sabor.addItem("Portuguesa");
        add(sabor);



        // Botão
        JButton jButton = new JButton("Adicionar novo pedido");
        jButton.setBounds(290, 330, 400, 40); // margem esquerda, cima, comprimento, altura botão
        jButton.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        jButton.setForeground(new Color(0, 0, 0));
        jButton.setBackground(new Color(190, 196, 201));
        add(jButton);
        jButton.addActionListener(this::AdicionarPedido);


        JButton jButton2 = new JButton("Finaliza pedido");
        jButton2.setBounds(290, 415, 400, 40); // margem esquerda, cima, comprimento, altura botão
        jButton2.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        jButton2.setForeground(new Color(0, 0, 0));
        jButton2.setBackground(new Color(190, 196, 201));
        add(jButton2);
        jButton2.addActionListener(this::ConfirmaPedido);

        setVisible(true);
    }

    
    private void AdicionarPedido(ActionEvent actionEvent) { // adiciona o pedido ao clicar no botão
        String tamanhoSelecionado = (String) tamanho.getSelectedItem(); // pega o tamanho selecionado da JComboBox
        String saborSelecionado = (String) sabor.getSelectedItem(); // pega o sabor selecionado da JComboBox
        Pizza pizza = null; // variável para armazenar a pizza

        if (tamanhoSelecionado != null) {
            switch (tamanhoSelecionado) {
                case "Broto":
                    pizza = new PizzaBroto(tamanhoSelecionado);
                    break;
                case "Pequena":
                    pizza = new PizzaPequena(tamanhoSelecionado);
                    break;
                case "Média":
                    pizza = new PizzaMedia(tamanhoSelecionado);
                    break;
                case "Grande":
                    pizza = new PizzaGrande(tamanhoSelecionado);
                    break;
                default: // se o tamanho não corresponder a nenhum anterior, lança uma exceção
                    try {
                        throw new PedidoException("O tamanho da pizza é inválido: " + tamanhoSelecionado);
                    } catch (PedidoException e) {
                        e.printStackTrace();
                    }
            }
        } else { // imprime um erro caso nenhum tamanho seja selecionado
            System.out.println("Nenhum tamanho selecionado");
        }

        if (pizza != null) {
            ValorTotal += pizza.calculaPreco(); // Calcula o valor total somando o preço da pizza selecionada
            valorTotal = ValorTotal;
            this.jLabel4.setText("Valor total: " + ValorTotal);
            PedidoItem pedidoItem = new PedidoItem(tamanhoSelecionado, saborSelecionado, pizza.calculaPreco());
            pedidos.add(pedidoItem);

            try {
                FileOutputStream fos = new FileOutputStream("pedidos.ser"); // cria do FileOutputStream para escrever no arquivo "pedidos.ser"
                ObjectOutputStream oos = new ObjectOutputStream(fos); // cria o ObjectOutputStream para escrever no FileOutputStream
                oos.writeObject(pedidos); // Escreve no "pedidos.ser" usando o ObjectOutputStream
                oos.close(); // Fecha o ObjectOutputStream
                fos.close(); // Fecha o FileOutputStream
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nenhuma pizza foi selecionada");
        }
    }

    private void ConfirmaPedido(ActionEvent actionEvent) { // redireciona para a página de confirmar pedido
        this.dispose(); // fecha a janela atual
        ConfirmaPedido confirmaPedido = new ConfirmaPedido(); // carrega a página de login
        confirmaPedido.setNomeUsuario(nomeUsuario); // Define o nome do usuário na instância de Pedido
    }
}
