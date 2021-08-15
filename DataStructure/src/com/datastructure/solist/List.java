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
	
	
	
	
	
	
}
