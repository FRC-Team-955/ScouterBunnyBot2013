
package scouting;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fauzi
 */
public class Form extends javax.swing.JFrame 
{
    private int m_matchNumber = 0;
    private String m_color = "blue";
    private FileWriter m_writer;
    private FileReader m_reader;
    private Bot[] m_bots = new Bot[Config.amountOfBots];
    private JTextField[] m_textTeam;
    private JTextField[] m_textTags;
    
    /**
     * Creates new form Form
     */
    public Form() 
    {
        initComponents(); 
        m_textTeam = new JTextField[]{textTeam1, textTeam2, textTeam3};
        m_textTags = new JTextField[]{textTags1, textTags2, textTags3};
        resetData();
        initTeamColor();
        writeBotDataFormat();
        Object[] headers = (Object[])Util.splitString(Config.botDataFormat, ",");
        DefaultTableModel tableModel = new DefaultTableModel(headers, 0);
        tableData = new JTable(tableModel);
        
        for(Object data : headers)
            tableModel.addColumn(data);
    }
        
    public void writeBotDataFormat()
    {
        openFile(Config.botDataFormatFileName);
        
        try
        {    
            m_writer.append(Config.botDataFormat);
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        closeFile();
    }
    /**
     * Exports to .csv file.
     * @param directory
     */
     public void openFile(String directory)
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
     
    public void writeBotData(String botData)
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
     
    public void closeFile()
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
            m_textTeam[index].setText("Bot #" + (index + 1));
            m_textTags[index].setText("");
            m_bots[index] = new Bot();
        }
        
