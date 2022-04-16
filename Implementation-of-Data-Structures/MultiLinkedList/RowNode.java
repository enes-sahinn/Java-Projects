package lab10;

public class RowNode {
	private Object rowNumber;
	private RowNode down;
	private RowElement right;
	
	public RowNode(Object dataToAdd) {
		rowNumber = dataToAdd;
		down = null;
		right = null;
	}

	public Object getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(Object rowNumber) {
		this.rowNumber = rowNumber;
	}

	public RowNode getDown() {
		return down;
	}

	public void setDown(RowNode down) {
		this.down = down;
	}

	public RowElement getRight() {
		return right;
	}

	public void setRight(RowElement right) {
		this.right = right;
	}
	
	
}


