abstract class Pizza {
  protected String tamanho;

  public Pizza(String tamanho) {
    this.tamanho = tamanho;
  }

  public abstract double calculaPreco();
  
  public void mostraPreco() {
    System.out.println(calculaPreco());
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

