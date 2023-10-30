package ma.enset.transferservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ma.enset.transferservice.model.Wallet;

@FeignClient(name = "wallet-service")
public interface WalletRestWalletService {
    @GetMapping("/wallets/{id}?projection=fullWallet")
    Wallet walletById(@PathVariable Long id);

    @GetMapping("/wallet?projection=fullWallet")
    PagedModel<Wallet> allwallets();
}
