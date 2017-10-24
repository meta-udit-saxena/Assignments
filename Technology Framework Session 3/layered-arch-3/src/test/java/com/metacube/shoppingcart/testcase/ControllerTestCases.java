package com.metacube.shoppingcart.testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import com.metacube.shoppingcart.dao.product.JdbcProductDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.facade.DefaultProductFacade;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.service.DefaultProductService;

public class ControllerTestCases {
	ProductFacade productFacade;

	@Before
	public void setUpObject() {
		productFacade = new DefaultProductFacade(new DefaultProductService(
				new JdbcProductDao()));
	}

	@Test
	public void GivenAddProduct_WhenAddProduct_ThenStatusSuccess() {
		Product product = new Product();
		product.setCurrency("india");
		product.setDescription("dadsdsadsa");
		product.setImagePath("nike.png");
		product.setName("demo");
		product.setPrice(1000);
		assertEquals(productFacade.addProduct(product), Status.Success);
	}

	@Test
	public void GivenRequestProductList_WhenGetProducts_ThenAllProducts() {
		assertNotEquals(productFacade.getAllProducts(), null);
	}

	@Test
	public void GivenValidId_WhenGetProductById_ThenProduct() {
		Product product = new Product();
		product.setCurrency("india");
		product.setDescription("dadsdsadsa");
		product.setImagePath("nike.png");
		product.setName("demo");
		product.setPrice(1000);
		productFacade.addProduct(product);
		assertEquals(productFacade.getProductById(53).getName(),
				product.getName());
	}

	@Test
	public void GivenValidId_WhenDeleteProductById_ThenStatusSuccess() {
		assertEquals(productFacade.deleteProductById(51), Status.Success);
	}

	@Test
	public void GivenInValidId_WhenDeleteProductById_ThenStatusNotFound() {
		assertEquals(productFacade.deleteProductById(14509), Status.NOT_Found);
	}

	@Test
	public void GivenValidId_WhenUpdateProduct_ThenStatusSuccess() {
		Product product = new Product();
		product.setCurrency("india");
		product.setDescription("dadsdsadsa");
		product.setImagePath("nike.png");
		product.setName("demo");
		product.setPrice(1000);
		productFacade.addProduct(product);
		assertEquals(productFacade.updateProduct(product, 50), Status.Success);
		assertEquals(productFacade.getProductById(50).getName(),
				product.getName());
	}
}
