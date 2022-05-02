package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.RuleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RuleNameRepository extends JpaRepository<RuleName, Integer> {

    public Optional<RuleName> findById(Integer id);
    public Optional<RuleName> findByName(String name);
    public Optional<RuleName> findByDescription(String description);
    public Optional<RuleName> findByJson(String json);
    public Optional<RuleName> findByTemplate(String template);
    public Optional<RuleName> findBySqlStr(String sqlStr);
    public Optional<RuleName> findBySqlPart(String sqlPart);

}
