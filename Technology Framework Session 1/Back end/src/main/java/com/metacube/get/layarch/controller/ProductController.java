package com.metacube.get.layarch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.get.layarch.dao.product.JdbcProductDao;
import com.metacube.get.layarch.facade.DefaultProductFacade;
import com.metacube.get.layarch.facade.ProductFacade;
import com.metacube.get.layarch.model.Product;
import com.metacube.get.layarch.service.DefaultProductService;

@Path("/product")
public class ProductController
{
	ProductFacade productFacade;

	public ProductController() {
		productFacade = new DefaultProductFacade(new DefaultProductService(new JdbcProductDao()));
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts() {
		return Response.status(Response.Status.OK).entity(productFacade.getAllProducts()).build();

	}
}
