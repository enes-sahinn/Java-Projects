package lab10;

public class RowElement {
	private Object number;
	private RowElement next;
	
	public RowElement(Object dataToAdd) {
		number = dataToAdd;
		next = null;
	}

	public Object getNumber() {
		return number;
	}

	public void setNumber(Object number) {
		this.number = number;
	}

	public RowElement getNext() {
		return next;
	}

	public void setNext(RowElement next) {
		this.next = next;
	}
}
