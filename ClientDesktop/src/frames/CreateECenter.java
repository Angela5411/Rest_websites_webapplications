
package frames;

import data.Administrator;
import data.ECenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CreateECenter extends javax.swing.JFrame implements ActionListener{

    

    // Variables declaration - do not modify                     
    private javax.swing.JButton BSave;
    private javax.swing.JLabel LAddress;
    private javax.swing.JLabel LAdministrator;
    private javax.swing.JLabel LCreate;
    private javax.swing.JLabel LECenter;
    private javax.swing.JLabel LName;
    private javax.swing.JLabel LPassword;
    private javax.swing.JLabel LPicture;
    private javax.swing.JLabel LUsername;
    private javax.swing.JPasswordField PFPassword;
    private javax.swing.JTextField TFAddress;
    private javax.swing.JTextField TFName;
    private javax.swing.JTextField TFUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private ECenter ecenter;
    private Administrator admin;
    // End of variables declaration                   
    
    
    public CreateECenter() {
        this.setVisible(true);
        initComponents();
    }

    public CreateECenter(ECenter e,Administrator a)
    {
        ecenter=e;
        admin=a;
        this.setVisible(true);
        initComponents();
        setDefault();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LAdministrator = new javax.swing.JLabel();
        LName = new javax.swing.JLabel();
        TFName = new javax.swing.JTextField();
        LUsername = new javax.swing.JLabel();
        TFUsername = new javax.swing.JTextField();
        LPassword = new javax.swing.JLabel();
        PFPassword = new javax.swing.JPasswordField();
        LPicture = new javax.swing.JLabel();
        BSave = new javax.swing.JButton();
        LCreate = new javax.swing.JLabel();
        LAddress = new javax.swing.JLabel();
        TFAddress = new javax.swing.JTextField();
        LECenter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        LAdministrator.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LAdministrator.setText("Administrator");

        LName.setForeground(new java.awt.Color(0, 0, 51));
        LName.setText("Name");

        LUsername.setForeground(new java.awt.Color(0, 0, 51));
        LUsername.setText("Username");
        
        LPassword.setForeground(new java.awt.Color(0, 0, 51));
        LPassword.setText("Password");

        LPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/login back2.jpg"))); // NOI18N
        LPicture.setMaximumSize(new java.awt.Dimension(100, 60));
        LPicture.setPreferredSize(new java.awt.Dimension(90, 60));

        LCreate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LCreate.setText("Create");

        LAddress.setText("Διεύθυνση");

        TFAddress.setText("οδός αριθμός πόλη χώρα ταχυδρομικός κώδικας");

        LECenter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LECenter.setText("ECenter");
        
        BSave.setText("Save");
        BSave.addActionListener(this);
        
        setLayout();

        pack();
    }
    
    private void setDefault()
    {
        TFName.setText(ecenter.getECenterName());
        TFAddress.setText(ecenter.getECenterAddress());
        
        TFUsername.setText(admin.getUsername());
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LPassword)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BSave, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(PFPassword))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LUsername)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LECenter, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TFAddress)
                                        .addComponent(LCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LAdministrator, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFName)))))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addComponent(LPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LECenter, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LAddress)
                            .addComponent(TFAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LAdministrator, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TFUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LPassword)
                            .addComponent(PFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(LPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(BSave))
        );

        LAdministrator.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold> 
    
    private void BSaveActionPerformed(java.awt.event.ActionEvent evt) 
    {                                      

            String c_address=TFAddress.getText();
            String c_name=TFName.getText();
            String a_user=TFUsername.getText();
            char[] tt=PFPassword.getPassword();
            String a_pass=new String(tt);
            
            if(c_address.equals("") || c_name.equals(""))
            {
                JOptionPane.showMessageDialog (null, "Εχετε αφήσει κενό πεδίο. ",
                "Συμπληρώστε όλα τα πεδία που αφορούν το κέντρο", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(a_user.equals("") || a_pass.equals(""))
            {
                JOptionPane.showMessageDialog (null, "Εχετε αφήσει κενό πεδίο. ",
                "Συμπληρώστε όλα τα πεδία που αφορούν τον διαχειριστή", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            //ean dhmiourgei 
            if(ecenter==null && admin==null)
            {
                ecenter=new ECenter(c_name,c_address);
                admin=new Administrator(a_user,a_pass);
                try {
                    ecenter.terminate();                
                    ecenter=ecenter.findbyΝame(c_name);
                } catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog (null, "Υπήρχε λάθος κατά την δημιουργεία του κέντρου",
                    "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                }
                try{
                    admin.setECenterId(ecenter);
                    admin.terminate();
                }catch(Exception e){
                    JOptionPane.showMessageDialog (null, "Εχετε αφήσει κενό πεδίο. ",
                    "Συμπληρώστε όλα τα πεδία που αφορούν τον διαχειριστή", JOptionPane.ERROR_MESSAGE);
                }
            }else
            {//ean to name allazei
                ecenter.setECenterAddress(c_address);
                if(!ecenter.getECenterName().equals(c_name))
                {
                    changeName(c_name);
                    return;
                }
                //ean den allazei
                ecenter.setECenterName(c_name);
                try {
                    ecenter.updateECenter();
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog (null, "Υπήρξε λάθος κατά δημιουργία του κέντρου. ",
                            "Σφάλμα", JOptionPane.ERROR_MESSAGE); 
                }
                
            //ean to username allazei
                admin.setECenterId(ecenter);
                admin.setPasswordHash(a_pass);
                if(!admin.getUsername().equals(a_user))
                {
                    changeUsername(a_user);
                    return;
                }
                admin.setUsername(a_user);
                try{
                    admin.updateAdministrator();
                }catch(Exception ex) {
                        JOptionPane.showMessageDialog (null, "Υπήρξε λάθος κατά δημιουργία του Διαχειριστή. ",
                            "Σφάλμα", JOptionPane.ERROR_MESSAGE); 
                }
            }

    }                                     
                                         

    private void changeName(String name)
    {
        try{
            ecenter.findbyΝame(name);
            {JOptionPane.showMessageDialog (null, "Εμφανίστηκε άλλο κέντρο με το ίδιο name",
                    "Σφάλμα κατά δημιουργία του Κέντρου.", JOptionPane.ERROR_MESSAGE);}
            return;
        }catch(Exception e){
            try {
                ecenter.updateECenter();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog (null, "Υπήρξε λάθος κατά δημιουργία του Κέντρου. ",
                "Σφάλμα", JOptionPane.ERROR_MESSAGE);}
        }   
    }
    
    private void changeUsername(String username)
    {
        try{
            admin.findbyUsername(username);
            {JOptionPane.showMessageDialog (null, "Εμφανίστηκε άλλο κέντρο με το ίδιο username",
                    "Σφάλμα κατά δημιουργία του Διαχειριστή.", JOptionPane.ERROR_MESSAGE);}
            return;
        }catch(Exception e){
            try {
                ecenter.updateECenter();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog (null, "Υπήρξε λάθος κατά δημιουργία του Διαχειριστή. ",
                "Σφάλμα", JOptionPane.ERROR_MESSAGE);}
        }  
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object source= e.getSource ();
        if(source instanceof javax.swing.JButton){
            if (source == BSave)   
            {
                BSaveActionPerformed(e);
                return;
            }
        }
    }

}
