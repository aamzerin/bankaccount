package io.aamzerin.kata.bankaccount.account.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import io.aamzerin.kata.bankaccount.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Instantiates a new account.
 *
 * @param accountNumber
 *            the account number
 * @param userId
 *            the user id
 * @param Balance
 *            the balance
 * @param client
 *            the client
 */
@AllArgsConstructor
@Builder
@Data
@Entity
public class Account {

	/** The account number. */
	@Id
	private String accountNumber;

	/** The Balance. */
	private BigDecimal balance;

	/** The client. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Client client;

}
