/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author khalil
 */
public class Hint extends JTextField implements FocusListener{
    private final  String hint;
    private  boolean Showinghint;
    Hint(final String hint){
        super(hint);
        this.hint =hint ;
        this.Showinghint=true;
        super.addFocusListener(this);
            }
    
    

    @Override
    public void focusGained(FocusEvent e) {
        if(this.getText().isEmpty()){
            
            super.setText("");
            Showinghint=false;
            
        }
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(this.getText().isEmpty()){
            
            super.setText(hint);
            Showinghint=true;
            
        }
        
    }
        @Override
        public String getText(){
            return Showinghint ? "" :super.getText();
        }
        

    
    
}
