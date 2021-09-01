package com.datastructure.solist;

public interface List<E> {

	/**
	 * 리스트에 요소 추가
	 * 
	 * @param E value 리스트에 추가하는 요소
	 * @return boolean (true or false) 
	 *  */
	boolean add(E value);
	
	/**
	 * 리스트 특정 index에 요소 추가
	 * 
	 * @param int index 리스트 내 요소가 추가될 특정 index 위치
	 * @param E value 리스트에 추가할 요소
	 *  */
	void add(int index, E value);
	
	/**
	 * @param int index 리스트내 data가 위치한 index
	 * @return 리스트 내 index 에 해당하는 요소 
	 *  */
	E get(int index);
	
	/** 
	 * @return 리스트 내 요소의 개수
	 * */
	int size();
	
	/**
	 * @return 리스트의 요소 유무에 따른 boolean 값
	 *  */
	boolean isEmpty();
	
	/**
	 * 지정한 인덱스에 맞는 배열 내의 요소를 삭제
	 * 
	 * @param int index 리스트 내 data가 위치한 idnex
	 * @return 삭제 완료한 요소
	 *  */
	E remove(int index);
	
	/**
	 * 
	 *  @param index를 찾고 싶은 배열 내의 요소
	 *  @return 인자로 받아온 요소와 배열 내 요소와 일치하는 index를 return
	 *  		존재하지 않을 시, -1을 return
	 *  */
	int indexOf(Object value);
	
	/**
	 * 
	 * @param 삭제하고자 하는 요소
	 * @return 인자로 받은 요소가 배열 내 요소로 존재 및 삭제 성공 시, true 반환
	 *  */
	boolean remove(Object value);
	
	/**
	 * 
	 * 해당 배열의 모든 요소를 삭제.
	 *  */
	void clear();
	
	/**
	 * @param 배열 내 들어있는지 확인하려는 요소의 값
	 * @return boolean
	 *  */
	boolean contains(Object value);
	
	/**
	 * @param 배열 내 index와 해당 index에 set할 요소
	 * @return set한 요소
	 *  */
	E set(int index, Object element);
}
