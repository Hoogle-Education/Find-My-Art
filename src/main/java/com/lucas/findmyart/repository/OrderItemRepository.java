package com.lucas.findmyart.repository;

import com.lucas.findmyart.model.composed.OrderItemPK;
import com.lucas.findmyart.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
