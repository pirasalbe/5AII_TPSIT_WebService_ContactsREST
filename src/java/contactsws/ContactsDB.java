/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsws;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pirasalbe
 */
public class ContactsDB {
        private static Map map  = Collections.synchronizedMap(new HashMap<String,Integer>());

    public static Map getMap() {
        return map;
    }

    
}
