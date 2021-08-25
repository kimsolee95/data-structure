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
		defaultAdd(value);
		return false;
	}
	
	public void defaultAdd(E value) { 
		//arrayList에서 인자로 더할 value만 있을 시, 배열의 마지막에 value가 온다.(default) 
		//만약 현재의 요소담긴 배열 전체의 크기와 실제 담긴 요소 개수가 같으면 동적할당을 하는 메서드를 호출한다.
		if (size == array.length) { resize(); }
		
		//배열 끝 위치 index에 value를 넣어준다.
		array[size] = value;
		size++; 
	}
	

	@Override
	public void add(int index, E value) {
		
		//배열의 index를 벗어난 index를 인자로 한다면 exception을 발생시켜야 한다.
		if (index > size || index < 0) { throw new IndexOutOfBoundsException(); }
		
		if (index == size) { //인자로 받은 index가 현재 담긴 요소의 개수를 뜻하는 변수(size)와 같다면

			defaultAdd(value); //배열 끝에 value를 추가한다.	
			
		} else if (index != size) { //인자로 받은 index가 현재 담긴 요소의 개수를 뜻하는 변수(size)와 틀리다면

			if (size == array.length) { //만약 배열 내 요소 개수와 배열 길이가 같다면
				resize(); //배열을 동적할당하는 메서드 호출한다.
			}
			
			//특정 index에 value를 놓을 때에는
			//인자로 받아온 해당 index를 기준으로 하여 뒤편에 있는 data는 index+1 되어야 한다.
			for (int i=size; i>index; i--) {
				array[i] = array[i - 1]; //베열을 도표로 그릴 시, data가 한칸씩 우측으로 이동하는 그림과 동일한 형태
			}
			
			array[index] = value; //지정한 index에 value를 할당한다.
			size++;
		}
			
	}

	@Override
	public E get(int index) {
		
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		return (E) array[index]; 
		//Object로 들어있는 요소를
		// Generic Element E로 캐스팅하여 return 시켜야 한다. (원 data의 type)
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0; 
	}
	
}
