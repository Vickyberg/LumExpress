package africa.volacode.lumexpress.data.dtos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailNotificationRequest {
    private String userEmail;
    private String mailContent;

}
