package com.example.movieapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val id: Long = 0,
                 val movieTitle: String? = getDefaultTitle(),
                 val movieGenre: String? = getDefaultGenre(),
                 val yearOfRelease: Int? = 0,
                 val movieDuration: Int? = 0,
                 val overview: String? = "",
                 val poster: String? = "")
    : Parcelable {
}

fun getDefaultGenre() = "Жанр"

fun getDefaultTitle() = "Название фильма"

fun getHorrorMovies() = mutableListOf(
            Movie(274,"Молчание ягнят", "ужасы", 1991,114, "", "https://fs.kinomania.ru/file/film_poster/1/ce/1ce927f875864094e3906a4a0b5ece68.jpeg"),
            Movie(9003,"Восставший из ада", "ужасы", 1987,93, "", "https://fs.kinomania.ru/file/film_poster/5/00/500bcbcf4f48df874b9dbe4059700824.jpeg"),
            Movie(19614,"Оно", "ужасы", 1990,135, "", "https://fs.kinomania.ru/file/film_poster/6/fc/6fca0a1bb7df30924337f674e82eb6a2.jpeg"),
            Movie(138843,"Заклятие", "ужасы", 2013,112, "", "https://fs.kinomania.ru/file/film_poster/3/79/3793d4a04ccb4c3272853bc526c2c8a6.jpeg"),
            Movie(49018,"Астрал", "ужасы", 2010,103, "", "https://fs.kinomania.ru/file/film_poster/3/eb/3eb81a0ff05d44147f7b43d1577423d0.jpeg"),
            Movie(447332,"Тихое место", "ужасы", 2018,90,"", "https://fs.kinomania.ru/file/film_poster/3/80/380bd14a4f13c7bb03578a261f30e36c.jpeg"),
            Movie(68315,"Мгла", "ужасы", 2017,126, "", "https://fs.kinomania.ru/file/film_poster/9/a4/9a449adf7ad6d4c723729bda45432952.jpeg"),
            Movie(565,"Звонок", "ужасы", 2002,115, "", "https://fs.kinomania.ru/file/film_poster/6/05/605ff764c617d3cd28dbbdd72be8f9a2.jpeg"),
            Movie(9378,"Триннадцать привидений", "ужасы", 2001,91,"", "https://fs.kinomania.ru/file/film_poster/2/10/210f760a89db30aa72ca258a3483cc7f.jpeg"),
            Movie(13515,"Зеркала", "ужасы", 2008,110,"", "https://fs.kinomania.ru/file/film_poster/6/87/687cb95f9d89142b67e41ab640c0a002.jpeg"),
            Movie(270303, "Оно идет", "ужасы", 2014,96,"", "https://fs.kinomania.ru/file/film_poster/9/a6/9a66960fb7046d727890d55948ed4aab.jpeg"),
            Movie(555974,"Кукла 2", "ужасы", 2020,98,"", "https://fs.kinomania.ru/file/film_poster/1/1a/11a89ff72581c5a60b0b710a67c52eec.jpeg")
    )


