# DBMS-JAVA-Normalizarea-cheilor-straine

Pentru dezvoltarea aplicației a fost folosit limbajul JAVA împreuna cu DBMS-ul MS Office Access.

Având o baza de date se dorește impunerea integrității datelor.
<ol>
<li> Daca în tabel există cheie străine la fiecare rând din tabelul copil trebuie să se potrivească cu un rând din tabela parinte. </li>
<li> La ștergerea unui rând din tabelul părinte se face o verificare dacă nu există în tabelul copil unul sau mai multe rânduri cu valoarea respectivă. </li>
  <li> La încercarea de a șterge un tabel aplicația nu va permite ștergerea tabelelor care fac parte dintr-o constrângere FOREIGN KEY.</li>
  <li> Coloanele cheie straine și coloanele referite trebuie sa fie de același tip de date.</li>
  <li> Coloanele referite trebuie sa fie PRIMARY KEY sau un INDEX UNIQUE.</li>
  <li> Pentru coloanele chei străine care au tipul de date diferit de INTEGER vor fi realizate operații pentru adaugarea unei relații de tip INTEGER.(Ștergerea referinței și adaugarea unei noi referințe pe coloane de tip INTEGER).</li>
</ol>

Aplicația va primi ca input baza de date selectata de utilizator și va afișa în interfața lista tabelelor existente în baza de date. Prin selectarea unui tabel și acționarea butonului “Selecteaza linia” în interfață vor fi afișate coloanele tabelului selectat , informații despre acestea, cheile straine existente,referințe și datele din tabelul respectiv.
