package com.example.walletservice.services;

import com.example.walletservice.entities.Wallet;

import com.example.walletservice.repo.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Wallet getWalletById(Long id) {
        Optional<Wallet> wallet = walletRepository.findById(id);
        return wallet.orElse(null);
    }

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }


}
