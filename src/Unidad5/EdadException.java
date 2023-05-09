package Unidad5;

import java.io.Serializable;

//public class EdadException extends Exception {
//public EdadException() {
//	super();
//}
//public EdadException(String  msg) {
//	super(msg);
//}
//}
public class EdadException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public EdadException() {
        super();
    }
    
    public EdadException(String msg) {
        super(msg);
    }
}
