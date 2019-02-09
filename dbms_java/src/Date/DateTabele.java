package Date;

import Clase.Tabele;
import Conectare.ConectareBD;
import java.awt.List;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DateTabele {
    public static ArrayList<Tabele> listaNumeTabele() throws SQLException 
    {
        Connection conexiune = ConectareBD.ConectareBazaDate();
        PreparedStatement ps = null;
        ArrayList<Tabele> lista = new ArrayList<Tabele>();
        Statement st = conexiune.createStatement();
        String instructiuneSql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE table_type = 'BASE TABLE' AND table_schema = 'PUBLIC' ORDER BY TABLE_NAME ASC";
        ResultSet rs = st.executeQuery(instructiuneSql);
        while (rs.next()) 
        {
            Tabele adauga = new Tabele();
            adauga.setNumeTabele(rs.getString(1));
            lista.add(adauga);
        }
    conexiune.close();
    st.close();
    
    return lista;
    
    }
    public static ArrayList<Tabele> detaliiTabel(String numeTabel) throws SQLException 
    {
        Connection conexiune = ConectareBD.ConectareBazaDate();
        PreparedStatement ps = null;
        ArrayList<Tabele> lista2 = new ArrayList<Tabele>();
        Statement st = conexiune.createStatement();
        String instructiuneSql = "SELECT COLUMN_NAME,DATA_TYPE,IS_NULLABLE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + numeTabel + "';";
        ResultSet rs = st.executeQuery(instructiuneSql);
        while (rs.next()) 
        {
            Tabele adauga = new Tabele();
            adauga.setNumeColoana(rs.getString(1));
            adauga.setTipColoana(rs.getString(2));
            adauga.setValoareNull(rs.getString(3));
            lista2.add(adauga);
        }
    conexiune.close();
    st.close();
    return lista2;
    }
    public static String tabelSelectat(int linie)
    {
        int i = 0;
        String nume_tabel_selectat ="";
        if( linie < 0 )
        {
            
        }
        try { 
            for (Tabele tabel : DateTabele.listaNumeTabele()) {
                String date[] = {String.valueOf(tabel.getNumeTabele()),};
                if(i == linie)
                {
                    nume_tabel_selectat = String.valueOf(tabel.getNumeTabele());
                }    
                i++;
            }
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Eroare: " + e.getMessage());
        }
        return nume_tabel_selectat;
    }
    public static void stergeTabel(String numeTabel) 
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(true); 
            Statement st = conexiune.createStatement();
            String sql = "DROP TABLE " + numeTabel;
            st.executeUpdate(sql);
            conexiune.commit();
            conexiune.close();
            st.close();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }     
    }
    public static ArrayList<Tabele> tabelCheiStraine(String numeTabel) throws SQLException 
    {
        Connection conexiune = ConectareBD.ConectareBazaDate();
        PreparedStatement ps = null;
        ArrayList<Tabele> lista2 = new ArrayList<Tabele>();
        Statement st = conexiune.createStatement();
        String instructiuneSql = "SELECT ccu1.COLUMN_NAME, ccu2.COLUMN_NAME,ccu2.TABLE_NAME \n" +
    "FROM    INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE ccu1,\n" +
    "        INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE ccu2,\n" +
    "        INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS rc\n" +
    "WHERE   rc.CONSTRAINT_NAME = ccu1.CONSTRAINT_NAME\n" +
    "AND     rc.UNIQUE_CONSTRAINT_NAME = ccu2.CONSTRAINT_NAME " +
    "AND TABLE_NAME = '" + numeTabel +"'";
        ResultSet rs = st.executeQuery(instructiuneSql);
        while (rs.next()) 
        {
            Tabele adauga = new Tabele();
            adauga.setTabelCheie(rs.getString(1));
            adauga.setColoanaFK(rs.getString(2));
            adauga.setTabelReferit(rs.getString(3));
            lista2.add(adauga);
        }
    conexiune.close();
    st.close();
    return lista2;
    }
    
    public static ArrayList<Tabele> listaTipuriDate() throws SQLException 
    {
        Connection conexiune = ConectareBD.ConectareBazaDate();
        PreparedStatement ps = null;
        ArrayList<Tabele> lista2 = new ArrayList<Tabele>();
        Statement st = conexiune.createStatement();
        String instructiuneSql = "SELECT DISTINCT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS ORDER BY DATA_TYPE ASC";
        ResultSet rs = st.executeQuery(instructiuneSql);
        while (rs.next()) 
        {
            Tabele adauga = new Tabele();
            adauga.setlistaTipDate(rs.getString(1));
            lista2.add(adauga);
        }
    conexiune.close();
    st.close();
    return lista2;
    }
    
    public static ArrayList<Tabele> listaColoane(String numeTabel) throws SQLException 
    {
        Connection conexiune = ConectareBD.ConectareBazaDate();
        PreparedStatement ps = null;
        ArrayList<Tabele> lista2 = new ArrayList<Tabele>();
        Statement st = conexiune.createStatement();
        String instructiuneSql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + numeTabel + "';";
        ResultSet rs = st.executeQuery(instructiuneSql);
        while (rs.next()) 
        {
            Tabele adauga = new Tabele();
            adauga.setlistaColoane(rs.getString(1));
            lista2.add(adauga);
        }
        conexiune.close();
        st.close();
        return lista2;
    }

    public static Map<Integer,ArrayList<String>> valoriTabel(String numeTabel) throws SQLException 
    {
        Connection conexiune = ConectareBD.ConectareBazaDate();
        PreparedStatement ps = null;
        Statement st = conexiune.createStatement();
        String instructiuneSql2 = "SELECT COUNT(COLUMN_NAME) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + numeTabel + "';";
        ResultSet numarColoane = st.executeQuery(instructiuneSql2);
        String nrColoane ="";
        while (numarColoane.next()) 
        {
           nrColoane = numarColoane.getString(1);
        }
        //System.out.println("Numar coloane:" + Integer.parseInt(nrColoane) );
        HashMap<Integer,ArrayList<String>> listaValori = new HashMap<Integer,ArrayList<String>>();
        String instructiuneSql = "SELECT * FROM " + numeTabel + ";";
        ResultSet rs = st.executeQuery(instructiuneSql); 
        int count = 0;
        while (rs.next()) 
        {
            ArrayList<String> valori = new ArrayList<>();
            for(int i = 1; i<= Integer.parseInt(nrColoane);i++)
            {
                valori.add(rs.getString(i));
               // System.out.println("aici : " + count + "  " +rs.getObject(i).toString() );
            }   
            count ++;
            listaValori.put(count, valori);
        }
        conexiune.close();
        st.close();
    
        return listaValori;
    
    }
    public static int numarColoane(String numeTabel) 
    {
        int numarCol = 0;
        try {
            Connection conexiune = ConectareBD.ConectareBazaDate();
            PreparedStatement ps = null;
            Statement st = conexiune.createStatement();
            String instructiuneSql2 = "SELECT COUNT(COLUMN_NAME) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + numeTabel + "';";
            ResultSet numarColoane = st.executeQuery(instructiuneSql2);
            
            while (numarColoane.next())
            {
                numarCol = Integer.parseInt(numarColoane.getString(1));
            }
            conexiune.close();
            st.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(DateTabele.class.getName()).log(Level.SEVERE, null, ex);
        }
       return numarCol;
    }
    public static int CreareTabel(String numeTabel) 
    {
        try (Connection conexiune = ConectareBD.ConectareBazaDate()){
            conexiune.setAutoCommit(false); 
            
            Statement st = conexiune.createStatement();
            String instructiuneSql2 = "CREATE TABLE " + numeTabel + "(Id AUTOINCREMENT PRIMARY KEY);";
            st.executeUpdate(instructiuneSql2);
            conexiune.commit();
            conexiune.close();
            st.close();
            return 1;
        } 
        catch (SQLException ex)
        {
            return 0;
        }
    }
    public static int verificaStergere(String numeTabel) 
    {
        int i = 0;
        try {
            Connection conexiune = ConectareBD.ConectareBazaDate();
            PreparedStatement ps = null;
            Statement st = conexiune.createStatement();
            String instructiuneSql = "SELECT ccu2.TABLE_NAME \n" +
                    "FROM  INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE ccu2,\n" +
                    "      INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS rc\n" +
                    "WHERE rc.UNIQUE_CONSTRAINT_NAME = ccu2.CONSTRAINT_NAME " +
                    "AND TABLE_NAME = '" + numeTabel +"'";
            ResultSet rs = st.executeQuery(instructiuneSql);
            
            while(rs.next())
            {
                i++;   
            }
            conexiune.close();
            st.close();
           // System.out.println("Este tabel referit.! " + i);
        } catch (SQLException ex) {
            Logger.getLogger(DateTabele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public static int adaugaCheieStraina(String Tabel1,String Tabel2,String col1,String col2) 
    {
        
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(true); 
            Statement st = conexiune.createStatement();
            String sql = "ALTER TABLE " + Tabel1 + " ADD CONSTRAINT " + Tabel1 + Tabel2 + " FOREIGN KEY (" + col1 +") REFERENCES " + Tabel2 + "(" + col2 +");";
            //System.out.println("" + Tabel1 + Tabel2);
            st.executeUpdate(sql);
            conexiune.commit();
            conexiune.close();
            st.close();
            return 1;
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return 0;
    }

    public static int verificareCheieStraina(String Tabel1,String Tabel2,String col1,String col2) 
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(true); 
            Statement st = conexiune.createStatement();
            String instructiuneTip1 = "SELECT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = \n'"
                                        + Tabel1 + "' AND COLUMN_NAME = '" + col1 + "'";
            String instructiuneTip2 = "SELECT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = \n'"
                                        + Tabel2 + "' AND COLUMN_NAME = '" + col2 + "'";
            String instructiuneTip3 = "SELECT coloanaCautata.column_name \n" +
"    FROM information_schema.table_constraints tabelC\n" +
"    INNER JOIN information_schema.key_column_usage coloanaCautata \n" +
"        ON coloanaCautata.Constraint_Name = tabelC.Constraint_Name \n" +
"    AND coloanaCautata.Constraint_schema = tabelC.Constraint_schema \n" +
"    WHERE tabelC.Constraint_Type IN ('PRIMARY KEY','UNIQUE') AND coloanaCautata.Table_name = '" + Tabel2 + "'";
            //System.out.println(instructiuneTip1);
            //System.out.println(instructiuneTip2);
            ResultSet p1 = st.executeQuery(instructiuneTip1);
            ResultSet p2 = st.executeQuery(instructiuneTip2);
            ResultSet p3 = st.executeQuery(instructiuneTip3);
            String pp1 ="",pp2="",pp3="";
            while(p1.next() && p2.next())
            {
                pp1 = p1.getString(1);
                //System.out.println(pp1);
                pp2 = p2.getString(1);
                //System.out.println(pp2);
                
            }
            while(p3.next())
            {
                pp3 = p3.getString(1);
                if(pp3.equals(col2))
                {
                    break;
                }
                //System.out.println(" Aici : " + pp3);
            }
            
            if(pp1.equals(pp2))
            {
              if(col2.equals(pp3))
              {
                  return 1;
              }
              else 
              {
                  return -1;      
              }
            }
            conexiune.commit();
            conexiune.close();
            st.close();
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }    
        return 0;
    }
    public static int adaugaColoane(String numeTabel,String numeColoana,String tipColoana,String valNull) 
    {
        
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(true); 
            Statement st = conexiune.createStatement();
            if(tipColoana.equals("INTEGER"))
            {
                tipColoana = "INT";
            }
            String sql = "ALTER TABLE " + numeTabel + " ADD " + numeColoana + " " + tipColoana + " "+ valNull + ";";
            //System.out.println(sql);
            //System.out.println(tipColoana);
            st.executeUpdate(sql);
            conexiune.commit();
            conexiune.close();
            st.close();
            return 1;
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return 0;
    }
    public static int verificaStergereColoane(String numeColoana) 
    {
        int i = 0;
        try {
            Connection conexiune = ConectareBD.ConectareBazaDate();
            PreparedStatement ps = null;
            Statement st = conexiune.createStatement();
            String instructiuneSql = "SELECT ccu2.COLUMN_NAME \n" +
                    "FROM  INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE ccu2,\n" +
                    "      INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS rc\n" +
                    "WHERE rc.UNIQUE_CONSTRAINT_NAME = ccu2.CONSTRAINT_NAME " +
                    "AND COLUMN_NAME = '" + numeColoana +"'";
            ResultSet rs = st.executeQuery(instructiuneSql);
            
            while(rs.next())
            {
                i++;   
            }
            conexiune.close();
            st.close();
           // System.out.println("Este tabel referit.! " + i);
        } catch (SQLException ex) {
            Logger.getLogger(DateTabele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public static int modificaColoane(String numeTabel,String numeColoana,String tipColoana,String valNull) 
    {
        
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(false); 
            Statement st = conexiune.createStatement();
            String sql = "ALTER TABLE " + numeTabel + " ALTER COLUMN " + numeColoana +" " + tipColoana ;
            PreparedStatement preparedStatement = conexiune.prepareStatement(sql);
            int verifica = verificaStergereColoane(numeTabel);
            if(verifica  == 0)
            {
                System.out.println(sql);
                //st.executeUpdate(sql);
                preparedStatement.executeQuery(sql); 
            }
            conexiune.commit();
            conexiune.close();
            st.close();
            return 1;
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return 0;
    }
    
    public static String adaugaValoriTabel(String numeTabel,Object[] valori) 
    {
        
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(false); 
            String mesajEroare = "";
            Statement st = conexiune.createStatement();
            //PreparedStatement prepared = null;
            int nrColoane = numarColoane(numeTabel);
            String sql = "SELECT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + numeTabel + "';";
            ResultSet rezultat = st.executeQuery(sql);
            String tipDate[] = new String[nrColoane];
            int k=0;
            while(rezultat.next())
            {
                tipDate[k] = rezultat.getString(1);
               // System.out.println(tipDate[k]);
                k++;  
            }
            String instructiuneSql = "INSERT INTO " + numeTabel + " (";
            int i =0;
            
            String instructiune = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + numeTabel + "';";
            ResultSet rs = st.executeQuery(instructiune);
            String[] coloane = new String[nrColoane+1];
            int j = 0;
            while(rs.next())
            {
                coloane[j] = rs.getString(1);
                j++;

            }
            for(i=1;i<nrColoane;i++)
            {
                if(i != nrColoane-1)
                {
                    instructiuneSql += coloane[i] + ",";
                }
                if(i == nrColoane-1)
                {
                    instructiuneSql += coloane[i] + ")";
                }
            }
            instructiuneSql += " VALUES ("; 
            for(i=1;i<valori.length;i++)
            {
                if(i != valori.length-1)
                {
                   // System.out.println(tipDate[i]);
                    if(tipDate[i].equals("CHARACTER VARYING")  || tipDate[i].equals("CHARACTER"))
                    {
                        instructiuneSql += "\"" + valori[i] + "\"" + "," ;
                        //System.out.println("\"" + valori[i] + "\"" + ",");
                    }
                    else if(tipDate[i].equals("TIMESTAMP"))
                    {
                        String dataTabel = valori[i].toString();
                        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
                        java.util.Date parsedDate = sdf.parse(dataTabel);
                        SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
                        
                        instructiuneSql += "\'" + print.format(parsedDate) + "\'" + "," ;
                    }
                    else
                    {
                        instructiuneSql += valori[i] + "," ;
                    }
                }
                if(i == valori.length-1)
                {
                    if(tipDate[i].equals("CHARACTER VARYING")  || tipDate[i].equals("CHARACTER"))
                    {
                        instructiuneSql += "\"" + valori[i] + "\");";
                       // System.out.println("\"" + valori[i] + "\"" + ",");
                    }
                    else if(tipDate[i].equals("TIMESTAMP"))
                    {
                        String dataTabel = valori[i].toString();
                        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
                        java.util.Date parsedDate = sdf.parse(dataTabel);
                        SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
                        instructiuneSql += "\'" + print.format(parsedDate) + "\'" + ");" ;
                    }
                    else
                    {
                        instructiuneSql += valori[i] + ");";
                    } 
                }
            }
            //System.out.println(instructiuneSql);
            //conexiune.prepareStatement(instructiuneSql);
            int numarChei = tabelCheiStraine(numeTabel).size();
            String[] cheiStraineTabel = new String[numarChei];
            String[] referintaCheie = new String[numarChei];
            String[] tabelReferit = new String[numarChei];
            String[] dateTabel = new String[numarChei];
            int l = 0;
            for (Tabele tabel : tabelCheiStraine(numeTabel))
            {
                cheiStraineTabel[l] = String.valueOf(tabel.getTabelCheie());
                referintaCheie[l] = String.valueOf(tabel.getColoanaFK());
                tabelReferit[l] = String.valueOf(tabel.getTabelReferit());
               // System.out.println(cheiStraineTabel[l] + " "+ referintaCheie[l] + " " + tabelReferit[l]);
                l++;
            }
            l = 0;
            // pozitiile pe care se gasesc cheile straine.
            for(int m=0;m<nrColoane;m++)
            {
                for(int n =0; n < cheiStraineTabel.length; n++)
                {
                    if(coloane[m].equals(cheiStraineTabel[n]))
                    {
                        dateTabel[l] = valori[m].toString();
                        l++;
                    }
                }
            }
            //int contor = 0;
            for(int m = 0; m < dateTabel.length;m++)
            {
                int petre = verificareExistenta(referintaCheie[m],tabelReferit[m],dateTabel[m]);
                if (petre == 0)
                {
                    return mesajEroare += "Valoarea " + dateTabel[m] + " nu exista in tabelul " + tabelReferit[m] + ".";
                }
               // contor++;                
            }
            
            //System.out.println(instructiuneSql);
            st.executeUpdate(instructiuneSql); 
            
            conexiune.commit();
            conexiune.close();
            st.close();
            return mesajEroare = "Linie adauga cu succes !"; 
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        } catch (ParseException ex) { 
            Logger.getLogger(DateTabele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static String stergeDate(String numeTabel,Object[] valori)
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate())
        {
            conexiune.setAutoCommit(false); 
            Statement st = conexiune.createStatement();
            int nrColoane = numarColoane(numeTabel);
            String instructiuneSql1 = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + numeTabel + "';";
            ResultSet rs = st.executeQuery(instructiuneSql1);
            String[] coloane = new String[nrColoane];
            int i = 0;
            // salveaza toate coloanele
            while(rs.next())
            {
                coloane[i] = rs.getString(1);
                i++;
            }
            // lista cu toate cheile straine si referinte
            String instructiuneSql2 = "SELECT ccu1.TABLE_NAME,ccu1.COLUMN_NAME, ccu2.COLUMN_NAME,ccu2.TABLE_NAME \n" +
                                     "FROM    INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE ccu1,\n" +
                                     "        INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE ccu2,\n" +
                                     "        INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS rc\n" +
                                     "WHERE   rc.CONSTRAINT_NAME = ccu1.CONSTRAINT_NAME\n" +
                                     "AND     rc.UNIQUE_CONSTRAINT_NAME = ccu2.CONSTRAINT_NAME ";
            ResultSet rr = st.executeQuery(instructiuneSql2);
            int nrTabele = 0;
            String numeTabelCautat[] = new String[50];
            String coloanaDeVerificat[] = new String[50];
            String idVerificat = "";
            while (rr.next()) 
            {
                    if(rr.getString(4).equals(numeTabel))
                    {
                        numeTabelCautat[nrTabele] = rr.getString(1);
                        coloanaDeVerificat[nrTabele] = rr.getString(2);
                        idVerificat = rr.getString(3);
                        nrTabele++;
                    }
                
            }
            Object valoare = new Object[1];
            for(int q=0;q<coloane.length;q++)
            {
                if(coloane[q].equals(idVerificat))
                {
                    valoare = valori[q];
                }
            }
            String mesaj = "";
            //System.out.println(coloanaDeVerificat[0] + " tabel cautat: " + numeTabelCautat[0]);
            int numarColoane = 0;
            int nrAparitii = 0;
            for(int q=0;q<nrTabele;q++)
            {
                String instructiuneSql4 = "SELECT COUNT(COLUMN_NAME) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + numeTabelCautat[q] + "';";
                ResultSet ro = st.executeQuery(instructiuneSql4);
                //System.out.println(instructiuneSql4);
                
                while (ro.next()) 
                {
                     numarColoane = Integer.parseInt(ro.getString(1)); 
                }
                String instructiuneSql3 = "SELECT * FROM " + numeTabelCautat[q] + " WHERE " + coloanaDeVerificat[q] + "=" + valoare.toString();
                //System.out.println(instructiuneSql3);
                ResultSet rt = st.executeQuery(instructiuneSql3);
                while (rt.next()) 
                {
                    for(int linii=1;linii<=numarColoane; linii++)
                    {
                        System.out.print(rt.getString(linii) + " ");
                    } 
                    nrAparitii++;
                    System.out.print("\n");
                }
                //System.out.println("Valoarea apare de " + nrAparitii + " in tabelul : " + numeTabelCautat[q]);
                if(nrAparitii > 0)
                {
                    return mesaj = " Imposibil de șters inregistrarea deoarece tabelul " + numeTabelCautat[q] + " include înregistrări corelate."  + "\n Inregistrarea " + valoare.toString() + " apare de " + nrAparitii + " ori in tabelul " + numeTabelCautat[q];
                }
            }
            
            String instructiuneSql5 = "DELETE FROM " + numeTabel + " WHERE " + coloane[0] + "=" + valori[0]+";";
            st.executeUpdate(instructiuneSql5);
            conexiune.commit();
            conexiune.close();
            st.close();
            return mesaj = "Linia selectata a fost stearsa cu succes.";
        }
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }   
        return null;
    }
    public static int verificareExistenta(String coloana,String tabel,String valoare)
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate())
        {
        conexiune.setAutoCommit(false); 
        Statement st = conexiune.createStatement();
        String instructiuneSql = "SELECT * FROM " + tabel + " WHERE " + coloana + "=" + valoare;
        //System.out.println(instructiuneSql);
        int i = 0;
        ResultSet rs = st.executeQuery(instructiuneSql);
        while(rs.next())
        {
            i++;
        }
        return i;
        }
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        } 
       return 0;
    }
    public static ArrayList<Tabele> indexTabel(String numeTabel)
    {
        ArrayList<Tabele> listaIndex = new ArrayList<Tabele>();
        try(Connection conexiune = ConectareBD.ConectareBazaDate())
        {
        conexiune.setAutoCommit(false); 
        Statement st = conexiune.createStatement();
        String instructiuneSql = "SELECT tc.CONSTRAINT_NAME,cu.COLUMN_NAME,tc.CONSTRAINT_TYPE\n" +
"FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS tc \n" +
"    inner join INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE cu \n" +
"        on cu.CONSTRAINT_NAME = tc.CONSTRAINT_NAME \n" +
"where tc.TABLE_NAME like '" + numeTabel + "' AND tc.CONSTRAINT_TYPE IN ('UNIQUE','PRIMARY KEY')";
        int i = 0;
        ResultSet rs = st.executeQuery(instructiuneSql);
        while(rs.next())
        {
            Tabele adauga = new Tabele();
            String[] numeIndex = rs.getString(1).split("_");
            //adauga.setNumeIndex(numeIndex[1]);
            adauga.setNumeIndex(rs.getString(1));
            adauga.setColoanaIndex(rs.getString(2));
            adauga.setTipIndex(rs.getString(3));
            listaIndex.add(adauga);
            //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
        
        }
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        } 
       return listaIndex;
    }
    public static String adaugaUnique(String numeTabel,String numeColoana,String numeIndex) 
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(true); 
            Statement st = conexiune.createStatement();
            String sql = "CREATE UNIQUE INDEX " + numeIndex + " ON " + numeTabel + " (" + numeColoana +")";
            System.out.println(sql);
            st.executeUpdate(sql);
            conexiune.commit();
            conexiune.close();
            st.close();
            return "Operatiune efectuata cu succes.";
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "Erroare.";
    }
    public static String adaugaPrimary(String numeTabel,String numeColoana,String numeIndex) 
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(false); 
            Statement st = conexiune.createStatement();
            String sql = "ALTER TABLE " + numeTabel + " ADD CONSTRAINT " + numeIndex + " PRIMARY KEY (" + numeColoana +")";
            System.out.println(sql);
            st.executeUpdate(sql);
            conexiune.commit();
            conexiune.close();
            st.close();
            return "Operatiune efectuata cu succes.";
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "Erroare.";
    }
    public static String stergePrimary(String numeTabel,String numeIndex) 
    {
        
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(false); 
            Statement st = conexiune.createStatement();
            String sql = "ALTER TABLE " + numeTabel +" DROP CONSTRAINT " + numeIndex + ";";
            System.out.println(sql);
            st.executeQuery(sql);
            conexiune.commit();
            conexiune.close();
            st.close();
            return "Operatiune efectuata cu succes.";
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "Erroare.";
    }
    public static String stergeUnique(String numeTabel,String numeIndex) 
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(false); 
            Statement st = conexiune.createStatement();
            String sql = "DROP INDEX " + numeIndex + " ON " + numeTabel + ";";
            System.out.println(sql);
            st.executeQuery(sql);
            conexiune.commit();
            conexiune.close();
            st.close();
            return "*Operatiune efectuata cu succes.";
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "Erroare.";
    }
    public static String adaugaColoanaId(String numeTabel)
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(false); 
            Statement st = conexiune.createStatement();
            String instructiuneSQL = "ALTER TABLE " + numeTabel + " ADD Id INTEGER;";
            st.executeUpdate(instructiuneSQL);
            conexiune.commit();
            conexiune.close();
            st.close();
            return "*A fost adaugata coloana Id de tip INTEGER.";
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "Erroare.";
    }
    public static String adaugaPrimaryKey(String numeTabel)
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(false); 
            Statement st = conexiune.createStatement();
            String instructiuneSql = "ALTER TABLE " + numeTabel + " ADD CONSTRAINT PK_" + numeTabel + " PRIMARY KEY (ID);";
            st.executeUpdate(instructiuneSql);
            
            conexiune.commit();
            conexiune.close();
            st.close();
            return "*Coloana Id este acum PRIMARY KEY in tabelul " + numeTabel +".";
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "Erroare.";
    }
    public static String incarcaId(String numeTabel,String numeColoana)
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(false); 
            Statement st = conexiune.createStatement();
            String instructiuneSql = "SELECT " + numeColoana + " FROM " + numeTabel;
            //st.executeQuery(instructiuneSql);
            ResultSet rs = st.executeQuery(instructiuneSql);
            int i = 1;
            while(rs.next())
            {
                String sql = "UPDATE " + numeTabel + " SET Id=" + i + " WHERE " + numeColoana + "='" + rs.getString(1) + "';";
                i++;
                st.executeUpdate(sql);
            }
            conexiune.commit();
            conexiune.close();
            st.close();
            return "*Coloana Id poate fi facuta Primary Key. " + numeTabel +".";
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "Erroare.";
    }
    public static String adaugaColoanaTabelProblema(String numeTabel,String tabelReferit)
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(false); 
            Statement st = conexiune.createStatement();
            String instructiuneSQL = "ALTER TABLE " + numeTabel + " ADD Id_" + tabelReferit + " INTEGER;";
            //System.out.println(instructiuneSQL);
            st.executeUpdate(instructiuneSQL);
            conexiune.commit();
            conexiune.close();
            st.close();
            return "*A fost adaugata coloana Id de tip INTEGER.";
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "Erroare.";
    }
    public static String stergeReferintaProblema(String numeTabel,String coloanaReferita)
    {
        
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            
            conexiune.setAutoCommit(true); 
            Statement st = conexiune.createStatement();
            String instructiuneSql = "SELECT tc.CONSTRAINT_NAME,cu.TABLE_NAME,cu.COLUMN_NAME,tc.TABLE_SCHEMA\n" +
"FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS tc \n" +
" inner join INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE cu \n" +
" on cu.CONSTRAINT_NAME = tc.CONSTRAINT_NAME \n" +
"where tc.TABLE_NAME like '" + numeTabel + "' AND tc.CONSTRAINT_TYPE like 'FOREIGN KEY';";
            //System.out.println(instructiuneSql);
            ResultSet rs = st.executeQuery(instructiuneSql);               
            while(rs.next()) 
            {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                System.out.println(numeTabel + " " + coloanaReferita);
                String table_schema = rs.getString(4);
                if(numeTabel.equals(rs.getString(2)) && coloanaReferita.equals(rs.getString(3)))
                {
                   String[] numeFK = rs.getString(1).split("_");
                   String instructiuneSQL = "ALTER TABLE " + numeTabel + " DROP CONSTRAINT " + rs.getString(1)  + ";";
                   st.executeQuery(instructiuneSQL);
                }
            }            
            conexiune.commit();
            conexiune.close();
            st.close();
            return "*A fost stearsa referinta veche." ;
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "Erroare.";
    }
    public static String referintaNoua(String numeTabel,String tabelReferit)
    {
        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            conexiune.setAutoCommit(true); 
            Statement st = conexiune.createStatement();
            String instructiuneSQL = "ALTER TABLE " + numeTabel +
            " ADD FOREIGN KEY (Id_" + tabelReferit + ") REFERENCES " + tabelReferit + "(Id);";
            //System.out.println(instructiuneSQL);
            st.executeUpdate(instructiuneSQL);
            conexiune.commit();
            conexiune.close();
            st.close();
            return "*A fost adaugata noua referinta.";
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "Erroare.";
    }
    public static String adaugaDateId(String numeTabel,String tabelReferit,String coloanaReferit,String coloanaTabel)
    {

        try(Connection conexiune = ConectareBD.ConectareBazaDate()) 
        {
            ArrayList<Integer> array = new ArrayList<Integer>();
            ArrayList<String>  arrayString = new ArrayList<String>();
            ArrayList<String>  arrayString2 = new ArrayList<String>();
            ArrayList<Integer>  id_uri = new ArrayList<Integer>();
            conexiune.setAutoCommit(false); 
            Statement st = conexiune.createStatement();
            String instructiuneSQL1 = "SELECT " + coloanaTabel + " FROM " + numeTabel;
            ResultSet rs = st.executeQuery(instructiuneSQL1);
            while(rs.next())
            {
                arrayString.add(rs.getString(1));
            }
            String instructiuneSQL2 = "SELECT Id," + coloanaReferit + " FROM " + tabelReferit;
            ResultSet rr = st.executeQuery(instructiuneSQL2);
            while(rr.next())
            {
                arrayString2.add(rr.getString(2));
                id_uri.add(rr.getInt(1));
            }
            for(int i = 0;i<arrayString.size();i++)
            {
                for(int j = 0;j<arrayString.size();j++)
                {
                    if(arrayString.get(i).toString().equals(arrayString2.get(j).toString()))
                    {
                         array.add(id_uri.get(j));
                         System.out.println(id_uri.get(j));
                    }
                }
            }
            for(int i = 0; i<arrayString.size();i++)
            {
               String instructiuneSQL3 = "UPDATE " + numeTabel + " SET Id_" + tabelReferit + "=" + array.get(i) +
               " WHERE " + coloanaTabel + "='" + arrayString.get(i) + "';";
                //System.out.println(instructiuneSQL3);
                st.executeUpdate(instructiuneSQL3);  
            }
            //System.out.println(instructiuneSQL2);
            conexiune.commit();
            conexiune.close();
            st.close();   
            return "*Au fost adaugate id-urile in coloana Id_" + tabelReferit;
        } 
        catch (SQLException ex) 
        {
             ex.printStackTrace();
        }
        return "";
    }
}