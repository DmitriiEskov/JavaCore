package ru.job4j.calculator;

/**
 * Class for "Hello World" and echo method.
 * 
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 01.06.2017
 */
public class Calculate {

	/**
	 * main.
	 * @param args - args
	 */
	public static void main(String[] args) {
		System.out.println("Hello world");		
	}
	
	/**
     * echo.
     * @param name Your name
     * @return Echo plus your name
     */
    public String echo(String name) {
        return "Echo, echo, echo: " + name;
    }
}