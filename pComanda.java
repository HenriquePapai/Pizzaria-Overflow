import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Comanda extends JFrame {

    private ArrayList<PedidoItem> pedidos;

    public Comanda(ArrayList<PedidoItem> pedidos) {
        this.pedidos = pedidos; // Armazena a lista de pedidos deserializada
        configurarJanela();
        exibirPedidos(); // Chama o método para exibir os pedidos
    }

    private void configurarJanela() {
        setTitle("Comanda");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // trava o tamanho da tela
        setLocationRelativeTo(null); // centraliza a tela
        setLayout(null);

        // Label
        JLabel titulo = new JLabel("Comanda");
        titulo.setBounds(378, 70, 300, 80); // margem esquerda, cima, comprimento, altura
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        add(titulo);
    }

    private void exibirPedidos() {
        // Campo do pedido
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 150, 900, 400); // margem esquerda, cima, comprimento, altura
        add(scrollPane);

        // Adiciona os pedidos deserializados ao campo de texto
        for (PedidoItem pedido : pedidos) {
            textArea.append(pedido.toString() + "\n"); // Supondo que PedidoItem tenha um método toString adequado
        }
    }
}