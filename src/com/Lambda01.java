package com;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.junit.Test;

import com.atguigu.java8.Employee;

public class Lambda01 {

	private static final ThreadLocal<DateFormat>  df = new ThreadLocal<DateFormat>() {
		 protected DateFormat initialValue() {
		        return new SimpleDateFormat("yyyyMMdd");
		    }
	};
	
	public static Date covert(String source) throws ParseException {
		return df.get().parse(source);
	}
	
	@Test
	public void test1() {
		int num = 0;
		Runnable r = ()-> System.out.println(num);
		r.run();
	}
	
	@Test
	public void test2() {
		Comparator<Integer> c = (x,y)->x;
		
		System.out.println(c.compare(1, 2));
	}
	
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);
	private Optional<Integer> reduce2;
	
	@Test
	public void test3(){
		Collections.sort(emps, (e1, e2) -> {
			System.out.println(e1.getName().compareTo(e2.getName()));
			if(e1.getAge() == e2.getAge()){
					return e1.getName().compareTo(e2.getName());
			}else{
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
                                                                                                                                                          
		for (Employee emp : emps) {                                                                                                                            
			Consumer<Employee>  c = System.out::println;
			c.accept(emp);
		}
	}
	
	@Test
	public void test4(){
		boolean allMatch = emps.stream().allMatch((e)->e.getAge()==18);
		System.out.println(allMatch);
		Optional<Employee> findFirst = emps.stream().sorted((e1,e2) -> Double.compare(e2.getSalary(),e1.getSalary())).findFirst();
		System.out.println(findFirst.get()); 
		Optional<Double> min = emps.stream().map(Employee::getSalary).min(Double::compareTo);
		System.out.println(min);
	}
	
	@Test
	public void test5(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Optional<Integer> a = list.stream()
			.reduce((e1,e2)->e1-e2);
		System.out.println(a);
		
		Optional<Double> reduce = emps.stream().map(Employee::getSalary).reduce((e1,e2)->e1+e2);
		System.out.println(reduce);
		
		List<String> collect = emps.stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(collect);
		Map<String, String> collect2 = emps.stream().collect(Collectors.toMap(Employee::getName, Employee::getName));
		System.out.println(collect2);
		
		Integer[] nums = {1,2,3,4,5};
		Arrays.stream(nums).map((x)->x*x).forEach(System.out::println);
	}
	
	@Test
	public void test6(){
		Instant start = Instant.now();
		long reduce = LongStream.rangeClosed(0, 100000000000L).parallel().reduce(0,Long::sum);
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end).toMillis());

	}
	@Test
	public void test7(){
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		ldt=ldt.plusYears(2L);
		System.out.println(ldt);
		ldt=ldt.minusMonths(2L);
		System.out.println(ldt);
	}
	
}
