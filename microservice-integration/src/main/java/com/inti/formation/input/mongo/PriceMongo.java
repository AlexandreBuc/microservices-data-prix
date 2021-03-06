package com.inti.formation.input.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


/**
 * @author CestVianney
 * @author AlexandreBuc
 */

@Data
@Document(collection = "price")
@CompoundIndexes({
        @CompoundIndex(name = "price", def = "{ active: 1, date: 1 }", unique = false)
        // unique = false acceptation des doublons true non
        // unique = true rejet  des doublons
})

public class PriceMongo implements Serializable {
    /**
     * price identifier
     */
    @Id
    private long idPrix;
    @Indexed(unique = false)
    private float montant;
    private boolean active;
    private String code;
    private Date date;
    private Date dateSuppr;

}
