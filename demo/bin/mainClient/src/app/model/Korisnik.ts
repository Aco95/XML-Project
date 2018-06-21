import { Uloga } from "./Uloga.enum";

export class Korisnik {

    public id: String;
    public ime: String;
    public prezime: String;
    public email: String;
    public uloga: Uloga;
    public username: String;
    public password: String;
    public maticniBroj: String;
    public adresa: String;
    public blokiran: boolean;

    constructor(

    ) {}
}
