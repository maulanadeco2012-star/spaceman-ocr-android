# Spaceman OCR Signal — proyek Android

**Ini source project, bukan APK siap instal.** Belum dikompilasi atau diuji pada perangkat pengguna.

## Build APK
1. Buka folder ini dengan Android Studio di komputer.
2. Tunggu Gradle sync; internet diperlukan untuk mengunduh dependensi.
3. Pilih **Build > Build APK(s)**.
4. APK debug biasanya ada di `app/build/outputs/apk/debug/app-debug.apk`.
5. Pindahkan APK ke Android dan instal. Berikan izin instalasi dari sumber tersebut jika Android memintanya.

## Penggunaan
1. Tekan **Mulai tangkap layar**, lalu setujui dialog izin berbagi layar Android.
2. Sistem akan menangkap layar dan mencoba membaca teks dengan ML Kit.
3. Periksa angka kandidat. Tekan konfirmasi hanya jika benar; jika tidak, gunakan input manual.
4. Tekan **Hentikan tangkapan** untuk berhenti.

## Batasan
- OCR dapat salah membaca jam, baterai, atau angka lain. Wajib verifikasi manual.
- Beberapa perangkat/aplikasi dapat membatasi tangkapan layar; perilaku bergantung versi Android.
- Riwayat hanya tersimpan selama aplikasi berjalan dan belum disimpan permanen.
- Tidak ada auto-bet atau auto cashout. Sinyal TUNGGU bukan prediksi hasil; hasil permainan tidak dapat dipastikan.
