
package com.example.agent.demoModel;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.techprimers.demo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.techprimers.demo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddSmestajRequest }
     * 
     */
    public AddSmestajRequest createAddSmestajRequest() {
        return new AddSmestajRequest();
    }

    /**
     * Create an instance of {@link Smestaj }
     * 
     */
    public Smestaj createSmestaj() {
        return new Smestaj();
    }

    /**
     * Create an instance of {@link AddSmestajResponse }
     * 
     */
    public AddSmestajResponse createAddSmestajResponse() {
        return new AddSmestajResponse();
    }

    /**
     * Create an instance of {@link Soba }
     * 
     */
    public Soba createSoba() {
        return new Soba();
    }

    /**
     * Create an instance of {@link Korisnik }
     * 
     */
    public Korisnik createKorisnik() {
        return new Korisnik();
    }

    /**
     * Create an instance of {@link Recenzija }
     * 
     */
    public Recenzija createRecenzija() {
        return new Recenzija();
    }

    /**
     * Create an instance of {@link Komentar }
     * 
     */
    public Komentar createKomentar() {
        return new Komentar();
    }

    /**
     * Create an instance of {@link Rezervacija }
     * 
     */
    public Rezervacija createRezervacija() {
        return new Rezervacija();
    }

    /**
     * Create an instance of {@link Poruka }
     * 
     */
    public Poruka createPoruka() {
        return new Poruka();
    }

}
