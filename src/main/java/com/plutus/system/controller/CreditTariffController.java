package com.plutus.system.controller;

import com.plutus.system.configuration.security.SecurityConfiguration;
import com.plutus.system.model.request.creditTariff.AssignCreditTariffToAccountRequest;
import com.plutus.system.model.request.creditTariff.ModifyOrCreateCreditTariffRequest;
import com.plutus.system.model.response.CreditTariffInfo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(SecurityConfiguration.SECURED_API_ENDPOINT + "/creditTariff")
public interface CreditTariffController {
    @PostMapping("/createOrModify")
    CreditTariffInfo createOrModify(@Valid @RequestBody ModifyOrCreateCreditTariffRequest request);

    @DeleteMapping("/{creditTariffId}/delete")
    void delete(@PathVariable("creditTariffId") BigInteger creditTariffId);

    @PostMapping("/assignToAccount")
    void assignToAccount(@Valid @RequestBody AssignCreditTariffToAccountRequest request);

    @GetMapping("/all")
    Collection<CreditTariffInfo> getAll();

    @GetMapping({"/", "/{creditTariffId}"})
    CreditTariffInfo get(@PathVariable("creditTariffId") Optional<BigInteger> maybeCreditTariffId);
}
