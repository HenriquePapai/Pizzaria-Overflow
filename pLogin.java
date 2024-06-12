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

import java.io.File;


class Login extends JFrame{
    private JTextField email;
    private JPasswordField senha;

    // Criando ArrayList e lendo o conteúdo do arquivos respectivos arquivos
    private ArrayList<String> user = lerArquivo(Main.localArquivo + "users.txt");

    private ArrayList<String> pass = lerArquivo(Main.localArquivo + "senhas.txt");

    private ArrayList<String> name = lerArquivo(Main.localArquivo + "name.txt");

    private String nomeUsuario; // adiciona um membro para armazenar o nome do usuário

    // Método para decifrar o texto com a cifra de César com pulo variavel
    public String decifrarTexto(String textoCifrado) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@.";
        StringBuilder textoDecifrado = new StringBuilder();
        int salto = 2; // Salto inicial
        for (char caracter : textoCifrado.toCharArray()) {
            int index = alfabeto.indexOf(caracter);
            if (index != -1) {
                // Decifra o caractere se ele estiver no alfabeto
                char decifrado = alfabeto.charAt((index - salto + alfabeto.length()) % alfabeto.length());
                textoDecifrado.append(decifrado);
                salto++; // Ajusta o salto para o próximo caractere
            } else {
                // Mantém o caractere original se não estiver no alfabeto
                textoDecifrado.append(caracter);
            }
        }
        return textoDecifrado.toString();
    }

    // Lê o conteúdo do arquivo
    public ArrayList<String> lerArquivo(String nomeArquivo) {
        ArrayList<String> list = new ArrayList<>();

        // Tenta ler o arquivo
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo)); // Cria o BufferedReader para ler o arquivo
            String line;
            while ((line = reader.readLine()) != null) {
                // Trecho para recuperar a senha cifrada
                String decifrado = decifrarTexto(line); // Decifra a linha antes de dividir
                String[] items = decifrado.split(","); // Divide os elementos separados por vírgula
                for (String item : items) {
                    list.add(item); // Adiciona na lista
                }
            }
            reader.close();
        } catch (FileNotFoundException e) { // Caso o arquivo não seja encontrado
            System.out.println("O arquivo não foi encontrado.");
            e.printStackTrace(); // Imprime o erro
        } catch (IOException e) { // Caso ocorra algum erro ao ler o arquivo
            System.out.println("Ocorreu um erro ao ler o arquivo.");
            e.printStackTrace(); // Imprime o erro
        }
        return list;
    }

    public Login() {
        setTitle("Login");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // trava o tamanho da tela
        setLocationRelativeTo(null); // centraliza a tela

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

        senha = new JPasswordField();
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
        int loginValido = 0;
        String emailDigitado = email.getText(); // pega o email digitado pelo usuário
        char[] senhaArray = senha.getPassword();  // converte a senha em uma String
        String senhaDigitada = new String(senhaArray); // pega a senha digitada pelo usuário
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).equals(emailDigitado) && pass.get(i).equals(senhaDigitada)) { // Pega o texto que está dentro do JTextField
                loginValido = 1;
                nomeUsuario = name.get(i); // pega o nome do usuário correspondente ao login e salva no nomeUsuario
                new File("pedidos.txt").delete(); // Comando para deletar os pedidos do usuario anterior
                break;
            }
        }

        if (loginValido == 1) {
            this.dispose();
            Pedido pedido = new Pedido(); // Abre a nova página de Pedido
            pedido.setNomeUsuario(nomeUsuario); // Define o nome do usuário na instância de Pedido
        } else {
            JOptionPane.showMessageDialog(null, "E-mail ou senha incorretos.", "Erro de login", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void cadastro(ActionEvent actionEvent) {
        this.dispose(); // fecha a janela atual
        new Cadastro(); // carrega a página de cadastro
    }
}
