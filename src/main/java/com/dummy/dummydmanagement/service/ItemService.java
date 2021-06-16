package com.dummy.dummydmanagement.service;

import com.dummy.dummydmanagement.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    private static List<Item> items =  Arrays.asList(
            new Item("abc", "Samsung TV-", 1399.99),
            new Item("asd", "LG TV", 2329.99),
            new Item("fgh", "Apple Watch", 4999.99),
            new Item("xgs", "MI Watch", 349.99),
            new Item("zia", "One plus 9", 356.99),
            new Item("lrv", "Iphone 12", 949.99),
            new Item("mnb", "Beats HeadPhones-", 149.99)
    );


    @Autowired
    @Qualifier("jdbcScheduler")
    private Scheduler jdbcScheduler;


    public Flux<Item> getAllItemsService() throws Exception {
       // int s = 5/0;
        // throw new Exception();
//        logger.info("*** Inside getAllItems service ***");
        Flux<Item> defer = Flux.defer(() -> Flux.fromIterable(items));
        return defer.subscribeOn(jdbcScheduler);

    }

    public Mono<Item> getOneItemService(@PathVariable Integer id){
        logger.info("*** Inside getOneItem service ***");
        return Mono.just(items.get(id)).flatMap(Mono::justOrEmpty);
    }

}
