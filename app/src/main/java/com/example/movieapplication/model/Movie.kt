package com.example.movieapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val movieTitle: String = getDefaultTitle(), val movieGenre: String= getDefaultGenre(), val yearOfRelease: Int = 0, val movieDuration: Int = 0)
        : Parcelable{
}

fun getDefaultGenre() = "Жанр"

fun getDefaultTitle() = "Название фильма"

fun getHorrorMovies() : MutableList<Movie>{
    return mutableListOf(
            Movie("Молчание ягнят", "ужасы", 1991,114),
            Movie("Восставший из ада", "ужасы", 1987,93),
            Movie("Оно", "ужасы", 2017,135),
            Movie("Визит", "ужасы", 2015,94),
            Movie("Астрал", "ужасы", 2010,103),
            Movie("Тихое место", "ужасы", 2018,90),
            Movie("Мгла", "ужасы", 2007,126),
            Movie("Звонок", "ужасы", 2002,115),
            Movie("Триннадцать приведений", "ужасы", 2001,91),
            Movie("Зеркала", "ужасы", 2008,110),
            Movie("Оно идет", "ужасы", 2014,96),
            Movie("Кукла", "ужасы", 2016,98)
    )
}

fun getThrillerMovies() : MutableList<Movie>{
    return mutableListOf(
            Movie("Исчезнувшая", "триллеры", 2014,149),
            Movie("Начало", "триллеры", 2010,148),
            Movie("Семь", "триллеры", 1995,127),
            Movie("Престиж", "триллеры", 2006,125),
            Movie("Код да Винчи", "триллеры", 2006,149),
            Movie("Обитель порклятых", "триллеры", 2014,112),
            Movie("Машинист", "триллеры", 2003,97),
            Movie("Заводной апельсин", "триллеры", 1971,137),
            Movie("Предчуствие", "триллеры", 2007,96),
            Movie("Остров проклятых", "триллеры", 2010,138),
            Movie("Девятые врата", "триллеры", 1999,133),
            Movie("Посылка", "триллеры", 2009,115)
    )
}

fun getComedyMovies() : MutableList<Movie>{
    return mutableListOf(
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0),
            Movie("", "комедии", 0,0)
    )
}

fun getSerials() : MutableList<Movie> {
    return mutableListOf(
            Movie("Особняк красной розы", "сериалы", 2002, 0),
            Movie("Американская история ужасов", "сериалы", 2011, 0),
            Movie("Потерянная комната", "сериалы", 2006, 0),
            Movie("Ганнибал", "сериалы", 2013, 0),
            Movie("Друзья", "сериалы", 1994, 0),
            Movie("", "сериалы", 0, 0),
            Movie("", "сериалы", 0, 0),
            Movie("", "сериалы", 0, 0),
            Movie("", "сериалы", 0, 0),
            Movie("", "сериалы", 0, 0),
            Movie("", "сериалы", 0, 0),
            Movie("", "сериалы", 0, 0)
    )
}

    fun getDefault() : MutableList<Movie>{
        return mutableListOf(
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0)
        )
}