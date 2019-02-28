package rezervasyonsistemi;

import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.util.Locale;
import javax.swing.JTextField;

/**
 *
 * @author bat
 */
public class Rezervasyon extends javax.swing.JFrame {

	private String oda;
	private String rezervasyon_ismi;
	private String not;
	private String kapora;
	private int id;
	private Date giris;
	private Date cikis;
	private int kisi;
	Connection connection;
	DatabaseConnector db;
	String dateInString;
	Statement statement = null;

	public Rezervasyon(String oda, String rezervasyon_ismi, String not, String kapora, int id, Date giris, Date cikis,int kisi) {
		this.oda = oda;
		this.rezervasyon_ismi = rezervasyon_ismi;
		this.not = not;
		this.id = id;
		this.giris = giris;
		this.cikis = cikis;
		this.kisi = kisi;
	}

	public Rezervasyon(int id) {
		this.id = id;
		db = new DatabaseConnector();
		connection = db.getConnection();
		initComponents();
		try {
			String query = "SELECT * FROM rezervasyonlar WHERE  id = '" + id + "'";

			System.out.println(query);
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				this.oda = rs.getString("oda");
				this.rezervasyon_ismi = rs.getString("rezervasyon_isimi");
				this.not = rs.getString("not");
				this.id = id;
				this.giris = rs.getDate("giris");
				this.cikis = rs.getDate("cikis");
				this.kisi = rs.getInt("kisi");
				this.kapora = rs.getString("kapora");
			}
		} catch (SQLException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
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
		datePicker1.getComponentToggleCalendarButton().setFont(new java.awt.Font("Tahoma", 1, 15));
		datePicker1.setDateToToday();// bu günün tarihi
		JTextField dd1 = datePicker1.getComponentDateTextField();
		dd1.setBackground(new Color(0, 0, 0, 0));
		dd1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
		dd1.setFont(new java.awt.Font("Tahoma", 1, 15));
		dd1.setForeground(Color.BLACK);
		//////////////////////////////////////
		DatePickerSettings settings2 = datePicker2.getSettings();
		settings2.setGapBeforeButtonPixels(-2);
		settings2.setFontVetoedDate(new java.awt.Font("Tahoma", 1, 15));
		settings2.setFontValidDate(new java.awt.Font("Tahoma", 1, 15));
		settings2.setColor(DatePickerSettings.DateArea.TextFieldBackgroundValidDate, new Color(0, 0, 0, 0));
		settings2.setLocale(Locale.getDefault());
		settings2.setFirstDayOfWeek(DayOfWeek.MONDAY);
		settings2.setAllowKeyboardEditing(false);
		datePicker2.getComponentToggleCalendarButton().setText("SEÇ");
		datePicker2.getComponentToggleCalendarButton().setBackground(new Color(0, 0, 0, 0));
		datePicker2.getComponentToggleCalendarButton().setFont(new java.awt.Font("Tahoma", 1, 15));
		datePicker2.setDateToToday();// bu günün tarihi
		JTextField dd2 = datePicker2.getComponentDateTextField();
		dd2.setBackground(new Color(0, 0, 0, 0));
		dd2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
		dd2.setFont(new java.awt.Font("Tahoma", 1, 15));
		dd2.setForeground(Color.BLACK);
		/////////////////////////////////
		oda2.setSelectedItem(oda);
		isim.setText(rezervasyon_ismi);
		kisi_sayisi.setText(kisi+"");
		id_area.setText(" "+id);
		kapora3.setText(kapora);
		not2.setText(not);
		datePicker1.setDate(giris.toLocalDate());
		datePicker2.setDate(cikis.toLocalDate());
	}

	public String getOda() {
		return oda;
	}

	public void setOda(String oda) {
		this.oda = oda;
	}

	public String getRezervasyon_ismi() {
		return rezervasyon_ismi;
	}

	public void setRezervasyon_ismi(String rezervasyon_ismi) {
		this.rezervasyon_ismi = rezervasyon_ismi;
	}

	public String getNot() {
		return not;
	}

	public void setNot(String not) {
		this.not = not;
	}

	public String getKapora() {
		return kapora;
	}

