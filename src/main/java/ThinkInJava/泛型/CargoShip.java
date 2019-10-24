package ThinkInJava.泛型;

import ThinkInJava.泛型.util.Generator;
import ThinkInJava.泛型.util.Generators;

import java.util.ArrayList;
import java.util.Random;

/*
* 构建复杂模型 构建一个容器化的货船模型
* p372
* @author wxq
* @date 2018-4-20
* */
class Product{
    private final int id ;
    private String description;
    private double price;

    public Product(int id, String description, double price){
        this.id = id;
        this.description = description;
        this.price = price;
    }
    public String toString(){
        return id + ": " + description + " price: $" + price + "";
    }
    // set // get
    public static Generator<Product> generator(){
        return new Generator<Product>() {
            @Override
            public Product next() {
                Random random = new Random();
                return new Product(random.nextInt(1000), "Test", Math.round(random.nextDouble())*1000.0 + 0.99);
            }
        };
    }
}
// 货仓
class WareHouse extends ArrayList<Product>{
    public WareHouse(int nProducts){
        Generators.fill(this, Product.generator(), nProducts);
    }
}

// 甲板
class Deck extends ArrayList<WareHouse>{
    public Deck(int nWares, int nPros){
        for (int i = 0; i < nWares; i++) {
            add(new WareHouse(nPros));
        }
    }
}

public class CargoShip extends ArrayList<Deck>{
    // 其他属性

    public CargoShip(int nDecks, int nWare, int nPros){
        for (int i = 0; i < nDecks; i++) {
            add(new Deck(nWare, nPros));
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Deck wareHouses : this) {
            for (WareHouse wareHouse : wareHouses) {
                for (Product product : wareHouse) {
                    result.append(product);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(new CargoShip(3,5,10));
    }
}


