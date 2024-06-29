import java.util.*;

class Solution {

    HashMap<String, List<MusicInfo>> genreInfo = new HashMap<>();
    ArrayList<GenreCount> genreCount = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        for (int i=0; i<genres.length; i++) {
            genreInfo.putIfAbsent(genres[i], new ArrayList<>());
            genreInfo.get(genres[i]).add(new MusicInfo(i, plays[i]));
        }

        for (int i=0; i<genres.length; i++) {
            genreInfo.get(genres[i]).sort((a, b) -> {
                if (a.playTime == b.playTime) return a.musicId - b.musicId;
                else return b.playTime - a.playTime;
            });
        }

        genreInfo.entrySet().forEach( entry -> {

            List<MusicInfo> dataList = entry.getValue();
            Integer totalPlayTime = dataList.stream().mapToInt(item -> item.playTime).sum();
            genreCount.add(new GenreCount(entry.getKey(), totalPlayTime));
        });

        genreCount.sort((a, b) -> b.playTimeTotal - a.playTimeTotal);

        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i=0; i<genreCount.size(); i++) {
            String genre = genreCount.get(i).genre;
            List<MusicInfo> infoList = genreInfo.get(genre);
            for (int j= 0; j<infoList.size() && j<2;j++) {
                answerList.add(infoList.get(j).musicId);
            }
        }
        answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }


}


class MusicInfo {
    Integer playTime;
    Integer musicId;

    public MusicInfo (Integer musicId, Integer playTime) {
        this.musicId = musicId;
        this.playTime = playTime;
    }

}

class GenreCount {
    String genre;
    Integer playTimeTotal;

    public GenreCount (String genre, Integer playTimeTotal) {
        this.genre = genre;
        this.playTimeTotal = playTimeTotal;
    }
}