package africa.volacode.lumexpress.service.cloud;

import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CloudinaryCloudServiceImpl implements CloudService{

    private final Cloudinary cloudinary= new Cloudinary();
    @Override
    public String upload(byte[] imageBytes, Map<?, ?> map) {
        return null;
    }
}
