
package scouting;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

/**
 *
 * @author Fauzi
 */
public class Form extends javax.swing.JFrame 
{
    static int m_matchNumber = 0;
    static String m_color = "blue";
    static FileWriter m_writer;
    
    // Keyboard Format: pocket
    static char[] m_botKeys = {'a', 'g', 'l'};
    
    // Data for bots starts ----------------------------------------------------
    static Bot[] m_bots = new Bot[Config.amountOfBots];
    
    // Bot defensive, broken, penalized
    JCheckBox[] m_checkPenalized;
    JCheckBox[] m_checkDefensive;
    JCheckBox[] m_checkBroken;
    
    // Team numbers, comments
    JTextField[] m_textTeam;
    JTextField[] m_textComments;
    
    /**
     * Creates new form Form
     */
    public Form() 
    {
        initComponents(); 
        m_checkDefensive = new JCheckBox[]{checkDefensive1, checkDefensive2, checkDefensive3};
        m_checkPenalized = new JCheckBox[]{checkPenalized1, checkPenalized2, checkPenalized3};
        m_checkBroken = new JCheckBox[]{checkBroken1, checkBroken2, checkBroken3};
        m_textTeam = new JTextField[]{textTeam1, textTeam2, textTeam3};
        m_textComments = new JTextField[]{textComments1, textComments2, textComments3};
        resetData();
        initTeamColor();
    }
        
    /**
     * Exports to .csv file.
     * @param directory
     */
     public static void openFile(String directory)
     {
        try
        {
            File file = new File(directory);
            file.getParentFile().mkdirs();
            m_writer = new FileWriter(file);
        }
         
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
     
    public static void writeBotData(String botData)
    {  
        try
        {
            m_writer.append(botData);
            m_writer.append("\n");
            m_writer.flush();
        }

        catch(IOException e)
        {
             e.printStackTrace();
        } 
    }
     
    public static void closeFile()
    {
        try
        {
            m_writer.close();
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void resetData()
    { 
        for(int index = 0; index < Config.amountOfBots; index++)
        {
            m_checkPenalized[index].setSelected(false);
            m_checkDefensive[index].setSelected(false);
            m_checkBroken[index].setSelected(false);
            m_textTeam[index].setText("Bot #" + (index + 1));
            m_textComments[index].setText("");
            m_bots[index] = new Bot();
        }
        
        textScore.setText("");
        textMatchNumber.setText(String.valueOf(++m_matchNumber));
    }
    
    public void submitData()
    {
        for(int index = 0; index < Config.amountOfBots; index++)
        {
            m_bots[index].setPenalized(m_checkPenalized[index].isSelected());
            m_bots[index].setDefensive(m_checkDefensive[index].isSelected());
            m_bots[index].setBroken(m_checkBroken[index].isSelected());
            m_bots[index].setNumber(m_textTeam[index].getText());
            m_bots[index].setComments(m_textComments[index].getText());
        }   
        
        String scoreData = textScore.getText();
        
        for(int botIndex = 0; botIndex < m_botKeys.length; botIndex++)
        {
            for(int dataIndex = 0; dataIndex < scoreData.length(); dataIndex++)
            {    
                if(m_botKeys[botIndex] == scoreData.charAt(dataIndex))
                    m_bots[botIndex].setScoreTeleop(m_bots[botIndex].getScoreTeleop() + 1);

                else if(Character.toUpperCase(m_botKeys[botIndex]) == scoreData.charAt(dataIndex))
                    m_bots[botIndex].setScoreAuto(m_bots[botIndex].getScoreAuto() + 1);
            }
        }      
        
        try
        {
            m_matchNumber = Integer.parseInt(textMatchNumber.getText());
        }
        
        catch(NumberFormatException e){}
        
        String sMatchNumber = String.valueOf(m_matchNumber);
        
        // Open file
        openFile("Scouting Data/Match " + sMatchNumber  + m_color + ".csv");
        
        // Write data to files.
        for(int index = 0; index < Config.amountOfBots; index++)       
            writeBotData(m_bots[index].getData());

        // Close file
        closeFile();
    }
    
    public void setColor(Color color)
    {
        if(color.getRGB() == Config.blue.getRGB())
        {
            m_color = "blue";
            checkRedAlliance.setSelected(false);
            checkBlueAlliance.setSelected(true);
        }
        
        else if(color.getRGB() == Config.red.getRGB())
        {
            m_color = "red";
            checkRedAlliance.setSelected(true);
            checkBlueAlliance.setSelected(false);
        }
        
        textTeam1.setForeground(color);
        textTeam2.setForeground(color);
        textTeam3.setForeground(color);
    }
    
    public void initTeamColor()
    {
        int response = showOptionBox("Team Color", "What color is your Alliance?", "Red", "Blue");
        
        checkRedAlliance.setForeground(Color.red);
        checkBlueAlliance.setForeground(Color.blue);
        
        if(response == 0)
            setColor(Config.red);
        
        else
            setColor(Config.blue);
    }
    public int showOptionBox(String title, String question, String box1, String box2)
    {
        Object[] options = {box1, box2};
        int response = JOptionPane.showOptionDialog(this,
                                            question,
                                            title,
                                            JOptionPane.YES_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            options,
                                            options[1]);
        return response;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        labelTitle = new javax.swing.JLabel();
        btSubmit = new javax.swing.JButton();
        panelScore = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textScore = new javax.swing.JTextArea();
        labelScore = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        labelMatchNumber = new javax.swing.JLabel();
        textMatchNumber = new javax.swing.JTextField();
        checkRedAlliance = new javax.swing.JCheckBox();
        panelBots = new javax.swing.JPanel();
        panelBot1 = new javax.swing.JPanel();
        checkPenalized1 = new javax.swing.JCheckBox();
        checkBroken1 = new javax.swing.JCheckBox();
        checkDefensive1 = new javax.swing.JCheckBox();
        textComments1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textTeam1 = new javax.swing.JTextField();
        panelBot3 = new javax.swing.JPanel();
        checkDefensive3 = new javax.swing.JCheckBox();
        checkBroken3 = new javax.swing.JCheckBox();
        checkPenalized3 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        textComments3 = new javax.swing.JTextField();
        textTeam3 = new javax.swing.JTextField();
        panelBot2 = new javax.swing.JPanel();
        checkBroken2 = new javax.swing.JCheckBox();
        checkDefensive2 = new javax.swing.JCheckBox();
        checkPenalized2 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        textComments2 = new javax.swing.JTextField();
        textTeam2 = new javax.swing.JTextField();
        checkBlueAlliance = new javax.swing.JCheckBox();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitle.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        labelTitle.setText("Team 955 Scouting!");

        btSubmit.setText("Submit");
        btSubmit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSubmitActionPerformed(evt);
            }
        });

        textScore.setColumns(20);
        textScore.setRows(5);
        jScrollPane2.setViewportView(textScore);

        labelScore.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelScore.setText("Teleop = Lowercase, Autonomous = Uppercase");

        javax.swing.GroupLayout panelScoreLayout = new javax.swing.GroupLayout(panelScore);
        panelScore.setLayout(panelScoreLayout);
        panelScoreLayout.setHorizontalGroup(
            panelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelScoreLayout.setVerticalGroup(
            panelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );

        labelMatchNumber.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelMatchNumber.setText("Match Number:");

        textMatchNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textMatchNumber.setText("1");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(labelMatchNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textMatchNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMatchNumber)
                    .addComponent(textMatchNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        checkRedAlliance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        checkRedAlliance.setForeground(new java.awt.Color(222, 0, 0));
        checkRedAlliance.setText("Red Alliance");
        checkRedAlliance.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkRedAllianceActionPerformed(evt);
            }
        });

