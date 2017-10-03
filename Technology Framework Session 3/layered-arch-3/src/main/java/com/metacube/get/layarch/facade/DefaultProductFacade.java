package com.metacube.get.layarch.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.get.layarch.dto.ProductDto;
import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;
import com.metacube.get.layarch.service.ProductService;

/**
 * The Class DefaultProductFacade.
 */
@Component("productFacade")
public class DefaultProductFacade implements ProductFacade {

	/** The product service. */
	@Autowired
	private ProductService productService;

	/**
	 * Default constructor.
	 */
	public DefaultProductFacade() {
	}

	/**
	 * Instantiates a new default product facade.
	 *
	 * @param productService
	 *            the product service
	 */
	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Gets the product service.
	 *
	 * @return the product service
	 */
	public ProductService getProductService() {
		return productService;
	}

	/**
	 * Sets the product service.
	 *
	 * @param productService
	 *            the new product service
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@Override
	public Iterable<ProductDto> getAllProducts() {
		List<ProductDto> productDtoList = new ArrayList<>();
		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToProductDto(product));
		}

		return productDtoList;
	}

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@Override
	public Iterable<ProductDto> getDashboardProducts() {
		List<ProductDto> productDtoList = new ArrayList<>();
		for (Product product : productService.getDashboardProducts()) {
			productDtoList.add(modelToProductDto(product));
		}

		return productDtoList;
	}

	/**
	 * Gets the product by id.
	 *
	 * @param id
	 *            the id
	 * @return the product by id
	 */
	@Override
	public ProductDto getProductById(final int id) {
		return modelToProductDto(productService.getProductById(id));
	}

	/**
	 * Delete product by id.
	 *
	 * @param id
	 *            the id
	 * @return the status
	 */
	@Override
	public Status deleteProductById(final int id) {
		return productService.deleteProductById(id);
	}

	/**
	 * Adds the product.
	 *
	 * @param entity
	 *            the entity
	 * @return the status
	 */
	@Override
	public Status addProduct(Product entity) {
		return productService.addProduct(entity);
	}

	/**
	 * Update product.
	 *
	 * @param entity
	 *            the entity
	 * @param id
	 *            the id
	 * @return the status
	 */
	@Override
	public Status updateProduct(Product entity, int id) {
		return productService.updateProduct(entity, id);
	}

	/**
	 * product Dto to model.
	 *
	 * @param productDto
	 *            the product dto
	 * @return the product
	 */
	private Product productDtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setImagePath(productDto.getImagePath());
		product.setCurrency(productDto.getCurrency());
		product.setDescription(productDto.getDescription());

		return product;
	}

	/**
	 * Model to dto.
	 *
	 * @param product
	 *            the product
	 * @return the product dto
	 */
	private ProductDto modelToProductDto(Product product) {
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setImagePath(product.getImagePath());
		productDto.setCurrency(product.getCurrency());
		productDto.setDescription(product.getDescription());

		return productDto;
	}
}
