/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Cacu {
    public float caculate(float salary,int percent) // luong co ban
    {
        return (float) (salary*4.5/100)*(100-percent)/100;
    }
    public float[] caculateForFamily(float salary,int numberOfMember) //ho gia dinh
    {
       float[] list = new float[10] ;
       for(int i = 0; i < numberOfMember;i++)
       {
           if(i == 0)list[i] = (float)(salary*4.5/100);
           if(i == 1)list[i] = (float)(salary*4.5/100)*70/100;
           if(i == 2)list[i] = (float)(salary*4.5/100)*60/100;
           if(i == 3)list[i] = (float)(salary*4.5/100)*50/100;
           if(i>3)   list[i] = (float)(salary*4.5/100)*40/100; 
       }
       return list;
    }
    
}
