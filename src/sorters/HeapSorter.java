package sorters;

import java.util.Comparator;

import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {

	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		
		heapify();
		
		extract();
		
		return list;
	}
	
	private void siftDown(int start, int end) { 
		int root = start;
		
		while(root*2 + 1 <= end) {
			int child = root *2 + 1; 
			int swap = root;
			
			if(list.compare(swap, child, comparator) < 0) 
				swap = child;

			if(child+1 <= end && list.compare(swap, child + 1, comparator) < 0) 
				swap = child +1;
			
			if(swap == root) {
				return;
			} else {
				list.swap(root, swap); 
				root = swap;
			}
		}
	}
	
	private void heapify() {
		
		int start = (list.size()-2)/2;
		
		while(start >= 0) {
			siftDown(start--, list.size()-1);
		}
	}
	
	private void extract() {
		int end = list.size() - 1;
		
		while (end > 0) {
			list.swap(0, end);
			
			end--;
			
			siftDown(0, end);
		}
		
	}
	
	
}
