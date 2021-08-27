package com.datastructure.solist;

public class TestMakedArrayList {
	
	public static void main(String[] args) {
		
		List makedArrayList = new SoList();
		
		makedArrayList.add(1);
		makedArrayList.add(2);
		makedArrayList.add(3);
		makedArrayList.add(4);
		makedArrayList.add(5);

		//add test
		System.out.println("== 만든 arrayList에 add method를 통해 추가한 요소를 확인해봅니다. ==");
		System.out.println(makedArrayList.get(0));
		System.out.println(makedArrayList.get(1));
		System.out.println(makedArrayList.get(2));
		System.out.println(makedArrayList.get(3));
		System.out.println(makedArrayList.get(4));

		System.out.println("== 만든 arrayList에 add method를 통해 추가된 요소의 개수를 확인해봅니다. ==");
		System.out.println(makedArrayList.size());
		
		//remove test
		System.out.println("만든 arrayList에 remove method를 통해 삭제한 요소를 확인해봅니다.");
		
		makedArrayList.remove(2);
		System.out.println(makedArrayList.size());
		System.out.println(makedArrayList.get(0));
		System.out.println(makedArrayList.get(1));
		System.out.println(makedArrayList.get(2));
		System.out.println(makedArrayList.get(3));
	}

}
