package com.webservice.IeltsWeb.jpa;
import org.springframework.data.repository.CrudRepository;

import com.webservice.IeltsWeb.Model.Cart;
import com.webservice.IeltsWeb.Model.CartId;

public interface CartRespon  extends CrudRepository<Cart,CartId> {

}
