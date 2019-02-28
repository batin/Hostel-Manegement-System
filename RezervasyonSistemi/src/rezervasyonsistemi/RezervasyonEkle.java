package rezervasyonsistemi;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.Locale;
import javax.swing.JTextField;

/**
 *
 * @author bat
 */
public class RezervasyonEkle extends javax.swing.JFrame {

	Connection connection;
	DatabaseConnector db;
	String dateInString;
	Statement statement = null;

	public RezervasyonEkle() {
		initComponents();
		db = new DatabaseConnector();
		connection = db.getConnection();
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
		datePicker1.addDateChangeListener(new SampleDateChangeListener());
		datePicker2.addDateChangeListener(new SampleDateChangeListener());
		checkRooms();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        oda = new javax.swing.JComboBox<>();
        kapora = new javax.swing.JFormattedTextField();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        datePicker2 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kaydet = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        isim = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        not = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        geri = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kisi_sayisi = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setBackground(new java.awt.Color(153, 204, 255));
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        oda.setMaximumRowCount(17);
        oda.setBackground(new java.awt.Color(255, 255, 255));
        oda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oda.setForeground(new java.awt.Color(0, 0, 0));
        Panel.add(oda, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 60, 30));

        kapora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        kapora.setBackground(new java.awt.Color(255, 255, 255));
        kapora.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        kapora.setCaretColor(new java.awt.Color(0, 0, 0));
        kapora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kapora.setForeground(new java.awt.Color(0, 0, 0));
        kapora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kaporaKeyTyped(evt);
            }
        });
        Panel.add(kapora, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 70, 30));

        datePicker1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        datePicker1.setOpaque(false);
        Panel.add(datePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 220, 30));

        datePicker2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        datePicker2.setOpaque(false);
        Panel.add(datePicker2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 220, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("                 ₺");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);
        Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 30));

        jLabel2.setText("ÇIKIŞ TARİHİ");
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        kaydet.setText("KAYDET");
        kaydet.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        kaydet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kaydetMouseClicked(evt);
            }
        });
        Panel.add(kaydet, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, -1, -1));

        jLabel4.setText("AD SOYAD");
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel5.setText("GİRİŞ TARİHİ");
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        isim.setBackground(new java.awt.Color(255, 255, 255));
        isim.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        isim.setCaretColor(new java.awt.Color(0, 0, 0));
        isim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        isim.setForeground(new java.awt.Color(0, 0, 0));
        isim.setSelectionColor(new java.awt.Color(255, 153, 204));
        Panel.add(isim, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 460, 30));

        jLabel6.setText("KAPORA");
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        not.setColumns(20);
        not.setLineWrap(true);
        not.setRows(5);
        not.setBackground(new java.awt.Color(255, 255, 255));
        not.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        not.setCaretColor(new java.awt.Color(0, 0, 0));
        not.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        not.setForeground(new java.awt.Color(0, 0, 0));
        not.setSelectedTextColor(new java.awt.Color(255, 153, 204));
        jScrollPane1.setViewportView(not);

        Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 460, 150));

        jLabel7.setText("ODA");
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        jLabel8.setText("NOT");
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("REZERVASYON EKLE");
        Panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        geri.setText("GERİ");
        geri.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        geri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                geriMouseClicked(evt);
            }
        });
        Panel.add(geri, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("KİŞİ SAYISI");
        Panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        kisi_sayisi.setBackground(new java.awt.Color(255, 255, 255));
        kisi_sayisi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        kisi_sayisi.setForeground(new java.awt.Color(0, 0, 0));
        kisi_sayisi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        kisi_sayisi.setCaretColor(new java.awt.Color(0, 0, 0));
        kisi_sayisi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kisi_sayisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kisi_sayisiActionPerformed(evt);
            }
        });
        kisi_sayisi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kisi_sayisiKeyTyped(evt);
            }
        });
        Panel.add(kisi_sayisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void geriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_geriMouseClicked
		MainFrame main = new MainFrame();
		this.setVisible(false);
		main.setVisible(true);
    }//GEN-LAST:event_geriMouseClicked
	private void checkRooms() {
		System.out.println(".....");
		oda.removeAllItems();
		Date Giris = java.sql.Date.valueOf(datePicker1.getDate());
		Date Cikis = java.sql.Date.valueOf(datePicker2.getDate());
		try {
			for (int i = 101; i < 118; i++) {

				String query = "SELECT oda FROM rezervasyonlar WHERE giris <= '"
					+ Giris + "' AND cikis > '" + Cikis + "' AND oda = '" + i + "'";
				statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				//System.out.println("----"+query);

				if (rs.next()) {
					System.out.println(i);
				} else {
					oda.addItem(i + "");
				}

			}
			for (int i = 201; i < 218; i++) {

				String query
					= "SELECT oda FROM rezervasyonlar WHERE giris <= '" + Giris
					+ "' AND cikis > '" + Cikis + "' AND oda = '" + i + "'";
				statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				//System.out.println("----"+query);
				if (rs.next()) {
					System.out.println(i);
				} else {
					oda.addItem(i + "");
				}
			}
		} catch (SQLException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
	}

    private void kaydetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kaydetMouseClicked
		String Oda = oda.getSelectedItem().toString();
		Date Giris = java.sql.Date.valueOf(datePicker1.getDate());
		Date Cikis = java.sql.Date.valueOf(datePicker2.getDate());
		String Isim = isim.getText();
		String Kapora = kapora.getText();
		String Not = not.getText();
		int kisi = Integer.parseInt(kisi_sayisi.getText());

		try {
			statement = connection.createStatement();
			String query = "INSERT INTO `rezervasyonlar` (`oda`, `rezervasyon_isimi`, `not`, `kapora`, `giris`, `cikis`, `kisi`) VALUES "
				+ "('" + Oda + "', '" + Isim + "', '" + Not + "', '" + Kapora + "', '" + Giris + "', '" + Cikis + "', '" + kisi + "')";

			statement.executeUpdate(query);

		} catch (SQLException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		System.out.println("Kayit basarili");
		MainFrame main = new MainFrame();
		this.setVisible(false);
		main.setVisible(true);
    }//GEN-LAST:event_kaydetMouseClicked

    private void kaporaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kaporaKeyTyped
		char vChar = evt.getKeyChar();
		if (!(Character.isDigit(vChar)
			|| (vChar == KeyEvent.VK_BACK_SPACE)
			|| (vChar == KeyEvent.VK_DELETE))) {
			evt.consume();
		}
    }//GEN-LAST:event_kaporaKeyTyped

    private void kisi_sayisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kisi_sayisiActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_kisi_sayisiActionPerformed

    private void kisi_sayisiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kisi_sayisiKeyTyped
		char vChar = evt.getKeyChar();
		if (!(Character.isDigit(vChar)
			|| (vChar == KeyEvent.VK_BACK_SPACE)
			|| (vChar == KeyEvent.VK_DELETE))) {
			evt.consume();
		}
    }//GEN-LAST:event_kisi_sayisiKeyTyped
	private class SampleDateChangeListener implements DateChangeListener {

		@Override
		public void dateChanged(DateChangeEvent event) {
			checkRooms();
		}

	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private com.github.lgooddatepicker.components.DatePicker datePicker2;
    private javax.swing.JLabel geri;
    private javax.swing.JTextField isim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField kapora;
    private javax.swing.JLabel kaydet;
    private javax.swing.JFormattedTextField kisi_sayisi;
    private javax.swing.JTextArea not;
    private javax.swing.JComboBox<String> oda;
    // End of variables declaration//GEN-END:variables
}
