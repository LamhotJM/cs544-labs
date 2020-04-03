
NOTE: there are 2 MAIN methods ...one uses XML Configuration , the other uses Java configuration
NOTE: See Installation instructions for Rabbit

NOTE: Exchange/queues/binding set up in CONSUMERS

                     uses TOPIC EXCHANGE: order
                      
 Has Producer for order exchange for routing key purchases.store 
 The messages are sent to the durable queue purchasesStore 


AMQPTopicConsumerStoreQueue application has listener on purchasesStore queue  
AMQPTopicConsumerTempStoreQueue application has listener on TEMPORARY queue purchasesStoreToo  

                