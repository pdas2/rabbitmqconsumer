package com.javasampleapproach.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.json.simple.JSONObject;  
import org.json.simple.JSONValue;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Consumer {
	public static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	@RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedMessage(String msg) {
		
		
        System.out.println("Recieved Message: " + msg);
        
        Object obj=JSONValue.parse(msg);  
        JSONObject jsonObject = (JSONObject) obj; 
        
        String userName = (String) jsonObject.get("userName"); 
        String userAccId = (String) jsonObject.get("userAccId");
        String offerid = (String) jsonObject.get("offerid");
        String userPhone = (String) jsonObject.get("userPhone");
        
        String Log="Customers master CRM has being updated for you.This will allow us for scale this accross channels";
        Log=" "+Log+""+"User: "+userName+" "+"User account: "+userAccId+" "+"Phone: "+userPhone+" "+"Offer activated: "+offerid;
        
         System.out.println(Log);
        
        logger.info(Log);
    }
}
