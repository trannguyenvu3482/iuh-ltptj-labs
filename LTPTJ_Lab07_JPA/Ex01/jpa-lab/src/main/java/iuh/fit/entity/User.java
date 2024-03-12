/**
 * 
 */
package iuh.fit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 12 Mar 2024 - 1:26:26 pm
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
	@Id
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int id;

	@Column(name = "username", columnDefinition = "varchar(45)")
	private String username;

	@Column(name = "password", columnDefinition = "varchar(45)")
	private String password;

	@Column(name = "email", columnDefinition = "varchar(45)")
	private String email;
}
