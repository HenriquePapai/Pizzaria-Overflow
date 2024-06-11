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

    public ConfirmaPedido() {
        setTitle("Confirmar Pedido");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // trava o tamanho da tela
        setLocationRelativeTo(null); // centraliza a tela

        setLayout(null);

        
        // Label
        JLabel titulo = new JLabel("Confirmar Pedido");
        titulo.setBounds(278, 150, 500, 80); // margem esquerda, cima, comprimento, altura
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        add(titulo);

        // Botão
        JButton jButton = new JButton("Finalizar Pedido");
        jButton.setBounds(290, 270, 400, 40); // margem esquerda, cima, comprimento, altura botão
        jButton.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        jButton.setForeground(new Color(0, 0, 0));
        jButton.setBackground(new Color(190, 196, 201));
        add(jButton);
        jButton.addActionListener(this::FinalizarPedido);


        JButton jButton2 = new JButton("Voltar");
        jButton2.setBounds(290, 325, 400, 40); // margem esquerda, cima, comprimento, altura botão
        jButton2.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        jButton2.setForeground(new Color(0, 0, 0));
        jButton2.setBackground(new Color(190, 196, 201));
        add(jButton2);
        jButton2.addActionListener(this::Voltar);

        setVisible(true);
    }

    private void FinalizarPedido(ActionEvent actionEvent) {
        try {
            FileInputStream fis = new FileInputStream("pedidos.ser"); // Abre arquivo para leitura usando FileInputStream
            ObjectInputStream ois = new ObjectInputStream(fis); // Cria o ObjectInputStream para ler o arquivo
            ArrayList<PedidoItem> pedidosRecuperados = (ArrayList<PedidoItem>) ois.readObject(); // Lê o arquivo e armazena em uma lista
            System.out.println("Pedidos finalizados:");
            for (PedidoItem pedido : pedidosRecuperados) {
                System.out.println(pedido);
            }
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso, ele será entregue em sua residência em breve!", "Pedido finalizado", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }
    private void Voltar(ActionEvent actionEvent) {
        this.dispose();
        new Pedido();
    }
}
