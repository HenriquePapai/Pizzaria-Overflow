import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

//Caso o try falhe
import java.io.FileNotFoundException;

// Imports usados para ler trazer as informações de um arquivo txt
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class Login extends JFrame{
    private JTextField email;
    private JTextField senha;

    //teste
    private JTextField nome;

    //Informações dos arquivos txt
    private ArrayList<String> user = lerArquivo("C:/Estudos/Programação Orientada a Objetos/PjBL/Pizzaria-Overflow-main/users.txt");

    private ArrayList<String> pass = lerArquivo("C:/Estudos/Programação Orientada a Objetos/PjBL/Pizzaria-Overflow-main/senhas.txt");

    //teste
    private ArrayList<String> name = lerArquivo("C:/Estudos/Programação Orientada a Objetos/PjBL/Pizzaria-Overflow-main/name.txt");

    // Trazer os usuarios para dentro do ArrayList user
    public static ArrayList<String> lerArquivo(String nomeArquivo) {
        ArrayList<String> list = new ArrayList<>();

        // Tenta puxar as informações do arquivo txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");
                for (String item : items) {
                    list.add(item); // Se for adicionar espaços entre os parametros adicionar o .trim()
                }
            }
            reader.close();
            // Caso o arquivo não seja encontrado
        } catch (FileNotFoundException e) {
            System.out.println("O arquivo não foi encontrado.");
            e.printStackTrace();
            // Caso ocorra algum erro ao ler o arquivo
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo.");
            e.printStackTrace();
        }
        return list;
    }

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
        titulo.setBounds(420, 80, 200, 80); // margem esquerda, cima, comprimento, altura
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
    private String nomeUsuario; // adiciona um membro para armazenar o nome do usuário
    private String emailUsuario; // adiciona um membro para armazenar o email do usuário

    public String getNomeUsuario() { // Obtém o nome do usuário
        return nomeUsuario;
    }

    public String getEmailUsuario() { // Obtém o email do usuário
        return emailUsuario;
    }


    private void entrar(ActionEvent actionEvent) {
        // fazer o IF
        boolean loginValido = false;
        String emailDigitado = email.getText();
        String senhaDigitada = senha.getText();
        for (int i = 0; i < user.size(); i++) {
            // Pegar o texto que está dentro do JTextField
            if (user.get(i).equals(emailDigitado) && pass.get(i).equals(senhaDigitada)) {
                loginValido = true;
                nomeUsuario = name.get(i);
                emailUsuario = emailDigitado;
                break;
            }
        }

        if (loginValido) {
            this.dispose();
            // Página para onde ele envia após estar logado
            new Pedido();
        } else {
            JOptionPane.showMessageDialog(null, "E-mail ou senha incorretos.", "Erro de login", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void cadastro(ActionEvent actionEvent) {
        this.dispose(); // fecha a janela atual
        new Cadastro(); // carrega a página de cadastro
    }
}

