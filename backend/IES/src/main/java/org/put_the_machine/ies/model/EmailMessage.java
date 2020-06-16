package org.put_the_machine.ies.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@Getter
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class EmailMessage {
    @Singular
    List<Email> receivers;
    String from;
    String title;
    String text;
    List<MultipartFile> attachments;
}
