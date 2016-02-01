package sorters;

import java.util.Comparator;

import structures.SwapList;

public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		
		qs(0, list.size() - 1);
		
		/*
		 * Note: When choosing a pivot, choose the element in the middle of
		 * the sub-array. That is,
		 * 
		 * pivotIndex = (firstIndex + lastIndex) / 2;
		 */
		
		return list;
	}
	
	public void qs(int firstIndex, int lastIndex) {
		  if (firstIndex < lastIndex) {
		    int splitPoint = split(firstIndex, lastIndex);
		    qs(firstIndex, splitPoint - 1);
		    qs(splitPoint + 1, lastIndex);
		  }
	}
	
	public int split(int firstIndex, int lastIndex) {
		
		  int splitIndex = (firstIndex + lastIndex) / 2;
		  
		  list.swap(splitIndex, lastIndex);
		  
		  int nextSwapIndex = firstIndex;
		  
		  for (int i = firstIndex; i < lastIndex; i++) {
		    if (list.compare(i, lastIndex, comparator) <= 0) {
		      list.swap(i, nextSwapIndex);
		      nextSwapIndex++;
		    }
		  }
		  
		  list.swap(nextSwapIndex, lastIndex);

		  return nextSwapIndex;
	}
}