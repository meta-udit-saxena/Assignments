package com.metacube.get.layarch.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.metacube.get.layarch.facade.ProductFacade;
import com.metacube.get.layarch.factory.Factory;
import com.metacube.get.layarch.model.Product;

/**
 * The Class ProductController.
 *
 */
@Path("/product")
public class ProductController {

	/** The product facade. */
	private ProductFacade productFacade;

	/**
	 * Instantiates a new product controller.
	 */
	public ProductController() {
		productFacade = Factory.getApplicationContext().getBean(
				"productFacade", ProductFacade.class);
	}

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts() {
		return Response.status(Response.Status.OK)
				.entity(productFacade.getAllProducts()).build();

	}

	/**
	 * Gets the products for dashboard.
	 *
	 * @return the products
	 */
	@GET
	@Path("/dashboard")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductForDashboard() {
		return Response.status(Response.Status.OK)
				.entity(productFacade.getDashboardProducts()).build();

	}

	/**
	 * Gets the product.
	 *
	 * @param id
	 *            the id
	 * @return the products
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("id") int id) {
		return Response.status(Response.Status.OK)
				.entity(productFacade.getProductById(id)).build();
	}

	/**
	 * Delete product.
	 *
	 * @param id
	 *            the id
	 * @return the response
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduct(@PathParam("id") int id) {
		return Response.status(Response.Status.OK)
				.entity(productFacade.deleteProductById(id)).build();
	}

	/**
	 * Adds the product.
	 *
	 * @param product
	 *            the product
	 * @return the response
	 */
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Product product) {
		return Response.status(Response.Status.OK)
				.entity(productFacade.addProduct(product)).build();
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
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editProduct(Product product, @PathParam("id") int id) {
		return Response.status(Response.Status.OK)
				.entity(productFacade.updateProduct(product, id)).build();
	}
}
