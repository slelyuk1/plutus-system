package com.plutus.system.service;

import com.plutus.system.exception.NotExistsException;
import com.plutus.system.model.entity.CreditTariff;
import com.plutus.system.model.request.creditTariff.AssignCreditTariffToAccountRequest;
import com.plutus.system.model.request.creditTariff.ModifyOrCreateCreditTariffRequest;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Optional;

public interface CreditTariffService {
    CreditTariff createOrModify(ModifyOrCreateCreditTariffRequest request) throws NotExistsException;

    boolean delete(BigInteger creditTariffId);

    void assignToAccount(AssignCreditTariffToAccountRequest request) throws NotExistsException;

    Collection<CreditTariff> getAll();

    Optional<CreditTariff> getById(BigInteger id);
}