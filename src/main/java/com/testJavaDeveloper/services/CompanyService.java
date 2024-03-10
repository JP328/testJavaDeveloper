package com.testJavaDeveloper.services;

import com.testJavaDeveloper.dtos.CompanyDTO;
import com.testJavaDeveloper.model.company.Company;
import com.testJavaDeveloper.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public void validateBalance(Company company, BigDecimal amount) throws Exception {
        if(company.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }

    public Company findCompanyById(Long id) throws Exception {
        return this.companyRepository
                .findCompanyById(id)
                .orElseThrow(() -> new Exception("Empresa não encontrada."));
    }

    public Company createCompany(CompanyDTO data) {
        Company newCompany = new Company(data);
        this.saveCompany(newCompany);

        return newCompany;
    }

    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }

    public void saveCompany(Company company) {
        this.companyRepository.save(company);
    }
}
