package com.metacube.get.layarch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.get.layarch.facade.ProductFacade;
import com.metacube.get.layarch.factory.Factory;
import com.metacube.get.layarch.model.Product;
import com.metacube.get.layarch.dto.ProductDto;
import com.metacube.get.layarch.enums.Status;

/**
 * The Class ProductController.
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	/** The product facade. */
	@Autowired
	private ProductFacade productFacade;

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	@RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Iterable<ProductDto> getProducts() {
		return productFacade.getAllProducts();

	}

	/**
	 * Gets the products for dashboard.
	 *
	 * @return the products
	 */
	@RequestMapping(value = "/dashboard", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Iterable<ProductDto> getProductForDashboard() {
		return productFacade.getDashboardProducts();

	}

	/**
	 * Gets the product.
	 *
	 * @param id
	 *            the id
	 * @return the products
	 */
	@RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ProductDto getProduct(@PathVariable("id") int id) {
		return productFacade.getProductById(id);
	}

	/**
	 * Delete product.
	 *
	 * @param id
	 *            the id
	 * @return the response
	 */
	@RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteProduct(@PathVariable("id") int id) {
		return productFacade.deleteProductById(id);
	}

	/**
	 * Adds the product.
	 *
	 * @param product
	 *            the product
	 * @return the response
	 */
	@RequestMapping(value = "/add", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Status addProduct(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}

	/**
	 * Edits the product.
	 *
	 * @param product
	 *            the product
	 * @param id
	 *            the id
	 * @return the response
	 */
	@RequestMapping(value = "/update/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody Status editProduct(@RequestBody Product product,
			@PathVariable("id") int id) {
		return productFacade.updateProduct(product, id);
	}
}
