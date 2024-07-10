package com.el_economico.api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Pedidos {
    @Id
    @Column(name = "id", nullable = false)
    private int ID;

    @Column(name = "pedido_numero", nullable = false)
    private int numPedido;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private Clientes cliente;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_producto")
    @JsonBackReference
    private Productos productos;

    @Column(name = "destino", length = 150, nullable = false)
    private String destino;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "monto", nullable = false)
    private float monto;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonBackReference
    @JoinColumn(name = "id_impuesto")
    private Impuesto SAT;

    @Column(name = "subtotal", nullable = false)
    private float subtotal;

    @Column(name = "envio", nullable = false)
    private float envio;

    @Column(name = "total", nullable = false)
    private float total;

    @Column(name = "estado_pedido", nullable = false, length = 150)
    private String estadoPedido;

    @Column(name="creado_por", nullable = false, length = 150, updatable = false)
    private String creado_por;

    @Column(name = "modificado_por", length = 150)
    private String modificado_por;

    @Column(name="creado_en", nullable = false, updatable = false)
    private Timestamp creado_en;

    @Column(name="modificado_en")
    private Timestamp modificado_en;

    @Column(name = "estado", length = 1)
    private int estado;

}
