# Kaminari Dojo 2.0 – megvalósítási terv

## Állapot
Az első négyfunkciós prototípus a `prototype/dojo-2-demo.html` fájlban található. Ez csak helyi, fiktív tesztadatokkal használható. A főág és az éles alkalmazás változatlan.

## Követelmények
1. **Tagdíj**: csak admin látja a tanítványok nevét, havi előírását, befizetését és hátralékát. Csoportok: Hévízgyörk kezdő, Hévízgyörk középhaladó, Tura, Óvoda. Részfizetés, tört hónap, inaktiválás, CSV export.
2. **Verseny**: szülői űrlap csak gyermek neve és „Jövök / Nem jövök” választással; az esemény és határidő az eseményhez tartozik. A jelentkezés nyilvános, az összesített névsor csak adminnak látható. Más nevében történő módosítás és automatizált spam elleni védelem szükséges.
3. **Dicsőségfal**: nyilvános eredmények, admin által publikálva; gyermeknév és fénykép csak megfelelő hozzájárulással.
4. **Statisztika**: admin látja a létszámot, bevételt, hátralékot, versenyválaszokat és – külön megvalósítással – napi/heti/havi látogatottságot.

## Biztonsági követelmények
- GitHub Pages statikus frontend; személyes és pénzügyi adatok nem kerülhetnek publikus GitHub-repozitóriumba vagy nyilvános JSON fájlba.
- A jelenlegi localStorage/PIN **nem** alkalmas szerveroldali jogosultságkezelésre.
- Valódi backend és adminhitelesítés (például Firebase Authentication + Firestore Security Rules) szükséges. A szabályokat negatív tesztekkel is ellenőrizni kell: vendég nem olvashat tagdíjat, nem írhat eredményt, nem listázhat nevezéseket.
- A nyilvános nevezéshez rate limit / botvédelem, duplikációkezelés, határidő-ellenőrzés és adatmegőrzési szabályok szükségesek. Bejelentkezés nélkül egy név nem hitelesíti a szülőt; a válaszmódosítást külön védeni kell.
- Élesítés előtt adatkezelési tájékoztató és gyermekek adatainak minimalizálása.

## Műszaki lépések
1. Meglévő app, PWA, Android APK wrapper, service worker és adattárolás felmérése; mentés.
2. Ingyenes szolgáltatási keret, fiók és biztonsági beállítások ellenőrzése; szolgáltatói jóváhagyás, ha kell.
3. Szerveroldali adatmodell: students, fee_obligations, fee_payments, competitions, responses, achievements; külön admin role.
4. Felület integrálása a meglévő `dojo.html` menürendszerébe; a tagdíjak és statisztika csak valóban hitelesített adminnak.
5. Tesztek: több eszköz közötti szinkron, hozzáférési szabályok, versenyhatáridő, ismételt nevezés, részfizetés, CSV, mobil kijelzők.
6. Android APK és iOS PWA cache/frissítés vizsgálata. Újratelepítés nélküliség csak sikeres teszt után ígérhető.
7. Élesítés külön ellenőrzéssel, visszaállítási tervvel.

## Költség
A GitHub Pages statikus tárhely jelenleg használható; a központi backend ingyenessége szolgáltatási feltételektől, konfigurációtól és forgalomtól függ. A 0 Ft/hó nem garantálható teszt és kvótaellenőrzés nélkül.

## Készültség
- [x] Elkülönített GitHub fejlesztői ág
- [x] Négyfunkciós helyi UI prototípus
- [ ] Valódi backend és szerveroldali hozzáférés
- [ ] Éles app integráció
- [ ] Többeszközös és biztonsági tesztek
- [ ] Élesítés
