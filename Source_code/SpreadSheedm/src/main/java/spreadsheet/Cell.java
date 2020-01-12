/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author uni
 */
public abstract class Cell 
{
    private PropertyChangeSupport dependentCells = new PropertyChangeSupport(this);
    public Cell (String content)
    {        
        this.content = content;
    }
    public void addPropertyChangeListener(PropertyChangeListener l) {
        dependentCells.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        dependentCells.removePropertyChangeListener(l);
    }
    public abstract String getContent();
    protected String content;
    
    // TODO Destructor that calls remove dependencies
}
