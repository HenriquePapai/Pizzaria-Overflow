import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

class ConfirmaPedido extends JFrame {

    private ArrayList<PedidoItem> mostraPedidod;

    public ConfirmaPedido() {
        this.mostraPedidod = new ArrayList<PedidoItem>();
        configurarJanela();
        adicionarComponentes();
    }

    private void configurarJanela() {
        setTitle("Confirmar Pedido");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // trava o tamanho da tela
        setLocationRelativeTo(null); // centraliza a tela
        setLayout(null);
    }

    private void adicionarComponentes() {
        // Label
        JLabel titulo = new JLabel("Confirmar Pedido");
        titulo.setBounds(278, 150, 500, 80); // margem esquerda, cima, comprimento, altura
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        add(titulo);

        // Botão Finalizar Pedido
        JButton jButtonFinalizar = new JButton("Finalizar Pedido");
        jButtonFinalizar.setBounds(290, 270, 400, 40); // margem esquerda, cima, comprimento, altura botão
        jButtonFinalizar.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        jButtonFinalizar.setForeground(new Color(0, 0, 0));
        jButtonFinalizar.setBackground(new Color(190, 196, 201));
        add(jButtonFinalizar);
        jButtonFinalizar.addActionListener(this::FinalizarPedido);

        // Botão Voltar
        JButton jButtonVoltar = new JButton("Voltar");
        jButtonVoltar.setBounds(290, 325, 400, 40); // margem esquerda, cima, comprimento, altura botão
        jButtonVoltar.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        jButtonVoltar.setForeground(new Color(0, 0, 0));
        jButtonVoltar.setBackground(new Color(190, 196, 201));
        add(jButtonVoltar);
        jButtonVoltar.addActionListener(this::Voltar);

        setVisible(true);
    }

    private void FinalizarPedido(ActionEvent actionEvent) {
        try {
            FileInputStream fis = new FileInputStream("pedidos.txt"); // Abre arquivo para leitura usando FileInputStream
            ObjectInputStream ois = new ObjectInputStream(fis); // Cria o ObjectInputStream para ler o arquivo
            mostraPedidod = (ArrayList<PedidoItem>) ois.readObject(); // Lê o arquivo e armazena em uma lista
            ois.close();
            fis.close();

            JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso, ele será entregue em sua residência em breve!", "Pedido finalizado", JOptionPane.INFORMATION_MESSAGE);
            Comanda comanda = new Comanda(mostraPedidod); // Passa a lista deserializada para o construtor de Comanda
            comanda.setVisible(true);
            this.dispose();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void Voltar(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Será necessário criar um novo pedido do zero!", "Pedido reiniciado", JOptionPane.WARNING_MESSAGE);
        this.dispose();
        new Pedido();
    }
}
