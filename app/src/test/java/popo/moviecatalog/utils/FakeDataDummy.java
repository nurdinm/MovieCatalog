package popo.moviecatalog.utils;

import java.util.ArrayList;

import popo.moviecatalog.data.source.local.entity.FilmCastEntity;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.local.entity.FilmGenreEntity;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.data.source.remote.response.CastResponse;
import popo.moviecatalog.data.source.remote.response.GenreResponse;
import popo.moviecatalog.data.source.remote.response.MoviesResponse;

public class FakeDataDummy {
    public static ArrayList<FilmEntity> generateDummyMovies(){
        ArrayList<FilmEntity> filmEntities = new ArrayList<>();

        filmEntities.add(new FilmEntity(
                "01",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "October 5, 2018",
                "poster_a_start_is_born",
                "7.5",
                "2h 15m",
                "English",
                "$433,888,866.00",
                false));
        filmEntities.add(new FilmEntity(
                "02",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "December 7, 2018",
                "poster_aquaman",
                "6.8",
                "2h 24m",
                "English",
                "$1,143,689,193.00",
                false));
        filmEntities.add(new FilmEntity(
                "03",
                "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "November 21, 2018",
                "poster_robin_hood",
                "5.8",
                "1h 56m",
                "English",
                "$73,260,114.00",
                false));
        filmEntities.add(new FilmEntity(
                "04",
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "November 27, 2018",
                "poster_mortal_engines",
                "6.0",
                "2h 9m",
                "English",
                "$104,236,467.00",
                false));
        filmEntities.add(new FilmEntity(
                "05",
                "Cold Persuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "February 7, 2019",
                "poster_cold_persuit",
                "5.4",
                "1h 59m",
                "English",
                "$59,213,931.00",
                false));

        return filmEntities;
    }

    public static ArrayList<TvShowEntity> generateDummyTvShow(){
        ArrayList<TvShowEntity> filmEntities = new ArrayList<>();

        filmEntities.add(new TvShowEntity(
                "01",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "October 10, 2012",
                "poster_arrow",
                "5.8",
                "42m",
                "English",
                "-",
                false));
        filmEntities.add(new TvShowEntity(
                "02",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "February 15, 2019",
                "poster_doom_patrol",
                "6.4",
                "60m",
                "English",
                "-",
                false));
        filmEntities.add(new TvShowEntity(
                "03",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "February 26, 1986",
                "poster_dragon_ball",
                "7.1",
                "25m",
                "Japanese",
                "-",
                false));
        filmEntities.add(new TvShowEntity(
                "04",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "October 12, 2009",
                "poster_fairytail",
                "6.5",
                "25m",
                "Japanese",
                "-",false));
        filmEntities.add(new TvShowEntity(
                "05",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "January 31, 1999",
                "poster_family_guy",
                "6.5",
                "22m",
                "English",
                "-",
                false));

        return filmEntities;
    }

    public static ArrayList<MoviesResponse> generateRemoteDummyMovies(){
        ArrayList<MoviesResponse> filmEntities = new ArrayList<>();

        filmEntities.add(new MoviesResponse(
                "01",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "October 5, 2018",
                "poster_a_start_is_born",
                "7.5",
                "2h 15m",
                "English",
                "$433,888,866.00"));
        filmEntities.add(new MoviesResponse(
                "02",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "December 7, 2018",
                "poster_aquaman",
                "6.8",
                "2h 24m",
                "English",
                "$1,143,689,193.00"));
        filmEntities.add(new MoviesResponse(
                "03",
                "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "November 21, 2018",
                "poster_robin_hood",
                "5.8",
                "1h 56m",
                "English",
                "$73,260,114.00"));
        filmEntities.add(new MoviesResponse(
                "04",
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "November 27, 2018",
                "poster_mortal_engines",
                "6.0",
                "2h 9m",
                "English",
                "$104,236,467.00"));
        filmEntities.add(new MoviesResponse(
                "05",
                "Cold Persuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "February 7, 2019",
                "poster_cold_persuit",
                "5.4",
                "1h 59m",
                "English",
                "$59,213,931.00"));

        return filmEntities;
    }