        checkPenalized1.setText("Penalized?");
        checkPenalized1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkPenalized1ActionPerformed(evt);
            }
        });

        checkBroken1.setText("Broken?");

        checkDefensive1.setText("Defensive ?");
        checkDefensive1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkDefensive1ActionPerformed(evt);
            }
        });

        textComments1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textComments1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Comments");

        textTeam1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textTeam1.setText("Bot 1#");
        textTeam1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textTeam1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBot1Layout = new javax.swing.GroupLayout(panelBot1);
        panelBot1.setLayout(panelBot1Layout);
        panelBot1Layout.setHorizontalGroup(
            panelBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBot1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBot1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(checkBroken1)
                        .addGap(213, 213, 213))
                    .addGroup(panelBot1Layout.createSequentialGroup()
                        .addGroup(panelBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkPenalized1)
                            .addComponent(jLabel4)
                            .addComponent(textTeam1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkDefensive1)
                            .addComponent(textComments1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBot1Layout.setVerticalGroup(
            panelBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBot1Layout.createSequentialGroup()
                .addComponent(textTeam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkDefensive1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkPenalized1)
                .addGap(9, 9, 9)
                .addComponent(checkBroken1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textComments1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        checkDefensive3.setText("Defensive ?");
        checkDefensive3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkDefensive3ActionPerformed(evt);
            }
        });

        checkBroken3.setText("Broken?");

        checkPenalized3.setText("Penalized?");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Comments");

        textComments3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textComments3ActionPerformed(evt);
            }
        });

        textTeam3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textTeam3.setText("Bot 3#");
        textTeam3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textTeam3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBot3Layout = new javax.swing.GroupLayout(panelBot3);
        panelBot3.setLayout(panelBot3Layout);
        panelBot3Layout.setHorizontalGroup(
            panelBot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBot3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTeam3)
                    .addGroup(panelBot3Layout.createSequentialGroup()
                        .addGroup(panelBot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkDefensive3)
                            .addComponent(checkBroken3)
                            .addComponent(textComments3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(checkPenalized3))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBot3Layout.setVerticalGroup(
            panelBot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBot3Layout.createSequentialGroup()
                .addComponent(textTeam3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkDefensive3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkPenalized3)
                .addGap(8, 8, 8)
                .addComponent(checkBroken3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textComments3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        checkBroken2.setText("Broken?");

        checkDefensive2.setText("Defensive ?");
        checkDefensive2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkDefensive2ActionPerformed(evt);
            }
        });

        checkPenalized2.setText("Penalized?");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Comments");

        textComments2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textComments2ActionPerformed(evt);
            }
        });

        textTeam2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textTeam2.setText("Bot 2#");
        textTeam2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textTeam2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBot2Layout = new javax.swing.GroupLayout(panelBot2);
        panelBot2.setLayout(panelBot2Layout);
        panelBot2Layout.setHorizontalGroup(
            panelBot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBot2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTeam2)
                    .addGroup(panelBot2Layout.createSequentialGroup()
                        .addGroup(panelBot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkDefensive2)
                            .addComponent(checkBroken2)
                            .addComponent(checkPenalized2)
                            .addComponent(textComments2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBot2Layout.setVerticalGroup(
            panelBot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBot2Layout.createSequentialGroup()
                .addComponent(textTeam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkDefensive2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkPenalized2)
                .addGap(8, 8, 8)
                .addComponent(checkBroken2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textComments2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBotsLayout = new javax.swing.GroupLayout(panelBots);
        panelBots.setLayout(panelBotsLayout);
        panelBotsLayout.setHorizontalGroup(
            panelBotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBot1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotsLayout.setVerticalGroup(
            panelBotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelBot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelBot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        checkBlueAlliance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        checkBlueAlliance.setForeground(new java.awt.Color(0, 0, 222));
        checkBlueAlliance.setText("Blue Alliance");
        checkBlueAlliance.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkBlueAllianceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkRedAlliance, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBlueAlliance, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panelScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkRedAlliance)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBlueAlliance)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkDefensive1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDefensive1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDefensive1ActionPerformed

    private void checkDefensive2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDefensive2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDefensive2ActionPerformed

    private void checkDefensive3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDefensive3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDefensive3ActionPerformed

    private void btSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmitActionPerformed
        // TODO add your handling code here:
        int response = showOptionBox("Just Making Sure!", "Are you sure you entered the data right?", "Yes I Did", "Nope, I did not :(");
        
        if(response == JOptionPane.YES_OPTION)
        {
            submitData();
            resetData();
        }
    }//GEN-LAST:event_btSubmitActionPerformed

    private void textTeam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTeam1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTeam1ActionPerformed

    private void textTeam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTeam2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTeam2ActionPerformed

    private void textTeam3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTeam3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTeam3ActionPerformed

    private void checkRedAllianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRedAllianceActionPerformed
        // TODO add your handling code here:
        if(!checkRedAlliance.isSelected() && !checkBlueAlliance.isSelected())
            checkRedAlliance.setSelected(true);
        
        if(checkRedAlliance.isSelected())
            setColor(Config.red);
    }//GEN-LAST:event_checkRedAllianceActionPerformed

    private void checkPenalized1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPenalized1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkPenalized1ActionPerformed

    private void textComments1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_textComments1ActionPerformed
    {//GEN-HEADEREND:event_textComments1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textComments1ActionPerformed

    private void textComments2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_textComments2ActionPerformed
    {//GEN-HEADEREND:event_textComments2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textComments2ActionPerformed

    private void textComments3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_textComments3ActionPerformed
    {//GEN-HEADEREND:event_textComments3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textComments3ActionPerformed

    private void checkBlueAllianceActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_checkBlueAllianceActionPerformed
    {//GEN-HEADEREND:event_checkBlueAllianceActionPerformed
        // TODO add your handling code here:
        if(!checkRedAlliance.isSelected() && !checkBlueAlliance.isSelected())
            checkBlueAlliance.setSelected(true);
        
        if(checkBlueAlliance.isSelected())
            setColor(Config.blue);
        
    }//GEN-LAST:event_checkBlueAllianceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JCheckBox checkBlueAlliance;
    private javax.swing.JCheckBox checkBroken1;
    private javax.swing.JCheckBox checkBroken2;
    private javax.swing.JCheckBox checkBroken3;
    private javax.swing.JCheckBox checkDefensive1;
    private javax.swing.JCheckBox checkDefensive2;
    private javax.swing.JCheckBox checkDefensive3;
    private javax.swing.JCheckBox checkPenalized1;
    private javax.swing.JCheckBox checkPenalized2;
    private javax.swing.JCheckBox checkPenalized3;
    private javax.swing.JCheckBox checkRedAlliance;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelMatchNumber;
    private javax.swing.JLabel labelScore;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelBot1;
    private javax.swing.JPanel panelBot2;
    private javax.swing.JPanel panelBot3;
    private javax.swing.JPanel panelBots;
    private javax.swing.JPanel panelScore;
    private javax.swing.JTextField textComments1;
    private javax.swing.JTextField textComments2;
    private javax.swing.JTextField textComments3;
    private javax.swing.JTextField textMatchNumber;
    private javax.swing.JTextArea textScore;
    private javax.swing.JTextField textTeam1;
    private javax.swing.JTextField textTeam2;
    private javax.swing.JTextField textTeam3;
    // End of variables declaration//GEN-END:variables
}
