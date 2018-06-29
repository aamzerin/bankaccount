package io.aamzerin.kata.bankaccount.client.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Instantiates a new client.
 *
 * @param clientId
 *            the client id
 * @param username
 *            the username
 * @param firstName
 *            the first name
 * @param secondName
 *            the second name
 */
@AllArgsConstructor
@Builder
@Data
@Entity
public class Client {

	/** The client id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clientId;

	/** The username. */
	private String username;

	/** The first name. */
	private String firstName;

	/** The second name. */
	private String secondName;

}
