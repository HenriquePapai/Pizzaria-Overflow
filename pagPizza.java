import javax.swing.*;
import java.awt.*;

class Pizza extends JPanel {
    private static final int ALTURA_BARRA_TITULO = 20;
    private JFrame frame;

    //Novos botões
    private JLabel numeroPedido;
    private JComboBox tamanho;
    private JComboBox sabor;
    private JLabel valor;
    private JButton submitButton;

    public Pizza(String nome) {

        // Define o layout do painel como GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Cria os campos de login e senha
        numeroPedido = new JLabel("20");
        String[] tamanhos = {" - ", "Grande", "Média", "Pequena", "Broto"};
        tamanho = new JComboBox(tamanhos);
        tamanho.setPreferredSize(new Dimension(200, 20)); // Define o tamanho da JComboBox
        String[] sabores = {" - ", "Calabresa", "Frango Catupiry", "Lombo"};
        sabor = new JComboBox(sabores);
        sabor.setPreferredSize(new Dimension(200, 20)); // Define o tamanho da JComboBox
        valor = new JLabel("20");
        submitButton = new JButton("Finalizar Pedido");

        // Cria painéis para cada campo e adiciona os campos aos painéis
        JPanel NumeroPedido = new JPanel();
        NumeroPedido.setLayout(new BoxLayout(NumeroPedido, BoxLayout.LINE_AXIS));
        NumeroPedido.add(new JLabel("Numero do Pedido:  "));
        NumeroPedido.add(numeroPedido);

        JPanel Tamanho = new JPanel();
        Tamanho.setLayout(new BoxLayout(Tamanho, BoxLayout.PAGE_AXIS));
        Tamanho.add(new JLabel("Tamanho:"));
        Tamanho.add(tamanho);

        JPanel Sabor = new JPanel();
        Sabor.setLayout(new BoxLayout(Sabor, BoxLayout.PAGE_AXIS));
        Sabor.add(new JLabel("Sabor:"));
        Sabor.add(sabor);

        JPanel Valor = new JPanel();
        Valor.setLayout(new BoxLayout(Valor, BoxLayout.LINE_AXIS));
        Valor.add(new JLabel("Valor Total:  "));
        Valor.add(valor);

        // Adiciona os painéis e o botão ao painel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(NumeroPedido, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0); // Adiciona um espaço abaixo do numero do pedido
        this.add(Tamanho, gbc);
        gbc.gridy = 2;
        this.add(Sabor, gbc);
        gbc.gridy = 3;
        gbc.insets = new Insets(20, 0, 0, 0); // Adiciona um espaço entre sabor e valor
        this.add(Valor, gbc);
        gbc.gridy = 4;
        gbc.insets = new Insets(20, 0, 0, 0); // Adiciona um espaço extra acima do botão
        this.add(submitButton, gbc);

        frame = new JFrame(nome); // cria um frame
        frame.add(this); // insere o território no frame
        frame.setSize(1000, 600 + ALTURA_BARRA_TITULO ); // define as dimensões do frame
        frame.setResizable(false);
        frame.setVisible(true); // torna o frame visível
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define como o frame é fechado
    }
}

public class pagPizza {
    public static void main(String[] args) {
        Pizza territorio = new Pizza("Pizza");
    }
}