package com.humanbooster.jdbc.utils;

public final class Consts {
	
	//public static final String LOG4J_CONF_PATH = "C:\\Users\\safia\\workspace2\\cours-JDBC\\resources\\log4j.properties";
	
	public static final String LOG4J_CONF_PATH = "resources/log4j.properties";
	
	public static final String DELETE_ALL_USER_QUERY = "DELETE FROM user";
	public static final String RESET_AUTO_INCREMENT_USER_QUERY = "ALTER TABLE user AUTO_INCREMENT = 1";
	public static final String NB_USER_QUERY = "SELECT COUNT(*) FROM user";
	
	
	public static final String BASKET_CREATION_QUERY = "INSERT INTO basket (brand, color, price, basket_date) VALUES (?,?,?,?)";
	public static final String NB_BASKET_QUERY = "SELECT COUNT(*) FROM basket";
	public static final String UPDATE_BASKET_COLOR_QUERY = "UPDATE basket SET color = ? WHERE id = ?";
	public static final String GET_BASKET_BY_ID_QUERY = "SELECT * FROM basket WHERE id = ?";
	public static final String RESET_AUTO_INCREMENT_BASKET_QUERY = "ALTER TABLE basket AUTO_INCREMENT = 1";
	public static final String DELETE_ALL_BASKET_QUERY = "DELETE FROM basket";
	public static final String GET_ALL_BASKET_QUERY = "SELECT * FROM basket";
	public static final String GET_LAST_BASKET_QUERY = "SELECT MAX(id) FROM basket";
	public static final String GET_BASKETS_BY_DATE_QUERY = "SELECT * FROM basket WHERE basket_date > ?";
	public static final String UPDATE_PRICE_BRAND_OF_BASKET_QUERY = "UPDATE basket SET price = ?, color = ? WHERE id = ?";
	public static final String UPDATE_COLOR_OF_BASKET_QUERY = "UPDATE basket SET color = ? WHERE brand = ? AND price = ?";
	public static final String CREATE_SIMPLE_BASKET_QUERY = "INSERT INTO basket (brand, color, price) values (?,?,?)";
	public static final String CREATE_BASKET_WITH_USER_AND_DATE = "INSERT INTO basket (brand, color, stock, login, basket_date) VALUES (?,?,?,?,?)";
	public static final String CREATE_BASKET_WITH_USER_QUERY = "INSERT INTO basket (brand, color, price, login, basket_date) VALUES (?,?,?,?,?)";
	public static final String SELECT_BASKET_BY_BRAND_QUERY = "SELECT * FROM basket WHERE brand = ?";
	public static final String DELETE_BASKET_BY_ID_QUERY = "DELETE FROM basket WHERE id = ?";
}
