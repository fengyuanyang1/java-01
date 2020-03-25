package com;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class Interview {

	
	@Test
	public void Dice() {
		int probability2 = 0;
		int probability3 = 0;
		int probability4 = 0;
		int probability5 = 0;
		int probability6 = 0;
		int probability7 = 0;
		int probability8 = 0;
		int probability9 = 0;
		int probability10 = 0;
		int probability11 = 0;
		int probability12 = 0;
		for (int i = 0; i < 100; i++) {
			 Random rn = new Random();
			 int one = rn.nextInt(6);
			 int two = rn.nextInt(6);
			 switch (one+two+2) {
			case 2:
				probability2++;
				break;
			case 3:
				probability3++;
				break;
			case 4:
				probability4++;
				break;
			case 5:
				probability5++;
				break;
			case 6:
				probability6++;
				break;
			case 7:
				probability7++;
				break;
			case 8:
				probability8++;
				break;
			case 9:
				probability9++;
				break;
			case 10:
				probability10++;
				break;
			case 11:
				probability11++;
				break;
			case 12:
				probability12++;
				break;
			default:
				System.out.println(one+two);
				break;
			}
		}
		double gl2=probability2/10D;
		double gl3=probability3/100D;
		double gl4=probability4/100D;
		double gl5=probability5/100D;
		double gl6=probability6/100D;
		double gl7=probability7/100D;
		double gl8=probability8/100D;
		double gl9=probability9/100D;
		double gl10=probability10/100D;
		double gl11=probability11/100D;
		double gl12=probability12/100D;
		System.out.println("和为2的概率"+gl2);
		System.out.println("和为3的概率"+gl3);
		System.out.println("和为4的概率"+gl4);
		System.out.println("和为5的概率"+gl5);
		System.out.println("和为6的概率"+gl6);
		System.out.println("和为7的概率"+gl7);
		System.out.println("和为8的概率"+gl8);
		System.out.println("和为9的概率"+gl9);
		System.out.println("和为10的概率"+gl10);
		System.out.println("和为11的概率"+gl11);
		System.out.println("和为12的概率"+gl12);
	}
	
	@Test
	public void arr() {
		int[] arr = new int[100];
		Random rn = new Random();
		for (int i = 0; i <100-1; i++){
			arr[i] = rn.nextInt(50);
		}
		List<Integer> list = new ArrayList<Integer>();
		for (Integer integer : arr) {
			list.add(integer+1);
		}
		List<Integer> newlist = new ArrayList<Integer>();
		for (int j = 0; j < list.size(); j++){
			if (list.get(j) % 2 == 0){
				newlist.add(list.get(j));
			}
		}
		int before = 1;
		int count2 = 0;
		Collections.sort(newlist);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		System.out.println(newlist.toString());
		for (Integer integer : newlist) {
			if(before==integer) {
				count2++;
				map.put(before, count2);
			}else {
				before=integer;
				count2=1;
				map.put(before, count2);
			}
		}
		List<Integer> newlist2 = new ArrayList<Integer>();
		for (Integer integer : map.values()) {
			newlist2.add(integer);
		}
//		Collections.sort(newlist2); 
	}
	@Test
	public void arr2() {
		String na="main-action-holder";
		String i = na.substring(0, na.indexOf("-"))+
				na.substring(na.indexOf("-")+1, na.indexOf("-")+2).toUpperCase()+
				na.substring(na.indexOf("-")+2,na.lastIndexOf("-"))+
				na.substring(na.lastIndexOf("-")+1,na.lastIndexOf("-")+2).toUpperCase()
				+na.substring(na.lastIndexOf("-")+2);
System.out.println(i);
		
	}
	
}
