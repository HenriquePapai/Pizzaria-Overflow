abstract class Pizza extends CalculaPreco {
  protected String tamanho;

  public Pizza(String tamanho) {
    this.tamanho = tamanho;
  }
}

class PizzaGrande extends Pizza {
  public PizzaGrande(String tamanho) {
    super(tamanho);
  }
  public double calculaPreco() {
    return 75;
  }
}

class PizzaMedia extends Pizza {
  public PizzaMedia(String tamanho) {
    super(tamanho);
  }
  public double calculaPreco() {
    return 60;
  }
}

class PizzaPequena extends Pizza {
  public PizzaPequena(String tamanho) {
    super(tamanho);
  }
  public double calculaPreco() {
    return 45;
  }
}

class PizzaBroto extends Pizza {
  public PizzaBroto(String tamanho) {
    super(tamanho);
  }
  public double calculaPreco() {
    return 35;
  }
}

