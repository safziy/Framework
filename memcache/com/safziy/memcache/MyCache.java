package com.safziy.memcache;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MyCache {
	public static void main(String[] args) {
		MemCachedClient client = new MemCachedClient();
		String[] addr = { "127.0.0.1:11211" };
		Integer[] weights = { 3 };
		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(addr);
		pool.setWeights(weights);
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(200);
		pool.setMaxIdle(1000 * 30 * 30);
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketTO(30);
		pool.setSocketConnectTO(0);
		pool.initialize();

		// String [] s =pool.getServers();
		// client.setCompressEnable(true);
		// client.setCompressThreshold(1000*1024);

		// 将数据放入缓存
		client.set("test2", "test2");

		// 将数据放入缓存,并设置失效时间
		Date date = new Date(2000000);
		client.set("test1", "test1", date);

		// 删除缓存数据
		// client.delete("test1");

		// 获取缓存数据
		String str = (String) client.get("test1");
		System.out.println(str);

		BeanA beanA = new BeanA(1, "beanA1");
		System.out.println("beanA === " + new String(toByteArray(beanA)));
		client.set("bean1", beanA);

		Object o = client.get("bean1");
		System.out.println("s === " + new String(toByteArray(o)));
		byte[] b = toByteArray(o);
		
		File f = new File("E:\\temp\\file.t");
		try {
			OutputStream os = new FileOutputStream(f);
			os.write(b);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		BeanA beanB = (BeanA) client.get("bean1");
		System.out.println("beanA == beanB ? " + (beanA == beanB));

	}

	/**
	 * 对象转数组
	 * 
	 * @param obj
	 * @return
	 */
	public static byte[] toByteArray(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray();
			oos.close();
			bos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return bytes;
	}

}

class BeanA implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int id;
	String name;

	public BeanA(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
