
package frames;

import data.Administrator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.primefaces.json.JSONException;

/**
 *
 * @author User
 */
public class LoginAdmin extends javax.swing.JFrame implements ActionListener{

    
    // Variables declaration - do not modify 
    //private javax.swing.JComboBox<String> CBeCenter;
    private javax.swing.JButton BSignin;
    private javax.swing.JButton BSigninExaminee;
    private javax.swing.JLabel LPassword;
    private javax.swing.JLabel LPicture;
    private javax.swing.JLabel LSignin;
    private javax.swing.JLabel LUsername;
    private javax.swing.JPasswordField PFPassword;
    private javax.swing.JTextField TFUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private MainDesktop main;
    
    //List<ECenter> eCenters;
            
    // End of variables declaration     
    
    public LoginAdmin(MainDesktop m) {
        main=m;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LSignin = new javax.swing.JLabel();
        LUsername = new javax.swing.JLabel();
        TFUsername = new javax.swing.JTextField();
        LPassword = new javax.swing.JLabel();
        PFPassword = new javax.swing.JPasswordField();
        LPicture = new javax.swing.JLabel();
        BSigninExaminee = new javax.swing.JButton();
        BSignin = new javax.swing.JButton();
        //CBeCenter = new javax.swing.JComboBox<>();

        //eCenters=new ArrayList<ECenter>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        LSignin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LSignin.setText("Sign in");

        LUsername.setForeground(new java.awt.Color(0, 0, 51));
        LUsername.setText("Username");

        LPassword.setForeground(new java.awt.Color(0, 0, 51));
        LPassword.setText("Password");
        /*
        try {
            eCenters=ECenter.findAll();
        } catch (JSONException | IOException ex) {
            Logger.getLogger(LoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] temp = new String[eCenters.size()+1];
        int i=0;
        for(ECenter ecenter:eCenters)
        {
            temp[i]=new String(ecenter.getECenterName());
            i++;
        }
        temp[i]="";
        CBeCenter.setModel(new javax.swing.DefaultComboBoxModel<>(temp));
        CBeCenter.setSelectedIndex(1);*/

        LPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/login back2.jpg"))); // NOI18N
        LPicture.setMaximumSize(new java.awt.Dimension(100, 60));
        LPicture.setPreferredSize(new java.awt.Dimension(90, 60));

        BSigninExaminee.setText("Sign in as Examinee");
        BSigninExaminee.addActionListener(this);

        BSignin.setText("Sing in");
        BSignin.addActionListener(this);
        
        
        
        setlayout();

        pack();
    }// </editor-fold>                        

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void setlayout()
   {
       javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TFUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LSignin)
                                    .addComponent(BSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(LUsername)
                                    .addGap(47, 47, 47)))
                            .addComponent(LPassword)
                            .addComponent(PFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BSigninExaminee)
                            .addComponent(LPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LSignin)
                        .addGap(30, 30, 30)
                        .addComponent(LUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(LPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                        .addComponent(LPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BSigninExaminee)
                    .addComponent(BSignin))
                .addGap(21, 21, 21))
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
   }// </editor-fold>
    
   
   private void BSigninActionPerformed(ActionEvent e)
   {
            String a_user=TFUsername.getText();
            //String a_center = CBeCenter.getSelectedItem().toString();   
            char[] tt=PFPassword.getPassword();
            String a_pass=new String(tt);
            
            if(a_user.equals("") || a_pass.equals(""))
                JOptionPane.showMessageDialog (null, "Εχετε αφήσει κενό πεδίο. ","Συμπληρώστε όλα τα πεδία", JOptionPane.ERROR_MESSAGE);
            else
            {
               
                Administrator temp=new Administrator(null,a_user,a_pass);
                try {
                    temp.existsUsername();
                }catch (IOException | JSONException ex) 
                {JOptionPane.showMessageDialog (null, "Δεν έχετε δώσει σωστά στοιχεία","Δώστε σωστά στοιχεία", JOptionPane.ERROR_MESSAGE); return;} 
                
                if(temp.getIdP()==null)
                    JOptionPane.showMessageDialog (null, "Δεν έχετε δώσει σωστά στοιχεία","Δώστε σωστά στοιχεία", JOptionPane.ERROR_MESSAGE);
                else
                {
                    Menu menu=new Menu(temp);
                }
            } 
   }
   
   
   private void BExamineeActionPerformed(ActionEvent e)
   {       
       main.getLoginA().setVisible(false);
       main.getLogin().setVisible(true);
   }
   
   @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource ();
            if(source instanceof javax.swing.JButton){
            if (source == BSignin)   
            {
                BSigninActionPerformed(e);
                return;
            }
            if(source==BSigninExaminee)
            {
                BExamineeActionPerformed(e);
                return;
            }
            
            }
    }          
}
