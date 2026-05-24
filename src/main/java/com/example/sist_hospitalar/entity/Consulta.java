package com.example.sist_hospitalar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Exercício 6 - Entidade Consulta
 * Relacionamentos:
 * - ManyToOne com Paciente (Exercício 8)
 * - ManyToOne com Medico (Exercício 9)
 * - ManyToOne com Convenio (Exercício 10)
 * - OneToOne com Receita (Exercício 11)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private String motivo;

    @Column(nullable = false)
    private double valor;

    // Relacionamento ManyToOne com Paciente (Exercício 8)
    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;

    // Relacionamento ManyToOne com Medico (Exercício 9)
    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = false)
    private Medico medico;

    // Relacionamento ManyToOne com Convenio (Exercício 10)
    @ManyToOne
    @JoinColumn(name = "convenio_id", referencedColumnName = "id", nullable = false)
    private Convenio convenio;

    // Relacionamento OneToOne com Receita (lado inverso - Exercício 11)
    @OneToOne(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Receita receita;
}
