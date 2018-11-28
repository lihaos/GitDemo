package cn.ch.netem;

import org.springframework.data.redis.connection.jedis.JedisConnection;

import redis.clients.jedis.Jedis;

public class demo {
public static void main(String[] args) {
	Jedis a = new Jedis("192.168.10.14", 6379);
	a.set("ike1", "v2");
}
}
