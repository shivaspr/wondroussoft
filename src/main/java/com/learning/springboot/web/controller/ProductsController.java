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
import com.learning.springboot.web.model.Product;
import com.learning.springboot.web.model.repo.ItemRepository;
import com.learning.springboot.web.model.repo.ProductRepository;

@Controller
public class ProductsController {

	@Autowired
	private ProductRepository repoProduct;

	@Autowired
	private ItemRepository repoItem;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String showProductsListPage(ModelMap model) {

		List<Product> products = repoProduct.findAll();
		List<Item> items;

        for (Product products1 : products) {
        	Long i = ((Product) products1).getId();
			items = repoItem.findByProductId(i);
			int temp = 0;
			temp = items.size();
			((Product) products1).setBrands(temp);
        }

		model.put("products", products);

		return "products";
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public String showEditProductPage(ModelMap model, @PathVariable(value = "id") Long id) {

		Product product = repoProduct.findById(id);

		model.put("product", product);

		return "editproduct";
	}

	@RequestMapping(value = "/products/{id}/update", method = RequestMethod.POST)
	public String updateProductPage(ModelMap model, @PathVariable(value = "id") Long id,
			@ModelAttribute("product") Product product, BindingResult result) {

		String msg = "";
		product = repoProduct.save(product);

		List<Product> products = repoProduct.findAll();

		msg = "Product is Updated with id as " + product.getId();

		model.put("msg", msg);
		model.put("products", products);

		return "products";
	}

	@RequestMapping(value = "/products/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(ModelMap model, @PathVariable(value = "id") Long id) {
		String msg = "";

		Product product = repoProduct.findById(id);

		List<Item> items = repoItem.findByProductId(id);

		for (Item item : items) {
			repoItem.delete(item);
		}

		repoProduct.delete(product);

		msg = "Product is deleted with id as " + product.getId();

		List<Product> products = repoProduct.findAll();

		model.put("msg", msg);
		model.put("products", products);

		return "products";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String saveProduct(ModelMap model, @ModelAttribute("product") Product product) {

		product = repoProduct.save(product);

		String msg = "New product is added with id as " + product.getId();

		List<Product> products = repoProduct.findAll();

		model.put("msg", msg);
		model.put("products", products);

		return "products";
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String saveProduct(ModelMap model) {

		return "addproduct";

	}

	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public String saveRawItem(ModelMap model, @ModelAttribute("item") Item item) {

		item = repoItem.save(item);

		String msg = "New Item is added with id as " + item.getId() + "under the category of Product with ID as"
				+ item.getProductId();

		List<Product> products = repoProduct.findAll();
		
		List<Item> items;
		for (Product products1 : products) {
        	Long i = ((Product) products1).getId();
			items = repoItem.findByProductId(i);
			int temp = temp = items.size();
			((Product) products1).setBrands(temp);
        }
		
		model.put("msg", msg);
		model.put("products", products);

		return "products";
	}

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String saveRawItem(ModelMap model) {

		List<Product> products = repoProduct.findAll();
				
		model.put("products", products);
		return "additemhome";

	}

}
