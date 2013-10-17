package edu.umt.test;

import edu.umt.utils.ApplicationStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloWorld {
	public static void main(String[] args){
		Logger logger = LoggerFactory.getLogger(HelloWorld.class);
		logger.info("Hello World");
		logger.debug("Hola World");
        System.out.println(ApplicationStates.APPROVED_BY_SPONSOR);
	}
}
