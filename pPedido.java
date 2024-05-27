import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
  
class Pedido extends JFrame {
    private JComboBox<String> tamanho;
    private JComboBox<String> sabor;

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

        JLabel jLabel4 = new JLabel("Valor total: ");
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
        jButton2.addActionListener(this::FinalizarPedido);

        setVisible(true);
    }
    
    private void AdicionarPedido(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Pedido adicionado com sucesso.", "Pedido adicionado", JOptionPane.INFORMATION_MESSAGE);
    }
    private void FinalizarPedido(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso, ele será entregue em sua residência em breve!", "Pedido finalizado", JOptionPane.INFORMATION_MESSAGE);
    }
}
