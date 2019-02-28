package rezervasyonsistemi;

import java.sql.Connection;
import java.sql.ResultSet;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

	Connection connection;
	DatabaseConnector db;
	String dateInString;
	private final DefaultTableModel rezervasyon_table1;
	private final DefaultTableModel rezervasyon_table2;
	ArrayList<Rezervasyon> rezList;
	int tiklama = 0;
	int tiklama2 = 0;
	Statement statement = null;
	public MainFrame() {
		initComponents();
		db = new DatabaseConnector();
		connection = (Connection) db.getConnection();
		////////datePicker ayarlari////
		DatePickerSettings settings1 = datePicker1.getSettings();
		settings1.setGapBeforeButtonPixels(-2);
		settings1.setFontVetoedDate(new java.awt.Font("Tahoma", 1, 15));
		settings1.setFontValidDate(new java.awt.Font("Tahoma", 1, 15));
		settings1.setColor(DatePickerSettings.DateArea.TextFieldBackgroundValidDate, new Color(0, 0, 0, 0));
		settings1.setLocale(Locale.getDefault());
		settings1.setFirstDayOfWeek(DayOfWeek.MONDAY);
		settings1.setAllowKeyboardEditing(false);
		datePicker1.getComponentToggleCalendarButton().setText("SEÇ");
		datePicker1.getComponentToggleCalendarButton().setBackground(new Color(0, 0, 0, 0));
		datePicker1.getComponentToggleCalendarButton().setFont(new java.awt.Font("Tahoma", 1, 14));
		datePicker1.setDateToToday();// bu günün tarihi
		datePicker1.addDateChangeListener(new SampleDateChangeListener());
		JTextField dd1 = datePicker1.getComponentDateTextField();
		dd1.setBackground(new Color(0, 0, 0, 0));
		dd1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
		dd1.setFont(new java.awt.Font("Tahoma", 1, 15));
		dd1.setForeground(Color.BLACK);
		/////////////////////////////////
		rezervasyon_table1 = (DefaultTableModel) jTable1.getModel();
		rezervasyon_table2 = (DefaultTableModel) jTable2.getModel();
		rezList = new ArrayList<>();

		Update(LocalDate.now());
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        LIST1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        LIST2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        oda101 = new javax.swing.JButton();
        oda102 = new javax.swing.JButton();
        oda103 = new javax.swing.JButton();
        oda104 = new javax.swing.JButton();
        oda105 = new javax.swing.JButton();
        oda106 = new javax.swing.JButton();
        oda107 = new javax.swing.JButton();
        oda108 = new javax.swing.JButton();
        oda109 = new javax.swing.JButton();
        oda110 = new javax.swing.JButton();
        oda111 = new javax.swing.JButton();
        oda112 = new javax.swing.JButton();
        oda113 = new javax.swing.JButton();
        oda114 = new javax.swing.JButton();
        oda115 = new javax.swing.JButton();
        oda116 = new javax.swing.JButton();
        oda117 = new javax.swing.JButton();
        oda201 = new javax.swing.JButton();
        oda202 = new javax.swing.JButton();
        oda203 = new javax.swing.JButton();
        oda204 = new javax.swing.JButton();
        oda205 = new javax.swing.JButton();
        oda206 = new javax.swing.JButton();
        oda207 = new javax.swing.JButton();
        oda208 = new javax.swing.JButton();
        oda209 = new javax.swing.JButton();
        oda210 = new javax.swing.JButton();
        oda211 = new javax.swing.JButton();
        oda212 = new javax.swing.JButton();
        oda213 = new javax.swing.JButton();
        oda214 = new javax.swing.JButton();
        oda215 = new javax.swing.JButton();
        oda216 = new javax.swing.JButton();
        oda217 = new javax.swing.JButton();
        forward = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datePicker1.setBackground(jPanel1.getBackground());
        jPanel1.add(datePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        LIST1.setBackground(new java.awt.Color(0, 0, 0));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"101", null, null, null, null, null},
                {"102", null, null, null, null, null},
                {"103", null, null, null, null, null},
                {"104", null, null, null, null, null},
                {"105", null, null, null, null, null},
                {"106", null, null, null, null, null},
                {"107", null, null, null, null, null},
                {"108", null, null, null, null, null},
                {"109", null, null, null, null, null},
                {"110", null, null, null, null, null},
                {"111", null, null, null, null, null},
                {"112", null, null, null, null, null},
                {"113", null, null, null, null, null},
                {"114", null, null, null, null, null},
                {"115", null, null, null, null, null},
                {"116", null, null, null, null, null},
                {"117", null, null, null, null, null}
            },
            new String [] {
                "ODA", "İSİM", "SAYI", "GİRİŞ", "ÇIKIŞ", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowHeight(20);
        jTable1.setShowGrid(true);
        LIST1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(1);
        }

        jPanel1.add(LIST1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 460, 370));

        jLabel2.setText("GÜNÜN REZERVASYONLARI");
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 340, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"201", null, null, null, null, null},
                {"202", null, null, null, null, null},
                {"203", null, null, null, null, null},
                {"204", null, null, null, null, null},
                {"205", null, null, null, null, null},
                {"206", null, null, null, null, null},
                {"207", null, null, null, null, null},
                {"208", null, null, null, null, null},
                {"209", null, null, null, null, null},
                {"210", null, null, null, null, null},
                {"211", null, null, null, null, null},
                {"212", null, null, null, null, null},
                {"213", null, null, null, null, null},
                {"214", null, null, null, null, null},
                {"215", null, null, null, null, null},
                {"216", null, null, null, null, null},
                {"217", null, null, null, null, null}
            },
            new String [] {
                "ODA", "İSİM", "SAYI", "GİRİŞ", "ÇIKIŞ", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.setRowHeight(20);
        jTable2.setShowGrid(true);
        LIST2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(2);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(1);
        }

        jPanel1.add(LIST2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 460, 370));

        jLabel1.setText("REZERVASYON EKLE");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 460, 250, 33));

        oda101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda101ActionPerformed(evt);
            }
        });
        jPanel1.add(oda101, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 10, 10));

        oda102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda102ActionPerformed(evt);
            }
        });
        jPanel1.add(oda102, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 10, 10));

        oda103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda103ActionPerformed(evt);
            }
        });
        jPanel1.add(oda103, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 10, 10));

        oda104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda104ActionPerformed(evt);
            }
        });
        jPanel1.add(oda104, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 10, 10));

        oda105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda105ActionPerformed(evt);
            }
        });
        jPanel1.add(oda105, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 10, 10));

        oda106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda106ActionPerformed(evt);
            }
        });
        jPanel1.add(oda106, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 10, 10));

        oda107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda107ActionPerformed(evt);
            }
        });
        jPanel1.add(oda107, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 10, 10));

        oda108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda108ActionPerformed(evt);
            }
        });
        jPanel1.add(oda108, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 10, 10));

        oda109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda109ActionPerformed(evt);
            }
        });
        jPanel1.add(oda109, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 10, 10));

        oda110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda110ActionPerformed(evt);
            }
        });
        jPanel1.add(oda110, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 10, 10));

        oda111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda111ActionPerformed(evt);
            }
        });
        jPanel1.add(oda111, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 10, 10));

        oda112.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda112ActionPerformed(evt);
            }
        });
        jPanel1.add(oda112, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 10, 10));

        oda113.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda113ActionPerformed(evt);
            }
        });
        jPanel1.add(oda113, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 10, 10));

        oda114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda114ActionPerformed(evt);
            }
        });
        jPanel1.add(oda114, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 10, 10));

        oda115.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda115ActionPerformed(evt);
            }
        });
        jPanel1.add(oda115, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 10, 10));

        oda116.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda116ActionPerformed(evt);
            }
        });
        jPanel1.add(oda116, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 10, 10));

        oda117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda117ActionPerformed(evt);
            }
        });
        jPanel1.add(oda117, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 10, 10));

        oda201.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda201ActionPerformed(evt);
            }
        });
        jPanel1.add(oda201, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, 10, 10));

        oda202.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda202ActionPerformed(evt);
            }
        });
        jPanel1.add(oda202, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 10, 10));

        oda203.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda203ActionPerformed(evt);
            }
        });
        jPanel1.add(oda203, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 130, 10, 10));

        oda204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda204ActionPerformed(evt);
            }
        });
        jPanel1.add(oda204, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 150, 10, 10));

        oda205.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda205ActionPerformed(evt);
            }
        });
        jPanel1.add(oda205, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 170, 10, 10));

        oda206.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda206ActionPerformed(evt);
            }
        });
        jPanel1.add(oda206, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 190, 10, 10));

        oda207.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda207ActionPerformed(evt);
            }
        });
        jPanel1.add(oda207, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 210, 10, 10));

        oda208.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda208ActionPerformed(evt);
            }
        });
        jPanel1.add(oda208, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 230, 10, 10));

        oda209.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda209ActionPerformed(evt);
            }
        });
        jPanel1.add(oda209, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 250, 10, 10));

        oda210.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda210ActionPerformed(evt);
            }
        });
        jPanel1.add(oda210, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 270, 10, 10));

        oda211.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda211ActionPerformed(evt);
            }
        });
        jPanel1.add(oda211, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 290, 10, 10));

        oda212.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda212ActionPerformed(evt);
            }
        });
        jPanel1.add(oda212, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 310, 10, 10));

        oda213.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda213ActionPerformed(evt);
            }
        });
        jPanel1.add(oda213, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 330, 10, 10));

        oda214.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda214ActionPerformed(evt);
            }
        });
        jPanel1.add(oda214, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 350, 10, 10));

        oda215.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda215ActionPerformed(evt);
            }
        });
        jPanel1.add(oda215, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 370, 10, 10));

        oda216.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda216ActionPerformed(evt);
            }
        });
        jPanel1.add(oda216, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 390, 10, 10));

        oda217.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oda217ActionPerformed(evt);
            }
        });
        jPanel1.add(oda217, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 410, 10, 10));

        forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/next.png"))); // NOI18N
        forward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forwardMouseClicked(evt);
            }
        });
        jPanel1.add(forward, new org.netbeans.lib.awtextra.AbsoluteConstraints(987, 25, 20, 20));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/back.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 25, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
		// REZERVASYON EKLEME SAYFASI ACAR
		RezervasyonEkle re = new RezervasyonEkle();
		this.setVisible(false);
		re.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseReleased

    private void oda102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda102ActionPerformed
        openRez1(1);
    }//GEN-LAST:event_oda102ActionPerformed

    private void oda103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda103ActionPerformed
        openRez1(2);
    }//GEN-LAST:event_oda103ActionPerformed

    private void oda104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda104ActionPerformed
        openRez1(3);
    }//GEN-LAST:event_oda104ActionPerformed

    private void oda105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda105ActionPerformed
        openRez1(4);
    }//GEN-LAST:event_oda105ActionPerformed

    private void oda106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda106ActionPerformed
        openRez1(5);
    }//GEN-LAST:event_oda106ActionPerformed

    private void oda107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda107ActionPerformed
        openRez1(6);
    }//GEN-LAST:event_oda107ActionPerformed

    private void oda108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda108ActionPerformed
        openRez1(7);
    }//GEN-LAST:event_oda108ActionPerformed

    private void oda109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda109ActionPerformed
        openRez1(8);
    }//GEN-LAST:event_oda109ActionPerformed

    private void oda110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda110ActionPerformed
        openRez1(9);
    }//GEN-LAST:event_oda110ActionPerformed

    private void oda111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda111ActionPerformed
        openRez1(10);
    }//GEN-LAST:event_oda111ActionPerformed

    private void oda112ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda112ActionPerformed
        openRez1(11);
    }//GEN-LAST:event_oda112ActionPerformed

    private void oda113ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda113ActionPerformed
        openRez1(12);
    }//GEN-LAST:event_oda113ActionPerformed

    private void oda114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda114ActionPerformed
        openRez1(13);
    }//GEN-LAST:event_oda114ActionPerformed

    private void oda115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda115ActionPerformed
        openRez1(14);
    }//GEN-LAST:event_oda115ActionPerformed

    private void oda116ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda116ActionPerformed
        openRez1(15);
    }//GEN-LAST:event_oda116ActionPerformed

    private void oda117ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda117ActionPerformed
        openRez1(16);
    }//GEN-LAST:event_oda117ActionPerformed

    private void oda201ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda201ActionPerformed
        openRez2(0);
    }//GEN-LAST:event_oda201ActionPerformed

    private void oda202ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda202ActionPerformed
        openRez2(1);
    }//GEN-LAST:event_oda202ActionPerformed

    private void oda203ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda203ActionPerformed
        openRez2(2);
    }//GEN-LAST:event_oda203ActionPerformed

    private void oda204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda204ActionPerformed
        openRez2(3);
    }//GEN-LAST:event_oda204ActionPerformed

    private void oda205ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda205ActionPerformed
        openRez2(4);
    }//GEN-LAST:event_oda205ActionPerformed

    private void oda206ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda206ActionPerformed
        openRez2(5);
    }//GEN-LAST:event_oda206ActionPerformed

    private void oda207ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda207ActionPerformed
        openRez2(6);
    }//GEN-LAST:event_oda207ActionPerformed

    private void oda208ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda208ActionPerformed
        openRez2(7);
    }//GEN-LAST:event_oda208ActionPerformed

    private void oda209ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda209ActionPerformed
        openRez2(8);
    }//GEN-LAST:event_oda209ActionPerformed

    private void oda211ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda211ActionPerformed
        openRez2(10);
    }//GEN-LAST:event_oda211ActionPerformed

    private void oda212ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda212ActionPerformed
        openRez2(11);
    }//GEN-LAST:event_oda212ActionPerformed

    private void oda213ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda213ActionPerformed
        openRez2(12);
    }//GEN-LAST:event_oda213ActionPerformed

    private void oda214ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda214ActionPerformed
        openRez2(13);
    }//GEN-LAST:event_oda214ActionPerformed

    private void oda215ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda215ActionPerformed
        openRez2(14);
    }//GEN-LAST:event_oda215ActionPerformed

    private void oda216ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda216ActionPerformed
        openRez2(15);
    }//GEN-LAST:event_oda216ActionPerformed

    private void oda217ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda217ActionPerformed
        openRez2(16);
    }//GEN-LAST:event_oda217ActionPerformed

    private void oda210ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda210ActionPerformed
        openRez2(9);
    }//GEN-LAST:event_oda210ActionPerformed

    private void oda101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oda101ActionPerformed
		openRez1(0);
    }//GEN-LAST:event_oda101ActionPerformed

    private void forwardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardMouseClicked
		LocalDate Giris = datePicker1.getDate();
		datePicker1.setDate(LocalDate.ofYearDay(Giris.getYear(), Giris.getDayOfYear()+1));
		Update(LocalDate.ofYearDay(Giris.getYear(), Giris.getDayOfYear()+1));
    }//GEN-LAST:event_forwardMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
		LocalDate Giris = datePicker1.getDate();
		datePicker1.setDate(LocalDate.ofYearDay(Giris.getYear(), Giris.getDayOfYear()-1));
		Update(LocalDate.ofYearDay(Giris.getYear(), Giris.getDayOfYear()-1));
    }//GEN-LAST:event_backMouseClicked
	private void openRez1(int oda){
		Object isEmpty = jTable1.getValueAt(oda, 2);
			if(isEmpty != "" && isEmpty != null){
				Rezervasyon rez = new Rezervasyon((int)jTable1.getValueAt(oda, 5));
				this.setVisible(false);
				rez.setVisible(true);
			}
	}
	private void openRez2(int oda){
		Object isEmpty = jTable2.getValueAt(oda, 2);
			if(isEmpty != "" && isEmpty != null){
				Rezervasyon rez = new Rezervasyon((int)jTable2.getValueAt(oda, 5));
				this.setVisible(false);
				rez.setVisible(true);
			}
	}
	private void Update(LocalDate Tarih) {
		System.out.println(Tarih);
		try {
			String query = "SELECT * FROM rezervasyonlar WHERE '" + Tarih + "' BETWEEN `giris` AND `cikis`";
			statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
			System.out.println(query);
			

			while (rs.next()) {

				Rezervasyon rsx = new Rezervasyon(rs.getString("oda"), rs.getString("rezervasyon_isimi"),
					rs.getString("not"), rs.getString("kapora"),
					rs.getInt("id"), rs.getDate("giris"), rs.getDate("cikis"),rs.getInt("kisi"));
				System.out.println(rsx);
				rezList.add(rsx);
			}
		} catch (SQLException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		if (!rezList.isEmpty()) {
			for (int i = 0; i < 17; i++) {
				for (Rezervasyon rezervasyon : rezList) {
					if (rezervasyon.getOda().equals(rezervasyon_table1.getValueAt(i, 0).toString())) {
						rezervasyon_table1.setValueAt(rezervasyon.getRezervasyon_ismi(), i, 1);
						rezervasyon_table1.setValueAt(rezervasyon.getKisi(), i, 2);
						rezervasyon_table1.setValueAt(rezervasyon.getGiris(), i, 3);
						rezervasyon_table1.setValueAt(rezervasyon.getCikis(), i, 4);
						rezervasyon_table1.setValueAt(rezervasyon.getId(), i, 5);
					}
					if (rezervasyon.getOda().equals(rezervasyon_table2.getValueAt(i, 0).toString())) {
						rezervasyon_table2.setValueAt(rezervasyon.getRezervasyon_ismi(), i, 1);
						rezervasyon_table2.setValueAt(rezervasyon.getKisi(), i, 2);
						rezervasyon_table2.setValueAt(rezervasyon.getGiris(), i, 3);
						rezervasyon_table2.setValueAt(rezervasyon.getCikis(), i, 4);
						rezervasyon_table2.setValueAt(rezervasyon.getId(), i, 5);
					}

				}
			}
		} else {
			for (int i = 0; i < 17; i++) {
				rezervasyon_table1.setValueAt("", i, 1);
				rezervasyon_table1.setValueAt("", i, 2);
				rezervasyon_table1.setValueAt("", i, 3);
				rezervasyon_table1.setValueAt("", i, 4);
				rezervasyon_table1.setValueAt("", i, 5);
				rezervasyon_table2.setValueAt("", i, 1);
				rezervasyon_table2.setValueAt("", i, 2);
				rezervasyon_table2.setValueAt("", i, 3);
				rezervasyon_table2.setValueAt("", i, 4);
				rezervasyon_table2.setValueAt("", i, 5);
			}
		}
		rezList.removeAll(rezList);
	}

	 class SampleDateChangeListener implements DateChangeListener {

		@Override
		public void dateChanged(DateChangeEvent event) {
			LocalDate newDate = event.getNewDate();
			Update(newDate);
		}

	}

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
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane LIST1;
    private javax.swing.JScrollPane LIST2;
    private javax.swing.JLabel back;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JLabel forward;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton oda101;
    private javax.swing.JButton oda102;
    private javax.swing.JButton oda103;
    private javax.swing.JButton oda104;
    private javax.swing.JButton oda105;
    private javax.swing.JButton oda106;
    private javax.swing.JButton oda107;
    private javax.swing.JButton oda108;
    private javax.swing.JButton oda109;
    private javax.swing.JButton oda110;
    private javax.swing.JButton oda111;
    private javax.swing.JButton oda112;
    private javax.swing.JButton oda113;
    private javax.swing.JButton oda114;
    private javax.swing.JButton oda115;
    private javax.swing.JButton oda116;
    private javax.swing.JButton oda117;
    private javax.swing.JButton oda201;
    private javax.swing.JButton oda202;
    private javax.swing.JButton oda203;
    private javax.swing.JButton oda204;
    private javax.swing.JButton oda205;
    private javax.swing.JButton oda206;
    private javax.swing.JButton oda207;
    private javax.swing.JButton oda208;
    private javax.swing.JButton oda209;
    private javax.swing.JButton oda210;
    private javax.swing.JButton oda211;
    private javax.swing.JButton oda212;
    private javax.swing.JButton oda213;
    private javax.swing.JButton oda214;
    private javax.swing.JButton oda215;
    private javax.swing.JButton oda216;
    private javax.swing.JButton oda217;
    // End of variables declaration//GEN-END:variables
}
