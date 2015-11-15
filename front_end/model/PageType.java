package model;

/**
 *
 * @author tiffanychao
 */
public enum PageType {
    HOME(0), DECK(1), QUIZ(2);
    private int value;
    PageType(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }  
}
