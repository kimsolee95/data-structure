package com.datastructure.solist;

import java.util.ArrayList;

public class TestMakedArrayList {
	
	public static void main(String[] args) {
		
		List<String> makedArrayList = new SoList<>(); //String만 담는 배열
		List<Integer> arrayList2 = new SoList<>(); //int형만 담는 배열
		ArrayList<String> originalArrayList = new ArrayList<>();
		
				
		makedArrayList.add("처음 add 시, index 0 요소");
		makedArrayList.add("처음 add 시, index 1 요소");
		makedArrayList.add("처음 add 시, index 2 요소");
		makedArrayList.add("처음 add 시, index 3 요소");
		makedArrayList.add("처음 add 시, index 4 요소");
		
		arrayList2.add(1);
		arrayList2.add(2);
		arrayList2.add(3);
		arrayList2.add(4);
		arrayList2.add(5);
		

		//add test
		System.out.println("== 만든 arrayList에 add method를 통해 추가한 요소를 확인해봅니다. ==");
		System.out.println(makedArrayList.get(0));
		System.out.println(makedArrayList.get(1));
		System.out.println(makedArrayList.get(2));
		System.out.println(makedArrayList.get(3));
		System.out.println(makedArrayList.get(4));

		System.out.println(arrayList2.get(0));
		System.out.println(arrayList2.get(1));
		System.out.println(arrayList2.get(2));
		System.out.println(arrayList2.get(3));
		System.out.println(arrayList2.get(4));
		
		System.out.println("== 만든 arrayList(String형)에 add method를 통해 추가된 요소의 개수를 확인해봅니다. ==");
		System.out.println(makedArrayList.size());
		
		System.out.println("== 만든 arrayList(int형)에 add method를 통해 추가된 요소의 개수를 확인해봅니다. ==");
		System.out.println(arrayList2.size());
		
		
		//remove test
		System.out.println("만든 arrayList에 remove method를 통해 삭제한 요소를 확인해봅니다.");
		
		System.out.println("1. index를 인자로 하여 삭제해보기(remove(2 ))");
		makedArrayList.remove(2);
		System.out.println(makedArrayList.size());
		System.out.println(makedArrayList.get(0));
		System.out.println(makedArrayList.get(1));
		System.out.println(makedArrayList.get(2));
		System.out.println(makedArrayList.get(3));
		
		System.out.println("2. 배열내 Object를 인자로 하여 삭제해보기");
		makedArrayList.remove(3);
		System.out.println(makedArrayList.size());
		System.out.println(makedArrayList.get(0));
		System.out.println(makedArrayList.get(1));
		System.out.println(makedArrayList.get(2));
		
		//set test
		System.out.println("만든 arrayList에 set method를 통해 set한 요소를 확인해봅니다.");
		makedArrayList.set(0, "set method test입니다.");
		System.out.println(makedArrayList.get(0));
		
		//clone test (makedArrayList를 clone method를 통해 deep copy하는 test)
		//List<String> newCloneList =  makedArrayList.clone();
		
		SoList<String> originalList = new SoList<String>();
		
		originalList.add("1요소");
		originalList.add("2요소");
		originalList.add("3요소");
		originalList.add("4요소");
		originalList.add("5요소");
		
		System.out.println("====== OriginalList에 들어간 요소 확인 ======");
		
		System.out.println(originalList.get(0));
		System.out.println(originalList.get(1));
		System.out.println(originalList.get(2));
		System.out.println(originalList.get(3));
		System.out.println(originalList.get(4));
		
		//SoList cloneList<String> = originalList.clone();
		//clone method는 Object를 반환하기 때문에 SoList<String> 으로 casting해야 함.
		
		//전역변수 선언
		SoList<String> cloneList = null;
		
		try {
			cloneList = (SoList<String>) originalList.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} 
		
		System.out.println("====== CloneList에 들어간 요소 확인 ======");
		
		System.out.println(cloneList.get(0));
		System.out.println(cloneList.get(1));
		System.out.println(cloneList.get(2));
		System.out.println(cloneList.get(3));
		System.out.println(cloneList.get(4));

		//cloneList.remove(4);
		//cloneList.remove(3);
		//cloneList.remove(2);
		
		
		
		System.out.println("cloneList의 지워진 요소 확인");
		System.out.println(cloneList.get(0));
		System.out.println(cloneList.get(1));

		System.out.println("cloneList의 size: 요소의 개수");
		System.out.println(cloneList.size());
		

		System.out.println("originalList의 요소들 확인: cloneList와 다른 주소값, data를 가지고 있음을 확인하기");
		System.out.println(originalList.get(0));
		System.out.println(originalList.get(1));
		System.out.println(originalList.get(2));
		System.out.println(originalList.get(3));
		System.out.println(originalList.get(4));
		
		System.out.println("originalList의 size: 요소의 개수");
		System.out.println(originalList.size());
	}

}
