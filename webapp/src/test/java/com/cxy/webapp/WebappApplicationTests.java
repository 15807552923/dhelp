package com.cxy.webapp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.google.common.collect.ImmutableList;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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
	@Test
	public void TestReplaceStr(){

		//List<User> list = ImmutableList.of(new User("Tom","1"),new User("jack","2"),new User("full","3"),new User("Apple","1"));
		List<User> list = new ArrayList<>(10);
		for(int i=0 ;i<100;i++){
			list.add(new User("name"+i,i%3+""));
		}

		String str = JSON.toJSONString(list);
		System.out.println("before :"+str);
//		list.stream().forEach(user->{
//			if(user.getSex().equals("1")){user.setSex("男"); }
//			if(user.getSex().equals("2")){user.setSex("女"); }
//			if(user.getSex().equals("3")){user.setSex("未知"); }
//		});
//		String str2 = JSON.toJSONString(list);
//		System.out.println("after:"+str2);

//		ValueFilter valueFilter = new ValueFilter() {
//			@Override
//			public Object process(Object o, String s, Object o1) {
//				if(s.equals("sex")){
//					if(o1.equals("1")){
//						return new String("男");//返回修改后的属性值对象
//					}
//					if(o1.equals("2")){
//						return new String("女");//返回修改后的属性值对象
//					}
//					if(o1.equals("3")){
//						return new String("未知");//返回修改后的属性值对象
//					}
//
//				}
//
//				return o1;
//			}
//
//		};


		Map<String ,HashMap<String,String>> mapall = new HashMap<String ,HashMap<String,String>>(5);
		HashMap<String,String> map =new HashMap(5);
		map.put("1","男");
		map.put("2","女");
		map.put("3","未知");
		mapall.put("sex",map);

		Long startTime = System.currentTimeMillis();
		String jsonString = JSON.toJSONString(list, new MyFilter(mapall));
		Long endTime =System.currentTimeMillis();
		User u = new User("cxu","1");
		//String listStr = JSON.toJSONString(u,new MyFilter(mapall,User.class));

		System.out.println("after:"+jsonString);
		System.out.println("消耗时间："+(endTime-startTime)+"ms");
	}

	class MyFilter<T> implements  ValueFilter{
		//private Map<String ,HashMap<String,String>> map;
		private  T t;

		public MyFilter(T t){
			//this.map=map;
			this.t =t;
			System.out.println("result:"+t.getClass()+",");
		}
		@Override
		public Object process(Object o, String s, Object o1) {
			Map<Object ,HashMap<Object,Object>> map=new HashMap<>();
				map= (Map<Object, HashMap<Object, Object>>) t;
				if(map.containsKey(s)){
					HashMap<Object,Object> map2=  map.get(s);
					return  map2.get(o1);
				}

			return o1;
		}


	}



	class User {
		private String name ;
		private String sex;

		public User(String name,String sex){
			this.name=name;
			this.sex=sex;
		}
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}
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
