package model;

/**
 *
 * @author tiffanychao
 */

import java.util.Stack;

public class AsknoteModel {
    Stack<PageType> pages;
    
    public AsknoteModel() {
        pages = new Stack<PageType>();
    }
    
    public PageType getCurrentPage() {
        if (pages.empty()) {
            return PageType.HOME;
        } else {
            return pages.peek();
        }
    } 
}
