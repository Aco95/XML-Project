import { Korisnik} from '../model/Korisnik';
import { Smestaj } from '../model/Smestaj';
import { Soba } from '../model/Soba';
import { Uloga } from '../model/Uloga.enum';
import { Rezervacija } from '../model/Rezervacija';

export const KORISNICI: Korisnik[] = [
    {
        id: '1', ime:'Boban', prezime:'Poznanovic', adresa:'Slobodana Bajica 1/28', maticniBroj:'1234',
        uloga: Uloga.ADMIN, username:'boban', password:'boban', blokiran:false, email:''
    },
    {
        id: '2', ime:'Aco', prezime:'Aco', adresa:'Temerinska 1', maticniBroj:'4321',
        uloga: Uloga.AGENT, username:'acoaco', password:'acoaco', blokiran:false, email:''
    },
    {
        id: '3', ime:'ogi', prezime:'og', adresa:'Slobodana Bajica 1/28', maticniBroj:'12345678',
        uloga: Uloga.USER, username:'ogiogi', password:'ogiog', blokiran:false, email:''
    }

]

export const SMESTAJI: Smestaj[] = [
    {
        id:'1', naziv:'Hotel Vojvodina', adresa:'Trg Slobode 1', mesto:'Novi Sad', opis:'Hotel u centru grada',
        kategorija:4, ocena:4, dorucak:true, miniKuhinja:false, pansion:true, parking:false, polupansion:true,
        privatnoKupatilo:true, tip: 0, tv:true, wifi:true
    },
    {
        id:'2', naziv:'Hotel Park', adresa:'Novosadskog sajma 4', mesto:'Novi Sad', opis:'Hotel',
        kategorija:5, ocena:5, dorucak:true, miniKuhinja:false, pansion:true, parking:true, polupansion:true,
        privatnoKupatilo:true, tip: 0, tv:true, wifi:true
    }
]

export const SOBE: Soba[] = [
    {
        id:'1', broj:1, cena: 1200,  idSmestaja:'1', kapacitet:2
    },
    {
        id:'2', broj:2, cena: 1200, idSmestaja:'1', kapacitet:2
    },
    {
        id:'3', broj:3, cena: 1300, idSmestaja:'1', kapacitet:3
    },
    {
        id:'4', broj:4, cena: 1800, idSmestaja:'1', kapacitet:4
    },
    {
        id:'5', broj:1, cena: 2000, idSmestaja:'2', kapacitet:2
    },
    {
        id:'6', broj:2, cena: 12000, idSmestaja:'2', kapacitet:6
    }
]

export const REZERVACIJE: Rezervacija[] = [
    {
        idUser:'3', idSobe:'6', datumRezervacije:'12/12/2018', nacinPlacanja:0, otkazana:false, 
        potvrdaRezervacije:true, cenaRezervacije: 12000       
    },
    {
        idUser:'3', idSobe:'2', datumRezervacije:'30/12/2018', nacinPlacanja:1, otkazana:false, 
        potvrdaRezervacije:true, cenaRezervacije: 1200     
    }
]



