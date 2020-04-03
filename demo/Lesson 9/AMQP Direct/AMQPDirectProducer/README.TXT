
NOTE: there are 2 MAIN methods ...one uses XML Configuration , the other uses Java configuration
NOTE: See Installation instructions for Rabbit

 
                    DIRECT EXCHANGE

Two queues [orderStoreQueue, orderOnlineQueue]

Has Producer for BOTH queues -- based on routing key
 
 AMQPDirectOnlineConsumer application   has a listener for orderOnlineQueue
 AMQPDirectStoreConsumer application   has a listener for orderStoreQueue
                