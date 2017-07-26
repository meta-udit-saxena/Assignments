/**
 * Generate Bill - calculate total bill and send to Bill class for printing
 * 
 * @author Udit Saxena
 * 
 */
public class BillGenerator {
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
	Bill billCalculator(Cart cart, ProductPromo productPromo,
			OrderPromo orderPromo, String name) {
		productPromo.setDiscount(cart);
		cart.calculateTotal(cart);
		orderPromo.setDiscount(cart);
		Bill bill = new Bill(name, cart, productPromo);

		return bill;
	}
}
