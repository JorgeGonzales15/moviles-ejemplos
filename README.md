# moviles-ejemplos

Dependencias:
retrofit
com.squareup.retrofit2

converter-gson
com.squareup.retrofit2

landscapist-glide
com.github.skydoves

navigation-compose
androidx.navigation

room-compiler
androidx.room as annotationProcessor

room-runtime
androidx.room

en build.gradle.kts:

plugins {
    id("org.jetbrains.kotlin.kapt")
}

dependencies {
val roomVersion = "2.6.1"
    kapt("androidx.room:room-compiler:$roomVersion")
}

PERMISO:
<uses-permission android:name="android.permission.INTERNET"/>

PARA MYAPPLICATION en manifest dentro de <application:
android:name=".MyApplication"

otros:
material-icons-extended

----------
APIS:

eatsexplorer: 
https://plain-marbled-muskox.glitch.me/restaurants/

friendfindr;
https://randomuser.me/api/

superhero:
https://www.superheroapi.com/api.php/10157703717092094/search/{name}
https://www.superheroapi.com/api.php/"10157703717092094/{id}

applistproduct:
https://api.spoonacular.com/food/products/search?query=arroz&number=50&apiKey=979b107215934f4786cde0970b5cfe0a

moviecompose:
Populares
https://api.themoviedb.org/3/movie/popular?&api_key=3cae426b920b29ed2fb1c0749f258325
Mejores puntuación
https://api.themoviedb.org/3/movie/top_rated?&api_key=3cae426b920b29ed2fb1c0749f258325
Por estreno
https://api.themoviedb.org/3/movie/upcoming?&api_key=3cae426b920b29ed2fb1c0749f258325
