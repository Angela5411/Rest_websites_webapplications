
package frames;

import data.Examinee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CreateExaminee extends javax.swing.JFrame implements ActionListener{

    
    // Variables declaration - do not modify                     
    private javax.swing.JButton BSignin;
    private javax.swing.JLabel LCreate;
    private javax.swing.JLabel LName;
    private javax.swing.JLabel LPassword;
    private javax.swing.JLabel LPicture;
    private javax.swing.JLabel LUsername;
    private javax.swing.JPasswordField PFPassword;
    private javax.swing.JTextField TFName;
    private javax.swing.JTextField TFUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Examinee examinee;
    // End of variables declaration 
    
    
    public CreateExaminee() {
        this.setVisible(true);
        initComponents();
    }
    public CreateExaminee(Examinee e)
    {
        examinee=e;
        this.setVisible(true);
        initComponents();
        setDefault();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LCreate = new javax.swing.JLabel();
        LName = new javax.swing.JLabel();
        TFName = new javax.swing.JTextField();
        LUsername = new javax.swing.JLabel();
        TFUsername = new javax.swing.JTextField();
        LPassword = new javax.swing.JLabel();
        PFPassword = new javax.swing.JPasswordField();
        LPicture = new javax.swing.JLabel();
        BSignin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        LCreate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LCreate.setText("Create");

        LName.setForeground(new java.awt.Color(0, 0, 51));
        LName.setText("Name and Surname");


        LUsername.setForeground(new java.awt.Color(0, 0, 51));
        LUsername.setText("Username");


        LPassword.setForeground(new java.awt.Color(0, 0, 51));
        LPassword.setText("Password");

        LPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/login back.jpg"))); // NOI18N
        LPicture.setMaximumSize(new java.awt.Dimension(100, 60));
        LPicture.setPreferredSize(new java.awt.Dimension(90, 60));

        BSignin.setText("Sing in");
        BSignin.addActionListener(this);

        setLayout();
        pack();
    }                  

    private void setDefault()
    {
        TFName.setText(examinee.getName());
        TFUsername.setText(examinee.getUsername());
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void setLayout()
    {
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TFUsername)
                        .addComponent(LUsername)
                        .addComponent(LName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LCreate)
                        .addComponent(LPassword)
                        .addComponent(TFName)
                        .addComponent(PFPassword)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(LPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
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
                        .addComponent(PFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(BSignin)))
                .addGap(29, 29, 29))
        );

        LCreate.getAccessibleContext().setAccessibleDescription("");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>      
    
    
    private void BSigninActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
        
            String a_name=TFName.getText();
            String a_user=TFUsername.getText();
            char[] tt=PFPassword.getPassword();
            String a_pass=new String(tt);
            if(a_name.equals("") || a_user.equals("") || tt.equals(""))
            {
                JOptionPane.showMessageDialog (null, "Εχετε αφήσει κενό πεδίο. ",
                        "Συμπληρώστε όλα τα πεδία", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //periptwsh dhmiourgias
            if(examinee==null)
            {
                examinee=new Examinee(a_name,a_user,a_pass);
                createExaminee();
                
            }
            //periptwsh epe3ergasias
            else
            {
                examinee.setName(a_name);
                examinee.setPasswordHash(a_pass);
                //ean allazei to username
                if(!examinee.getUsername().equals(a_user))
                {
                    changeUsername();
                    return;
                }
                //ean paramenei idio
                examinee.setUsername(a_user);
                try {
                    examinee.updateExaminee();
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog (null, "Υπήρξε λάθος κατά δημιουργία του Εξεταζόμενου. ",
                            "Σφάλμα", JOptionPane.ERROR_MESSAGE); 
                }
            }
    }                                       

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object source= e.getSource ();
        if(source instanceof javax.swing.JButton){
            if (source == BSignin)   
            {
                BSigninActionPerformed(e);
                return;
            }
            
        }
    }

    private void createExaminee() 
    {
        try {
            examinee.existsUsername();
            {JOptionPane.showMessageDialog (null, "Εμφανίστηκε άλλο άτομο με το ίδιο username",
                    "Σφάλμα κατά δημιουργία του Εξεταζόμενου.", JOptionPane.ERROR_MESSAGE);}
        } catch (Exception ex) {
            try {
                examinee.terminate();
                JOptionPane.showMessageDialog (null, "Επιτυχία",
                    "Η ενημέρωση ολοκληρώθηκε", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e)
            {JOptionPane.showMessageDialog (null, "Υπήρξε λάθος κατά δημιουργία του Εξεταζόμενου. ",
                    "Σφάλμα", JOptionPane.ERROR_MESSAGE);
            }
        }    
    }

    private void changeUsername() 
    {
        try{
            examinee.existsUsername();
            {JOptionPane.showMessageDialog (null, "Εμφανίστηκε άλλο άτομο με το ίδιο username",
                    "Σφάλμα κατά δημιουργία του Εξεταζόμενου.", JOptionPane.ERROR_MESSAGE);}
            return;
        }catch(Exception e){
            try {
                examinee.updateExaminee();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog (null, "Υπήρξε λάθος κατά δημιουργία του Εξεταζόμενου. ",
                "Σφάλμα", JOptionPane.ERROR_MESSAGE);}
        }    
    }


}



