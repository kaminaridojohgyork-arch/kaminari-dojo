# Kaminari Dojo – bővített Android alkalmazás

## Tartalom
Kék villámos Kaminari háttér, embléma és alkalmazásikon. Főoldal, edzésidők, események, hírek, tagdíjak (4 csoport, szeptember–június), vizsgainformációk, galéria, kapcsolat, PIN-es helyi admin, JSON biztonsági mentés és import.

## Feltöltés GitHubra
A ZIP-et **csomagold ki**, és a benne levő `app`, `.github` mappákat és gyökérfájlokat a `kaminari-dojo` repository gyökerébe töltsd fel a mappastruktúrát megtartva. A régi, gyökérben levő `index.html`, `MainActivity.java`, `AndroidManifest.xml` stb. fájlokat nem használja a build: a helyes fájlok az `app/src/main/` alatt vannak. GitHub Actions → Android APK → sikeres futás → Artifacts → Kaminari-Dojo-APK → `app-debug.apk`.

**Figyelem:** ez offline prototípus, a telefonon végzett admin módosítások nem jutnak el más készülékekre. A PIN csak helyi védelem. A szülőknek központilag frissülő változathoz később közös adatszolgáltatás szükséges. Az edzésidőket és eseményeket közzététel előtt ellenőrizd.
