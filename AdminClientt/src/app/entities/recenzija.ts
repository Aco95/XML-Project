import { Korisnik } from "./Korisnik";
import { Smestaj } from "./Smestaj";
import { Comment } from "./comment";

export class Recenzija {

    public korisnik: Korisnik;
    public smestajId: string;
    public komentar: Comment;
    public id: String;
    public ocena: Number;

    constructor() {
        this.korisnik = null;
        this.smestajId = null;
        this.komentar = new Comment();
        this.ocena = null;
    }
}
