package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Orders;
import repository.OrderRepo;


@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderRepo order;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Orders>> getOrders() throws IOException {
		return ResponseEntity.ok(order.findAll());
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Orders> getOrder(@PathVariable("name") Long id) throws IOException {
		return ResponseEntity.ok(order.findById(id).get());
	}

	
}