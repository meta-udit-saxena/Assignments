import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
public class ProductPromoTest {
	Cart cart;
	Store store;
	ProductPromo productPromo;
	CartProducts cartProduct;
	@Before
	public void setUpObject(){
		store = new Store();
		cart = new Cart();
		productPromo=new ProductPromo();
		cartProduct=new CartProducts();
	}
@Test
public void Given_ProductIdIs1001_When_isApplicable_Then_True(){
	boolean actual = productPromo.isApplicable(1001);
	boolean expected=true;
	assertEquals(expected, actual);
}
@Test
public void Given_ProductIdIs4011_When_isApplicable_Then_False(){
	boolean actual = productPromo.isApplicable(4011);
	boolean expected=false;
	assertEquals(expected, actual);
}
@Test
public void Given_IdIs1001_And_QuantityIs50_When_setDiscount_Then_3245(){
	cart.addProductToCartByProductId(store,1001,50);
	productPromo.setDiscount(cart);	
	cartProduct = cart.getCartItems().get(0);
	double actual = cartProduct.getProductPrice();
	double expected =749.0;
	assertEquals(expected,actual,0.0);
}
@Test
public void Given_IdIs4011_And_QuantityIs1_When_setDiscount_Then_0(){
	cart.addProductToCartByProductId(store,4011,1);
	productPromo.setDiscount(cart);	
	cartProduct = cart.getCartItems().get(0);
	double actual = cart.getOrderLevelDiscount();
	double expected =0.0;
	assertEquals(expected,actual,0.0);
}
}
