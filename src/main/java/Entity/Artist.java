package Entity;

public class Artist {
//     "name": "Nghe si 1",
//             "id": "C001",
//             "birthDate": "32874",
//             "url": "https://example.com/artist1"
    private String name;
    private String id;
    private String birthDate;
    private String url;

    public Artist(String name, String id, String birthDate, String url) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
