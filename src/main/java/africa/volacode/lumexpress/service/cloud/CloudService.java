package africa.volacode.lumexpress.service.cloud;

import java.util.Map;

public interface CloudService {
    String  upload(byte[] imageBytes, Map<?,?> map);
}
