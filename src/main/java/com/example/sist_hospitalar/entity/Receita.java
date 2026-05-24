package com.example.sist_hospitalar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Exercício 5 - Entidade Receita
 * Relacionamento OneToOne com Consulta (Exercício 11)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "receitas")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String medicamento;

    @Column(nullable = false)
    private String dosagem;

    @Column(nullable = false)
    private int duracaoDias;

    // Relacionamento OneToOne com Consulta (lado dono do relacionamento - Exercício 11)
    @OneToOne
    @JoinColumn(name = "consulta_id", referencedColumnName = "id", nullable = false)
    private Consulta consulta;
}
