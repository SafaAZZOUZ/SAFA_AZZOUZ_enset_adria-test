package ma.enset.transferservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class Wallet {
    private Long id;
    private double solde;
    private Date dateCreation;
    private String devise;
    private Client client;
}
