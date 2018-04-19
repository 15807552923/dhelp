package com.cxy.webapp;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebappApplicationTests {



	@Test
	public void contextLoads() {
	/*	List<Integer> intList = Lists.newArrayList(1,2,3,4);
		intList.forEach(System.out::println);
		intList.forEach((Integer e)->System.out.println(e));
		Integer add = intList.stream().reduce(0,(x,y)->x+y);
		System.out.println("add="+add);

		Runnable r1 = ()->  System.out.println("d");
		r1.run();*/

		System.out.println(Food.Cake);
		Food.Cake.getInfo(Food.Duck);
	}


	interface ShowDetail{
		 <T> void getInfo(T t);
	}
	enum Food implements ShowDetail{
		Cake(1,"cake"),Cook(2,"cook"),Duck(3,"Duck");

		private int i;
		private String name;
		Food(int i,String s) {
			this.i = i;
			this.name = s;
		}

		@Override
		public <T> void getInfo(T t) {
			System.out.println("i="+i+",name="+name);
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}


}
