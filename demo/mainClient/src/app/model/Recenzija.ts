import { Korisnik } from "./Korisnik";
import { Smestaj } from "./Smestaj";
import { Komentar } from "./Komentar";

export class Recenzija {

    public korisnik: Korisnik;
    public smestajId: string;
    public komentar: Komentar;
    public id: String;
    public ocena: Number;

    constructor() {
        this.korisnik = null;
        this.smestajId = null;
        this.komentar = new Komentar();
        this.ocena = null;
    }
}
