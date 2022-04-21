
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc2020;

/**
 *
 * @author ujjawal kumar
 */
public class RackBean 
{
    int rackno;
    private String subject;

    public void setRackno(int rackno)
    {
        this.rackno = rackno;
    }

    public int getRackno()
    {
        return rackno;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    public String getSubject()
    {
        return subject;
    }
}