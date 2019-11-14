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
public class StringCell extends Cell
{
    public StringCell(String content) 
    {
        super(content);
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
    }    
}
