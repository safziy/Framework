package com.safziy.redis.test;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestRedis {
	Jedis jedis;
	
	@Before
	public void before(){
		jedis = new Jedis("localhost");
	}
	
	@After
	public void after(){
		jedis.close();
	}
	
	@Test
	public void testConnection() {
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis.ping());
		jedis.close();
	}
	
	@Test
	public void testSetAndGetString() {
		jedis.set("string", "addda");
		System.out.println(jedis.get("string"));
	}
	
	@Test
	public void testSetAndGetList() {
		jedis.lpush("list", "jack");
		jedis.lpush("list", "tom");
		jedis.lpush("list", "kitty");
		
		List<String> list = jedis.lrange("list", 0, 4);
		for (String value : list) {
			System.out.println("list  value " + value);
		}
	}
	
	@Test
	public void testkeys() {
		Set<String> keys = jedis.keys("*");
		for (String key : keys) {
			System.out.println("key === " + key);
		}
	}
}
