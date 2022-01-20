package JBProject.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ServerFiles {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long PkId;
    @Column
    private String filename;
    @Column
    private Long filesize;
    @Column
    private String filepath;


}
