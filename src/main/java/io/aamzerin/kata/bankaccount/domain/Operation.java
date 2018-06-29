package io.aamzerin.kata.bankaccount.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;


/**
 * Instantiates a new operation.
 *
 * @param Id the id
 * @param amount the amount
 * @param date the date
 * @param account the account
 */
@AllArgsConstructor
@Data
@Builder
@Entity
public class Operation {

	/** The Id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	/** The amount. */
	private BigDecimal amount;
	
	/** The amount. */
	private Integer entryType;
	
	/** The date. */
	private LocalDateTime date;
	
	/** The account. */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountNumber", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Account account;

}