	public void setKapora(String kapora) {
		this.kapora = kapora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Date getGiris() {
		return giris;
	}

	public void setGiris(Date giris) {
		this.giris = giris;
	}

	public Date getCikis() {
		return cikis;
	}

	public void setCikis(Date cikis) {
		this.cikis = cikis;
	}

	@Override
	public String toString() {
		return "Rezervasyon{" + "oda=" + oda2 + ", rezervasyon_ismi=" + rezervasyon_ismi + ", not=" + not2 + ", kisi=" + kisi_sayisi + ", giris=" + giris + ", cikis=" + cikis + '}';
	}

	public int getKisi() {
		return kisi;
	}

	public void setKisi(int kisi) {
		this.kisi = kisi;
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        geri = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        oda2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        datePicker2 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kisi_sayisi = new javax.swing.JFormattedTextField();
        isim = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        id_area = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        not2 = new javax.swing.JTextArea();
        kapora3 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        guncelle = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        geri.setBackground(new java.awt.Color(153, 204, 255));
        geri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("REZERVASYON");
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        geri.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel10.setText("GERİ");
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        geri.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        oda2.setBackground(new java.awt.Color(255, 255, 255));
        oda2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oda2.setForeground(new java.awt.Color(0, 0, 0));
        oda2.setMaximumRowCount(17);
        oda2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217" }));
        geri.add(oda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 60, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ODA");
        geri.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("GİRİŞ TARİHİ");
        geri.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ÇIKIŞ TARİHİ");
        geri.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        datePicker1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        datePicker1.setOpaque(false);
        geri.add(datePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 230, 30));

        datePicker2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        datePicker2.setOpaque(false);
        geri.add(datePicker2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 220, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("AD SOYAD");
        geri.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel6.setText("KİŞİ SAYISI");
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        geri.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        kisi_sayisi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        kisi_sayisi.setBackground(new java.awt.Color(255, 255, 255));
        kisi_sayisi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        kisi_sayisi.setCaretColor(new java.awt.Color(0, 0, 0));
        kisi_sayisi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kisi_sayisi.setForeground(new java.awt.Color(0, 0, 0));
        kisi_sayisi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kisi_sayisiKeyTyped(evt);
            }
        });
        geri.add(kisi_sayisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 90, 30));

        isim.setBackground(new java.awt.Color(255, 255, 255));
        isim.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        isim.setCaretColor(new java.awt.Color(0, 0, 0));
        isim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        isim.setForeground(new java.awt.Color(0, 0, 0));
        isim.setSelectionColor(new java.awt.Color(255, 153, 204));
        geri.add(isim, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 460, 30));

        jLabel11.setText("ID");
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        geri.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, 20));

        id_area.setEditable(false);
        id_area.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_area.setBackground(new java.awt.Color(153, 204, 255));
        id_area.setBorder(null);
        id_area.setCaretColor(new java.awt.Color(0, 0, 0));
        id_area.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        id_area.setForeground(new java.awt.Color(0, 0, 0));
        id_area.setSelectionColor(new java.awt.Color(255, 153, 204));
        id_area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                id_areaKeyTyped(evt);
            }
        });
        geri.add(id_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 70, 20));

        not2.setBackground(new java.awt.Color(255, 255, 255));
        not2.setColumns(20);
        not2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        not2.setForeground(new java.awt.Color(0, 0, 0));
        not2.setLineWrap(true);
        not2.setRows(5);
        not2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        not2.setCaretColor(new java.awt.Color(0, 0, 0));
        not2.setSelectedTextColor(new java.awt.Color(255, 153, 204));
        jScrollPane1.setViewportView(not2);

        geri.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 460, 150));

        kapora3.setBackground(new java.awt.Color(255, 255, 255));
        kapora3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        kapora3.setForeground(new java.awt.Color(0, 0, 0));
        kapora3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        kapora3.setCaretColor(new java.awt.Color(0, 0, 0));
        kapora3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kapora3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kapora3KeyTyped(evt);
            }
        });
        geri.add(kapora3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 70, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("NOT");
        geri.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel1.setText("                 ₺");
        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setOpaque(true);
        geri.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 30));

        guncelle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        guncelle.setText("GÜNCELLE");
        guncelle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guncelleMouseClicked(evt);
            }
        });
        geri.add(guncelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("KAPORA");
        geri.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(geri, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(geri, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        MainFrame main = new MainFrame();
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void id_areaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_areaKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
            || (vChar == KeyEvent.VK_BACK_SPACE)
            || (vChar == KeyEvent.VK_DELETE))) {
        evt.consume();
        }
    }//GEN-LAST:event_id_areaKeyTyped

    private void guncelleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guncelleMouseClicked
        String Oda = oda2.getSelectedItem().toString();
        Date Giris = java.sql.Date.valueOf(datePicker1.getDate());
        Date Cikis = java.sql.Date.valueOf(datePicker2.getDate());
        String Isim = isim.getText();
        String Kapora = kapora3.getText();
        String Not = not2.getText();
        String kisi = kisi_sayisi.getText();
        try {
            statement = connection.createStatement();
            String query = "UPDATE `rezervasyonlar` SET `oda` = '"+Oda+"', `rezervasyon_isimi` = '"+Isim+"', `not` = '"+Not+"', `kapora` = '"+Kapora+"', "
				+ "`kisi` = '"+kisi+"' , `giris` = '"+Giris+"' , `cikis` = '"+Cikis+"' WHERE id = '"+id+"'";
			
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        System.out.println("Kayit guncellendi");
        MainFrame main = new MainFrame();
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_guncelleMouseClicked

    private void kapora3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kapora3KeyTyped
        char vChar = evt.getKeyChar();
		if (!(Character.isDigit(vChar)
			|| (vChar == KeyEvent.VK_BACK_SPACE)
			|| (vChar == KeyEvent.VK_DELETE))) {
			evt.consume();
		}
    }//GEN-LAST:event_kapora3KeyTyped

    private void kisi_sayisiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kisi_sayisiKeyTyped
       char vChar = evt.getKeyChar();
		if (!(Character.isDigit(vChar)
			|| (vChar == KeyEvent.VK_BACK_SPACE)
			|| (vChar == KeyEvent.VK_DELETE))) {
			evt.consume();
		}
    }//GEN-LAST:event_kisi_sayisiKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private com.github.lgooddatepicker.components.DatePicker datePicker2;
    private javax.swing.JPanel geri;
    private javax.swing.JLabel guncelle;
    private javax.swing.JTextField id_area;
    private javax.swing.JTextField isim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField kapora3;
    private javax.swing.JFormattedTextField kisi_sayisi;
    private javax.swing.JTextArea not2;
    private javax.swing.JComboBox<String> oda2;
    // End of variables declaration//GEN-END:variables
}
