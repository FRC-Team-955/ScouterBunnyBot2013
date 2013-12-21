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
    private boolean[] m_stats;
    public String m_number;
    public int m_scoreTeleop;
    public int m_scoreAuto;
    
    public Bot()
    {
        reset();
    }
    
    public void reset()
    {
        m_stats = new boolean[Config.tagKeys.length];
        m_number = "";
        m_scoreTeleop = 0;
        m_scoreAuto = 0;
        
        for(int i = 0; i < m_stats.length; i++)
            m_stats[i] = false;
    }
    
    public void parseTags(String data)
    {
        for(int dataIndex = 0; dataIndex < data.length(); dataIndex++)
            for(int tagIndex = 0; tagIndex < Config.tagKeys.length; tagIndex++)
                if(data.charAt(dataIndex) == Config.tagKeys[tagIndex])
                    m_stats[tagIndex] = true;
    }
    
    public String getData()
    {
        String data = "";
        data += m_number + ",";
        data += m_scoreTeleop + ",";
        data += m_scoreAuto + ",";
        
        for(int i = 0; i < m_stats.length; i++)
            data += m_stats[i] + ",";
        
        return data;
    }
}