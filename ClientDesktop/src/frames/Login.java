
package frames;

import data.Answer;
import data.Examinee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.primefaces.json.JSONException;

public class Login extends JFrame  implements ActionListener{
// Variables declaration - do not modify                     
    private javax.swing.JButton BSignin;
    private javax.swing.JButton BSigninAdmin;
    private javax.swing.JLabel LName;
    private javax.swing.JLabel LPassword;
    private javax.swing.JLabel LPisture;
    private javax.swing.JLabel LSignin;
    private javax.swing.JLabel LUsername;
    private javax.swing.JPasswordField PFPassword;
    private javax.swing.JTextField TFName;
    private javax.swing.JTextField TFUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private MainDesktop main;
    // End of variables declaration    
    
    
    public Login(MainDesktop m) {
        main=m;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LSignin = new javax.swing.JLabel();
        LName = new javax.swing.JLabel();
        TFName = new javax.swing.JTextField();
        LUsername = new javax.swing.JLabel();
        TFUsername = new javax.swing.JTextField();
        LPassword = new javax.swing.JLabel();
        PFPassword = new javax.swing.JPasswordField();
        LPisture = new javax.swing.JLabel();
        BSigninAdmin = new javax.swing.JButton();
        BSignin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        LSignin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LSignin.setText("Sign in");

        LName.setForeground(new java.awt.Color(0, 0, 51));
        LName.setText("Name and Surname");


        LUsername.setForeground(new java.awt.Color(0, 0, 51));
        LUsername.setText("Username");


        LPassword.setForeground(new java.awt.Color(0, 0, 51));
        LPassword.setText("Password");

        LPisture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/login back.jpg"))); // NOI18N
        

        BSigninAdmin.setText("Sign in as Administrator");
        BSigninAdmin.addActionListener(this);

        BSignin.setText("Sing in");
        BSignin.addActionListener(this);
            

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFUsername)
                    .addComponent(LUsername)
                    .addComponent(LName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LSignin)
                    .addComponent(LPassword)
                    .addComponent(TFName)
                    .addComponent(PFPassword)
                    .addComponent(BSignin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BSigninAdmin)
                    .addComponent(LPisture, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LSignin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(LName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(LUsername)
                        .addGap(4, 4, 4)
                        .addComponent(TFUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LPassword)
                        .addGap(11, 11, 11)
                        .addComponent(PFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LPisture, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BSigninAdmin)
                    .addComponent(BSignin))
                .addGap(21, 21, 21))
        );

        LSignin.getAccessibleContext().setAccessibleDescription("");

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
                .addGap(118, 118, 118)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void BSigninActionPerformed(java.awt.event.ActionEvent evt) 
    {                                               
            String a_name=TFName.getText();
            String a_user=TFUsername.getText();
            char[] tt=PFPassword.getPassword();
            String a_pass=new String(tt);
            
            if(a_name.equals("") || a_user.equals("") || a_pass.equals(""))
                JOptionPane.showMessageDialog (null, "Εχετε αφήσει κενό πεδίο. ",
                        "Συμπληρώστε όλα τα πεδία", JOptionPane.ERROR_MESSAGE);
            else
            {
               
                Examinee temp=new Examinee(null,a_name,a_user,a_pass,null);
                try {temp.existsUsername();
                }catch (IOException | JSONException ex) 
                {JOptionPane.showMessageDialog (null, "Δεν έχετε δώσει σωστά στοιχεία","Δώστε σωστά στοιχεία", JOptionPane.ERROR_MESSAGE); } 
                if(temp.getIdP()==null)
                    JOptionPane.showMessageDialog (null, "Δεν έχετε δώσει σωστά στοιχεία","Δώστε σωστά στοιχεία", JOptionPane.ERROR_MESSAGE);
                else
                try{   
                    this.setEnabled(false);
                    startExam(temp);
                } catch (IOException|JSONException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
           
    }                                       

    private void BAdminActionPerformed(java.awt.event.ActionEvent evt) 
    {                                       
        main.getLogin().setVisible(false);
        main.getLoginA().setVisible(true);

    }                                      

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource ();
            if(source instanceof javax.swing.JButton){
            if (source == BSignin)   
            {
                BSigninActionPerformed(e);
            }
            if(source==BSigninAdmin)
            {
                BAdminActionPerformed(e);
            }
            }
    }

    private void startExam(Examinee temp) throws JSONException, IOException {
        boolean flag=false;        

        while(!flag){
        LocalDateTime now=LocalDateTime.now();
        LocalDateTime exam=temp.getExamId().getExamDate();
        //LocalDateTime d2 = now.minus(Period.ofDays(1));
        LocalDateTime db = now.minus(Period.ofDays(1));
        LocalDateTime da = now.plus(Period.ofDays(1));
        System.out.println(db+" "+da+" "+now);
        if(exam.isAfter(db) && exam.isBefore(da))
        {
            flag=true;        
            Questions questions;
            questions=new Questions( Answer.prepareQuestions(5, temp));
        }
        else
            temp.setExamId(temp.getExamId().findbyId(temp.getExamId().getExamId()));
        }            

    }

                   
}
