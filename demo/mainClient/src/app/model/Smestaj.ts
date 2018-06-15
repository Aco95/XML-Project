import { Soba } from "./Soba";

export class Smestaj {

    public id: String;
    public naziv: String;
    public adresa: String;
    public mesto: String;
    public kategorija: Number;
    public tip: Number;
    public parking: boolean;
    public wifi: boolean;
    public dorucak: boolean;
    public polupansion: boolean;
    public pansion: boolean;
    public tv: boolean;
    public miniKuhinja: boolean;
    public privatnoKupatilo: boolean;
    public ocena: Number;
    public opis: String;

    /*
    public sobe: Array<Soba>;
    public slikeUrl: Array<String>;
    */

    constructor(
    ) {}
}
