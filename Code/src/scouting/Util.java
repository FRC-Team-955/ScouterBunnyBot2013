/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scouting;

import java.util.ArrayList;

/**
 *
 * @author Merfoo
 */
public class Util
{
    public static String eraseComma(String data)
    {
        String noComma = "";
        
        for(int i = 0; i < data.length(); i++)
            if(data.charAt(i) != ',')
                noComma += data.charAt(i);
        
        return noComma;
    }
   
    public static String[] splitString(String data, String delim)
    {
        ArrayList<String> newData = new ArrayList();
        final int dataLength = data.length();
        final int delimLength = delim.length();
        int index = 0;
        int delimIndex = 0;
        String temp;
        
        while((delimIndex = data.indexOf(delim, index)) != -1)
        {
            temp = data.substring(index, delimIndex);
            
            if(!temp.equals(""))
                newData.add(temp);
            
            index = delimIndex + delimLength;
        }
        
        temp = data.substring(index, dataLength);
        
        if(!temp.equals(""))
            newData.add(temp);
        
        return newData.toArray(new String[newData.size()]);
    }
}
