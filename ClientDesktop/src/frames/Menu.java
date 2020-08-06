package frames;

import data.Administrator;
import data.ECenter;
import data.Exam;
import data.Examinee;
import data.Excel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.primefaces.json.JSONException;

public class Menu extends javax.swing.JFrame implements ActionListener{
 // Variables declaration - do not modify                     
    private javax.swing.JButton BAddExaminee;
    private javax.swing.JButton BCreateCenter;
    private javax.swing.JButton BCreateExaminee;
    private javax.swing.JButton BExcel;
    private javax.swing.JButton BStartExam;
    private javax.swing.JButton BEditCenter;
    private javax.swing.JButton BEditExaminee;
    private javax.swing.JLabel LMenu;
    private javax.swing.JLabel LPicture;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Administrator admin;
    // End of variables declaration    
    
    public Menu(Administrator admin) 
    {
        this.admin=admin;
        if (admin.getECenterId()==null)
            initComponents(true);
        else
            initComponents(false);
    }

    
    private void initComponents(Boolean a) 
    {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LMenu = new javax.swing.JLabel();
        LPicture = new javax.swing.JLabel();
        BExcel = new javax.swing.JButton();
        BCreateExaminee = new javax.swing.JButton();
        BAddExaminee = new javax.swing.JButton();
        BStartExam = new javax.swing.JButton();
        BCreateCenter = new javax.swing.JButton();
        BEditCenter = new javax.swing.JButton();
        BEditExaminee = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        LMenu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LMenu.setText("Menu");

        LPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/login back2.jpg"))); // NOI18N
        LPicture.setMaximumSize(new java.awt.Dimension(100, 60));
        LPicture.setPreferredSize(new java.awt.Dimension(90, 60));



        BAddExaminee.setText("Add Examinee to Exam");
        BAddExaminee.addActionListener(this);

        BStartExam.setText("Start Exam");
        BStartExam.addActionListener(this);

        BCreateExaminee.setText("Create Examinee");
        BCreateExaminee.addActionListener(this);
        BCreateExaminee.setVisible(a);
        
        BExcel.setText("Add Questions from Excel");
        BExcel.addActionListener(this);
        BExcel.setVisible(a);
        
        BCreateCenter.setText("Create ECenter");
        BCreateCenter.addActionListener(this);
        BCreateCenter.setVisible(a);

        BEditCenter.setText("Edit ECenter");
        BEditCenter.addActionListener(this);
        BEditCenter.setVisible(a);

        BEditExaminee.setText("Edit Examinee");
        BEditExaminee.addActionListener(this);
        BEditExaminee.setVisible(a);

        setLayout();

        pack();
        this.setVisible(true);
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LMenu)
                    .addComponent(BAddExaminee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BStartExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BCreateCenter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BCreateExaminee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BEditExaminee, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BEditCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LMenu)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BAddExaminee)
                        .addGap(33, 33, 33)
                        .addComponent(BStartExam)
                        .addGap(32, 32, 32)
                        .addComponent(BExcel)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BCreateExaminee)
                            .addComponent(BEditExaminee))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BCreateCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BEditCenter)))
                    .addComponent(LPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object source= e.getSource ();
        if(source instanceof javax.swing.JButton){
            if (source == BAddExaminee)   
            {
                BAddExamineeActionPerformed(e);
                return;
            }
            if(source==BCreateCenter)
            {
                BCreateCenterActionPerformed(e);
                return;
            }
            if (source == BCreateExaminee)   
            {
                BCreateExamineeActionPerformed(e);
                return;
            }if (source == BExcel)   
            {
                BExcelActionPerformed(e);
                return;
            }if (source == BStartExam)   
            {
                BStartExamActionPerformed(e);
                return;
            }if (source == BEditCenter)   
            {
                BEditCenterActionPerformed(e);
                return;
            }if (source == BEditExaminee)   
            {
                BEditExamineeActionPerformed(e);
                return;
            }
        }
    }// </editor-fold>

    private void BExcelActionPerformed(java.awt.event.ActionEvent evt) 
    {                                       
        JFileChooser Fc = new JFileChooser ();
        Fc.setCurrentDirectory (new File (System.getProperty ("user.home")));
        FileNameExtensionFilter flt = new FileNameExtensionFilter ("Excel (*.xlsx)", "xlsx");
        Fc.setFileFilter (flt);
        Fc.setFileSelectionMode (JFileChooser.FILES_ONLY);
        Fc.setDialogTitle ("Επέλεξε αρχείο");
        int result = Fc.showSaveDialog (this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            try {
                File Sel = Fc.getSelectedFile ();
                String CurFn = Sel.getAbsolutePath ( );
                Excel excel=new Excel(CurFn);
            } catch (JSONException | URISyntaxException | IOException ex) {
                JOptionPane.showMessageDialog (null, "Ελέγξτε ότι είναι το κατάλληλο αρχείο με τη σωστή μορφοποίηση ",
                        "Σφάλμα", JOptionPane.ERROR_MESSAGE);            }
        }
    }                                      

    private void BAddExamineeActionPerformed(ActionEvent e) 
    {
        AddExamineestoExam eJe=new AddExamineestoExam();
        //done
    }

    private void BCreateCenterActionPerformed(ActionEvent e) 
    {
        CreateECenter ecenter=new CreateECenter();
        //done
    }

    private void BCreateExamineeActionPerformed(ActionEvent e) 
    {
        CreateExaminee createExaminee=new CreateExaminee();
        //done
    }

    private void BStartExamActionPerformed(ActionEvent e) 
    {
        
        StartExamDialog dialog = new StartExamDialog(this, false);
        dialog.setLocationRelativeTo(null);
        dialog.setSize(250, 120);
    }

    private void BEditCenterActionPerformed(ActionEvent e) 
    {
        ECenter ecenter=null;
        ECenterDialog dialog = new ECenterDialog(this,ecenter, false);
        dialog.setLocationRelativeTo(null);
        dialog.setSize(250, 120);
    }

    private void BEditExamineeActionPerformed(ActionEvent e) 
    {        
        Examinee examinee=null;
        ExamineeDialog dialog = new ExamineeDialog(this,examinee, false);
        dialog.setLocationRelativeTo(null);
        dialog.setSize(250, 120);
        

    }

    

                  
}


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
class ExamineeDialog extends JDialog 
{
  javax.swing.JLabel label1 = new javax.swing.JLabel("Username");
  javax.swing.JLabel label2 = new javax.swing.JLabel("id");
  javax.swing.JTextField TFUsername = new javax.swing.JTextField();
  javax.swing.JTextField TFId = new javax.swing.JTextField();
  javax.swing.JButton BSearch=new javax.swing.JButton();
  Examinee temp;

