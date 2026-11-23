# Kaminari Dojo 2.0 – Firebase RTDB integráció

## Felismert meglévő infrastruktúra
A jelenlegi `dojo.html` már csatlakozik a `kaminari-dojo` Firebase Realtime Database projekthez, és a `public` útvonalról olvas. **Nem kell új Firebase projektet létrehozni.** A GitHub Pages és az éles app egyelőre változatlan.

## Szükséges adminfiók
A Firebase Console Authentication felületén engedélyezni kell az Email/Password bejelentkezést, és létre kell hozni a kizárólagos adminfiókot. Az admin UID-jét be kell írni a `firebase/database.rules.json` fájl `REPLACE_WITH_ADMIN_UID` helyőrzői helyére. A jelszó és a belépési token soha nem kerülhet a GitHubba.

## Biztonsági szabályok
A `firebase/database.rules.json` tervezet: a `public`, `achievements` és `competitions` olvasható, de csak admin írhat; a `private` teljesen admin-only. A gyermekek befizetései és nevezései kizárólag a `private` alatt lehetnek. A szabályokat **nem telepítettük**, és nem szabad őket a meglévő szabályok összevetése nélkül felülírni. A nyilvános gyermeknév-alapú nevezéshez szerveroldali védelem kell; anonim, korlátlan közvetlen írás a Realtime Database-be nem engedhető meg.

## Adatmodell
- `private/students/{id}`: név, csoport, aktív státusz
- `private/fee_obligations/{id}`: studentId, hónap (YYYY-MM), összeg
- `private/fee_payments/{id}`: studentId, hónap, összeg, dátum
- `private/responses/{competitionId}/{id}`: gyermek neve, válasz, időbélyeg (csak admin olvassa)
- `competitions/{id}`: publikus verseny, határidő, státusz
- `achievements/{id}`: csak hozzájárulással közzétett eredmény
- `private/analytics/{date}`: látogatottsági összesítés; a kliensoldali látogatottság önmagában nem hiteles mérés

## Blokkolók az élesítéshez
1. Firebase Authentication adminfiók/UID beállítása és biztonsági szabályok telepítése.
2. A meglévő `public` adatok és szabályok mentése, kompatibilitás ellenőrzése.
3. A névvel történő nyilvános versenyválasz beküldéshez hitelesítés, szerveroldali limit vagy moderált megoldás választása.
4. Negatív jogosultsági tesztek, többeszközös tesztek, adatkezelési tájékoztató.
5. Csak ezek után éles integráció. Ne használj valós tanítványadatokat a prototípusban.
