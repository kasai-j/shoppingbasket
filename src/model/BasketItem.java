package model;

/**
 * Represents one item in the basket. This is different from an individual product and allows
 * amounts etc to be updated.
 */

public class BasketItem {

    private Product product;
    private int quanity;
    private double price;

    public BasketItem(){
        quanity = 0;
    }

    public BasketItem(Product product, int quanity, double price){
        this.product = product;
        this.quanity = quanity;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quanity;
    }

    public double getPrice() {
        return product.getPrice();
    }

    /**
     * Total cost which is price X quantity
     * @return
     */
    public double getCost() {
        return this.product.getPrice() * quanity;
    }

    public void remove() {

    }

    public void setQantity(int quantity) {
        this.quanity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
