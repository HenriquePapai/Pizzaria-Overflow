import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// Novos imports para parte de cadastro
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
        JButton jButton = new JButton("Cadastrar");
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

        ArrayList<String> user = new ArrayList<>();
        ArrayList<String> pass = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();

        // Obter os dados digitados pelo usuário para cadastro
        String nomeDigitado = nome.getText();
        String emailDigitado = email.getText();
        //String cpfDigitado = cpf.getText();
        String senhaDigitada = senha.getText();

        // Adicionar os novos dados às listas
        user.add(emailDigitado + ",");
        pass.add(senhaDigitada + ",");
        name.add(nomeDigitado + ",");

        // Escrever as listas atualizadas nos arquivos
        escreverArquivo(user, "C:/Users/ericr/Documents/3 - Periodo/Programação Orientada a Objetos/PROJETO FINAL/ProjFinal/interface/src/users.txt");
        escreverArquivo(pass, "C:/Users/ericr/Documents/3 - Periodo/Programação Orientada a Objetos/PROJETO FINAL/ProjFinal/interface/src/senhas.txt");
        escreverArquivo(name, "C:/Users/ericr/Documents/3 - Periodo/Programação Orientada a Objetos/PROJETO FINAL/ProjFinal/interface/src/name.txt");

        // Fechar a janela atual e abrir a de login
        this.dispose();
        new Login();
    }

    // Método para escrever no arquivo
    public static void escreverArquivo(ArrayList<String> lista, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            for (String item : lista) {
                writer.write(item + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }

    private void cadastro(ActionEvent actionEvent) {
        this.dispose(); // fecha a janela atual
        new Login(); // carrega a página de login
    }
}

