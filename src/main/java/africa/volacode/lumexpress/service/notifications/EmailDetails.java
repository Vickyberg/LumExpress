package africa.volacode.lumexpress.service.notifications;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDetails {
    private String userEmail;
    private String mailContent;

}
