import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Product p1 = new Product("Kaas", 400);
        Product p2 = new Product("Wasmiddel", 800);
        Product p3 = new Product("Worst", 200);
        Product p4 = new Product("Chips", 400);
        Product p5 = new Product("Appels", 150);

        List<Product> producten = new ArrayList();
        producten.add(p1);
        producten.add(p2);
        producten.add(p3);
        producten.add(p4);
        producten.add(p5);

        for (Product p : producten) {
            System.out.println(p.naam + ">>" + p.prijs);
        }

        Collections.sort(producten);
        System.out.println("Gesorteerd op prijs: " + producten);

        producten.sort(new ProductNameComparator());
        System.out.println("Gesorteerd op naam: " + producten);
    }
}

class Product implements Comparable<Product> {
    String naam;
    int prijs;

    Product(String naam, int prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getPrijs() {
        return this.prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    @Override
    public int compareTo(Product otherProduct) {
        if (this.prijs < otherProduct.getPrijs()) {
            return -1;
        } else if (this.prijs > otherProduct.getPrijs()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }

        if (this.getClass() != otherObject.getClass()) {
            return false;
        }

        Product otherProduct = (Product) otherObject;

        if (this.naam.equals(otherProduct.getNaam())
                && this.prijs == otherProduct.getPrijs()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.naam, this.prijs);
    }

    @Override
    public String toString() {
        return this.naam + ">>" + this.prijs;
    }
}

class ProductNameComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getNaam().compareTo(p2.getNaam());
    }
}
