import javax.swing.*;
import java.awt.*;
import java.io.*;

class Comanda extends JFrame{
    public Comanda() {
        setTitle("Comanda");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // trava o tamanho da tela
        setLocationRelativeTo(null); // centraliza a tela

        setLayout(null);


        // Label
        JLabel titulo = new JLabel("Comanda");
        titulo.setBounds(378, 70, 300, 80); // margem esquerda, cima, comprimento, altura
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        add(titulo);


        
        // Campo do pedido
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 150, 900, 400); // margem esquerda, cima, comprimento, altura
        add(scrollPane);

        
        try { // Lê o arquivo "pedidos.txt"
            FileInputStream fis = new FileInputStream("pedidos.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis)); // lê as linhas do arquivo
            String line; // variável para armazenar cada linha do arquivo
            while ((line = br.readLine()) != null) { // enquanto tiver linhas para ler, adiciona a linha lida no campo
                textArea.append(line + "\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace(); // imprime o erro
        }

        setVisible(true);
    }
}





