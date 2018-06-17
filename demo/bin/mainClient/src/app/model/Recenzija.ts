import { Korisnik } from "./Korisnik";
import { Smestaj } from "./Smestaj";
import { Komentar } from "./Komentar";

export class Recenzija {

    public korisnik: Korisnik;
    public smestaj: Smestaj;
    public komentar: Komentar;
    public id: String;
    public ocena: Number;

    constructor() {

    }
}
