package JBProject.Repository;

import JBProject.Domain.ServerFiles;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component
public class JPAFilerepository implements ServerFileRepository{

    private final EntityManager em;

    public JPAFilerepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public ServerFiles save(ServerFiles serverFiles) {
        em.persist(serverFiles);
        return serverFiles;
    }

    @Override
    public Optional<ServerFiles> findByFilepath(String filepath) {
        List<ServerFiles> result = em.createQuery("select f from Files f where f.filepath = :filepath",ServerFiles.class)
                .setParameter("filepath",filepath)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<ServerFiles> findByFileName(String filename) {
        List<ServerFiles> result = em.createQuery("select f from Files f where f.filename = :filename", ServerFiles.class)
                .setParameter("filename", filename)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<ServerFiles> findByAll() {

        return em.createQuery("select f from ServerFiles f",ServerFiles.class)
                .getResultList();
    }
}
