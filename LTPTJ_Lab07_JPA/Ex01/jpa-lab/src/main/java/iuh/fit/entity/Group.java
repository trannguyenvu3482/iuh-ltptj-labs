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
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 12 Mar 2024 - 1:13:08 pm
 */

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Group {

	@Id
	@Column(name = "group_id", columnDefinition = "int(11)")
	private int id;

	@Column(name = "name", columnDefinition = "varchar(45)")
	private String name;
}