fun getThrillerMovies() = mutableListOf(
            Movie(210577,"Исчезнувшая", "триллеры", 2014,149, "", "https://fs.kinomania.ru/file/film_poster/2/34/234b033c03e12b62d13954a9ae8d9826.jpeg"),
            Movie(27205,"Начало", "триллеры", 2010,148, "", "https://fs.kinomania.ru/file/film_poster/0/b5/0b5f021b66f796db68b2fa8b601b0f8a.jpeg"),
            Movie(478820,"Видок", "триллеры", 2018,127, "", "https://fs.kinomania.ru/file/film_poster/1/7f/17facdf9270e10be84c1eaf4baf43a62.jpeg"),
            Movie(1124,"Престиж", "триллеры", 2006,125, "", "https://fs.kinomania.ru/file/film_poster/f/b4/fb4ab556bc42d6f0ee0f9e24ec4d1af0.jpeg"),
            Movie(591,"Код да Винчи", "триллеры", 2006,149, "", "https://fs.kinomania.ru/file/film_poster/f/31/f3144cefe89a60d6a1afaf7859c5076b.jpeg"),
            Movie(207933,"Обитель порклятых", "триллеры", 2014,112, "", "https://fs.kinomania.ru/file/film_poster/b/04/b04a38ef3dabd2dcb05fa04bd80629d1.jpeg"),
            Movie(4553,"Машинист", "триллеры", 2003,97, "", "https://fs.kinomania.ru/file/film_poster/9/3f/93f03de4966b294a610d813b9eaef3c2.jpeg"),
            Movie(185,"Заводной апельсин", "триллеры", 1971,137, "", "https://fs.kinomania.ru/file/film_poster/6/f3/6f3e24662182e125fc58299809ee6a67.jpeg"),
            Movie(9963,"Предчуствие", "триллеры", 2007,96, "", "https://fs.kinomania.ru/file/film_poster/d/fe/dfea0768cc6ba51dd20c7224016b0bd7.jpeg"),
            Movie(11324,"Остров проклятых", "триллеры", 2010,138, "", "https://fs.kinomania.ru/file/film_poster/4/fc/4fc5e22514f6323e66d2226402fcc8fc.jpeg"),
            Movie(622,"Девятые врата", "триллеры", 1999,133, "", "https://fs.kinomania.ru/file/film_poster/0/2e/02e8884e3ac1b165428fffd37411218c.jpeg"),
            Movie(22825,"Посылка", "триллеры", 2009,115, "", "https://fs.kinomania.ru/file/film_poster/4/7c/47c25f64f2b40398afb5cd9e67e53f28.jpeg")
    )


fun getComedyMovies() = mutableListOf(
            Movie(2330,"Такси", "комедии", 1998,86, "", ""),
            Movie(120467,"Отель Гранд Будапешт", "комедии", 2014,100, "", ""),
            Movie(246741,"Реальные упыри", "комедии", 2014,86, "", ""),
            Movie(18785,"Мальчишник в Вегвсе", "комедии", 2009,96, "", ""),
            Movie(337404,"Круэлла", "комедии", 2021,100, "", ""),
            Movie(771,"Один дома", "комедии", 1990,103, "", ""),
            Movie(3049,"Эйс Вентура", "комедии", 1993,86, "", ""),
            Movie(11008,"Майор Пэйн", "комедии", 1995,95, "", ""),
            Movie(854,"Маска", "комедии", 1994,100, "", ""),
            Movie(9352,"Евротур", "комедии", 2004,90, "", ""),
            Movie(20871,"Джентельмены удачи", "комедии", 1971,84, "", ""),
            Movie(496,"Борат", "комедии", 2006,84, "", "")
    )


fun getSerials() =  mutableListOf(
            Movie(19995,"Аватар", "фантастика", 2009, 162, "", ""),
            Movie(9947,"Электра", "фантастика", 2005, 97, "", ""),
            Movie(603,"Матрица", "фантастика", 1999, 136, "", ""),
            Movie(37924,"Суинни Тодд", "фантастика", 2006, 90, "", ""),
            Movie(157336,"Интерстеллар", "фантастика", 2014, 169, "", ""),
            Movie(241259,"Алиса в Зазеркалье", "фантастика", 2016, 112, "", ""),
            Movie(2668,"Сонная лощина", "фантастика", 1999, 105, "", ""),
            Movie(62213,"Мрачные тени", "фантастика", 2012, 103, "", ""),
            Movie(335983,"Веном", "фантастика", 2018, 102, "", ""),
            Movie(283366,"Дом странных детей мисс Перегрин", "фантастика", 2016, 126, "", ""),
            Movie(120,"Властелин колец: Братство кольца", "фантастика", 2001, 179, "", ""),
            Movie(561,"Константин", "фантастика", 2005, 121, "", "")
    )


    fun getDefault() = mutableListOf(
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0),
                Movie(0,"", "", 0,0)
        )

