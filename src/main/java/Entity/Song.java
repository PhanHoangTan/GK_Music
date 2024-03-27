package Entity;

public class Song {
//     "fileLink": "https://example.com/song1.mp3",
//             "lyric": ""L?i b? h? 1"",
//            "name": "B? h? 1",
//            "runtime": "3:30",
//            "id": "S001"

    private String fileLink;
    private String lyric;
    private String name;
    private String runtime;
    private String id;

    public Song(String fileLink, String lyric, String name, String runtime, String id) {
        this.fileLink = fileLink;
        this.lyric = lyric;
        this.name = name;
        this.runtime = runtime;
        this.id = id;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Song{" +
                "fileLink='" + fileLink + '\'' +
                ", lyric='" + lyric + '\'' +
                ", name='" + name + '\'' +
                ", runtime='" + runtime + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
