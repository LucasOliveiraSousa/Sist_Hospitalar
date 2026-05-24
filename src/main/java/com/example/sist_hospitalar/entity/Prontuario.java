package com.example.sist_hospitalar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Exercício 2 - Entidade Prontuario
 * Relacionamento OneToOne com Paciente (Exercício 7)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "prontuarios")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoSanguineo;

    @Column(nullable = true)
    private String alergia;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String observacoes;

    // Relacionamento OneToOne com Paciente (lado dono do relacionamento)
    @OneToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
}
