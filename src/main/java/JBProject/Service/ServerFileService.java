package JBProject.Service;

import JBProject.Domain.ServerFiles;
import JBProject.Repository.ServerFileRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServerFileService {

    private final ServerFileRepository serverFileRepository;


    public ServerFileService(ServerFileRepository serverFileRepository) {
        this.serverFileRepository = serverFileRepository;
    }

    public String saveDB(ServerFiles serverFiles){
        serverFileRepository.save(serverFiles);
        return serverFiles.getFilepath();
    }

    public List<ServerFiles> findAllServerFiles(){
        return this.serverFileRepository.findByAll();
    }

    public Optional<ServerFiles> findByName(String filename){
        return serverFileRepository.findByFileName(filename);
    }

}
