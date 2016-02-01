package sorters;

import java.util.Comparator;

import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		
		for (int i = 1; i < list.size(); i++) {
			
			int tempIndex = i;
			
			while (list.compare(tempIndex - 1, tempIndex, comparator) > 0) {
				list.swap(tempIndex - 1, tempIndex);
				
				tempIndex--;
				
				if (tempIndex <= 0)
					break;
			}
		}
		
		return list;
	}
}
