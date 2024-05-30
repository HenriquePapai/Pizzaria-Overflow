import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


class Cadastro extends JFrame{
    private JTextField nome;
    private JTextField email;
    private JTextField cpf;
    private JTextField senha;

    public Cadastro() {
        setTitle("Cadastro");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // trava o tamanho da tela
        setLocationRelativeTo(null); // centraliza a tela
        //getContentPane().setBackground(new Color(206, 159, 0));

        setLayout(null);


        // Label
        JLabel titulo = new JLabel("Cadastro");
        titulo.setBounds(390, 25, 300, 80); // margem esquerda, cima, comprimento, altura
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        add(titulo);

        JLabel jLabel = new JLabel("Nome:");
        jLabel.setBounds(290, 103, 90, 50); // margem esquerda, cima, comprimento, altura
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel);

        JLabel jLabel2 = new JLabel("E-mail:");
        jLabel2.setBounds(290, 173, 90, 50); // margem esquerda, cima, comprimento, altura
        jLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel2);

        JLabel jLabel3 = new JLabel("CPF:");
        jLabel3.setBounds(290, 243, 90, 50); // margem esquerda, cima, comprimento, altura
        jLabel3.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel3);

        JLabel jLabel4 = new JLabel("Senha:");
        jLabel4.setBounds(290, 313, 90, 50); // margem esquerda, cima, comprimento, altura
        jLabel4.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel4);



        // Campos
        nome = new JTextField();
        nome.setBounds(290, 140, 400, 40); // margem esquerda, cima, comprimento, altura campo
        nome.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        add(nome);

        email = new JTextField();
        email.setBounds(290, 210, 400, 40); // margem esquerda, cima, comprimento, altura campo
        email.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        add(email);

        cpf = new JTextField();
        cpf.setBounds(290, 280, 400, 40); // margem esquerda, cima, comprimento, altura campo
        cpf.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        add(cpf);

        senha = new JTextField();
        senha.setBounds(290, 350, 400, 40); // margem esquerda, cima, comprimento, altura campo
        senha.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        add(senha);



        // Botões
        JButton jButton = new JButton("Entrar");
        jButton.setBounds(290, 405, 400, 40); // margem esquerda, cima, comprimento, altura botão
        jButton.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        jButton.setForeground(new Color(0, 0, 0));
        jButton.setBackground(new Color(190, 196, 201));
        add(jButton);
        jButton.addActionListener(this::entrar);

        JButton jButton2 = new JButton("Já tenho uma conta");
        jButton2.setBounds(290, 460, 400, 40); // margem esquerda, cima, comprimento, altura botão
        jButton2.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        jButton2.setForeground(new Color(0, 0, 0));
        jButton2.setBackground(new Color(190, 196, 201));
        add(jButton2);
        jButton2.addActionListener(this::cadastro);

        setVisible(true);
    }

    private void entrar(ActionEvent actionEvent) {
        // fazer o IF
        JOptionPane.showMessageDialog(null, "E-mail ou senha incorretos.", "Erro de login", JOptionPane.WARNING_MESSAGE);
        System.out.println("Eae");
    }
    private void cadastro(ActionEvent actionEvent) {
        this.dispose(); // fecha a janela atual
        new Login(); // carrega a página de login


    }
}

public class pCadastro {
    public static void main(String[] args) {
        new Cadastro();
    }
}