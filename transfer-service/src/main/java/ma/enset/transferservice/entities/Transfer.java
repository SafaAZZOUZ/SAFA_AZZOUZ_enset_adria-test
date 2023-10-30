package ma.enset.transferservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.transferservice.enums.EtatTransfert;
import ma.enset.transferservice.model.Wallet;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Date date;
    @Transient

    private Wallet sourceWallet;
    @Transient
    private Wallet destinationWallet;
    private double montant;
    private EtatTransfert etat;
}
