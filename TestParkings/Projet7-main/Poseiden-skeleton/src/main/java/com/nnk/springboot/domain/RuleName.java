package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rulename")
public class RuleName {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    @NotBlank(message="must not be empty")
    String name;

    @NotBlank(message="must not be empty")
    String description;

    @NotBlank(message="must not be empty")
    String json;

    @NotBlank(message="must not be empty")
    String template;

    @NotBlank(message="must not be empty")
    String sqlStr;

    @NotBlank(message="must not be empty")
    String sqlPart;

    public RuleName(String rule_name, String description, String json, String template, String sql, String sql_part) {
        name = rule_name;
        this.description = description;
        this.json = json;
        this.template = template;
        sqlStr = sql;
        sqlPart = sql_part;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RuleName ruleName = (RuleName) o;
        return id != null && Objects.equals(id, ruleName.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
