package com.learning.springboot.web.model.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.springboot.web.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findAll();

	Item findById(Long id);

	void delete(Item item);

	List<Item> findByProductId(Long productId);
}
