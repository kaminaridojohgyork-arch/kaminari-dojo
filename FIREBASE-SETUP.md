# Kaminari Dojo – központi szinkronizálás előkészítése

A jelenlegi Android APK helyi localStorage adatokat használ. A GitHub Pages iOS PWA jelenleg megtekintési prototípus, nem szinkronizál.

## Firebase beállítás (későbbi aktiválás)
1. Hozz létre Firebase projektet a https://console.firebase.google.com oldalon.
2. Adj hozzá egy webalkalmazást, és másold ki a **webes Firebase config** adatait (apiKey, authDomain, databaseURL, projectId, appId).
3. Kapcsold be az Authentication → Sign-in method → Email/Password lehetőséget. Csak egy adminisztrátori felhasználót hozz létre; a szülőknek nem kell belépniük.
4. Hozz létre **Realtime Database** adatbázist zárolt módban. A `databaseURL` ennek pontos címe legyen.
5. Az admin UID-ját másold be a `firebase.database.rules.json` fájlban a `REPLACE_WITH_ADMIN_UID` helyére, és csak utána publikáld a szabályokat a Firebase konzolban.
6. A képeket és Word/PDF vizsgaanyagokat később külön, megfelelő hozzáférési szabályokkal kezeljük. A Firebase Storage ingyenessége és számlázási feltételei projektfüggők; a teljesen ingyenes működéshez szükség esetén GitHub-alapú publikus fájltárolást használunk.

**Biztonság:** soha ne tegyél fel GitHubra admin jelszót, privát kulcsot vagy service account JSON-t. A webes Firebase config önmagában nem titok, de a szabályok kritikusak. A helyi PIN nem biztosít online védelmet.

**Adatvédelem:** nyilvános adatbáziságra csak mindenki számára megtekinthető hírek, események, díjtáblák és engedélyezett képek kerülhetnek. Tanulók személyes adatai, egyéni befizetései nem.
