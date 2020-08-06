package frames;

import data.Answer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.primefaces.json.JSONException;

public class Questions extends javax.swing.JFrame implements ActionListener {
    
// Variables declaration - do not modify                     
    private javax.swing.JButton BPass;
    private javax.swing.JButton BSubmit;
    private javax.swing.JLabel Lheader;
    private javax.swing.ButtonGroup radio;
    private javax.swing.JRadioButton RBa1;
    private javax.swing.JRadioButton RBa2;
    private javax.swing.JRadioButton RBa3;
    private javax.swing.JRadioButton RBa4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Timer timer;

    
    List<Answer> questions;
    List<Answer> answered;
    // End of variables declaration 
    Answer question;
    public Questions(List<Answer> q) {
        this.setVisible(true);
        questions=q;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        radio= new javax.swing.ButtonGroup();
        RBa1 = new javax.swing.JRadioButton();
        RBa2 = new javax.swing.JRadioButton();
        RBa3 = new javax.swing.JRadioButton();
        RBa4 = new javax.swing.JRadioButton();
        BSubmit = new javax.swing.JButton();
        BPass = new javax.swing.JButton();
        Lheader = new javax.swing.JLabel();
        answered=new ArrayList<Answer>();
        timer= new Timer();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/login back.jpg"))); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(90, 60));
        
        question=questions.get(0);
        Lheader.setText(question.getIdQ().getQuestion());
        RBa1.setText(question.getIdQ().getA1());
        RBa1.setActionCommand(question.getIdQ().getA1());
        radio.add(RBa1);
        
        RBa2.setText(question.getIdQ().getA2());
        RBa2.setActionCommand(question.getIdQ().getA2());
        radio.add(RBa2);
        
        RBa3.setText(question.getIdQ().getA3());
        RBa3.setActionCommand(question.getIdQ().getA3());
        radio.add(RBa3);
        
        RBa4.setText(question.getIdQ().getA4());
        RBa4.setActionCommand(question.getIdQ().getA4());
        radio.add(RBa4);
        
        RBa1.setSelected(true);

        BSubmit.setText("submit");
        BSubmit.setActionCommand("Bsubmit");
        BSubmit.addActionListener(this);
                
         

        BPass.setText("pass");
        BPass.setActionCommand("Bpass");
        BPass.addActionListener(this);
       
        setLayout();
        pack();
        
        
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            timer.cancel(); //Terminate the timer thread
            terminate();
            JOptionPane.showMessageDialog(null, "Your time's up!", "Error",JOptionPane.ERROR_MESSAGE);
        }
        }, 5*60*1000);
        
        
    }  
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void setLayout()
    {
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBa2)
                            .addComponent(RBa3)
                            .addComponent(RBa4)
                            .addComponent(RBa1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Lheader, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(BSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BPass, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Lheader, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RBa1)
                        .addGap(18, 18, 18)
                        .addComponent(RBa2)
                        .addGap(18, 18, 18)
                        .addComponent(RBa3)
                        .addGap(18, 18, 18)
                        .addComponent(RBa4)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BSubmit)
                    .addComponent(BPass))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>
    
    private void BPassActionPerformed() 
    {    
        questions.add(new Answer(question));
        changeTexts(); 
    }                                     
    
    private void BSubmitActionPerformed() 
    {                          
        String[] options = new String[]{"OK", "Άκυρο"};
        int option = JOptionPane.showOptionDialog (null,"Είστε σίγουρος για την επιλογή σας?", "Δώστε μια επιλογή", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
       
        if (option != 0) return;
        question.submitAnswer(radio.getSelection().getActionCommand());               
        answered.add(new Answer(question));
        
        changeTexts();   
    } 
    
    private void changeTexts()
    {
        questions.remove(0); 
        if(questions.isEmpty())
        {
            terminate();
            return;
        
        }
        question=questions.get(0);
        
        Lheader.setText(question.getIdQ().getQuestion());
        RBa1.setText(question.getIdQ().getA1());
        RBa1.setActionCommand(question.getIdQ().getA1());
        
        RBa2.setText(question.getIdQ().getA2());
        RBa2.setActionCommand(question.getIdQ().getA2());
        
        RBa3.setText(question.getIdQ().getA3());
        RBa3.setActionCommand(question.getIdQ().getA3());

        RBa4.setText(question.getIdQ().getA4());
        RBa4.setActionCommand(question.getIdQ().getA4());
        
    }

    private void terminate()
    {
        try {
                if (!answered.isEmpty()) 
                {
                    for (int i = 0; i < answered.size(); i++) 
                           answered.get(i).terminate();
                }       
                
                this.setEnabled(false);
                JOptionPane.showMessageDialog(this,question.getIdP().getIdP().toString() , "You can find your results using your id:",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                
            } catch (JSONException | IOException | URISyntaxException ex) {
                Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource ();
        if(source instanceof javax.swing.JButton)
        {
            if (source == BSubmit)   
            {
                BSubmitActionPerformed();
            }
            if(source==BPass)
            {
                BPassActionPerformed();
            }

        }  
    }

                
}
