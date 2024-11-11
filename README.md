# testAndroid-Brighton

Ini adalah proyek Android yang menunjukkan penggunaan arsitektur MVVM (Model-View-ViewModel) bersama dengan komponen arsitektur Android modern. Proyek ini menyediakan titik awal yang terstruktur untuk membangun aplikasi Android yang mudah dimaintenance, dapat ditest, dan dapat dikembangkan lebih lanjut.

## Project Overview

Proyek TestAndroid-Brighton dirancang untuk menampilkan pola arsitektur MVVM dalam pengembangan Android, yang menggabungkan praktik terbaik dalam manajemen data, pemisahan UI, dan library eksternal. Proyek ini menggunakan beberapa library untuk mempermudah pemuatan gambar, permintaan jaringan, dan pengelolaan library sehingga menghasilkan fondasi yang kuat dan efisien.

## Technologies and Libraries Used

  - [Kotlin](https://kotlinlang.org/): Bahasa pemrograman utama untuk pengembangan Android.
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding): Menghasilkan kelas binding untuk file layout XML sehingga mempermudah binding komponen view.
  - [Glide](https://bumptech.github.io/glide/): Pustaka pemuatan gambar yang cepat dan efisien untuk Android.
  - [Retrofit](https://square.github.io/retrofit/): HTTP client yang aman untuk membuat permintaan jaringan.
  - [OkHttp Logging Interceptor](https://square.github.io/okhttp/features/interceptors/): Melacak permintaan dan respons jaringan untuk mempermudah debugging.
  - [Activity KTX](https://developer.android.com/kotlin/ktx): Ekstensi untuk AndroidX Activity yang menyediakan API Kotlin.
  - [Lifecycle ViewModel](https://developer.android.com/jetpack/androidx/releases/lifecycle): Mengelola data UI yang mengikuti siklus hidup komponen.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata): Kelas penyimpan data yang dapat diamati untuk menangani data komponen UI.
  - [DataStore Preferences](https://developer.android.com/topic/libraries/architecture/datastore): Memberikan mekanisme penyimpanan key-value sederhana sebagai alternatif dari SharedPreferences.
  - [Material Favorite Button](https://github.com/IvBaranov/MaterialFavoriteButton): Tombol yang dapat dikustomisasi dengan status favorit/tidak favorit.

## Screenshot

<p align="center">
  <img src="https://drive.google.com/uc?export=view&id=1PASVs08OUmAE02RPW5NV7xfWdHYbvJIB" width="200">
  <img src="https://drive.google.com/uc?export=view&id=1db131ie-bTloZFdRKuiLD8v0IJ23wbDF" width="200">
  <img src="https://drive.google.com/uc?export=view&id=186uCV0E-z9hKqZA2Rxk87JD-NXRazgmI" width="200">
</p>

## Project Structure
- Pola **MVVM**: Memisahkan manajemen data, UI, dan logika bisnis.
  - Model: Mengelola data dan logika bisnis.
  - View: Merender komponen UI berdasarkan data yang diterima dari ViewModel.
  -  ViewModel: Mengelola komunikasi data antara View dan Model.

## Features
  - Arsitektur MVVM: Memberikan pemisahan tanggung jawab yang jelas.
  - Permintaan Jaringan dengan Retrofit: Mempermudah komunikasi dengan layanan web.
  - Pemuatan Gambar dengan Glide: Mengelola pemuatan dan caching gambar secara efisien.
  - Penyimpanan Data dengan DataStore: Mempermudah penyimpanan dan pengambilan data.
  - ViewBinding: Mengurangi kode boilerplate dan meningkatkan keterbacaan.

# ~ ありがとう

Surabaya, November 11, 2024
