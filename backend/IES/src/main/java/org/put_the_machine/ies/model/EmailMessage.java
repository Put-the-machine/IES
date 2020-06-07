package org.put_the_machine.ies.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
public class EmailMessage {
    @Singular
    List<Email> receivers;
    String from;
    String title;
    String text;
    List<Document> attachments;
}
