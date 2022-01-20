package JBProject.Controller;

import JBProject.Domain.ServerFiles;
import JBProject.Service.ServerFileService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@Log
public class UploadController {

    private final ServerFileService serverFileService;



    public UploadController(ServerFileService serverFileService) {
        this.serverFileService = serverFileService;
    }

    @GetMapping("/upload")
    public String uploadForm(){
        log.info("/uploadForm");
        return "uploadForm";
    }
    @PostMapping("/upload")
    public String exUploadPost(MultipartFile[] files) { // ArrayList<MultipartFile>
        String uploadFolder = "C:\\storage";

        for(MultipartFile file : files) {
            log.info("---------------------");
            log.info("name : " + file.getOriginalFilename());
            log.info("size : " + file.getSize());

            ServerFiles serverFiles = new ServerFiles();
            if(!(file.getSize() ==0)) {
                serverFiles.setFilename(file.getOriginalFilename());
                serverFiles.setFilesize(file.getSize());
                serverFiles.setFilepath(uploadFolder + "\\" + file.getOriginalFilename());
                serverFileService.saveDB(serverFiles);
            }

            File saveFile = new File(uploadFolder, file.getOriginalFilename());

            try {
                file.transferTo(saveFile);
            } catch (IllegalStateException e) {
                log.info(e.getMessage());
            } catch (IOException e) {
                log.info(e.getMessage());
            }
        }

        return "uploadForm";
    }


    @GetMapping("/download")
    public String downloadForm(Model model){

        log.info("/downloadForm");

        List<ServerFiles> serverFilesList = this.serverFileService.findAllServerFiles();
        model.addAttribute("serverfiles",serverFilesList);

        return "downloadForm";
    }

    @PostMapping("/download")
    public String downloadfile(@RequestParam(name ="fileName") String fileName,
                               @RequestParam(name ="fileSize") Long fileSize,
                               @RequestParam(name = "filePath") String filePath,
                             HttpServletResponse httpServletResponse){

        String name = fileName;
        Long size = fileSize;
        String path = filePath;


        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        httpServletResponse.setHeader("Content-Transfer-Encoding", "binary");
//        this.httpServletResponse.setHeader("Content-Type", contentType);
        httpServletResponse.setHeader("Content-Length", "" + fileSize);
        httpServletResponse.setHeader("Pragma", "no-cache;");
        httpServletResponse.setHeader("Expires", "-1;");

        try(
                FileInputStream fis = new FileInputStream(filePath);
                OutputStream out = httpServletResponse.getOutputStream();
        ){
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while((readCount = fis.read(buffer)) != -1){
                out.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            throw new RuntimeException("file Save Error");
        }
    return "downloadForm";
    }






}
