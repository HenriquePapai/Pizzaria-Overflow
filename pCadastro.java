import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Cadastro extends JFrame {
    private JTextField nome;
    private JTextField email;
    private JTextField cpf;
    private JPasswordField senha;

    public Cadastro() {
        setTitle("Cadastro");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(null);

        // Labels
        JLabel titulo = new JLabel("Cadastro");
        titulo.setBounds(390, 25, 300, 80);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        add(titulo);

        JLabel jLabel = new JLabel("Nome:");
        jLabel.setBounds(290, 103, 90, 50);
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel);

        JLabel jLabel2 = new JLabel("E-mail:");
        jLabel2.setBounds(290, 173, 90, 50);
        jLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel2);

        JLabel jLabel3 = new JLabel("CPF:");
        jLabel3.setBounds(290, 243, 90, 50);
        jLabel3.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel3);

        JLabel jLabel4 = new JLabel("Senha:");
        jLabel4.setBounds(290, 313, 90, 50);
        jLabel4.setFont(new Font("Arial", Font.BOLD, 20));
        add(jLabel4);

        // Campos de texto
        nome = new JTextField();
        nome.setBounds(290, 140, 400, 40);
        nome.setFont(new Font("Arial", Font.BOLD, 20));
        add(nome);

        email = new JTextField();
        email.setBounds(290, 210, 400, 40);
        email.setFont(new Font("Arial", Font.BOLD, 20));
        add(email);

        cpf = new JTextField();
        cpf.setBounds(290, 280, 400, 40);
        cpf.setFont(new Font("Arial", Font.BOLD, 20));
        add(cpf);

        senha = new JPasswordField();
        senha.setBounds(290, 350, 400, 40);
        senha.setFont(new Font("Arial", Font.BOLD, 20));
        add(senha);

        // Botões
        JButton jButton = new JButton("Cadastrar");
        jButton.setBounds(290, 405, 400, 40);
        jButton.setFont(new Font("Arial", Font.BOLD, 20));
        jButton.setForeground(new Color(0, 0, 0));
        jButton.setBackground(new Color(190, 196, 201));
        add(jButton);
        jButton.addActionListener(this::entrar);

        JButton jButton2 = new JButton("Já tenho uma conta");
        jButton2.setBounds(290, 460, 400, 40);
        jButton2.setFont(new Font("Arial", Font.BOLD, 20));
        jButton2.setForeground(new Color(0, 0, 0));
        jButton2.setBackground(new Color(190, 196, 201));
        add(jButton2);
        jButton2.addActionListener(this::cadastro);

        setVisible(true);
    }

    private void entrar(ActionEvent actionEvent) {
        ArrayList<String> user = new ArrayList<>();
        ArrayList<String> pass = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();

        String nomeDigitado = nome.getText();
        String emailDigitado = email.getText();
        char[] senhaArray = senha.getPassword();
        String senhaDigitada = new String(senhaArray);

        user.add(emailDigitado + ",");
        pass.add(senhaDigitada + ",");
        name.add(nomeDigitado + ",");

        escreverArquivo(user, Main.localArquivo + "users.txt");
        escreverArquivo(pass, Main.localArquivo + "senhas.txt");
        escreverArquivo(name, Main.localArquivo + "name.txt");

        this.dispose();
        new Login();
    }

    public String cifrarTexto(String texto) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@.";
        StringBuilder textoCifrado = new StringBuilder();
        int salto = 2;
        for (char caracter : texto.toCharArray()) {
            int index = alfabeto.indexOf(caracter);
            if (index != -1) {
                char cifrado = alfabeto.charAt((index + salto) % alfabeto.length());
                textoCifrado.append(cifrado);
                salto++;
            } else {
                textoCifrado.append(caracter);
            }
        }
        return textoCifrado.toString();
    }

    public void escreverArquivo(ArrayList<String> lista, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            for (String item : lista) {
                String itemCifrado = cifrarTexto(item);
                writer.write(itemCifrado + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao tentar escrever no arquivo.");
            e.printStackTrace();
        }
    }

    private void cadastro(ActionEvent actionEvent) {
        this.dispose();
        new Login();
    }

    // Método main para iniciar a aplicação
    public static void main(String[] args) {
        new Cadastro();
    }
}
