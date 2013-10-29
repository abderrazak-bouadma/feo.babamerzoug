package com.babamerzoug.feo.business;

import com.babamerzoug.feo.domain.CurrencyExchangeDesk;
import com.babamerzoug.feo.repository.CurrencyExchangeDeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/29/13
 * Time: 5:28 PM
 */
@Service
public class CurrencyExchangeDeskService {

    @Autowired
    private CurrencyExchangeDeskRepository exchangeDeskRepository;

    public List<CurrencyExchangeDesk> findAll() {
        return exchangeDeskRepository.findAll();
    }
}
