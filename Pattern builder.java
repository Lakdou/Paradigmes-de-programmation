// Classe CoffeeOrder représentant une commande de café
class CoffeeOrder {
    private String typeOfCoffee;
    private boolean withMilk;
    private boolean withSugar;

    public CoffeeOrder(String typeOfCoffee, boolean withMilk, boolean withSugar) {
        this.typeOfCoffee = typeOfCoffee;
        this.withMilk = withMilk;
        this.withSugar = withSugar;
    }

    public String getTypeOfCoffee() {
        return typeOfCoffee;
    }

    public boolean isWithMilk() {
        return withMilk;
    }

    public boolean isWithSugar() {
        return withSugar;
    }

    @Override
    public String toString() {
        String milk = withMilk ? "avec lait" : "sans lait";
        String sugar = withSugar ? "avec sucre" : "sans sucre";
        return "Commande de café : " + typeOfCoffee + ", " + milk + ", " + sugar;
    }
}

// Classe CoffeeOrderBuilder pour construire les commandes de café
class CoffeeOrderBuilder {
    private String typeOfCoffee;
    private boolean withMilk;
    private boolean withSugar;

    public CoffeeOrderBuilder(String typeOfCoffee) {
        this.typeOfCoffee = typeOfCoffee;
    }

    public CoffeeOrderBuilder withMilk(boolean withMilk) {
        this.withMilk = withMilk;
        return this;
    }

    public CoffeeOrderBuilder withSugar(boolean withSugar) {
        this.withSugar = withSugar;
        return this;
    }

    public CoffeeOrder build() {
        return new CoffeeOrder(typeOfCoffee, withMilk, withSugar);
    }
}

// Classe principale pour tester le pattern Builder
public class Main {
    public static void main(String[] args) {
        // Création de commandes de café avec le pattern Builder
        CoffeeOrderBuilder builder = new CoffeeOrderBuilder("Espresso");
        CoffeeOrder espressoWithoutMilk = builder.withMilk(false).withSugar(true).build();

        CoffeeOrderBuilder builder2 = new CoffeeOrderBuilder("Cappuccino");
        CoffeeOrder cappuccinoWithMilkAndSugar = builder2.withMilk(true).withSugar(true).build();

        CoffeeOrderBuilder builder3 = new CoffeeOrderBuilder("Latte");
        CoffeeOrder latteWithMilkWithoutSugar = builder3.withMilk(true).withSugar(false).build();

        // Affichage des détails des commandes de café
        System.out.println(espressoWithoutMilk);
        System.out.println(cappuccinoWithMilkAndSugar);
        System.out.println(latteWithMilkWithoutSugar);
    }
}