    public static ArrayList<MoviesResponse> generateRemoteDummyTvShow(){
        ArrayList<MoviesResponse> filmEntities = new ArrayList<>();

        filmEntities.add(new MoviesResponse(
                "01",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "October 10, 2012",
                "poster_arrow",
                "5.8",
                "42m",
                "English",
                "-"));
        filmEntities.add(new MoviesResponse(
                "02",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "February 15, 2019",
                "poster_doom_patrol",
                "6.4",
                "60m",
                "English",
                "-"));
        filmEntities.add(new MoviesResponse(
                "03",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "February 26, 1986",
                "poster_dragon_ball",
                "7.1",
                "25m",
                "Japanese",
                "-"));
        filmEntities.add(new MoviesResponse(
                "04",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "October 12, 2009",
                "poster_fairytail",
                "6.5",
                "25m",
                "Japanese",
                "-"));
        filmEntities.add(new MoviesResponse(
                "05",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "January 31, 1999",
                "poster_family_guy",
                "6.5",
                "22m",
                "English",
                "-"));

        return filmEntities;
    }

    public static ArrayList<FilmCastEntity> generateCastFilm(String filmId){
        ArrayList<FilmCastEntity> cast = new ArrayList<>();
        cast.add(new FilmCastEntity(
                "1",
                filmId,
                "profile_11",
                "Lady Gaga",
                "Ally Campana"));
        cast.add(new FilmCastEntity(
                "2",
                filmId,
                "profile_12",
                "Bradley Cooper",
                "Jackson Maine"));
        cast.add(new FilmCastEntity(
                "3",
                filmId,
                "profile_13",
                "Sam Elliott",
                "Bobby Maine"));
        cast.add(new FilmCastEntity(
                "4",
                filmId,
                "profile_14",
                "Andrew Dice Clay",
                "Lorenzo Campana"));
        cast.add(new FilmCastEntity(
                "5",
                filmId,
                "profile_15",
                "Rafi Gavron",
                "Rez Gavron"));
        return cast;
    }

    public static ArrayList<CastResponse> generateRemoteCastFilm(String filmId){
        ArrayList<CastResponse> cast = new ArrayList<>();
        cast.add(new CastResponse(
                filmId,
                "profile_11",
                "Lady Gaga",
                "Ally Campana"));
        cast.add(new CastResponse(
                filmId,
                "profile_12",
                "Bradley Cooper",
                "Jackson Maine"));
        cast.add(new CastResponse(
                filmId,
                "profile_13",
                "Sam Elliott",
                "Bobby Maine"));
        cast.add(new CastResponse(
                filmId,
                "profile_14",
                "Andrew Dice Clay",
                "Lorenzo Campana"));
        cast.add(new CastResponse(
                filmId,
                "profile_15",
                "Rafi Gavron",
                "Rez Gavron"));
        return cast;
    }

    public static ArrayList<FilmGenreEntity> generateGenreFilm(String filmId){
        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
        genres.add(new FilmGenreEntity(
                "1",
                filmId,
                "DRAMA"));
        genres.add(new FilmGenreEntity(
                "2",
                filmId,
                "ROMANCE"));
        genres.add(new FilmGenreEntity(
                "3",
                filmId,
                "MUSIC"));
        return genres;
    }

    public static ArrayList<GenreResponse> generateRemoteGenreFilm(String filmId){
        ArrayList<GenreResponse> genres = new ArrayList<>();
        genres.add(new GenreResponse(
                filmId,
                "DRAMA"));
        genres.add(new GenreResponse(
                filmId,
                "ROMANCE"));
        genres.add(new GenreResponse(
                filmId,
                "MUSIC"));
        return genres;
    }

    public static FilmEntity generateDummyFavoriteMovie(FilmEntity filmEntity, boolean favorite) {
        filmEntity.setFavorited(favorite);
        return filmEntity;
    }

