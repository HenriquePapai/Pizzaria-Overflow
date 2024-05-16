import javax.swing.*;
import java.awt.*;

class Cadastro extends JPanel {
    private static final int ALTURA_BARRA_TITULO = 20;
    private JFrame frame;

    //Novos botões
    private JTextField nomeCompleto;
    private JTextField email;
    private JTextField cpf;
    private JTextField endereco;
    private JPasswordField senha;
    private JButton submitButton;

    public Cadastro(String nome) {

        // Define o layout do painel como GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Cria os campos de login e senha
        nomeCompleto = new JTextField(20);
        email = new JTextField(20);
        cpf = new JTextField(20);
        endereco = new JTextField(20);
        senha = new JPasswordField(20);
        submitButton = new JButton("Entrar");

        // Cria painéis para cada campo e adiciona os campos aos painéis
        JPanel NomeCompleto = new JPanel();
        NomeCompleto.setLayout(new BoxLayout(NomeCompleto, BoxLayout.PAGE_AXIS));
        NomeCompleto.add(new JLabel("Nome Completo:"));
        NomeCompleto.add(nomeCompleto);

        JPanel Email = new JPanel();
        Email.setLayout(new BoxLayout(Email, BoxLayout.PAGE_AXIS));
        Email.add(new JLabel("Email:"));
        Email.add(email);

        JPanel CPF = new JPanel();
        CPF.setLayout(new BoxLayout(CPF, BoxLayout.PAGE_AXIS));
        CPF.add(new JLabel("CPF:"));
        CPF.add(cpf);

        JPanel Endereco = new JPanel();
        Endereco.setLayout(new BoxLayout(Endereco, BoxLayout.PAGE_AXIS));
        Endereco.add(new JLabel("Endereço:"));
        Endereco.add(endereco);

        JPanel Senha = new JPanel();
        Senha.setLayout(new BoxLayout(Senha, BoxLayout.PAGE_AXIS));
        Senha.add(new JLabel("Senha:"));
        Senha.add(senha);

        // Adiciona os painéis e o botão ao painel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(NomeCompleto, gbc);
        gbc.gridy = 1;
        this.add(Email, gbc);
        gbc.gridy = 2;
        this.add(CPF, gbc);
        gbc.gridy = 3;
        this.add(Endereco, gbc);
        gbc.gridy = 4;
        this.add(Senha, gbc);
        gbc.gridy = 5;
        gbc.insets = new Insets(30, 0, 0, 0); // Adiciona um espaço extra acima do botão
        this.add(submitButton, gbc);

        frame = new JFrame(nome); // cria um frame
        frame.add(this); // insere o território no frame
        frame.setSize(1000, 600 + ALTURA_BARRA_TITULO ); // define as dimensões do frame
        frame.setResizable(false);
        frame.setVisible(true); // torna o frame visível
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define como o frame é fechado
    }
}

public class pagCadastro {
    public static void main(String[] args) {
        Cadastro territorio = new Cadastro("Cadastro");
    }
}