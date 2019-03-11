package com.learning.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.springboot.web.model.Item;
import com.learning.springboot.web.model.repo.ItemRepository;

@Controller
public class ItemsController {

	@Autowired
	private ItemRepository repoItem;

//	@Autowired
//	private ProductRepository repoProduct;

	@RequestMapping(value = "/products/{id}/items", method = RequestMethod.GET)
	public String getItemsBasedonProductId(ModelMap model, 
			@PathVariable(value = "id") Long id) {

		String msg = "";
		List<Item> items = repoItem.findByProductId(id);

		model.put("msg", msg);
		model.put("items", items);
		model.put("productId", id);

		return "items";
	}

	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
	public String showEditItemPage(ModelMap model, @PathVariable(value = "id") Long id) {

		Item item = repoItem.findById(id);

		model.put("item", item);

		return "edititem";
	}

	@RequestMapping(value = "/items/{id}/update", method = RequestMethod.POST)
	public String updateItemPage(ModelMap model, @PathVariable(value = "id") Long id, 
			@ModelAttribute("item") Item item, BindingResult result) {

		String msg = "";

		item = repoItem.save(item);
		
		Long productId = item.getProductId();
		List<Item> items = repoItem.findByProductId(productId);

		model.put("msg", msg);
		model.put("items", items);

		return "items";
	}

	@RequestMapping(value = "/items/delete/{id}", method = RequestMethod.GET)
	public String deleteItem(ModelMap model, 
			@PathVariable(value = "id") Long id) {

		String msg = "";

		Item item = repoItem.findById(id);
		Long productId = item.getProductId();
		repoItem.delete(item);

		List<Item> items = repoItem.findByProductId(productId);

		model.put("msg", msg);
		model.put("items", items);

		return "items";
	}

	@RequestMapping(value = "/products/{productId}/item", method = RequestMethod.POST)
	public String saveItemForm(ModelMap model, 
			@PathVariable(value = "productId") Long productId, 
			@ModelAttribute("item") Item item, BindingResult result) {

		item = repoItem.save(item);
		String msg = "New Item is added with ID as " + item.getId() + 
				"under the Product group of ID as" + item.getProductId();

		List<Item> items = repoItem.findByProductId(productId);

		model.put("msg", msg);
		model.put("items", items);
		model.put("productId", productId);

		return "items";
	}

	@RequestMapping(value = "/products/{productId}/item", method = RequestMethod.GET)
	public String saveItemForm(ModelMap model, 
			@PathVariable(value = "productId") Long productId) {
		
		model.put("productId", productId);

		return "additem";
	}

}
