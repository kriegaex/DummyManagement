package com.dummy.dummydmanagement.controllers;

import com.dummy.dummydmanagement.model.Item;
import com.dummy.dummydmanagement.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static com.dummy.dummydmanagement.constants.ItemConstants.ITEM_END_POINT_V1;

@RestController
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;


    @GetMapping(ITEM_END_POINT_V1)
    public Flux<Item> getAllItems() throws Exception {
        logger.info("*** Inside getAllItems controller ***");
        return itemService.getAllItemsService();

    }


    @GetMapping(ITEM_END_POINT_V1+"/{id}")
    public Mono<Item> getOneItem(@PathVariable Integer id){
        logger.info("*** Inside getOneItem controller ***");
        return itemService.getOneItemService(id);
    }
}
