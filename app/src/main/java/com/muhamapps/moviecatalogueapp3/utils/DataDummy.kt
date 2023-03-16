package com.muhamapps.moviecatalogueapp3.utils

import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.data.source.remote.response.MovieResponse
import com.muhamapps.moviecatalogueapp3.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity("mv01",
                "Pacific Rim",
                "2013",
                "6.8",
                "Action, Fiction, Adventure",
                "2h 11m",
                "A ragtag band of humans band together in the year 2025 to fight legions of monstrous creatures rising from the sea. Using massive piloted robots to combat the alien threat, earth's survivors take the fight to the invading alien force lurking in the depths of the Pacific Ocean. Nearly defenseless in the face of the relentless enemy, the forces of mankind have no choice but to turn to two unlikely heroes -- a washed up former pilot and an untested trainee -- who now stand as earth's final hope against the mounting apocalypse.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mmznhaQDwlHWpUwKuNxtQiubbmM.jpg")
        )

        movies.add(
            MovieEntity("mv02",
                "Avengers: Endgame",
                "2019",
                "8.3",
                "Adventure, Science Fiction, Action",
                "3h 1m",
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg")
        )

        movies.add(
            MovieEntity("mv03",
                "Spider-Man: Far From Home",
                "2019",
                "7.5",
                "Adventure, Science Fiction, Action",
                "3h 1m",
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4q2NNj4S5dG2RLF9CpXsej7yXl.jpg")
        )

        movies.add(
            MovieEntity("mv04",
                "Space Sweepers",
                "2021",
                "7.2",
                "Drama, Fantasy, Science Fiction",
                "2h 16m",
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/p9YDHJKvUoi7v2SCd3vLGPae1Xp.jpg")
        )

        movies.add(
            MovieEntity("mv05",
                "The Fate of the Furious",
                "2017",
                "6.9",
                "Adventure, Science Fiction, Action",
                "2h 16m",
                "When a mysterious woman seduces Dom into the world of crime and a betrayal of those closest to him, the crew face trials that will test them as never before.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dImWM7GJqryWJO9LHa3XQ8DD5NH.jpg")
        )

        movies.add(
            MovieEntity("mv06",
                "Godzilla vs. Kong",
                "2021",
                "8.2",
                "Science Fiction, Action, Drama",
                "1h 53m",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg")
        )

        movies.add(
            MovieEntity("mv07",
                "Mortal Kombat Legends: Scorpion's Revenge",
                "2020",
                "8.4",
                "Animation, Action, Fantasy",
                "1h 20m",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg")
        )

        movies.add(
            MovieEntity("mv08",
                "One Piece: Stampede",
                "2019",
                "7.9",
                "Animation, Action, Adventure",
                "1h 41m",
                "One Piece: Stampede is a stand-alone film that celebrates the anime's 20th Anniversary and takes place outside the canon of the \"One Piece\" TV series. Monkey D. Luffy and his Straw Hat pirate crew are invited to a massive Pirate Festival that brings many of the most iconic characters from throughout the franchise to participate in competition with the Straw Hats to find Roger's treasure. It also pits the Straw Hats against a new enemy named Bullet, a former member of Roger's crew.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/35KrrxdjJP3c9dnBZqnVmSVStgp.jpg")
        )

        movies.add(
            MovieEntity("mv09",
                "Parasite",
                "2019",
                "8.5",
                "Comedy, Thriller, Drama",
                "2h 13m",
                "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg")
        )

        movies.add(
            MovieEntity("mv10",
                "The Imitation Game",
                "2014",
                "8.0",
                "History, Drama, Thriller, War",
                "1h 53m",
                "Based on the real life story of legendary cryptanalyst Alan Turing, the film portrays the nail-biting race against time by Turing and his brilliant team of code-breakers at Britain's top-secret Government Code and Cypher School at Bletchley Park, during the darkest days of World War II.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zSqJ1qFq8NXFfi7JeIYMlzyR0dx.jpg")
        )

        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity("ts01",
                "The Flash",
                "7",
                "2014",
                "7.7",
                "Drama, Sci-fi & Fantasy",
                "44m",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg")
        )

        tvShow.add(
            TvShowEntity("ts02",
                "Into the Night",
                "1",
                "2020",
                "7.5",
                "Sci-Fi & Fantasy",
                "37m",
                "When the sun suddenly starts killing everything in its path, passengers on an overnight flight from Brussels attempt to survive by any means necessary.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7JjTFDtfpQBVIwZA1aD8CgNzduQ.jpg")
        )

        tvShow.add(
            TvShowEntity("ts03",
                "Hunter x Hunter",
                "3",
                "2011",
                "8.8",
                "Action & Adventure, Animation, Drama",
                "24m",
                "Twelve-year-old Gon Freecss one day discovers that the father he had always been told was dead was alive. His Father, Ging, is a Hunter — a member of society's elite with a license to go anywhere or do almost anything. Gon, determined to follow in his father's footsteps, decides to take the Hunter Examination and eventually find his father to prove himself as a Hunter in his own right. But on the way, he learns that there is more to becoming a Hunter than previously thought, and the challenges that he must face are considered the toughest in the world.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ucpgmUR1h5Te1BYegKItoPjOeF7.jpg")
        )

        tvShow.add(
            TvShowEntity("ts04",
                "Money Heist",
                "4",
                "2017",
                "8.3",
                "Crime, Drama",
                "1h 10m",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg")
        )

        tvShow.add(
            TvShowEntity("ts05",
                "WandaVision",
                "1",
                "2021",
                "8.4",
                "Sci-Fi & Fantasy, Mystery, Drama",
                "36m",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/glKDfE6btIRcVB5zrjspRIs4r52.jpg")
        )

        tvShow.add(
            TvShowEntity("ts06",
                "Once",
                "3",
                "2017",
                "8.8",
                "Comedy, Family",
                "86m",
                "The series revolves around Gabo, a soccer-loving teenager who, upon receiving a scholarship from the prestigious Sports Academic Institute (IAD) of Buenos Aires, will see his dream of playing at Los Halcones Dorados, the renowned amateur team of the school, and also his longing to become a professional footballer.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/d4vPg3QsTJJh6C5MHARTb5CyqOu.jpg")
        )

        tvShow.add(
            TvShowEntity("ts07",
                "Teen Wolf",
                "6",
                "2011",
                "7.7",
                "Sci-Fi & Fantasy, Drama",
                "43m",
                "Scott McCall, a high school student living in the town of Beacon Hills has his life drastically changed when he's bitten by a werewolf, becoming one himself. He must henceforth learn to balance his problematic new identity with his day-to-day teenage life. The following characters are instrumental to his struggle: Stiles, his best friend; Allison, his love interest who comes from a family of werewolf hunters; and Derek, a mysterious werewolf with a dark past. Throughout the series, he strives to keep his loved ones safe while maintaining normal relationships with them.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vY2vfAskJTiWsQSv6bdbNCQhPLm.jpg")
        )

        tvShow.add(
            TvShowEntity("ts08",
                "Blindspot",
                "5",
                "2015",
                "7.3",
                "Crime, Drama, Action & Adventure",
                "43m",
                "A vast international plot explodes when a beautiful Jane Doe is discovered naked in Times Square, completely covered in mysterious, intricate tattoos with no memory of who she is or how she got there. But there's one tattoo that is impossible to miss: the name of FBI agent Kurt Weller, emblazoned across her back. \"Jane,\" Agent Weller and the rest of the FBI quickly realize that each mark on her body is a crime to solve, leading them closer to the truth about her identity and the mysteries to be revealed.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4AeYzamQmd9Fa6hawDmYKbdvBSe.jpg")
        )

        tvShow.add(
            TvShowEntity("ts09",
                "The Good Doctor",
                "4",
                "2017",
                "8.6",
                "Drama",
                "43m",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg")
        )

        tvShow.add(
            TvShowEntity("ts10",
                "One-Punch Man",
                "2",
                "2015",
                "8.4",
                "Action & Adventure, Animation, Comedy",
                "24m",
                "Saitama is a hero who only became a hero for fun. After three years of “special” training, though, he’s become so strong that he’s practically invincible. In fact, he’s too strong—even his mightiest opponents are taken out with a single punch, and it turns out that being devastatingly powerful is actually kind of a bore. With his passion for being a hero lost along with his hair, yet still faced with new enemies every day, how much longer can he keep it going?",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iE3s0lG5QVdEHOEZnoAxjmMtvne.jpg")
        )

        return tvShow
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse("mv01",
                "Pacific Rim",
                "2013",
                "6.8",
                "Action, Fiction, Adventure",
                "2h 11m",
                "A ragtag band of humans band together in the year 2025 to fight legions of monstrous creatures rising from the sea. Using massive piloted robots to combat the alien threat, earth's survivors take the fight to the invading alien force lurking in the depths of the Pacific Ocean. Nearly defenseless in the face of the relentless enemy, the forces of mankind have no choice but to turn to two unlikely heroes -- a washed up former pilot and an untested trainee -- who now stand as earth's final hope against the mounting apocalypse.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mmznhaQDwlHWpUwKuNxtQiubbmM.jpg")
        )

        movies.add(
            MovieResponse("mv02",
                "Avengers: Endgame",
                "2019",
                "8.3",
                "Adventure, Science Fiction, Action",
                "3h 1m",
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg")
        )

        movies.add(
            MovieResponse("mv03",
                "Spider-Man: Far From Home",
                "2019",
                "7.5",
                "Adventure, Science Fiction, Action",
                "3h 1m",
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4q2NNj4S5dG2RLF9CpXsej7yXl.jpg")
        )

        movies.add(
            MovieResponse("mv04",
                "Space Sweepers",
                "2021",
                "7.2",
                "Drama, Fantasy, Science Fiction",
                "2h 16m",
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/p9YDHJKvUoi7v2SCd3vLGPae1Xp.jpg")
        )

        movies.add(
            MovieResponse("mv05",
                "The Fate of the Furious",
                "2017",
                "6.9",
                "Adventure, Science Fiction, Action",
                "2h 16m",
                "When a mysterious woman seduces Dom into the world of crime and a betrayal of those closest to him, the crew face trials that will test them as never before.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dImWM7GJqryWJO9LHa3XQ8DD5NH.jpg")
        )

        movies.add(
            MovieResponse("mv06",
                "Godzilla vs. Kong",
                "2021",
                "8.2",
                "Science Fiction, Action, Drama",
                "1h 53m",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg")
        )

        movies.add(
            MovieResponse("mv07",
                "Mortal Kombat Legends: Scorpion's Revenge",
                "2020",
                "8.4",
                "Animation, Action, Fantasy",
                "1h 20m",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg")
        )

        movies.add(
            MovieResponse("mv08",
                "One Piece: Stampede",
                "2019",
                "7.9",
                "Animation, Action, Adventure",
                "1h 41m",
                "One Piece: Stampede is a stand-alone film that celebrates the anime's 20th Anniversary and takes place outside the canon of the \"One Piece\" TV series. Monkey D. Luffy and his Straw Hat pirate crew are invited to a massive Pirate Festival that brings many of the most iconic characters from throughout the franchise to participate in competition with the Straw Hats to find Roger's treasure. It also pits the Straw Hats against a new enemy named Bullet, a former member of Roger's crew.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/35KrrxdjJP3c9dnBZqnVmSVStgp.jpg")
        )

        movies.add(
            MovieResponse("mv09",
                "Parasite",
                "2019",
                "8.5",
                "Comedy, Thriller, Drama",
                "2h 13m",
                "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg")
        )

        movies.add(
            MovieResponse("mv10",
                "The Imitation Game",
                "2014",
                "8.0",
                "History, Drama, Thriller, War",
                "1h 53m",
                "Based on the real life story of legendary cryptanalyst Alan Turing, the film portrays the nail-biting race against time by Turing and his brilliant team of code-breakers at Britain's top-secret Government Code and Cypher School at Bletchley Park, during the darkest days of World War II.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zSqJ1qFq8NXFfi7JeIYMlzyR0dx.jpg")
        )

        return movies
    }

    fun generateRemoteDummyTvShows(): List<TvShowResponse> {

        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(
            TvShowResponse("ts01",
                "The Flash",
                "7",
                "2014",
                "7.7",
                "Drama, Sci-fi & Fantasy",
                "44m",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg")
        )

        tvShow.add(
            TvShowResponse("ts02",
                "Into the Night",
                "1",
                "2020",
                "7.5",
                "Sci-Fi & Fantasy",
                "37m",
                "When the sun suddenly starts killing everything in its path, passengers on an overnight flight from Brussels attempt to survive by any means necessary.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7JjTFDtfpQBVIwZA1aD8CgNzduQ.jpg")
        )

        tvShow.add(
            TvShowResponse("ts03",
                "Hunter x Hunter",
                "3",
                "2011",
                "8.8",
                "Action & Adventure, Animation, Drama",
                "24m",
                "Twelve-year-old Gon Freecss one day discovers that the father he had always been told was dead was alive. His Father, Ging, is a Hunter — a member of society's elite with a license to go anywhere or do almost anything. Gon, determined to follow in his father's footsteps, decides to take the Hunter Examination and eventually find his father to prove himself as a Hunter in his own right. But on the way, he learns that there is more to becoming a Hunter than previously thought, and the challenges that he must face are considered the toughest in the world.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ucpgmUR1h5Te1BYegKItoPjOeF7.jpg")
        )

        tvShow.add(
            TvShowResponse("ts04",
                "Money Heist",
                "4",
                "2017",
                "8.3",
                "Crime, Drama",
                "1h 10m",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg")
        )

        tvShow.add(
            TvShowResponse("ts05",
                "WandaVision",
                "1",
                "2021",
                "8.4",
                "Sci-Fi & Fantasy, Mystery, Drama",
                "36m",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/glKDfE6btIRcVB5zrjspRIs4r52.jpg")
        )

        tvShow.add(
            TvShowResponse("ts06",
                "Once",
                "3",
                "2017",
                "8.8",
                "Comedy, Family",
                "86m",
                "The series revolves around Gabo, a soccer-loving teenager who, upon receiving a scholarship from the prestigious Sports Academic Institute (IAD) of Buenos Aires, will see his dream of playing at Los Halcones Dorados, the renowned amateur team of the school, and also his longing to become a professional footballer.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/d4vPg3QsTJJh6C5MHARTb5CyqOu.jpg")
        )

        tvShow.add(
            TvShowResponse("ts07",
                "Teen Wolf",
                "6",
                "2011",
                "7.7",
                "Sci-Fi & Fantasy, Drama",
                "43m",
                "Scott McCall, a high school student living in the town of Beacon Hills has his life drastically changed when he's bitten by a werewolf, becoming one himself. He must henceforth learn to balance his problematic new identity with his day-to-day teenage life. The following characters are instrumental to his struggle: Stiles, his best friend; Allison, his love interest who comes from a family of werewolf hunters; and Derek, a mysterious werewolf with a dark past. Throughout the series, he strives to keep his loved ones safe while maintaining normal relationships with them.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vY2vfAskJTiWsQSv6bdbNCQhPLm.jpg")
        )

        tvShow.add(
            TvShowResponse("ts08",
                "Blindspot",
                "5",
                "2015",
                "7.3",
                "Crime, Drama, Action & Adventure",
                "43m",
                "A vast international plot explodes when a beautiful Jane Doe is discovered naked in Times Square, completely covered in mysterious, intricate tattoos with no memory of who she is or how she got there. But there's one tattoo that is impossible to miss: the name of FBI agent Kurt Weller, emblazoned across her back. \"Jane,\" Agent Weller and the rest of the FBI quickly realize that each mark on her body is a crime to solve, leading them closer to the truth about her identity and the mysteries to be revealed.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4AeYzamQmd9Fa6hawDmYKbdvBSe.jpg")
        )

        tvShow.add(
            TvShowResponse("ts09",
                "The Good Doctor",
                "4",
                "2017",
                "8.6",
                "Drama",
                "43m",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg")
        )

        tvShow.add(
            TvShowResponse("ts10",
                "One-Punch Man",
                "2",
                "2015",
                "8.4",
                "Action & Adventure, Animation, Comedy",
                "24m",
                "Saitama is a hero who only became a hero for fun. After three years of “special” training, though, he’s become so strong that he’s practically invincible. In fact, he’s too strong—even his mightiest opponents are taken out with a single punch, and it turns out that being devastatingly powerful is actually kind of a bore. With his passion for being a hero lost along with his hair, yet still faced with new enemies every day, how much longer can he keep it going?",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iE3s0lG5QVdEHOEZnoAxjmMtvne.jpg")
        )

        return tvShow
    }
}