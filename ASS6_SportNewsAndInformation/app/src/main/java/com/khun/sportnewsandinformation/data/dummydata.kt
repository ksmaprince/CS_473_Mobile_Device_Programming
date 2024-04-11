package com.khun.sportnewsandinformation.data

import com.khun.sportnewsandinformation.data.models.AchievementHistory
import com.khun.sportnewsandinformation.data.models.Athelete
import com.khun.sportnewsandinformation.data.models.Event
import com.khun.sportnewsandinformation.data.models.News
import com.khun.sportnewsandinformation.data.models.Profile
import com.khun.sportnewsandinformation.data.models.Sport
import com.khun.sportnewsandinformation.data.models.User

//IN MEMORY Dummy Data

val sports = arrayListOf<Sport>(
    Sport("Measure", "Car Racing", "To excel in car racing, first, prioritize safety by wearing appropriate protective gear and understanding track rules. Second, master vehicle control through practice sessions, focusing on braking, accelerating, and steering techniques. Third, study racing lines and optimal trajectories to navigate corners efficiently and gain speed. Finally, maintain focus and composure during races, anticipating challenges and adapting strategies to secure victory."),
    Sport("Precision", "Golf", "To play golf effectively, start by understanding the basics of the game, including its rules and etiquette. Next, practice your swing technique, focusing on proper grip, stance, and posture to achieve consistency and accuracy. Pay attention to course management, strategizing each shot to minimize risks and maximize scoring opportunities. Finally, maintain a positive mindset, embracing both successes and setbacks as part of the learning process while enjoying the beauty of the game."),
    Sport("Spectacle", "Gymnastics", "Begin by warming up your muscles and stretching to prevent injuries and improve flexibility. Practice basic gymnastic moves such as somersaults, cartwheels, and handstands to build strength and coordination. Gradually progress to more advanced skills like backflips, splits, and balance beam routines with proper supervision and technique. Focus on consistency, perseverance, and mastering each skill progressively to advance in gymnastics and enhance performance."),
    Sport("Spectacle", "Skateboarding", "Skateboarding is an exhilarating sport that requires balance, coordination, and practice. Before you start, ensure you have the proper safety gear, including a helmet, knee pads, and elbow pads. Begin by finding a smooth, flat surface to practice on, preferably free of obstacles and traffic. Stand on your skateboard with one foot near the front bolts and the other near the tail. Push off with your back foot to gain momentum, keeping your weight centered over the board. To turn, shift your weight and lean in the direction you want to go. Remember to practice stopping techniques, such as dragging your foot or using the tail to initiate a controlled stop. Always respect your limits and gradually progress as you gain confidence and skill. Most importantly, have fun and enjoy the ride!"),
    Sport("Combat", "Tug of war", "Tug of war is a classic team game where two teams compete to pull a rope in opposite directions. The rope is marked with a center point, and the goal is to pull the opposing team across that point to your side. Each team consists of an equal number of players, and the team that successfully pulls the other team across the center line wins. It's important to have proper grip and footing to avoid injuries, and teamwork is essential for success.")
)

