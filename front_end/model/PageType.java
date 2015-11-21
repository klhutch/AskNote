package model;

/**
 *
 * @author tiffanychao
 */
public enum PageType {
    HOME(0), DECK(1), QUIZ(2), QUIZ_DECK(3), EDIT_CARD(4), EDIT_DECK(5), 
        FRIENDS_LIST(6), LOGIN(7), NOTIFICATIONS(8), QUIZ_SELF(9), 
        QUIZ_SELECT(10), QUIZ_TESTER(11), QUIZ_TESTEE(12), QUIZ_WAITING(13);
    
    private int value;
    
    PageType(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }  
}
