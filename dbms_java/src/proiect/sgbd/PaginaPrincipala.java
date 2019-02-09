/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect.sgbd;

import Conectare.ConectareBD;
import Clase.Tabele;
import Conectare.ConectareBD;
import Date.DateTabele;
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserCellEditor;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Database.FileFormat;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author HP
 */
public class PaginaPrincipala extends javax.swing.JFrame {
    static DefaultTableModel ListaTabele = new DefaultTableModel();
    DefaultTableModel TabelDetalii = new DefaultTableModel();
    DefaultTableModel TabelChei = new DefaultTableModel();
    DefaultTableModel TabelAdaugaValori = new DefaultTableModel();
    DefaultTableModel TabelReferinte = new DefaultTableModel();
    int linieNouaVerificare = 0;
    JComboBox comboTipDate = new JComboBox();
    int linieSelectata;
    public int randNou = 0;
    public static String numeTabelIndex = "";
    public PaginaPrincipala() {
        initComponents();        
        ascunde();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("DBMS-JAVA-Normalizarea-cheilor-straine");
        setVisible(true);     
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TabelLista = new javax.swing.JScrollPane();
        Tabel_lista = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        butonSelecteaza = new javax.swing.JButton();
        stergeTabel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Panou = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TabelCheiStraine = new javax.swing.JScrollPane();
        tabelCheiStraine = new javax.swing.JTable();
        text_chei = new javax.swing.JLabel();
        adaugaColoana = new javax.swing.JButton();
        dTabelDetalii1 = new javax.swing.JScrollPane();
        tabelDetalii = new javax.swing.JTable();
        salveazaTabel1 = new javax.swing.JButton();
        text_chei1 = new javax.swing.JLabel();
        TabelCheiStraine1 = new javax.swing.JScrollPane();
        tabelReferinte = new javax.swing.JTable();
        jNumeTabel = new javax.swing.JLabel();
        tabelAdauga = new javax.swing.JScrollPane();
        tabelAdaugaValori = new javax.swing.JTable();
        adaugaColoana1 = new javax.swing.JButton();
        textAltTip = new javax.swing.JLabel();
        rezolvaProbleme = new javax.swing.JButton();
        stergeColoana2 = new javax.swing.JButton();
        adaugaColoana2 = new javax.swing.JButton();
        textNumeBD = new javax.swing.JLabel();
        txtAdauga = new javax.swing.JLabel();
        t_numeTabel = new javax.swing.JTextField();
        butonAdaugaTabel = new javax.swing.JButton();
        adaugaBD = new javax.swing.JButton();
        numeBD = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Craciun Petrisor");

        Tabel_lista.setModel(ListaTabele);
        Tabel_lista.setColumnSelectionAllowed(true);
        Tabel_lista.getTableHeader().setReorderingAllowed(false);
        TabelLista.setViewportView(Tabel_lista);
        Tabel_lista.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton1.setText("Selectare baza de date");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        butonSelecteaza.setText("Selectare rand");
        butonSelecteaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonSelecteazaActionPerformed(evt);
            }
        });

        stergeTabel.setText("-");
        stergeTabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeTabelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Baza de date:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nume tabel:");

        tabelCheiStraine.setModel(TabelChei);
        tabelCheiStraine.setColumnSelectionAllowed(true);
        tabelCheiStraine.getTableHeader().setReorderingAllowed(false);
        TabelCheiStraine.setViewportView(tabelCheiStraine);
        tabelCheiStraine.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        text_chei.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_chei.setText("Chei straine:");

        adaugaColoana.setText("+");
        adaugaColoana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaColoanaActionPerformed(evt);
            }
        });

        tabelDetalii.setModel(TabelDetalii);
        tabelDetalii.getTableHeader().setReorderingAllowed(false);
        dTabelDetalii1.setViewportView(tabelDetalii);

        salveazaTabel1.setText("+ FK");
        salveazaTabel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salveazaTabel1ActionPerformed(evt);
            }
        });

        text_chei1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_chei1.setText("Referinte:");

        tabelReferinte.setModel(TabelReferinte);
        tabelReferinte.getTableHeader().setReorderingAllowed(false);
        TabelCheiStraine1.setViewportView(tabelReferinte);

        jNumeTabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jNumeTabel.setForeground(new java.awt.Color(204, 0, 0));

        tabelAdaugaValori.setModel(TabelAdaugaValori);
        tabelAdaugaValori.getTableHeader().setReorderingAllowed(false);
        tabelAdauga.setViewportView(tabelAdaugaValori);

        adaugaColoana1.setText("Indexuri");
        adaugaColoana1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaColoana1ActionPerformed(evt);
            }
        });

        rezolvaProbleme.setText("Configureaza DB");
        rezolvaProbleme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rezolvaProblemeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanouLayout = new javax.swing.GroupLayout(Panou);
        Panou.setLayout(PanouLayout);
        PanouLayout.setHorizontalGroup(
            PanouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanouLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanouLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumeTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(text_chei)
                        .addGap(82, 82, 82)
                        .addComponent(text_chei1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tabelAdauga)
                    .addGroup(PanouLayout.createSequentialGroup()
                        .addGroup(PanouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanouLayout.createSequentialGroup()
                                .addComponent(adaugaColoana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adaugaColoana1)
                                .addGap(18, 18, 18)
                                .addComponent(textAltTip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(rezolvaProbleme)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanouLayout.createSequentialGroup()
                                .addComponent(dTabelDetalii1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TabelCheiStraine, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PanouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanouLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(TabelCheiStraine1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanouLayout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(salveazaTabel1)))))
                .addContainerGap())
        );
        PanouLayout.setVerticalGroup(
            PanouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanouLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(text_chei)
                        .addComponent(text_chei1))
                    .addComponent(jNumeTabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TabelCheiStraine, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(dTabelDetalii1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(TabelCheiStraine1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adaugaColoana)
                    .addComponent(salveazaTabel1)
                    .addComponent(adaugaColoana1)
                    .addComponent(textAltTip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rezolvaProbleme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelAdauga, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        stergeColoana2.setText("Sterge linia");
        stergeColoana2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeColoana2ActionPerformed(evt);
            }
        });

        adaugaColoana2.setText("Adauga linie noua");
        adaugaColoana2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaColoana2ActionPerformed(evt);
            }
        });

        textNumeBD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textNumeBD.setForeground(new java.awt.Color(255, 0, 51));
        textNumeBD.setText("                            ");

        txtAdauga.setText("Tabel nou:");

        t_numeTabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        butonAdaugaTabel.setText("Adauga tabel");
        butonAdaugaTabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAdaugaTabelActionPerformed(evt);
            }
        });

        adaugaBD.setText("+ BD");
        adaugaBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaBDActionPerformed(evt);
            }
        });

        numeBD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNumeBD, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stergeTabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butonSelecteaza))
                    .addComponent(TabelLista, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panou, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numeBD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adaugaBD)))
                .addGap(61, 61, 61)
                .addComponent(txtAdauga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(t_numeTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonAdaugaTabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adaugaColoana2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stergeColoana2)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textNumeBD))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(TabelLista, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butonSelecteaza)
                            .addComponent(stergeTabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Panou, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adaugaColoana2)
                    .addComponent(stergeColoana2)
                    .addComponent(jButton1)
                    .addComponent(txtAdauga)
                    .addComponent(t_numeTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonAdaugaTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adaugaBD)
                            .addComponent(numeBD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(incarcaFisier() == 1 )
        {
           listaTabele(); 
           afiseaza();
        }     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void butonSelecteazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonSelecteazaActionPerformed
        linieSelectata = Tabel_lista.getSelectedRow();
        verificareLinieSelectata(linieSelectata);
        tabelDetalii();
        tabelCheie();
        listaTipDate();
        linieNouaVerificare = 0;
        String numeTabel = DateTabele.tabelSelectat(linieSelectata) ;
        if(linieSelectata>=0)
        {
            tabelAdaugaValori();
        }
        jNumeTabel.setText(DateTabele.tabelSelectat(linieSelectata));
        seteazaData(numeTabel);
        colorareTabel();
        rezolvaProbleme.setVisible(false);
    }//GEN-LAST:event_butonSelecteazaActionPerformed

    private void stergeTabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeTabelActionPerformed
        int linie = Tabel_lista.getSelectedRow();
        int verificare = DateTabele.verificaStergere(DateTabele.tabelSelectat(linie));
        //System.out.println(verificare);
        if(verificare>0)
        {
            JOptionPane.showMessageDialog(null, "   Imposibil de sters tabelul " + DateTabele.tabelSelectat(linie) + ".\nAcesta participa in una sau mai multe relatii." , "Eroare", JOptionPane.INFORMATION_MESSAGE);
        }
        else 
        {
            int raspuns = JOptionPane.showConfirmDialog(null, "Sunteti sigur ca doriti stergerea tabelului selectate?", "Titlu", JOptionPane.YES_NO_OPTION);
                if (raspuns == JOptionPane.YES_OPTION) 
                {
                    DateTabele.stergeTabel(DateTabele.tabelSelectat(linie));
                    JOptionPane.showMessageDialog(null, "Tabelul a fost stears cu succes!!");
                    listaTabele();
                }
        }
    }//GEN-LAST:event_stergeTabelActionPerformed
    int linieNoua = 0;
    private void adaugaColoanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaColoanaActionPerformed
        
        String numeTabel = DateTabele.tabelSelectat(linieSelectata);
        int raspuns = 0;
        int numarLinii = TabelDetalii.getRowCount();;
        if(linieNoua == 0)
        {
            TabelDetalii.addRow(new Object[]{"", "", ""});
            linieNoua = 1;
            //TabelAdaugaValori.setValueAt("(Nou)", numarLinii, 0);
        }
        numarLinii--;
        int linieSelectata = tabelDetalii.getSelectedRow();
        if( linieSelectata>=0 && linieSelectata == numarLinii && linieNoua == 1)
        {
            String numeColoana = tabelDetalii.getModel().getValueAt(tabelDetalii.getSelectedRow(),0).toString();
            String tipDate = tabelDetalii.getModel().getValueAt(tabelDetalii.getSelectedRow(),1).toString();
            String valNull = tabelDetalii.getModel().getValueAt(tabelDetalii.getSelectedRow(),2).toString();
            System.out.println(valNull);
            if(valNull.equals("YES") || valNull.equals("yes"))
            {
                valNull = "NOT NULL";
            }
            else
            {
                valNull="NULL";
            }
            if(tipDate.equals("CHARACTER VARYING"))
            {
                tipDate = "VARCHAR";
            }
            raspuns = DateTabele.adaugaColoane(numeTabel,numeColoana,tipDate,valNull);
            if(raspuns == 1 )
            {
                    JOptionPane.showMessageDialog(null, "Coloana a fost adaugata cu succes!!");
                    tabelDetalii.getSelectionModel().clearSelection();
                    linieNoua = 0;
            }
            else 
            {
                    JOptionPane.showMessageDialog(null, "Coloana exista !!");
            }
        }
        
    }//GEN-LAST:event_adaugaColoanaActionPerformed

    private void stergeColoana2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeColoana2ActionPerformed
        
        //Object[] linie = new Object[30];
        int nrColoane = DateTabele.numarColoane(DateTabele.tabelSelectat(linieSelectata));
        String numeTabel = DateTabele.tabelSelectat(linieSelectata);
        Object[] valoriTabel = new Object[nrColoane];
        for(int i =0 ;i<nrColoane;i++)
        {
            valoriTabel[i] = tabelAdaugaValori.getModel().getValueAt(tabelAdaugaValori.getSelectedRow(),i).toString();
        }
        int raspuns = JOptionPane.showConfirmDialog(null, "Sunteti sigur ca doriti stergerea liniei selectate?", "Titlu", JOptionPane.YES_NO_OPTION);
        if (raspuns == JOptionPane.YES_OPTION) 
        {
            String rezultat = DateTabele.stergeDate(numeTabel,valoriTabel);
            if(rezultat.length() > 0)
            {
                          JOptionPane.showMessageDialog(null, rezultat);
                          tabelAdaugaValori();
            }
        } 
    }//GEN-LAST:event_stergeColoana2ActionPerformed

    private void adaugaColoana2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaColoana2ActionPerformed
        Object[] linie = new Object[30];
        String numeTabel = DateTabele.tabelSelectat(linieSelectata);
        int nrColoane = DateTabele.numarColoane(DateTabele.tabelSelectat(linieSelectata));
        int linieDeAdaugat = tabelAdaugaValori.getSelectedRow();
        for(int i=0;i<nrColoane ;i++)
        {
                linie[i]= "";
        }
        int numarLinii = TabelAdaugaValori.getRowCount();
        if(linieNouaVerificare == 0 || numarLinii == 0)
        {
            TabelAdaugaValori.addRow(linie);
            linieNouaVerificare = 1;
            TabelAdaugaValori.setValueAt("(Nou)", numarLinii, 0); 
        }
        String valoare = "";
        if(numarLinii >= 1)
        {
            valoare = TabelAdaugaValori.getValueAt(numarLinii-1, 0).toString();
        }
        Object[] valoriTabel = new Object[nrColoane]; 
        if(linieDeAdaugat == numarLinii-1 && linieNouaVerificare == 1 && valoare.equals("(Nou)"))
        {
            for(int i =0 ;i<nrColoane;i++)
            {
                valoriTabel[i] = tabelAdaugaValori.getModel().getValueAt(tabelAdaugaValori.getSelectedRow(),i).toString();
            }
            String mesaj = DateTabele.adaugaValoriTabel(numeTabel,valoriTabel);
            JOptionPane.showMessageDialog(null, mesaj );
            tabelAdaugaValori.getSelectionModel().clearSelection();
            
            if(mesaj.equals("Linie adauga cu succes !"))
            {
                linieNouaVerificare = 0;
                tabelAdaugaValori();
            }
            
        }
        seteazaData(numeTabel);

    }//GEN-LAST:event_adaugaColoana2ActionPerformed

    private void salveazaTabel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salveazaTabel1ActionPerformed
        try 
        {
            new AdaugaCheieStraina();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PaginaPrincipala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salveazaTabel1ActionPerformed

    private void butonAdaugaTabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAdaugaTabelActionPerformed
       String numeTabel = t_numeTabel.getText();
       int verificare = DateTabele.CreareTabel(numeTabel);
       if(verificare == 1 )
       {
          JOptionPane.showMessageDialog(null, "Tabel adaugat cu succes! " , "Eroare", JOptionPane.INFORMATION_MESSAGE);
          t_numeTabel.setText("");
          listaTabele();
       }
       else 
       {
          JOptionPane.showMessageDialog(null, "Tabelul exista." , "Eroare", JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_butonAdaugaTabelActionPerformed

    private void adaugaBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaBDActionPerformed
        adaugaBD();
    }//GEN-LAST:event_adaugaBDActionPerformed

    private void adaugaColoana1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaColoana1ActionPerformed

        numeTabelIndex = DateTabele.tabelSelectat(linieSelectata);
        new Indexuri(); 
    }//GEN-LAST:event_adaugaColoana1ActionPerformed

    private void rezolvaProblemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rezolvaProblemeActionPerformed
        int rand = tabelCheiStraine.getSelectedRow();
        String numeTabel = DateTabele.tabelSelectat(linieSelectata);
        String[] verificare = verificaAltTip(); 
        if(rand >= 0)
        {
            String coloanaCheieStraina = tabelCheiStraine.getModel().getValueAt(rand,0).toString();
            int contor = 0;
            for(int i=0; i<verificare.length;i++)
            {
                if(verificare[i].equals(coloanaCheieStraina))
                {
                     contor++;
                }
            }
            if(contor == 1)
            {
             String TabelReferit = tabelReferinte.getModel().getValueAt(rand,1).toString();
             String coloanaReferit = tabelReferinte.getModel().getValueAt(rand,0).toString();
             for(Tabele tabel : DateTabele.indexTabel(TabelReferit))
             {
                 String coloanaIndex[]= {String.valueOf(tabel.getColoanaIndex()),};
                 String coloanaVerificare[] = {String.valueOf(tabel.getTipIndex()),};
                 String coloanaindex = coloanaIndex[0];
                 String coloanaverificare = coloanaVerificare[0];
                 if(coloanaverificare.equals("PRIMARY KEY"))
                 {
                    // JOptionPane.showMessageDialog(null, "In tabelul " + TabelReferit + " exista Primary Key pe coloana " + coloanaindex , "Mesaj", JOptionPane.INFORMATION_MESSAGE);  
                    int raspuns = JOptionPane.showConfirmDialog(null, "In tabelul " + TabelReferit + " exista Primary Key pe coloana " + coloanaindex + "\n Doriti sa continuati ? ", "Titlu", JOptionPane.YES_NO_OPTION);
                    if (raspuns == JOptionPane.YES_OPTION) 
                    {
                          System.out.println(DateTabele.adaugaColoanaTabelProblema(numeTabel,TabelReferit));
                          System.out.println(DateTabele.stergeReferintaProblema(numeTabel,coloanaCheieStraina));
                          System.out.println(DateTabele.adaugaDateId(numeTabel, TabelReferit, coloanaReferit, coloanaCheieStraina));
                          System.out.println(DateTabele.referintaNoua(numeTabel, TabelReferit));
                    }
                    break;
                 }
                 else 
                 {
                     int raspuns = JOptionPane.showConfirmDialog(null, "In tabelul " + TabelReferit + " nu exista PRIMARY KEY" + "\n Doriti sa continuati ? ", "Titlu", JOptionPane.YES_NO_OPTION);
                     if (raspuns == JOptionPane.YES_OPTION) 
                     {
                        String mesaj = DateTabele.adaugaColoanaId(TabelReferit);
                        mesaj += "\n" + DateTabele.incarcaId(TabelReferit,tabelReferinte.getModel().getValueAt(rand,0).toString());
                        mesaj += "\n" + DateTabele.adaugaPrimaryKey(TabelReferit);
                        mesaj += "\n" + DateTabele.adaugaColoanaTabelProblema(numeTabel,TabelReferit);
                        mesaj += "\n" + DateTabele.stergeReferintaProblema(numeTabel,coloanaCheieStraina);
                        mesaj += "\n" + DateTabele.adaugaDateId(numeTabel, TabelReferit, coloanaReferit, coloanaCheieStraina);
                        mesaj += "\n" + DateTabele.referintaNoua(numeTabel, TabelReferit);
                        JOptionPane.showMessageDialog(null, mesaj , "Titlu", JOptionPane.INFORMATION_MESSAGE);
                     }
                 }  
             }
            }   
        }
        else if(rand < 0)
        {
            JOptionPane.showMessageDialog(null, "Selectati o linie din tabelul Coloane FK" , "Eroare", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_rezolvaProblemeActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PaginaPrincipala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                new PaginaPrincipala().setVisible(true);
            }
        });
    }

    public void listaTabele()
    {
        while (ListaTabele.getRowCount() > 0) 
           {
                ListaTabele.removeRow(0);
           }
        Tabel_lista.setRowHeight(25);
        String coloane[] = {"Tabele"};
        ListaTabele.setColumnIdentifiers(coloane);
        
        try {
            for (Tabele tabel : DateTabele.listaNumeTabele()) 
            {
                String date[] = {String.valueOf(tabel.getNumeTabele()),};
                ListaTabele.addRow(date);
            }
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Eroare: " + e.getMessage());
        }
    }

    public int incarcaFisier()
    {
           JFileChooser alege_fisier = new JFileChooser();
           File folder_actual = new File(System.getProperty("user.dir"));
           FileNameExtensionFilter filtreaza = new FileNameExtensionFilter(null,"accdb","mdb");
           alege_fisier.setFileFilter(filtreaza);
           alege_fisier.addChoosableFileFilter(filtreaza);
           alege_fisier.setCurrentDirectory(folder_actual);
           int verificareSelectare = alege_fisier.showOpenDialog(null);
           if (verificareSelectare == JFileChooser.APPROVE_OPTION) 
           {
                File fisier = alege_fisier.getSelectedFile();     
                String locatie_fisier = fisier.getAbsolutePath();
                ConectareBD.locatie_fisier = locatie_fisier;
                String numeBD = alege_fisier.getSelectedFile().getName();
                textNumeBD.setText(numeBD);
                Panou.setVisible(true);
                return 1;
            } 
           else if (verificareSelectare == JFileChooser.CANCEL_OPTION) 
           {
               
           }      
           return 0;
    }
    
    public void verificareLinieSelectata(int linieSelectata)
    {
        if( linieSelectata < 0)
        {
                    JOptionPane.showMessageDialog(null, "Selectati o linie." , "Eroare", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    public void tabelDetalii()
    {
        int rand = tabelDetalii.getSelectedRow();
        while (TabelDetalii.getRowCount() > 0) 
           {
                TabelDetalii.removeRow(0);
           }
       tabelDetalii.setRowHeight(20);
       
       String coloane[] = {"Nume coloana" , "Tip date" , "NULL"};
       TabelDetalii.setColumnIdentifiers(coloane);
       tabelDetalii.getColumnModel().getColumn(2).setMaxWidth(60);
       try 
       {
            for (Tabele tabel : DateTabele.detaliiTabel(DateTabele.tabelSelectat(linieSelectata))) 
            {
                String numeColoane[] = {String.valueOf(tabel.getNumeColoana()),};
                String tipColoane[] = {String.valueOf(tabel.getTipColoana()),};
                String esteNull[] = {String.valueOf(tabel.getValoareNull()),};
                String nColoane = numeColoane[0];
                String nTip = tipColoane[0];
                String verificaNull = esteNull[0];
                TabelDetalii.addRow(new Object[]{ nColoane , nTip , verificaNull });
            }
        } 
        catch (SQLException e)
        {
                JOptionPane.showMessageDialog(null, "Eroare: " + e.getMessage());
        }
       
    }
    public void tabelCheie()
    {
         while (TabelChei.getRowCount() > 0) 
           {
                TabelChei.removeRow(0);
                TabelReferinte.removeRow(0);
           }
       int rand = tabelCheiStraine.getSelectedRow();
       tabelCheiStraine.setRowHeight(20);
       tabelReferinte.setRowHeight(20);
       String coloane[] = {"Coloana FK",};
       String coloane2[] = {"Coloana PK","Nume Tabel"};
       TabelChei.setColumnIdentifiers(coloane);
       TabelReferinte.setColumnIdentifiers(coloane2);
       try 
       {
            for (Tabele tabel : DateTabele.tabelCheiStraine(DateTabele.tabelSelectat(linieSelectata))) 
            {
                String cheieFK[] = {String.valueOf(tabel.getTabelCheie()),};
                String cheiePK[] = {String.valueOf(tabel.getColoanaFK()),};
                String TabelReferit[] = {String.valueOf(tabel.getTabelReferit()),};
                String cheieFK1 = cheieFK[0];
                String pk = cheiePK[0];
                String tabelReferit = TabelReferit[0];
                TabelChei.addRow(new Object[]{ cheieFK1 });
                TabelReferinte.addRow(new Object[]{ pk , tabelReferit});
            }
        } 
        catch (SQLException e)
        {
                JOptionPane.showMessageDialog(null, "Eroare: " + e.getMessage());
        }
       
    }
    public void tabelAdaugaValori()
    {
       tabelAdaugaValori.setRowHeight(20);
       TabelAdaugaValori.setColumnCount(0);
       int rand = tabelAdaugaValori.getSelectedRow();
       try 
       {
            for (Tabele tabel : DateTabele.listaColoane(DateTabele.tabelSelectat(linieSelectata))) 
            {
                TabelAdaugaValori.addColumn(String.valueOf(tabel.getlistaColoane()));
            }
        } 
        catch (SQLException e)
        {
                JOptionPane.showMessageDialog(null, "Eroare: " + e.getMessage());
        }
       int numarColoane = 0;
       
       while (TabelAdaugaValori.getRowCount() > 0) 
        {
            TabelAdaugaValori.removeRow(0);
        }

        try {
            numarColoane = DateTabele.numarColoane(DateTabele.tabelSelectat(linieSelectata));
            
            for (Map.Entry<Integer, ArrayList<String>> valori : DateTabele.valoriTabel(DateTabele.tabelSelectat(linieSelectata)).entrySet()) 
            {
                    ArrayList<String> lista = valori.getValue();
                    Object[] valoriTabel = new Object[256];
                    for(int i = 0; i<numarColoane;i++)
                    {
                        valoriTabel[i] = lista.get(i);
                    }
                    TabelAdaugaValori.addRow(valoriTabel);
            }
           
        } 
        catch (SQLException ex) {
            Logger.getLogger(PaginaPrincipala.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void listaTipDate()
    {
       comboTipDate.removeAllItems();
       try 
       {
            for (Tabele tabel : DateTabele.listaTipuriDate())
            {
                String[] numeColoane = {String.valueOf(tabel.getlistaTipDate()),};
                comboTipDate.insertItemAt(String.valueOf(tabel.getlistaTipDate()), 0);
                comboTipDate.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
                tabelDetalii.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboTipDate));
            }
        } 
        catch (SQLException e)
        {
                JOptionPane.showMessageDialog(null, "Eroare: " + e.getMessage());
        }
       
    }
    public void ascunde()
    {
        t_numeTabel.setVisible(false);
        butonAdaugaTabel.setVisible(false);
        stergeTabel.setVisible(false);
        butonSelecteaza.setVisible(false);
        adaugaColoana2.setVisible(false);
        stergeColoana2.setVisible(false);
        Panou.setVisible(false);
        tabelAdauga.setVisible(false);
        txtAdauga.setVisible(false);
        rezolvaProbleme.setVisible(false);
    }
    public void afiseaza()
    {
        txtAdauga.setVisible(true);
        t_numeTabel.setVisible(true);
        butonAdaugaTabel.setVisible(true);
        stergeTabel.setVisible(true);
        butonSelecteaza.setVisible(true);
        tabelAdauga.setVisible(true);
        adaugaColoana2.setVisible(true);
        stergeColoana2.setVisible(true); 
    }
    public void seteazaData(String numeTabel) 
    {
        String numeColoane;
        int numarLiniiTabel = tabelDetalii.getRowCount();
        //int[] pozitii = new int[50];
        int p = 0;
        int contor = 0;

        for(int q = 0; q < numarLiniiTabel;q++ )
        {
            String tipColoana = tabelDetalii.getModel().getValueAt(q,1).toString();
            if(tipColoana.equals("TIMESTAMP"))
            {
                numeColoane = tabelDetalii.getModel().getValueAt(q,0).toString();
                try {
                    for (Tabele tabel : DateTabele.listaColoane(numeTabel))
                    {
                        if(numeColoane.equals(String.valueOf(tabel.getlistaColoane())))
                        {
                            //System.out.println("aici :" + contor);
                            //TableColumn col1 = tabelAdaugaValori.getColumnModel().getColumn(contor);
                            SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
                            //TableCellRenderer renderer = new FormatRenderer(formatData);
                            tabelAdaugaValori.getColumnModel().getColumn(contor).setCellEditor(new JDateChooserCellEditor());
                            //tabelAdaugaValori.getColumnModel().getColumn(contor).setCellRenderer(renderer);
                            
                            // dFormat.format(tabelAdaugaValori.getColumnModel().getColumn(contor));
                            //alegeData.setDateFormatString("yyyy-MM-dd HH:mm");
                        }
                        contor++;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PaginaPrincipala.class.getName()).log(Level.SEVERE, null, ex);
                }
                contor = 0;
            } 
        }
   
    }
    public void adaugaBD()
    {
        String numebd = numeBD.getText();
        String locatie = System.getProperty("user.dir")+ "/" + numebd + ".accdb";
        try (Database db = DatabaseBuilder.create(FileFormat.V2010, new File(locatie))) {
            JOptionPane.showMessageDialog(null, "Eroare: " + "Baza de date creata cu succes. ");
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }
    
    public String[] verificaAltTip()
    {
        int nrChei = TabelChei.getRowCount();
        int nrColoane = TabelDetalii.getRowCount();
        String coloane = "-";
        if(nrChei > 0)
        {
            for(int i =0;i<nrColoane;i++)
            {
                for(int j = 0;j<nrChei;j++)
                {
                    String coloana = tabelDetalii.getModel().getValueAt(i,0).toString();
                    String cheieCol = tabelCheiStraine.getModel().getValueAt(j,0).toString();
                    if(coloana.equals(cheieCol))
                    {
                        if(tabelDetalii.getModel().getValueAt(i,1).toString().equals("INTEGER"))
                        {
                            //System.out.println("Este buna: " + tabelDetalii.getModel().getValueAt(i,0).toString() + " j : " + j);
                        }
                        else
                        {                                           
                            coloane += tabelDetalii.getModel().getValueAt(i,0).toString() + "-";
                            //System.out.println(tabelDetalii.getModel().getValueAt(i,0).toString() + " " + tabelDetalii.getModel().getValueAt(i,1).toString() + "j: " + j);
                        }
                    }
                }
            }
        }
        String[] coloaneAltTip = coloane.split("-");
        return coloaneAltTip;
    }
    public void colorareTabel()
    {
        String[] tabele = verificaAltTip();
        tabelCheiStraine.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
        {
            public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row, int col) 
            {

                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                String status = tabelCheiStraine.getModel().getValueAt(row,0).toString();
                int i = 1;
                if (tabele.length > 0) 
                { 
                    while(i<tabele.length)
                    {
                       // System.out.println("Valoarea lui i: " + i + " valoarea lui status:" + status + " " +tabele[i]);
                        if(tabele[i].equals(status))
                        {
                            setForeground(Color.RED);
                            i+=tabele.length-1;
                            rezolvaProbleme.setVisible(true);
                        } 
                    else 
                        {
                        //System.out.println("FALSE: " + tabele[i] + " status :" + status);
                            setForeground(table.getForeground());
                        }
                        i++;
                       
                    } 
                }
                      
                return this;
            }   
        });
    }
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panou;
    private javax.swing.JScrollPane TabelCheiStraine;
    private javax.swing.JScrollPane TabelCheiStraine1;
    private javax.swing.JScrollPane TabelLista;
    private javax.swing.JTable Tabel_lista;
    private javax.swing.JButton adaugaBD;
    private javax.swing.JButton adaugaColoana;
    private javax.swing.JButton adaugaColoana1;
    private javax.swing.JButton adaugaColoana2;
    private javax.swing.JButton butonAdaugaTabel;
    private javax.swing.JButton butonSelecteaza;
    private javax.swing.JScrollPane dTabelDetalii1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jNumeTabel;
    private javax.swing.JTextField numeBD;
    private javax.swing.JButton rezolvaProbleme;
    private javax.swing.JButton salveazaTabel1;
    private javax.swing.JButton stergeColoana2;
    private javax.swing.JButton stergeTabel;
    private javax.swing.JTextField t_numeTabel;
    private javax.swing.JScrollPane tabelAdauga;
    private javax.swing.JTable tabelAdaugaValori;
    private javax.swing.JTable tabelCheiStraine;
    private javax.swing.JTable tabelDetalii;
    private javax.swing.JTable tabelReferinte;
    private javax.swing.JLabel textAltTip;
    private javax.swing.JLabel textNumeBD;
    private javax.swing.JLabel text_chei;
    private javax.swing.JLabel text_chei1;
    private javax.swing.JLabel txtAdauga;
    // End of variables declaration//GEN-END:variables
}
