import java.io.Serializable;

class PedidoItem implements Serializable { // objetos dessa classe podem ser serializados
    private String nomeUsuario;
    private String tamanho;
    private String sabor;
    private double preco;
    
    public PedidoItem(String nomeUsuario, String tamanho, String sabor, double preco) {
        this.nomeUsuario = nomeUsuario;
        this.tamanho = tamanho;
        this.sabor = sabor;
        this.preco = preco;
    }
    
    public String toString() {
        return nomeUsuario + " - " + "Tamanho: " + tamanho + ", Sabor: " + sabor + ", Preço: R$" + preco;
    }
}