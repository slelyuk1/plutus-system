package com.plutus.system.repository;

import com.plutus.system.model.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Collection;

public interface TransferRepository extends JpaRepository<Transfer, BigInteger> {
}
