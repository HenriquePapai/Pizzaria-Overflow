abstract class Pizza {
  protected String tamanho;
  protected double valor;

  public Pizza(String tamanho, double valor) {
    this.tamanho = tamanho;
    this.valor = valor;
  }

  public abstract double calculaPreco();
  
  public void mostraPreco() {
    System.out.println(calculaPreco());
  }
}

class PizzaGrande extends Pizza {
  public PizzaGrande(String tamanho, double valor) {
    super(tamanho, valor);
  }
  public double calculaPreco() {
    return valor += 75;
  }
}

class PizzaMedia extends Pizza {
  public PizzaMedia(String tamanho, double valor) {
    super(tamanho, valor);
  }
  public double calculaPreco() {
    return valor += 60;
  }
}

class PizzaPequena extends Pizza {
  public PizzaPequena(String tamanho, double valor) {
    super(tamanho, valor);
  }
  public double calculaPreco() {
    return valor += 45;
  }
}

class PizzaBroto extends Pizza {
  public PizzaBroto(String tamanho, double valor) {
    super(tamanho, valor);
  }
  public double calculaPreco() {
    return valor += 35;
  }
}

