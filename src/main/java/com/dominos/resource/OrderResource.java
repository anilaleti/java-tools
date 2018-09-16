package com.dominos.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dominos.req.CustomerDetails;
import com.dominos.req.DeliveryDetails;
import com.dominos.req.Order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

/**
 * @author Anil Aleti
 *
 *         Sep 10, 2018
 */
@Api("operations on order service")
@Path("/order")
@SwaggerDefinition(tags = { @Tag(name = "order service", description = "rest endpoints for order services") })
public class OrderResource {
	
private Logger logger = LoggerFactory.getLogger(OrderResource.class);
	/**
	 * @param Order
	 * @return String
	 */
	@Path("/createOrder")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiOperation(value = "createOrder")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "order created successfully"),
			@ApiResponse(code = 404, message = "resource not found") })

	public Response createOrder(Order order) {
		logger.debug("entered into create order............");
		String returnString = "created succesfully";
		
		return Response.ok().entity(returnString).build();

	}

	/**
	 * @param orderId
	 * @return Order
	 */
	@Path("/getOrder")
	@GET
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiOperation(value = "getOrder")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "returns the order details found"),
			@ApiResponse(code = 404, message = "resource not found") })

	public Response getOrder(@QueryParam(value = "orderId") String orderId) {
		// http://localhost:7070/order-web/order/getOrder?orderId=1234
		logger.debug("entered into getOrder()............");
		Order order = new Order();
		order.setDate("10-9-2018");
		order.setOrderId("101");
		order.setPrice("4000");
		order.setQty("4");
		order.setProductName("pizza");
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustName("Anil");
		customerDetails.setMobileNum("91777");
		DeliveryDetails deliveryDetails = new DeliveryDetails();
		deliveryDetails.setDlvryLocation("Sr Nagar");
		order.setCstmrDtls(customerDetails);
		order.setDelvryDtls(deliveryDetails);
		logger.info("response from getOrder()"+order);
		return Response.ok().entity(order).build();
	}

	/**
	 * @param String
	 * @return String
	 */
	@Path("/updateOrder")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiOperation(value = "updateOrder")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "returns the updated message"),
			@ApiResponse(code = 404, message = "resource not found") })

	public Response updateOrder(@QueryParam(value = "orderId") String orderId) {

		String returnString = "updated succesfully";
		return Response.ok().entity(returnString).build();

	}

	@Path("/healthCheck")
	@GET
	public String healthCheck() {
		return "order service is runnig fine";

	}

}
