/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scouting;

/**
 *
 * @author Merfoo
 */
public class Bot
{
    private boolean m_bunnyCapable;
    private boolean m_notFunctioning;
    private String m_number;
    private String m_comments;
    private int m_scoreTeleop;
    private int m_scoreAuto;
    
    public Bot()
    {
        reset();
    }
    
    public void reset()
    {
        m_bunnyCapable = false;
        m_notFunctioning = false;
        m_number = "";
        m_comments = "";
        m_scoreTeleop = 0;
        m_scoreAuto = 0;
    }
    
    public void setBunnyCapable(boolean value)
    {
        m_bunnyCapable = value;
    }
    
    public void setBroken(boolean value)
    {
        m_notFunctioning = value;
    }
    
    public void setNumber(String value)
    {
        m_number = Util.eraseComma(value);
    }
    
    public void setComments(String value)
    {
        m_comments = Util.eraseComma(value);
    }
    
    public void setScoreTeleop(int value)
    {
        m_scoreTeleop = value;
    }
    
    public void setScoreAuto(int value)
    {
        m_scoreAuto = value;
    }
    
    public int getScoreTeleop()
    {
        return m_scoreTeleop;
    }
    
    public int getScoreAuto()
    {
        return m_scoreAuto;
    }
    
    public String getData()
    {
        String data = "";
        data += m_number + ",";
        data += m_scoreTeleop + ",";
        data += m_scoreAuto + ",";
        data += m_penalized + ",";
        data += m_bunnyCapable + ",";
        data += m_notFunctioning + ",";
        data += m_comments;
        return data;
    }
}
