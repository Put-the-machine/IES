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
    private final List<Email> receivers;
    private final String from;
    private final String title;
    private final String text;
    private final List<MultipartFile> attachments;
}
