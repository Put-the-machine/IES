package org.put_the_machine.ies.service.impl;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.put_the_machine.ies.model.Email;
import org.put_the_machine.ies.model.Group;
import org.put_the_machine.ies.model.user.Student;
import org.put_the_machine.ies.service.FileContentToStudentsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


@Service
public class FileContentToStudentsServiceImpl implements FileContentToStudentsService {
    @SneakyThrows
    @Override
    public List<Group> parseExcelFile(MultipartFile file) {
        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        val numberOfSheets = workbook.getNumberOfSheets();
        List<Group> groups = new ArrayList<>();
        for (int i = 0; i < numberOfSheets; i++) {
            val sheet = workbook.getSheetAt(i);
            val groupName = sheet.getSheetName();
            val group = new Group();
            groups.add(group);
            group.setName(groupName);
            group.setSemester(0L);
            group.setStudents(new HashSet<>());
            int j = 1;
            while (true) {
                try {

                val userRow = sheet.getRow(j);
                val fullName = userRow.getCell(0).getStringCellValue();
                val email = userRow.getCell(1).getStringCellValue();
                val student = new Student();
                student.setFullName(fullName);
                student.setUsername(fullNameToUsername(fullName));
                student.setEmail(new Email(email));
                student.setGroups(Collections.singleton(group));
                group.getStudents().add(student);
                } catch (NullPointerException e) {
                    break;
                }
                j++;
            }
        }
        return groups;
    }

    private String fullNameToUsername(String fullName) {
        try {
            val names = fullName.split(" ");
            return names[0] + "_" + names[1].charAt(0) + names[2].charAt(0);
        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong fullName format :" + fullName);
        }
    }
}
