package be.fnord.Permutator.PartitionedLists;

import java.util.LinkedList;


public class PartitionListElement<T> extends LinkedList<T> {
	private static final long serialVersionUID = 1L;

	public PartitionListElement() {
		super();
	}

	public PartitionListElement(PartitionListItem<T> results3) {
		for (T s : results3.get(0)) {
			add(s);
		}
	}

}