package edu.umt.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
	public static void main(String[] args){
		Logger logger = LoggerFactory.getLogger(HelloWorld.class);
		logger.info("Hello World");
		logger.debug("Hola World");
	}
}
