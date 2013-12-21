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
}
