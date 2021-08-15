package com.datastructure.solist;

import java.util.Arrays;

public class SoList<E> implements List<E> {

	private int initialCapacity = 10; //기본적으로 할당되는 ArrayList의 크기
	private Object[] emptyArray = {}; //빈 배열
	private int size; //배열 내 존재하는 요소의 개수
	
	Object[] array; //요소를 직접 담는 배열
	
	//생성자 : 초기 공간을 사용자가 지정하지 않고 쓸 때, 쓸 수 있는 method
	//ArrayList<String> list = new ArrayList<>();
	public SoList() {
		this.array = emptyArray;
		this.size = 0;
	}
	
	//생성자: 초기 공간을 사용자가 지정하고 쓸 때, 쓸 수 있는 method
	//ArrayList<String> list = new ArrayList<>(70);
	public SoList(int initialCapacity) {
		this.array = emptyArray;
		this.size = 0;
	}
	
	//접근지정자는 private로 한다. -> 맘대로 접근 X
	//ArrayList의 동적 배열 원리 -> 2배로 늘리는 것에 따른다.
	private void resize() {
		int arrayCapacity = array.length; //요소를 직접 담는 배열의 크기
		
		//만약 요소가 한 개도 안 담겨져 있어 배열의 크기가 0이라면
		//기본적인 arrayList의 크기인 int 10 크기의 배열 객체를 생성한다.
		if (Arrays.equals(array, emptyArray)) {
			array = new Object[initialCapacity];
			return;
		}
		
		//만약 요소가 담긴 배열의 크기만큼 요소가 모두 찼다면
		if (size == arrayCapacity) { 
			//ArrayList는 2배의 공간을 할당하기에 새 배열을 생성하며 지정할 배열크기는 원래 크기*2.
			int newCapacity = arrayCapacity * 2; 
			array = Arrays.copyOf(array, newCapacity); //새 배열을 복제한다.
			return;
		}
		
		//만약 배열에 담긴 요소의 개수가 배열 전체의 크기의 절반에 미치지 못할 땐
		if (size < (arrayCapacity / 2)) {
			//ArrayList는 담긴 요소가 전체 배열이 가진 크기 절반보다 적을 시, 자동으로 줄어든다.
			int newCapacity = arrayCapacity / 2;
			array = Arrays.copyOf(array, newCapacity);
			return;
		}
		
	}
	
	@Override
	public boolean add(E value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, E value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
