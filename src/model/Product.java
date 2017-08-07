package model;

/**
 * Represents the individual product. Note this might have to change later to represent an enity in a DB.
 */

public class Product {

    String productID;
    String name;
    String description;
    double price;
    //Todo: Add images? Date when item was added to the basket for concurrency

    public Product (){

    }

    public Product(String productID, String name, String description, double price){
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * Price of an object this is in pounds.
     * @return
     */
    public double getPrice() {
        return price;
    }
}
