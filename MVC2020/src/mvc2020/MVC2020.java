
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc2020;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ujjawal kumar
 */
public class MVC2020 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO MVC");
        while(true)
        {
            
            System.out.println("1.INSERT");
            System.out.println("2.DELETE");
            System.out.println("3.SEARCH");
            System.out.println("4.GET ALL");
            System.out.println("5.EXIT");
            System.out.println("ENTER YOUR CHOICE");
            int v=sc.nextInt();
            
            switch(v)
            {
                case 1:
                {
                    RackBean rb = new RackBean();
                    rb.setRackno(12);
                    rb.setSubject("Sonali");
                    
                    RackData rd = new RackData();
                    
                    try
                    {
                        String s = rd.insert(rb);
       
                        if(s.equals("success"))
                        {
                            System.out.println("Data Saved");
                        }
                        else 
                        {
                            System.out.println("Some Data Error");
                        }
                    }
                        
                    catch(Exception e)
                    {
                        System.out.println(e.toString());
                    }
                    break;
                }
                
                case 2:
                {
                    RackData rd = new RackData();
                
                    try
                    {
                        String s=rd.delete(2);
                        if(s.equals("success"))
                        {
                            System.out.println("Data Deleted");
                        }
                        else 
                        {
                            System.out.println("Some Data Error");
                        }
                    }
                    
                    catch(Exception e)
                    {
                        System.out.println(e.toString());
                    }
                    break;
                }
                
                case 3:
                {
                    RackData rd = new RackData();

                    try
                    {
                        RackBean rb = rd.search(12);
                        if(rb != null)
                        {
                            System.out.println(rb.getSubject());
                        }
                        else 
                        {
                            System.out.println("Sorry this rack doesn't exist");
                        }
                    }
                    
                    catch(Exception e)
                    {
                        System.out.println(e.toString());
                    }
                    break;
                }
                
                case 4:
                {
                    System.out.println("----THE REQUIRED REMAINING TABLE:----");
                    RackData rd = new RackData();
                    RackBean rb = null;
                    
                    try
                    {
                    ArrayList al = rd.getAll();
                        for (int i = 0; i< al.size(); i++)
                        {
                            rb = (RackBean)al.get(i);
                            System.out.println(rb.getRackno()+"\t"+rb.getSubject());
                        }
                    }
                    
                    catch(Exception e)
                    {
                        System.out.println(e.toString());
                    }
                    break;
                }
                
                case 5:
                {
                    System.out.println("Now Exit");
                    System.exit(0);
                }
                
                default:
                {
                    System.out.println("Wrong choice please enter correct choice");
                }
            }
        }
    }
}