    public static TvShowEntity generateDummyFavoriteTvShow(TvShowEntity tvShowEntity, boolean favorite) {
        tvShowEntity.setFavorited(favorite);
        return tvShowEntity;
    }

//
//    private static ArrayList<FilmCastEntity> generateCastFilm2(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_21",
//                "Jason Momoa",
//                "Arthur Curry / Aquaman"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_22",
//                "Amber Heard",
//                "Mera"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_23",
//                "Willem Dafoe",
//                "Nuidis Vulko"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_24",
//                "Patrick Wilson",
//                "King Orm Marius / Ocean Master"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_25",
//                "Nicole Kidman",
//                "Atlanna"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastFilm3(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_31",
//                "Taron Egerton",
//                "Robin of Loxley"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_32",
//                "Jamie Foxx",
//                "Yahya / John"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_33",
//                "Ben Mendelsohn",
//                "Sheriff of Nottingham"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_34",
//                "Eve Hewson",
//                "Marian"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_35",
//                "Jamie Dornan",
//                "Will Scarlet"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastFilm4(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_41",
//                "Hera Hilmar",
//                "Hester Shaw"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_42",
//                "Robert Sheehan",
//                "Tom Natsworthy"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_43",
//                "Hugo Weaving",
//                "Thaddeus Valentine"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_44",
//                "Jihae",
//                "Anna Fang"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_45",
//                "Ronan Raftery",
//                "Bevis Pod"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastFilm5(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_51",
//                "Liam Neeson",
//                "Nels Coxman"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_52",
//                "Tom Bateman",
//                "Trevor 'Viking' Calcote"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_53",
//                "Tom Jackson",
//                "White Bull Legrew"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_54",
//                "Emmy Rossum",
//                "Kim Dash"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_55",
//                "Domenick Lombardozzi",
//                "Mustang"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastFilm6(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_61",
//                "Michael B. Jordan",
//                "Adonis Creed"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_62",
//                "Sylvester Stallone",
//                "Robert \"Rocky\" Balboa Sr."));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_63",
//                "Dolph Lundgren",
//                "Ivan Drago"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_64",
//                "Florian Munteanu",
//                "Viktor Drago"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_65",
//                "Tessa Thompson",
//                "Bianca Taylor"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastFilm7(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_71",
//                "James McAvoy",
//                "Patricia / Dennis "));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_72",
//                "Bruce Willis",
//                "David Dunn / The Overseer"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_73",
//                "Anya Taylor-Joy",
//                "Casey Cooke"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_74",
//                "Sarah Paulson",
//                "Dr. Ellie Staple"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_75",
//                "Samuel L. Jackson",
//                "Elijah Price / Mr. Glass"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastFilm8(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_81",
//                "Jay Baruchel",
//                "Hiccup (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_82",
//                "America Ferrera",
//                "Astrid (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_83",
//                "Cate Blanchett",
//                "Valka (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_84",
//                "Craig Ferguson",
//                "Gobber the Belch (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_85",
//                "Jonah Hill",
//                "Snotlout Jorgenson (voice)"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastFilm9(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_91",
//                "Zhang Jin",
//                "Cheung Tin-Chi"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_92",
//                "Dave Bautista",
//                "Owen Davidson"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_93",
//                "Liu Yan",
//                "Julia"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_94",
//                "Xing Yu",
//                "Fu"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_95",
//                "Michelle Yeoh",
//                "Sis Ha"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastFilm10(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_101",
//                "John C. Reilly",
//                "Ralph (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_102",
//                "Sarah Silverman",
//                "Vanellope (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_103",
//                "Gal Gadot",
//                "Shank (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_104",
//                "Taraji P. Henson",
//                "Yesss (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile_105",
//                "Jack McBrayer",
//                "Felix (voice)"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastTvShow(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_11",
//                "Stephen Amell",
//                "Oliver Queen"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_12",
//                "David Ramsey",
//                "John Diggle"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_13",
//                "Katie Cassidy",
//                "Laurel Lance "));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_14",
//                "Emily Bett Rickards",
//                "Felicity Smoak"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_15",
//                "Willa Holland",
//                "Thea Queen"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastTvShow2(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_21",
//                "Timothy Dalton",
//                "Dr. Niles Caulder / The Chief"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_22",
//                "Matt Bomer",
//                "Larry Trainor "));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_23",
//                "Brendan Fraser",
//                "Cliff Steele"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_24",
//                "Diane Guerrero",
//                "Crazy Jane"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_25",
//                "April Bowlby",
//                "Rita Farr / Elasti-Woman"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastTvShow3(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_31",
//                "Masako Nozawa",
//                "Son Goku (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_32",
//                "Mayumi Tanaka",
//                "Krillin (voice) "));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_33",
//                "Hiromi Tsuru",
//                "Bulma (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_34",
//                "Tōru Furuya",
//                "Yamcha (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_35",
//                "Naoki Tatsuta",
//                "Oolong (voice)"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastTvShow4(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_41",
//                "Tetsuya Kakihara",
//                "Natsu Dragneel (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_42",
//                "Aya Hirano",
//                "Lucy Heartfilia (voice) "));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_43",
//                "Rie Kugimiya",
//                "Happy (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_44",
//                "Yuichi Nakamura",
//                "Gray Fullbuster (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_45",
//                "Satomi Satou",
//                "Wendy Marvell (voice)"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastTvShow5(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_51",
//                "Seth MacFarlane",
//                "Peter Griffin"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_52",
//                "Alex Borstein",
//                "Lois Griffin"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_53",
//                "Seth Green",
//                "Chris Griffin (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_54",
//                "Mila Kunis",
//                "Meg Griffin (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_55",
//                "Mike Henry",
//                "Cleveland Brown"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastTvShow6(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_61",
//                "Grant Gustin",
//                "Barry Allen / The Flash"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_62",
//                "Candice Patton",
//                "Iris West"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_63",
//                "Carlos Valdes",
//                "Reverb, Cisco Ramon"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_64",
//                "Danielle Panabaker",
//                "Killer Frost, Caitlin Snow"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_65",
//                "Jesse L. Martin",
//                "Joe West"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastTvShow7(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_71",
//                "Ben McKenzie",
//                "James \"Jim\" Gordon"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_72",
//                "Donal Logue",
//                "Harvey Bullock"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_73",
//                "David Mazouz",
//                "Bruce Wayne / 514A / Batman"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_74",
//                "Sean Pertwee",
//                "Alfred Pennyworth"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_75",
//                "Robin Lord Taylor",
//                "Oswald Cobblepot"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastTvShow8(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_81",
//                "Junko Takeuchi",
//                "Naruto Uzumaki (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_82",
//                "Chie Nakamura",
//                "Sakura Haruno (voice) "));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_83",
//                "Kazuhiko Inoue",
//                "Kakashi Hatake (voice)"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_84",
//                "Jouji Nakata",
//                "Baki (voice),"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_85",
//                "Akira Ishida",
//                "Gaara (voice)"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastTvShow9(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_91",
//                "Melissa Benoist",
//                "Supergirl"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_92",
//                "Chyler Leigh",
//                "Alex Danvers"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_93",
//                "David Harewood",
//                " Cyborg Superman"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_94",
//                "Mehcad Brooks",
//                "Guardian"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_95",
//                "Jeremy Jordan",
//                "Winn Schott"));
//        return cast;
//    }
//
//    private static ArrayList<FilmCastEntity> generateCastTvShow10(){
//        ArrayList<FilmCastEntity> cast = new ArrayList<>();
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_101",
//                "Jensen Ackles",
//                "Dean Winchester"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_102",
//                "Jared Padalecki",
//                "Sam Winchester "));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_103",
//                "Misha Collins",
//                "Leviathan"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_104",
//                "Alexander Calvert",
//                "Jack"));
//        cast.add(new FilmCastEntity(
//                "01",
//                "profile2_105",
//                "Ruth Connell",
//                "Rowena"));
//        return cast;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreFilm(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "DRAMA"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ROMANCE"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "MUSIC"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreFilm2(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ACTION"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ADVENTURE"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "FANTASY"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreFilm3(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ADVENTURE"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ACTION"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "THRILLER"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreFilm4(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ADVENTURE"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "FANTASY"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreFilm5(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ACTION"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreFilm6(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "DRAMA"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreFilm7(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "THRILLER"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "DRAMA"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "SCIENCE FICTION"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreFilm8(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ANIMATION"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "FAMILY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ADVENTURE"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreFilm9(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ACTION"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreFilm10(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "FAMILY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ANIMATION"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "COMEDY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ADVENTURE"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreTvShow(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "CRIME"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "DRAMA"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "MYSTERY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ACTION & ADVENTURE"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreTvShow2(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "SCI-FI & FANTASY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ACTION & ADVENTURE"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreTvShow3(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "COMEDY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "SCI-FI & FANTASY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ANIMATION"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ACTION & ADVENTURE"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreTvShow4(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ACTION & ADVENTURE"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ANIMATION"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "COMEDY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "SCI-FI & FANTASY"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreTvShow5(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ANIMATION"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "COMEDY"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreTvShow6(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "DRAMA"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "SCI-FI & FANTASY"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreTvShow7(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "DRAMA"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "FANTASY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "CRIME"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreTvShow8(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ANIMATION"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "COMEDY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "DRAMA"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreTvShow9(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ACTION"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "ADVENTURE"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "DRAMA"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "SCIENCE FICTION"));
//        return genres;
//    }
//
//    private static ArrayList<FilmGenreEntity> generateGenreTvShow10(){
//        ArrayList<FilmGenreEntity> genres = new ArrayList<>();
//        genres.add(new FilmGenreEntity(
//                "01",
//                "DRAMA"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "MYSTERY"));
//        genres.add(new FilmGenreEntity(
//                "01",
//                "SCI-FI & FANTASY"));
//        return genres;
//    }

}
