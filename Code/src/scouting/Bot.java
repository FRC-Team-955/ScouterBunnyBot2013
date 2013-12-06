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


///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package scouting;
//
///**
// *
// * @author Merfoo
// */
//public class Bot
//{
//    private boolean m_notFunctioning;
//    private boolean m_herdsBalls;
//    private boolean m_picksUpBalls;
//    private boolean m_selectiveScoring;
//    private boolean m_defensive;
//    public String m_number;
//    public int m_scoreTeleop;
//    public int m_scoreAuto;
//    
//    public Bot()
//    {
//        reset();
//    }
//    
//    public void reset()
//    {
//        m_notFunctioning = false;
//        m_herdsBalls = false;
//        m_picksUpBalls = false;
//        m_selectiveScoring = false;
//        m_defensive = false;
//        m_number = "";
//        m_scoreTeleop = 0;
//        m_scoreAuto = 0;
//    }
//    
//    public void parseTags(String data)
//    {
//        for(int dataIndex = 0; dataIndex < data.length(); dataIndex++)
//        {
//            int tagIndex = 0;
//            
//            if(data.charAt(dataIndex) == Config.tagKeys[tagIndex++])
//                m_defensive = true;
//            
//            else if(data.charAt(dataIndex) == Config.tagKeys[tagIndex++])
//                m_herdsBalls = true;
//            
//            else if(data.charAt(dataIndex) == Config.tagKeys[tagIndex++])
//                m_picksUpBalls = true;
//            
//            else if(data.charAt(dataIndex) == Config.tagKeys[tagIndex++])
//                m_selectiveScoring = true;
//            
//            else if(data.charAt(dataIndex) == Config.tagKeys[tagIndex++])
//                m_notFunctioning = true;
//        }
//    }
//    
//    public String getData()
//    {
//        String data = "";
//        data += m_number + ",";
//        data += m_scoreTeleop + ",";
//        data += m_scoreAuto + ",";
//        data += m_penalized + ",";
//        data += m_bunnyCapable + ",";
//        data += m_notFunctioning + ",";
//        data += m_comments;
//        return data;
//    }
//}
