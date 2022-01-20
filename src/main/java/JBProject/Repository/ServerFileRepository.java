package JBProject.Repository;

import JBProject.Domain.ServerFiles;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServerFileRepository {
    ServerFiles save(ServerFiles serverFiles);
    Optional<ServerFiles> findByFilepath(String filepath);
    Optional<ServerFiles> findByFileName(String filename);
    List<ServerFiles> findByAll();


}
