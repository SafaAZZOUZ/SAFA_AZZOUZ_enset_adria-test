package ma.enset.transferservice.web;

import lombok.AllArgsConstructor;
import ma.enset.transferservice.entities.Transfer;
import ma.enset.transferservice.model.Wallet;
import ma.enset.transferservice.repo.TransferRepository;
import ma.enset.transferservice.services.WalletRestWalletService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransferRestController {

    private final TransferRepository transferRepository;
    private final WalletRestWalletService walletRestWalletService;

    @GetMapping("/fullTransfer/{id}")
    public Transfer getTransfer(@PathVariable Long id) {
        Transfer transfer = transferRepository.findById(id).orElse(null);

        if (transfer != null) {
            Wallet sourceWallet = walletRestWalletService.walletById(transfer.getSourceWallet().getId());

            if (sourceWallet != null) {
                transfer.setSourceWallet(sourceWallet);
            }
        }

        return transfer;
    }
}
