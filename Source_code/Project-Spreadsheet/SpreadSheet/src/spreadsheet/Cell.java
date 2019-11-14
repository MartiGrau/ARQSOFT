/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet;

/**
 *
 * @author uni
 */
public abstract class Cell 
{
    public Cell (String content)
    {
        this.content = content;
    }
    public abstract String getContent();
    public abstract void setContent(String content);
    protected String content;
}
