package MusicAlbums;

public class Main {
    AlbumController album = new AlbumController();
    ArtistController artist = new ArtistController();
    public static void main(String[] args) {
         new Main();
     }
    Main() {
        artist.create("Rammstein","Germany");
        artist.create("Metallica","SUA");
        artist.create("Queen","United Kingdom");
        artist.create("Parazitii","Romania");
        album.create("Mutter",1, 2001);
        album.create("Master of Puppets", 2, 1986);
        album.create("Load",2, 1996);
        album.create("St. Anger",2, 2003);
        album.create("ReLoad",2, 1997);
        album.create("Bohemian Rapsody",3,1977);
        album.create("Antimilie",4,2019);
        System.out.println(artist.findByName("Queen"));
        System.out.println(artist.findByName("Parazitii"));
        System.out.println(album.findByArtist(2));System.out.println(album.findByArtist(4));
    }
}
