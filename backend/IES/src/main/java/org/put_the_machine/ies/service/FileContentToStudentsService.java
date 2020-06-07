package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.Group;
import org.put_the_machine.ies.model.user.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileContentToStudentsService {
    List<Group> parseExcelFile(MultipartFile file);
}
