package kodlamaio.hrms.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryAdapterService {

    DataResult<?> uploadPhoto(MultipartFile file);

}
