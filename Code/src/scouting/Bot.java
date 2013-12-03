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
    private boolean m_penalized;
    private boolean m_defensive;
    private boolean m_broken;
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
        m_penalized = false;
        m_defensive = false;
        m_broken = false;
        m_number = "";
        m_comments = "";
        m_scoreTeleop = 0;
        m_scoreAuto = 0;
    }
    
    public void setPenalized(boolean value)
    {
        m_penalized = value;
    }
    
    public void setDefensive(boolean value)
    {
        m_defensive = value;
    }
    
    public void setBroken(boolean value)
    {
        m_broken = value;
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
        data += m_defensive + ",";
        data += m_broken + ",";
        data += m_comments;
        return data;
    }
}
