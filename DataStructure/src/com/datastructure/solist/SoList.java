package com.datastructure.solist;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SoList <E> extends ArrayList {
	
    public SoList(int initialCapacity) {
        super(initialCapacity);
    }

    public SoList() {
        super();
    }

    public SoList(Collection c) {
        super(c);
    }

    @Override
    public void trimToSize() {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public void add(int index, Object element) {
    }

    @Override ////특정 index 요소 제거 후, 해당 위치 이후 data들을 한 index씩 앞으로 당겨오기
    public Object remove(int index) { 
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
    }

    @Override
    public void sort(Comparator c) {
    }
}


