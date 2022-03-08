package com.resto.restoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resto.restoapp.entity.TicketOrder;

@Repository 
public interface TicketOrderRepository extends JpaRepository<TicketOrder, Long>{

	
	
}
