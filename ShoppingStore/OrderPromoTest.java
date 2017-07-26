import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class OrderPromoTest {
	OrderPromo orderPromo;
	Cart cart;
	Store store;
	ProductPromo productPromo;
	@Before
	public void setUpObject(){
		store = new Store();
		cart = new Cart();
		orderPromo =  new OrderPromo();
		productPromo=new ProductPromo();
	}
@Test
public void Given_totalAmountIs1900_When_isApplicable_Then_True(){
	boolean actual = orderPromo.isApplicable(1900);
	boolean expected=true;
	assertEquals(expected, actual);
}
@Test
public void Given_totalAmountIs100_When_isApplicable_Then_False(){
	boolean actual = orderPromo.isApplicable(100);
	boolean expected=false;
	assertEquals(expected, actual);
}
@Test
public void Given_IdIs1001AndQuantityIs50_When_setDiscount_Then_3245(){
	cart.addProductToCartByProductId(store,1001,50);
	productPromo.setDiscount(cart);
	cart.calculateTotal(cart);
	orderPromo.setDiscount(cart);
	
	double actual = cart.getOrderLevelDiscount();
	double expected = 3245.0;
	assertEquals(expected,actual,0.0);
}
@Test
public void Given_IdIs1001AndQuantityIs1_When_setDiscount_Then_0(){
	cart.addProductToCartByProductId(store,1001,1);
	productPromo.setDiscount(cart);
	cart.calculateTotal(cart);
	orderPromo.setDiscount(cart);
	
	double actual = cart.getOrderLevelDiscount();
	double expected =0.0;
	assertEquals(expected,actual,0.0);
}
}
