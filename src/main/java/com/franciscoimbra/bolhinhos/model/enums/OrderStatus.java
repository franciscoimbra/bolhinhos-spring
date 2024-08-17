package com.franciscoimbra.bolhinhos.model.enums;

public enum OrderStatus {
    PENDING,        // Pedido realizado, mas ainda não processado
    PROCESSING,     // Pedido em processamento
    SHIPPED,        // Pedido enviado, mas ainda não entregue
    DELIVERED,      // Pedido entregue ao cliente
    CANCELLED,      // Pedido cancelado
    RETURNED,       // Pedido devolvido
    FAILED
}
