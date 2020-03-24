package edu.mum.component.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import edu.mum.component.MessageOrigin;


@Component
public class HelloWorldMessageOrigin implements MessageOrigin {
 
@Autowired
private MessageSource messageSource;
	
 	public String getMessage() {
 		
		  return messageSource.getMessage("messageText",null, Locale.getDefault());	}


 }