val newsList = arrayListOf<News>(
    News("Domantas Sabonis’ double-double streak ends at 61 games as Kings lose to Thunder", "OKLAHOMA CITY (AP) — Sacramento Kings center Domantas Sabonis’ double-double streak has ended at 61 games.\n" +
            "\n" +
            "Sabonis had eight points and 13 rebounds in Sacramento’s 112-105 loss to the Oklahoma City Thunder on Tuesday night.\n" +
            "\n" +
            "Sabonis owns the seventh-longest streak of double-doubles in NBA history. He had just moved past Elvin Hayes’ stretch of 60 straight from Oct. 30, 1968, to Feb. 22, 1969, on Sunday in a win over the Brooklyn Nets. His streak was the longest since the NBA and ABA merged for the 1976-77 season. He broke Kevin Love’s mark of 53 straight since the merger last month.", "https://dims.apnews.com/dims4/default/9090bd7/2147483647/strip/true/crop/4329x2882+0+3/resize/700x466!/format/webp/quality/90/?url=https%3A%2F%2Fassets.apnews.com%2F48%2F30%2F6f0aa8842768f7b7be4e59ad3dc4%2F3a84be3931e04177a2d91ed6b96aca9d"),
    News("AUTO RACING: Byron gives Hendrick more to celebrate in Martinsville. Verstappen gets another F1 win", "Race distance: 267 laps, 400.5 miles.\n" +
            "\n" +
            "Last year: William Byron won after starting 18th in late September.\n" +
            "\n" +
            "Last race: Byron held onto the lead during a two-lap dash to the finish and led a 1-2-3 finish for Hendrick Motorsports at Martinsville, the first for a team in the track’s storied history.\n" +
            "\n" +
            "Fast facts: The victory was Byron’s third in eight races. ... Kyle Larson finished second and Chase Elliott was third on the 40th anniversary of the team’s first win. ... Larson also took over the points lead by 14 over former leader Martin Truex Jr. ... Despite his three victories, Byron is fourth in points, 48 behind Larson. ... There were 13 lead changes among eight drivers. ... The victory was the 29th for Hendrick on the 0.526-mile oval, the most for any organization at any track.", "https://dims.apnews.com/dims4/default/0c1ed71/2147483647/strip/true/crop/4070x2709+0+1/resize/700x466!/format/webp/quality/90/?url=https%3A%2F%2Fassets.apnews.com%2F9c%2F33%2F13962edcb0b90330b57327a999bc%2F7ffa80dccd714c6d95b2f1bb76b7bcf2"),
    News("Yahoo DFS Basketball: Who to Play, Who to Avoid for 4/10",
        "We have an eight-game slate on tap Wednesday after a massive Tuesday ledger. As we inch closer to the final day of the regular season, the picture gets a bit murkier with respect to playing time on both contending and non-contending teams. Nevertheless, with 16 teams in action, we still have an ample player pool to work with.\n" +
                "\n" +
                "As customary, we'll highlight multiple advantageous positional matchups to exploit at each position for your Yahoo Fantasy lineups, as well as a good trio of candidates that may be best to steer clear of due to a combination of circumstances/salary.",
        "https://s.yimg.com/ny/api/res/1.2/sJJM3_MZ.s_fN4g5L0mLDw--/YXBwaWQ9aGlnaGxhbmRlcjt3PTk2MDtoPTY0MDtjZj13ZWJw/https://s.yimg.com/os/creatr-uploaded-images/2024-04/097a39e0-f77a-11ee-b7d7-0668f3435221"),
    News("Sidney Crosby and the Pittsburgh Penguins were lost two weeks ago. Now they’re in the playoff mix",
        "PITTSBURGH (AP) — Sidney Crosby insists he’s not a scoreboard watcher.\n" +
                "\n" +
                "Not publicly anyway.\n" +
                "\n" +
                "Maybe it’s because the Pittsburgh Penguins’ longtime captain is too occupied with his team to worry about anyone else. Or maybe it’s because Crosby never had much reason to check during Pittsburgh’s run to 16 straight playoff berths between 2007 and 2022.\n" +
                "\n" +
                "Or maybe it’s simply because Crosby doesn’t have to check his phone to figure out where the Penguins stand. The evidence is on the countless videoboards that greet players wherever they go inside PPG Paints Arena.",
        "https://dims.apnews.com/dims4/default/4b14515/2147483647/strip/true/crop/4544x3029+0+0/resize/1440x960!/format/webp/quality/90/?url=https%3A%2F%2Fassets.apnews.com%2F66%2Fe3%2Fe9b4deeb176d0391a20256dc4519%2Fdf289d2344234477ad22c573921d2de5")
)

val atheletes = arrayListOf<Athelete>(
    Athelete("Usain Bolt", "Track and Field", "Jamaica", "100-9.58s", "8", " Usain Bolt holds the world record for both the 100 meters and 200 meters"),
    Athelete("Simone Biles", "Gymnastics", "United States", "N/A", "7", "Simone Biles is considered on of the greatest gymnasts of all time.")
)

val events = arrayListOf<Event>(
    Event("FIBA Basketball World Cup Qualifiers","Qualifying games for the 2025 FIBA Basketball World Cup.", "10/03/2024"),
    Event("Indian Premier League (IPL)", "Twenty20 cricket league in India.", "15/03/2024")
)

val achievementHistories = arrayListOf<AchievementHistory>(
    AchievementHistory("First Modern Olympic Games", "April 6, 1896", "The first modern Olympic Games were held in Athens, Greece, and marked the revival of the ancient Olympic Games."),
    AchievementHistory("Jesse Owens at the 1936 Olympics", "August 3-12, 1936", "American athlete Jesse Owens won four gold medals in track and field events at the 1936 Berlin Olympics, defying Adolf Hitler's Aryan supremacy ideology.")
)

val profile = Profile("Cristiano Ronaldo", "https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcQlj3rCfLHry58AtJ8ZyBEAFPtChMddDSUSjt7C7nV3Nhsni9RIx5b0-n7LxfgerrPS6b-P-u3BOM3abuY", "The penultimate athlete in this countdown is none other than Portuguese sensation Cristiano Ronaldo. Now in Saudi Arabia with Al-Nassr, Ronaldo has reached the twilight of his footballing career which has seen him claim multiple Champions Leagues, domestic titles in England, Spain, and Italy while winning the Ballon d'Or on five different occasions.")

val users = arrayListOf<User>(User("admin", "123"))



