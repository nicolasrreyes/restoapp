package com.resto.restoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.resto.restoapp.service.TicketOrderService;

@RequestMapping("/ticket")
public class TicketController {

@Autowired
private TicketOrderService ticketService;



}
