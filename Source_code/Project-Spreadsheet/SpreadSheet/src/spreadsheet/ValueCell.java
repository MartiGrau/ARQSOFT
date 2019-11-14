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
public final class ValueCell extends Cell
{
    public ValueCell(String content)
    {
        super(content);
        this.value = Float.parseFloat(content);
    }
    @Override
    public String getContent()
    {
        return content;
        
    }
    @Override
    public void setContent(String content)
    {
        this.content = content; 
        this.value = Float.parseFloat(content);
    }
    public float getValue()
    {
        return value;
    }
    private float value;
    
}
