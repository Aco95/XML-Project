export class Rezervacija {
    
    public idUser: String;
    public idSobe: String;
    public potvrdaRezervacije: boolean;
    public datumRezervacije: String; //ako je danasnj datum > od datumRezervacija dozvoli recenziju
    public nacinPlacanja: Number;
    public cenaRezervacije: Number; //osobe*cenaSobe
    public otkazana: boolean; //da li je rezervacija otkazana

    
    constructor() {

    }
}
