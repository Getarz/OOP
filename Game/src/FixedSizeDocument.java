import javax.swing.text.*;
 
public class FixedSizeDocument extends PlainDocument {
	private int max = 10;
	public FixedSizeDocument(int max){
		this.max = max;
	}
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // check string being inserted does not exceed max length
        if (getLength() + str.length() <= max) {
            super.insertString(offs, str, a);
        }
    }
}