package com.example.javaex.DAO;

import com.example.javaex.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CartDAO extends CrudRepository <Cart, Long> {

}
