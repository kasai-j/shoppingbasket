package UnitTests;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import model.Basket;
import model.Product;

public class BasketTest {

    Basket basket;

    @Before
    public void setUp() throws Exception{
        basket = Basket.getInstance();
    }

    @Test
    public void getInstance() throws Exception {
        Basket basket2 = Basket.getInstance();
        Assert.assertEquals(true, basket == basket2);
    }

    @Test
    public void addBasketItem() throws Exception {
        Product bread = new Product("Bread001", "Hovis Bread", "Tasty hovis bread", 0.99);
        basket.addBasketItem(bread, 5);
        Assert.assertEquals(false, basket.isBasketEmpty());
    }

    @Test
    public void addDuplicateBasketItem() throws Exception {
        Product bread = new Product("Bread001", "Hovis Bread", "Tasty hovis bread", 0.99);
        basket.addBasketItem(bread, 3);
        Assert.assertEquals(false, basket.isBasketEmpty());
    }

    @Test
    public void getTotalCost() throws Exception {
        Assert.assertEquals(7.92, basket.getTotalCost(), 0);
    }

}