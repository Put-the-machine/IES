package org.put_the_machine.ies.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SemesterScheduler {
    private final GroupService groupService;

    @Scheduled(cron="0 0 0 ${semester.day.first},${semester.day.second} ${semester.month.first},${semester.month.second} * *")
    public void transfer() {
        groupService.transferToNextSemester();
    }

}
