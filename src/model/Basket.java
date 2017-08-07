package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows for a singleton basket to be added to the application.
 */

public class Basket {

    private static Basket instance = null;
    private int orderNumber; //to link to a specific order in the future.
    private final List<BasketItem> basketItemsList = new ArrayList<BasketItem>();

    protected Basket(){

    }

    public static Basket getInstance(){
        if (instance == null){
            instance = new Basket();
        }
        return instance;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<BasketItem> getBasketItemsList() {
        return basketItemsList;
    }

    /**
     * Searches the items in the basket so we can add the same Item without
     * creating duplicates.
     * @param productID
     * @return
     */
    private BasketItem findExistingItem(String productID){
        for (BasketItem itemsList : basketItemsList){
            if (itemsList.getProduct().getProductID().equals(productID)){
                return itemsList;
            }
        }
        return null;
    }

    public void addBasketItem(Product product, int quantity){
        BasketItem basketItem = findExistingItem(product.getProductID());
        ///product is a new one.
        if(basketItem == null) {
            basketItem = new BasketItem();
            if (quantity > 0) {
                basketItem.setQantity(quantity);
            }
            basketItem.setProduct(product);
            basketItemsList.add(basketItem);
        }
        //add to existing product or remove item.
        if (quantity <= 0){
            basketItem.remove();
        } else{
            basketItem.setQantity(basketItem.getQuantity() + quantity);
        }
    }

    /**
     * Updates a prduct in a basketItem
     * @param product
     * @param quantity New amount
     */
    public boolean updateProduct(Product product, int quantity) {
        BasketItem basketItem = findExistingItem(product.getProductID());
        if (basketItem != null){
            basketItem.setQantity(quantity);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product){
        BasketItem basketItem = findExistingItem(product.getProductID());
        if (basketItem != null){
            basketItem.remove();
            return true;
        }
        return false;
    }

    public boolean isBasketEmpty(){
        return basketItemsList.isEmpty();
    }

    public double getTotalCost(){
        double totalCost = 0;
        for(BasketItem basketItem : basketItemsList){
           totalCost += basketItem.getCost();
        }
        return totalCost;
    }

}