    public ExamineeDialog(javax.swing.JFrame owner,Examinee examinee, boolean modal) {
        super(owner, modal);
        temp=examinee;
        init();
    }

    private void init() 
    {
        this.setTitle("Find Examinee");
        this.setLayout(new java.awt.GridLayout(4,4));
        this.setResizable(false);
        this.add(label1);
        this.add(TFUsername);
        this.add(label2);
        this.add(TFId);
        BSearch.setText("Search");
        BSearch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findExaminee();
            }
        });
        this.add(BSearch);
        this.setVisible(true);

    }

    public void findExaminee() 
    {
        if(!TFUsername.getText().equals(""))
        {
            try{
                temp=(new Examinee()).findbyUsername(TFUsername.getText());
                this.setVisible(false);
                CreateExaminee ce=new CreateExaminee(temp);
            }catch(Exception e)
            {JOptionPane.showMessageDialog (null, "Δεν βρέθηκε",
                        "Δώσατε λάθος Username", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(!TFId.getText().equals(""))
        {
            try{
                temp=(new Examinee()).findbyId(Integer.parseInt(TFId.getText()));
                this.setVisible(false);
                CreateExaminee ce=new CreateExaminee(temp);
            }catch(Exception e)
            {JOptionPane.showMessageDialog (null, "Δεν βρέθηκε",
                        "Δώσατε λάθος Username", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog (null, "Εχετε αφήσει κενό πεδίο. ",
                        "Συμπληρώστε ένα από τα δύο πεδία", JOptionPane.ERROR_MESSAGE);
        }
    }
}
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
class ECenterDialog extends JDialog 
{
  javax.swing.JLabel label1 = new javax.swing.JLabel("Name");
  javax.swing.JLabel label2 = new javax.swing.JLabel("id");
  javax.swing.JTextField TFName = new javax.swing.JTextField();
  javax.swing.JTextField TFId = new javax.swing.JTextField();
  javax.swing.JButton BSearch=new javax.swing.JButton();
  ECenter temp;

    public ECenterDialog(javax.swing.JFrame owner,ECenter ecenter, boolean modal) {
        super(owner, modal);
        temp=ecenter;
        init();
    }

    private void init() 
    {
        this.setTitle("Find Ecenter");
        this.setLayout(new java.awt.GridLayout(4,4));
        this.setResizable(false);
        this.add(label1);
        this.add(TFName);
        this.add(label2);
        this.add(TFId);
        BSearch.setText("Search");
        BSearch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findECenter();
            }
        });
        this.add(BSearch);
        this.setVisible(true);

    }

    public void findECenter() 
    {
        if(!TFName.getText().equals(""))
        {
            try{
                //briskei to ecenter me to onoma p edwse sto TFName
                temp=(new ECenter()).findbyΝame(TFName.getText());
                this.setVisible(false);
                //ftiaxnei ena CreateECenter me to center kai ton admin pou exei to idio centerid
                CreateECenter ce=new CreateECenter(temp,new Administrator().findbyECenter(temp.getECenterId()));
            }catch(Exception e)
            {JOptionPane.showMessageDialog (null, "Δεν βρέθηκε",
                        "Δώσατε λάθος Username", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(!TFId.getText().equals(""))
        {
            try{
                temp=(new ECenter()).findbyId(Integer.parseInt(TFId.getText()));
                this.setVisible(false);
                CreateECenter ce=new CreateECenter(temp,new Administrator().findbyECenter(temp.getECenterId()));
            }catch(Exception e)
            {JOptionPane.showMessageDialog (null, "Δεν βρέθηκε",
                        "Δώσατε λάθος id", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog (null, "Εχετε αφήσει κενό πεδίο. ",
                        "Συμπληρώστε ένα από τα δύο πεδία", JOptionPane.ERROR_MESSAGE);
        }
    }
}// </editor-fold>


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
class StartExamDialog extends JDialog 
{
  javax.swing.JComboBox<String> CBExams =new javax.swing.JComboBox<>();;
  javax.swing.JButton BSearch=new javax.swing.JButton();
  List<Exam> exams=new ArrayList<Exam>();
  
    public StartExamDialog(javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        init();
    }

    private void init() 
    {
        this.setTitle("Choose Exam");
        this.setLayout(new java.awt.GridLayout(4,4));
        this.setResizable(false);
        this.add(CBExams);
        BSearch.setText("Start");
        BSearch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startExam();
            }
        });
        this.add(BSearch);
        
        
        try {
            exams=Exam.findAll();
        } catch (JSONException | IOException ex) {
        }
        String[] temp = new String[exams.size()];
        int i=0;
        for(Exam exam:exams)
        {
            temp[i]=new String(""+exam.getExamId()+" "+exam.getECenterId().getECenterName()+" "+exam.getExamDate());
            i++;
        }
        CBExams.setModel(new javax.swing.DefaultComboBoxModel<>(temp));
        CBExams.setSelectedIndex(0);
        
        
        
        this.setVisible(true);

    }

    public void startExam() 
    {
        String lexam = CBExams.getSelectedItem().toString();   
        try {
                Exam exam=new Exam().findbyId(Character.getNumericValue(lexam.charAt(0)));
                LocalDateTime time=LocalDateTime.now();
                exam.setExamDate(time);
                exam.updateExam();
                JOptionPane.showMessageDialog (null, "Επιτυχία",
                        "Η ενημέρωση ολοκληρώθηκε η νέα εξέταση έχει id"+exam.getExamId(), JOptionPane.INFORMATION_MESSAGE);
 

            } catch (JSONException | IOException | URISyntaxException ex) {
                JOptionPane.showMessageDialog (null, "συνέβει κάποιο λάθος κατά το update ",
                        "συνέβει κάποιο λάθος κατά το update ", JOptionPane.ERROR_MESSAGE);
                        }
        
    }
}// </editor-fold>