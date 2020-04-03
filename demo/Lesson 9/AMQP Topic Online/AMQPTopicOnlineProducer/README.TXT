************* ATTENTION *******************
For TOPIC related Producers & Consumers, 
This Application has to be run ONE TIME initially.
BECAUSE it sets up the TOPIC Exchange AND the durable queues


NOTE: there are 2 MAIN methods ...one uses XML Configuration , the other uses Java configuration
NOTE: See Installation instructions for Rabbit

                    used TOPIC EXCHANGE: order
                     
Two queues... 
One queue   purchasesOnline
One queue  purchasesOnlineClassic

Has Producers for BOTH  Queues
 
AMQPTopicConsumerOnlineQueue application has listener on purchasesOnline queue 
[ OR can listen on purchasesOnlineClassic]


                