import javax.swing.*;
import java.awt.*;

class Login extends JPanel {
    private static final int ALTURA_BARRA_TITULO = 20;
    private JFrame frame;
    private JButton button;
    private JTextField textField;
    public Login(String nome) {
        frame = new JFrame(nome); // cria um frame
        frame.setSize(1000, 600);
        frame.setResizable(false);
        
        textField = new JTextField("", 40); // Cria o input e define o comprimento
        textField.setPreferredSize(new Dimension(1, 40)); // define a altura do input
    
        this.add(textField);
        frame.add(this); // insere o território no frame
        frame.setVisible(true); // torna o frame visível
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define como o frame é fechado
    }
    private String Email = "";
    private String Senha = "";
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g; // por motivos de compatibilidade com a AWT
        g2d.setColor(Color.BLACK); // define a cor em uso
        g2d.setFont(new Font("Verdana", Font.BOLD, 16)); // define a fonte em uso

        g2d.drawString("E-mail: ",200 , 30); // escreve uma string, define largura e altura
        g2d.drawString("Senha: ", 200, 30);          
    }
}

public class pagina_login {
    public static void main(String[] args) {
        Login login = new Login("Login");
    }
}