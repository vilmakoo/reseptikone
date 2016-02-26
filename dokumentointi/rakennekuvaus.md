Ohjelmassa on neljä niin kutsuttua näkymää. Päänäkymä avautuu heti ohjelmaa avatessa ja se sisältää listan kaikista ainesosista ja nappeja, joita painamalla voi joko etsiä reseptin, listata kaikki reseptit, lisätä oman reseptin tai tyhjentää valitut ainesosat ohjelman muistista.

Reseptiä etsittäessä otetaan käyttäjän valitsemat ainesosat ja käydään läpi kaikki koneeseen tallennetut reseptit. Reseptit on tallennettu niin, että yhdessä tiedostossa on reseptin ainesosat ja toisessa ohje, minkä lisäksi yhteen tiedostoon on tallennettu kaikkien reseptien nimet. Reseptinetsijä valitsee resepteistä sen, josta käyttäjältä puuttuu vähiten ainesosia. Jos ainesosia puuttuu, muodostetaan kauppalista.

Reseptien listauksessa reseptien nimet luetaan tiedostosta ja jokaiselle reseptille tehdään nappi, jota painamalla reseptiä pääsee katsomaan. Reseptinäkymässä näkyy reseptin nimi ja ohje sekä mahdollinen kauppalista (jos reseptinäkymään on päädytty reseptin etsimisen kautta).

Reseptiä lisättäessä pyydetään käyttäjältä uniikki reseptin nimi, sen ainesosat ja ohje. Jos jokin puuttuu, ohjelma antaa käyttäjäystävällisen virheilmoituksen. Kaiken mennessä oikein kirjoitetaan reseptin tiedot TiedostoonKirjoittajan avulla muistiin.

Reseptejä käytetään reseptiluokan avulla, joka TiedostonLukijan avulla lukee reseptin tiedot ja lisää ne oliomuuttujiin.
