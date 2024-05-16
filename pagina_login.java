import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


class Login extends JFrame{
    JTextField email;
    JTextField senha;

    public Login() {
        setTitle("Login");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // trava o tamanho da tela
        setLocationRelativeTo(null); // centraliza a tela
        //getContentPane().setBackground(new Color(206, 159, 0));
        
        setLayout(null);

        
        // Label
        JLabel titulo = new JLabel("Login");
        titulo.setBounds(410, 80, 200, 80);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        add(titulo);        

        JLabel jLabel = new JLabel("E-mail:");
        jLabel.setBounds(290, 183, 90, 50); // margem esquerda, cima, comprimento, altura
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel);

        JLabel jLabel2 = new JLabel("Senha:");
        jLabel2.setBounds(290, 253, 90, 50); // margem esquerda, cima, comprimento, altura
        jLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel2);


        
        // Campos
        email = new JTextField();
        email.setBounds(290, 220, 400, 40); // margem esquerda, cima, comprimento, altura campo
        email.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        add(email);
        
        senha = new JTextField();
        senha.setBounds(290, 290, 400, 40); // margem esquerda, cima, comprimento, altura campo
        senha.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        add(senha);
        

        
        // Botões
        JButton jButton = new JButton("Entrar");
        jButton.setBounds(290, 345, 400, 40); // margem esquerda, cima, comprimento, altura botão
        jButton.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        jButton.setForeground(new Color(0, 0, 0));
        jButton.setBackground(new Color(190, 196, 201));
        add(jButton);
        jButton.addActionListener(this::entrar);
        
        JButton jButton2 = new JButton("Não tenho uma conta");
        jButton2.setBounds(290, 400, 400, 40); // margem esquerda, cima, comprimento, altura botão
        jButton2.setFont(new Font("Arial", Font.BOLD, 20)); // fonte, tipo, tamanho
        jButton2.setForeground(new Color(0, 0, 0));
        jButton2.setBackground(new Color(190, 196, 201));
        add(jButton2);
        jButton2.addActionListener(this::cadastro);
        
        setVisible(true);
    }
    
    private void entrar(ActionEvent actionEvent) {
        // fazer o IF

        System.out.println("Eae");
    }
    private void cadastro(ActionEvent actionEvent) {
        this.dispose(); // fecha a janela atual
        new Cadastro("Cadastro"); // carrega a página de cadastro
        

    }
}

public class pagina_login {
    public static void main(String[] args) {
        new Login();
    }
}