        textScore.setText("");
        textMatchNumber.setText(String.valueOf(++m_matchNumber));
    }
    
    public void submitData()
    {
        for(int index = 0; index < Config.amountOfBots; index++)
        {
            m_bots[index].m_number = m_textTeam[index].getText();
            m_bots[index].parseTags(m_textTags[index].getText());
        }
        
        String scoreData = textScore.getText();
        
        for(int botIndex = 0; botIndex < Config.botKeysTeleop.length; botIndex++)
        {
            for(int dataIndex = 0; dataIndex < scoreData.length(); dataIndex++)
            {    
                if(Config.botKeysTeleop[botIndex] == scoreData.charAt(dataIndex))  // Lowercase = teleop
                    m_bots[botIndex].m_scoreTeleop++;

                else if(Config.botKeysAuto[botIndex] == scoreData.charAt(dataIndex))  // Uppercase = Autonomous
                    m_bots[botIndex].m_scoreAuto++;
            }
        }      
        
        try
        {
            m_matchNumber = Integer.parseInt(textMatchNumber.getText());
        }
        
        catch(NumberFormatException e){}
        
        String matchNumber = String.valueOf(m_matchNumber);
        
        // Open file
        openFile(Config.matchFileName + matchNumber  + m_color + ".csv");
        
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
        
        for(int i = 0; i < Config.amountOfBots; i++)
            m_textTeam[i].setForeground(color);
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
    
    public void setTableData(File file)
    {
        try
        {
            m_reader = new FileReader(file);
            DefaultTableModel tableModel = new DefaultTableModel(Util.splitString(Config.botDataFormat, ","), 0);
            tableBotData = new JTable(tableModel);
        }
         
        catch(IOException e)
        {
            e.printStackTrace();
        }
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        labelMatchNumber = new javax.swing.JLabel();
        textMatchNumber = new javax.swing.JTextField();
        btSubmit = new javax.swing.JButton();
        panelBots = new javax.swing.JPanel();
        panelBot1 = new javax.swing.JPanel();
        textTags1 = new javax.swing.JTextField();
        jLable4 = new javax.swing.JLabel();
        textTeam1 = new javax.swing.JTextField();
        panelBot2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textTags2 = new javax.swing.JTextField();
        textTeam2 = new javax.swing.JTextField();
        panelBot3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        textTags3 = new javax.swing.JTextField();
        textTeam3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        panelScore = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textScore = new javax.swing.JTextArea();
        labelScore = new javax.swing.JLabel();
        panelScore1 = new javax.swing.JPanel();
        checkBlueAlliance = new javax.swing.JCheckBox();
        checkRedAlliance = new javax.swing.JCheckBox();
        labelTitle = new javax.swing.JLabel();
        btWriteBotDataFormat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableBotData = new javax.swing.JTable();
        fileChooser = new javax.swing.JFileChooser();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();

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

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelMatchNumber.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelMatchNumber.setText("Match Number:");

        textMatchNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textMatchNumber.setText("1");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(labelMatchNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textMatchNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMatchNumber)
                    .addComponent(textMatchNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btSubmit.setText("Submit");
        btSubmit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSubmitActionPerformed(evt);
            }
        });

        panelBots.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBots.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textTags1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textTags1ActionPerformed(evt);
            }
        });

        jLable4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLable4.setText("Tags");

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
                    .addComponent(textTags1)
                    .addGroup(panelBot1Layout.createSequentialGroup()
                        .addGroup(panelBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTeam1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLable4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBot1Layout.setVerticalGroup(
            panelBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBot1Layout.createSequentialGroup()
                .addComponent(textTeam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLable4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textTags1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBots.add(panelBot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 110));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tags");

        textTags2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textTags2ActionPerformed(evt);
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
                    .addComponent(textTags2)
                    .addGroup(panelBot2Layout.createSequentialGroup()
                        .addGroup(panelBot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTeam2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBot2Layout.setVerticalGroup(
            panelBot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBot2Layout.createSequentialGroup()
                .addComponent(textTeam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textTags2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBots.add(panelBot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 430, 110));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tags");

        textTags3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textTags3ActionPerformed(evt);
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
                    .addComponent(textTags3)
                    .addGroup(panelBot3Layout.createSequentialGroup()
                        .addGroup(panelBot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTeam3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBot3Layout.setVerticalGroup(
            panelBot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBot3Layout.createSequentialGroup()
                .addComponent(textTeam3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textTags3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBots.add(panelBot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 430, 110));
        panelBots.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 450, 10));
        panelBots.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 450, 10));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Legend");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Tags\n\n1: Defensive Strategy\n2: Herds Balls\n3: Can pick up balls\n4: Selective of goal color\n5: Not functioning");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Teleop\n\na: Bot 1 scored \ng: Bot 2 scored\nl: Bot 3 scored");
        jScrollPane3.setViewportView(jTextArea2);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("Autonomous\n\nA: Bot 1 scored \nG: Bot 2 scored\nL: Bot 3 scored");
        jScrollPane4.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelScore.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                    .addComponent(labelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelScoreLayout.setVerticalGroup(
            panelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelScore1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        javax.swing.GroupLayout panelScore1Layout = new javax.swing.GroupLayout(panelScore1);
        panelScore1.setLayout(panelScore1Layout);
        panelScore1Layout.setHorizontalGroup(
            panelScore1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScore1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelScore1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkRedAlliance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkBlueAlliance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelScore1Layout.setVerticalGroup(
            panelScore1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScore1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkRedAlliance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBlueAlliance)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelTitle.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        labelTitle.setText("Team 955 Scouting!");

        btWriteBotDataFormat.setText("Write Bot Data Format");
        btWriteBotDataFormat.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btWriteBotDataFormatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(panelScore1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(btWriteBotDataFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelScore1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panelScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panelBots, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btWriteBotDataFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Writing", jPanel2);

        tableBotData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        jScrollPane5.setViewportView(tableBotData);

        fileChooser.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                fileChooserActionPerformed(evt);
            }
        });

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tableData);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reading", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void textTags1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_textTags1ActionPerformed
    {//GEN-HEADEREND:event_textTags1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTags1ActionPerformed

    private void textTags2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_textTags2ActionPerformed
    {//GEN-HEADEREND:event_textTags2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTags2ActionPerformed

    private void textTags3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_textTags3ActionPerformed
    {//GEN-HEADEREND:event_textTags3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTags3ActionPerformed

    private void checkBlueAllianceActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_checkBlueAllianceActionPerformed
    {//GEN-HEADEREND:event_checkBlueAllianceActionPerformed
        // TODO add your handling code here:
        if(!checkRedAlliance.isSelected() && !checkBlueAlliance.isSelected())
            checkBlueAlliance.setSelected(true);
        
        if(checkBlueAlliance.isSelected())
            setColor(Config.blue);
        
    }//GEN-LAST:event_checkBlueAllianceActionPerformed

    private void btWriteBotDataFormatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btWriteBotDataFormatActionPerformed
    {//GEN-HEADEREND:event_btWriteBotDataFormatActionPerformed
        // TODO add your handling code here:
        writeBotDataFormat();
    }//GEN-LAST:event_btWriteBotDataFormatActionPerformed

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_fileChooserActionPerformed
    {//GEN-HEADEREND:event_fileChooserActionPerformed
        // TODO add your handling code here:
        File file = fileChooser.getSelectedFile();
        System.out.println(file.getName() + " " + evt.getActionCommand());
        setTableData(file);
    }//GEN-LAST:event_fileChooserActionPerformed

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
    private javax.swing.JButton btWriteBotDataFormat;
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
    private javax.swing.JCheckBox checkRedAlliance;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLable4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel labelMatchNumber;
    private javax.swing.JLabel labelScore;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelBot1;
    private javax.swing.JPanel panelBot2;
    private javax.swing.JPanel panelBot3;
    private javax.swing.JPanel panelBots;
    private javax.swing.JPanel panelScore;
    private javax.swing.JPanel panelScore1;
    private javax.swing.JTable tableBotData;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField textMatchNumber;
    private javax.swing.JTextArea textScore;
    private javax.swing.JTextField textTags1;
    private javax.swing.JTextField textTags2;
    private javax.swing.JTextField textTags3;
    private javax.swing.JTextField textTeam1;
    private javax.swing.JTextField textTeam2;
    private javax.swing.JTextField textTeam3;
    // End of variables declaration//GEN-END:variables
}
