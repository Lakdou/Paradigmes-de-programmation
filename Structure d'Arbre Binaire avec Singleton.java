import java.util.ArrayList;
import java.util.List;

// Classe Stock représentant une action
class Stock {
    private String nom;
    private double prix;

    public Stock(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

// Interface Observer
interface Observer {
    void update(Stock stock);
}

// Classe Investor représentant un investisseur
class Investor implements Observer {
    private String nom;

    public Investor(String nom) {
        this.nom = nom;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Investisseur " + nom + " : Nouveau prix pour " + stock.getNom() + " : " + stock.getPrix());
    }
}

// Classe StockMarket représentant le marché boursier
class StockMarket {
    private List<Observer> observers;
    private Stock stock;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    public void addInvestor(Observer observer) {
        observers.add(observer);
    }

    public void removeInvestor(Observer observer) {
        observers.remove(observer);
    }

    public void setStockPrice(Stock stock, double newPrice) {
        stock.setPrix(newPrice);
        notifyObservers(stock);
    }

    private void notifyObservers(Stock stock) {
        for (Observer observer : observers) {
            observer.update(stock);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Création du marché boursier
        StockMarket market = new StockMarket();

        // Création des investisseurs
        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        // Ajout des investisseurs au marché boursier
        market.addInvestor(investor1);
        market.addInvestor(investor2);

        // Simulation des changements de prix des actions
        Stock stock = new Stock("GOOG", 1000);
        market.setStockPrice(stock, 1100);
        market.setStockPrice(stock, 1050);
    }
}
