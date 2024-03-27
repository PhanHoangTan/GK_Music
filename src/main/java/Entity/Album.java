package Entity;

public class Album {
//     "yearOfRelease": 2023,
//             "downloadLink": "https://example.com/album1.mp3",
//             "price": 10.0,
//             "id": "A001",
//             "title": "Album 1"
    private int yearOfRelease;
    private String downloadLink;
    private double price;
    private String id;
    private String title;

    public Album(int yearOfRelease, String downloadLink, double price, String id, String title) {
        this.yearOfRelease = yearOfRelease;
        this.downloadLink = downloadLink;
        this.price = price;
        this.id = id;
        this.title = title;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Album{" +
                "yearOfRelease=" + yearOfRelease +
                ", downloadLink='" + downloadLink + '\'' +
                ", price=" + price +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
