package ShoppingStore;
/**
 * Generate Bill - calculate total bill and send to Bill class for printing
 * 
 * @author Udit Saxena
 * 
 */
public class BillGenerator {
	
	private Cart cart;
	private ProductPromo productPromo;
	private OrderPromo orderPromo;
	private String name;
	public BillGenerator(Cart cart, ProductPromo productPromo,
			OrderPromo orderPromo) {
		super();
		this.cart = cart;
		this.productPromo = productPromo;
		this.orderPromo = orderPromo;
	}
	/**
	 * 
	 * @param cart
	 *            - Cart Class object
	 * @param productPromo
	 *            - ProductPromo class object
	 * @param orderPromo
	 *            - OrderPromo class object
	 * @param name
	 *            - UserName
	 * @return bill Bill class object
	 */
	private Bill billCalculator(Cart cart, ProductPromo productPromo,
			OrderPromo orderPromo, String name) {
	
		orderPromo.setDiscount(cart);
		Bill bill = new Bill(name, cart, productPromo);

		return bill;
	}
	@Override
	public String toString(){
		return billCalculator(cart, productPromo, orderPromo, name).display();
		
	}
}
