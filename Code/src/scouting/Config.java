/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scouting;

import java.awt.Color;

/**
 *
 * @author Merfoo
 */
public class Config
{
    static final Color blue = new Color(0, 0, 222);
    static final Color red = new Color(222, 0, 0);
    static final int amountOfBots = 3;
    static final char[] botKeysTeleop = {'a', 'g', 'l'};
    static final char[] botKeysAuto = {'A', 'G', 'L'};
    static final char[] tagKeys = {'1', '2', '3', '4', '5', '6'};
    static final String matchFileName = "Scouting Data/Match ";
    static final String botDataFormatFileName = "Scouting Data/Data Format.csv";
    static final String botDataFormat = "Team Number,Teleop,Auto,Defensive,Herds,Picks Up,Selective Scoring,Not Functioning";
}
