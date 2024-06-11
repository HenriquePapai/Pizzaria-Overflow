import java.io.Serializable;

class PedidoItem implements Serializable { // objetos dessa classe podem ser serializados
    private String tamanho;
    private String sabor;
    private double preco;
    
    public PedidoItem(String tamanho, String sabor, double preco) {
        this.tamanho = tamanho;
        this.sabor = sabor;
        this.preco = preco;
    }
    
    public String toString() {
        return"Tamanho: " + tamanho + ", Sabor: " + sabor + ", Preço: R$" + preco;
    }
}