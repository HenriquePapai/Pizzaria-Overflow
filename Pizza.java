abstract class Pizza {
  protected String tamanho;
  protected String sabor;
  protected double valor;

  public Pizza(String tamanho, String sabor, double valor) {
    this.tamanho = tamanho;
    this.sabor = sabor;
    this.valor = valor;
  }

  public abstract double calculaPreco();
  
  public void mostraPreco() {
    System.out.println(calculaPreco());
  }
}

class PizzaGrande extends Pizza {
  public PizzaGrande(String tamanho, String sabor, double valor) {
    super(tamanho, sabor, valor);
  }
  public double calculaPreco() {
    return valor += 75;
  }
}

class PizzaMedia extends Pizza {
  public PizzaMedia(String tamanho, String sabor, double valor) {
    super(tamanho, sabor, valor);
  }
  public double calculaPreco() {
    return valor += 60;
  }
}

class PizzaPequena extends Pizza {
  public PizzaPequena(String tamanho, String sabor, double valor) {
    super(tamanho, sabor, valor);
  }
  public double calculaPreco() {
    return valor += 45;
  }
}

class PizzaBroto extends Pizza {
  public PizzaBroto(String tamanho, String sabor, double valor) {
    super(tamanho, sabor, valor);
  }
  public double calculaPreco() {
    return valor += 35;
  }
}

