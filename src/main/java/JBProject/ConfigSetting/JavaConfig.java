package JBProject.ConfigSetting;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;

public class JavaConfig {

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();

        // 10MB
        resolver.setMaxUploadSize(800000000);
        // 2MB
        resolver.setMaxUploadSizePerFile(800000000);
        // 1MB
        resolver.setMaxInMemorySize(800000000);
        // temp upload
        resolver.setUploadTempDir(new FileSystemResource("C:\\Storage"));

        resolver.setDefaultEncoding("UTF-8");

        return resolver;
    }
}
