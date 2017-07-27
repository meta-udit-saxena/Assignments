package ShoppingStore;

public class RemoveProductFromCart {
	private Cart cart;
 public RemoveProductFromCart(Cart cart) {
	this.cart=cart;
}
 public String removeProductFromCart(){
	 return cart.removeProductFromCartByProductId();
 }
 @Override
 public String toString(){
	 return "\n-------"+removeProductFromCart()+"------\n";
 }
}
