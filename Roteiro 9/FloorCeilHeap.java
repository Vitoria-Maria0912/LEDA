package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		
		Integer floor = null;
		
		if(array != null) {
			for(Integer value: array) {
				insert(value);
			}
			floor = floor(floor, numero);
		}
		
		return floor;
	}

	private Integer floor(Integer floor, double numero) {
		
		Integer root = extractRootElement();
		
		if (root != null) {
			
			if(numero >= root && (floor == null || root >= floor)) {
				floor = floor(root, numero);
				
			} else {
				floor = floor(floor, numero);
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		
		Integer ceil = null;
		
		if(array != null) {
			for(Integer value: array) {
				insert(value);
			} 
			ceil = ceil(ceil, numero);
		}
		
		return ceil;
	}

	private Integer ceil(Integer ceil, double numero) {
		
		Integer root = extractRootElement();
		
		if (root != null) {
			
			if (numero <= root && (ceil == null || root <= ceil)) {
				ceil = ceil(root, numero);
				
			} else {
				ceil = ceil(ceil, numero);
			}
		}
		return ceil;
	}
}
