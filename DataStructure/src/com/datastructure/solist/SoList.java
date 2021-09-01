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
	public E remove(int index) {
		
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		E element = (E) array[index]; 
		// 배열 내에 Object로 담긴 요소를 generic E type으로 캐스팅하여 변수 하나로 담아놓는다.
		// 삭제 완료한 요소를 반환 시, 해당 변수를 반환할 예정임.
		
		//arrayList는 삭제가 진행되면 삭제 위치 뒤에 있는 요소들을 모두 위치 이동(배열 왼쪽으로 한칸씩)한다.
		//그러므로 삭제 전 배열 마지막 위치 index는 null 이 된다.
		for (int i=index; i<size; i++) {
			array[i] = array[i + 1];
			array[i + 1] = null;
			//JAVA의 GC가 null이 된 배열 내 메모리를 자동으로 처리한다.
		}
		
		size--;
		resize(); //arrayList는 동적배열이므로 다시 배열크기를 자동적으로 조절해야 한다.
		return element;
	}	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0; 
	}
	
	@Override
	public int indexOf(Object value) {
		
		if (value == null) {
			for (int i=0; i<size; i++) {
				if(array[i]==null) { return i; }
			}
		} else {
			for (int i=0; i<size; i++) {
				if (value.equals(array[i])) { return i; }
			}
		}
		
		return -1; //배열 내에 인자로 받아온 value와 일치하는 요소가 없다면 -1을 반환.
	}
	
	@Override
	public boolean remove(Object value) {
		//미리 구현해놓은
		//E remove(int index) 와 int indexOf(Object value) method 기능을 활용한다.
		
		int index = indexOf(value); //인자로 받은 value가 배열의 index로 존재하는지 확인한다.
		
		if (index != -1) { //배열 내 존재하는 value라면
			 
			if (value == null) { //해당 value 값이 null이라면 
				if (array[index] == null) {
					remove(index);
					return true;
				}
			} else {  
				if (value.equals(array[index])) {
					remove(index);
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void clear() {
		
		//배열 내 모든 요소를 null로 한다.
		for (int i=0; i<size; i++) {
			array[i] = null;
		}
		
		array = Arrays.copyOf(array, initialCapacity); 
		//초기 arrayList의 크기인 10으로 다시 새 배열을 복제한 것을 
		//요소를 직접 담는 변수인 array에 할당해준다.
		
		size = 0; //요소의 개수를 다시 0으로 돌려놓는다.
	}
	
	@Override
	public boolean contains(Object value) {
		
		int index = indexOf(value);
		
		if (index != -1) {
			if (value == null) {
				if (array[index] == null) {
					return true;
				}
			} else {
				if (array[index] == value) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public E set(int index, Object value) {
		
		//배열의 index를 벗어나는 값이 인자로 온다면 exception 처리를 해야 한다.
		if (index > size || index < 0) { throw new IndexOutOfBoundsException(); }

		//반환하는 값은 set method가 동작하기 이전의 Object를 E로 casting한 값이다.
		E element = (E) array[index]; 
		
		array[index] = value;
		
		return element;
	}
}
