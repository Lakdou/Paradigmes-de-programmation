// Interface Boisson
interface Boisson {
    String description();
    double cout();
}

// Classe concrète Cafe représentant le café de base
class Cafe implements Boisson {
    @Override
    public String description() {
        return "Café";
    }

    @Override
    public double cout() {
        return 1.0;
    }
}

// Classe abstraite Decorateur
abstract class Decorateur implements Boisson {
    protected Boisson boisson;

    public Decorateur(Boisson boisson) {
        this.boisson = boisson;
    }
}

// Classe concrète Lait représentant l'ingrédient supplémentaire lait
class Lait extends Decorateur {
    public Lait(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String description() {
        return boisson.description() + ", Lait";
    }

    @Override
    public double cout() {
        return boisson.cout() + 0.5;
    }
}

// Classe concrète Sucre représentant l'ingrédient supplémentaire sucre
class Sucre extends Decorateur {
    public Sucre(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String description() {
        return boisson.description() + ", Sucre";
    }

    @Override
    public double cout() {
        return boisson.cout() + 0.3;
    }
}

// Classe principale Main
public class Main {
    public static void main(String[] args) {
        // Sélection du café de base
        Boisson cafeBase = new Cafe();

        // Personnalisation de la boisson avec des ingrédients supplémentaires
        Boisson cafePersonnalise = new Lait(new Sucre(cafeBase));

        // Affichage de la description et du coût final de la boisson personnalisée
        System.out.println("Description : " + cafePersonnalise.description());
        System.out.println("Coût : " + cafePersonnalise.cout());
    }
}
