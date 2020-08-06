package frames;

import data.ECenter;
import data.Exam;
import data.Examinee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.primefaces.json.JSONException;

public class AddExamineestoExam extends javax.swing.JFrame implements ActionListener{

    // Variables declaration - do not modify                     
    private javax.swing.JButton BSave;
    private javax.swing.JButton BSearchExaminee;
    private javax.swing.JComboBox<String> CBCenters;
    private javax.swing.JComboBox<String> CBIdCenter;
    private javax.swing.JLabel LCId;
    private javax.swing.JLabel LCenter;
    private javax.swing.JLabel LCreateExam;
    private javax.swing.JLabel LEid;
    private javax.swing.JLabel LExam;
    private javax.swing.JLabel LExaminee;
    private javax.swing.JLabel LJunction;
    private javax.swing.JLabel LPicture;
    private javax.swing.JLabel LUsername;
    private javax.swing.JTextField TFEid;
    private javax.swing.JTextField TFUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    
    Examinee examinee;
    Exam exam;
    List<ECenter> centers;
    List<Exam> exams;
    // End of variables declaration    
    
    public AddExamineestoExam() {
        initComponents();        
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LJunction = new javax.swing.JLabel();
        LPicture = new javax.swing.JLabel();
        LExaminee = new javax.swing.JLabel();
        TFUsername = new javax.swing.JTextField();
        LUsername = new javax.swing.JLabel();
        LEid = new javax.swing.JLabel();
        TFEid = new javax.swing.JTextField();
        LExam = new javax.swing.JLabel();
        LCId = new javax.swing.JLabel();
        BSave = new javax.swing.JButton();
        CBIdCenter = new javax.swing.JComboBox<>();
        LCreateExam = new javax.swing.JLabel();
        CBCenters = new javax.swing.JComboBox<>();
        LCenter = new javax.swing.JLabel();
        BSearchExaminee = new javax.swing.JButton();

        centers=new ArrayList<ECenter>();
        exams=new ArrayList<Exam>();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        LJunction.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LJunction.setText("Junction");

        LPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/login back2.jpg"))); // NOI18N
        LPicture.setMaximumSize(new java.awt.Dimension(100, 60));
        LPicture.setPreferredSize(new java.awt.Dimension(90, 60));

        LExaminee.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LExaminee.setText("Find the Examinee. ");


        LUsername.setForeground(new java.awt.Color(0, 0, 51));
        LUsername.setText("Username");

        LEid.setForeground(new java.awt.Color(0, 0, 51));
        LEid.setText("id");

        LExam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LExam.setText("Find the Exam. ");

        LCId.setForeground(new java.awt.Color(0, 0, 51));
        LCId.setText("id-center");

        BSave.setText("Save");
        BSave.addActionListener(this);

        
        try {
            centers=ECenter.findAll();
        } catch (JSONException | IOException ex) {
        }
        String[] tempc = new String[centers.size()+1];
        tempc[0]="";
        int i=1;
        for(ECenter ecenter:centers)
        {
            tempc[i]=new String(ecenter.getECenterName());
            i++;
        }
        CBCenters.setModel(new javax.swing.DefaultComboBoxModel<>(tempc));
        CBCenters.setSelectedIndex(0);
        
        
        
        try {
            exams=Exam.findAll();
        } catch (JSONException | IOException ex) {
        }        
        String[] tempe = new String[exams.size()+1];
        tempe[0]="";
        i=1;
        for(Exam exam:exams)
        {
            tempe[i]=new String(exam.getExamId()+" "+exam.getECenterId().getECenterName());
            i++;
        }
        CBIdCenter.setModel(new javax.swing.DefaultComboBoxModel<>(tempe));
        CBIdCenter.setSelectedIndex(0);

        LCreateExam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LCreateExam.setText("Create the Exam. ");


        LCenter.setForeground(new java.awt.Color(0, 0, 51));
        LCenter.setText("Center");

        BSearchExaminee.setText("Search");
        BSearchExaminee.addActionListener(this);

        setLayout();
        pack();
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
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(LCId)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(CBIdCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LJunction)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(LEid, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LUsername))
                                    .addComponent(LExaminee)))
                            .addGap(104, 104, 104))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(LCenter)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CBCenters, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(TFEid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(TFUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BSearchExaminee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LExam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(BSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LCreateExam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(LPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LJunction)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LExaminee)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LEid)
                            .addComponent(LUsername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFEid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(BSearchExaminee)
                        .addGap(18, 18, 18)
                        .addComponent(LExam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LCId)
                            .addComponent(CBIdCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(LCreateExam)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LCenter)
                            .addComponent(CBCenters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(LPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(BSave)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>
    
      
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object source= e.getSource ();
        if(source instanceof javax.swing.JButton)
        {           
            if (source == BSearchExaminee)   
            {
                BSearchExamineeActionPerformed(e);
                return;
            }
            if (source == BSave)   
            {
                BSaveActionPerformed(e);
                return;
            }
        }
    }
    
    
    private void BSearchExamineeActionPerformed(java.awt.event.ActionEvent evt) 
    {
        String username=TFUsername.getText();
        String id=TFEid.getText();
        if(!username.equals(""))
        {
            try
            {
                examinee=new Examinee().findbyUsername(username);
                JOptionPane.showMessageDialog (null, "Ο χρήστης "+examinee.getName()+" με Id "+examinee.getIdP(),
                        "Βρέθηκε", JOptionPane.NO_OPTION);
            }catch(IOException | JSONException exception)
            {
                JOptionPane.showMessageDialog (null, "Δεν βρέθηκε",
                        "Δώσατε λάθος Username", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(!id.equals(""))
        {
            try
            {
                examinee=new Examinee().findbyId(Integer.parseInt(id));
                JOptionPane.showMessageDialog (null, "Ο χρήστης "+examinee.getName()+" με username "+examinee.getUsername(),
                        "Βρέθηκε", JOptionPane.NO_OPTION);
            }catch(IOException | JSONException exception)
            {
                JOptionPane.showMessageDialog (null, "Δεν βρέθηκε",
                        "Δώσατε λάθος id", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog (null, "Εχετε αφήσει κενό πεδίο. ",
                        "Συμπληρώστε ένα από τα δύο πεδία", JOptionPane.ERROR_MESSAGE);
        }

    }                                               

    private void BSaveActionPerformed(ActionEvent e) 
    {
        String lcenter = CBCenters.getSelectedItem().toString();   
        String lexam=CBIdCenter.getSelectedItem().toString();
        //apo to uparxon exam pairnw to id
        if(!lexam.equals(""))
        {
            try {
                exam=new Exam().findbyId(Character.getNumericValue(lexam.charAt(0)));
            } catch (JSONException | IOException ex) {
                Logger.getLogger(AddExamineestoExam.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        //dhmiourgw kainourgio exam kai pairnw oloklhro to ecenter sumfwna me to onoma p edwse
        else if(!lcenter.equals(""))
        {
            try {
                //arxika ftiaxnw to exam
                exam=new Exam();
                //briskw to center
                exam.setECenterId(new ECenter().findbyΝame(lcenter));
                //to dhmiourgw
                exam.terminate();
                //to zhtaw pisw wste na exei kai id
                exam.setExamId(exam.findMax());
            } catch (JSONException | IOException ex) {
                Logger.getLogger(AddExamineestoExam.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(AddExamineestoExam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog (null, "Επιλέγξτε ένα από τα δύο πεδία ",
                        "Λάθος", JOptionPane.ERROR_MESSAGE);
        }
        
        if(exam==null || examinee==null)
        {
            JOptionPane.showMessageDialog (null, "Εχετε αφήσει κενό πεδίο. ",
                        "Συμπληρώστε και τα δύο πεδία και ελέγξτε ότι υπάρχουν", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            examinee.updateExam(exam);
            JOptionPane.showMessageDialog (null, "Επιτυχία",
                        "Η ενημέρωση ολοκληρώθηκε η νέα εξέταση έχει id"+exam.getExamId(), JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog (null, "συνέβει κάποιο λάθος κατά το update ",
                        "συνέβει κάποιο λάθος κατά το update ", JOptionPane.ERROR_MESSAGE);
            
        }
    }
}
