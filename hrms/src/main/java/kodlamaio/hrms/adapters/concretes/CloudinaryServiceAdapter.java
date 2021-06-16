package kodlamaio.hrms.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.adapters.abstracts.CloudinaryAdapterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceAdapter implements CloudinaryAdapterService {

    @Override
    public DataResult<?> uploadPhoto(MultipartFile file) {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "humanresourcesystem",
                "api_key", "494679956488353",
                "api_secret", "udMMICQxUY2W9FF7UO2Q2J_-MeY"));

        try{
            Map cloudinaryUploader = cloudinary.uploader()
                    .upload(file.getBytes()
                            , ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(cloudinaryUploader);
        }

        catch (IOException e){
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();
    }

}
