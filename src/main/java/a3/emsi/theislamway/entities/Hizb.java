package a3.emsi.theislamway.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hizb {
    @Id
    private int No;
    private boolean lu;
    @ManyToOne
    private User user;
}
