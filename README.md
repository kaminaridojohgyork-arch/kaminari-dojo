# Kaminari Dojo – Android prototípus

Ingyenes, offline Android alkalmazás. A tagdíjak 4 csoporthoz külön, tanévenként szerkeszthetők. A főnézet automatikusan az aktuális hónapot mutatja, az éves táblázat és a csoportonként feltöltött fotó külön megnyitható.

**Fontos:** az adatok és képek kizárólag azon a telefonon tárolódnak, ahol beállítják őket. Nincs központi adatbázis, többkészülékes szinkron, felhasználói bejelentkezés vagy adminvédelem. Ezért ez még nem a szülőknek terjeszthető végleges verzió.

## APK elkészítése GitHubon

1. Töltsd fel a ZIP **kicsomagolt tartalmát**, a mappaszerkezetet megtartva a repository gyökerébe.
2. Commit changes.
3. Actions → Android APK → legutóbbi sikeres futás → Artifacts → Kaminari-Dojo-APK.
4. Az artifact ZIP-ben található `app-debug.apk` telepíthető Androidra. A telefon figyelmeztethet ismeretlen forrásra.

A GitHub Actions ingyenes kerete és az Android buildkörnyezet elérhetősége változhat. A projekt nem igényel fizetős tárhelyet.
